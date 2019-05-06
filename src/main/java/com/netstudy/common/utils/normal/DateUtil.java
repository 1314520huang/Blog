package com.netstudy.common.utils.normal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * 
 * @author Administrator
 *
 */
public class DateUtil {

	private static SimpleDateFormat df;
	private static final String DATE = "yyyy-MM-dd";
	private static final String TIME = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 获取当前日期
	 * 
	 * @return
	 */
	public static String getNowDate() {
		
		df = new SimpleDateFormat(DATE);
		return df.format(System.currentTimeMillis());
	}
	
	/**
	 * 获取当前的日期时间
	 * 
	 * @return
	 */
	public static String getNowTime() {

		df = new SimpleDateFormat(TIME);
		return df.format(System.currentTimeMillis());
	}
	
	/**
	 * 获取当前日期
	 * 
	 * @return
	 */
	public static Date getNowDate1() {
		
		return new Date();
	}
	
	public static Date strToDate(String nowStr) {
		
		df = new SimpleDateFormat(DATE);
		Date date = null;
		try {
			date = df.parse(nowStr);
		} catch (ParseException e) {
			date = new Date();
		}
		return date;
	}
	
	public static void main(String[] args) {

//		System.out.println(getNowDate());
//		System.out.println(getNowTime());
//		System.err.println(getNowDate1());
		System.out.println(strToDate("2019-03-07"));
	}
}
