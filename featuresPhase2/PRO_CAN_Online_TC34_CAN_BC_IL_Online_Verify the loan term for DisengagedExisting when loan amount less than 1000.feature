
##Scenario:: CAN_BC_IL_Online_Verify the loan term for DisengagedExisting when loan amount < 1000
Feature: TC34_CAN_BC_IL_Online_Verify the loan term for DisengagedExisting when loan amount < 1000

  @SPLApproved
  Scenario: TC34_CAN_BC_IL_Online_Verify the loan term for DisengagedExisting when loan amount < 1000|TC34_IL_ExingDisengaged

   Given Genareted sin
   Given user click on signup customer
   And Pre-requisite data generation for customer
   And verify the phonenumber threshold
   When Create customer
   And customer chooses SPL loan
   And Run the TU query general D "1" and FICO score "719"
   And User provides basic information for spl
   ####################################################################And select the flink consent
   And Provides income information
   And signed the picra and submit application
   And  enter valid OTP
   And add the bank details
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

   And Backdate loan and get make a payment button
 	 Then Make a full payment spl
   And Backdate loan 367 days spl


   ####
   ####And sign the customer
   ####
   
   ### NEW IL ###
   And Run the TU query general D to get less than oneK "1" and FICO score "719"
   And customer chooses IL loan
   And User provides basic information DisEngaged Existing IL
   And select the flink consent
   And Provides income information DisEngagedExisting IL
   And signed the picra and submit application
   ################# Auto Fund
   #And Verify the phone OTP and enter valid OTP for autofund
   #And chosses the either LPP yes or no
   #And select the funding types
   #And add the bank details
   #And Verify the loan documents
     
   ################# Review ################# 
   And verify the funding screen and chosses the funding type
   ###########################################################And add the bank details
   And select the bank
   And upload document
   And verify the loan status and update loan status in DB
  
   And click on Finalize and e-Sign Loan Documents 
   And Verify the loan approved amount
   And chosses the either LPP yes or no
   And Go Next
   And Verify the loan documents
   
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
   