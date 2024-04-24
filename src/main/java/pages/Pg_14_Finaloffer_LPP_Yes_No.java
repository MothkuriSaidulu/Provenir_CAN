package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;
import driver.TestBase;



public class Pg_14_Finaloffer_LPP_Yes_No extends OnlineActions {

	//WebDriver driver;
		public Pg_14_Finaloffer_LPP_Yes_No(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
		}

///added 11-july-2022
		//@FindBy (how=How.XPATH, using = "//div[text()='Loan Amount']//parent::div//descendant::div[2]//input") Commented on 30-Nov-2022
		@FindBy (how=How.XPATH, using = "//strong[text()='Approved loan amount']//parent::div//following-sibling::div//input") //Added on 30-Nov-2022
		public static WebElement loan_amount;
		///added 11-july-2022
		
		
		@FindBy (how=How.XPATH, using = "//div[contains(text(),'Confirm your loan details')]")
		public static WebElement caption_Confirm_your_loan_details;
		
		
		//Added on 25-Aug-2022 Start
		
		@FindBy (how=How.XPATH, using = "//div[contains(text(),'Confirm your loan details')]")
		public static WebElement caption_topUp_Confirm_your_loan_details;
		
		@FindBy (how=How.XPATH, using = "//div[text()='Top Up Amount']")
		public static WebElement caption_topUp_TopUpLoanAmount;
		
		
		//Added on 25-Aug-2022 End
		
		
		
		
		//Added on 17-Aug-2022 Start
		@FindBy (how=How.XPATH, using = "//div[text()='Top Up Amount']//parent::div//descendant::div[2]//input")
		public static WebElement loan_TopUp_amount;
		//Added on 17-Aug-2022 End
		
		
	@FindBy (how=How.XPATH, using = "//form[@id='offer-form']//div//h1")
	public static WebElement offer_approved_validation;
	
	@FindBy (how=How.XPATH, using = "//div[contains(@class,'mm-form-field mmLoan')]//span[contains(@class,'mm-form-field__label')]")
	public static WebElement loanapprovedamount;
	
	//@FindBy (how=How.XPATH, using = "//button[normalize-space()='Yes']") //Commented on 11-July-2023 Revised
	@FindBy (how=How.XPATH, using = "//span[@id='lpp_live_person']//preceding::button[normalize-space()='Yes']") //Added on 23-July-2023 Revised
	public static WebElement accept_LPP_Yes;
	
	//@FindBy (how=How.XPATH, using = "//button[normalize-space()='No']") //Commented on 10-July-2023
	@FindBy (how=How.XPATH, using = "//span[@id='lpp_live_person']//preceding::button[normalize-space()='No']") //Added on 10-July-2023
	
	public static WebElement accept_LPP_No;
	
	
	//Added on 25-July-2023 Start Revised
	@FindBy (how=How.XPATH, using = "//div[contains(text(),'Add the Loan Protection Plan?')]")
	public static WebElement caption_Add_LPP_QuestionMark;
	//Added on 25-July-2023 End Revised
	
	//Added on 11-July-2023 Start
	@FindBy (how=How.XPATH, using = "//div[text()='*Loan Protection Plan']")
	public static WebElement caption_LPP;
	//Added on 11-July-2023 End
	
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Coverage through work']")
	public static WebElement LLP_coverage;
	
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Too expensive']")
	public static WebElement LLP_tooexpensive;
	
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Will not use']")
	public static WebElement LLP_willnotuse;
	
	//@FindBy (how=How.XPATH, using = "//button[normalize-space()='Next']") //Commented on 31-Oct-2022
 	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Continue']") //Added on 31-Oct-2022
	public static WebElement next_button;
	
	
	
	//@FindBy (how=How.XPATH, using = "//button[normalize-space()='Next']") //Commented on 31-Oct-2022
 	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Continue']") //Added on 31-Oct-2022
	public static List<WebElement> next_button_l;
	

