package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;



public class Pg_19_Cross_Sell extends OnlineActions {

	//WebDriver driver;
		public Pg_19_Cross_Sell(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
		}


	
	@FindBy (how=How.XPATH, using = "//div[@class='text-bold font-size3-0 line-height-4 mb-5']")
	public static WebElement downsell_txt;
	
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Proceed with Cash Advance']")
	public static WebElement next_button;
	
	public void downsell_offer_screen() throws Exception
	{
		
		Thread.sleep(10000);
		waitForElementToBeVisible(downsell_txt, "downsell screen");
		Thread.sleep(2000);
		click(next_button,"Cash advance button "); 
					
	}
	
	
	
	
	}
