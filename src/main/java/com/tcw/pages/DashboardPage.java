package com.tcw.pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tcw.base.BasePage;
import com.tcw.utilities.TestUtil;

public class DashboardPage extends BasePage {

	@FindBy(id = "add_task_link")
	public WebElement addTaskBtn;

	@FindBy(xpath = "//a[@id='btn_saveTask']//following-sibling::a")
	public WebElement taskCloseBtn;

	@FindBy(xpath = "//div[contains(text(),'Pending Timesheet Requests')]")
	public WebElement pendTsRqLink;

	@FindBy(xpath = "//div[contains(text(),'Possible Clock In Errors')]")
	public WebElement possClockInErrLink;

	@FindBy(xpath = "//*[text()='Shift Switch Requests']")
	public WebElement shiftSwitchReqLink;

	@FindBy(xpath = "//*[text()='Pending Absence Requests']")
	public WebElement penAbsReqLink;

	@FindBy(xpath = "//div[contains(text(),'Timesheets To Verify')]")
	public WebElement tsToVerifyLink;

	@FindBy(xpath = "//div[contains(text(),'Reimbursement Requests')]")
	public WebElement reimbReqLink;

	@FindBy(xpath = "//div[contains(text(),'Self Registration Requests')]")
	public WebElement selfRegReqLink;

	@FindBy(xpath = "//div[text()='Scheduled Employees']")
	public WebElement schEmpLink;

	@FindBy(xpath = "//div[text()='Clocked In Now']")
	public WebElement clockedInNowLink;

	@FindBy(xpath = "//div[text()='Employees Clocked In Today']")
	public WebElement empClockTodayLink;

	@FindBy(xpath = "//div[text()='Not Clocked In Now']")
	public WebElement notClockedLink;

	@FindBy(id = "livestream_link")
	public WebElement liveStreamLink;

	@FindBy(xpath = "//a[@class='livestream_link']")
	public WebElement liveStreamMore;

	@FindBy(xpath = "//span[@class='sidebar_menu_link' and text()='Timesheet']")
	public WebElement timesheetPageLink;

	@FindBy(xpath = "//a[@id='clock_in_link']")
	public WebElement clockIn;

	@FindBy(xpath = "//a[@id='clock_out_link' and contains(text(),'Clock Out')]")
	public WebElement clockOut;

	@FindBy(xpath = "//div[@class='all-button-header-sec']")
	public WebElement completeClockInOut;

	@FindBy(xpath = "//div[@id='jSuccess']")
	WebElement clockInOutMsg;

	@FindBy(xpath = "//div[@id='user_head_avatar']")
	WebElement profilePicture;

	@FindBy(partialLinkText = "My Profile")
	WebElement myProfileLink;

	@FindBy(id = "liSharedTopNotification")
	WebElement messages;

	@FindBy(partialLinkText = "View message")
	WebElement viewMessagesLink;

	@FindBy(id = "LogoutManually")
	WebElement logOutBtn;

	@FindBy(xpath = "//a[contains(@onclick,'BindTimeCartReport')]/img")
	WebElement myTimeCardExportIcon;

	@FindBy(id = "ddlTimesheetStandard")
	WebElement myTimeCardExportFormatDropDown;

	@FindBy(xpath = "//a[contains(text(),'Export')]")
	WebElement myTimeCardExportBtn;

	@FindBy(xpath = "//div[text()='Birthdays Alert']")
	WebElement birthdayAlertLink;

	@FindBy(xpath = "//h4[contains(text(),'Birthday')]")
	WebElement birthdayAlertText;

	@FindBy(id = "aMainQuickClockIn")
	WebElement quickClockInLink;

	@FindBy(xpath = "//div[@id='subscrip_header']/a")
	WebElement subscriptionLink;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	static String dashboardWindow;

	public PendingTimesheetRequestsPage goToPendingTimesheetReq() {

		pendTsRqLink.click();

		return new PendingTimesheetRequestsPage(driver);

	}

	public PossibleClockInErrorsPage goToPossibleClockInErrorsPage() {

		possClockInErrLink.click();

		return new PossibleClockInErrorsPage(driver);

	}

	public PendingAbsenceRequestsPage goToPendingAbsenceRequestsPage() {

		penAbsReqLink.click();

		return new PendingAbsenceRequestsPage(driver);

	}

	public ShiftSwitchRequestsPage goToShiftSwitchRequestsPage() {

		shiftSwitchReqLink.click();

		return new ShiftSwitchRequestsPage(driver);

	}

