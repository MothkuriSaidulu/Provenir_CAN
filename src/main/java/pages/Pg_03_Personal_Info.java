package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;
import utils.UtilityMethods;


public class Pg_03_Personal_Info extends OnlineActions {

	public Pg_03_Personal_Info(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public static String generatedEmail;
	//Loan page1 - Personal information

	@FindBy (how=How.XPATH, using = "//h1[normalize-space()='Welcome!']")
	public static WebElement txt_Welcome;

	@FindBy (how=How.XPATH, using = "//input[@name='firstName']")
	public static WebElement FirstName;

	@FindBy (how=How.XPATH, using = "//input[@name='lastName']")
	public static WebElement LastName;

	@FindBy (how=How.NAME, using = "dob")
	public static WebElement DOB;

	@FindBy (how=How.NAME, using = "sin")
	public static WebElement SIN;

	@FindBy (how=How.NAME, using = "phone")
	public static WebElement Phone;

	@FindBy (how=How.NAME, using = "email")
	public static WebElement Email;

	@FindBy (how=How.ID, using = "gs-accept")
	public static WebElement Continue;
	
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Continue']")
	public static List<WebElement> Continue1;

	//Set Password

	@FindBy (how=How.XPATH, using = "//h2[normalize-space()='Set Password']")
	public static WebElement txt_SetPassword;
	
	@FindBy (how=How.XPATH, using = "//h2[normalize-space()='Sign up to Money Mart']")
	public static WebElement txt_SignUp;
	
	@FindBy (how=How.XPATH, using = "//button[@class='mm-select__value']")
	public static WebElement dd_SelectSecurityQuestion;

	@FindBy (how=How.XPATH, using = "//button[normalize-space()='What was your childhood nickname?']")
	public static WebElement SecurityAns;

	@FindBy (how=How.XPATH, using = "//input[@autocomplete='none']")
	public static WebElement input_yourAns;

	@FindBy (how=How.XPATH, using = "//input[@name='newPassword']")
	public static WebElement input_Password;

	@FindBy (how=How.XPATH, using = "//input[@name='confirmPassword']")
	public static WebElement input_ConfirmPassword;

	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Save']")
	public static WebElement btn_Save;
	
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Create Account']")
	public static WebElement btn_CreateAccount;

		
	// Locators for address 
	
	@FindBy (how=How.XPATH, using = "//input[@name='address']")
	public static WebElement Home_Address;

	@FindBy (how=How.ID, using = "search_btn")
	public static WebElement btn_CheckAddress;

	@FindBy (how=How.ID, using = "exampleModalLabel")
	public static WebElement txt_ConfirmLoan;

	@FindBy (how=How.XPATH, using = "//h4[normalize-space()='Confirm Loan Availability']")
	public static WebElement txt_ConfirmLoanAavail;

	@FindBy (how=How.XPATH, using = "//div[@class='pcaitem pcafirstitem pcaselected' OR @class='pcaitem pcafirstitem pcalastitem pcaselected' OR @class='pcaitem pcafirstitem pcaexpandable']")
	public static WebElement txt_FirstAutoText;
	
	@FindBy (how=How.XPATH, using = "//div[@class='pca pcalist'][1]")
	public static WebElement txt_FirstAutoText1;
	
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Yes']")
	public static WebElement Rent_Yes;
	
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='No']")
	public static WebElement Rent_No;
	
	@FindBy (how=How.XPATH, using = "//div[contains(text(),'What is your share of rent?*')]/following::input[1]")
	public static WebElement Rent_Amount;
	
	@FindBy (how=How.XPATH, using = "//div[@class='app-wrapper__body']")
	public static WebElement Body;
	
	@FindBy (how=How.XPATH, using = "//img[@class='hrglass']")
	public static List<WebElement> OfferLoading;

	//Confirm Address
	
	@FindBy (how=How.XPATH, using = "//h2[contains(normalize-space(), 'Just Checking')]")
	public static List<WebElement> JustChecking;
	
	@FindBy (how=How.XPATH, using = "//p[contains(normalize-space(), 'The address you entered is different from the one you used previously')]")
	public static List<WebElement> DifferentAddress;
	
	@FindBy (how=How.XPATH, using = "//div[@class='mm-congrats-header']")
	public static List<WebElement> head_LoanOffer;
	
	@FindBy (how=How.XPATH, using = "//div[contains(normalize-space(), 'sorry, we')]")
	public static List<WebElement> Loan_Decline;
	
	@FindBy (how=How.XPATH, using = "//div[normalize-space()='Check out these other options.']")
	public static List<WebElement> Loan_Decline1;
	
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Confirm']")
	public static WebElement btn_confirm;
	
	@FindBy (how=How.XPATH, using = "(//span[@class='mm-checkbox__box'])[1]")
	public static WebElement checkbox_one;
	
	@FindBy (how=How.XPATH, using = "(//span[@class='mm-checkbox__box'])[2]")
	public static WebElement checkbox_two;
	
	public void personalInfo() throws Exception
	{
		waitForElementToBeVisible(txt_Welcome,"Welcome message");
		EnterText(FirstName, getMapData.get("FirstName"), "First name");
		EnterText(LastName, getMapData.get("LastName"), "Last name");
		EnterText(DOB, getMapData.get("DOB"), "Date of birth");
		EnterText(SIN, getMapData.get("SIN"), "SIN");
		EnterText(Phone, getMapData.get("Phone"), "Mobile number");
		generatedEmail = UtilityMethods.generateRandomTextDynamically();
		generatedEmail=generatedEmail+getMapData.get("FirstName")+"@yopmail.com";
		logger.info("===EMAIL ADDRESS===");
			logger.info(generatedEmail);
			logger.info("===EMAIL ADDRESS===");
			
			EnterText(Email,generatedEmail ,"Email");
	//Address information	
		waitForElementToBeVisible(Home_Address,"Home address");
		waitForElementToBeVisible(Home_Address, "Caption");
		Thread.sleep(4000);
		//EnterText(email_id, getMapData.get("Email"), "emailid");
		
		EnterText(Home_Address, getMapData.get("home_Address"), "customer address");
		
		Actions act = new Actions(getDriver());
		
		act.sendKeys(Keys.DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		//address.sendKeys(Keys.ARROW_DOWN);
		//address.sendKeys(Keys.ENTER);  
		Thread.sleep(4000);

		//Rent information
		Thread.sleep(1500);
		if(getMapData.get("Rent_Yes_No").equalsIgnoreCase("Yes"))
		{
			click(Rent_Yes,"Rent Yes");
			EnterText(Rent_Amount,getMapData.get("Rent_Contribution") ,"Rent amount" );
		}
		else if(getMapData.get("Rent_Yes_No").equalsIgnoreCase("No"))
		{
			click(Rent_No,"Rent no");
		}
		Thread.sleep(2000);
click(checkbox_one, "check the checkbox");
		
		click(checkbox_two, "check the checkbox");
		click(Continue,"Continnue button");	
		for(int i=1;i<=12;i++)
		{
			if(Continue1.size()>0)
			{
				click(Continue1.get(0),"Continnue button for Picra");	
			}
			else
			{
				
			}
		}
		
	}

	
	

}
