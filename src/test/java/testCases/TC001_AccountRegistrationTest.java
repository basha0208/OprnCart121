package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass {



	@Test(groups = {"Regression", "Master"})
	public void verify_Account_Registration()  {
		
		logger.info("... Started....");

		HomePage hp = new HomePage(driver);

		hp.clickMyAccount();
		hp.clickRegister();

		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString() +"@gmail.com");
		regpage.setTelephone(randomNumber());

		String pwd = randomAlphaNumeric();
		regpage.setPassword(pwd);
		regpage.confirmPassword(pwd);

		regpage.agreeButton();
		regpage.clickContinue();

		String congmsg =  regpage.getConfirmationmsg();
		Assert.assertEquals(congmsg, "Your Account Has Been Created!");



	}


}
