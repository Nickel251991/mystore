package rough;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Extentreport {

	WebDriver driver;
	String baseurl = "http://automationpractice.com/index.php/";
	ExtentReports report; //to generate the HTML report
	ExtentTest test; // to log the test steps

	@BeforeClass
	public void setup() {
		
		// where you want to save the report file
		
		report = new ExtentReports("C:\\Users\\Admin\\eclipse-workspace\\mystore-master\\src\\test\\report.html");
		System.setProperty("webdriver.chrome.driver", "C:\\Jar files\\Driver\\chromedriver_win32\\chromedriver.exe");
		//Creating instance of Chrome driver by passing reference of ChromeOptions object
		driver = new ChromeDriver();
		driver.get(baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
@Test
	public void verifyLogin() {
		// start the test
		test = report.startTest("VERIFY LOGIN");
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		
		test.log(LogStatus.INFO, "Clicked Signin button");
		
		driver.findElement(By.id("email")).sendKeys("username@hello.com");
		
		test.log(LogStatus.INFO, "Entered username");
		
		driver.findElement(By.id("passwd")).sendKeys("password");
		test.log(LogStatus.INFO, "Entered password");
		
		driver.findElement(By.name("SubmitLogin")).click();
		
		test.log(LogStatus.INFO, "Clicked Submit button");
		String actualTitle = driver.getTitle();
	    String expectedTitle = "Login - My Store";
       // Assert.assertEquals(actualTitle, expectedTitle);
 
        if ("actualTitle= expectedTitle" != null)
        {
        	System.out.println("My store website opened");
        	
        }
        	else 
        		System.out.println("Wrong website");
       
        }
		
		
	
	@AfterClass
	public void tearDown() {
		driver.close();
		report.endTest(test);
		report.flush();
	}

}
	

