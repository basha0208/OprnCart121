package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.thirdparty.publicsuffix.PublicSuffixPatterns;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLasttName;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtemail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txttelephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtpassword;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtconfirmpassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement btnAgree;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btncontinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirmationMessage;

	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtLasttName.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}

	public void setTelephone(String telephone) {
		txttelephone.sendKeys(telephone);
	}

	public void setPassword(String password) {
		txtpassword.sendKeys(password);
	}
	public void confirmPassword(String password) {
		txtconfirmpassword.sendKeys(password);
	}

	public void agreeButton() {
		btnAgree.click();;
	}

	public void clickContinue() {
		btncontinue.click();;
	}

	public String getConfirmationmsg() {
		try {
			return (confirmationMessage.getText());
		}
		catch (Exception e) {
			return (e.getMessage());
		}
	}
}
