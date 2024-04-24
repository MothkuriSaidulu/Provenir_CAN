package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


import actions.OnlineActions;

public class Pg_001_HomePage extends OnlineActions {

	WebDriver driver;
	public Pg_001_HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH,using = "//h2[text()=' Received an Invitation Code in the Mail? ']")
	WebElement caption;
	
	@FindBy(how = How.XPATH,using = "//div[@id='navbarContent']//a[text()='Apply Now']")
	WebElement apply_now;
	
	
	@FindBy(how = How.XPATH,using = "//a//p[text()='Get Started']")
	WebElement get_started;
	
	@FindBy(how = How.XPATH,using = "//a[text()='Get Started']")
	WebElement get_startedmobie;
	
	
	public void GetStarted_mobile() throws Exception
	{
	waitForElementToBeVisible(caption, "Caption");
	VerifyText_For_PageCaption(caption, " Received an Invitation Code in the Mail? ", "Centz Home Page, Hence Passed");
	//waitForElementToBeClickable(apply_now, "apply_now");
	//((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();",apply_now);

	waitForElementToBeClickable(get_startedmobie,"Get Started Button");
	scrollToElement(get_startedmobie);
	click(get_startedmobie,"Get Started Button");

	}
	
	public void applyNow() throws Exception
	{
		waitForElementToBeVisible(caption, "Caption");
		VerifyText_For_PageCaption(caption, " Received an Invitation Code in the Mail? ", "Centz Home Page, Hence Passed");
		waitForElementToBeClickable(apply_now, "apply_now");
		((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();",apply_now);
		click(get_started,"Get Started Button");
		
	}
	
}
