package saisaketh.pageObjects.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import saisaketh.utils.AndroidActions;

//So for one page we have one java class
//all form page data will be updated here
// driver.findElement(By.xpath("//android.widget.TextView[@text='Aruba']")).click();
//to acheive above line


public class FormPage extends AndroidActions {
	
	AndroidDriver driver;

	public FormPage(AndroidDriver driver){//creating a constructor to use driver
		super(driver);
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement Name;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	private WebElement maleradiobtn;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleradiobtn;

	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement Countrydropdown;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement Submitbutton;
	
	
	

	
	public void SetName(String name) {
		Name.sendKeys(name);
		driver.hideKeyboard();
	}
	
	public void setgender(String gender) {
		if (gender.contains("male")) 
			maleradiobtn.click();
			else
			femaleradiobtn.click();
	}
	
	public void Selectcountry(String CountryName) {
		Countrydropdown.click();
		ScrolltoElement(CountryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+CountryName+"']")).click();
	}
	
	public Productpage submitbtn() {
		Submitbutton.click();
		return new Productpage(driver);
	}
	
	 public void toastmessage() {
			//Toast code
		    String Toast = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
			Assert.assertEquals(Toast, "Please enter your name");
	 }
	public void activityformpage() throws InterruptedException {
		Activity activity = new io.appium.java_client.android.Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);
		Thread.sleep(5000);
	}

}
