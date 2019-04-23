package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;

	public ReadConfig() {
		File src = new File("./Configuration\\Config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is: " + e.getMessage());
		}
	}

	public String getBaseUrl() {
		String url = pro.getProperty("baseURL");
		return url;
	}

	public String getUserName() {
		String userName = pro.getProperty("userName");
		return userName;
	}

	public String getPassword() {
		String userPasssword = pro.getProperty("userPassword");
		return userPasssword;
	}

	public String getChromePath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}

	public String getFirefoxPath() {
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}
}
