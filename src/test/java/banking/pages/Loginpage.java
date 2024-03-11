package banking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	WebDriver driver;
	
	public Loginpage(WebDriver d) {
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	@FindBy(name="uid")
	private WebElement txtusername;
	
	@FindBy(name="password")
	private WebElement txtpassword;
	
	@FindBy(name="btnLogin")
	private WebElement loginbtn;


	public void setTxtusername(String uname) {
		txtusername.sendKeys(uname);
	}

	public void setTxtpassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}

	public void setLoginbtn() {
		loginbtn.click();
	}
	
	

}
