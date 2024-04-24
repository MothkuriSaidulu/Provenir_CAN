package online.TestRunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;


@RunWith(driver.CustomRunner.class)

@CucumberOptions(features = {
		
		//TC1
		//"C:\\MM\\Provenir_Automation_Working\\Provenir_CAN\\features_Revised\\PRO_CAN_Online_TC01_New_IL_Approved.feature", 
			//OK GOOD VERIFIED - Non Flinks - Refer To Store
		
		//TC2
		//"C:\\MM\\Provenir_Automation_Working\\Provenir_CAN\\features_Revised\\PRO_CAN_Online_TC02_New_SPL_NonFlinks_ReferToStore.feature",
		//OK GOOD VERIFIED - Non Flinks - Refer To Store

		//TC3 - TO BE TESTED
		//"C:\\MM\\Provenir_Automation_Working\\Provenir_CAN\\features_Revised\\PRO_CAN_Online_TC03_Existing_IL_Reloan_Approved.feature",
		//OK GOOD VERIFIED -

		//TC4
		//Existing SPL Reloan		
		//"C:\\MM\\Provenir_Automation_Working\\Provenir_CAN\\features_Revised\\PRO_CAN_Online_TC04_SPL_Verify the Net Pay Calculation for existing Customer Monthly Frequency.feature",
		//OK GOOD VERIFIED - Revised
		
		//TC5
		"C:\\MM\\Provenir_Automation_Working\\Provenir_CAN\\features_Revised\\PRO_CAN_Online_TC05_New_Flinks_IL_Approved.feature",
		//OK GOOD VERIFIED - Flinks - Approve
		
		//TC6 Refi - TEST IT LATER AS TAKING LONG TIME
		//"C:\\MM\\Provenir_Automation_Working\\Provenir_CAN\\features_Revised\\PRO_CAN_Online_TC06_New_IL_Refi_Approved.feature",	
		
		//TC7
		//"C:\\MM\\Provenir_Automation_Working\\Provenir_CAN\\features_Revised\\PRO_CAN_Online_TC07_SPL_Verify the Net Pay Calculation for Existing Customer Bi-Weekly Frequency.feature",
		//OK GOOD VERIFIED - Revised
		
		//TC08
		//"C:\\MM\\Provenir_Automation_Working\\Provenir_CAN\\features_Revised\\PRO_CAN_Online_TC08_Verify_Loan_decission_is_denied_when_Debt_ratio_does_not_fall_in_the_valid_range_allowed.feature",
		//OK GOOD VERIFIED - Revised
		
		//TC09 - Need Flinks Data for less than 1k else scripting is good
		//"C:\\MM\\Provenir_Automation_Working\\Provenir_CAN\\features_Revised\\PRO_CAN_Online_TC09_Verify_Loan_decission_is_denied_when_annual_income_less_tha_1k.feature",
		
		
		//TC10 - WIP - Test it - getting data fraud issue due to accountNouniqueness - GODD VERIFIED
		//"C:\\MM\\Provenir_Automation_Working\\Provenir_CAN\\features_Revised\\PRO_CAN_Online_TC10_Verify_loan_decission_for_New_loan_as_Decile_2_And_Reloan_loan_with_Decile_8.feature",
		
		//TC11 - GOOD VERIFIED - Revised
		//"C:\\MM\\Provenir_Automation_Working\\Provenir_CAN\\features_Revised\\PRO_CAN_Online_TC11_SPL_Verify the loan term duration calculation for existing customer with Bi Weekly frequency when CSR change the loan amount and recalculate.feature",
		//"C:\\MM\\Provenir_Automation_Working\\Provenir_CAN\\features_demo\\PRO_CAN_Online_TC11_SPL_Verify the loan term duration calculation for existing customer with Bi Weekly frequency when CSR change the loan amount and recalculate.feature",
		
		//TC12 - EPP - GOOD VERIFIED
		//"C:\\MM\\Provenir_Automation_Working\\Provenir_CAN\\features_Revised\\PRO_CAN_Retail_TC12_ON_Verify whether user is able to generate  EPP loan when two spl loan closed past within 63 days.feature",
		
		
		//TC13 - Multiple Frequency - GOOD VERIFIEDPRO_CAN_Online_TC35_Verify Top up loan decision is review when income is less than parent loan.feature
		//"C:\\MM\\Provenir_Automation_Working\\Provenir_CAN\\features_Revised\\PRO_CAN_Online_TC13_CAN BC_Online_verify netpay calculation , loan amount , loan fee, total loan amount with loan term for Multiple employer with different frequency.feature",
		
		//TC14 - TOP UP LOan
		//"C:\\MM\\Provenir_Automation_Working\\Provenir_CAN\\features_Revised\\PRO_CAN_Online_TC14_Verify Top up loan decision is review when income is less than parent loan.feature",
		
		
		//TC15 - EPP - bi-Monthly
		//"C:\\MM\\Provenir_Automation_Working\\Provenir_CAN\\features_Revised\\PRO_CAN_Online_TC15_ON_Verify the EPP Terms pay frequency for customer with Bi-Monthly frequency.feature",
		
		
		//Additional
		//"C:\\MM\\Provenir_Automation_Working\\Provenir_CAN\\features_Revised\\PRO_CAN_Online_TC01_New_IL_Approved_Org.feature",
		//OK GOOD VERIFIED - Flinks New Customer
			
		//CHANGE
		//CHANGE 1
		//THis changes in done by me on Branch Provenir_CAN_PP
		//SEcond line change by me on Branch Provenir_CAN_PP
		
		//TEST COMMIT AND PUSH
		//TEST COMMIT AND PUSH
		//TEST COMMIT AND PUSH 3rd
		
},

dryRun = false, 
glue = {"online.StepDefinitions"},
		plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json", "html:target/cucumber-report",
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
				"junit:target/cukes/junit.xml" }, monochrome = true)

public class Runner_Revised{
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("config/report.xml"));

	}
	
	

}

