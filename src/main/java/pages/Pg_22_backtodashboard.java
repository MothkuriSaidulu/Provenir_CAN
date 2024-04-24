package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;

public class Pg_22_backtodashboard extends OnlineActions {

	// WebDriver driver;
	public Pg_22_backtodashboard(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//i[@class='mm-icon mm-icon--person mm-header__user-icon']")
	WebElement btn_use_icon;

	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Back to Dashboard']")
	WebElement btn_BacktoDashboard;

	@FindBy(how = How.XPATH, using = "//h1[normalize-space()='Wait!']")
	WebElement txt_wait;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Ok']")
	WebElement btn_okay;

		
	
	public void backtodashboard() throws IOException, Exception {
		
		waitForElementToBeClickable(btn_use_icon, "user icon to click");
		click(btn_use_icon, "clickonusericon");
		
		click(btn_BacktoDashboard, "backtodashboardbutton");
		VerifyText_For_PageCaption(txt_wait, "Wait!", " Hence Passed");
		
		click(btn_okay, "clickonokaybtm");
		
		Thread.sleep(1000);
		
		click(btn_use_icon, "clickonusericon");
		
		click(btn_BacktoDashboard, "backtodashboardbutton");
		
		
	}
	
	
}
