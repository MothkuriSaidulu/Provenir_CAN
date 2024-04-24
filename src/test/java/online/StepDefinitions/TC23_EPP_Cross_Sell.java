package online.StepDefinitions;

import cucumber.api.java.en.Then;
import driver.TestBase;
import pages.Pg_02_PersonalInfo;
import pages.Pg_11_eSignDocs;
import pages.Pg_19_Cross_Sell;
import pages.Pg_20_FinalOffer_PayDay_Loan;

public class TC23_EPP_Cross_Sell {

	

	
	@Then("^existing customer details$")
	public void existing_customer_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
		Pg_02_PersonalInfo obj_PInfo= new Pg_02_PersonalInfo(TestBase.getDriver());
		obj_PInfo.existing_profile_Rent_downsell();
		hooks.bindreport(hooks.scenario, "customer details");
	}

	@Then("^verify the cross sell screen and continue PDL loan$")
	public void verify_the_cross_sell_screen_and_continue_PDL_loan() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_19_Cross_Sell obj_Dsell= new Pg_19_Cross_Sell(TestBase.getDriver());
		
	    hooks.bindreport(hooks.scenario, "cross sell screen");
	    obj_Dsell.downsell_offer_screen();
	}

	@Then("^Loan approved final offer$")
	public void loan_approved_final_offer() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_20_FinalOffer_PayDay_Loan obj_Finaloffer= new Pg_20_FinalOffer_PayDay_Loan(TestBase.getDriver());
		obj_Finaloffer.finaloffer();
	    hooks.bindreport(hooks.scenario, "loan approval screeen");
	}
	
	@Then("^Loan approved final offer spl change verification$")
	public void loan_approved_final_offer_spl_change_verification() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_20_FinalOffer_PayDay_Loan obj_Finaloffer= new Pg_20_FinalOffer_PayDay_Loan(TestBase.getDriver());
		obj_Finaloffer.finaloffer_spl_Change_And_Verify();
	    hooks.bindreport(hooks.scenario, "loan approval screeen");
	}

	@Then("^esing document and back to dashboard$")
	public void esing_document_and_back_to_dashboard() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_11_eSignDocs  obj_esign=new Pg_11_eSignDocs(TestBase.getDriver());
		
		obj_esign.Sign_Loan_Docs_EPP();
		
	    hooks.bindreport(hooks.scenario, "esign document");
	}
}
