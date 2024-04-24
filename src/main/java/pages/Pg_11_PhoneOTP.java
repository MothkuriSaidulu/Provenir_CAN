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

public class Pg_11_PhoneOTP extends OnlineActions {

	public Pg_11_PhoneOTP(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	
	@FindBy (how=How.XPATH, using = "//h1[normalize-space()='Verify your phone number']")
	public static WebElement phonenumber_valid;
	@FindBy (how=How.XPATH, using = "(//input[contains(@name,'phoneSelected')])[1]")
	public static WebElement radio_phone;
	
	
	//@FindBy (how=How.XPATH, using = "//button[contains(.,'Call Me')]")
	
	@FindBy (how=How.XPATH, using = "//button[text()='Call Me']")
	public static WebElement callme_button;
	
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Verify']")
	public static WebElement verify_phonenumbe;
	
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Next']")
	public static WebElement next_pagefrom_phonenumber;
	
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Next']")
	public static List<WebElement> next_pagefrom_phonenumber_popup;
	
	@FindBy (how=How.XPATH, using = "//span[@class='mm-form-field__message']")
	public static WebElement otp_fail_message;
	
	@FindBy (how=How.XPATH, using = "//input[@type='text']")
	public static WebElement text_opt;
	
	public void phone_verification() throws Exception
	{
		
		
		//Get(denied_valid);
		
		VerifyText_For_PageCaption(phonenumber_valid, "Verify your phone number", "Basic Info Page, Hence Passed");
		
		//waitForElementToBeClickable(radio_phone,"Process with SPL loan");
		
		Thread.sleep(5000);
		
		//waitForClickablility(radio_phone,10);
		//radio_phone.click();
		
		//click(radio_phone,"radio phone nubmer"); 
		waitForElementToBeVisible(callme_button, "WaitVisibleOfCallMe");
		if(callme_button.isDisplayed()) {
		
		click(callme_button,"call to opt");
		}
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("enter vaild phone number ");
		Thread.sleep(5000);
		
		
		MsSqlUtility obj=new MsSqlUtility();
		obj.getDbConnection2();
		String opt=obj.getMobileOTP( getMapData.get("eMail"));
		
		EnterText(text_opt, opt, "enter opt");
		waitForElementToBeVisible(verify_phonenumbe, "WaitVisibleOfotpfailmessage");
		click(verify_phonenumbe,"verified phone number");
		Thread.sleep(5000);
		
		
      
		if (next_pagefrom_phonenumber_popup.size()>0)
		{
			click(next_pagefrom_phonenumber,"Next button page"); 
		}
		
		}
	public void phone_verification_SPL() throws Exception
	{
		
		
		//Get(denied_valid);
		
		VerifyText_For_PageCaption(phonenumber_valid, "Verify your phone number", "Basic Info Page, Hence Passed");
		
		//waitForElementToBeClickable(radio_phone,"Process with SPL loan");
		
		Thread.sleep(5000);
		
		//waitForClickablility(radio_phone,10);
		//radio_phone.click();
		
		//click(radio_phone,"radio phone nubmer"); 
		waitForElementToBeVisible(callme_button, "WaitVisibleOfCallMe");
		if(callme_button.isDisplayed()) {
		
		click(callme_button,"call to opt");
		}
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("enter vaild phone number ");
		Thread.sleep(10000);
		
		
		MsSqlUtility obj=new MsSqlUtility();
		obj.getDbConnection2();
		String opt=obj.getMobileOTP( getMapData.get("eMail"));
		
		EnterText(text_opt, opt, "enter opt");
		waitForElementToBeVisible(verify_phonenumbe, "WaitVisibleOfotpfailmessage");
		click(verify_phonenumbe,"verified phone number");
		Thread.sleep(1000);
		
	
	}
	
	public void phone_verification_invalidopt() throws Exception
	{
		
		
		//Get(denied_valid);
		Thread.sleep(2000);
		//VerifyText_For_PageCaption(phonenumber_valid, "Verify your phone number", "Basic Info Page, Hence Passed");
		

		
		//click(radio_phone,"radio phone nubmer"); 
		//Thread.sleep(5000);
		VerifyText_For_PageCaption(phonenumber_valid, "Verify your phone number", "Basic Info Page, Hence Passed");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		//System.out.println(callme_button.isEnabled());
		
		//waitForElementToBeClickable(callme_button, "Waitbutton");
		waitForElementToBeVisible(callme_button, "WaitVisibleOfCallMe");
		if(callme_button.isDisplayed()) {
		mouseOverAndClick(TestBase.getDriver(), callme_button, "clickoncallme");
		
		System.out.println("WAITED");
		
		click(callme_button,"calltoopt");
		
		System.out.println("CLICKED");
		System.out.println("success");
		//Thread.sleep(50000);
		
		
		}
			
			//click(verify_phonenumbe,"verified phone number");
			Thread.sleep(2000);
			
			for(int i=0;i<=2;i++)
			{
			
				//waitForElementToBeVisible(otp_fail_message, "WaitVisibleOfotpfailmessage");
				text_opt.sendKeys(Keys.CONTROL + "a");
				text_opt.sendKeys(Keys.DELETE);
				EnterText(text_opt, "7890", "enter opt");
				waitForElementToBeVisible(verify_phonenumbe, "WaitVisibleOfotpfailmessage");
				if(verify_phonenumbe.isEnabled())
				{
				click(verify_phonenumbe,"verified phone number");
				}
			}
		Thread.sleep(3000);
		
		
	}
		
		
	}
	
	
	