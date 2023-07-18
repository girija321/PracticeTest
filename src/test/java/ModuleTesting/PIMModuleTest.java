package ModuleTesting;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.Browser;

/**
 * 
 * @author Girija
 * 
 *         PIM Module tests
 *
 */
public class PIMModuleTest {

	// WebDriver driver;
	static String userId;

	@BeforeClass
	void launchApp() {
		Browser.openApp("chrome");
	}

	@BeforeMethod
	void loginApp() {
		Browser.driver.findElement(By.name("username")).sendKeys("Admin");
		Browser.driver.findElement(By.name("password")).sendKeys("admin123");
		Browser.driver.findElement(By.xpath("//button")).click();
		Browser.driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")).click();

	}

	@Test(priority = 1, groups = "smoke")
	void addUser() {
		Browser.driver.findElement(By.xpath("//button[text()=' Add ']")).click();
		Browser.driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("girija");
		Browser.driver.findElement(By.xpath("//input[@name='middleName']")).sendKeys("Singh");
		Browser.driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Chandrawat");
		userId = Browser.driver
				.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input"))
				.getAttribute("value");
		System.out.println("userId=" + userId);
		Browser.driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	@Test(groups = { "regression", })
	void editUser() throws InterruptedException {
		System.out.println("user id =" + userId);
		Browser.driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input"))
				.sendKeys(userId);
		Thread.sleep(3000);
		Browser.driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		Browser.driver.findElement(By.xpath("//div[@class='oxd-table-cell-actions']//button[2]")).click();
		Thread.sleep(3000);
		Browser.driver.findElement(By.xpath("//label[text()='Nickname']/parent::div/following-sibling::div/input"))
				.sendKeys("giru");
		WebDriverWait wait = new WebDriverWait(Browser.driver, Duration.ofSeconds(40));
		WebElement saveButton = Browser.driver.findElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[5]/button"));
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		Browser.driver
				.findElement(
						By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[5]/button"))
				.click();
		assertEquals(false, true);
	}

	@Test()
	void delete() {
		Browser.driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input"))
				.sendKeys(userId);
		Browser.driver.findElement(By.xpath("//button[@type='submit']")).click();
		Browser.driver.findElement(By.xpath("//div[@class='oxd-table-cell-actions']/button[1]")).click();
		Browser.driver.findElement(By.xpath("//div[@class='orangehrm-modal-footer']/button[2]")).click();

	}

	@AfterMethod
	void logout() {
		Browser.driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
		Browser.driver.findElement(By.linkText("Logout")).click();
	}

	@AfterClass
	void close() {
		Browser.driver.close();
	}

}
