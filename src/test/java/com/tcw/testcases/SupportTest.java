package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.SupportPage;

public class SupportTest extends LogInTest {

	SupportPage sp;

	@Test(priority = 1)
	public void landingOnSupportPage() {
		logIn();
		sp = new SupportPage(driver);
		String supportTtl1 = sp.goToSupportPage();
		Assert.assertEquals(supportTtl1, "Support");
	}

	@Test(priority = 2)
	public void frequentlyAskedQuestionsTest() {
		logIn();
		sp = new SupportPage(driver);
		sp.goToSupportPage();
		String msg = sp.frequentlyAskedQuestion();
		Assert.assertTrue(msg.contains("BROWSER"));
	}

	@Test(priority = 3)
	public void desktopAppTest() {
		logIn();
		sp = new SupportPage(driver);
		sp.goToSupportPage();
		String msg = sp.desktopApp();
		Assert.assertTrue(msg.contains("Desktop"));
	}

	@Test(priority = 4)
	public void needAssistanceTest() {
		logIn();
		sp = new SupportPage(driver);
		sp.goToSupportPage();
		String msg = sp.needAssistance();
		Assert.assertTrue(msg.contains("Support"));
	}

}
