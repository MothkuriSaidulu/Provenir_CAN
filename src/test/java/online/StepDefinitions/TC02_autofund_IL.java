package online.StepDefinitions;

import cucumber.api.java.en.When;
import driver.TestBase;
import pages.Pg_09_Funding;

public class TC02_autofund_IL {

	
	

	@When("^Verify the phone OTP and enter valid OTP for autofund$")
	public void verify_the_phone_OTP_and_enter_valid_OTP_for_autofund() throws Throwable {
		
		Pg_09_Funding obj_phone= new Pg_09_Funding(TestBase.getDriver());
		obj_phone.autofund();
		hooks.bindreport(hooks.scenario, "Phone verification");
		
	}
	@When("^select the funding types$")
	public void Veirfy_the_funding_types_and_bank_details_for_repay() throws Throwable {
		
		Pg_09_Funding obj_phone= new Pg_09_Funding(TestBase.getDriver());
		obj_phone.Funding_Method();
	   
		hooks.bindreport(hooks.scenario, "funding screen");
	}
	
	
	
	
	
	
}
