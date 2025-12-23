package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{

	
	@Test(groups= {"Regression","Master"})
	public void verify_account_registration() {
		
		log.info("******  Starting TC001_AccountRegistrationTest   *******");
		try {
			
		HomePage hp=new HomePage(driver);
		hp.clickRegister();
		log.info("Clicked on the registration link....");
		
		AccountRegistrationPage rpage=new AccountRegistrationPage(driver);
		log.info("Providing the customer details....");
		rpage.setFirstName(randomString());
		rpage.setLastName(randomString());
		rpage.setAddress(randomString());
		rpage.setCity(randomString());
		rpage.setState(randomString());
		rpage.setZipCode(randomNumber(5));
		rpage.setPhone(randomNumber(10));
		rpage.setSSN(randomNumber(4));
		String un=randomAlphaNumeric();
		rpage.setUserName(un);
		System.out.println(un);
		String pswd=randomAlphaNumeric();
		System.out.println(pswd);
		rpage.setPassowrd(pswd);
		rpage.setConfirmPassowrd(pswd);
		rpage.clckConfirm();
		
		log.info("Validating the confirmation message....");
		String confmsg=rpage.getConfirmationMessage();
		Assert.assertEquals(confmsg,"Your account was created successfully. You are now logged in.");
		}catch(Exception e) {	
			log.error("Test failed..");
			log.debug("Debug logs...");
			Assert.fail();
		}
		log.info("******  finished TC001_AccountRegistrationTest   *******");
		}
	
}
