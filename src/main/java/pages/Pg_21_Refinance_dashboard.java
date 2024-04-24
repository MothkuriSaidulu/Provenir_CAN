package pages;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;
import driver.TestBase;



public class Pg_21_Refinance_dashboard extends OnlineActions {

	//WebDriver driver;
		public Pg_21_Refinance_dashboard(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
		}


	
		@FindBy(how=How.XPATH, using = "//div[@title='Email Loan Documents']")
		public static WebElement Custom_Dash_email;
	
		@FindBy(how=How.XPATH, using = "//div[@title='View Payment Schedule']")
		public static WebElement Custom_Dash_viewpayment_LoanCount_01;
	
		@FindBy(how=How.XPATH, using = "//button[normalize-space()='Make a Payment']")
		public static WebElement Custom_Dash_Make_a_payment_LoanCount_01;	
		
		@FindBy(how=How.XPATH, using = "//button[normalize-space()='Refinance']")
		public static WebElement btm_Refinacne_validation;
		
		
		//Commented and Added on 24-Sept-2022 Start
		//@FindBy(how=How.XPATH, using = "//button[text()='YES, LET’S GO!']")
		//public static WebElement btn_YesLetsDo;
		
		//@FindBy(how=How.XPATH, using = "//img[@class='jsy-btn']") //Commented on 01-Dec-2022
		@FindBy(how=How.XPATH, using = "//button[@class='jsy_button']") //Added on 01-Dec-2022
		public static WebElement btn_YesLetsDo;
		//Commented and Added on 24-Sept-2022 End
		
		
		
		//Added on 25-Aug-2022 Start
		
		//Commented and Added on 24-Sept-2022 Start
		//@FindBy(how=How.XPATH, using = "//button[text()='YES, LET’S GO!']")
		//public static List<WebElement> btn_YesLetsDo_list;
		
		@FindBy(how=How.XPATH, using = "//img[@class='jsy-btn']")
		public static List<WebElement> btn_YesLetsDo_list;
		
		//Commented and Added on 24-Sept-2022 End
		
		@FindBy(how=How.XPATH, using = "//div[@title='View Payment Schedule']")
		public static WebElement div_capion_ViewPaymentSchedule;
		
		//Added on 25-Aug-2022 End
		
	public void refinancebutton_dashboard() throws Exception
	{
		
		
		TestBase.getDriver().navigate().refresh();
		Thread.sleep(4000);
		waitForElementToBeVisible(Custom_Dash_email, "email button");
		waitForElementToBeVisible(Custom_Dash_viewpayment_LoanCount_01, "View payment");
		waitForElementToBeVisible(Custom_Dash_Make_a_payment_LoanCount_01, "Make a payment button");
		waitForElementToBeVisible(btm_Refinacne_validation, "Refinance loan button");
		
		click(btm_Refinacne_validation,"Refinance loan");
		
		
		
					
	}
	//Added on 12-Aug-2022 Start
	public void newUI_Refi_Yes_LetsDo_from_dashboard() throws Exception
	{
		waitForElementToBeClickable(btn_YesLetsDo, "WaitYesLetsDoRefinanceloanbutton");
		click(btn_YesLetsDo,"clkYesLetsDoRefinanceloan");
	}
	//Added on 12-Aug-2022 End
	
	//Added on 25-Aug-2022 Start
		public void newUI_Refi_Yes_LetsDo_from_dashboard_verify() throws Exception
		{
			waitForElementToBeClickable(div_capion_ViewPaymentSchedule, "WaitViewPaymentSchedule");
			Thread.sleep(3000);
			if(btn_YesLetsDo_list.size() > 0)
			{
				assertTrue("3rd Early Advance is not allowed but system is allowing, Hence FAIL", false);
			}
			else
			{
				assertTrue("3rd Early Advance is not allowed and system is not allowing, Hence PASSS", true);
			}
		}
		//Added on 25-Aug-2022 End
		
		//Added on 21-SEpt-2022 start
		public void newUI_EA_Yes_LetsDo_from_dashboard_verify() throws Exception
		{
			waitForElementToBeClickable(div_capion_ViewPaymentSchedule, "WaitViewPaymentSchedule");
			Thread.sleep(3000);
			if(btn_YesLetsDo_list.size() > 0)
			{
				assertTrue("Early Advance is not Applicable but stil showing button to proceed with, Hence FAIL", false);
			}
			else
			{
				assertTrue("Early Advance is not aApploicable and not showing button to proceed with, Hence PASSS", true);
			}
		}
		//Added on 21-SEpt-2022 End
		
	
	
	//Added on 16-Aug-2022 Start
		public void newUI_ReLoan_Yes_LetsDo_from_dashboard() throws Exception
		{
			waitForElementToBeClickable(btn_YesLetsDo, "WaitYesLetsDoRefinanceloanbutton");
			click(btn_YesLetsDo,"clkYesLetsDoRefinanceloan");
		}
		//Added on 16-Aug-2022 End
	
	}
