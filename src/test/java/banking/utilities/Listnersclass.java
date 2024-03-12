package banking.utilities;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


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
	ExtentTest test;
	BaseClass bc=new BaseClass();
	
	String report;
	

	
	@Override
	public void onStart(ITestContext testContext) {
		
		LocalDateTime myDateObj1 = LocalDateTime.now();
	    DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HHmmss");	
	    report=myDateObj1.format(myFormatObj1);
	File filename=new File(System.getProperty("user.dir")+"\\extentreports\\"+"Test-Report"+report+".html");
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
	
	

	spark.config().setTheme(Theme.DARK);
	spark.config().setReportName("Banking_testcases");
	spark.config().setDocumentTitle("Bankingproject");
	spark.config().setTimeStampFormat("dd-MM-yyyy HH:mm:ss");
	spark.config().setCss(".badge-primary{ background-color: #69DF65}");

	}
	
//	@Override
//	public void onTestStart(ITestResult result) {
//		
//
//		test=extent.createTest(result.getName());
//		test.assignAuthor("sannith");
//		test.assignDevice("chrome-v.121");
//		test.assignCategory("smoke testing");
//	
//	}


	@Override
	public void onTestSuccess(ITestResult result) {
		
		
		test=extent.createTest(result.getName());
		test.assignAuthor("sannith");
		test.log(Status.PASS, result.getName()+"  passed");
		
		//(Media) MarkupHelper.createLabel(testname, ExtentColor.GREEN));
		
	}
	


	@Override
	public void onTestFailure(ITestResult result) {
		
		test=extent.createTest(result.getName());
		test.assignAuthor("sannith");
		test.log(Status.FAIL, result.getName()+"  failed");
		
		
		
		String screenshotpaths=bc.capturescreenshot(result.getTestContext().getName()+" "+result.getMethod().getMethodName()+".png");
		test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(screenshotpaths).build());
		test.log(Status.FAIL, result.getThrowable());
	}


	@Override
	public void onTestSkipped(ITestResult result) {
		
		test=extent.createTest(result.getName());
		test.assignAuthor("sannith");
		test.log(Status.SKIP, result.getName()+ " skipped");
		
	}


	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}


	
	

}