	public TimesheetsToVerifyPage goToTimesheetsToVerifyPage() {

		tsToVerifyLink.click();

		return new TimesheetsToVerifyPage(driver);
	}

	public ReimbursementRequestsPage goToReimbursementRequestsPage() {

		reimbReqLink.click();

		return new ReimbursementRequestsPage(driver);
	}

	public SelfRegistrationRequestsPage goToSelfRegistrationRequestsPage() {

		selfRegReqLink.click();

		return new SelfRegistrationRequestsPage(driver);
	}

	public ScheduledEmployeesPage goToScheduledEmployeesPage() {

		schEmpLink.click();

		return new ScheduledEmployeesPage(driver);
	}

	public ClockedInNowPage goToClockedInNowPage() {

		clockedInNowLink.click();

		return new ClockedInNowPage(driver);
	}

	public EmployeesClockedInTodayPage goToEmployeesClockedInTodayPage() {

		empClockTodayLink.click();

		return new EmployeesClockedInTodayPage(driver);
	}

	public NotClockedInNowPage goToNotClockedInNowPage() {

		notClockedLink.click();

		return new NotClockedInNowPage(driver);
	}

	public LiveStreamPage goToLiveStreamPage() {

		liveStreamLink.click();
		toWait();
		Actions act = new Actions(driver);
		act.moveToElement(liveStreamMore).click().build().perform();

		return new LiveStreamPage(driver);
	}

	public TimesheetPage goToTimesheetPage() {

		timesheetPageLink.click();

		return new TimesheetPage(driver);
	}

	public String clockingInAndOut() {
		Actions act = new Actions(driver);
		act.moveToElement(completeClockInOut).build().perform();
		String txt = completeClockInOut.getText();
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		System.out.println(txt);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		if (txt.contains("Clock In")) {
			act.moveToElement(clockIn).click().build().perform();
		} else if (txt.contains("Clock Out")) {
			// act.moveToElement(clockOut).click().build().perform();
			js.executeScript("arguments[0].click()", clockOut);
		}

		return clockInOutMsg.getText();

	}

	public void waitFor2Sec() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void hoverOverProfilePic() {
		Actions act = new Actions(driver);
		act.moveToElement(profilePicture).build().perform();
		waitFor2Sec();
	}

	public ReimbursementPage clickOnMyProfileLink() {
		Actions act = new Actions(driver);
		act.moveToElement(myProfileLink).click().build().perform();
		toWait();
		return new ReimbursementPage(driver);

	}

	public void hoverOnMessages() {
		Actions act = new Actions(driver);
		act.moveToElement(messages).click().build().perform();

	}

	public MessagesPage clickOnViewMessages() {
		Actions act = new Actions(driver);
		act.moveToElement(viewMessagesLink).click().build().perform();
		toWait();
		return new MessagesPage(driver);

	}

	public LoginPage clickOnLogOutBtn() {
		Actions act = new Actions(driver);
		act.moveToElement(logOutBtn).click().build().perform();
		toWait();
		return new LoginPage(driver);
	}

	public void clickOnMyTimeCardExportIcon() {
		Actions act = new Actions(driver);
		act.moveToElement(myTimeCardExportIcon).click().build().perform();
		synchronized (driver) {
			try {
				driver.wait(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void selectMyTimeCardExportFormat() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select selectFormat = new Select(myTimeCardExportFormatDropDown);
		selectFormat.selectByVisibleText("PDF");
	}

	public boolean clickOnMyTimeCardExportBtn() {
		TestUtil.removeFilesFromFolder();
		
		try {
			Thread.sleep(3000);
			myTimeCardExportBtn.click();
			// Thread.sleep(4000);
		} catch (ElementClickInterceptedException d) {
			d.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// return TestUtil.isFileExists(Config.getProperty("timecardpdf"));
		return TestUtil.waitForDownloadCompleteByLoop(".pdf", 180);
	}

	public String birthdayAlertVerification() {
		birthdayAlertLink.click();
		toWait();
		return birthdayAlertText.getText();

	}

	public QuickClockInPage clickOnQuickClockInLink() {
		// TestUtil.getParentWindowHandleString();
		dashboardWindow = driver.getWindowHandle();
		quickClockInLink.click();
		return new QuickClockInPage(driver);
	}

	public SubscriptionPage clickOnSubscriptionInLink() {
		// TestUtil.getParentWindowHandleString();
		dashboardWindow = driver.getWindowHandle();
		System.out.println("dashboard window: " + dashboardWindow);
		subscriptionLink.click();
		return new SubscriptionPage(driver);
	}

}
