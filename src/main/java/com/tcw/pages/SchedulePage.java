package com.tcw.pages;

import java.text.SimpleDateFormat;
import java.time.Duration;
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
import com.tcw.utilities.TestUtil;

public class SchedulePage extends BasePage {

	@FindBy(xpath = "//span[@class='sidebar_menu_link' and contains(text(),'Schedule')]")
	WebElement schdLnk;

	@FindBy(xpath = "//div[@id='site_name']//h1")
	WebElement schdTtl;

	@FindBy(xpath = "//td[contains(@class,'fc-day-top') and not(contains(@class,'fc-other-month'))]")
	List<WebElement> multipleDates;

	@FindBy(xpath = "//a[contains(text(),'Add schedule')]")
	WebElement addSchBtn;

	@FindBy(xpath = "//ul[@class='chosen-choices']")
	WebElement empDrpDwn;

	@FindBy(xpath = "//li[@class='active-result']")
	List<WebElement> empDrpDwnLst;

	@FindBy(xpath = "//li[@class='search-choice'][1]//a")
	WebElement selectedEmpCloseBtn;

	@FindBy(id = "txtScheduleFromTime")
	WebElement stTime;

	@FindBy(id = "txtScheduleToTime")
	WebElement endTime;

	@FindBy(id = "ddlScheduleLocation")
	WebElement locDrpDwn;

	@FindBy(id = "ddlSchedulePosition")
	WebElement jobDrpDwn;

	@FindBy(id = "Pricerate")
	WebElement customPay;

	@FindBy(id = "Comment")
	WebElement Notes;

	@FindBy(id = "PesonalNote")
	WebElement PesonalNote;

	@FindBy(xpath = "//div[@class='col-xs-12']//a[text()='Save']")
	WebElement saveBtn;

	@FindBy(id = "jSuccess")
	WebElement successMsg;

	@FindBy(xpath = "//h4[@class='modal-title warning']")
	WebElement errorMsg;

	@FindBy(xpath = "//div[@class='userNamee-month pull-left']")
	List<WebElement> editEmpList;

	@FindBy(xpath = "//div[contains(@class,'userBloc-month')]/div[@class='block_one_pep'] | //div[@class='block_one_pep ']/div[1]/h5")
	List<WebElement> editEmpListContent;

	@FindBy(xpath = "//a[contains(@onclick,'confirmDeleteShift')]")
	WebElement deleteSch;

	@FindBy(id = "aSYesConfirm")
	WebElement onlyThisInstanceBtn;

	@FindBy(id = "jSuccess")
	List<WebElement> successMsgList;

	@FindBy(xpath = "//a[@id='scheduleMonth']")
	WebElement scheduleReportListViewBtn;

	@FindBy(id = "ScheduleReportExport")
	WebElement scheduleReportListViewFormatDropDown;

	@FindBy(xpath = "//a[text()='Export']")
	WebElement scheduleReportListViewExportBtn;

	@FindBy(xpath = "//a[contains(text(),'MONTH VIEW')]")
	WebElement scheduleReportListMonthBtn;

	public SchedulePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String goToSchedulePage() {
		schdLnk.click();
		toWait();
		return schdTtl.getText();
	}

	// Selecting a Date
	public static String getTodayDate() {

		SimpleDateFormat formatter3 = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = new Date();
		String yyMMdd = formatter3.format(d1);
		return yyMMdd;

	}

	// Adding the Schedule
	public String addScheduleForEmp(Hashtable<String, String> data) {
		Actions act = new Actions(driver);
		for (WebElement singleDate : multipleDates) {
			String singleDateTxt = singleDate.getAttribute("data-date");
			System.out.println(singleDateTxt);

			// Date manupulation
			/*
			 * SimpleDateFormat formatter3 = new SimpleDateFormat("yyyy-MM-dd"); Date d1 =
			 * new Date(); String yyMMdd = formatter3.format(d1);
			 */
			if (singleDateTxt.equalsIgnoreCase(SchedulePage.getTodayDate())) {
				act.moveToElement(singleDate).perform();
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,150)");
				act.moveToElement(singleDate).click(singleDate).build().perform();
				System.out.println("clicked on the date");
				break;
			}

		}
		addSchBtn.click();
		empDrpDwn.click();

