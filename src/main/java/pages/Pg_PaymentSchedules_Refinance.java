package pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;
import sqlUtils.MsSqlUtility;
//import sqlUtils.Run_PaymentScheduler;
//import sqlUtils.Run_PaymentScheduler_LPP;
import sqlUtils.Run_PaymentScheduler;



public class Pg_PaymentSchedules_Refinance extends OnlineActions {

	public Pg_PaymentSchedules_Refinance(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	public void Complete_Payments(int No_OfPayments) throws Exception
	{
		
		int DaysDiff =0;
		for(int i=1;i<=No_OfPayments;i++)
		{
			// Step - 1 Verify the Next scheduled date
			long LoanStatus=MsSqlUtility.getLoanStatusId(getMapData.get("eMail"));
			String LoanStatusID = Long.toString(LoanStatus);
			System.out.println("Loan status id:"+LoanStatusID);
			long loantype=MsSqlUtility.getLoanTypeId(getMapData.get("eMail"));
			String loantypeid = Long.toString(LoanStatus);
			System.out.println("loantypeid ::"+loantypeid);
			/*
			 * if(loantypeid.equalsIgnoreCase("4")&&LoanStatusID.equalsIgnoreCase("3")) {
			 */
				
			
			String NextScheduleDateFromDB1 = MsSqlUtility.getLOANPAYMENTHEADERTable(getMapData.get("eMail")).get("NextScheduledDate");
			System.out.println("Nextscheduled date from DB::"+NextScheduleDateFromDB1);
			String[] NSD = NextScheduleDateFromDB1.split(" ");
			NextScheduleDateFromDB1 = NSD[0];
			NSD = NextScheduleDateFromDB1.split("-");
			NextScheduleDateFromDB1 = NSD[0]+"-"+NSD[1]+"-"+NSD[2]; //0-yyy 1-MM 2-DD

			SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
			LocalDateTime now = LocalDateTime.now();
			String TodayDate = dtf.format(now)+"";
			String inputString1 = NextScheduleDateFromDB1;
			String inputString2 = TodayDate;
			System.out.println("Next schedule date from DB: 1-- "+inputString1);
			System.out.println("Todays Date: 2-- "+inputString2);
			try {
				Date date1 = myFormat.parse(inputString1);
				Date date2 = myFormat.parse(inputString2);
				System.out.println("Next schedule date from DB: "+date1);
				System.out.println("Todays Date: "+date2);
				long diff = date2.getTime() - date1.getTime();
				DaysDiff = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

				//			DaysDiff = DaysDiff-1;


				//  System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			System.out.println("No of days difference is "+DaysDiff);
			MsSqlUtility.executeBackDateLoan(getMapData.get("eMail"),-DaysDiff);
			String NextScheduleDateFromDB2 = MsSqlUtility.getLOANPAYMENTHEADERTable(getMapData.get("eMail")).get("NextScheduledDate");
			System.out.println("Next schedule date from db after back date"+NextScheduleDateFromDB2);
			Run_PaymentScheduler.RunFilewithoutlpp();
			PrintValueToReport("Payment schedule is executed successfully for payment number "+i, "Payment schedule");

			//Step - 2 Calculate how many days differ from next schedule date to today date

			//Step - 3 Back date those number for current loan

			//Step - 4 Now verify once again that Next schedule date is the current date

			//Step - 5 Run the scheduler to make payment

		//}

		}

		//Verify the new entry will be log in loanPayment table

		//Repeat the above process to 5 times with for loop to make 5 paymants

	}
	
	public void runscheduler() throws Exception
	{
		System.out.println("Scheduler is started");
		Run_PaymentScheduler.RunFilewithoutlpp();
		System.out.println("Scheduler is ended");
	}

	public void Complete_PaymentsAndBackdatepreviousLoansAlso(int No_OfPayments, int NoOfLoansBackdate) throws Exception
	{
		
		int DaysDiff =0;
		for(int i=1;i<=No_OfPayments;i++)
		{
			// Step - 1 Verify the Next scheduled date
			String NextScheduleDateFromDB1 = MsSqlUtility.getLOANPAYMENTHEADERTable(getMapData.get("Email")).get("NextScheduledDate");
			String[] NSD = NextScheduleDateFromDB1.split(" ");
			NextScheduleDateFromDB1 = NSD[0];
			NSD = NextScheduleDateFromDB1.split("-");
			NextScheduleDateFromDB1 = NSD[0]+"-"+NSD[1]+"-"+NSD[2]; //0-yyy 1-MM 2-DD

			SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
			LocalDateTime now = LocalDateTime.now();
			String TodayDate = dtf.format(now)+"";
			String inputString1 = NextScheduleDateFromDB1;
			String inputString2 = TodayDate;
			System.out.println("Next schedule date from DB: 1-- "+inputString1);
			System.out.println("Todays Date: 2-- "+inputString2);
			try {
				Date date1 = myFormat.parse(inputString1);
				Date date2 = myFormat.parse(inputString2);
				System.out.println("Next schedule date from DB: "+date1);
				System.out.println("Todays Date: "+date2);
				long diff = date2.getTime() - date1.getTime();
				DaysDiff = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

			} catch (ParseException e) {
				e.printStackTrace();
			}
			System.out.println("No of days difference is "+DaysDiff);
			MsSqlUtility.executeBackDateLoan(getMapData.get("Email"),DaysDiff);
			String NextScheduleDateFromDB2 = MsSqlUtility.getLOANPAYMENTHEADERTable(getMapData.get("Email")).get("NextScheduledDate");
			System.out.println("Next schedule date from db after back date"+NextScheduleDateFromDB2);
			Run_PaymentScheduler.RunFilewithoutlpp();
			PrintValueToReport("Payment schedule is executed successfully for payment number "+i, "Payment schedule");
			if(NoOfLoansBackdate==1)
			{
				MsSqlUtility.executeBackDateLoan(Pg_07_Dashboard.First_LoanID,DaysDiff);
			}
			else if(NoOfLoansBackdate==2)
			{
				MsSqlUtility.executeBackDateLoan(Pg_07_Dashboard.First_LoanID,DaysDiff);
				MsSqlUtility.executeBackDateLoan(Pg_07_Dashboard.Second_LoanID,DaysDiff);
			}
			else if(NoOfLoansBackdate==3)
			{
				MsSqlUtility.executeBackDateLoan(Pg_07_Dashboard.First_LoanID,DaysDiff);
				MsSqlUtility.executeBackDateLoan(Pg_07_Dashboard.Second_LoanID,DaysDiff);
				MsSqlUtility.executeBackDateLoan(Pg_07_Dashboard.Third_LoanID,DaysDiff);
			}
			else if(NoOfLoansBackdate==4)
			{
				MsSqlUtility.executeBackDateLoan(Pg_07_Dashboard.First_LoanID,DaysDiff);
				MsSqlUtility.executeBackDateLoan(Pg_07_Dashboard.Second_LoanID,DaysDiff);
				MsSqlUtility.executeBackDateLoan(Pg_07_Dashboard.Third_LoanID,DaysDiff);
				MsSqlUtility.executeBackDateLoan(Pg_07_Dashboard.Fourth_LoanID,DaysDiff);
			}


			//Step - 2 Calculate how many days differ from next schedule date to today date

			//Step - 3 Back date those number for current loan

			//Step - 4 Now verify once again that Next schedule date is the current date

			//Step - 5 Run the scheduler to make payment

		}



		//Verify the new entry will be log in loanPayment table

		//Repeat the above process to 5 times with for loop to make 5 paymants

	}

	public void BackDate_31_effectiveDateDiff() throws Exception
	{
		
		String LoanID = MsSqlUtility.getLoanId(getMapData.get("Email"))+"";
		int DaysDiff =0;

		// Step - 1 Verify the Next scheduled date
		String EffectiveDate = MsSqlUtility.LoanEffectiveDate(getMapData.get("Email"));
		String[] EFD = EffectiveDate.split(" ");
		EffectiveDate = EFD[0];
		EFD = EffectiveDate.split("-");
		EffectiveDate = EFD[0]+"-"+EFD[1]+"-"+EFD[2]; //0-yyy 1-MM 2-DD

		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDateTime now = LocalDateTime.now();
		String TodayDate = dtf.format(now)+"";
		String inputString1 = EffectiveDate;
		String inputString2 = TodayDate;
		System.out.println("Effective date from DB: 1-- "+inputString1);
		System.out.println("Todays Date: 2-- "+inputString2);
		try {
			Date date1 = myFormat.parse(inputString1);
			Date date2 = myFormat.parse(inputString2);
			System.out.println("Next schedule date from DB: "+date1);
			System.out.println("Todays Date: "+date2);
			long diff = (date2.getTime() - date1.getTime());
			System.out.println("Days difference is "+((int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)));
			DaysDiff = -(31-((int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)));
			System.out.println("diff is "+diff);
			System.out.println("Days diff is "+DaysDiff);

			//			DaysDiff = DaysDiff-1;


			//  System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("No of days difference is "+DaysDiff);
		MsSqlUtility.executeBackDateLoan(getMapData.get("Email"),DaysDiff);
//		PrintValueToReport("Loan with loan-id "+LoanID+" is back dated to "+DaysDiff+" days", "Executed Back date Query: ");

	}

	public static void BackDate_31_effectiveDateDiffAndPreviousLoan(Long Loanid) throws Exception
	{
		
		int DaysDiff =0;

		// Step - 1 Verify the Next scheduled date
		String EffectiveDate = MsSqlUtility.LoanEffectiveDate(getMapData.get("Email"));
		String[] EFD = EffectiveDate.split(" ");
		EffectiveDate = EFD[0];
		EFD = EffectiveDate.split("-");
		EffectiveDate = EFD[0]+"-"+EFD[1]+"-"+EFD[2]; //0-yyy 1-MM 2-DD

		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDateTime now = LocalDateTime.now();
		String TodayDate = dtf.format(now)+"";
		String inputString1 = EffectiveDate;
		String inputString2 = TodayDate;
		System.out.println("Effective date from DB: 1-- "+inputString1);
		System.out.println("Todays Date: 2-- "+inputString2);
		try {
			Date date1 = myFormat.parse(inputString1);
			Date date2 = myFormat.parse(inputString2);
			System.out.println("Next schedule date from DB: "+date1);
			System.out.println("Todays Date: "+date2);
			long diff = (date2.getTime() - date1.getTime());
			DaysDiff = -(31-((int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)));

			//			DaysDiff = DaysDiff-1;


			//  System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("No of days difference is "+DaysDiff);
		MsSqlUtility.executeBackDateLoan(getMapData.get("Email"),DaysDiff);
		MsSqlUtility.executeBackDateLoan(Loanid,DaysDiff);
	}

	public void Complete_Payments_WithLPP(int No_OfPayments) throws Exception
	{
		
		int DaysDiff =0;
		int DaysDiff2=0;
		for(int i=1;i<=No_OfPayments;i++)
		
		{
			long LoanStatus=MsSqlUtility.getLoanStatusId(getMapData.get("eMail"));
			String LoanStatusID = Long.toString(LoanStatus);
			System.out.println("Loan status id:"+LoanStatusID);
			long loantype=MsSqlUtility.getLoanTypeId(getMapData.get("eMail"));
			String loantypeid = Long.toString(LoanStatus);
			System.out.println("loantypeid ::"+loantypeid);
			// Step - 1 Verify the Next scheduled date
			String NextScheduledDateDB1 = MsSqlUtility.getLOANPAYMENTHEADERTable(getMapData.get("eMail")).get("NextScheduledDate");
			System.out.println("NextScheduledDateDB1:::"+NextScheduledDateDB1);
			String QueueDateFromDB1 = MsSqlUtility.getLOANPAYMENTHEADERTable(getMapData.get("eMail")).get("QueueDate");
			System.out.println("Queuedate::"+QueueDateFromDB1);
			String QueueDateFromDB2 = MsSqlUtility.getLOANPAYMENTHEADERTable(getMapData.get("eMail")).get("QueueDate");
			System.out.println("Queuedate::"+QueueDateFromDB2);
//Step - 2 Calculate how many days differ from next schedule date to today date
			
			
			String[] NSDN = NextScheduledDateDB1.split(" ");
			NextScheduledDateDB1 = NSDN[0];
			NSDN = NextScheduledDateDB1.split("-");
			NextScheduledDateDB1 = NSDN[0]+"-"+NSDN[1]+"-"+NSDN[2]; //0-yyy 1-MM 2-DD
			
			String[] NSDQ = QueueDateFromDB2.split(" ");
			QueueDateFromDB2 = NSDQ[0];
			NSDQ = QueueDateFromDB2.split("-");
			QueueDateFromDB2 = NSDQ[0]+"-"+NSDQ[1]+"-"+NSDQ[2];
			
			SimpleDateFormat myFormat1 = new SimpleDateFormat("yyyy-MM-dd");
			DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
			
			
			String inputString11 = NextScheduledDateDB1;
			String inputString21 = QueueDateFromDB2;
			System.out.println("Next schedule date from DB: 1-- "+inputString11);
			System.out.println("Queue Date: 2-- "+inputString21);
			try {
				Date dateN = myFormat1.parse(inputString11);
				Date dateQ = myFormat1.parse(inputString21);
				System.out.println("Next schedule date from DB: "+dateN);
				System.out.println("Queue Date: "+dateQ);
				long diffNQ = dateQ.getTime() - dateN.getTime();
				DaysDiff2 = (int) TimeUnit.DAYS.convert(diffNQ, TimeUnit.MILLISECONDS);
				//DaysDiff = DaysDiff;
				//  System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			System.out.println("No of days difference is "+DaysDiff2);
			
			
			
			
			String[] NSD = QueueDateFromDB1.split(" ");
			QueueDateFromDB1 = NSD[0];
			NSD = QueueDateFromDB1.split("-");
			QueueDateFromDB1 = NSD[0]+"-"+NSD[1]+"-"+NSD[2]; //0-yyy 1-MM 2-DD

			SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
			LocalDateTime now = LocalDateTime.now();
			String TodayDate = dtf.format(now)+"";
			String inputString1 = QueueDateFromDB1;
			String inputString2 = TodayDate;
			System.out.println("Next schedule date from DB: 1-- "+inputString1);
			System.out.println("Todays Date: 2-- "+inputString2);
			try {
				Date date1 = myFormat.parse(inputString1);
				Date date2 = myFormat.parse(inputString2);
				System.out.println("Queue schedule date from DB: "+date1);
				System.out.println("Todays Date: "+date2);
				long diff = date2.getTime() - date1.getTime();
				DaysDiff = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
				System.out.println("Before::"+DaysDiff);
				//DaysDiff = DaysDiff;
				//  System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			System.out.println("No of days difference is "+DaysDiff);
			MsSqlUtility.executeBackDateLoan(getMapData.get("eMail"),-DaysDiff);
			String Queuedate2 = MsSqlUtility.getLOANPAYMENTHEADERTable(getMapData.get("eMail")).get("QueueDate");
			System.out.println("Next schedule date from db after back date"+Queuedate2);
			Run_PaymentScheduler.RunFilewithoutlpp();
			Run_PaymentScheduler.RunFilewithlpp();

			
			MsSqlUtility.executeBackDateLoan(getMapData.get("eMail"),-DaysDiff2);
			//String NextScheduledDateDB2 = MsSqlUtility.getLOANPAYMENTHEADERTable(getMapData.get("eMail")).get("NextScheduledDate");
			//System.out.println("Next schedule date from db after back date"+NextScheduledDateDB2);
			Thread.sleep(10000);
			Run_PaymentScheduler.RunFilewithoutlpp();

			//Step - 3 Back date those number for current loan

			//Step - 4 Now verify once again that Next schedule date is the current date

			//Step - 5 Run the scheduler to make payment

		}



		//Verify the new entry will be log in loanPayment table

		//Repeat the above process to 5 times with for loop to make 5 paymants

	}
}

