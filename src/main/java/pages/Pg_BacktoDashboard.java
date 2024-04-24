package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;



public class Pg_BacktoDashboard extends OnlineActions {

	//WebDriver driver;
		public Pg_BacktoDashboard(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
		}


	
	@FindBy (how=How.XPATH, using = "//div[@id='standard']")
	public static WebElement non_flink_select;
	
	@FindBy (how=How.XPATH, using = "//button[@id='gs-accept']")
	public static WebElement next_button;
	
	public void flink_select() throws Exception
	{
		
		click(non_flink_select,"Non-flink option"); 
		click(next_button,"next button "); 
					
	}
	
	
	}
