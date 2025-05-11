package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccRegisPage extends BasePage {

	public AccRegisPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txt_fname;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txt_lname;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txt_email;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txt_tele;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txt_pswd;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txt_comfpswd;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement box_policy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btn_cont;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msg_confirmation;
	
	public void setfirstname(String fname) {
		txt_fname.sendKeys(fname);
	}

	public void setLastname(String lname) {
		txt_lname.sendKeys(lname);
	}

	public void setEmail(String email) {
		txt_email.sendKeys(email);
	}

	public void setTelephone(String tele) {
		txt_tele.sendKeys(tele);
	}

	public void setPassword(String pswd) {
		txt_pswd.sendKeys(pswd);
	}

	public void setConfPassword(String confpswd) {
		txt_comfpswd.sendKeys(confpswd);
	}

	public void selectPolicy() {
		box_policy.click();
	}

	public void clickContinue() {
		btn_cont.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return (msg_confirmation.getText());
		}

		catch (Exception e) {
			return (e.getMessage());
		}
	}

}
