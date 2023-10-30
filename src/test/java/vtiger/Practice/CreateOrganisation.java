package vtiger.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class CreateOrganisation {

	public static void main(String args[]) throws Throwable{
		
		//Step 1: create all required objects
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		
		WebDriver driver = null;
		
		
//		Step 2: Read data from propertyfile
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");	
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
//		Read the data from Excel file
		String ORGNAME = eUtil.readDataFromExcel("Organizations", 1, 2)+jUtil.getRandomNumber();
		
		
//		Step 3: Samething polymorphism - Launching the browser
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
		
		
//		Step 4: Login to App
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	    driver.findElement(By.id("submitButton")).click();
	    
//	    Step 5: Navigate to Organisation Link
	    driver.findElement(By.linkText("Organizations")).click();
	    
//	    Step 6: Click on create organisation Lookup image
	    driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	    
//	    Step 7: Create organisation with mandatory information
	    driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
	    
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
	    WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    wUtil.mouseHoverAction(driver, ele);
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("Sign Out")).click();
//	    driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
	    System.out.println("logout successfully");
	    
//	    Step 10: Close the Browser
//	    Thread.sleep(2000);    
//	    driver.quit();
	}
}
