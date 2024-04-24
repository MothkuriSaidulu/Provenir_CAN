package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;
import driver.TestBase;
import utils.UtilityMethods;


public class Pg_08_Signup extends OnlineActions{

	//WebDriver driver;
	public Pg_08_Signup(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public static String generatedEmail;
	
	
	@FindBy (how=How.XPATH, using = "//h1[normalize-space()='Sign up to Money Mart']")
	public static WebElement signup_header;
	@FindBy (how=How.XPATH, using = "//input[@name='firstName']")
	public static WebElement first_name;
	@FindBy (how=How.XPATH, using = "//input[@name='lastName']")
	public static WebElement last_Name;
	@FindBy (how=How.XPATH, using = "//input[@name='dob']")
	public static WebElement dob;
	
	@FindBy (how=How.XPATH, using = "//input[@name='phoneNumber']")
	public static WebElement phone_number;
	@FindBy (how=How.XPATH, using = "//input[@name='email']")
	public static WebElement email_id;
	@FindBy (how=How.XPATH, using = "//button[@class='mm-select__value']")
	public static WebElement Security_list;
	
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='What was your childhood nickname?']")
	public static WebElement Security_Question;
	
	@FindBy (how=How.XPATH, using = "//input[@autocomplete='none']")
	public static WebElement Security_answer;
	@FindBy (how=How.XPATH, using = "//input[@name='newPassword']")
	public static WebElement newpassword;
	@FindBy (how=How.XPATH, using = "//input[@name='confirmPassword']")
	public static WebElement confirmpassword;
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Create Account']")
	public static WebElement createaccount;
	
	
	public void signup_customer() throws Exception
	

	{
		String strUrl = TestBase.getDriver().getCurrentUrl();
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

		//Added on 24-Sept-2022 Start
		logger.info("^^^^^^^^^^^^^^^^^^^^ENVIRONMENT URL^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		logger.info(strUrl);
		logger.info("^^^^^^^^^^^^^^^^^^^^ENVIRONMENT URL^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		TestBase.currentGlobalScenarioName.write("<span style='color:navy'><b> ENVIRONMENT URL </b></span>");
		TestBase.currentGlobalScenarioName.write("<span style='color:navy'><b>"+strUrl+"</b></span>");
		TestBase.currentGlobalScenarioName.write("<span style='color:navy'><b> ENVIRONMENT URL </b></span>");
		
		//Added on 07-July-2022 Start
		logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^ENVIRONMENT URL^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		logLoanDetails.add(strUrl);
		logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^ENVIRONMENT URL^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		//Added on 07-July-2022 End

		//Added on 07-July-2022 Start
		UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
		logLoanDetails.clear();
		//Added on 07-July-2022 End
		
		
		//Added on 24-Sept-2022 End
		
		System.out.println("Wait update the loan status in DB"+"URL:::"+strUrl);
		
		VerifyText_For_PageCaption(signup_header, "Sign up to Money Mart", "Basic Info Page, Hence Passed");
		waitForElementToBeClickable(first_name,"Firstname");
		//FinalgeneratedFirstName= UtilityMethods.generateRandomTextDynamically();
		//EnterText(first_name, FinalgeneratedFirstName, "First Name");
		EnterText(first_name, getMapData.get("FirstName"), "First Name");
		EnterText(last_Name, getMapData.get("LastName"), "Last Name");
		EnterText(dob, getMapData.get("DOB"), "Date of birth");
		Thread.sleep(2000);
		TestBase.bindreport(currentGlobalScenarioName, "DOBEntered");
		EnterText(phone_number, getMapData.get("Phone"), "phone number");
		Thread.sleep(2000);
		TestBase.bindreport(currentGlobalScenarioName, "cutomer details page");
		/*
		 * generatedEmail = UtilityMethods.generateRandomTextDynamically();
		 * generatedEmail = generatedEmail + FinalgeneratedFirstName + "@yopmail.com";
		 * logger.info("===EMAIL ADDRESS==="); logger.info(generatedEmail);
		 */
		/*
		 * generatedEmail = UtilityMethods.generateRandomTextDynamically();
		 * generatedEmail=generatedEmail+getMapData.get("FirstName")+"@yopmail.com";
		 * logger.info("===EMAIL ADDRESS==="); logger.info(generatedEmail);
		 * logger.info("===EMAIL ADDRESS===");
		 */
		  //EnterText(email_id,generatedEmail,"Email");
		 
		EnterText(email_id, getMapData.get("eMail"), "email id");
		click(Security_list,"Security_list"); 
		click(Security_Question,"Security_Question"); 
		EnterText(Security_answer, getMapData.get("Answer"), "Answer");
		EnterText(newpassword, getMapData.get("Password"), " Password");
		EnterText(confirmpassword, getMapData.get("Password"), "Password ");
		TestBase.bindreport(currentGlobalScenarioName, "customer details page");
		click(createaccount,"createaccount"); 
		Thread.sleep(6000);
		

}
}