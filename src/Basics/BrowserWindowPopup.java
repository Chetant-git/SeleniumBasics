package Basics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowPopup {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.navigate().to("http://www.popuptest.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Come & Go Test")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		Iterator<String> iterator = windowHandles.iterator();
		String ParentWindowID = iterator.next();
		System.out.println("ParentWindowID= "+ParentWindowID);
		
		String ChildWindowHandle = iterator.next();
		System.out.println("ChildWindowHandle= "+ParentWindowID);
		
		//switch to child
		driver.switchTo().window(ChildWindowHandle);
		
		System.out.println("Child Title "+driver.getTitle());
		
		driver.close();
		
		//switch to parent
		driver.switchTo().window(ParentWindowID);
		System.out.println("Parent Title "+driver.getTitle());
		
	}
}
