package ModuleTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LeaveModule {

	WebDriver driver= new ChromeDriver();
	   
	  @BeforeClass
	  void launchApp() {
		  
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  }
	   
	   
	    @BeforeMethod
	   void loginApp() {
	     
	    	driver.findElement(By.name("username")).sendKeys("Admin");
			driver.findElement(By.name("password")).sendKeys("admin123");
		    driver.findElement(By.xpath("//button")).click();
		    driver.findElement(By.xpath("//span[text()='Leave']")).click();
		}
	    @Test
	   void addUser() {
		   driver.findElement(By.xpath("//label[text()='From Date']/parent::div/following-sibling::div/div/div/input")).click();
		   driver.findElement(By.xpath("//div[@class='oxd-calendar-selector-month-selected']")).click();
		   driver.findElement(By.xpath("//li[text()='February']")).click();
		   driver.findElement(By.xpath("//div[@class='oxd-calendar-date'][normalize-space()='8']")).click();
	   }

	}


