package pomLogin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage {
	@FindBy(name="username") public WebElement textusername; 
	@FindBy(name="password") public WebElement textpassword; 
	@FindBy(xpath="//button") public WebElement btmlogin; 
	@FindBy(css =".orangehrm-login-forgot-header") public WebElement linkforgotpasswaod; 
	
	public void loginPage (String username, String password ) {
		textusername.sendKeys(username);
		textpassword.sendKeys(password);
		btmlogin.click();
	}
	
	public void clickOnFrogetPassword() {
		linkforgotpasswaod.click();
	}
	
}
