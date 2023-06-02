package saisaketh.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class appiumutils {
	//using this class where we can have common methods, Instead of having specific methods
	
	AppiumDriver driver;
	public appiumutils(AppiumDriver driver){//creating a constructor to use driver
		this.driver= driver;
		}	
	
	
	
	public void wait_for_element(WebElement title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains((title), "text", "Cart"));
	}
}
