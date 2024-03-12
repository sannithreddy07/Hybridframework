package banking.testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import banking.pages.Loginpage;

public class TC_LoginTest_001 extends BaseClass{
	
	
	@Test
	public void tc_logintest_001() {
		driver1.navigate().to(url);
		log.info("url opened");
		Loginpage lp=new Loginpage(driver1);
		lp.setTxtusername(username);
		log.info("entered username");
		lp.setTxtpassword(password);
		log.info("entered password");
		lp.setLoginbtn();
		log.info("clicked on login btn");
		if(driver1.getTitle().equals("GTPL Bank Manager HomePage")) {
			Assert.assertTrue(true);
			log.info("title matched login success");
		}else {
			Assert.assertTrue(false);
			log.info("title not matched login failed");
		}
		log.info("******************************************");
	}
	

}
