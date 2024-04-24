package online.StepDefinitions;

import sqlUtils.MsSqlUtility;

public class generaltest {

      public static void main(String[] args) {
        
    	/*
    	System.out.println("Testing MyRunnerTest");
        TestIt myRun = new TestIt();
        myRun.defaultRun();
        */
    	
    	/*
    	String str="154412 (Add Note)";
    	String numberOnly= str.replaceAll("[^0-9]", "");
    	System.out.println(numberOnly);
    	*/
    	//String str1="$(123.23)";
    	//str1.replaceAll("[^0-9?!\\.]","");
    	
    	//System.out.println(str1.replaceAll("[^0-9?!\\.]",""));
    	
    	//String s = "https://previewc.moneymart.ca/loan-application/verification/info";
    	//String s1 = "https://qac.moneymart.ca/loan-application/verification/info";
    	
    	//System.out.println(s1.indexOf("/",10));
    	//System.out.println(s.indexOf("/",10));
    	
    	  MsSqlUtility.getDbConnection2();
    	  
    }
}