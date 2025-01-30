package com.tcw.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcw.base.BasePage;

public class SupportPage extends BasePage {

	@FindBy(xpath = "//span[@class='sidebar_menu_link' and contains(text(),'Support')]")
	WebElement supportLnk;

	@FindBy(xpath = "//div[@id='site_name']//h1")
	WebElement supportTtl;

	@FindBy(id = "lifaq")
	WebElement frequentlyAskedQuestionsTab;

	@FindBy(xpath = "(//div[@id='task_accordion']//a[@role='button'])[1]")
	WebElement frequentlyAskedQuestionsText;

	@FindBy(xpath = "//li[@id='lidesktop']/a")
	WebElement desktopAppTab;

	@FindBy(xpath = "//div[@id='support_main']//h3")
	WebElement desktopAppText;

	@FindBy(xpath = "//li[@id='liCalendly']/a")
	WebElement needAssistanceTab;

	@FindBy(xpath = "//*[text()='Time Clock Support']")
	List<WebElement> needAssistanceText;

	Actions act;

	JavascriptExecutor jse;

	public SupportPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String goToSupportPage() {
		act = new Actions(driver);
		act.moveToElement(supportLnk).click().build().perform();
		toWait();
		return supportTtl.getText();
	}

	public String frequentlyAskedQuestion() {
		frequentlyAskedQuestionsTab.click();
		return frequentlyAskedQuestionsText.getText();
	}

	public String desktopApp() {
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", desktopAppTab);
		return desktopAppText.getText();
	}

	public String needAssistance() {
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", needAssistanceTab);
		driver.switchTo().frame("load");
		return needAssistanceText.get(0).getText();
	}

}
