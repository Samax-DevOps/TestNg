package com.tcw.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcw.base.BasePage;

public class QuickClockInPage extends BasePage {

	@FindBy(xpath = "//div[@class='row']//h3")
	WebElement pinText;

	public QuickClockInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	Set<String> allWindowHandlesWithQuickClockIn;

	public void getQuickClockInWindow() {
		allWindowHandlesWithQuickClockIn = driver.getWindowHandles();
		for (String e : allWindowHandlesWithQuickClockIn) {
			if (e != DashboardPage.dashboardWindow) {
				driver.switchTo().window(e);
			}
		}

	}

	public String getTextFromQuickClockInPage() {
		return pinText.getText();
	}
}
