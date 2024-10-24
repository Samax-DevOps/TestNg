package com.tcw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcw.base.BasePage;

public class SettingsPage extends BasePage {

	@FindBy(xpath = "//span[@class='sidebar_menu_link' and contains(text(),'Settings')]")
	WebElement settLnk;

	@FindBy(xpath = "//div[@id='site_name']//h1")
	WebElement settTtl;

	@FindBy(xpath = "//a[text()='Payroll and Breaks']")
	WebElement payrollAndBreaksTab;

	@FindBy(xpath = "(//div[@class='title mb0'])[1]/h3")
	WebElement payrollAndBreaksTabText;

	@FindBy(xpath = "//li[@id='liclockin']/a")
	WebElement clockInAndOutSettingsTab;

	@FindBy(xpath = "//div[@id='clock-setTwo']//h3")
	WebElement clockInAndOutSettingsTabText;

	@FindBy(xpath = "//li[@id='liaccountsetting']/a")
	WebElement accountSettingsTab;

	@FindBy(xpath = "(//form[@id='frmAccountSetting']//h3)[1]")
	WebElement accountSettingsTabTabText;

	@FindBy(xpath = "//li[@id='limessagealert']/a")
	WebElement messageAndAlertTab;

	@FindBy(xpath = "(//div[@id='div_MsgAlert']//h3)[1]")
	WebElement messageAndAlertTabText;

	@FindBy(xpath = "//li[@id='lilocation']/a")
	WebElement locationsTab;

	@FindBy(xpath = "//input[@id='txt_searchText']")
	WebElement locationsTabText;

	@FindBy(xpath = "//li[@id='lijobs']/a")
	WebElement jobsTab;

	@FindBy(xpath = "//input[@id='txt_jobSearch']")
	WebElement jobsTabText;

	@FindBy(xpath = "//li[@id='liNotification']/a")
	WebElement notificationsTab;

	@FindBy(xpath = "//label[@for='gbPushNotificationMobileApp']")
	WebElement notificationsTabText;

	@FindBy(xpath = "//a[@id='customfield']")
	WebElement customFieldTab;

	@FindBy(xpath = "//div[@id='custom_field']//div[@class='sel']//h4")
	WebElement customFieldTabText;

	@FindBy(xpath = "//a[@id='tools']")
	WebElement toolsTab;

	@FindBy(xpath = "//div[@id='seetings_tool']//p[1]")
	WebElement toolsTabText;

	@FindBy(xpath = "//a[@id='addons']")
	WebElement addOnsTab;

	@FindBy(xpath = "//div[@id='addon_tool']//h2")
	WebElement addOnsTabText;

	Actions act;

	public SettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String goToSettingsPage() {
		act = new Actions(driver);
		act.moveToElement(settLnk).click().build().perform();
		toWait();
		return settTtl.getText();
	}

	public String payrollAndBreaksVerification() {
		payrollAndBreaksTab.click();
		toWait();
		return payrollAndBreaksTabText.getText();
	}

	public String clockInAndOutSettingsVerification() {
		clockInAndOutSettingsTab.click();
		toWait();
		return clockInAndOutSettingsTabText.getText();
	}

	public String accountSettingsVerification() {
		accountSettingsTab.click();
		toWait();
		return accountSettingsTabTabText.getText();
	}

	public String messageAndAlertVerification() {
		messageAndAlertTab.click();
		toWait();
		return messageAndAlertTabText.getText();
	}

	public boolean locationsVerification() {
		locationsTab.click();
		toWait();
		return locationsTabText.isDisplayed();
	}

	public boolean jobsVerification() {
		jobsTab.click();
		toWait();
		return jobsTabText.isDisplayed();
	}

	public String notificationsVerification() {
		notificationsTab.click();
		toWait();
		return notificationsTabText.getText();
	}

	public String customFieldVerification() {
		customFieldTab.click();
		toWait();
		return customFieldTabText.getText();
	}

	public String toolsVerification() {
		toolsTab.click();
		toWait();
		return toolsTabText.getText();
	}

	public String addOnsVerification() {
		addOnsTab.click();
		toWait();
		return addOnsTabText.getText();
	}
}
