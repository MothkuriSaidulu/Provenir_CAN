package pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


import actions.OnlineActions;

public class Pg_002_SignInMoneyMartPage extends OnlineActions {

	// WebDriver driver;
	public Pg_002_SignInMoneyMartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//h1[text()='Sign in to Money Mart']")
	WebElement caption;

	@FindBy(how = How.XPATH, using = "//span[text()='Sign In / Sign Up']")
	WebElement btn_SignInSignUp;

	@FindBy(how = How.XPATH, using = "//input[@name='email']")
	WebElement txt_email;

	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	WebElement txt_password;

	@FindBy(how = How.XPATH,using = "//button[@class='mm-btn mm-btn--lg mm-btn--block mb-2']")
	WebElement btn_SignIn;	
	
	public void enterEmailPassword() throws IOException {
		waitForElementToBeVisible(caption, "Caption");
		VerifyText_For_PageCaption(caption, "Sign in to Money Mart", "Sign in to Money Mart, Hence Passed");
		txt_email.sendKeys(Keys.CONTROL + "a");
		txt_email.sendKeys(Keys.DELETE);
		EnterText(txt_email, getMapData.get("eMail"), "emailId");
		txt_password.sendKeys(Keys.CONTROL + "a");
		txt_password.sendKeys(Keys.DELETE);
		EnterText(txt_password, getMapData.get("Password"), "Password");
	}
	
	public void clickSignIn() throws IOException {
		waitForElementToBeClickable(btn_SignIn, "waitSignIn");
		click(btn_SignIn, "clickSignIn");
	}

}
