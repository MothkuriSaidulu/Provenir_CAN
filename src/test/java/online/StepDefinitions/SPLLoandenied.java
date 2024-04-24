package online.StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import driver.TestBase;
import pages.Pg_01_Home;
import pages.Pg_02_PersonalInfo;
import pages.Pg_08_Signup;

public class SPLLoandenied {
	
	@Given("^user click on signup customer$")
	public void user_click_on_signup_customer() throws Throwable {
		TestBase.setupSelenium();
		Pg_01_Home obj_home = new Pg_01_Home(TestBase.getDriver());
		
		
		TestBase.getDriver().get(TestBase.getPropertyValue("OnlineURL"));
		
		obj_home.signup_home();
		Thread.sleep(2000); //Added on 21-Sept-2022 - Added for Webdriver issue
		hooks.bindreport(hooks.scenario, "home");
		obj_home.click_signup();
		System.out.println("Preparating few test data and saving to XL sheeet, please wait for some time to select the loan");
		Thread.sleep(2000); //Added on 21-Sept-2022 - Added for Webdriver issue
		hooks.bindreport(hooks.scenario, "customer creation");
	}

	@When("^Create customer$")
	public void create_customer() throws Throwable {
		Pg_08_Signup obj_sign = new Pg_08_Signup(TestBase.getDriver());
		
		
		obj_sign.signup_customer();
		hooks.bindreport(hooks.scenario, "created account");
	}

	@When("^customer chooses SPL loan$")
	public void customer_chooses_SPL_loan() throws Throwable {
		Pg_01_Home obj_db = new Pg_01_Home(TestBase.getDriver());
		
		
		obj_db.Dashboard_click_SPL();
		hooks.bindreport(hooks.scenario, "choses loan");
	}

@When("^User provides basic information for spl$")
public void user_provides_basic_information_for_spl() throws Throwable {
    
	Pg_02_PersonalInfo  obj_PersonalInfo = new Pg_02_PersonalInfo(TestBase.getDriver());
	
	
	System.out.println("Provides Personal information");
	obj_PersonalInfo.personalinfo_SPL();
	
	hooks.bindreport(hooks.scenario, "Personal information");
}

@When("^User provides basic information for spl reloan$")
public void user_provides_basic_information_for_spl_reloan() throws Throwable {
    
	Pg_02_PersonalInfo  obj_PersonalInfo = new Pg_02_PersonalInfo(TestBase.getDriver());
	
	
	System.out.println("Provides Personal information");
	obj_PersonalInfo.personalinfo_SPL_reloan();
	
	hooks.bindreport(hooks.scenario, "Personal information");
}

}
