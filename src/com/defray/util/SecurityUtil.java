package com.defray.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.apache.commons.lang.StringUtils;

/**
 *
 * Title:
 *
 * Description:加密，解密类，对中文的加密有问题
 *
 * Copyright: Copyright (c) 2005
 *
 * @author david
 * @created 2005-6-7 11:04:33
 * @version $Id: SecurityUtil.java,v 1.1 2007/04/18 06:06:39 david Exp $
 */
public class SecurityUtil {

	public static String encrypt(int  istr) {
		return encrypt(istr + "");
	}

	/**
	 * 加密
	 */
	public static String encrypt(String str) {
		// System.err.println("encrypt====" + str);
		String re = null;
		if (!StringUtils.isEmpty(str)) {
			InputStream inputstream = new ByteArrayInputStream(str.getBytes());
			ByteArrayOutputStream sout = new ByteArrayOutputStream();
			BlockCipherTool.encrypt(inputstream, sout);
			re = sout.toString();
		}
		return re;
	}

	/**
	 * 解密
	 *
	 * @param str
	 * @return
	 */
	public static String decrypt(String str) {
		String re = null;
		if (!StringUtils.isEmpty(str)) {
			InputStream inputstream = new ByteArrayInputStream(str.getBytes());
			ByteArrayOutputStream sout = new ByteArrayOutputStream();
			BlockCipherTool.decrypt(inputstream, sout);
			re = sout.toString();
		}
		return re;

	}

	public static void main(String[] args){
		String src = "A";
		String en = encrypt(src);
		System.err.println(en);
		System.err.println(decrypt(en));
	}
}
