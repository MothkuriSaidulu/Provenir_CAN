Feature: Online_Verify pay off an IL Topup and returned.

  @ILApprovedd
  Scenario: PRO_CAN_Online_TC14_Verify Top up loan decision is review when income is less than parent loan.feature.|TC14_IL_TopUp_Review_BOnIncome
    
    Given Genareted sin
    And Genareted random six digit accountnumber
    Given user click on signup
    And verify the phonenumber threshold
    When Create customer
    And customer chooses IL loan
    And Run the TU query decile one 
    And User provides basic information
    And select flink opt in
    And check the flinks income details
    And signed the picra and submit application
    
    ##OTP ONLINE CHANGE 
    Then Send verification code and get and enter otp and validate
    
    ################# Review ################# 
    And verify the funding screen and chosses the funding type
    And add the bank details
   
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
   
    ## LOG LOAN DETAILS BEFORE TOP UP
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
   
       
		## BAck date the Loan - 10 days ##
		And Backdate loan ten days
		And update loan contract
    #######And sign the customer
		And TopUp IL loan
	  And Verify the information to proceed next
	  And chosses the either LPP yes or no - topup loan
	  And select the funding types
	  And verify the bank details
		And Verify the loan documents 
	  And verify the DB validatioin for reloan
	  And verify the API validatioins
    And Show request for investigation
    And Show response for investigation
   
    ## LOG LOAN DETAILS AFTER TOP UP
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
  