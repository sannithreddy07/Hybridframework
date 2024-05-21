package banking.testcases;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import banking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig rc=new ReadConfig(); //created object to access the methods of this class
	
	public String url=rc.geturl(); // store the value of this method in a variable
	public String username=rc.getUsername();
	public String password=rc.getPassword();
	public static WebDriver driver1;
	public static Logger log;
	static String screenshotSubFolderName;
	

	@Parameters("browsername")
	@BeforeClass
	public void launch(@Optional("chrome") String brow) {
		
		switch (brow) {
		case "chrome":
		driver1=new ChromeDriver();
		break;
		case "edge":
			driver1=new EdgeDriver();
			break;
			default:
				System.out.println("entered browse is not correct");
				break;
		}
		
		driver1.manage().window().maximize();
		log=Logger.getLogger("banking");
		DOMConfigurator.configure("src/test/resources/log4j.xml");
	}
	
	@AfterClass
	public void teardown() {
		driver1.close();
	}
	
	public  String capturescreenshot(String filename) {
		if(screenshotSubFolderName==null) {
	
	LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HHmmss");

    screenshotSubFolderName = myDateObj.format(myFormatObj);
	}
	
	File sourceFile=((TakesScreenshot)driver1).getScreenshotAs(OutputType.FILE);
	
	File destFile = new File(System.getProperty("user.dir")+"\\ScreenShots\\"+screenshotSubFolderName+"\\"+filename);
	//System.getProperty("user.dir")+"\\ScreenShots\\"

	try{
		FileUtils.copyFile(sourceFile, destFile);
	}catch (Exception e){
	e.printStackTrace();
	}
return destFile.getAbsolutePath();

	
	}
	
	

}
