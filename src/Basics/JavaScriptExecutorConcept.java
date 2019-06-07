package Basics;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.io.FileHandler;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws InterruptedException, Exception {

		
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.crmpro.com/index.html");
		
		System.out.println("Before Login "+driver.getTitle());
		driver.findElement(By.name("username")).sendKeys("ChetanT");
		driver.findElement(By.name("password")).sendKeys("qwerasdf1234");
		WebElement submit = driver.findElement(By.xpath("*//input[@type='submit']"));
		Thread.sleep(3000);
		//submit.click();
		
		//Highlight a specific element
		//JavascriptExecutor js= ((JavascriptExecutor) driver);
		
		
		//JavascriptExecutor is a class , we have to cast driver into JavascriptExecutor
		//executeScript-- to execute javascript code
		
		
		//1.Highlight the element
		flash(submit,driver);   
		
		//2.Draw border to the element and take screen shot
		drawBorder(submit,driver); 
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		File screenshot = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshot, new File("D:\\Selenium\\screenshots\\image124.jpg"));
	
		//3. Generate Alert
		//generateAlert(driver, "Alert message-- Issue with login page ");
		
		//4. Click on element by js
		//clickElementByJs(submit, driver);

		// referesh using selenium
		//driver.navigate().refresh();
		
		//5. Refresh browser
		refreshByJS(driver);
		
		//6. Page title
		String pageTitleByJs = PageTitleByJs(driver);
		System.out.println(pageTitleByJs);
		
		
		//7. To get inner text
		String pageInnerText = getPageInnerText(driver);
		System.out.println(pageInnerText);
		
		
		//8. Scroll page down
		//scrollPageDown(driver);
		
		//9. Scroll till element found
		WebElement fgEle = driver.findElement(By.linkText("Forgot Password?"));
		scrollInto(fgEle, driver);
		
	}

	
	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		String bg = element.getCssValue("backgroundColor");
		for(int i=0; i<50; i++) {
			changeColor("rgb(0,200,0)",element,driver);
			changeColor(bg,element,driver);
		}
		
		
	}
	
	
	public static void changeColor(String color,WebElement element, WebDriver driver) {
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",element);
		
		
		  try { Thread.sleep(20); }catch(InterruptedException e) {
		  
		  }
		 
	}
	
	
	
	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border= '3px solid red'", element);
		
		
	}
	
	
	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("alert('"+message+"')");
	}
	
	
	public static void clickElementByJs(WebElement element, WebDriver driver) {
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", element);
		
	}
	
	
	public static void refreshByJS(WebDriver driver) {
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("history.go(0)");
	}
	
	
	public static String PageTitleByJs(WebDriver driver) {
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		String Title = js.executeScript("return document.title;").toString();
		
		return Title;
	}
	
	public static String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		String InnerText = js.executeScript("return document.documentElement.innerText;").toString();
		
		return InnerText;
	}
	
	
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		
		
	}
	
	public static void scrollInto(WebElement element, WebDriver driver) {
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
