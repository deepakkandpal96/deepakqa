package Hrismaven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HrisMain {
	WebDriver web;
	HrisMaven loginform;
	
	
	 @BeforeClass
	 
	    public void launchBrowser()
	    {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\deepakkandpal\\Desktop\\chromedriver_win32\\chromedriver.exe");
	 	    web = new ChromeDriver();
	        web.get("https://hris.qainfotech.com/login.php");
	        web.findElement(By.className("active")).click();
	        loginform = new HrisMaven(web);
	        
	    }
	
	 @Test(priority=1)
       public void attempt_Login_With_Incorrect_Password_Should_Render_Error_Message()
	  {
            Assert.assertTrue(loginform.loginWithIncorrectCredentials("invalid_username", "invalid_password").contains("Invalid Login"));
           
      }
	 
	 @Test(priority=2)
	    public void attempt_Login_With_No_Password_Should_Annotate_Blank_Password_Field()
	    {
	        loginform.login("deepakkandpal", "");
	        Assert.assertTrue(loginform.isPasswordEntryAnnotated());  
	    }
	    
    
    @Test(priority=3)
    public void attempt_Login_With_correct_Password_Should_Take_You_To_Timesheet_Page()
    {
        Assert.assertTrue(loginform.loginWithCorrectCredentials("akansharastogi", "Akansha@321#").getDisplay());
    }
    
    @AfterClass
    public void closeBrowser() throws InterruptedException
    {
    	
    	TimeUnit.SECONDS.sleep(4);
        web.quit();
    }
}
