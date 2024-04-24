Feature: Online_Verify pay off an IL Topup and returned.

  @ILApprovedd
  Scenario: Online_Verify pay off an IL Topup and returned.|TC_07_IL_TopUp_PayOff
    Given Genareted sin
    Given user click on signup 
    And Pre-requisite data generation for customer
    And verify the email threshold  
    When Enter all details and create account
    And verify the phonenumber threshold
    And Run the TU query decile one
    And customer chooses IL loan
    And User provides basic information
    And select the flink consent
    And Provides income information
    And signed the picra and submit application
    And Verify the phone OTP and enter valid OTP for autofund
    And chosses the either LPP yes or no - for topup loan
    And select the funding types
    And add the bank details 
    And Verify the loan documents
    And verify the DB validatioin
    And verify the API validatioins
    And Show request for investigation
    And Show response for investigation
    
    ## LOG LOAN DETAILS BEFORE TOP UP
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
    
    
    ###### END ###### BELOW IS ADDITIONAL FLOW#########
    ## BAck date the Loan - 10 days ##
		####And Backdate loan ten days
		## Make a full payment through UI ##
	  ####And Make a full Payment EPP loan
	  
    ## STROM  : LOG DETAILS TO DO RERUTN PAYMENT
    ####And Initialize Loan Details and write to excel
    ####And log all the Loan details in logger for investigation
	  ####And log all the Note details in logger for investigation
	  ####And log all payment details in logger for investigation
    ####And log all Transaction details in logger for investigation
    ####And log all EFTLog details in logger for investigation
    ####And log all ETransferLog details in logger for investigation
     
	 ###### END ###### 