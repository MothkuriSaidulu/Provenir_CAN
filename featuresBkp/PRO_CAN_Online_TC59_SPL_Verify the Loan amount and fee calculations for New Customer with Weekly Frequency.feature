
##Scenario:: TC04_CAN_SPL_MB_Digital_Web App (Mobile & Web App)-Verify the Loan amount and fee calculations for New Customer with Weekly Frequency
Feature: TC59_CAN_SPL_MB_Digital_Web App (Mobile & Web App)-Verify the Loan amount and fee calculations for New Customer with Weekly Frequency

  @SPLApproved
  Scenario: TC59_CAN_SPL_MB_Digital_Web App (Mobile & Web App)-Verify the Loan amount and fee calculations for New Customer with Weekly Frequency|TC59_New_SPL_Wkly_NetPayCalc
   Given Genareted sin
   Given user click on signup customer
   And Pre-requisite data generation for customer
   And verify the phonenumber threshold
   When Create customer
   ###And Run the TU query decile one
   And customer chooses SPL loan
   And Run the TU query decile one
   And User provides basic information for spl
   And select the flink consent
   And Provides income information Weekly
   And signed the picra and submit application
   And  enter valid OTP
   ####And select the funding types Not NEEDED in second iteration
   And add the bank details
   And upload document
   And verify the loan status and update loan status in DB
   And click on Finalize and e-Sign Loan Documents
   And Loan approval screen
   And Loan approved final offer
   And funding and payment confirmation
   And esing document SPL and back to dashboard 
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

   
   
   
   
   
   