package pages;

import java.util.HashSet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;
import driver.TestBase;

public class Pg_09_Funding extends OnlineActions {

	public Pg_09_Funding(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// Funding method

	@FindBy(how = How.XPATH, using = "//div[@class='box-content-funding-dd']")
	public static WebElement radio_DirectDeposit;

	@FindBy(how = How.XPATH, using = "//div[@class='box-content-funding-et']")
	public static WebElement etransfer;

	//@FindBy(how = How.XPATH, using = "//button[normalize-space()='Next']") //Commented on 31-Oct-2022
	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Continue']") //Added on 31-Oct-2022
	public static WebElement next_button;

	@FindBy(how = How.XPATH, using = "//h1[normalize-space()='Perfect!']")
	public static WebElement txt_fundingpage;
	
	//Repay card xpaths
	
	@FindBy (how=How.XPATH, using = "//div[normalize-space()='Tell us how to give you your money.']")
	public static WebElement head_Step2Funding;
	
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='+ Add Visa Debit Card']")
	public static WebElement Add_DebitCard;
	
	@FindBy (how=How.XPATH, using = "//iframe[@class='responsive-iframe']")
	public static WebElement iFrame;
	
	@FindBy(how=How.XPATH, using = "//input[@name='cardholder_name']")
	private static WebElement cardholder_Name;

	@FindBy(how=How.XPATH, using = "//input[@name='card_number']")
	private static WebElement cardNumber;

	@FindBy(how=How.XPATH, using = "//input[@name='card_cvc']")
	private static WebElement CardCVV;

	@FindBy(how=How.XPATH, using = "//select[@name='card_expiration_month']")
	private static WebElement dd_ExpireMonth;

	@FindBy(how=How.XPATH, using = "//select[@name='card_expiration_year']")
	private static WebElement dd_ExpireYear;

	@FindBy(how=How.XPATH, using = "//input[@name='address_street']")
	private static WebElement StreetAddress;

	@FindBy(how=How.XPATH, using = "//input[@name='address_zip']")
	private static WebElement ZipCode;

	@FindBy(how=How.XPATH, using = "//input[@name='StateorProvince']")
	private static WebElement StateProvince;

	@FindBy(how=How.XPATH, using = "//button[normalize-space()='Authorize']")
	private static WebElement btn_Authorize;
	
	@FindBy(how=How.XPATH, using = "//div[normalize-space()='Thank you for your authorization!']")
	private static WebElement txt_TanksforAuth;

	@FindBy(how=How.XPATH, using = "//h3[normalize-space()='Card added']")
	private static WebElement txt_CardAdded;

	@FindBy(how=How.XPATH, using = "//input[@type='checkbox']")
	private static WebElement Check_Debitcard_SaveforFuture;

	@FindBy(how=How.XPATH, using = "//button[normalize-space()='Continue']")
	private static WebElement btn_Continue;
	
	@FindBy(how=How.XPATH, using = "//button[normalize-space()='Close']")
	private static WebElement btn_close;
	
	@FindBy(how=How.XPATH, using = "//div[@class='funding-head-et'][normalize-space()='Card: #### #### #### 0004' or 'Card: #### #### #### 0134']")
	private static WebElement RepayCard;
	
	@FindBy(how=How.XPATH, using = "//div[@class='boxcard ']//div[@class='box-content-funding-et']")
	private static WebElement existing_repay;
	
	
	
