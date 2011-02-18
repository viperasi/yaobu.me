/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.yaobu.conn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Administrator
 */
public class DbHelper {

    private final static Log log = LogFactory.getLog(DbHelper.class);
    private final static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();
    private static DataSource ds;
    private static boolean show_sql = false;

    static {
        initDataSource(null);
    }

    private final static void initDataSource(Properties dbProp) {
        try {
            if (dbProp == null) {
                dbProp = new Properties();
                dbProp.load(DbHelper.class.getResourceAsStream("db.properties"));
            }
            Properties cp_props = new Properties();
            for (Object key : dbProp.keySet()) {
                String skey = (String) key;
                if (skey.startsWith("jdbc.")) {
                    String name = skey.substring(5);
                    cp_props.put(name, dbProp.getProperty(skey));
                    if ("show_sql".equalsIgnoreCase(name)) {
                        show_sql = "true".equalsIgnoreCase(dbProp.getProperty(skey));
                    }
                }
            }
            ds = (DataSource) Class.forName(cp_props.getProperty("datasource")).newInstance();
            if (ds.getClass().getName().indexOf("c3p0") > 0) {
                //Disable JMX in c3p0
                System.setProperty("com.mchange.v2.c3p0.management.ManagementCoordinator", "com.mchange.v2.c3p0.management.NullManagementCoordinator");
            }
            log.info("Using DataSource:" + ds.getClass().getName());
            BeanUtils.populate(ds, cp_props);
            Connection conn = getConnection();
            DatabaseMetaData mdm = conn.getMetaData();
            log.info("Connected to " + mdm.getDatabaseProductName() + " " + mdm.getDatabaseProductVersion());
            closeConnection();
        } catch (Exception e) {
            log.error("初始化数据库链接出错!!",e);
        }
    }

    public final static void closeDataSource(){
        try{
            ds.getClass().getMethod("close").invoke(ds);
        }catch(NoSuchMethodException e){
        }catch(Exception e){
            log.error("无法销毁DataSource!!",e);
        }
    }

    public final static void closeConnection(){
        Connection conn = conns.get();
        try{
            if(conn!=null&&!conn.isClosed()){
                conn.setAutoCommit(true);
                conn.close();
            }
        }catch(SQLException e){
            log.error("无法关闭连接!!",e);
        }
        conns.set(null);
    }

    public final static Connection getConnection() throws SQLException {
        Connection conn = conns.get();
        if (conn == null || conn.isClosed()) {
            conn = ds.getConnection();
            conns.set(conn);
        }
        return (show_sql && Proxy.isProxyClass(conn.getClass())) ? new _DebugConnection(conn).getConnection() : conn;
    }

    static class _DebugConnection implements InvocationHandler {

        private final static Log log = LogFactory.getLog(_DebugConnection.class);
        private Connection conn = null;

        public _DebugConnection(Connection conn) {
            this.conn = conn;
        }

        public Connection getConnection() {
            return (Connection) Proxy.newProxyInstance(conn.getClass().getClassLoader(), conn.getClass().getInterfaces(), this);
        }

        public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
            try {
                String method = m.getName();
                if ("prepareStatement".equals(method) || "createStatement".equals(method)) {
                    log.info("[SQL] >>>" + args[0]);
                }
                return m.invoke(conn, args);
            } catch (InvocationTargetException e) {
                throw e.getTargetException();
            }
        }
    }
}
