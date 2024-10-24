package com.tcw.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.tcw.base.BasePage;

public class ScreenshotUtil extends BasePage {

	public static String fileName;

	public static void captureScreenshot() {

		BasePage bp = new BasePage();
		Date d = new Date();

		fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		File screenshot = ((TakesScreenshot) td.get()).getScreenshotAs(OutputType.FILE);
		try {
			// for index report
			//FileUtils.copyFile(screenshot,
					//new File(System.getProperty("user.dir") + "\\test-output\\html\\" + fileName));

			// For emailable report
			//FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "\\test-output\\" + fileName));
			// For Maven
			// FileUtils.copyFile(screenshot,
			// new File(System.getProperty("user.dir") + "/target/surefire-reports/html/" +
			// fileName));
			
			//For Extent
			FileUtils.copyFile(screenshot,new File( System.getProperty("user.dir")+"\\target\\reports\\"+fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void captureElementScreenshot(WebElement element) {
		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		File screenshot = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "\\screenshot\\" + fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
