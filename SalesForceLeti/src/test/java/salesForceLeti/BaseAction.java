package salesForceLeti;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseAction {



	/**
	 * Method to Return us WebDriver please provide inputs chrome, firefox, edge
	 *
	 * 
	 * @return WebDriver
	 */	
	public WebDriver getWebDriver(String browserName) {

		WebDriver driver;
		System.out.println("Driver is defined in the Base Action Class");
		switch(browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			return driver;			
		case "firefox":
			WebDriverManager.firefoxdriver().setup(); 
			driver = new FirefoxDriver();
			return driver;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver =  new EdgeDriver();	 
			return driver;
			//... more cases as needed ...
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			return driver;
		}
	}

	//Test
	public void setMaxWindowBrowser(WebDriver dr) {		  
		dr.manage().window().maximize();
	}


	public  void closeBrowser(WebDriver dr) {
		dr.close();
	}
}