 	//Added on 14-Nov-2022 Start
	 	//@FindBy (how=How.XPATH, using = "(//div[text()='Loan Term']//parent::div//i)[1]") Commented on 30-Nov-2022 
 		@FindBy (how=How.XPATH, using = "(//div[contains(text(),'Loan Term')]//parent::div//i)[1]") //Added on 30-Nov-2022 
		public static WebElement btn_LoanTerm_Decrease;
	 	
		//Added on 14-Nov-2022 Start
		@FindBy (how=How.XPATH, using = "//div[@class='mm-page-loader__wrapper']")
		public static List<WebElement> searchWheel_SearchLook;
		//Added on 14-Nov-2022 End
 	//Added on 14-Nov-2022 End
		
	public void finaloffer_Decrease_Term_And_Check_12_Not_There() throws Exception
	{
		VerifyText_For_PageCaption(offer_approved_validation, "Great news - you're approved!", "Basic Info Page, Hence Passed");
		TestBase.bindreport(currentGlobalScenarioName, "loam approved amount details page_landing"); //Added on 21-Sept-2022
		String loanamount=loan_amount.getAttribute("Value");
		System.out.println("Loan amount:"+loanamount);
		String str1=loanamount.substring(1);
		System.out.println("Page name:::"+str1);
		String finalamount=str1;
		System.out.println(finalamount.replace(",", ""));
		TestBase.bindreport(currentGlobalScenarioName, "loam approved amount details page");
		int amount = Integer.parseInt(finalamount.replace(",", ""));
		
		//Added on 17-Sept-2022 start
		scrollIntoView(loan_amount);
		Thread.sleep(1000);
		TestBase.bindreport(currentGlobalScenarioName, "LoanApprovedAmount");
		//Added on 17-Sept-2022 End
		
		
		//Added on 15-Nov-2022 Start
		waitForElementToBeClickable(btn_LoanTerm_Decrease, "WaitDecreaseTerm");
		click(btn_LoanTerm_Decrease, "clkDecreaseTerm");
			//Added on 14-Nov-2022 Start
				int k = 0;
				while(searchWheel_SearchLook.size() > 0)
				{
					Thread.sleep(2000);
					k = k + 1;
					
					if(k==30)
					{
						break;
					}
				}
			//Added on 14-Nov-2022 End
				Thread.sleep(5000); //changed 5k from 2k on 30-nov-2022
				TestBase.bindreport(currentGlobalScenarioName, "Term1");
				
		//SECOND
				waitForElementToBeClickable(btn_LoanTerm_Decrease, "WaitDecreaseTerm");
				click(btn_LoanTerm_Decrease, "clkDecreaseTerm");
					//Added on 14-Nov-2022 Start
						int l = 0;
						while(searchWheel_SearchLook.size() > 0)
						{
							Thread.sleep(2000);
							l = l + 1;
							
							if(l==30)
							{
								break;
							}
						}
					//Added on 14-Nov-2022 End
						Thread.sleep(5000); //changed 5k from 2k on 30-nov-2022
						TestBase.bindreport(currentGlobalScenarioName, "Term2");
						
		//THIRD
						waitForElementToBeClickable(btn_LoanTerm_Decrease, "WaitDecreaseTerm");
						click(btn_LoanTerm_Decrease, "clkDecreaseTerm");
							//Added on 14-Nov-2022 Start
								int m = 0;
								while(searchWheel_SearchLook.size() > 0)
								{
									Thread.sleep(2000);
									m = m + 1;
									
									if(m==30)
									{
										break;
									}
								}
							//Added on 14-Nov-2022 End
								Thread.sleep(5000); //changed 5k from 2k on 30-nov-2022
								TestBase.bindreport(currentGlobalScenarioName, "Term3");
								
		//FOURTH
								waitForElementToBeClickable(btn_LoanTerm_Decrease, "WaitDecreaseTerm");
								click(btn_LoanTerm_Decrease, "clkDecreaseTerm");
									//Added on 14-Nov-2022 Start
										int n = 0;
										while(searchWheel_SearchLook.size() > 0)
										{
											Thread.sleep(2000);
											n = n + 1;
											
											if(n==30)
											{
												break;
											}
										}
									//Added on 14-Nov-2022 End
										Thread.sleep(5000); //changed 5k from 2k on 30-nov-2022
										TestBase.bindreport(currentGlobalScenarioName, "Term4");
										
		//FIFTH
		waitForElementToBeClickable(btn_LoanTerm_Decrease, "WaitDecreaseTerm");
		click(btn_LoanTerm_Decrease, "clkDecreaseTerm");
			//Added on 14-Nov-2022 Start
				int o = 0;
				while(searchWheel_SearchLook.size() > 0)
				{
					Thread.sleep(2000);
					o = o + 1;
					
					if(o==30)
					{
						break;
					}
				}
			//Added on 14-Nov-2022 End
				Thread.sleep(5000); //changed 5k from 2k on 30-nov-2022
				TestBase.bindreport(currentGlobalScenarioName, "Term5");
				
		//Added on 15-Nov-2022 End
		
		//Added on 16-Aug-2022 Start
		if(getMapData.get("Funding_Method").equalsIgnoreCase("E-Transfer"))
		{
			if(amount>=10000)
			{
				loan_amount.sendKeys(Keys.CONTROL + "a");
				loan_amount.sendKeys(Keys.DELETE);
				EnterText(loan_amount,"9000","Loan ammount");
			}	
		}
		
		//Added on 28-Sept-2022 Start
		if(getMapData.get("User_Wants_Flinks_Optin_OR_Optout").equalsIgnoreCase("Optin"))
		{
			if(amount>=10000)
			{
				scrollIntoView(caption_Confirm_your_loan_details);
				Thread.sleep(3000);
				loan_amount.sendKeys(Keys.CONTROL + "a");
				loan_amount.sendKeys(Keys.DELETE);
				EnterText(loan_amount,"9000","Loan ammount");
				Thread.sleep(1000); //Added on 28-Sept-2022
				loan_amount.sendKeys(Keys.TAB); //Added on 28-Sept-2022
				Thread.sleep(3000); //Added on 28-Sept-2022
			}	
			TestBase.bindreport(currentGlobalScenarioName, "LoanApprovedAmountOptFor");
		}
		//Added on 28-Sept-2022 End
		
		Thread.sleep(3000); //Added on 19-Aug-2022
		
		if(getMapData.get("LPP").equalsIgnoreCase("Yes"))
			
		{
			click(accept_LPP_Yes,"LPP yes ");
		}
		else if(getMapData.get("LPP").equalsIgnoreCase("No"))
		{
			click(accept_LPP_No,"LPP_no");
			Thread.sleep(2000);
			click(LLP_tooexpensive,"tooexpensive");
		}
		waitForElementToBeClickable(next_button,"Process with approved loan");
		
		
		///* DO NOT NEXT FOR DEBUG on 19-sept-2022
		if(next_button_l.size()>0)
		{
			click(next_button,"continue ");	
		}
		//*/
	}
		
	
	public void finaloffer() throws Exception
	{
		
		Thread.sleep(4000); //Added on 30-Nov-2022
		VerifyText_For_PageCaption(offer_approved_validation, "Great news - you're approved!", "Basic Info Page, Hence Passed");
		TestBase.bindreport(currentGlobalScenarioName, "loam approved amount details page_landing"); //Added on 21-Sept-2022
		String loanamount=loan_amount.getAttribute("Value");
		System.out.println("Loan amount:"+loanamount);
		String str1=loanamount.substring(1);
		System.out.println("Page name:::"+str1);
		String finalamount=str1;
		System.out.println(finalamount.replace(",", ""));
		TestBase.bindreport(currentGlobalScenarioName, "loam approved amount details page");
		int amount = Integer.parseInt(finalamount.replace(",", ""));
		
		//Added on 17-Sept-2022 start
		scrollIntoView(loan_amount);
		Thread.sleep(1000);
		TestBase.bindreport(currentGlobalScenarioName, "LoanApprovedAmount");
		//Added on 17-Sept-2022 End
		
		//Added on 16-Aug-2022 Start
		if(getMapData.get("Funding_Method").equalsIgnoreCase("E-Transfer"))
		{
			if(amount>=10000)
			{
				loan_amount.sendKeys(Keys.CONTROL + "a");
				loan_amount.sendKeys(Keys.DELETE);
				EnterText(loan_amount,"9000","Loan ammount");
			}	
		}
		
		//Added on 28-Sept-2022 Start
		if(getMapData.get("User_Wants_Flinks_Optin_OR_Optout").equalsIgnoreCase("Optin"))
		{
			if(amount>=10000)
			{
				scrollIntoView(caption_Confirm_your_loan_details);
				Thread.sleep(3000);
				/* Commented on 22-Aug-2022 Start
				loan_amount.sendKeys(Keys.CONTROL + "a");
				loan_amount.sendKeys(Keys.DELETE);
				EnterText(loan_amount,"9000","Loan ammount");
				Thread.sleep(1000); //Added on 28-Sept-2022
				loan_amount.sendKeys(Keys.TAB); //Added on 28-Sept-2022
				Thread.sleep(3000); //Added on 28-Sept-2022
				Commented on 22-Aug-2022 End
				*/
			}	
			TestBase.bindreport(currentGlobalScenarioName, "LoanApprovedAmountOptFor");
		}
		//Added on 28-Sept-2022 End
		
		Thread.sleep(3000); //Added on 19-Aug-2022
		
		/* Commented on 17-Aug-2022
		if(getMapData.get("ScenarioforTopUp").equalsIgnoreCase("Yes"))
		{
			if(amount>=10000)
			{
				loan_amount.sendKeys(Keys.CONTROL + "a");
				loan_amount.sendKeys(Keys.DELETE);
				EnterText(loan_amount,"9000","Loan ammount");
			}	
		}
		Commented on 17-Aug-2022
		*/
		
		//Added on 16-Aug-2022 End
		
		/* commented on 16-Aug-2022 Start
		if(amount>=10000)
		{
			loan_amount.sendKeys(Keys.CONTROL + "a");
			loan_amount.sendKeys(Keys.DELETE);
			EnterText(loan_amount,"9000","Loan ammount");
		}
		commented on 16-Aug-2022 End
		*/
		
		if(getMapData.get("LPP").equalsIgnoreCase("Yes"))
			
		{
			scrollIntoView(caption_LPP); //Added on 10-July-2023 Revised
			Thread.sleep(4000); //Added on 10-July-2023 Revised
			//click(accept_LPP_Yes,"LPP yes "); //Commented on 11-July-2023 Revised
			mouseOverAndClick(getDriver(), accept_LPP_Yes, "accept_LPP_Yes"); //Added on 11-July-2023 Revised
		}
		else if(getMapData.get("LPP").equalsIgnoreCase("No"))
		{
			scrollIntoView(caption_LPP); //Added on 10-July-2023 Revised
			Thread.sleep(4000); //Added on 10-July-2023 Revised
			//click(accept_LPP_No,"LPP_no"); //Commented on 11-July-2023 Revised
			mouseOverAndClick(getDriver(), accept_LPP_No, "accept_LPP_No"); //Added on 11-July-2023 Revised
			Thread.sleep(2000);
			click(LLP_tooexpensive,"tooexpensive");
		}
		waitForElementToBeClickable(next_button,"Process with approved loan");
		
		
		///* DO NOT NEXT FOR DEBUG on 19-sept-2022
		if(next_button_l.size()>0)
		{
			click(next_button,"continue ");	
		}
		//*/
					
	}
	
