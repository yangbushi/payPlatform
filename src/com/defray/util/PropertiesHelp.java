package com.defray.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class PropertiesHelp {

	protected static final Logger LOG = LogManager
			.getLogger(PropertiesHelp.class);

	private final String[] fileName = { "/properties/config.properties" };

	private static PropertiesHelp propertiesHelps = null;

	public static Map<Object, Object> map = null;

	private PropertiesHelp() {
		InputStream in = null;

		try {
			map = new HashMap<Object, Object>();
			for (String name : fileName) {
				in = PropertiesHelp.class.getResourceAsStream(name);
				Properties props = new Properties();
				props.load(in);
				Set<Object> keys = props.keySet();
				for (Object o : keys) {
					Object t = props.get(o);
					map.put(o, t);
				}
				in.close();
			}

		} catch (IOException e) {
			LOG.error(fileName + "读取失败！");
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				LOG.error(fileName + "关闭失败！");
			}
		}
	}

	public static String getProperty(String key) {
		if (propertiesHelps == null)
			propertiesHelps = new PropertiesHelp();
		try {
			return (String) map.get(key);
		} catch (Exception e) {
			LOG.error("PropertiesHelp,读取" + key + "属性发生异常");
			return null;
		}
	}
}
