package com.defray.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class CommentUtil {
	protected static final Logger LOG = LogManager.getLogger(CommentUtil.class);
	
	public static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat wxSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	public static SimpleDateFormat SDFDate = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat SDFTime = new SimpleDateFormat("HH:mm:ss");
	public static SimpleDateFormat SDFMonthDay = new SimpleDateFormat("MM-dd");

	public static String getTencentEmotions() throws IOException {
		String filename = "/json/tencent-emotions.json";
		InputStream ios = PropertiesHelp.class.getResourceAsStream(filename);
		BufferedReader in = new BufferedReader(new InputStreamReader(ios,"UTF-8"));
		//String encoding="";
		
		StringBuffer buffer = new StringBuffer();
		String line = "";
		while ((line = in.readLine()) != null) {
			buffer.append(line);
		}
		
		return StringUtil.getUtf8(buffer.toString(),"UTF-8");
		
	}
	
	public static long getTime() {
		Date dt = new Date();
		long nowtTme = dt.getTime();
		return nowtTme;
	}
	
	public static long getTimeshort() {
		Date dt = new Date();
		long nowtTme = dt.getTime() / 1000;
		return nowtTme;
	}
	
	public static Integer getNowTime(){
		Integer now = (int) (new Date().getTime() / 1000);
		return now;
	}


	public static Integer getIntegerTime(String expireDate) {
		if (expireDate == null || expireDate.equals("")) {
			return 0;
		}

		try {
			Date d = SDF.parse(expireDate);
			long expireTime = d.getTime() / 1000;
			return (int) expireTime;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}
	
	public static Integer getWxIntegerTime(String expireDate) {
		if (expireDate == null || expireDate.equals("")) {
			return 0;
		}

		try {
			Date d = wxSDF.parse(expireDate);
			long expireTime = d.getTime() / 1000;
			return (int) expireTime;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}
	
	/**
	 * 判断时间是否在多少天之内
	 * @return
	 */
	public static boolean getTimeInDays(String date,Integer days){
		Long interval = getIntervalTime(date,getDateString())/1000;		
		Long  daysSeconds = days*86400L;
		if(interval>daysSeconds){
			return false;
		}
		return true;
	}

	public static Integer getTime(String expireDate) {
		if (expireDate == null || expireDate.equals("")) {
			return -1;
		}
		try {
			Date dt = new Date();
			long nowtTme = dt.getTime();
			Date d = SDF.parse(expireDate);
			long expireTime = d.getTime();
			long expireIn = expireTime - nowtTme;
			return (int) (expireIn / 1000);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * 获取间隔时间的毫秒数
	 * @param startDate 开始时间
	 * @param endDate   终止时间
	 * @return 终止时间-开始时间的毫秒数。如果开始时间大于终止时间结果为负值
	 */
	public static Long getIntervalTime(String startDate, String endDate) {
		if (StringUtil.isEmpty(startDate) || StringUtil.isEmpty(endDate)) {
			return 0l;
		}
		try {
			return SDF.parse(endDate).getTime()-SDF.parse(startDate).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0l;
	}

	/**
	 * 计算新的时间，
	 * @param startDate 开始时间
	 * @param interval  间隔时间
	 * @return 新时间的字符串形式。interval为正数取得后面的时间，为负数时获取之前的时间
	 */
	public static Date computeDate(String startDate, long interval) {
		if (StringUtil.isEmpty(startDate)) {
			return null;
		}
		try {
			long startTime = SDF.parse(startDate).getTime();
			return new Date(startTime + interval);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static long computeTimeShort(String startDate, long interval) {
		if (StringUtil.isEmpty(startDate)) {
			return 0L;
		}
		try {
			long startTime = SDF.parse(startDate).getTime();
			return new Date(startTime + interval).getTime()/1000;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0L;
	}

	public static String computeDateString(String startDate, long interval) {
		if (StringUtil.isEmpty(startDate)) {
			return "";
		}
		try {
			long startTime = SDF.parse(startDate).getTime();
			return SDF.format(startTime + interval);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static List<String> getSevenDay() {
		List<String> dayList = new ArrayList<String>();
		Date dt = new Date();
		long time = dt.getTime();
		for (int i = 6; i >= 0; i--) {
			long timeTmp = time - 86400000 * i;
			String date = SDFDate.format(timeTmp);
			dayList.add(date + " 23:59:59");
		}
		return dayList;
	}
	
	public static List<String> getYunangeSevenDay() {
		List<String> dayList = new ArrayList<String>();
		Date dt = new Date();
		long time = dt.getTime();
		for (int i = 6; i >= 0; i--) {
			long timeTmp = time - 86400000 * i;
			String date = SDFDate.format(timeTmp);
			dayList.add(date + "T23:59:59");
		}
		return dayList;
	}
	
	public static List<Integer> getSevenDayInteger() {
		List<Integer> dayList = new ArrayList<Integer>();
		Date dt = new Date();
		long time = dt.getTime();
		for (int i = 6; i >= 0; i--) {
			long timeTmp = time - 86400000 * i;
			String dtTmp = SDFDate.format(timeTmp);
			Date date = null;
			try {
				date = SDFDate.parse(dtTmp);
			} catch (ParseException e) {
				LOG.error(e);
				e.printStackTrace();
//				dayList.add(null);
				return null;
			}
			int dateInteger = (int)(date.getTime() / 1000);
			dayList.add(dateInteger);
		}
		return dayList;
	}

	public static String getSimpleDate() {
		Date dt = new Date();
		String addtime = SDFDate.format(dt);
		return addtime;
	}
	
	public static Integer getSimpleDateInteger() {
		String dtStr = getSimpleDate();

		Date dt = null;;
		try {
			dt = SDFDate.parse(dtStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		return (int) (dt.getTime() / 1000);
		
	}
	
	public static String getDateString(long time) {		
		long datetime = time;		
		Date dt = new Date(datetime);
		String addtime = wxSDF.format(dt);
		return addtime;
	}
	
	public static String getDateString(int time) {		
		long datetime = (long)time*1000;		
		Date dt = new Date(datetime);
		String addtime = wxSDF.format(dt);
		return addtime;
	}

	public static String getDateString() {
		Date dt = new Date();
		String addtime = SDF.format(dt);
		return addtime;
	}

	public static String getDateString(Date dt) {
		if (dt == null)
			return "";
		String addtime = SDF.format(dt);
		return addtime;
	}

	/**
	 * 返回Date
	 * 
	 * @param timestamp
	 *            单位为妙
	 * @return
	 */
	public static Date getGreenTimeFromTimestamp(String timestamp) {
		if (StringUtil.isEmpty(timestamp))
			return null;
		long time = Long.valueOf(timestamp) * 1000;
		return new Date(time);
	}
	
	//输入日期字符串，返回date对象，例如 "2012-12-12 12:33:22"
	public static Date getDateFromString(String dateString){
		
		int timeInt = getTime(dateString);
		return new Date(timeInt*1000l);
		//return null;
	}

	/**
	 * 获取前后时间，
	 * 
	 * @param expireIn
	 * @param flag
	 *            为true的时候，取得后面的时间，false时获取之前的时间
	 * @return
	 */
	public static String getDate(String expireIn, boolean flag) {
		if (expireIn == null)
			return null;
		if (flag) {
			return getDate(Long.valueOf(expireIn) * 1000);
		} else {
			return getDate(Long.valueOf(expireIn) * -1000);
		}
	}

	public static String getDate(String expireIn) {
		if (expireIn == null)
			return null;
		return getDate(Long.valueOf(expireIn) * 1000);
	}

	public static String getDate(long expireInLong) {
		Date dt = new Date();
		long time = dt.getTime() + expireInLong;
		String addtime = SDF.format(time);
		return addtime;
	}

	public static Integer getRandomInt(Integer n) {
		Random r = new Random();
		return r.nextInt(n);
	}

	public static String mapToUrl(Map<String, Object> mapStr) {
		String url = "?1";
		if(mapStr==null) return url;

		Set<String> keys = mapStr.keySet();
		for (String k : keys) {
			if (mapStr.get(k) != null && !mapStr.get(k).equals("")) {
				url += "&" + k + "=" + mapStr.get(k);
			}
		}
		return url;
	}

	public static Map<String, String> urlToMap(String url) {
		Map<String, String> urlMap = new HashMap<String, String>();
		String[] urlArr = url.split("\\?");

		if (urlArr.length < 2) {
			return urlMap;
		}

		String uri = urlArr[1];
		String[] uriTmp = uri.split("&");
		if (uriTmp == null || uriTmp.length == 0) {
			return urlMap;
		}

		for (String tmp : uriTmp) {
			String[] tmpArr = tmp.split("=");
			if (tmpArr == null || tmpArr.length < 2) {
				continue;
			}
			urlMap.put(tmpArr[0], tmpArr[1]);
		}
		return urlMap;
	}

	/**
	 * @param map存储返回值的容器
	 * @param key存储的key
	 * @param value存储的值
	 * @return 将非空的key-value对存入map中
	 */
	public static  void addToMap(Map<String, Object>map,String key,Object value) {
		if (map == null) {
			map = new HashMap<String, Object>();
		}
		if (StringUtil.isEmpty(key) || value == null) {
			LOG.debug("when add  to map ,but is null:" + key);
			return;
		}
		if (!StringUtil.isEmpty(value.toString())) {
			map.put(key, value);
		}
	}

	/**
	 * 将一个 JavaBean 对象转化为一个 Map
     * @param bean 要转化的JavaBean 对象 
	 * @return 转化出来的 Map 对象
	 * @throws IllegalArgumentException
     * @throws IntrospectionException 如果分析类属性失败 
     * @throws IllegalAccessException 如果实例化 JavaBean 失败 
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map convertBean(Object bean) {
		Class type = bean.getClass();
		Map returnMap = new HashMap();
		BeanInfo beanInfo;
		try {
			beanInfo = Introspector.getBeanInfo(type);
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return returnMap;
		}

        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();  
		for (int i = 0; i < propertyDescriptors.length; i++) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();
			LOG.debug("propertyName" + propertyName);
			if (!propertyName.equals("class")) {
				Method readMethod = descriptor.getReadMethod();
				Object result;

				try {
					result = readMethod.invoke(bean, new Object[0]);
					if (result != null) {
						returnMap.put(propertyName, result);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return returnMap;
	}

	/**
	 * 将一个 Map 对象转化为一个 JavaBean
     * @param type 要转化的类型 
     * @param map 包含属性值的 map 
	 * @return 转化出来的 JavaBean 对象
     * @throws IntrospectionException 如果分析类属性失败 
     * @throws IllegalAccessException 如果实例化 JavaBean 失败 
     * @throws InstantiationException 如果实例化 JavaBean 失败 
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败 
	 */
	@SuppressWarnings("rawtypes")
	public static Object convertMap(Class type, Map map)
			throws IntrospectionException, IllegalAccessException,
			InstantiationException, InvocationTargetException {
		BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性
		Object obj = type.newInstance(); // 创建 JavaBean 对象

		// 给 JavaBean 对象的属性赋值
        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();  
		for (int i = 0; i < propertyDescriptors.length; i++) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();
			if (map.containsKey(propertyName)) {
				// 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
				Object value = map.get(propertyName);
				Object[] args = new Object[1];
				args[0] = value;
				descriptor.getWriteMethod().invoke(obj, args);
			}
		}
		return obj;
	}
	
	public static Integer getExpireTime(Integer expireIn) {
		if(expireIn == null) {
			return null;
		}
		
		Date dt = new Date();
		long time = dt.getTime() / 1000 + expireIn;
		return (int)time;
	}
	
	public static boolean isExpired(Integer expireTime) {
		Integer now = new Long(new Date().getTime() / 1000).intValue();
		
		return now > expireTime;
	}
	
	public static Integer getIntegerDate(String dateString, SimpleDateFormat sdf) {
		if (dateString == null || dateString.equals("")) {
			return 0;
		}
		
		try {
			Date d = sdf.parse(dateString);
			long expireTime = d.getTime() / 1000;
			return (int) expireTime;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	public static void main(String[] args) {
		
//		List<Integer> sevenDayInteger = getSevenDayInteger();
//		System.out.println(sevenDayInteger);
//		
//		for(Integer aday : sevenDayInteger) {
//			System.out.println(new Date((long)aday * 1000));
//		}
		
//		System.out.println((new Date().getTime()+ 5243462831489L));

		System.out.println(new Date((long)getExpireTime(0) * 1000));
		
		
		// String expireDate = CommentUtil.getDate(""+157679999);
//		System.out.println(getGreenTimeFromTimestamp("1362647037"));
		// System.out.println("expireDate="+(int)(157679999000l/1000));
		 
		//int a = CommentUtil.getNowTime();
		//System.out.println(a);
		Date date = new Date();
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
			String d = simpleDate.format(date);
			try {
				System.out.println(simpleDate.parse(d));
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

	}
}
