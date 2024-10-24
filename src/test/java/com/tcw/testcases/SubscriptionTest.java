package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.DashboardPage;
import com.tcw.pages.SubscriptionPage;

public class SubscriptionTest extends LogInTest {

	DashboardPage dp;
	SubscriptionPage ssp;

	@Test(priority = 1)
	public void goToSubscriptionPageTest() {
		logIn();
		dp = new DashboardPage(driver);
		ssp = dp.clickOnSubscriptionInLink();
		boolean msg = ssp.goToSubscriptionPage();
		Assert.assertTrue(msg);
	}
}
