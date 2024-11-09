package demo;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class demoTest {
	
@Test
	public void DemoTesting () {
		//Create the Spark Report
	ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReports/report.html");

	
	//Cinfigure the Spark Report Information
	spark.config().setDocumentTitle("Regression testing for The Learning page");
	spark.config().setReportName("RegisterSuite");
	spark.config().setTheme(Theme.DARK);
	
	//create the extent report
	ExtentReports report=new ExtentReports();
	
	//Attach the spark report and ExtentReport
	report.attachReporter(spark);
	
	//Configure the system information in ExtentReports
	report.setSystemInfo("DeviceName", "Chinna");
	report.setSystemInfo("OperatingSystem:","Window11");
	report.setSystemInfo("Browser","Chrome");
	report.setSystemInfo("BrowserVersion:", "chrome-128.0.6613.85");
	
	
	//Create the Test Information 
	ExtentTest test=report.createTest("Regressiontest");
	
	//steps Information
	test.log(Status.INFO,"Step1:Launching The Browser Sucessful");
	
	test.log(Status.INFO,"step:2 Navigating To Applicatiob Via Url Sucessful" );
	
	test.log(Status.PASS,"Step3:Verified The WebPage Sucessful");
	
	if("Chinna".equals("Chinna")){
		test.log(Status.PASS, "step4: Verified the WebElemneties Displayed");
	}else {
		test.log(Status.FAIL,"Step4:Verified the WebElemneties Not Displayed");
	}
		//test.log(Status.SKIP,"step5:Element is Hidden");
		
		//Flush the report information 
		report.flush();
		
		System.out.println("Execution done");
	}



@Test
public void demoTesting1() {
	
}
@Test
public void demoTesting2() {
}
@Test
public void demoTesting3() {
}
@Test
public void demoTesting4() {
}
@Test
public void demoTesting5() {
}


}
