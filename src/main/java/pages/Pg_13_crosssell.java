package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;

public class Pg_13_crosssell extends OnlineActions {

	public Pg_13_crosssell(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	
	@FindBy (how=How.XPATH, using = "//div[@class='mm-congrats-header']")
	public static WebElement approved_valid;
	@FindBy (how=How.XPATH, using = "//button[@class='mm-nonav-btn mm-btn--lg mm-btn--primary fill']")
	public static WebElement next_Approvedscreen;
	
	
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Next']")
	public static WebElement next_button;
	
		
	public void crosssell() throws Exception
	{
		
		
		//Get(denied_valid);
		waitForElementToBeClickable(approved_valid,"Process with SPL loan");
		
		VerifyText_For_PageCaption(approved_valid, "Verify your phone number", "Basic Info Page, Hence Passed");
		
		
		
		Thread.sleep(5000);
		click(next_Approvedscreen,"click on next button in approved popup screen"); 
		Thread.sleep(5000);
		
		click(next_button,"Clock on next button in approved screen");
		
		
	}
		
		
		
	}
	
	
	