package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Resource.base;

public class Onetest extends base {

	@Test
	public void testone() throws IOException, InterruptedException {
		
		WebDriver driver = initilizer();
		driver.get("https://tutorialsninja.com/demo/");
		
		Thread.sleep(2000);
		
	driver.close();
	
	}
}