	public void funding_existing_repay() throws Exception
	{
		Thread.sleep(3000);
		
		if(getMapData.get("Funding_Method").equalsIgnoreCase("Debit Card")||getMapData.get("Funding_Method").equalsIgnoreCase("Repay"))
		{
			waitForElementToBeVisible(existing_repay, "Existing repay card");
			click(existing_repay, "select the repay card");
		}
		else if(getMapData.get("Funding_Method").equalsIgnoreCase("Debit Card")||getMapData.get("Funding_Method").equalsIgnoreCase("Repay"))
		{
			waitForElementToBeVisible(Add_DebitCard, "Funding method as debit card");
			click(Add_DebitCard,"Add debit card");
			waitForElementToBeVisible(iFrame, "iFrame");
			TestBase.getDriver().switchTo().frame(iFrame);
			waitForElementToBeClickable(cardholder_Name, "Card holder name");
			EnterText(cardholder_Name, getMapData.get("input_CardHolderName"), "Card holder name");
			EnterText(cardNumber, getMapData.get("input_CardHolderNumber"), "Card number");
			EnterText(CardCVV, getMapData.get("input_CardHolderSecurityNumber"), "Card CVV");
			click(dd_ExpireMonth,"Expire month");
			SelectVisibleText(dd_ExpireMonth, getMapData.get("input_CardHolderExpMonth"), "Expire month");
			click(dd_ExpireYear,"Expire year");
			SelectVisibleText(dd_ExpireYear, getMapData.get("input_CardHolderExpYear"), "Expire year");
			EnterText(StreetAddress, getMapData.get("input_CardHolderBillingStreet"), "Street Address");
			EnterText(ZipCode, getMapData.get("input_CardHolderPostalCode"), "ZipCode");
			EnterText(StateProvince, getMapData.get("input_CardHolderProvince"), "Province");
			click(btn_Authorize,"Authorize button");
			waitForLoadingIconDisappearInDialog(TestBase.getDriver());
			TestBase.getDriver().switchTo().defaultContent();
//			waitForElementToBeVisible(txt_TanksforAuth, "Thanks for AUth text");			
			waitForElementToBeVisible(txt_CardAdded, "text card added");
			click(Check_Debitcard_SaveforFuture,"Save card for future");
			click(btn_close,"Close button");
			click(RepayCard,"Repay card");
			waitForLoadingIconDisappearInDialog(TestBase.getDriver());
//			waitForElementToBeVisible(txt_TestCard, "Debit card");
//			click(check_DebitCard,"Checkbox on debit card");

			Thread.sleep(2000);
		}
		click(next_button, "Next");
		Thread.sleep(3000);
	}
	
	  public void Page_Method() throws Exception 
	  { 
		  System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		  
		  
		  
		  System.out.println("Getting current page URL");
		  //Thread.sleep(12000); //commnet 25 july 2022
		  //String  strUrl = TestBase.getDriver().getCurrentUrl(); //commnet 25 july 2022
		  //System.out.println("Wait update the loan status in DB"+"URL:::"+strUrl);//commnet 25 july 2022
		  
		//Added on 25-July-2022 Start
		  HashSet<String> Url_Set = new HashSet<String>();
		 
		  /* Commented on 08-Aug-2022 Start
		  Url_Set.add("https://qac.moneymart.ca/loan-application/verification/info");
		  Url_Set.add("https://qac.moneymart.ca/loan-application/verification");
		  Url_Set.add("https://qac.moneymart.ca/loan-application/funding");
		  Url_Set.add("https://qac.moneymart.ca/loan-application/loan-protection");
		  Commented on 08-Aug-2022 End
		  */
		  
		  //Added on 08-Aug-2022 Start
		  Url_Set.add(getPropertyValue("DynamicUrl1"));
		  Url_Set.add(getPropertyValue("DynamicUrl2"));
		  Url_Set.add(getPropertyValue("DynamicUrl3"));
		  Url_Set.add(getPropertyValue("DynamicUrl4"));
		//Added on 08-Aug-2022 End
		  
	      String strUrl = TestBase.getDriver().getCurrentUrl(); 
	      System.out.println("Wait update the loan status in DB"+"URL:::"+strUrl);
	      
		  int i = 1;
	      while(!Url_Set.contains(strUrl))
		  {
			  System.out.println(TestBase.getDriver().getCurrentUrl());
			  System.out.println("WAITING................................");
			  Thread.sleep(5000); 
			  i = i + 1;
			  strUrl = TestBase.getDriver().getCurrentUrl();
			  if(i == 24)
			  {
				  break;
			  }
		  }
		  //strUrl = TestBase.getDriver().getCurrentUrl(); 
		  System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		//Added on 25-July-2022 End
	  
	  String loanprotection="loan-application/loan-protection"; String
	  phoneverification="loan-application/verification/info"; String
	  phoneverfication2= "loan-application/verification"; String
	  fundingselection="loan-application/funding";
	  
	  //String str1=strUrl.substring(25); System.out.println("Page name:::"+str1); //Commented on 09-Aug-2022
	  //String str1=strUrl.substring(30); System.out.println("Page name:::"+str1); //Added on 09-Aug-2022 //Commented on 24-Sept-2022
	  
	  //Added on 24-Sept-2022 Start
	  String str1 = "";
	  if(getPropertyValue("provinerORQacURL").equalsIgnoreCase("QAC"))
	  {
		  str1 = strUrl.substring(25);
		  System.out.println("Page name:::"+str1);
	  }
	  if(getPropertyValue("provinerORQacURL").equalsIgnoreCase("PROVENIR"))
	  {
		   str1 = strUrl.substring(30);
		   System.out.println("Page name:::"+str1);
	  }
	 //Added on 24-Sept-2022 End
	  
	  if(str1.equalsIgnoreCase(phoneverification)
	  ||str1.equalsIgnoreCase(phoneverfication2)) 
	  { Pg_11_PhoneOTP
	  obj_phoneverification=new Pg_11_PhoneOTP(TestBase.getDriver());
	  
	  String phone=obj_phoneverification.phonenumber_valid.getText();
	  //obj_phoneverification.phone_verification_invalidopt(); Commented on 07-Sept-2022 
	  obj_phoneverification.phone_verification();  //Added on 07-Sep2022
	  TestBase.bindreport(currentGlobalScenarioName, "opt page");
		Funding_Method();
	  
	  }
	  else if(str1.equalsIgnoreCase(fundingselection)) 
	  { 
		  String  funding=txt_fundingpage.getText(); System.out.println("verify the text"+funding);
	  
		  
			Funding_Method();
		  
	  
	  
	  } else if(str1.equalsIgnoreCase(loanprotection)) { Pg_12_LoanApprovedScreen
	  obj_approved_screen = new Pg_12_LoanApprovedScreen(TestBase.getDriver());
	  obj_approved_screen.Approved_screen();
	  
	  }
	  
	  }
	  
