package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_002_LoginPage extends BaseClass{

	
	@Test(groups = {"Sanity", "Master"})
	public void verifyLoginPage() {
		
		logger.info("*** Starting Test Case****");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		logger.info("*****Login clicked****");
		
		LoginPage login = new LoginPage(driver);
		
	    login.setEmail(p.getProperty("Email"));
	    login.setPassword(p.getProperty("Password"));
		login.clickLogin();
		
		MyAccountPage msg = new MyAccountPage(driver);
		  boolean TargetValue = msg.confirmationMessage();
		  Assert.assertTrue(TargetValue);
		  logger.info("*****finished****");
		}
		
		
		catch (Exception e) {
			Assert.fail();
		}
		
	}
}
