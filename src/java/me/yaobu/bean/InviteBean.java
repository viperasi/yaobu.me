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
public class InviteBean {
    private long inviteId;
    private String site;
    private long user;
    private String userName;
    private String content;
    private int eval;
    private int allCount;
    private int remain;
    private String addTime;
    private String updTime;
    private int released;
    private List<EvalBean> evals;

    public List<EvalBean> getEvals() {
        return evals;
    }

    public void setEvals(List<EvalBean> evals) {
        this.evals = evals;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public int getAllCount() {
        return allCount;
    }

    public void setAllCount(int allCount) {
        this.allCount = allCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getEval() {
        return eval;
    }

    public void setEval(int eval) {
        this.eval = eval;
    }

    public long getInviteId() {
        return inviteId;
    }

    public void setInviteId(long inviteId) {
        this.inviteId = inviteId;
    }

    public int getReleased() {
        return released;
    }

    public void setReleased(int released) {
        this.released = released;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getUpdTime() {
        return updTime;
    }

    public void setUpdTime(String updTime) {
        this.updTime = updTime;
    }

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
