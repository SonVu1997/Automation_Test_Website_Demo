package Verify_Link;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
	
public class Verify_Customer_Service {
	WebDriver driver;
 
  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
  }
  @Test
  public void Customer_Service() {
	  driver.manage().window().maximize();
	  driver.get("http://live.demoguru99.com");
	  
	  driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[3]/div/div[2]/ul/li[3]/a")).click();
	  
	  String string = driver.getTitle();
	  System.out.println(string);
  }
  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
