package com.automation.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation.pageObjects.LoginPage;
import com.automation.pageObjects.NewCustomer;

public class TC_AddCustomer_003 extends BaseClass {

	@Test(dependsOnMethods = { "com.automation.testCases.TC_LoginDDT_002.login" })
	public void addCustDetails() throws IOException {
		NewCustomer nec = new NewCustomer(driver);
		nec.newCustPage();
		nec.setCustName("Test User");
		nec.setCustGender("Male");
		nec.setCustDob("01-01-1985");
		nec.setCustAdd("Sector 24");
		nec.setCustCity("Gurugram");
		nec.setCustState("Haryana");
		nec.setCustPin("122002");
		nec.setCustMob("1234567890");
		String email = randomEmail + "@gmail.com";
		nec.setCustEmail(email);
		nec.setCustPass("123456");
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

	String randomEmail = RandomStringUtils.randomAlphanumeric(8);

// @DataProvider(name="TestData")
	

}
