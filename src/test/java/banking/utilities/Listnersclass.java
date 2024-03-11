package banking.utilities;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import banking.testcases.BaseClass;

public class Listnersclass extends BaseClass implements ITestListener{
	
	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	BaseClass bc=new BaseClass();
	public Capabilities capab;
	

	
	@Override
	public void onStart(ITestContext testContext) {
		
		
	File filename=new File(System.getProperty("user.dir")+"\\extentreports\\"+"report.html");
	spark=new ExtentSparkReporter(filename);
	try {
		spark.loadXMLConfig("src/test/resources/config-extent-xmlfile.xml");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	extent=new ExtentReports();
	
	
	extent.attachReporter(spark);
	extent.setSystemInfo("OS", System.getProperty("os.name"));
	extent.setSystemInfo("Java", System.getProperty("java.version"));
//	capab=((RemoteWebDriver)driver1).getCapabilities();
//	extent.setSystemInfo("Browser", capab.getBrowserName());
//	extent.setSystemInfo("BrowserVersion", capab.getBrowserVersion());
	
	
	
	spark.config().setTheme(Theme.DARK);
	spark.config().setReportName("Banking_testcases");
	spark.config().setDocumentTitle("Bankingproject");
	spark.config().setTimeStampFormat("dd-MM-yyyy HH:mm:ss");
	spark.config().setCss(".badge-primary{ background-color: #69DF65}");

	}
	
	@Override
	public void onTestStart(ITestResult result) {
		
		String testname=result.getName();
		test=extent.createTest(testname);
		test.assignAuthor("sannith");
		test.assignDevice("chrome-v.121");
		test.assignCategory("smoke testing");
	
	}


	@Override
	public void onTestSuccess(ITestResult result) {
		
		String testname=result.getName();
		
		test.log(Status.PASS, testname+" test case passed");
		//(Media) MarkupHelper.createLabel(testname, ExtentColor.GREEN));
		
	}
	


	@Override
	public void onTestFailure(ITestResult result) {
		String testname=result.getName();
		test.log(Status.FAIL, testname+" test case failed");
		// (Media) MarkupHelper.createLabel(testname, ExtentColor.RED));
		
		String screenshotpaths=bc.capturescreenshot(result.getTestContext().getName()+" "+result.getMethod().getMethodName()+".png");
		test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(screenshotpaths).build());
		test.log(Status.FAIL, result.getThrowable());
	}


	@Override
	public void onTestSkipped(ITestResult result) {
		String testname=result.getName();
		test.log(Status.SKIP, testname+" test case skipped");
		//(Media) MarkupHelper.createLabel(testname, ExtentColor.ORANGE));
	}


	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}


	
	

}
