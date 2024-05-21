package banking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import banking.pages.Loginpage;
import banking.utilities.XLUtilityfile;



public class TC_LoginTest_DP_001 extends BaseClass {

@Test(dataProvider = "testdataDP")
public void tc_logintest_Dp(String usrname, String pawd) throws InterruptedException {
	driver1.navigate().to(url);
	log.info("url opened");
	Loginpage lp=new Loginpage(driver1);
	lp.setTxtusername(usrname);
	log.info("username entered");
	lp.setTxtpassword(pawd);
	log.info("password entered");
	lp.setLoginbtn();
	log.info("clicked on login btn");
	Thread.sleep(2000);
	if(isAlertPresent()==true) {
		driver1.switchTo().alert().accept();
		driver1.switchTo().defaultContent();
		Assert.assertFalse(false);
		log.warn("invalid credentials");
	}else {
		Assert.assertTrue(true);
		lp.setLogoutbtn();
		Thread.sleep(2000);
		driver1.switchTo().alert().accept();
		driver1.switchTo().defaultContent();
		log.info("login succcess");
	}
	log.info("******************************************");
	
	
}

public boolean isAlertPresent() {
	
	try {
	driver1.switchTo().alert();
	return true;
	}catch(Exception e) {
	return false;
	
}
}

@DataProvider(name="testdataDP")
public Object[][] logindata() throws IOException{
	
	XLUtilityfile xl=new XLUtilityfile(".\\"+"src\\test\\java\\banking\\testdata\\BanktestdataExcel.xlsx");
	int rows=xl.getRowCount("Sheet1");
	int cols=xl.getColCount("Sheet1", 0);
	Object[][] data=new Object[rows][cols];
	for(int i=1;i<=rows;i++) {
		for(int j=0;j<cols;j++) {
		data[i-1][j]=xl.getCelldata("Sheet1", i, j); // in excel we have 1,0 to get data but in object array it is data[0][0]--so do -1 in data[][] so that the data can be stored proper array format
		}
	}
	
	
	return data;
	
}

}
