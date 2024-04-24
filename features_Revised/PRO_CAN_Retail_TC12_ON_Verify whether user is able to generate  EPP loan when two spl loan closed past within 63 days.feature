
##Scenario:: (#56) PRO_CAN_Retail_TC45_ON_Verify whether user is able to generate  EPP loan when two spl loan closed past within 63 days
Feature: PRO_CAN_Retail_TC45_ON_Verify whether user is able to generate  EPP loan when two spl loan closed past within 63 days

  @SPLEPPApproved
   Scenario: PRO_CAN_Retail_TC12_ON_Verify whether user is able to generate  EPP loan when two spl loan closed past within 63 days|TC12_2SplCls_EPP_witn63
   
   ##SPL  3 - EPP
   Given Pre-requisite data load for customer
   And sign the customer
   And customer chooses SPL loan
   And User provides basic information for spl reloan
   And select the flink consent
   ##And Provides income information same Monthly reloan
   And Provides income information Monthly
   And signed the picra and submit application
     ##OTP ONLINE CHANGE 
   Then Send verification code and get and enter otp and validate
   And select the funding types
   And select the bank
   And upload document
   And verify the loan status and update loan status in DB
   And click on Finalize and e-Sign Loan Documents
   ######And Loan approval screen Not Needed for EPP
   And Loan approved final offer
   And funding and payment confirmation
   And esing document SPL and back to dashboard 
   And verify the DB validatioin for reloan
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
   
 