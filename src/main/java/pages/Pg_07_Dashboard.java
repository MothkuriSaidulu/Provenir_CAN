package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;
import driver.TestBase;
import sqlUtils.MsSqlUtility;


public class Pg_07_Dashboard extends OnlineActions {

	public Pg_07_Dashboard(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	private static String Loan_Status;
	private static String Loan_Btn1;
	//private String Loan_Btn2;
	public static String LoanContractID;
	public static String DueAmount;
	public static String PrincipleAmountt;
	public static String PaymentDue;
	public static String ParentLoanID;
	public static long First_LoanID;
	public static long Second_LoanID;
	public static long Third_LoanID;
	public static long Fourth_LoanID;
	public static long Fifth_LoanID;

	//	private String Loan_Status_SPL;
	//	public static String LoanContractID_SPL;
	//	public static String DueAmount_SPL;
	//	public static String PrincipleAmountt_SPL;
	//	public static String PaymentDue_SPL;

	@FindBy(how=How.XPATH, using = "//span[@class='mm-loan-status__status-name']")
	public static WebElement Dash_Loan_Status_LoanCount_01;

	@FindBy(how=How.XPATH, using = "//span[@class='mm-loan-status__status-name']")
	public static List<WebElement> list_Dash_Loan_Status_LoanCount_01;

	@FindBy(how=How.XPATH, using = "//div[@class='mm-card__action col custom_card_btn'][1]")
	public static WebElement Old_V1_Dash_Button1_LoanCount_01;

	@FindBy(how=How.XPATH, using = "//div[@class='mm-card__cardremove col col-6 col-l-6 col-m-6 custom_card_btn'][1]")
	public static WebElement Dash_Button1_LoanCount_01;

	@FindBy(how=How.XPATH, using = "//div[@class='mm-card__cardremove col custom_card_btn'][1]")
	public static WebElement Custom_Dash_Button1_LoanCount_01;

	@FindBy(how=How.XPATH, using = "//div[@class='mm-card__cardremove col custom_card_btn'][1]")
	public static List<WebElement> Custom_List_Dash_Button1_LoanCount_01;

	@FindBy(how=How.XPATH, using = "//div[@class='mm-card__cardremove col custom_card_btn'][2]")
	public static List<WebElement> Custom_List_Dash_Button2_LoanCount_01;

	@FindBy(how=How.XPATH, using = "//div[@class='mm-card__cardremove col custom_card_btn'][3]")
	public static List<WebElement> Custom_List_Dash_Button3_LoanCount_01;

	@FindBy(how=How.XPATH, using = "//div[@class='mm-card__action col custom_card_btn'][2]")
	public static WebElement Old_V1_Dash_Button2_LoanCount_01;

	@FindBy(how=How.XPATH, using = "//div[@class='mm-card__cardremove col col-6 col-l-6 col-m-6 custom_card_btn'][2]")
	public static WebElement Dash_Button2_LoanCount_01;

	@FindBy(how=How.XPATH, using = "//div[@class='mm-card__cardremove col custom_card_btn'][2]")
	public static WebElement Custom_Dash_Button2_LoanCount_01;

	@FindBy(how=How.XPATH, using = "//div[@class='mm-card__cardremove col custom_card_btn']")
	public static WebElement Custom_UploadDoc_Dash_Button2_LoanCount_01;

	@FindBy(how=How.XPATH, using = "//div[@class='mm-card__action col custom_card_btn'][3]")
	public static WebElement Old_V1_Dash_Button3_LoanCount_01;

	@FindBy(how=How.XPATH, using = "//div[@class='mm-card__cardremove col col-6 col-l-6 col-m-6 custom_card_btn'][3]")
	public static WebElement Dash_Button3_LoanCount_01;

	@FindBy(how=How.XPATH, using = "//div[@class='mm-card__cardremove col custom_card_btn'][3]")
	public static WebElement Custom_Dash_Button3_LoanCount_01;

	@FindBy(how=How.XPATH, using = "//div[@class='mm-card__cardremove col col-6 col-l-6 col-m-6 custom_card_btn'][1]")
	public static List<WebElement> QList_Dash_Button1_LoanCount_01;

	@FindBy(how=How.XPATH, using = "//div[@class='mm-card__action col custom_card_btn'][1]")
	public static List<WebElement> Old_V1_List_Dash_Button1_LoanCount_01;

	@FindBy(how=How.XPATH, using = "//div[@class='mm-card__action col custom_card_btn'][2]")
	public static List<WebElement> Old_V1_List_Dash_Button2_LoanCount_01;

	@FindBy(how=How.XPATH, using = "//div[@class='mm-card__cardremove col col-6 col-l-6 col-m-6 custom_card_btn'][2]")
	public static List<WebElement> List_Dash_Button2_LoanCount_01;

	@FindBy(how=How.XPATH, using = "//div[@class='mm-card__action col custom_card_btn'][3]")
	public static List<WebElement> Old_V1_List_Dash_Button3_LoanCount_01;

	@FindBy(how=How.XPATH, using = "//div[@class='mm-card__cardremove col col-6 col-l-6 col-m-6 custom_card_btn'][3]")
	public static List<WebElement> List_Dash_Button3_LoanCount_01;

	@FindBy(how=How.XPATH, using = "//div[@title='Finalize and e-Sign Loan Documents']")
	public static WebElement btn_ESignLoanDocs;

	@FindBy(how=How.XPATH, using = "//div[@title='Withdraw Loan Application']")
	public static WebElement btn_WithDrawApp;

	@FindBy(how=How.XPATH, using = "//strong[contains(normalize-space(),'Installment Loan | #')]")
	public static WebElement Loan_ContractID;

	@FindBy(how=How.XPATH, using = "//strong[contains(normalize-space(),'Cash Advance | #')]")
	public static WebElement Loan_ContractID_SPL;

	@FindBy(how=How.XPATH, using = "//div[normalize-space()='Amount Due']/following::strong")
	public static WebElement Amount_Due;

	@FindBy(how=How.XPATH, using = "//div[normalize-space()='Balance']/following-sibling::h2")
	public static WebElement BalanceAmount;

	@FindBy(how=How.XPATH, using = "//div[@class='mm-loan-status__date-text']")
	public static WebElement PaymentDueOn;
	
	@FindBy(how=How.XPATH, using = "//button[normalize-space()='Make a Payment']")
	public static WebElement MakePayment;
	
	@FindBy(how=How.XPATH, using = "//a[normalize-space()='Back to Dashboard']")
	public static WebElement BackToDashboard;
	
	@FindBy(how=How.XPATH, using = "//span[contains(normalize-space(), 'Pay the Loan in full')]/preceding::span[1]")
	public static WebElement radio_PayinFull;
	
	@FindBy(how=How.XPATH, using = "//button[normalize-space()='Continue']")
	public static WebElement btn_continue;
	
	@FindBy(how=How.XPATH, using = "//span[normalize-space()='Pre-Authorized Debit']/preceding::span[1]")
	public static WebElement radio_Pre_AuthDebit;
	
	@FindBy(how=How.XPATH, using = "//p[normalize-space()='Please review the Agreement before proceeding.']")
	public static WebElement txt_Agreement;
	
	@FindBy(how=How.XPATH, using = "//a[normalize-space()='Download']")
	public static WebElement Download;
	
	@FindBy(how=How.XPATH, using = "//button[normalize-space()='Agree & Continue']")
	public static WebElement AgreeContinue;
	
	@FindBy(how=How.XPATH, using = "//p[normalize-space()='Success! Your payment being processed.']")
	public static WebElement PaymentAcknowledge;
	
	//@FindBy(how=How.XPATH, using = "//strong[normalize-space()='Application in Progress']") //Commented on 30-Nov-2022
	@FindBy(how=How.XPATH, using = "//strong[normalize-space()='Action Required']") //Added on 30-Nov-2022
	public static WebElement loanstatus;
	
	
	@FindBy(how=How.XPATH, using = "//div[@title='Withdraw Loan Application']")
	public static WebElement withdraw_dashboard_link;
	
	//@FindBy(how=How.XPATH, using = "//div[@title='Finalize and e-Sign Loan Documents']") //Commented on 30-Nov-2022
	@FindBy(how=How.XPATH, using = "//button[text()='Finalize and e-Sign Loan Documents']") //Added on 30-Nov-2022
	public static WebElement esign_dashboard_link;
	
	


	
	public void Dashboard_LoanStatus_BeforeCRMApproval() throws Exception
	{
		waitForElementToBeVisible(Dash_Loan_Status_LoanCount_01, "Loan status");
		PrintValueToReport(Dash_Loan_Status_LoanCount_01.getText(), "Loan Status before CRM approval");	
	}
	public void TwoLoans_2nd_Dashboard_LoanStatus_BeforeCRMApproval() throws Exception
	{
		waitForElementToBeVisible(Dash_Loan_Status_LoanCount_01, "Loan status");
		waitForElementToBeClickable(Dash_Loan_Status_LoanCount_01, "Loan status");
		PrintValueToReport(list_Dash_Loan_Status_LoanCount_01.get(1).getText(), "Loan Status before CRM approval");	
	}

	public void Dashboard_LoanStatus_AfterLoan() throws Exception
	{
		waitForElementToBeVisible(Dash_Loan_Status_LoanCount_01, "Loan status");
		TakeScreenshot("Dashboard after loan");
		//Validate the buttons
		SoftVerifyTextOnly(Custom_Dash_Button1_LoanCount_01.getText(), "Email Loan Documents", "Email loan docs Button");
		SoftVerifyTextOnly(Custom_Dash_Button2_LoanCount_01.getText(), "Cancel Loan Application", "Email loan docs Button");
		SoftVerifyTextOnly(Custom_Dash_Button3_LoanCount_01.getText(), "View Payment Schedule", "Email loan docs Button");

		String LoanCont = Loan_ContractID.getText();
		System.out.println("LoanCont: "+LoanCont);
		String[] LoanCont1 = LoanCont.split("#");
		LoanContractID = LoanCont1[1];
		ParentLoanID = MsSqlUtility.getLoanId(getMapData.get("Email"))+"";
		PrintValueToReport(MsSqlUtility.getCustomerId(getMapData.get("Email"))+"", "Customer ID");
		PrintValueToReport(ParentLoanID, "Loan Id");
		PrintValueToReport(LoanContractID, "Loan contract Id");	
		PrintValueToReport(Dash_Loan_Status_LoanCount_01.getText(), "Loan Status after loan origination complete");	
		String DueAmount1 = Amount_Due.getText();
		DueAmount = DueAmount1.substring(1);
		PrintValueToReport(DueAmount1, "Due Amount is ");
		if(getMapData.get("Lpp_Option").equalsIgnoreCase("Yes"))
		{
			SoftVerifyTextOnly(DueAmount1, Pg_08_FinalOffer.LoanValue, "Amount due compared from Final offer page and Dashboard after Loan");
		}
		else if(getMapData.get("Lpp_Option").equalsIgnoreCase("No"))
		{
			SoftVerifyTextOnly(DueAmount1, Pg_08_FinalOffer.MonthlyPayAmount, "Amount due compared from Final offer page and Dashboard after Loan");
		}
		String BalAmount = BalanceAmount.getText();
		System.out.println("String BalAmount value is "+BalAmount);
		PrincipleAmountt = BalAmount.replace("$", "").trim();
		System.out.println("String PrincipleAmountt after Substring value is "+PrincipleAmountt);
		PrincipleAmountt = PrincipleAmountt.replace(",", "");
		System.out.println("String PrincipleAmountt after replace coma value is "+PrincipleAmountt);
		System.out.println("Principle amount after removal $ and coma is "+PrincipleAmountt);
		PrintValueToReport(BalAmount, "Balance Amount is");
		SoftVerifyTextOnly(BalAmount, Pg_08_FinalOffer.ApprovedLoanAmount+".00", "Balance amount compared from Final offer page and Dashboard after Loan");
		String payd = PaymentDueOn.getText();
		String[] payd1 = payd.split(": ");
		PaymentDue = payd1[1];

		DateFormat originalFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);
		DateFormat targetFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = originalFormat.parse(Pg_08_FinalOffer.PaymentDueOn);
		String formattedDate = targetFormat.format(date);
		Pg_08_FinalOffer.PaymentDueOn = formattedDate;

		PrintValueToReport(PaymentDue, "Payment due date is: ");
		SoftVerifyTextOnly(PaymentDue, formattedDate, "Payment due date compared from Final offer page and Dashboard after Loan");

	}

