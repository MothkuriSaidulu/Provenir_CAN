###CHECK
##Scenario:: TC16_Verify loan decission for New loan as Decile 2 & Reloan loan with Decile8
Feature: PRO_CAN_Online_TC10_Verify_loan_decission_for_New_loan_as_Decile_2_And_Reloan_loan_with_Decile_8

  @ILreloanApproved
  Scenario: TC16_Verify loan decission for New loan as Decile 2 & Reloan loan with Decile8|TC10_new_dec2_reloan_dec8
  
   Given Genareted sin
   And Genareted random six digit accountnumber
   Given user click on signup customer
   #####And Pre-requisite data generation for customer
   And verify the phonenumber threshold
   When Create customer
   And customer chooses IL loan
   And Run the TU query decile two
   And User provides basic information
   And select flink opt in
   And check the flinks income details
   And signed the picra and submit application
  
   #Auto Fund
   #And Verify the phone OTP and enter valid OTP for autofund
   #And chosses the either LPP yes or no
   #And select the funding types
   #And add the bank details
   #And Verify the loan documents
   
   ##OTP ONLINE CHANGE 
   Then Send verification code and get and enter otp and validate
   
   ################# Review ################# 
   And verify the funding screen and chosses the funding type
   ###########->And select the bank Flinks -> DUE TO DATA ISSUE ASKING TO ADD BANK
   And add the bank details
   ###->And sign the customer
   And upload document 
   And verify the loan status and update loan status in DB
   And click on Finalize and e-Sign Loan Documents 
   And Verify the loan approved amount
   And chosses the either LPP yes or no
   And Go Next
   And Verify the loan documents
	 And verify the DB validatioin for reloan
   And verify the API validatioins 
   And Show request for investigation
   And Show response for investigation
   
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
   ##And sign the customer
 	 Then Make a full payment
   And Backdate loan 180days
   ###And Run the TU query decile eight reloan
   And Run the TU query general ReRefEa D "6" and FICO score "620"
   And select the reloan new UI
   And select the flink consent new UI 
   And Verify the customer information new UI
   And signed the picra and submit application
   
   ##OTP ONLINE CHANGE 
   Then Send verification code and get and enter otp and validate
      
   And upload document
   And verify the loan status and update loan status in DB
   And click on Finalize and e-Sign Loan Documents 
   And Verify the loan approved amount
   And chosses the either LPP yes or no
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