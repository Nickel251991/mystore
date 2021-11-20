package rough;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class screencapture_loginpage {

		public static void main(String[] args) throws IOException {
			System.setProperty("webdriver.chrome.driver", "C:\\Jar files\\Driver\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("http://automationpractice.com/index.php");
			
			String fileName = "automation" + getRandomString(4) +".png";
				
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(scrFile, new File("C:\\Users\\Admin\\Documents\\screenshot\\"+ fileName));
		//	FileUtils.copyFile(scrFile, new File("C:\\screenshot\\screenshots.jpg"));
			
			
			driver.quit();
		}
		
		public static String getRandomString(int length) {
			StringBuilder sb = new StringBuilder();
			String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			for (int i = 0; i < length; i++) {
				int index = (int) (Math.random() * characters.length());
				sb.append(characters.charAt(index));
			}
			return sb.toString();
	}
	
	}

