##Scenario: TC31_Verify Loan decission is denied when PR43> 1 and PR11>$500 and PR12<12 months

Feature: TC31_Verify Loan decission is denied when PR43> 1 and PR11>$500 and PR12<12 months

  @ILApprovedd
  Scenario: TC31_Verify Loan decission is denied when PR43> 1 and PR11>$500 and PR12<12 months|TC31_New_IL_Denied
    
     Given Genareted sin
     Given user click on signup 
     And Pre-requisite data generation for customer
     And verify the email threshold
     When Enter all details and create account
     And verify the phonenumber threshold
     And customer chooses IL loan
     And Run the TU query denied Rule "1" and FICO score "719"
     And User provides basic information
     And select the flink consent
     And Provides income information
     And signed the picra and submit application
    
     And Verify loan decision denied
     ################# Review #################  DUE to LATEST CHANGE in Sprint 21 Denied rahter Review
     ##And verify the funding screen and chosses the funding type
     ##And add the bank details
     ##And upload document
     ##And verify the loan status and update loan status in DB
     ##And click on Finalize and e-Sign Loan Documents 
     ##And Verify the loan approved amount
     ##And chosses the either LPP yes or no
     ##And Go Next
     ##And Verify the loan documents
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
     