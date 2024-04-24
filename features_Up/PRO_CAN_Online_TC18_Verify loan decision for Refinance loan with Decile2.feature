##Scenario:: TC18_Verify loan decision for Refinance loan with Decile2
Feature: TC18_Verify loan decision for Refinance loan with Decile2

  @ILRefinanceApproved
  Scenario: TC18_Verify loan decision for Refinance loan with Decile2|TC18_D2_Refi_Appr 
    Given Genareted sin
    Given user click on signup customer
    And Pre-requisite data generation for customer
    And verify the phonenumber threshold
    When Create customer
    And Run the TU query general D "3" and FICO score "620"
    
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
   And update loan contract
   And sign the customer
   And select the refinance loan new UI
   
   #################################GENERIC####################################
   And Run the TU query general ReRefEa D "2" and FICO score "719"
   #################################GENERIC####################################
   
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