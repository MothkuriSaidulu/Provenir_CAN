package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;

public class Pg_05_picra_page extends OnlineActions {

	public Pg_05_picra_page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	
	@FindBy (how=How.XPATH, using = "//span[@class='mm-checkbox__box']")
	public static WebElement PICRA_checkbox;
	
	@FindBy (how=How.XPATH, using = "//button[@id='gs-accept']")
	public static WebElement agree_button;
	
	@FindBy (how=How.XPATH, using = "//button[text()='Agree and Continue']")
	public static WebElement agreepop_button;
	@FindBy (how=How.XPATH, using = "//button[text()='Agree and Continue']")
	public static List<WebElement> agreepop_buttonlist;
	
	public void picra_details() throws Exception
	{
		
		//added 21 july 2022 start
		if (agreepop_buttonlist.size()>0)
		{
			click(agreepop_button,"agree button "); 
		}
		//added 21 july 2022 end
		click(PICRA_checkbox,"PICRA_checkbox"); 
		
		
		click(agree_button,"agree button "); 
		
		Thread.sleep(6000);
		
	}
	
	
	}
