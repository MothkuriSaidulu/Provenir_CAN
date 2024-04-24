package online.StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import driver.TestBase;
import pages.Pg_Databases;
import pages.Pg_PaymentSchedules_Refinance;
import sqlUtils.MsSqlUtility;

public class schedulerandDBlog {

	//Added 24 july 2022 start
	
	@Given("^Make a LPP scheduler$")
	public void Make_a_LPP_scheduler() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_PaymentSchedules_Refinance objo=new Pg_PaymentSchedules_Refinance(TestBase.getDriver());
	  	objo.Complete_Payments_WithLPP(1);
	}
	//added 24 july 2022 end
	
	@Given("^Make IL scheduler payments$")
	public void Make_IL_scheduler_payments() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_PaymentSchedules_Refinance objo=new Pg_PaymentSchedules_Refinance(TestBase.getDriver());
	  	objo.Complete_Payments(5);
	}
	
	
	@Given("^Make IL scheduler payments - early advance$")
	public void Make_IL_scheduler_payments_early_advance() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_PaymentSchedules_Refinance objo=new Pg_PaymentSchedules_Refinance(TestBase.getDriver());
	  	objo.Complete_Payments(2);
	}
	
	@When("^Initialize Loan Details and write to excel$")
	public void Initialize_Loan_Details_and_write_to_excel() throws Throwable {
		
		Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
		obj_DB.dbvalidation_initilize_LoanDetails_Save_Excel();
		//MsSqlUtility.dbvalidation_initilize_LoanDetails_Save_Excel();
	}
	@When("^log all the Loan details in logger for investigation$")
	public void log_all_the_Loan_details_in_logger_for_investigation_before_strom() throws Throwable {
		//Pg_DatabasesCan obj_DB=new Pg_DatabasesCan(TestBase.getDriver());
		//obj_DB.dbvalidation_getAllNotes_And_Logit();
		
		MsSqlUtility.getLoanDetails(TestBase.getMapData.get("eMail"));
		hooks.scenario.write(TestBase.sb.toString());
	}
	
	
	//Added on 15-SEpt-2022 Start
	@When("^log all the Loandetail in logger for investigation$")
	public void log_all_the_Loandetail_in_logger_for_investigation_before_strom() throws Throwable 
	{
		MsSqlUtility.getLoanDetail_Table(TestBase.getMapData.get("eMail"));
		hooks.scenario.write(TestBase.sb.toString());
	}
	
	@When("^log all the LoanPaymentHeader in logger for investigation$")
	public void log_all_the_LoanPaymentHeader_in_logger_for_investigation_before_strom() throws Throwable 
	{
		MsSqlUtility.getLoanPaymentHeader_Table(TestBase.getMapData.get("eMail"));
		hooks.scenario.write(TestBase.sb.toString());
	}
	
	@When("^log all the LoanFee in logger for investigation$")
	public void log_all_the_LoanFee_in_logger_for_investigation_before_strom() throws Throwable 
	{
		MsSqlUtility.getLoanFee_Table(TestBase.getMapData.get("eMail"));
		hooks.scenario.write(TestBase.sb.toString());
	}
	
	@When("^log all the CustomerCredit in logger for investigation$")
	public void log_all_the_CustomerCredit_in_logger_for_investigation_before_strom() throws Throwable 
	{
		MsSqlUtility.getCustomerCredit_Table(TestBase.getMapData.get("eMail"));
		hooks.scenario.write(TestBase.sb.toString());
	}
	
	
	//Added on 15-SEpt-2022 End
	

	@When("^log all the Note details in logger for investigation$")
	public void log_all_the_Note_details_in_logger_for_investigation_before_strom() throws Throwable {
		//Pg_DatabasesCan obj_DB=new Pg_DatabasesCan(TestBase.getDriver());
		//obj_DB.dbvalidation_getAllNotes_And_Logit();
		
		MsSqlUtility.getLOANNOTETable(TestBase.getMapData.get("eMail"));
		hooks.scenario.write(TestBase.sb.toString());
	}

	@When("^log all payment details in logger for investigation$")
	public void log_all_payment_details_in_logger_for_investigation_before_strom() throws Throwable {
		MsSqlUtility.getLoanPayment(TestBase.getMapData.get("eMail"));
		hooks.scenario.write(TestBase.sb.toString());
	}

	@When("^log all Transaction details in logger for investigation$")
	public void log_all_Transaction_details_in_logger_for_investigation_before_strom() throws Throwable {
		MsSqlUtility.getLoanTransactionDetails(TestBase.getMapData.get("eMail"));
		hooks.scenario.write(TestBase.sb.toString());
	}

	@When("^log all EFTLog details in logger for investigation$")
	public void log_all_EFTLog_details_in_logger_for_investigation_before_strom() throws Throwable {
		MsSqlUtility.getLoanEFTLog(TestBase.getMapData.get("eMail"));
	}

	@When("^log all ETransferLog details in logger for investigation$")
	public void log_all_ETransferLog_details_in_logger_for_investigation_before_strom() throws Throwable {
		MsSqlUtility.getLoanETransferLog(TestBase.getMapData.get("eMail"));
	}
}
