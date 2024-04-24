package online.StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import driver.TestBase;
import pages.Pg_01_Home;
import pages.Pg_02_PersonalInfo;
import pages.Pg_03_flinksconnect;
import pages.Pg_04_Employerinfo;
import pages.Pg_05_picra_page;
import pages.Pg_06_NonFlinks_Denied;
import pages.Pg_07_deniedscreen;
import pages.Pg_08_Signup;

import pages.Pg_Databases;
import sqlUtils.MsSqlUtility;


public class ILLoandenied 
{

@Given("^user click on signup$")
public void user_click_on_signup() throws Throwable {
	
	TestBase.setupSelenium();
	Pg_01_Home obj_home = new Pg_01_Home(TestBase.getDriver());
	
	
	TestBase.getDriver().get(TestBase.getPropertyValue("OnlineURL"));
	obj_home.signup_home();
	
	Thread.sleep(7000); //Added on 220Sept2022 Added for Webdriver error HARD WAIT
	
	hooks.bindreport(hooks.scenario, "homepage");
	
	obj_home.click_signup();
	
	hooks.bindreport(hooks.scenario, "singup");
}

@Given("^verify the phonenumber threshold$")
public void verify_the_phonenumber_threshold() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
	obj_DB.update_phonenumber();
	
}
//added july 20 2022 start
@Given("^verify the email threshold$")
public void verify_the_email_threshold() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
	obj_DB.Update_emailid_threshold();
}
//added july 20 2022 end


@Given("^Verify the address threshold and update address$")
public void verify_the_address_threshold_and_update_address() throws Throwable {
	Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
	obj_DB.Update_Address_threshold();
}

@Given("^update address$")
public void update_address() throws Throwable {
	Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
	obj_DB.Update_Address();
}

@When("^Enter all details and create account$")
public void Enter_all_details_and_create_account() throws Throwable {
	Pg_08_Signup obj_sign = new Pg_08_Signup(TestBase.getDriver());
	
	hooks.bindreport(hooks.scenario, "signup");
	
	obj_sign.signup_customer();
	hooks.bindreport(hooks.scenario, "accountcreated");
	/*
	 * System.out.println(
	 * "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	 * 
	 * System.out.println("Wait update the loan status in DB"); Thread.sleep(80000);
	 * 
	 * System.out.println(" updated the loan status in DB"); System.out.println(
	 * "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	 */
	
}
@When("^Run the TU query$")
public void run_the_TU_query() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
	obj_DB.TUquery();
	
}

@When("^Run the TU query decile one$")
public void run_the_TU_query_decile_one() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
	obj_DB.Proviner_Decile_TUquery_1();
	
}

@When("^Run the TU query decile one Bankruptcies$")
public void run_the_TU_query_decile_one_Bankruptcies() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
	obj_DB.Proviner_Decile_TUquery_1_Bankruptcies();
	
}


@When("^Run the TU query general D$")
public void Run_the_TU_query_general_D() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
	obj_DB.Proviner_Decile_TUquery_GeneralD();
	
}


@When("^Run the TU query general D \"([^\"]*)\"$")
public void run_the_TU_query_general_D(String arg1) throws Throwable 
{
	Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
	obj_DB.Proviner_Decile_TUquery_GeneralD(arg1);
}


@When("^Run the TU query general D \"([^\"]*)\" and FICO score \"([^\"]*)\"$")
public void run_the_TU_query_general_D_and_FICO_score(String arg1, String arg2) throws Throwable 
{
	Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
	Thread.sleep(8000);
	obj_DB.Proviner_Decile_TUquery_GeneralD(arg1,arg2 ); 
	Thread.sleep(8000); //Added on 19-sept-2022 Updated 8k from 5k on 04-Oct-2022
}

@When("^Run the TU query general D to get less than oneK \"([^\"]*)\" and FICO score \"([^\"]*)\"$")
public void run_the_TU_query_general_D_to_get_less_than_oneK_and_FICO_score(String arg1, String arg2) throws Throwable 
{
	Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
	Thread.sleep(8000);
	obj_DB.Proviner_Decile_TUquery_To_Get_Less_Than_1k_Approved_Amount(arg1,arg2 ); 
	Thread.sleep(8000); //Added on 19-sept-2022 Updated 8k from 5k on 04-Oct-2022
}


