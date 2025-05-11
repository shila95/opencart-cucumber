package stepDefinitions;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

@SuppressWarnings("deprecation")
public class LoginStep {
	
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	MyAccountPage macc;
	
	@Given("the user navigates to Login Page")
	public void the_user_navigates_to_login_page() {
		BaseClass.getLogger().info("Navigates to Login Page...");
		hp=new HomePage(BaseClass.getDriver());
		hp.clickMyaccount();
		hp.clickLogin();
	}

	@When("the user enters email as {string} and password as {string}")
	public void the_user_enters_email_as_and_password_as(String email, String password) {
		BaseClass.getLogger().info("Enters Email and Password...");
		lp=new LoginPage(BaseClass.getDriver());
		lp.setEmail(email);
		lp.setPassword(password);
	}
	    
	@When("the user clicks on Login button")
	public void the_user_clicks_on_login_button() {
		BaseClass.getLogger().info("Click on Login Button...");
		lp.clickLogin();
	}

	@Then("the user should redirected to My Account page")
	public void the_user_should_redirected_to_my_account_page() {
		BaseClass.getLogger().info("Validating My Account Page...");
		macc=new MyAccountPage(BaseClass.getDriver());
		boolean targetpage=macc.isMyAccountPageExist();
		//System.out.println(targetpage);
		Assert.assertEquals(targetpage, true);
	}
}
