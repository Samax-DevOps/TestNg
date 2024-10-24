package com.tcw.pages;

import java.time.Duration;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tcw.base.BasePage;

public class EmployeePage extends BasePage {

	@FindBy(xpath = "//span[@class='sidebar_menu_link' and contains(text(),'Employee')]")
	WebElement empLnk;

	@FindBy(xpath = "//div[@id='site_name']//h1")
	WebElement empTtl;

	@FindBy(id = "add_setting_link")
	WebElement globalSettingBtn;

	@FindBy(xpath = "//div[@class='sel check_sel']/input")
	List<WebElement> clockInOutCheckBx;

	@FindBy(id = "SMSEmailAlerts")
	WebElement notificationsTab;

	@FindBy(xpath = "//div[@class='check_inform check_sel']/input[@name='ReceiveNotification']")
	List<WebElement> notificationCheckBx1;

	@FindBy(xpath = "//div[@class='sel check_sel']/input[@class='checkbox smsEmailAlert emailAlert']")
	List<WebElement> notificationCheckBx2;

	@FindBy(xpath = "//div[@class='col-md-6 col-sm-12']/input[@class='checkbox emailAlert']")
	List<WebElement> notificationCheckBx3;

	@FindBy(id = "ClockPoints")
	WebElement clockPointsTab;

	@FindBy(xpath = "//div[@class='title ml-sm-2']/input")
	WebElement clockPointNewUserCheckBx;

	@FindBy(xpath = "//input[@name='ClockPointRestriction']")
	List<WebElement> clockPointRestCheckBx;

	@FindBy(id = "Payroll")
	WebElement payrolLTab;

	@FindBy(xpath = "//div[@class='col-sm-12']//input[1]")
	WebElement includeWagesCheckBx;

	@FindBy(xpath = "//div[@class='one_check_permis']//input[@type='radio' and @name='PayEmployeesForBreaks']")
	List<WebElement> paidBreakCheckBx;

	@FindBy(xpath = "//input[@name='TimeRounding']")
	List<WebElement> timeRoundingCheckBx;

	@FindBy(xpath = "//input[@name='AllowOverTime']")
	List<WebElement> overtimeInfoCheckBx;

	@FindBy(id = "Reimbursement")
	WebElement reimbursementTab;

	@FindBy(id = "checkboxUpload")
	WebElement upoadCheckBx;

	@FindBy(id = "GlobalPTO")
	WebElement ptoTab;

	@FindBy(id = "dvGlobalPTOAbsencesName")
	List<WebElement> ptoNames;

	@FindBy(id = "Schedule")
	WebElement scheduleTab;

	@FindBy(id = "checkboxWeekly")
	WebElement weeklyCheckBx;

	@FindBy(id = "checkboxMonthly")
	WebElement monthlyCheckBx;

	@FindBy(xpath = "//a[text()='Reimbursement' and @id='1']")
	WebElement reimbursementGTab;

	By remEmpDD = By.id("ddlUser");

	@FindBy(id = "txtFrom")
	WebElement remStDate;

	@FindBy(id = "txtTo")
	WebElement remEndDate;

	@FindBy(id = "btnSearchReimbursement")
	WebElement remSrcBtn;

	@FindBy(xpath = "//div[@class='total_reim']")
	WebElement totalRem;

	@FindBy(xpath = "//a[@id='aEdit']")
	List<WebElement> activeEmployeeList;

	@FindBy(id = "FirstName")
	WebElement fNameEmp;

	@FindBy(id = "UserName")
	WebElement userNameEmp;

	@FindBy(id = "LastName")
	WebElement lNameEmp;

	@FindBy(id = "Employee_ID")
	WebElement empId;

	@FindBy(xpath = "//ul[@class='chosen-choices']/li[@class='search-choice']")
	List<WebElement> managedByList;

	@FindBy(id = "QuickClockInId")
	WebElement quickClockIn;

	@FindBy(id = "txtAddress1")
	WebElement addressLine1;

	@FindBy(id = "txtCity")
	WebElement cityName;

	@FindBy(id = "ddlCountry")
	WebElement selectedCountry;

	@FindBy(id = "State")
	WebElement stateName;

	@FindBy(id = "txtZip")
	WebElement zipCode;

	@FindBy(id = "empCellphone")
	WebElement cellPhone;

	@FindBy(id = "empworkPhone")
	WebElement workPhone;

	@FindBy(id = "empHomePhone")
	WebElement homePhone;