@When("^Run the TU query general D to get less than oneK ReRefiEA \"([^\"]*)\" and FICO score \"([^\"]*)\"$")
public void run_the_TU_query_general_D_to_get_less_than_oneK_ReREfiEA_and_FICO_score(String arg1, String arg2) throws Throwable 
{
	Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
	Thread.sleep(8000);
	obj_DB.Proviner_Decile_TUquery_To_Get_Less_Than_1k_Approved_Amount_ReREfiEA(arg1,arg2 ); 
	Thread.sleep(8000); //Added on 19-sept-2022 Updated 8k from 5k on 04-Oct-2022
}



@When("^Run the TU query denied Rule \"([^\"]*)\" and FICO score \"([^\"]*)\"$")
public void run_the_TU_query_denied_Rule_and_FICO_score(String arg1, String arg2) throws Throwable 
{
	Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
	Thread.sleep(8000);
	obj_DB.Proviner_Decile_TUquery_DeniedRule(arg1,arg2 ); 
	Thread.sleep(8000); //Added on 19-sept-2022 Updated 8k from 5k on 04-Oct-2022
}

@When("^Run the TU query denied Rule approved \"([^\"]*)\" and FICO score \"([^\"]*)\"$")
public void run_the_TU_query_denied_Rule_approved_and_FICO_score(String arg1, String arg2) throws Throwable 
{
	Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
	Thread.sleep(8000);
	obj_DB.Proviner_Decile_TUquery_DeniedRule_Approved(arg1,arg2 ); 
	Thread.sleep(8000); //Added on 19-sept-2022 Updated 8k from 5k on 04-Oct-2022
}


@When("^Run the TU query general ReRefEa D \"([^\"]*)\" and FICO score \"([^\"]*)\"$")
public void run_the_TU_query_general_ReRefEa_D_and_FICO_score(String arg1, String arg2) throws Throwable 
{
	Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
	Thread.sleep(8000);
	obj_DB.Proviner_Decile_TUquery_GeneralD_ReRefiEa(arg1,arg2 ); 
	Thread.sleep(8000); //Added on 19-sept-2022 Updated 8k from 5k on 04-Oct-2022
}


@When("^Run the TU query decile generic for data generation$")
public void run_the_TU_query_decile_generic_my_ref_for_data_generation() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
	obj_DB.Proviner_Decile_TUquery_generic();
	
}

@When("^Run the TU query decile five$")
public void run_the_TU_query_decile_five() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
	obj_DB.Proviner_Decile_TUquery_5();
	
}

@When("^Run the TU query decile two$")
public void run_the_TU_query_decile_two() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
	obj_DB.Proviner_Decile_TUquery_2();
	
}

@When("^Run the TU query decile eight reloan$")
public void run_the_TU_query_decile_eight() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
	obj_DB.Proviner_Decile_TUquery_8_reloan();
	
}

@When("^Run the TU query decile one refi$")
public void run_the_TU_query_decile_one_refi() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
	obj_DB.Proviner_Decile_TUquery_1_refi();
	
}


@When("^Run the TU query decile generic my ref for data generation$")
public void run_the_TU_query_decile_one_refi_generic_my_ref_for_data_generation() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
	obj_DB.Proviner_Decile_TUquery_refi_generic();
	
}



@When("^Run the TU query decile eight earlyadvance$")
public void run_the_TU_query_decile_eight_earlyadvance() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
	obj_DB.Proviner_Decile_TUquery_8_earlyadvance();
	
}


