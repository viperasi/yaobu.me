/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package me.yaobu.bean;

import java.util.List;

/**
 *
 * @author Administrator
 */
public class SiteBean {
    private long siteId;
    private String siteName;
    private String siteAddr;
    private long addUserId;
    private String desc;
    private String img;
    private String logo;
    private String addTime;
    private String updTime;
    private int eval;
    private int released;
    private List<EvalBean> evals;

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public long getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(long addUserId) {
        this.addUserId = addUserId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getEval() {
        return eval;
    }

    public void setEval(int eval) {
        this.eval = eval;
    }

    public List<EvalBean> getEvals() {
        return evals;
    }

    public void setEvals(List<EvalBean> evals) {
        this.evals = evals;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getReleased() {
        return released;
    }

    public void setReleased(int released) {
        this.released = released;
    }

    public String getSiteAddr() {
        return siteAddr;
    }

    public void setSiteAddr(String siteAddr) {
        this.siteAddr = siteAddr;
    }

    public long getSiteId() {
        return siteId;
    }

    public void setSiteId(long siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getUpdTime() {
        return updTime;
    }

    public void setUpdTime(String updTime) {
        this.updTime = updTime;
    }
    
}
