/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package me.yaobu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import me.yaobu.bean.SiteBean;
import me.yaobu.conn.DbHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Administrator
 */
public class SiteDAO extends BaseDAO{
    private final static Log log = LogFactory.getLog(SiteDAO.class);

    public SiteBean selSiteById(long siteId){
        SiteBean s = null;
        String sql = "select s.site_id,s.site_name,s.site_addr,s.site_adduser,u.user_name,s.site_desc,s.site_img,s.site_logo,s.site_addtime,s.site_updtime,s.site_eval,s.released from tbl_sites s left join tbl_uses u on u.userid=s.site_adduser where s.siteid=? and s.released=1";
        try{
            conn = DbHelper.getConnection();
            st = conn.prepareStatement(sql);
            st.setLong(1, siteId);
            rs = st.executeQuery();
            if(rs.next()){
                s = new SiteBean();
                int i = 1;
                s.setSiteId(rs.getLong(i++));
                s.setSiteName(rs.getString(i++));
                s.setSiteAddr(rs.getString(i++));
                s.setAddUserId(rs.getLong(i++));
                s.setAddUserName(rs.getString(i++));
                s.setDesc(rs.getString(i++));
                s.setImg(rs.getString(i++));
                s.setLogo(rs.getString(i++));
                s.setAddTime(rs.getTimestamp(i++).toString().substring(0, 19));
                s.setUpdTime(rs.getTimestamp(i++).toString().substring(0,19));
                s.setEval(rs.getInt(i++));
                s.setReleased(rs.getInt(i++));
            }
        }catch(SQLException ex){
            log.error("根据ID查找site出错,",ex);
        }finally{
            close();
        }
        return s;
    }

