package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;



public class Pg_11_eSignDocs extends OnlineActions {

	public Pg_11_eSignDocs(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	//Sigh the documents

	@FindBy (how=How.XPATH, using = "//h1[normalize-space()='Scroll through each box to review loan documents.']")
	public static WebElement txt_LoanSignDocs2;
	
	@FindBy (how=How.XPATH, using = "//p[@class='step-4-of-4-review pt-2' or contains(normalize-space(),'Step 3 of 3: Review and sign these documents — then we’ll send your money.')]")
	public static WebElement txt_LoanSignDocs;
	
	@FindBy (how=How.XPATH, using = "//h3[normalize-space()='Loan Agreement']")
	public static WebElement SignDocs_LoanAgreement;

	@FindBy (how=How.XPATH, using = "//label[@for='agreement-0']")
	public static WebElement txt_Checkbox_LoanAgreement;

	@FindBy (how=How.XPATH, using = "//input[@id='agreement-0']/following::span[1]")
	public static WebElement Checkbox_LoanAgreement1;
	
	@FindBy (how=How.XPATH, using = "//u[normalize-space()='Loan Agreement']/following::span[1]")
	public static WebElement Checkbox_LoanAgreement;
	
	@FindBy (how=How.XPATH, using = "//input[@name='signature']")
	public static WebElement txt_check_loanagreement_signature_NS;
	
	
	
	@FindBy (how=How.XPATH, using = "//u[normalize-space()='PAD Agreement']/following::span[1]")
	public static WebElement Checkbox_PadAgreement;
	
	@FindBy (how=How.XPATH, using = "//u[normalize-space()='Loan Agreement']/preceding::span[1]")
	public static WebElement link_LoanAgreement;
	
	//Added on 16-Nov-2022 Start
	@FindBy (how=How.XPATH, using = "//p[contains(text(),'each document')]")
	public static WebElement caption_CheckAgainstEachDocument;
	
	@FindBy (how=How.XPATH, using = "//u[normalize-space()='Loan Agreement Disclosure']/following::span[1]")
	public static WebElement check_Loan_Agreement_DisclosureAB;
	
	//Added on 16-Nov-2022 End
	
	@FindBy (how=How.XPATH, using = "//label[@for='agreement-1']")
	public static WebElement txt_Checkbox_Amortzation;

	@FindBy (how=How.XPATH, using = "//input[@id='agreement-1']/following::span[1]")
	public static WebElement Checkbox_Amortzation1;
	
	@FindBy (how=How.XPATH, using = "//u[normalize-space()='Loan Amortization']/following::span[1]")
	public static WebElement Checkbox_Amortzation;

	@FindBy (how=How.XPATH, using = "//label[@for='agreement-2']")
	public static WebElement txt_Checkbox_AutoPayuth;

	@FindBy (how=How.XPATH, using = "//u[normalize-space()='Loan Agreement Disclosure']/following::span[1]")
	public static WebElement Checkbox_AutoPayuth;

	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Accept']")
	public static WebElement btn_Accept1;
	
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='I Agree']")
	public static WebElement btn_IAgree;

	@FindBy (how=How.XPATH, using = "//a[normalize-space()='Back to Dashboard']")
	public static WebElement btn_BackToDash;
	
	//Prod download for IL
	
	@FindBy (how=How.XPATH, using = "//a[normalize-space()='Download']")
	public static List<WebElement> List_Download;
	
	@FindBy (how=How.XPATH, using = "//i[@class='mm-icon mm-icon--person mm-header__user-icon']")
	public static WebElement profile;
	
	@FindBy (how=How.XPATH, using = "//h2[normalize-space()='Exit Application']")
	public static WebElement txt_ExitApp;
	
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Yes, Exit Application']")
	public static WebElement btn_ExitApp;
	
	@FindBy (how=How.XPATH, using = "//div[@title='Withdraw Loan Application']")
	public static WebElement withdrawLoanApp;
	
	@FindBy (how=How.XPATH, using = "//h1[normalize-space()='Withdraw Loan']")
	public static WebElement txt_Withdraw;
	
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Continue']")
	public static WebElement continuebtn;
	
