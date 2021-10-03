package com.demo.mvc.utils;

import org.springframework.util.StringUtils;

public class AppUtils {
	
	public static String toString(Float p) {
		if(StringUtils.isEmpty(p)) {
			return "";
		}else {
			return p.toString();
		}
	}
	
	public static String toString(Integer p) {
		if(StringUtils.isEmpty(p)) {
			return "";
		}else {
			return p.toString();
		}
	}

}
