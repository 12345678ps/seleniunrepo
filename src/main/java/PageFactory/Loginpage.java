package PageFactory;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	
	WebDriver diver;
	
	public Loginpage(WebDriver driver) {
		
		this.diver=driver;
		PageFactory.initElements(driver,this);
	}
	
	 @FindBy(id="input-email")
	 private WebElement email;
	
	 @FindBy(id="input-password")
	 private WebElement password;
	
	 @FindBy(xpath="//input[@value='Login']")
	 private WebElement submitbutton;


public WebElement email() {
	return email;
	}

public WebElement password() {
	return password;
	}
public WebElement submitbutton() {
	return submitbutton;
	}

}
