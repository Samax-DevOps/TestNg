package com.tcw.pages;

import java.util.Hashtable;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tcw.base.BasePage;

public class ReimbursementPage extends BasePage {

	@FindBy(partialLinkText = "REIMBURSEMENT")
	WebElement reimbursementTab;

	@FindBy(id = "add_task_link")
	WebElement addTaskBtn;

	@FindBy(id = "ddlReimbursementEmployee")
	WebElement employeeDropDown;

	@FindBy(id = "ddlReimbursementExpense")
	WebElement expenseTypeDropDown;

	@FindBy(id = "txtAddReimbursementAmount")
	WebElement amountTextBox;

	@FindBy(id = "txtReimbursementNotes")
	WebElement notesTextBox;

	@FindBy(id = "fileUploadReceipt")
	WebElement uploadReceiptBtn;

	@FindBy(id = "btnAddAddReimbursementList")
	WebElement saveReimbursementBtn;

	@FindBy(id = "jSuccess")
	WebElement successMsg;

	@FindBy(id = "ddlUser")
	WebElement deleteEmployeeDropDown;

	@FindBy(id = "btnSearchReimbursement")
	WebElement searchBtn;

	@FindBy(id = "btnDeleteReimbursement")
	WebElement deleteBtn;

	@FindBy(xpath = "(//a[@id='aYesConfirm'])[1]")
	WebElement confirmBtn;

	public ReimbursementPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickOnReimbursementTab() {
		reimbursementTab.click();
		toWait();
	}

	public void clickOnAddTaskBtn() {
		addTaskBtn.click();/*
		synchronized (driver) {
			try {
				driver.wait(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	String projectPath = System.getProperty("user.dir");

	public String fillReimbursement(Hashtable<String, String> data) {
		Select selectEmployee = new Select(employeeDropDown);
		selectEmployee.selectByVisibleText(data.get("Employee"));
		Select expenseType = new Select(expenseTypeDropDown);
		expenseType.selectByVisibleText(data.get("Expense"));
		amountTextBox.sendKeys(data.get("Amount"));
		notesTextBox.sendKeys(data.get("Notes"));
		try {
			uploadReceiptBtn.sendKeys(projectPath + "\\src\\test\\resources\\pics\\photo_upload1.png");
			System.out.println("file uploded");
			Thread.sleep(2000);
		} catch (Throwable e) {
			System.out.println("file not uploded");

		}
		saveReimbursementBtn.click();

		return successMsg.getText();

	}

	public String deleteReimbursement() {

		Select empDropDown = new Select(deleteEmployeeDropDown);
		empDropDown.selectByVisibleText("All Employees");
		searchBtn.click();
		toWait();
		deleteBtn.click();
		toWait();
		confirmBtn.click();
		return successMsg.getAttribute("textContent");
	}

}