	  public void changefunding() throws Exception 
	  { 
		  System.out.println("Getting current page URL");
		  //Thread.sleep(12000); //commnet 25 july 2022
		  //String  strUrl = TestBase.getDriver().getCurrentUrl(); //commnet 25 july 2022
		  //System.out.println("Wait update the loan status in DB"+"URL:::"+strUrl);//commnet 25 july 2022
		  
		//Added on 25-July-2022 Start
		  HashSet<String> Url_Set = new HashSet<String>();
		  
		  /* Commented on 08-Aug-2022 Start
		  Url_Set.add("https://qac.moneymart.ca/loan-application/verification/info");
		  Url_Set.add("https://qac.moneymart.ca/loan-application/verification");
		  Url_Set.add("https://qac.moneymart.ca/loan-application/funding");
		  Url_Set.add("https://qac.moneymart.ca/loan-application/loan-protection");
		  Commented on 08-Aug-2022 End
		  */
		  
		  //Added on 08-Aug-2022 Start
		  Url_Set.add(getPropertyValue("DynamicUrl1"));
		  Url_Set.add(getPropertyValue("DynamicUrl2"));
		  Url_Set.add(getPropertyValue("DynamicUrl3"));
		  Url_Set.add(getPropertyValue("DynamicUrl4"));
		//Added on 08-Aug-2022 End
		  
	      String strUrl = TestBase.getDriver().getCurrentUrl(); 
	      System.out.println("Wait update the loan status in DB"+"URL:::"+strUrl);
	      
		  int i = 1;
	      while(!Url_Set.contains(strUrl))
		  {
			  System.out.println(TestBase.getDriver().getCurrentUrl());
			  System.out.println("WAITING................................");
			  Thread.sleep(5000); 
			  i = i + 1;
			  strUrl = TestBase.getDriver().getCurrentUrl();
			  if(i == 24)
			  {
				  break;
			  }
		  }
		  //strUrl = TestBase.getDriver().getCurrentUrl(); 
		  System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		//Added on 25-July-2022 End
	  
	  String loanprotection="loan-application/loan-protection"; String
	  phoneverification="loan-application/verification/info"; String
	  phoneverfication2= "loan-application/verification"; String
	  fundingselection="loan-application/funding";
	  
	  //String str1=strUrl.substring(25); System.out.println("Page name:::"+str1); //Commented on 09-Aug-2022
	  //String str1=strUrl.substring(30); System.out.println("Page name:::"+str1); //Added on 09-Aug-2022 //Commented on 24-Sept-2022
	  
	  //Added on 24-Sept-2022 Start
	  String str1 = "";
	  if(getPropertyValue("provinerORQacURL").equalsIgnoreCase("QAC"))
	  {
		  str1 = strUrl.substring(25);
		  System.out.println("Page name:::"+str1);
	  }
	  if(getPropertyValue("provinerORQacURL").equalsIgnoreCase("PROVENIR"))
	  {
		   str1 = strUrl.substring(30);
		   System.out.println("Page name:::"+str1);
	  }
	 //Added on 24-Sept-2022 End
	  
	  if(str1.equalsIgnoreCase(phoneverification)
	  ||str1.equalsIgnoreCase(phoneverfication2)) 
	  { 
		  Pg_11_PhoneOTP  obj_phoneverification=new Pg_11_PhoneOTP(TestBase.getDriver());
	  
	  String phone=obj_phoneverification.phonenumber_valid.getText();
	  obj_phoneverification.phone_verification_SPL();
	 
		  Funding_Method_change();
	  
	  }
	  else if(str1.equalsIgnoreCase(fundingselection)) 
	  { 
		  String  funding=txt_fundingpage.getText(); System.out.println("verify the text"+funding);
	  
		  
			  Funding_Method_change();
		  
		
	  
	  
	  } 
	  else if(str1.equalsIgnoreCase(loanprotection)) 
	  { 
		  Pg_12_LoanApprovedScreen  obj_approved_screen = new Pg_12_LoanApprovedScreen(TestBase.getDriver());
	  obj_approved_screen.Approved_screen();
	  
	  }
	  
	  }
	  
