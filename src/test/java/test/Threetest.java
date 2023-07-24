package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Resource.base;

public class Threetest extends base {

	@Test
	public void testthree() throws IOException, InterruptedException {
		
		WebDriver driver = initilizer();
		driver.get("https://tutorialsninja.com/demo/");
		
		Thread.sleep(2000);
		
		System.out.println("This is updated by karan");
	driver.close();
	
}
}
