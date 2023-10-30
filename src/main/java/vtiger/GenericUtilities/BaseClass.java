package vtiger.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import schemaorg_apache_xmlbeans.system.sXMLTOOLS.TypeSystemHolder;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

/**
 * This class consists of all basic configuration annotation of testNG
 * @author bhumi
 *
 */
public class BaseClass {
	

	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public WebDriver driver = null;
	
//	For screenshot creating sdriver
	public static WebDriver sdriver;
	@BeforeSuite
	public void bsConfig() {
		System.out.println("------------DB Connection successful--------");
	}
	
	@BeforeTest
	@BeforeClass
	public void bcConfig() throws Throwable {
		
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		
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
		
//		For screenshot creating this method
		sdriver = driver;
		driver.get(URL);
		System.out.println("---------Browser launched --------");
	}
	
	@BeforeMethod
	public void bmConfig() throws Throwable{
		
		String USERNAME = pUtil.readDataFromPropertyFile("username");	
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("------------Login  successful--------");
	}
	
	@AfterMethod
	public void amConfig() throws InterruptedException {
		
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		
		System.out.println("------------Logout successful--------");
	}
	
	@AfterClass
	public void acConfig() {
		driver.quit();
		System.out.println("------------Browser closed--------");
	}
	
	@AfterSuite
	public void asConfig() {
		System.out.println("------------DB Connection successful--------");
	}

}