	  public void phoneotppass() throws Exception 
	  { 
		  System.out.println("Getting current page URL");
		  //Thread.sleep(12000); //commnet 25 july 2022
		  //String  strUrl = TestBase.getDriver().getCurrentUrl(); //commnet 25 july 2022
		  //System.out.println("Wait update the loan status in DB"+"URL:::"+strUrl);//commnet 25 july 2022
		  
		//Added on 25-July-2022 Start
		  HashSet<String> Url_Set = new HashSet<String>();
		 
		  /* Commented on 08-Aug-2022 Start
		  Url_Set.add("https://qac.moneymart.ca/loan-application/verification/info");
		  Url_Set.add("https://qac.moneymart.ca/loan-application/verification");
		  Url_Set.add("https://qac.moneymart.ca/loan-application/funding");
		  Url_Set.add("https://qac.moneymart.ca/loan-application/loan-protection");
		  Commented on 08-Aug-2022 End
		  */
		  
		  //Added on 08-Aug-2022 Start
		  Url_Set.add(getPropertyValue("DynamicUrl1"));
		  Url_Set.add(getPropertyValue("DynamicUrl2"));
		  Url_Set.add(getPropertyValue("DynamicUrl3"));
		  Url_Set.add(getPropertyValue("DynamicUrl4"));
		//Added on 08-Aug-2022 End
		  
		  
		  
	      String strUrl = TestBase.getDriver().getCurrentUrl(); 
	      System.out.println("Wait update the loan status in DB"+"URL:::"+strUrl);
	      
		  int i = 1;
	      while(!Url_Set.contains(strUrl))
		  {
			  System.out.println(TestBase.getDriver().getCurrentUrl());
			  System.out.println("WAITING................................");
			  Thread.sleep(5000); 
			  i = i + 1;
			  strUrl = TestBase.getDriver().getCurrentUrl();
			  if(i == 24)
			  {
				  break;
			  }
		  }
		  //strUrl = TestBase.getDriver().getCurrentUrl(); 
		  System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		//Added on 25-July-2022 End
	  
	  String loanprotection="loan-application/loan-protection"; String
	  phoneverification="loan-application/verification/info"; String
	  phoneverfication2= "loan-application/verification"; String
	  fundingselection="loan-application/funding";
	  
	  //String str1=strUrl.substring(25); System.out.println("Page name:::"+str1); //Commented on 09-Aug-2022
	  //String str1=strUrl.substring(30); System.out.println("Page name:::"+str1); //Added on 09-Aug-2022 Commented on 24-Sept-2022
	  
	  //Added on 24-Sept-2022 Start
	  String str1 = "";
	  if(getPropertyValue("provinerORQacURL").equalsIgnoreCase("QAC"))
	  {
		  str1 = strUrl.substring(25);
		  System.out.println("Page name:::"+str1);
	  }
	  if(getPropertyValue("provinerORQacURL").equalsIgnoreCase("PROVENIR"))
	  {
		   str1 = strUrl.substring(30);
		   System.out.println("Page name:::"+str1);
	  }
	 //Added on 24-Sept-2022 End
	  
	  if(str1.equalsIgnoreCase(phoneverification)	  ||str1.equalsIgnoreCase(phoneverfication2)) 
	  { 
		  Pg_11_PhoneOTP  obj_phoneverification=new Pg_11_PhoneOTP(TestBase.getDriver());
	  
	  String phone=obj_phoneverification.phonenumber_valid.getText();
	  obj_phoneverification.phone_verification(); 
	 
		Funding_Method(); //UnCommented on 20-Sept-2022 as Funding selection and Bank selection page is coming on the flow way
	  
	  
	  }
	  else if(str1.equalsIgnoreCase(fundingselection)) 
	  { 
		  String  funding=txt_fundingpage.getText(); System.out.println("verify the text"+funding);
	  
		 
			Funding_Method();
		  
	  
	  
	  } else if(str1.equalsIgnoreCase(loanprotection)) { Pg_12_LoanApprovedScreen
	  obj_approved_screen = new Pg_12_LoanApprovedScreen(TestBase.getDriver());
	  obj_approved_screen.Approved_screen();
	  
	  }
	  
	  }
	  
