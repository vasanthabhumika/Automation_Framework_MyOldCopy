package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{
//Declaration
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement orgLookUpImg;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="search_text")
	private WebElement orgSearchTextField;
	
	@FindBy(name="search")
	private WebElement orgSearchBtn;
	
	
//	initialization
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//	Utilization
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrgLookUpImg() {
		return orgLookUpImg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getOrgSearchTextField() {
		return orgSearchTextField;
	}

	public WebElement getOrgSearchBtn() {
		return orgSearchBtn;
	}
	
	
	
//	Business Logic
	/**
	 * This method will create contact with Mandatory fields
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME) {
		lastNameEdt.sendKeys(LASTNAME);
		saveBtn.click();
	}
	
	/**
	 * This method will create Contact using Organization
	 * @param LASTNAME
	 * @param ORGNAME
	 * @param driver
	 */
	
	public void createNewContact(String LASTNAME, String ORGNAME, WebDriver driver) {
		lastNameEdt.sendKeys(LASTNAME);
		orgLookUpImg.click();
		switchToWindow(driver, "Accounts");
		orgSearchTextField.sendKeys(ORGNAME);
		orgSearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();  //dynamic xpath using driver.findElement
		switchToWindow(driver, "Contacts");
		saveBtn.click();
		
	}
	
	

	
	

}
