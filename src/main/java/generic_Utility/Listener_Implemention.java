package generic_Utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener_Implemention implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"------Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"------Success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"------Failed");
		WebDriver_Utility ws = new WebDriver_Utility();
		Java_Utility js = new Java_Utility();
		
		 String screenshotname = methodname+" "+js.toGetSystemdateandtime();
		 try {
			ws.ToTakesScreenshot(BaseClass.sDriver, screenshotname);
		} catch (IOException e) {
			e.printStackTrace();
		}	 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"------Skipped");
	}

	
	@Override
	public void onStart(ITestContext context) {

		System.out.println("-------Suite Execution Started");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("-------Suite Exceution Finished");		
	}

}
