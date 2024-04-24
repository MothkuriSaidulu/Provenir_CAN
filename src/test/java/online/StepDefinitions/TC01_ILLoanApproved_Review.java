package online.StepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.TestBase;
import pages.Pg_01_Home_for_Payments;
import pages.Pg_06_ThankYou_DocumentUpload;
import pages.Pg_07_Dashboard;
import pages.Pg_09_Funding;
import pages.Pg_10_Payment;
import pages.Pg_11_PhoneOTP;
import pages.Pg_11_eSignDocs;
import pages.Pg_12_LoanApprovedScreen;
import pages.Pg_14_Finaloffer_LPP_Yes_No;
import pages.Pg_15_fundingPaymentConfirmation;
import pages.Pg_16_Rescind;
import pages.Pg_Databases;

public class TC01_ILLoanApproved_Review {
	
	
	
	@When("^verify the funding screen and chosses the funding type$")
	public void verify_the_funding_screen_and_chosses_the_funding_type() throws Throwable {
		Pg_09_Funding obj_funding = new Pg_09_Funding(TestBase.getDriver());
		//Pg_11_PhoneOTP obj_otp = new Pg_11_PhoneOTP(TestBase.getDriver());

		//obj_otp.phone_verification_invalidopt();
		Thread.sleep(3000);
		obj_funding.Page_Method();

		hooks.bindreport(hooks.scenario, "funding screen");
	}

	@When("^add the bank details$")
	public void add_the_bank_details() throws Throwable {
		Pg_10_Payment obj_payment = new Pg_10_Payment(TestBase.getDriver());

		obj_payment.Payment_AddBank();

		hooks.bindreport(hooks.scenario, "Bank details ");
	}
	
	@When("^select the bank Flinks$")
	public void add_the_bank_details_Flinks() throws Throwable {
		Pg_10_Payment obj_payment = new Pg_10_Payment(TestBase.getDriver());

		obj_payment.Payment_AddBank_OptIn();

		hooks.bindreport(hooks.scenario, "Bank details ");
	}
	
	@When("^select the bank$")
	public void select_the_bank() throws Throwable {
		Pg_10_Payment obj_payment = new Pg_10_Payment(TestBase.getDriver());

		obj_payment.Payment_SelectBank();

		hooks.bindreport(hooks.scenario, "select bank details ");
	}
	
	@When("^Go Next$")
	public void Go_Next() throws Throwable {
		Pg_10_Payment obj_payment = new Pg_10_Payment(TestBase.getDriver());

		obj_payment.go_Next();

		hooks.bindreport(hooks.scenario, "Bank details ");
	}

	@When("^upload document$")
	public void upload_document() throws Throwable {
		Pg_06_ThankYou_DocumentUpload obj_DocumentUpload = new Pg_06_ThankYou_DocumentUpload(TestBase.getDriver());

		obj_DocumentUpload.Upload_Docs();

		
		
		
		hooks.bindreport(hooks.scenario, "uploaded documents");
	}
	
