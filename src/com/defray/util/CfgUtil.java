package com.defray.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class CfgUtil {
    private static Logger log = Logger.getLogger(CfgUtil.class);
    private static CfgUtil configProperties = null;
    private Properties properties;
    private static final String PROP_PATH = "/conf/info.properties";

    private CfgUtil() {
        properties = null;
        init();
    }

    private InputStream getInputStream() {
        return this.getClass().getResourceAsStream(PROP_PATH);
    }

    private void init() {
        if (properties == null)
            properties = new Properties();
        try {
            properties.load(getInputStream());
        } catch (IOException e) {
            log.error("未找到配置文件[config.properties]", e);
        }
    }

    public static CfgUtil getInstance() {
        if (configProperties == null)
            configProperties = new CfgUtil();
        return configProperties;
    }

    public String get(String key) {
        return properties.getProperty(key);
    }

}
