package com.tcw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcw.base.BasePage;

public class ForgotPasswordPage extends BasePage{

	@FindBy(id = "btnForgotPassword")
	WebElement resetPasswordBtn;
	
	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getForgotPasswordText() {
		return resetPasswordBtn.getText();
	}

}