	@FindBy (how=How.XPATH, using = "//p[@class='message-text']")
	public static WebElement txt_Withdraw_Confirmation;
	
	@FindBy (how=How.XPATH, using = "//i[@class='mm-icon mm-icon--arrow-back']")
	public static WebElement symb_BacktoDash;
	
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Installment Loan']")
	public static WebElement Dash_IL_Apply;
	
	//LPP_Yes sign docs
	
	@FindBy (how=How.XPATH, using = "//span[normalize-space()='Loan Agreement']/preceding::i[1]")
	public static WebElement Arrow_LoanAgreement;
	
	//BC province added 13-july-2022
	@FindBy (how=How.XPATH, using = "(//img[@alt='Open'])[1]")
	public static WebElement arrow_LoanAgreement;
	
	@FindBy (how=How.XPATH, using = "//input[@name='signature']")
	public static WebElement loangreement_signature;
	
	
	@FindBy (how=How.XPATH, using = "//u[normalize-space()='Loan Agreement']/following::span[1]")
	public static WebElement check_LoanAgreement;
	
	@FindBy (how=How.XPATH, using = "(//img[@alt='Open'])[2]")
	public static WebElement Arrow_Amortization;
	
	@FindBy (how=How.XPATH, using = "//input[@placeholder='Initials']")
	public static WebElement initials_Amortization;
	
	
	@FindBy (how=How.XPATH, using = "//u[normalize-space()='Loan Amortization']/following::span[1]")
	public static WebElement check_Amortization;
	
	@FindBy (how=How.XPATH, using = "//span[normalize-space()='Auto-Payment Authorization']/preceding::i[1]")
	public static WebElement Arrow_AutoPay;
	
	@FindBy (how=How.XPATH, using = "//span[normalize-space()='Lpp Waiver Form']/preceding::i[1]")
	public static WebElement Arrow_LPPWavier;
	
	//@FindBy (how=How.XPATH, using = "//u[normalize-space()='Lpp Waiver Form']/following::span[1]") //Commented on 31-Oct-2022
	@FindBy (how=How.XPATH, using = "//u[normalize-space()='LPP Waiver Form']/following::span[1]") //Added on 31-Oct-2022
	public static WebElement check_LPPWavier;
	
	@FindBy (how=How.XPATH, using = "//u[normalize-space()='Auto-Payment Authorization']/following::span[1]")
	public static WebElement check_AutoPay;
	
	@FindBy (how=How.XPATH, using = "//strong[text()='I Agree']")
	public static WebElement caption_IAgreee;
	
	
	
	@FindBy (how=How.XPATH, using = "//span[normalize-space()='Standard Term Loan Protection Plan Summary']/preceding::i[1]")
	public static WebElement Arrow_LPPSummary;
	
	@FindBy (how=How.XPATH, using = "//u[normalize-space()='Standard Term Loan Protection Plan Summary']/following::span[1]")
	public static WebElement check_LPPSummary;
	
	@FindBy (how=How.XPATH, using = "//u[normalize-space()='Application to Enroll for Optional Creditor Protection Insurance (LPP)']/following::span[1]")
	public static WebElement Arrow_AEOCPI;
	
	@FindBy (how=How.XPATH, using = "//input[@name='signature']")
	public static WebElement input_AEOCPI;
	
	@FindBy (how=How.XPATH, using = "//div[@class='mm-document-box__checkbox']//span[@class='mm-checkbox__box']")
	public static WebElement check_AEOCPI;
		
	@FindBy (how=How.XPATH, using = "//span[normalize-space()='Certificate of Insurance']/preceding::i[1]")
	public static WebElement Arrow_COI;
	
	@FindBy (how=How.XPATH, using = "//u[normalize-space()='Certificate of Insurance']/following::span[1]")
	public static WebElement check_COI;
	
	@FindBy (how=How.XPATH, using = "//span[normalize-space()='Loan Protection Plan Auto-Payment Authorization']/preceding::i[1]")
	public static WebElement Arrow_LPPAutoPay;
	
	@FindBy (how=How.XPATH, using = "//u[normalize-space()='Loan Protection Plan Auto-Payment Authorization']/following::span[1]")
	public static WebElement check_LPPAutoPay;
	
