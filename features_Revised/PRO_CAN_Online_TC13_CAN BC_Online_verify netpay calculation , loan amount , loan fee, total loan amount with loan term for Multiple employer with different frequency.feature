
##Scenario:: (#66) PRO_CAN_Online_TC55_CAN BC_Online_verify netpay calculation , loan amount , loan fee, total loan amount with loan term for Multiple employer with different frequency
Feature: PRO_CAN_Online_TC49_CAN BC_Online_verify netpay calculation , loan amount , loan fee, total loan amount with loan term for Multiple employer with different frequency.feature

  @SPLApproved
  Scenario: PRO_CAN_Online_TC13_CAN BC_Online_verify netpay calculation , loan amount , loan fee, total loan amount with loan term for Multiple employer with different frequency.feature|TC13_Exst_SPL_Mlt_Emp_mlt_frq
  
   Given Pre-requisite data load for customer
   And sign the customer
   And customer chooses SPL loan
   And User provides basic information for spl reloan
   ###############And select the flink consent Not applicable for BC province
   And Provides income information Multi Employer with Monthly Weekly Bi_Weekly frequency
   And signed the picra and submit application
   ##OTP ONLINE CHANGE 
   Then Send verification code and get and enter otp and validate
   
   And select the funding types
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
   