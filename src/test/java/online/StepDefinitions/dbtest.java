package online.StepDefinitions;

import org.openqa.selenium.WebDriver;

import sqlUtils.MsSqlUtility;

import actions.OnlineActions;

public class dbtest extends OnlineActions {
	public dbtest(WebDriver driver) {
		super(driver);
	}
	public static void main(String[] are) throws Exception
	{
		
		//String loancontract=MsSqlUtility.getLoanContractID("jimm.mike@yopmail.com");
		//String LoanContractID = Double.toString(loancontract);
		//System.out.println(loancontract);
		//String s="15,000";
		//System.out.println(s.replace(",", ""));
		MsSqlUtility.update_address("F-415,Dunsdon St,BRANTFORD,ON,N3P1W7");
		
		//MsSqlUtility.executeBackDateLoan("distty.gismascond@yopmail.com", 10);
		
		//HashMap<String, String> trans=MsSqlUtility.getLOANTRANSACTIONTable("history.twocard@yopmail.com");
		
		//System.out.println(trans);
		//MsSqlUtility.getLoanTypeId("history.twocard@yopmail.com");
		
		//MsSqlUtility.getDbConnection2();
		//MsSqlUtility.UpdateLoanStatus("final.jorfinal@yopmail.com", 24);
		//MsSqlUtility.Check_Update_Phone_Threshold("7865218907", "sconddenied.denied@yopmail.com");
		//MsSqlUtility.execute15000TUQuery("rosten.t@yopmail.com");
		
//		System.out.println("customer id is: "+MsSqlUtility.getCustomerId("mostt.denied@yopmail.com"));
//		MsSqlUtility.getLoanId("mostt.denied@yopmail.com");
//		System.out.println("Loan id is: "+MsSqlUtility.getLoanId("mostt.denied@yopmail.com"));
//		System.out.println("loan status is:: "+MsSqlUtility.getLoanStatusId("mostt.denied@yopmail.com"));
//		
//		
//		
//		//MsSqlUtility.getLOANDETAILSTable("mostt.denied@yopmail.com");
//		MsSqlUtility.getLOANNOTETable("mostt.denied@yopmail.com");
//		//long LoanStatus=MsSqlUtility.getLoanStatusId("mostt.denied@yopmail.com");
//		//String LoanStatusID = Long.toString(LoanStatus);

		//System.out.println("Loan id is: "+MsSqlUtility.getLoanId("mostt.denied@yopmail.com"));
		
		
		//DB_Verify(LoanStatusID, "11", "Loan Status Id","LOAN");
		
	//	System.out.println("Loan status id::"+LoanStatusID);
		
		
		
		//obj.execute15000TUQuery("rosion.matty@yopmail.com");
		
//		Pg_DataBase_Actions obj_DB = new Pg_DataBase_Actions(TestBase.getDriver());
//		
//		
//		obj.getLOANNOTETable("rosion.matty@yopmail.com");
//		
//		
//		
//		obj_DB.Verify_DB_LoanNoteTABLE();
		
//		  MsSqlUtility obj=new MsSqlUtility();
//		  
//		  obj.getDbConnection("vitacrmcan");
//		  
//		  obj.getCustomerId("breloan","postonloan","customer");
//		  //String firstName = "Tosjoy"; String
		  //lastName="josion"; String tableName="Customer";
		  //obj.getCustomerId("poven.timrost@yopmail.com");
		 
	
		/*
		 * String str= new String("https://qac.moneymart.ca/my-account/sign-up");
		 * System.out.println("Substring starting from index 15:"); String
		 * str1=str.substring(25); String strActual="my-account/sign-up"; if
		 * (str1.equals(strActual)) { System.out.println("Strings are equal"); } else {
		 * System.out.println("Strings are NOT equal"); } System.out.println(str1);
		 * System.out.println("Substring starting from index 15 and ending at 20:");
		 * System.out.println(str.substring(15, 20));
		 */
			
	}
	
}