		for (WebElement singleEmp : empDrpDwnLst) {
			String singleEmpTxt = singleEmp.getText();
			if (singleEmpTxt.equalsIgnoreCase(data.get("desiredEmp"))) {
				singleEmp.click();
				selectedEmpCloseBtn.click();
				break;
			}
		}

		stTime.clear();
		stTime.sendKeys(data.get("stTime"));
		endTime.clear();
		endTime.sendKeys(data.get("endTime"));
		Select selectLocDrpDwn = new Select(locDrpDwn);
		selectLocDrpDwn.selectByVisibleText(data.get("locDrpDwn"));
		Select selectJobDrpDwn = new Select(jobDrpDwn);
		selectJobDrpDwn.selectByVisibleText(data.get("jobDrpDwn"));
		customPay.sendKeys(data.get("customPay"));
		Notes.sendKeys(data.get("Notes"));
		PesonalNote.sendKeys(data.get("PesonalNote"));
		act.moveToElement(saveBtn).click().build().perform();
		System.out.println(successMsgList.size());
		try {
			// wait.until(ExpectedConditions.visibilityOf(successMsg));
			return successMsg.getAttribute("textContent");
		} catch (Throwable e) {
			return errorMsg.getText();
		}

	}

	// Deleting the Schedule
	public void deleteScheduleForEmp(Hashtable<String, String> data) {
		Actions act = new Actions(driver);
		for (WebElement singleDate : multipleDates) {
			String singleDateTxt = singleDate.getAttribute("data-date");
			System.out.println(singleDateTxt);
			if (singleDateTxt.equalsIgnoreCase(SchedulePage.getTodayDate())) {
				act.moveToElement(singleDate).build().perform();
				// ((JavascriptExecutor)
				// driver).executeScript("arguments[0].scrollIntoView(true);", singleDate);
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,150)");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				// singleDate);
				act.moveToElement(singleDate).click(singleDate).build().perform();
				System.out.println("Clicked on a date");
				break;
			}

		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		int no = 0;
		for (WebElement editEmpListSingle : editEmpList) {
			// System.out.println(editEmpListSingle.getText());
			System.out.println(editEmpListSingle.getAttribute("innerHTML"));
			if (editEmpListSingle.getAttribute("innerHTML").equalsIgnoreCase(data.get("desiredEmp"))) {
				// System.out.println("Desired Emp"+data.get("desiredEmp"));
				WebElement singleContent = editEmpListContent.get(no);
				wait = new WebDriverWait(driver, Duration.ofSeconds(5));
				/*
				 * wait.until(ExpectedConditions. presenceOfElementLocated((By) singleContent));
				 */
				// wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(singleContent,
				// null));
				try {
					act.moveToElement(singleContent).build().perform();
				} catch (Exception e) {

					// act.moveToElement(singleContent).click().build().perform();
				}
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", singleContent);
				// ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)");
				// System.out.println("scrolling the page up");
				((JavascriptExecutor) driver).executeScript("arguments[0].click()", singleContent);
				System.out.println("clicked on the employee");
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			no++;
		}
		wait.until(ExpectedConditions.elementToBeClickable(deleteSch));
		act.moveToElement(deleteSch).click().build().perform();
		wait.until(ExpectedConditions.visibilityOf(onlyThisInstanceBtn));
		onlyThisInstanceBtn.click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void clickOnScheduleReportListView() {
		Actions act = new Actions(driver);
		act.moveToElement(scheduleReportListViewBtn).build().perform();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", scheduleReportListViewBtn);
		jse.executeScript("arguments[0].click()", scheduleReportListViewBtn);

		synchronized (driver) {
			try {
				driver.wait(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void selectScheduleReportListViewFormat() {
		Select selectFormat = new Select(scheduleReportListViewFormatDropDown);
		selectFormat.selectByVisibleText("PDF");
	}

	public boolean clickOnScheduleReportListViewExportBtn() {
		TestUtil.removeFilesFromFolder();
		scheduleReportListViewExportBtn.click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return TestUtil.isFileExists(Config.getProperty("scheduleListView"));
	}

	public boolean clickOnScheduleReportMonthView() {
		TestUtil.removeFilesFromFolder();
		Actions act = new Actions(driver);
		act.moveToElement(scheduleReportListMonthBtn).build().perform();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", scheduleReportListMonthBtn);
		jse.executeScript("arguments[0].click()", scheduleReportListMonthBtn);

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return TestUtil.isFileExists(Config.getProperty("scheduleMonthView"));

	}
}
