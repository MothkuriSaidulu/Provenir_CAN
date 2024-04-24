##Scenario:: TC07_Verify loan decission for parent loan with decile8  Reloan loan with Decile6 and missing fico score
Feature: TC07_Verify loan decission for parent loan with decile8  Reloan loan with Decile6 and missing fico score

  @ILreloanApproved
  Scenario: TC07_Verify loan decission for parent loan with decile8  Reloan loan with Decile6 and missing fico score|TC07_P8R6_IL_Aprvd
   Given Genareted sin
   Given user click on signup customer
   And Pre-requisite data generation for customer
   And verify the phonenumber threshold
   When Create customer
   And Run the TU query general D "8" and FICO score "620"
   And customer chooses IL loan
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
   
   
   And Backdate loan and get make a payment button
 	 Then Make a full payment
   And Backdate loan 180days
  
   #################################GENERIC####################################
   And Run the TU query general ReRefEa D "6" and FICO score ""
   #################################GENERIC####################################
   And select the reloan new UI
   And select the flink consent new UI 
   And Verify the customer information new UI
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