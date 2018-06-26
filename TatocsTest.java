package Tatocautomation;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TatocsTest {

  String webPath;
  WebDriver web;
  String expectedurl;
  
     @BeforeTest
     public void initialize() {
     webPath=("C:\\\\Users\\\\deepakkandpal\\\\Desktop\\\\chromedriver_win32\\\\chromedriver.exe");
	 System.setProperty("webdriver.chrome.driver",webPath);
     web = new ChromeDriver();
     web.manage().window().maximize();
  }
     
     
     @Test
      public void check_Homepage() 
     {
      System.out.println("launching chrome browser"); 
      web.get("http://10.0.1.86/tatoc");
      }
      
      
      @Test(dependsOnMethods= {"check_Homepage"})
      public void compare_Title()
     {
      String expectedTitle = ("Welcome - T.A.T.O.C");
      String actualTitle = web.getTitle();
      System.out.println(expectedTitle);
      System.out.println(actualTitle);
      Assert.assertEquals(actualTitle, expectedTitle);   
     }
      

      @Test(dependsOnMethods= {"compare_Title"})
      public void basic_Course()
     { 
      Assert.assertEquals(web.findElement(By.linkText("Basic Course")).isDisplayed(),true);
	  web.findElement(By.cssSelector("a")).click();
	  String expectedurl=("http://10.0.1.86/tatoc/basic/grid/gate");
	  Assert.assertEquals(expectedurl, web.getCurrentUrl(), "Not as expected webpage");
     }
  
     
      
      @Test(dependsOnMethods= {"basic_Course"})
      public void grid_gate()
     {
	  Assert.assertEquals(web.findElement(By.className("greenbox")).isDisplayed(),true);
	  web.findElement(By.className("greenbox")).click();
	  String expectedurl="http://10.0.1.86/tatoc/basic/frame/dungeon";
	  Assert.assertEquals(expectedurl, web.getCurrentUrl(), "Not as expected webpage");
     }
  
       
      
      @Test(dependsOnMethods= {"grid_gate"})
       public void frame_Dungeon()
     {
	   web.switchTo().frame("main"); 
	   Assert.assertEquals(web.findElement(By.id("answer")).isDisplayed(),true);
	   String box1 = web.findElement(By.id("answer")).getAttribute("class");        
	   while(true)
	        {
	          web.findElement(By.cssSelector("a")).click(); 
	          web.switchTo().frame("child");
	          String box2 = web.findElement(By.id("answer")).getAttribute("class");
	          web.switchTo().parentFrame(); 
	          if(box1.equals(box2))                                                
	            {
	                web.findElement(By.linkText("Proceed")).click();
	                break;
	            }
	    String expectedurl="http://10.0.1.86/tatoc/basic/drag";
	    Assert.assertEquals(expectedurl, web.getCurrentUrl(),"Not as Expected Webpage");
	        }
	  }
  
  
  
       @Test(dependsOnMethods= {"frame_Dungeon"})
       public void drag_Drop() 
      {
	   Actions action = new Actions(web); 
	   Assert.assertEquals(web.findElement(By.id("dragbox")).isDisplayed(),true);
	   WebElement drag = web.findElement(By.id("dragbox"));
	   Assert.assertEquals(web.findElement(By.id("dropbox")).isDisplayed(),true);
	   WebElement Drop = web.findElement(By.id("dropbox"));
	   action.dragAndDrop (drag,Drop);                                           
	   action.build().perform();                                                 
	   web.findElement(By.cssSelector("a")).click();
	   String expectedurl="http://10.0.1.86/tatoc/basic/windows#";
	   Assert.assertEquals(expectedurl,web.getCurrentUrl(),"Not as Expected webpage");
	  }
  
       
       
       @Test(dependsOnMethods= {"drag_Drop"})
       public void window_Handle() 
      {
	   web.findElement(By.cssSelector("a")).click();
	   String parentWindowHandler = web.getWindowHandle();                      
       web.findElement(By.cssSelector("a")).click(); 
	   String subWindowHandler = null;
       Set<String> handles = web.getWindowHandles();
	    		    
	   Iterator<String> iterator = handles.iterator();                          
	   while (iterator.hasNext())
	        {
	    	 subWindowHandler = iterator.next();
	    	}
	   web.switchTo().window(subWindowHandler); 
	   web.findElement(By.id("name")).sendKeys("deepak");
	   web.findElement(By.id("submit")).click();
       web.switchTo().window(parentWindowHandler); 
	   web.findElement(By.linkText("Proceed")).click();
	   String expectedurl="http://10.0.1.86/tatoc/basic/cookie";
	   Assert.assertEquals(expectedurl,web.getCurrentUrl(),"Not an Expected webpage");
      }
       
     
       
       
       @Test(dependsOnMethods= {"window_Handle"})
      public void cookie_Handle()
     {
	   Assert.assertEquals(web.findElement(By.cssSelector("a")).isDisplayed(),true);  
	   web.findElement(By.cssSelector("a")).click();
	   String Tokenvalue = web.findElement(By.id("token")).getText();            
	   Tokenvalue = (Tokenvalue.substring(7));                                   
	   Cookie cookie = new Cookie("Token", Tokenvalue);
	   web.manage().addCookie(cookie);                                           
	   web.findElement(By.linkText("Proceed")).click();
	   String expectedurl="http://10.0.1.86/tatoc/end";
	   Assert.assertEquals(expectedurl,web.getCurrentUrl(),"Not an Expected webpage");
      }
 }
