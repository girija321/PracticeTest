package testNGpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * 
 * @author Girija
 * 
 * 
 *
 */


public class LoginTest {
	WebDriver driver;
	
	@Test
    void logIn() {
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get("https://demoqa.com/text-box");
    	driver.findElement(By.id("userName")).sendKeys("Girija Chnadrawat");
    	driver.findElement(By.id("userEmail")).sendKeys("girija.c@test.com");
    	driver.findElement(By.id("currentAddress")).sendKeys("123 ABC DR Seattle");
    	driver.findElement(By.id("permanentAddress")).sendKeys("123 ABC DR Seattle");
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("window.scrollBy(10,500)");
    	driver.findElement(By.id("submit")).click();
    }

}