	//Added on 18-Aug-2022 Start
	public void finaloffer_PrimaryIl_With_LessAmount() throws Exception
	{
		
		
		VerifyText_For_PageCaption(offer_approved_validation, "Great news - you're approved!", "Basic Info Page, Hence Passed");
		TestBase.bindreport(currentGlobalScenarioName, "loam approved amount details page_landing"); //Added on 21-Sept-2022
		String loanamount=loan_amount.getAttribute("Value");
		System.out.println("Loan amount:"+loanamount);
		String str1=loanamount.substring(1);
		System.out.println("Page name:::"+str1);
		String finalamount=str1;
		System.out.println(finalamount.replace(",", ""));
		TestBase.bindreport(currentGlobalScenarioName, "loam approved amount details page");
		int amount = Integer.parseInt(finalamount.replace(",", ""));
		
		//Added on 16-Aug-2022 Start
		if(getMapData.get("Funding_Method").equalsIgnoreCase("E-Transfer"))
		{
			if(amount>=10000)
			{
				loan_amount.sendKeys(Keys.CONTROL + "a");
				loan_amount.sendKeys(Keys.DELETE);
				EnterText(loan_amount,"9000","Loan ammount");
			}	
		}
		
		if(amount>=10000)
		{
			loan_amount.sendKeys(Keys.CONTROL + "a");
			loan_amount.sendKeys(Keys.DELETE);
			EnterText(loan_amount,getMapData.get("PrimaryLoanOptFor"),"Loan ammount");
		}	
		
		Thread.sleep(3000); //Added on 19-Aug-2022
		
		if(getMapData.get("LPP").equalsIgnoreCase("Yes"))
			
		{
			click(accept_LPP_Yes,"LPP yes ");
		}
		else if(getMapData.get("LPP").equalsIgnoreCase("No"))
		{
			click(accept_LPP_No,"LPP_no");
			Thread.sleep(2000);
			click(LLP_tooexpensive,"tooexpensive");
		}
		waitForElementToBeClickable(next_button,"Process with approved loan");
		
		if(next_button_l.size()>0)
		{
			click(next_button,"continue ");	
		}
		
					
	}
	
