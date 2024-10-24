package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.DashboardPage;
import com.tcw.pages.LoginPage;
import com.tcw.pages.PendingTimesheetRequestsPage;

public class DashboardTest extends LogInTest {

	DashboardPage dashp;
	PendingTimesheetRequestsPage ptr;
	LoginPage lp;

	// @Test(priority = 1)

	@Test(priority = 2)
	public void goToPendingTimesheetReqTest() {
		logIn();
		// System.out.println("hello error 1");
		ptr = new PendingTimesheetRequestsPage(driver);
		// System.out.println("hello error 2");
		// System.out.println(driver);
		dashp = new DashboardPage(driver);
		ptr = dashp.goToPendingTimesheetReq();
		// System.out.println(driver);
		String tsReqSrchTtl1 = ptr.tsReqSrchTtl.getText();
		Assert.assertEquals(tsReqSrchTtl1, "TIMESHEETS REQUEST SEARCH");
	}

	// @Test(priority = 3)
	public void clockInClockOut() {
		logIn();
		dashp = new DashboardPage(driver);
		String txt = dashp.clockingInAndOut();
		Assert.assertTrue(txt.contains("Clock"));

	}

	@Test(priority = 4)
	public void logOutTest() {
		logIn();
		dashp = new DashboardPage(driver);
		dashp.hoverOverProfilePic();
		lp = dashp.clickOnLogOutBtn();
		Assert.assertTrue(lp.isLoginBtnDisplayed());

	}

	@Test(priority = 5)
	public void myTimeCradExportTest() {
		logIn();
		dashp = new DashboardPage(driver);
		dashp.clickOnMyTimeCardExportIcon();
		dashp.selectMyTimeCardExportFormat();
		boolean b = dashp.clickOnMyTimeCardExportBtn();
		Assert.assertTrue(b);
	}

	@Test(priority = 6)
	public void birthdaysAlertTest() {
		logIn();
		dashp = new DashboardPage(driver);
		String msg = dashp.birthdayAlertVerification();
		Assert.assertTrue(msg.contains("BIRTHDAY"));
	}

}