	@FindBy (how=How.XPATH, using = "//span[normalize-space()='Lpp Disclosure']/preceding::i[1]")
	public static WebElement Arrow_LPPDisc;
	
	@FindBy (how=How.XPATH, using = "//span[normalize-space()='Lpp Disclosure']/following::span[1]")
	public static WebElement check_LPPDisc;
	@FindBy (how=How.XPATH, using = "//div[@class='itemcontainer relative']/label[1]/span[1]")
	public static WebElement checkbox_one_BC;
	@FindBy (how=How.XPATH, using = "//div[@class='itemcontainer relative']/label[2]/span[1]")
	public static WebElement checkbox_two_BC;
	@FindBy (how=How.XPATH, using = "//div[@class='itemcontainer relative']/label[3]/span[1]")
	public static WebElement checkbox_three_BC;
	
	@FindBy (how=How.XPATH, using = "//p[contains(text(),'Check the box beside each document ')]")
	public static WebElement caption_Check_the_box_beside_each_document;
	

	//14-Nov-2022 Start
	@FindBy (how=How.XPATH, using = "//u[normalize-space()='Loan Agreement Disclosure']/following::span[1]")
	public static WebElement check_Loan_Agreement_Disclosure;
	
	@FindBy (how=How.XPATH, using = "(//img[@alt='Open'])[2]")
	public static WebElement Arrow_Loan_Agreement;
	
	@FindBy (how=How.XPATH, using = "//input[@name='signature']")
	public static WebElement txt_SignatureName;

	@FindBy (how=How.XPATH, using = "//u[normalize-space()='Loan Agreement']/following::span[1]")
	public static WebElement Check_Loan_Agreement;
	
	@FindBy (how=How.XPATH, using = "//u[normalize-space()='PAD Agreement']/following::span[1]")
	public static WebElement Check_PAD_Agreement;
	
	
	//Added on 17-Nov-2022 Start
	@FindBy (how=How.XPATH, using = "//div[text()='View Payment Schedule']")
	public static WebElement link_View_Payment_Schedule;
	
	@FindBy (how=How.XPATH, using = "//a[text()=' Back to dashboard']")
	public static WebElement link_BackToDashboard;
	//Added on 17-Nov-2022 End
	
