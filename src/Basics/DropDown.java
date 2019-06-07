package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) {

		
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.seleniumeasy.com/test/");
		//maximize window
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Input Forms")).click();
		driver.findElement(By.linkText("Select Dropdown List")).click();
		
		WebElement DropDown = driver.findElement(By.id("select-demo"));
		Select select = new Select(DropDown);
		select.selectByVisibleText("Tuesday");
		
		

	}

}
