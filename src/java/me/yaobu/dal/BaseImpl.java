/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.yaobu.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Administrator
 */
public class BaseImpl {

    private final static Log log = LogFactory.getLog(BaseImpl.class);
    Connection conn = null;
    PreparedStatement st = null;
    ResultSet rs = null;

    public void close() {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            log.error("关闭RS出错！！", e);
        }
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            log.error("关闭ST出错！！", e);
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            log.error("关闭CONN出错！！", e);
        }
    }
}
