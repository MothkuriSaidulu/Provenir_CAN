package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;



public class Pg_15_fundingPaymentConfirmation extends OnlineActions {

	//WebDriver driver;
		public Pg_15_fundingPaymentConfirmation(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
		}

		
	
		@FindBy (how=How.XPATH, using = "//div[contains(@class,'mm-alerts')]")
		public static WebElement txt_fundrecieving_type;
		
	@FindBy (how=How.XPATH, using = "//div[normalize-space()='Direct Deposit']")
	public static WebElement txt_fundingtype;
	
	@FindBy (how=How.XPATH, using = "//div[normalize-space()='BANK OF MONTREAL']")
	public static WebElement txt_bankdetails;
	
	//@FindBy (how=How.XPATH, using = "//button[normalize-space()='Next']") //Commented on 31-Oct-2022
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Continue']") //Added on 31-Oct-2022
	public static WebElement next_button;
	
	
	@FindBy (how=How.XPATH, using = "//h1[normalize-space()='Excellent!']")
	public static WebElement txt_page_validation;
	
	@FindBy (how=How.XPATH, using = "//div[normalize-space()='ROYAL BANK OF CANADA']")
	public static WebElement ROYAL_BANK_CANADA;
	
	@FindBy (how=How.XPATH, using = "//img[@class='image image-sizedd']//following::div[1]/div[1]")
	public static WebElement banktype;
	
	//Added on 01-Nov-2022 Start
	@FindBy (how=How.XPATH, using = "//img[@class='image image-sizedd']//following::div[1]/div[1]")
	public static List<WebElement> banktype_List;
	
	@FindBy (how=How.XPATH, using = "//h1[text()='Excellent!']")
	public static WebElement caption_Excellent;
	//Added on 01-Nov-2022 Ends
	
	//@FindBy (how=How.XPATH, using = "//button[text()='Next']") //Commented on 31-Oct-2022
	@FindBy (how=How.XPATH, using = "//button[text()='Continue']") //Added on 31-Oct-2022
	public static WebElement btm_next;
	
	
	
	public void fundingPaymentConfirmation() throws Exception
	{
		Thread.sleep(8000);
		//waitForElementToBeVisible(btm_next, "next_button"); comment on 08-July-2022
		
		click(btm_next,"Next button"); 
		
		
	}
	
	public void paymentconfirmation_DD() throws Exception
	{
		
		
			//waitForElementToBeVisible(txt_fundingtype, "Direct Deposit");
			//waitForElementToBeVisible(txt_bankdetails, "BANK OF MONTREAL");
		
		//VerifyText_For_PageCaption(txt_page_validation, "Excellent!", "Basic Info Page, Hence Passed");
		
		
		
		
		Thread.sleep(4000);
		
		
		waitForElementToBeVisible(caption_Excellent, "HeaderExcellent"); //Added on 01-Nov-2022
		
		
		/* Commneted again on 01-Nov-2022 Start
		//Added on 01-Nov-2022 Start
		if(banktype_List.size() > 0)
		{
			waitForElementToBeVisible(banktype, "Banktype"); //Added on 10-Oct-2022
			String bankname=banktype.getText();
			
			System.out.println("Bank name"+":"+bankname);
			
			if(bankname.equalsIgnoreCase("ROYAL BANK OF CANADA"))
			{
				waitForElementToBeVisible(next_button, "next_button");
				click(next_button,"movetoesignpage");
			}
			else if (bankname.equalsIgnoreCase("BANK OF MONTREAL"))
			{
				waitForElementToBeVisible(next_button, "next_button");
				click(next_button,"movetoesignpage");
			}
			
		}
		
		waitForElementToBeVisible(next_button, "next_button");
		scrollIntoView(next_button); //Added on 01-Nov-2022 
		Thread.sleep(2000); //Added on 01-Nov-2022 
		click(next_button,"movetoesignpage");
		//Added on 01-Nov-2022 End
		Commneted again on 01-Nov-2022 End
		 */
		
		
		//Commented on 01-Nov-2022 Start
		
		waitForElementToBeVisible(banktype, "Banktype"); //Added on 10-Oct-2022
		String bankname=banktype.getText();
		
		System.out.println("Bank name"+":"+bankname);
		
		if(bankname.equalsIgnoreCase("ROYAL BANK OF CANADA"))
		{
			waitForElementToBeVisible(next_button, "next_button");
			click(next_button,"movetoesignpage");
		}
		else if (bankname.equalsIgnoreCase("BANK OF MONTREAL"))
		{
			waitForElementToBeVisible(next_button, "next_button");
			click(next_button,"movetoesignpage");
		}
		else
		{
			waitForElementToBeVisible(next_button, "next_button");
			click(next_button,"movetoesignpage");
		}
		//Commented on 01-Nov-2022 End
		
		/*
		 * Actions actions = new Actions(driver);
		 * actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		 * actions.moveToElement(next_button).click();
		 * 
		 * //waitForElementToBeVisible(next_button, "next_button");
		 */			//click(next_button,"movetoesignpage");
		Thread.sleep(2000);
					
	}
	
	
	}