	@FindBy(id = "EmergencyContactName")
	WebElement emergencyContactName;

	@FindBy(id = "empEmergencyPhone")
	WebElement emergencyContactPhone;

	@FindBy(id = "EmergencyNote")
	WebElement emergencyNote;

	@FindBy(id = "EmailAddress")
	WebElement emailOptional;

	@FindBy(id = "txtBirthDate")
	WebElement birthDay;

	@FindBy(id = "Office_ID")
	WebElement primaryPayrollLocation;

	@FindBy(id = "txtHireDate")
	WebElement hireDate;

	@FindBy(id = "ddlTimeZone")
	WebElement timeZone;

	@FindBy(id = "WorkExtention")
	WebElement workExtension;

	@FindBy(id = "checkboxApply")
	WebElement dayLightSaving;

	@FindBy(id = "Permissions")
	WebElement permissionsTab;

	@FindBy(xpath = "//label/input/following-sibling::h4[@class='modal-title']")
	List<WebElement> accountTypeList;

	@FindBy(xpath = "//label/input/following-sibling::h4[@class='modal-title']/preceding-sibling::input")
	List<WebElement> accountTypeSelectedList;

	@FindBy(xpath = "//ul[@id='ulPermissionPayRoll']/li/label/h4")
	List<WebElement> permissionsTabPayrollNames;

	@FindBy(xpath = "//ul[@id='ulPermissionPayRoll']/li/label/input")
	List<WebElement> permissionsTabPayrollNamesCheckBoxes;

	@FindBy(xpath = "//ul[@id='ulSettings']/li/label/h4")
	List<WebElement> permissionsTabSettingNames;

	@FindBy(xpath = "//ul[@id='ulSettings']/li/label/input")
	List<WebElement> permissionsTabSettingNamesCheckBoxes;

	@FindBy(xpath = "//ul[@id='ulSettings']/li")
	List<WebElement> permissionsTabSettingNamesVisiblty;

	@FindBy(xpath = "//ul[@id='ulPermissionEmployee']/li/label/h4")
	List<WebElement> permissionsTabEmployeeNames;

	@FindBy(xpath = "//ul[@id='ulPermissionEmployee']/li/label/input")
	List<WebElement> permissionsTabEmployeeNamesCheckBoxes;

	@FindBy(xpath = "//ul[@id='ulSchedule']/li/label/h4")
	List<WebElement> permissionsTabScheduleNames;

	@FindBy(xpath = "//ul[@id='ulSchedule']/li/label/input")
	List<WebElement> permissionsTabScheduleNamesCheckBoxes;

	@FindBy(xpath = "//ul[@id='ulTimeSheets']/li/label/h4")
	List<WebElement> permissionsTabTimesheetNames;

	@FindBy(xpath = "//ul[@id='ulTimeSheets']/li/label/input")
	List<WebElement> permissionsTabTimesheetNamesCheckBoxes;

	@FindBy(xpath = "//ul[@id='ulPermissionAbsences']/li/label/h4")
	List<WebElement> permissionsTabAbsenceNames;

	@FindBy(xpath = "//ul[@id='ulPermissionAbsences']/li/label/input")
	List<WebElement> permissionsTabAbsenceNamesCheckBoxes;

	@FindBy(xpath = "//ul[@id='ulReimbursement']/li/label/h4")
	List<WebElement> permissionsTabReimbursementNames;

	@FindBy(xpath = "//ul[@id='ulReimbursement']/li/label/input")
	List<WebElement> permissionsTabReimbursementNamesCheckBoxes;

	@FindBy(xpath = "//ul[@id='ulTasks']/li/label/h4")
	List<WebElement> permissionsTabTaskNames;

	@FindBy(xpath = "//ul[@id='ulTasks']/li/label/input")
	List<WebElement> permissionsTabTaskNamesCheckBoxes;

	@FindBy(xpath = "//ul[@id='ulReport']/li/label/h4")
	List<WebElement> permissionsTabReportNames;

	@FindBy(xpath = "//ul[@id='ulReport']/li/label/input")
	List<WebElement> permissionsTabReportNamesCheckBoxes;

	@FindBy(xpath = "//ul[@id='ulPaypal']/li/label/h4")
	List<WebElement> permissionsTabPaypalNames;

	@FindBy(xpath = "//ul[@id='ulPaypal']/li/label/input")
	List<WebElement> permissionsTabPaypalNamesCheckBoxes;

