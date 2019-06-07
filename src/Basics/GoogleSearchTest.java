package Basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	public static void main(String[] args) {

		
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.navigate().to("http://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("testing");
		
		List<WebElement> listEle = driver.findElements(By.xpath("//ul[@role= 'listbox']//li/descendant::div[@class='sbl1']"));
		
		int size = listEle.size();
		System.out.println(size);
		
		for(int i=0; i<size;i++) {
			WebElement Search = listEle.get(i);
			if(Search.getText().contains("testing techniques")) {
				Search.click();
				break;
			}
		}

		
		

	}

}
