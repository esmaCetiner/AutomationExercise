package com.eurotech.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    //We added from ExtentReportsDemoClass
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;

    @BeforeTest
    public void setUpTest(){

        report = new ExtentReports();

        String projectPath=System.getProperty("user.dir");
        String path= projectPath+"/test-output/report.html";

        htmlReporter=new ExtentHtmlReporter(path);

        report.attachReporter(htmlReporter);

        htmlReporter.config().setReportName("Batch11 Smoke Test");

        report.setSystemInfo("Environment","Production");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer","Esma Cetiner");
    }
    @AfterTest
    public void tearDownTest(){
        report.flush();
    }

    @BeforeMethod
    public void setUp() {
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // driver.get(ConfigurationReader.get("url"));
        wait=new WebDriverWait(driver,15);
        actions=new Actions(driver);

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {
        //If test is failed
        if (result.getStatus()==ITestResult.FAILURE){
            //Record the name of the failed test
            extentLogger.fail(result.getName());

            //Take the screenshot (evidence) and return its location
            String screenShotPath= BrowserUtils.getScreenshot(result.getName());

            //Add the screenshot to the report
            extentLogger.addScreenCaptureFromPath(screenShotPath);

            //Capture the exception and put inside the report
            extentLogger.fail(result.getThrowable());
        }

        Thread.sleep(2000);
        Driver.closeDriver();
    }
}
