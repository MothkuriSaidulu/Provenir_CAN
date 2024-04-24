##Scenario:: TC49_Retail_verify the 3rd early advance is displaying when customer is already having 2 early advance
Feature: TC49_Retail_verify the 3rd early advance is displaying when customer is already having 2 early advance

  @ILRefinanceApproved
  Scenario: TC49_Retail_verify the 3rd early advance is displaying when customer is already having 2 early advance|TC_49_EA_aftr_2EA
   #Given Genareted sin
   Given user click on signup customer
   And Pre-requisite data generation for customer
   And verify the phonenumber threshold
   When Create customer
   And Run the TU query decile one
   #And Run the TU query general D "2" and FICO score "719"
   And customer chooses IL loan
   And User provides basic information
   And select the flink consent
   And Provides income information
   And signed the picra and submit application
   
   And Verify the phone OTP and enter valid OTP for autofund
   And chosses the either LPP yes or no
   And select the funding types
   And add the bank details
   And Verify the loan documents
   
    #################REVIEW
    #And verify the funding screen and chosses the funding type
    #And add the bank details
    #And upload document
    #And verify the loan status and update loan status in DB
    #And click on Finalize and e-Sign Loan Documents 
    #And Verify the loan approved amount
    #And chosses the either LPP yes or no
    #And Go Next
    #And Verify the loan documents
    
   
  
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
   
   
   ## Early Advance 1 ##
   Then Make IL scheduler payments - early advance
   Then Run the TU query decile one refi
   #And Run the TU query general ReRefEa D "2" and FICO score "719"
   And update loan contract
   And sign the customer
   And select the refinance loan new UI
   And select the flink consent new UI 
   And Verify the customer information new UI
   And signed the picra and submit application
   And Verify the phone OTP and enter valid OTP for autofund  
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
   
   ## Early Advance 2 ##
   Then Make IL scheduler payments - early advance
   Then Run the TU query decile one refi
   #And Run the TU query general ReRefEa D "2" and FICO score "719"
   And update loan contract
   And sign the customer
   And select the refinance loan new UI
   And select the flink consent new UI 
   And Verify the customer information new UI
   And signed the picra and submit application
   And Verify the phone OTP and enter valid OTP for autofund  
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
   
    ## Early Advance 3 ##
   Then Make IL scheduler payments - early advance
   Then Run the TU query decile one refi
   #And Run the TU query general ReRefEa D "2" and FICO score "719"
   And update loan contract
   And sign the customer
   And Verify the refinance loan new UI - 3rd Early advance should not be allowed
  
  
  