	  public void autofund() throws Exception 
	  { 
		  System.out.println("Getting current page URL");
		  //Thread.sleep(12000); //commnet 25 july 2022
		  //String  strUrl = TestBase.getDriver().getCurrentUrl(); //commnet 25 july 2022
		  //System.out.println("Wait update the loan status in DB"+"URL:::"+strUrl);//commnet 25 july 2022
		  
		//Added on 25-July-2022 Start
		  HashSet<String> Url_Set = new HashSet<String>();
		
		  /* Commented on 08-Aug-2022 Start
		  Url_Set.add("https://qac.moneymart.ca/loan-application/verification/info");
		  Url_Set.add("https://qac.moneymart.ca/loan-application/verification");
		  Url_Set.add("https://qac.moneymart.ca/loan-application/funding");
		  Url_Set.add("https://qac.moneymart.ca/loan-application/loan-protection");
		  Commented on 08-Aug-2022 End
		  */
		  
		//Added on 08-Aug-2022 Start
		  Url_Set.add(getPropertyValue("DynamicUrl1"));
		  Url_Set.add(getPropertyValue("DynamicUrl2"));
		  Url_Set.add(getPropertyValue("DynamicUrl3"));
		  Url_Set.add(getPropertyValue("DynamicUrl4"));
		//Added on 08-Aug-2022 End

		  
	      String strUrl = TestBase.getDriver().getCurrentUrl(); 
	      //System.out.println("Wait update the loan status in DB"+"URL:::"+strUrl);
	      
		  int i = 1;
	      while(!Url_Set.contains(strUrl))
		  {
			  System.out.println(TestBase.getDriver().getCurrentUrl());
			  System.out.println("WAITING................................");
			  Thread.sleep(5000); 
			  i = i + 1;
			  strUrl = TestBase.getDriver().getCurrentUrl();
			  if(i == 24)
			  {
				  break;
			  }
		  }
		  //strUrl = TestBase.getDriver().getCurrentUrl(); 
		  System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		//Added on 25-July-2022 End
	  
	  String loanprotection="loan-application/loan-protection"; 
	  String  phoneverification="loan-application/verification/info"; 
	  String phoneverfication2= "loan-application/verification"; 
	  String  fundingselection="loan-application/funding";
	  
	  //String str1=strUrl.substring(25); //Commented on 09-Aug-2022
	  //String str1=strUrl.substring(30); //Added on 09-Aug-2022 //Commented on 24-Sept-2022
	  
	  String str1 = "";
	  if(getPropertyValue("provinerORQacURL").equalsIgnoreCase("QAC"))
	  {
		  str1 = strUrl.substring(25);
	  }
	  if(getPropertyValue("provinerORQacURL").equalsIgnoreCase("PROVENIR"))
	  {
		   str1 = strUrl.substring(30);
	  }
	  
	  
	  System.out.println("Page name:::"+str1);
	  
	  if(str1.equalsIgnoreCase(phoneverification)	  ||str1.equalsIgnoreCase(phoneverfication2)) 
	  { 
		  Pg_11_PhoneOTP  obj_phoneverification=new Pg_11_PhoneOTP(TestBase.getDriver());
	  
	  String phone=obj_phoneverification.phonenumber_valid.getText();
	  obj_phoneverification.phone_verification(); 
	  Pg_12_LoanApprovedScreen  obj_approved_screen = new Pg_12_LoanApprovedScreen(TestBase.getDriver());
	  obj_approved_screen.Approved_screen();
	  
	  }
	  else if(str1.equalsIgnoreCase(loanprotection)) 
	  { 
		  Pg_12_LoanApprovedScreen  obj_approved_screen = new Pg_12_LoanApprovedScreen(TestBase.getDriver());
		  obj_approved_screen.Approved_screen();
		  
		  }
	  else if(str1.equalsIgnoreCase(fundingselection)) 
	  { 
		  
	  System.out.println("Application goes to manual review");
	  System.out.println("Change the test data");
	  TestBase.getDriver().close();
	  
	  	} 
	  
	  }
	 

