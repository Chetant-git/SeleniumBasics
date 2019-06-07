package Basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigations {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/?gws_rd=ssl");
		
		driver.navigate().to("http://jqueryui.com/");
		driver.navigate().back();
		
		Thread.sleep(2000);
		
		//navigate forward
		driver.navigate().forward();

		Thread.sleep(2000);
		
		//navigate backward
		driver.navigate().back();
		
		//refresh
		driver.navigate().refresh();
	}

}