	//Added on 18-Aug-2022 End
	
	
	//Added on 18-Aug 202 Start
	public void finaloffer_Refi_ForTopUp() throws Exception
	{
		
		VerifyText_For_PageCaption(offer_approved_validation, "Great news - you're approved!", "Basic Info Page, Hence Passed");
		TestBase.bindreport(currentGlobalScenarioName, "loam approved amount details page_landing"); //Added on 21-Sept-2022
		String loanamount=loan_amount.getAttribute("Value");
		System.out.println("Loan amount:"+loanamount);
		String str1=loanamount.substring(1);
		System.out.println("Page name:::"+str1);
		String finalamount=str1;
		System.out.println(finalamount.replace(",", ""));
		TestBase.bindreport(currentGlobalScenarioName, "loam approved amount details page");
		int amount = Integer.parseInt(finalamount.replace(",", ""));
		
		//Added on 16-Aug-2022 Start
		
		if(getMapData.get("ScenarioforTopUp").equalsIgnoreCase("Yes"))
		{
			if(amount>=10000)
			{
				loan_amount.sendKeys(Keys.CONTROL + "a");
				loan_amount.sendKeys(Keys.DELETE);
				EnterText(loan_amount,getMapData.get("RefiLoanOptFor"),"Loan ammount");
			}	
		}
		
		Thread.sleep(3000); //Added on 19-Aug-2022
		
		if(getMapData.get("LPP").equalsIgnoreCase("Yes"))
			
		{
			click(accept_LPP_Yes,"LPP yes ");
		}
		else if(getMapData.get("LPP").equalsIgnoreCase("No"))
		{
			click(accept_LPP_No,"LPP_no");
			Thread.sleep(2000);
			click(LLP_tooexpensive,"tooexpensive");
		}
		waitForElementToBeClickable(next_button,"Process with approved loan");
		
		if(next_button_l.size()>0)
		{
			click(next_button,"continue ");	
		}
		
					
	}
	//Added on 18-Aug 202 End
	
