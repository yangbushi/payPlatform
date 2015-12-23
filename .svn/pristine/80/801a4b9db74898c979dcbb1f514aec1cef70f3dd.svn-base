package com.defray.util;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConfigUtil {

    private static Logger log = Logger.getLogger(ConfigUtil.class);

    private static ConfigUtil configUtil = new ConfigUtil();
    private Properties properties = new Properties();
    private static final String CONF_FILE_PATH = "/conf/config.properties";

    public static ConfigUtil getInstance() {
        return configUtil;
    }

    private ConfigUtil() {
        init();
    }

    private void init() {
        try {
            properties.load(this.getClass().getResourceAsStream(CONF_FILE_PATH));
        } catch (IOException e) {
            log.error("配置文件加载错误[" + CONF_FILE_PATH + "]", e);
        }
    }

    public String getString(String key) {
        return properties.getProperty(key);
    }

    public int getInt(String key) {
        return  Integer.parseInt(properties.getProperty(key));
    }
}
