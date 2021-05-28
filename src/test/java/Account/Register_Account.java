package Account;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class Register_Account {
	WebDriver driver;
	
  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
  }
  @Test
  public void Register() {
//	  Open web site http://live.demoguru99.com
	  driver.get("http://live.demoguru99.com/");
	  
//	  Click link account
	  driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a")).click();
	  
//	  Action link Register
	  WebElement element = driver.findElement(By.xpath("//*[@id=\"header-account\"]/div/ul/li[5]/a"));
	  Actions action = new Actions(driver);
	  action.click(element).build().perform();
	  
//	  Input first name, middle name and last name
	  driver.findElement(By.id("firstname")).sendKeys("Nguyen");
	  driver.findElement(By.id("middlename")).sendKeys("Van");
	  driver.findElement(By.id("lastname")).sendKeys("A");
	  driver.findElement(By.id("email_address")).sendKeys("NGVA@gmail.com");
	  driver.findElement(By.id("password")).sendKeys("123456");
	  driver.findElement(By.id("confirmation")).sendKeys("123456");
	  
//	  Click button Register
	  driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div[2]/button")).click();
	  
//	  Verify register success
	  String Actual = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div[1]/div/div[1]/div/p")).getText();
	  if(Actual.contains("Nguyen Van A")) {
		  System.out.println("Register Success");
	  }
	  else{
		  System.out.println("Register Faild");
	  }
  }
  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
