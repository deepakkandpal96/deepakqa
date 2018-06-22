package Tatocautomation;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Tatocs {
	WebDriver web = new ChromeDriver();
	
	   
	public void set_Up() {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\deepakkandpal\\Desktop\\chromedriver_win32\\chromedriver.exe");// To set the path of the chromedriver
		 web.manage().window().maximize();														// To maximize the window
		 web.get("http://10.0.1.86/tatoc");
		 web.findElement(By.linkText("Basic Course")).click();
		 
	}
		  
		 public void grid_Gate() {
		        
		        web.findElement(By.className("greenbox")).click(); }                          // To find element by the classname
			 
			 
			public void frame_Dungeon() {                                             
			    web.switchTo().frame("main");                                                 // To switch the main frame(parent frame)     
			    String box1 = web.findElement(By.id("answer")).getAttribute("class");         // To get box 1
			    
			    while(true){
			            
			            web.findElement(By.cssSelector("a")).click(); 
			            web.switchTo().frame("child");                                        // To switch to the child frame  
			            String box2 = web.findElement(By.id("answer")).getAttribute("class");
			            web.switchTo().parentFrame(); 
			            if(box1.equals(box2))                                                // Box 1 and Box 2 classes are same
			            {
			                web.findElement(By.linkText("Proceed")).click();
			                break;
			            }}
			    
			    }
			            
			            
			 public void drag_Drop() {
			    
			     Actions action = new Actions(web);                                        // action class for the movement 
			     WebElement drag = web.findElement(By.id("dragbox"));
			     WebElement Drop = web.findElement(By.id("dropbox"));
			     action.dragAndDrop (drag,Drop);                                           
			     action.build().perform();                                                 // To perform multiple action at one time
			     web.findElement(By.cssSelector("a")).click();
			 }
			    		
			    		
			    		
			    		
			 public void popup_Window() {  		
			     web.findElement(By.cssSelector("a")).click();
			     String parentWindowHandler = web.getWindowHandle();                       // To store the parent window
                web.findElement(By.cssSelector("a")).click(); 
			     String subWindowHandler = null;
                Set<String> handles = web.getWindowHandles();
			    		    
			     Iterator<String> iterator = handles.iterator();                           // To traverse in different windows
			     while (iterator.hasNext()){
			    	 subWindowHandler = iterator.next();
			    	  }
			     web.switchTo().window(subWindowHandler); 
			     web.findElement(By.id("name")).sendKeys("deepak");
			     web.findElement(By.id("submit")).click();

			     web.switchTo().window(parentWindowHandler); 
			     web.findElement(By.linkText("Proceed")).click(); 
			 }		    
			    		  
			  public void cookie_Handling() {  		    
			      web.findElement(By.cssSelector("a")).click();
				  String Tokenvalue = web.findElement(By.id("token")).getText();            // To get the token value 
				  Tokenvalue = (Tokenvalue.substring(7));                                   // Token value divided into substring
				  Cookie cookie = new Cookie("Token", Tokenvalue);
				  web.manage().addCookie(cookie);                                          // To add the Cookies 
				  web.findElement(By.linkText("Proceed")).click(); 
			    
				  
            }
	        
	         public void exit_browser() {
	        	 web.quit();                                                               // To close the browser
	         }


}


