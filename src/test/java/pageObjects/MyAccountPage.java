package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);

	}


	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement confmsg;

	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnklogout;

	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Login']")
	WebElement reLoginbtn;

	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logoutdropdown;
	
	public void clickLogoutDropDown() {
		logoutdropdown.click();
	}
	
	@FindBy(xpath = "//a[normalize-space()='Edit your account information']")
	WebElement editAccountInfo;

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement editAccountInfofirstname;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement setLastName;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement setEmail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement setmobile;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement clickContinue;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement confirm_msg;

	@FindBy(xpath = "//a[normalize-space()='Change your password']")
	WebElement changepwd;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement setPwd;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement setConfirmPwd;

	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement clickLogout;

	@FindBy(xpath = "//a[normalize-space()='Modify your address book entries']")
	WebElement modifyAddressBook;
	
	@FindBy(xpath = "//a[normalize-space()='New Address']")
	WebElement newAddress;
	
	
	@FindBy(xpath = "//input[@id='input-company']")
	WebElement company;
	
	
	
	@FindBy(xpath = "//input[@id='input-address-1']")
	WebElement address1;
	
	public void address1(String addr) {
		address1.sendKeys(addr);;
	}
	
	@FindBy(xpath = "//input[@id='input-address-2']")
	WebElement address2;
	
	public void address2(String addr2) {
		address2.sendKeys(addr2);;
	}
	
	@FindBy(xpath = "//input[@id='input-city']")
	WebElement city;
	
	public void city(String cit) {
		city.sendKeys(cit);;
	}
	
	@FindBy(xpath = "//input[@id='input-postcode']")
	WebElement postCode;
	
	public void postcode(String post) {
		postCode.sendKeys(post);;
	}
	
	
	
	//h2[normalize-space()='New Customer']
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement confmsgnewcustomer;
	public Boolean confmsgnewcustomer() {
		try
		{
			return (confmsgnewcustomer.isDisplayed());
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public Boolean confirmationMessage() {
		try
		{
			return (confmsg.isDisplayed());
		}
		catch (Exception e) {
			return false;
		}
	}

	public void clickLogout() {
		lnklogout.click();
	}
	public void clickmodifyAddressBook() {
		modifyAddressBook.click();
	}
	public void clickNewAddress() {
		newAddress.click();
	}

	public void clickLogoutContinueBtn() {
		reLoginbtn.click();
	}

	public void ClickeditAccountInfo() {
		editAccountInfo.click();
	}

	public void setFirstName(String fname) {
		editAccountInfofirstname.sendKeys(fname);
	}

	public void setFirstNameClick() {
		editAccountInfofirstname.click();
	}

	public void setLastName(String lname) {
		setLastName.sendKeys(lname);
	}

	public void click_Logout() {
		clickLogout.click();
	}
	public void setEmail(String email) {
		setEmail.sendKeys(email);
	}
	public void setmobile(String mobile) {
		setmobile.sendKeys(mobile);
	}
	public void clickContinuebtn() {
		clickContinue.click();
	}

	public boolean editInfoConfMsg() {
		try {
			return(confirm_msg.isDisplayed());
		}
		catch (Exception e) {
			return false;
		}
	}
	public void clickChangePassword() {
		changepwd.click();
	}
	public void setnewPassword(String newPassword) {
		setPwd.sendKeys(newPassword);
	}

	public void setConfirmPassword(String confirmpwd) {
		setConfirmPwd.sendKeys(confirmpwd);
	}
	
	public void company(String comp) {
		company.sendKeys(comp);
	}

}
