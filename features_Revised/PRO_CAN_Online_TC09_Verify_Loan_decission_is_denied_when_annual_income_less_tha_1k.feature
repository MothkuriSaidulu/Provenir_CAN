##Scenario: TC24_ Verify Loan decission is denied when annual income < 1K

Feature: PRO_CAN_Online_TC09_Verify_Loan_decission_is_denied_when_annual_income_less_tha_1k

  @ILApprovedd
  Scenario: PRO_CAN_Online_TC09_Verify_Loan_decission_is_denied_when_annual_income_less_tha_1k|TC09_incomeless1k_Decln
    
     Given Genareted sin
     Given user click on signup 
     ###And Pre-requisite data generation for customer
     ###And verify the email threshold
     And verify the phonenumber threshold
     When Create customer
     And customer chooses IL loan
     #And Run the TU query decile one
     And Run the TU query general D "1" and FICO score "710"
     And User provides basic information
     And select flink opt in
     And check the flinks income details
     And signed the picra and submit application
     And Verify loan decision denied
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