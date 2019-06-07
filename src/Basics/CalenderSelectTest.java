package Basics;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalenderSelectTest {

	public static void main(String[] args) throws InterruptedException {
		
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
		
		String date1 = "31-September-2017";
		String dateArr[] = date1.split("-");
		String day= dateArr[0];
		String month= dateArr[1];
		String year= dateArr[2];
		
		Select monthBox = new Select(driver.findElement(By.name("slctMonth")));
		monthBox.selectByVisibleText("September");
		
		Select yearBox = new Select(driver.findElement(By.name("slctYear")));
		yearBox.selectByVisibleText("2017");
		
		
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[3]
		
		String beforeXpath = "//*[@id=\"crmcalendar\"]/table/tbody/tr[2]/td/table/tbody/tr[";
		String afterXpath = "]/td[";
		
		boolean flag= false;
		String calVal= null;
		for(int row=2; row<=7; row++) {
			
			for(int col=1; col<=7; col++) {
				
				
				try {
					calVal = driver.findElement(By.xpath(beforeXpath+row+afterXpath+col+"]")).getText();
					
					
				}catch(NoSuchElementException e) {
					System.out.println("Please enter a correct date value");
					flag= false;
					break;
				}

				System.out.println(calVal);
				if(calVal.equals(day)) {
					driver.findElement(By.xpath(beforeXpath+row+afterXpath+col+"]")).click();
					flag= true;
					break;
				}
				
			}
			
			
			if(flag) {
				break;
			}
		}
		

	}

}
