package com.EpsonDoms.Welcometest;

import org.testng.Assert;
import org.testng.Reporter;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.DomsEpson.PageRepositoryLibrary.pagemanagement;
import com.EpsonDoms.Genericlibrary.BaseTest;
import com.EpsonDoms.Javalibrary.javaUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class VerifyWelcomePageTest extends BaseTest {
	

	@Test(priority = 1)
	public void verifyWelcomepageWithValidInput() {

		// Create the Test Information
		test = report.createTest("verifyWelcomepageWithValidInput");

		// steps Information
		test.log(Status.INFO, "Execution Started Sucessfully");

		test.log(Status.INFO, "step1:Launching the Browser Sucessful");

		// Implicitly wait
		webdriverobj.WaitImplicitly(20);

		Assert.assertEquals("Learning Selenium", webdriverobj.driver.getTitle());
		test.log(Status.PASS, "Title Verified:");

		// create an object for PageManager
		pagemanagementobj = new pagemanagement(webdriverobj.driver);

		// verify the name Textfield
		boolean result = pagemanagementobj.initWelcomepage().getNametextfield().isDisplayed();
		Assert.assertTrue(result);
		test.log(Status.INFO, "Element verified:name textfield is displayed");

		// step-3 perform action -clear
		pagemanagementobj.initWelcomepage().getNametextfield().clear();
		test.log(Status.INFO, "Clear Action done Succefully -name");

		// perform Action--sendkeys
		pagemanagementobj.initWelcomepage().getNametextfield().sendKeys(username);
		test.log(Status.INFO, "Sendkeys Action done Succefully -name");
		javaUtility.pause(2000);

		boolean email = pagemanagementobj.initWelcomepage().getEmailtextfield().isDisplayed();
		/*
		 * if (result) { test.log(Status.PASS,"Email pass"); } else {
		 * test.log(Status.FAIL,"email textfield is not displayed"); }
		 */
		pagemanagementobj.initWelcomepage().getEmailtextfield().sendKeys("charan00013@gmail.com");
		javaUtility.pause(2000);
		boolean pswd = pagemanagementobj.initWelcomepage().getPasswordtextfield().isDisplayed();
		/*
		 * if (result) { Reporter.log("pswd textfield is displayed", true); } else {
		 * Reporter.log("pswd textfield is not displayed", true); }
		 */
		pagemanagementobj.initWelcomepage().getPasswordtextfield().sendKeys("Ch@ran0013");
		javaUtility.pause(2000);
		boolean Mobile = pagemanagementobj.initWelcomepage().getNametextfield().isDisplayed();
		/*
		 * if (result) { Reporter.log("Mobile textfield is displayed", true); } else {
		 * Reporter.log("Mobile textfield is not displayed", true); }
		 */
		pagemanagementobj.initWelcomepage().getMobileNotextfield().sendKeys("9959536894");
		javaUtility.pause(2000);
		boolean Dob = pagemanagementobj.initWelcomepage().getDateofbirth().isDisplayed();
		/*
		 * if (result) { Reporter.log("Dob textfield is displayed", true); } else {
		 * Reporter.log("Dob textfield is not displayed", true); }
		 */
		pagemanagementobj.initWelcomepage().getDateofbirth().sendKeys("18-jun-1996");
		javaUtility.pause(2000);
		boolean Male = pagemanagementobj.initWelcomepage().getGendermalefield().isDisplayed();
		/*
		 * if (result) { Reporter.log("Male radiao button is displayed", true); } else {
		 * Reporter.log("Male radiao button is not displayed", true); }
		 */
		pagemanagementobj.initWelcomepage().getGendermalefield().click();
		javaUtility.pause(2000);
		boolean place = pagemanagementobj.initWelcomepage().getPlacesbglrfield().isDisplayed();
		/*
		 * if (result) { Reporter.log("place radiao buttons are displayed", true); }
		 * else { Reporter.log("place radiao buttons are not displayed", true); }
		 */
		pagemanagementobj.initWelcomepage().getPlacesbglrfield().click();

		boolean INDIA = pagemanagementobj.initWelcomepage().getCountry().isDisplayed();
		/*
		 * if (result) { Reporter.log("INDIA dropdown is displayed", true); } else {
		 * Reporter.log("INDIA dropdown is not displayed", true); }
		 */
		pagemanagementobj.initWelcomepage().getCountry().click();

		boolean INDIA1 = pagemanagementobj.initWelcomepage().getCountry().isSelected();
		/*
		 * if (result) { Reporter.log("INDIA1 dropdown is Selected", true); } else {
		 * Reporter.log("INDIA1 dropdown is not Selected", true); }
		 */

		boolean Feedback = pagemanagementobj.initWelcomepage().getFeedback().isDisplayed();
		/*
		 * if (result) { Reporter.log("Feedback textfield is displayed", true); } else {
		 * Reporter.log("Feedback textfield is not displayed", true); }
		 */
		pagemanagementobj.initWelcomepage().getFeedback().sendKeys("hello welcome to these page");

		boolean Register = pagemanagementobj.initWelcomepage().getRegister().isDisplayed();
		/*
		 * if (result) { Reporter.log("Register submit button is displayed", true); }
		 * else { Reporter.log("Register submit button is not displayed", true); }
		 */
		pagemanagementobj.initWelcomepage().getRegister().click();
		javaUtility.pause(2000);
		// g1.getContact().click();
//
		SoftAssert softassertobj = new SoftAssert();

		// Execution log or status
		Reporter.log("Execution completed succefully", true);
		// Flush the report information
		report.flush();
	}

	@Test(priority = 2, invocationCount = 2, dependsOnMethods = "verifyWelcomepageWithValidInput")
	public void VerifyWelcomePageWithInValidInput() {
		// Create the test information
		test = report.createTest("VerifyWelcomePageWithInValidInput");
		// Execution starts
		test.log(Status.INFO, "Execution Starts");
		// Execute the precondition--->1.launch browser,2.Navigate to Url

		// Implicitly wait
		webdriverobj.WaitImplicitly(20);

		// Verify the Welcome page using Title
		String Exptitle = "Learning Selenium";
		String Acttile = webdriverobj.driver.getTitle();
		// verify Tittle -HardAssertion
		Assert.assertEquals(Acttile, Exptitle);

		// Create the Test Information
		test = report.createTest("verifyWelcomepageWithValidInput");

		// steps Information
		test.log(Status.INFO, "Execution Started Sucessfully");

		test.log(Status.INFO, "step1:Launching the Browser Sucessful");

		// Implicitly wait
		webdriverobj.WaitImplicitly(20);

		Assert.assertEquals("Learning Selenium", webdriverobj.driver.getTitle());
		test.log(Status.PASS, "Title Verified:");

		// create an object for PageManager
		pagemanagementobj = new pagemanagement(webdriverobj.driver);

		// verify the name Textfield
		boolean result = pagemanagementobj.initWelcomepage().getNametextfield().isDisplayed();
		Assert.assertTrue(result);
		test.log(Status.INFO, "Element verified:name textfield is displayed");

		// step-3 perform action -clear
		pagemanagementobj.initWelcomepage().getNametextfield().clear();
		test.log(Status.INFO, "Clear Action done Succefully -name");

		// perform Action--sendkeys
		pagemanagementobj.initWelcomepage().getNametextfield().sendKeys("gaggag");
		test.log(Status.INFO, "Sendkeys Action done Succefully -name TextField");
		// see the execution
		javaUtility.pause(2000);

		// To make The Excplicit TestScriptFail
		// Assert.fail();

		// verify the postcondition -->terminate the browser
		// Execution log or status
		test.log(Status.INFO, "<<---Execution completed successfully");
	}
}
