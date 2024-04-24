
##Scenario:: (#45P2) PRO_CAN_Online_TC61_ON_Verify the EPP Terms pay frequency for customer with Bi-Monthly frequency
Feature: PRO_CAN_Online_TC61_ON_Verify the EPP Terms pay frequency for customer with Bi-Monthly frequency

  @SPLEPPApproved
   Scenario: PRO_CAN_Online_TC15_ON_Verify the EPP Terms pay frequency for customer with Bi-Monthly frequency|TC15_2SplCls_EPP_BiMontly
   
   
   Given Pre-requisite data load for customer
   And sign the customer
   And customer chooses SPL loan
   And User provides basic information for spl reloan
   And select the flink consent
   And Provides income information Twice a Month - otherwise
   And signed the picra and submit application
   ##OTP ONLINE CHANGE 
   Then Send verification code and get and enter otp and validate
   And select the funding types
   And select the bank
   And upload document
   And verify the loan status and update loan status in DB
   And click on Finalize and e-Sign Loan Documents
   And Loan approved final offer
   And funding and payment confirmation
   And esing document SPL and back to dashboard
   And show Loan payment schedule 
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
   
 