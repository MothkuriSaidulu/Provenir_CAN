package online.StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import driver.TestBase;
import pages.Pg_23_Withdraw_loan;
import pages.Pg_Databases;

public class TC53_Refinance_withdraw {
	
	@And("^loan withdraw$")
	public void loan_withdraw() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		hooks.bindreport(hooks.scenario, "refinance with drawdashboard");
		Pg_23_Withdraw_loan obj_withdraw=new Pg_23_Withdraw_loan(TestBase.getDriver());
		obj_withdraw.withdrawloan();
	}

	@Then("^update loan contract$")
	public void update_loan_contract() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_Databases obj_BD= new Pg_Databases(TestBase.getDriver());
		
		obj_BD.Change_LoanContract_iD(1);
	}
}
