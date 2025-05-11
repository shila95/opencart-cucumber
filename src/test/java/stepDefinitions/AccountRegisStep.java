package stepDefinitions;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.AccRegisPage;
import pageObjects.HomePage;

public class AccountRegisStep {
	
	WebDriver driver;
	HomePage hp;
	AccRegisPage ar;
	
	@Given("the user navigates to Account Registration Page")
	public void the_user_navigates_to_account_registration_page() {
		hp= new HomePage(BaseClass.getDriver());
		hp.clickMyaccount();
		hp.clickRegister();
	}

	@When("the user enter datail into all feild")
	public void the_user_enter_datail_into_all_feild() {
		ar=new AccRegisPage(BaseClass.getDriver());
		ar.setfirstname(BaseClass.randomAlpha());
		ar.setLastname(BaseClass.randomAlpha());
		ar.setEmail(BaseClass.randomAlpha()+"123@gmail.com");
		ar.setTelephone(BaseClass.randomNumeric());
		
		String passwd=BaseClass.randomAlphaNumeric();
		ar.setPassword(passwd);
		ar.setConfPassword(passwd);
	}

	@When("the user selelct Privacy Policy")
	public void the_user_selelct_privacy_policy() {
		ar.selectPolicy();
	   
	}

	@When("the user click on Continuu button")
	public void the_user_click_on_continuu_button() {
	    ar.clickContinue();
	}

	@SuppressWarnings("deprecation")
	@Then("the user account should successfully created")
	public void the_user_account_should_successfully_created() {
		
		String conmsg=ar.getConfirmationMsg();
		Assert.assertEquals(conmsg, "Your Account Has Been Created!");
	}
}
