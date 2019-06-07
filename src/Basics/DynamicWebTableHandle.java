package Basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableHandle {

	public static void main(String[] args) throws Exception {
		
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
		
		//*[@id="vContactsForm"]/table/tbody/tr[5]/td[2]/a
		//*[@id="vContactsForm"]/table/tbody/tr[6]/td[2]/a
		//*[@id="vContactsForm"]/table/tbody/tr[7]/td[2]/a
		
		
		
		//Method 1 for dynamic table handling
		/*
		 * String before_xpath= "//*[@id=\"vContactsForm\"]/table/tbody/tr["; String
		 * after_xpath= "]/td[2]/a";
		 * 
		 * for(int i=5; i<=9; i++) {
		 * 
		 * String name = driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
		 * System.out.println(name); 
		 * if(name.contains("Mahesha KN")) {
		 * driver.findElement(By.xpath(before_xpath+i+"]/td[1]/input")).click(); } }
		 * 
		 */
		
		
		//Method 2 for dynamic table handling
		
		//keywords to remember: Parent, Preceding-sibling (Previous item), preceding(previous tr), following-sibling(next item), following(next tr)
		
		driver.findElement(By.xpath("//a[contains(text(),'Mahesha KN')]/parent::td/preceding-sibling::td/input[@name= \"contact_id\"]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'sai Kumar')]/parent::td/preceding-sibling::td/input[@name= \"contact_id\"]")).click();
		
		

	}

}
