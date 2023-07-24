package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landingpage {

	
	WebDriver driver;
	
	public Landingpage(WebDriver driver) {
		
		this .driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	 @FindBy(xpath="//a[@title='My Account']")
	private WebElement MyAccount;
	
	 @FindBy(linkText="Login")
	 private WebElement Loginoption;
	
	public WebElement MyAccount() {
		
		return MyAccount;
	}
		
	public WebElement Loginoption() {
		return Loginoption;
			
	}
	
}
