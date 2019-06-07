package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.seleniumeasy.com/test/");
		//maximize window
		driver.manage().window().maximize();
		//1. Link text
		driver.findElement(By.linkText("Input Forms")).click();
		//2. Partial link text
		driver.findElement(By.partialLinkText("Simple Form ")).click();
		//3.ID
		driver.findElement(By.id("user-message")).sendKeys("Sample text");
		//4. Xpath
		driver.findElement(By.xpath("//*[@id=\"get-input\"]/button")).click();
		//5. Css Selector
		String text = driver.findElement(By.cssSelector("#display")).getText();
		System.out.println("Text displayed: "+text);
		
		//6. Name 
		//driver.findElement(By.name("name")).click();
		//7.Class name
		//driver.findElement(By.className("name")).click();
		//8. tagname
		//driver.findElement(By.tagName("td")).getText();
		
		
		

	}

}
