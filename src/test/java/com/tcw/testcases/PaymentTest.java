package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.PaymentPage;

public class PaymentTest extends LogInTest{
	
	PaymentPage pp;
	
	@Test(priority = 1)
	public void goToPayementPageTest() {
		logIn();
		pp = new PaymentPage(driver);
		String msg = pp.goToPaymentPage();
		Assert.assertEquals(msg, "Payment");
	}
	
	@Test(priority = 2)
	public void goToPaymentHistoryTest() {
		logIn();
		pp = new PaymentPage(driver);
		pp.goToPaymentPage();
		String msg = pp.goToPaymentHistoryTab();
		Assert.assertTrue(msg.contains("HISTORY"));
	}
	
	@Test(priority = 3)
	public void goToEmployerPaymentSetupTab() {
		logIn();
		pp = new PaymentPage(driver);
		pp.goToPaymentPage();
		String msg = pp.goToEmployerPaymentSetupTab();
		Assert.assertTrue(msg.contains("ACCOUNT"));
	}
	
	@Test(priority = 4)
	public void goToEmployeePaymentSetupTab() {
		logIn();
		pp = new PaymentPage(driver);
		pp.goToPaymentPage();
		String msg = pp.goToEmployeePaymentSetupTab();
		Assert.assertTrue(msg.contains("SALARY"));
	}
}
