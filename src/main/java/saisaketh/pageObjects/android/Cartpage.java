package saisaketh.pageObjects.android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import saisaketh.utils.AndroidActions;
import saisaketh.utils.appiumutils;

public class Cartpage extends AndroidActions {
	
	AndroidDriver driver;

	public Cartpage(AndroidDriver driver){//creating a constructor to use driver
		super(driver);
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_back")
	private WebElement backicon;
	
	@AndroidFindBy(className="android.widget.CheckBox")
	private WebElement checkbox_incartpage;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	private WebElement terms_conditions;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement visit_website;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
	private WebElement title;
	
	
	
	public String gettitlename() {
		return(title.getText());
		 
	}

	
	public void backbtnincartpage() {
		backicon.click();
	}
	
	public void getproductnameadded() {
		String last = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(last,"PG 3");
	}
	
	
	public void productvalue_and_verifyproductvalue() {
		
List<WebElement> productprice	= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		
		int products_no = productprice.size();
		 double Total =0;
	     for(int c=0; c< products_no ; c++) {
	    	 String amount = productprice.get(c).getText(); 
	    	 Double price= Double.parseDouble(amount.substring(1));
	    	 Total = price + Total;
	     }
	     
	     String generated_total = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		    Double purchase = Double.parseDouble(generated_total.substring(1));
		    
		    System.out.println(purchase);
		    
		    
		     if(purchase == Total)
		     {
		    	 System.out.println("Purchase amout matches added items in cart");
		     }
	}
	
	public void checkboxincartpage() {
		checkbox_incartpage.click();
	}
	
	public void terms_conditionsbtn() throws InterruptedException {
		longpress(terms_conditions);
	     driver.findElement(By.id("android:id/button1")).click();
	}
	
	public void visit_website_btn() {
		visit_website.click();
	}
	

}
