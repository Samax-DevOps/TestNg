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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tcw.base.BasePage;

public class ReportsPage extends BasePage {

	@FindBy(xpath = "//span[@class='sidebar_menu_link' and contains(text(),'Reports')]")
	WebElement reportsLnk;

	@FindBy(xpath = "//div[@id='site_name']//h1")
	WebElement reportsTtl;

	@FindBy(xpath = "//button[contains(text(),'View Report')]")
	WebElement viewReportBtn;

	@FindBy(xpath = "(//div[text()='Employee Name'])[1]")
	WebElement tsEmpNameTxt;

	@FindBy(xpath = "(//div[text()='Employee'])[1]")
	WebElement tsEmpNameTxt2;

	@FindBy(xpath = "(//div[text()='Shift Date'])[1]")
	WebElement tsEmpNameTxt3;

	@FindBy(xpath = "//span[text()='Shift Location']")
	WebElement tsEmpNameTxt4;
	
	@FindBy(xpath = "(//div[text()='Name'])[1]")
	WebElement tsEmpNameTxt5;

	@FindBy(id = "IframeheaderSource")
	WebElement frameId;

	@FindBy(id = "Timesheet_IsStandard")
	WebElement detailedTimesheetToggle;

	@FindBy(id = "PTOBanks")
	WebElement ptoBankTab;

	@FindBy(id = "ptoBankReport")
	WebElement ptoViewReportBtn;

	@FindBy(id = "ContactBlock")
	WebElement empContactListTab;

	@FindBy(xpath = "//a[@type='submit']")
	WebElement empContactListViewReportBtn;

	@FindBy(id = "Payroll")
	WebElement payrollTab;

	@FindBy(xpath = "(//a[@type='submit'])[2]")
	WebElement payrollViewReportBtn;

	@FindBy(id = "TardyPercentage")
	WebElement tardyPercentageTab;

	@FindBy(xpath = "//a[contains(@onclick,'ViewReportTardyPercentage')]")
	WebElement tardyPercentageViewReportBtn;

	@FindBy(id = "Reimburse")
	WebElement reimbursementTab;

	@FindBy(xpath = "//a[contains(@onclick,'ViewReimbursementReport')]")
	WebElement reimbursementViewReportBtn;

	@FindBy(id = "ScheduleDetail")
	WebElement scheduleDetailedTab;

	@FindBy(xpath = "//a[contains(@onclick,'SchedulesDetailedReport')]")
	WebElement scheduleDetailedViewReportBtn;

	@FindBy(id = "MonthlySchedule")
	WebElement monthlyScheduleTab;

	@FindBy(xpath = "//a[contains(@onclick,'MonthlySchedule')]")
	WebElement monthlyScheduleViewReportBtn;

	@FindBy(id = "TimeSheetHistory")
	WebElement historicalReportTab;

	@FindBy(xpath = "//button[contains(@onclick,'TimesheetHistoryReport')]")
	WebElement historicalReportViewReportBtn;

	@FindBy(id = "YearDDL")
	WebElement historicalSelectYearDropDown;
	
	@FindBy(id = "PrePayroll_WeeklyID")
	WebElement prePayrollSelectWeekDropDown;
	
	@FindBy(id = "PrePayroll")
	WebElement prePayrollTab;
	
	@FindBy(xpath = "//a[contains(@onclick,'GeneratePayroll')]")
	WebElement prePayrollViewReportBtn;

	By tsEmpNameTxt_By = By.xpath("(//div[text()='Employee Name'])[1]");

	By tsEmpNameTxt2_By = By.xpath("(//div[text()='Employee'])[1]");

	By tsEmpNameTxt3_By = By.xpath("(//div[text()='Shift Date'])[1]");

	By tsEmpNameTxt4_By = By.xpath("//span[text()='Shift Location']");
	
	By tsEmpNameTxt5_By = By.xpath("(//div[text()='Name'])[1]");

	Actions act;

	WebDriverWait wait;

	public ReportsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Implicit wait changes
	public void waitForReport() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	// Landing on the Time sheet page
	public String goToReportsPage() {
		act = new Actions(driver);
		act.moveToElement(reportsLnk).click().build().perform();
		toWait();
		act.moveToElement(reportsTtl).build().perform();
		return reportsTtl.getText();
	}

	// Standard TimeSheet
	public String genStdTimesheet() {
		act = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		act.moveToElement(viewReportBtn).click().build().perform();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divLoading")));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
		// driver.switchTo().frame(frameId);

		// wait.until(ExpectedConditions.visibilityOf(tsEmpNameTxt));
		wait.until(ExpectedConditions.presenceOfElementLocated(tsEmpNameTxt_By));
		act.moveToElement(tsEmpNameTxt).build().perform();
		return tsEmpNameTxt.getText();

	}

	// Detailed Timesheet
	public String genDtdTimesheet() {
		act = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		act.moveToElement(detailedTimesheetToggle).click().build().perform();
		act.moveToElement(viewReportBtn).click().build().perform();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divLoading")));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
		// driver.switchTo().frame(frameId);

		// wait.until(ExpectedConditions.visibilityOf(tsEmpNameTxt));
		wait.until(ExpectedConditions.presenceOfElementLocated(tsEmpNameTxt_By));
		act.moveToElement(tsEmpNameTxt).build().perform();
		return tsEmpNameTxt.getText();

	}

