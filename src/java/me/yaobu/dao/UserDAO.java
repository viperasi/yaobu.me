/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package me.yaobu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import me.yaobu.bean.UserBean;
import me.yaobu.conn.DbHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Administrator
 */
public class UserDAO extends BaseDAO{
    private final static Log log = LogFactory.getLog(UserDAO.class);

    public UserBean selUserById(long uid){
        UserBean u = null;
        String sql = "select user_id,account,user_name,isenabled,reg_time,del_time,released from tbl_users where user_id=? and released=1";
        try {
            conn = DbHelper.getConnection();
            st = conn.prepareStatement(sql);
            st.setLong(1, uid);
            rs = st.executeQuery();
            if(rs.next()){
                u = new UserBean();
                int i = 1;
                u.setUserId(rs.getInt(i++));
                u.setAccount(rs.getString(i++));
                u.setName(rs.getString(i++));
                u.setIsEnabled(rs.getInt(i++));
                u.setRegTime(rs.getTimestamp(i++).toString().substring(0,19));
                u.setDelTime(rs.getTimestamp(i++).toString().substring(0,19));
                u.setReleased(rs.getInt(i++));
            }
        } catch (SQLException ex) {
            log.error("根据ID查用户出错，",ex);
        }finally{
            close();
        }
        return u;
    }

    public UserBean selUserByAccount(String account){
        UserBean u  = null;
        String sql = "select user_id,account,user_name,isenabled,reg_time,del_time,released from tbl_users where account=? and released=1";
        try{
            conn = DbHelper.getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, account);
            rs = st.executeQuery();
            if(rs.next()){
                u = new UserBean();
                int i = 1;
                u.setUserId(rs.getInt(i++));
                u.setAccount(rs.getString(i++));
                u.setName(rs.getString(i++));
                u.setIsEnabled(rs.getInt(i++));
                u.setRegTime(rs.getTimestamp(i++).toString().substring(0,19));
                u.setDelTime(rs.getTimestamp(i++).toString().substring(0,19));
                u.setReleased(rs.getInt(i++));
            }
        }catch(SQLException ex){
            log.error("根据账户查用户出错，",ex);
        }finally{
            close();
        }
        return u;
    }

    public List<UserBean> selAllUser(){
        List<UserBean> list = new ArrayList<UserBean>();
        String sql = "select user_id,account,user_name,isenabled,reg_time,del_time,released from tbl_users where released=1";
        try{
            conn = DbHelper.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                UserBean u = new UserBean();
                int i = 1;
                u.setUserId(rs.getInt(i++));
                u.setAccount(rs.getString(i++));
                u.setName(rs.getString(i++));
                u.setIsEnabled(rs.getInt(i++));
                u.setRegTime(rs.getTimestamp(i++).toString().substring(0,19));
                u.setDelTime(rs.getTimestamp(i++).toString().substring(0,19));
                u.setReleased(rs.getInt(i++));
                list.add(u);
            }
        }catch(SQLException ex){
            log.error("查找所哟用户出错，",ex);
        }finally{
            close();
        }
        return list;
    }

    public void addUser(UserBean u){
        String sql = "insert into tbl_users(account,passwd,user_name,isenabled,reg_time) values(?,?,?,?,now())";
        try{
            conn = DbHelper.getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, u.getAccount());
            st.setString(2, u.getPasswd());
            st.setString(3, u.getName());
            st.setInt(4, u.getIsEnabled());
            st.execute();
        }catch(SQLException ex){
            log.error("添加用户出错",ex);
        }finally{
            close();
        }
    }

    public void updUser(UserBean u){
        String sql = "update tbl_users set account=?,passwd=?,user_name=?,isenabled=? where userid=?";
        try{
            conn = DbHelper.getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, u.getAccount());
            st.setString(2, u.getPasswd());
            st.setString(3, u.getName());
            st.setInt(4, u.getIsEnabled());
            st.setLong(1, u.getUserId());
            st.execute();
        }catch(SQLException ex){
            log.error("更新用户出错,",ex);
        }finally{
            close();
        }
    }

    public void delUpd(long uid){
        String sql = "update tbl_users set released=0,del_time=now() where userid=?";
        try{
            conn = DbHelper.getConnection();
            st = conn.prepareStatement(sql);
            st.setLong(1, uid);
            st.execute();
        }catch(SQLException ex){
            log.error("删除用户出错,",ex);
        }finally{
            close();
        }
    }
}
