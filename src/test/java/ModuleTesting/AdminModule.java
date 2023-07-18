package ModuleTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminModule {
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
	    driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")).click();
	}


  @Test
  void addUser() throws InterruptedException {

	  driver.findElement(By.xpath("//button[text()=' Add ']")).click();
	 driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("girija");

	 driver.findElement(By.xpath("//label[text()='User Role']/parent::div/following-sibling::div/div/div/div[1]")).click();
	 WebElement form =  driver.findElement(By.xpath("//label[text()='User Role']/parent::div/following-sibling::div/div/div/div[1]"));
		form.sendKeys("Ess");
	  form.sendKeys(Keys.ARROW_DOWN);
	  form.sendKeys(Keys.ARROW_DOWN);
	  form.sendKeys(Keys.ENTER);
	// WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	// wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[1]/a[1]")));
	driver.findElement(By.xpath("//label[text()='Status']/parent::div/following-sibling::div/div/div/div[1]")).click();
WebElement status=	driver.findElement(By.xpath("//label[text()='Status']/parent::div/following-sibling::div/div/div/div[1]"));
	status.sendKeys("Enabled");
	status.sendKeys(Keys.ARROW_DOWN);
	status.sendKeys(Keys.ARROW_UP);
	status.sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input")).sendKeys("Ess");
	 driver.findElement(By.xpath("//label[text()='Password']/parent::div/following-sibling::div/input")).sendKeys("Girija@123");
	driver.findElement(By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div/input")).sendKeys("Girija@123");
	  driver.findElement(By.xpath("//button[text()=' Save ']")).click();
	Thread.sleep(2000);

  }

  @AfterMethod
	 void logout() {
	driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
	 driver.findElement(By.linkText("Logout")).click();
	 }
	 @AfterClass
	 void close() {
		  driver.close();
	 }

}
