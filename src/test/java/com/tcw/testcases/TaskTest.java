package com.tcw.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.TasksPage;
import com.tcw.utilities.DataUtil;

public class TaskTest extends LogInTest {

	TasksPage tp;

	@Test(priority = 1, dataProviderClass = DataUtil.class, dataProvider = "dp2")
	public void addTaskTest(Hashtable<String, String> data) {
		logIn();
		tp = new TasksPage(driver);
		String taskPageTtl1 = tp.goToTaskPage();
		System.out.println(taskPageTtl1);
		// Assert.assertEquals(taskPageTtl1, "Tasks");
		String succMsg1 = tp.addActualTask(data);
		Assert.assertEquals(succMsg1, "Information saved successfully.");

	}

	@Test(priority = 2)
	public void deleteTaskTest() {
		logIn();
		tp = new TasksPage(driver);
		tp.goToTaskPage();
		String msg = tp.deleteTask();
		Assert.assertTrue(msg.contains("delete"));

	}

}
