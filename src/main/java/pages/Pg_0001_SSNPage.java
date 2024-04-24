package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;




public class Pg_0001_SSNPage extends OnlineActions{

	WebDriver driver;
	public Pg_0001_SSNPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH,using = "//h3[text()='SSN Reset Utility']")
	WebElement caption;
	
	@FindBy(how = How.XPATH,using = "//input[@id='ssn']")
	WebElement txt_SSN;
	
	@FindBy(how = How.XPATH,using = "//button[text()='Reset']")
	WebElement btn_RESET;
	
	@FindBy(how = How.XPATH,using = "//b[normalize-space()='Record updated successfully.']")
	WebElement tex_msg;
	
	
	
	public void resetSSN() throws Exception
	{
		
		waitForElementToBeVisible(caption, "Caption");
		VerifyText_For_PageCaption(caption, "SSN Reset Utility", "SSN Reset Utility Page, Hence Passed");
		waitForElementToBeVisible(txt_SSN, "SSN");
		EnterText(txt_SSN, getMapData.get("ssn"), "SSN");
		click(btn_RESET, "RESET");
		
		waitForElementToBeVisible(tex_msg, "Record updated");
		VerifyText_For_PageCaption(tex_msg, "Record updated successfully.", "SSN Reset successfully  ");
	
	 
	}
	
}
