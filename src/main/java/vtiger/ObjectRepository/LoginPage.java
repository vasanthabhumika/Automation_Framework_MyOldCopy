package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {  //Rule 1: - create a separate pom class for every web page
	
	//Rule 2: Identify the webelements using @FindBy, @FindAll, @FindBys
	
//	Declaration
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
//	@FindBy(id="submitButton")
//	private WebElement submitBtn;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
	private WebElement submitBtn;
	
	
//	Rule 3: Create a constructor to initialize the web elements
	
//	Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

//	Rule 4: Provide getters for accessing the web elements 
	
//	Utilization
	
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}


	public WebElement getPasswordEdt() {
		return passwordEdt;
	}


	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
//I have used the above code in createorgwithIndustryGU in vtiger.genericutilities
	
	
//	Just creating the generic methods according to the need of project requirements and it is 
//	called as test script optimization.
	
//Any project specific libaray or method is called business library	
	
//Rule 5: Trying using Business Logic in code share
	
//	 Provide business library - Framework developers idea
//-  is a generic method created using web elements present only in current page 
	
/**
* This method will Login to application
* @param USERNAME
* @param PASSWORD
*/
public void loginToApp(String USERNAME, String PASSWORD)
{
userNameEdt.sendKeys(USERNAME);
passwordEdt.sendKeys(PASSWORD);
submitBtn.click();
}
}