    public List<SiteBean> selAllSite(){
        List<SiteBean> list = new ArrayList<SiteBean>();
        String sql = "select s.site_id,s.site_name,s.site_addr,s.site_adduser,u.user_name,s.site_desc,s.site_img,s.site_logo,s.site_addtime,s.site_updtime,s.site_eval,s.released from tbl_sites s left jion tbl_users u on u.user_id=s.site_adduser where s.released=1 order by s.site_updtime desc";
        try{
            conn = DbHelper.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                SiteBean s = new SiteBean();
                int i = 1;
                s.setSiteId(rs.getLong(i++));
                s.setSiteName(rs.getString(i++));
                s.setSiteAddr(rs.getString(i++));
                s.setAddUserId(rs.getLong(i++));
                s.setAddUserName(rs.getString(i++));
                s.setDesc(rs.getString(i++));
                s.setImg(rs.getString(i++));
                s.setLogo(rs.getString(i++));
                s.setAddTime(rs.getTimestamp(i++).toString().substring(0, 19));
                s.setUpdTime(rs.getTimestamp(i++).toString().substring(0,19));
                s.setEval(rs.getInt(i++));
                s.setReleased(rs.getInt(i++));
                list.add(s);
            }
        }catch(SQLException ex){
            log.error("查找所有site出错，",ex);
        }finally{
            close();
        }
        return list;
    }

    public int selAllSiteCount(){
        int count = 0;
        String sql = "select count(site_id) from tbl_sites where released=1 order by site_updtime desc";
        try{
            conn = DbHelper.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next())
                count = rs.getInt(1);
        }catch(SQLException ex){
            log.error("查找所有site总数出错，",ex);
        }finally{
            close();
        }
        return count;
    }

    public List<SiteBean> selAllSitePage(int start,int limit){
        List<SiteBean> list = new ArrayList<SiteBean>();
        String sql = "select s.site_id,s.site_name,s.site_addr,s.site_adduser,u.user_name,s.site_desc,s.site_img,s.site_logo,s.site_addtime,s.site_updtime,s.site_eval,s.released from tbl_sites s left jion tbl_users u on u.user_id=s.site_adduser where s.released=1 order by s.site_updtime desc limit ?,?";
        try{
            conn = DbHelper.getConnection();
            st = conn.prepareStatement(sql);
            st.setInt(1, start);
            st.setInt(2, limit);
            rs = st.executeQuery();
            while(rs.next()){
                SiteBean s = new SiteBean();
                int i = 1;
                s.setSiteId(rs.getLong(i++));
                s.setSiteName(rs.getString(i++));
                s.setSiteAddr(rs.getString(i++));
                s.setAddUserId(rs.getLong(i++));
                s.setAddUserName(rs.getString(i++));
                s.setDesc(rs.getString(i++));
                s.setImg(rs.getString(i++));
                s.setLogo(rs.getString(i++));
                s.setAddTime(rs.getTimestamp(i++).toString().substring(0, 19));
                s.setUpdTime(rs.getTimestamp(i++).toString().substring(0,19));
                s.setEval(rs.getInt(i++));
                s.setReleased(rs.getInt(i++));
                list.add(s);
            }
        }catch(SQLException ex){
            log.error("分页查找site出错,start--->"+start+",limit--->"+limit,ex);
        }finally{
            close();
        }
        return list;
    }

    public int selAllSiteCountLike(String name){
        int count = 0;
        String sql = "select count(site_id) from tbl_sites where site_name like '%?%' and released=1 order by site_updtime desc";
        try{
            conn = DbHelper.getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, name);
            rs = st.executeQuery();
            if(rs.next())
                count = rs.getInt(1);
        }catch(SQLException ex){
            log.error("模糊查询site总数出错，name---->"+name,ex);
        }finally{
            close();
        }
        return count;
    }

    public List<SiteBean> selAllSitePageLike(String name,int start,int limit){
        List<SiteBean> list = new ArrayList<SiteBean>();
        String sql = "select s.site_id,s.site_name,s.site_addr,s.site_adduser,u.user_name,s.site_desc,s.site_img,s.site_logo,s.site_addtime,s.site_updtime,s.site_eval,s.released from tbl_sites s left jion tbl_users u on u.user_id=s.site_adduser where s.site_name like '%?%' and s.released=1 order by s.site_updtime desc limit ?,?";
        try{
            conn = DbHelper.getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, name);
            st.setInt(2, start);
            st.setInt(3, limit);
            rs = st.executeQuery();
            while(rs.next()){
                SiteBean s = new SiteBean();
                int i = 1;
                s.setSiteId(rs.getLong(i++));
                s.setSiteName(rs.getString(i++));
                s.setSiteAddr(rs.getString(i++));
                s.setAddUserId(rs.getLong(i++));
                s.setAddUserName(rs.getString(i++));
                s.setDesc(rs.getString(i++));
                s.setImg(rs.getString(i++));
                s.setLogo(rs.getString(i++));
                s.setAddTime(rs.getTimestamp(i++).toString().substring(0, 19));
                s.setUpdTime(rs.getTimestamp(i++).toString().substring(0,19));
                s.setEval(rs.getInt(i++));
                s.setReleased(rs.getInt(i++));
                list.add(s);
            }
        }catch(SQLException ex){
            log.error("分页模糊查询site出错,name---->"+name,ex);
        }finally{
            close();
        }
        return list;
    }

    public void addSite(SiteBean s){
        String sql = "insert into tbl_sites(site_name,site_addr,site_adduser,site_desc,site_img,site_logo,site_addtime,site_updtime) values(?,?,?,?,?,?,now(),now())";
        try{
            conn = DbHelper.getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, s.getSiteName());
            st.setString(2, s.getSiteAddr());
            st.setLong(3, s.getAddUserId());
            st.setString(4, s.getDesc());
            st.setString(5, s.getImg());
            st.setString(6, s.getLogo());
            st.execute();
        }catch(SQLException ex){
            log.error("添加site出错,",ex);
        }finally{
            close();
        }
    }

    public void updSite(SiteBean s){
        String sql = "update tbl_sites set site_name=?,site_addr=?,site_desc=?,site_img=?,site_logo=?,site_eval=?,site_updtime=now() where site_id=? and released=1";
        try{
            conn = DbHelper.getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, s.getSiteName());
            st.setString(2, s.getSiteAddr());
            st.setString(3, s.getDesc());
            st.setString(4, s.getImg());
            st.setString(5, s.getLogo());
            st.setInt(6, s.getEval());
            st.execute();
        }catch(SQLException ex){
            log.error("更新site出错,",ex);
        }finally{
            close();
        }
    }

    public void delSite(long siteId){
        String sql = "update tbl_sites set released=0,site_updtime=now() where site_id=? and released=1";
        try{
            conn = DbHelper.getConnection();
            st = conn.prepareStatement(sql);
            st.setLong(1, siteId);
            st.execute();
        }catch(SQLException ex){
            log.error("删除site出错，",ex);
        }finally{
            close();
        }
    }
}
