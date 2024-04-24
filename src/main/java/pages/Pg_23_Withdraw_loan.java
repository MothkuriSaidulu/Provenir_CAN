package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;

public class Pg_23_Withdraw_loan extends OnlineActions {

	// WebDriver driver;
	public Pg_23_Withdraw_loan(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[@title='Withdraw Loan Application']")
	WebElement btn_withdraw;

	@FindBy(how = How.XPATH, using = "//h1[normalize-space()='Withdraw Loan']")
	WebElement txt_withdraw;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Continue']")
	WebElement btn_continue_withdrawpage;

	@FindBy(how = How.XPATH, using = "//p[@class='message-text']")
	WebElement txt_validation_msg;
	
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Back to dashboard']")
	WebElement btm_backtodashboard;
		
	
	public void withdrawloan() throws IOException, Exception {
		
		waitForElementToBeClickable(btn_withdraw, "withdraw button");
		click(btn_withdraw, "clickonusericon");
		
		//click(txt_withdraw, "withtext");
		VerifyText_For_PageCaption(txt_withdraw, "Withdraw Loan", " Hence Passed");
		
		click(btn_continue_withdrawpage, "clickonokaybtm");
		
		Thread.sleep(4000);
		waitForElementToBeClickable(btm_backtodashboard, "backtodashboard button");
		//VerifyText_For_PageCaption(txt_validation_msg,"Withdraw Loan", "clickonusericon");
		
		click(btm_backtodashboard, "backtodashboardbutton");
		
		
	}
	
	
}
