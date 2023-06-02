package saisaketh.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AndroidActions extends appiumutils {
	
	AndroidDriver driver;
	public AndroidActions(AndroidDriver driver){//creating a constructor to use driver
		super(driver);
		this.driver= driver;
		}
	
	public void longpress(WebElement element) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement)element).getId(),"duration",2000));
				Thread.sleep(1000);
	}
	boolean canScrollMore;
	
	public void scroll() {
		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			));
	}
	
	public void scrolltotop() {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList().flingToBeginning(10)"));
	}
	
	public void swipe(WebElement Swipe_element) {
		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement)Swipe_element).getId(),
						"direction", "left","percent",0.75));

	}
	int x,y;
	public void dragdrop(WebElement DragElement,int i, int j) {
		
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) DragElement).getId(),
			    "endX", i,
			    "endY", j
			));
	}
	
	public void ScrolltoElement(String text) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))"));
	}

}
