package com.automation.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	private void loginTest() throws IOException {
		logger.info("Test Case Started");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("Entered Username");
		lp.setPassword(userPassword);
		logger.info("Entered Passsword");
		lp.clickLogin();

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Title matched");
		} else {
			try {
				captureScreenshot(driver, "loginTest");
			} catch (Exception e) {
				e.printStackTrace();
			}
			Assert.assertTrue(false);
			logger.info("Title not matched");
		}
		logger.info("Test Case End");
	}
}