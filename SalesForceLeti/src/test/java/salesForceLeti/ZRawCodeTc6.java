package salesForceLeti;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ZRawCodeTc6 {


	public static void main(String[] args) throws InterruptedException, Exception {
		
	//	String expectedusername = "Leti Casta";// username should be displayed after change
	//	WebDriverManager.edgedriver().setup();
	//	WebDriver driver =  new EdgeDriver();
		WebDriverManager.chromedriver().setup(); 
		WebDriver driver = new ChromeDriver();
	//	WebDriverManager.firefoxdriver().setup(); 
	//	WebDriver driver = new FirefoxDriver();
		
		
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("leti@isreal.com"); // we enter correct username
		driver.findElement(By.id("password")).sendKeys("testtest123"); //we provide correct password
		driver.findElement(By.id("Login")).click();//tc1
		Thread.sleep(3000); // we let the page load
		driver.findElement(By.id("userNavLabel")).click();// userNavLabel id > for username dropdowm to be clicked
		driver.findElement(By.partialLinkText("My Profile")).click();
		Thread.sleep(2000); // we let the page load
		/*		driver.findElement(By.id("moderatorMutton")).click();//Click on button to get the menu with edit profile
		driver.findElement(By.partialLinkText("Edit Profile")).click(); // when click, a pop up window appears
		Thread.sleep(2000); // we let the page load
		
		driver.switchTo().frame("aboutMeContentId");//we enter the iFrame id=aboutMeContentId
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys("Casta");//By default about is already selected >> Click on Last Name and change
		driver.findElement(By.cssSelector("#TabPanel > div > div.zen-body > form > div > input.zen-btn.zen-primaryBtn.zen-pas")).click();// click on save button
		
		// check if UserProfilePage with changed <lastname> is displayed
		String actualusername = driver.findElement(By.id("userNavLabel")).getText();//we get the text on menu dropdown to compare 
		System.out.println("the expected name on top of menu dropdown is: "+expectedusername);
		System.out.println("the actual name appearing on top of menu dropdown is: "+actualusername);
		if (actualusername.equalsIgnoreCase(expectedusername)) {
			System.out.println("Script passed for username"); 
		} else {
			System.out.println("Script failed for username");
		}
		System.out.println("--------------"); 
		Thread.sleep(3000);
		
		// Click on Post link, Enter the <text> to post in the post text area and click on share button
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Post")).click();
		WebElement textEditor = driver.findElement(By.id("cke_publisherRichTextEditor"));//ok
		textEditor.click(); //ok 
		Thread.sleep(2000); // we let the page load
//		Boolean utilisable = textEditor.isEnabled();//check if text editor is enable
//		System.out.println(utilisable);//true = text editor is enabled

		WebElement myFrame = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td/div/div[3]/div[1]/div/div[1]/div/div[2]/ul/li[1]/div/div/div[1]/div[1]/div[1]/div[1]/div/div[2]/div[2]/div/div/iframe"));
		driver.switchTo().frame(myFrame);
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body")).sendKeys("Test 2 new post about me"); // ok print 
		driver.switchTo().defaultContent(); //out of frame to publish with button ok
		Thread.sleep(1000);
		driver.findElement(By.id("publishersharebutton")).click();//ok share button 
		String expectedPost = "Test 2 new post about me";
		String actualPost = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td/div/div[3]/div[1]/div/div[1]/div/div[2]/ul/li[1]/div/div/div[2]/div/div[5]/div/div[1]/div[1]/div[2]/div[1]/span/p")).getText();
		if (actualPost.equalsIgnoreCase(expectedPost)) {
			System.out.println("Script passed for Post"); 
		} else {
			System.out.println("Script failed for Post");
		}
		System.out.println("--------------"); 
		
		Thread.sleep(3000);
		
		// Click on the  file link and click on "upload a file from computer" button. Click on choose file button and select a file to be uploaded and click open button.
		driver.findElement(By.partialLinkText("File")).click(); //click file link
		Thread.sleep(1000); 
		driver.findElement(By.id("chatterUploadFileAction")).click(); //click upload file from computer
		Thread.sleep(2000); 
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td/div/div[3]/div[1]/div/div[1]/div/div[2]/ul/li[1]/div/div/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/form/table/tbody/tr[1]/td/div/div[1]/input"))).click().perform();
		Thread.sleep(2000); 
	
		String filePath = "C:\\Users\\Aditya\\Documents\\letifortekarch.png"; // we send the file path to the clipboard
		StringSelection stringSelection = new StringSelection(filePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		
		Robot robot = new Robot(); 	    // we use the Robot class to pase filepath and press Enter
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);// ok
		Thread.sleep(2000);
		
		String mainWindow = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
		    if (!handle.equals(mainWindow)) {
		        driver.switchTo().window(handle);
		        driver.close();
		    }
		}
		driver.switchTo().window(mainWindow);
		driver.findElement(By.partialLinkText("File")); //find file link
		driver.findElement(By.id("publishersharebutton")).click();//we click on share button to send the photo
		System.out.println("--------------"); 
		System.out.println("Script evaluation to make to show Passed for File"); 
		Thread.sleep(3000);
		
		//click on profile image + add photo
		driver.switchTo().defaultContent(); //out of frame
	//	driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td/div/div[3]/div[1]/div/div[1]/div/div[2]/ul/li[1]/div/div/div[1]/div[1]/div[2]/div[3]/div/div[1]/span/input")).click();
		Thread.sleep(2000); 
		*/
		Thread.sleep(2000); 
		WebElement photoProfil = driver.findElement(By.id("photoSection"));

		Actions action = new Actions(driver);
		action.moveToElement(photoProfil).perform(); //Hover the mouse on myprofilephoto image and Add photo link appears.
		Thread.sleep(1000);
		driver.findElement(By.partialLinkText("Add Photo")).click(); // Click on the link to upload a photo. ok
		Thread.sleep(2000); 
//---------------------------------------------------work until here
	
		// Click on Choose file button and select the image to upload
		//driver.switchTo().frame("/html/body/iframe");//we enter the iFrame id=aboutMeContentId
		//driver.switchTo().frame("uploadPhoto");//we enter the iFrame id=aboutMeContentId
		//WebElement iframeElement2 = driver.findElement(By.id("uploadPhotoContentId")); //	we switch to uploadPhotoContentId iframe
		//driver.switchTo().frame(iframeElement2).close();
		//("https://testcompany-c3-dev-ed.develop.my.salesforce.com/userprofile/photo/upload.apexp?u=005Dn000004aZBX");

	//	List <WebElement> all_iframes = driver.findElements(By.tagName("iframe"));
	//	System.out.println(all_iframes.size()); // i get the number of iframes to check > result 3
	//	List <WebElement> all_iframes2 = driver.findElements(By.tagName("iframe"));
	//	System.out.println(all_iframes2.get(2).isDisplayed());// (0false) (1 false)  2true -->  is displayed
	//	driver.switchTo().frame(all_iframes2.get(2));
		driver.findElement(By.id("uploadPhoto"));
		driver.switchTo().frame(2);
		Thread.sleep(2000); 
		
//-----------------------------------------		how to click on button??????????????????
		
		// driver.findElement(By.xpath("//*[@id=\'j_id0:uploadFileForm\']")).click(); // xpath of button Browse //*[@id="j_id0:uploadFileForm:uploadInputFile"] INVALID ARGUMENT
		//driver.findElement(By.name("j_id0:uploadFileForm")).click();
		//driver.findElement(By.partialLinkText("Choose")).click(); //click Choose file link
		//driver.findElement(By.id("j_id0:uploadFileForm:uploadInputFile")).click();// browse button >> doesn't work
		//driver.findElement(By.xpath("/html/body/span/form/input[2]")).click(); //browse button full xpath /html/body/span/form/input[2] >> doesn't work // invalid argument to find button
		//driver.findElement(By.xpath("//*[@id='j_id0:uploadFileForm:uploadInputFile']")).click();// Choose File unable to click

		Thread.sleep(2000); 
	
		System.out.println("test 7");
		
		String filePath2 = "C:\\Users\\Aditya\\Documents\\letifortekarch.png"; // we send the image path to the clipboard ok
		System.out.println("test 8");
		StringSelection stringSelection2 = new StringSelection(filePath2);
		Clipboard clipboard2 = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard2.setContents(stringSelection2, null);

		Robot robot2 = new Robot(); 	    // we use the Robot class to paste image path and press Enter ok
		robot2.keyPress(KeyEvent.VK_CONTROL);
		robot2.keyPress(KeyEvent.VK_V);
		robot2.keyRelease(KeyEvent.VK_V);
		robot2.keyRelease(KeyEvent.VK_CONTROL);
		robot2.keyPress(KeyEvent.VK_ENTER);
		robot2.keyRelease(KeyEvent.VK_ENTER);// ok
		System.out.println("test 9");
		Thread.sleep(2000);
	
		
		
	}
}

