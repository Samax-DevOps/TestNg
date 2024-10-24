package com.tcw.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.DashboardPage;
import com.tcw.pages.TimesheetPage;
import com.tcw.utilities.DataUtil;

public class TimesheetTest extends LogInTest {

	DashboardPage dasp;
	TimesheetPage tp;

	// @Test(priority=1)
	public void tsPageHitTest() {
		logIn();
		dasp = new DashboardPage(driver);
		tp = new TimesheetPage(driver);
		dasp.goToTimesheetPage();
		String tsSrchText1 = tp.tsPageHit();
		Assert.assertEquals(tsSrchText1, "TIMESHEET SEARCH");
	}

	// Adding the Timesheet
	// @Test(priority = 2, dataProviderClass = DataUtil.class, dataProvider = "dp2")
	public void addTimeSheetTest(Hashtable<String, String> data) {
		logIn();
		dasp = new DashboardPage(driver);
		tp = new TimesheetPage(driver);
		dasp.goToTimesheetPage();
		tp.tsPageHit();
		String msg = tp.addTimeRecord(data);
		try {
			Assert.assertEquals(msg, "Information saved successfully.");
		} catch (Throwable t) {
			Assert.assertEquals(msg,
					"This user already has a time record for this date and time. Please edit or delete the time record.");
		}

	}

	// Adding the Absence
	@Test(priority = 3, dataProviderClass = DataUtil.class, dataProvider = "dp2")
	public void addAbsenceTest(Hashtable<String, String> data) {
		logIn();
		dasp = new DashboardPage(driver);
		tp = new TimesheetPage(driver);
		dasp.goToTimesheetPage();
		tp.tsPageHit();
		String msg = tp.addTimeOff(data);
		try {
			Assert.assertEquals(msg, "Information saved successfully.");
		} catch (Throwable t) {
			Assert.assertEquals(msg,
					"This user already has a time record for this date and time. Please edit or delete the time record.");
		}

	}

	@Test(priority = 4, dataProviderClass = DataUtil.class, dataProvider = "dp2")
	public void addTimeSheetTestCurrentDate(Hashtable<String, String> data) {
		logIn();
		dasp = new DashboardPage(driver);
		tp = new TimesheetPage(driver);
		dasp.goToTimesheetPage();
		tp.tsPageHit();
		String msg = tp.addTimeRecordCurrentDate(data);
		try {
			Assert.assertEquals(msg, "Information saved successfully.");
		} catch (Throwable t) {
			Assert.assertEquals(msg,
					"This user already has a time record for this date and time. Please edit or delete the time record.");
		}

	}

	@Test(priority = 5, dataProviderClass = DataUtil.class, dataProvider = "dp2", dependsOnMethods = "addTimeSheetTestCurrentDate")
	public void editTimesheetTest(Hashtable<String, String> data) {
		logIn();
		dasp = new DashboardPage(driver);
		tp = new TimesheetPage(driver);
		dasp.goToTimesheetPage();
		tp.tsPageHit();
		tp.getTheEmpForDeleteEdit(data);
		String msg = tp.editTimesheet();
		Assert.assertTrue(msg.contains("successfully"));
	}

	@Test(priority = 6, dataProviderClass = DataUtil.class, dataProvider = "dp2", dependsOnMethods = "addTimeSheetTestCurrentDate")
	public void deleteTimesheetTest(Hashtable<String, String> data) {
		logIn();
		dasp = new DashboardPage(driver);
		tp = new TimesheetPage(driver);
		dasp.goToTimesheetPage();
		tp.tsPageHit();
		tp.getTheEmpForDeleteEdit(data);
		String msg = tp.deleteTimesheet();
		Assert.assertTrue(msg.contains("deleted"));

	}

}
