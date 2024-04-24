
##Scenario:: (#34P2) PRO_CAN_Retail_TC23_AB_Existing Engage_Verify Classification of Existing engage Loan when customer has fully paid-off SPL loan within last 6 months
Feature: PRO_CAN_Retail_TC23_AB_Existing Engage_Verify Classification of Existing engage Loan when customer has fully paid-off SPL loan within last 6 months

  @SPLApproved
  Scenario: PRO_CAN_Retail_TC23_AB_Existing Engage_Verify Classification of Existing engage Loan when customer has fully paid-off SPL loan within last 6 months|TC23_IL_ExingEngaged

   Given Genareted sin
   Given user click on signup customer
   And Pre-requisite data generation for customer
   And verify the phonenumber threshold
   When Create customer
   And customer chooses SPL loan
   And Run the TU query general D "1" and FICO score "719"
   And User provides basic information for spl
   ##########################################And select the flink consent Not needed for AB
   And Provides income information
   And signed the picra and submit application
   And  enter valid OTP
   And add the bank details
   And upload document
   And verify the loan status and update loan status in DB
   And click on Finalize and e-Sign Loan Documents
   ###################################And Loan approval screen Not needed
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
   And Backdate loan 160 days spl


   ####
   ####And sign the customer
   ####
   
   ### NEW IL ###
   And Run the TU query general D "1" and FICO score "719"
   And customer chooses IL loan
   And User provides basic information Engaged Existing IL
   And select the flink consent
   And Provides income information EngagedExisting IL
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
   