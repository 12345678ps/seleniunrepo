package Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {

	WebDriver driver;
	public Properties prop;
	public WebDriver initilizer() throws IOException {

		
		prop=new Properties();
		
		String Proppath = System.getProperty("user.dir")+"\\src\\main\\java\\Resource\\data.properties";
		FileInputStream fs=new FileInputStream(Proppath);
		
		prop.load(fs);
		String Browser=prop.getProperty("Browser");
		
		if(Browser.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			
		}else if(Browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
         
		}else if(Browser.equalsIgnoreCase("Internet Explorer")) {
			WebDriverManager.iedriver().setup();
			 driver=new InternetExplorerDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
		return driver;
			
		
	}

	public String screenshots(String testname,WebDriver driver) throws IOException {
	File sourcefile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String filedest = System.getProperty("user.dir")+"\\screenshot\\"+testname+".png";
	FileUtils.copyFile(sourcefile, new File(filedest));
	
	return filedest;
}
}
