package com.tcw.pages;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tcw.base.BasePage;

public class TimesheetPage extends BasePage {

	@FindBy(xpath = "//h2[text()='Timesheet search']")
	public WebElement tsSrchText;

	@FindBy(id = "add_task_link_two")
	public WebElement addTimeRecordBtn;

	@FindBy(id = "ddltmpopupEmployeeList")
	WebElement empDrpDwn;

	@FindBy(id = "txtStartDateClock")
	WebElement clockInDt;

	@FindBy(id = "txtEndDateClock")
	WebElement clockOutDt;

	@FindBy(id = "txtstartTimeClock")
	WebElement clockInTime;

	@FindBy(id = "txtEndTimeClock")
	WebElement clockOutTime;

	@FindBy(id = "ddlLocationClocked")
	WebElement addTimeLocation;

	@FindBy(id = "ddlJobClocked")
	WebElement addTimeJob;

	@FindBy(id = "txtNoteClocked")
	WebElement addTimeNotes;

	@FindBy(id = "btntimesheetpopupSave")
	WebElement addTimeRecordSaveBtn;

	@FindBy(id = "jSuccess")
	WebElement successMsg;

	@FindBy(id = "jError")
	WebElement errorMsg;

	@FindBy(xpath = "//*[text()='Future timesheets are not allowed.']")
	WebElement errorMsg1;

	@FindBy(id = "modalTimeRecord")
	WebElement tsOverlapMsg;

	@FindBy(xpath = "//a[@data-target='#Add_timeOff']")
	public WebElement addTimeOffBtn;

	@FindBy(id = "ddlAbsenceEmployeeList")
	public WebElement absenceEmpDrpDwn;

	@FindBy(id = "ddlAbsneceType")
	public WebElement absenceTypeDrpDwn;

	@FindBy(id = "txtstartdateAbsence")
	public WebElement absenceStDt;

	@FindBy(id = "txtenddateAbsence")
	public WebElement absenceEndDt;

	@FindBy(id = "txtStartTime")
	public WebElement absenceStTime;

	@FindBy(id = "txtEndTime")
	public WebElement absenceEndTime;

	@FindBy(id = "ddlLocationClockedAbsence")
	public WebElement absenceLocation;

	@FindBy(id = "ddlJobClockedAbsence")
	public WebElement absenceJob;

	@FindBy(id = "txtaAbsenceNote")
	public WebElement absenceNotes;

	@FindBy(id = "btnabsencepopupSave")
	public WebElement addAbsencesBtn;

	@FindBy(xpath = "//ul[@class='chosen-choices']")
	public WebElement mainEmployeeDropDown;

	@FindBy(xpath = "//ul[@class='chosen-results']/li")
	public List<WebElement> mainEmployeeList;

	@FindBy(id = "ddlDays")
	public WebElement selectDayDropDown;

	@FindBy(id = "txtStartDate")
	public WebElement mainStartDate;

	@FindBy(id = "txtEndDate")
	public WebElement mainEndDate;

	@FindBy(xpath = "//a[@class='btn' and text()='Search']")
	public WebElement mainSearchBtn;

	@FindBy(xpath = "//a[@class='ed' and text()='Edit']")
	public WebElement editBtn;

	@FindBy(xpath = "//a[@class='del' and text()='Delete']")
	public WebElement deleteBtn;

	@FindBy(id = "aYesConfirm")
	public WebElement confirmDeleteBtn;

	Actions act;
	WebDriverWait wait;

	public TimesheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Landing on the Timesheet Page
	public String tsPageHit() {
		toWait();
		return tsSrchText.getText();
	}

	// Adding the Timesheet
	public String addTimeRecord(Hashtable<String, String> data) {
		act = new Actions(driver);
		act.moveToElement(addTimeRecordBtn).click().build().perform();

		Select selectEmpDrpDwn = new Select(empDrpDwn);
		// System.out.println(data.get("emp"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(empDrpDwn));
		selectEmpDrpDwn.selectByVisibleText(data.get("emp"));
		clockInDt.clear();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		clockInDt.sendKeys(data.get("clockInDt"));
		clockOutDt.clear();
		clockOutDt.sendKeys(data.get("clockOutDt"));
		clockInTime.clear();
		clockInTime.sendKeys(data.get("clockInTime"));
		clockOutTime.clear();
		clockOutTime.sendKeys(data.get("clockOutTime"));

		try {
			Select selectAddTimeLocation = new Select(addTimeLocation);
			selectAddTimeLocation.selectByVisibleText(data.get("addTimeLocation"));
		} catch (NoSuchElementException p) {

		}
		try {
			Select selectAddTimeJob = new Select(addTimeJob);
			selectAddTimeJob.selectByVisibleText(data.get("addTimeJob"));
		} catch (NoSuchElementException o) {

		}
		addTimeNotes.sendKeys(data.get("addTimeNotes"));
		addTimeRecordSaveBtn.click();
		try {

			String msg = successMsg.getText();
			return msg;

		} catch (NoSuchElementException e) {
			try {
				String msg = tsOverlapMsg.getText();
				return msg;
			} catch (NoSuchElementException i) {
				return "";
			}
		}

	}

