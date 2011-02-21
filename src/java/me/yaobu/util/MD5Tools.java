/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package me.yaobu.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Administrator
 */
public class MD5Tools {

    private final static Log log = LogFactory.getLog(MD5Tools.class);

    /**
     * 加密数据
     * @param str
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String encrypt(String str) throws NoSuchAlgorithmException {
	return encodeString(md5Str(str));
    }

    /**
     * 解密数据
     * @param str
     * @return
     */
    public static String decrypt(String str) {
	return decodeString(str);
    }

    /**
     * md5加密
     * @param str
     * @return
     * @throws NoSuchAlgorithmException
     */
    private static String md5Str(String str) throws NoSuchAlgorithmException {
	MessageDigest md5 = MessageDigest.getInstance("MD5");
	md5.update(str.getBytes());
	byte[] digest = md5.digest();
	BigInteger code = new BigInteger(1, digest);
	log.info("code---md5--->" + code.toString(16));
	return code.toString(16);
    }

    /**
     * 重排序
     * @param str
     * @return
     */
    private static String encodeString(String str) {
	String newStr = new String();
	char[] c = str.toCharArray();
	for (int i = 0; i < c.length; i++) {
	    if (i % 3 == 0) {
		if (newStr != null)
		    newStr = c[i] + newStr;
		else
		    newStr = String.valueOf(c[i]);
	    } else {
		newStr += c[i];
	    }
	}
	return newStr;
    }

    /**
     * 反向排序
     * @param str
     * @return
     */
    private static String decodeString(String str) {
	String newStr = new String();
	char[] c = str.toCharArray();
	int count = 0;
	for (int i = 0; i < c.length; i++) {
	    if (i % 3 == 0)
		count++;
	}
	char[] pc = str.substring(0, count).toCharArray();
	char[] rc = str.substring(count).toCharArray();
	log.info("pc----->" + String.valueOf(pc) + "     rc----->"
		+ String.valueOf(rc));
	int k = 0;
	for (int i = pc.length - 1; i >= 0; i--) {
	    newStr = newStr + pc[i];
	    for (int j = k; j < k + 2 && j < rc.length; j++) {
		newStr = newStr + rc[j];
	    }
	    k += 2;
	}
	return newStr;
    }
}
