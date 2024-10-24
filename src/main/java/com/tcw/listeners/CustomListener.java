package com.tcw.listeners;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.tcw.base.BasePage;
import com.tcw.utilities.ScreenshotUtil;
import com.tcw.utilities.TestUtil;

public class CustomListener extends BasePage implements ITestListener, ISuiteListener {
	
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
	public static Date d = new Date();
	public static String fileName = "Extent_" + d.toString().replace(" ", "_").replace(":", "_") + ".html";
	public static ExtentReports extent = ExtentManager
			.createInstance(System.getProperty("user.dir") + "\\target\\reports\\" + fileName);
	
	public static ExtentTest test;

	public void onTestStart(ITestResult result) {

		
		test = extent.createTest(result.getTestClass().getName() + " @TestCase  " + result.getMethod().getMethodName());
		testReport.set(test);
//		BasePage bp = new BasePage();
//		bp.log.info("Test Case Started: " + result.getMethod().getMethodName());
		System.out.println("Test Case Started: " + result.getMethod().getMethodName());
		log.info("Test Case Started: " + result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE:-" + methodName + " PASSED" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		testReport.get().pass(m);
//		BasePage bp = new BasePage();
//		bp.log.info("Test Case Passed: " + result.getMethod().getMethodName());
		System.out.println("Test Case Passed: " + result.getMethod().getMethodName());
		log.info("Test Case Passed: " + result.getMethod().getMethodName());

	}

	public void onTestFailure(ITestResult result) {
		// System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("Capturing Screenshot");
		ScreenshotUtil.captureScreenshot();

		Reporter.log("<a target=\"_blank\" href=" + ScreenshotUtil.fileName + ">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=" + ScreenshotUtil.fileName + "><img src=" + ScreenshotUtil.fileName
				+ " height=200 width=200></img></a>");

		/////////////////////////////////// Extent Report ////////////////
		// String exceptionMessage =
		/////////////////////////////////// Arrays.toString(result.getThrowable().getStackTrace());
		/////////////////////////////////// -- It was giving half of the error.
		// test.fail(exceptionMessage);
		testReport.get().fail(result.getThrowable()); // It gives the complete error.
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE:- " + methodName + " FAILED" + "</b>";

		try {

			String screenshot1 = ScreenshotUtil.fileName;
			testReport.get().fail("<b><font color=red>" + "Screenshot of failure",
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.fileName).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		testReport.get().log(Status.FAIL, m);

//		BasePage bp = new BasePage();
//		//bp.log.info(result.getThrowable().toString());
//		bp.log.info("Test Case Failed: " + result.getMethod().getMethodName());
		System.out.println("Test Case Failed: " + result.getMethod().getMethodName());
		log.info("Test Case Failed: " + result.getMethod().getMethodName());

	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "Test Case:- " + methodName + " Skipped" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		testReport.get().skip(m);

//		BasePage bp = new BasePage();
//		bp.log.info("Test Case Skipped: " + result.getMethod().getMethodName());
		System.out.println("Test Case Skipped: " + result.getMethod().getMethodName());
		log.info("Test Case Skipped: " + result.getMethod().getMethodName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
//		TestRunner runner = (TestRunner) context;
//		String path = System.getProperty("user.dir");
//		runner.setOutputDirectory(path + "/target/output-testng");

	}

	public void onFinish(ITestContext context) {

		if (extent != null) {

			extent.flush();
		}
	}

	public void onFinish(ISuite suite) {
		File f = new File(projectPath + "\\src\\test\\resources\\zipFolder");
		if ((f.exists())) {
			try {
				FileUtils.cleanDirectory(f);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		TestUtil.pack();

	}

}
