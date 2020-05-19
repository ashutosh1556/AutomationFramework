package com.automation.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporting extends TestListenerAdapter {

    ExtentSparkReporter extentSparkReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;

    public void onStart(ITestContext textContext) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String reportName = "TestReport_" + timeStamp + ".html";

        extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/" + reportName);
        extentSparkReporter.loadXMLConfig(System.getProperty("user.dir") + "/spark-config.xml/");

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        extentReports.setSystemInfo("Hostname", "TIMES CARD");
        extentReports.setSystemInfo("Environment", "Staging");
        extentReports.setSystemInfo("User", "Ashutosh Verma");

        extentSparkReporter.config().setDocumentTitle("Automation test report");
        extentSparkReporter.config().setReportName("Test results");
        extentSparkReporter.config().setTheme(Theme.STANDARD);
    }

    public void onTestSuccess(ITestResult tcName) {
        extentTest = extentReports.createTest(tcName.getName());
        extentTest.log(Status.PASS, MarkupHelper.createLabel(tcName.getName(), ExtentColor.GREEN));
    }

    public void onTestFailure(ITestResult tcName) {
        extentTest = extentReports.createTest(tcName.getName());
        extentTest.log(Status.FAIL, MarkupHelper.createLabel(tcName.getName(), ExtentColor.RED));

        String imagePath = System.getProperty("user.dir") + "/Screenshots/" + tcName.getName() + ".png";

        File imageAtPath = new File(imagePath);

        if (imageAtPath.exists()) {
            try {
                extentTest.fail(tcName.getThrowable().getMessage() + extentTest.addScreenCaptureFromPath(imagePath));
//                extentTest.fail(tcName.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(imagePath).build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onTestSkipped(ITestResult tr) {
        extentTest = extentReports.createTest(tr.getName());
        extentTest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
    }

    public void onFinish(ITestContext tr) {
        extentReports.flush();
    }
}
