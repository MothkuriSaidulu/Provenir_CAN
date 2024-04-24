
##Scenario:: TC16_Verify the Net Pay Calculation for Existing Customer Bi-Weekly Frequency.
Feature: TC55_Verify the Net Pay Calculation for Existing Customer Bi-Weekly Frequency.

  @SPLApproved
  Scenario: PRO_CAN_Online_TC07_SPL_Verify the Net Pay Calculation for Existing Customer Bi-Weekly Frequency|TC07_Exing_SPL_Appr_BiWkly



	Given Pre-requisite data load for customer
  And sign the customer
  And customer chooses SPL loan 
  
  And User provides basic information for spl reloan
  And select the flink consent
   And Provides income information Every 2 weeks reloan change from Primary
  And signed the picra and submit application
  And enter valid OTP
  And select the bank
  And upload document
  And verify the loan status and update loan status in DB
  And click on Finalize and e-Sign Loan Documents
  And Loan approval screen
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