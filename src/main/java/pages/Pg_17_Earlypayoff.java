package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;
import driver.TestBase;



public class Pg_17_Earlypayoff extends OnlineActions {

	//WebDriver driver;
		public Pg_17_Earlypayoff(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
		}


	
		@FindBy(how=How.XPATH, using = "//div[@class='mm-card__cardremove col custom_card_btn'][1]")
		public static WebElement Custom_Dash_Button1_LoanCount_01;
	
		@FindBy(how=How.XPATH, using = "//div[@class='mm-card__cardremove col custom_card_btn'][2]")
		public static WebElement Custom_Dash_Button2_LoanCount_01;
	
		@FindBy(how=How.XPATH, using = "//div[@class='mm-card__cardremove col custom_card_btn'][3]")
		public static WebElement Custom_Dash_Button3_LoanCount_01;	
		
		
	
		
		@FindBy(how=How.XPATH, using = "//button[normalize-space()='Make a Payment']")
		public static WebElement makepayment_btm;
		@FindBy(how=How.XPATH, using = "//h1[normalize-space()='Make a Payment']")
		public static WebElement txt_makepayment;
		@FindBy(how=How.XPATH, using = "//span[contains(text(),'full')]")
		public static WebElement txt_fullpaymetn;
		
		
		@FindBy(how=How.XPATH, using = "//input[@value='payFull']/following::span[1]")
		public static WebElement radio_fullpayment;
		
		@FindBy(how=How.XPATH, using = "//button[normalize-space()='Continue']")
		public static WebElement continue_makepayment;
		
		@FindBy(how=How.XPATH, using = "//label[normalize-space()='How would you like to pay?']")
		public static WebElement txt_paymentmethod;
		
		@FindBy(how=How.XPATH, using = "//label[1]//span[1]")
		public static WebElement radio_paymentmethod;
		
		@FindBy(how=How.XPATH, using = "//p[normalize-space()='Please review the Agreement before proceeding.']")
		public static WebElement txt_validationpayment;
		
		@FindBy(how=How.XPATH, using = "//button[normalize-space()='Agree & Continue']")
		public static WebElement bmt_agree;
		
		@FindBy(how=How.XPATH, using = "//p[normalize-space()='Success! Your payment being processed.']")
		public static WebElement txt_sucess;
		
		@FindBy(how=How.XPATH, using = "//a[normalize-space()='Back to Dashboard']")
		public static WebElement back_dashboard;
		
		
		
		@FindBy(how=How.XPATH, using = "//button[@class='mm-user-dash__cta__actions mm-btn mm-btn--primary mm-btn--loan mm-btn--block']")
		public static WebElement verify_IL_button;
		@FindBy(how=How.XPATH, using = "//label[text()='How would you like to pay?']")
		public static WebElement txt_lable_payment_option;
		@FindBy(how=How.XPATH, using = "//span[@class='mm-radio__box']//following-sibling::span[contains(text(),'Pre')]")
		public static WebElement btm_payment;
		@FindBy(how=How.XPATH, using = "//button[text()='Continue']")
		public static WebElement btm_contiue;
		
		@FindBy(how=How.XPATH, using = "//p[contains(text(),'Please review the Agreement')]")
		public static WebElement txt_agreementpage;
		
		@FindBy(how=How.XPATH, using = "//button[text()='Agree & Continue']")
		public static WebElement btm_agree;
		
		@FindBy(how=How.XPATH, using = "//p[contains(text(),'Success')]")
		public static WebElement txt_success;
		
		

		

		
		
