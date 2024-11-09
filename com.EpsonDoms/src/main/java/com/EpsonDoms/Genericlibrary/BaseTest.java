package com.EpsonDoms.Genericlibrary;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.DomsEpson.PageRepositoryLibrary.pagemanagement;
import com.EpsonDoms.Excelfilelibrary.ReadExcelFile;
import com.EpsonDoms.PropertyFile.library.ReadPropertyFile;
import com.EpsonDoms.webdriverlibrary.WebdriverUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * This Class is used For configure All PreCondition And PostCondition For TestScript 
 * And also intializing All library-utility
 *
 * 
 *@author sande
 */
public class BaseTest {

	public pagemanagement pagemanagementobj;
	public WebdriverUtility webdriverobj;
	public ReadExcelFile excelutilityobj;
	public ReadPropertyFile propertyfileobj;
	public String username;
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;

	@BeforeSuite
	public void suiteSetup() {
		// Create spark Report
		spark = new ExtentSparkReporter("./AdvanceReports/report.html");

		// configure the spark report information
		spark.config().setDocumentTitle("Regresstion Testing for the learning selenium page");
		spark.config().setReportName("RegressionSuite||verification of welcome page");
		spark.config().setTheme(Theme.STANDARD);
		
		//Create the extent report
		report=new ExtentReports();
		
		//Attach the spark Report and ExtentReport
		report.attachReporter(spark);
		
		//Configure the system info
		report.setSystemInfo("DeviceName:", "Chinna");
		report.setSystemInfo("Operating system:", "Windows 11");
		report.setSystemInfo("Browser:", "Chrome");
		report.setSystemInfo("BrowserVersion:", "chrome-130.0.6723.92");
		
	}

	@AfterSuite
	public void suiteTerminatesetup() {
		report.flush();
	}

	@Parameters({ "browsername", "webUrl" })

	@BeforeClass
	public void browsersetup(String browser, String url) {
		// create Obj for all the repository utility
		createObjects();
		//Fetch the UserName from excel file
		username = excelutilityobj.readSingleData("Sheet1", 1, 1);
		// step:1Launch the browser
		webdriverobj.launchBrowser(browser);
		Reporter.log("step:1.1 Maximized Browser Success",true);

		// Maximize the browser
		webdriverobj.maximizeTheBrowser();

		// Step:2Navigating to the ApplicationUrl

		webdriverobj.NavigateToApplication(url);
		Reporter.log("Navigated to the application URL",true);
	}

	@AfterClass
	public void terminatebrowser() {
		// step10:close the browser

		webdriverobj.closeAllBrowser();
		Reporter.log("close the browser success",true);
	}

	public void createObjects() {
		webdriverobj = new WebdriverUtility();

		excelutilityobj=new ReadExcelFile();
	 propertyfileobj=new ReadPropertyFile();
	}
}