	public void Funding_Method() throws Exception {
		Thread.sleep(8000);
		
		
		/*
		 * if(getMapData.get("IL_User_Funding").equalsIgnoreCase("Optout")) {
		 */
		if (getMapData.get("Funding_Method").equalsIgnoreCase("E-Transfer")) {
			waitForElementToBeVisible(etransfer, "E-Transfer");
			click(etransfer, "E-Transfer");
		} 
		else if (getMapData.get("Funding_Method").equalsIgnoreCase("Direct Deposit")) {
			Thread.sleep(2000);
			System.out.println("Wait for verifing funding type");
			//waitForElementToBeVisible(radio_DirectDeposit, "Direct depost"); //Commented on 20-Sept-2022
			waitForElementToBeClickable(radio_DirectDeposit, "Direct depost"); //Added on 20-Sept-2022
			mouseOverAndClick(getDriver(), radio_DirectDeposit, "Direct depostclick");

			// Actions actions = new Actions(driver);
			// actions.moveToElement(radio_DirectDeposit);
			// actions.click().build().perform();
			// click(radio_DirectDeposit,"Direct deposit");
			Thread.sleep(2000);
			waitForLoadingIconDisappearInDialog(TestBase.getDriver());
		}

		
		else if(getMapData.get("Funding_Method").equalsIgnoreCase("Debit Card")||getMapData.get("Funding_Method").equalsIgnoreCase("Repay"))
		{
			Thread.sleep(2000);
			waitForElementToBeVisible(Add_DebitCard, "Funding method as debit card");
			click(Add_DebitCard,"Add debit card");
			waitForElementToBeVisible(iFrame, "iFrame");
			TestBase.getDriver().switchTo().frame(iFrame);
			waitForElementToBeClickable(cardholder_Name, "Card holder name");
			EnterText(cardholder_Name, getMapData.get("input_CardHolderName"), "Card holder name");
			EnterText(cardNumber, getMapData.get("input_CardHolderNumber"), "Card number");
			EnterText(CardCVV, getMapData.get("input_CardHolderSecurityNumber"), "Card CVV");
			click(dd_ExpireMonth,"Expire month");
			SelectVisibleText(dd_ExpireMonth, getMapData.get("input_CardHolderExpMonth"), "Expire month");
			click(dd_ExpireYear,"Expire year");
			SelectVisibleText(dd_ExpireYear, getMapData.get("input_CardHolderExpYear"), "Expire year");
			EnterText(StreetAddress, getMapData.get("input_CardHolderBillingStreet"), "Street Address");
			EnterText(ZipCode, getMapData.get("input_CardHolderPostalCode"), "ZipCode");
			EnterText(StateProvince, getMapData.get("input_CardHolderProvince"), "Province");
			Thread.sleep(2000);
			waitForElementToBeClickable(btn_Authorize, "Authorize button");
			click(btn_Authorize,"Authorize button");
			waitForLoadingIconDisappearInDialog(TestBase.getDriver());
			TestBase.getDriver().switchTo().defaultContent();
//			waitForElementToBeVisible(txt_TanksforAuth, "Thanks for AUth text");			
			waitForElementToBeVisible(txt_CardAdded, "text card added");
			click(Check_Debitcard_SaveforFuture,"Save card for future");
			click(btn_close,"Close button");
			click(RepayCard,"Repay card");
			waitForLoadingIconDisappearInDialog(TestBase.getDriver());
//			waitForElementToBeVisible(txt_TestCard, "Debit card");
//			click(check_DebitCard,"Checkbox on debit card");

			Thread.sleep(2000);
			
			
		}
		TestBase.bindreport(currentGlobalScenarioName, "funding details page");
		// the below two lines is a temparory code for Issue in the application
		// click(btn_Back,"Back");
		// click(Pg_08_FinalOffer.btn_FundMyLoan,"Fund my loan button");

		click(next_button, "Next");
		//Thread.sleep(3000);

	}
	
