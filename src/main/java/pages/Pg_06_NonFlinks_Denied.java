package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;

public class Pg_06_NonFlinks_Denied extends OnlineActions {

	public Pg_06_NonFlinks_Denied(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	
	@FindBy (how=How.XPATH, using = "//div[@class='denialHeader']")
	public static WebElement header_Denied;
	
	@FindBy (how=How.XPATH, using = "//button[text()='Find a Store']")
	public static WebElement btn_REferToStore;
	
	
	
	
	public void verify_deniedMessage() throws Exception
	{
		waitForElementToBeVisible(btn_REferToStore, "ReferToStore");
		VerifyText(header_Denied, "Thank you for choosing Money Mart for your loan needs.", "VerifyDeniedText");
	}
	
	}