	//Added on 17-Aug-2022 Start
	public void finaloffer_for_topUpLoan() throws Exception
	{
		
		
		VerifyText_For_PageCaption(offer_approved_validation, "Great news - you're approved!", "Basic Info Page, Hence Passed");
		TestBase.bindreport(currentGlobalScenarioName, "loam approved amount details page_landing"); //Added on 21-Sept-2022
		String loanamount=loan_amount.getAttribute("Value");
		System.out.println("Loan amount:"+loanamount);
		String str1=loanamount.substring(1);
		System.out.println("Page name:::"+str1);
		String finalamount=str1;
		System.out.println(finalamount.replace(",", ""));
		TestBase.bindreport(currentGlobalScenarioName, "loam approved amount details page");
		int amount = Integer.parseInt(finalamount.replace(",", ""));
		
		//Added on 16-Aug-2022 Start
		if(getMapData.get("Funding_Method").equalsIgnoreCase("E-Transfer"))
		{
			if(amount>=10000)
			{
				loan_amount.sendKeys(Keys.CONTROL + "a");
				loan_amount.sendKeys(Keys.DELETE);
				EnterText(loan_amount,"9000","Loan ammount");
			}	
		}
		
		if(getMapData.get("ScenarioforTopUp").equalsIgnoreCase("Yes"))
		{
			if(amount>=10000)
			{
				loan_amount.sendKeys(Keys.CONTROL + "a");
				loan_amount.sendKeys(Keys.DELETE);
				EnterText(loan_amount,getMapData.get("PrimaryILLoanOptFor"),"Loan ammount");
			}	
		}
		
		Thread.sleep(3000); //Added on 19-Aug-2022
		//Added on 16-Aug-2022 End
		
		/* commented on 16-Aug-2022 Start
		if(amount>=10000)
		{
			loan_amount.sendKeys(Keys.CONTROL + "a");
			loan_amount.sendKeys(Keys.DELETE);
			EnterText(loan_amount,"9000","Loan ammount");
		}
		commented on 16-Aug-2022 End
		*/
		
		if(getMapData.get("LPP").equalsIgnoreCase("Yes"))
			
		{
			click(accept_LPP_Yes,"LPP yes ");
		}
		else if(getMapData.get("LPP").equalsIgnoreCase("No"))
		{
			click(accept_LPP_No,"LPP_no");
			Thread.sleep(10000);//Updated 10k from 3k for QAC sysn
			scrollIntoView(LLP_tooexpensive); //Added on 02-Nov-2022 for QAC Sync
			Thread.sleep(2000); 
			click(LLP_tooexpensive,"tooexpensive");
			Thread.sleep(2000); //Added on 02-Nov-2022 for QAC Sync
		}
		waitForElementToBeClickable(next_button,"Process with approved loan");
		
		if(next_button_l.size()>0)
		{
			
			click(next_button,"continue ");	
		}
		
					
	}
	//Added on 17-Aug-2022 End
	
