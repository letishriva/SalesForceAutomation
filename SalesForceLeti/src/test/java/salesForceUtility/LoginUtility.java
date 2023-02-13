package salesForceUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginUtility {
	
	//I want to make Login as a reusable method
	//It requires Driver,URL,UserId and Password
	
	public void loginToSalesForce(WebDriver dr) throws InterruptedException {
				
		System.out.println("Entered class LoginUtility");
		dr.get("https://login.salesforce.com/");
		Thread.sleep(2000);		
		dr.findElement(By.id("username")).sendKeys("leti@isreal.com"); 
		dr.findElement(By.id("password")).sendKeys("testtest123"); 
		dr.findElement(By.id("Login")).click();
	}
}
