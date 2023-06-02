package saisaketh.pageObjects.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import saisaketh.utils.AndroidActions;

public class Productpage extends AndroidActions {
	AndroidDriver driver;

	public Productpage(AndroidDriver driver){//creating a constructor to use driver
		super(driver);
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement carticon;
	


	public String itemname;
	public void ScrolltoProduct(String itemname) {
		ScrolltoElement(itemname);
        int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for(int i=0;i<count;i++) {
			
			String name= driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			
			if(name.equalsIgnoreCase( itemname) )
			{
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}
	}
	
	public Cartpage carticon()
	{
		carticon.click();
		return new Cartpage(driver);
	}
}
