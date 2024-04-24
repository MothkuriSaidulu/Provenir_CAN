package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;
import driver.TestBase;

public class Pg_01_Home extends OnlineActions{

	//WebDriver driver;
	public Pg_01_Home(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	//Home page	
	
	//a[normalize-space()='Loans']
	@FindBy (how=How.XPATH, using = "//header/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]")
	public static WebElement chooseloan;
	
	//@FindBy (how=How.XPATH, using = "//header/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]")
	//public static WebElement chooseloan;
	@FindBy (how=How.XPATH, using = "//a[normalize-space()='Installment�Loans']")
	public static WebElement IL_loan;
	@FindBy (how=How.XPATH, using = "//div[@class='feature--icon']//a[@class='apply-now']")
	public static WebElement IL_loan_apply;
	
	//body/div[1]/main[1]/div[1]/div[4]/div[2]/div[2]/div[2]/div[1]/div[5]/div[1]/a[1]
		
	@FindBy (how=How.XPATH, using = "//strong[normalize-space()='Cash Advance']/following::span[normalize-space()='Apply Now'][1]")
	public static WebElement SPL_Apply;
	
	@FindBy (how=How.XPATH, using = "//input[@placeholder='Enter your home address']")
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
	
	@FindBy (how=How.XPATH, using = "//div[@class='pca pcalist'][1]")
	public static List<WebElement> list_FirstAutoText1;
	
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Installment Loan']")
	public static WebElement Dash_IL_Apply;
	
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Cash Advance']")
	public static WebElement Dash_SPL_Apply;
	
	@FindBy (how=How.XPATH, using = "//span[@class='text underline']")
	public static WebElement signup_page;
	
	@FindBy(how = How.XPATH, using = "//h1[text()='Sign in to Money Mart']")
	WebElement caption;
	
	@FindBy (how=How.XPATH, using = "//a[normalize-space()='Sign Up now']")
	public static WebElement signup;
	
	@FindBy (how=How.XPATH, using = "//input[@name='email']")
	
	public static WebElement User_name;
	@FindBy (how=How.XPATH, using = "//input[@name='password']")
	public static WebElement password;
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Sign In']")
	public static WebElement signin;
	
	@FindBy (how=How.XPATH, using = "//li[normalize-space()='Installment Loans']")
	public static WebElement Installment_home;
	
	@FindBy (how=How.XPATH, using = "//div[@class='button-block toggleLoanApplyNow']//a[@class='apply-now']")
	public static WebElement click_installemnt;

	public void click_IL() throws Exception
	{
		
		waitForElementToBeClickable(chooseloan,"Get Started select loan");
		//Move To specified element
		//Actions actions = new Actions(getDriver());
		//actions.moveToElement(chooseloan);
		click(chooseloan,"Loan selection");
		
		click(IL_loan,"Installment loan link");	
		waitForElementToBeClickable(IL_loan_apply,"To apply select loan");
		click(IL_loan_apply,"Apply for Installment loan");
	}
	
	public void click_IL_Home() throws Exception
	{
	
	waitForElementToBeClickable(Installment_home,"Get Started select loan");
	click(Installment_home,"Installment link"); 
	waitForElementToBeClickable(click_installemnt,"Get Started select loan");
	click(click_installemnt,"Installment link"); 
	}
	
	public void signup_home() throws Exception
	{
		Thread.sleep(4000);
	waitForElementToBeClickable(signup_page,"Get Started select loan");
	click(signup_page,"singnup_page"); 
	
	}

	public void click_signup() throws Exception
{
		Thread.sleep(4000);
	waitForElementToBeClickable(signup, "WaitSignUp"); //Added on 17-Aug-2022
	scrollIntoView(signup); //Added on 17-Aug-2022
	click(signup,"clicked_signup");
	TestBase.bindreport(currentGlobalScenarioName, "Signup page");
}
	
	public void username_password() throws Exception
{
		
		
		VerifyText_For_PageCaption(caption, "Sign in to Money Mart", "Sign in to Money Mart, Hence Passed");
		User_name.sendKeys(Keys.CONTROL + "a");
		User_name.sendKeys(Keys.DELETE);
		EnterText(User_name, getMapData.get("Username"), "user name");
		password.sendKeys(Keys.CONTROL + "a");
		password.sendKeys(Keys.DELETE);
		EnterText(password, getMapData.get("Password"), "customer password");
	
	
			waitForElementToBeClickable(signin, "waitSignIn");
			click(signin, "clickSignIn");
	 
	
}

	
	public void Dashboard_click_IL() throws Exception
	{
		
		Thread.sleep(3000);
		waitForElementToBeVisible(Dash_IL_Apply,"WaitVisibleOfInstallment displayed");
		waitForElementToBeClickable(Dash_IL_Apply,"WaitVisibleOfInstallment displayed"); //Added on 18-Oct-2022
		Thread.sleep(2000); //Added on 20-Aug-2023 Revised
		click(Dash_IL_Apply,"Installment loan link");
	}

	
	//Added on 14-Nov-2022 Start
	@FindBy (how=How.XPATH, using = "//div[@class='mm-page-loader__wrapper']")
	public static List<WebElement> searchWheel_SearchLook;
	//Added on 14-Nov-2022 End
	
public void Dashboard_click_SPL() throws Exception
	{
		
	Thread.sleep(12000); //Updated 3k to 5k on 31-Oct-2022 //Updated 7k from 5k on 02-Nov-2022
	
	TestBase.getDriver().navigate().refresh(); //Added on 30-Nov-2022
	
	//waitForElementToBeVisible(Dash_SPL_Apply,"WaitVisibleOfInstallment displayed"); //Commented on 27-Sept-2022
	waitForElementToBeClickable(Dash_SPL_Apply,"WaitVisibleOfInstallment displayed"); //Added on 27-Sept-2022
	
	//Added on 14-Nov-2022 Start
			int k = 0;
			while(searchWheel_SearchLook.size() > 0)
			{
				Thread.sleep(2000);
				k = k + 1;
				
				if(k==30)
				{
					break;
				}
			}
			//Added on 14-Nov-2022 End
	
	
		click(Dash_SPL_Apply,"Cash Advance loan link");
	}



//	public void click_SPL() throws Exception
//	{
//		
//		click(SPL_Apply,"Cash Advance loan link");
//	}
//	/*
//	 * public void Update_Address_Home() throws Exception { TreeMap<String, String>
//	 * getMapData = new TreeMap<String, String>(); getMapData =
//	 * Xls_Reader.getCellDataBasedOnRowValuefromTestData(TestBase.gettestCaseName(),
//	 * TestBase.gettestCaseName()+TestBase.getEnvironment()+TestBase.getDevice()+
//	 * TestBase.getOS1()+TestBase.getOSVersion()+TestBase.getBrowser()); //AddedPP
//	 * 02-Apr-2019 // Updated method name on 06-MAY-2019 Commented on 13-MAY-2019
//	 * 
//	 * waitForElementToBeVisible(Home_Address,"Home address");
//	 * EnterText(Home_Address, getMapData.get("home_Address"), "Home Address");
//	 * Justclick(txt_ConfirmLoanAavail,"Confirm Available text");
//	 * Justclick(Home_Address,"Place holder");
//	 * 
//	 * if(TestBase.getBrowser().equalsIgnoreCase("Chrome")) {
//	 * Home_Address.sendKeys(Keys.DOWN); Thread.sleep(1000);
//	 * click(txt_FirstAutoText1,"Address from auto suggesion list");
//	 * 
//	 * } else if(TestBase.getBrowser().equalsIgnoreCase("Firefox")) {
//	 * Home_Address.sendKeys(Keys.DOWN); Justclick(Home_Address,"Place holder");
//	 * Home_Address.sendKeys(Keys.ENTER); Thread.sleep(1000); } else {
//	 * Home_Address.sendKeys(Keys.DOWN); Thread.sleep(1000);
//	 * click(txt_FirstAutoText1,"Address from auto suggesion list"); }
//	 * 
//	 * click(btn_CheckAddress,"Check address button"); Thread.sleep(1000); }
//	 */	
}
