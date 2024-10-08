package testCases;



import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pageObjects.HomePage;
import pageObjects.LoginPage;

public class BaseClass {


	public static WebDriver driver;
	public Logger logger;
	public Properties p;

	@Parameters({"os","browser"})
	@BeforeClass(groups= {"Sanity", "Regression", "Master"})
	public void setup(String os, String br) throws IOException {

		// Loading config.properties file

		FileReader file = new FileReader("./src//test//resources//config.properties");

		p = new Properties();
		p.load(file);

		logger = LogManager.getLogger();
		switch(br.toLowerCase())
		{
		case "chrome": driver = new ChromeDriver(); break;
		case "edge": driver = new EdgeDriver(); break;
		case "firefox": driver = new FirefoxDriver(); break;
		default: System.out.println("invalid browser name"); return;
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();

	}
	@AfterClass(groups = {"Sanity", "Regression", "Master"})
	public void tearDown() {
		driver.quit();
	}

	@SuppressWarnings("deprecation")
	public String randomString() {

		String generatedstring = 	RandomStringUtils.randomAlphabetic(5);
		return generatedstring;

	}

	@SuppressWarnings("deprecation")
	public String randomNumber() {

		String generatedNumber = 	RandomStringUtils.randomNumeric(5);
		return generatedNumber;	

	}
	@SuppressWarnings("deprecation")
	public String randomAlphaNumeric() {

		String generatedstring = 	RandomStringUtils.randomAlphabetic(5);
		String generatedNumber = 	RandomStringUtils.randomNumeric(5);
		return (generatedstring+"@"+generatedNumber);	

	}

	public String captureScreen(String tname) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		 
		 TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		 File sourceFile = takesScreenshot.getScreenshotAs (OutputType.FILE);
		 
		 String targetFilePath= System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".jpg" ;
		 File targetFile = new File(targetFilePath);
		 sourceFile.renameTo(targetFile);
		
		return targetFilePath ;
	
	}
	
	 public void commonAction() {
		 try {
		   HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("Email"));
			lp.setPassword(p.getProperty("Password"));
			lp.clickLogin();
	   }
	catch (Exception e) {
		System.out.println("Login failed");
		}
	 }
	
}
	



