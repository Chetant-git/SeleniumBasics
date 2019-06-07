package Basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderSelectByJS {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.navigate().to("https://book.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement frmDate = driver.findElement(By.id("date_picker_id_1"));
		String date= "29-05-2019";
		
		selectDateByJs(driver,frmDate,date);

	}

	
	
	public static void selectDateByJs(WebDriver driver, WebElement element, String date) {
		
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+date+"')",element );
	}
}
