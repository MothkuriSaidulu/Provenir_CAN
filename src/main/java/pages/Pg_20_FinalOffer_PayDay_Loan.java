package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;
import driver.TestBase;



public class Pg_20_FinalOffer_PayDay_Loan extends OnlineActions {

	//WebDriver driver;
		public Pg_20_FinalOffer_PayDay_Loan(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
		}


	
	@FindBy (how=How.XPATH, using = "(//h1[text()=\"Great news - you're approved!\"])")
	public static WebElement offer_head_txt;
	
	@FindBy (how=How.XPATH, using = "//div[contains(text(),'Confirm your loan details')]")
	public static WebElement header_Confirm_Your_Loan_Details;
	
	
	//@FindBy (how=How.XPATH, using = "//button[normalize-space()='Next']") //Commented on 31-Oct-2022 
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Continue']")  //Added on 31-Oct-2022
	public static WebElement next_button;
	
	
	//@FindBy (how=How.XPATH, using = "//div[text()='Loan Amount']") //Commented on 30-Nov-2022
	@FindBy (how=How.XPATH, using = "//strong[text()='Approved loan amount']") //Commented on 30-Nov-2022
	public static WebElement header_LoanAmount;

	//@FindBy (how=How.XPATH, using = "//div[text()='Loan Amount']//parent::div//input") //Commented on 30-Nov-2022
	@FindBy (how=How.XPATH, using = "//strong[text()='Approved loan amount']//parent::div//following-sibling::div//input") //Added on 30-Nov-2022
	public static WebElement txt_LoanAmount;

	@FindBy (how=How.XPATH, using = "//h3[text()='Details of the Cash Advance Agreement']")
	public static WebElement header_DetailsoftheCashAdvanceAgreement;
	
	@FindBy (how=How.XPATH, using = "//td[text()='Total to be Repaid (Amount Due)']")
	public static WebElement header_Total_to_be_Repaid;
	 
