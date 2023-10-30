package TestNG_Explore;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class TestNGPractice {
//Case 1:

//public static void main(String[] args) {
//	@Test
//	public void createContact() {
//		System.out.println("Contact Created");
//	}
//	
//	@Test
//	public void modifyContent() {
//		System.out.println("Contact Modified");
//	}
//	
//	@Test
//	public void deleteContent() {
//		System.out.println("Contact Deleted");
//	}
	
	
//	Case 2:
	
//	@Test(priority = 1)
//	public void createContact() {
//		System.out.println("Contact");
//	}
//	@Test(priority = 0)
//	public void modifyContact() {
//		System.out.println("modify");
//	}
//	@Test(priority = 2)
//	public void deleteContact() {
//		System.out.println("delete");
//	}
	
	
	
//	case 3:
	
//	@Test(invocationCount = 4, priority = 2)
//	public void createContact() {
//		System.out.println("Contact");
//	}
//	@Test(priority = 3)
//	public void modifyContact() {
//		System.out.println("modify");
//	}
//	@Test(priority = 0)
//	public void deleteContact() {
//		System.out.println("delete");
//	}
	
	
//	case 4: 
	
//	@Test(enabled = false)
//	public void createContact() {
//		System.out.println("Contact");
//	}
//	@Test(priority = 3)
//	public void modifyContact() {
//		System.out.println("modify");
//	}
//	@Test(priority = 0)
//	public void deleteContact() {
//		System.out.println("delete");
//	}
	
	
//	Case 5: making the script to fail wantedly inorder to make the script to skip.
	
	@Test
	public void createContact() {
		Assert.fail();
		System.out.println("Contact");      //failed script making this as assert.fail
	}
	@Test(dependsOnMethods = "createContact")
	public void modifyContact() {
		System.out.println("modify");
	}
	@Test
	public void deleteContact() {
		System.out.println("delete");
	}
}


