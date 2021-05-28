package Product;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class Detail_Product {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test(description = "login with usernam and password" , priority = 1)
	public void Login() {
//		  open web site http://live.demoguru99.com
		  driver.manage().window().maximize();
		  driver.get("http://live.demoguru99.com/");
		  
//		  click link account
		  driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a")).click();
		  
//		  action link login
		  Actions actions = new Actions(driver);
		  WebElement element = driver.findElement(By.xpath("//*[@id=\"header-account\"]/div/ul/li[6]/a"));
		  actions.click(element).build().perform();
		  
//		  input email and password valid
		  driver.findElement(By.id("email")).sendKeys("NGVA@gmail.com");
		  driver.findElement(By.id("pass")).sendKeys("123456");
		  
//		  click button login
		  driver.findElement(By.id("send2")).click();
		  
//		  verify login successfully
		  String string = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/div/div[2]/p[1]")).getText();
		  if(string.contains("Hello")) {
			  System.out.println("Login Success");
		  }
		  else{
			  System.out.println("Login Failed");
		  }
	}
	@Test(description = "detail product" , priority = 2)
	public void Detail_product() {
		driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/a"));
		
//		String string = driver.getTitle();
//		String actual = "Iphone - Mobile";
//		if(string.equalsIgnoreCase(actual)) {
//			System.out.println("view detail product success");
//		}
//		else {
//			System.out.println("no success");
//		}
	}
	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
