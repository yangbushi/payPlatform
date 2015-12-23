package com.defray.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class DefaultConfUtil {
    private static Logger log = Logger.getLogger(DefaultConfUtil.class);
    private static DefaultConfUtil defaultProperties = null;
    private Properties properties;
    private static final String PROP_PATH = "/conf/default.properties";

    private DefaultConfUtil() {
        properties = null;
        init();
    }

    private InputStream getInputStream() {
        log.debug("加载配置文件 [" + System.getProperty("user.dir")+PROP_PATH + "]");
        System.out.println(System.getProperty("user.dir")+PROP_PATH);
        return this.getClass().getResourceAsStream(System.getProperty("user.dir")+PROP_PATH);
    }

    private void init() {
        if (properties == null)
            properties = new Properties();
        try {
            properties.load(getInputStream());
        } catch (IOException e) {
            log.error("未找到配置文件[default.properties]", e);
        }
    }

    public static DefaultConfUtil getInstance() {
        if (defaultProperties == null)
            defaultProperties = new DefaultConfUtil();
        return defaultProperties;
    }

    public String get(String key) {
        return properties.getProperty(key);
    }

}
