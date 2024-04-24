package online.StepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.TestBase;
import pages.Pg_07_Dashboard;
import pages.Pg_09_Funding;
import pages.Pg_10_Payment;
import pages.Pg_11_PhoneOTP;
import pages.Pg_17_Earlypayoff;
import pages.Pg_21_OTPScreen;
import pages.Pg_Databases;

public class TC37_autovoid_esignpending {

	
	
	@When("^Verify the esign pending status$")
	public void verify_the_esign_pending_status() throws Throwable {
		Pg_07_Dashboard obj_dashboard = new Pg_07_Dashboard(TestBase.getDriver());

		Thread.sleep(1000);
		obj_dashboard.esign_btm();
		
		hooks.bindreport(hooks.scenario, "esign pending screen");
	}

	@When("^enter valid OTP$")
	public void enter_valid_OTP() throws Throwable {
		
		Pg_09_Funding obj_phone = new Pg_09_Funding(TestBase.getDriver());
		obj_phone.phoneotppass();
	   
		hooks.bindreport(hooks.scenario, "opt phone screen");
	}
	@When("^verify the bank details$")
	public void verify_the_bank_details() throws Throwable {
		
		Pg_10_Payment obj_bank= new Pg_10_Payment(TestBase.getDriver());
		obj_bank.Payment_Existing();
	   
		hooks.bindreport(hooks.scenario, "Bank screen");
	}
	
	@When("^Back date IL & SPL loans$")
	public void back_date_IL_SPL_loans() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
		obj_DB.backdateloan(6);
	}
	
	
	//add code for otp revised 0517 start
		@When("^Send verification code and get and enter otp and validate$")
		public void Enter_otp_and_validate() throws Throwable {
			
			Pg_21_OTPScreen obj_phone_OTP = new Pg_21_OTPScreen(TestBase.getDriver());
			obj_phone_OTP.enter_otp();
		   
			hooks.bindreport(hooks.scenario, "opt phone screen");
		}
		
		//add code for otp revised 0517 end
	
}
