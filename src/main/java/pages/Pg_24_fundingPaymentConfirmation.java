package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;

public class Pg_24_fundingPaymentConfirmation extends OnlineActions {

	public Pg_24_fundingPaymentConfirmation(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	
	@FindBy (how=How.XPATH, using = "//button[text()='Next']")
	public static WebElement btm_next;
	
	
	
	public void fundingPaymentConfirmation() throws Exception
	{
		Thread.sleep(8000);
		
		click(btm_next,"Nex button"); 
		
		
	}
	
	
	}
