package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_004_MyAccountCases extends BaseClass {


	@Test(groups = {"Sanity", "Master"})
	public void verify_Edit_Account_Info () {
		Actions act = new Actions(driver);
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();

		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("Email"));
		lp.setPassword(p.getProperty("Password"));
		lp.clickLogin(); 

		MyAccountPage mp = new MyAccountPage(driver);

		mp.ClickeditAccountInfo();

		mp.setFirstNameClick();
		act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		act.keyDown(Keys.DELETE).keyUp(Keys.DELETE).perform();
		mp.setFirstName(p.getProperty("FirstName_Editinfo"));

		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();	
		mp.setLastName(p.getProperty("LastName_Editinfo"));

		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();	
		mp.setEmail(p.getProperty("Email_Editinfo"));

		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		mp.setmobile(p.getProperty("Mobile_Editinfo"));

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
	@Test(groups = {"Sanity", "Master"})
	public void verify_ChangePASSWORD () {
		Actions act = new Actions(driver);
		HomePage hp = new HomePage(driver);
		hp.commonAction_HomePage();


		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("Email"));
		lp.setPassword(p.getProperty("Password"));
		lp.clickLogin(); 

		MyAccountPage mp = new MyAccountPage(driver);
		mp.clickmodifyAddressBook();
		mp.clickNewAddress();

		mp.setFirstName(p.getProperty("FirstName_Editinfo"));
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		mp.setLastName(p.getProperty("LastName_Editinfo"));
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		 mp.company(p.getProperty("Company"));
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
	mp.address1(p.getProperty("Address1"));	
		 act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
	mp.address2(p.getProperty("Address2"));	
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
	mp.city(p.getProperty("City"));	
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
	mp.postcode(p.getProperty("PostCode"));
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();

		WebElement countryelemeny= driver.findElement(By.xpath("//select[@id='input-country']"));
		Select country = new Select(countryelemeny); 
		country.selectByValue("99");

		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();

		WebElement stateElement= driver.findElement(By.xpath("//select[@id='input-zone']"));
		Select state = new Select(stateElement); 
		state.selectByValue("1503");

		mp.clickContinuebtn();

		boolean expValue=	 mp.confmsgnewcustomer();
		try {
			Assert.assertEquals(expValue, true);
		}
		catch (Exception e) {
			Assert.fail();
		}
		mp.click_Logout();



	}
}