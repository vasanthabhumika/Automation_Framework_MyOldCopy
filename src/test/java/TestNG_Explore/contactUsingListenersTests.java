package TestNG_Explore;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.ContactsInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.HomePage;



@Listeners(vtiger.GenericUtilities.ListenersImplementationClass.class)
public class contactUsingListenersTests extends BaseClass{

	@Test(groups = {"SmokeSuite", "RegressionSuite"} )
	public void createContact() throws Throwable {
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);
		
		
//		Step 1: Click on contacts link
		HomePage hp = new HomePage(driver);
		hp.contactsClick();
		
//		Step 2: Click on create contact look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnContactsLookUp();
		
//		Step 3: create contact with organization
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME);
		
		
//		Step 4: validation
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println(contactHeader);
		
	}
	
	@Test
	public void demo() {
		System.out.println("demo");
	}
}