	public void Makepayoff() throws Exception
	{
		Thread.sleep(8000);
		waitForElementToBeVisible(Custom_Dash_Button1_LoanCount_01, "email button");
		waitForElementToBeVisible(Custom_Dash_Button2_LoanCount_01, "Cancel button");
		waitForElementToBeVisible(Custom_Dash_Button3_LoanCount_01, "View payment button");
		//System.out.println("*****************************");
		//System.out.println("loan back date wait for sometime ");
		//Thread.sleep(20000);
		
		
		TestBase.getDriver().navigate().refresh();
		Thread.sleep(9000);
		waitForElementToBeVisible(makepayment_btm, "make a payment button");
		TestBase.bindreport(currentGlobalScenarioName, "PaymentScreen1");	 //Added on 04-Oct-2022
		click(makepayment_btm,"click on make payment button");
		
		waitForElementToBeVisible(txt_makepayment, "make a payment button validation");
		VerifyText_For_PageCaption(txt_makepayment, "Make a Payment", "Basic Info Page, Hence Passed");
		
		TestBase.bindreport(currentGlobalScenarioName, "PaymentScreen2"); //Added on 04-Oct-2022
			waitForElementToBeVisible(radio_fullpayment, "EFT payment");
			click(radio_fullpayment,"click on EFT payment");
			TestBase.bindreport(currentGlobalScenarioName, "PaymentScreen3");	//Added on 04-Oct-2022
			Thread.sleep(1000);
			click(continue_makepayment,"Contine");
			Thread.sleep(1000);
			click(continue_makepayment,"Contine");
			
			waitForElementToBeVisible(txt_paymentmethod, "make a payment method ");
		VerifyText_For_PageCaption(txt_paymentmethod, "How would you like to pay?", "Basic Info Page, Hence Passed");
		Thread.sleep(1000);
		click(radio_paymentmethod,"select payment method");
		Thread.sleep(1000);
		TestBase.bindreport(currentGlobalScenarioName, "PaymentScreen4");	//Added on 04-Oct-2022
		click(continue_makepayment,"Contine");
		
		TestBase.bindreport(currentGlobalScenarioName, "PaymentScreen5");	//Added on 04-Oct-2022
		waitForElementToBeVisible(txt_validationpayment, "Agree payoff ");
		VerifyText_For_PageCaption(txt_validationpayment, "Please review the Agreement before proceeding.", "Basic Info Page, Hence Passed");
		
		click(bmt_agree,"select agree method");
		
		waitForElementToBeVisible(txt_sucess, "Success ");
		VerifyText_For_PageCaption(txt_sucess, "Success! Your payment being processed.", "Basic Info Page, Hence Passed");
		
		
		TestBase.bindreport(currentGlobalScenarioName, "PaymentScreen6");	//Added on 04-Oct-2022
		
		click(back_dashboard,"back to dashboard loan");
		
		System.out.println("*****************************");
		
		Thread.sleep(10000);
		
		/* Commented on 16-Aug-2022 Start
		waitForElementToBeVisible(verify_IL_button, "IL loan");
		
		System.out.println("*****************************");
		System.out.println("loan early payoff successfully ");
		Commented on 16-Aug-2022 End
		*/
		System.out.println("*****************************"); //Added on 16-Aug-2022
		System.out.println("loan early payoff successfully "); //Added on 16-Aug-2022
					
	}
	
	public void Makepayoff_SPL() throws Exception
	{
		Thread.sleep(8000);
		waitForElementToBeVisible(Custom_Dash_Button1_LoanCount_01, "email button");
		TestBase.getDriver().navigate().refresh();
		Thread.sleep(9000);
		waitForElementToBeVisible(makepayment_btm, "make a payment button");
		TestBase.bindreport(currentGlobalScenarioName, "PaymentScreen1");	 //Added on 04-Oct-2022	
		click(makepayment_btm,"click on make payment button");
		waitForElementToBeVisible(txt_makepayment, "make a payment button validation");
		VerifyText_For_PageCaption(txt_makepayment, "Make a Payment", "Basic Info Page, Hence Passed");
		TestBase.bindreport(currentGlobalScenarioName, "PaymentScreen2"); //Added on 04-Oct-2022
		
			waitForElementToBeVisible(txt_fullpaymetn, "full payment");
			
			Thread.sleep(1000);
			click(continue_makepayment,"Contine");
			TestBase.bindreport(currentGlobalScenarioName, "PaymentScreen3");	//Added on 04-Oct-2022
		VerifyText_For_PageCaption(txt_lable_payment_option, "How would you like to pay?", "Passed");
		
		click(btm_payment, "Paymenet option");
		TestBase.bindreport(currentGlobalScenarioName, "PaymentScreen4");	//Added on 04-Oct-2022
		click(btm_contiue, "Continue button");
		TestBase.bindreport(currentGlobalScenarioName, "PaymentScreen5");	//Added on 04-Oct-2022
		waitForElementToBeVisible(txt_agreementpage, "agreement  payment");
		click(btm_agree, "click on agreee button");
		TestBase.bindreport(currentGlobalScenarioName, "PaymentScreen6");	//Added on 04-Oct-2022
		VerifyText_For_PageCaption(txt_success, "Success! Your payment being processed.", "Passed");
		click(back_dashboard,"back to dashboard loan");
		
	}
}
