package com.tcw.pages;

import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcw.base.BasePage;

public class MessagesPage extends BasePage {

	@FindBy(id = "site_name")
	WebElement pageHeading;

	@FindBy(xpath = "//a[@class='add_task_link']")
	WebElement newMessageBtn;

	@FindBy(xpath = "//ul[@class='chosen-choices']")
	WebElement employeeDropDown;

	@FindBy(id = "txt_Subject")
	WebElement subjectTextBox;

	@FindBy(id = "txt_Message")
	WebElement messagesTextBox;

	@FindBy(xpath = "//ul[@class='chosen-results']/li")
	List<WebElement> employeeList;

	@FindBy(xpath = "//button[@type='submit' and contains(text(),'Send')]")
	WebElement sendMessageBtn;

	@FindBy(id = "jSuccess")
	WebElement successMsg;

	public MessagesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waitFor1Sec() {
		synchronized (driver) {
			try {
				driver.wait(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String getPageHeading() {
		return pageHeading.getText();
	}

	public String createANewMessage(Hashtable<String,String> data) {
		newMessageBtn.click();
		waitFor1Sec();
		employeeDropDown.click();
		for (WebElement singleEmp : employeeList) {
			String nameOfTheEmployee = singleEmp.getText();
			if (nameOfTheEmployee.equalsIgnoreCase(data.get("Employee"))) {
				singleEmp.click();
				break;
			}
		}
		subjectTextBox.sendKeys(data.get("Subject"));
		messagesTextBox.sendKeys(data.get("Message"));
		sendMessageBtn.click();
		return successMsg.getText();
	}

}
