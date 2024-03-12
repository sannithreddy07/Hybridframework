package banking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {
	
	public WebDriver driver;
	
	
	@CacheLookup
	@FindBy(xpath="//a[text()='New Customer']")
	
	private WebElement addNewcustomer;
	
	@CacheLookup
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")
	private WebElement custname;
	
	@FindBy(name="rad1")
	private WebElement gender;
	
	@FindBy(name="dob")
	private WebElement dob;
	
	@FindBy(name="addr")
	private WebElement address;
	
	@FindBy(name="city")
	private WebElement city;
	
	@FindBy(name="state")
	private WebElement state;
	
	@FindBy(name="pinno")
	WebElement pinNo;
	
	@FindBy(name="telephoneno")
	private WebElement telePhone;
	
	@FindBy(name="emailid")
	private WebElement email;
	
	@FindBy(name="sub")
	private WebElement submit;
	
	public AddNewCustomer(WebDriver d) {
		this.driver=d;
		PageFactory.initElements(d, this);
	}

	public void setAddNewcustomer() {
		addNewcustomer.click();
	}

	public void setCustname(String name) {
		custname.sendKeys(name);
	}

	public void setGender() {
		gender.click();
	}

	public void setDob(String dd, String mm, String yy) {
		dob.sendKeys(dd);
		dob.sendKeys(mm);
		dob.sendKeys(yy);
	
	}

	public void setAddress(String addres) {
		address.sendKeys(addres);
	}

	public void setCity(String City) {
	city.sendKeys(City);
	}

	public void setState(String State) {
		state.sendKeys(State);
	}

	public void setPinNo(int PIN) {
		pinNo.sendKeys(String.valueOf(PIN));
	}

	public void setTelePhone(int TelePhone) {
		telePhone.sendKeys(String.valueOf(TelePhone));
	}

	public void setEmail(String Email) {
		
		email.sendKeys(Email);
		
	}

	public void setSubmit() {
		submit.click();
	}
	
	

}
