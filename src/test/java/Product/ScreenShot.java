package Automation_Test_Website;

import java.io.File;
import java.io.IOException;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot {
	WebDriver driver;
  @Test
  public void captureScreenMethod() throws IOException {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://amazon.in");
	  
	  File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(screenshotFile, new File("C:\\Users\\admin\\Pictures\\Screenshots\\a.png"));
	  driver.close();	
  }
}
