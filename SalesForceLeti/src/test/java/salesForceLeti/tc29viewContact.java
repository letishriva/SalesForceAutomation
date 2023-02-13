package salesForceLeti;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import salesForceUtility.LoginUtility;

/*
1	Launch and Login 	Launch and Login  to SalesForce Application	SalesForce application should be Launced
2	Click Contact Tab	Click ON Contact Tab	Contact Home page should be displayed
3	Click on a contact name	Click on a <contact name> under the Name fIEld in the Recent Contact Frame	Contact Page related to <contact name>, which contains entire information about that <contact name> should be displayed 
*/
public class tc29viewContact {
//1.	Launch and Login 
	
	@Test
	public static void viewContact () throws InterruptedException {
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

//2.	Click on Contact page
		driverSF.findElement(By.id("Contact_Tab")).click();
		Thread.sleep(2000);
		
// a pop up opens!! we need to close it before  we can reach "create new account"-----------------
		driverSF.findElement(By.id("tryLexDialog"));
		driverSF.switchTo().activeElement();
		driverSF.findElement(By.id("tryLexDialogX")).click();
		Thread.sleep(2000);		
		
//3	Click on a contact name	Click on a <contact name> under the Name fIEld in the Recent Contact Frame	Contact Page related to <contact name>, which contains entire information about that <contact name> should be displayed 
		driverSF.findElement(By.partialLinkText("NewLastName")).click(); // Click on a <contact name> under the Name fIEld in the Recent Contact Frame
		Thread.sleep(2000);		
		String expected2 = "Contact: NewLastName ~ Salesforce - Developer Edition";
    	String actual2 = driverSF.getTitle();
    	Assert.assertEquals(actual2, expected2, "My contacts view should be displayed");
 
    	ba.closeBrowser(driverSF);
	}		
}