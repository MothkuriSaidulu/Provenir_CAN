package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;
import driver.TestBase;



public class Pg_18_LoanDecision extends OnlineActions {

	//WebDriver driver;
		public Pg_18_LoanDecision(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
		}


		@FindBy (how=How.XPATH, using = "//h1[normalize-space()='Perfect!']")
		public static WebElement txt_fundingpage;
	
		Pg_11_PhoneOTP  obj_phoneverification=new Pg_11_PhoneOTP(TestBase.getDriver());
		Pg_09_Funding obj_funding=new Pg_09_Funding(TestBase.getDriver());
		Pg_10_Payment obj_bank=new Pg_10_Payment(TestBase.getDriver());
		
	public void Loandecision_new() throws Exception
	{
		Thread.sleep(3000);
		String strUrl = TestBase.getDriver().getCurrentUrl();
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

		System.out.println("Wait update the loan status in DB"+"URL:::"+strUrl);
		
		String loanprotection="loan-application/loan-protection";
		String phoneverification="loan-application/verification/info";
		String phoneverfication2= "loan-application/verification";
		String fundingselection="loan-application/funding";
		
		String str1=strUrl.substring(25);
		System.out.println("Page name:::"+str1);
		
		if(str1.equalsIgnoreCase(phoneverification) ||str1.equalsIgnoreCase(phoneverfication2))
		{
			
			
			String phone=obj_phoneverification.phonenumber_valid.getText();
			obj_phoneverification.phone_verification_invalidopt();
			obj_funding.Funding_Method();
		}
		else if(str1.equalsIgnoreCase(fundingselection))
		{
			String funding=txt_fundingpage.getText();
			System.out.println("verify the text"+ funding);
			
			obj_funding.Funding_Method();
			
			
		}
		else if(str1.equalsIgnoreCase(loanprotection))
		{
			Pg_12_LoanApprovedScreen obj_approved_screen = new Pg_12_LoanApprovedScreen(TestBase.getDriver());
			obj_approved_screen.Approved_screen();
			
		}
		
	}
	
	public void Loandecision_Existing() throws Exception
	{
		Thread.sleep(3000);
		String strUrl = TestBase.getDriver().getCurrentUrl();
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

		System.out.println("Wait update the loan status in DB"+"URL:::"+strUrl);
		
		String loanprotection="loan-application/loan-protection";
		String phoneverification="loan-application/verification/info";
		String phoneverfication2= "loan-application/verification";
		String fundingselection="loan-application/funding";
		
		String str1=strUrl.substring(25);
		System.out.println("Page name:::"+str1);
		
		
		if(str1.equalsIgnoreCase(phoneverification) ||str1.equalsIgnoreCase(phoneverfication2))
		{
			
			
			String phone=obj_phoneverification.phonenumber_valid.getText();
			obj_phoneverification.phone_verification_invalidopt();
			obj_funding.Funding_Method();
			
		}
		else if(str1.equalsIgnoreCase(fundingselection))
		{
			String funding=txt_fundingpage.getText();
			System.out.println("verify the text"+ funding);
			
			obj_funding.Funding_Method();
			
			
		}
		else if(str1.equalsIgnoreCase(loanprotection))
		{
			Pg_12_LoanApprovedScreen obj_approved_screen = new Pg_12_LoanApprovedScreen(TestBase.getDriver());
			obj_approved_screen.Approved_screen();
			
		}
		
	}
	
	}