	@When("^verify the loan status and update loan status in DB$")
	public void verify_the_loan_status_and_update_loan_status_in_DB() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
		obj_DB.update_loanstatus(24);
	}

	@When("^verify the loan status and update loan status three in DB$")
	public void verify_the_loan_status_and_update_loan_status_three_in_DB() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
		obj_DB.update_loanstatus_3(3);
	}
	
	
	@When("^click on Finalize and e-Sign Loan Documents$")
	public void click_on_Finalize_and_e_Sign_Loan_Documents() throws Throwable {
		Pg_07_Dashboard obj_dashboard = new Pg_07_Dashboard(TestBase.getDriver());

		Thread.sleep(1000);
		obj_dashboard.click_esign();
		
		hooks.bindreport(hooks.scenario, "esign-document");
	}

	@When("^Verify the loan approved amount$")
	public void verify_the_loan_approved_amount() throws Throwable {
		Pg_12_LoanApprovedScreen obj_approved_screen = new Pg_12_LoanApprovedScreen(TestBase.getDriver());
		obj_approved_screen.Approved_screen();
		
		hooks.bindreport(hooks.scenario, "Final offer");
	}

	@When("^chosses the either LPP yes or no$")
	public void chosses_the_either_LPP_yes_or_no() throws Throwable {
		Pg_14_Finaloffer_LPP_Yes_No obj_finaloffer = new Pg_14_Finaloffer_LPP_Yes_No(TestBase.getDriver());
		obj_finaloffer.finaloffer();
		
		hooks.bindreport(hooks.scenario, "approval loan amount and lpp chooses");
	}
	
	@When("^chosses the either LPP yes or no - verify twelve month is not available for apply$")
	public void chosses_the_either_LPP_yes_or_no_verify_twelve_month_is_not_availabl_for_apply() throws Throwable {
		Pg_14_Finaloffer_LPP_Yes_No obj_finaloffer = new Pg_14_Finaloffer_LPP_Yes_No(TestBase.getDriver());
		obj_finaloffer.finaloffer_Decrease_Term_And_Check_12_Not_There();
		
		hooks.bindreport(hooks.scenario, "approval loan amount and lpp chooses");
	}
	
	@When("^chosses the either LPP yes or no - go for less loan amount$")
	public void chosses_the_either_LPP_yes_or_no_go_for_less_loan_amount() throws Throwable {
		Pg_14_Finaloffer_LPP_Yes_No obj_finaloffer = new Pg_14_Finaloffer_LPP_Yes_No(TestBase.getDriver());
		obj_finaloffer.finaloffer_PrimaryIl_With_LessAmount();
		
		hooks.bindreport(hooks.scenario, "approval loan amount and lpp chooses");
	}
	
	@When("^chosses the either LPP yes or no - for refi topup$")
	public void chosses_the_either_LPP_yes_or_no_for_refi_topup() throws Throwable {
		Pg_14_Finaloffer_LPP_Yes_No obj_finaloffer = new Pg_14_Finaloffer_LPP_Yes_No(TestBase.getDriver());
		obj_finaloffer.finaloffer_Refi_ForTopUp();
		
		hooks.bindreport(hooks.scenario, "approval loan amount and lpp chooses");
	}
	
	
	@When("^chosses the either LPP yes or no - for topup loan$")
	public void chosses_the_either_LPP_yes_or_no_for_topup_loan() throws Throwable {
		Pg_14_Finaloffer_LPP_Yes_No obj_finaloffer = new Pg_14_Finaloffer_LPP_Yes_No(TestBase.getDriver());
		obj_finaloffer.finaloffer_for_topUpLoan();
		
		hooks.bindreport(hooks.scenario, "approval loan amount and lpp chooses");
	}

	@When("^bank details$")
	public void veirfy_the_funding_types_and_bank_details() throws Throwable {
		Pg_15_fundingPaymentConfirmation obj_fundingdetail = new Pg_15_fundingPaymentConfirmation(TestBase.getDriver());
		obj_fundingdetail.paymentconfirmation_DD();
		
		hooks.bindreport(hooks.scenario, "funding confirmation");
	}

	@When("^Verify the loan documents$")
	public void verify_the_loan_documents() throws Throwable {
		Pg_11_eSignDocs obj_esigndocs = new Pg_11_eSignDocs(TestBase.getDriver());
		obj_esigndocs.Sign_Loan_Docs();
		Thread.sleep(3000); //Added on 30-Nov-2022
		hooks.bindreport(hooks.scenario, "sign loan document screen");
	}
	
	@When("^Verify the loan documents AB$")
	public void verify_the_loan_documents_AB() throws Throwable {
		Pg_11_eSignDocs obj_esigndocs = new Pg_11_eSignDocs(TestBase.getDriver());
		obj_esigndocs.Sign_Loan_Docs_AB();
		
		hooks.bindreport(hooks.scenario, "sign loan document screen");
	}

	@When("^verify the dasboard and rescind loan$")
	public void verify_the_dasboard_and_rescind_loan() throws Throwable {

		Pg_16_Rescind obj_dashboard_Cancelloan = new Pg_16_Rescind(TestBase.getDriver());
		
		hooks.bindreport(hooks.scenario, "resind dashboard screen");
		obj_dashboard_Cancelloan.rescindloan();
		
		hooks.bindreport(hooks.scenario, "dashoard screen");
	}
	@When("^verify the DB validatioin for rescind$")
	public void verify_the_DB_validatioin_for_rescind() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   Pg_Databases obj_DB=new Pg_Databases(TestBase.getDriver());
		obj_DB.dbvalidation_recind();	
		}
	
	
	@Then("^TopUp IL loan$")
	public void TopUp_IL_loan() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_01_Home_for_Payments  obj_hForPayment =new Pg_01_Home_for_Payments(TestBase.getDriver());
		obj_hForPayment.topUpLoan();
	    hooks.bindreport(hooks.scenario, "topUpLoan");
	}
	
	@Then("^Verify TopUp IL loan not present$")
	public void Verify_TopUp_IL_loan_not_present() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pg_01_Home_for_Payments  obj_hForPayment =new Pg_01_Home_for_Payments(TestBase.getDriver());
		obj_hForPayment.topUpLoan_not_present();
	    hooks.bindreport(hooks.scenario, "topUpLoan");
	}
	
	
	@When("^Verify the information to proceed next$")
	public void Verify_the_topup_confirmation() throws Throwable {
		Pg_12_LoanApprovedScreen obj_approved_screen = new Pg_12_LoanApprovedScreen(TestBase.getDriver());
		obj_approved_screen.approve_topUp_IL_Loan();
		
		hooks.bindreport(hooks.scenario, "InfoToProceedNext");
	}
	
	
	@When("^chosses the either LPP yes or no - topup loan$")
	public void chosses_the_either_LPP_yes_or_no_topUpLoan() throws Throwable {
		Pg_14_Finaloffer_LPP_Yes_No obj_finaloffer = new Pg_14_Finaloffer_LPP_Yes_No(TestBase.getDriver());
		obj_finaloffer.finaloffer_TopUp();
		hooks.bindreport(hooks.scenario, "approval loan amount and lpp chooses topup");
	}
	
	
	@When("^chosses the either LPP yes or no - topup loan one$")
	public void chosses_the_either_LPP_yes_or_no_topUpLoan_one() throws Throwable {
		Pg_14_Finaloffer_LPP_Yes_No obj_finaloffer = new Pg_14_Finaloffer_LPP_Yes_No(TestBase.getDriver());
		obj_finaloffer.finaloffer_TopUp_X(TestBase.getMapData.get("TopUp1"));
		hooks.bindreport(hooks.scenario, "approval loan amount and lpp chooses topup");
	}
	
	@When("^chosses the either LPP yes or no - topup loan two$")
	public void chosses_the_either_LPP_yes_or_no_topUpLoan_two() throws Throwable {
		Pg_14_Finaloffer_LPP_Yes_No obj_finaloffer = new Pg_14_Finaloffer_LPP_Yes_No(TestBase.getDriver());
		obj_finaloffer.finaloffer_TopUp_X(TestBase.getMapData.get("TopUp2"));
		hooks.bindreport(hooks.scenario, "approval loan amount and lpp chooses topup");
	}
	
	@When("^chosses the either LPP yes or no - topup loan three$")
	public void chosses_the_either_LPP_yes_or_no_topUpLoan_three() throws Throwable {
		Pg_14_Finaloffer_LPP_Yes_No obj_finaloffer = new Pg_14_Finaloffer_LPP_Yes_No(TestBase.getDriver());
		obj_finaloffer.finaloffer_TopUp_X(TestBase.getMapData.get("TopUp3"));
		hooks.bindreport(hooks.scenario, "approval loan amount and lpp chooses topup");
	}
	
	@When("^chosses the either LPP yes or no - topup loan four$")
	public void chosses_the_either_LPP_yes_or_no_topUpLoan_four() throws Throwable {
		Pg_14_Finaloffer_LPP_Yes_No obj_finaloffer = new Pg_14_Finaloffer_LPP_Yes_No(TestBase.getDriver());
		obj_finaloffer.finaloffer_TopUp_X(TestBase.getMapData.get("TopUp4"));
		hooks.bindreport(hooks.scenario, "approval loan amount and lpp chooses topup");
	}
	

}
/*
 * @Given("^User click on signup in home page$") public void
 * user_click_on_signup_in_home_page() throws Throwable {
 * TestBase.setupSelenium(); Pg_01_Home obj_home = new
 * Pg_01_Home(TestBase.getDriver());
 * 
 * TestBase.getDriver().get(TestBase.getPropertyValue("OnlineURL"));
 * 
 * obj_home.click_IL_Home();
 * 
 * 
 * hooks.bindreport(hooks.scenario, "IL_Approved"); }
 * 
 * @When("^User given all details and created profile$") public void
 * user_given_all_details_and_created_profile() throws Throwable { // Write code
 * here that turns the phrase above into concrete actions
 * //Pg_002_SignInMoneyMartPage obj_singpage = new
 * Pg_002_SignInMoneyMartPage(TestBase.getDriver());
 * 
 * //obj_singpage.enterEmailPassword(); //obj_singpage.clickSignIn();
 * Pg_03_Personal_Info obj_personal=new
 * Pg_03_Personal_Info(TestBase.getDriver()); obj_personal.personalInfo();
 * hooks.bindreport(hooks.scenario, "IL_Approved");
 * 
 * }
 * 
 * 
 * @When("^User select installment loan in dashboard$") public void
 * user_select_installment_loan_in_dashboard() throws Throwable { // Write code
 * here that turns the phrase above into concrete actions
 * 
 * Pg_01_Home obj_dashboardIL = new Pg_01_Home(TestBase.getDriver());
 * 
 * obj_dashboardIL.Dashboard_click_IL();
 * 
 * hooks.bindreport(hooks.scenario, "IL_Approved");
 * 
 * }
 * 
 * @When("^verify the customer details and click on next$") public void
 * verify_the_customer_details_and_click_on_next() throws Throwable { // Write
 * code here that turns the phrase above into concrete actions
 * Pg_02_PersonalInfo obj_personalinfo = new
 * Pg_02_PersonalInfo(TestBase.getDriver());
 * 
 * obj_personalinfo.existing_profile_details();
 * 
 * hooks.bindreport(hooks.scenario, "IL_Approved"); }
 * 
 * 
 * @When("^user select the non-flinks$") public void
 * user_select_the_non_flinks() throws Throwable { // Write code here that turns
 * the phrase above into concrete actions Pg_03_flinksconnect obj_option=new
 * Pg_03_flinksconnect(TestBase.getDriver());
 * 
 * obj_option.flink_select(); hooks.bindreport(hooks.scenario, "IL_Approved"); }
 * 
 * @When("^Enter the employee details and click next$") public void
 * enter_the_employee_details_and_click_next() throws Throwable {
 * Pg_04_Employerinfo obj_employee= new
 * Pg_04_Employerinfo(TestBase.getDriver());
 * 
 * obj_employee.existing_employee_details();
 * 
 * hooks.bindreport(hooks.scenario, "IL_Approved"); }
 * 
 * @When("^verify the PICRA and submit application$") public void
 * verify_the_PICRA_and_submit_application() throws Throwable { Pg_05_picra_page
 * obj_PICRA= new Pg_05_picra_page(TestBase.getDriver());
 * 
 * obj_PICRA.picra_details();
 * 
 * hooks.bindreport(hooks.scenario, "IL_Approved");
 * 
 * 
 * }
 */
