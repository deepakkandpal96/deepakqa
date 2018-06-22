package Tatocautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tatocsmain {
	WebDriver web = new ChromeDriver();
	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\deepakkandpal\\Desktop\\chromedriver_win32\\chromedriver.exe");
		Tatocautomation.Tatocs a1 = new Tatocautomation.Tatocs();
		
		a1.set_Up();
		a1.grid_Gate();
		a1.frame_Dungeon();
		a1.drag_Drop();
		a1.popup_Window();
		a1.cookie_Handling();
		a1.exit_browser();
	}

}
