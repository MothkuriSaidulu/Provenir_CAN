
##Scenario:: (#45P2) PRO_CAN_Retail_TC56_AB_Verify the EPP loan term duration calculation for New customer with Monthly and weekly frequency
Feature: PRO_CAN_Retail_TC56_AB_Verify the EPP loan term duration calculation for New customer with Monthly and weekly frequency

  @SPLEPPApproved
   Scenario: PRO_CAN_Retail_TC56_AB_Verify the EPP loan term duration calculation for New customer with Monthly and weekly frequency|TC56_EPP_TermDuration
   Given Genareted sin
   Given user click on signup customer
   And Pre-requisite data generation for customer
   And verify the phonenumber threshold
   When Create customer
   #And Run the TU query decile one
   And customer chooses SPL loan
   And Run the TU query general D "1" and FICO score "620"
   And User provides basic information for spl
   ###########And select the flink consent NOT Applicable for AB
   And Provides income information Multi Employer with Monthly Weekly frequency
   And signed the picra and submit application
   And  enter valid OTP
   #And select the funding types Not needed second iteration
   And add the bank details
   And upload document
   And verify the loan status and update loan status in DB
   And click on Finalize and e-Sign Loan Documents
   ########################And Loan approval screen NOT Applicable for AB
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
   
   ##SPL  2
   And Backdate loan and get make a payment button serven days back
 	 Then Make a full payment spl
   And Backdate loan 10 days spl
   
   And customer chooses SPL loan
   And User provides basic information for spl reloan
   ################And select the flink consent NOT APPLICABLE FOR AB Province
   And Provides income information Monthly
   And signed the picra and submit application
   And enter valid OTP
   And add the bank details
   ################And select the bank Not needed as above snippet is already covered this step
   And upload document
   And verify the loan status and update loan status in DB
   And click on Finalize and e-Sign Loan Documents
   #################And Loan approval screen NOT Applicable for AB Province
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
   