	public void Funding_Method_change() throws Exception {
		Thread.sleep(8000);
		
		
		/*
		 * if(getMapData.get("IL_User_Funding").equalsIgnoreCase("Optout")) {
		 */
		if (getMapData.get("Funding_Method_change").equalsIgnoreCase("E-Transfer")) {
			waitForElementToBeVisible(etransfer, "E-Transfer");
			click(etransfer, "E-Transfer");
		} else if (getMapData.get("Funding_Method_change").equalsIgnoreCase("Direct Deposit")) {
			Thread.sleep(1000);
			System.out.println("Verifying funding method");
			waitForElementToBeVisible(radio_DirectDeposit, "Direct depost");
			mouseOverAndClick(getDriver(), radio_DirectDeposit, "Direct depost");

			// Actions actions = new Actions(driver);
			// actions.moveToElement(radio_DirectDeposit);
			// actions.click().build().perform();
			// click(radio_DirectDeposit,"Direct deposit");
			Thread.sleep(2000);
			waitForLoadingIconDisappearInDialog(TestBase.getDriver());
		}

		
		else if(getMapData.get("Funding_Method_change").equalsIgnoreCase("Debit Card")||getMapData.get("Funding_Method_change").equalsIgnoreCase("Repay"))
		{
			waitForElementToBeVisible(Add_DebitCard, "Funding method as debit card");
			click(Add_DebitCard,"Add debit card");
			waitForElementToBeVisible(iFrame, "iFrame");
			TestBase.getDriver().switchTo().frame(iFrame);
			waitForElementToBeClickable(cardholder_Name, "Card holder name");
			EnterText(cardholder_Name, getMapData.get("input_CardHolderName"), "Card holder name");
			EnterText(cardNumber, getMapData.get("input_CardHolderNumber"), "Card number");
			EnterText(CardCVV, getMapData.get("input_CardHolderSecurityNumber"), "Card CVV");
			click(dd_ExpireMonth,"Expire month");
			SelectVisibleText(dd_ExpireMonth, getMapData.get("input_CardHolderExpMonth"), "Expire month");
			click(dd_ExpireYear,"Expire year");
			SelectVisibleText(dd_ExpireYear, getMapData.get("input_CardHolderExpYear"), "Expire year");
			EnterText(StreetAddress, getMapData.get("input_CardHolderBillingStreet"), "Street Address");
			EnterText(ZipCode, getMapData.get("input_CardHolderPostalCode"), "ZipCode");
			EnterText(StateProvince, getMapData.get("input_CardHolderProvince"), "Province");
			click(btn_Authorize,"Authorize button");
			waitForLoadingIconDisappearInDialog(TestBase.getDriver());
			TestBase.getDriver().switchTo().defaultContent();
//			waitForElementToBeVisible(txt_TanksforAuth, "Thanks for AUth text");			
			waitForElementToBeVisible(txt_CardAdded, "text card added");
			click(Check_Debitcard_SaveforFuture,"Save card for future");
			click(btn_close,"Close button");
			click(RepayCard,"Repay card");
			waitForLoadingIconDisappearInDialog(TestBase.getDriver());
//			waitForElementToBeVisible(txt_TestCard, "Debit card");
//			click(check_DebitCard,"Checkbox on debit card");

			Thread.sleep(2000);
			
			
		}
		// the below two lines is a temparory code for Issue in the application
		// click(btn_Back,"Back");
		// click(Pg_08_FinalOffer.btn_FundMyLoan,"Fund my loan button");

		click(next_button, "Next");
		Thread.sleep(3000);

	}
	
	//div[@class='boxcard ']//div[@class='box-content-funding-et']

	private void waitForLoadingIconDisappearInDialog(WebDriver driver) {
		// TODO Auto-generated method stub

	}

}
