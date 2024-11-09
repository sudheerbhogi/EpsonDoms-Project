package com.EpsonDoms.JavaScriptLibrary;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.EpsonDoms.webdriverlibrary.WebdriverUtility;
/**
 * This Class Provides the Reusable Method To Perform JavaScript Related Actions
 * By calling Inbuild Methods
 * 
 *@author sande
 */


public class JavScriptUtility {
	
	public  JavascriptExecutor javascriptobj;
	
	/**
     * This Method Used To enterData_DisabledElement
     * 
     * @param WebElement element,String data
     * @return void*/
	public void enterData_DisabledElement(WebElement element,String data)
	{
		javascriptobj=(JavascriptExecutor)WebdriverUtility.driver_static;
		javascriptobj.executeScript("arguments[0].value='"+data+"'", element);
	}
	/**
     * This Method Used To click_DisabledElement
     * 
     * @param WebElement element
     * @return void*/
	
	public void click_DisabledElement(WebElement element)
	{
		javascriptobj=(JavascriptExecutor)WebdriverUtility.driver_static;
		javascriptobj.executeScript("arguments[0].click()", element);

	}
	/**
     * This Method Used To defaultVerticalscrollBy
     * 
     * @return void*/
	public void defaultVerticalscrollBy()
	{
		javascriptobj=(JavascriptExecutor)WebdriverUtility.driver_static;
		javascriptobj.executeScript("window.scrollBy(1000, 1000)");
	}
	
	/**
     * This Method Used To defaultVerticalscrollTo
     * 
     * @return void*/
	public void defaultVerticalscrollTo()
	{
		javascriptobj=(JavascriptExecutor)WebdriverUtility.driver_static;
		javascriptobj.executeScript("window.scrollTo(1000, 1000)");
	}
	
	/**
     * This Method Used To defaultscrollUsingView
     * 
     * @param WebElement element,
     * @return void*/
	public void defaultscrollUsingView(WebElement element,boolean value)
	{
		javascriptobj=(JavascriptExecutor)WebdriverUtility.driver_static;
		javascriptobj.executeScript("arguments[0].scrollIntoView("+value+");", element);
	}

}