	public void finaloffer() throws Exception
	{
		
		
		Thread.sleep(4000);
		waitForElementToBeVisible(offer_head_txt, "Offer header");
		
		TestBase.bindreport(currentGlobalScenarioName, "Offer_Screenshot0");
		
		scrollIntoView(header_Confirm_Your_Loan_Details);
		TestBase.bindreport(currentGlobalScenarioName, "Offer_Screenshot1");
		
		VerifyText_For_PageCaption(offer_head_txt, "Great news - you're approved!", "approved page, Hence Passed");
		Thread.sleep(4000);
		TestBase.bindreport(currentGlobalScenarioName, "Offer_Screenshot2");
		Thread.sleep(2000); //Added on 17-Nov-2022
		click(next_button,"next button "); 
					
	}
	
	
	public void finaloffer_spl_Change_And_Verify() throws Exception
	{
		
		
		Thread.sleep(4000);
		waitForElementToBeVisible(offer_head_txt, "Offer header");
		
		VerifyText_For_PageCaption(offer_head_txt, "Great news - you're approved!", "approved page, Hence Passed");
		Thread.sleep(4000);
		
		scrollIntoView(header_Confirm_Your_Loan_Details);
		TestBase.bindreport(currentGlobalScenarioName, "Offer_Screenshot1");
		Thread.sleep(3000);
		scrollIntoView(header_DetailsoftheCashAdvanceAgreement);
		TestBase.bindreport(currentGlobalScenarioName, "Offer_ScreenshotORG");
		
		Thread.sleep(2000);
		scrollIntoView(offer_head_txt);
		Thread.sleep(20000); //Updated 7k from 1k on 02-Nov-2022  //Updated 20k from 7k safe side on 30-Nov-2022
		txt_LoanAmount.sendKeys(Keys.CONTROL + "a");
		txt_LoanAmount.sendKeys(Keys.DELETE);
		EnterText(txt_LoanAmount, getMapData.get("LoanAmount1") , "LoanAmount1" );
		txt_LoanAmount.sendKeys(Keys.TAB);
		Thread.sleep(20000); //Updated 7k from 3k on 02-Nov-2022 //Updated 20k from 7k safe side on 30-Nov-2022
		scrollIntoView(header_DetailsoftheCashAdvanceAgreement);
		TestBase.bindreport(currentGlobalScenarioName, "Offer_Screenshot2");
		Thread.sleep(2000);
		
		scrollIntoView(offer_head_txt);
		Thread.sleep(7000); //Updated 7k from 1k on 02-Nov-2022
		txt_LoanAmount.sendKeys(Keys.CONTROL + "a");
		txt_LoanAmount.sendKeys(Keys.DELETE);
		EnterText(txt_LoanAmount, getMapData.get("LoanAmount2") , "LoanAmount2" );
		TestBase.bindreport(currentGlobalScenarioName, "Offer_Screenshot3");
		Thread.sleep(2000);
		
		txt_LoanAmount.sendKeys(Keys.TAB);
		Thread.sleep(20000); //Updated 7k from 3k on 02-Nov-2022 //Updated 20k from 7k safe side on 30-Nov-2022
		scrollIntoView(header_DetailsoftheCashAdvanceAgreement);
		TestBase.bindreport(currentGlobalScenarioName, "Offer_Screenshot4");
		Thread.sleep(2000);
		
		
		scrollIntoView(offer_head_txt);
		Thread.sleep(7000); //Updated 7k from 1k on 02-Nov-2022
		txt_LoanAmount.sendKeys(Keys.CONTROL + "a");
		txt_LoanAmount.sendKeys(Keys.DELETE);
		EnterText(txt_LoanAmount, getMapData.get("LoanAmount3") , "LoanAmount3" );
		TestBase.bindreport(currentGlobalScenarioName, "Offer_Screenshot5");
		Thread.sleep(2000);
		
		txt_LoanAmount.sendKeys(Keys.TAB);
		Thread.sleep(20000); //Updated 7k from 3k on 02-Nov-2022 //Updated 20k from 7k safe side on 30-Nov-2022
		scrollIntoView(header_DetailsoftheCashAdvanceAgreement);
		TestBase.bindreport(currentGlobalScenarioName, "Offer_Screenshot6");
		Thread.sleep(2000);
		
		
		scrollIntoView(offer_head_txt);
		Thread.sleep(7000); //Updated 7k from 1k on 02-Nov-2022
		txt_LoanAmount.sendKeys(Keys.CONTROL + "a");
		txt_LoanAmount.sendKeys(Keys.DELETE);
		EnterText(txt_LoanAmount, getMapData.get("LoanAmount4") , "LoanAmount4" );
		TestBase.bindreport(currentGlobalScenarioName, "Offer_Screenshot7");
		Thread.sleep(2000);
		
		txt_LoanAmount.sendKeys(Keys.TAB);
		Thread.sleep(20000); //Updated 7k from 3k on 02-Nov-2022 //Updated 20k from 7k safe side on 30-Nov-2022
		scrollIntoView(header_DetailsoftheCashAdvanceAgreement);
		TestBase.bindreport(currentGlobalScenarioName, "Offer_Screenshot8");
		Thread.sleep(2000);
		
		
		scrollIntoView(offer_head_txt);
		Thread.sleep(7000); //Updated 7k from 1k on 02-Nov-2022
		txt_LoanAmount.sendKeys(Keys.CONTROL + "a");
		txt_LoanAmount.sendKeys(Keys.DELETE);
		EnterText(txt_LoanAmount, getMapData.get("LoanAmount5") , "LoanAmount5" );
		TestBase.bindreport(currentGlobalScenarioName, "Offer_Screenshot9");
		Thread.sleep(2000);
		
		txt_LoanAmount.sendKeys(Keys.TAB);
		Thread.sleep(20000); //Updated 7k from 3k on 02-Nov-2022 //Updated 20k from 7k safe side on 30-Nov-2022
		scrollIntoView(header_DetailsoftheCashAdvanceAgreement);
		TestBase.bindreport(currentGlobalScenarioName, "Offer_Screenshot10");
		
		scrollIntoView(offer_head_txt);
		Thread.sleep(7000); //Updated 7k from 1k on 02-Nov-2022
		TestBase.bindreport(currentGlobalScenarioName, "Offer_Screenshot11");
		Thread.sleep(3000);
		
		scrollIntoView(header_DetailsoftheCashAdvanceAgreement);
		Thread.sleep(1000);
		TestBase.bindreport(currentGlobalScenarioName, "Offer_Screenshot12");
		Thread.sleep(2000);
		
		click(next_button,"next button "); 
					
	}
	
	
	
	
	}
