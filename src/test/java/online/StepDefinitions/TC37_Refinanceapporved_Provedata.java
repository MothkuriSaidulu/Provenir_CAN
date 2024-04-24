package online.StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import driver.TestBase;
import pages.Pg_03_flinksconnect;
import pages.Pg_11_eSignDocs;
import pages.Pg_12_LoanApprovedScreen;

public class TC37_Refinanceapporved_Provedata {

	
	@Then("^Exising flink$")
	public void exising_flink() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_03_flinksconnect obj_flink=new Pg_03_flinksconnect(TestBase.getDriver());
		
		obj_flink.Flinks_Refi();
		hooks.bindreport(hooks.scenario, "Final offer");
	}
	
	
	@Then("^New flink for refi$")
	public void New_flink_for_refi() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_03_flinksconnect obj_flink=new Pg_03_flinksconnect(TestBase.getDriver());
		
		obj_flink.Flinks_Func_refi();
		hooks.bindreport(hooks.scenario, "Final offer");
	}
	
}