	@FindBy(xpath = "//ul[@id='ulAccessQB']/li/label/h4")
	List<WebElement> permissionsTabAddOnsNames;

	@FindBy(xpath = "//ul[@id='ulAccessQB']/li/label/input")
	List<WebElement> permissionsTabAddOnsNamesCheckBoxes;

	@FindBy(xpath = "//ul[@id='ulSchedule']/li")
	List<WebElement> permissionsTabScheduleNamesVisiblty;

	@FindBy(xpath = "(//*[@id='ClockInOut'])[2]")
	WebElement clockInOutTab;

	@FindBy(xpath = "(//div[@class='body_permis'])[1]//h4[not(contains(@class,'modal'))]")
	List<WebElement> clockInOutAllowList;

	@FindBy(xpath = "(//div[@class='body_permis'])[1]//div[@class='sel check_sel']/input")
	List<WebElement> clockInOutAllowListCheckBoxes;

	@FindBy(xpath = "//label[contains(@for,'photo')]/h4")
	List<WebElement> screenshotsFrequencyName;

	@FindBy(xpath = "//label[contains(@for,'photo')]/input")
	List<WebElement> screenshotsFrequencyNameCheckBox;

	@FindBy(xpath = "//label[contains(@for,'Minue')]/h4")
	List<WebElement> screenshotsIdleName;

	@FindBy(xpath = "//label[contains(@for,'Minue')]/input")
	List<WebElement> screenshotsIdleNameCheckBox;

	@FindBy(xpath = "(//div[@class='body_permis'])[2]//h4[not(contains(@class,'modal'))]")
	List<WebElement> doNotAllowListNames;

	@FindBy(xpath = "(//div[@class='body_permis'])[2]//div[@class='sel check_sel']/input")
	List<WebElement> doNotAllowListNamesCheckBox;

	@FindBy(xpath = "(//a[@id='SMSEmailAlerts'])[2]")
	WebElement notificationsTab1;

	@FindBy(xpath = "(//div[@class='title_permis']/h3)[1]")
	WebElement notificationsTab1Text;

	@FindBy(xpath = "(//a[@id='ClockPoints'])[2]")
	WebElement clockPointsTab2;

	@FindBy(xpath = "//div[@id='other_inform']/div/h3")
	WebElement clockPointsTab2Text;

	@FindBy(xpath = "(//a[@id='Payroll'])[2]")
	WebElement payrollTab;

	@FindBy(xpath = "//div[@class='empl_search title']//h3")
	WebElement payrollTabText;

	@FindBy(xpath = "(//a[@id='Reimbursement'])[2]")
	WebElement reimbursementTab1;

	@FindBy(xpath = "(//div[@class='local_inform']/div/div/h3)[1]")
	WebElement reimbursementTab1Text;

	@FindBy(xpath = "(//a[@id='Schedule'])[2]")
	WebElement scheduleTab1;

	@FindBy(xpath = "//div[@class='sel left_form_empl']/div/h3")
	WebElement scheduleTab1Text;

	@FindBy(xpath = "//a[@id='PTO']")
	WebElement ptoTab1;

	@FindBy(xpath = "//div[@id='tblPTO_wrapper']//thead/tr/td[1]")
	WebElement ptoTab1Text;

	public EmployeePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String goToEmployeePage() {
		empLnk.click();
		toWait();
		return empTtl.getText();
	}

	// Global Setting Testing
	public void globalSettingTesting() {

		Actions act = new Actions(driver);
		act.moveToElement(globalSettingBtn).click().build().perform();
		getTheCheckBoxes(clockInOutCheckBx);

		// Notifications
		act.moveToElement(notificationsTab).click().build().perform();
		System.out.println(
				notificationCheckBx1.size() + " " + notificationCheckBx2.size() + " " + notificationCheckBx3.size());

//		notificationCheckBx1.addAll(notificationCheckBx2);
//		notificationCheckBx1.addAll(notificationCheckBx3);
//		notificationCheckBx1.add(notificationCheckBx2.get(0));
//		notificationCheckBx1.add(notificationCheckBx2.get(1));

		// System.out.println(b1+" "+b2);

		getTheCheckBoxes(notificationCheckBx1);
		getTheCheckBoxes(notificationCheckBx2);
		getTheCheckBoxes(notificationCheckBx3);

		act.moveToElement(clockPointsTab).click().build().perform();
		getTheCheckBoxesSing(clockPointNewUserCheckBx);
		getTheCheckBoxes(clockPointRestCheckBx);

		act.moveToElement(payrolLTab).click().build().perform();
		getTheCheckBoxesSing(includeWagesCheckBx);
		getTheCheckBoxes(paidBreakCheckBx);
		getTheCheckBoxes(timeRoundingCheckBx);
		getTheCheckBoxes(overtimeInfoCheckBx);

		act.moveToElement(reimbursementTab).click().build().perform();
		getTheCheckBoxesSing(upoadCheckBx);

		act.moveToElement(ptoTab).click().build().perform();

		getTheNames(ptoNames);

		act.moveToElement(scheduleTab).click().build().perform();
		getTheCheckBoxesSing(weeklyCheckBx);
		getTheCheckBoxesSing(monthlyCheckBx);
	}

