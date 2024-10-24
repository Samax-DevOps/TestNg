package com.tcw.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tcw.base.BasePage;

public class PayrollPage extends BasePage {

	@FindBy(xpath = "//span[@class='sidebar_menu_link' and contains(text(),'Payroll')]")
	WebElement payrollLnk;

	@FindBy(xpath = "//div[@id='site_name']//h1")
	WebElement payrollTtl;

	@FindBy(xpath = "//select[@id='ddlweekly']")
	WebElement dateDd;

	@FindBy(xpath = "//select[@id='ddlweekly']/option")
	List<WebElement> listOfDatesForPayroll;

	@FindBy(id = "aGeneratePayroll")
	WebElement generatePayrollBtn;

	@FindBy(xpath = "//div[@id='jSuccess' and contains(text(),'generated')]")
	WebElement payrollGeneratedMsg;

	@FindBy(xpath = "//div[@id='jError' and contains(text(),'already')]")
	WebElement payrollErrorMsg;

	@FindBy(xpath = "//table[contains(@class,'tc-datatable')]/tbody/tr")
	List<WebElement> row1;

	@FindBy(xpath = "//table[contains(@class,'tc-datatable')]/tbody/tr[1]/td")
	List<WebElement> col1;

	@FindBy(xpath = "(//td//a[@id='aBtndelete'])[1]")
	WebElement deleteBtn;

	@FindBy(xpath = "(//a[@id='aYesConfirm'])[1]")
	WebElement deleteConfirmBtn;

	@FindBy(id = "jSuccess")
	WebElement deleteMessage;

	Actions act;

	public PayrollPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Landing on the Payroll Page
	public String goToPayrollPage() {
		act = new Actions(driver);
		act.moveToElement(payrollLnk).click().build().perform();
		toWait();
		return payrollTtl.getText();
	}

	// Generating the Payroll
	public String GeneratePayroll() {
		act = new Actions(driver);
		act.moveToElement(dateDd).click().build().perform();
		listOfDatesForPayroll.get(1).click();
		act.moveToElement(generatePayrollBtn).click().build().perform();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
			wait.until(ExpectedConditions.visibilityOf(payrollGeneratedMsg));
			return payrollGeneratedMsg.getText();
		} catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			return payrollErrorMsg.getText();
		}

	}

	// Printing all the Generated Payroll
	public void fetchAllPayrollDetails() {

		for (int i = 1; i <= row1.size(); i++) {

			for (int k = 1; k <= col1.size() - 1; k++) {
				String st = driver
						.findElement(
								By.xpath("//table[contains(@class,'tc-datatable')]/tbody/tr[" + i + "]/td[" + k + "]"))
						.getText();
				System.out.print(st + " ");

			}
			System.out.println();
		}

	}

	public String deletePayroll() {
		act = new Actions(driver);
		act.moveToElement(deleteBtn).click().build().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(deleteConfirmBtn)).click();
		return deleteMessage.getAttribute("textContent");
	}

}
