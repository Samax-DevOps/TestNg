package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.DashboardPage;
import com.tcw.pages.QuickClockInPage;

public class QuickClockInTest extends LogInTest {

	DashboardPage dashp;
	QuickClockInPage qcip;

	@Test(priority = 1)
	public void goToQuickClockInPageTest() {
		logIn();
		dashp = new DashboardPage(driver);
		dashp.hoverOverProfilePic();
		// String pWindow = TestUtil.getParentWindowHandleString();
		qcip = dashp.clickOnQuickClockInLink();
		qcip.getQuickClockInWindow();
		String msg = qcip.getTextFromQuickClockInPage();
		Assert.assertTrue(msg.contains("PIN"));

	}
}
