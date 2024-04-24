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
import sqlUtils.MsSqlUtility;

public class Pg_21_OTPScreen extends OnlineActions{

	//WebDriver driver;
	public Pg_21_OTPScreen(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	
	//Home page	
	
	//a[normalize-space()='Loans']
	@FindBy (how=How.XPATH, using = "//h1[normalize-space()='Verify your mobile number']")
	public static WebElement otp_header;
	
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Send Verification Code']")
	public static WebElement otp_sent;
	
	
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Validate']")
	public static WebElement otp_validate;
	
	//input[1]
	
	@FindBy (how=How.XPATH, using = "//input[1]")
	public static WebElement otp_input;

	public void enter_otp() throws Exception
	{
	
		VerifyText_For_PageCaption(otp_header, "Verify your mobile number", "Basic Info Page, Hence Passed");
		
		waitForElementToBeVisible(otp_sent, "WaitVisibleOfCallMe");
		if(otp_sent.isDisplayed()) {
		
		click(otp_sent,"call to opt");
		}
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("enter vaild phone number ");
		Thread.sleep(5000); //Added on 20-July-2023 Revised changed 5k to 10k again 5k from 10k
		
		
		MsSqlUtility obj=new MsSqlUtility();
		obj.getDbConnection2();
		//Thread.sleep(5000); //Added on 20-July2023 Revised For demo Commented again
		String opt=obj.getOnlineOTP( getMapData.get("eMail"));
		System.out.println("OTP number:: "+opt);
		Thread.sleep(2000);//Added on 27-July2023 Revised For demo
		EnterText(otp_input, opt, "enter opt");
		Thread.sleep(2000);//Added on 20-July2023 Revised For demo
		waitForElementToBeVisible(otp_validate, "WaitVisibleOfotpfailmessage");
		click(otp_validate,"verified phone number");
		Thread.sleep(5000);
	
}
}
