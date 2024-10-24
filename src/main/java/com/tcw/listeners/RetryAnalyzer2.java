package com.tcw.listeners;

import java.util.concurrent.atomic.AtomicInteger;

import org.testng.ITestResult;
import org.testng.util.RetryAnalyzerCount;

public class RetryAnalyzer2 extends RetryAnalyzerCount {
	
	private static final int MAX_RETRY_ATTEMPTS = 2;
    private AtomicInteger counter = new AtomicInteger(1); //used only for logging purposes

    public RetryAnalyzer2() {
        setCount(MAX_RETRY_ATTEMPTS);
    }

	@Override
	public boolean retryMethod(ITestResult result) {
		 if (counter.getAndIncrement() > MAX_RETRY_ATTEMPTS) {
		      return retryMethod(result);
		    }
		    return true;
	}

}
