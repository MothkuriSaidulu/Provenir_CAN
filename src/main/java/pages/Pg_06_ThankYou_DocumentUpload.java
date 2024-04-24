package pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import  actions.OnlineActions;
import  driver.TestBase;
import  sqlUtils.MsSqlUtility;



public class Pg_06_ThankYou_DocumentUpload extends OnlineActions {

	public Pg_06_ThankYou_DocumentUpload(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	//Thank you page
	//@FindBy (how=How.XPATH, using = "//h1[normalize-space()='Thank You for your Application!']") //Commented on 10-Nov-2022 Un Commented on 14-Nov-2022 Commented on 30-Nov-2022
	@FindBy (how=How.XPATH, using = "//h1[text()='Almost done!']") //Added on 10-Nov-2022 //Commented on 14-Nov-2022 Un-Commented on 30-Nov-2022
	public static WebElement txt_ThankYou;

	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Upload Documents']")
	public static WebElement btn_UploadDocs;

	@FindBy (how=How.XPATH, using = "//div[@title='Upload Documents']")
	public static WebElement btn_UploadDocs1;

	@FindBy (how=How.XPATH, using = "//span[normalize-space()='Upload Photo ID']/preceding-sibling::span")
	public static WebElement radio_UploadPhotoID;

	@FindBy (how=How.XPATH, using = "//div[contains(@class,'mm-radio-menu__item mm-radio-menu__item--active')]//div[contains(@class,'mm-radio-menu__content')]//div[contains(@class,'upload-documents-page__menu-toggle-content')]//div[contains(@class,'mm-uploader mb-4')]//div[contains(@class,'mm-uploader__dropzone')]//div//div[contains(@class,'mm-uploader__text--link')][normalize-space()='or select files']")
	public static WebElement Upload_pics;

	@FindBy (how=How.XPATH, using = "//div[contains(@class,'mm-radio-menu__item mm-radio-menu__item--active')]//input[contains(@type,'file')]")
	//@FindBy (how=How.XPATH, using = "//input[(@type='file')]")
	public static WebElement Upload_pic;
	
	
	/* This is by chandu - need to investigate and apply if needed - Added on 31-Oct-2022 Start
    @FindBy (how=How.XPATH, using = "(//div[contains(@class,'mm-radio-menu__item mm-radio-menu__item--active')]//input[contains(@type,'file')])[2]")  //new dt change 10/17/2022 chandu
    public static WebElement Upload_pic;
    Added on 31-Oct-2022 End
	*/
	
	//@FindBy (how=How.XPATH, using = "//button[normalize-space()='Upload']") //Commented on 31-Oct-2022
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Submit document(s)']") //Added on 31-Oct-2022
	public static WebElement btn_Upload;

	@FindBy (how=How.XPATH, using = "//i[@class='mm-icon iconuploaded mm-icon--check-circle']")
	public static WebElement Upload_Sucess_Tick;

	@FindBy (how=How.XPATH, using = "//a[normalize-space()='Account Portal']")
	public static WebElement btn_AccountPortal;
	
	//@FindBy (how=How.XPATH, using = "//button[normalize-space()='Go to Dasboard']") //Commented on 10-Apr-2023 Revised
	@FindBy (how=How.XPATH, using = "//button[normalize-space()='Go to Dashboard']") //Added on 10-Apr-2023 Revised
	public static WebElement btn_GoToDashboard;

	//CRM page 
	//Login page
	@FindBy (how=How.XPATH, using = "//input[@type='email']")
	public static WebElement txt_Email;

	@FindBy (how=How.XPATH, using = "//input[@type='submit']")
	public static WebElement btn_Next;

	@FindBy (how=How.XPATH, using = "//input[@name='passwd']")
	public static WebElement txt_Password;

	@FindBy (how=How.ID, using = "idBtn_Back")
	public static WebElement btn_No_ReduceSessionLogin;

	//After login select CRM
	@FindBy (how=How.ID, using = "AppLandingPage")
	public static WebElement iframe_CRM;

	@FindBy (how=How.ID, using = "WebResource_CustomHTMLforCases")
	public static WebElement iframe_DocReview;

	@FindBy (how=How.XPATH, using = "//div[@title='Dynamics 365 – custom']")
	public static WebElement DynamicCRM;

	@FindBy (how=How.XPATH, using = "//span[contains(@class,'symbolFont SearchButton-symbol')]")
	public static WebElement btn_Search;

	@FindBy (how=How.XPATH, using = "//input[@aria-label='Search box']")
	public static WebElement txt_Search;

	@FindBy (how=How.XPATH, using = "//span[@id='searchButtonIcon']")
	public static WebElement icon_search;

	@FindBy (how=How.XPATH, using = "//div[@class='customControl MscrmControls Grid.GridControl MscrmControls.Grid.GridControl']/div/ul/li[1]")
	public static WebElement User_FromSearch;

	@FindBy (how=How.XPATH, using = "//label[contains(normalize-space(),'WILLIAM BARNARD')]")
	public static WebElement Prod_User_FromSearch;

	@FindBy (how=How.XPATH, using = "//label[contains(normalize-space(),'TOMS HANK')]")
	public static WebElement Preview_User_FromSearch;

	@FindBy (how=How.XPATH, using = "//div[@class='customControl MscrmControls Grid.GridControl MscrmControls.Grid.GridControl']")
	public static WebElement Old_User_FromSearch;

	@FindBy (how=How.XPATH, using = "//h2[@title='PERSONAL INFORMATION']")
	public static WebElement PersonalInfo;

	@FindBy (how=How.XPATH, using = "//div[@data-id='tabpanel-SUMMARY_TAB']")
	public static WebElement SummaryTab;

	@FindBy (how=How.XPATH, using = "//h3[@aria-label='Timeline']")
	public static WebElement TimeLineTab;

	//	WebElement personal = driver.findElement(By.xpath("//h2[@title='PERSONAL INFORMATION']"));
	//	WebElement scrollArea = driver.findElement(By.xpath("//div[@data-id='tabpanel-SUMMARY_TAB']"));

	@FindBy (how=How.XPATH, using = "//div[normalize-space()='RECENT CASES']")
	public static WebElement txt_RecentCases;

	@FindBy (how=How.XPATH, using = "//div[@aria-label='The following documents are required in order to approve the loan Normal New']")
	public static List<WebElement> list_RecentCases;

	@FindBy (how=How.XPATH, using = "//span[@title='The following documents are required in order to approve the loan']")
	public static List<WebElement> list_RecentCases_old;
	
	@FindBy (how=How.XPATH, using = "//div[@aria-label='The following documents are required in order to approve the loan Normal New']")
	public static WebElement Case1;	
	
	@FindBy (how=How.XPATH, using = "//span[@title='The following documents are required in order to approve the loan']")
	public static WebElement Case1_old;
	
	@FindBy (how=How.XPATH, using = "//label[normalize-space()='The following documents are required in order to approve the loan']")
	public static WebElement Case12;

	@FindBy (how=How.XPATH, using = "//span[@id='expandIcon']")
	public static WebElement dd_ResolveCase;

	@FindBy (how=How.ID, using = "id-8d65dbdc-7b0c-44f8-9ecb-702690eaf155-134-header_dfc_casestatus8-header_dfc_casestatus.fieldControl-option-set-select")
	public static WebElement Click_Status;

	@FindBy (how=How.ID, using = "id-8d65dbdc-7b0c-44f8-9ecb-702690eaf155-130-header_dfc_casestatus3ef39988-22bb-4f0b-bbbe-64b5a3748aee-header_dfc_casestatus.fieldControl-option-set-select")
	public static WebElement Select_CaseStatus;
	
	@FindBy (how=How.XPATH, using = "id-8d65dbdc-7b0c-44f8-9ecb-702690eaf155-136-header_statecode8-header_statecode.fieldControl-option-set-select")
	public static WebElement Select_CaseStatus12;	
	
	@FindBy (how=How.XPATH, using = "//li[@aria-label='Document Review']")
	public static WebElement DocReview;

	@FindBy (how=How.XPATH, using = "//h2[@data-lp-id='form-sectionHeader-DocReview_LoanDocs']")
	public static WebElement txt_LoanDocs;

	@FindBy (how=How.XPATH, using = "//td[normalize-space()='Is Phone Number Valid?']")
	public static WebElement txt_PhoneValid;

	@FindBy (how=How.XPATH, using = "//td[normalize-space()='Is Phone Number Valid?']/child::input")
	public static WebElement check_PhoneValid;	

	@FindBy (how=How.XPATH, using = "//td[normalize-space()='Customer Identity verified?']")
	public static WebElement txt_CustValid;

	@FindBy (how=How.XPATH, using = "//td[normalize-space()='Customer Identity verified?']/child::input")
	public static WebElement check_CustValid;	

	@FindBy (how=How.XPATH, using = "//td[normalize-space()='Is Employment Valid?']")
	public static WebElement txt_EmpValid;

	@FindBy (how=How.XPATH, using = "//td[normalize-space()='Is Employment Valid?']/child::input")
	public static WebElement check_EmpValid;

	@FindBy (how=How.XPATH, using = "//td[normalize-space()='Is Contact Info Valid?']")
	public static WebElement txt_ContactValid;

	@FindBy (how=How.XPATH, using = "//td[normalize-space()='Is Contact Info Valid?']/child::input")
	public static WebElement check_ContactValid;

	@FindBy (how=How.XPATH, using = "//td[normalize-space()='Is Phone Number Valid?']")
	public static List<WebElement> List_txt_PhoneValid;

	@FindBy (how=How.XPATH, using = "//td[normalize-space()='Customer Identity verified?']")
	public static List<WebElement> List_txt_CustValid;

	@FindBy (how=How.XPATH, using = "//td[normalize-space()='Is Employment Valid?']")
	public static List<WebElement> List_txt_EmpValid;

	@FindBy (how=How.XPATH, using = "//td[normalize-space()='Is Contact Info Valid?']")
	public static List<WebElement> List_txt_ContactValid;

	@FindBy (how=How.XPATH, using = "//span[contains(text(),'Resolve Case')]")
	public static WebElement link_ResoveCase;

	@FindBy (how=How.XPATH, using = "//h1[normalize-space()='Resolve Case']")
	public static WebElement txt_Pop_Heading;

	@FindBy (how=How.XPATH, using = "//div[@data-id='resolution_id.fieldControl-text-box-container']")
	public static WebElement click_Resolution;

	@FindBy (how=How.XPATH, using = "//input[@data-id='resolution_id.fieldControl-text-box-text']")
	public static WebElement txt_Resolution;

	@FindBy (how=How.XPATH, using = "//button[@aria-label='Resolve']")
	public static WebElement btn_Resolve;

	@FindBy (how=How.XPATH, using = "//div[@aria-label='Resolved']")
	public static WebElement Status_Resolved;

	@FindBy (how=How.XPATH, using = "//span[@aria-label='Save & Close']")
	public static WebElement SaveAndClose;

	//Search loan fromm CRM using loan id

	@FindBy (how=How.XPATH, using = "//li[@aria-label='General']")
	public static WebElement Loan_General;

	@FindBy (how=How.XPATH, using = "//h3[normalize-space()='Cases']")
	public static WebElement Cases;

	@FindBy (how=How.XPATH, using = "//h3[normalize-space()='Cases']")
	public static List<WebElement> List_Cases;




	@FindBy (how=How.XPATH, using = "//div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/select")
	public static WebElement Select_CaseStatus1;
	
	@FindBy (how=How.XPATH, using = "//div[text()='browse for a file']")
	public static WebElement link_browseforafile;
	
	//Added on 31-Oct-2022 Start
	@FindBy (how=How.XPATH, using = "(//span[text()='Click here to upload'])[1]")
	public static WebElement link_As_button_Click_here_to_upload;
	//Added on 31-Oct-2022 End
	
	
	
	
	public static void Upload_Docs() throws Exception
	{
		waitForElementToBeVisible(txt_ThankYou, "Thank you text in upload docs");
		
		
		click(btn_UploadDocs,"Upload document");
		
		//waitForElementToBeClickable(Upload_pic, "Upload pic");
		//Upload_pic.sendKeys(rootPath+"\\Images\\3iLogo.PNG");
		
		/* Commented on 31-Oct-2022 Start
		waitForElementToBeClickable(link_browseforafile, "WaitLink");
		click(link_browseforafile, "Upload Icon");
		
		Commented on 31-Oct-2022 End
		*/
		
		//Added on 31-Oct-2022 Start
		waitForElementToBeClickable(link_As_button_Click_here_to_upload, "WaitLink");
		click(link_As_button_Click_here_to_upload, "Upload Icon");
		//Added on 31-Oct-2022 End
		
		
		
		
		
		
		 Thread.sleep(5000); // suspending execution for specified time period
		 
		    // creating object of Robot class
		    Robot rb = new Robot();
		 
		    // copying File path to Clipboard
		    StringSelection str = new StringSelection(rootPath+"\\Images\\AltirayLogo.PNG");
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		 
		     // press Contol+V for pasting
		     rb.keyPress(KeyEvent.VK_CONTROL);
		     rb.keyPress(KeyEvent.VK_V);
		 
		    // release Contol+V for pasting
		    rb.keyRelease(KeyEvent.VK_CONTROL);
		    rb.keyRelease(KeyEvent.VK_V);
		 
		    // for pressing and releasing Enter
		    rb.keyPress(KeyEvent.VK_ENTER);
		    rb.keyRelease(KeyEvent.VK_ENTER);
		    
		waitForElementToBeVisible(btn_Upload, "Upload btn");
		click(btn_Upload, "Upload btn");
		waitForElementToBeVisible(Upload_Sucess_Tick, "Upload success btn");
		TestBase.bindreport(currentGlobalScenarioName, "upload docs page");
		click(btn_GoToDashboard,"Go to Dashboard");
	}
	
	/* Original Commented on 08-Aug-2022 Start
	public static void Upload_Docs() throws Exception
	{
		waitForElementToBeVisible(txt_ThankYou, "Thank you text in upload docs");
		click(btn_UploadDocs,"Upload document");
		waitForElementToBeVisible(Upload_pic, "Upload pic");
		Upload_pic.sendKeys(rootPath+"\\Images\\3iLogo.PNG");
		waitForElementToBeVisible(btn_Upload, "Upload btn");
		click(btn_Upload, "Upload btn");
		waitForElementToBeVisible(Upload_Sucess_Tick, "Upload success btn");
		TestBase.bindreport(currentGlobalScenarioName, "upload docs page");
		click(btn_GoToDashboard,"Go to Dashboard");
	}
	Original Commented on 08-Aug-2022 End
	*/

	public void Upload_Docs_1SPL_2IL() throws Exception
	{
		waitForElementToBeVisible(txt_ThankYou, "Thank you text in upload docs");
		click(btn_UploadDocs,"Upload document");
		//click(radio_UploadPhotoID,"Upload photo id");
		Upload_pic.sendKeys(rootPath+"\\Images\\3iLogo.PNG");
		waitForElementToBeVisible(btn_Upload, "Upload btn");
		click(btn_Upload, "Upload btn");
		waitForElementToBeVisible(Upload_Sucess_Tick, "Upload success btn");
		click(btn_GoToDashboard,"Go to Dashboard");
	}

	public void Upload_Docs_IL1() throws Exception
	{
		//waitForElementToBeVisible(txt_ThankYou, "Thank you text in upload docs");
		//click(btn_UploadDocs,"Upload document");
		click(radio_UploadPhotoID,"Upload photo id");
		Upload_pic.sendKeys(rootPath+"\\Images\\3iLogo.PNG");
		waitForElementToBeVisible(btn_Upload, "Upload btn");
		click(btn_Upload, "Upload btn");
		waitForElementToBeVisible(Upload_Sucess_Tick, "Upload success btn");
		click(btn_GoToDashboard,"Go to Dashboard");
	}

	public void New_Upload_Doc() throws Exception
	{
		Thread.sleep(1500);
		click(btn_UploadDocs1,"Upload document");
		//click(radio_UploadPhotoID,"Upload photo id");
		Upload_pic.sendKeys(rootPath+"\\Images\\3iLogo1.PNG");
		waitForElementToBeVisible(btn_Upload, "Upload btn");
		click(btn_Upload, "Upload btn");
		waitForElementToBeVisible(Upload_Sucess_Tick, "Upload success btn");
		click(btn_GoToDashboard,"Go to Dashboard");
	}

	public void CRM_OpenNewTab_ResolveCase(String Loan) throws Exception
	{
		JavascriptExecutor jse = (JavascriptExecutor)TestBase.getDriver();
		jse.executeScript("window.open('')");
		ArrayList<String> tabs = new ArrayList<String>(TestBase.getDriver().getWindowHandles());
		TestBase.getDriver().switchTo().window(tabs.get(1));
		TestBase.getDriver().get(getPropertyValue("CRMURL"));
		EnterText(txt_Email, getPropertyValue("CRM_UserName"), "CRM username");
		click(btn_Next,"Next btn");
		EnterText(txt_Password, getPropertyValue("CRM_Password"), "CRM username");
		click(btn_Next,"login");
		click(btn_No_ReduceSessionLogin,"No btn");
		waitForElementToBeVisible(iframe_CRM, "iFrame in CRM");
		TestBase.getDriver().switchTo().frame(iframe_CRM);
		click(DynamicCRM,"Dynamic CRM");
		click(btn_Search,"Search btn");
		String LoanID = MsSqlUtility.getLoanId(getMapData.get("Email"))+"";
		EnterText(txt_Search, LoanID, "CRM search");
		click(icon_search,"Search");
		click(User_FromSearch,"User");
		waitForElementToBeVisible(Loan_General, "General tab"); 
		//		ScrollToDivElement(Cases, "Cases Tab");
		//		ScrollToDivElement(Cases, "Cases Tab");
		//		ScrollToDivElement(Cases, "Cases Tab");
		for(int i=1;i<60;i++)
		{
			if(List_Cases.size()>0)
			{
				ScrollToElement(Cases, "Cases Tab");
			}

			int j = list_RecentCases.size();
			if(j>0)
			{
				break;
			}
			else
			{
				//ScrollDown(250);
				Thread.sleep(1000);
			}

		}
		//	waitForElementToBeVisible(txt_RecentCases, "Recent cases");
		//		ScrollToElement(txt_RecentCases, "Recent cases");
		click(Case1,"Case");
		/*	click(Case1,"Case");
		click(dd_ResolveCase, "Dropdown case");
		Thread.sleep(1000);
		click(Select_CaseStatus,"Case status");
		Thread.sleep(1500);
		Select_CaseStatus.findElement(By.xpath("//option[. = 'Available']")).click();
		Thread.sleep(1500);
		click(Click_Status,"Status");
		Thread.sleep(1500);
		Select_CaseStatus.findElement(By.xpath("//option[. = 'Resolved']")).click();
		Thread.sleep(2000);
		 */		
		click(DocReview,"Document Review");
		waitForElementToBeVisible(txt_LoanDocs, "Loan documents");
		waitForElementToBeVisible(iframe_DocReview, "iFrame of docs review");
		TestBase.getDriver().switchTo().frame(iframe_DocReview);
		if(Loan.equalsIgnoreCase("1SPL_2IL"))
		{
			waitForElementToBeVisible(txt_EmpValid, "Valid Emp");
			if(List_txt_EmpValid.size()>0)
			{
				click(check_EmpValid,"Valid Emp");
			}
			if(List_txt_PhoneValid.size()>0)
			{
				waitForElementToBeVisible(txt_PhoneValid, "Phone valid text");
				click(check_PhoneValid,"Phone valid");
			}
			if(List_txt_ContactValid.size()>0)
			{
				waitForElementToBeVisible(txt_ContactValid, "Valid contact");
				click(check_ContactValid,"Valid Contact");
			}
			if(List_txt_CustValid.size()>0)
			{
				waitForElementToBeVisible(txt_CustValid, "Customer valid");
				click(check_CustValid,"Valid customer");
			}
		}
		else
		{
			waitForElementToBeVisible(txt_EmpValid, "Valid Emp");
			if(List_txt_EmpValid.size()>0)
			{
				click(check_EmpValid,"Valid Emp");
			}
			if(List_txt_PhoneValid.size()>0)
			{
				waitForElementToBeVisible(txt_PhoneValid, "Phone valid text");
				click(check_PhoneValid,"Phone valid");
			}
			if(List_txt_ContactValid.size()>0)
			{
				waitForElementToBeVisible(txt_ContactValid, "Valid contact");
				click(check_ContactValid,"Valid Contact");
			}
			if(List_txt_CustValid.size()>0)
			{
				waitForElementToBeVisible(txt_CustValid, "Customer valid");
				click(check_CustValid,"Valid customer");
			}
		}

		TestBase.getDriver().switchTo().defaultContent();
		click(dd_ResolveCase, "Dropdown case");
		Thread.sleep(1000);
		click(Select_CaseStatus,"Case status");
		Thread.sleep(1500);
		Select_CaseStatus.findElement(By.xpath("//option[. = 'Working']")).click();
		Thread.sleep(1500);
		click(link_ResoveCase,"Resolve Case");
		waitForElementToBeVisible(txt_Pop_Heading, "Popup heading");
		click(click_Resolution,"Resolution");
		EnterText(txt_Resolution, "Resolved by Auto", "Resolution");
		click(btn_Resolve,"Resolve");
		Thread.sleep(4000);
		waitForElementToBeVisible(Status_Resolved, "Status resolved");
		TakeScreenshot("Case resolved status");
		//System.out.println("Status is  ------- "+Status_Resolved.getText());
		TestBase.getDriver().switchTo().defaultContent();
		Thread.sleep(2000);
		TestBase.getDriver().close();
		TestBase.getDriver().switchTo().window(tabs.get(0));
	}

	private void TakeScreenshot(String string) {
		// TODO Auto-generated method stub
		
	}

	public void Prod_CRM_OpenNewTab_ResolveCase(String Loan) throws Exception
	{
		JavascriptExecutor jse = (JavascriptExecutor)TestBase.getDriver();
		jse.executeScript("window.open('')");
		ArrayList<String> tabs = new ArrayList<String>(TestBase.getDriver().getWindowHandles());
		TestBase.getDriver().switchTo().window(tabs.get(1));
		TestBase.getDriver().get(getPropertyValue("CRMURL"));
		EnterText(txt_Email, getPropertyValue("CRM_UserName"), "CRM username");
		click(btn_Next,"Next btn");
		EnterText(txt_Password, getPropertyValue("CRM_Password"), "CRM username");
		click(btn_Next,"login");
		click(btn_No_ReduceSessionLogin,"No btn");
		waitForElementToBeVisible(iframe_CRM, "iFrame in CRM");
		TestBase.getDriver().switchTo().frame(iframe_CRM);
		click(DynamicCRM,"Dynamic CRM");
		click(btn_Search,"Search btn");
		EnterText(txt_Search,  getMapData.get("Email"), "CRM search");
		click(icon_search,"Search");
	//	click(Prod_User_FromSearch,"User");
		Thread.sleep(60000);
		
		
		
		//waitForElementToBeVisible(Loan_General, "General tab"); 
		/*

// The below is for PreviwC and above is for prod		
		String LoanID = MsSqlUtility.getLoanId(getMapData.get("Email"))+"";
		EnterText(txt_Search, LoanID, "CRM search");
		click(icon_search,"Search");
		click(User_FromSearch,"User");
		 */		

/*
		for(int i=1;i<60;i++)
		{
			if(List_Cases.size()>0)
			{
				ScrollToDivElement(Cases, "Cases Tab");
			}

			int j = list_RecentCases.size();
			if(j>0)
			{
				break;
			}
			else
			{
				//ScrollDown(250);
				Thread.sleep(1000);
			}

		}

		click(Case12,"Case");

		click(DocReview,"Document Review");
		waitForElementToBeVisible(txt_LoanDocs, "Loan documents");
		waitForElementToBeVisible(iframe_DocReview, "iFrame of docs review");
		driver.switchTo().frame(iframe_DocReview);
		if(Loan.equalsIgnoreCase("1SPL_2IL"))
		{
			waitForElementToBeVisible(txt_EmpValid, "Valid Emp");
			click(check_EmpValid,"Valid Emp");
			waitForElementToBeVisible(txt_CustValid, "Customer valid");
			click(check_CustValid,"Valid customer");
		}
		else
		{
			waitForElementToBeVisible(txt_EmpValid, "Valid Emp");
			if(List_txt_EmpValid.size()>0)
			{
				click(check_EmpValid,"Valid Emp");
			}
			if(List_txt_PhoneValid.size()>0)
			{
				waitForElementToBeVisible(txt_PhoneValid, "Phone valid text");
				click(check_PhoneValid,"Phone valid");
			}
			if(List_txt_ContactValid.size()>0)
			{
				waitForElementToBeVisible(txt_ContactValid, "Valid contact");
				click(check_ContactValid,"Valid Contact");
			}
			if(List_txt_CustValid.size()>0)
			{
				waitForElementToBeVisible(txt_CustValid, "Customer valid");
				click(check_CustValid,"Valid customer");
			}
		}

		driver.switchTo().defaultContent();
		click(dd_ResolveCase, "Dropdown case");
*/		Thread.sleep(1000);
		
/*		click(Select_CaseStatus,"Case status");
		Thread.sleep(1500);
		Select_CaseStatus.findElement(By.xpath("//option[. = 'Working']")).click();
*/		Thread.sleep(1500);
		
/*		click(Click_Status,"Case status");
		Thread.sleep(1500);
		Click_Status.findElement(By.xpath("//option[. = 'Working']")).click();
		Thread.sleep(1500);
		
		
		click(link_ResoveCase,"Resolve Case");
		waitForElementToBeVisible(txt_Pop_Heading, "Popup heading");
		click(click_Resolution,"Resolution");
		EnterText(txt_Resolution, "Resolved by Auto", "Resolution");
		click(btn_Resolve,"Resolve");
		Thread.sleep(4000);
		waitForElementToBeVisible(Status_Resolved, "Status resolved");
		TakeScreenshot("Case resolved status");
		//System.out.println("Status is  ------- "+Status_Resolved.getText());
*/		TestBase.getDriver().switchTo().defaultContent();
		Thread.sleep(2000);
		TestBase.getDriver().close();
		TestBase.getDriver().switchTo().window(tabs.get(0));
	}

	public void PreviewC_CRM_OpenNewTab_ResolveCase(String Loan) throws Exception
	{
		JavascriptExecutor jse = (JavascriptExecutor)TestBase.getDriver();
		jse.executeScript("window.open('')");
		ArrayList<String> tabs = new ArrayList<String>(TestBase.getDriver().getWindowHandles());
		TestBase.getDriver().switchTo().window(tabs.get(1));
		TestBase.getDriver().get(getPropertyValue("CRMURL"));
		EnterText(txt_Email, getPropertyValue("CRM_UserName"), "CRM username");
		click(btn_Next,"Next btn");
		EnterText(txt_Password, getPropertyValue("CRM_Password"), "CRM username");
		click(btn_Next,"login");
		click(btn_No_ReduceSessionLogin,"No btn");
		waitForElementToBeVisible(iframe_CRM, "iFrame in CRM");
		TestBase.getDriver().switchTo().frame(iframe_CRM);
		click(DynamicCRM,"Dynamic CRM");
		click(btn_Search,"Search btn");


		// The below is for PreviwC and above is for prod		
		EnterText(txt_Search,  getMapData.get("Email"), "CRM search");
		click(icon_search,"Search");
		click(Preview_User_FromSearch,"User");

		waitForElementToBeVisible(PersonalInfo, "Personal info");
		ScrollToElement(SummaryTab, "Summary Tab");
		ScrollToElement(SummaryTab, "Summary Tab");
		ScrollToElement(SummaryTab, "Summary Tab");

		for(int i=1;i<60;i++)
		{
			if(List_Cases.size()>0)
			{
				ScrollToElement(Cases, "Cases Tab");
			}

			int j = list_RecentCases.size();
			if(j>0)
			{
				break;
			}
			else
			{
				//ScrollDown(250);
				Thread.sleep(1000);
			}

		}

		click(Case1,"Case");

		click(DocReview,"Document Review");
		waitForElementToBeVisible(txt_LoanDocs, "Loan documents");
		waitForElementToBeVisible(iframe_DocReview, "iFrame of docs review");
		TestBase.getDriver().switchTo().frame(iframe_DocReview);
		if(Loan.equalsIgnoreCase("1SPL_2IL"))
		{
			waitForElementToBeVisible(txt_EmpValid, "Valid Emp");
			click(check_EmpValid,"Valid Emp");
			waitForElementToBeVisible(txt_CustValid, "Customer valid");
			click(check_CustValid,"Valid customer");
		}
		else
		{
			waitForElementToBeVisible(txt_EmpValid, "Valid Emp");
			if(List_txt_EmpValid.size()>0)
			{
				click(check_EmpValid,"Valid Emp");
			}
			if(List_txt_PhoneValid.size()>0)
			{
				waitForElementToBeVisible(txt_PhoneValid, "Phone valid text");
				click(check_PhoneValid,"Phone valid");
			}
			if(List_txt_ContactValid.size()>0)
			{
				waitForElementToBeVisible(txt_ContactValid, "Valid contact");
				click(check_ContactValid,"Valid Contact");
			}
			if(List_txt_CustValid.size()>0)
			{
				waitForElementToBeVisible(txt_CustValid, "Customer valid");
				click(check_CustValid,"Valid customer");
			}
		}

		TestBase.getDriver().switchTo().defaultContent();
		click(dd_ResolveCase, "Dropdown case");
		Thread.sleep(1000);
		click(Select_CaseStatus,"Case status");
		Thread.sleep(1500);
		Select_CaseStatus.findElement(By.xpath("//option[. = 'Working']")).click();
		Thread.sleep(1500);
		click(link_ResoveCase,"Resolve Case");
		waitForElementToBeVisible(txt_Pop_Heading, "Popup heading");
		click(click_Resolution,"Resolution");
		EnterText(txt_Resolution, "Resolved by Auto", "Resolution");
		click(btn_Resolve,"Resolve");
		Thread.sleep(4000);
		waitForElementToBeVisible(Status_Resolved, "Status resolved");
		TakeScreenshot("Case resolved status");
		//System.out.println("Status is  ------- "+Status_Resolved.getText());
		TestBase.getDriver().switchTo().defaultContent();
		Thread.sleep(2000);
		TestBase.getDriver().close();
		TestBase.getDriver().switchTo().window(tabs.get(0));
	}
}
