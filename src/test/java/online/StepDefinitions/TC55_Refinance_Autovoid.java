package online.StepDefinitions;

import cucumber.api.java.en.And;
import driver.TestBase;
import pages.Pg_22_backtodashboard;
import pages.Pg_Databases;
import pages.Pg_PaymentSchedules_Refinance;

public class TC55_Refinance_Autovoid {
	
	@And("^back to  dashboard and verify the withdraw button$")
	public void back_to_dashboard_and_verify_the_withdraw_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_22_backtodashboard obj_dashboard=new Pg_22_backtodashboard(TestBase.getDriver());
		
		obj_dashboard.backtodashboard();
		
		hooks.bindreport(hooks.scenario, "refinance dashboard");
	}

	@And("^Back to loan$")
	public void back_to_loan() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
		obj_DB.backdateloanformakepayment(5);
	   
	}

	@And("^run the scheduler$")
	public void run_the_scheduler() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_PaymentSchedules_Refinance obj_scheduler=new Pg_PaymentSchedules_Refinance(TestBase.getDriver());
		
		obj_scheduler.runscheduler();
		
	}

}