	// Pto Banks
	public String genPTOBanks() {
//		act = new Actions(driver);
//		wait = new WebDriverWait(driver,Duration.ofSeconds(15));
//		act.moveToElement(ptoBankTab).click().build().perform();
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divLoading")));
//		act.moveToElement(ptoViewReportBtn).click().build().perform();
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
//		wait.until(ExpectedConditions.presenceOfElementLocated(tsEmpNameTxt_By));
//		act.moveToElement(tsEmpNameTxt).perform();
//		return tsEmpNameTxt.getText();
		return gettingTheReports(ptoBankTab, ptoViewReportBtn);
	}

	// Emp Contact List
	public String genEmpContactList() {
//		act = new Actions(driver);
//		wait = new WebDriverWait(driver,Duration.ofSeconds(15));
//		act.moveToElement(empContactListTab).click().build().perform();
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divLoading")));
//		act.moveToElement(empContactListViewReportBtn).click().build().perform();
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
//		wait.until(ExpectedConditions.presenceOfElementLocated(tsEmpNameTxt_By));
//		act.moveToElement(tsEmpNameTxt).perform();
//		return tsEmpNameTxt.getText();
		return gettingTheReports(empContactListTab, empContactListViewReportBtn);
	}

	public String generatePayroll() {
		return gettingTheReports(payrollTab, payrollViewReportBtn);
	}

	public String generateTardyPercentage() {
		return gettingTheReports(tardyPercentageTab, payrollViewReportBtn);
	}

	public String generateReimbursement() {
		return gettingTheReports2(reimbursementTab, reimbursementViewReportBtn);
	}

	public String generateScheduledDetailed() {
		return gettingTheReports3(scheduleDetailedTab, scheduleDetailedViewReportBtn);
	}

	public String generateMonthlySchedule() {
		return gettingTheReports4(monthlyScheduleTab, monthlyScheduleViewReportBtn);
	}

	public String generateHistoricalReport() {
		return gettingTheReports5(historicalReportTab, historicalReportViewReportBtn);
	}
	
	public String generatePrePayrollReport() {
		return gettingTheReports6(prePayrollTab, prePayrollViewReportBtn);
	}

	public String gettingTheReports(WebElement targetReport, WebElement viewBtn) {
//		act = new Actions(driver);
//		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//		act.moveToElement(targetReport).click().build().perform();
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divLoading")));
		moveToAndClickTargetedReport(targetReport);
		act.moveToElement(viewBtn).click().build().perform();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
		wait.until(ExpectedConditions.presenceOfElementLocated(tsEmpNameTxt_By));
		act.moveToElement(tsEmpNameTxt).build().perform();
		return tsEmpNameTxt.getText();
	}

	public String gettingTheReports2(WebElement targetReport, WebElement viewBtn) {
//		act = new Actions(driver);
//		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//		act.moveToElement(targetReport).click().build().perform();
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divLoading")));
		moveToAndClickTargetedReport(targetReport);
		act.moveToElement(viewBtn).click().build().perform();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
		wait.until(ExpectedConditions.presenceOfElementLocated(tsEmpNameTxt2_By));
		act.moveToElement(tsEmpNameTxt2).build().perform();
		return tsEmpNameTxt2.getText();
	}

	public String gettingTheReports3(WebElement targetReport, WebElement viewBtn) {
//		act = new Actions(driver);
//		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//		act.moveToElement(targetReport).click().build().perform();
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divLoading")));
		moveToAndClickTargetedReport(targetReport);
		act.moveToElement(viewBtn).click().build().perform();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
		wait.until(ExpectedConditions.presenceOfElementLocated(tsEmpNameTxt3_By));
		act.moveToElement(tsEmpNameTxt3).build().perform();
		return tsEmpNameTxt3.getText();
	}

	public String gettingTheReports4(WebElement targetReport, WebElement viewBtn) {
//		act = new Actions(driver);
//		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//		act.moveToElement(targetReport).click().build().perform();
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divLoading")));
		moveToAndClickTargetedReport(targetReport);
		act.moveToElement(viewBtn).click().build().perform();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
		wait.until(ExpectedConditions.presenceOfElementLocated(tsEmpNameTxt4_By));
		act.moveToElement(tsEmpNameTxt4).build().perform();
		return tsEmpNameTxt4.getText();
	}

	public String gettingTheReports5(WebElement targetReport, WebElement viewBtn) {
//		act = new Actions(driver);
//		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//		act.moveToElement(targetReport).click().build().perform();
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divLoading")));
		moveToAndClickTargetedReport(targetReport);
		Select se = new Select(historicalSelectYearDropDown);
		List<WebElement> e = se.getOptions();
		int lastIndex = e.size() - 2;
		se.selectByIndex(lastIndex);
		act.moveToElement(viewBtn).click().build().perform();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
		wait.until(ExpectedConditions.presenceOfElementLocated(tsEmpNameTxt_By));
		act.moveToElement(tsEmpNameTxt).build().perform();
		return tsEmpNameTxt.getText();
	}

	public String gettingTheReports6(WebElement targetReport, WebElement viewBtn) {
//		act = new Actions(driver);
//		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//		act.moveToElement(targetReport).click().build().perform();
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divLoading")));
		moveToAndClickTargetedReport(targetReport);
		Select se = new Select(prePayrollSelectWeekDropDown);
		se.selectByIndex(3);
		act.moveToElement(viewBtn).click().build().perform();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
		wait.until(ExpectedConditions.presenceOfElementLocated(tsEmpNameTxt5_By));
		act.moveToElement(tsEmpNameTxt5).build().perform();
		return tsEmpNameTxt5.getText();
	}
	
	public void moveToAndClickTargetedReport(WebElement targetReport) {
		act = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		act.moveToElement(targetReport).click().build().perform();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divLoading")));
	}
}
