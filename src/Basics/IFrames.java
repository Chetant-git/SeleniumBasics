package Basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrames {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.navigate().to("https://www.crmpro.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//login
		driver.findElement(By.name("username")).sendKeys("ChetanT");
		driver.findElement(By.name("password")).sendKeys("Qwerasdf1234");
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input")).click();
		
		Thread.sleep(3000);
		
		//frame
		driver.switchTo().frame("mainpanel");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[4]/a")).click();
		
		
	}
}
