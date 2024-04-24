package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;



public class Pg_03_flinksconnect extends OnlineActions {

	//WebDriver driver;
		public Pg_03_flinksconnect(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
		}

//flinks xpath
		
		@FindBy (how=How.XPATH, using = "//button[normalize-space()='Continue']")
		public static WebElement Flinks_Continue;

		@FindBy (how=How.XPATH, using = "//div[contains(text(),'ROYAL BANK OF CANADA')]")
		public static WebElement FlinksConnectedText;
		
		
		//@FindBy (how=How.XPATH, using = "//h1[normalize-space()='2 ways to apply']") //Commented on 11-Apr-2023 Revised
		@FindBy (how=How.XPATH, using = "//h1[text()='Verify Your Income']") //Added on 11-Apr-2023 Revised
		public static WebElement txt_Flinks;

		//@FindBy (how=How.XPATH, using = "//div[@id='express']//div[@class='box-content']")
		@FindBy (how=How.XPATH, using = "//div[@id='express']")
		//div[@id='express']
		public static WebElement Flinks_Express;

		//@FindBy (how=How.XPATH, using = "//button[normalize-space()='Next']") //Commented on 09-Nov-2022
		@FindBy (how=How.XPATH, using = "//button[normalize-space()='Continue']") //Added on 09-Nov-2022
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
	
	@FindBy (how=How.XPATH, using = "//div[@id='standard']")
	public static WebElement non_flink_select;
	
	@FindBy (how=How.XPATH, using = "//button[@id='gs-accept']")
	public static WebElement next_button;
	
	
	//Added on 12-Aug-2022 Start
	
	@FindBy (how=How.XPATH, using = "//div[contains(@class,'heading')]/h1")
	public static WebElement header_IncomeInfoHeader;
	//Verify your income
	
	@FindBy (how=How.XPATH, using = "//h2[text()='Connect with Flinks']")
	public static WebElement radio_header_ConnectwithFlinks;
	
	@FindBy (how=How.XPATH, using = "//label[contains(@class,'Flinks')]//span[1]")
	public static WebElement radio_ConnectwithFlinks;
	
	@FindBy (how=How.XPATH, using = "//h2[text()='Continue without Flinks']")
	public static WebElement radio_header_ContinueWithoutFlinks;
	
	@FindBy (how=How.XPATH, using = "//label[contains(@class,'Nflinks')]//span[1]")
	public static WebElement radio_ContinueWithoutFlinks;
	
	//@FindBy (how=How.XPATH, using = "//button[text()='Next']") //Commented on 02-Nov-2022
	@FindBy (how=How.XPATH, using = "//button[text()='Continue']") //Added on 02-Nov-2022
	public static WebElement btn_NextOnFlixNFlixScr;
	
	@FindBy (how=How.XPATH, using = "//h1[normalize-space()='Thanks for choosing Express!']")
    public static WebElement page_Tittle;
	
	
	//Added on 12-Aug-2022 End
	
	
	//Added on 10-Apr-2022 Start Revised
	@FindBy (how=How.XPATH, using = "//h1[text()='Flinks Terms and Conditions']")
    public static WebElement popup_Tittle;
	
	@FindBy (how=How.XPATH, using = "//span[contains(text(),'I have read and agree to the Terms and Conditions for Flinks and consent to the Privacy Notice.')]")
    public static WebElement checkBox_Agreeement;
	
	@FindBy (how=How.XPATH, using = "//button[text()='Agree and Continue']")
    public static WebElement btn_AgreeAndContinue;
	//Added on 10-Apr-2022 End Revised
	
	public void flink_select() throws Exception
	{
		
		waitForElementToBeClickable(non_flink_select, "flink option");
		click(non_flink_select,"Non-flink option"); 
		click(next_button,"next button "); 
					
	}
	
