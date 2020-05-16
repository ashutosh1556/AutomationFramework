package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties pro;

    public ReadConfig() {
        File src = new File("Configuration/Config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is: " + e.getMessage());
        }
    }

    public String getBaseUrl() {
        return pro.getProperty("baseURL");
    }

    public String getUserName() {
        return pro.getProperty("userName");
    }

    public String getPassword() {
        return pro.getProperty("userPassword");
    }

    public String getChromePath() {
        return pro.getProperty("chromePath");
    }

    public String getFirefoxPath() {
        return pro.getProperty("firefoxPath");
    }
}
