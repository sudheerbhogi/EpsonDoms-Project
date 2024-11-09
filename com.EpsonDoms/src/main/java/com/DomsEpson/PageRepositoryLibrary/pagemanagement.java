package com.DomsEpson.PageRepositoryLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class pagemanagement {
	public WebDriver driver;
	public Loginpage loginPageobj;
	public Registerpage registerpageobj;
	public Welcomepage Welcomepageobj;
	

//Initialization
	public pagemanagement(WebDriver driver) {
		this.driver=driver;
	}
	public Loginpage initloginpage() {
		loginPageobj=new Loginpage(driver);
		return loginPageobj;
	}
	
	public Welcomepage initWelcomepage() {
		Welcomepageobj=new Welcomepage(driver);
		return this.Welcomepageobj;
				
	}

	
	public Registerpage initRegisterpage() {
		registerpageobj=new Registerpage(driver);
		return registerpageobj;
	
	}
	
}
