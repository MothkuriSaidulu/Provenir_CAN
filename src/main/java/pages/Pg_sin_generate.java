package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;


public class Pg_sin_generate extends OnlineActions {

	public Pg_sin_generate(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	

@FindBy (how=How.XPATH, using = "//font")
public static WebElement caption_sinForValidOrInvalid;

@FindBy (how=How.XPATH, using = "//font/strong")
public static WebElement caption_FinalSin;


	@FindBy (how=How.XPATH, using = "(//p)[2]") 
	public static WebElement caption_RansomSin;

	@FindBy (how=How.XPATH, using = "//input[@id='sin']")
	public static WebElement text_sin;
	
	@FindBy (how=How.XPATH, using = "//input[@value='Validate SIN']")
	public static WebElement text_validate;

	//New flinks page with changes
	
	
	public String  sinGenerate() throws Exception {
		
		
		String finalSinValid = "NOTVALIDSIN";
		waitForElementToBeClickable(caption_RansomSin,"WaitRandomSin");
		String gotSin = caption_RansomSin.getText();
		System.out.println("gotSin"+gotSin);
		int indOfcollon = gotSin.indexOf(":");
		String finalSin =  gotSin.substring(indOfcollon+2);
		EnterText(text_sin, finalSin, "txtsin");
		click(text_validate, "clkValidateSin");
		String validatedString = caption_sinForValidOrInvalid.getText();
		System.out.println(validatedString);
		logger.info(validatedString);
		if(validatedString.contains("valid"))
		{
			finalSinValid = caption_FinalSin.getText();
			datatable.setCellDataForTestData_online(testCaseName, "SIN", 1, "'"+finalSin);
			System.out.println("VALID SIN "+finalSinValid);
		}
		else
		{
			return finalSinValid;
		}
		return finalSinValid;
		}
		
	}
	

	


