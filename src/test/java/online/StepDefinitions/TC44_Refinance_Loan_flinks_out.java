package online.StepDefinitions;

import cucumber.api.java.en.Then;
import driver.TestBase;
import pages.Pg_002_SignInMoneyMartPage;
import pages.Pg_01_Home;
import pages.Pg_21_Refinance_dashboard;
import pages.Pg_Databases;

public class TC44_Refinance_Loan_flinks_out {
	
	@Then("^Run the TU query for refinance$")
	public void run_the_TU_query_for_refinance() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
		Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
		obj_DB.TUquery_refi();
		
	}

	@Then("^sign the customer$")
	public void sign_the_customer() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		TestBase.setupSelenium();
		Pg_01_Home obj_home = new Pg_01_Home(TestBase.getDriver());
		
		
		TestBase.getDriver().get(TestBase.getPropertyValue("OnlineURL"));
		
		obj_home.signup_home();
		
		Pg_002_SignInMoneyMartPage obj_sign=new Pg_002_SignInMoneyMartPage(TestBase.getDriver());
		
		
		Thread.sleep(5000); //Added on 27-Sept-2022
		obj_sign.enterEmailPassword();
		obj_sign.clickSignIn();
		
		hooks.bindreport(hooks.scenario, "user login");
	}

	@Then("^select the refinance loan$")
	public void select_the_refinance_loan() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_21_Refinance_dashboard obj_refi_btm=new Pg_21_Refinance_dashboard(TestBase.getDriver());
		hooks.bindreport(hooks.scenario, "refinance dashboard");
		obj_refi_btm.refinancebutton_dashboard();
		
		hooks.bindreport(hooks.scenario, "refinance dashboard");
	}

	//Added on 12-Aug-2022 Start
	@Then("^select the refinance loan new UI$")
	public void select_the_refinance_loan_new_UI() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_21_Refinance_dashboard obj_refi_btm=new Pg_21_Refinance_dashboard(TestBase.getDriver());
		hooks.bindreport(hooks.scenario, "refinancedashboardbefore");
		obj_refi_btm.newUI_Refi_Yes_LetsDo_from_dashboard();
		hooks.bindreport(hooks.scenario, "refinancedashboardafter");
	}
	//Added on 12-Aug-2022 End
	
	//Added on 25-Aug-2022 Start
	@Then("^Verify the refinance loan new UI - 3rd Early advance should not be allowed$")
	public void Verify_the_refinance_loan_new_UI() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_21_Refinance_dashboard obj_refi_btm=new Pg_21_Refinance_dashboard(TestBase.getDriver());
		hooks.bindreport(hooks.scenario, "refinancedashboardbefore");
		obj_refi_btm.newUI_Refi_Yes_LetsDo_from_dashboard_verify();
		hooks.bindreport(hooks.scenario, "refinancedashboardafter");
	}
	//Added on 25-Aug-2022 End
	
	
	@Then("^Verify the refinance loan new UI - Early advance not applicable$")
	public void Verify_the_refinance_loan_new_UI_Early_advance_not_applicable() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_21_Refinance_dashboard obj_refi_btm=new Pg_21_Refinance_dashboard(TestBase.getDriver());
		hooks.bindreport(hooks.scenario, "refinancedashboardbefore");
		obj_refi_btm.newUI_EA_Yes_LetsDo_from_dashboard_verify();
		hooks.bindreport(hooks.scenario, "refinancedashboardafter");
	}
	
	
	//Added on 16-Aug-2022 Start
		@Then("^select the reloan new UI$")
		public void select_the_reloan_new_UI() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			Pg_21_Refinance_dashboard obj_refi_btm=new Pg_21_Refinance_dashboard(TestBase.getDriver());
			hooks.bindreport(hooks.scenario, "refinancedashboardbefore");
			obj_refi_btm.newUI_ReLoan_Yes_LetsDo_from_dashboard();
			hooks.bindreport(hooks.scenario, "refinancedashboardafter");
		}
		//Added on 16-Aug-2022 End

}
