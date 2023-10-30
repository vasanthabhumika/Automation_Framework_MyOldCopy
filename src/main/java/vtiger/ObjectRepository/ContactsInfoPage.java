package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
//Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactsHeaderText;
	
//	initialization
	public ContactsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//	Utilization
	public WebElement getContactsHeaderText() {
		return contactsHeaderText;
	}
	
//	Business Library
	
	/**
	 * This method will return the header text
	 * @return
	 */
	public String getContactHeader(){
		return contactsHeaderText.getText();
	}
	
	
}
