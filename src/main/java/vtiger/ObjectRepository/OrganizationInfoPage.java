package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

//	Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgHeaderTxt;    //the text is dynamic becuase text changes and account no changes
//	creating a dynamic xpath is not possible
	
//	initialization
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//	Utilization

	public String getOrgHeaderTxt() {
		return orgHeaderTxt;
	}
	
	
//	Business lib
	
	/**
	 * This method will capture headet text and return it to caller
	 * @return
	 */
	public String getOrgheader() {
		return orgHeaderTxt.getText();
	}
	
	
	
}

