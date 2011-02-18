/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package me.yaobu.util.ex;

/**
 *
 * @author Administrator
 */
public class DbException extends Exception{
    Exception ex;

    public DbException(Exception ex){
        this.ex = ex;
    }

    
}
