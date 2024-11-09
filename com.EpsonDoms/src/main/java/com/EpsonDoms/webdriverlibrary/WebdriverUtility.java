package com.EpsonDoms.webdriverlibrary;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This Class Provides the Reusable Method ToPerform All Browser Related actions
 *@author sande*/




public class WebdriverUtility {
	
	public WebDriver driver;
	public static WebDriver driver_static;
	public  Select selectobj;
	public  Actions actionsobj;
	public  Robot robotobj;
    public  WebDriverWait wait;
    
    
    
    /**@param String Browser Name
     * This Method Used To Launch The Specific Browser
     * @return void*/
	public void launchBrowser(String browser) {

		switch (browser) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver_static=driver;
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver_static=driver;
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver_static=driver;
			break;
		default:
			System.out.println("Incorrect browser");
			break;
		}

	}
	/**
	 *  This Method is Used To Navigate To The Application
	 *  
	 * @param String Url
	 * @return void*/
	public  void NavigateToApplication(String url) {
		driver.get(url);
	}
	/**
	 *This Method is Used To Maximize The Browser
	 * 
	 * @return void*/
	public void maximizeTheBrowser() {
		driver.manage().window().maximize();
	}
	/**
	 *This Method is Used To Close The Browser
	 * 
	 * @return void*/
	public void closeTheBrowser() {
		driver.close();
	}
	/**
	 *This Method is Used To Close All The Browser
	 * 
	 * @return void*/
	public  void closeAllBrowser() {
		driver.quit();
	}
	/**
	 *This Method is Used To WaitImplicitly
	 *
	 *@param long Duration 
	 * @return void*/
	public  void WaitImplicitly(long duration) {
		driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);

	}
	/**
	 *This Method is Used To WaitExplicitly 
	 *
	 *@param long Duration, WebElement element
	 * @return void*/
	public void waitExplicitly(long duration, WebElement element) {
		 wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 *This Method is Used To selectOptionInDropdown
	 *
	 *@param WebElement element int Index
	 * @return void*/
	public void selectOptionInDropdown(WebElement element, int index) {
		selectobj.selectByIndex(index);
	}
	/**
	 *This Method is Used To selectOptionInDropdown
	 *
	 *@param WebElement element, String visibletext
	 * @return void*/
	public void selectOptionInDropdown(WebElement element, String visibletext) {
		selectobj.selectByVisibleText(visibletext);
	}
	/**
	 *This Method is Used To selectOptionInDropdown
	 *
	 *@param WebElement element, String Value
	 * @return void*/
	public void selectOptionInDropdown(String value, WebElement element) {
		selectobj.selectByValue(value);
	}
	/**
	 *This Method is Used To mouseHovering
	 *
	 *@param WebElement element
	 * @return void*/
	public void mouseHovering(WebElement element) {
		actionsobj.moveToElement(element).perform();
	}
	/**
	 *This Method is Used To pressTheKey
	 *
	 * @return void*/
	public void pressTheKey() {
		robotobj.keyPress(KeyEvent.VK_PAGE_DOWN);
	}
	/**
	 *This Method is Used To ReleaseTheKey
	 *
	 * @return void*/
	public void ReleaseTheKey() {
		robotobj.keyRelease(KeyEvent.VK_PAGE_DOWN);

	}
	/**
	 *This Method is Used To AlertPopupAccept
	 *
	 * @return void*/
	public void AlertPopupAccept() {
		driver.switchTo().alert().accept();
	}
	/**
	 *This Method is Used To AlertPopupDismiss
	 *
	 * @return void*/
	public void AlertPopupDismiss() {
		driver.switchTo().alert().dismiss();
	}
	/**
	 *This Method is Used To switchControlToFrame
	 *
	 *@param int index
	 * @return void*/
	public void switchControlToFrame(int index) {
		driver.switchTo().frame(index);

	}
	/**
	 *This Method is Used ToswitchControlToFrame
	 *
	 *@param WebElement element
	 * @return void*/
	public void switchControlToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 *This Method is Used To switchBackControlToMain
	 *
	 * @return void*/
	public void switchBackControlToMain() {
		driver.switchTo().defaultContent();
	}
	/**
	 *This Method is Used To switchControlToWindow
	 *
	 *@param String Windowid
	 * @return void*/
	public void switchControlToWindow(String Windowid) {
		
		driver.switchTo().window(Windowid);
	}

}
