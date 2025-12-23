package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
  
	@FindBy(xpath="//b[contains(text(),\"Welcome\")]")
	WebElement msgHeading;
	
	@FindBy(xpath="//a[contains(text(),\"Log Out\")]")
	WebElement linklogout;
	
	public void clickLogout() {
		linklogout.click();
	}
	public Boolean isMyAccountPageExists() {
		try {
		return (msgHeading.isDisplayed());
		}catch(Exception e) {
			return false;
		}
	}
	
}
