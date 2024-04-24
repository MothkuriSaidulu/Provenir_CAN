##Scenario:: TC20_Verify Early advance loan should get decline if parent loan decile is less then early advance loan decile.
Feature: TC20_Verify Early advance loan should get decline if parent loan decile is less then early advance loan decile.

  @ILRefinanceApproved
  Scenario: TC20_Verify Early advance loan should get decline if parent loan decile is less then early advance loan decile.|TC20_Ploan_dcil_less_EA_Decl
   Given Genareted sin
   Given user click on signup customer
   And Pre-requisite data generation for customer
   And verify the phonenumber threshold
   When Create customer
   And Run the TU query decile five
   And customer chooses IL loan
   And User provides basic information
   And select the flink consent
   And Provides income information
   And signed the picra and submit application
   And verify the funding screen and chosses the funding type
   And add the bank details
   And upload document
   And verify the loan status and update loan status in DB
   And click on Finalize and e-Sign Loan Documents 
   And Verify the loan approved amount
   And chosses the either LPP yes or no
   And bank details
   And Verify the loan documents
   And verify the DB validatioin
   And verify the API validatioins
   
   ###log file
   And Initialize Loan Details and write to excel
   And log all the Loan details in logger for investigation
	 And log all the Note details in logger for investigation
	 And log all payment details in logger for investigation
   And log all Transaction details in logger for investigation
   And log all EFTLog details in logger for investigation
   And log all ETransferLog details in logger for investigation
   
   
   ## Early Advance 1 ##
   Then Make IL scheduler payments - early advance
   Then Run the TU query decile eight earlyadvance
   And update loan contract
   And sign the customer
   And select the refinance loan new UI
   And select the flink consent new UI 
   And Verify the customer information new UI
   And signed the picra and submit application
   And Verify loan decision denied
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
   