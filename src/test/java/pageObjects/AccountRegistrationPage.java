package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	WebDriver driver;
  public  AccountRegistrationPage(WebDriver driver) {
	  super(driver);
  }
  
  @FindBy(xpath="//input[@id='customer.firstName']")
  WebElement txtFirstName;
  
  @FindBy(xpath="//input[@id='customer.lastName']")
  WebElement txtLastName;
  
  @FindBy(xpath="//input[@id='customer.address.street']")
  WebElement txtAddress;
  
  @FindBy(xpath="//input[@id='customer.address.city']")
  WebElement txtCity;
  
  @FindBy(xpath="//input[@id='customer.address.state']")
  WebElement txtState;
  
  @FindBy(xpath="//input[@id='customer.address.zipCode']")
  WebElement txtZipCode;
  
  @FindBy(xpath="//input[@id='customer.phoneNumber']")
  WebElement txtPhone;
  
  @FindBy(xpath="//input[@id='customer.ssn']")
  WebElement txtSSN;
  
  @FindBy(xpath="//input[@id='customer.username']")
  WebElement txtUsername;
  
  @FindBy(xpath="//input[@id='customer.password']")
  WebElement txtPassword;
  
  @FindBy(xpath="//input[@id='repeatedPassword']")
  WebElement txtConfirmPassword;
  
  @FindBy(xpath="//input[contains(@value,'Register')]")
  WebElement btnConfirm;
  
  @FindBy(xpath="//p[contains(text(),'Your account was created successfully. You are now logged in.')]")
  WebElement confirmMessage;
  
  public void setFirstName(String fname) {
	  txtFirstName.sendKeys(fname);
  }
  
  public void setLastName(String lname) {
	  txtLastName.sendKeys(lname);
  }
  
  public void setAddress(String ads) {
	  txtAddress.sendKeys(ads);
  }
  
  public void setCity(String city) {
	  txtCity.sendKeys(city);
  }
  public void setState(String state) {
	  txtState.sendKeys(state);
  }
  public void setZipCode(String zcode) {
	  txtZipCode.sendKeys(zcode);
  }
  public void setPhone(String phone) {
	  txtPhone.sendKeys(phone);
  }
  public void setSSN(String ssn) {
	  txtSSN.sendKeys(ssn);
  }
  public void setUserName(String username) {
	  txtUsername.sendKeys(username);
  }
  public void setPassowrd(String pswd) {
	  txtPassword.sendKeys(pswd);
  } 
  
  public void setConfirmPassowrd(String cnfpswd) {
	  txtConfirmPassword.sendKeys(cnfpswd);
  } 
  
  public void clckConfirm() {
	  btnConfirm.click();
  }
  public String getConfirmationMessage() {
	  try {
		  return confirmMessage.getText();
	  }catch(Exception e) {
		  return e.getMessage();
	  }
  }
}
