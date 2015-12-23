package com.defray.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public final class TimeUtil {
	private static final Logger LOG = LogManager.getLogger(TimeUtil.class);
	public static SimpleDateFormat SDF = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat SDFYMDHM = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm");
	public static SimpleDateFormat SDFDate = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat SDFYM = new SimpleDateFormat("yyyy-MM");
	public static SimpleDateFormat SDFTime = new SimpleDateFormat("HH:mm:ss");
	public static SimpleDateFormat SDFTimeHM = new SimpleDateFormat("HH:mm");
	public static SimpleDateFormat SDFMonthDay = new SimpleDateFormat("MM-dd");
	public static SimpleDateFormat SDFDayCN = new SimpleDateFormat("EEEE");		//中文星期

	// long
	public static long getLong() {
		Date dt = new Date();
		long nowtTme = dt.getTime();
		return nowtTme;
	}
	
	public static long getLong(Date date) {
		long nowtTme = date.getTime();
		return nowtTme;
	}
	
	public static long getLong(String dateString) {
		return getLong(dateString,SDFYMDHM);
	}
	
	public static long getLong(String dateString,SimpleDateFormat format) {
		if(StringUtil.isEmpty(dateString)) return 0;
		Date dt =getDate(dateString,format);
		if(dt == null) return 0;
		long nowtTme = dt.getTime();
		return nowtTme;
	}
	// int
	
	/**
	 * 获取当天是一周的第几天，从周一开始，周日为0
	 */
	public static int getDayInt() {
		Calendar cal = Calendar.getInstance();
		return (cal.get(Calendar.DAY_OF_WEEK) + 6) % 7;
	}
	
	/**
	 * 东八区用，与格林威治时间相差8个小时 28800秒
	 * @return
	 */
	public static int getTodayInt() {
		return (int)(getLong()/1000) / 86400 * 86400 - 28800;
	}
	
	public static int getInt() {
		return (int)(getLong()/1000);
	}
	public static int getInt(Date date) {
		return (int)(getLong( date)/1000);
	}
	
	public static int getInt(String dateString) {
		
		return (int)(getLong( dateString)/1000);
	}
	
	public static int getInt(String dateString,SimpleDateFormat format) {
		if(StringUtil.isEmpty(dateString)) return 0;
		return (int)( getLong( dateString,format)/1000) ;
	}
	 
	// String
	
	
	public static String getString(SimpleDateFormat format) {
		Date dt = new Date();
		String addtime = format.format(dt);
		return addtime;
	}

	public static String getString(Date dt,SimpleDateFormat format) {
		if (dt == null)
			return null;
		String addtime = format.format(dt);
		return addtime;
	}
	
	public static String getString(long time,SimpleDateFormat format) {
		long datetime = time;
		Date dt = new Date(datetime);
		String addtime = format.format(dt);
		return addtime;
	}
	
	public static String getString(int time,SimpleDateFormat format) {
		return getString(1000L*time,format);
	}
	
	public static String getString() {
		return getString(SDFYMDHM);
	}

//	public static String getString(Date dt) {
//		return getString(  dt,SDFYMDHM) ;
//	}
	public static String getString(Date dt) {
		return getString(  dt,SDF) ;
	}
	
	public static String getString(long time) {
		return getString(time,SDFYMDHM);
	}
	
	public static String getString(int time) {
		return getString(time,SDFYMDHM);
	}
	
	public static String getAllString(int time) {
		return getString(time,SDF);
	}
	 
	public static String getDateString(int time) {
		return getString(time,SDFDate);
	}
	
	public static String getDateYMString(int time) {
		return getString(time,SDFYM);
	}
	
	public static String getTimeHMString(int time) {
		return getString(time,SDFTimeHM);
	}
	
	// date
	public static Date getDate(long time) {
		return new Date(time);

	}
	public static Date getDate(int time) {
		return new Date(1000L*time);
	}
	public static Date getDate( ) {
		return new Date();
	}
	
	public static Date getDate(String dateString,SimpleDateFormat format) {
		try {
			Date d = format.parse(dateString);
			return d;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Date getDate(String dateString ) {
		return getDate(  dateString, SDFYMDHM);
	}
	
	
	//start + l毫秒
	public static Date addDate(Date start,long l) {
		
		return new Date(start.getTime()+l);

	}
	
	
	 /**
     * 获取当前日期是星期几<br>
     * 
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

	   

	public static void main(String[]args) throws Exception{
		//1404090675
		//System.out.println(DateUtil.getInt("09:30:00", SDFTime));
		//System.out.println(DateUtil.getInt("2014-12-14",SDFDate));
		System.out.println(TimeUtil.getTodayInt());
		System.out.println(TimeUtil.getDateString(1419350400));
	}
}