package Hrismaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Timesheet {
WebDriver web;
	
	public Timesheet(WebDriver web)
	{
		this.web = web;
	}

	public Boolean getDisplay()
	{		
		return this.web.findElement(By.className("ng-binding")).isDisplayed();
	}
}