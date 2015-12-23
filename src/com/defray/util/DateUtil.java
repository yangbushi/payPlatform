﻿package com.defray.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author chendw
 *
 */
public class DateUtil {
    private static final String[] dayNames = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };

    private static final String[] dayIndexs = { "7", "1", "2", "3", "4", "5", "6" };

    /**
     * 把字符串转化成日期型。
     *
     * @param String
     *            字符串
     * @param DateFormat
     *            日期格式
     * @return Date 转化后的日期
     */
    public static Date getDate(String name, String df, Date defaultValue) {
        if (name == null) {
            return defaultValue;
        }

        SimpleDateFormat formatter = new SimpleDateFormat(df);

        try {
            return formatter.parse(name);
        } catch (ParseException e) {
        }

        return defaultValue;
    }

    /**
     * 把字符串转化成日期型。 缺省为当前系统时间。
     *
     * @param String
     *            字符串
     */
    public static Date getDate(String name) {
        return getDate(name, null);
    }

    /**
     * 把字符串转化成日期型。 缺省为当前系统时间。
     *
     * @param String
     *            字符串
     */
    public static Date getDateTime(String name) {
        return getDateTime(name, null);
    }

    /**
     * 把字符串转化成日期型。
     *
     * @param String
     *            字符串
     * @param DateFormat
     *            日期格式
     * @return Date 转化后的日期
     */
    public static Date getDate(String name, Date defaultValue) {
        return getDate(name, "yyyy-MM-dd", defaultValue);
    }

    /**
     * 把字符串转化成日期型。
     *
     * @param String
     *            字符串
     * @param DateFormat
     *            日期格式
     * @return Date 转化后的日期
     */
    public static Date getDateTime(String name, Date defaultValue) {
        return getDate(name, "yyyy-MM-dd HH:mm:ss", defaultValue);
    }

    public static Date mysqlDate2Date(int seconds) {
        long l = (long) seconds * 1000;
        Date date = new Date(l);
        return date;
    }

    public static long date2MysqlDate(Date date) {
        return date.getTime() / 1000;
    }

    /**
     * 返回两个日期的时间差，返回的时间差格式可以是: Calendar.YEAR, Calendar.MONTH, Calendar.DATE
     * 注意：该功能采用递归的方法，效率还有待解决，如果两个时间之差较大，而要求返回的时间格式又很小，这时效率就很差
     * 但此方法在要求精度较高的情况下比较有效，如求月份差的时候就比较准确，考虑到了各种情况．如闰月，闰年
     *
     * @param earlyDate
     * @param lateDate
     * @param returnTimeFormat
     * @return time
     */
    public static int getBetweenTime(Calendar earlyDate, Calendar lateDate, int returnTimeFormat) {
        earlyDate = (Calendar) earlyDate.clone();
        lateDate = (Calendar) lateDate.clone();
        int time = 0;
        while (earlyDate.before(lateDate)) {
            earlyDate.add(returnTimeFormat, 1);
            time++;
        }
        return time;
    }

    public static int getBetweenYear(Date lastDate) {
        int between = Integer.MIN_VALUE;
        if (lastDate != null) {
            Calendar cnow = Calendar.getInstance();
            Calendar clast = Calendar.getInstance();
            clast.setTime(lastDate);
            between = getBetweenTime(clast, cnow, Calendar.YEAR);
        }
        return between;
    }

    /**
     * 求两个日期相差天数
     *
     * @param sd
     *            起始日期，格式yyyy-MM-dd
     * @param ed
     *            终止日期，格式yyyy-MM-dd
     * @return 两个日期相差天数
     */
    public static long getBetweenDay(String sd, String ed) {
        return ((java.sql.Date.valueOf(ed)).getTime() - (java.sql.Date.valueOf(sd)).getTime()) / (3600 * 24 * 1000);
    }

    /**
     * 求两个日期相差天数
     *
     * @param sd
     *            起始日期，格式yyyy-MM-dd
     * @param ed
     *            终止日期，格式yyyy-MM-dd
     * @return 两个日期相差天数
     */
    public static long getBetweenDay(Date sd, Date ed) {
        return (ed.getTime() - sd.getTime()) / (3600 * 24 * 1000);
    }

    public static int getBetweenDay(Date lastDate) {
        int between = Integer.MIN_VALUE;
        if (lastDate != null) {
            Calendar cnow = Calendar.getInstance();
            Calendar clast = Calendar.getInstance();
            clast.setTime(lastDate);
            between = getBetweenTime(clast, cnow, Calendar.DATE);
        }
        return between;
    }

    /**
     * 得到给定的时间距离现在的天数
     *
     * @param last
     * @return
     */
    public static int getBetweenDays(int last) {
        Calendar cnow = Calendar.getInstance();
        Calendar clast = Calendar.getInstance();
        clast.setTime(DateUtil.mysqlDate2Date(last));
        int between = getBetweenTime(clast, cnow, Calendar.DATE);
        return between;
    }

    public static String dateFormate(Date date, String formate) {
        Locale.setDefault(Locale.CHINA);
        if (date != null) {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(formate);
            return sdf.format(date);
        } else {
            return null;
        }

    }

    public static String dateFormateHuman(int seconds) {
        Date date = DateUtil.mysqlDate2Date(seconds);

        Calendar cnow = Calendar.getInstance();
        Calendar clast = Calendar.getInstance();
        cnow.setTime(new Date());
        clast.setTime(date);

        String format = "";
        if (cnow.get(Calendar.YEAR) == clast.get(Calendar.YEAR) && cnow.get(Calendar.MONTH) == clast.get(Calendar.MONTH) && cnow.get(Calendar.DATE) == clast.get(Calendar.DATE)) {
            format = "HH:mm";
        } else if (cnow.get(Calendar.YEAR) == clast.get(Calendar.YEAR) && cnow.get(Calendar.MONTH) == clast.get(Calendar.MONTH)) {
            format = "MM月dd日";
        } else {
            format = "yyyy年MM月dd日";
        }

        return dateFormate(date, format);
    }

    public static String dateFormate(int seconds, String formate) {
        Date date = DateUtil.mysqlDate2Date(seconds);
        return dateFormate(date, formate);
    }

    public static Date getTime(String name, Date defaultValue) {
        return getDate(name, "HH:mm:ss", defaultValue);
    }

    public static Date getTime(String name) {
        return getTime(name, null);
    }

    /**
     * 比较日期值对应的时间与字符串对应的时间值的大小(只比较HH:mm:ss部分)。
     *
     * @param dateTime
     *            日期值
     * @param timeString
     *            时间字符串
     * @return <br>
     *         dateTime的时间早于 timeString的时间则返回 -1;<br>
     *         dateTime的时间晚于 timeString的时间则返回 1;<br>
     *         dateTime的时间等于 timeString的时间则返回 0;
     */
    public static int dateTimeDiff(Date dateTime, String timeString) {
        Calendar dTime = Calendar.getInstance();
        Calendar sTime = Calendar.getInstance();
        dTime.setTime(dateTime);
        sTime.setTime(getTime(timeString));
        sTime.set(Calendar.YEAR, dTime.get(Calendar.YEAR));
        sTime.set(Calendar.MONTH, dTime.get(Calendar.MONTH));
        sTime.set(Calendar.DATE, dTime.get(Calendar.DATE));
        if (dTime.before(sTime)) {
            return -1;
        }
        if (dTime.after(sTime)) {
            return 1;
        }
        return 0;
    }

    public static Date rollDate(Date dateTime, int field, int amount) {
        if (dateTime != null) {
            Calendar c = Calendar.getInstance();
            c.setTime(dateTime);
            c.add(field, amount);
            return c.getTime();
        }
        return null;
    }

    /**
     * 功能：计算日期 时间：2010-3-4 下午07:47:31 版本： 参数： 日期基值 date 计算类型 type
     * 如Calendar.YEAR、Calendar.MONTH 计算偏值 num
     *
     * @return
     */
    public static Date caclDate(Date date, int type, int num) {
        Calendar C = Calendar.getInstance();
        C.setTime(date);
        C.add(type, num);
        return C.getTime();
    }

    public static String getDayIndexOfWeek(Date date) {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        int dayOfWeek = cld.get(7);
        return dayIndexs[(dayOfWeek - 1)];
    }

    /**
     * 获取当前日期是星期几
     *
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    public static void main(String[] args) {
        Date dExpiredDate = DateUtil.getDate( "20111226070000", "yyyyMMddHHmmss", null);

       System.out.println(dExpiredDate.after(new Date()));
    }
    /** 
     * 获得指定日期的前一天 
     *  
     * @param specifiedDay 
     * @return 
     * @throws Exception 
     */  
    public static Date getSpecifiedDayBefore(String specifiedDay) {//可以用new Date().toLocalString()传递参数  
        Calendar c = Calendar.getInstance();  
        Date date = null;  
        try {  
            date = new SimpleDateFormat("yy-MM-dd HH:mm").parse(specifiedDay);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        c.setTime(date);  
        int day = c.get(Calendar.DATE);  
        c.set(Calendar.DATE, day - 1);  
        //String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        Date dayBefore = c.getTime(); 
        return dayBefore;  
    }
    
    /** 
     * 获得指定日期 
     *  
     * @param specifiedDay 
     * @return 
     * @throws Exception 
     */  
    public static Date getSpecifiedDay(String specifiedDay) {//可以用new Date().toLocalString()传递参数  
        Calendar c = Calendar.getInstance();  
        Date date = null;  
        try {  
            date = new SimpleDateFormat("yy-MM-dd HH:mm").parse(specifiedDay);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        c.setTime(date);  
        int day = c.get(Calendar.DATE);  
        c.set(Calendar.DATE, day);  
        //String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        Date dayBefore = c.getTime(); 
        return dayBefore;  
    } 
  
    /** 
     * 获得指定日期的后一天 
     *  
     * @param specifiedDay 
     * @return 
     */  
    public static Date getSpecifiedDayAfter(String specifiedDay) {  
        Calendar c = Calendar.getInstance();  
        Date date = null;  
        try {  
            date = new SimpleDateFormat("yy-MM-dd HH:mm").parse(specifiedDay);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        c.setTime(date);  
        int day = c.get(Calendar.DATE);  
        c.set(Calendar.DATE, day + 1);  
        //String dayAfter = new SimpleDateFormat("yyyy-MM-dd")  
        //.format(c.getTime());
        Date dayAfter = c.getTime();  
        //DateUtil.caclDate(DateUtil.getDate(specifiedDay,"yyyy-MM",null), Calendar.DATE, 1);
        return dayAfter;  
    }
    //判断时间是否在当前时间之前
    public static boolean judgeDate(String date){
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HH:mm");
    	Date d=null;
		try {
			d = formatter.parse(date+" 7:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
        String specifiedDay = sdf.format(d); 
        Date curr = new Date();
        return curr.before(getSpecifiedDay(specifiedDay));
    }
    
    public static boolean judgeDate(String date,String ampm){
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HH:mm");
    	Date d=null;
    	if ("1".equals(ampm)) {
    		try {
    			d = formatter.parse(date+" 12:00");
    		} catch (ParseException e) {
    			e.printStackTrace();
    		}
		} else if ("2".equals(ampm)) {
			try {
    			d = formatter.parse(date+" 18:00");
    		} catch (ParseException e) {
    			e.printStackTrace();
    		}
		}
        Date curr = new Date();
        return curr.before(d);
    }
}
