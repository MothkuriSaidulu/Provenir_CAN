package online.TestRunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;


@RunWith(driver.CustomRunner.class)

@CucumberOptions(features = {


//"C:\\Data_file\\Online_MM\\features\\TC16_Canada_Online_Denied_IL.feature",
//"C:\\Data_file\\Online_MM\\features\\Canada_Online_Denied_SPL.feature"},
//"C:\\Data_file\\Online_MM\\features\\TC01_Canada_Online_IL_Approved_new.feature"},
//"C:\\Data_file\\Online_MM\\features\\TC31_Canada_Online_Loan_Existing.feature"},
//"C:\\Data_file\\Online_MM\\features\\Canada_Online_reloan.feature"},
//"C:\\Data_file\\Online_MM\\features\\Canada_Online_Existing_IL_repay.feature"},
//"C:\\Data_file\\Online_MM\\features\\SPL_IL_EsignPending.feature"},

//"C:\\Data_file\\Online_MM\\features\\IL_autofund.feature"},
//"C:\\Data_file\\Online_MM\\features\\TC23_Canada_Online_IL_Denied_EPP_Cross_Sell.feature"},

"C:\\Data_file\\Online_MM\\features\\Scheduler.feature",

//"C:\\Data_file\\Online_MM\\features\\TC44_IL_Refinance_flink_out.feature"},

//"C:\\Data_file\\Online_MM\\features\\TC53_IL_Refinance_withdraw.feature"},

//"C:\\Data_file\\Online_MM\\features\\TC55_IL_Refinance_autovoid.feature"},

//"C:\\Data_file\\Online_MM\\features\\TC06_Canada_Online_EPP_approved.feature"},

//"C:\\Data_file\\Online_MM\\features\\TC50_Refinance_flink_optout_Parent_flink_in.feature"},

//"C:\\Data_file\\Online_MM\\features\\TC07_Canada_Online_SPL_approved.feature"},

//"C:\\Data_file\\Online_MM\\features\\TC37_Refinance_flink_prove_data.feature"},
//"C:\\Data_file\\Online_MM\\features\\TC63_Canada_Online_IL_review_crm_denied.feature"},
//"C:\\Data_file\\Online_MM\\features\\TC19_SPL_flink_prove.feature"},
//"C:\\Data_file\\Online_MM\\features\\TC04_IL_Existing_etransfer.feature"},

//"C:\\Data_file\\Online_MM\\features\\TC09_SPL_Existing_Etransfer.feature"},
//"C:\\Data_file\\Online_MM\\features\\TC12_EPP_Existing_Etransfer.feature"},
//"C:\\Data_file\\Online_MM\\features\\TC59_IL_Arrears_PAD_ON.feature"},
//"C:\\Data_file\\Online_MM\\features\\TC60_IL_debt_PAD_ON.feature"},
//"C:\\Data_file\\Online_MM\\features\\TC01_IL_LPP_refund.feature"},
//"C:\\Data_file\\Online_MM\\features\\TC14_DT_Prod_IL_denied_emptype_others.feature"},
//"C:\\Data_file\\Online_MM\\features\\TC26_DT_Prod_IL_denied_Address.feature"},

//"C:\\Data_file\\Online_MM\\features\\TC07_DT_Prod_IL_flinks_PID.feature"},
//"features"},
//glue = {"online.StepDefinitions.CentzLAFlow"},
//true and false
},
dryRun = false, 
glue = {"online.StepDefinitions"},
		plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json", "html:target/cucumber-report",
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
				"junit:target/cukes/junit.xml" }, monochrome = true)

public class Runner_BKp{
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("config/report.xml"));

	}
	
	

}

