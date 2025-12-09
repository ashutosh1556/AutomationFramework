package com.automation.testCases;

import com.automation.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckCRMLogin extends BaseClass {
    @Test
    public void loginTest() throws Exception {
        try {
            logger.info("Test Case Started");
            LoginPage loginPage = new LoginPage(driver);

            loginPage.clickLogin();
            logger.info("Log in button clicked");

            loginPage.setUserName(userName);
            logger.info("Entered Username");

            loginPage.setPassword(userPassword);
            logger.info("Entered Password");

            if (driver.getTitle().equals("Cogmento CRM")) {
                Assert.assertTrue(true);
                logger.info("Title matched");
            } else {
                captureScreenshot(driver, "loginTest");
                Assert.assertTrue(false);
                logger.info("Title not matched");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            captureScreenshot(driver, "loginTest");
            throw e;
        }
        logger.info("Test Case End");
    }
}
