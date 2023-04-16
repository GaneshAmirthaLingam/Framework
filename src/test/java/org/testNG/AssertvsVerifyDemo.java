package org.testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertvsVerifyDemo {

	/*@Test
	public void assertTest() {
		
		//Hard Assertion
		System.out.println("Before Assertion");
		
		//Assert.assertEquals(true, false);
		Assert.fail();
		
		System.out.println("After Assertion");
	}
	*/
	
	@Test
	public void testVerify() {
		//Soft Assertion
		
		SoftAssert assert1 = new SoftAssert();
		System.out.println("Before Assertion");
		assert1.fail();
		System.out.println("After Assertion");
		
	}
}
