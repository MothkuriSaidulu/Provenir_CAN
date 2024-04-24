package online.TestRunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;


@RunWith(driver.CustomRunner.class)

@CucumberOptions(features = {


		"C:\\Data_file\\Online_MM\\features\\CAN_Online_TC01_IL_Approved_new.feature",
		//"C:\\Data_file\\Online_MM\\features\\CAN_Online_TC02_IL_autofund.feature",
		//"C:\\Data_file\\Online_MM\\features\\CAN_Online_TC03_IL_Existing_etransfer.feature",
		//"C:\\Data_file\\Online_MM\\features\\CAN_Online_TC04_IL_autofund_Earlyoff.feature",
		//"C:\\Data_file\\Online_MM\\features\\CAN_Online_TC05_EPP_approved.feature",
		//"C:\\Data_file\\Online_MM\\features\\CAN_Online_TC06_SPL_approved.feature",
		//"C:\\Data_file\\Online_MM\\features\\CAN_Online_TC07_SPL_Existing_Etransfer.feature",
		//"C:\\Data_file\\Online_MM\\features\\CAN_Online_TC08_EPP_Existing_Etransfer.feature",
		//"C:\\Data_file\\Online_MM\\features\\CAN_Online_TC09_SPL_Denied.feature",
		//"C:\\Data_file\\Online_MM\\features\\CAN_Online_TC10_IL_Denied.feature",
		//"C:\\Data_file\\Online_MM\\features\\CAN_Online_TC11_IL_Denied_SPL_Cross_Sell.feature",
		//"C:\\Data_file\\Online_MM\\features\\CAN_Online_TC12_IL_Denied_EPP_Cross_Sell.feature",
		//"C:\\Data_file\\Online_MM\\features\\CAN_Online_TC13_IL_Loan_Engaged.feature",
		//"C:\\Data_file\\Online_MM\\features\\CAN_Online_TC14_IL_reloan.feature",
		//"C:\\Data_file\\Online_MM\\features\\CAN_Online_TC15_SPL_IL_EsignPending.feature",
		//"C:\\Data_file\\Online_MM\\features\\CAN_Online_TC17_IL_Refinance_flink_out.feature",
		//"C:\\Data_file\\Online_MM\\features\\CAN_Online_TC18_IL_Refinance_flink_optout_Parent_flink_in.feature",
		//"C:\\Data_file\\Online_MM\\features\\CAN_Online_TC19_IL_Refinance_withdraw.feature",
		//"C:\\Data_file\\Online_MM\\features\\CAN_Online_TC20_IL_Refinance_autovoid.feature",
		//"C:\\Data_file\\Online_MM\\features\\CAN_Online_TC21_IL_Arrears_PAD_ON.feature",
		//"C:\\Data_file\\Online_MM\\features\\CAN_Online_TC22_IL_debt_PAD_ON.feature",
		//"C:\\Data_file\\Online_MM\\features\\CAN_Online_TC23_IL_reloan_LPP_Cancel.feature",
		//"C:\\Data_file\\Online_MM\\features\\CAN_Online_TC24_IL_review_crm_denied.feature",
		//"C:\\Data_file\\Online_MM\\features\\CAN_Online_TC26_IL_Refinance_flink_prove_data.feature",
		//"C:\\Data_file\\Online_MM\\features\\CAN_Online_TC27_SPL_flink_prove.feature",
		//"C:\\Data_file\\Online_MM\\features\\CAN_Online_TC28_IL_LPP_refund.feature",
		
		

//glue = {"online.StepDefinitions.CentzLAFlow"},
//true and false
},
dryRun = false, 
glue = {"online.StepDefinitions"},
		plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json", "html:target/cucumber-report",
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
				"junit:target/cukes/junit.xml" }, monochrome = true)

public class RunnerOrg{
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("config/report.xml"));

	}
	
	

}