	private static void TakeScreenshot(String string) {
		// TODO Auto-generated method stub
		
	}
	public void Dashboard_LoanStatus_AfterRefiLoan(String LoanStatus) throws Exception
	{
		waitForElementToBeVisible(Dash_Loan_Status_LoanCount_01, "Loan status");
		//Validate the buttons
		SoftVerifyTextOnly(Custom_Dash_Button1_LoanCount_01.getText(), "Email Loan Documents", "Email loan docs Button");
		SoftVerifyTextOnly(Custom_Dash_Button2_LoanCount_01.getText(), "Cancel Loan Application", "Email loan docs Button");
		SoftVerifyTextOnly(Custom_Dash_Button3_LoanCount_01.getText(), "View Payment Schedule", "Email loan docs Button");


		String LoanCont = Loan_ContractID.getText();
		System.out.println("LoanCont: "+LoanCont);
		String[] LoanCont1 = LoanCont.split("#");
		LoanContractID = LoanCont1[1];
		PrintValueToReport(MsSqlUtility.getCustomerId(getMapData.get("Email"))+"", "Customer ID");
		PrintValueToReport(MsSqlUtility.getLoanId(getMapData.get("Email"))+"", "Loan Id");	
		PrintValueToReport(LoanContractID, "Loan contract Id");	
		PrintValueToReport(Dash_Loan_Status_LoanCount_01.getText(), "Loan Status after loan origination complete");	
		String DueAmount1 = Amount_Due.getText();
		DueAmount = DueAmount1.substring(1);
		PrintValueToReport(DueAmount1, "Due Amount is ");
		if(LoanStatus.equalsIgnoreCase("Refi_ChangeRentPayfreq"))
		{
			//Loan payment per month amount is different from next pay amnt in dashboard
		}
		else
		{
			if(getMapData.get("Refi_Lpp_Option").equalsIgnoreCase("Yes"))
			{
				SoftVerifyTextOnly(DueAmount1, Pg_08_FinalOffer.LoanValue, "Monthly Pay amount compared from Final offer page and Dashboard after Loan");
			}
			else if(getMapData.get("Refi_Lpp_Option").equalsIgnoreCase("No"))
			{
				SoftVerifyTextOnly(DueAmount1, Pg_08_FinalOffer.MonthlyPayAmount, "Monthly Pay amount compared from Final offer page and Dashboard after Loan");
			}
			//			SoftVerifyTextOnly(DueAmount1, Pg_08_FinalOffer.LoanValue, "Monthly Pay amount compared from Final offer page and Dashboard after Loan");
		}

		String BalAmount = BalanceAmount.getText();
		System.out.println("String BalAmount value is "+BalAmount);
		PrincipleAmountt = BalAmount.replace("$", "").trim();
		System.out.println("String PrincipleAmountt after Substring value is "+PrincipleAmountt);
		PrincipleAmountt = PrincipleAmountt.replace(",", "");
		System.out.println("String PrincipleAmountt after replace coma value is "+PrincipleAmountt);
		System.out.println("Principle amount after removal $ and coma is "+PrincipleAmountt);
		PrintValueToReport(BalAmount, "Balance Amount is");
		SoftVerifyTextOnly(BalAmount, Pg_08_FinalOffer.ApprovedLoanAmount+".00", "Balance amount compared from Final offer page and Dashboard after Loan");
		String payd = PaymentDueOn.getText();
		String[] payd1 = payd.split(": ");
		PaymentDue = payd1[1];

		DateFormat originalFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);
		DateFormat targetFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = originalFormat.parse(Pg_08_FinalOffer.PaymentDueOn);
		String formattedDate = targetFormat.format(date);
		Pg_08_FinalOffer.PaymentDueOn = formattedDate;

