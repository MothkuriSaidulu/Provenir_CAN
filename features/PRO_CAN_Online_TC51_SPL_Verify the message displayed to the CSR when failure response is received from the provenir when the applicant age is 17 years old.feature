
##Scenario:: TC01_Verify the message displayed to the CSR when failure response is received from the provenir when the applicant age is 17 years old
Feature: TC51_Verify the message displayed to the CSR when failure response is received from the provenir when the applicant age is 17 years old

  @SPLApproved
  Scenario: TC51_Verify the message displayed to the CSR when failure response is received from the provenir when the applicant age is 17 years old|TC51_New_SPL_Less17Year
   Given Genareted sin
   Given user click on signup customer
   And Pre-requisite data generation for customer
   And verify the phonenumber threshold
   When Create customer
   #And Run the TU query decile one
   And customer chooses SPL loan
   And Run the TU query general D "1" and FICO score "719"
   And User provides basic information for spl
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
   