package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;
import driver.TestBase;

public class Pg_12_LoanApprovedScreen extends OnlineActions {

	public Pg_12_LoanApprovedScreen(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	
	@FindBy (how=How.XPATH, using = "//div[@class='mm-congrats-header']")
	public static WebElement approved_valid;
	@FindBy (how=How.XPATH, using = "//button[@class='mm-nonav-btn mm-btn--lg mm-btn--primary fill']")
	public static WebElement next_Approvedscreen;
	@FindBy (how=How.XPATH, using = "//h2[contains(text(),'Congratulations you are approved for an installmen')]")
	public static WebElement LPP_protection_document_header_validation;
	
	
	
	//@FindBy (how=How.XPATH, using = "//button[normalize-space()='Next']") //Commented on 31-Oct-2022
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Continue']") //Added on 31-Oct-2022
	public static WebElement next_button;
	
	
	//Added on 10-Nov-2022 Start
			@FindBy (how=How.XPATH, using = "//div[contains(text(),'sorry')]")
			public static WebElement caption_SorryForIL;
			
			@FindBy (how=How.XPATH, using = "//div[contains(text(),' for a Cash Advance for')]")
			public static WebElement caption_EligibleFor_a_Cash_Advance_for;
			
			@FindBy (how=How.XPATH, using = "//strong")
			public static WebElement caption_AmountYouCanOptForSPL;
			
			@FindBy (how=How.XPATH, using = "//button[text()='Proceed with Cash Advance']")
			public static WebElement btn_Proceed_with_Cash_Advance;
			
			@FindBy (how=How.XPATH, using = "//button[text()='Agree and Continue']")
			public static List<WebElement> btn_Agree_and_Continue_List;
			
			@FindBy (how=How.XPATH, using = "//button[text()='Agree and Continue']")
			public static WebElement btn_Agree_and_Continue;
		//Added on 10-Nov-2022 End
	
		
	public void Approved_screen() throws Exception
	{
		
		
		//Get(denied_valid);
		Thread.sleep(2000);
		VerifyText_For_PageCaption(approved_valid, "Congratulations!", "Basic Info Page, Hence Passed");
		waitForElementToBeClickable(next_Approvedscreen,"Process with LPP documenet loan");
		
		//VerifyText_For_PageCaption(approved_valid, "Verify amouont", "Basic Info Page, Hence Passed");
		
		
		
		Thread.sleep(5000);
		click(next_Approvedscreen,"click on next button in approved popup screen"); 
		
		VerifyText_For_PageCaption(LPP_protection_document_header_validation, "Congratulations you are approved for an installment loan", "Basic Info Page, Hence Passed");
		waitForElementToBeClickable(next_button,"Process with approved loan");
		
		TestBase.bindreport(currentGlobalScenarioName, "LoanApproved"); //Added on 19-Sept-2022
		Thread.sleep(2000); //Added on 30-Nov-2022
		click(next_button,"Click on next button in approved screen");
		
		
	}
	public void Approved_screen_SPL() throws Exception
	{
		
		Thread.sleep(2000);
		VerifyText_For_PageCaption(approved_valid, "Congratulations!", "Basic Info Page, Hence Passed");
		waitForElementToBeClickable(next_Approvedscreen,"Process with LPP documenet loan");
		
		//VerifyText_For_PageCaption(approved_valid, "Verify amouont", "Basic Info Page, Hence Passed");
		
		
		
		Thread.sleep(5000);
		click(next_Approvedscreen,"click on next button in approved popup screen"); 
		
	}
	
	
	
	//Added on 10-Nov-2022 Start
	public void Approved_screen_IL_Denied_Eligible_For_Downsell_SPL() throws Exception
	{
		
		waitForElementToBeVisible(caption_SorryForIL, "WaitForCaptionSorryForIL");
		//waitForElementToBeVisible(caption_EligibleFor_a_Cash_Advance_for, "WaitForCaptionEligibleForSPL"); Commented on 14-Nov-2022
		bindreport(currentGlobalScenarioName, "Downsell Eligible");
		
		waitForElementToBeClickable(btn_Proceed_with_Cash_Advance, "WaitProceedWithCashEdvancebtn");
		click(btn_Proceed_with_Cash_Advance, "ClkProceedWithCashAdvance");
		
		Thread.sleep(5000); //Wait for the check pop-up to be come up
		if(btn_Agree_and_Continue_List.size() > 1)
		{
			click(btn_Agree_and_Continue, "ClkAgreeAndContinue");
		}
	}
	
	
	
	public void Wait_Till_Downsell_SPL() throws Exception
	{
		
		waitForElementToBeVisible(caption_SorryForIL, "WaitForCaptionSorryForIL");
		waitForElementToBeClickable(btn_Proceed_with_Cash_Advance, "WaitProceedWithCashEdvancebtn");
		Thread.sleep(2000);
	}
	//Added on 10-Nov-2022 End
	
	
	public void approve_topUp_IL_Loan() throws IOException 
	{
		VerifyText_For_PageCaption(LPP_protection_document_header_validation, "Congratulations you are approved for an installment loan", "Basic Info Page, Hence Passed");
		waitForElementToBeClickable(next_button,"Process with approved loan");
		click(next_button,"Clock on next button in approved screen");
	}
	
}
	