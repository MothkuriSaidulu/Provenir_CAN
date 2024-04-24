package pages;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;
import driver.TestBase;

public class Pg_01_Home_for_Payments extends OnlineActions{

	//WebDriver driver;
	public Pg_01_Home_for_Payments(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	
	@FindBy (how=How.XPATH, using = "//span[text()='Sign In / Sign Up']")
	public static WebElement link_SignInSignUp;
	
	@FindBy (how=How.XPATH, using = "//h1[text()='Sign in to Money Mart']")
	public static WebElement caption_SignintoMart;
	
	@FindBy (how=How.XPATH, using = "//input[@name='email']")
	public static WebElement txt_Email;
	
	@FindBy (how=How.XPATH, using = "//input[@name='password']")
	public static WebElement txt_Password;
	
	@FindBy (how=How.XPATH, using = "//button[text()='Sign In']")
	public static WebElement btn_SignIn;
	
	@FindBy (how=How.XPATH, using = "//a[text()='Sign Out']")
	public static WebElement link_SignOut;
	
	@FindBy (how=How.XPATH, using = "//button[text()='Make a Payment']")
	public static WebElement btn_MakeAPayment;
	
	@FindBy (how=How.XPATH, using = "//h1[text()='Make a Payment']")
	public static WebElement caption_MakeAPayment;
	
	//span[contains(text(),'full')]
	@FindBy (how=How.XPATH, using = "//span[@class='mm-radio__box']//following-sibling::span[contains(text(),'full')]")
	public static WebElement rdo_Basedon_Text_FullPayment;
	
	//span[text()='Custom amount']
	@FindBy (how=How.XPATH, using = "//span[@class='mm-radio__box']//following-sibling::span[contains(text(),'Custom')]")
	public static WebElement rdo__Basedon_Text_CustomPayment;
	
	@FindBy (how=How.XPATH, using = "//input[@name='partPayAmount']")
	public static WebElement txt_PartPayAmount;
	
	//button[text()='Continue']
	@FindBy (how=How.XPATH, using = "//button[text()='Continue']")
	public static WebElement btn_ContinueCommon;
	
	@FindBy (how=How.XPATH, using = "//label[text()='How would you like to pay?']")
	public static WebElement caption_HowWouldYouLikeToPay;
		
	@FindBy (how=How.XPATH, using = "//span[@class='mm-radio__box']//following-sibling::span[contains(text(),'Pre')]")
	public static WebElement rdo_Basedon_Text_Pre_AuthorizedPayment;
	
	@FindBy (how=How.XPATH, using = "//p[contains(text(),'Please review the Agreement')]")
	public static WebElement caption_PleaseReviewTheAgreement;
	
	@FindBy (how=How.XPATH, using = "//button[text()='Agree & Continue']")
	public static WebElement btn_Agree_And_Continue;
	
	@FindBy (how=How.XPATH, using = "//p[contains(text(),'Success')]")
	public static WebElement caption_Success;
	
	@FindBy (how=How.XPATH, using = "//button[text()='Top Up My Loan']")
	public static WebElement btn_TopUpMyLoan;
	
	@FindBy (how=How.XPATH, using = "//button[text()='Top Up My Loan']")
	public static List<WebElement> btn_TopUpMyLoan_List;
	
	
	public void launchMMCanada_URL()
	{
		TestBase.getDriver().get(TestBase.getPropertyValue("OnlineURL"));
	}
	public void signInAndLogin() throws IOException
	{
		waitForElementToBeClickable(link_SignInSignUp, "WaitSignInSignUp");
		click(link_SignInSignUp, "clkSignInSinUp");
		waitForElementToBeVisible(caption_SignintoMart, "WaitSinInToMart");
		EnterText(txt_Email, getMapData.get("eMail"), "eMail");
		EnterText(txt_Password, getMapData.get("Password"), "Password");
		click(btn_SignIn, "clkSignIn");
	}
	
	
	public void refreshPage() throws InterruptedException 
	{
		Thread.sleep(3000); //Added for Visiblity
		getDriver().navigate().refresh();
	}
	
	
	
	public void topUpLoan() throws InterruptedException, IOException 
	{
		refreshPage();
		waitForElementToBeClickable(btn_TopUpMyLoan, "WaitTopUp");
		click(btn_TopUpMyLoan, "clkTopUpMyLoan");
	}
	
	public void topUpLoan_not_present() throws InterruptedException, IOException 
	{
		refreshPage();
		Thread.sleep(5000);
		if(btn_TopUpMyLoan_List.size() == 0)
		{
			assertTrue("Top-Up option is not present to apply second time, Hende Pass", true);
		}
		else
		{
			assertTrue("Top-Up option is present to apply second time, Hence Fail", false);
		}
	}
	
	public void makeAPartialPayment() throws IOException, InterruptedException 
	{
		
		refreshPage();
		
		waitForElementToBeClickable(btn_MakeAPayment, "waitMakeAPayment");
		click(btn_MakeAPayment, "clckMakeApayment");
		
		waitForElementToBeVisible(caption_MakeAPayment, "waitMakeAPaymentCaption");
		click(rdo__Basedon_Text_CustomPayment, "clkCustomPayment");
		EnterText(txt_PartPayAmount, getMapData.get("partialPaymentAmount"), "partialPaymentAmount");
		click(btn_ContinueCommon, "clkContinue");
		
		waitForElementToBeVisible(caption_HowWouldYouLikeToPay, "waitHowWouldYouLikeToPay");
		click(rdo_Basedon_Text_Pre_AuthorizedPayment, "clkPre_AuthorizedPayment");
		click(btn_ContinueCommon, "clkContinue");
		
		waitForElementToBeVisible(caption_PleaseReviewTheAgreement, "waitPleaseReviewTheAgreement");
		click(btn_Agree_And_Continue, "clkAgree_And_Continue");
		
		waitForElementToBeVisible(caption_Success, "waitSuccess");
		click(link_SignOut, "SingOut");
		waitForElementToBeVisible(link_SignInSignUp, "WaitSignInSignUp");
		
	}
	
	public void makeAFullPayment() throws IOException, InterruptedException 
	{
		
		refreshPage();
		
		waitForElementToBeClickable(btn_MakeAPayment, "waitMakeAPayment");
		click(btn_MakeAPayment, "clckMakeApayment");
		
		waitForElementToBeVisible(caption_MakeAPayment, "waitMakeAPaymentCaption");
		click(rdo_Basedon_Text_FullPayment, "clkCustomPayment");
		click(btn_ContinueCommon, "clkContinue");
		
		waitForElementToBeVisible(caption_HowWouldYouLikeToPay, "waitHowWouldYouLikeToPay");
		click(rdo_Basedon_Text_Pre_AuthorizedPayment, "clkPre_AuthorizedPayment");
		click(btn_ContinueCommon, "clkContinue");
		
		waitForElementToBeVisible(caption_PleaseReviewTheAgreement, "waitPleaseReviewTheAgreement");
		click(btn_Agree_And_Continue, "clkAgree_And_Continue");
		
		waitForElementToBeVisible(caption_Success, "waitSuccess");
		click(link_SignOut, "SingOut");
		waitForElementToBeVisible(link_SignInSignUp, "WaitSignInSignUp");
		
	}
	
	}