		PrintValueToReport(PaymentDue, "Payment due date is: ");
		SoftVerifyTextOnly(PaymentDue, formattedDate, "Payment due date compared from Final offer page and Dashboard after Loan");

	}
	
	public void Loanid_LoanCount(int LoanCount) throws Exception
	{
		
		if(LoanCount==1)
		{
			First_LoanID = MsSqlUtility.getLoanId(getMapData.get("Email"));
		}
		else if(LoanCount==2)
		{
			Second_LoanID = MsSqlUtility.getLoanId(getMapData.get("Email"));
		}
		else if(LoanCount==3)
		{
			Third_LoanID = MsSqlUtility.getLoanId(getMapData.get("Email"));
		}
		else if(LoanCount==4)
		{
			Fourth_LoanID = MsSqlUtility.getLoanId(getMapData.get("Email"));
		}
		else if(LoanCount==5)
		{
			Fifth_LoanID = MsSqlUtility.getLoanId(getMapData.get("Email"));
		}

	}

	public void BackDat_31_effectiveDateDiffAndPreviousLoan(int LoanCount) throws Exception
	{
		if(LoanCount==1)
		{
			Pg_PaymentSchedules_Refinance.BackDate_31_effectiveDateDiffAndPreviousLoan(First_LoanID);
		}
		else if(LoanCount==2)
		{
			Pg_PaymentSchedules_Refinance.BackDate_31_effectiveDateDiffAndPreviousLoan(Second_LoanID);
		}
		else if(LoanCount==3)
		{
			Pg_PaymentSchedules_Refinance.BackDate_31_effectiveDateDiffAndPreviousLoan(Third_LoanID);
		}
		else if(LoanCount==4)
		{
			Pg_PaymentSchedules_Refinance.BackDate_31_effectiveDateDiffAndPreviousLoan(Fourth_LoanID);
		}
		else if(LoanCount==5)
		{
			Pg_PaymentSchedules_Refinance.BackDate_31_effectiveDateDiffAndPreviousLoan(Fifth_LoanID);
		}
	}
	public void Dashboard_LoanStatus_AfterLoan_SPL() throws Exception
	{
		waitForElementToBeVisible(Dash_Loan_Status_LoanCount_01, "Loan status");
		//Validate the buttons 
		SoftVerifyTextOnly(Custom_Dash_Button1_LoanCount_01.getText(), "Email Loan Documents", "Email loan docs Button");
		SoftVerifyTextOnly(Custom_Dash_Button2_LoanCount_01.getText(), "Cancel Loan Application", "Email loan docs Button");
		//		SoftVerifyTextOnly(Custom_Dash_Button3_LoanCount_01.getText(), "View Payment Schedule", "Email loan docs Button");
		String LoanCont = Loan_ContractID_SPL.getText();
		String[] LoanCont1 = LoanCont.split("#");
		LoanContractID = LoanCont1[1];
		PrintValueToReport(MsSqlUtility.getCustomerId(getMapData.get("Email"))+"", "Customer ID");
		PrintValueToReport(MsSqlUtility.getLoanId(getMapData.get("Email"))+"", "Loan Id");	
		PrintValueToReport(LoanContractID, "Loan contract Id");	
		PrintValueToReport(Dash_Loan_Status_LoanCount_01.getText(), "Loan Status after loan origination complete");	
		String DueAmount1 = Amount_Due.getText();
		DueAmount = DueAmount1.substring(1);
		PrintValueToReport(DueAmount1, "Due Amount is ");
		SoftVerifyTextOnly(DueAmount1, Pg_08_FinalOffer.CAA_AmountDue, "Monthly Pay amount compared from Final offer page and Dashboard after Loan");
		String BalAmount = BalanceAmount.getText();
		System.out.println("String BalAmount value is "+BalAmount);
		PrincipleAmountt = BalAmount.replace("$", "").trim();
		System.out.println("String PrincipleAmountt after Substring value is "+PrincipleAmountt);
		PrincipleAmountt = PrincipleAmountt.replace(",", "");
		System.out.println("String PrincipleAmountt after replace coma value is "+PrincipleAmountt);
		System.out.println("Principle amount after removal $ and coma is "+PrincipleAmountt);
		PrintValueToReport(BalAmount, "Balance Amount is");
		SoftVerifyTextOnly(BalAmount, Pg_08_FinalOffer.CAA_AmountDue, "Balance amount compared from Final offer page and Dashboard after Loan");
		String payd = PaymentDueOn.getText();
		String[] payd1 = payd.split(": ");
		PaymentDue = payd1[1];

		DateFormat originalFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);
		DateFormat targetFormat = new SimpleDateFormat("MM/dd/yyyy");
		String[] dateee = Pg_08_FinalOffer.CAA_PaymentDateAndAmountDue.split(":");
		String datee = dateee[0];
		//April 1, 2021: $230.00
		Date date = originalFormat.parse(datee);
		String formattedDate = targetFormat.format(date);

		//PrintValueToReport(PaymentDue_SPL, "Payment due date is: ");
		SoftVerifyTextOnly(PaymentDue, formattedDate, "Payment due date compared from Final offer page and Dashboard after Loan");

	}

	public void Dashboard_LoanStatus_AfterLoan_EPP() throws Exception
	{
		waitForElementToBeVisible(Dash_Loan_Status_LoanCount_01, "Loan status");
		//Validate the buttons 
		SoftVerifyTextOnly(Custom_Dash_Button1_LoanCount_01.getText(), "Email Loan Documents", "Email loan docs Button");
		SoftVerifyTextOnly(Custom_Dash_Button2_LoanCount_01.getText(), "Cancel Loan Application", "Email loan docs Button");
//		SoftVerifyTextOnly(Custom_Dash_Button3_LoanCount_01.getText(), "View Payment Schedule", "Email loan docs Button");
		String LoanCont = Loan_ContractID_SPL.getText();
		String[] LoanCont1 = LoanCont.split("#");
		LoanContractID = LoanCont1[1];
		PrintValueToReport(MsSqlUtility.getCustomerId(getMapData.get("Email"))+"", "Customer ID");
		PrintValueToReport(MsSqlUtility.getLoanId(getMapData.get("Email"))+"", "Loan Id");	
		PrintValueToReport(LoanContractID, "Loan contract Id");	
		PrintValueToReport(Dash_Loan_Status_LoanCount_01.getText(), "Loan Status after loan origination complete");	
		String DueAmount1 = Amount_Due.getText();
		DueAmount = DueAmount1.substring(1);
		PrintValueToReport(DueAmount1, "Due Amount is ");
//		SoftVerifyTextOnly(DueAmount1, Pg_08_FinalOffer.EPP_AmountDue, "Monthly Pay amount compared from Final offer page and Dashboard after Loan");
		String BalAmount = BalanceAmount.getText();
		System.out.println("String BalAmount value is "+BalAmount);
		PrincipleAmountt = BalAmount.replace("$", "").trim();
		System.out.println("String PrincipleAmountt after Substring value is "+PrincipleAmountt);
		PrincipleAmountt = PrincipleAmountt.replace(",", "");
		System.out.println("String PrincipleAmountt after replace coma value is "+PrincipleAmountt);
		System.out.println("Principle amount after removal $ and coma is "+PrincipleAmountt);
		PrintValueToReport(BalAmount, "Balance Amount is");
		SoftVerifyTextOnly(BalAmount, Pg_08_FinalOffer.CAA_AmountDue, "Balance amount compared from Final offer page and Dashboard after Loan");

		String payd = PaymentDueOn.getText();
		String[] payd1 = payd.split(": ");
		PaymentDue = payd1[1];

		DateFormat originalFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);
		DateFormat targetFormat = new SimpleDateFormat("MM/dd/yyyy");
