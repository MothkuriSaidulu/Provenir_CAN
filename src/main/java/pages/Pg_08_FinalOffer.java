package pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import  actions.OnlineActions;
import  driver.TestBase;
import  sqlUtils.MsSqlUtility;

;

public class Pg_08_FinalOffer extends OnlineActions {

	public Pg_08_FinalOffer(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String YourApprovedTxt;
	public String YourMaxAmount;
	public static String ApprovedLoanAmount;
	public String APRValue;
	public static String MonthlyPayAmount;
	public static String TermMonths;
	public static String PaymentDueOn;
	public static String LoanValue;
	public static String TotalLoanValue;

	public String YourApprovedTxt_SPL;
	public String YourMaxAmount_SPL;
	public static String ApprovedLoanAmount_SPL;
	public String PaymentDueOn_SPL;
	//Details on Cash Advance Agreement
	public static String CAA_Principal_SPL;
	public String CAA_DateOfInitialAdvance;
	public String CAA_LoanTermInDays;
	public String CAA_LoanFee;
	public String CAA_TotalCostOfBorrowing;
	public static String CAA_APR_SPL;
	public static String CAA_AmountDue;
	public static String CAA_PaymentDateAndAmountDue;
	public static String EPP_AmountDue;

	public static String refinance_NewLoanAmount;
	public static String refinance_PreviousLoanPayyOff;
	public static String refinance_BalanceFromRefi;

	//	Pg_DataBase_Actions obj_DB = new Pg_DataBase_Actions(driver);
	//	Pg_06_ThankYou_DocumentUpload obj_UploadDocs = new Pg_06_ThankYou_DocumentUpload(driver);
	//	Pg_07_Dashboard obj_Dashboard = new Pg_07_Dashboard(driver);
	//	Pg_08_FinalOffer obj_FinalOffer = new Pg_08_FinalOffer(driver);
	//Final offer page

	@FindBy (how=How.XPATH, using = "//div[@class='mm-congrats-header']")
	public static WebElement head_LoanOffer;
	
	@FindBy (how=How.XPATH, using = "//div[@class='mm-congrats-header']")
	public static List<WebElement> List_head_LoanOffer;
	
	@FindBy (how=How.XPATH, using = "//h2[contains(text(),'Congratulations you are approved for an installment loan')]")
	public static List<WebElement> List_LPP_Congrats;

	@FindBy (how=How.XPATH, using = "//div[@class='mm-congrats-grp']")
	public static WebElement head_LoanOffer1;

	@FindBy (how=How.XPATH, using = "//div[@class='amt mt-2']")
	public static WebElement step1_ApprovedAmnt;

	@FindBy (how=How.XPATH, using = "//h1[@class='mt-2 mm-lo-header']")
	public static WebElement txt_YourApprovedIL;

	@FindBy (how=How.XPATH, using = "//h2[@class='mb-2 mm-lo-offer-text__header']")
	public static WebElement txt_YourMaxAmount;

	@FindBy (how=How.XPATH, using = "//div[normalize-space()='Loan Amount']/following::input[1]")
	public static WebElement txt_ApprovedLoanAmount;

	@FindBy (how=How.XPATH, using = "//h1[normalize-space()=\"Great news - you're approved!\"]")
	public static WebElement header_LoanApprovdTxt;
	
	@FindBy (how=How.XPATH, using = "//h1[normalize-space()=\"Great news - you're approved!\"]")
	public static List<WebElement> List_header_LoanApprovdTxt;

	@FindBy (how=How.XPATH, using = "//h2[@class='mm-lo-amount__loan']")
	public static WebElement txt_ApprovedLoanAmount_SPL;

	@FindBy (how=How.XPATH, using = "//div[normalize-space()='APR']/following::div[1]")
	public static WebElement txt_APRValue;

	@FindBy (how=How.XPATH, using = "//div[normalize-space()='Total Loan Payments with LPP']/following-sibling::div[1]")
	public static WebElement txt_MonthlyPayAmount;

	@FindBy (how=How.XPATH, using = "//div[normalize-space()='Total Loan Payments']/following-sibling::div[1]")
	public static WebElement txt_MonthlyPayAmount_LPPNO;

	@FindBy (how=How.XPATH, using = "//div[contains(text(),'Loan Term')]/following::input[1]")
	public static WebElement txt_TermMonths;

	@FindBy (how=How.XPATH, using = "//h4[normalize-space()='Payment due on:']/following-sibling::h3")
	public static WebElement txt_PaymentDueOn1;

	@FindBy (how=How.XPATH, using = "//div[normalize-space()='First Payment Due']/following-sibling::div")
	public static WebElement txt_PaymentDueOn2;

	@FindBy (how=How.XPATH, using = "//div[normalize-space()='First Payment Due']/following-sibling::div[1]")
	public static WebElement txt_PaymentDueOn;

	@FindBy (how=How.XPATH, using = "//tbody/tr")
	public static List<WebElement> List_Table_Rows;

	@FindBy (how=How.XPATH, using = "//h3[normalize-space()='Details of the Cash Advance Agreement']/following::table/tbody/tr")
	public static List<WebElement> List_Table_Rows_EPPLoan;

	@FindBy (how=How.XPATH, using = "//h3[normalize-space()='Payments due on']/following-sibling::table/tbody/tr")
	public static List<WebElement> List_Table_Rows_EPPLoanPaydue;

	@FindBy (how=How.XPATH, using = "//div[normalize-space()='First Payment Due']/following-sibling::div")
	public static WebElement EPP_FirstPaymentDue;

	@FindBy (how=How.XPATH, using = "//h3[normalize-space()='Payments due on']/following-sibling::table/tbody/tr[1]/td[2]")
	public static WebElement EPP_FirstPaymentDue_old;

	@FindBy (how=How.XPATH, using = "//tbody/tr")
	public static WebElement Table_Rows;

	@FindBy (how=How.XPATH, using = "//tbody/tr/td")
	public static List<WebElement> List_Table_Columns;

	@FindBy (how=How.XPATH, using = "//h3[normalize-space()='Details of the Cash Advance Agreement']/following::table/tbody/tr/td")
	public static List<WebElement> List_Table_Columns_EPPLoan;

	@FindBy (how=How.XPATH, using = "//h3[normalize-space()='Payments due on']/following-sibling::table/tbody/tr/td")
	public static List<WebElement> List_Table_Columns_EPPLoanPaydue;

	@FindBy (how=How.XPATH, using = "//tbody/tr/td")
	public static WebElement Table_Columnss;

	@FindBy (how=How.XPATH, using = "//button[@form='offer-form']")
	public static WebElement btn_FundMyLoan;

	@FindBy (how=How.XPATH, using = "//p[normalize-space()='New Loan Amount']/preceding::strong[1]")
	public static WebElement refi_NewLoanAmount;

	@FindBy (how=How.XPATH, using = "//p[normalize-space()='Previous Loan Payoff']/preceding::strong[1]")
	public static WebElement refi_PreviousLoanPayyOff;

	@FindBy (how=How.XPATH, using = "//p[normalize-space()='Balance from Refinance']/preceding::strong[1]")
	public static WebElement refi_BalanceFromRefi;

	@FindBy (how=How.XPATH, using = "//div[normalize-space()='Desired Loan Amount']/following::input[1]")
	public static WebElement FinalOffer_Loan;
	
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Next']")
	public static WebElement btn_Nextt;
	
	@FindBy (how=How.XPATH, using = "//div[text()='Loan Amount']//parent::div//descendant::div[2]//input")
	public static WebElement loan_amount;
	
	

	//Final offer page EPP

	@FindBy (how=How.XPATH, using = "//input[@class='mm-input']")
	public static WebElement EPP_FinalOffer_Loan;


	//LPP info

	@FindBy (how=How.XPATH, using = "//h1[contains(text(),'Congratulations you are approved for an installmen')]")
	public static WebElement LPP_Congratulations;

	@FindBy (how=How.XPATH, using = "//button[normalize-space()='View My Loan Offer']")
	public static WebElement LPP_ViewMyOffer;

	//LPP options

	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Yes']")
	public static WebElement LPP_Yes;

	@FindBy (how=How.XPATH, using = "//button[normalize-space()='No']")
	public static WebElement LPP_No;

	@FindBy (how=How.XPATH, using = "//h3[normalize-space()='Please select your reason for not accepting the LPP']")
	public static WebElement txt_AreUSure;

	@FindBy (how=How.XPATH, using = "//button[@class='mm-select__value']")
	public static WebElement dd_LPPNo;

	@FindBy (how=How.XPATH, using = "//button[contains(text(),'No thanks, I don’t want it')]")
	public static WebElement LPP_NO_confirm;
	
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Coverage through work']")
	public static WebElement LPP_NO_Reason;

	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Too expensive']")
	public static WebElement dd_LPPNo_reason;

	@FindBy (how=How.XPATH, using = "//div[normalize-space()='LPP* premium']/following-sibling::div[1]")
	public static WebElement LPP_Premium;

	@FindBy (how=How.XPATH, using = "//div[normalize-space()='LPP* premium']/following::div[3]")
	public static WebElement LPP_text_SalesTax;

	@FindBy (how=How.XPATH, using = "//div[normalize-space()='LPP* premium']/following::div[4]")
	public static WebElement LPP_Value_SalesTax;

	@FindBy (how=How.XPATH, using = "//div[normalize-space()='Total LPP amount per payment']/following::div[1]")
	public static WebElement LPP_Amount_PerPayment;

	@FindBy (how=How.XPATH, using = "//div[normalize-space()='LPP* premium']/following::div[8]")
	public static WebElement LoanAmount;

	@FindBy (how=How.XPATH, using = "//div[normalize-space()='Loan Payments']/following::div[1]")
	public static WebElement LoanAmount_WOLPP;

	@FindBy (how=How.XPATH, using = "//div[normalize-space()='Desired Loan Term']/following::i[1]")
	public static WebElement Minus_LoanTerm;

	@FindBy (how=How.XPATH, using = "//span[normalize-space()='Upload Photo ID']/preceding-sibling::span")
	public static List<WebElement> List_radio_UploadPhotoID;

	@FindBy (how=How.XPATH, using = "//button[@class='mm-nonav-btn mm-btn--lg mm-btn--primary fill']")
	public static WebElement btn_Next;

	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Proceed with Cash Advance']")
	public static WebElement Proceed_SPL;

	@FindBy (how=How.XPATH, using = "//div[@class=' loan-denied']")
	public static List<WebElement> LoanDecline;



	public void LPP_Info() throws Exception
	{
		waitForLoadingIconDisappearInDialog(TestBase.getDriver());
		for(int i=1;i<30;i++)
		{
			if(List_radio_UploadPhotoID.size()>0)
			{
				PrintValueToReport("Loan is under Manual review porcess instead of Auto approval", "Loan Auto aproval");
				SoftVerifyTextOnly("Loan is review state (Manual review)", "Loan is auto approved", "Loan Auto decision");
				Pg_06_ThankYou_DocumentUpload.Upload_Docs();
				//				obj_UploadDocs.CRM_OpenNewTab_ResolveCase("Normal");
				//Pg_DataBase_Actions.UpdateLoanStatus(24);
				Pg_07_Dashboard.Dash_RefreshTillLoanEsign();
				Pg_07_Dashboard.click_EsignDocs();
				break;
			}
			else
			{

			}
		}

		waitForElementToBeVisible(LPP_Congratulations, "LPP Heading");
		TakeScreenshot("LPP Info 1");
		ScrollToElement(LPP_ViewMyOffer, "LPP_ViewMyOffer");
		TakeScreenshot("LPP Info 2");
		click(LPP_ViewMyOffer,"LPP_View My Offer");

	}

	private void waitForLoadingIconDisappearInDialog(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	private void TakeScreenshot(String string) {
		// TODO Auto-generated method stub
		
	}

	public void IL_FinalOffer() throws Exception
	{
		waitForLoadingIconDisappearInDialog(TestBase.getDriver());
		waitForLoadingIconDisappearInDialog(TestBase.getDriver());
		waitForLoadingIconDisappearInDialog(TestBase.getDriver());

		for(int i=0;i<=240;i++)
		{
			if(LoanDecline.size()>0)
			{
				PrintValueToReport("Loan declined", "Loan decision");
				//Pg_DataBase_Actions.Verify_DB_LoanNoteTABLE();
				FailCase(head_LoanOffer,"The loan got declined");
				break;
			}
			else if(List_head_LoanOffer.size()>0||List_LPP_Congrats.size()>0)
			{
				System.out.println("Break and the size is "+List_LPP_Congrats.size());
				break;
			}
			else
			{
				Thread.sleep(1000);
			}

		}
		waitForElementToBeVisible(List_LPP_Congrats.get(0), "LPP congrats");
		waitForElementToBeVisible(btn_Nextt, "Next112233");
		click(btn_Nextt,"Next");
		click(btn_Nextt,"Next");
		waitForElementToBeVisible(header_LoanApprovdTxt, "1 Loan Offer");
		TakeScreenshot("Final offer page");

		// This line of code is to change payment terms to 12 as per sanjeev need

		//Reduce term loan 

		//		click(Minus_LoanTerm,"Minus");
		//		Thread.sleep(2000);
		//		waitForLoadingIconDisappearInDialog(driver);
		//		click(Minus_LoanTerm,"Minus");
		//		Thread.sleep(2000);
		//	waitForLoadingIconDisappearInDialog(driver);
		//		click(Minus_LoanTerm,"Minus");
		//		Thread.sleep(2000);
		//		waitForLoadingIconDisappearInDialog(driver);


		//-------------------------------------------------------------------------		


		//		YourApprovedTxt = txt_YourApprovedIL.getText();
		//		YourMaxAmount = txt_YourMaxAmount.getText();

//		String Step1ApprvdLoanAmnt = step1_ApprovedAmnt.getText();
//		click(btn_Next,"Next");
		waitForElementToBeVisible(header_LoanApprovdTxt, "Loan offer header text");
		ApprovedLoanAmount = txt_ApprovedLoanAmount.getAttribute("value");
		APRValue = txt_APRValue.getText();

		TermMonths = txt_TermMonths.getAttribute("value");
		if(getMapData.get("Lpp_Option").equalsIgnoreCase("Yes"))
		{
			click(LPP_Yes,"LPP Yes");
			String LPPPremium = LPP_Premium.getText();
			String LPPSales_Text = LPP_text_SalesTax.getText();
			String LPP_Values_SalesTax = LPP_Value_SalesTax.getText();
			//			String LPPAmountPerPayment =  LPP_Amount_PerPayment.getText();
			LoanValue = LoanAmount_WOLPP.getText();
			TotalLoanValue = LoanAmount.getText();

			PrintValueToReport(LPPPremium,"LPPPremium");
			PrintValueToReport(LPPSales_Text,"LPPSales_Text");
			PrintValueToReport(LPP_Values_SalesTax,"LPP_Values_SalesTax");
			//			PrintValueToReport(LPPAmountPerPayment,"LPPAmountPerPayment");
			PrintValueToReport(LoanValue,"LoanValue");

			//			ScrollToElement(head_LoanOffer,"Loan Head");
			TakeScreenshot("Loan offer page top");
			waitForElementToBeVisible(header_LoanApprovdTxt, "Loan offer header text");
			MonthlyPayAmount = txt_MonthlyPayAmount.getText();
		}
		else if(getMapData.get("Lpp_Option").equalsIgnoreCase("No"))
		{
			click(LPP_No,"LPP No");
			waitForElementToBeVisible(txt_AreUSure, "Please select LPP reason");
			click(LPP_NO_Reason,"Coverage through work");
			waitForElementToBeVisible(header_LoanApprovdTxt, "Loan offer header text");
			MonthlyPayAmount = txt_MonthlyPayAmount_LPPNO.getText();

			//click(dd_LPPNo,"Drop down for LPP No");
			//click(dd_LPPN_reason,"LPP no reason");
		}

		PaymentDueOn = txt_PaymentDueOn.getText();
		//Change payment due to normal date format and compare with excel
		PrintValueToReport(MonthlyPayAmount, "Monthly Pay Amount");
		PrintValueToReport(ApprovedLoanAmount, "Approved Loan amount");
		PrintValueToReport(TermMonths, "Loan Termss");
		waitForElementToBeVisible(header_LoanApprovdTxt, "Loan offer header text");

		//Commented below code due to TU query has changed - Date: 04/09/2021

		//long CustomerID = MsSqlUtility.getCustomerId(getMapData.get("Email"));

		/*		if(CustomerID%2==0)
		{
			//Loan ID is Even
			SoftVerifyTextOnly(APRValue,"29.9% APR" , "APR Value");
		}
		else
		{
			//Loan ID is Odd
			SoftVerifyTextOnly(APRValue,"39.9% APR" , "APR Value");
		}
		 */		
		ScrollToElement(btn_FundMyLoan,"Fund my loan button");
		TakeScreenshot("Final offer page 1");
		click(btn_FundMyLoan,"Fund my loan button");		
	}

	private void FailCase(WebElement head_LoanOffer2, String string) {
		// TODO Auto-generated method stub
		
	}

	public void Prod_IL_FinalOffer_ChangeLoanValue() throws Exception
	{
		
		waitForLoadingIconDisappearInDialog(TestBase.getDriver());
		waitForLoadingIconDisappearInDialog(TestBase.getDriver());
		waitForLoadingIconDisappearInDialog(TestBase.getDriver());
		waitForElementToBeVisible(head_LoanOffer, "1 Loan Offer");

		TakeScreenshot("Final offer page");

		ApprovedLoanAmount = txt_ApprovedLoanAmount.getText();
		APRValue = txt_APRValue.getText();

		TermMonths = txt_TermMonths.getText();
		if(getMapData.get("Lpp_Option").equalsIgnoreCase("Yes"))
		{
			click(LPP_No,"LPP No");
			TakeScreenshot("With LPP No status");
			click(LPP_Yes,"LPP Yes");
			String LPPPremium = LPP_Premium.getText();
			String LPPSales_Text = LPP_text_SalesTax.getText();
			String LPP_Values_SalesTax = LPP_Value_SalesTax.getText();
			//			String LPPAmountPerPayment =  LPP_Amount_PerPayment.getText();
			String LoanValue = LoanAmount.getText();

			PrintValueToReport(LPPPremium,"LPPPremium");
			PrintValueToReport(LPPSales_Text,"LPPSales_Text");
			PrintValueToReport(LPP_Values_SalesTax,"LPP_Values_SalesTax");
			//			PrintValueToReport(LPPAmountPerPayment,"LPPAmountPerPayment");
			PrintValueToReport(LoanValue,"LoanValue");

		}
		else if(getMapData.get("Lpp_Option").equalsIgnoreCase("No"))
		{
			click(LPP_No,"LPP Yes");


		}


		EnterText(FinalOffer_Loan, "1100", "Loan amount");
		click(txt_PaymentDueOn,"Payment ");
		Thread.sleep(8000);
		waitForLoadingIconDisappearInDialog(TestBase.getDriver());
		TakeScreenshot("Final offer page after loan amount changed");


		//		YourApprovedTxt = txt_YourApprovedIL.getText();
		//		YourMaxAmount = txt_YourMaxAmount.getText();
		//		ApprovedLoanAmount = txt_ApprovedLoanAmount.getText();
		//		APRValue = txt_APRValue.getText();
		//		MonthlyPayAmount = txt_MonthlyPayAmount.getText();
		//		TermMonths = txt_TermMonths.getText();
		//		PaymentDueOn = txt_PaymentDueOn.getText();
		//Change payment due to normal date format and compare with excel
		PrintValueToReport(ApprovedLoanAmount, "Approved Loan amount");
		PrintValueToReport(TermMonths, "Loan Termss");
		//div[normalize-space()='Desired Loan Amount']/following::input[1]
		ScrollToElement(btn_FundMyLoan,"Fund my loan button");
		TakeScreenshot("Final offer page 1");
		click(btn_FundMyLoan,"Fund my loan button");
		Thread.sleep(2000);
		waitForLoadingIconDisappearInDialog(TestBase.getDriver());

	}

	public void DownSell() throws Exception
	{
		
		waitForLoadingIconDisappearInDialog(TestBase.getDriver());
		waitForLoadingIconDisappearInDialog(TestBase.getDriver());
		waitForElementToBeVisible(Proceed_SPL, "Down cell ");
		TakeScreenshot("Down sell page");
		click(Proceed_SPL,"Proceed to SPL");
	}
	public void SPL_FinalOffer() throws Exception
	{
		
		waitForLoadingIconDisappearInDialog(TestBase.getDriver());
		waitForLoadingIconDisappearInDialog(TestBase.getDriver());
		waitForLoadingIconDisappearInDialog(TestBase.getDriver());
		
		for(int i=0;i<=240;i++)
		{
			if(LoanDecline.size()>0)
			{
				PrintValueToReport("Loan declined", "Loan decision");
				//Pg_DataBase_Actions.Verify_DB_LoanNoteTABLE();
				FailCase(head_LoanOffer,"The loan got declined");
				break;
			}
			else if(List_head_LoanOffer.size()>0)
			{
				break;
			}
			else
			{
				Thread.sleep(1000);
			}

		}
		
		waitForElementToBeVisible(head_LoanOffer, "1 Loan Offer");
		TakeScreenshot("Final offer page");
		ApprovedLoanAmount_SPL = step1_ApprovedAmnt.getText();
		PrintValueToReport(ApprovedLoanAmount_SPL, "Approved Loan amount");
		click(btn_Next,"Next");
		waitForElementToBeVisible(header_LoanApprovdTxt, "Loan offer header text");

		long CustomerID = MsSqlUtility.getCustomerId(getMapData.get("Email"));

		int rws_cnt= List_Table_Rows.size();
		int cols_cnt=  List_Table_Columns.size();
		HashMap<String, String> CA_TableValues = new HashMap<>();
		String Table_Text_C1 = null;
		String Table_Text_C2 = null;

		for(int i=1; i<=rws_cnt;i++)
		{
			for(int j=1;j<=cols_cnt;j++)
			{
				String Xpath_C1 = "//tbody/tr["+ i+ "]/td["+ j+ "]";
				if(j==1)
				{
					Table_Text_C1 = TestBase.getDriver().findElement(By.xpath(Xpath_C1)).getText();
				}
				else if(j==2)
				{
					Table_Text_C2 = TestBase.getDriver().findElement(By.xpath(Xpath_C1)).getText();
				}	
			}
			CA_TableValues.put(Table_Text_C1, Table_Text_C2);
		}
		System.out.println("Cash Advance Final offer page table values are: "+CA_TableValues);

		CAA_Principal_SPL = CA_TableValues.get("Amount of Advance (Loan Principal)");
		CAA_DateOfInitialAdvance = CA_TableValues.get("Date of Inital Advance");
		CAA_LoanTermInDays = CA_TableValues.get("Loan Term in Days");
		CAA_LoanFee = CA_TableValues.get("Loan Fee");
		CAA_TotalCostOfBorrowing = CA_TableValues.get("Total Cost of Borrowing");
		CAA_APR_SPL = CA_TableValues.get("Annual Percentage Rate (APR)");
		CAA_AmountDue = CA_TableValues.get("Total to be Repaid (Amount Due)");
		CAA_PaymentDateAndAmountDue = CA_TableValues.get("Payment Date & Due Amount");
		TakeScreenshot("Final offer page -1");
		PrintValueToReport(CAA_Principal_SPL, "Amount of Advance (Loan Principal)");
		PrintValueToReport(CAA_DateOfInitialAdvance, "Date of Inital Advance");
		PrintValueToReport(CAA_LoanTermInDays, "Loan Term in Days");
		PrintValueToReport(CAA_LoanFee, "Loan Fee");
		PrintValueToReport(CAA_TotalCostOfBorrowing, "Total Cost of Borrowing");
		PrintValueToReport(CAA_APR_SPL, "Annual Percentage Rate (APR)");
		PrintValueToReport(CAA_AmountDue, "Total to be Repaid (Amount Due)");
		PrintValueToReport(CAA_PaymentDateAndAmountDue, "Payment Date & Due Amount");
		ScrollToElement(btn_FundMyLoan,"Fund my loan button");
		TakeScreenshot("Final offer page 1");
		click(btn_FundMyLoan,"Fund my loan button");
	}

	public void EPP_FinalOffer() throws Exception
	{
		waitForLoadingIconDisappearInDialog(TestBase.getDriver());
		waitForLoadingIconDisappearInDialog(TestBase.getDriver());
		for(int i=0;i<=240;i++)
		{
			if(LoanDecline.size()>0)
			{
				PrintValueToReport("Loan declined", "Loan decision");
				//Pg_DataBase_Actions.Verify_DB_LoanNoteTABLE();
				FailCase(head_LoanOffer,"The loan got declined");
				break;
			}
			else if(List_header_LoanApprovdTxt.size()>0)
			{
				break;
			}
			else
			{
				Thread.sleep(1000);
			}

		}
		//		waitForElementToBeVisible(head_LoanOffer, "1 Loan Offer");

		//		ApprovedLoanAmount_SPL = step1_ApprovedAmnt.getText();
		//		PrintValueToReport(ApprovedLoanAmount_SPL, "Approved Loan amount");
		//		click(btn_Next,"Next");
		waitForElementToBeVisible(header_LoanApprovdTxt, "Loan offer header text");

		TakeScreenshot("Final offer page");
		//		YourApprovedTxt_SPL = txt_YourApprovedIL.getText();
		//		YourMaxAmount_SPL = txt_YourMaxAmount.getText();
		ApprovedLoanAmount_SPL = EPP_FinalOffer_Loan.getAttribute("value");
		//Change payment due to normal date format and compare with excel
		PrintValueToReport(ApprovedLoanAmount_SPL, "Approved Loan amount");
		//long CustomerID = MsSqlUtility.getCustomerId(getMapData.get("Email"));

		PaymentDueOn = txt_PaymentDueOn2.getText();
		//Payments due on Table

		ScrollToElement(List_Table_Rows_EPPLoan.get(0), "Final offer page - 1");

		//Details of the Cash Advance Agreement Table
		int rws_cnt1= List_Table_Rows_EPPLoan.size();
		int cols_cnt1=  List_Table_Columns_EPPLoan.size();

		HashMap<String, String> CA_TableValues1 = new HashMap<>();
		String Table_Text_C11 = null;
		String Table_Text_C21 = null;

		for(int i=1; i<=rws_cnt1;i++)
		{
			for(int j=1;j<=cols_cnt1;j++)
			{
				String Xpath_C1 = "//h3[normalize-space()='Details of the Cash Advance Agreement']/following::tbody/tr["+ i+ "]/td["+ j+ "]";
				if(j==1)
				{
					Table_Text_C11 = TestBase.getDriver().findElement(By.xpath(Xpath_C1)).getText();
				}
				else if(j==2)
				{
					Table_Text_C21 = TestBase.getDriver().findElement(By.xpath(Xpath_C1)).getText();
				}	
			}
			CA_TableValues1.put(Table_Text_C11, Table_Text_C21);
		}
		System.out.println("Details of the Cash Advance Agreement in Final offer page table values are: "+CA_TableValues1);
		EPP_AmountDue = EPP_FirstPaymentDue.getText();
		CAA_Principal_SPL = CA_TableValues1.get("Amount of Advance (Loan Principal)");
		CAA_DateOfInitialAdvance = CA_TableValues1.get("Date of Inital Advance");
		CAA_LoanTermInDays = CA_TableValues1.get("Loan Term in Days");
		CAA_LoanFee = CA_TableValues1.get("Loan Fee");
		CAA_TotalCostOfBorrowing = CA_TableValues1.get("Total Cost of Borrowing");
		CAA_APR_SPL = CA_TableValues1.get("Annual Percentage Rate (APR)");
		CAA_AmountDue = CA_TableValues1.get("Total to be Repaid (Amount Due)");

		//		CAA_PaymentDateAndAmountDue = CA_TableValues.get("Payment Date & Due Amount");
		TakeScreenshot("Final offer page -2");
		PrintValueToReport(CAA_Principal_SPL, "Amount of Advance (Loan Principal)");
		PrintValueToReport(CAA_DateOfInitialAdvance, "Date of Inital Advance");
		PrintValueToReport(CAA_LoanTermInDays, "Loan Term in Days");
		PrintValueToReport(CAA_LoanFee, "Loan Fee");
		PrintValueToReport(CAA_TotalCostOfBorrowing, "Total Cost of Borrowing");
		PrintValueToReport(CAA_APR_SPL, "Annual Percentage Rate (APR)");
		PrintValueToReport(CAA_AmountDue, "Total to be Repaid (Amount Due)");
		//		PrintValueToReport(PaymentDueOn, "Payment Due on");
		ScrollToElement(btn_FundMyLoan,"Fund my loan button");
		TakeScreenshot("Final offer page 2");
		click(btn_FundMyLoan,"Fund my loan button");
	}

	public void IL_FinalOffer_Refi() throws Exception
	{
		waitForLoadingIconDisappearInDialog(TestBase.getDriver());
		waitForLoadingIconDisappearInDialog(TestBase.getDriver());
		waitForLoadingIconDisappearInDialog(TestBase.getDriver());
		
		for(int i=0;i<=240;i++)
		{
			if(LoanDecline.size()>0)
			{
				PrintValueToReport("Loan declined", "Loan decision");
				//Pg_DataBase_Actions.Verify_DB_LoanNoteTABLE();
				FailCase(head_LoanOffer,"The loan got declined");
				break;
			}
			else if(List_head_LoanOffer.size()>0)
			{
				break;
			}
			else
			{
				Thread.sleep(1000);
			}

		}
		
		waitForElementToBeVisible(head_LoanOffer, "1 Loan Offer");
		TakeScreenshot("Final offer page");

		//		 YourApprovedTxt = txt_YourApprovedIL.getText();
		//		 YourMaxAmount = txt_YourMaxAmount.getText();

		String Step1ApprvdLoanAmnt = step1_ApprovedAmnt.getText();
		click(btn_Next,"Next");

		waitForElementToBeVisible(header_LoanApprovdTxt, "Loan offer header text");
		ApprovedLoanAmount = txt_ApprovedLoanAmount.getAttribute("value");
		APRValue = txt_APRValue.getText();
		TermMonths = txt_TermMonths.getAttribute("value");


		if(getMapData.get("Refi_Lpp_Option").equalsIgnoreCase("Yes"))
		{
			click(LPP_Yes,"LPP Yes");
			String LPPPremium = LPP_Premium.getText();
			String LPPSales_Text = LPP_text_SalesTax.getText();
			String LPP_Values_SalesTax = LPP_Value_SalesTax.getText();
			//			String LPPAmountPerPayment =  LPP_Amount_PerPayment.getText();
			LoanValue = LoanAmount_WOLPP.getText();
			TotalLoanValue = LoanAmount.getText();
			PrintValueToReport(LPPPremium,"LPPPremium");
			PrintValueToReport(LPPSales_Text,"LPPSales_Text");
			PrintValueToReport(LPP_Values_SalesTax,"LPP_Values_SalesTax");
			//			PrintValueToReport(LPPAmountPerPayment,"LPPAmountPerPayment");
			PrintValueToReport(LoanValue,"LoanValue");

			//			ScrollToElement(head_LoanOffer,"Loan Head");
			TakeScreenshot("Loan offer page top");
			waitForElementToBeVisible(header_LoanApprovdTxt, "Loan offer header text");

		}
		else if(getMapData.get("Lpp_Option").equalsIgnoreCase("No"))
		{
			click(LPP_No,"LPP No");
			waitForElementToBeVisible(txt_AreUSure, "text are you sure");
			click(LPP_NO_confirm,"No thanks, i dont want LPP");
			waitForElementToBeVisible(header_LoanApprovdTxt, "Loan offer header text");
			MonthlyPayAmount = txt_MonthlyPayAmount_LPPNO.getText();
		}
		//Refinance texts
		refinance_NewLoanAmount = refi_NewLoanAmount.getText();
		refinance_PreviousLoanPayyOff = refi_PreviousLoanPayyOff.getText();
		refinance_BalanceFromRefi = refi_BalanceFromRefi.getText();

		System.out.println("refinance_NewLoanAmount "+refinance_NewLoanAmount);
		System.out.println("refinance_PreviousLoanPayyOff "+refinance_PreviousLoanPayyOff);
		System.out.println("refinance_BalanceFromRefi "+refinance_BalanceFromRefi);


		PaymentDueOn = txt_PaymentDueOn.getText();
		//Change payment due to normal date format and compare with excel
		PrintValueToReport(MonthlyPayAmount, "Monthly Pay Amount");
		PrintValueToReport(ApprovedLoanAmount, "Approved Loan amount");
		PrintValueToReport(TermMonths, "Loan Termss");

		ScrollToElement(btn_FundMyLoan,"Fund my loan button");
		TakeScreenshot("Final offer page 1");
		click(btn_FundMyLoan,"Fund my loan button");

	}
}
