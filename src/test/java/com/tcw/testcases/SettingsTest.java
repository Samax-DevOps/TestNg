package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.SettingsPage;

public class SettingsTest extends LogInTest {

	SettingsPage sp;

	@Test(priority = 1)
	public void landingOnSettingsPage() {
		logIn();
		sp = new SettingsPage(driver);
		String settTtl1 = sp.goToSettingsPage();
		Assert.assertEquals(settTtl1, "Settings");
	}

	@Test(priority = 2)
	public void payrollAndBreaksTabTest() {
		logIn();
		sp = new SettingsPage(driver);
		sp.goToSettingsPage();
		String msg = sp.payrollAndBreaksVerification();
		Assert.assertTrue(msg.contains("pay"));
	}

	@Test(priority = 3)
	public void clockInAndOutSettingsTabTest() {
		logIn();
		sp = new SettingsPage(driver);
		sp.goToSettingsPage();
		String msg = sp.clockInAndOutSettingsVerification();
		Assert.assertTrue(msg.contains("time"));
	}

	@Test(priority = 4)
	public void accountSettingsTabTest() {
		logIn();
		sp = new SettingsPage(driver);
		sp.goToSettingsPage();
		String msg = sp.accountSettingsVerification();
		Assert.assertTrue(msg.contains("Address"));
	}

	@Test(priority = 5)
	public void messageAndAlertTabTest() {
		logIn();
		sp = new SettingsPage(driver);
		sp.goToSettingsPage();
		String msg = sp.messageAndAlertVerification();
		Assert.assertTrue(msg.contains("Message"));
	}

	@Test(priority = 6)
	public void locationsTabTest() {
		logIn();
		sp = new SettingsPage(driver);
		sp.goToSettingsPage();
		Assert.assertTrue(sp.locationsVerification());
	}

	@Test(priority = 7)
	public void jobsTabTest() {
		logIn();
		sp = new SettingsPage(driver);
		sp.goToSettingsPage();
		Assert.assertTrue(sp.jobsVerification());
	}

	@Test(priority = 8)
	public void notificationsTabTest() {
		logIn();
		sp = new SettingsPage(driver);
		sp.goToSettingsPage();
		String msg = sp.notificationsVerification();
		Assert.assertTrue(msg.contains("Wizard"));

	}

	@Test(priority = 9)
	public void customFieldTabTest() {
		logIn();
		sp = new SettingsPage(driver);
		sp.goToSettingsPage();
		String msg = sp.customFieldVerification();
		Assert.assertTrue(msg.contains("custom"));

	}

	@Test(priority = 9)
	public void toolsTabTest() {
		logIn();
		sp = new SettingsPage(driver);
		sp.goToSettingsPage();
		String msg = sp.toolsVerification();
		Assert.assertTrue(msg.contains("website"));

	}

	@Test(priority = 10)
	public void addOnsTabTest() {
		logIn();
		sp = new SettingsPage(driver);
		sp.goToSettingsPage();
		String msg = sp.addOnsVerification();
		Assert.assertTrue(msg.contains("Featured"));

	}
}