	// Adding the Absence
	public String addTimeOff(Hashtable<String, String> data) {
		act = new Actions(driver);
		act.moveToElement(addTimeOffBtn).click().build().perform();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select selectEmpDrpDwn = new Select(absenceEmpDrpDwn);
		selectEmpDrpDwn.selectByVisibleText(data.get("emp"));
		Select selectAbsenceTypeDrpDwn = new Select(absenceTypeDrpDwn);
		selectAbsenceTypeDrpDwn.selectByVisibleText(data.get("absenceType"));
		absenceStDt.clear();
		// absenceStDt.sendKeys(data.get("absenceStDt"));
		String dateFormat = driver.findElement(By.id("hdnSession_ClientDateFormat")).getAttribute("value");
		// absenceStDt.sendKeys(data.get("absenceStDt"));
		if (dateFormat.equalsIgnoreCase("Day/Month/Year")) {
			absenceStDt.sendKeys(TimesheetPage.getStartAndEndDate());
			absenceEndDt.clear();
			// absenceEndDt.sendKeys(data.get("absenceEndDt"));
			absenceEndDt.sendKeys(TimesheetPage.getStartAndEndDate());
			absenceStTime.clear();
		} else {
			absenceStDt.sendKeys(TimesheetPage.getStartAndEndDateMMDDYY());
			absenceEndDt.clear();
			// absenceEndDt.sendKeys(data.get("absenceEndDt"));
			absenceEndDt.sendKeys(TimesheetPage.getStartAndEndDateMMDDYY());
			absenceStTime.clear();
		}
		// absenceStTime.sendKeys(data.get("absenceStTime"));
		absenceStTime.sendKeys(TimesheetPage.getStartTime());
		absenceEndTime.clear();
		// absenceEndTime.sendKeys(data.get("absenceEndTime"));
		absenceEndTime.sendKeys(TimesheetPage.getEndTime());
		try {
			Select selectAbsenceLocation = new Select(absenceLocation);
			selectAbsenceLocation.selectByVisibleText(data.get("absenceLocation"));
		} catch (NoSuchElementException e) {

		}
		try {
			Select selectAbsenceJob = new Select(absenceJob);
			selectAbsenceJob.selectByVisibleText(data.get("absenceJob"));
		} catch (NoSuchElementException p) {

		}
		absenceNotes.sendKeys(data.get("absenceNotes"));
		addAbsencesBtn.click();
		try {
			String msg = successMsg.getText();
			return msg;

		} catch (NoSuchElementException e) {
			try {
				String msg = tsOverlapMsg.getText();
				return msg;

			} catch (NoSuchElementException i) {
				return "";

			}
		}

	}

	public static String getStartAndEndDate() {

		// To select the date
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		Instant now = Instant.now(); // current date
		Instant before = now.minus(Duration.ofDays(1));
		Date dateBefore = Date.from(before);
		String dateToCompare = formatter.format(dateBefore);
		return dateToCompare;

	}

	public static String getStartAndEndDateMMDDYY() {

		// To select the date
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

		Instant now = Instant.now(); // current date
		Instant before = now.minus(Duration.ofDays(1));
		Date dateBefore = Date.from(before);
		String dateToCompare = formatter.format(dateBefore);
		return dateToCompare;

	}

	public static String getStartTime() {

		// To select time
		SimpleDateFormat formatter1 = new SimpleDateFormat("hh:mm a");
		Instant now = Instant.now();
		Instant before1 = now.minus(Duration.ofHours(3)).minus(Duration.ofMinutes(5));
		Date dateBefore1 = Date.from(before1);
		// System.out.println(dateBefore1);
		String dd1 = formatter1.format(dateBefore1);
		return dd1;
	}

