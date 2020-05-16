package com.automation.testCases;

import com.automation.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckCRMLogin extends BaseClass {
    @Test
    private void loginTest() throws Exception {

        try {
            logger.info("Test Case Started");
            LoginPage loginPage = new LoginPage(driver);

            loginPage.clickLogin();
            logger.info("Log in button clicked");

//            loginPage.setUserName(userName);
//            logger.info("Entered Username");
//
//            loginPage.setPassword(userPassword);
//            logger.info("Entered Password");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        captureScreenshot(driver, "loginTest");
        Assert.assertEquals("Cogmento CRM1", driver.getTitle());



//        if (driver.getTitle().equals("Cogmento CRM1")) {
//            Assert.assertTrue(true);
//            logger.info("Title matched");
//        } else {
//            captureScreenshot(driver, "Login test case");
//            Assert.assertTrue(false);
//            logger.info("Title not matched");
//        }
        logger.info("Test Case End");
    }
}