	//Added on 12-Aug-2022 Start
	public void flink_select_new_UI_refi() throws Exception
	{
		
		VerifyText_For_PageCaption(header_IncomeInfoHeader, "Verify your income", "Income Info Page, Hence Passed");
		waitForElementToBeClickable(radio_ContinueWithoutFlinks, "flink option");
		click(radio_ContinueWithoutFlinks,"Non-flink option"); 
		click(btn_NextOnFlixNFlixScr,"next button "); 
					
	}
	//Added on 12-Aug-2022 End
	
	

	//Added on 12-Aug-2022 Start
	public void flink_select_new_UI_refi_withFlinks() throws Exception
	{
		
		VerifyText_For_PageCaption(header_IncomeInfoHeader, "Verify your income", "Income Info Page, Hence Passed");
		waitForElementToBeClickable(radio_ConnectwithFlinks, "flink option");
		click(radio_ConnectwithFlinks,"Non-flink option"); 
		click(btn_NextOnFlixNFlixScr,"next button "); 
					
	}
	//Added on 12-Aug-2022 End
	
	public void Flinks(String LoanType) throws Exception
	{
		 
		Thread.sleep(8000);
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
					;
					Thread.sleep(2000);
					waitForElementToBeVisible(Flinks_Standard,"With draw consent");
					
					click(Flinks_Standard,"Flinks Standard");
					click(btn_Next,"Next");
				}
			}
		}
	}
	
	public static void Flinks_Func() throws Exception
	{
		waitForElementToBeVisible(txt_Flinks,"Text in flinks page");
		
		//String flinksText = txt_Flinks.getText();
		//System.out.println("Flinks text is "+flinksText);
		click(Flinks_Express,"Express - fastest option");
		
		//Added on 10-Apr-2023 Start Revised
		flinks_popup_handle();
		//Added on 10-Apr-2023 End Revised
		
		//click(btn_Next,"Next"); Commented on 10-Apr-2023 Revised
		
		waitForElementToBeVisible(iFrame, "iFrame for flinks page");
		//WebElement ifm = driver.findElement(By.xpath("//iframe[@class='mm-iframe']"));
		driver.TestBase.getDriver().switchTo().frame(iFrame);
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
		driver.TestBase.getDriver().switchTo().defaultContent();
		
		
		Thread.sleep(1500);
		
	}
	
	
	//Added on 10-Apr-2023 Start Revised 
	public static void flinks_popup_handle() throws IOException 
	{
		waitForElementToBeVisible(popup_Tittle, "FlinksTitle");
		waitForElementToBeClickable(checkBox_Agreeement, "WaitCheckBoxClick");
		click(checkBox_Agreeement, "ClkAgrCheck");
		waitForElementToBeClickable(btn_AgreeAndContinue, "btnAgrContinue");
		click(btn_AgreeAndContinue, "clkBtnAgrCont");
		
	}
	//Added on 10-Apr-2023 End Revised
	
	
	//Added on 16-Aug-2022 Start
	public static void Flinks_Func_refi() throws Exception
	{
		//waitForElementToBeVisible(txt_Flinks,"Text in flinks page");
		waitForElementToBeVisible(page_Tittle, "page tittle"); //Need to add this 19-Aug-2022
		//Thread.sleep(180000); //Need to remove this 19-Aug-2022
		//String flinksText = txt_Flinks.getText();
		//System.out.println("Flinks text is "+flinksText);
		//click(Flinks_Express,"Express - fastest option");
		//click(btn_Next,"Next");
		//waitForElementToBeVisible(iFrame, "iFrame for flinks page");
		//WebElement ifm = driver.findElement(By.xpath("//iframe[@class='mm-iframe']"));
		driver.TestBase.getDriver().switchTo().frame(iFrame);
		
		
		
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
		driver.TestBase.getDriver().switchTo().defaultContent();
		
		
		Thread.sleep(1500);
		
	}
	//Added on 16-Aug-2022 End
	
	
	
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
