package com.qf.farmer.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang.StringUtils;

public class StringUtil {

	public static String utf2gbk(String str) {
		if (StringUtils.isEmpty(str)) {
			return "";
		}
		String unicode = null;
		String gbkStr = null;
		try {
			unicode = new String(str.getBytes(), "UTF-8");
			gbkStr = new String(unicode.getBytes("GBK"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gbkStr;

	}

	public static String Str2utf(String str) {
		if (StringUtils.isEmpty(str)) {
			return "";
		}
		String unicode = null;
		try {
			unicode = new String(str.getBytes(), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return unicode;
	}
	
	public static boolean isNotEmpty(String str) {
		byte[] ss = new byte[]{1};
		try {
			String sss = new String(ss,"UTF-8");
			if(str != null){
				str.replaceAll(sss, "");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return (str != null && !"".equals(str) && !"null".equals(str));
	}
	
	public static void main(String[] args) {
		System.out.println(StringUtil.isNotEmpty("null"));
	}
}
