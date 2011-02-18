/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package me.yaobu.bean;

/**
 *
 * @author Administrator
 */
public class LogBean {
    private long logId;
    private long logUserId;
    private String logUserName;
    private String logTime;
    private String logIp;

    public long getLogId() {
        return logId;
    }

    public void setLogId(long logId) {
        this.logId = logId;
    }

    public String getLogIp() {
        return logIp;
    }

    public void setLogIp(String logIp) {
        this.logIp = logIp;
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    public long getLogUserId() {
        return logUserId;
    }

    public void setLogUserId(long logUserId) {
        this.logUserId = logUserId;
    }

    public String getLogUserName() {
        return logUserName;
    }

    public void setLogUserName(String logUserName) {
        this.logUserName = logUserName;
    }

    public int getReleased() {
        return released;
    }

    public void setReleased(int released) {
        this.released = released;
    }
    private int released;
}
