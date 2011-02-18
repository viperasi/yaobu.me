/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package me.yaobu.conn;

import java.sql.Connection;
import javax.sql.DataSource;
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
    
    static{
        
    }
}
