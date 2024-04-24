package online.StepDefinitions;

import cucumber.api.java.en.When;
import driver.TestBase;
import pages.Pg_03_flinksconnect;
import pages.Pg_04_Employerinfo;
import pages.Pg_10_Payment;

public class TC50_Refinance {
	
	@When("^select flink opt in$")
	public void select_flink_opt_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
		Pg_03_flinksconnect obj_flink= new Pg_03_flinksconnect(TestBase.getDriver());
		obj_flink.Flinks("IL");
		hooks.takeScreenshotimage(TestBase.getDriver(), "Flinks");
		
		hooks.bindreport(hooks.scenario, "flinks  login");
	}

	@When("^check the flinks income details$")
	public void check_the_flinks_income_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_04_Employerinfo obj_emp=new Pg_04_Employerinfo(TestBase.getDriver());
		
		obj_emp.IncomeDetails_WithFlinks();
		hooks.bindreport(hooks.scenario, "flinks income");
	}

	@When("^Flinks bank details$")
	public void flinks_bank_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		Pg_10_Payment obj_bank=new Pg_10_Payment(TestBase.getDriver());
		
		obj_bank.Payment_withFlinks();
		
		hooks.bindreport(hooks.scenario, "flinks banks");
	}

}