	public void finaloffer_TopUp() throws Exception
	{
		
		
		VerifyText_For_PageCaption(offer_approved_validation, "Great news - you're approved!", "Basic Info Page, Hence Passed");
		TestBase.bindreport(currentGlobalScenarioName, "loam approved amount details page_landing"); //Added on 21-Sept-2022
		
		//Added on 25-Sept-2022 start
		scrollIntoView(caption_topUp_Confirm_your_loan_details);
		Thread.sleep(2000);
		TestBase.bindreport(currentGlobalScenarioName, "LoanApprovedAmount");
		
		Thread.sleep(1000);
		scrollIntoView(caption_topUp_TopUpLoanAmount);
		Thread.sleep(2000);
		TestBase.bindreport(currentGlobalScenarioName, "LoanApprovedAmount1");
		
		//Added on 25-Sept-2022 End
		
		
		if(getMapData.get("LPP").equalsIgnoreCase("Yes"))
			
		{
			click(accept_LPP_Yes,"LPP yes ");
		}
		else if(getMapData.get("LPP").equalsIgnoreCase("No"))
		{
			
			//Added on 25-July-2023 Start Revised
			scrollIntoView(caption_LPP); //Added on 10-July-2023 Revised
			Thread.sleep(4000); //Added on 10-July-2023 Revised
			//click(accept_LPP_No,"LPP_no"); //Commented on 11-July-2023 Revised
			mouseOverAndClick(getDriver(), accept_LPP_No, "accept_LPP_No"); //Added on 11-July-2023 Revised
			Thread.sleep(5000);  //Updated 5k from 10k for QAC sysn
			scrollIntoView(LLP_tooexpensive);
			Thread.sleep(2000);
			click(LLP_tooexpensive,"tooexpensive");
			Thread.sleep(2000); //Added on 02-Nov-2022 for QAC Sync
			//Added on 25-July-2023 End Revised
			
			/* Commented on 25-July-2023 Start Revised
			Thread.sleep(2000); //Added on 25-July-2023 Revised
			scrollIntoView(caption_Add_LPP_QuestionMark); //Added on 25-July-2023 Revised
			click(accept_LPP_No,"LPP_no");
			Thread.sleep(10000);  //Updated 10k from 3k for QAC sysn
			scrollIntoView(LLP_tooexpensive);
			Thread.sleep(2000);
			click(LLP_tooexpensive,"tooexpensive");
			Thread.sleep(2000); //Added on 02-Nov-2022 for QAC Sync
			Commented on 25-July-2023 End Revised
			*/
		}
		waitForElementToBeClickable(next_button,"Process with approved loan");
		if(next_button.isDisplayed())
		{
			click(next_button,"continue ");	
		}
	}	
	
	
	//Added on 17-Aug-2022 Start
	
