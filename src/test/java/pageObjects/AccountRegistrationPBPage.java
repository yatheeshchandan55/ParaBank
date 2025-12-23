package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class AccountRegistrationPBPage extends BaseClass {
	WebDriver driver;
	public AccountRegistrationPBPage(WebDriver driver){
		this.driver=driver;
	}
	
	 @FindBy(xpath="//input[@id='input-firstname']")
	  WebElement txtFirstName;
	  
	  @FindBy(xpath="//input[@id='input-lastname']")
	  WebElement txtLastName;
	  
	  @FindBy(xpath="//input[@id='input-email']")
	  WebElement txtEmail;
	  
	  @FindBy(xpath="//input[@id='input-telephone']")
	  WebElement txtPhone;
	  
	  @FindBy(xpath="//input[@id='input-password']")
	  WebElement txtPassword;
	  
	  @FindBy(xpath="//input[@id='input-confirm']")
	  WebElement txtConfirmPassword;
	  
	  @FindBy(xpath="//input[contains(@name,'newsletter' )and @value=1]")
	  WebElement btnSubscribe;
	  
	  @FindBy(xpath="//input[contains(@type,'checkbox')]")
	  WebElement btnPvcPolicy;
	
	  @FindBy(xpath="//input[contains(@type,'submit')]")
	  WebElement btnSubmit;
	  
	  @FindBy(xpath="//h1[contains(text(),'Your Account Has Been Created!')]")
	  WebElement confirmMessage;
	  
	  public void setFirstName(String fname) {
		  txtFirstName.sendKeys(fname);
	  }
	  
	  public void setLastName(String lname) {
		  txtLastName.sendKeys(lname);
	  }
	  
	  public void setEmail(String email) {
		  txtEmail.sendKeys(email);
	  }
	  
	  public void setPhone(String phone) {
		  txtPhone.sendKeys(phone);
	  }
	  
	  public void setPassowrd(String pswd) {
		  txtPassword.sendKeys(pswd);
	  } 
	  
	  public void setConfirmPassowrd(String cnfpswd) {
		  txtConfirmPassword.sendKeys(cnfpswd);
	  } 
	  
	  public void clckSubscribe() {
		  btnSubscribe.click();
	  }
	  
	  public void clckPolicy() {
		  btnPvcPolicy.click();
	  }
	  public void clckSubmit() {
		  btnSubmit.click();
	  }
	  public String getConfirmationMessage() {
		  try {
			  return confirmMessage.getText();
		  }catch(Exception e) {
			  return e.getMessage();
		  }
	  }
}
