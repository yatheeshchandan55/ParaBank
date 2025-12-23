package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
 
	public LoginPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='username']")
	WebElement txtUsername;
	
	@FindBy(xpath="(//input[@class='input'])[2]")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@value='Log In']")
	WebElement btnLogin;
	
	public void setUsername(String uname) {
		txtUsername.sendKeys(uname);
	}
	
	public void setPassword(String psd) {
		txtPassword.sendKeys(psd);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
}
