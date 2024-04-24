package online.StepDefinitions;

import cucumber.api.java.en.When;
import driver.TestBase;
import pages.Pg_02_PersonalInfo;
import pages.Pg_04_Employerinfo;
import pages.Pg_09_Funding;
import pages.Pg_17_Earlypayoff;

public class TC31_Engaged_Existing_IL {
	
	
	@When("^verify the existing customer details for SPL$")
	public void verify_the_existing_customer_details_for_SPL() throws Throwable {
		Pg_02_PersonalInfo obj_personal=new  Pg_02_PersonalInfo(TestBase.getDriver());
		obj_personal.existing_profile_details_spl();
		hooks.bindreport(hooks.scenario, "existing personal details for SPL");
	}
	
	@When("^verify the funding screen and change the funding type$")
	public void verify_the_funding_screen_and_change_the_funding_type() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_09_Funding obj_funding = new Pg_09_Funding(TestBase.getDriver());
		
		//Thread.sleep(1000);
		obj_funding.changefunding();

		hooks.bindreport(hooks.scenario, "funding screen");
	}
	
	
	@When("^verify the existing customer details$")
	public void verify_the_existing_customer_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_02_PersonalInfo obj_personal=new  Pg_02_PersonalInfo(TestBase.getDriver());
		obj_personal.existing_profile_details();
		hooks.bindreport(hooks.scenario, "Existing customer details"); 
	}
	@When("^change the funding types$")
	public void change_the_funding_types() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_09_Funding obj_phone = new Pg_09_Funding(TestBase.getDriver());
		System.out.println("Getting the URL and wait few minites ");
		Thread.sleep(3000);
		obj_phone.changefunding();
	   
		hooks.bindreport(hooks.scenario, "opt phone screen and funding selection");
	}
	
	@When("^make a SPL payment$")
	public void make_a_SPL_payment() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_17_Earlypayoff obj_fullpayment=new Pg_17_Earlypayoff(TestBase.getDriver());
		obj_fullpayment.Makepayoff_SPL();
		hooks.bindreport(hooks.scenario, "Make full payment for SPL"); 
	}

	@When("^Verify the  income information$")
	public void verify_the_income_information() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		 Pg_04_Employerinfo obj_employee= new Pg_04_Employerinfo(TestBase.getDriver());
				 obj_employee.existing_employee_details();
			hooks.bindreport(hooks.scenario, "IL_Approved"); 
	}
	
	@When("^Verify the customer information new UI$")
	public void Verify_the_customer_information_new_UI() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 Pg_04_Employerinfo obj_employee= new Pg_04_Employerinfo(TestBase.getDriver());
				 obj_employee.existing_customer_details_new_UI();
			hooks.bindreport(hooks.scenario, "IL_Approved"); 
	}
	
	@When("^Verify the customer information new UI Monthly Weekly$")
	public void Verify_the_customer_information_new_UI_Monthly_Weekly() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 Pg_04_Employerinfo obj_employee= new Pg_04_Employerinfo(TestBase.getDriver());
				 obj_employee.existing_customer_details_new_UI_Monthly_Weekly();
			hooks.bindreport(hooks.scenario, "IL_Approved"); 
	}
	
	//Added on 11-Oct-202 Start
	@When("^Verify the customer information new UI Monthly$")
	public void Verify_the_customer_information_new_UI_Monthly() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 Pg_04_Employerinfo obj_employee= new Pg_04_Employerinfo(TestBase.getDriver());
				 obj_employee.existing_customer_details_new_UI_Monthly();
			hooks.bindreport(hooks.scenario, "IL_Approved"); 
	}
	//Added on 11-Oct-202 End
	
	
	//Added on 16-Oct-2022 Start
	@When("^Verify the customer information new UI Monthly Debt ratio does not fall in the valid range$")
	public void Verify_the_customer_information_new_UI_Monthly_Debt_ratio_does_not_fall_in_the_valid_range() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 Pg_04_Employerinfo obj_employee= new Pg_04_Employerinfo(TestBase.getDriver());
				 obj_employee.existing_customer_details_new_UI_Monthly_Debt_ratio_does_not_fall_in_the_valid_range();
			hooks.bindreport(hooks.scenario, "IL_Approved"); 
	}
	//Added on 16-Oct-2022 End
	
	
	//Added on 15-Oct-2022 Start
	@When("^Verify the customer information new UI Monthly SK$")
	public void Verify_the_customer_information_new_UI_Monthly_SK() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 Pg_04_Employerinfo obj_employee= new Pg_04_Employerinfo(TestBase.getDriver());
				 obj_employee.existing_customer_details_new_UI_Monthly_SK_Province();
			hooks.bindreport(hooks.scenario, "IL_Approved"); 
	}
	//Added on 15-Oct-2022 End

	@When("^verify the funding and chosses the funding type$")
	public void verify_the_funding_and_chosses_the_funding_type() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_09_Funding obj_funding=new Pg_09_Funding(TestBase.getDriver());
		//Thread.sleep(10000);
		obj_funding.Page_Method();
	}
	
}