	public void Sign_Loan_Docs_AB() throws Exception
	{
		waitForElementToBeVisible(txt_LoanSignDocs,"Text in loan sign page");
		
		if(getMapData.get("Current_Address_Province").equalsIgnoreCase("AB"))
		{
			waitForElementToBeClickable(check_Loan_Agreement_Disclosure, "WaitLoanAgreementDisclosure");
			click(check_Loan_Agreement_Disclosure, "clkLoan_Agreement_Disclosure");
			
			waitForElementToBeClickable(Arrow_Loan_Agreement, "WaitArraowAgreement");
			click(Arrow_Loan_Agreement, "ClkArrowAgreement");
			bindreport(currentGlobalScenarioName, "arrow_LoanAgreementscr");
			Thread.sleep(3000);
			EnterText(txt_SignatureName, getMapData.get("LastName"),"Last name");
			bindreport(currentGlobalScenarioName, "LastName");
			Thread.sleep(3000);
			scrollIntoView(caption_Check_the_box_beside_each_document); //Added on 15-Oct-2022
			Thread.sleep(2000); //Added on 15-Oct-2022
			bindreport(currentGlobalScenarioName, "TopAgain");
			click(Arrow_Loan_Agreement, "Arrrow loan agreeemnt"); //Added on 15-Oct-2022
			Thread.sleep(2000); //Added on 15-Oct-2022
			
			waitForElementToBeClickable(Check_Loan_Agreement, "WaitLoanAgreementD");
			click(Check_Loan_Agreement, "clkLoan_Agreement");
			bindreport(currentGlobalScenarioName, "LoanAgrmnt");
			
			waitForElementToBeClickable(Check_PAD_Agreement, "WaitPadAgrment");
			click(Check_PAD_Agreement, "clkPADAgreement");
			bindreport(currentGlobalScenarioName, "PadLoanAgrmnt");
			
			if(btn_IAgree.isEnabled())
			{
			click(btn_IAgree,"I Agree");
			}
			
			waitForElementToBeVisible(btn_BackToDash, "Back to dashboard");
			//TakeScreenshot("Offer");
			click(btn_BackToDash,"Back to dashboard");
		}
	}
	
	
	//14-Nov-2022 End
	
	
	public void Sign_Loan_Docs() throws Exception
	{
		
		waitForElementToBeVisible(txt_LoanSignDocs,"Text in loan sign page");
		
		
		
	
		
		
		
		 if(getMapData.get("Current_Address_Province").equalsIgnoreCase("BC"))
			{
			 if(getMapData.get("LPP").equalsIgnoreCase("Yes"))
				{
				//added 13-july-2022  start
				 click(arrow_LoanAgreement, "Arrrow loan agreeemnt");
				 
				 waitForElementToBeClickable(loangreement_signature, "loangreement_signatureWait"); //Added on 15-Oct-2022
				 click(loangreement_signature,"singature");
					Thread.sleep(3000);
					EnterText(loangreement_signature, getMapData.get("LastName"),"Last name");
					Thread.sleep(3000);
					click(check_LoanAgreement,"checkbox for Loan Agreement");
					
					//click(Arrow_Amortization,"Amortization");
					//Thread.sleep(3000);
					click(Arrow_Amortization, "Arrrow loan amortization");
				
					waitForElementToBeClickable(initials_Amortization, "initials_AmortizationWait"); //Added on 15-Oct-2022
					click(initials_Amortization,"AEOCPI");
					Thread.sleep(3000);
					EnterText(initials_Amortization, getMapData.get("LastName"),"Last name");
					Thread.sleep(3000);
					
					click(check_Amortization,"checkbox for Loan Amortization");
					
					//added 13-july-2022 end
					
					//click(Arrow_AutoPay,"Loan Auto payment");
					//Thread.sleep(3000);
					click(check_AutoPay,"checkbox for Loan Auto payment");
					
					//click(Arrow_LPPSummary,"LPPSummary");
					//Thread.sleep(3000);
					click(check_LPPSummary,"checkbox for LPPSummary");
					
					click(Arrow_AEOCPI,"AEOCPI");
					Thread.sleep(3000);
					EnterText(input_AEOCPI, getMapData.get("LastName"),"Last name");
					Thread.sleep(3000);
					click(check_AEOCPI,"checkbox for AEOCPI");
					click(check_AEOCPI,"checkbox for AEOCPI");
					//click(Arrow_COI,"Certificate of Insurance");
					//Thread.sleep(3000);
					click(check_COI,"checkbox for Certificate of Insurancet");
					
					//click(Arrow_LPPAutoPay,"LPPAutoPay");
					//Thread.sleep(3000);
					click(check_LPPAutoPay,"checkbox for LPPAutoPay");
					
					if(getMapData.get("Current_Address_Province").equalsIgnoreCase("AB"))
					{
						click(Arrow_LPPDisc,"LPP Disclosure");
						Thread.sleep(3000);
						click(check_LPPDisc,"checkbox for LPP Disclosure");	
					}
					
					if(btn_IAgree.isEnabled())
					{
					click(btn_IAgree,"I Agree");
					}
					
					waitForElementToBeVisible(btn_BackToDash, "Back to dashboard");
					//TakeScreenshot("Offer");
					click(btn_BackToDash,"Back to dashboard");
				}
				else if(getMapData.get("LPP").equalsIgnoreCase("No"))
				{
					//added 13-july-2022 start
					click(arrow_LoanAgreement, "Arrrow loan agreeemnt");
					 bindreport(currentGlobalScenarioName, "arrow_LoanAgreementscr");
					 click(loangreement_signature,"singature");
						Thread.sleep(3000);
						EnterText(loangreement_signature, getMapData.get("LastName"),"Last name");
						 bindreport(currentGlobalScenarioName, "loangreement_signature");
						Thread.sleep(3000);
						
						
						
						scrollIntoView(caption_Check_the_box_beside_each_document); //Added on 15-Oct-2022
						Thread.sleep(2000); //Added on 15-Oct-2022
						click(arrow_LoanAgreement, "Arrrow loan agreeemnt"); //Added on 15-Oct-2022
						Thread.sleep(2000); //Added on 15-Oct-2022
						click(check_LoanAgreement,"checkbox for Loan Agreement");
						 bindreport(currentGlobalScenarioName, "check_LoanAgreement");
						//click(Arrow_Amortization,"Amortization");
						Thread.sleep(3000); //Uncommented on 13-Oct-2022
						////////////////////////scrollIntoView(Arrow_Amortization); //Added on 15-Oct-2022
	//////////////////////Thread.sleep(2000); //Added on 15-Oct-2022
						click(Arrow_Amortization, "Arrrow loan amortization");
						
						click(initials_Amortization,"AEOCPI");
						Thread.sleep(3000);
						EnterText(initials_Amortization, getMapData.get("LastName"),"Last name");
						 bindreport(currentGlobalScenarioName, "initials_Amortization");
						Thread.sleep(3000);
						scrollIntoView(caption_Check_the_box_beside_each_document); //Added on 15-Oct-2022
						Thread.sleep(2000); //Added on 15-Oct-2022
						click(Arrow_Amortization, "Arrrow loan amortization");//Added on 15-Oct-2022
						Thread.sleep(2000); //Added on 15-Oct-2022
						click(check_Amortization,"checkbox for Loan Amortization");
						 bindreport(currentGlobalScenarioName, "check_Amortization");
						//added 13-july-2022  end
					//click(Arrow_AutoPay,"Loan Auto payment");
						
					///////////////////////scrollIntoView(caption_IAgreee); //Added on 15-Oct-2022	
						
					Thread.sleep(3000); //Uncommented on 13-Oct-2022
					click(check_AutoPay,"checkbox for Loan Auto payment");
					
					//click(Arrow_LPPWavier,"Loan Auto payment");
					Thread.sleep(3000); //Uncommented on 13-Oct-2022
					click(check_LPPWavier,"checkbox for Loan Auto payment");
					
					 bindreport(currentGlobalScenarioName, "beforeIAgreee");
					click(btn_IAgree,"I Agree");
					waitForElementToBeVisible(btn_BackToDash, "Back to dashboard");
					//TakeScreenshot("Offer");
					click(btn_BackToDash,"Back to dashboard");
					
				}
			
			}
		 else 
		 {
		 
		if(getMapData.get("LPP").equalsIgnoreCase("Yes"))
		{
			Thread.sleep(3000);
			click(Checkbox_LoanAgreement,"checkbox for Loan Agreement");
			
			//click(Arrow_Amortization,"Amortization");
			//Thread.sleep(3000);
			click(Checkbox_Amortzation,"checkbox for Loan Amortization");
			
			click(check_AutoPay,"checkbox for Loan Auto payment");
			
			//click(Arrow_LPPSummary,"LPPSummary");
			//Thread.sleep(3000);
			click(check_LPPSummary,"checkbox for LPPSummary");
			
			click(Arrow_AEOCPI,"AEOCPI");
			Thread.sleep(3000);
			EnterText(input_AEOCPI, getMapData.get("LastName"),"Last name");
			Thread.sleep(3000);
			click(check_AEOCPI,"checkbox for AEOCPI");
			click(check_AEOCPI,"checkbox for AEOCPI");
			//click(Arrow_COI,"Certificate of Insurance");
			//Thread.sleep(3000);
			click(check_COI,"checkbox for Certificate of Insurancet");
			
			//click(Arrow_LPPAutoPay,"LPPAutoPay");
			//Thread.sleep(3000);
			//click(check_LPPAutoPay,"checkbox for LPPAutoPay"); Commented on 22-Aug-2023 Revised (Due to not came in the LPP Yes Flow)
			
			if(getMapData.get("Current_Address_Province").equalsIgnoreCase("AB"))
			{
				click(Arrow_LPPDisc,"LPP Disclosure");
				Thread.sleep(3000);
				click(check_LPPDisc,"checkbox for LPP Disclosure");	
			}
			
			if(btn_IAgree.isEnabled())
			{
			click(btn_IAgree,"I Agree");
			}
			
			waitForElementToBeVisible(btn_BackToDash, "Back to dashboard");
			//TakeScreenshot("Offer");
			click(btn_BackToDash,"Back to dashboard");
		}
		else if(getMapData.get("LPP").equalsIgnoreCase("No"))
		{
			//click(Arrow_LoanAgreement,"Loan Agreement");
			Thread.sleep(3000);
			click(Checkbox_LoanAgreement,"checkbox for Loan Agreement");
			
			//click(Arrow_Amortization,"Amortization");
			//Thread.sleep(3000);
			click(Checkbox_Amortzation,"checkbox for Loan Amortization");
			
			//click(Arrow_AutoPay,"Loan Auto payment");
			//Thread.sleep(3000);
			click(check_AutoPay,"checkbox for Loan Auto payment");
			
			//click(Arrow_LPPWavier,"Loan Auto payment");
			//Thread.sleep(3000);
			click(check_LPPWavier,"checkbox for Loan Auto payment");
			
			click(btn_IAgree,"I Agree");
			waitForElementToBeVisible(btn_BackToDash, "Back to dashboard");
			//TakeScreenshot("Offer");
			click(btn_BackToDash,"Back to dashboard");
			
		}
	
		 }
	}
	
	
	
