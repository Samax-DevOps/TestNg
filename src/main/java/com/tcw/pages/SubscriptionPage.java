package com.tcw.pages;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcw.base.BasePage;

public class SubscriptionPage extends BasePage {

	@FindBy(xpath = "//div/a[@id='a_DeactivateAccount']")
	WebElement deactivateAccountText;

	@FindBy(xpath = "//img[@alt='logoWizard']")
	WebElement logo;

	Set<String> windows;
	Set<String> singleWindow;

	public SubscriptionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean goToSubscriptionPage() {
		boolean fg;
		String dummy = null;
		windows = driver.getWindowHandles();
		singleWindow = new HashSet<String>();
		singleWindow.add(DashboardPage.dashboardWindow);
		for (String aa : windows) {
			fg = singleWindow.add(aa);
			if (fg == true) {
				dummy = aa;
				break;
			}
		}

		driver.switchTo().window(dummy);

		return logo.isDisplayed();

	}
}
