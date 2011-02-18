/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package me.yaobu.bean;

/**
 *
 * @author Administrator
 */
public class UserBean {
    private long userId;
    private String account;
    private String passwd;
    private String name;
    private int isEnabled;
    private String regTime;
    private String delTime;
    private int released;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDelTime() {
        return delTime;
    }

    public void setDelTime(String delTime) {
        this.delTime = delTime;
    }

    public int getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(int isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public int getReleased() {
        return released;
    }

    public void setReleased(int releadse) {
        this.released = released;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
