##Scenario:: Test case 60323: TS_44_existing customer_refinance_both Parent and Refinance loan with out Flinks
Feature: Online_IL_Refinance loan with flinks out

  @ILRefinanceApproved
  Scenario: Online_IL_Refinance_loan_with_flinks_out|TC_05_Refinance_loan 
    Given Genareted sin
    Given user click on signup customer
    And Pre-requisite data generation for customer
    And verify the phonenumber threshold
    When Create customer
    ##And Run the TU query decile one
    ##And Run the TU query decile generic for data generation
    And customer chooses IL loan
    And Run the TU query general D "1" and FICO score "620"
    And User provides basic information
    And select the flink consent
    And Provides income information
    And signed the picra and submit application
  		 
	  #################AUTO FUND
    #And Verify the phone OTP and enter valid OTP for autofund
    #And chosses the either LPP yes or no
	  #And select the funding types
	  #And add the bank details
	  #And Verify the loan documents
   
    #################REVIEW
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
  
   ##RE-FINANACE
   Then Make IL scheduler payments
   ##Then Run the TU query decile one refi
   #################################GENERIC####################################
   ##Then Run the TU query decile generic my ref for data generation
   And Run the TU query general ReRefEa D "1" and FICO score "620"
   #################################GENERIC####################################
   And update loan contract
   And sign the customer
   And select the refinance loan new UI
   And select the flink consent new UI 
   ##And Verify the customer information new UI
   And Verify the customer information new UI Monthly
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