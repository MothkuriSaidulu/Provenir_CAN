package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;

public class Pg_10_crossell_screen extends OnlineActions {

	public Pg_10_crossell_screen(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	
	@FindBy (how=How.XPATH, using = "//div[@class='text-bold font-size3-0 line-height-4 mb-5']")
	public static WebElement crosssell_valid;
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Proceed with Cash Advance']")
	public static WebElement proces_SPL;
	
	
	@FindBy (how=How.XPATH, using = "//p[text()='No Thanks']")
	public static WebElement no_thanks;
	
	
	
	public void crosssell() throws Exception
	{
		
		
		//Get(denied_valid);
		
		VerifyText_For_PageCaption(crosssell_valid, "But you are Proceed with Cash Advance", "Basic Info Page, Hence Passed");
		
		waitForElementToBeClickable(proces_SPL,"Process with SPL loan");
		
		Thread.sleep(5000);
//		click(no_thanks,"no thanks"); 
//		Thread.sleep(5000);
		
		Actions actions = new Actions(getDriver());
		actions.moveToElement(proces_SPL).click().build().perform();
	}
	
	
	}