	public void finaloffer_TopUp_X(String topUpAmount) throws Exception
	{
		VerifyText_For_PageCaption(offer_approved_validation, "Great news - you're approved!", "Basic Info Page, Hence Passed");
		TestBase.bindreport(currentGlobalScenarioName, "loam approved amount details page_landing"); //Added on 21-Sept-2022
		if(getMapData.get("ScenarioforTopUp").equalsIgnoreCase("Yes"))
		{
			loan_TopUp_amount.sendKeys(Keys.CONTROL + "a");
			loan_TopUp_amount.sendKeys(Keys.DELETE);
				EnterText(loan_TopUp_amount,topUpAmount,"Loan ammount");
		}
		
		Thread.sleep(3000); //Added on 19-Aug-2022
		
		if(getMapData.get("LPP").equalsIgnoreCase("Yes"))
			
		{
			click(accept_LPP_Yes,"LPP yes ");
		}
		else if(getMapData.get("LPP").equalsIgnoreCase("No"))
		{
			click(accept_LPP_No,"LPP_no");
			Thread.sleep(10000); //Updated 10k from 3k for QAC sysn
			scrollIntoView(LLP_tooexpensive);
			Thread.sleep(2000);
			click(LLP_tooexpensive,"tooexpensive");
			Thread.sleep(2000); //Added on 02-Nov-2022 for QAC Sync
		}
		waitForElementToBeClickable(next_button,"Process with approved loan");
		if(next_button.isDisplayed())
		{
			click(next_button,"continue ");	
		}
	}	
	
	//Added on 17-Aug-2022 End


	
	}