@When("^customer chooses IL loan$")
public void customer_chooses_IL_loan() throws Throwable {
	
	
	  System.out.println(
	  "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"); // //
	  System.out.println("Wait update the loan status in DB"); //
	  Thread.sleep(5000); // //
	 
	 Pg_01_Home obj_db = new Pg_01_Home(TestBase.getDriver());
	
	
	obj_db.Dashboard_click_IL();
	 System.out.println(" updated the loan status in DB"); 
	   System.out.println(
	  "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	hooks.bindreport(hooks.scenario, "choses Loan");
}

	@When("^User provides basic information$")
	public void user_provides_basic_information() throws Throwable {
		
		Pg_02_PersonalInfo  obj_PersonalInfo = new Pg_02_PersonalInfo(TestBase.getDriver());
		
		hooks.bindreport(hooks.scenario, " personal inforation");
		System.out.println("Provides Personal information");
		obj_PersonalInfo.click_personlinfo();
		
		hooks.bindreport(hooks.scenario, "Provides personal inforation");
		
		
	}
	
	@When("^User provides basic information DisEngaged Existing IL$")
	public void user_provides_basic_information_DisEngaged_Existing_IL() throws Throwable {
		
		Pg_02_PersonalInfo  obj_PersonalInfo = new Pg_02_PersonalInfo(TestBase.getDriver());
		
		hooks.bindreport(hooks.scenario, " personal inforation");
		System.out.println("Provides Personal information");
		obj_PersonalInfo.click_personlinfo_DisEngagedExisting_IL();
		
		hooks.bindreport(hooks.scenario, "Provides personal inforation");
		
		
	}
	
	@When("^User provides basic information Engaged Existing IL$")
	public void user_provides_basic_information_Engaged_Existing_IL() throws Throwable {
		
		Pg_02_PersonalInfo  obj_PersonalInfo = new Pg_02_PersonalInfo(TestBase.getDriver());
		
		hooks.bindreport(hooks.scenario, " personal inforation");
		System.out.println("Provides Personal information");
		obj_PersonalInfo.click_personlinfo_EngagedExisting_IL();
		
		hooks.bindreport(hooks.scenario, "Provides personal inforation");
		
		
	}

	@When("^select the flink consent$")
	public void select_the_flink_consent() throws Throwable {
		
		Pg_03_flinksconnect  obj_FlinksScreen = new Pg_03_flinksconnect(TestBase.getDriver());
		
	
		obj_FlinksScreen.flink_select();
		
		hooks.bindreport(hooks.scenario, "flinks page");
		
	}
	
	//Added on 12-Aug-2022 Start
	@When("^select the flink consent new UI$")
	public void select_the_flink_consent_new_UI() throws Throwable {
		Pg_03_flinksconnect  obj_FlinksScreen = new Pg_03_flinksconnect(TestBase.getDriver());
		obj_FlinksScreen.flink_select_new_UI_refi();
		hooks.bindreport(hooks.scenario, "flinks page");
	}
	//Added on 12-Aug-2022 End
	
	
	
	//Added on 16-Aug-2022 Start
		@When("^select the flink consent new UI - with flinks$")
		public void select_the_flink_consent_new_UI_with_Flinks() throws Throwable {
			Pg_03_flinksconnect  obj_FlinksScreen = new Pg_03_flinksconnect(TestBase.getDriver());
			obj_FlinksScreen.flink_select_new_UI_refi_withFlinks();
			hooks.bindreport(hooks.scenario, "flinks page");
		}
		//Added on 16-Aug-2022 End
	
	@When("^Provides income information$")
	public void provides_income_information() throws Throwable {
		
		Pg_04_Employerinfo  obj_Employeedetails = new Pg_04_Employerinfo(TestBase.getDriver());
			
		hooks.bindreport(hooks.scenario, "employee details ");
		obj_Employeedetails.Employer_details();
		
		hooks.bindreport(hooks.scenario, "income details");
		
	}
	
	@When("^Provides income information DisEngagedExisting IL$")
	public void provides_income_information_DisEngagedExisting_IL() throws Throwable {
		
		Pg_04_Employerinfo  obj_Employeedetails = new Pg_04_Employerinfo(TestBase.getDriver());
			
		hooks.bindreport(hooks.scenario, "employee details ");
		obj_Employeedetails.Employer_details_DisEngagedExisting_IL_Reloan();
		
		hooks.bindreport(hooks.scenario, "income details");
		
	}
	
	
	@When("^Provides income information EngagedExisting IL$")
	public void provides_income_information_EngagedExisting_IL() throws Throwable {
		
		Pg_04_Employerinfo  obj_Employeedetails = new Pg_04_Employerinfo(TestBase.getDriver());
			
		hooks.bindreport(hooks.scenario, "employee details ");
		obj_Employeedetails.Employer_details_EngagedExisting_IL_Reloan();
		
		hooks.bindreport(hooks.scenario, "income details");
		
	}
	
	
	@When("^Provides income information Old Age Security - OAS$")
	public void provides_income_information_Old_Age_Security() throws Throwable {
		
		Pg_04_Employerinfo  obj_Employeedetails = new Pg_04_Employerinfo(TestBase.getDriver());
			
		hooks.bindreport(hooks.scenario, "employee details OAS");
		obj_Employeedetails.Employer_details_OldAgeSecurity();
		
		hooks.bindreport(hooks.scenario, "income details OAS 1");
		
	}
	
	
	@When("^Provides income information Twice a Month - otherwise$")
	public void provides_income_information_Twice_a_Month_otherwise() throws Throwable {
		
		Pg_04_Employerinfo  obj_Employeedetails = new Pg_04_Employerinfo(TestBase.getDriver());
			
		hooks.bindreport(hooks.scenario, "employee details ");
		obj_Employeedetails.Employer_details_With_Frequency("Twice a Month - otherwise");
		
		hooks.bindreport(hooks.scenario, "income details");
		
	}
	
	@When("^Provides income information Weekly$")
	public void provides_income_information_Weekly() throws Throwable {
		
		Pg_04_Employerinfo  obj_Employeedetails = new Pg_04_Employerinfo(TestBase.getDriver());
			
		hooks.bindreport(hooks.scenario, "employee details ");
		obj_Employeedetails.Employer_details_With_Frequency("Weekly");
		
		hooks.bindreport(hooks.scenario, "income details");
		
	}
	
	
	@When("^Provides income information Every 2 weeks$")
	public void provides_income_information_Every_2_weeks() throws Throwable {
		
		Pg_04_Employerinfo  obj_Employeedetails = new Pg_04_Employerinfo(TestBase.getDriver());
			
		hooks.bindreport(hooks.scenario, "employee details ");
		obj_Employeedetails.Employer_details_With_Frequency("Every 2 weeks");
		
		hooks.bindreport(hooks.scenario, "income details");
		
	}
	
	
	@When("^Provides income information Every 2 weeks reloan$")
	public void provides_income_information_Every_2_weeks_reloan() throws Throwable {
		
		Pg_04_Employerinfo  obj_Employeedetails = new Pg_04_Employerinfo(TestBase.getDriver());
			
		hooks.bindreport(hooks.scenario, "employee details ");
		obj_Employeedetails.Employer_details_With_Frequency_reloan("Every 2 weeks");
		
		hooks.bindreport(hooks.scenario, "income details");
		
	}
	
	
	@When("^Provides income information Monthly reloan$")
	public void provides_income_information_Monthly_reloan() throws Throwable {
		
		Pg_04_Employerinfo  obj_Employeedetails = new Pg_04_Employerinfo(TestBase.getDriver());
			
		hooks.bindreport(hooks.scenario, "employee details ");
		obj_Employeedetails.Employer_details_With_Frequency_reloan("Every 2 weeks");
		
		hooks.bindreport(hooks.scenario, "income details");
		
	}
	
	
	@When("^Provides income information Twice a Month - otherwise reloan$")
	public void provides_income_information_Twice_a_Month_otherwise_reloan() throws Throwable {
		
		Pg_04_Employerinfo  obj_Employeedetails = new Pg_04_Employerinfo(TestBase.getDriver());
			
		hooks.bindreport(hooks.scenario, "employee details ");
		obj_Employeedetails.Employer_details_With_Frequency_reloan("Twice a Month - otherwise");
		
		hooks.bindreport(hooks.scenario, "income details");
		
	}
	
	
	
	@When("^Provides income information Every 2 weeks reloan change from Primary$")
	public void provides_income_information_Every_2_weeks_reloan_change_from_Primary() throws Throwable {
		
		Pg_04_Employerinfo  obj_Employeedetails = new Pg_04_Employerinfo(TestBase.getDriver());
			
		hooks.bindreport(hooks.scenario, "employee details ");
		obj_Employeedetails.Employer_details_With_Frequency_reloan_Change_Primary("Every 2 weeks");
		
		hooks.bindreport(hooks.scenario, "income details");
		
	}
	
	
	@When("^Provides income information Monthly$")
	public void provides_income_information_Monthly() throws Throwable {
		
		Pg_04_Employerinfo  obj_Employeedetails = new Pg_04_Employerinfo(TestBase.getDriver());
			
		hooks.bindreport(hooks.scenario, "employee details ");
		obj_Employeedetails.Employer_details_With_Frequency("Same day every month");
		
		hooks.bindreport(hooks.scenario, "income details");
		
	}
	
	@When("^Provides income information Multi Employer with Monthly Weekly Bi_Weekly frequency$")
	public void provides_income_information_multi_Employer_with_Monthly_Weekly_Bi_Weekly_frequency() throws Throwable {
		
		Pg_04_Employerinfo  obj_Employeedetails = new Pg_04_Employerinfo(TestBase.getDriver());
			
		hooks.bindreport(hooks.scenario, "employee details ");
		obj_Employeedetails.Employer_details_With_Frequency_Multi_Employer_with_Monthly_Weekly_BiWeekly("Same day every month");
		
		hooks.bindreport(hooks.scenario, "income details");
		
	}
	
	@When("^Provides income information Multi Employer with Monthly Weekly frequency$")
	public void provides_income_information_multi_Employer_with_Monthly_Weekly_frequency() throws Throwable {
		
		Pg_04_Employerinfo  obj_Employeedetails = new Pg_04_Employerinfo(TestBase.getDriver());
			
		hooks.bindreport(hooks.scenario, "employee details ");
		obj_Employeedetails.Employer_details_With_Frequency_Multi_Employer_with_Monthly_Weekly("Same day every month");
		
		hooks.bindreport(hooks.scenario, "income details");
		
	}
	
	@When("^Provides income information same Monthly reloan$")
	public void provides_income_information_same_as_Monthly_reloan() throws Throwable {
		
		Pg_04_Employerinfo  obj_Employeedetails = new Pg_04_Employerinfo(TestBase.getDriver());
			
		hooks.bindreport(hooks.scenario, "employee details ");
		obj_Employeedetails.Employer_details_With_Frequency_reloan("Same day every month");
		
		hooks.bindreport(hooks.scenario, "income details");
		
	}
	
	@When("^Provides income information same Twice a Month - otherwise reloan$")
	public void provides_income_information_same_as_Twice_a_Month_otherwise_reloan() throws Throwable {
		
		Pg_04_Employerinfo  obj_Employeedetails = new Pg_04_Employerinfo(TestBase.getDriver());
			
		hooks.bindreport(hooks.scenario, "employee details ");
		obj_Employeedetails.Employer_details_With_Frequency_reloan("Twice a Month - otherwise");
		
		hooks.bindreport(hooks.scenario, "income details");
		
	}
	
	
	@When("^Provides income information Monthly reloan change$")
	public void provides_income_information_Monthly_reloan_change() throws Throwable {
		
		Pg_04_Employerinfo  obj_Employeedetails = new Pg_04_Employerinfo(TestBase.getDriver());
			
		hooks.bindreport(hooks.scenario, "employee details ");
		obj_Employeedetails.Employer_details_With_Frequency_Change("Same day every month");
		
		hooks.bindreport(hooks.scenario, "income details");
		
	}
	
	
	@When("^signed the picra and submit application$")
	public void signed_the_picra_and_submit_application() throws Throwable {
		Pg_05_picra_page  obj_PICRA = new Pg_05_picra_page(TestBase.getDriver());
		
		obj_PICRA.picra_details();
		
		hooks.bindreport(hooks.scenario, "submit page");
	}

	
	@When("^verify loan is refer to store for apply$")
	public void verify_loan_is_refer_to_store_for_apply() throws Throwable {
		
		
		Pg_06_NonFlinks_Denied  obj_NonFlinks_Denied = new Pg_06_NonFlinks_Denied(TestBase.getDriver());
		obj_NonFlinks_Denied.verify_deniedMessage();
		
		hooks.bindreport(hooks.scenario, "submit page");
	}
	
	


	@When("^loan decision screen$")
	public void loan_decision_screen() throws Throwable {
		
		Pg_07_deniedscreen  obj_dashboard= new Pg_07_deniedscreen(TestBase.getDriver());
		
	
		
		obj_dashboard.deniedscreen();
		hooks.bindreport(hooks.scenario, "loan Denied");
		
		
	}
	
	
	@When("^Verify loan decision denied$")
	public void Verify_loan_decision_denied() throws Throwable 
	{
		Pg_07_deniedscreen  obj_dashboard= new Pg_07_deniedscreen(TestBase.getDriver());
		obj_dashboard.denied_confirmation();
		hooks.bindreport(hooks.scenario, "loan Denied");
	}
	
	@When("^verify the DB validatioin$")
	public void verify_the_DB_validatioin() throws Throwable {
		
		Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
		obj_DB.dbvalidation();
		//System.out.println(obj_DB.);
	
	}
	
	@When("^verify the API validatioins$")
	public void verify_the_API_validatioin() throws Throwable {
		
		TestRestAssured.toExecute_Proviner_Job();
	
	}
	
	
	@When("^Show request for investigation$")
	public void Show_request_for_investigation() throws Throwable 
	{
	
		TestRestAssured.show_Request_For_Investigation();
	}
	
	@When("^Show response for investigation$")
	public void Show_response_for_investigation() throws Throwable 
	{
	
		TestRestAssured.show_Response_For_Investigation();
	}
	
	
	

}
