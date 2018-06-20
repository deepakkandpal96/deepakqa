import java.util.Iterator;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Tatoc{
	 WebDriver web = new ChromeDriver();
		
	 public static void main(String[] args)  throws InterruptedException{
		 
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\deepakkandpal\\Desktop\\chromedriver_win32\\chromedriver.exe");
		
		  WebDriver web = new ChromeDriver();
		  
		    // grid_Gate
		        web.get("http://10.0.1.86/tatoc/basic/grid/gate");
		        web.manage().window().maximize();
		        web.findElement(By.className("greenbox")).click(); 
			
			 
			// frame_Dungeon 
			    web.switchTo().frame("main");
			    String box1 = web.findElement(By.id("answer")).getAttribute("class");
			    
			    while(true){
			            
			            web.findElement(By.cssSelector("a")).click(); 
			            web.switchTo().frame("child");
			            String box2 = web.findElement(By.id("answer")).getAttribute("class");
			            web.switchTo().parentFrame(); 
			            if(box1.equals(box2))
			            {
			                web.findElements(By.cssSelector("a")).get(1).click(); 
			                break;
			            }
			    }
			            
			            
			 // drag_Drop
			    
			     Actions action = new Actions(web);
			     WebElement drag = web.findElement(By.id("dragbox"));
			     WebElement Drop = web.findElement(By.id("dropbox"));
			     action.dragAndDrop (drag,Drop);
			     action.build().perform();
			    		
			    		
			    		
			    		
			 // popup_Window   		
			     web.findElement(By.cssSelector("a")).click();
			     String parentWindowHandler = web.getWindowHandle(); 
                 web.findElement(By.cssSelector("a")).click(); 
			     String subWindowHandler = null;
                 Set<String> handles = web.getWindowHandles();
			    		    
			     Iterator<String> iterator = handles.iterator(); 
			     while (iterator.hasNext()){
			    	 subWindowHandler = iterator.next();
			    	  }
			     web.switchTo().window(subWindowHandler); 
			     web.findElement(By.id("name")).sendKeys("deepak");
			     web.findElement(By.id("submit")).click();

			     web.switchTo().window(parentWindowHandler); 
			     web.findElements(By.cssSelector("a")).get(1).click(); 
			    		    
			    		  
			  // cookie  		    
			      web.findElement(By.cssSelector("a")).click();
				  String Tokenvalue = web.findElement(By.id("token")).getText();
				  Tokenvalue = (Tokenvalue.substring(7));
				  Cookie cookie = new Cookie("Token", Tokenvalue);
				  web.manage().addCookie(cookie);
				  web.findElements(By.cssSelector("a")).get(1).click(); 
			    
				  
             }
	        
	            }


