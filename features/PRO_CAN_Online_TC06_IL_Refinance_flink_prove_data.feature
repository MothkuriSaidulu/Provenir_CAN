
##Scenario:Test case 52677: TC37_E2E-IL-Refinance-Existing customer-Flinks opt in-Auto fund-Prove data with Fraud Flag
Feature: Online_IL_Refinance loan flink opt in

  @ILRefinanceApproved
  Scenario: Online_IL_Refinance_loan_flink_opt_in|TC_06_Refinance_prove
  Given Genareted sin
  Given user click on signup customer
    And verify the phonenumber threshold
    #########And Verify the address threshold and update address
    When Create customer
    And customer chooses IL loan
    #And Run the TU query decile one
    And Run the TU query general D "1" and FICO score "620"
    And User provides basic information
    And select flink opt in
    And check the flinks income details
    And signed the picra and submit application
    
    #Auto Fund
    #And Verify the phone OTP and enter valid OTP for autofund
    ############################And Verify the loan approved amount
    #And chosses the either LPP yes or no
    #And select the funding types
    #And Flinks bank details
    #And Verify the loan documents
   
    #################REVIEW
    And verify the funding screen and chosses the funding type
    ##BElow Snippt Created New for PreviewC Flinks
    And select the bank Flinks
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
  
   And update loan contract
   Then Make IL scheduler payments
   Then Run the TU query decile one refi
   # And update loan contract
   And sign the customer
   And select the refinance loan new UI
   #################################And verify the existing customer details
   And select the flink consent new UI - with flinks
   And New flink for refi 
   And Verify the customer information new UI
   And signed the picra and submit application
   
   ## Auto Fund ##
   #And Verify the phone OTP and enter valid OTP for autofund  
   #################################################And Verify the loan approved amount
   #And chosses the either LPP yes or no
   #################################################And select the funding types
   #################################################And Flinks bank details
   #And Verify the loan documents
   
   
   ###### Manula Review #####
   And upload document
   And verify the loan status and update loan status in DB
   And click on Finalize and e-Sign Loan Documents   
   And Verify the loan approved amount
   And chosses the either LPP yes or no
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