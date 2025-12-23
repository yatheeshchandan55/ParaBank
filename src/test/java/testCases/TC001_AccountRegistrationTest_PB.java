package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPBPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest_PB extends BaseClass{

	
	@Test
	public void verify_account_registration() {
		
		log.info("******  Starting TC001_AccountRegistrationTest   *******");
		try {
			
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		Thread.sleep(10);
		hp.clickRegister();
		log.info("Clicked on the registration link....");
		
		AccountRegistrationPBPage rpage=new AccountRegistrationPBPage(driver);
		log.info("Providing the customer details....");
		rpage.setFirstName(randomString());
		rpage.setLastName(randomString());
		String email=randomString()+"gmail.com";
		System.out.println(email);
		rpage.setEmail(email);
		rpage.setPhone(randomNumber(10));
		String pswd=randomAlphaNumeric();
		System.out.println(pswd);
		rpage.setPassowrd(pswd);
		rpage.setConfirmPassowrd(pswd);
		rpage.clckSubscribe();
        rpage.clckPolicy();
        rpage.clckSubmit();
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
