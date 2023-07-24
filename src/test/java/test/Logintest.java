package test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageFactory.Landingpage;
import PageFactory.Loginpage;
import PageFactory.MyAccountpage;
import Resource.base;




public class Logintest extends base {
	public WebDriver driver;
	Logger log;
	
	@Test(dataProvider="logincredentials")
	public void login(String email,String Password,String ExpectedResult) throws IOException, InterruptedException  {
		
		
		
		 
		Landingpage landingpage=new Landingpage(driver);
		landingpage.MyAccount().click();
		log.debug("User select My account option from dropdown");
		
		landingpage.Loginoption().click();
		log.debug("User select Login option from dropdown");
		Thread.sleep(2000);
		
		Loginpage loginpage=new Loginpage(driver);
		loginpage.email().sendKeys(email);
		log.debug("User enter email id");
	
		loginpage.password().sendKeys(Password);
		log.debug("User enters password");
		
		loginpage.submitbutton().click();
		log.debug("User clicks on login button");
		
		
		MyAccountpage myacc=new MyAccountpage(driver);
		String ActualResult;
		try {
			if(myacc.MyAccountsuccess().isDisplayed()) 
				ActualResult="Success";
			log.debug("User successfully login");
			}
			catch(Exception e) {
				ActualResult="failure";
				log.debug("Login should be failed");
			}
		}
		
		@BeforeMethod
		
		 
		public void openApplication() throws IOException {
			
			log = LogManager.getLogger(Logintest.class.getName());
			driver = initilizer();
			log.debug("Launch chrome broswer");
			driver.get(prop.getProperty("url"));
			log.debug("Open application");
		}
	
	
	@AfterMethod
	
public void closure() {
		
		driver.close();
		
	}
	
	@DataProvider
	
	public Object[][] logincredentials() {
		
		Object[][] data = {{"arun.selenium@gmail.com","Second@123","Success"}};
		
		return data;
		
	}
}
