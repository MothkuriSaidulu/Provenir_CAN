##Scenario:: TC08_Verify whether early advance is not applicable when parent loan amount is 1000$ in MB
Feature: TC08_Verify whether early advance is not applicable when parent loan amount is 1000$ in MB

  @ILRefinanceApproved
  Scenario: TC08_Verify whether early advance is not applicable when parent loan amount is 1000$ in MB|TC08_EA_Decl_PL1k 
    #Given Genareted sin
    Given user click on signup customer
    And Pre-requisite data generation for customer
    And verify the phonenumber threshold
    When Create customer
    And Run the TU query general D "8" and FICO score "619"
    
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
  
   ##Early Advance
   Then Make IL scheduler payments - early advance
   And update loan contract
   And sign the customer
   And Verify the refinance loan new UI - Early advance not applicable
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