package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReporter {

	
	static ExtentReports ExtentReport;
	public static ExtentReports getExtendReport() {
		
		String reports = System.getProperty("user.dir")+"\\Reports\\index.html";
		ExtentSparkReporter report=new ExtentSparkReporter(reports);
		report.config().setReportName("Tutorail ninja");
		report.config().setDocumentTitle("Test Result");
			
		
		ExtentReports ExtentReport = new ExtentReports();
		ExtentReport.attachReporter(report);
		ExtentReport.setSystemInfo("Operating system", "Windows 10");
		ExtentReport.setSystemInfo("Tested by", "Pranali");
		
		return ExtentReport;
		
	}
}
