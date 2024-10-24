package com.tcw.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.DashboardPage;
import com.tcw.pages.ReimbursementPage;
import com.tcw.utilities.DataUtil;

public class ReimbursementTest extends LogInTest {

	DashboardPage dp;
	ReimbursementPage rp;

	@Test(priority = 1, dataProviderClass = DataUtil.class, dataProvider = "dp2")
	public void addReimbursementTest(Hashtable<String, String> data) {
		logIn();
		dp = new DashboardPage(driver);
		dp.hoverOverProfilePic();
		rp = dp.clickOnMyProfileLink();
		rp.clickOnReimbursementTab();
		rp.clickOnAddTaskBtn();
		String msg = rp.fillReimbursement(data);
		Assert.assertEquals(msg, "Information saved successfully.");
	}

	@Test(priority = 2)
	public void deleteReimbursementTest() {
		logIn();
		dp = new DashboardPage(driver);
		dp.hoverOverProfilePic();
		rp = dp.clickOnMyProfileLink();
		rp.clickOnReimbursementTab();
		String msg = rp.deleteReimbursement();
		Assert.assertTrue(msg.contains("deleted"));

	}
}
