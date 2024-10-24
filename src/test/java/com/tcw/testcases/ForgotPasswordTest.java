package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.ForgotPasswordPage;
import com.tcw.pages.LoginPage;

public class ForgotPasswordTest extends LogInTest{

	LoginPage lp;
	ForgotPasswordPage fpp;
	
	@Test(priority = 1)
	public void verifyForgotPasswordPageTest() {
		lp = new LoginPage(driver);
		lp.clickOnForgotPasswordLink();
		fpp = new ForgotPasswordPage(driver);
		String msg = fpp.getForgotPasswordText();
		Assert.assertTrue(msg.contains("Reset"));
	}
	
}
