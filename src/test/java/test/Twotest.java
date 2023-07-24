package test;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Resource.base;

public class Twotest extends base {
	public WebDriver driver;
	
	@Test
	public void testtwo() throws IOException, InterruptedException {
		
		
		driver = initilizer();
		driver.get("https://tutorialsninja.com/demo/");
		
		
		Assert.assertTrue(false);
	}
	
	@AfterMethod
	
	public void closure() {
		
		driver.close();
		
	}
	}
