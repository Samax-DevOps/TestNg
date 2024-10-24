package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.ReportsPage;

public class ReportsTest extends LogInTest {

	ReportsPage rp;

	public void pageSetup() {
		logIn();
		rp = new ReportsPage(driver);
	}

	@Test(priority = 1)
	public void landingOnReportsPage() {
//		logIn();
//		rp = new ReportsPage(driver);
		pageSetup();
		String reportsTtl1 = rp.goToReportsPage();
		Assert.assertEquals(reportsTtl1, "Reports");
	}

	@Test(priority = 2)
	public void viewStdTimesheet() {
//		logIn();
//		rp = new ReportsPage(driver);
		pageSetup();
		rp.goToReportsPage();
		String txt = rp.genStdTimesheet();
		Assert.assertEquals("Employee Name", txt);
	}

	@Test(priority = 3)
	public void viewDetailedTimesheet() {
//		logIn();
//		rp = new ReportsPage(driver);
		pageSetup();
		rp.goToReportsPage();
		String txt = rp.genDtdTimesheet();
		Assert.assertEquals("Employee Name", txt);
	}

	@Test(priority = 4)
	public void viewPtoBank() {
//		logIn();
//		rp = new ReportsPage(driver);
		pageSetup();
		rp.goToReportsPage();
		String txt = rp.genPTOBanks();
		Assert.assertEquals("Employee Name", txt);
	}

	@Test(priority = 5)
	public void viewEmpContactList() {
//		logIn();
//		rp = new ReportsPage(driver);
		pageSetup();
		rp.goToReportsPage();
		String txt = rp.genEmpContactList();
		Assert.assertEquals("Employee Name", txt);
	}

	@Test(priority = 6)
	public void viewPayroll() {
//		logIn();
//		rp = new ReportsPage(driver);
		pageSetup();
		rp.goToReportsPage();
		String txt = rp.generatePayroll();
		Assert.assertEquals("Employee Name", txt);
	}

	@Test(priority = 7)
	public void viewTardyPercentage() {
//		logIn();
//		rp = new ReportsPage(driver);
		pageSetup();
		rp.goToReportsPage();
		String txt = rp.generateTardyPercentage();
		Assert.assertEquals("Employee Name", txt);
	}

	@Test(priority = 8)
	public void viewReimbursement() {
//		logIn();
//		rp = new ReportsPage(driver);
		pageSetup();
		rp.goToReportsPage();
		String txt = rp.generateReimbursement();
		Assert.assertEquals("Employee", txt);
	}

	@Test(priority = 9)
	public void viewScheduleDetailed() {
//		logIn();
//		rp = new ReportsPage(driver);
		pageSetup();
		rp.goToReportsPage();
		String txt = rp.generateScheduledDetailed();
		Assert.assertEquals("Shift Date", txt);
	}

	@Test(priority = 10)
	public void viewMonthlySchedule() {
//		logIn();
//		rp = new ReportsPage(driver);
		pageSetup();
		rp.goToReportsPage();
		String txt = rp.generateMonthlySchedule();
		Assert.assertEquals("Shift Location", txt);
	}
	
	@Test(priority = 11)
	public void viewHistoricalReport() {
//		logIn();
//		rp = new ReportsPage(driver);
		pageSetup();
		rp.goToReportsPage();
		String txt = rp.generateHistoricalReport();
		Assert.assertEquals("Employee Name", txt);
	}
	
	@Test(priority = 12)
	public void viewPrePayroll() {
//		logIn();
//		rp = new ReportsPage(driver);
		pageSetup();
		rp.goToReportsPage();
		String txt = rp.generatePrePayrollReport();
		Assert.assertEquals("Name", txt);
	}
}
