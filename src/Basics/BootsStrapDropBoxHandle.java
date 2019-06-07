package Basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootsStrapDropBoxHandle {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.navigate().to("https://www.jquery-az.com/boots/demo.php?ex=6.0_4");
		
		driver.findElement(By.xpath("//button[contains(@class,'dropdown-togg')]")).click();
		
		///html/body/div[2]/table/tbody/tr[2]/td[3]/div/div/ul
		List<WebElement> findElements = driver.findElements(By.xpath("//ul[@class,'dropdown-menu inner']//li//a//"));
		
		System.out.println(findElements.size());
		System.out.println(findElements.get(1));
	}

}
