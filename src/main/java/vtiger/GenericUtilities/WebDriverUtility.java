package vtiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of all generic methods related to web driver actions
 * @author bhumi
 *
 */
public class WebDriverUtility {
	/**
	 * This method will maximize the window 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {   //parameterising the webdriver is best option than declaring globally
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will open the window in full screen mode
	 * @param driver
	 */
	public void fullScreenWindow(WebDriver driver) {
		driver.manage().window().fullscreen();
	}
	
	/**
	 * This method will wait for page to load
	 * @param driver
	 */
	
	
//	09-08-23
	
	public void waitForpageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	/**
	 * This method will wait for particular element to be Visible in the DOM 
	 * @param driver
	 * @param element
	 */
	
	public void waitForElementTobeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	/**
	 * This method will wait for particular element to be Clickable in the DOM 
	 * @param driver
	 * @param element
	 */
	
	public void waitForElementTobeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	/**
	 * This method will handle the drop down using index
	 * @param driver
	 * @param element
	 */
	
	public void handleDropdown(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);	
	}
	
	
	/**
	 * This method will handle the drop down using value
	 * @param driver
	 * @param element
	 */
	
	public void handleDropdown(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);	
	}
	
	/**
	 * This method will handle the drop down using visibleText
	 * @param driver
	 * @param element
	 */
	
	public void handleDropdown(String text, WebElement element) {  //if method names are same atleast the order of parameters must be different - method overloading
		Select sel = new Select(element);
		sel.selectByVisibleText(text);	
	}
	
	/**
	 * This method will perform mouse hovering action on a web element 
	 * @param driver
     * @param element
	 */
	
	public void mouseHoverAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	
	/**
	 * This method will move the cursor by offset and click on web page
	 * @param driver
	 * @param x
	 * @param y
	 */
	
	public void moveTheCursorAndClick(WebDriver driver, int x, int y) {
		Actions act = new Actions(driver);
		act.moveByOffset(x, y).perform();
	}
	
	
	/**
	 * This method will perform right click anywhere on the web page
	 * @param driver
	 */
	
	public void rightClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will perform right click anywhere on particular web element
	 * @param driver
	 * @param element
	 */
	
	public void rightClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will perform double click anywhere on the web page
	 * @param driver
	 */
	
	public void doubleClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method will perform double click on a particular web element
	 * @param driver
	 */
	
	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform drag and drop operation
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void dragAndDropAction(WebDriver driver, WebElement src, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, target).perform();
	}
	
	
//	Scroll Actions...
	/**
	 * This method will scroll down for 500 units
	 * @param driver
	 */
	
	public void scrollAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500);","");
	}
	
	/**
	 * This method will scroll down until a particular web element
	 * @param driver
	 * @param element
	 */
	
	public void scrollAction(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
	}
	
	/**
	 * This method will accept the alert popup
	 * @param driver
	 */
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	
	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	
//	10-08-23
	
//	Concept called frame handling
	// Eg: for method overloading - handling frames
	
	/**
	 * This method will handle Frame using index
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will handle Frame using name or ID
	 * @param driver
	 * @param nameOrID
	 */
	public void handleFrame(WebDriver driver, String nameOrID)
	{
		driver.switchTo().frame(nameOrID);	
	}
	
	/**
	 * This method will handle Frame using frame element
	 * @param driver
	 * @param element
	 */
	public void handleFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	
//	WindowHandling
	/**
	 * This method will switch to immediate parent frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch to default page
	 * @param driver
	 */
	public void switchToDefaultContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method will help to switch the control from one window to another
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle)
	{
		//Step 1: Capture all the window IDs
		Set<String> allWinIDs = driver.getWindowHandles();
		
		//Step 2: Navigate through each window 
		for(String id:allWinIDs)
		{
			//Step 3: Switch To each and capture the title
			String actTitle = driver.switchTo().window(id).getTitle();
			
			//Step 4: compare the title with required
			if(actTitle.contains(partialWindowTitle)) //true - 
			{
				break;
			}
		}
	}
	
	
	/**
	 * This method will take screenshot and return the dst path
	 * @param driver
	 * @param screenshotName
	 * @return path
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver, String screenshotName) throws IOException
	{

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);  // temporary location
		File dst = new File(".\\Screenshots\\"+screenshotName+".png");  //just adding a new file location or folder structure
		Files.copy(src, dst);
		
		return dst.getAbsolutePath(); //used for extent reporting
		
	}
	
//	.\\means double forward slash folder path
	
//	A dependency called commons.io for screenshot add in pom.xml developed by Apache Poi and the need of
//	this is to copy, paste the file locations.
	
	
//	Test-1- Ad Selenium - batch Code Aug 10, 4:02 PM
//	Name 
	
	
	
	
	
}
