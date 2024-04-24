package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;
import driver.TestBase;


public class Pg_04_Flinks extends OnlineActions {

	public Pg_04_Flinks(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	

	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Continue']")
	public static WebElement Flinks_Continue;

	@FindBy (how=How.XPATH, using = "//div[contains(text(),'ROYAL BANK OF CANADA')]")
	public static WebElement FlinksConnectedText;

	//New flinks page with changes

	@FindBy (how=How.XPATH, using = "//h1[normalize-space()='2 ways to apply']")
	public static WebElement txt_Flinks;

	@FindBy (how=How.XPATH, using = "//div[@id='express']//div[@class='box-content']")
	public static WebElement Flinks_Express;

	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Next']")
	public static WebElement btn_Next;

	@FindBy (how=How.XPATH, using = "//div[@id='standard']//div[@class='box-content']")
	public static WebElement Flinks_Standard;

	@FindBy (how=How.XPATH, using = "//a[normalize-space()=\"I don't use online/mobile banking\"]")
	public static WebElement Old_V2_btn_Idont_Agree;

	@FindBy (how=How.XPATH, using = "//a[normalize-space()=\"I don't use online/mobile banking\"]")
	public static WebElement Old_V1_btn_Idont_Agree;

	@FindBy (how=How.XPATH, using = "//iframe[@class='mm-iframe']")
	public static WebElement iFrame;

	@FindBy (how=How.XPATH, using = "//a[@title='Flinks Capital International']")
	public static WebElement Bank_FlinksCapital;

	@FindBy (how=How.ID, using = "username")
	public static WebElement flinks_UserName;

	@FindBy (how=How.ID, using = "password")
	public static WebElement flinks_Password;

	@FindBy (how=How.XPATH, using = "//input[@value='Submit']")
	public static WebElement btn_Submit;

	@FindBy (how=How.XPATH, using = "//td[contains(normalize-space(),'Answer to question')]/following-sibling::td[1]")
	public static WebElement Ans_Security_Que;
	
	@FindBy (how=How.XPATH, using = "//li[contains(text,'Answer to security question:')]")
	public static WebElement Ans_Security_Que_Old;

	@FindBy (how=How.NAME, using = "mfa-QuestionAndAnswer-0")
	public static WebElement txt_Securityque;

	@FindBy (how=How.XPATH, using = "//input[@value='Continue']")
	public static WebElement btn_Continue;

	@FindBy (how=How.XPATH, using = "//a[normalize-space()='Withdraw my consent to use Flinks']")
	public static WebElement link_WithdrawConsent;

	@FindBy (how=How.XPATH, using = "//a[@class='text-white']")
	public static WebElement link_WithdrawConsent1;


	public static void Flinks_Func() throws Exception
	{
		waitForElementToBeVisible(txt_Flinks,"Text in flinks page");
		
		//String flinksText = txt_Flinks.getText();
		//System.out.println("Flinks text is "+flinksText);
		click(Flinks_Express,"Express - fastest option");
		click(btn_Next,"Next");
		waitForElementToBeVisible(iFrame, "iFrame for flinks page");
		//WebElement ifm = driver.findElement(By.xpath("//iframe[@class='mm-iframe']"));
		TestBase.getDriver().switchTo().frame(iFrame);
		Thread.sleep(2000);
		click(Bank_FlinksCapital,"Capital bank");
		EnterText(flinks_UserName, getMapData.get("Flinks_UserName"), "Flinks username");
		EnterText(flinks_Password, getMapData.get("Flinks_Password"), "Flinks password");
		click(Flinks_Continue,"Continue button");
		waitForElementToBeVisible(Ans_Security_Que,"Security question page text");
		String seqtext = Ans_Security_Que.getText();
		//String seqtext1[]=seqtext.split(": ");
		//System.out.println("Answer to seq que is "+seqtext1[1]);
		EnterText(txt_Securityque, seqtext, "Answer to sec que");
		click(Flinks_Continue,"Continue button");
		TestBase.getDriver().switchTo().defaultContent();
		Thread.sleep(1500);
		
	}	

	public void Flinks(String LoanType) throws Exception
	{
		
		if((LoanType.equalsIgnoreCase("IL"))&&(getMapData.get("Current_Address_Province").equalsIgnoreCase("SK")))
		{
			PrintValueToReport("No flinks option for this province in IL", "Flinks option w.r.t Product");
			System.out.println("No Flinks");
		}
		else if((LoanType.equalsIgnoreCase("SPL"))&&(getMapData.get("Current_Address_Province").equalsIgnoreCase("SK")||getMapData.get("Current_Address_Province").equalsIgnoreCase("AB")))
		{
			PrintValueToReport("No flinks option for this province in SPL or EPP", "Flinks option w.r.t Product");
			System.out.println("No Flinks");
		}
		else
		{

			if(getMapData.get("User_Wants_Flinks_Optin_OR_Optout").equalsIgnoreCase("Optin"))
			{
				if(getMapData.get("User_New_OR_Existing_For_Flinks").equalsIgnoreCase("New"))
				{
					Flinks_Func();
				}
				else if(getMapData.get("User_New_OR_Existing_For_Flinks").equalsIgnoreCase("Existing"))
				{
					
					waitForElementToBeClickable(Flinks_Standard,"Flinks Standard");
					
					Thread.sleep(4000);
					click(Flinks_Express,"Continue with flinks optin");
					click(btn_Next,"Next");
				}
			}
			else if(getMapData.get("User_Wants_Flinks_Optin_OR_Optout").equalsIgnoreCase("Optout"))
			{
				if(getMapData.get("User_New_OR_Existing_For_Flinks").equalsIgnoreCase("New"))
				{
					
					waitForElementToBeVisible(txt_Flinks,"Text in flinks page");
					
					click(Flinks_Standard,"Flinks_Standard");
					click(btn_Next,"Next");

				}
				else if(getMapData.get("User_New_OR_Existing_For_Flinks").equalsIgnoreCase("Existing"))
				{
					
					Thread.sleep(2000);
					waitForElementToBeVisible(Flinks_Standard,"With draw consent");
					
					click(Flinks_Standard,"Flinks Standard");
					click(btn_Next,"Next");
				}
			}
		}
	}

	public static void Exist_IL_Flinks() throws Exception
	{
		if(getMapData.get("Current_Address_Province").equalsIgnoreCase("SK"))
		{
			PrintValueToReport("No flinks option for this province in IL", "Flinks option w.r.t Product");
			System.out.println("No Flinks");
		}
		else
		{
			if(getMapData.get("IL_User_Wants_Flinks_Optin_OR_Optout").equalsIgnoreCase("Optin"))
			{
				if(getMapData.get("IL_User_New_OR_Existing_For_Flinks").equalsIgnoreCase("New"))
				{
					Flinks_Func();
				}
				else if(getMapData.get("IL_User_New_OR_Existing_For_Flinks").equalsIgnoreCase("Existing"))
				{
					waitForElementToBeClickable(Flinks_Standard,"Flinks Standard");
					 
					Thread.sleep(4000);
					click(Flinks_Express,"Continue with flinks optin");
					click(btn_Next,"Next");
				}
			}
			else if(getMapData.get("IL_User_Wants_Flinks_Optin_OR_Optout").equalsIgnoreCase("Optout"))
			{
				if(getMapData.get("IL_User_New_OR_Existing_For_Flinks").equalsIgnoreCase("New"))
				{
					 
					waitForElementToBeVisible(txt_Flinks,"Text in flinks page");
					 
					click(Flinks_Standard,"FLinks Standard");
					click(btn_Next,"Next");
				}
				else if(getMapData.get("IL_User_New_OR_Existing_For_Flinks").equalsIgnoreCase("Existing"))
				{
					 
					waitForElementToBeVisible(Flinks_Standard,"FLinks Standard");
					 
					click(Flinks_Standard,"FLinks Standard");
					click(btn_Next,"Next");
				}
			}
		}

	}

	public static void Flinks_ReLoan(String LoanType) throws Exception
	{
		
		Thread.sleep(10000);
		 
		if((LoanType.equalsIgnoreCase("IL"))&&(getMapData.get("Current_Address_Province").equalsIgnoreCase("SK")))
		{
			PrintValueToReport("No flinks option for this province in IL", "Flinks option w.r.t Product");
			System.out.println("No Flinks");
		}
		else if((LoanType.equalsIgnoreCase("SPL"))&&(getMapData.get("Current_Address_Province").equalsIgnoreCase("SK")||getMapData.get("Current_Address_Province").equalsIgnoreCase("AB")))
		{
			PrintValueToReport("No flinks option for this province in SPL or EPP", "Flinks option w.r.t Product");
			System.out.println("No Flinks");
		}
		else
		{

			if(getMapData.get("Re-Loan_User_Wants_Flinks_Optin_OR_Optout").equalsIgnoreCase("Optin"))
			{
				if(getMapData.get("Re-Loan_User_New_OR_Existing_For_Flinks").equalsIgnoreCase("New"))
				{
					Flinks_Func();
				}
				else if(getMapData.get("Re-Loan_User_New_OR_Existing_For_Flinks").equalsIgnoreCase("Existing"))
				{
					 
					waitForElementToBeClickable(Flinks_Standard,"Flinks Standard");
					 
					Thread.sleep(4000);
					click(Flinks_Express,"Continue with flinks optin");
					click(btn_Next,"Next");
				}
			}
			else if(getMapData.get("Re-Loan_User_Wants_Flinks_Optin_OR_Optout").equalsIgnoreCase("Optout"))
			{
				if(getMapData.get("Re-Loan_User_New_OR_Existing_For_Flinks").equalsIgnoreCase("New"))
				{
					waitForElementToBeVisible(txt_Flinks,"Text in flinks page");
					 
					click(Flinks_Standard,"Flinks Standard");
					click(btn_Next,"Next");
				}
				else if(getMapData.get("Re-Loan_User_New_OR_Existing_For_Flinks").equalsIgnoreCase("Existing"))
				{
					 
					waitForElementToBeVisible(Flinks_Standard,"With draw consent");
					 
					click(Flinks_Standard,"Flinks Standard");
					click(btn_Next,"Next");
				}
			}
		}
				
	}
	public static void Flinks_Refi() throws Exception
	{
		
		Thread.sleep(10000);
		 
		if(getMapData.get("Current_Address_Province").equalsIgnoreCase("SK"))
		{
			PrintValueToReport("No flinks option for this province in IL", "Flinks option w.r.t Product");
			System.out.println("No Flinks");
		}
		else
		{

			if(getMapData.get("Refi_User_Wants_Flinks_Optin_OR_Optout").equalsIgnoreCase("Optin"))
			{
				if(getMapData.get("Refi_User_New_OR_Existing_For_Flinks").equalsIgnoreCase("New"))
				{
					Flinks_Func();
				}
				else if(getMapData.get("Refi_User_New_OR_Existing_For_Flinks").equalsIgnoreCase("Existing"))
				{
					 
					waitForElementToBeClickable(Flinks_Standard,"Flinks Standard");
					 
					Thread.sleep(4000);
					click(Flinks_Express,"Continue with flinks optin");
					click(btn_Next,"Next");
				}
			}
			else if(getMapData.get("Refi_User_Wants_Flinks_Optin_OR_Optout").equalsIgnoreCase("Optout"))
			{
				if(getMapData.get("Refi_User_New_OR_Existing_For_Flinks").equalsIgnoreCase("New"))
				{
					waitForElementToBeVisible(txt_Flinks,"Text in flinks page");
					 
					click(Flinks_Standard,"Flinks Standard");
					click(btn_Next,"Next");
				}
				else if(getMapData.get("Refi_User_New_OR_Existing_For_Flinks").equalsIgnoreCase("Existing"))
				{
					 
					waitForElementToBeVisible(Flinks_Standard,"With draw consent");
					 
					click(Flinks_Standard,"Flinks Standard");
					click(btn_Next,"Next");
				}
			}
		}

	}

}
