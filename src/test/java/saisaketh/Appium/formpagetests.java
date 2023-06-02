package saisaketh.Appium;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import configurations.Appiumconfigure;
import saisaketh.pageObjects.android.Productpage;

public class formpagetests extends Appiumconfigure{
	
//	@BeforeMethod
//	public void applaunch() {
//		io.appium.java_client.android.Activity activity = new io.appium.java_client.android.Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
//		Appiumconfigure.driver.startActivity(activity);
//	}
//Sync fails so commenting the code
	
	@Test (priority=1, groups= {"testgroupattributes"})
	public void toastmessagecheck() throws InterruptedException {
		formpage.submitbtn();
		formpage.toastmessage();
		System.out.println("Changes in GIT");
	}
	
	@Parameters({ "name" , "gender","country" })
	@Test (priority=2,dataProvider= "appdata")
	public void formpagesubmit(String name,String gender,String country) throws InterruptedException {
		formpage.SetName(name);
		formpage.setgender(gender);
		formpage.Selectcountry(country);
		Productpage productpage = formpage.submitbtn();
		//click on back adding manually since activity class is not working
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_back")).click();
		Thread.sleep(2000);
	}
	
	
	
	@DataProvider
	public Object[][] appdata() { //since we returning data void cannot be used..
		Object[][] data = new Object[3][3];
		data[0][0] = "sai";
		data[0][1] = "male";
		data[0][2] = "Aruba";
		data[2][0] = "Saketh";
		data[2][1] = "female";
		data[2][2] = "Argentina";
		
		return data;
	}

//	@BeforeMethod()
//	public void setup() throws InterruptedException {
//		formpage.activityformpage();
//	}

	

}
