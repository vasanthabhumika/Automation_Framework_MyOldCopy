package vtiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.LoginPage;

public class CreateOrgWithIndustryUsingGU {

	public static void main(String[] args) throws Throwable{
		
	     
		//Call or create all the object reference for all utilities
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		JavaUtility jUtil = new JavaUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
			
		WebDriver driver = null;
		
//		Step 1:	Read the data from Property file
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");	
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
//		Read the data from Excel file
		String ORGNAME = eUtil.readDataFromExcel("Organizations", 1, 2)+jUtil.getRandomNumber();
		String INDUSTRYTYPE = eUtil.readDataFromExcel("Organizations", 4, 3);
		
//		Step 2: Launch the Browser Run time Polymorphism  - driver
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Invalid Browser name");
		}
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForpageLoad(driver);
		driver.get(URL);
		
		
//		Step 3: Login to App
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	    driver.findElement(By.id("submitButton")).click();
	    
//	    Step 4: Navigate to Organisation Link
	    driver.findElement(By.linkText("Organizations")).click();
	    
//	    Step 5: Click on create organisation Lookup image
	    driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	    
//	    Step 6: Create organisation with mandatory information
	    driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
	    
//	    Step 7: Select 'chemicals' from industry dropdown
	    WebElement dropdown = driver.findElement(By.name("industry"));
	    wUtil.handleDropdown(dropdown, INDUSTRYTYPE);
	    
//	    Step 8: Save
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    
//	    Step 9: Validate
	    String orgText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    if(orgText.contains(ORGNAME)){
	    	System.out.println("PASS");
	    	System.out.println(orgText);
	    }
	    else {
	    	System.out.println("FAIL");
	    }
	    
	    
//	    Step 10: Logout the App
	    WebElement onmouseOver = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    wUtil.mouseHoverAction(driver, onmouseOver);
	    Thread.sleep(2000);
//	    driver.findElement(By.linkText("Sign Out")).click();
	    driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
	    
//	    Step 10: Close the Browser
	    Thread.sleep(2000);    
	    driver.quit();
		
	}

}
