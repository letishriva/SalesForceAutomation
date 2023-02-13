package salesForceLeti;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
1	Click leads tab link from Home Page	Click leads tab link from Home Page	Link should navigate to Leads Home page
*/
public class tc20leadsTab {
    private static WebDriver driver;

    @Test
    public static void leadsTab() throws InterruptedException {
        driver = tc2SFDCLogin.loginToSalesForce();
        driver.findElement(By.id("Lead_Tab")).click();
        Thread.sleep(4000);
        // a pop up opens!! we need to close it before we can reach "create new account"-----------------
        driver.switchTo().activeElement();
        driver.findElement(By.id("tryLexDialogX")).click();
        Thread.sleep(3000);
        
        String expected = "Leads: Home ~ Salesforce - Developer Edition";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected, "login and Leads Home page passed");
        
        driver.close();
    }
}
		  
// PASS and ASSESSED
	
// ------------------------------------ DIFFERENT USE OF METHODS /////      ANOTHER WAY TO USE REUSABLE METHOD --- directly with tc2SFDCLogin Class with LoginToSalesForce() method