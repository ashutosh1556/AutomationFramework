package com.automation.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pageObjects.LoginPage;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "TestData")
	public void login(String user, String pwd) throws IOException {

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("UserName Entered");
		lp.setPassword(pwd);
		logger.info("Password Entered");
		lp.clickSubmit();
		logger.info("Submitted");

		if (isAlertPresent()) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.warn("Login Failed");
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
			logger.warn("Login Passed");
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
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

	/*
	 * @DataProvider(name = "TestData") String[][] getData() throws IOException {
	 * String path = excelPath();
	 * 
	 * int rowcount = XLUtils.getRowCount(path, "Sheet1"); int colcount =
	 * XLUtils.getCellCount(path, "Sheet1", 1);
	 * 
	 * String[][] loginData = new String[rowcount][colcount];
	 * 
	 * for (int i = 1; i <= rowcount; i++) { for (int j = 0; j < colcount; j++) {
	 * loginData[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j); } } return
	 * loginData; }
	 */
	
	
}
