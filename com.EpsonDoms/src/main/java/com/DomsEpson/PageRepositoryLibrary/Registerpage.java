package com.DomsEpson.PageRepositoryLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Registerpage {
	public Registerpage (WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
}
