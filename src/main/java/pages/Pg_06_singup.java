package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;

public class Pg_06_singup extends OnlineActions {

	public Pg_06_singup(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	
	@FindBy (how=How.XPATH, using = "//button[@class='mm-select__value']")
	public static WebElement Security_list;
	
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='What was your childhood nickname?']")
	public static WebElement Security_Question;
	
	@FindBy (how=How.XPATH, using = "//input[@autocomplete='none']")
	public static WebElement Security_answer;
	@FindBy (how=How.XPATH, using = "//input[@name='newPassword']")
	public static WebElement newpassword;
	@FindBy (how=How.XPATH, using = "//input[@name='confirmPassword']")
	public static WebElement confirmpassword;
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Create Account']")
	public static WebElement createaccount;
	
	public void singupdetails() throws Exception
	{
		waitForElementToBeClickable(Security_list,"Security_list");
		click(Security_list,"Security_list"); 
		click(Security_Question,"Security_Question"); 
		EnterText(Security_answer, getMapData.get("Answer"), "Answer");
		EnterText(newpassword, getMapData.get("Password"), " Password");
		EnterText(confirmpassword, getMapData.get("Password"), "Password ");
		
		click(createaccount,"createaccount"); 
		
	}

}
