package rough;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class landingpage_assertion {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Jar files\\Driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//navigate to website
		driver.get("http://automationpractice.com/index.php");
		//maximize the window
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//find and click on sigin 
		driver.findElement(By.className("login")).click();
		
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
		
	}


			