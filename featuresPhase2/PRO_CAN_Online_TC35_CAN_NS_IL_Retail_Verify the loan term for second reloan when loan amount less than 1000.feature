##Scenario:: CAN_NS_IL_Retail_Verify the loan term for second reloan when loan amount < 1000
Feature: TC35_CAN_NS_IL_Retail_Verify the loan term for second reloan when loan amount < 1000

  @ILreloanApproved
  Scenario: TC35_CAN_NS_IL_Retail_Verify the loan term for second reloan when loan amount < 1000|TC35_IL_2Reloan_Lt1k
   Given Genareted sin
   Given user click on signup customer
   And Pre-requisite data generation for customer
   And verify the phonenumber threshold
   When Create customer
   And customer chooses IL loan
   And Run the TU query general D to get less than oneK "1" and FICO score "719"
   And User provides basic information
   And select the flink consent
   And Provides income information
   And signed the picra and submit application
   ################# Review ################# 
   And verify the funding screen and chosses the funding type
   And add the bank details
   And upload document
   And verify the loan status and update loan status in DB
   And click on Finalize and e-Sign Loan Documents 
   And Verify the loan approved amount
   And chosses the either LPP yes or no
   And Go Next
   And Verify the loan documents
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
   
   
   ## RELOAN 1
   And Backdate loan and get make a payment button
 	 Then Make a full payment
   And Backdate loan 180 days
  
   #################################GENERIC####################################
   And Run the TU query general D to get less than oneK ReRefiEA "1" and FICO score "719"
   #################################GENERIC####################################
   And select the reloan new UI
   And select the flink consent new UI 
   ###And Verify the customer information new UI###
   And Verify the customer information new UI Monthly
   And signed the picra and submit application
   And upload document
   And verify the loan status and update loan status in DB
   And click on Finalize and e-Sign Loan Documents 
   And Verify the loan approved amount
   And chosses the either LPP yes or no 
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
   
   ## RELOAN 2
   And Backdate loan and get make a payment button
 	 Then Make a full payment
   And Backdate loan 180 days
  
   #################################GENERIC####################################
   And Run the TU query general D to get less than oneK ReRefiEA "1" and FICO score "719"
   #################################GENERIC####################################
   And select the reloan new UI
   And select the flink consent new UI 
   ###And Verify the customer information new UI###
   And Verify the customer information new UI Monthly
   And signed the picra and submit application
   And upload document
   And verify the loan status and update loan status in DB
   And click on Finalize and e-Sign Loan Documents 
   And Verify the loan approved amount
   And chosses the either LPP yes or no 
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