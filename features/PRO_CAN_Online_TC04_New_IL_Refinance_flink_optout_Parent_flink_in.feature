##Scenario:: Test case 60329: TS_50_Refinance- Auto Fund- Parent loan option Flinks and Refinance loan with out Flinks Cancel/ Rescind_Automation
Feature: Online_IL_Refinance loan flink opt out and parent opt in

  @ILRefinanceApproved
  Scenario: Online_IL_Refinance_loan_flink_opt_out_and_parent_opt in|TC_04_Refinance
    Given Genareted sin
    Given user click on signup customer
    And verify the phonenumber threshold
    ####And Verify the address threshold and update address
    When Create customer
    And customer chooses IL loan
    And Run the TU query decile one
    And User provides basic information
    And select flink opt in
    And check the flinks income details
    And signed the picra and submit application
  
   #####AUTO FUND
   #And Verify the phone OTP and enter valid OTP for autofund
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
  ####Then Run the TU query for refinance
  Then Run the TU query decile one refi
  ##Refinance origination
  
  And sign the customer
  And select the refinance loan new UI
  ####################And verify the existing customer details
   And select the flink consent new UI 
   And Verify the customer information new UI
   And signed the picra and submit application
   And Verify the phone OTP and enter valid OTP for autofund  
   #And Verify the loan approved amount
   And chosses the either LPP yes or no
   ####################And select the funding types
   ####################And Flinks bank details 
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