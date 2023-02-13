
package salesForceLeti;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import salesForceUtility.LoginUtility;
/*
2	Select 'Todays leads'	Select 'My unread leads' from the view drop down and logout from the application	Todays leads' should be selected from the drop down and the salesforce login page appears
3	Login to salesforce again	Enter Username and pasword and click login 	User should be logged in to the application
4	Click leads tab link from Home Page	Click leads tab link from Home Page	Leads homepage should be displayed
5	click Go button	Click on go button without changing list selection	Which ever default view was selected during last session, that page should be displayed.Ex:'Todays leads' view should have been the default view and that view's page should be displayed once the go button is clicked

*/
public class tc22leadsDefaultView {
	    @Test
    public static void leadsDefaultView() throws InterruptedException {
    	WebDriver driverSF;		
		BaseAction ba = new BaseAction();
		LoginUtility loginSF =  new LoginUtility();
		driverSF = ba.getWebDriver("chrome");
		ba.setMaxWindowBrowser(driverSF);
		loginSF.loginToSalesForce(driverSF);
		Thread.sleep(2000); // we let the page load
		String actual = driverSF.getTitle();
		String expected = "Home Page ~ Salesforce - Developer Edition";
		Assert.assertEquals(actual, expected, "login passed");
		Thread.sleep(2000);
    	
//2	Select 'Todays leads'	Select 'My unread leads' from the view drop down and logout from the application	Todays leads' should be selected from the drop down and the salesforce login page appears
 	
		WebElement leadsMenu = driverSF.findElement(By.id("fcf"));
		Select MyUnreadLeads = new Select(leadsMenu);
		MyUnreadLeads.selectByVisibleText("My Unread Leads");
		Thread.sleep(3000);
//logout		
	 	String newPage = driverSF.getTitle();
    	System.out.println("Name of the page after selecting My Unread Leads: " + newPage);
    	driverSF.findElement(By.id("userNavLabel")).click();// userNavLabel id > for username dropdowm to be clicked
		driverSF.findElement(By.partialLinkText("Logout")).click(); // logout
		Thread.sleep(3000);
    	String pageAfterLogout = driverSF.getTitle();
    	System.out.println("Name of the page after logout: " + pageAfterLogout);
		Thread.sleep(3000);
		
		
//	3	Login to salesforce again	Enter Username and pasword and click login 	User should be logged in to the application
// 4	Click leads tab link from Home Page	Click leads tab link from Home Page	Leads homepage should be displayed
    	driverSF = tc2SFDCLogin.loginToSalesForce();
    	driverSF.findElement(By.id("Lead_Tab")).click();
    	Thread.sleep(3000);
    	// a pop up opens!! we need to close it before we can reach "create new account"-----------------
    	driverSF.switchTo().activeElement();
    	driverSF.findElement(By.id("tryLexDialogX")).click();
    	Thread.sleep(3000);

    	String expected2 = "Leads: Home ~ Salesforce - Developer Edition";
    	String actual2 = driverSF.getTitle();
    	 Assert.assertEquals(actual2, expected2, "login and Leads Home page passed again");
		
//	5	click Go button	Click on go button without changing list selection	Which ever default view was selected during last session, that page should be displayed.Ex:'Todays leads' view should have been the default view and that view's page should be displayed once the go button is clicked

    	driverSF.findElement(By.name("go")).click();
    	Thread.sleep(3000);
    	// My Unread Leads was selected during last session and should be displayed
    	
// How To assess ? Should I take a screenshot ???
    	ba.closeBrowser(driverSF);
    	}
   }
// PASS