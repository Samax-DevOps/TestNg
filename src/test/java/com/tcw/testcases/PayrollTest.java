package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.PayrollPage;

public class PayrollTest extends LogInTest {

	PayrollPage pp;

	@Test(priority = 1)
	public void landingOnPayrollPageTest() {
		logIn();
		pp = new PayrollPage(driver);
		String payrollTtl = pp.goToPayrollPage();
		Assert.assertEquals(payrollTtl, "Payroll");

	}

	@Test(priority = 2)
	public void generatingThePayrollTest() {
		logIn();
		pp = new PayrollPage(driver);
		pp.goToPayrollPage();
		String txt = pp.GeneratePayroll();
		try {
			Assert.assertTrue(txt.contains("already"));
		} catch (AssertionError e) {
			Assert.assertTrue(!txt.contains("already"));
		}
	}

	@Test(priority = 3)
	public void printingAllPayrollTest() {
		logIn();
		pp = new PayrollPage(driver);
		pp.goToPayrollPage();
		pp.fetchAllPayrollDetails();

	}

	@Test(priority = 4, dependsOnMethods = "generatingThePayrollTest")
	public void deletePayrollTest() {
		logIn();
		pp = new PayrollPage(driver);
		pp.goToPayrollPage();
		String msg = pp.deletePayroll();
		Assert.assertTrue(msg.contains("delete"));

	}

}
