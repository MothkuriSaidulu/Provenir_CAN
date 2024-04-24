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


public class Pg_04_Employerinfo extends OnlineActions {

	public Pg_04_Employerinfo(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public static String Flinks_PrimaryIncome;
	public static String Flinks_Emp_Name;
//	public static String Flinks_DirectDeposit;
	public static String Flinks_PayFreq;
	public static String Flinks_LastPayDate;
	public static String Flinks_NextPayDate;
	public static String Flinks_LastPayAmount;
	public static String Flinks_LastMonthPayAmnt;
	
	//Get data from income details when flinks is Optin
	@FindBy (how=How.XPATH, using = "//div[contains(text(),'Employer*')]/following::input[1]")
	public static WebElement txt_EmpName;

		@FindBy (how=How.XPATH, using = "//div[normalize-space()='Your Employment Status*']/following::button[1]")
		
		//div[normalize-space()='Your Employment Status*']/following::button[1]
		public static WebElement getText_PrimaryIncome;

		@FindBy (how=How.XPATH, using = "//div[normalize-space()='How often are you paid? *']/following::button[1]")
		public static WebElement getText_PayFreq;

		//@FindBy (how=How.XPATH, using = "//button[normalize-space()='Next']") //Commented on 09-Nov-2022
		@FindBy (how=How.XPATH, using = "//button[normalize-space()='Continue']") //Added on 09-Nov-2022
		public static WebElement btn_Next;
	
	@FindBy (how=How.XPATH, using = "(//button[@type='button'])[1]")
	public static WebElement employee_type;
	
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Full Time Employed']")
	public static WebElement full_typeemploye;
	
	//Added on 15-Nov-2022 Start
	@FindBy (how=How.XPATH, using = "(//button[normalize-space()='Full Time Employed'])[2]")
	public static WebElement full_typeemploye2;
	
	@FindBy (how=How.XPATH, using = "(//button[normalize-space()='Full Time Employed'])[3]")
	public static WebElement full_typeemploye3;
	//Added on 15-Nov-2022 End
	
	@FindBy (how=How.XPATH, using = "//button[text()='Old Age Security (OAS)']")
	public static WebElement btn_OldAgeSecurity;
	
	
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Full Time Employed']")
	public static WebElement dd_income_FullTime;

	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Part Time Employed']")
	public static WebElement dd_income_PartTime;

	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Pension']")
	public static WebElement dd_income_Pension;

	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Canada Pension Plan (CPP)']")
	public static WebElement dd_income_CPP;

	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Old Age Security (OAS)']")
	public static WebElement dd_income_OAS;

	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Other']")
	public static WebElement dd_income_Other;
	
	@FindBy (how=How.XPATH, using = "//input[@class='mm-input mm-gs-input']")
	public static WebElement employee_name;
	
	@FindBy (how=How.XPATH, using = "//input[@placeholder='XXX-XXX-XXXX']")
	public static WebElement employee_phone;
	
	@FindBy (how=How.XPATH, using = "//div[@class='mm-form-field mm-form-field--has-value']//button[@type='button']")
	public static WebElement how_to_paid;
	
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Same day every month']")
	public static WebElement pay_frequency;
	
	//Added on 15-Nov-2022 Start
	@FindBy (how=How.XPATH, using = "(//button[normalize-space()='Same day every month'])[2]")
	public static WebElement pay_frequency2;
	
	@FindBy (how=How.XPATH, using = "(//button[normalize-space()='Same day every month'])[3]")
	public static WebElement pay_frequency3;
	//Added on 15-Nov-2022 Start
	
	//Added 17-Sept-2022 Start
	@FindBy (how=How.XPATH, using = "//button[text()='Twice a Month - otherwise']")
	public static WebElement txt_pay_frequency_Twice_a_Month_otherwise;
	
	//Added on 30-Sept-2022 Start
	@FindBy (how=How.XPATH, using = "//button[text()='Once a week']")
	public static WebElement txt_pay_frequency_Once_a_week;
	//Added on 30-Sept-2022 End
	
	//@FindBy (how=How.XPATH, using = "//div[text()='Last Pay date *']//parent::div//input") //Commented on 26-Sept-2022 PreviewC
	@FindBy (how=How.XPATH, using = "//div[text()='Last pay date *']//parent::div//input") //Added on 26-Sept-2022 QAC
	public static WebElement txt_LastPaydate;
	
	@FindBy (how=How.XPATH, using = "//div[text()='Next pay date *']//parent::div//input")
	public static WebElement txt_Nextpaydate;
	
	@FindBy (how=How.XPATH, using = "//div[text()='Last take home pay cheque amount *']//parent::div//input")
	public static WebElement txt_Last_take_home_pay_cheque_amount;
	
	@FindBy (how=How.XPATH, using = "//div[contains(text(),'first cheque total')]//parent::div//input")
	public static WebElement txt_first_cheque_total;
	
	@FindBy (how=How.XPATH, using = "//div[contains(text(),'second cheque total')]//parent::div//input")
	public static WebElement txt_second_cheque_total;
	
	//Added 17-Sept-2022 End
	
	//Added on 30-Sept-2022 Start
	@FindBy (how=How.XPATH, using = "(//div[contains(text(),'cheque total *')])[1]//parent::div//input")
	public static WebElement txt_cheque_total_weekly_1;
	
	@FindBy (how=How.XPATH, using = "(//div[contains(text(),'cheque total *')])[2]//parent::div//input")
	public static WebElement txt_cheque_total_weekly_2;
	
	@FindBy (how=How.XPATH, using = "(//div[contains(text(),'cheque total *')])[3]//parent::div//input")
	public static WebElement txt_cheque_total_weekly_3;
	
	@FindBy (how=How.XPATH, using = "(//div[contains(text(),'cheque total *')])[4]//parent::div//input")
	public static WebElement txt_cheque_total_weekly_4;
	
	//Added on 30-Sept-2022 End
	
	//Added 21-Nov-2022 Start
	
	@FindBy (how=How.XPATH, using = "(//div[contains(text(),'cheque total*')])[1]//parent::div//input")
	public static WebElement txt_cheque_total_weekly_11;
	
	@FindBy (how=How.XPATH, using = "(//div[contains(text(),'cheque total*')])[2]//parent::div//input")
	public static WebElement txt_cheque_total_weekly_12;
	
	@FindBy (how=How.XPATH, using = "(//div[contains(text(),'cheque total*')])[3]//parent::div//input")
	public static WebElement txt_cheque_total_weekly_13;
	
	@FindBy (how=How.XPATH, using = "(//div[contains(text(),'cheque total*')])[4]//parent::div//input")
	public static WebElement txt_cheque_total_weekly_14;
	
	//Added 21-Nov-2022 End
					
	//Added 19-Sept-2022 Start
	
	@FindBy (how=How.XPATH, using = "//button[text()='Every 2 weeks']")
	public static WebElement txt_Every2Week;
	
	//@FindBy (how=How.XPATH, using = "//div[text()='Last Pay date *']//parent::div//input") //Commented on 26-Sept-2022 PreviewC 
	@FindBy (how=How.XPATH, using = "//div[text()='Last pay date *']//parent::div//input") //Added on 26-Sept-2022 QAC
	public static WebElement txt_LastPaydate_SemiWeekly;
	
	@FindBy (how=How.XPATH, using = "//div[text()='Next pay date *']//parent::div//input")
	public static WebElement txt_Nextpaydate_SemiWeekly;
	
	
	@FindBy (how=How.XPATH, using = "//div[text()='Last pay date *']//parent::div//input") //Added on 26-Sept-2022 QAC
	public static WebElement txt_LastPaydate_Weekly;
	
	@FindBy (how=How.XPATH, using = "//div[text()='Next pay date *']//parent::div//input")
	public static WebElement txt_Nextpaydate_Weekly;
	
	@FindBy (how=How.XPATH, using = "//div[text()='Last take home pay cheque amount *']//parent::div//input")
	public static WebElement txt_Last_take_home_pay_cheque_amount_SemiWeekly;
	
	//Added on 30-Sept-2022 Start
	@FindBy (how=How.XPATH, using = "//div[text()='Last take home pay cheque amount *']//parent::div//input")
	public static WebElement txt_Last_take_home_pay_cheque_amount_Weekly;
	//Added on 30-Sept-2022 End
	
	@FindBy (how=How.XPATH, using = "(//div[contains(text(),'cheque total')]//parent::div//input)[1]")
	public static WebElement txt_Cheque_Total1;
	
	@FindBy (how=How.XPATH, using = "(//div[contains(text(),'cheque total')]//parent::div//input)[2]")
	public static WebElement txt_Cheque_Total2;
	
					
	//Added 19-Sept-2022 End
	
	@FindBy (how=How.XPATH, using = "//div[6]//div[1]//div[2]//label[1]//div[1]//input[1]")
	public static WebElement Last_Pay_date;
	
	
	//@FindBy (how=How.XPATH, using = "//div[text()='Last Pay date *']//parent::div//input") //Commented on 26-Sept-2022 PreviewC
	@FindBy (how=How.XPATH, using = "//div[text()='Last pay date *']//parent::div//input") //Added on 26-Sept-2022 QAC
	public static WebElement txt_LastPayDate;
	
	@FindBy (how=How.XPATH, using = "//div[contains(text(),'Take-home for month of')]//parent::div//input")
	public static WebElement txt_Take_home_for_month_of_Previous;
	
	@FindBy (how=How.XPATH, using = "//div[contains(text(),'Take-home for month of')]//parent::div//input")
	public static List<WebElement> txt_Take_home_for_month_of_Previous_list;
	
	@FindBy (how=How.XPATH, using = "//div[text()='Next pay date *']//parent::div//input")
	public static WebElement txt_NextPayDate;
	
	@FindBy (how=How.XPATH, using = "//div[text()='Last take home pay cheque amount *']//parent::div//input")
	public static WebElement txt_LastTakeHomePayChequeAmount;
	
	@FindBy (how=How.XPATH, using = "//div[7]//div[1]//div[2]//label[1]//div[1]//input[1]")
	public static WebElement Next_Pay_date;
	
	@FindBy (how=How.XPATH, using = "//input[@type='text']")
	public static WebElement net_amount;
	
	@FindBy (how=How.XPATH, using = "//button[@id='gs-accept']")
	public static WebElement next_button;
	
	//@FindBy (how=How.XPATH, using = "//fieldset[contains(@class,'mm-fieldset')]//input[contains(@type,'text')]") Commented on 24-Sept-2022
	@FindBy (how=How.XPATH, using = "//div[contains(text(),'Take-home for')]//parent::div//input") 
	public static WebElement pervious_netpay;
	
	@FindBy (how=How.XPATH, using = "//div[@class='mm-form-field mm-form-field--has-value mm-gs-formfield']//select[@class='mm-select__native-input']//option]")
	public static WebElement employee_types;
	@FindBy (how=How.XPATH, using = "//div[contains(text(),'Take-home for month')]/following::input[1]")
	public static List<WebElement> List_txt_PreviousPay;
	
	//@FindBy (how=How.XPATH, using = "//div[contains(text(),'Last Pay date *')]/following::input[1]") //Commented on 26-Sept-2022 PreviewC
	@FindBy (how=How.XPATH, using = "//div[contains(text(),'Last pay date *')]/following::input[1]") //Added on 26-Sept-2022 QAC
	public static WebElement txt_LastPayDay;

	@FindBy (how=How.XPATH, using = "//div[contains(text(),'Next pay date *')]/following::input[1]")
	public static WebElement txt_NextPayDay;

	@FindBy (how=How.XPATH, using = "//div[contains(text(),'Last take home pay')]/following::input[1]")
	public static WebElement txt_LastNetPay;

	@FindBy (how=How.XPATH, using = "//input[contains(@type,'text')]")
	public static List<WebElement> List_txt_LastNetPay;
	
	@FindBy (how=How.XPATH, using = "//div[contains(text(),'Last take home pay cheque amount *')]/following::input[1]")
	public static WebElement txt_LastNetPayGetText;

	@FindBy (how=How.XPATH, using = "//div[contains(text(),'Take-home for month of ')]/following::input[1]")
	public static WebElement txt_PreviousPay;

	//Added on 12-Aug-2022 Start
		@FindBy (how=How.XPATH, using = "//h1[text()='Any changes to your information?']")
		public static WebElement header_AnyChangesToYourInformation;
		
		@FindBy (how=How.XPATH, using = "//div[@class='container']//h1")
		public static WebElement header_page_AnyChangesToYourInformation;
		
		@FindBy (how=How.XPATH, using = "//button[text()='No']")
		public static WebElement btn_Rent_No;
		
		@FindBy (how=How.XPATH, using = "//button[text()='Yes']")
		public static WebElement btn_Rent_Yes;
		
		@FindBy (how=How.XPATH, using = "//div[contains(text(),'What is your share of rent?*')]//parent::div//label/input")
		public static WebElement txt_Rent;
		
		@FindBy (how=How.XPATH, using = "//button[@id='mm-btn-click']")
		public static WebElement btn_No_withID;
		
		@FindBy (how=How.XPATH, using = "//div[contains(text(),'Last take-home pay cheque')]//parent::div//label/input")
		public static WebElement txt_Last_takehomepay;
		
		//Added on 15-Oct-2022 Start
		@FindBy (how=How.XPATH, using = "//div[contains(text(),'Last take-home pay cheque')]//parent::div//label/input")
		public static List<WebElement> txt_Last_takehomepay_LISTs;
		//Added on 15-Oct-2022 End
		
		@FindBy (how=How.XPATH, using = "//div[contains(text(),'Take-home net pay for')]//parent::div//label/input")
		public static WebElement txt_Takehomenetpay;
		
		//Added on 16-Oct-2022 Start
		@FindBy (how=How.XPATH, using = "//div[contains(text(),'Take-home net pay for')]//parent::div//label/input")
		public static List<WebElement> txt_Takehomenetpay_LISTs;
		//Added on 16-Oct-2022 Start
		
		@FindBy (how=How.XPATH, using = "//button[text()='Confirm & Continue']")
		public static WebElement btn_ConfirmAndContinue;
	//Added on 12-Aug-2022 End
		
		
		
	public void Employer_details_DisEngagedExisting_IL_Reloan() throws Exception
	{
	
		if(getMapData.get("PayFrequency_DisEngagedExisting").equalsIgnoreCase("Monthly"))
		{
			txt_Last_take_home_pay_cheque_amount.sendKeys(Keys.CONTROL + "a");
			txt_Last_take_home_pay_cheque_amount.sendKeys(Keys.DELETE);
			EnterText(txt_Last_take_home_pay_cheque_amount, getMapData.get("LasttakehomePay_DisEngagedExisting"), "LasttakehomePay_DisEngagedExisting");
		}
		
		waitForElementToBeClickable(next_button, "WaitNextClickable");
		click(next_button,"Next button page"); 
	}
	
	//Added on 21-Nov-2022 Start
	public void Employer_details_EngagedExisting_IL_Reloan() throws Exception
	{
	
		if(getMapData.get("Pay_Frequency").equalsIgnoreCase("Monthly"))
		{
			txt_Last_take_home_pay_cheque_amount.sendKeys(Keys.CONTROL + "a");
			txt_Last_take_home_pay_cheque_amount.sendKeys(Keys.DELETE);
			EnterText(txt_Last_take_home_pay_cheque_amount, getMapData.get("LastNetPay"), "LastNetPay");
		}
		
		waitForElementToBeClickable(next_button, "WaitNextClickable");
		click(next_button,"Next button page"); 
	}
	//Added on 21-Nov-2022 End
	
	public void Employer_details() throws Exception
	{
		
		Thread.sleep(3000);
		waitForElementToBeVisible(employee_type,"WaitVisibleOfemployeetype");
		Thread.sleep(2000); //Added on 09-Aug-2022
		waitForElementToBeClickable(employee_type, "WaitEmployeeType"); //Added on 09-Aug-2022
		//scrollIntoView(employee_type); //Added on 31-Oct-2022
		Thread.sleep(7000); //Added on 31-Oct-2022 //Updated 7k from 2k on 02-Nov-2022
		click(employee_type,"employee_type"); 
		
		
		if(getMapData.get("Income_source").equalsIgnoreCase("Full Time Employed"))
		{
			click(full_typeemploye,"Full time");
		} 
		else if (getMapData.get("Income_source").equalsIgnoreCase("Others"))
		{
			click(dd_income_Other,"others");
		}
		else if (getMapData.get("Income_source").equalsIgnoreCase("Old Age Security (OAS)"))
		{
			click(btn_OldAgeSecurity,"Old Age Security");
		}
		
		
		EnterText(employee_name, getMapData.get("Emp_Name"), "employee name");
		TestBase.bindreport(currentGlobalScenarioName, "NMM_EmployeerName");
		
		EnterText(employee_phone, getMapData.get("Emp_Phone"), "employee phone");	
		
		click(how_to_paid,"how_to_paid list "); 
		TestBase.bindreport(currentGlobalScenarioName, "how to paid1");
		click(pay_frequency,"Same day every month"); 
		
		click(Last_Pay_date,"Last Pay date"); 
		EnterText(Last_Pay_date, getMapData.get("LastPayDate"), "LastPayDate");
		
		click(Next_Pay_date,"Next Pay date"); 
		EnterText(Next_Pay_date, getMapData.get("NextPayDate"), "NextPayDate");
		EnterText(net_amount, getMapData.get("LastNetPay"), "net amount");
		TestBase.bindreport(currentGlobalScenarioName, "employee details page");
		
		if(List_txt_PreviousPay.size()>0)
		{
			EnterText(pervious_netpay, getMapData.get("PreviousMonthPay"), "PreviousMonthPay");
		}
		
		else
		{
		
		click(next_button,"Next button page"); 
		}
		TestBase.bindreport(currentGlobalScenarioName, "BeforeClick");
		click(next_button,"Next button page"); 
	}
	
	
	public void Employer_details_OldAgeSecurity() throws Exception
	{
		
		Thread.sleep(3000);
		waitForElementToBeVisible(employee_type,"WaitVisibleOfemployeetype");
		Thread.sleep(2000); //Added on 09-Aug-2022
		waitForElementToBeClickable(employee_type, "WaitEmployeeType"); //Added on 09-Aug-2022
		//scrollIntoView(employee_type); //Added on 31-Oct-2022
		Thread.sleep(2000); //Added on 31-Oct-2022
		click(employee_type,"employee_type"); 
		
		click(btn_OldAgeSecurity,"Old Age Security");
		
		click(how_to_paid,"how_to_paid list "); 
		TestBase.bindreport(currentGlobalScenarioName, "how to paid1");
		
		click(pay_frequency,"Same day every month"); 
		
		click(txt_LastPayDate,"Last Pay date"); 
		EnterText(txt_LastPayDate, getMapData.get("LastPayDate"), "LastPayDate");
		
		click(txt_NextPayDate,"Next Pay date"); 
		EnterText(txt_NextPayDate, getMapData.get("NextPayDate"), "NextPayDate");
		
		EnterText(txt_LastTakeHomePayChequeAmount, getMapData.get("LastNetPay"), "net amount");
		
		TestBase.bindreport(currentGlobalScenarioName, "employee details page");
		
		if(txt_Take_home_for_month_of_Previous_list.size()>0)
		{
			EnterText(txt_Take_home_for_month_of_Previous, getMapData.get("PreviousMonthPay"), "PreviousMonthPay");
		}	
	
		click(next_button,"Next button page"); 
	}
	
	
	//Added on 14-Nov-2022 Start
	@FindBy (how=How.XPATH, using = "//div[@class='mm-page-loader__wrapper']")
	public static List<WebElement> searchWheel_SearchLook;
	//Added on 14-Nov-2022 End
	
	
	//Added on 15-Nov-2022 Start
	@FindBy (how=How.XPATH, using = "//p[text()='+ Add employer']")
	public static WebElement link_AddEmployer;
	
	@FindBy (how=How.XPATH, using = "(//div[text()='Your Employment Status*'])[1]//parent::div//button")
	public static WebElement dd_Your_Employment_Status1;
	
	//////////////////////////////////////////////////////
	//@FindBy (how=How.XPATH, using = "(//div[text()='Who pays you? *'])[1]//parent::div//input")
	@FindBy (how=How.XPATH, using = "(//div[text()='Employer*'])[1]//parent::div//input")
	public static WebElement txt_Who_pays_you1;
	
	//@FindBy (how=How.XPATH, using = "(//div[contains(text(),'Payer')])[1]//parent::div//input")
	@FindBy (how=How.XPATH, using = "(//div[text()='Employers Phone'])[1]//parent::div//input")
	public static WebElement txt_PayerNo1;
	
	
	
	
	
	//////////////////////////////////////////////////////
	
	@FindBy (how=How.XPATH, using = "(//div[text()='How often are you paid? *'])[1]//parent::div//button")
	public static WebElement dd_How_often_are_you_paid1;
	
	@FindBy (how=How.XPATH, using = "(//div[text()='Last pay date *'])[1]//parent::div//input")
	public static WebElement txt_Last_pay_date1;
	
	@FindBy (how=How.XPATH, using = "(//div[text()='Next pay date *'])[1]//parent::div//input")
	public static WebElement txt_Next_pay_date1;
	
	@FindBy (how=How.XPATH, using = "(//div[text()='Last take home pay cheque amount *'])[1]//parent::div//input")
	public static WebElement txt_Last_take_home_pay_cheque_amount1;
	
	
	//WEEKLY
		
		@FindBy (how=How.XPATH, using = "(//div[text()='Your Employment Status*'])[2]//parent::div//button")
		public static WebElement dd_Your_Employment_Status2;
	
		//////////////////////////////////////////////////////
		//@FindBy (how=How.XPATH, using = "(//div[text()='Who pays you? *'])[1]//parent::div//input")
		@FindBy (how=How.XPATH, using = "(//div[text()='Employer*'])[2]//parent::div//input")
		public static WebElement txt_Who_pays_you2;
		
		//@FindBy (how=How.XPATH, using = "(//div[contains(text(),'Payer')])[1]//parent::div//input")
		@FindBy (how=How.XPATH, using = "(//div[text()='Employers Phone'])[2]//parent::div//input")
		public static WebElement txt_PayerNo2;
		//////////////////////////////////////////////////////
		
		@FindBy (how=How.XPATH, using = "(//div[text()='How often are you paid? *'])[2]//parent::div//button")
		public static WebElement dd_How_often_are_you_paid2;
		
		@FindBy (how=How.XPATH, using = "(//div[text()='Last pay date *'])[2]//parent::div//input")
		public static WebElement txt_Last_pay_date2;
		
		@FindBy (how=How.XPATH, using = "(//div[text()='Next pay date *'])[2]//parent::div//input")
		public static WebElement txt_Next_pay_date2;
		
		@FindBy (how=How.XPATH, using = "(//div[text()='Last take home pay cheque amount *'])[2]//parent::div//input")
		public static WebElement txt_Last_take_home_pay_cheque_amount2;
		
	//BI-WEEKLY
		@FindBy (how=How.XPATH, using = "(//div[text()='Your Employment Status*'])[3]//parent::div//button")
		public static WebElement dd_Your_Employment_Status3;
		
		//////////////////////////////////////////////////////
		//@FindBy (how=How.XPATH, using = "(//div[text()='Who pays you? *'])[2]//parent::div//input")
		@FindBy (how=How.XPATH, using = "(//div[text()='Who pays you? *'])[1]//parent::div//input")
		public static WebElement txt_Who_pays_you3;
		
		//@FindBy (how=How.XPATH, using = "(//div[contains(text(),'Payer')])[2]//parent::div//input")
		@FindBy (how=How.XPATH, using = "(//div[contains(text(),'Payer')])[1]//parent::div//input")
		public static WebElement txt_PayerNo3;
		//////////////////////////////////////////////////////
		
		@FindBy (how=How.XPATH, using = "(//div[text()='How often are you paid? *'])[3]//parent::div//button")
		public static WebElement dd_How_often_are_you_paid3;
		
		@FindBy (how=How.XPATH, using = "(//div[text()='Last pay date *'])[3]//parent::div//input")
		public static WebElement txt_Last_pay_date3;
		
		@FindBy (how=How.XPATH, using = "(//div[text()='Next pay date *'])[3]//parent::div//input")
		public static WebElement txt_Next_pay_date3;
		
		@FindBy (how=How.XPATH, using = "(//div[text()='Last take home pay cheque amount *'])[3]//parent::div//input")
		public static WebElement txt_Last_take_home_pay_cheque_amount3;
	
		@FindBy (how=How.XPATH, using = "(//div[text()='Employer Information'])[2]")
		public static WebElement header_Employer_Information2;
		
		@FindBy (how=How.XPATH, using = "(//div[text()='Employer Information'])[3]")
		public static WebElement header_Employer_Information3;
	
	//Added on 15-Nov-2022 End
	
		public void Employer_details_With_Frequency_Multi_Employer_with_Monthly_Weekly(String payPeriodOrFrequency) throws Exception
		{
			Thread.sleep(5000);
			waitForElementToBeClickable(dd_Your_Employment_Status1, "WaitEmployeeType"); 
			Thread.sleep(2000); 
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
					
					click(dd_Your_Employment_Status1,"Clickemployee_type"); 
					
					
					if(getMapData.get("Income_source").equalsIgnoreCase("Full Time Employed"))
					{
						click(full_typeemploye,"Full time");
					} 
					else if (getMapData.get("Income_source").equalsIgnoreCase("Others"))
					{
						click(dd_income_Other,"others");
					}
					
					EnterText(txt_Who_pays_you1, getMapData.get("Emp_Name"), "employee name");
					TestBase.bindreport(currentGlobalScenarioName, "EmployeerName");
					
					EnterText(txt_PayerNo1, getMapData.get("Emp_Phone"), "employee phone");	
					
					click(dd_How_often_are_you_paid1,"how_to_paid list "); 
					TestBase.bindreport(currentGlobalScenarioName, "how to paid2");
					
					if(payPeriodOrFrequency.equalsIgnoreCase("Same day every month"))
					{
						click(pay_frequency,"Same day every month");
						
						click(txt_Last_pay_date1,"Last Pay date"); 
						EnterText(txt_Last_pay_date1, getMapData.get("LastPayDate"), "LastPayDate");
						
						click(txt_Next_pay_date1,"Next Pay date");
						EnterText(txt_Next_pay_date1, getMapData.get("NextPayDate"), "NextPayDate");
						
						EnterText(txt_Last_take_home_pay_cheque_amount1, getMapData.get("LastNetPay"), "net amount");
						TestBase.bindreport(currentGlobalScenarioName, "employee details page");
						
						if(List_txt_PreviousPay.size()>0)
						{
							EnterText(pervious_netpay, getMapData.get("PreviousMonthPay"), "PreviousMonthPay");
						}
						
						TestBase.bindreport(currentGlobalScenarioName, "PayFrequency0");
					}
					
					
					waitForElementToBeClickable(link_AddEmployer, "WaitEmployerLink");
					scrollIntoView(link_AddEmployer);
					Thread.sleep(2000);
					click(link_AddEmployer, "clkAddEmployer");
					
					//Thread.sleep(2000);
					//scrollIntoView(txt_Who_pays_you2);
					Thread.sleep(5000);
					
					//===============================================================
					//WEEKLY
					//===============================================================
					waitForElementToBeClickable(dd_Your_Employment_Status2, "WaitEmpStatus2");
					click(dd_Your_Employment_Status2,"Clickemployee_type_2"); 
					
					
					if(getMapData.get("Income_source").equalsIgnoreCase("Full Time Employed"))
					{
						click(full_typeemploye2,"Full time2");
					} 
					else if (getMapData.get("Income_source1").equalsIgnoreCase("Part Time Employed"))
					{
						click(dd_income_PartTime,"PartTime");
					}
					else if (getMapData.get("Income_source").equalsIgnoreCase("Others"))
					{
						click(dd_income_Other,"others");
					}
					
					
					
					//Part Time Employed
					
					Thread.sleep(3000);
					EnterText(txt_Who_pays_you2, getMapData.get("Emp_Name"), "employee name_2");
					TestBase.bindreport(currentGlobalScenarioName, "EmployeerName_2");
					
					EnterText(txt_PayerNo2, getMapData.get("Emp_Phone"), "employee phone_2");	
					
					click(dd_How_often_are_you_paid2,"how_to_paid list_2"); 
					TestBase.bindreport(currentGlobalScenarioName, "how to paid_2");
					
					if(payPeriodOrFrequency.equalsIgnoreCase("Same day every month"))
					{
						click(txt_pay_frequency_Once_a_week,"OnceAWeek_2");
						
						click(txt_Last_pay_date2,"Last Pay date_2"); 
						EnterText(txt_Last_pay_date2, getMapData.get("LastPayDate_Weekly"), "LastPayDate_2");
						
						click(txt_Next_pay_date2,"Next Pay date_2");
						EnterText(txt_Next_pay_date2, getMapData.get("NextPayDate_Weekly"), "NextPayDate_2");
						
						EnterText(txt_Last_take_home_pay_cheque_amount2, getMapData.get("LastNetPay_Weekly"), "net amount_2");
						TestBase.bindreport(currentGlobalScenarioName, "employee details page_2");
						
						/* Commented on 30-Nov-2022 Start Applicable only for MB and ON
						//Added on 21-Nov-2022 Start
						EnterText(txt_cheque_total_weekly_1, getMapData.get("FirstChequeTotalWeekly1"), "FirstChequeTotalWeekly1");
						EnterText(txt_cheque_total_weekly_2, getMapData.get("FirstChequeTotalWeekly2"), "FirstChequeTotalWeekly2");
						EnterText(txt_cheque_total_weekly_3, getMapData.get("FirstChequeTotalWeekly3"), "FirstChequeTotalWeekly3");
						EnterText(txt_cheque_total_weekly_4, getMapData.get("FirstChequeTotalWeekly4"), "FirstChequeTotalWeekly4");
						//Added on 21-Nov-2022 End
						  Commented on 30-Nov-2022 End
						*/
						
						/* Not applicable for Weekly - Commented on 21-Nov-2022
						if(List_txt_PreviousPay.size()>0)
						{
							EnterText(pervious_netpay, getMapData.get("PreviousMonthPay"), "PreviousMonthPay_2");
						}
						*/
						
						TestBase.bindreport(currentGlobalScenarioName, "PayFrequency_2");
					}
				click(next_button,"Next button page"); 		
		}	
	
	public void Employer_details_With_Frequency_Multi_Employer_with_Monthly_Weekly_BiWeekly(String payPeriodOrFrequency) throws Exception
	{
		Thread.sleep(5000);
		waitForElementToBeClickable(dd_Your_Employment_Status1, "WaitEmployeeType"); 
		Thread.sleep(2000); 
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
				
				click(dd_Your_Employment_Status1,"Clickemployee_type"); 
				
				
				if(getMapData.get("Income_source").equalsIgnoreCase("Full Time Employed"))
				{
					click(full_typeemploye,"Full time");
				} 
				else if (getMapData.get("Income_source").equalsIgnoreCase("Others"))
				{
					click(dd_income_Other,"others");
				}
				
				EnterText(txt_Who_pays_you1, getMapData.get("Emp_Name"), "employee name");
				TestBase.bindreport(currentGlobalScenarioName, "EmployeerName");
				
				EnterText(txt_PayerNo1, getMapData.get("Emp_Phone"), "employee phone");	
				
				click(dd_How_often_are_you_paid1,"how_to_paid list "); 
				TestBase.bindreport(currentGlobalScenarioName, "how to paid2");
				
				if(payPeriodOrFrequency.equalsIgnoreCase("Same day every month"))
				{
					click(pay_frequency,"Same day every month");
					
					click(txt_Last_pay_date1,"Last Pay date"); 
					EnterText(txt_Last_pay_date1, getMapData.get("LastPayDate"), "LastPayDate");
					
					click(txt_Next_pay_date1,"Next Pay date");
					EnterText(txt_Next_pay_date1, getMapData.get("NextPayDate"), "NextPayDate");
					
					EnterText(txt_Last_take_home_pay_cheque_amount1, getMapData.get("LastNetPay"), "net amount");
					TestBase.bindreport(currentGlobalScenarioName, "employee details page");
					
					if(List_txt_PreviousPay.size()>0)
					{
						EnterText(pervious_netpay, getMapData.get("PreviousMonthPay"), "PreviousMonthPay");
					}
					
					TestBase.bindreport(currentGlobalScenarioName, "PayFrequency0");
				}
				
				
				waitForElementToBeClickable(link_AddEmployer, "WaitEmployerLink");
				scrollIntoView(link_AddEmployer);
				Thread.sleep(2000);
				click(link_AddEmployer, "clkAddEmployer");
				
				//Thread.sleep(2000);
				//scrollIntoView(txt_Who_pays_you2);
				Thread.sleep(5000);
				
				//===============================================================
				//WEEKLY
				//===============================================================
				waitForElementToBeClickable(dd_Your_Employment_Status2, "WaitEmpStatus2");
				click(dd_Your_Employment_Status2,"Clickemployee_type_2"); 
				
				
				if(getMapData.get("Income_source").equalsIgnoreCase("Full Time Employed"))
				{
					click(full_typeemploye2,"Full time2");
				} 
				else if (getMapData.get("Income_source1").equalsIgnoreCase("Part Time Employed"))
				{
					click(dd_income_PartTime,"PartTime");
				}
				else if (getMapData.get("Income_source").equalsIgnoreCase("Others"))
				{
					click(dd_income_Other,"others");
				}
				
				
				
				//Part Time Employed
				
				Thread.sleep(3000);
				EnterText(txt_Who_pays_you2, getMapData.get("Emp_Name"), "employee name_2");
				TestBase.bindreport(currentGlobalScenarioName, "EmployeerName_2");
				
				EnterText(txt_PayerNo2, getMapData.get("Emp_Phone"), "employee phone_2");	
				
				click(dd_How_often_are_you_paid2,"how_to_paid list_2"); 
				TestBase.bindreport(currentGlobalScenarioName, "how to paid_2");
				
				if(payPeriodOrFrequency.equalsIgnoreCase("Same day every month"))
				{
					click(txt_pay_frequency_Once_a_week,"OnceAWeek_2");
					
					click(txt_Last_pay_date2,"Last Pay date_2"); 
					EnterText(txt_Last_pay_date2, getMapData.get("LastPayDate_Weekly"), "LastPayDate_2");
					
					click(txt_Next_pay_date2,"Next Pay date_2");
					EnterText(txt_Next_pay_date2, getMapData.get("NextPayDate_Weekly"), "NextPayDate_2");
					
					EnterText(txt_Last_take_home_pay_cheque_amount2, getMapData.get("LastNetPay_Weekly"), "net amount_2");
					TestBase.bindreport(currentGlobalScenarioName, "employee details page_2");
					
					if(List_txt_PreviousPay.size()>0)
					{
						EnterText(pervious_netpay, getMapData.get("PreviousMonthPay"), "PreviousMonthPay_2");
					}
					
					TestBase.bindreport(currentGlobalScenarioName, "PayFrequency_2");
				}
				
				waitForElementToBeClickable(link_AddEmployer, "WaitEmployerLink");
				click(link_AddEmployer, "clkAddEmployer");
				
				
				//Thread.sleep(2000);
				//scrollIntoView(txt_Who_pays_you3);
				Thread.sleep(5000);
				
				//===============================================================
				//BI-WEEKLY
				//===============================================================
				waitForElementToBeClickable(dd_Your_Employment_Status2, "WaitEmpStatus3");
				click(dd_Your_Employment_Status3,"Clickemployee_type_3"); 
				
				/* TO CONTINUE WITH DEFAULT others
				if(getMapData.get("Income_source").equalsIgnoreCase("Full Time Employed"))
				{
					click(full_typeemploye3,"Full time2");
				} 
				else if (getMapData.get("Income_source").equalsIgnoreCase("Others"))
				{
					click(dd_income_Other,"others");
				}
				*/
				
				Thread.sleep(3000);
				EnterText(txt_Who_pays_you3, getMapData.get("Emp_Name"), "employee name_3");
				TestBase.bindreport(currentGlobalScenarioName, "EmployeerName_3");
				
				EnterText(txt_PayerNo3, getMapData.get("Emp_Phone"), "employee phone_3");	
				
				click(dd_How_often_are_you_paid3,"how_to_paid list_3"); 
				TestBase.bindreport(currentGlobalScenarioName, "how to paid_3");
				
				if(payPeriodOrFrequency.equalsIgnoreCase("Same day every month"))
				{
					
					Thread.sleep(3000);
					scrollIntoView(txt_Every2Week);
					Thread.sleep(3000);
					click(txt_Every2Week,"Every2Weeks_3");
					Thread.sleep(3000);
					
					click(txt_Last_pay_date3,"Last Pay date_3"); 
					EnterText(txt_Last_pay_date3, getMapData.get("LastPayDate_BiWeekly"), "LastPayDate_3");
					
					click(txt_Next_pay_date3,"Next Pay date_2");
					EnterText(txt_Next_pay_date3, getMapData.get("NextPayDate_BiWeekly"), "NextPayDate_3");
					
					EnterText(txt_Last_take_home_pay_cheque_amount3, getMapData.get("LastNetPay_BiWeekly"), "net amount_3");
					TestBase.bindreport(currentGlobalScenarioName, "employee details page_3");
					
					if(List_txt_PreviousPay.size()>0)
					{
						EnterText(pervious_netpay, getMapData.get("PreviousMonthPay"), "PreviousMonthPay_3");
					}
					
					TestBase.bindreport(currentGlobalScenarioName, "PayFrequency_3");
				}
				
			click(next_button,"Next button page"); 		
	}
	
	
	public void Employer_details_With_Frequency(String payPeriodOrFrequency) throws Exception
	{
		
		Thread.sleep(3000);
		//waitForElementToBeVisible(employee_type,"WaitVisibleOfemployeetype"); //Commented on 20-Sept-2022
		Thread.sleep(2000); //Added on 09-Aug-2022
		waitForElementToBeClickable(employee_type, "WaitEmployeeType"); //Added on 09-Aug-2022
		//scrollIntoView(employee_type); //Added on 31-Oct-2022
		Thread.sleep(2000); //Added on 31-Oct-2022
		
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
		
		click(employee_type,"employee_type"); 
		
		
		if(getMapData.get("Income_source").equalsIgnoreCase("Full Time Employed"))
		{
			click(full_typeemploye,"Full time");
		} 
		else if (getMapData.get("Income_source").equalsIgnoreCase("Others"))
		{
			click(dd_income_Other,"others");
		}
		
		EnterText(employee_name, getMapData.get("Emp_Name"), "employee name");
		TestBase.bindreport(currentGlobalScenarioName, "NMM_EmployeerName");
		
		EnterText(employee_phone, getMapData.get("Emp_Phone"), "employee phone");	
		
		click(how_to_paid,"how_to_paid list "); 
		TestBase.bindreport(currentGlobalScenarioName, "how to paid2");
		if(payPeriodOrFrequency.equalsIgnoreCase("Same day every month"))
		{
			click(pay_frequency,"Same day every month");
			
			click(Last_Pay_date,"Last Pay date"); 
			EnterText(Last_Pay_date, getMapData.get("LastPayDate"), "LastPayDate");
			
			click(Next_Pay_date,"Next Pay date");
			EnterText(Next_Pay_date, getMapData.get("NextPayDate"), "NextPayDate");
			
			EnterText(net_amount, getMapData.get("LastNetPay"), "net amount");
			TestBase.bindreport(currentGlobalScenarioName, "employee details page");
			
			if(List_txt_PreviousPay.size()>0)
			{
				EnterText(pervious_netpay, getMapData.get("PreviousMonthPay"), "PreviousMonthPay");
			}
			
			TestBase.bindreport(currentGlobalScenarioName, "PayFrequency0");
		}
		if(payPeriodOrFrequency.equalsIgnoreCase("Twice a Month - otherwise"))
		{
			
			click(txt_pay_frequency_Twice_a_Month_otherwise,"Twice a Month - otherwise");
			
			
			click(txt_LastPaydate,"Last Pay date"); 
			EnterText(txt_LastPaydate, getMapData.get("LastPayDate"), "LastPayDate");
			
			click(txt_Nextpaydate,"Next Pay date");
			EnterText(txt_Nextpaydate, getMapData.get("NextPayDate"), "NextPayDate");
			
			EnterText(txt_Last_take_home_pay_cheque_amount, getMapData.get("LasttakehomePay"), "LasttakehomePay");
			EnterText(txt_first_cheque_total, getMapData.get("FirstChequeTotal"), "FirstChequeTotal");
			EnterText(txt_second_cheque_total, getMapData.get("SecondChequeTotal"), "SecondChequeTotal");
			
			TestBase.bindreport(currentGlobalScenarioName, "PayFrequency1");
			
		}
		
		if(payPeriodOrFrequency.equalsIgnoreCase("Every 2 weeks"))
		{
			
			click(txt_Every2Week,"Every 2 weeks");
			
			click(txt_LastPaydate_SemiWeekly,"Last Pay date"); 
			EnterText(txt_LastPaydate_SemiWeekly, getMapData.get("LastPayDate"), "LastPayDate");
			
			click(txt_Nextpaydate_SemiWeekly,"Next Pay date");
			EnterText(txt_Nextpaydate_SemiWeekly, getMapData.get("NextPayDate"), "NextPayDate");
			
			EnterText(txt_Last_take_home_pay_cheque_amount_SemiWeekly, getMapData.get("LasttakehomePay"), "LasttakehomePay");
			EnterText(txt_Cheque_Total1, getMapData.get("FirstChequeTotal"), "FirstChequeTotal");
			EnterText(txt_Cheque_Total2, getMapData.get("SecondChequeTotal"), "SecondChequeTotal");
			
			TestBase.bindreport(currentGlobalScenarioName, "PayFrequency2");
		}
		
		if(payPeriodOrFrequency.equalsIgnoreCase("Weekly"))
		{
			
			click(txt_pay_frequency_Once_a_week,"Once a Week");
			
			click(txt_LastPaydate_SemiWeekly,"Last Pay date"); 
			EnterText(txt_LastPaydate_Weekly, getMapData.get("LastPayDate"), "LastPayDate");
			
			click(txt_Nextpaydate_SemiWeekly,"Next Pay date");
			EnterText(txt_Nextpaydate_Weekly, getMapData.get("NextPayDate"), "NextPayDate");
			
			EnterText(txt_Last_take_home_pay_cheque_amount_Weekly, getMapData.get("LasttakehomePay"), "LasttakehomePay");
			
			
			EnterText(txt_cheque_total_weekly_1, getMapData.get("FirstChequeTotalWeekly1"), "FirstChequeTotalWeekly1");
			EnterText(txt_cheque_total_weekly_2, getMapData.get("FirstChequeTotalWeekly2"), "FirstChequeTotalWeekly2");
			EnterText(txt_cheque_total_weekly_3, getMapData.get("FirstChequeTotalWeekly3"), "FirstChequeTotalWeekly3");
			EnterText(txt_cheque_total_weekly_4, getMapData.get("FirstChequeTotalWeekly4"), "FirstChequeTotalWeekly4");
			
			TestBase.bindreport(currentGlobalScenarioName, "PayFrequency2");
		}
	
	click(next_button,"Next button page"); 	
	}
	
	
	
	
	
	
	@FindBy (how=How.XPATH, using = "//div[contains(text(),'Last take home pay cheque')]//parent::div//input")
	public static WebElement txt_Last_take_home_pay_cheque;
	
	@FindBy (how=How.XPATH, using = "//div[contains(text(),'Take-home for month')]//parent::div//input")
	public static WebElement txt_TakeHome_for_month;
	

	//Added on 10-Nov-2022 Start
	@FindBy (how=How.XPATH, using = "//div[contains(text(),'Take-home for month')]//parent::div//input")
	public static WebElement txt_TakeHome_for_month_Reloan;
	
	@FindBy (how=How.XPATH, using = "//div[contains(text(),'Take-home for month')]//parent::div//input")
	public static List<WebElement> txt_TakeHome_for_month_Reloan_List;
	
	//Added on 10-Nov-2022 End
	
	
	public void Employer_details_With_Frequency_Change(String payPeriodOrFrequency) throws Exception
	{
			if(payPeriodOrFrequency.equalsIgnoreCase("Same day every month"))
		{
			
				
			click(how_to_paid,"how_to_paid list "); 
			TestBase.bindreport(currentGlobalScenarioName, "how to paid3");	
			click(pay_frequency,"Same day every month");
			
			//click(Last_Pay_date,"Last Pay date1"); 
			Last_Pay_date.sendKeys(Keys.CONTROL + "a");
			Last_Pay_date.sendKeys(Keys.DELETE);
			EnterText(Last_Pay_date, getMapData.get("LastPayDate_SameDayMonthly"), "LastPayDate1");
			
			//click(Next_Pay_date,"Next Pay date2");
			Next_Pay_date.sendKeys(Keys.CONTROL + "a");
			Next_Pay_date.sendKeys(Keys.DELETE);
			EnterText(Next_Pay_date, getMapData.get("NextPayDate_SameDayMonthly"), "NextPayDate2");
			
			
			txt_Last_take_home_pay_cheque.sendKeys(Keys.CONTROL + "a");
			txt_Last_take_home_pay_cheque.sendKeys(Keys.DELETE);
			EnterText(txt_Last_take_home_pay_cheque, getMapData.get("LastNetPay_SameDayMonthly"), "net amount monthly1");
			
			txt_TakeHome_for_month.sendKeys(Keys.CONTROL + "a");
			txt_TakeHome_for_month.sendKeys(Keys.DELETE);
			EnterText(txt_TakeHome_for_month, getMapData.get("NextNetPay_SameDayMonthly"), "net amount monthly2");
			
			TestBase.bindreport(currentGlobalScenarioName, "employee details page");
			
			if(List_txt_PreviousPay.size()>0)
			{
				EnterText(pervious_netpay, getMapData.get("PreviousMonthPay"), "PreviousMonthPay");
			}
			
			TestBase.bindreport(currentGlobalScenarioName, "PayFrequency3");
		}
	click(next_button,"Next button page"); 	
	}
	
	
	public void Employer_details_With_Frequency_reloan(String payPeriodOrFrequency) throws Exception
	{
		
		Thread.sleep(3000);
		waitForElementToBeVisible(employee_type,"WaitVisibleOfemployeetype");
	
		if(payPeriodOrFrequency.equalsIgnoreCase("Same day every month"))
		{
			//Added on 10-Nov-2022 Start
			Thread.sleep(4000);
			if(txt_TakeHome_for_month_Reloan_List.size()>0)
			{
				txt_TakeHome_for_month_Reloan.sendKeys(Keys.CONTROL + "a");
				txt_TakeHome_for_month_Reloan.sendKeys(Keys.DELETE);
				EnterText(txt_TakeHome_for_month_Reloan, getMapData.get("LastNetPay"), "LastNetPay");
			}
			
			TestBase.bindreport(currentGlobalScenarioName, "PayAmount");
			//Added on 10-Nov-2022 End
			
		}
		if(payPeriodOrFrequency.equalsIgnoreCase("Twice a Month - otherwise"))
		{
			
			System.out.println("WRITE HERE for Twice a Month - otherwise");
			EnterText(txt_Cheque_Total1, getMapData.get("FirstChequeTotal"), "FirstChequeTotal");
			EnterText(txt_Cheque_Total2, getMapData.get("SecondChequeTotal"), "SecondChequeTotal");
			
			TestBase.bindreport(currentGlobalScenarioName, "PayFrequency4");
			
		}
		
		if(payPeriodOrFrequency.equalsIgnoreCase("Every 2 weeks"))
		{
			
			EnterText(txt_Cheque_Total1, getMapData.get("FirstChequeTotal"), "FirstDateChequeTotal");
			EnterText(txt_Cheque_Total2, getMapData.get("SecondChequeTotal"), "SecondDateChequeTotal");
			
			TestBase.bindreport(currentGlobalScenarioName, "PayFrequency4");
		}
	
	click(next_button,"Next button page"); 	
	}
	
	
	public void Employer_details_With_Frequency_reloan_Change_Primary(String payPeriodOrFrequency) throws Exception
	{
		
		Thread.sleep(3000);
		waitForElementToBeVisible(employee_type,"WaitVisibleOfemployeetype");
	
		if(payPeriodOrFrequency.equalsIgnoreCase("Same day every month"))
		{
			System.out.println("WRITE HERE");
		}
		if(payPeriodOrFrequency.equalsIgnoreCase("Twice a Month - otherwise"))
		{
			
			System.out.println("WRITE HERE");
			
		}
		
		if(payPeriodOrFrequency.equalsIgnoreCase("Every 2 weeks"))
		{
		
			click(how_to_paid,"how_to_paid list "); 
			TestBase.bindreport(currentGlobalScenarioName, "how to paid4");
			
			click(txt_Every2Week,"Every 2 weeks");
			
			//click(txt_LastPaydate_SemiWeekly,"Last Pay date");
			txt_LastPaydate_SemiWeekly.sendKeys(Keys.CONTROL + "a");
			txt_LastPaydate_SemiWeekly.sendKeys(Keys.DELETE);
			EnterText(txt_LastPaydate_SemiWeekly, getMapData.get("LastPayDate_biWeekly"), "LastPayDate_biWeekly");
			
			//click(txt_Nextpaydate_SemiWeekly,"Next Pay date");
			txt_Nextpaydate_SemiWeekly.sendKeys(Keys.CONTROL + "a");
			txt_Nextpaydate_SemiWeekly.sendKeys(Keys.DELETE);
			EnterText(txt_Nextpaydate_SemiWeekly, getMapData.get("NextPayDate_biWeekly"), "NextPayDate_biWeekly");
			
			txt_Last_take_home_pay_cheque_amount_SemiWeekly.sendKeys(Keys.CONTROL + "a");
			txt_Last_take_home_pay_cheque_amount_SemiWeekly.sendKeys(Keys.DELETE);
			EnterText(txt_Last_take_home_pay_cheque_amount_SemiWeekly, getMapData.get("LasttakehomePay_biWeekly"), "LasttakehomePay_biWeekly");
			
			txt_Cheque_Total1.sendKeys(Keys.CONTROL + "a");
			txt_Cheque_Total1.sendKeys(Keys.DELETE);
			EnterText(txt_Cheque_Total1, getMapData.get("FirstChequeTotal_biWeekly"), "FirstChequeTotal_biWeekly");
			
			txt_Cheque_Total2.sendKeys(Keys.CONTROL + "a");
			txt_Cheque_Total2.sendKeys(Keys.DELETE);
			EnterText(txt_Cheque_Total2, getMapData.get("SecondChequeTotal_biWeekly"), "SecondChequeTotal_biWeekly");
			
			TestBase.bindreport(currentGlobalScenarioName, "PayFrequency5");
			
			
			/*
			EnterText(txt_Cheque_Total1, getMapData.get("FirstChequeTotal"), "FirstChequeTotal");
			EnterText(txt_Cheque_Total2, getMapData.get("SecondChequeTotal"), "SecondChequeTotal");
			TestBase.bindreport(currentGlobalScenarioName, "PayFrequency");
			*/
		}
	
	click(next_button,"Next button page"); 	
	}
	
	
	
	public void existing_employee_details() throws Exception
	{
		
		
		if(getMapData.get("Emp_Name").equalsIgnoreCase("N/A"))
		{

		}
		else
		{
			employee_name.sendKeys(Keys.CONTROL + "a");
			employee_name.sendKeys(Keys.DELETE);
			EnterText(employee_name,getMapData.get("Emp_Name"),"Emp name");
		}
		

		if(getMapData.get("Income_source").equalsIgnoreCase("Full Time Employed"))
		{
			click(full_typeemploye,"Full time");
		} 
		net_amount.sendKeys(Keys.CONTROL + "a");
		net_amount.sendKeys(Keys.DELETE);
		EnterText(net_amount, getMapData.get("LastNetPay"), "net amount");
		if(List_txt_PreviousPay.size()>0)
		{
			EnterText(pervious_netpay, getMapData.get("PreviousMonthPay"), "PreviousMonthPay");
		}
		
		else
		{
		
		click(next_button,"Next button page"); 
		}
		click(next_button,"Next button page"); 
	}
	
	//Added on 12-Aug-2022 Start
	public void existing_customer_details_new_UI() throws Exception
	{
		waitForElementToBeVisible(header_AnyChangesToYourInformation, "WaitAnyChangesToYourInformation");
		VerifyText_For_PageCaption(header_page_AnyChangesToYourInformation, "Any changes to your information?", "Existing Customer Info Page, Hence Passed");
		
		if(getMapData.get("Rent_Yes_No").equalsIgnoreCase("Yes"))
		{
			click(btn_Rent_Yes, "Rent select yes");
			Thread.sleep(2000);
			txt_Rent.sendKeys(Keys.CONTROL + "a");
			txt_Rent.sendKeys(Keys.DELETE);
			EnterText(txt_Rent, getMapData.get("Rent_Contribution") , "Rent amount" );
		}
		else if(getMapData.get("Rent_Yes_No").equalsIgnoreCase("No"))
		{
			click(btn_Rent_No,"Rent no");
			Thread.sleep(10000); //Added on 03-Nov-2022 for QAC Sync
		}
		txt_Takehomenetpay.sendKeys(Keys.CONTROL + "a");
		txt_Takehomenetpay.sendKeys(Keys.DELETE);
		EnterText(txt_Takehomenetpay, getMapData.get("PreviousMonthPay"), "PreviousMonthPay");
		waitForElementToBeClickable(btn_ConfirmAndContinue, "WaitCinformAndContinue");
		click(btn_ConfirmAndContinue, "clkConfirmAndContinue");
	}
	//Added on 12-Aug-2022 End
	
	//Added on 21-Nov-2022 Start
	
	@FindBy (how=How.XPATH, using = "//div[text()='Additional Employer']//parent::div//img")
	public static WebElement DownArrow_AdditionalEmployer;
	
	public void existing_customer_details_new_UI_Monthly_Weekly() throws Exception
	{
		waitForElementToBeVisible(header_AnyChangesToYourInformation, "WaitAnyChangesToYourInformation");
		VerifyText_For_PageCaption(header_page_AnyChangesToYourInformation, "Any changes to your information?", "Existing Customer Info Page, Hence Passed");
		
		if(getMapData.get("Rent_Yes_No").equalsIgnoreCase("Yes"))
		{
			click(btn_Rent_Yes, "Rent select yes");
			Thread.sleep(2000);
			txt_Rent.sendKeys(Keys.CONTROL + "a");
			txt_Rent.sendKeys(Keys.DELETE);
			EnterText(txt_Rent, getMapData.get("Rent_Contribution") , "Rent amount" );
		}
		else if(getMapData.get("Rent_Yes_No").equalsIgnoreCase("No"))
		{
			click(btn_Rent_No,"Rent no");
			Thread.sleep(10000); //Added on 03-Nov-2022 for QAC Sync
		}
		txt_Takehomenetpay.sendKeys(Keys.CONTROL + "a");
		txt_Takehomenetpay.sendKeys(Keys.DELETE);
		EnterText(txt_Takehomenetpay, getMapData.get("PreviousMonthPay"), "PreviousMonthPay");
		//waitForElementToBeClickable(btn_ConfirmAndContinue, "WaitCinformAndContinue"); //Commented on 21-Nov-2022
		//click(btn_ConfirmAndContinue, "clkConfirmAndContinue"); //Commented on 21-Nov-2022
		
		waitForElementToBeClickable(DownArrow_AdditionalEmployer, "WaitDownArrow");
		click(DownArrow_AdditionalEmployer, "clkDownArrow");
		
		//Added on 21-Nov-2022 Start
		EnterText(txt_cheque_total_weekly_11, getMapData.get("FirstChequeTotalWeekly1"), "FirstChequeTotalWeekly1");
		EnterText(txt_cheque_total_weekly_12, getMapData.get("FirstChequeTotalWeekly2"), "FirstChequeTotalWeekly2");
		EnterText(txt_cheque_total_weekly_13, getMapData.get("FirstChequeTotalWeekly3"), "FirstChequeTotalWeekly3");
		EnterText(txt_cheque_total_weekly_14, getMapData.get("FirstChequeTotalWeekly4"), "FirstChequeTotalWeekly4");
		//Added on 21-Nov-2022 End
		TestBase.bindreport(currentGlobalScenarioName, "PayFrequency_2");
	
		click(btn_ConfirmAndContinue, "clkConfirmAndContinue");
		
	}
	
	//Added on 21-Nov-2022 End
	
	
	
	//Added on 15-Oct-2022 Start
	
	
	@FindBy (how=How.XPATH, using = "//span[text()='+ Add employer']")
	public static WebElement link_AddEployer;
	
    @FindBy (how=How.XPATH, using = "//div[text()='Employers Phone']//parent::div//input")
	public static WebElement txt_Employers_Phone;
	
	@FindBy (how=How.XPATH, using = "//div[text()='How often are you paid?*']//parent::div//button")
	public static WebElement txt_How_often_are_you_paid;
	
	@FindBy (how=How.XPATH, using = "//div[text()='Last pay date*']//parent::div//input")
	public static WebElement txt_LastPayDate_AddEmployer;
	
	@FindBy (how=How.XPATH, using = "//div[text()='Next pay date*']//parent::div//input")
	public static WebElement txt_NextPayDate_AddEmployer;
	
	@FindBy (how=How.XPATH, using = "//div[text()='Last take-home pay cheque amount*']//parent::div//input")
	public static WebElement txt_Last_takehome_pay_cheque_amount_AddEmployer;
	
	//SAMEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
	//--(//button[@type='button'])[1]
	//button[normalize-space()='Full Time Employed']
	//input[@class='mm-input mm-gs-input']
	//button[normalize-space()='Same day every month']
	//Added on 15-Oct-2022 End
	
	
	public void existing_customer_details_new_UI_Monthly_SK_Province() throws Exception
	{
		waitForElementToBeVisible(header_AnyChangesToYourInformation, "WaitAnyChangesToYourInformation");
		VerifyText_For_PageCaption(header_page_AnyChangesToYourInformation, "Any changes to your information?", "Existing Customer Info Page, Hence Passed");
		
		if(getMapData.get("Rent_Yes_No").equalsIgnoreCase("Yes"))
		{
			click(btn_Rent_Yes, "Rent select yes");
			Thread.sleep(2000);
			txt_Rent.sendKeys(Keys.CONTROL + "a");
			txt_Rent.sendKeys(Keys.DELETE);
			EnterText(txt_Rent, getMapData.get("Rent_Contribution") , "Rent amount" );
		}
		else if(getMapData.get("Rent_Yes_No").equalsIgnoreCase("No"))
		{
			click(btn_Rent_No,"Rent no");
		}
		
		click(link_AddEployer, "AddEmployer");
		
		Thread.sleep(3000);
		waitForElementToBeVisible(employee_type,"WaitVisibleOfemployeetype");
		Thread.sleep(2000); //Added on 09-Aug-2022
		waitForElementToBeClickable(employee_type, "WaitEmployeeType"); //Added on 09-Aug-2022
		//scrollIntoView(employee_type); //Added on 31-Oct-2022
		Thread.sleep(2000); //Added on 31-Oct-2022
		click(employee_type,"employee_type"); 
		
		if(getMapData.get("Income_source").equalsIgnoreCase("Full Time Employed"))
		{
			click(full_typeemploye,"Full time");
		} 
		else if (getMapData.get("Income_source").equalsIgnoreCase("Others"))
		{
			click(dd_income_Other,"others");
		}
		else if (getMapData.get("Income_source").equalsIgnoreCase("Old Age Security (OAS)"))
		{
			click(btn_OldAgeSecurity,"Old Age Security");
		}
		
		EnterText(employee_name, getMapData.get("Emp_Name"), "employee name");
		TestBase.bindreport(currentGlobalScenarioName, "NMM_EmployeerName");
		
		
		EnterText(txt_Employers_Phone, getMapData.get("Emp_Phone"), "employee phone 1");	
		
		click(txt_How_often_are_you_paid,"how_to_paid list employer "); 
		TestBase.bindreport(currentGlobalScenarioName, "how to paid1 employer");
		click(pay_frequency,"Same day every month"); 
		
		click(txt_LastPayDate_AddEmployer,"Last Pay date EMP"); 
		EnterText(txt_LastPayDate_AddEmployer, getMapData.get("LastPayDate"), "LastPayDateEMP");
		
		click(txt_NextPayDate_AddEmployer,"Next Pay dateEMP"); 
		EnterText(txt_NextPayDate_AddEmployer, getMapData.get("NextPayDate"), "NextPayDateEMP");
		
		EnterText(txt_Last_takehome_pay_cheque_amount_AddEmployer, getMapData.get("LastNetPay"), "net amountEMP");
		TestBase.bindreport(currentGlobalScenarioName, "employee details page EMP");
		
		waitForElementToBeClickable(btn_ConfirmAndContinue, "WaitCinformAndContinue");
		click(btn_ConfirmAndContinue, "clkConfirmAndContinue");
		
	}
	
	//Added on 16-Oct-2022 Start
	public void existing_customer_details_new_UI_Monthly_Debt_ratio_does_not_fall_in_the_valid_range() throws Exception
	{
		waitForElementToBeVisible(header_AnyChangesToYourInformation, "WaitAnyChangesToYourInformation");
		VerifyText_For_PageCaption(header_page_AnyChangesToYourInformation, "Any changes to your information?", "Existing Customer Info Page, Hence Passed");
		
		if(getMapData.get("Rent_Yes_No_Reloan").equalsIgnoreCase("Yes"))
		{
			click(btn_Rent_Yes, "Rent select yes");
			Thread.sleep(2000);
			txt_Rent.sendKeys(Keys.CONTROL + "a");
			txt_Rent.sendKeys(Keys.DELETE);
			EnterText(txt_Rent, getMapData.get("Rent_Contribution_Reloan") , "Rent amount" );
		}
		else if(getMapData.get("Rent_Yes_No_Reloan").equalsIgnoreCase("No"))
		{
			click(btn_Rent_No,"Rent no");
		}
		
		//Added on 15-Oct-2022 Start
		Thread.sleep(2000);
		if(txt_Last_takehomepay_LISTs.size() > 0)
		{
			txt_Last_takehomepay.sendKeys(Keys.CONTROL + "a");
			txt_Last_takehomepay.sendKeys(Keys.DELETE);
			EnterText(txt_Last_takehomepay, getMapData.get("PreviousMonthPay"), "PreviousMonthPay");
		}
		//Added on 15-Oct-2022 End
		
		//Added on 15-Oct-2022 Start
		
		Thread.sleep(2000);
		if(txt_Takehomenetpay_LISTs.size() > 0)
		{
			txt_Takehomenetpay.sendKeys(Keys.CONTROL + "a");
			txt_Takehomenetpay.sendKeys(Keys.DELETE);
			EnterText(txt_Takehomenetpay, getMapData.get("LastNetPay"), "LastNetPay");
		}
		//Added on 15-Oct-2022 End
		
		//Commented on 15-Oct-2022 Start
		/*
		txt_Last_takehomepay.sendKeys(Keys.CONTROL + "a");
		txt_Last_takehomepay.sendKeys(Keys.DELETE);
		EnterText(txt_Last_takehomepay, getMapData.get("PreviousMonthPay"), "PreviousMonthPay");
		*/
		//Commented on 15-Oct-2022 End
		waitForElementToBeClickable(btn_ConfirmAndContinue, "WaitCinformAndContinue");
		click(btn_ConfirmAndContinue, "clkConfirmAndContinue");
		
	}
	//Added on 16-Oct-2022 End
	
	//Added on 11-Oct-202 Start
		public void existing_customer_details_new_UI_Monthly() throws Exception
		{
			waitForElementToBeVisible(header_AnyChangesToYourInformation, "WaitAnyChangesToYourInformation");
			VerifyText_For_PageCaption(header_page_AnyChangesToYourInformation, "Any changes to your information?", "Existing Customer Info Page, Hence Passed");
			
			if(getMapData.get("Rent_Yes_No").equalsIgnoreCase("Yes"))
			{
				click(btn_Rent_Yes, "Rent select yes");
				Thread.sleep(2000);
				txt_Rent.sendKeys(Keys.CONTROL + "a");
				txt_Rent.sendKeys(Keys.DELETE);
				EnterText(txt_Rent, getMapData.get("Rent_Contribution") , "Rent amount" );
			}
			else if(getMapData.get("Rent_Yes_No").equalsIgnoreCase("No"))
			{
				click(btn_Rent_No,"Rent no");
			}
			
			//Added on 15-Oct-2022 Start
			Thread.sleep(2000);
			if(txt_Last_takehomepay_LISTs.size() > 0)
			{
				txt_Last_takehomepay.sendKeys(Keys.CONTROL + "a");
				txt_Last_takehomepay.sendKeys(Keys.DELETE);
				EnterText(txt_Last_takehomepay, getMapData.get("PreviousMonthPay"), "PreviousMonthPay");
			}
			//Added on 15-Oct-2022 End
			
			//Commented on 15-Oct-2022 Start
			/*
			txt_Last_takehomepay.sendKeys(Keys.CONTROL + "a");
			txt_Last_takehomepay.sendKeys(Keys.DELETE);
			EnterText(txt_Last_takehomepay, getMapData.get("PreviousMonthPay"), "PreviousMonthPay");
			*/
			//Commented on 15-Oct-2022 End
			waitForElementToBeClickable(btn_ConfirmAndContinue, "WaitCinformAndContinue");
			click(btn_ConfirmAndContinue, "clkConfirmAndContinue");
		}
		//Added on 11-Oct-202 Start
	
	public void IncomeDetails_WithFlinks() throws Exception
	{
		Thread.sleep(3000);
		//comment 19 july 2022 start
		waitForElementToBeVisible(getText_PrimaryIncome, "Primary income");
		//comment 19 july 2022 start
		  //Flinks_PrimaryIncome =
		  //getText_PrimaryIncome.getAttribute(Flinks_PrimaryIncome);
		//comment 19 july 2022 end
		Thread.sleep(3000);
		  Flinks_PrimaryIncome =  getText_PrimaryIncome.getText();
		  
		  System.out.println("PrimaryIncome "+Flinks_PrimaryIncome);
		  waitForElementToBeVisible(txt_EmpName, "Emp Name"); 
	
		  Flinks_Emp_Name =  txt_EmpName.getAttribute("value");
		  System.out.println("Emp_Name "+Flinks_Emp_Name);
		  //comment 19 july 2022 end
		

		Flinks_PayFreq = getText_PayFreq.getText();
		System.out.println("payfrequency "+Flinks_PayFreq);
		Flinks_LastPayDate = txt_LastPayDay.getAttribute("Value");
		System.out.println("last paydate::"+Flinks_LastPayDate);
		Flinks_NextPayDate = txt_NextPayDay.getAttribute("Value");
		System.out.println("Next pay date::"+Flinks_NextPayDate);
		Flinks_LastPayAmount = txt_LastNetPayGetText.getAttribute("value");
		System.out.println("Last month payamount "+Flinks_LastPayAmount);
		if(List_txt_PreviousPay.size()>0)
		{
			Flinks_LastMonthPayAmnt = txt_PreviousPay.getAttribute("value");
			 System.out.println("Last month payamount "+Flinks_LastMonthPayAmnt);
		}
		
		click(btn_Next,"Next");
	}


	}
