package Basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HTMLUnitDriverConcept {

	public static void main(String[] args) throws Exception {

		
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		
		// Headless browsers
		//1. HtmlUnitDriver -- java
		//2. PhantomJS -- javascript
		
		//WebDriver driver= new ChromeDriver();
		
		//HtmlUnitDriver is not available as part of selenium 3.0
		//HtmlUnitDriver --- to use this concept download HtmlUnitDriver JAR file
		
		//Advantages
		//1. Testing is happening behind the scene
		//2. execution of test cases is very fast --- Improved performance
		//3. Also called ghost driver (Headless browser)
		
		//disadvantage
		//1. Not suitable for action class--- like mouse movement. double click, dragdrop
		WebDriver driver= new HtmlUnitDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.crmpro.com/index.html");
		
		System.out.println("Before Login "+driver.getTitle());
		driver.findElement(By.name("username")).sendKeys("ChetanT");
		driver.findElement(By.name("password")).sendKeys("qwerasdf1234");
		WebElement submit = driver.findElement(By.xpath("*//input[@type='submit']"));
		
		Thread.sleep(3000);
		submit.click();
		
		//clickOn(driver,submit,40);
		
		
		System.out.println("After Login "+driver.getTitle());

	}
	
	public static void clickOn(WebDriver driver, WebElement locator, int timeout) {
		
		new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}

}
