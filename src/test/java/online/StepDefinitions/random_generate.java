package online.StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import driver.TestBase;
import pages.Pg_Generate_ramdom;
import pages.Pg_sin_generate;
import utils.UtilityMethods;


public class random_generate  {


	@When("^Pre-requisite data generation for customer$")
	public void create_customerpre_requisite_data_generation() throws Throwable {
		Pg_Generate_ramdom obj_sign = new Pg_Generate_ramdom(TestBase.getDriver());
		
		
		obj_sign.preRequisiteDataGeneration();
		
	}
	
	
	@When("^Pre-requisite data load for customer$")
	public void create_customerpre_requisite_data_load() throws Throwable {
		Pg_Generate_ramdom obj_sign = new Pg_Generate_ramdom(TestBase.getDriver());
		
		
		obj_sign.preRequisiteDataLoad();
		
	}
	
	
	
	
	@Given("^Genareted sin$")
	public void genareted_sin() throws Throwable {
		
		TestBase.setupSelenium();
		Pg_sin_generate obj_sin = new Pg_sin_generate(TestBase.getDriver());
		
		TestBase.getDriver().get(TestBase.getPropertyValue("SIN_URL"));
		
		hooks.bindreport(hooks.scenario, "sin account");
		//Thread.sleep(4000); Commented on 22-Sept-2022
		
		obj_sin.sinGenerate();
		//Thread.sleep(2000); Commented on 22-Sept-2022
		hooks.bindreport(hooks.scenario, "sin account");
		//Thread.sleep(2000); //commented on 21-sept-2022
		TestBase.getDriver().close();
		
		//Thread.sleep(5000);//updated 5k from 2k Commented on 22-Sept-2022
		Thread.sleep(2000); //Added on 22-Sept-2022
		
	}
	
	@Given("^Genareted random six digit accountnumber$")
	public void genareted_random_six_digit_accountnumber() throws Throwable {
		
		String randonGeneratedAccontNumber = UtilityMethods.getRandomNumberString();
		TestBase.datatable.setCellDataForTestData_online(TestBase.testCaseName, "bank_AccountNo", 1, randonGeneratedAccontNumber);
		System.out.println("Ramdon Account Number Generated and logged in excel.."+randonGeneratedAccontNumber);
		
	}
	
}
