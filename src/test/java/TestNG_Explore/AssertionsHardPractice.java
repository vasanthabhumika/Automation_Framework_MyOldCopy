package TestNG_Explore;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsHardPractice {
@Test
	public void practice1() {
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertEquals(false, true);
		System.out.println("Step3");
		System.out.println("Step4");
	}
}

//if (false, false)  --> Then script will not fail
//if (true, true)  --> Then script will not fail

//if (false, true)  ---> Then script will not executed and get failed.
