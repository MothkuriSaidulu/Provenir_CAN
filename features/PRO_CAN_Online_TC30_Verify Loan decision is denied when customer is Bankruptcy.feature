##Scenario: TC30_Verify Loan decision is denied when customer is Bankruptcy

Feature: TC30_Verify Loan decision is denied when customer is Bankruptcy

  @ILApprovedd
  Scenario: TC30_Verify Loan decision is denied when customer is Bankruptcy|TC30_New_IL_Denied_Banktuptcies
    
     Given Genareted sin
     Given user click on signup 
     And Pre-requisite data generation for customer
     And verify the email threshold
     When Enter all details and create account
     And verify the phonenumber threshold
     And customer chooses IL loan
     And Run the TU query decile one Bankruptcies
     And User provides basic information
     And select the flink consent
     And Provides income information
     And signed the picra and submit application
     And Verify loan decision denied
     And verify the DB validatioin
     And verify the API validatioins
     And Show request for investigation
     And Show response for investigation
      
     ###log file
 	   And Initialize Loan Details and write to excel
     And log all the Loan details in logger for investigation
     And log all the Loandetail in logger for investigation
	   And log all the Note details in logger for investigation
	   And log all payment details in logger for investigation
	   And log all the LoanPaymentHeader in logger for investigation
	   And log all the LoanFee in logger for investigation
     And log all Transaction details in logger for investigation
     And log all the CustomerCredit in logger for investigation
     And log all EFTLog details in logger for investigation
     And log all ETransferLog details in logger for investigation
     