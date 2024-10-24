package com.tcw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcw.base.BasePage;

public class PaymentPage extends BasePage {

	@FindBy(xpath = "//span[@class='sidebar_menu_link' and contains(text(),'Payment')]")
	WebElement paymentLnk;

	@FindBy(xpath = "//div[@id='site_name']//h1")
	WebElement paymentTtl;

	@FindBy(id = "lnkpaymenthistory")
	WebElement paymentHistoryTab;

	@FindBy(xpath = "//div[@id='divGeneratepayroll']/div/div/h2")
	WebElement paymentHistoryText;

	@FindBy(id = "lnkemployerSetup")
	WebElement employerPaymentSetupTab;

	@FindBy(xpath = "(//div[@id='dvPaypalPaymentAccount']//h3)[1]")
	WebElement employerPaymentSetupText;
	

	@FindBy(id = "lnkemployeeSetup")
	WebElement employeePaymentSetupTab;
	
	@FindBy(xpath = "(//div[@id='dvSearchSalAcc']/div/div/h2)[1]")
	WebElement employeePaymentSetupText;


	Actions act;

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String goToPaymentPage() {
		act = new Actions(driver);
		act.moveToElement(paymentLnk).click().build().perform();
		toWait();
		return paymentTtl.getText();
	}

	public String goToPaymentHistoryTab() {
		paymentHistoryTab.click();
		toWait();
		return paymentHistoryText.getText();

	}

	public String goToEmployerPaymentSetupTab() {
		employerPaymentSetupTab.click();
		toWait();
		return employerPaymentSetupText.getText();
		
	}

	public String goToEmployeePaymentSetupTab() {
		employeePaymentSetupTab.click();
		toWait();
		return employeePaymentSetupText.getText();
	}
}
