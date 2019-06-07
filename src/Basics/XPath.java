package Basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPath {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.seleniumeasy.com/test/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//1. Contains 
		//syntax- *//tag_name[contains(@attribute,'attribute_value')]
		driver.findElement(By.xpath("*//a[contains(text(), 'Input Forms')]")).click();
		
		//Absolute xpath (Not recommended)- //*[@id="navbar-brand-centered"]/ul[1]/li[1]/ul/li[1]/a
		driver.findElement(By.xpath("*//a[contains(text(),'Simple Form Demo')]")).click();
		//ex: id= 3123_value_131; id= 1212_value_45646 
		driver.findElement(By.xpath("*//input[contains(@id,'value')]")).sendKeys("chetan");
		
		
		//2. using the attributed
		//syntax-  *//tag_name[@attribute_name= 'attribute_value')]
		driver.findElement(By.xpath("*//input[@id='user-message']")).sendKeys("Chetan Thimmanna");
		//driver.findElement(By.xpath("*//input[@class='form-control']")).sendKeys("Chetan Thimmanna");
		//driver.findElement(By.xpath("*//input[@name= 'userMessage']")).sendKeys("Chetan Thimmanna");
		
		
		//3. starts-with
		//syntax-  *//tag_name[starts-with(@attribute_name 'attribute_value'))]
		//ex of dynamic id: id= test_123; id= test_645; id= test_433
		driver.findElement(By.xpath("*\\input[starts-with(@id,'test_')]")).sendKeys("test");
		
		
		//4. ends-with
		//syntax-  *//tag_name[ends-with(@attribute_name= 'attribute_value'))]
		//ex of dynamic id: id= 4234_name; id= 23123_name; id= 31231_name
		driver.findElement(By.xpath("*\\input[ends-with(@id,'_name')]")).sendKeys("test");
		
		
		//For Links -- tag will be a --- Use text()
		driver.findElement(By.xpath("*//a[contains(text(), 'Input Forms')]")).click();
	}
}
