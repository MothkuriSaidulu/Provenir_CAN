package online.TestRunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;


@RunWith(driver.CustomRunner.class)

@CucumberOptions(features = {
		
		
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC01_Verify loan decission for First loan with Decile1.feature",
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC05_New_IL_Refinance_flink_out_Review.feature",
		"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC02_Verify loan decission for parent loan decile5 and Reloan loan with Decile6.feature",		
		
		//PHASE 2 MULTI PROVINCE WORK
		//ON - New - IL
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC01_Verify loan decission for First loan with Decile1.feature",
		//AB - Re-loan - IL
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC02_Verify loan decission for parent loan decile5 and Reloan loan with Decile6.feature",
		//NL - Re-fi - IL
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC05_New_IL_Refinance_flink_out_Review.feature",
		//BC - EA - IL
		//"C:\\MM\\Online_Proviner_MM\\featuresPhase2\\PRO_CAN_Online_TC03_Verify loan decission for Early Advance loan with Decile3.feature",
		
		
		//04-Oct-2022 PHASE 1 Priority 2 Started 
		//--------------"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC59_SPL_Verify the Loan amount and fee calculations for New Customer with Weekly Frequency.feature",
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC11_Verify loan decission for Parent Loan with decile8 and Reloan loan with Decile1.feature", OK GOOD 
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC28_Verify Loan decision is denied when customer has outstanding loan.feature", OK GOOD
		
		
		//06-Oct-2022 PHASE 1 P2 Continue
		//---NA----"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC35_Verify Top up loan decision is review when income is less than parent loan.feature",
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC60_Retail_SPL_Verify Loan amount get recalculated when Loan Amount is changed for Pay Frequency Bi-Monthly.feature", //OK GOOD
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC61_Web_CAN_Verify Loan amount get recalculated when Loan Amount is changed for Pay Frequency Monthly.feature", OK GOOD
		 
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC60_Retail_SPL_Verify Loan amount get recalculated when Loan Amount is changed for Pay Frequency Bi-Monthly.feature", //OK GOOD
		
		//07-Oct-2022 PHASE 1 P2 Continue
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC31_Verify Loan decission is denied when PR43 grt than 1 and PR11 grtr than $500 and PR12 less than 12 months.feature", //OK GOOD
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC32_Verify Loan decission is denied when PR43 grt than 1 and PR11 grtr than $500 and PR12 grater than 12 months.feature", //OK GOOD
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC59_SPL_Verify the Loan amount and fee calculations for New Customer with Weekly Frequency.feature", //OK GOOD Considering Bi-Monthly rather than weekly 
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC62_Verify Risk Assessed for New Customer with Monthly Frequency_Online.feature", //OK GOOD
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC30_Verify Loan decision is denied when customer is Bankruptcy.feature", //OK GOOD
		
		
		//10-Oct-2022
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC63_Verify whether system is displaying Cool off button when customer applies for another loan within 7 business days of repaying the last loan through EFT.feature", OK GOOD
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC64_Online_Verify response file is displaying 'Proof Of Repayment' when customer applies for another loan after 4 days of making payment on Last Loan through EFT.feature",
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC33_Verify Loan decission is dened when customer found in Fraud check with Address_phone_SSN.feature", OK GOOD
		
		
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC01_New_IL_Approved.feature", //OK GOOD
		
		
		//01-Oct-2022 Regression Mini Regression START
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC01_New_IL_Approved.feature", //OK GOOD
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC02_New_SPL_approved.feature", //OK DONE
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC03_Existing_IL_Reloan_Approved.feature", //OK GOOD after JSY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC05_New_IL_Refinance_flink_out.feature", //OK DONE
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC12_Verify loan decision for Early Advance loan with Decile2.feature", //OK DONE
		
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC13_Verify loan decission for Refinance loan with Decile3.feature", //OK DONE
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC03_Verify loan decission for Early Advance loan with Decile3.feature", //OK DONE
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC07__New_IL_TopUp_PayOff.feature", //OK DONE
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC55_SPL_Verify the Net Pay Calculation for Existing Customer Bi-Weekly Frequency.feature", //OK DONE
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC07_Verify loan decission for parent loan with decile8  Reloan loan with Decile6 and missing fico score.feature", //OK DONE
		//01-Oct-2022 Regression Mini Regression END
		
		//30-Sept-2022 (PReVIEWC) - TEST AGAIN
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC01_New_IL_Approved.feature", //OK GOOD
		
		
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC59_SPL_Verify the Loan amount and fee calculations for New Customer with Weekly Frequency.feature", //OK DONE
		
		
		//24-Sept-2022
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC01_New_IL_Approved.feature", //OK GOOD
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC03_Existing_IL_Reloan_Approved.feature", //OK GOOD after JSY
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC05_New_IL_Refinance_flink_out.feature", //OK DONE
	    //25-Sept-2022
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC08_New_IL_Refinance_flink_out_EarlyAdvance.feature", //OK DONE
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC02_New_SPL_approved.feature", //OK DONE
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC07__New_IL_TopUp_PayOff.feature", //OK DONE
		
		//NEW
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC01_Verify loan decission for First loan with Decile1.feature", //OK DONE
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC06_Verify loan decission for First loan with Decile6.feature", //OK DONE
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC10_Verify loan decission for New loan with Decile10.feature", //OK DONE
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC15_Verify loan decission for First loan with Decile5.feature", //OK DONE
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC24_Verify_Loan_decission_is_denied_when_annual_income_less_tha_1k.feature", //OK DONE
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC26_Verify_Loan_decission_is_denied_when_Debt_ratio_does_not_fall_in_the_valid_range_allowed.feature", //OK DONE
		
		// RELAON
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC02_Verify loan decission for parent loan decile5 and Reloan loan with Decile6.feature", //OK DONE
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC07_Verify loan decission for parent loan with decile8  Reloan loan with Decile6 and missing fico score.feature", //OK DONE
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC16_Verify_loan_decission_for_New_loan_as_Decile_2_And_Reloan_loan_with_Decile_8.feature", //OK DONE
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC47_Online_Verify_the_early_advance_on_re_loan.feature", //OK DONE
		
		//26-Sept-2022
		//REFI
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC04_Verify loan decission for Refinance loan with Decile6.feature", //OK DONE
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC13_Verify loan decission for Refinance loan with Decile3.feature", //OK DONE
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC18_Verify loan decision for Refinance loan with Decile2.feature", //OK DONE
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC44_Verify_top_up_functionality_on_a_refinance_loan.feature", //OK DONE
		
		
		//SPL
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC50_SPL_Verify whether denial message is displayed to  CSR when knock off rules are passed.feature", //OK DONE
		//---------------------------"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC51_SPL_Verify the message displayed to the CSR when failure response is received from the provenir when the applicant age is 17 years old.feature", //OK DONE
		
		//27-Sept-2022 SPL
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC53_SPL_Verify the Net Pay Calculation for existing Customer Monthly Frequency.feature", //OK DONE 
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC54_SPL_Verify the Net Pay Calculation for New Customer Bi-Monthly Frequency.feature", //OK DONE 
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC55_SPL_Verify the Net Pay Calculation for Existing Customer Bi-Weekly Frequency.feature", //OK DONE
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC56_SPL_Verify the loan term duration calculation for New customer with Monthly frequency.feature", //OK DONE
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC57_SPL_Verify the loan term duration calculation for existing customer with Bi Weekly frequency when CSR change the loan amount and recalculate..feature", //OK DONE
		//--------------------"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC58_Verify that the customer is able to qualify for SPL Loan or not by validating all knock out rule.feature", //OK DONE
		
		//EA
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC03_Verify loan decission for Early Advance loan with Decile3.feature", //OK DONE
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC08_Verify whether early advance is not applicable when parent loan amount is 1000$ in MB.feature", //OK DONE
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC12_Verify loan decision for Early Advance loan with Decile2.feature", //OK DONE
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC20_Verify_Early_advance_loan_should_get_decline_if_parent_loan_decile_is_less_then_early_advance_loan_decile.feature", //OK DONE
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC37_Verify Early Advance loan decision is denied when Early Advance application decile grater  than Parent loan decile.feature", //OK DONE
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC43_Verify_Refinance_functionality_after_Early_Advance_done_as_many_as_done_for_a_IL.feature", //OK DONE
		//"------C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC49_verify_the_3rd_early_advance_is_displaying_when_customer_is_already_having_2_early_advance.feature", //OK DONE
		
		//28-Sept-2022
		
		//Issue of 
		   //"Code": "GuardRail",
           //"Reason": "Adjusted Max Monthly Payment is negative"
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC04_New_IL_Refinance_flink_optout_Parent_flink_in.feature", //OK DONE with Partial Payment and than re try
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC06_IL_Refinance_flink_prove_data.feature", //OK DONE gonr both Parent and Refi Manual Review - need to perform changed in Refi
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC49_verify_the_3rd_early_advance_is_displaying_when_customer_is_already_having_2_early_advance.feature", // OK GOOD
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC42_Verify_whether_system_allowed_as_much_as_top_up.feature", // OK GOOD
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC58_Verify that the customer is able to qualify for SPL Loan or not by validating all knock out rule.feature", // OK GOOD 
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC21_Verify_Loan_decission_is_denied_when_employee_is_NMM_or_related.feature", // OK GOOD
		///////###############################################///////////
	    ///////###############################################///////////
	    ///////###############################################///////////
		
		
		
		//15-Sept-2022 
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC01_New_IL_Approved.feature", //TC01
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC06_Verify loan decission for First loan with Decile6.feature", //OK good
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC01_Verify loan decission for First loan with Decile1.feature", //OK good
		
		
		//16-Sept-202
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC10_Verify loan decission for New loan with Decile10.feature", OK good 
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC15_Verify loan decission for First loan with Decile5.feature", OK good
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC19_Verify loan decission for New loan with Decile9.feature", Decile for 9 is not there its 10
		
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC50_SPL_Verify whether denial message is displayed to  CSR when knock off rules are passed.feature",
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC51_SPL_Verify the message displayed to the CSR when failure response is received from the provenir when the applicant age is 17 years old.feature", --Need to work on validation point
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC54_SPL_Verify the Net Pay Calculation for New Customer Bi-Monthly Frequency.feature",
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC56_SPL_Verify the loan term duration calculation for New customer with Monthly frequency.feature",
		
		//RELOAN
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC02_Verify loan decission for parent loan decile5 and Reloan loan with Decile6.feature", //OK (take screenshot for full pay) //ParentFico Missing
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC07_Verify loan decission for parent loan with decile8  Reloan loan with Decile6 and missing fico score.feature",    //getting 8 rather than 6 //ParentFico Missing
		
		//19-Sept-2022
		//REFI
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC04_Verify loan decission for Refinance loan with Decile6.feature",  //OK GOOD 
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC13_Verify loan decission for Refinance loan with Decile3.feature", //OK GOOD, Added approved screenshot later 
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC18_Verify loan decision for Refinance loan with Decile2.feature", OK GOOD, Added approved screenshot later
		
		//20-SEpt-2022
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC57_SPL_Verify the loan term duration calculation for existing customer with Bi Weekly frequency when CSR change the loan amount and recalculate..feature", OK GOOD need to verify
		
		//21-Sept-2022
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC03_Verify loan decission for Early Advance loan with Decile3.feature", OK GOOD
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC37_Verify Early Advance loan decision is denied when Early Advance application decile grater  than Parent loan decile.feature", OK GOOD 
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC12_Verify loan decision for Early Advance loan with Decile2.feature", OK GOOD
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC08_Verify whether early advance is not applicable when parent loan amount is 1000$ in MB.feature",
		
		
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC53_SPL_Verify the Net Pay Calculation for existing Customer Monthly Frequency.feature", OK GOOD
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC55_SPL_Verify the Net Pay Calculation for Existing Customer Bi-Weekly Frequency.feature", OK GOOD
	
		//22-Sept-2022
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC21_Verify_Loan_decission_is_denied_when_employee_is_NMM_or_related.feature",
		//-------"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC23_Verify Loan decission is denied when employment type is OAS.feature",
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC58_Verify that the customer is able to qualify for SPL Loan or not by validating all knock out rule.feature",
		
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC03_Existing_IL_Reloan_Approved.feature",
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC05_New_IL_Refinance_flink_out.feature",
		
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC05_New_IL_Refinance_flink_out_Review.feature",
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC03_Existing_IL_Reloan_Approved_SecondForDagageneration.feature",
		
		//IL
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC01_New_IL_Approved.feature", //OK GOOD
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC05_New_IL_Refinance_flink_out.feature", // OK GOOD
		//SPL
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC02_New_SPL_approved.feature", // OK GOOD etreansfer
		//IL RELOAN
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC03_Existing_IL_Reloan_Approved.feature", //OK GOOD reloan
		//IL REFINANACE - Flinks - Non Flinks
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC04_New_IL_Refinance_flink_optout_Parent_flink_in.feature" //OK GOOD flinks non flinks 5k 
		//IL REFINANACE - Non Flinks - Non Flinks
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC05_New_IL_Refinance_flink_out.feature", // OK GOOD
		//IL REFINANACE - Flinks -Flinks
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC06_IL_Refinance_flink_prove_data.feature" //OK GOOD
		//IL TOPUP Loan
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC07__New_IL_TopUp_PayOff.feature" //OK GOOD 
		//IL Early Advance
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC08_New_IL_Refinance_flink_out_EarlyAdvance.feature",
		
		//======================
		//REGRESSION SCENARIOS
		//======================
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC42_Verify_whether_system_allowed_as_much_as_top_up.feature",
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC44_Verify_top_up_functionality_on_a_refinance_loan.feature",  top up need snippet
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC21_Verify_Loan_decission_is_denied_when_employee_is_NMM_or_related.feature", //TBD - Approved rather than denied
		
		//19-Aug-2022
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC24_Verify_Loan_decission_is_denied_when_annual_income_less_tha_1k.feature",
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC26_Verify_Loan_decission_is_denied_when_Debt_ratio_does_not_fall_in_the_valid_range_allowed.feature", OK GOOD
		
		
		//22-Aug-2022
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC43_Verify_Refinance_functionality_after_Early_Advance_done_as_many_as_done_for_a_IL.feature", OK GOOD
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC47_Online_Verify_the_early_advance_on_re_loan.feature", OK
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC16_Verify_loan_decission_for_New_loan_as_Decile_2_And_Reloan_loan_with_Decile_8.feature",  OK GOOD
		
		//24-Aug-2022
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC20_Verify_Early_advance_loan_should_get_decline_if_parent_loan_decile_is_less_then_early_advance_loan_decile.feature", //OK GOOD
		
		
		//25-Aug-2022
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC49_verify_the_3rd_early_advance_is_displaying_when_customer_is_already_having_2_early_advance.feature", //OK GOOD
		
		
		//28-Aug-2022
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC21_Verify_Loan_decission_is_denied_when_employee_is_NMM_or_related.feature", //Coding Done, Need Confirmation its not declining
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC47_Online_Verify_the_early_advance_on_re_loan.feature", OK GOOD
		
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC24_Verify_Loan_decission_is_denied_when_annual_income_less_tha_1k.feature", 
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC26_Verify_Loan_decission_is_denied_when_Debt_ratio_does_not_fall_in_the_valid_range_allowed.feature", 
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC20_Verify_Early_advance_loan_should_get_decline_if_parent_loan_decile_is_less_then_early_advance_loan_decile.feature",		
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC16_Verify_loan_decission_for_New_loan_as_Decile_2_And_Reloan_loan_with_Decile_8.feature",
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC43_Verify_Refinance_functionality_after_Early_Advance_done_as_many_as_done_for_a_IL.feature",
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC49_verify_the_3rd_early_advance_is_displaying_when_customer_is_already_having_2_early_advance.feature",
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC42_Verify_whether_system_allowed_as_much_as_top_up.feature",
		//"C:\\MM\\Online_Proviner_MM\\features\\PRO_CAN_Online_TC44_Verify_top_up_functionality_on_a_refinance_loan.feature",
},

dryRun = false, 
glue = {"online.StepDefinitions"},
		plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json", "html:target/cucumber-report",
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
				"junit:target/cukes/junit.xml" }, monochrome = true)

public class RunnerPhase1{
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("config/report.xml"));

	}
	
	

}

