package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{


	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups= {"Sanity","Master"})  
	public void verify_LoginData(String email, String pwd, String exp) {
		try {

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage login = new LoginPage(driver);

			login.setEmail(email);
			login.setPassword(pwd);
			login.clickLogin();

			MyAccountPage msg = new MyAccountPage(driver);
			boolean TargetValue = msg.confirmationMessage();

			if(exp.equalsIgnoreCase("valid")) {

				if(TargetValue==true) {
					
					
					logger.info("logged out clicked");
					
					msg.clickLogout();
					msg.clickLogoutContinueBtn();
					
					Assert.assertTrue(true);
				}
				
				else {
					Assert.assertTrue(false);
				}
			}
			

			if(exp.equalsIgnoreCase("invalid")) {
				
				if(TargetValue==true) {
					
					msg.clickLogout();
					msg.clickLogoutContinueBtn();
					logger.info("logged out clicked");
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
			

		}
		catch (Exception e) {
			Assert.fail();
		}
	}

}


