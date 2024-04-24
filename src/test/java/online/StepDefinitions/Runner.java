package online.StepDefinitions;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;


@RunWith(driver.CustomRunner.class)
//@RunWith(Cucumber.class)

//@CucumberOptions(features = {"classpath:Centz/features"},

@CucumberOptions(features = {"C:\\Data_file\\Online_Framework\\features\\Canada_Online_Denied_IL.feature"},
//@CucumberOptions(features = {"C:\\Data_file\\Online_Framework\\features\\Canada_Online_Denied_SPL.feature"},
//@CucumberOptions(features = {"C:\\Data_file\\Online_Framework\\features\\Canada_Online_IL_Approved_new.feature"},
//@CucumberOptions(features = {"C:\\Data_file\\Online_Framework\\features\\Canada_Online_Loan_Existing.feature"},
//@CucumberOptions(features = {"C:\\Data_file\\Online_Framework\\features\\Canada_Online_reloan.feature"},
//@CucumberOptions(features = {"C:\\Data_file\\Online_Framework\\features\\SPL_IL_EsignPending.feature"},

//@CucumberOptions(features = {"C:\\Data_file\\Online_Framework\\features\\IL_autofund.feature"},



//@CucumberOptions(features = {"features"},
//glue = {"online.StepDefinitions.CentzLAFlow"},
//true and false
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