	public static String getEndTime() {
		SimpleDateFormat formatter1 = new SimpleDateFormat("hh:mm a");
		Instant now = Instant.now();
		Instant before2 = now.minus(Duration.ofHours(3)).minus(Duration.ofMinutes(3));
		Date dateBefore2 = Date.from(before2);
		String dd2 = formatter1.format(dateBefore2);
		return dd2;
	}

	// Adding Timesheet using the current date and Time and not the excel file
	public String addTimeRecordCurrentDate(Hashtable<String, String> data) {
		act = new Actions(driver);
		act.moveToElement(addTimeRecordBtn).click().build().perform();

		Select selectEmpDrpDwn = new Select(empDrpDwn);
		// System.out.println(data.get("emp"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(empDrpDwn));
		selectEmpDrpDwn.selectByVisibleText(data.get("emp"));
		clockInDt.clear();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String dateFormat = driver.findElement(By.id("hdnSession_ClientDateFormat")).getAttribute("value");
		// clockInDt.sendKeys(data.get("clockInDt"));
		if (dateFormat.equalsIgnoreCase("Day/Month/Year")) {
			clockInDt.sendKeys(TimesheetPage.getStartAndEndDate());
			clockOutDt.clear();
			// clockOutDt.sendKeys(data.get("clockOutDt"));
			clockOutDt.sendKeys(TimesheetPage.getStartAndEndDate());
		} else {
			clockInDt.sendKeys(TimesheetPage.getStartAndEndDateMMDDYY());
			clockOutDt.clear();
			// clockOutDt.sendKeys(data.get("clockOutDt"));
			clockOutDt.sendKeys(TimesheetPage.getStartAndEndDateMMDDYY());
		}
		synchronized (driver) {
			try {
				driver.wait(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		clockInTime.clear();
		clockInTime.sendKeys(TimesheetPage.getStartTime());
		clockOutTime.clear();
		clockOutTime.sendKeys(TimesheetPage.getEndTime());

		try {
			Select selectAddTimeLocation = new Select(addTimeLocation);
			selectAddTimeLocation.selectByVisibleText(data.get("addTimeLocation"));
		} catch (NoSuchElementException p) {

		}
		try {
			Select selectAddTimeJob = new Select(addTimeJob);
			selectAddTimeJob.selectByVisibleText(data.get("addTimeJob"));
		} catch (NoSuchElementException o) {

		}
		addTimeNotes.sendKeys(data.get("addTimeNotes"));
		addTimeRecordSaveBtn.click();
		try {

			String msg = successMsg.getText();
			return msg;

		} catch (NoSuchElementException e) {
			try {
				String msg = tsOverlapMsg.getText();
				return msg;
			} catch (NoSuchElementException i) {
				return "";
			}
		}

	}

	public void getTheEmpForDeleteEdit(Hashtable<String, String> data) {
		act = new Actions(driver);
		act.moveToElement(mainEmployeeDropDown).click().build().perform();
		for (WebElement e : mainEmployeeList) {
			String eName = e.getText();
			System.out.println(eName);
			if (eName.equalsIgnoreCase(data.get("emp"))) {
				e.click();
				break;
			}

		}

		Select selectDayCustom = new Select(selectDayDropDown);
		selectDayCustom.selectByVisibleText("Custom");
		mainStartDate.clear();
		String dateFormat = driver.findElement(By.id("hdnSession_ClientDateFormat")).getAttribute("value");
		if (dateFormat.equalsIgnoreCase("Day/Month/Year")) {
			mainStartDate.sendKeys(TimesheetPage.getStartAndEndDate());
			mainEndDate.clear();
			mainEndDate.sendKeys(TimesheetPage.getStartAndEndDate());
		} else {
			mainStartDate.sendKeys(TimesheetPage.getStartAndEndDateMMDDYY());
			mainEndDate.clear();
			mainEndDate.sendKeys(TimesheetPage.getStartAndEndDateMMDDYY());
		}
		mainSearchBtn.click();
		toWait();
	}

	// Edit Time Sheet
	public String editTimesheet() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", editBtn);
		editBtn.click();

		synchronized (driver) {
			try {
				driver.wait(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		clockOutTime.clear();
		clockOutTime.sendKeys(TimesheetPage.getEndTime());
		addTimeNotes.sendKeys("Edited");
		addTimeRecordSaveBtn.click();
		return successMsg.getAttribute("textContent");

	}

	// Delete Timesheet
	public String deleteTimesheet() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", deleteBtn);
		deleteBtn.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteBtn)).click();
		return successMsg.getAttribute("textContent");
	}
}
