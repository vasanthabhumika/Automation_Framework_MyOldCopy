package TestNG_Explore;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionSoftPractice {

	@Test
	public void practice1() {
		SoftAssert sa = new SoftAssert();
		System.out.println("Step 1");
		System.out.println("Step 2");
		sa.assertEquals(false, false);
		System.out.println("Step 3");
		System.out.println("Step 4");
	}
}
