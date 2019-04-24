package com.automation.testCases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.automation.utilities.ReadConfig;

public class BaseClass {

	ReadConfig rc = new ReadConfig();

	public String baseURL = rc.getBaseUrl();
	public String userName = rc.getUserName();
	public String userPassword = rc.getPassword();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeTest
	public void setUp(String brwsr) {

		logger = Logger.getLogger("BaseClass");
		PropertyConfigurator.configure("log4j.properties");

		if ("chrome".equals(brwsr)) {
			DesiredCapabilities handlSSLErr = DesiredCapabilities.chrome();
			handlSSLErr.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			System.setProperty("webdriver.chrome.driver", rc.getChromePath());
			driver = new ChromeDriver();

		} else if ("firefox".equals(brwsr)) {
//			ProfilesIni prof = new ProfilesIni();
//			FirefoxProfile ffProfile = prof.getProfile("automation");
//			logger.info("Exiting FF profile");
//			if (ffProfile != null) {
//				logger.info("Going to accept certificate");
//				ffProfile.setAcceptUntrustedCertificates(true);
//				logger.info("Certificate Accepted");
//				ffProfile.setAssumeUntrustedCertificateIssuer(false);
//				System.setProperty("webdriver.gecko.driver", rc.getFirefoxPath());
				System.setProperty("webdriver.gecko.driver", rc.getFirefoxPath());
				driver = new FirefoxDriver();
//			}
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();

	}

	@BeforeMethod
	public String excelPath() {
		String path = (System.getProperty("user.dir") + "/src/test/java/com/automation/testData/TestData.xlsx");
		return path;
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	public void captureScreeshot(WebDriver driver, String tcName) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		System.out.println(System.getProperty("user.dir") + "/Screenshots/");
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tcName + ".png");
		FileUtils.copyFile(source, target);
	}

}
