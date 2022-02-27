package com.Listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.base.BaseClass;

public class ListnersEx extends BaseClass implements ITestListener {

	public void onTestStart(ITestResult result) {

		test = BaseClass.report.createTest(result.getName());
		Log.info("test case ready to start with Name" + result.getName());
	}

	public void onTestSuccess(ITestResult result) {

		Log.info("Test case pass successfully with name" + result.getName());
		test.log(Status.PASS, "test case pass succesfully");

	}

	public void onTestFailure(ITestResult result) {
		Log.info("Test case failed with name" + result.getName());
		test.log(Status.FAIL, "test case failed");
		test.log(Status.FAIL, result.getThrowable());
		String path = takesScreenshot(result.getName());
		test.addScreenCaptureFromPath(path);

	}

	public void onTestSkipped(ITestResult result) {
		Log.info("Test case skipped with name" + result.getName());
		

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		Log.info("Test suit is finished" + context.getName());
		report.flush();
		
	}

}
