package com.tcw.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.EmployeePage;
import com.tcw.utilities.DataUtil;

public class EmployeeTest extends LogInTest {

	EmployeePage ep;

	@Test(priority = 1)
	public void landingOnEmployeePage() {
		logIn();
		ep = new EmployeePage(driver);
		String empTtl1 = ep.goToEmployeePage();
		Assert.assertEquals(empTtl1, "Employee");
	}

	@Test(priority = 2)
	public void globalSettingTest() {
		logIn();
		ep = new EmployeePage(driver);
		ep.goToEmployeePage();
		ep.globalSettingTesting();
	}

	@Test(priority = 3, dataProviderClass = DataUtil.class, dataProvider = "dp2", enabled = true)
	public void reimbursementTest(Hashtable<String, String> data) {
		logIn();
		ep = new EmployeePage(driver);
		ep.goToEmployeePage();
		String txt = ep.reimbursementTesting(data);
		Assert.assertTrue(txt.contains("Total"));
	}

	@Test(priority = 4)
	public void getEmployeeInformationTest() {
		logIn();
		ep = new EmployeePage(driver);
		ep.goToEmployeePage();
		ep.selectAnEmployeeFromActiveList();
		ep.getEmployeeInformation();

	}

	@Test(priority = 5)
	public void getEmployeePermissionsTest() {
		logIn();
		ep = new EmployeePage(driver);
		ep.goToEmployeePage();
		ep.selectAnEmployeeFromActiveList();
		ep.getEmployeePermissions();

	}

	@Test(priority = 6)
	public void getEmployeeClockInOutTest() {
		logIn();
		ep = new EmployeePage(driver);
		ep.goToEmployeePage();
		ep.selectAnEmployeeFromActiveList();
		ep.getEmployeeClockInOutInfo();

	}

	@Test(priority = 7)
	public void getEmployeeNotificationsTest() {
		logIn();
		ep = new EmployeePage(driver);
		ep.goToEmployeePage();
		ep.selectAnEmployeeFromActiveList();
		String msg = ep.getEmployeeNotificationsInfo();
		Assert.assertTrue(msg.contains("MANAGER"));
	}

	@Test(priority = 8)
	public void clockPointsTest() {
		logIn();
		ep = new EmployeePage(driver);
		ep.goToEmployeePage();
		ep.selectAnEmployeeFromActiveList();
		String msg = ep.getClockPointsInfo();
		Assert.assertTrue(msg.contains("restrictions"));
	}

	@Test(priority = 9)
	public void getEmployeePayrollTest() {
		logIn();
		ep = new EmployeePage(driver);
		ep.goToEmployeePage();
		ep.selectAnEmployeeFromActiveList();
		String msg = ep.getEmployeePayroll();
		Assert.assertTrue(msg.contains("Wage"));
	}

	@Test(priority = 10)
	public void getEmployeeReimbursementTest() {
		logIn();
		ep = new EmployeePage(driver);
		ep.goToEmployeePage();
		ep.selectAnEmployeeFromActiveList();
		String msg = ep.getEmployeeReimbursementInfo();
		Assert.assertTrue(msg.contains("Mileage"));
	}

	@Test(priority = 11)
	public void getEmployeeScheduleTest() {
		logIn();
		ep = new EmployeePage(driver);
		ep.goToEmployeePage();
		ep.selectAnEmployeeFromActiveList();
		String msg = ep.getEmployeeScheduleInfo();
		Assert.assertTrue(msg.contains("Deviation"));
	}

	@Test(priority = 12)
	public void getEmployeePtoTest() {
		logIn();
		ep = new EmployeePage(driver);
		ep.goToEmployeePage();
		ep.selectAnEmployeeFromActiveList();
		String msg = ep.getEmployeePto();
		Assert.assertTrue(msg.contains("Code"));
	}
}
