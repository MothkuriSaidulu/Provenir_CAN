##Scenario:: (#04) PRO_CAN_Online_TC16_AB_Flinks_Online_Verify whether system allow new customer for  SPL Downsell when IL Loan Denial
Feature: PRO_CAN_Online_TC16_AB_Flinks_Online_Verify whether system allow new customer for  SPL Downsell when IL Loan Denial

  @IL_SPL_Downsell
  Scenario: PRO_CAN_Online_TC16_AB_Flinks_Online_Verify whether system allow new customer for  SPL Downsell when IL Loan Denial|TC_16_SPL_Downsell_whn_IL_Dned
  
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
  
   And Wait till Down sell SPL
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
   
   When Loan approval screen - IL denied and eligible for Down sell SPL
   And signed the picra and submit application
   And verify the funding screen and chosses the funding type
   ##BElow Snippt Created New for PreviewC Flinks
   And select the bank Flinks
   And upload document
   And verify the loan status and update loan status in DB
   And click on Finalize and e-Sign Loan Documents 
   #####And Verify the loan approved amount Not Needed for Downsell
   And Loan approved final offer
   And Go Next
   And Verify the loan documents AB
   
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