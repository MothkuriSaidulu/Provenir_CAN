package online.StepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.TestBase;
import pages.Pg_09_Funding;
import pages.Pg_17_Earlypayoff;
import pages.Pg_Databases;

public class TC05_existing_IL {

	
	
	@Then("^Backdate loan ten days$")
	public void backdate_loan_ten_days() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
		obj_DB.backdateloan(10);
	}
	
	@Then("^Backdate loan five days$")
	public void backdate_loan_five_days() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
		obj_DB.backdateloan(5);
	}
	
	
	@Then("^select the funding types for repay card$")
	public void select_the_funding_types_for_repay_card() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_09_Funding obj_fund=new Pg_09_Funding(TestBase.getDriver());
		obj_fund.funding_existing_repay();
		
		hooks.bindreport(hooks.scenario, "existingrepay");
	}
	
}
