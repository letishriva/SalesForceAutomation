package salesForceLeti;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
// For LOGIN, This is one way but I also created reusable methods for all the other test cases in [LoginUtility] and [BaseAction] classes
// I wanted to see if I can use this full login as one reusable method loginToSalesForce >> CF tc20leadsTab.java (it also works)

public class tc2SFDCLogin {
    @Test
    public static WebDriver loginToSalesForce() throws InterruptedException {
        String expected = "Home Page ~ Salesforce - Developer Edition";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://login.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys("leti@isreal.com");
        driver.findElement(By.id("password")).sendKeys("testtest123");
        driver.findElement(By.id("Login")).click();
        Thread.sleep(2000);
        String actual = driver.getTitle();
        Assert.assertEquals(actual, expected, "login passed");
        return driver;
    }

    public static void logoutAndCloseSF(WebDriver driver) {
    	driver.findElement(By.partialLinkText("Logout"));
        driver.close();
    }
}