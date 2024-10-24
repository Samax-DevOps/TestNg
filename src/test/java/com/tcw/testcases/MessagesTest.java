package com.tcw.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.DashboardPage;
import com.tcw.pages.MessagesPage;
import com.tcw.utilities.DataUtil;

public class MessagesTest extends LogInTest {

	DashboardPage dp;
	MessagesPage mp;

	/*
	 * public MessagesTest() { logIn(); dp = new DashboardPage(driver);
	 * dp.hoverOverProfilePic(); dp.hoverOnMessages(); mp =
	 * dp.clickOnViewMessages(); }
	 */
	@Test(priority = 1)
	public void goToMessagesPage() {
		logIn();
		dp = new DashboardPage(driver);
		dp.hoverOverProfilePic();
		dp.hoverOnMessages();
		mp = dp.clickOnViewMessages();
		Assert.assertEquals(mp.getPageHeading(), "Messages45455454");
	}

	//@Test(priority = 2, groups= {"functionality"},dataProviderClass = DataUtil.class, dataProvider = "dp2") // 
	public void createAMessageTest(Hashtable<String,String> data) {
		logIn();
		dp = new DashboardPage(driver);
		dp.hoverOverProfilePic();
		dp.hoverOnMessages();
		mp = dp.clickOnViewMessages();
		String msg = mp.createANewMessage(data);
		Assert.assertEquals(msg, "Information saved successfully.");
	}
}
