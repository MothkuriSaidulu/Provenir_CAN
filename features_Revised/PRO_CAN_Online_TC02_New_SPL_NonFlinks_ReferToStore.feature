
##Scenario:: Proviner New Canada IL Approved flow
Feature: Proviner New NonFlinks Canada SPL Refer To Store flow

  @SPLApproved
  Scenario: Proviner New Canada IL Approved flow|TC02_New_SPL_NonF_RTS
   Given Genareted sin
   Given user click on signup customer
   And Pre-requisite data generation for customer
   And verify the phonenumber threshold
   #And Verify the address threshold and update address
   When Create customer
   #And Run the TU query decile one
   And customer chooses SPL loan
   And Run the TU query general D "1" and FICO score "719"
   And User provides basic information for spl
   And select the flink consent
   And Provides income information
   And signed the picra and submit application
 
 	 ##ReferTOStore
   And verify loan is refer to store for apply


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
   