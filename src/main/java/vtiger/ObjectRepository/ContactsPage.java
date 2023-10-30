package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
//Declaration
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactLookUpImg;
	
//	initialization
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//	Utilization
	public WebElement getCreateContactLookUpImg() {
		return createContactLookUpImg;
	}
	
//	Business Logic
	
	public void clickOnContactsLookUp() {
		createContactLookUpImg.click();
	}
	
	

	
	
	
	
}
