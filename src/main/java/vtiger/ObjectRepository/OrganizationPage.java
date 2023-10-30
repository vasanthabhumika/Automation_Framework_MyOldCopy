package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

//	Declarations
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrgLookUpImg;
	
//	initialization
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//	Utilization
	public WebElement getOrgTitle() {
		return createOrgLookUpImg;
	}
	
//Business Logic
	
	public void clickOnOrganizationLookUpImg() {
		createOrgLookUpImg.click();
	}
	
}
