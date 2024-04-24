##Scenario: Proviner New Canada IL Approved flow

Feature: Proviner New Canada IL Approved flow

  @ILApprovedd
  Scenario: Proviner New Canada IL Approved flow|TC01_New_IL_Approved
    
     Given Genareted sin
     Given user click on signup 
     And Pre-requisite data generation for customer
     And verify the email threshold
     When Enter all details and create account
     And verify the phonenumber threshold
     ##And Run the TU query general D
     And customer chooses IL loan
     And Run the TU query decile one
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
     