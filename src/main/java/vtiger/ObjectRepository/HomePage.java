package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{

//	Declarations - dropDown,window,frames,textFields,popUps
	@FindBy(linkText = "Organizations")
	private WebElement organizationLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText = "Products")
	private WebElement productsLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLnk;
	
	
	
//	Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}


	
//	Utilization
	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}
	
	
//	Business Logic
	/**
	 * This method will logout the application
	 * @param driver
	 * @throws InterruptedException 
	 */
	
	
//	in the below code we need to mouseover on the element using webelements since in pom classes we mainly 
//	focus on webelements we kindly check on the webdriverutility since webelements work in webdriverutility
	
	public void logoutOfApp(WebDriver driver) throws InterruptedException {
		mouseHoverAction(driver, administratorImg);
		Thread.sleep(2000);
		signoutLnk.click();
	}
	
	public void organizationClick() {
		organizationLnk.click();
	}
	
	public void contactsClick() {
		contactsLnk.click();
	}

	
	
}
