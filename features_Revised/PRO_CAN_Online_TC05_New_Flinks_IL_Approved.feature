##Scenario: Proviner New Canada IL Approved flow

Feature: Proviner New Canada IL Approved flow

  @ILApprovedd
  Scenario: Proviner New Canada IL Approved flow|TC05_New_IL_Flx_Approved
    
    Given Genareted sin
    Given user click on signup customer
    And verify the phonenumber threshold
    ####And Verify the address threshold and update address
    When Create customer
    And customer chooses IL loan
    And Run the TU query decile one
    And User provides basic information
    And select flink opt in
    And check the flinks income details
    And signed the picra and submit application
    
     ##OTP ONLINE CHANGE 
   Then Send verification code and get and enter otp and validate
  
   #####AUTO FUND
   #And Verify the phone OTP and enter valid OTP for autofund
   #And chosses the either LPP yes or no
   #And select the funding types
   #And Flinks bank details
   #And Verify the loan documents
   
    #################REVIEW
    And verify the funding screen and chosses the funding type
    ##BElow Snippt Created New for PreviewC Flinks
    And select the bank Flinks
    ###And add the bank details THIS FOR QAC If Asking to add bank
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
   
   