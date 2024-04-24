##Scenario:: Proviner Existing Canada IL Reloan Approved flow
Feature: Proviner Existing Canada IL Reloan Approved flow

  @ILreloanApproved
  Scenario: Proviner Existing Canada IL Reloan Approved flow|TC03_Exng_IL_Reloan_Aprvd
   Given Genareted sin
   Given user click on signup customer
   And Pre-requisite data generation for customer
   And verify the phonenumber threshold
   When Create customer
   And customer chooses IL loan
   #And Run the TU query decile one
   And Run the TU query general D "1" and FICO score "620"
   And User provides basic information
   And select the flink consent
   And Provides income information
   And signed the picra and submit application
   
   #Auto Fund
   #And Verify the phone OTP and enter valid OTP for autofund
   ######################And Verify the loan approved amount NOT NEEDED
   #And chosses the either LPP yes or no
   #And select the funding types
   #And add the bank details
   #And Verify the loan documents
   
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
   ############################And customer chooses IL loan NOT NEEDED
   And select the reloan new UI
   #######################And verify the existing customer details NOT NEEDED
   And select the flink consent new UI 
   And Verify the customer information new UI
   And signed the picra and submit application
   
   
   ##Auto Fund
   #And Verify the phone OTP and enter valid OTP for autofund  
   #########################And Verify the loan approved amount NOT NEEDED
   #And chosses the either LPP yes or no
   ################And select the funding types NOT NEEDED
   ####################And verify the bank details  NOT NEEDED
   #And Verify the loan documents
   
    
    ################# Review ################# 
    ############################And verify the funding screen and chosses the funding type DIRECT Upload Document come for RELOAN
    ############And add the bank details NOT NEEDED
    And upload document
    And verify the loan status and update loan status in DB
    And click on Finalize and e-Sign Loan Documents 
    And Verify the loan approved amount
    And chosses the either LPP yes or no
    ########################################################And Go Next NOT NEEDED
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