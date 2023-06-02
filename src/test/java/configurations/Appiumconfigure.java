package configurations;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import saisaketh.pageObjects.android.FormPage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Appiumconfigure {
	
    public static AndroidDriver driver;
	public AppiumDriverLocalService service;
	public FormPage formpage;
	
	@BeforeClass(alwaysRun=true)
	public void appiumbasics() throws InterruptedException, IOException {		
//      Start Service	
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("S:\\Selenium\\Appium_Framework\\src\\main\\java\\configurationdata\\data.properties");
		prop.load(file);
		String ip = prop.getProperty("ip");
		String port = prop.getProperty("port");
		appiumstart(ip,Integer.parseInt(port));
	
//		service.start();
		 
		//Create Android driver
		//Appium code>>send to appium server>>mobile device
		UiAutomator2Options options= new UiAutomator2Options();
		options.setChromedriverExecutable("C:\\Users\\tammi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		options.setDeviceName("sai pixel");
		options.setApp("S://Appium//Appium//src//test//java//resources//General-Store.apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //waits for 10sec before element is visible
		formpage = new FormPage(driver);
		//		Stop driver and service		
		}	
	
	public void appiumstart(String ip, int port) {
		
//		Code to start appium server

		service = new AppiumServiceBuilder().withAppiumJS
		(new File("C://Users//tammi//AppData//Roaming//npm//node_modules//appium//build//lib//main.js")).
		withIPAddress(ip).usingPort(port).build();

	}
	
	public String getscreenshot(String test, AppiumDriver driver) throws IOException {
		
		File Source = driver.getScreenshotAs(OutputType.FILE);
		
		String destinationfile = test + ".png";
		
		FileUtils.copyFile(Source, new File(destinationfile));
		
		return destinationfile;
	}
	
	
	@AfterClass
	public void closedriver() {
		driver.quit();
	//	service.stop();
	}

}