	public void getTheCheckBoxes(List<WebElement> li) {
		for (WebElement e : li) {

			log.info(e.getAttribute("name"));
			log.info(e.isSelected());
			System.out.println(e.getAttribute("name"));
			System.out.println(e.isSelected());
		}
	}

	public void getTheCheckBoxesSing(WebElement e) {

		log.info(e.getAttribute("name"));
		log.info(e.isSelected());
		System.out.println(e.getAttribute("name"));
		System.out.println(e.isSelected());

	}

	public void getTheNames(List<WebElement> li) {
		for (WebElement e : li) {
			String name = e.getText();
			log.info(name);
			System.out.println(name);
		}
	}

	// Reimbursement Test
	public String reimbursementTesting(Hashtable<String, String> data) {
		Actions act = new Actions(driver);
		act.moveToElement(globalSettingBtn).click().build().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", reimbursementGTab);
//		act.moveToElement(reimbursementGTab).click().build().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement redd = wait.until(ExpectedConditions.presenceOfElementLocated(remEmpDD));
		Select remEmpSS = new Select(redd);
		// remEmpSS.selectByVisibleText("Maulik Dhaduk");
		remEmpSS.selectByVisibleText(data.get("remEmpSS"));
		// redd.click();
		remStDate.clear();
		remStDate.sendKeys(data.get("remStDate"));
		remEndDate.clear();
		remEndDate.sendKeys(data.get("remEndDate"));
		remSrcBtn.click();
		act.moveToElement(totalRem).build().perform();

		return totalRem.getText();

	}

