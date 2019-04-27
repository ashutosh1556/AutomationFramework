package com.automation.testCases;

import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pageObjects.LoginPage;
import com.automation.pageObjects.NewCustomer;

public class TC_AddCustomer_003 extends BaseClass {

	NewCustomer nec = new NewCustomer(driver);

	@Test(dataProvider = "TestData", dependsOnMethods = { "com.automation.testCases.TC_LoginWithHashmap_004.login" })
	public void addCustDetails(Map<String, String> map) throws Exception {
		nec.newCustPage();
		nec.setCustName(map.get("setCustName"));
		nec.setCustGender(map.get("setCustGender"));
		nec.setCustDob(map.get("setCustDob"));
		nec.setCustAdd(map.get("setCustAdd"));
		nec.setCustCity(map.get("setCustCity"));
		nec.setCustState(map.get("setCustState"));
		nec.setCustPin(map.get("setCustPin"));
		nec.setCustMob(map.get("setCustMob"));
		String randomEmail = RandomStringUtils.randomAlphanumeric(8);
		String email = randomEmail + "@gmail.com";
		nec.setCustEmail(email);
		nec.setCustPass(map.get("setCustPass"));
		nec.btnSubmit();

		try {
			String actual = nec.getTableHeading();
			String expected = "Customer Registered Successfully123!!!";
			Assert.assertEquals(actual, expected);
			captureScreeshot(driver, "addCustDetails");
			logger.info("Header matched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

		nec.btnContinue();
		LoginPage lp = new LoginPage(driver);
		lp.clickLogout();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}
}
