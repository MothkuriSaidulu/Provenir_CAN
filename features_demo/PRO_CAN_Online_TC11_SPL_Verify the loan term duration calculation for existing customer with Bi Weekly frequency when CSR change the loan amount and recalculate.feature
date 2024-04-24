
##Scenario:: TC14-Verify the loan term duration calculation for existing customer with Bi Weekly frequency when CSR change the loan amount and recalculate.
Feature: TC57_Verify the loan term duration calculation for existing customer with Bi Weekly frequency when CSR change the loan amount and recalculate.

  @SPLApproved
  Scenario: PRO_CAN_Online_TC11_SPL_Verify the loan term duration calculation for existing customer with Bi Weekly frequency when CSR change the loan amount and recalculate|TC11_Exing_SPL_Appr_TermRecalc

   Given Pre-requisite data load for customer
   And sign the customer
   And customer chooses SPL loan
   And User provides basic information for spl reloan
   And select the flink consent
   And Provides income information Every 2 weeks
   And signed the picra and submit application
   ##OTP ONLINE CHANGE 
   Then Send verification code and get and enter otp and validate
   And select the funding types
   And select the bank
   And upload document
   And verify the loan status and update loan status in DB
   And click on Finalize and e-Sign Loan Documents
   And Loan approval screen
   And Loan approved final offer
   And funding and payment confirmation
   And esing document SPL and back to dashboard 
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