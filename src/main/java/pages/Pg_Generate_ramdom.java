package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;
import utils.UtilityMethods;


public class Pg_Generate_ramdom extends OnlineActions {

	public Pg_Generate_ramdom(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	public void preRequisiteDataLoad() throws IOException 
	{
		//Added on 07-July-2022 to load Updated FirstName & Email Address
		try {
			loadExcelData(testCaseName, testDataSetName);
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		//Added on 07-July-2022 to load Updated FirstName  & Email Address
		//Added on 06-July-2022 End
	}
	
	

	public void preRequisiteDataGeneration() throws IOException 
	{
		generatedCustomerName = UtilityMethods.generateRandomTextDynamically();
		
		generatedaccountnumber =UtilityMethods.getRandomNumberString(); //Added on 31-Oct-2022


		//Added on 06-July-2022 Start
			logger.info("=================Generated CustomerName====================");
			datatable.setCellDataForTestData_online(testCaseName, "FirstName", 1, "dave"+generatedCustomerName);
			datatable.setCellDataForTestData_online(testCaseName, "LastName", 1, "simpson"+generatedCustomerName);
			
			logLoanDetails.add("=================Customer Name====================");
			logLoanDetails.add(generatedCustomerName);
			UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
			logLoanDetails.clear();
			logLoanDetails.add("=================Customer Name====================");
				
			logger.info(generatedCustomerName);
			logger.info("=====================================");
		//Added on 06-July-2022 End

		generatedEmail = "dave_"+ generatedCustomerName+"@yopmail.com"; //Added on 06-July-2022

		//Added on 06-July-2022 Start
			logger.info("=================Generated Email====================");
			datatable.setCellDataForTestData_online(testCaseName, "eMail", 1, generatedEmail);
				
			logLoanDetails.add("=================Customer Email====================");
			logLoanDetails.add(generatedEmail);
			UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
			logLoanDetails.clear();
			logLoanDetails.add("=================Customer Email====================");
				
			logger.info(generatedEmail);
			logger.info("=====================================");
			
			
			//Added on 31-Oct-2022 Start
			
			logger.info("================= Account number ====================");
            
            System.out.println("Account number " + generatedaccountnumber);
            
            logLoanDetails.add(generatedaccountnumber);
            UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
            logLoanDetails.clear();
            
            datatable.setCellDataForTestData_online(testCaseName, "bank_AccountNo", 1, generatedaccountnumber);
            
            logger.info("===============================================");
			
          //Added on 31-Oct-2022 End
			
			
			
			
			
			
				
			//Added on 07-July-2022 to load Updated FirstName & Email Address
				try {
					loadExcelData(testCaseName, testDataSetName);
					} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				//Added on 07-July-2022 to load Updated FirstName  & Email Address
		//Added on 06-July-2022 End

	}
	
	
	
}
