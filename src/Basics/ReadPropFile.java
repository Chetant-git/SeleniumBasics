package Basics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ReadPropFile {

	static WebDriver driver;
	public static void main(String[] args) throws Exception {
		
		Properties prop= new Properties();
		FileInputStream fi= new FileInputStream("C:\\Users\\chetanth\\eclipse-workspace\\SB_Project\\src\\Basics\\config.properties");
		prop.load(fi);
		
		System.out.println("Value of name: "+ prop.getProperty("name")); //tom
		System.out.println("Value of age: "+ prop.getProperty("age")); //25
		System.out.println("Value of name: "+ prop.getProperty("Name")); //null
		
		
		String url = prop.getProperty("url");
		System.out.println(url);
		String browser = prop.getProperty("browser");
		System.out.println(browser);
		
		
		if(browser.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
			 driver = new ChromeDriver();
		}else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver.exe");
			 driver = new FirefoxDriver();
		} else if(browser.equals("InternetExplorer")) {
			System.setProperty("webdriver.ie.driver", "D:\\Drivers\\ie.exe");
			 driver = new InternetExplorerDriver();
		}
		
		String firstname= prop.getProperty("firstname");
		String lastname= prop.getProperty("Lastname");
		String email= prop.getProperty("email");
		
		driver.get(url);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		
		driver.findElement(By.linkText(prop.getProperty("signup_lt"))).click();
		driver.findElement(By.xpath(prop.getProperty("firstname_xpath"))).sendKeys(firstname);
		driver.findElement(By.xpath(prop.getProperty("lastname_xpath"))).sendKeys(lastname);
		driver.findElement(By.name(prop.getProperty("email_name"))).sendKeys(email);
		
	}

}
