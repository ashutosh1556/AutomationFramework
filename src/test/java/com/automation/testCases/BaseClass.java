package com.automation.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.automation.utilities.ReadConfig;

public class BaseClass {

	ReadConfig rc = new ReadConfig();
	public String userName = rc.getUserName();
	public String userPassword = rc.getPassword();
	public String baseURL = rc.getBaseUrl();
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
			// ProfilesIni prof = new ProfilesIni();
			// FirefoxProfile ffProfile = prof.getProfile("automation");
			// logger.info("Exiting FF profile");
			// if (ffProfile != null) {
			// logger.info("Going to accept certificate");
			// ffProfile.setAcceptUntrustedCertificates(true);
			// logger.info("Certificate Accepted");
			// ffProfile.setAssumeUntrustedCertificateIssuer(false);
			// System.setProperty("webdriver.gecko.driver", rc.getFirefoxPath());
			System.setProperty("webdriver.gecko.driver", rc.getFirefoxPath());
			// DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			// capabilities.setCapability("marionette", true);
			// FirefoxOptions options = new FirefoxOptions();
			// options.setLegacy(true);
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();

	}

	// @BeforeMethod
	// String excelPath(String dataFileName) {
	// String testDataExcelFile = (System.getProperty("user.dir") +
	// "/src/test/java/com/automation/testData/"
	// + dataFileName + ".xlsx");
	// return testDataExcelFile;
	// }

	@BeforeMethod
	@DataProvider(name = "TestData")
	public static Object[][] getDatafromExcelToHashmap() throws Exception {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/java/com/automation/testData/TestData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet("Sheet1");
		wb.close();
		fis.close();
		int lastRowNum = ws.getLastRowNum();
		int lastCellNum = ws.getRow(0).getLastCellNum();
		int rowCount = ws.getLastRowNum();
		Object[][] data = new Object[rowCount][1];
		for (int i = 0; i < lastRowNum; i++) {
			ws.getRow(i);
			Map<String, String> map = new HashMap<String, String>();
			for (int j = 0; j < lastCellNum; j++) {
				map.put(ws.getRow(0).getCell(j).getStringCellValue(), ws.getRow(i + 1).getCell(j).getStringCellValue());
			}
			data[i][0] = map;
		}
		return data;
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
