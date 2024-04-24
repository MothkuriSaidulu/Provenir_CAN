package online.TestRunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;


@RunWith(driver.CustomRunner.class)

@CucumberOptions(features = {
		
		
		
		//06-Dec-2022 12/06 Release Execution
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC31_Verify Loan decission is denied when PR43 grt than 1 and PR11 grtr than $500 and PR12 less than 12 months.feature", //OK GOOD VERIFIED - READY3 
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC32_Verify Loan decission is denied when PR43 grt than 1 and PR11 grtr than $500 and PR12 grater than 12 months.feature", //OK GOOD VERIFIED - READY3		
		//--ReexecuteLast "C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC60_Retail_SPL_Verify Loan amount get recalculated when Loan Amount is changed for Pay Frequency Bi-Monthly.feature", //OK GOOD VERIFIED - READY3
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Retail_TC45_ON_Verify whether user is able to generate  EPP loan when two spl loan closed past within 63 days.feature" //--OK GOOD2 //OK GOOD VERIFIED - READY3
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Retail_TC29_ON_IL_New loan -Verify the loan term 12M is not offered for Monthly frequency.feature", //OK GOOD VERIFIED - READY3 
		
		//Set 2
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC30_Verify Loan decision is denied when customer is Bankruptcy.feature", //OK GOOD VERIFIED - READY3
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC49_CAN BC_Online_verify netpay calculation , loan amount , loan fee, total loan amount with loan term for Multiple employer with different frequency.feature", //OK GOOD VERIFIED - READY3
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Retail_TC56_AB_Verify the EPP loan term duration calculation for New customer with Monthly and weekly frequency.feature", //OK GOOD VERIFIED - READY3

		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC26_Verify_Loan_decission_is_denied_when_Debt_ratio_does_not_fall_in_the_valid_range_allowed.feature", ///OK GOOD VERIFIED - READY3
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC28_Verify Loan decision is denied when customer has outstanding loan.feature", //OK GOOD VERIFIED - READY3
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC42_Verify_whether_system_allowed_as_much_as_top_up.feature", //OK GOOD VERIFIED - DEMO READY3
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC63_Verify whether system is displaying Cool off button when customer applies for another loan within 7 business days of repaying the last loan through EFT.feature", //OK GOOD VERIFIED - DEMO READY3
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC34_CAN_BC_IL_Online_Verify the loan term for DisengagedExisting when loan amount less than 1000.feature", //OK GOOD VERIFIED - DEMO READY3
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC16_AB_Flinks_Online_Verify whether system allow new customer for  SPL Downsell when IL Loan Denial.feature" //OK GOOD VERIFIED - DEMO READY3		
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Retail_TC23_AB_Existing Engage_Verify Classification of Existing engage Loan when customer has fully paid-off SPL loan within last 6 months.feature", //OK GOOD VERIFIED - DEMO READY3
		
		
		//PHASE 2 - Downsell, EPP etc
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC04_New_IL_Refinance_flink_optout_Parent_flink_in.feature" //--OK GOOD flinks non flinks 5k
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC04_New_IL_flinks.feature" //--OK GOOD flinks non flinks 5k
		
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Retail_TC45_ON_Verify whether user is able to generate  EPP loan when two spl loan closed past within 63 days.feature" //--OK GOOD2
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC16_AB_Flinks_Online_Verify whether system allow new customer for  SPL Downsell when IL Loan Denial.feature" //--OK GOOD2
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC17_AB_NonFlinks_Verify whether system should not  allow new customer for SPL Downsell.feature" //--OK GOOD2
		//ON - New - IL
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Retail_TC29_ON_IL_New loan -Verify the loan term 12M is not offered for Monthly frequency.feature", //--OK GOOD2
	
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC49_CAN BC_Online_verify netpay calculation , loan amount , loan fee, total loan amount with loan term for Multiple employer with different frequency.feature", //--OK GOOD2
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Retail_TC56_AB_Verify the EPP loan term duration calculation for New customer with Monthly and weekly frequency.feature", //--OK GOOD2
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC61_ON_Verify the EPP Terms pay frequency for customer with Bi-Monthly frequency.feature", //--OK GOOD2
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Retail_TC59_BC_Verify the EPP Terms pay frequency for customer with Monthly frequency.feature", //--OK GOOD2
		
		//ADD TWO
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC30_ON_Verify the loan term 12M is not offered for Early advance1 (Weekly Non primary ) and (Monthly primary) frequency.feature", //OK GOOD2
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Retail_TC23_AB_Existing Engage_Verify Classification of Existing engage Loan when customer has fully paid-off SPL loan within last 6 months.feature", //OK GOOD2

		
		
		//QAC - 08-Nov-2022 Release
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC01_New_IL_Approved.feature", //OK GOOD VERIFIED - DEMO READY1
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC02_New_SPL_approved.feature", //OK GOOD VERIFIED - DEMO READY1
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC59_SPL_Verify the Loan amount and fee calculations for New Customer with Weekly Frequency.feature", //OK GOOD VERIFIED - DEMO READY1
		
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC04_Verify loan decission for Refinance loan with Decile6.feature", //OK GOOD VERIFIED - DEMO READY1 - Half Manula due to time contstaint
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC01_Verify loan decission for First loan with Decile1.feature", //OK GOOD VERIFIED - DEMO READY1
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC02_Verify loan decission for parent loan decile5 and Reloan loan with Decile6.feature", //OK GOOD VERIFIED - DEMO READY   -- Re-Loan getting netPay 2 fields - need investigate
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC16_Verify_loan_decission_for_New_loan_as_Decile_2_And_Reloan_loan_with_Decile_8.feature",//OK GOOD VERIFIED - DEMO READY1
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC06_Verify loan decission for First loan with Decile6.feature", //OK GOOD VERIFIED - DEMO READY1
		
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC31_Verify Loan decission is denied when PR43 grt than 1 and PR11 grtr than $500 and PR12 less than 12 months.feature", //OK GOOD VERIFIED - DEMO READY1
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC32_Verify Loan decission is denied when PR43 grt than 1 and PR11 grtr than $500 and PR12 grater than 12 months.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC53_SPL_Verify the Net Pay Calculation for existing Customer Monthly Frequency.feature", //OK GOOD VERIFIED - DEMO READY1
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC55d_SPL_Verify the Net Pay Calculation for Existing Customer Bi-Weekly Frequency.feature", //OK GOOD VERIFIED - DEMO READY1
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC60_Retail_SPL_Verify Loan amount get recalculated when Loan Amount is changed for Pay Frequency Bi-Monthly.feature", //OK GOOD VERIFIED - DEMO READY1
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC61_Web_CAN_Verify Loan amount get recalculated when Loan Amount is changed for Pay Frequency Monthly.feature", //OK GOOD VERIFIED - DEMO READY1
		//----------------"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC13_Verify loan decission for Refinance loan with Decile3.feature", //OK GOOD VERIFIED - DEMO READY DB ISSUE HENCE Manually EA thater than refi
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC42_Verify_whether_system_allowed_as_much_as_top_up.feature", //OK GOOD VERIFIED - DEMO READY1
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC47_Online_Verify_the_early_advance_on_re_loan.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC03_Verify loan decission for Early Advance loan with Decile3.feature", //OK GOOD VERIFIED - DEMO READY1
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC13_Verify loan decission for Refinance loan with Decile3.feature", //OK GOOD VERIFIED - DEMO READY DB ISSUE HENCE Manually EA thater than refi
		
		
		//26-OCT-2022 Release START
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC04_New_IL_Refinance_flink_optout_Parent_flink_in.feature", OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC05_New_IL_Refinance_flink_out_Review.feature", OK GOOD VERIFIED - DEMO READY
		//--Refi -Review---"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC06_IL_Refinance_flink_prove_data.feature",
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC08_New_IL_Refinance_flink_out_EarlyAdvance.feature", OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC03_Verify loan decission for Early Advance loan with Decile3.feature", OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC04_Verify loan decission for Refinance loan with Decile6.feature", OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC08_Verify whether early advance is not applicable when parent loan amount is 1000$ in MB.feature", OK GOOD VERIFIED - DEMO READY 
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC12_Verify loan decision for Early Advance loan with Decile2.feature", OK GOOD VERIFIED - DEMO READY (1 rahter 2)
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC13_Verify loan decission for Refinance loan with Decile3.feature", OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC18_Verify loan decision for Refinance loan with Decile2.feature", OK GOOD VERIFIED - DEMO READY (1 rahter 2)
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC20_Verify_Early_advance_loan_should_get_decline_if_parent_loan_decile_is_less_then_early_advance_loan_decile.feature", OK GOOD VERIFIED - DEMO READY (7 rather 8)
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC37_Verify Early Advance loan decision is denied when Early Advance application decile grater  than Parent loan decile.feature", OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC07_CAN_ON_Mobile_Verify whether down sell is happening on re-loan when primary loan is less than 1000$.feature",
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC43_Verify_Refinance_functionality_after_Early_Advance_done_as_many_as_done_for_a_IL.feature", OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC44_Verify_top_up_functionality_on_a_refinance_loan.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC49_verify_the_3rd_early_advance_is_displaying_when_customer_is_already_having_2_early_advance.feature", //OK GOOD VERIFIED - DEMO READY
		
		//19-OCT-2022
		     //"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC33_CAN_ON_IL_Retail_Verify the loan term for New Customer when loan amount less than 1000.feature",
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC03_Existing_IL_Reloan_Approved.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC02_Verify loan decission for parent loan decile5 and Reloan loan with Decile6.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC07_Verify loan decission for parent loan with decile8  Reloan loan with Decile6 and missing fico score.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC11_Verify loan decission for Parent Loan with decile8 and Reloan loan with Decile1.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC16_Verify_loan_decission_for_New_loan_as_Decile_2_And_Reloan_loan_with_Decile_8.feature",//OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC28_Verify Loan decision is denied when customer has outstanding loan.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC47_Online_Verify_the_early_advance_on_re_loan.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC53_SPL_Verify the Net Pay Calculation for existing Customer Monthly Frequency.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC55_SPL_Verify the Net Pay Calculation for Existing Customer Bi-Weekly Frequency.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC63_Verify whether system is displaying Cool off button when customer applies for another loan within 7 business days of repaying the last loan through EFT.feature", //OK GOOD VERIFIED - DEMO READY
		
		//ON-IL
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC01_Verify loan decission for First loan with Decile1.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC06_Verify loan decission for First loan with Decile6.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC10_Verify loan decission for New loan with Decile10.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC15_Verify loan decission for First loan with Decile5.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC21_Verify_Loan_decission_is_denied_when_employee_is_NMM_or_related.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC24_Verify_Loan_decission_is_denied_when_annual_income_less_tha_1k.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC26_Verify_Loan_decission_is_denied_when_Debt_ratio_does_not_fall_in_the_valid_range_allowed.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC30_Verify Loan decision is denied when customer is Bankruptcy.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC31_Verify Loan decission is denied when PR43 grt than 1 and PR11 grtr than $500 and PR12 less than 12 months.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC32_Verify Loan decission is denied when PR43 grt than 1 and PR11 grtr than $500 and PR12 grater than 12 months.feature", //OK GOOD VERIFIED - DEMO READY
		//20-Oct-2022
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC33_Verify Loan decission is dened when customer found in Fraud check with Address_phone_SSN.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC42_Verify_whether_system_allowed_as_much_as_top_up.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC50_SPL_Verify whether denial message is displayed to  CSR when knock off rules are passed.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC54_SPL_Verify the Net Pay Calculation for New Customer Bi-Monthly Frequency.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC56_SPL_Verify the loan term duration calculation for New customer with Monthly frequency.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC57_SPL_Verify the loan term duration calculation for existing customer with Bi Weekly frequency when CSR change the loan amount and recalculate..feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC58_Verify that the customer is able to qualify for SPL Loan or not by validating all knock out rule.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC59_SPL_Verify the Loan amount and fee calculations for New Customer with Weekly Frequency.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC60_Retail_SPL_Verify Loan amount get recalculated when Loan Amount is changed for Pay Frequency Bi-Monthly.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC61_Web_CAN_Verify Loan amount get recalculated when Loan Amount is changed for Pay Frequency Monthly.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC62_Verify Risk Assessed for New Customer with Monthly Frequency_Online.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC51_SPL_Verify the message displayed to the CSR when failure response is received from the provenir when the applicant age is 17 years old.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC01_New_IL_Approved.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC02_New_SPL_approved.feature", //OK GOOD VERIFIED - DEMO READY
		//----"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC07__New_IL_TopUp_PayOff.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC07__New_IL_TopUp_PayOff.feature", //OK GOOD VERIFIED - DEMO READY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC06_IL_Refinance_flink_prove_data.feature", //OK GOOD VERIFIED - DEMO READY
		//26-OCT-2022 Release END
		
		
		//21-Oct-2022 AD HOC $1 change scenario
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC02_New_SPL_approved.feature", //OK GOOD VERIFIED - DEMO READY
		
		
		
		
		//PHASE 2 MULTI PROVINCE WORK
		//ON - New - IL
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC01_Verify loan decission for First loan with Decile1.feature",
		//AB - Re-loan - IL
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC02_Verify loan decission for parent loan decile5 and Reloan loan with Decile6.feature",
		//NL - Re-fi - IL
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC05_New_IL_Refinance_flink_out_Review.feature",
		//BC - EA - IL
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC03_Verify loan decission for Early Advance loan with Decile3.feature",
		
		//12-Oct-2022 
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC33_CAN_ON_IL_Retail_Verify the loan term for New Customer when loan amount less than 1000.feature",
	
		//13-Oct-2022
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC34_CAN_BC_IL_Online_Verify the loan term for DisengagedExisting when loan amount less than 1000.feature", OK GOOD DONE
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC35_CAN_NS_IL_Retail_Verify the loan term for second reloan when loan amount less than 1000.feature", OK GOOD DONE
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC36_CAN_SK_IL_Online_Verify the loan term for second reloan when loan amount less than 1000.feature", //OK GOOD DONE
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC37_CAN_AB_IL_Retail_Verify the loan term for second Refinance when loan amount less than 1000.feature", 
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC41_CAN_NL_IL_Retail_Verify system should not allow early advance when parent  loan amount less than 1000.feature", OK GOOD
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC07_CAN_ON_Mobile_Verify whether down sell is happening on re-loan when primary loan is less than 1000$.feature", 

		"C:\\Users\\1003413\\eclipse-Moneymart\\Provenir_CAN\\Provenir_CAN\\features_Revised\\PRO_CAN_Online_TC05_New_Flinks_IL_Approved.feature"
},

dryRun = false, 
glue = {"online.StepDefinitions"},
		plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json", "html:target/cucumber-report",
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
				"junit:target/cukes/junit.xml" }, monochrome = true)

public class Runner{
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("config/report.xml"));

	}
	
	

}