	// Select an Employee
	public void selectAnEmployeeFromActiveList() {
		Actions act = new Actions(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		for (WebElement e : activeEmployeeList) {
			act.moveToElement(e).build().perform();
			String empName = e.getText();
			System.out.println(empName);
			if (empName.equalsIgnoreCase("User Twelve")) {
				act.moveToElement(e).build().perform();
				jse.executeScript("arguments[0].click();", e);
				break;
			}
		}
	}

	// Employee Detail Test
	public void getEmployeeInformation() {
		toWait();

		System.out.println("First Name: " + fNameEmp.getAttribute("value"));
		System.out.println("UserName: " + userNameEmp.getAttribute("value"));
		System.out.println("Last Name: " + lNameEmp.getAttribute("value"));
		System.out.println("EmpId: " + empId.getAttribute("value"));
		for (WebElement t : managedByList) {
			System.out.println("Manager: " + t.getAttribute("textContent"));
		}
		System.out.println("QuickClockIn: " + quickClockIn.getAttribute("value"));

		System.out.println("Address: " + addressLine1.getAttribute("value"));
		System.out.println("City: " + cityName.getAttribute("value"));
		Select selectedCountryDropDown = new Select(selectedCountry);
		String selectedCountryName = selectedCountryDropDown.getFirstSelectedOption().getText();
		System.out.println("Country: " + selectedCountryName);
		System.out.println("State: " + stateName.getAttribute("value"));
		System.out.println("ZipCode: " + zipCode.getAttribute("value"));

		System.out.println("CellPhone: " + cellPhone.getAttribute("value"));
		System.out.println("WorkPhone: " + workPhone.getAttribute("value"));
		System.out.println("HomePhone: " + homePhone.getAttribute("value"));

		System.out.println("Emergency Contact Name: " + emergencyContactName.getAttribute("value"));
		System.out.println("Emergency Contact Phone: " + emergencyContactPhone.getAttribute("value"));
		System.out.println("Emergency Note: " + emergencyNote.getAttribute("value"));

		System.out.println("Email: " + emailOptional.getAttribute("value"));
		System.out.println("BirthDay: " + birthDay.getAttribute("value"));
		Select selectedPrimaryLocationDropDown = new Select(primaryPayrollLocation);
		System.out.println(selectedPrimaryLocationDropDown.getFirstSelectedOption().getText());
		System.out.println("Hire Date: " + hireDate.getAttribute("value"));
		Select selectedTimeZoneDropDown = new Select(timeZone);
		System.out.println("Time Zone: " + selectedTimeZoneDropDown.getFirstSelectedOption().getText());
		System.out.println("Work Extension: " + workExtension.getAttribute("value"));
		if (dayLightSaving.isSelected()) {
			System.out.println("Daylight Saving is ON");
		} else {
			System.out.println("Daylight Saving is OFF");
		}

	}

	// Employee Permission Test
	public void getEmployeePermissions() {
		toWait();
		permissionsTab.click();
		toWait();
		String typeOfAccount = null;
		// To find out the type of account
		for (int k = 0; k < accountTypeList.size(); k++) {

			if (accountTypeSelectedList.get(k).isSelected()) {
				typeOfAccount = accountTypeList.get(k).getAttribute("textContent");
				System.out.println(typeOfAccount);
				break;
			}
		}

		// To print the permissions
		if (typeOfAccount.equalsIgnoreCase("Super Administrator") || typeOfAccount.equalsIgnoreCase("Administrator")
				|| typeOfAccount.equalsIgnoreCase("Manager")) {

			System.out.println("------------");
			System.out.println("Payroll Permissions");
			for (int l = 0; l < permissionsTabPayrollNames.size(); l++) {
				System.out.println(permissionsTabPayrollNames.get(l).getText() + "--"
						+ permissionsTabPayrollNamesCheckBoxes.get(l).isSelected());
			}

			System.out.println("------------");
			System.out.println("Settings Permissions");

			for (int l = 0; l < permissionsTabSettingNames.size(); l++) {
				String con = permissionsTabSettingNamesVisiblty.get(l).getAttribute("style");
				if (!con.contains("display: none")) {
					System.out.println(permissionsTabSettingNames.get(l).getText() + "--"
							+ permissionsTabSettingNamesCheckBoxes.get(l).isSelected());
				}
			}

			System.out.println("------------");
			System.out.println("Employee Permissions");

			for (int l = 0; l < permissionsTabEmployeeNames.size(); l++) {
				System.out.println(permissionsTabEmployeeNames.get(l).getText() + "--"
						+ permissionsTabEmployeeNamesCheckBoxes.get(l).isSelected());
			}

			System.out.println("------------");
			System.out.println("Schedule Permissions");

			for (int l = 0; l < permissionsTabScheduleNames.size(); l++) {
				System.out.println(permissionsTabScheduleNames.get(l).getText() + "--"
						+ permissionsTabScheduleNamesCheckBoxes.get(l).isSelected());
			}

			System.out.println("------------");
			System.out.println("Timesheets Permissions");

			for (int l = 0; l < permissionsTabTimesheetNames.size(); l++) {
				System.out.println(permissionsTabTimesheetNames.get(l).getText() + "--"
						+ permissionsTabTimesheetNamesCheckBoxes.get(l).isSelected());
			}

			System.out.println("------------");
			System.out.println("Absence Permissions");

			for (int l = 0; l < permissionsTabAbsenceNames.size(); l++) {
				System.out.println(permissionsTabAbsenceNames.get(l).getText() + "--"
						+ permissionsTabAbsenceNamesCheckBoxes.get(l).isSelected());
			}

			System.out.println("------------");
			System.out.println("Reimbursement Permissions");

			for (int l = 0; l < permissionsTabReimbursementNames.size(); l++) {
				System.out.println(permissionsTabReimbursementNames.get(l).getText() + "--"
						+ permissionsTabReimbursementNamesCheckBoxes.get(l).isSelected());
			}

			System.out.println("------------");
			System.out.println("Task Permissions");

			for (int l = 0; l < permissionsTabTaskNames.size(); l++) {
				System.out.println(permissionsTabTaskNames.get(l).getText() + "--"
						+ permissionsTabTaskNamesCheckBoxes.get(l).isSelected());
			}

			System.out.println("------------");
			System.out.println("Report Permissions");

			for (int l = 0; l < permissionsTabReportNames.size(); l++) {
				System.out.println(permissionsTabReportNames.get(l).getText() + "--"
						+ permissionsTabReportNamesCheckBoxes.get(l).isSelected());
			}

			System.out.println("------------");
			System.out.println("PayPal Permissions");

			for (int l = 0; l < permissionsTabPaypalNames.size(); l++) {
				System.out.println(permissionsTabPaypalNames.get(l).getText() + "--"
						+ permissionsTabPaypalNamesCheckBoxes.get(l).isSelected());
			}

			if (typeOfAccount.equalsIgnoreCase("Super Administrator")
					|| typeOfAccount.equalsIgnoreCase("Administrator")) {
				System.out.println("------------");
				System.out.println("Add On Permissions");

				for (int l = 0; l < permissionsTabAddOnsNames.size(); l++) {
					System.out.println(permissionsTabAddOnsNames.get(l).getText() + "--"
							+ permissionsTabAddOnsNamesCheckBoxes.get(l).isSelected());
				}
			}

		} else if (typeOfAccount.equalsIgnoreCase("Employee")) {

			System.out.println("------------");
			System.out.println("Schedule Permissions");

			for (int l = 0; l < permissionsTabScheduleNames.size(); l++) {
				String con = permissionsTabScheduleNamesVisiblty.get(l).getAttribute("style");
				if (!con.contains("display: none")) {
					System.out.println(permissionsTabScheduleNames.get(l).getText() + "--"
							+ permissionsTabScheduleNamesCheckBoxes.get(l).isSelected());
				}

			}

			System.out.println("------------");
			System.out.println("Task Permissions");

			for (int l = 0; l < permissionsTabTaskNames.size(); l++) {
				System.out.println(permissionsTabTaskNames.get(l).getText() + "--"
						+ permissionsTabTaskNamesCheckBoxes.get(l).isSelected());
			}

			System.out.println("------------");
			System.out.println("Report Permissions");

			for (int l = 0; l < permissionsTabReportNames.size(); l++) {
				System.out.println(permissionsTabReportNames.get(l).getText() + "--"
						+ permissionsTabReportNamesCheckBoxes.get(l).isSelected());
			}
		}

	}

	// Clock In Out
	public void getEmployeeClockInOutInfo() {
		toWait();
		clockInOutTab.click();
		toWait();

		boolean doNotAllow = true;
		for (int k = 0; k < clockInOutAllowList.size(); k++) {
			String name = clockInOutAllowList.get(k).getText();
			boolean b = clockInOutAllowListCheckBoxes.get(k).isSelected();
			System.out.println(name + ": " + b);
			if (name.equalsIgnoreCase("Enable screen capture.")) {
				if (!b) {
					doNotAllow = false;
					break;
				}
			}

		}

		if (doNotAllow) {
			for (int j = 0; j < screenshotsFrequencyName.size(); j++) {
				System.out.println(screenshotsFrequencyName.get(j).getText() + ": "
						+ screenshotsFrequencyNameCheckBox.get(j).isSelected());
			}

			for (int j = 0; j < screenshotsIdleName.size(); j++) {
				System.out.println(
						screenshotsIdleName.get(j).getText() + ": " + screenshotsIdleNameCheckBox.get(j).isSelected());
			}
		}

		for (int j = 0; j < doNotAllowListNames.size(); j++) {
			System.out.println(
					doNotAllowListNames.get(j).getText() + ": " + doNotAllowListNamesCheckBox.get(j).isSelected());
		}

	}

	// Notifications Test
	public String getEmployeeNotificationsInfo() {
		toWait();
		notificationsTab1.click();
		toWait();
		return notificationsTab1Text.getText();
	}

	// Clock Ponts Test
	public String getClockPointsInfo() {
		toWait();
		clockPointsTab2.click();
		toWait();
		return clockPointsTab2Text.getText();

	}

	// Payroll test
	public String getEmployeePayroll() {
		toWait();
		payrollTab.click();
		toWait();
		return payrollTabText.getText();
	}

	// Reimbursement Test
	public String getEmployeeReimbursementInfo() {
		toWait();
		reimbursementTab1.click();
		toWait();
		return reimbursementTab1Text.getText();
	}

	// Schedule Test
	public String getEmployeeScheduleInfo() {
		toWait();
		scheduleTab1.click();
		toWait();
		return scheduleTab1Text.getText();
	}
	
	// PTO Test
	public String getEmployeePto() {
		toWait();
		ptoTab1.click();
		toWait();
		return ptoTab1Text.getText();
	}

}
