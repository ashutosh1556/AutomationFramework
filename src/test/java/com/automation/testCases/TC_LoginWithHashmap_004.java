package com.automation.testCases;

import java.util.Map;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pageObjects.LoginPage;

public class TC_LoginWithHashmap_004 extends BaseClass {

	public String fileName;
	public String sheetName;

	@Test(dataProvider = "TestData")
	public void loginUsingHashmap(Map<String, String> map) throws Exception {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(map.get("username"));
		logger.info("UserName Entered");
		lp.setPassword(map.get("password"));
		logger.info("Password Entered");
		lp.clickSubmit();
		logger.info("Submitted");

		if (isAlertPresent()) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.error("Login Failed");
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
			logger.info("Login Passed");
			// lp.clickLogout();
			// driver.switchTo().alert().accept();
			// driver.switchTo().defaultContent();
		}
	}

	boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
}
