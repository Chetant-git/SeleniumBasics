package Basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardEvents {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.navigate().to("https://www.seleniumeasy.com/test/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Input Forms")).click();
		
		driver.findElement(By.partialLinkText("Simple Form ")).click();
		
		Actions action = new Actions(driver);
		WebElement input = driver.findElement(By.id("user-message"));
		
		//keyboard event
		action.click(input).sendKeys(Keys.SHIFT).sendKeys("chetan").build().perform();
		
		//Context click(right click)
		action.contextClick(input).build().perform();
		action.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
		
		
		
		
	}
}
