package Basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibilityTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.navigate().to("https://www.crmpro.com/register/");
		
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		//1. isDisplayed--- Applicable for all the elements (Displays true if displayed else false)
		
		boolean submitDisp = driver.findElement(By.name("submitButton")).isDisplayed();
		System.out.println(submitDisp);
		
		
		//2. isEnabled --- mainly used for buttons
		boolean submitEnabled = driver.findElement(By.name("submitButton")).isEnabled();
		System.out.println(submitEnabled);
		
		//select i agree 
		driver.findElement(By.name("agreeTerms")).click();
		boolean submitEnabled1 = driver.findElement(By.name("submitButton")).isEnabled();
		System.out.println(submitEnabled1);
		
		
		//3. isSelected---Only applicable for checkboxes, radiobuttons and drop downs
		boolean selected = driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println(selected);
		
		//de-select checkbox
		driver.findElement(By.name("agreeTerms")).click();
		boolean selected1 = driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println(selected1);
		
	}
}
