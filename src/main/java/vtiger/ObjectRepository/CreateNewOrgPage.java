package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrgPage extends WebDriverUtility{

//	declarations
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryType;
	
	@FindBy(name="accountype")
	private WebElement typeDropdown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
//	initializations
	public CreateNewOrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//	Utilizations
	public WebElement getOrgName() {
		return orgNameEdt;
	}

	public WebElement getIndustryType() {
		return industryType;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getTypeDropdown() {
		return typeDropdown;
	}


//	Business Libraray  oops concept used here is inheritance - hierarchical and method overloading
/**
 * This method will create org using mandatory fields
 * @param ORGNAME
 */
	public void createNewOrganization(String ORGNAME) {
		orgNameEdt.sendKeys(ORGNAME);
		saveBtn.click();
	}
	
	/**
	 * This method will create org by handling industry dropdown
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	
	public void createNewOrganization(String ORGNAME, String INDUSTRY) {
		orgNameEdt.sendKeys(ORGNAME);
		handleDropdown(industryType, INDUSTRY);  //to handlethutility webdriverutility we extend the 
		saveBtn.click();
	}
	

	/**
	 * This method will create org by handling industry dropdown and type drop down
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	
	public void createNewOrganization(String ORGNAME, String INDUSTRY, String TYPE) {
		orgNameEdt.sendKeys(ORGNAME);
		handleDropdown(industryType, INDUSTRY);  //to handlethutility webdriverutility we extend the 
		handleDropdown(typeDropdown, TYPE);
		saveBtn.click();
	}
	
}
