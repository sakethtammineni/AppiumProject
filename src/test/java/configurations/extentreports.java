package configurations;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentreports {
	
	static ExtentReports reports;
	
	@BeforeTest
	public static ExtentReports Extentreports() {
		//extent reports, extent spark reporter >> we use both of them for Extent reports
		
		//Creating objects for both of them
		
String path =System.getProperty("user.dir")+"\\reports\\saa.html"; // Creates a folder named reports our maven project
		
	ExtentSparkReporter reporter = new ExtentSparkReporter(path); 
	//for this we need to give for where we need to save the file so gave path.
	
	//we can set document name/ document title name etc
	
	reporter.config().setDocumentTitle("Sai Extent reports");
	reporter.config().setReportName("Results");
	
	 reports = new ExtentReports();
	//attaching reports to extent reporter so that it can access all the tests
	reports.attachReporter(reporter);
	reports.setSystemInfo("Trying", "Sai "); //we can configure values like tester name in reports
	
	return reports;
	}

}
