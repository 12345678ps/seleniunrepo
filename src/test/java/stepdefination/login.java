package stepdefination;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import PageFactory.Landingpage;
import PageFactory.Loginpage;
import PageFactory.MyAccountpage;
import Resource.base;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class login extends base {
WebDriver driver;
Landingpage landingpage;
Loginpage loginpage;
MyAccountpage myacc;
	
	@Given("^Open aplication$")
	public void Open_aplication() throws IOException {
		driver = initilizer();
		driver.get(prop.getProperty("url"));
		
		
		
	}

	@And("^Navigate to login page$")
	public void Navigate_to_login_page() {
		
		 landingpage=new Landingpage(driver);
		landingpage.MyAccount().click();
		landingpage.Loginoption().click();
		
	}

	@When("^user enter username as \"([^\"]*)\" and password as \"([^\"]*)\"  $ ")
	public void user_enter_username_as_something_and_password_as_something(String username,String password) {
		
		Loginpage loginpage=new Loginpage(driver);
		loginpage.email().sendKeys(username);
		
		loginpage.password().sendKeys(password);
		
		
	}
	
	@And("^ser click on login button$")
	public void user_click_on_login_button() {
		
		loginpage.submitbutton().click();
	}

	
	@Then("^verify user is able to login successfully$")
public void verify_user_is_able_to_login_successfully() {
	
		 myacc=new MyAccountpage(driver);
		Assert.assertTrue(myacc.MyAccountsuccess().isDisplayed());
}

	
	@After
	
	public void closure() {
		
		driver.close();
	}
}

