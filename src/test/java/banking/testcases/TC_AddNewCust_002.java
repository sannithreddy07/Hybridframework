package banking.testcases;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.NoAlertPresentException;

import org.testng.Assert;
import org.testng.annotations.Test;

import banking.pages.AddNewCustomer;
import banking.pages.Loginpage;

public class TC_AddNewCust_002 extends BaseClass {

	
	@Test
	public void addnecust() throws InterruptedException {
		log.info("**************************************");
		driver1.navigate().to(url);
		log.info("entered url");
		Loginpage lp=new Loginpage(driver1);
		lp.setTxtusername(username);
		log.info("entered username");
		lp.setTxtpassword(password);
		log.info("entered password");
		lp.setLoginbtn();
		log.info("click login");
		
		AddNewCustomer anc=new AddNewCustomer(driver1);
	
		anc.setAddNewcustomer();
		anc.setCustname("ramesh");
		anc.setGender();
		anc.setDob("12", "05", "1990");
		anc.setAddress("Bombay");
		anc.setCity("Andheri");
		anc.setState("MH");
		anc.setPinNo(566789);
		anc.setTelePhone(984356897);
		
		String email=randomString()+"@gmail.com";
		anc.setEmail(email);
		log.info("entered all deatils ");
		anc.setSubmit();
		log.info("subitted details");
		Thread.sleep(2000);
		
//		if(driver1.getPageSource().contains("")) {
//			Assert.assertTrue(true);
//		}else
//		{
//		log.warn("deatils not saved successfully");
//			Assert.assertTrue(false);
//		}
		
		driver1.navigate().back();
		
		lp.setLogoutbtn();
		if(isAlertpresent()==true) {
			Assert.assertTrue(true);
			driver1.switchTo().alert().accept();
			driver1.switchTo().defaultContent();
		}else {
			Assert.assertFalse(true);
		}
		log.info("logged out");
		log.info("**************************************");
	}
	
	public String randomString() {
		String random=RandomStringUtils.randomAlphabetic(10);
		return random;
	}
public boolean isAlertpresent() {
	
	try {
		driver1.switchTo().alert();
		return true;
	}catch(NoAlertPresentException e) {
		return false;
	}
}

}
