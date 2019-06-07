package Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		
		//1. Firefox driver
		//selenium v- 3.14  // Firefox v-66  // gecko driver v-0.24(works)
		//System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		
		//2. Chrome Driver
		//selenium v- 3.14  // chrome v-74
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		
		//3.Safari driver
		//WebDriver driver= new SafariDriver();
		
		//4. Internet Explorer driver
		//System.setProperty("webdriver.internet.driver", "D:\\Drivers\\chromedriver.exe");
		//WebDriver driver= new InternetExplorerDriver();
		
		driver.get("https://www.google.co.in/");
		String title = driver.getTitle();
		System.out.println("Title: "+title);
		
		//String comparision
		if(title.equals("Google")) {
			System.out.println("Correct title");
		}else {
			System.out.println("Incorrect title");
		}
			
		
		System.out.println("URL: "+driver.getCurrentUrl());
		//System.out.println("Page source: "+driver.getPageSource());
		
		driver.quit(); //Closes all the browsers
		driver.close();//Closes current open (window) browser

			
	}

}
