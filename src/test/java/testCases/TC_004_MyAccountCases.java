package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_004_MyAccountCases extends BaseClass {


	@Test(groups = {"Sanity", "Master"})
	public void verify_Edit_Account_Info () {

		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();

		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("Email"));
		lp.setPassword(p.getProperty("Password"));
		lp.clickLogin(); 

		MyAccountPage mp = new MyAccountPage(driver);

		mp.ClickeditAccountInfo();
		mp.setFirstName(p.getProperty("FirstName_Editinfo"));
		mp.setLastName("LastName_Editinfo");
		mp.setEmail("Email_Editinfo");
		mp.setmobile("Mobile_Editinfo");
		mp.clickContinuebtn();

		boolean Targetalue =  mp.editInfoConfMsg();
		try {
			Assert.assertEquals(Targetalue, true);
		}
		catch(Exception e) {
			Assert.fail();
		}
		mp.click_Logout();

	}
	@Test(groups = {"Sanity", "Master"})
	public void verify_Change_PASSWORD () {

		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();

		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("Email"));
		lp.setPassword(p.getProperty("Password"));
		lp.clickLogin(); 

		MyAccountPage mp = new MyAccountPage(driver);
	mp.clickChangePassword();
	mp.setnewPassword(p.getProperty("New_Pasword"));
	mp.setConfirmPassword(p.getProperty("Confirm_New_Paasword"));
	mp.clickContinuebtn();
	
	boolean Targetalue =  mp.editInfoConfMsg();
	try {
		Assert.assertEquals(Targetalue, true);
	}
	catch(Exception e) {
		Assert.fail();
	}
	mp.click_Logout();
}
}