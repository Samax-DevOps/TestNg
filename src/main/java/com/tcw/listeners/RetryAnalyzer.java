package com.tcw.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	// Counter to keep track of retry attempts
	int retryAttemptCounter = 0;

	// The max limit to retry running of failed test cases
	// Set the value to the number of times we want to retry
	int maxRetryLimit = 3;

	// Method to attempt retries for failure tests
	@Override
	public boolean retry(ITestResult result) {
		if (!result.isSuccess()) {
			if (retryAttemptCounter < maxRetryLimit) {
				retryAttemptCounter++;
				return true;
			}
		}

		return false;
	}

}
