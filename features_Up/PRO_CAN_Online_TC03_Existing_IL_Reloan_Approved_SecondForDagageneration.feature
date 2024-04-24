##Scenario:: Proviner Existing Canada IL Reloan Approved flow
Feature: Proviner Existing Canada IL Reloan Approved flow

  @ILreloanApproved
  Scenario: Proviner Existing Canada IL Reloan Approved flow|TC03_Exng_IL_Reloan_Aprvd
   Given Genareted sin
   Given user click on signup customer
   And Pre-requisite data generation for customer
   And verify the phonenumber threshold
   When Create customer
   And Run the TU query decile one
   #And Run the TU query decile generic for data generation
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
   
   And Backdate loan and get make a payment button
 	 Then Make a full payment
   And Backdate loan 180days
   ###########################And update loan contract
   #################################GENERIC####################################
   Then Run the TU query decile generic my ref for data generation
   #################################GENERIC####################################
   And select the reloan new UI
   And select the flink consent new UI 
   And Verify the customer information new UI
   And signed the picra and submit application
   And Verify the phone OTP and enter valid OTP for autofund  
   And chosses the either LPP yes or no
   And Verify the loan documents 
   And verify the DB validatioin for reloan
   And verify the API validatioins
    
   ###log file
   And Initialize Loan Details and write to excel
    And log all the Loan details in logger for investigation
	  And log all the Note details in logger for investigation
	  And log all payment details in logger for investigation
    And log all Transaction details in logger for investigation
    And log all EFTLog details in logger for investigation
    And log all ETransferLog details in logger for investigation