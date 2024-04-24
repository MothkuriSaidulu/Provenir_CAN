package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import actions.OnlineActions;

public class Pg_09_SPL_Presonalinfoscreeen extends OnlineActions{

	//WebDriver driver;
	public Pg_09_SPL_Presonalinfoscreeen(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy (how=How.XPATH, using = "//div[normalize-space()='Confirm your Province of Residence*']")
	public static WebElement province_spl;
	
	@FindBy (how=How.XPATH, using = "//div[@class='mm-form-field mm-gs-formfield mm-select']")
	public static WebElement select_dropdown;
	
	@FindBy (how=How.XPATH, using = "//select[@class='mm-select__native-input']//*")
	public static WebElement list_province;
	
	//select[@class='mm-select__native-input']//*
	
	@FindBy (how=How.XPATH, using = "//input[@name='address']")
	public static WebElement address;
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='No']")  //button[normalize-space()='Yes']
	public static WebElement rent_no;
	
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Yes']")  
	public static WebElement rent_yes;
	@FindBy (how=How.XPATH, using = "//input[@placeholder='$0']")  
	public static WebElement rent;
	
	@FindBy (how=How.XPATH, using = "//button[@Id='gs-accept']")
	public static WebElement next_page;
	
	@FindBy (how=How.XPATH, using = "//h1[normalize-space()='Welcome!']")
	public static WebElement Welcome_Valid;
	
	@FindBy (how=How.XPATH, using = "(//span[@class='mm-checkbox__box'])[1]")
	public static WebElement checkbox_one;
	
	@FindBy (how=How.XPATH, using = "(//span[@class='mm-checkbox__box'])[2]")
	public static WebElement checkbox_two;
	@FindBy (how=How.XPATH, using = "//input[@id='sin']")
	public static WebElement sin;
	
	public void click_personlinfo() throws Exception
	{
		
		VerifyText_For_PageCaption(Welcome_Valid, "Welcome!", "Basic Info Page, Hence Passed");
		VerifyText_For_PageCaption(province_spl, "Confirm your Province of Residence!", "Basic Info Page, Hence Passed");
		
		click(select_dropdown,"select province list");
		
		
		Select province = new Select(select_dropdown);
		
		province.selectByValue("ON");
		
		// Select the option using the visible text
		//province.selectByVisibleText("Ontario");
		
		EnterText(sin, getMapData.get("SIN"), "SIN");
		
		waitForElementToBeVisible(address, "Caption");
		Thread.sleep(4000);
		//EnterText(email_id, getMapData.get("Email"), "emailid");
		
		EnterText(address, getMapData.get("home_Address"), "customer address");
		
		Actions act = new Actions(getDriver());
		
		act.sendKeys(Keys.DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		//address.sendKeys(Keys.ARROW_DOWN);
		//address.sendKeys(Keys.ENTER);  
		Thread.sleep(4000);
		
		click(rent_yes, "Rent select yes");
		//click(rent, "click rent");
		//EnterText(rent, getMapData.get("Rent_Contribution"), "RentContribution");
		
		
		//WebElement elm = driver.findElement(By.xpath("//button[normalize-space()='No']"));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",elm);
		
		click(rent_no,"Rent selected no"); 
		Thread.sleep(4000);
		click(checkbox_one, "check the checkbox");
		
		click(checkbox_two, "check the checkbox");
	
		click(next_page,"Navigate to next page");
		
					
	}
	
	
	}
//Actions act = new Actions(driver);

//act.sendKeys(Keys.DOWN).perform();
		
//act.sendKeys(Keys.ENTER).perform();