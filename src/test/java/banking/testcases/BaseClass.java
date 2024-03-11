package banking.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public String url="https://demo.guru99.com/V1/index.php";
	public String username="mngr558087";
	public String password="dequnEt";
	public static WebDriver driver1;
	public static Logger log;
	
	@BeforeClass
	public void launch() {
		driver1=new ChromeDriver();
		driver1.manage().window().maximize();
		log=Logger.getLogger("banking");
	}
	
	@AfterClass
	public void teardown() {
		driver1.close();
	}

}
