package Hrismaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HrisMaven {
	WebDriver web;
    WebElement UserNameEntry, PasswordEntry, ErrorMessage;
	
	

	 HrisMaven(WebDriver web) {
		this.web = web;
	}
	public WebElement getUserNameEntry(){
		return this.web.findElement(By.id("txtUserName"));	
	}
	public WebElement getPasswordEntry(){
		return this.web.findElement(By.id("txtPassword"));	
	}
	public WebElement getErrorMessage(){
		return this.web.findElement(By.xpath("//*[@id=\"login\"]/form/div[1]/div"));	
	}
	
	public String loginWithIncorrectCredentials(String username, String password){
        login(username, password);
        return getErrorMessage().getText();
    }
	
	public Timesheet loginWithCorrectCredentials(String username, String password){
        login(username, password);
	    return new Timesheet(web);
	}
	void login(String username, String password){
        getUserNameEntry().clear();
        getUserNameEntry().sendKeys(username);
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        getPasswordEntry().clear();
        getPasswordEntry().sendKeys(password);
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        web.findElement(By.xpath("//input[@type='submit']")).click();
        web.findElement(By.className("active")).click();   
    }
	
	public Boolean isErrorMessage(String expectedMessage){
        return getErrorMessage().getText().contains(expectedMessage);
        
    }
    public Boolean isPasswordEntryAnnotated(){
        return getPasswordEntry().getAttribute("style").contains("red");
    }
}
