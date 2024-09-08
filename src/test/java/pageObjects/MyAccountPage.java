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
	
	public void clickLogoutContinueBtn() {
		reLoginbtn.click();
	}
	
	public void ClickeditAccountInfo() {
		editAccountInfo.click();
	}
	
	public void setFirstName(String fname) {
		editAccountInfofirstname.sendKeys(fname);
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
  
}
