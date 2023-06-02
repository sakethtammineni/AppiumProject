package saisaketh.Appium;

import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import configurations.Appiumconfigure;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import saisaketh.pageObjects.android.Cartpage;
import saisaketh.pageObjects.android.FormPage;
import saisaketh.pageObjects.android.Productpage;
import saisaketh.utils.AndroidActions;
import saisaketh.utils.appiumutils;

public class PracticeApp extends Appiumconfigure {
	

	@Test
	public void fillform() throws InterruptedException {
		
		formpage.submitbtn();
		formpage.toastmessage();
	    formpage.SetName("Sai Saketh");
		formpage.setgender("male");
		formpage.Selectcountry("Aruba");
		Productpage productpage = formpage.submitbtn();
		productpage.ScrolltoProduct("PG 3");
		Cartpage cartpage = productpage.carticon();
		Thread.sleep(1000);
		cartpage.backbtnincartpage();
		productpage.scrolltotop();
		productpage.ScrolltoProduct("Converse All Star");
		productpage.carticon();
		//cartpage.gettitlename();
		
		
		cartpage.getproductnameadded();
		cartpage.productvalue_and_verifyproductvalue();
		cartpage.checkboxincartpage();
		cartpage.terms_conditionsbtn();
		cartpage.visit_website_btn();
		Thread.sleep(2000);		    
	
	     		
	     Thread.sleep(10000);
	     Set<String> contexts = driver.getContextHandles();
	     for(String ContextName: contexts) {
	    	 System.out.println(ContextName);  	 
	     }
	     driver.context("WEBVIEW_com.androidsample.generalstore");
	     driver.findElement(By.name("q")).sendKeys("Sai Saketh 42Gears");
	     driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	     Thread.sleep(4000);
		 driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 driver.context("NATIVE_APP");
	}
}
