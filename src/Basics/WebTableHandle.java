package Basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader1;

public class WebTableHandle {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
		
		//Dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[3]/td[1]
		//*[@id="customers"]/tbody/tr[4]/td[1]
		
		String beforeXpath_comp= "//*[@id=\"customers\"]/tbody/tr[";
		String afterXpath_comp= "]/td[1]";
		String beforeXpath_cont= "//*[@id=\"customers\"]/tbody/tr[";
		String afterXpath_cont= "]/td[2]";
		
		WebElement table = driver.findElement(By.xpath("*//table[@id='customers']"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int rowCount = rows.size();
		System.out.println(rowCount);
		
		Xls_Reader1 reader= new Xls_Reader1("C:\\Users\\chetanth\\eclipse-workspace\\SB_Project\\src\\com\\testdata\\TestSheet.xlsx");
		
		if(!reader.isSheetExist("TableData")) {
			reader.addSheet("TableData");
			reader.addColumn("TableData", "Company");
			reader.addColumn("TableData", "Contact");
		}
		
		
		
		for(int i=2; i<=rowCount; i++) {
			String CompanyValue = driver.findElement(By.xpath(beforeXpath_comp+i+afterXpath_comp)).getText();
			String ContactValue = driver.findElement(By.xpath(beforeXpath_cont+i+afterXpath_cont)).getText();
			System.out.println(CompanyValue);
			System.out.println(ContactValue);
		
			
			reader.setCellData("TableData", "Company", i, CompanyValue);
			reader.setCellData("TableData", "Contact", i, ContactValue);
		}
		

		
				
		
		//*[@id="customers"]/tbody/tr[2]/td[2]
		//*[@id="customers"]/tbody/tr[3]/td[2]
		
		
		
	}

}
