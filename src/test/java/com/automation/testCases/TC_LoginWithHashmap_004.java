/**
 * 
 */
package com.automation.testCases;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.pageObjects.LoginPage;
import com.automation.utilities.XLUtils;

/**
 * @author ashutosh.verma
 *
 */
@Test(dataProvider = "Testdata")
public class TC_LoginWithHashmap_004 extends BaseClass {

	public void loginUsingHashmap(String uname, String pswd) throws Exception {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(uname);
		logger.info("UserName Entered");
		lp.setPassword(pswd);
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

	// https://www.youtube.com/watch?v=3y1sfsRbQqQ 
	@DataProvider(name = "TestData")
	public static Map<String, Map<String, String>> getDatafromExcelToHashmap() throws Exception {
		
		Map<String, Map<String, String>> superMap = new HashMap<String, Map<String, String>>();
		Map<String, String> myMap = new HashMap<String, String>();

		String path = excelPath();
		int rowcount = XLUtils.getRowCount(path, "Sheet1");
//		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
//		String celldata = XLUtils.getCellData(path, "Sheet1", 1, 0);

		for (int i = 1; i <= rowcount; i++) {
		}
		return superMap;
	}
}