	public void showLoanPaymentSchedule() throws Exception
	{
		waitForElementToBeClickable(link_View_Payment_Schedule, "waitViewPaymentScheduleLink");
		click(link_View_Payment_Schedule, "clkViewPaymentSchedule");
		Thread.sleep(2000);
		bindreport(currentGlobalScenarioName, "PaymentSchedule");
		Thread.sleep(2000);
		waitForElementToBeClickable(link_BackToDashboard, "waitBacktoDashboard");
		click(link_BackToDashboard, "clkBacktoDashboard");
		Thread.sleep(2000);
		bindreport(currentGlobalScenarioName, "PaymentSchedule");
	}
	
	public void Sign_Loan_Docs_SPL() throws Exception
	{
		//loadingWait(Pg_CommonLocators.Loading,"Loading Div");
		 if(getMapData.get("Current_Address_Province").equalsIgnoreCase("MB")||getMapData.get("Current_Address_Province").equalsIgnoreCase("ON"))
		{
		
		waitForElementToBeVisible(txt_LoanSignDocs,"Text in loan sign page");	
		Thread.sleep(4000);
		ScrollToElement(Checkbox_LoanAgreement, "Loan Agreement");
		click(Checkbox_LoanAgreement,"check for Loan Agreement");
		Thread.sleep(4000);
		click(Checkbox_PadAgreement,"check for Pad Agreement");
		Thread.sleep(5000);
		click(btn_IAgree,"I Agree");
		waitForElementToBeVisible(btn_BackToDash, "Back to dashboard");
		//TakeScreenshot("Back to dashboard");
		click(btn_BackToDash,"Back to dashboard");
		}
		 //added 14 july 2022 start
		 else if(getMapData.get("Current_Address_Province").equalsIgnoreCase("NS"))
		 {

				waitForElementToBeVisible(txt_LoanSignDocs,"Text in loan sign page");	
				Thread.sleep(4000);
				ScrollToElement(Checkbox_LoanAgreement, "Loan Agreement");
				click(link_LoanAgreement,"link LoanAgreement");
				
				EnterText(txt_check_loanagreement_signature_NS, getMapData.get("LastName"),"Last name");
				click(Checkbox_LoanAgreement,"check for Loan Agreement");
				Thread.sleep(4000);
				click(Checkbox_PadAgreement,"check for Pad Agreement");
				Thread.sleep(5000);
				click(btn_IAgree,"I Agree");
				waitForElementToBeVisible(btn_BackToDash, "Back to dashboard");
				//TakeScreenshot("Back to dashboard");
				click(btn_BackToDash,"Back to dashboard");
		 }
		//added 14 july 2022 End
		 //Added on 16-Nov-2022 Start
		 else if(getMapData.get("Current_Address_Province").equalsIgnoreCase("AB"))
		 {

				waitForElementToBeVisible(txt_LoanSignDocs,"Text in loan sign page");	
				Thread.sleep(4000);
				//ScrollToElement(Checkbox_LoanAgreement, "Loan Agreement"); Commented on 16-Nov-2022
				click(link_LoanAgreement,"link LoanAgreement");
				Thread.sleep(2000); //Added on 16-Nov-2022
				EnterText(txt_check_loanagreement_signature_NS, getMapData.get("LastName"),"Last name");
				Thread.sleep(2000); //Added on 16-Nov-2022
				bindreport(currentGlobalScenarioName, "Signature");
				scrollIntoView(caption_CheckAgainstEachDocument); //Added on 16-Nov-2022
				Thread.sleep(2000); //Added on 16-Nov-2022
				click(link_LoanAgreement,"link LoanAgreement"); //Added on 16-Nov-2022
				Thread.sleep(2000); //Added on 16-Nov-2022
				click(Checkbox_LoanAgreement,"check for Loan Agreement");
				Thread.sleep(4000);
				bindreport(currentGlobalScenarioName, "LoanAgreement");
				click(Checkbox_PadAgreement,"check for Pad Agreement");
				Thread.sleep(5000);
				bindreport(currentGlobalScenarioName, "PADAgreement");
				
				click(check_Loan_Agreement_DisclosureAB,"Loan Agreement Disclosure"); //Added on 16-Nov-2022
				Thread.sleep(2000); //Added on 16-Nov-2022
				
				click(btn_IAgree,"I Agree");
				waitForElementToBeVisible(btn_BackToDash, "Back to dashboard");
				//TakeScreenshot("Back to dashboard");
				bindreport(currentGlobalScenarioName, "BackToDashboard");
				click(btn_BackToDash,"Back to dashboard");
		 }
		//Added on 16-Nov-2022 End
		 else if(getMapData.get("Current_Address_Province").equalsIgnoreCase("BC"))
			{ 
	
		
		waitForElementToBeVisible(txt_LoanSignDocs,"Text in loan sign page");	
		Thread.sleep(4000);
		click(checkbox_one_BC, "Loan agreement checkbox");
		click(checkbox_two_BC, "Loan agreement checkbox");
		click(checkbox_three_BC, "Loan agreement checkbox");
		ScrollToElement(Checkbox_LoanAgreement, "Loan Agreement");
		click(Checkbox_LoanAgreement,"check for Loan Agreement");
		Thread.sleep(4000);
		click(Checkbox_PadAgreement,"check for Pad Agreement");
		Thread.sleep(5000);
		click(btn_IAgree,"I Agree");
		waitForElementToBeVisible(btn_BackToDash, "Back to dashboard");
		//TakeScreenshot("Back to dashboard");
		click(btn_BackToDash,"Back to dashboard");
	}
	}
	public void Sign_Loan_Docs_EPP() throws Exception
	{
		//TreeMap<String, String> getMapData = new TreeMap<String, String>();
		//getMapData  = Xls_Reader.getCellDataBasedOnRowValuefromTestData(TestBase.gettestCaseName(), TestBase.gettestCaseName()+TestBase.getEnvironment()+TestBase.getDevice()+TestBase.getOS1()+TestBase.getOSVersion()+TestBase.getBrowser()); //AddedPP 02-Apr-2019 // Updated method name on 06-MAY-2019 Commented on 13-MAY-2019
		//loadingWait(Pg_CommonLocators.Loading,"Loading Div");
		waitForElementToBeVisible(txt_LoanSignDocs,"Text in loan sign page");	
		Thread.sleep(2000);
		click(Checkbox_AutoPayuth,"check for Loan Agreement disclosure");
		Thread.sleep(2000);
		click(link_LoanAgreement,"link LoanAgreement");
		EnterText(input_AEOCPI, getMapData.get("LastName"),"Last name");
		Thread.sleep(2000);
		click(check_AEOCPI,"check for Loan Agreement");
		click(Checkbox_PadAgreement,"check for Pad Agreement");
		click(btn_IAgree,"I Agree");
		waitForElementToBeVisible(btn_BackToDash, "Back to dashboard");
		//TakeScreenshot("Back to dashboard");
		click(btn_BackToDash,"Back to dashboard");
		Thread.sleep(2000);
		//TakeScreenshot("Dashboard");
	}
}