//		String datee = Pg_08_FinalOffer.PaymentDueOn;
		//April 1, 2021: $230.00
//		Date date = originalFormat.parse(datee);
//		String formattedDate = targetFormat.format(date);

		//PrintValueToReport(PaymentDue_SPL, "Payment due date is: ");
		PrintValueToReport(PaymentDue, "Payment ");
//		SoftVerifyTextOnly(PaymentDue, formattedDate, "Payment due date compared from Final offer page and Dashboard after Loan");

	}


	public static void Dash_RefreshTillLoanEsign() throws Exception
	{
		Thread.sleep(3000);		
		waitForElementToBeVisible(Dash_Loan_Status_LoanCount_01, "Loan status");
		TakeScreenshot("Dashboard");
		for(int i=1;i<=10;i++)
		{
			//click(Dash_Button2_LoanCount_01,"");
			TestBase.getDriver().navigate().refresh();
			Thread.sleep(1000);
			waitForElementToBeVisible(Dash_Loan_Status_LoanCount_01, "Loan status");
			waitForElementToBeVisible(Dash_Button1_LoanCount_01, "Button 1");
			//	waitForElementToBeVisible(Dash_Button2_LoanCount_01, "Button 2");
			Loan_Status = Dash_Loan_Status_LoanCount_01.getText();
			Loan_Btn1 = Dash_Button1_LoanCount_01.getText();

			//Loan_Btn2 = Dash_Button2_LoanCount_01.getText();
			if(Loan_Status.equalsIgnoreCase("Application In Progress")&&Loan_Btn1.equalsIgnoreCase("Withdraw Loan Application"))
			{
				PrintValueToReport("Loan application is updated after CRM approval", "Loan application status");
				PrintValueToReport(Dash_Loan_Status_LoanCount_01.getText(), "Loan Status After CRM approval(Online application refreshed for update loan status) ");	
				break;
			}
			else
			{
				Thread.sleep(20000);
			}
		}

	}

	public void Dash_RefreshTillLoanEsign_2ndLoan() throws Exception
	{
		Thread.sleep(3000);		
		waitForElementToBeVisible(Dash_Loan_Status_LoanCount_01, "Loan status");
		for(int i=1;i<=10;i++)
		{
			TestBase.getDriver().navigate().refresh();
			Thread.sleep(1000);
			waitForElementToBeVisible(Dash_Loan_Status_LoanCount_01, "Loan status");
			Loan_Status = list_Dash_Loan_Status_LoanCount_01.get(1).getText();
			Loan_Btn1 = QList_Dash_Button1_LoanCount_01.get(0).getText();
			//Loan_Btn2 = Custom_List_Dash_Button2_LoanCount_01.get(1).getText();
			if(Loan_Status.equalsIgnoreCase("Application In Progress")&&Loan_Btn1.equalsIgnoreCase("Withdraw Loan Application"))
			{
				PrintValueToReport("Loan application is updated after CRM approval", "Loan application status");
				PrintValueToReport(Loan_Status, "Loan Status After CRM approval(Online application refreshed for update loan status) ");	
				break;
			}
			else
			{
				Thread.sleep(20000);
			}
		}

	}

	public void Change_LoanContract_iD(int LoanNo) throws Exception
	{
		String[] loancont = LoanContractID.split("-");
		String p1 = loancont[0];
		String p2 = loancont[1];
		String p3 = loancont[2];
		String p4 = loancont[3];
		String loanContID;
		int p3_1 = Integer.parseInt(p3)-100;
		int p4_1 = Integer.parseInt(p4)+5+LoanNo;
		
		int length1 = String.valueOf(p3_1).length();
		int length2 = String.valueOf(p4_1).length();
		if(length1==6)
		{
			if(length2==2)
			{
				loanContID = p1+"-"+p2+"-"+p3_1+"-"+p4_1;
			}
			else
			{
				String p41_1 = "0"+p4_1;
				loanContID = p1+"-"+p2+"-"+p3_1+"-"+p41_1;
			}
			
		}
		else
		{
			if(length2==2)
			{
				String p31_1 = "0"+p3_1;
				loanContID = p1+"-"+p2+"-"+p31_1+"-"+p4_1;
			}
			else
			{
				String p31_1 = "0"+p3_1;
				String p41_1 = "0"+p4_1;
				loanContID = p1+"-"+p2+"-"+p31_1+"-"+p41_1;
			}
			
		}
		
		//Update loan-ContractID
		MsSqlUtility.UpdateLoanContractID(getMapData.get("Email"),loanContID);
		PrintValueToReport("Loan contract id is changed from "+LoanContractID+" to "+loanContID+" for LoanID "+MsSqlUtility.getLoanId(getMapData.get("Email")), "Loan contract id is changed");

	}
	
	//Added on 16-Nov-2022 Start
	@FindBy (how=How.XPATH, using = "//div[@class='mm-page-loader__wrapper']")
	public static List<WebElement> searchWheel_SearchLook;
	//Added on 16-Nov-2022 End
	
	public static void click_esign() throws Exception
	{
		Thread.sleep(6000);
		TestBase.getDriver().navigate().refresh();
		Thread.sleep(3000);		
		waitForElementToBeVisible(loanstatus, "Loan status");
		waitForElementToBeVisible(withdraw_dashboard_link, "WIthdraw");
		
		waitForElementToBeVisible(esign_dashboard_link, "WIthdraw");
		TestBase.bindreport(currentGlobalScenarioName, "dashboard before status changed page");
		Loan_Status = loanstatus.getText();
		Loan_Btn1 = withdraw_dashboard_link.getText();
		//Loan_Btn2 = Custom_List_Dash_Button2_LoanCount_01.get(1).getText();
		//if(Loan_Status.equalsIgnoreCase("Application In Progress")&&Loan_Btn1.equalsIgnoreCase("Withdraw Loan Application")) //Commented on 30-Nov-2022
		if(Loan_Status.equalsIgnoreCase("Action Required")&&Loan_Btn1.equalsIgnoreCase("Withdraw Loan Application")) //Added on 30-Nov-2022
		{
			PrintValueToReport("Loan application is updated after CRM approval", "Loan application status");
			PrintValueToReport(Loan_Status, "Loan Status After CRM approval(Online application refreshed for update loan status) ");	
			TestBase.bindreport(currentGlobalScenarioName, "dashboard after status changed page");
			
			//Added on 16-Nov-2022 Start
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
			//Added on 16-Nov-2022 End
			
			
			click(esign_dashboard_link,"E-Sign loan docs");
			Thread.sleep(3000);
		}
		else
		{
			Thread.sleep(5000);
			
			System.out.println("esign button is not there");
		}
		
		
		//waitForLoadingIconDisappearInDialog(driver);
	}
	
	public static void esign_btm() throws Exception
	{
		Thread.sleep(50000);
		TestBase.getDriver().navigate().refresh();
		Thread.sleep(30000);		
		waitForElementToBeVisible(loanstatus, "Loan status");
		waitForElementToBeVisible(withdraw_dashboard_link, "WIthdraw");
		
		waitForElementToBeVisible(esign_dashboard_link, "esignbutton");
		
		
		
		
		//waitForLoadingIconDisappearInDialog(driver);
	}
	
	
	public static void click_EsignDocs() throws Exception
	{
		TakeScreenshot("Before click E-Sign docs");
		click(btn_ESignLoanDocs,"E-Sign loan docs");
		Thread.sleep(3000);
		//waitForLoadingIconDisappearInDialog(driver);
	}
	
	public static void MakePayment_Complete() throws Exception
	{
		try {
			TestBase.getDriver().navigate().refresh();
			waitForElementToBeClickable(MakePayment, "Make payment");
			click(MakePayment, "Make payment");
			waitForElementToBeVisible(BackToDashboard,"Back to dashboard link");
			click(radio_PayinFull,"Pay full amount");
			click(btn_continue,"Continue");
			click(radio_Pre_AuthDebit,"Pre-Authorized Debit");
			click(btn_continue,"Continue");
			waitForElementToBeVisible(txt_Agreement, "Agreement text");
			ScrollToElement(Download, "Download");
			click(AgreeContinue,"Agree and Continue");
			waitForElementToBeVisible(PaymentAcknowledge, "Payment acknowledgement");
			click(BackToDashboard,"Back to dashboard link");
			//waitForLoadingIconDisappearInDialog(driver);
			
			
		} catch(Exception e) {
			e.printStackTrace();
			//logEvent("MakePayment_Complete method is failed "+" due to the Exception:-"+e.getMessage(), "fail");
		}
	}

}
