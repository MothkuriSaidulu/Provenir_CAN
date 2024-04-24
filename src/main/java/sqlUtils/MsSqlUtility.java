package sqlUtils;

import java.io.IOException;
import java.io.Reader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import actions.OnlineActions;
import driver.TestBase;
import utils.UtilityMethods;


public class MsSqlUtility extends TestBase
{

	private static String SQLDBName = getPropertyValue("SQLDatabaseName");
	private static String SQLDBNameToGetCustId = getPropertyValue("SQLDatabaseNameToGetCustId");
	private static String SQLDBNameToRunTuQuery = getPropertyValue("SQLDatabaseNameToRunTuQuery");
	private static String SQLDBNameToGetLoan = getPropertyValue("SQLDatabaseNameToGetLoan");
	
	private static String SQLDBNameToGetReqRes = getPropertyValue("SQLDBNameToGetReqRes");


	public static final Logger logger = Logger.getLogger(MsSqlUtility.class.getName());

	// JDBC driver name and database URL
	public static Connection connObj;
	public static Statement statement;
	//public static String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=MMTestDB;integratedSecurity=true";
	public static void getDbConnection(String DBName) {
		try {
			String userName = "9kmal";
			System.out.println("db username is  ----> "+userName);
			String password = "Winter@2722";
			String hostName = "NADC1TSQL20";
			String PortNo = "58225";
			String url =  "jdbc:sqlserver://"+getPropertyValue("SQLHostName")+";databasename="+getPropertyValue("SQLDatabaseNameToRunTuQuery")+";integratedsecurity=true;encrypt=false";
			System.out.println("URL: -"+url); 
			//String urlWinAuth = "jdbc:sqlserver://"+getPropertyValue("SQLHostName")+":1433;databasename="+getPropertyValue("SQLDatabaseNameToGetCustId")+";integratedsecurity=true";

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connObj = DriverManager.getConnection(url, userName, password);
			/*Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         connObj = DriverManager.getConnection(JDBC_URL);*/
			if(connObj != null) 
			{
				DatabaseMetaData metaObj = (DatabaseMetaData) connObj.getMetaData();
				System.out.println("Driver Name?= " + metaObj.getDriverName() + ", Driver Version?= " + metaObj.getDriverVersion() + ", Product Name?= " + metaObj.getDatabaseProductName() + ", Product Version?= " + metaObj.getDatabaseProductVersion());
				System.out.println("connected"); 
				logger.info("--------Connection to SQL Server successfully--------");
			}
		}catch(Exception sqlException) 
		{
			logger.info("--------sqlException while connecting MS SQL Server--------: "+sqlException.getMessage());
			sqlException.printStackTrace();
		}
	}
	
	//Added on 17-Aug-2022 Start
	public static void getDbConnection_ReqRes(String DBName) {
		try {
			String userName = "9kmal";
			System.out.println("db username is  ----> "+userName);
			String password = "Winter@2722";
			String hostName = "NADC1TSQL20";
			String PortNo = "58225";
			String url =  "jdbc:sqlserver://"+getPropertyValue("SQLHostName")+";databasename="+DBName+";integratedsecurity=true;encrypt=false";
			System.out.println("URL: -"+url); 
			//String urlWinAuth = "jdbc:sqlserver://"+getPropertyValue("SQLHostName")+":1433;databasename="+getPropertyValue("SQLDatabaseNameToGetCustId")+";integratedsecurity=true";

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connObj = DriverManager.getConnection(url, userName, password);
			/*Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         connObj = DriverManager.getConnection(JDBC_URL);*/
			if(connObj != null) 
			{
				DatabaseMetaData metaObj = (DatabaseMetaData) connObj.getMetaData();
				System.out.println("Driver Name?= " + metaObj.getDriverName() + ", Driver Version?= " + metaObj.getDriverVersion() + ", Product Name?= " + metaObj.getDatabaseProductName() + ", Product Version?= " + metaObj.getDatabaseProductVersion());
				System.out.println("connected"); 
				logger.info("--------Connection to SQL Server successfully--------");
			}
		}catch(Exception sqlException) 
		{
			logger.info("--------sqlException while connecting MS SQL Server--------: "+sqlException.getMessage());
			sqlException.printStackTrace();
		}
	}
	
	public static String getRequest(String EmailAddress)
	{
		long CustomId = getCustomerId(EmailAddress);
		System.out.println("customer id::::::***"+CustomId);
		
		getDbConnection_ReqRes(SQLDBNameToGetReqRes);
		
		//Added on 24-Sept-2022 Start
		String environment="";
		  if(getPropertyValue("provinerORQacURL").equalsIgnoreCase("QAC"))
		  {
			  environment = "VitaUWCAN";
			  System.out.println("Environment:::"+environment);
		  }
		  if(getPropertyValue("provinerORQacURL").equalsIgnoreCase("PROVENIR"))
		  {
			  environment = "VitaUWCANETL";
			   System.out.println("Environment:::"+environment);
		  }
		 //Added on 24-Sept-2022 End
		
		String sRequest = "";
		try
		{	 statement = connObj.createStatement();
		String queryString = "select top 1 Request from "+environment+"..CreditApplication"
				+ " where customerid = '"+CustomId+"' order by createddate desc";

		System.out.println(queryString);

		ResultSet rs = statement.executeQuery(queryString);
		while (rs.next()) {
			sRequest =	rs.getString("Request");
		}
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		return sRequest;
	}
	
	
	
	//Added on 17-Aug-2022 End
	
	
	
	public static void getDbConnection1() {
		try {
			///String userName = getPropertyValue("SQLUserName");
			//String password = getPropertyValue("SQLPassword");
			String urlWinAuth = "jdbc:sqlserver://"+getPropertyValue("SQLHostName")+":1433;databasename="+getPropertyValue("SQLDatabaseNameToGetCustId")+";integratedsecurity=true";

			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connObj = DriverManager.getConnection(urlWinAuth);

			if(connObj != null) 
			{
				DatabaseMetaData metaObj = (DatabaseMetaData) connObj.getMetaData();
				System.out.println("Driver Name?= " + metaObj.getDriverName() + ", Driver Version?= " + metaObj.getDriverVersion() + ", Product Name?= " + metaObj.getDatabaseProductName() + ", Product Version?= " + metaObj.getDatabaseProductVersion());
				System.out.println("connected"); 
				logger.info("--------Connection to SQL Server successfully--------");
			}
		}catch(Exception sqlException) 
		{
			logger.info("--------sqlException while connecting MS SQL Server--------: "+sqlException.getMessage());
			sqlException.printStackTrace();
		}

	}

	public static void getDbConnection2() {
		try {
			//String userName = getPropertyValue("SQLUserName");
			//String password = getPropertyValue("SQLPassword");
			String urlWinAuth = "jdbc:sqlserver://"+getPropertyValue("SQLHostName")+";databasename="+getPropertyValue("SQLDatabaseNameToRunTuQuery")+";integratedsecurity=true;encrypt=false";
  			

			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connObj = DriverManager.getConnection(urlWinAuth);

			if(connObj != null) 
			{
				DatabaseMetaData metaObj = (DatabaseMetaData) connObj.getMetaData();
				//System.out.println("Driver Name?= " + metaObj.getDriverName() + ", Driver Version?= " + metaObj.getDriverVersion() + ", Product Name?= " + metaObj.getDatabaseProductName() + ", Product Version?= " + metaObj.getDatabaseProductVersion());
				System.out.println("connected"); 
				logger.info("--------Connection to SQL Server successfully--------");
			}
		}catch(Exception sqlException) 
		{
			logger.info("--------sqlException while connecting MS SQL Server--------: "+sqlException.getMessage());
			sqlException.printStackTrace();
		}

	}


	public static long getCustomerId(String firstName, String lastName, String tableName)
	{
		long sCustomerId = 0;
		try
		{	 statement = connObj.createStatement();
		String queryString = "select CustomerId from "+SQLDBName+".."+tableName+""
				+ " where firstname = '"+firstName+"' and lastname = '"+lastName+"' order by createddate desc";

		System.out.println(queryString);

		ResultSet rs = statement.executeQuery(queryString);
		while (rs.next()) {
			sCustomerId =	rs.getLong("CustomerId");
		}
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		return sCustomerId;
	}
	
		public static long getCustomerId(String EmailAddress)
	{
		System.out.println("Customer id method started");
		getDbConnection2();
		long sCustomerId = 0;
		try
		{	 statement = connObj.createStatement();
		String queryString = "select CustomerId from "+SQLDBName+".."+"customeremail"
				+ " where Email = '"+EmailAddress+"'";

		System.out.println("getCustomerID query is "+queryString);
		ResultSet rs = statement.executeQuery(queryString);
		System.out.println("rs is - "+rs);
		while (rs.next()) {
			sCustomerId =	rs.getLong("CustomerId");
			System.out.println("Customer id is -- "+sCustomerId);
		}
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		return sCustomerId;
	}
	
	public static void getEmployeedetails(String EmailAddress)
	{
		long CustomId = getCustomerId(EmailAddress);
		System.out.println("customer id::::::***"+CustomId);
		String employename;
		int Payperiodtype = 0;
		
		getDbConnection2();
		
		try
		{	 statement = connObj.createStatement();
		
		 

		String queryString = "select * from "+SQLDBName+".."+"CustomerEmployer"+" "+"ce,"
				+SQLDBName+".."+"CustomerEmployerPayDetail"+" "+"cp"+" "
				+ " where ce.CustomerEmployerId=cp.CustomerEmployerId and ce.CustomerId='"+CustomId+"'";

		System.out.println("Get Employee details query is "+queryString);
		ResultSet rs = statement.executeQuery(queryString);
		System.out.println("rs is - "+rs);
		while (rs.next()) {

			employename = rs.getString("EmployerName");
			Payperiodtype = rs.getInt("PayPeriodType");
			

		}
		
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		
	}
	public static long getLoanId(String EmailAddress)
	{
		long CustomId = getCustomerId(EmailAddress);
		System.out.println("customer id::::::***"+CustomId);
		getDbConnection2();

		long LoanId = 0;
		long LoadId1 = 0;
		//ArrayList<String> ListOfLoanID = new ArrayList<>();
		List<Long> ListOfLoanID = new ArrayList<>();

		//long sCustomerId = 0;
		try
		{	 statement = connObj.createStatement();
		String queryString = "select LoanId from "+SQLDBNameToGetLoan+".."+"Loan"
				+ " where customerid = '"+CustomId+"'";
		System.out.println("*****"+queryString);
		ResultSet rs = statement.executeQuery(queryString);
		System.out.println("*****"+rs);
		while (rs.next()) {

			LoadId1 =	rs.getLong("LoanId");
			ListOfLoanID.add(LoadId1);
		}
		LoanId = Collections.max(ListOfLoanID); 
		System.out.println("*****"+LoanId);
		/*while (rs.next()) {
			sCustomerId =	rs.getLong("CustomerId");
		}*/
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		return LoanId;
	}

	public static String getMobileOTP(String EmailAddress)
	{
		long LoanId = getLoanId(EmailAddress);
		getDbConnection(SQLDBName);

		String AppData = null;
		String OTP = null;

		try
		{	 statement = connObj.createStatement();
		String queryString = "select AppData from "+ SQLDBNameToGetLoan+ ".."+"Application"
				+ " where LoanId = '"+LoanId+"'";



		ResultSet rs = statement.executeQuery(queryString);

		while (rs.next()) {

			AppData =	rs.getString("AppData");

		}

		String[] AppData1 = AppData.split("\"Otp\":\"");
		AppData = AppData1[1];
		System.out.println("AppData::"+AppData);
		AppData1 = AppData.split("\"}]}");
		OTP = AppData1[0];
		System.out.println("OTP:: "+OTP);
		/*while (rs.next()) {
			sCustomerId =	rs.getLong("CustomerId");
		}*/
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		return OTP;
	}
	
	public static String getAppData(String EmailAddress)
	{
		long LoanId = getLoanId(EmailAddress);
		getDbConnection(SQLDBName);

		String AppData = null;

		try
		{	 statement = connObj.createStatement();
		String queryString = "select AppData from "+ SQLDBNameToGetLoan+ ".."+"Application"
				+ " where LoanId = '"+LoanId+"'";


		ResultSet rs = statement.executeQuery(queryString);

		while (rs.next()) {

			AppData =	rs.getString("AppData");

		}
		/*while (rs.next()) {
			sCustomerId =	rs.getLong("CustomerId");
		}*/
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		return AppData;
	}
	
	public static long getLoanStatusId(String EmailAddress)
	{
		long LoanId = getLoanId(EmailAddress);
		getDbConnection2();
		long LoanStatusId = 0;
		try
		{	 statement = connObj.createStatement();
		String queryString = "select LoanStatusId from "+ SQLDBNameToGetLoan+ ".."+"loan"
				+ " where LoanId = '"+LoanId+"' ";

		ResultSet rs = statement.executeQuery(queryString);
		while (rs.next()) {
			LoanStatusId =	rs.getLong("LoanStatusId");
		}
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		return LoanStatusId;
	}
	
	public static  String getLoanContractID(String EmailAddress)
	{
		long LoanId = getLoanId(EmailAddress);
		getDbConnection2();
		String LoanContractID = "0";
		try
		{	 statement = connObj.createStatement();
		String queryString = "select LoanContractNumber from "+ SQLDBNameToGetLoan+ ".."+"loan"
				+ " where LoanId = '"+LoanId+"' ";

		ResultSet rs = statement.executeQuery(queryString);
		while (rs.next()) {
			LoanContractID =	rs.getString("LoanContractNumber");
		}
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		return LoanContractID;
	}
	public static long getLoanTypeId(String EmailAddress)
	{
		long LoanId = getLoanId(EmailAddress);
		getDbConnection2();
		long LoanTypeId = 0;

		try
		{	 statement = connObj.createStatement();

		String queryString = "select LoanTypeId from "+ SQLDBNameToGetLoan+ ".."+"loan"
				+ " where LoanId = '"+LoanId+"' ";

		ResultSet rs = statement.executeQuery(queryString);

		while (rs.next()) {

			LoanTypeId =	rs.getLong("LoanTypeId");
			
			System.out.println("Loantype is::"+" "+LoanTypeId);
		}
		/*while (rs.next()) {
			sCustomerId =	rs.getLong("CustomerId");
		}*/
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		return LoanTypeId;
	}
	public static String LoanEffectiveDate(String EmailAddress)
	{
		long LoanId = getLoanId(EmailAddress);
		getDbConnection(SQLDBName);
		String EffectivDate = null;

		try
		{	 statement = connObj.createStatement();

		String queryString = "select EffectiveDate from "+ SQLDBNameToGetLoan+ ".."+"Loan"
				+ " where LoanId = '"+LoanId+"' ";

		ResultSet rs = statement.executeQuery(queryString);

		while (rs.next()) {

			EffectivDate =	rs.getString("EffectiveDate");
		}
		/*while (rs.next()) {
			sCustomerId =	rs.getLong("CustomerId");
		}*/
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		return EffectivDate;
	}
	

	public static HashMap<String, String> getLOANTable(String EmailAddress)
	{
		//long CustomId = getCustomerId(EmailAddress);
		long LoanId = getLoanId(EmailAddress);
		getDbConnection(SQLDBName);

		String LoanContractNumber;
		String LoanStatusId;
		String LoanTypeId;
		String Principal;
		String APR;
		String PaymentTypeId;
		String RepaymentTypeId;
		String ChannelTypeId;
		String StateCode;
		String ParentLoanId;

		HashMap<String, String> LoanDetails = new HashMap<>(); 

		//long sCustomerId = 0;
		try
		{	 statement = connObj.createStatement();
		String queryString = "select * from "+ SQLDBNameToGetLoan+ ".."+"loan"
				+ " where LoanId = '"+LoanId+"'";

		ResultSet rs = statement.executeQuery(queryString);

		while (rs.next()) {

			LoanContractNumber =	rs.getString("LoanContractNumber");
			LoanDetails.put("LoanContractNumber",LoanContractNumber);
			LoanStatusId = rs.getString("LoanStatusId");
			LoanDetails.put("LoanStatusId",LoanStatusId);
			LoanTypeId = rs.getString("LoanTypeId");
			LoanDetails.put("LoanTypeId",LoanTypeId);
			Principal =	rs.getString("Principal");
			LoanDetails.put("Principal",Principal);
			APR =	rs.getString("APR");
			LoanDetails.put("APR",APR);
			PaymentTypeId = rs.getString("PaymentTypeId");
			LoanDetails.put("PaymentTypeId",PaymentTypeId);
			RepaymentTypeId = rs.getString("RepaymentTypeId");
			LoanDetails.put("RepaymentTypeId",RepaymentTypeId);
			ChannelTypeId = rs.getString("ChannelTypeId");
			LoanDetails.put("ChannelTypeId",ChannelTypeId);
			StateCode =	rs.getString("StateCode");
			LoanDetails.put("StateCode",StateCode);	
			ParentLoanId = rs.getString("ParentLoanId");
			LoanDetails.put("ParentLoanId",ParentLoanId);	
			
			System.out.println(LoanStatusId);
		}

		/*while (rs.next()) {
			sCustomerId =	rs.getLong("CustomerId");
		}*/
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		return LoanDetails;
	}

	public static HashMap<String, String> getLOANDETAILSTable(String EmailAddress)
	{
		//long CustomId = getCustomerId(EmailAddress);
		long LoanId = getLoanId(EmailAddress);
		getDbConnection(SQLDBName);

		String LoanTerm;
		String ProcesScheduledEFT;

		HashMap<String, String> LOANDETAILS = new HashMap<>(); 

		//long sCustomerId = 0;
		try
		{	 statement = connObj.createStatement();
		String queryString = "select * from "+ SQLDBNameToGetLoan+ ".."+"LoanDetail"
				+ " where LoanId = '"+LoanId+"'";

		ResultSet rs = statement.executeQuery(queryString);

		while (rs.next()) {

			LoanTerm =	rs.getString("LoanTerm");
			LOANDETAILS.put("LoanTerm",LoanTerm);
			ProcesScheduledEFT = rs.getString("ProcesScheduledEFT");
			LOANDETAILS.put("ProcesScheduledEFT",ProcesScheduledEFT);

		}

		/*while (rs.next()) {
			sCustomerId =	rs.getLong("CustomerId");
		}*/
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		return LOANDETAILS;
	}

	public static HashMap<String, String> getLOANPAYMENTHEADERTable(String EmailAddress)
	{
		//long CustomId = getCustomerId(EmailAddress);
		long LoanId = getLoanId(EmailAddress);
		getDbConnection2();

		String NextScheduledDate;
		String PaymentAmount;

		HashMap<String, String> LOANPAYMENTHEADER = new HashMap<>(); 

		//long sCustomerId = 0;
		try
		{	 statement = connObj.createStatement();
		String queryString = "select * from "+ SQLDBNameToGetLoan+ ".."+"LoanPaymentHeader"
				+ " where LoanId = '"+LoanId+"'";


		ResultSet rs = statement.executeQuery(queryString);

		while (rs.next()) {

			NextScheduledDate =	rs.getString("NextScheduledDate");
			LOANPAYMENTHEADER.put("NextScheduledDate",NextScheduledDate);
			PaymentAmount = rs.getString("PaymentAmount");
			LOANPAYMENTHEADER.put("PaymentAmount",PaymentAmount);

		}

		/*while (rs.next()) {
			sCustomerId =	rs.getLong("CustomerId");
		}*/
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		return LOANPAYMENTHEADER;
	}
	public static HashMap<String, String> getLOANTRANSACTIONTable(String EmailAddress)
	{
		//long CustomId = getCustomerId(EmailAddress);
		long LoanId = getLoanId(EmailAddress);
		getDbConnection(SQLDBName);

		String TransactionTypeId;
		String PaymentTypeId;
		String Amount;
		String Principal;

		HashMap<String, String> LOANTRANSACTION = new HashMap<>(); 

		//long sCustomerId = 0;
		try
		{	 statement = connObj.createStatement();
		String queryString = "select * from "+ SQLDBNameToGetLoan+ ".."+"LoanTransaction"
				+ " where LoanId = '"+LoanId+"'";

		ResultSet rs = statement.executeQuery(queryString);

		while (rs.next()) {

			TransactionTypeId =	rs.getString("TransactionTypeId");
			LOANTRANSACTION.put("TransactionTypeId",TransactionTypeId);
			PaymentTypeId = rs.getString("PaymentTypeId");
			LOANTRANSACTION.put("PaymentTypeId",PaymentTypeId);
			Amount =	rs.getString("Amount");
			LOANTRANSACTION.put("Amount",Amount);
			Principal = rs.getString("Principal");
			LOANTRANSACTION.put("Principal",Principal);

		}

		/*while (rs.next()) {
			sCustomerId =	rs.getLong("CustomerId");
		}*/
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		return LOANTRANSACTION;
	}
	public static HashMap<String, String> getLOANPROCESSLOGTable(String EmailAddress,String TableValue1,String TableValue2,String TableValue3)
	{
		//long CustomId = getCustomerId(EmailAddress);
		long LoanId = getLoanId(EmailAddress);
		getDbConnection(SQLDBName);

		String Key;
		String Value;

		HashMap<String, String> LOANPROCESSLOG = new HashMap<>(); 

		//long sCustomerId = 0;
		try
		{	 statement = connObj.createStatement();
		String queryString = "select [Key],Value from "+ SQLDBNameToGetLoan+ ".."+"LoanProcessLog"
				+ " (nolock) where identifier = CONVERT(VARCHAR(19),"+LoanId+")";


		ResultSet rs = statement.executeQuery(queryString);

		while (rs.next()) {

			Key =	rs.getString("Key");
			Value = rs.getString("Value");
			if(Key.equalsIgnoreCase(TableValue1))
			{
				LOANPROCESSLOG.put(TableValue1,Value);
			}
			else if(Key.equalsIgnoreCase(TableValue2))
			{
				LOANPROCESSLOG.put(TableValue2,Value);
			}
			else if(Key.equalsIgnoreCase(TableValue3))
			{
				LOANPROCESSLOG.put(TableValue3,Value);
			}
		}


		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		return LOANPROCESSLOG;
	}
	/* comment 14 07 july 2022
	public static List<String> getLOANNOTETable(String EmailAddress)
	{
		//long CustomId = getCustomerId(EmailAddress);
		long LoanId = getLoanId(EmailAddress);
		getDbConnection2();

		String Note;
		List<String> Notes = new ArrayList<>(); 
		//long sCustomerId = 0;
		try
		{	 statement = connObj.createStatement();
		String queryString = "select Note from "+ SQLDBNameToGetLoan+ ".."+"LoanNote"
				+ " where LoanId = '"+LoanId+"'";
		ResultSet rs = statement.executeQuery(queryString);

		while (rs.next()) {

			Note = rs.getString("Note");

			Notes.add(Note);

		}

		System.out.println("loan note:::"+"/"+Notes);
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		return Notes;
	}
comment end*/
	public static List<String> getLOANDOCSPTH(String EmailAddress)
	{
		//long CustomId = getCustomerId(EmailAddress);
		long LoanId = getLoanId(EmailAddress);
		getDbConnection(SQLDBName);

		String Doc;
		List<String> Docs = new ArrayList<>(); 
		//long sCustomerId = 0;
		try
		{	 statement = connObj.createStatement();
		String queryString = "select DocumentPath from "+ SQLDBNameToGetLoan+ ".."+"LoanDocument"
				+ " where LoanId = '"+LoanId+"'";
		
		ResultSet rs = statement.executeQuery(queryString);

		while (rs.next()) {

			Doc = rs.getString("DocumentPath");

			Docs.add(Doc);

		}


		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		return Docs;
	}

	public static long getPhoneNumbCount(String PhoneNo)
	{
		getDbConnection(SQLDBName);
		int Count_Ph = 0;
		try
		{	 statement = connObj.createStatement();
		String queryString = "select Count(*) from "+ SQLDBName+ ".."+"CustomerPhone"
				+ " where PhoneNumber = '"+PhoneNo+"'";

		ResultSet rs = statement.executeQuery(queryString);
		while (rs.next()) {
			Count_Ph =	rs.getInt("");
		}
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		return Count_Ph;
	}
	public static int getEmailCount(String OldEmail)
	{
		System.out.println("Db connection started");
		getDbConnection2();
		int Count_Email = 0;
		try
		{	 statement = connObj.createStatement();
		String queryString = "select Count(*) from "+ SQLDBName+ ".."+"customeremail"
				+ " where Email = '"+OldEmail+"'";
		System.out.println("User with email count in DB is "+queryString);
		ResultSet rs = statement.executeQuery(queryString);
		while (rs.next()) {
			Count_Email =	rs.getInt("");
		}
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		return Count_Email;
	}

	public static long getAddressCount(String Address)
	{
		getDbConnection2();
		System.out.println("Addresss:::"+Address);
		String[] Addres = Address.split(",");
		System.out.println("Addresss:::"+Addres);
		// 78, Carson Ave, WHITBY, ON, L1M1J5, CANADA
		String add2 = Addres[0].trim();
		String add3 = Addres[1].trim();
		String city = Addres[2].trim();
		String prov = Addres[3].trim();
		String zip = Addres[4].trim();
		
		System.out.println("add2:"+add2+"add3::"+add3+"city::"+city+"prov::"+prov+"zip::"+zip);
		int Count_Add = 0;
		try
		{	 statement = connObj.createStatement();
		String queryString = "select Count(*) from "+ SQLDBName+ ".."+"CustomerAddress where "
				+ "address2='"+ add2
				+ "' and Address3='"+ add3
				+ "' and city='"+ city
				+ "'and postalcode='"+ zip+ "'";
		System.out.println("queryString"+queryString);
		//System.out.println("String query for the address is "+queryString);

		/*	78 Carson Ave, WHITBY ON L1M 1J5, CANADA
		Select Count(*) from VitaCrmCANETL..CustomerAddress
�		where address2='106-4950' and Address3='Albina Way' and city='Mississauga'and state='ON'and postalcode='L4Z4J4'
		 */
		ResultSet rs = statement.executeQuery(queryString);
		while (rs.next()) {
			Count_Add =	rs.getInt("");
		}
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		return Count_Add;
	}

	public static long getAddressCount_WithoutSpaceInZIp(String Address)
	{
		getDbConnection(SQLDBName);
		String[] Addres = Address.split(",");
		// 78, Carson Ave, WHITBY, ON, L1M1J5, CANADA
		String add2 = Addres[0].trim();
		String add3 = Addres[1].trim();
		String city = Addres[2].trim();
		String prov = Addres[3].trim();
		String zip = Addres[4].trim();

		int Count_Add = 0;
		try
		{	 statement = connObj.createStatement();
		String queryString = "select Count(*) from "+ SQLDBName+ ".."+"CustomerAddress where "
				+ "address2='"+ add2
				+ "' and Address3='"+ add3
				+ "' and city='"+ city
				+ "'and state='"+ prov
				+ "'and postalcode='"+ zip+ "'";

		//System.out.println("String query for the address is "+queryString);

		/*	78 Carson Ave, WHITBY ON L1M 1J5, CANADA
		Select Count(*) from VitaCrmCANETL..CustomerAddress
�		where address2='106-4950' and Address3='Albina Way' and city='Mississauga'and state='ON'and postalcode='L4Z4J4'
		 */
		ResultSet rs = statement.executeQuery(queryString);
		while (rs.next()) {
			Count_Add =	rs.getInt("");
		}
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		return Count_Add;
	}

	public static ArrayList<String>getListCustID_Phone(String PhoneNo)
	{
		getDbConnection(SQLDBName);
		long CustID2 = 0;
		ArrayList<String> ListOfCustID = new ArrayList<>();
		String CustID3 = null;

		try
		{	 statement = connObj.createStatement();
		String queryString = "select CustomerId from "+ SQLDBName+ ".."+"CustomerPhone"
				+ " where PhoneNumber = '"+PhoneNo+"'"+" group by CustomerId";

		ResultSet rs = statement.executeQuery(queryString);

		while (rs.next()) {

			CustID2 =	rs.getLong("CustomerId");
			CustID3 = CustID2+"";
			ListOfCustID.add(CustID3);
		}
		//System.out.println("The answer After the while loop is ArrayList "+ListOfCustID);
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		//return customers;
		return ListOfCustID;
	}

	public static ArrayList<String>getListCustID_Address(String Address)
	{
		getDbConnection(SQLDBName);
		long CustID2 = 0;
		ArrayList<String> ListOfCustID = new ArrayList<>();
		String CustID3 = null;
		String[] Addres = Address.split(",");
		String add2 = Addres[0].trim();
		String add3 = Addres[1].trim();
		String city = Addres[2].trim();
		String prov = Addres[3].trim();
		String zip = Addres[4].trim();

		try
		{	 
			statement = connObj.createStatement();

			String queryString = "select CustomerId from "+ SQLDBName+ ".."+"CustomerAddress where "
					+ "address2='"+ add2
					+ "' and Address3='"+ add3
					+ "' and city='"+ city
					+ "'and postalcode='"+ zip+ "'"
					+" group by CustomerId";

			//	Select CustomerId from VitaCrmCANETL..CustomerAddress
			//	where address2='106-4950' and Address3='Albina Way' and city='Mississauga'and state='ON'and postalcode='L4Z4J4' group by CustomerId

			ResultSet rs = statement.executeQuery(queryString);

			while (rs.next()) {

				CustID2 =	rs.getLong("CustomerId");
				CustID3 = CustID2+"";
				ListOfCustID.add(CustID3);
			}
			//System.out.println("The answer After the while loop is ArrayList "+ListOfCustID);
			logger.info("--------Table data retrieving successfully--------");
			System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		//return customers;
		return ListOfCustID;
	}

	//added 20 july 2022 start
	public static ArrayList<String>getListCustID_email(String EmailId)
	{
		getDbConnection2();
		long CustID2 = 0;
		ArrayList<String> ListOfCustID = new ArrayList<>();
		String CustID3 = null;
		
		String emailid=EmailId;
		System.out.println("email id::"+emailid);
		try
		{	 
			statement = connObj.createStatement();

			String queryString = "select CustomerId from "+ SQLDBName+ ".."+"customeremail where " +" "
					
					+ "Email='"+ EmailId+ "'"+" "
					+" group by"+" "+" CustomerId";

			//	Select CustomerId from VitaCrmCANETL..CustomerAddress
			//	where address2='106-4950' and Address3='Albina Way' and city='Mississauga'and state='ON'and postalcode='L4Z4J4' group by CustomerId

			ResultSet rs = statement.executeQuery(queryString);

			while (rs.next()) {

				CustID2 =	rs.getLong("CustomerId");
				CustID3 = CustID2+"";
				ListOfCustID.add(CustID3);
			}
			System.out.println("The answer After the while loop is ArrayList "+ListOfCustID);
			logger.info("--------Table data retrieving successfully--------");
			System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		//return customers;
		return ListOfCustID;
	}
	
	// added 20 july 2022 end
	
	public static void UpdateQuery_Phone_Threshold(ArrayList<String> ListCusts)
	{
		getDbConnection(SQLDBName);
		String commaseparatedlist = ListCusts.toString(); 
		commaseparatedlist = commaseparatedlist.replace("[", "") .replace("]", "") .replace(" ", ""); 
		//System.out.println("Coma separated list is "+commaseparatedlist);
		try
		{
			statement = connObj.createStatement();
			String sql =  "Update "+ SQLDBName+ ".."+"CustomerPhone"
					+ " set PhoneNumber = '9898989898'"+" where CustomerID in ("+commaseparatedlist+")";
			statement.executeUpdate(sql);
			
			
			logger.info("#######################PHONENO THREASHOLD############################");
			logger.info(sql);
			logger.info("#######################PHONENO THREASHOLD############################");

			//Added on 07-July-2022 Start
			logLoanDetails.add("#######################PHONENO THREASHOLD############################");
			logLoanDetails.add(sql);
			logLoanDetails.add("#######################PHONENO THREASHOLD############################");
			//Added on 07-July-2022 End

			//Added on 07-July-2022 Start
			UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
			logLoanDetails.clear();
			//Added on 07-July-2022 End

			logger.info("--------Table data updated successfully--------");
			System.out.println("Table data updated successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE UPDATING DATA TO TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while Updating data to MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
	}

	public static void Check_Update_Phone_Threshold(String PhoneNo, String EmailId) throws IOException
	{
		long Count_Ph = getPhoneNumbCount(PhoneNo);
		long CustomId = getCustomerId(EmailId);

		if(Count_Ph>2)
		{
			OnlineActions.PrintValueToReport("The provided phone number is not within the Threshold - "+Count_Ph,"Phone number Threshold: ");
			ArrayList<String> ListCusts = getListCustID_Phone(PhoneNo);
			String CustomID1 = CustomId+"";
			ListCusts.remove(CustomID1);
			System.out.println("List of customer id after remove current user"+ListCusts);
			UpdateQuery_Phone_Threshold(ListCusts);
			Count_Ph = getPhoneNumbCount(PhoneNo);
			System.out.println("Phone number threshold after update threshold query "+Count_Ph);
			if(Count_Ph>2)
			{
				System.out.println("Still the Phone number thresold is not updated");
				OnlineActions.PrintValueToReport("Still able to see same phone number more than 3 customers - count - "+"<b>"+Count_Ph+"</b>"+" for the CustId: "+"<b>"+CustomId+"</b>","Phone number Threshold after DB Threshold qury update: ");
			}
			else
			{
				OnlineActions.PrintValueToReport("The provided phone number is within the Threshold count - "+"<b>"+Count_Ph+"</b>"+" for the CustId: "+"<b>"+CustomId+"</b>","Phone number Threshold after DB update: ");
			}
		}
		else
		{
			OnlineActions.PrintValueToReport("The provided phone number is within the Threshold count - "+"<b>"+Count_Ph+"</b>"+" for the CustId: "+"<b>"+CustomId+"</b>","Phone number Threshold: ");
		}
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
	}
	//added 20 july 2022 stat
	public static void Check_email_Threshold(String EmailId) throws IOException
	{
		long Count_email = getEmailCount(EmailId);
		long CustomId = getCustomerId(EmailId);
		System.out.println("email count from threashold is "+Count_email);
		if(Count_email>2)
		{
			//OnlineActions.PrintValueToReport("The provided Address count is not within the Threshold - "+"<b>"+Count_Addr+"</b>"+" for the CustId: "+"<b>"+CustomId+"</b>","Address count Threshold: ");
			ArrayList<String> ListCusts = getListCustID_email(EmailId);
			String CustomID1 = CustomId+"";
			System.out.println("Current user customer id is "+CustomID1);
			System.out.println("List of customer id before remove current user"+ListCusts);
			ListCusts.remove(CustomID1);
			System.out.println("List of customer id after remove current user"+ListCusts);
			
			UpdateQuery_emailid_Threshold(ListCusts);
			
			
			System.out.println("email number threshold after update threshold query "+Count_email);
			if(Count_email>2)
			{
				System.out.println("Still the email count thresold is not updated");
				//OnlineActions.PrintValueToReport("Still able to see same address for more than 3 customers count - "+"<b>"+Count_Addr+"</b>"+" for the CustId: "+"<b>"+CustomId+"</b>","Address count Threshold after DB Threshold query update: ");
			}
			else
			{
				//OnlineActions.PrintValueToReport("The provided Address count is within the Threshold count - "+"<b>"+Count_Addr+"</b>"+" for the CustId: "+"<b>"+CustomId+"</b>","Address count Threshold after DB update: ");
			}
		}
		else
		{
			//OnlineActions.PrintValueToReport("The provided Address count is within the Threshold count - "+"<b>"+Count_Addr+"</b>"+" for the CustId: "+"<b>"+CustomId+"</b>","Address count Threshold: ");
		}
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
	}
	
	//added 20 july 2022 end
	
	
	public static String UpdateDuplicateEmail(String OldEmail) throws IOException
	{

		int Count_Customers = getEmailCount(OldEmail);
		System.out.println("Count of duplicate emails from db is "+Count_Customers);
		String newEmail = "ignore@noduplicatemail.com";
		
		if(Count_Customers>0)
		{
			OnlineActions.PrintValueToReport("There are already "+Count_Customers+" customer(s) exist with this email", "Duplicate customer count");
			//Create a random number and assign to the old email id
			for(int i=0;i<Count_Customers;i++)
			{
				int length = 8;
				boolean useLetters = true;
				boolean useNumbers = true;
				String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
				newEmail = generatedString+"_"+OldEmail;
				int Count_Customers1 = getEmailCount(newEmail);
				while(Count_Customers1>0)
				{
					newEmail = RandomStringUtils.random(length, useLetters, useNumbers)+"_"+OldEmail;
					Count_Customers1 = getEmailCount(newEmail);
				}
				long CustomeriD = getCustomerId(OldEmail);
				getDbConnection(SQLDBName);
				try
				{
					statement = connObj.createStatement();
					String sql =  "Update "+ SQLDBName+ ".."+"CustomerEmail "
							+ "set Email='"
							+ newEmail
							+ "'"+" where CustomerId='"+ CustomeriD+ "'";
					statement.executeUpdate(sql);
					OnlineActions.PrintValueToReport("The old email id is "+OldEmail+" AND new email id is "+newEmail+" AND the custmer id is "+CustomeriD,"Change email details");
					logger.info("--------Table data updated successfully--------");
					System.out.println("Table data updated successfully");
				}
				catch(Exception e)
				{
					System.out.println("EXCEPTION WHILE UPDATING DATA TO TABLE "+e.getMessage());
					logger.info("--------EXCEPTION while Updating data to MS SQL Server Table--------: "+e.getMessage());
					e.printStackTrace();
				}
				finally 
				{
					try {
						connObj.close();
					} catch (SQLException e) {
						System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
						logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
						e.printStackTrace();
					}
				}
			}

		}
		else
		{
			OnlineActions.PrintValueToReport(" is 0 ", "Duplicate customer count");
		}
		return newEmail;
	}

	public static void UpdateLoanContractID(String Email,String NewContractID) throws IOException
	{

		long loanid = getLoanId(Email);
		getDbConnection2();
		try
		{
			statement = connObj.createStatement();
			String sql =  "update "+ SQLDBNameToGetLoan+ ".."+"loan "
					+ "set LoanContractNumber='"
					+ NewContractID
					+ "'"+" where loanID='"+ loanid+ "'";
			
			
			statement.executeUpdate(sql);
			logger.info("--------Table data updated successfully--------");
			System.out.println("Table data updated successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE UPDATING DATA TO TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while Updating data to MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}

	}

	public static void UpdateLoanStatus(String Email,int LoanStatus) throws IOException
	{

		long loanid = getLoanId(Email);
		getDbConnection2();
		try
		{
			statement = connObj.createStatement();
			String sql =  "update "+ SQLDBNameToGetLoan+ ".."+"loan "
					+ "set loanstatusID='"
					+ LoanStatus
					+ "'"+" where loanID='"+ loanid+ "'"+"and"+" "+"loanstatusid='19'";
			
			statement.executeUpdate(sql);
			logger.info("--------Table data updated successfully--------");
			System.out.println("Table data updated successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE UPDATING DATA TO TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while Updating data to MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}

	}
	
	public static void UpdateLoanStatus_3(String Email,int LoanStatus) throws IOException
	{

		long loanid = getLoanId(Email);
		getDbConnection2();
		try
		{
			statement = connObj.createStatement();
			String sql =  "update "+ SQLDBNameToGetLoan+ ".."+"loan "
					+ "set loanstatusID='"
					+ LoanStatus
					+ "'"+" where loanID='"+ loanid+ "'";
			
			statement.executeUpdate(sql);
			logger.info("--------Table data updated successfully--------");
			logger.info("PPP "+statement);
			System.out.println("Table data updated successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE UPDATING DATA TO TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while Updating data to MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}

	}

	
	
	public static void UpdateQuery_Address_Threshold(ArrayList<String> ListCusts)
	{

		getDbConnection2();
		String commaseparatedlist = ListCusts.toString(); 
		commaseparatedlist = commaseparatedlist.replace("[", "") .replace("]", "") .replace(" ", ""); 
		//System.out.println("Coma separated list is "+commaseparatedlist);
		try
		{
			statement = connObj.createStatement();
			String sql =  "Update "+ SQLDBName+ ".."+"CustomerAddress "
					+ "set"+" Active='0',LivedhereFrom='2020-08-19' "+" where CustomerID in ("+commaseparatedlist+")";
			statement.executeUpdate(sql);

			logger.info("--------Table data updated successfully--------");
			System.out.println("Table data updated successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE UPDATING DATA TO TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while Updating data to MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}

	}
	
	//added 20 july 2022
	public static void UpdateQuery_emailid_Threshold(ArrayList<String> ListCusts)
	{

		getDbConnection2();
		String commaseparatedlist = ListCusts.toString(); 
		commaseparatedlist = commaseparatedlist.replace("[", "") .replace("]", "") .replace(" ", ""); 
		//System.out.println("Coma separated list is "+commaseparatedlist);
		try
		{
			statement = connObj.createStatement();
			String sql =  "Update "+ SQLDBName+ ".."+"CustomerEmail "
					+ "set"+" Active='0' "+" where CustomerID in ("+commaseparatedlist+")";
			statement.executeUpdate(sql);

			logger.info("--------Table data updated successfully--------");
			System.out.println("Table data updated successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE UPDATING DATA TO TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while Updating data to MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}

	}
	//added 20 july 2022
	public static void Check_Update_Address_Threshold(String Address,String EmailId) throws IOException
	{
		long Count_Addr = getAddressCount(Address);
		long CustomId = getCustomerId(EmailId);
		System.out.println("Address count from threashold is "+Count_Addr);
		if(Count_Addr>2)
		{
			//OnlineActions.PrintValueToReport("The provided Address count is not within the Threshold - "+"<b>"+Count_Addr+"</b>"+" for the CustId: "+"<b>"+CustomId+"</b>","Address count Threshold: ");
			ArrayList<String> ListCusts = getListCustID_Address(Address);
			String CustomID1 = CustomId+"";
			System.out.println("Current user customer id is "+CustomID1);
			System.out.println("List of customer id before remove current user"+ListCusts);
			ListCusts.remove(CustomID1);
			System.out.println("List of customer id after remove current user"+ListCusts);
			UpdateQuery_Address_Threshold(ListCusts);
			Count_Addr = getAddressCount(Address);
			System.out.println("Address number threshold after update threshold query "+Count_Addr);
			if(Count_Addr>2)
			{
				System.out.println("Still the Address count thresold is not updated");
				//OnlineActions.PrintValueToReport("Still able to see same address for more than 3 customers count - "+"<b>"+Count_Addr+"</b>"+" for the CustId: "+"<b>"+CustomId+"</b>","Address count Threshold after DB Threshold query update: ");
			}
			else
			{
				//OnlineActions.PrintValueToReport("The provided Address count is within the Threshold count - "+"<b>"+Count_Addr+"</b>"+" for the CustId: "+"<b>"+CustomId+"</b>","Address count Threshold after DB update: ");
			}
		}
		else
		{
			//OnlineActions.PrintValueToReport("The provided Address count is within the Threshold count - "+"<b>"+Count_Addr+"</b>"+" for the CustId: "+"<b>"+CustomId+"</b>","Address count Threshold: ");
		}
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
	}
	
	///added 18 july 2022 start
	public static void update_address(String Address)
	{ 
		getDbConnection2();
		try 
		{
		String[] Address1 = Address.split(",");
		
		String Address2 = Address1[0];
		String Address3 = Address1[1];
		String City = Address1[2];
		String PostalCode = Address1[4];
		String State = Address1[3];
		
		
				
		statement = connObj.createStatement();
		String sql =  "update "+ SQLDBName+ "."+"[dbo].[CustomerAddress] "
				+ "set LivedHereFrom="+"'2022-01-01'" +","+"Address2='"
				+ Address2
				+ "' ,"+"Address3='"+Address3+ "' ,"+"City='"+City + "' ,"+"PostalCode='"+PostalCode+ "' ,"+"State='"+State+"'"+","+"Active="+"'1'"+
				" "+" where CustomerID in ('4178866','4179078','4179080')";
		
		System.out.println("address updates query is "+sql);
	
		
		statement.executeUpdate(sql);
		logger.info("--------Table data updated successfully--------");
		System.out.println("Table data updated successfully");
		}
	catch(Exception e)
	{
		System.out.println("EXCEPTION WHILE UPDATING DATA TO TABLE "+e.getMessage());
		logger.info("--------EXCEPTION while Updating data to MS SQL Server Table--------: "+e.getMessage());
		e.printStackTrace();
	}
	finally 
	{
		try {
			connObj.close();
		} catch (SQLException e) {
			System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
			logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
			e.printStackTrace();
		}
	}
		
	
	logger.info("--------Table data retrieving successfully--------");
	System.out.println("Table data retrieving successfully");
		}
			
	
	///added 18 july 2022 end
	public static void Update_Address(String Address, String EmailId) throws IOException
	{
		long CustId = getCustomerId(EmailId);
		getDbConnection(SQLDBName);
		try
		{
			String[] Address1 = Address.split(",");
			
			String Address2 = Address1[0];
			String Address3 = Address1[1];
			String City = Address1[2];
			String PostalCode = Address1[3];
			String State = Address1[4];
			
			statement = connObj.createStatement();
			String sql =  "update "+ SQLDBName+ "."+"[dbo].[CustomerAddress] "
					+ "set Address2='"
					+ Address2
					+ "' ,"+"Address3='"+Address3+ "' ,"+"City='"+City + "' ,"+"PostalCode='"+PostalCode+ "' ,"+"State='"+State+
					"' "+" where CustomerID='"+ CustId+ "'";
			
			System.out.println("address updates query is "+sql);
			
		//	String sq1l =  "Update "+ SQLDBName+ ".."+"CustomerAddress "
		//			+ "set Address2='200-182',Address3='Bay St',City='Toronto',PostalCode='M5J 2T3'"+" where CustomerID in ("+commaseparatedlist+")";
			
	//		Update VitaCrmCAN.[dbo].[CustomerAddress] set Address2='65898',Address3='HOPE RD',City='MISSISSAUGA',PostalCode='L4Z2V7',
	//				�State='ON' where CustomerID = '4041325'
			
			
			statement.executeUpdate(sql);
			logger.info("--------Table data updated successfully--------");
			System.out.println("Table data updated successfully");
			OnlineActions.PrintValueToReport("Address is updated to "+"<b>"+Address+ "</b>"+ " for the customer with CustId: "+"<b>"+CustId+"</b>","Address update: ");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE UPDATING DATA TO TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while Updating data to MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
			
		
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
	}
	public static void executeTUQuery(long biCustomerId) throws SQLException
	{
		try
		{
			CallableStatement statement = null;
			statement = connObj.prepareCall("{call dbo.stpr_TuQueryRunBasedonCustomerIdbyPP(?)}");
			statement.setLong("biCustomerId", biCustomerId);
			boolean TUQueryResult = statement.execute();
			if(TUQueryResult == true)
			{
				System.out.println("Stored procedure executed successfully with "+biCustomerId);
				logger.info("--------Stored procedure executed successfully with "+biCustomerId+"--------");
			}
			else
			{
				System.out.println("Stored procedure unsuccessfull with "+biCustomerId);
				logger.info("--------Stored procedure unsuccessfull with "+biCustomerId+"--------");
			}
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE EXECUTING TU STORED PROCEDURE "+e.getMessage());
			logger.info("--------EXCEPTION WHILE EXECUTING TU STORED PROCEDURE--------: "+e.getMessage());
		}

		finally 
		{
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					System.out.println("EXCEPTION WHILE Closing Callable Statement"+ex.getMessage());
					logger.info("--------EXCEPTION WHILE Closing Callable Statement--------: "+ex.getMessage());
				}
			}
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
	} 

	public static void execute15000TUQuery(String EmailId ) throws SQLException
	{
		try
		{System.out.println("------------>   11111 <--------------");
			int biCustomerId = (int) getCustomerId(EmailId);
			System.out.println("Customer id for tu query is "+biCustomerId);
			getDbConnection(SQLDBNameToRunTuQuery);
			CallableStatement statement = null;
			String Tuq = "{call "+ getPropertyValue("SP_TU_15000")+ "(?)}";
			System.out.println("TU query is "+Tuq);
			statement = connObj.prepareCall(Tuq);
			statement.setLong("iCustomerID", biCustomerId);
			boolean TUQueryResult = statement.execute();
			System.out.println("TU execution result : "+TUQueryResult);
			if(TUQueryResult == true)
			{
				System.out.println("Stored procedure executed successfully with "+biCustomerId);
				//logger.info("--------Stored procedure executed successfully with "+biCustomerId+"--------");
			}
			else
			{
				System.out.println("Stored procedure unsuccessfull with "+biCustomerId);
				//logger.info("--------Stored procedure unsuccessfull with "+biCustomerId+"--------");
			}
			OnlineActions.PrintValueToReport("New Decile TU query executed successfully for CustID: "+biCustomerId, "IL TU query status: ");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE EXECUTING TU STORED PROCEDURE "+e.getMessage());
			//logger.info("--------EXCEPTION WHILE EXECUTING TU STORED PROCEDURE--------: "+e.getMessage());
		}

		finally 
		{
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					System.out.println("EXCEPTION WHILE Closing Callable Statement"+ex.getMessage());
					//logger.info("--------EXCEPTION WHILE Closing Callable Statement--------: "+ex.getMessage());
				}
			}
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				//logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
	}  
	
	public static void execute_Proviner_Decile_TUQuery_1_Bankruptcies(String EmailId ) throws SQLException
	{
		try
		{System.out.println("------------>   11111 <--------------");
			int biCustomerId = (int) getCustomerId(EmailId);
			System.out.println("Customer id for tu query is "+biCustomerId);
			getDbConnection(SQLDBNameToRunTuQuery);
			CallableStatement statement = null;
			String Tuq = "{call "+ getPropertyValue("SP_PRO_DECILE_TU_QUERY_1_BANKRUPTCIES")+ "(?)}";
			System.out.println("TU query is "+Tuq);
			statement = connObj.prepareCall(Tuq);
			statement.setLong("iCustomerID", biCustomerId);
			boolean TUQueryResult = statement.execute();
			System.out.println("TU execution result : "+TUQueryResult);
			if(TUQueryResult == true)
			{
				System.out.println("Stored procedure executed successfully with "+biCustomerId);
				//logger.info("--------Stored procedure executed successfully with "+biCustomerId+"--------");
			}
			else
			{
				System.out.println("Stored procedure unsuccessfull with "+biCustomerId);
				//logger.info("--------Stored procedure unsuccessfull with "+biCustomerId+"--------");
			}
			OnlineActions.PrintValueToReport("New Decile TU query executed successfully for CustID: "+biCustomerId, "IL TU query status: ");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE EXECUTING TU STORED PROCEDURE "+e.getMessage());
			//logger.info("--------EXCEPTION WHILE EXECUTING TU STORED PROCEDURE--------: "+e.getMessage());
		}

		finally 
		{
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					System.out.println("EXCEPTION WHILE Closing Callable Statement"+ex.getMessage());
					//logger.info("--------EXCEPTION WHILE Closing Callable Statement--------: "+ex.getMessage());
				}
			}
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				//logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
	} 
	
	public static void execute_Proviner_Decile_TUQuery_1(String EmailId ) throws SQLException
	{
		try
		{System.out.println("------------>   11111 <--------------");
			int biCustomerId = (int) getCustomerId(EmailId);
			System.out.println("Customer id for tu query is "+biCustomerId);
			getDbConnection(SQLDBNameToRunTuQuery);
			CallableStatement statement = null;
			String Tuq = "{call "+ getPropertyValue("SP_PRO_DECILE_TU_QUERY_1")+ "(?)}";
			System.out.println("TU query is "+Tuq);
			statement = connObj.prepareCall(Tuq);
			statement.setLong("iCustomerID", biCustomerId);
			boolean TUQueryResult = statement.execute();
			System.out.println("TU execution result : "+TUQueryResult);
			if(TUQueryResult == true)
			{
				System.out.println("Stored procedure executed successfully with "+biCustomerId);
				//logger.info("--------Stored procedure executed successfully with "+biCustomerId+"--------");
			}
			else
			{
				System.out.println("Stored procedure unsuccessfull with "+biCustomerId);
				//logger.info("--------Stored procedure unsuccessfull with "+biCustomerId+"--------");
			}
			OnlineActions.PrintValueToReport("New Decile TU query executed successfully for CustID: "+biCustomerId, "IL TU query status: ");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE EXECUTING TU STORED PROCEDURE "+e.getMessage());
			//logger.info("--------EXCEPTION WHILE EXECUTING TU STORED PROCEDURE--------: "+e.getMessage());
		}

		finally 
		{
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					System.out.println("EXCEPTION WHILE Closing Callable Statement"+ex.getMessage());
					//logger.info("--------EXCEPTION WHILE Closing Callable Statement--------: "+ex.getMessage());
				}
			}
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				//logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
	} 
	
	
	public static void execute_Proviner_Decile_TUQuery_To_Get_Less_Thank_1k_Approved_Amount(String EmailId, String inpFICO_Value) throws SQLException
	{
		try
		{System.out.println("------------>   11111 <--------------");
			int biCustomerId = (int) getCustomerId(EmailId);
			System.out.println("Customer id for tu query is "+biCustomerId);
			getDbConnection(SQLDBNameToRunTuQuery);
			CallableStatement statement = null;
			String Tuq = "{call "+ getPropertyValue("SP_PRO_DECILE_TU_QUERY_TOGetLessThan1K")+ "(?,?)}";
			System.out.println("TU query is "+Tuq);
			statement = connObj.prepareCall(Tuq);
			
			statement.setLong("iCustomerID", biCustomerId);
			
			statement.setString("FICO_Value", inpFICO_Value);
			
			boolean TUQueryResult = statement.execute();
			System.out.println("TU execution result : "+TUQueryResult);
			if(TUQueryResult == true)
			{
				System.out.println("Stored procedure executed successfully with "+biCustomerId);
				//logger.info("--------Stored procedure executed successfully with "+biCustomerId+"--------");
			}
			else
			{
				System.out.println("Stored procedure unsuccessfull with "+biCustomerId);
				//logger.info("--------Stored procedure unsuccessfull with "+biCustomerId+"--------");
			}
			OnlineActions.PrintValueToReport("New Decile TU query executed successfully for CustID: "+biCustomerId, "IL TU query status: ");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE EXECUTING TU STORED PROCEDURE "+e.getMessage());
			//logger.info("--------EXCEPTION WHILE EXECUTING TU STORED PROCEDURE--------: "+e.getMessage());
		}

		finally 
		{
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					System.out.println("EXCEPTION WHILE Closing Callable Statement"+ex.getMessage());
					//logger.info("--------EXCEPTION WHILE Closing Callable Statement--------: "+ex.getMessage());
				}
			}
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				//logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
	} 
	
	public static void execute_Proviner_Decile_TUQuery_To_Get_Less_Thank_1k_Approved_Amount_ReRefiEA(String EmailId, String inpFICO_Value) throws SQLException
	{
		try
		{System.out.println("------------>   11111 <--------------");
			int biCustomerId = (int) getCustomerId(EmailId);
			System.out.println("Customer id for tu query is "+biCustomerId);
			getDbConnection(SQLDBNameToRunTuQuery);
			CallableStatement statement = null;
			String Tuq = "{call "+ getPropertyValue("SP_PRO_DECILE_TU_QUERY_TOGetLessThan1K_ReRefiEA")+ "(?,?)}";
			System.out.println("TU query is "+Tuq);
			statement = connObj.prepareCall(Tuq);
			
			statement.setLong("iCustomerID", biCustomerId);
			
			statement.setString("FICO_Value", inpFICO_Value);
			
			boolean TUQueryResult = statement.execute();
			System.out.println("TU execution result : "+TUQueryResult);
			if(TUQueryResult == true)
			{
				System.out.println("Stored procedure executed successfully with "+biCustomerId);
				//logger.info("--------Stored procedure executed successfully with "+biCustomerId+"--------");
			}
			else
			{
				System.out.println("Stored procedure unsuccessfull with "+biCustomerId);
				//logger.info("--------Stored procedure unsuccessfull with "+biCustomerId+"--------");
			}
			OnlineActions.PrintValueToReport("New Decile TU query executed successfully for CustID: "+biCustomerId, "IL TU query status: ");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE EXECUTING TU STORED PROCEDURE "+e.getMessage());
			//logger.info("--------EXCEPTION WHILE EXECUTING TU STORED PROCEDURE--------: "+e.getMessage());
		}

		finally 
		{
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					System.out.println("EXCEPTION WHILE Closing Callable Statement"+ex.getMessage());
					//logger.info("--------EXCEPTION WHILE Closing Callable Statement--------: "+ex.getMessage());
				}
			}
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				//logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
	} 
	
	
	
	public static void execute_Proviner_Decile_TUQuery_denied_Rule(String EmailId, String inpFICO_Value,
			String inpPR43_Value, String inpPR11_Value, String inpPR12_Value) throws SQLException
	{
		try
		{System.out.println("------------>   11111 <--------------");
			int biCustomerId = (int) getCustomerId(EmailId);
			System.out.println("Customer id for tu query is "+biCustomerId);
			getDbConnection(SQLDBNameToRunTuQuery);
			CallableStatement statement = null;
			String Tuq = "{call "+ getPropertyValue("SP_PRO_DECILE_TU_QUERY_deniedRule")+ "(?,?,?,?,?)}";
			System.out.println("TU query is "+Tuq);
			statement = connObj.prepareCall(Tuq);
			
			statement.setLong("iCustomerID", biCustomerId);
			
			statement.setString("FICO_Value", inpFICO_Value);
			statement.setString("PR43_Value", inpPR43_Value);
			statement.setString("PR11_Value", inpPR11_Value);
			statement.setString("PR12_Value", inpPR12_Value);
			
			
			
			boolean TUQueryResult = statement.execute();
			System.out.println("TU execution result : "+TUQueryResult);
			if(TUQueryResult == true)
			{
				System.out.println("Stored procedure executed successfully with "+biCustomerId);
				//logger.info("--------Stored procedure executed successfully with "+biCustomerId+"--------");
			}
			else
			{
				System.out.println("Stored procedure unsuccessfull with "+biCustomerId);
				//logger.info("--------Stored procedure unsuccessfull with "+biCustomerId+"--------");
			}
			OnlineActions.PrintValueToReport("New Decile TU query executed successfully for CustID: "+biCustomerId, "IL TU query status: ");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE EXECUTING TU STORED PROCEDURE "+e.getMessage());
			//logger.info("--------EXCEPTION WHILE EXECUTING TU STORED PROCEDURE--------: "+e.getMessage());
		}

		finally 
		{
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					System.out.println("EXCEPTION WHILE Closing Callable Statement"+ex.getMessage());
					//logger.info("--------EXCEPTION WHILE Closing Callable Statement--------: "+ex.getMessage());
				}
			}
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				//logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
	} 
	
	
	public static void execute_Proviner_Decile_TUQuery_GeneralD(String EmailId, String inpFICO_Value,
			String inpAM25_Value, String inpAM86_Value, String inpAT104_Value, String inpAT147_Value,
			String inpAT168_Value, String inpAT21_Value, String inpAT35_Value, String inpAT85_Value,
			String inpCVPRAGG910_Value, String inpCVPRBALMAG01_Value, String inpCVPRPAYMNT02_Value,
			String inpCVPRPAYMNT11_Value, String inpCVPRTRV01_Value, String inpCVPRTRV10_Value,
			String inpCVSSBC97A_Value, String inpCVSSDM216_Value, String inpCVSSG256Z_Value,
			String inpCVSSG990S_Value, String inpCVSSICO21_Value, String inpCVSSIN36S_Value,
			String inpCVSSS114S_Value, String inpCVSSTEL21S_Value, String inpFI145_Value,
			String inpFI35_Value, String inpGO07_Value, String inpGO12_Value,
			String inpGO14_Value, String inpGO148_Value, String inpILCustSegment_Value,
			String inpIN02_Value, String inpIN85_Value, String inpOF20_Value,
			String inpPF34_Value, String inpAM155_Value) throws SQLException
	{
		try
		{System.out.println("------------>   11111 <--------------");
			int biCustomerId = (int) getCustomerId(EmailId);
			System.out.println("Customer id for tu query is "+biCustomerId);
			getDbConnection(SQLDBNameToRunTuQuery);
			CallableStatement statement = null;
			String Tuq = "{call "+ getPropertyValue("SP_PRO_DECILE_TU_QUERY_GeneralD")+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			System.out.println("TU query is "+Tuq);
			statement = connObj.prepareCall(Tuq);
			
			statement.setLong("iCustomerID", biCustomerId);
			
			statement.setString("FICO_Value", inpFICO_Value);
			statement.setString("AM25_Value", inpAM25_Value);
			statement.setString("AM86_Value", inpAM86_Value);
			statement.setString("AT104_Value", inpAT104_Value);
			statement.setString("AT147_Value", inpAT147_Value);
			statement.setString("AT168_Value", inpAT168_Value);
			statement.setString("AT21_Value", inpAT21_Value);
			statement.setString("AT35_Value", inpAT35_Value);
			statement.setString("AT85_Value", inpAT85_Value);
			statement.setString("CVPRAGG910_Value", inpCVPRAGG910_Value);
			statement.setString("CVPRBALMAG01_Value", inpCVPRBALMAG01_Value);
			statement.setString("CVPRPAYMNT02_Value", inpCVPRPAYMNT02_Value);
			statement.setString("CVPRPAYMNT11_Value", inpCVPRPAYMNT11_Value);
			statement.setString("CVPRTRV01_Value", inpCVPRTRV01_Value);
			statement.setString("CVPRTRV10_Value", inpCVPRTRV10_Value);
			statement.setString("CVSSBC97A_Value", inpCVSSBC97A_Value);
			statement.setString("CVSSDM216_Value", inpCVSSDM216_Value);
			statement.setString("CVSSG256Z_Value", inpCVSSG256Z_Value);
			statement.setString("CVSSG990S_Value", inpCVSSG990S_Value);
			statement.setString("CVSSICO21_Value", inpCVSSICO21_Value);
			statement.setString("CVSSIN36S_Value", inpCVSSIN36S_Value);
			statement.setString("CVSSS114S_Value", inpCVSSS114S_Value);
			statement.setString("CVSSTEL21S_Value", inpCVSSTEL21S_Value);
			statement.setString("FI145_Value", inpFI145_Value);
			statement.setString("FI35_Value", inpFI35_Value);
			statement.setString("GO07_Value", inpGO07_Value);
			statement.setString("GO12_Value", inpGO12_Value);
			statement.setString("GO14_Value", inpGO14_Value);
			statement.setString("GO148_Value", inpGO148_Value);
			statement.setString("ILCustSegment_Value", inpILCustSegment_Value);
			statement.setString("IN02_Value", inpIN02_Value);
			statement.setString("IN85_Value", inpIN85_Value);
			statement.setString("OF20_Value", inpOF20_Value);
			statement.setString("PF34_Value", inpPF34_Value);
			statement.setString("AM155_Value", inpAM155_Value);
			
			
			boolean TUQueryResult = statement.execute();
			System.out.println("TU execution result : "+TUQueryResult);
			if(TUQueryResult == true)
			{
				System.out.println("Stored procedure executed successfully with "+biCustomerId);
				//logger.info("--------Stored procedure executed successfully with "+biCustomerId+"--------");
			}
			else
			{
				System.out.println("Stored procedure unsuccessfull with "+biCustomerId);
				//logger.info("--------Stored procedure unsuccessfull with "+biCustomerId+"--------");
			}
			OnlineActions.PrintValueToReport("New Decile TU query executed successfully for CustID: "+biCustomerId, "IL TU query status: ");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE EXECUTING TU STORED PROCEDURE "+e.getMessage());
			//logger.info("--------EXCEPTION WHILE EXECUTING TU STORED PROCEDURE--------: "+e.getMessage());
		}

		finally 
		{
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					System.out.println("EXCEPTION WHILE Closing Callable Statement"+ex.getMessage());
					//logger.info("--------EXCEPTION WHILE Closing Callable Statement--------: "+ex.getMessage());
				}
			}
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				//logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
	} 
	
	
	public static void execute_Proviner_Decile_TUQuery_GeneralD_ReRefiEa(String EmailId, String inpFICO_Value,
			String inpAM25_Value, String inpAM86_Value, String inpAT104_Value, String inpAT147_Value,
			String inpAT168_Value, String inpAT21_Value, String inpAT35_Value, String inpAT85_Value,
			String inpCVPRAGG910_Value, String inpCVPRBALMAG01_Value, String inpCVPRPAYMNT02_Value,
			String inpCVPRPAYMNT11_Value, String inpCVPRTRV01_Value, String inpCVPRTRV10_Value,
			String inpCVSSBC97A_Value, String inpCVSSDM216_Value, String inpCVSSG256Z_Value,
			String inpCVSSG990S_Value, String inpCVSSICO21_Value, String inpCVSSIN36S_Value,
			String inpCVSSS114S_Value, String inpCVSSTEL21S_Value, String inpFI145_Value,
			String inpFI35_Value, String inpGO07_Value, String inpGO12_Value,
			String inpGO14_Value, String inpGO148_Value, String inpILCustSegment_Value,
			String inpIN02_Value, String inpIN85_Value, String inpOF20_Value,
			String inpPF34_Value, String inpAM155_Value) throws SQLException
	{
		try
		{System.out.println("------------>   11111 <--------------");
			int biCustomerId = (int) getCustomerId(EmailId);
			System.out.println("Customer id for tu query is "+biCustomerId);
			getDbConnection(SQLDBNameToRunTuQuery);
			CallableStatement statement = null;
			String Tuq = "{call "+ getPropertyValue("SP_PRO_DECILE_TU_QUERY_GeneralDReRefiEa")+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			System.out.println("TU query is "+Tuq);
			statement = connObj.prepareCall(Tuq);
			
			statement.setLong("iCustomerID", biCustomerId);
			
			statement.setString("FICO_Value", inpFICO_Value);
			statement.setString("AM25_Value", inpAM25_Value);
			statement.setString("AM86_Value", inpAM86_Value);
			statement.setString("AT104_Value", inpAT104_Value);
			statement.setString("AT147_Value", inpAT147_Value);
			statement.setString("AT168_Value", inpAT168_Value);
			statement.setString("AT21_Value", inpAT21_Value);
			statement.setString("AT35_Value", inpAT35_Value);
			statement.setString("AT85_Value", inpAT85_Value);
			statement.setString("CVPRAGG910_Value", inpCVPRAGG910_Value);
			statement.setString("CVPRBALMAG01_Value", inpCVPRBALMAG01_Value);
			statement.setString("CVPRPAYMNT02_Value", inpCVPRPAYMNT02_Value);
			statement.setString("CVPRPAYMNT11_Value", inpCVPRPAYMNT11_Value);
			statement.setString("CVPRTRV01_Value", inpCVPRTRV01_Value);
			statement.setString("CVPRTRV10_Value", inpCVPRTRV10_Value);
			statement.setString("CVSSBC97A_Value", inpCVSSBC97A_Value);
			statement.setString("CVSSDM216_Value", inpCVSSDM216_Value);
			statement.setString("CVSSG256Z_Value", inpCVSSG256Z_Value);
			statement.setString("CVSSG990S_Value", inpCVSSG990S_Value);
			statement.setString("CVSSICO21_Value", inpCVSSICO21_Value);
			statement.setString("CVSSIN36S_Value", inpCVSSIN36S_Value);
			statement.setString("CVSSS114S_Value", inpCVSSS114S_Value);
			statement.setString("CVSSTEL21S_Value", inpCVSSTEL21S_Value);
			statement.setString("FI145_Value", inpFI145_Value);
			statement.setString("FI35_Value", inpFI35_Value);
			statement.setString("GO07_Value", inpGO07_Value);
			statement.setString("GO12_Value", inpGO12_Value);
			statement.setString("GO14_Value", inpGO14_Value);
			statement.setString("GO148_Value", inpGO148_Value);
			statement.setString("ILCustSegment_Value", inpILCustSegment_Value);
			statement.setString("IN02_Value", inpIN02_Value);
			statement.setString("IN85_Value", inpIN85_Value);
			statement.setString("OF20_Value", inpOF20_Value);
			statement.setString("PF34_Value", inpPF34_Value);
			statement.setString("AM155_Value", inpAM155_Value);
			
			
			boolean TUQueryResult = statement.execute();
			System.out.println("TU execution result : "+TUQueryResult);
			if(TUQueryResult == true)
			{
				System.out.println("Stored procedure executed successfully with "+biCustomerId);
				//logger.info("--------Stored procedure executed successfully with "+biCustomerId+"--------");
			}
			else
			{
				System.out.println("Stored procedure unsuccessfull with "+biCustomerId);
				//logger.info("--------Stored procedure unsuccessfull with "+biCustomerId+"--------");
			}
			OnlineActions.PrintValueToReport("New Decile TU query executed successfully for CustID: "+biCustomerId, "IL TU query status: ");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE EXECUTING TU STORED PROCEDURE "+e.getMessage());
			//logger.info("--------EXCEPTION WHILE EXECUTING TU STORED PROCEDURE--------: "+e.getMessage());
		}

		finally 
		{
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					System.out.println("EXCEPTION WHILE Closing Callable Statement"+ex.getMessage());
					//logger.info("--------EXCEPTION WHILE Closing Callable Statement--------: "+ex.getMessage());
				}
			}
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				//logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
	} 
	
	
	
	public static void execute_Proviner_Decile_TUQuery_generic(String EmailId ) throws SQLException
	{
		try
		{System.out.println("------------>   11111 <--------------");
			int biCustomerId = (int) getCustomerId(EmailId);
			System.out.println("Customer id for tu query is "+biCustomerId);
			getDbConnection(SQLDBNameToRunTuQuery);
			CallableStatement statement = null;
			String Tuq = "{call "+ getPropertyValue("SP_PRO_DECILE_TU_QUERY_generic")+ "(?)}";
			System.out.println("TU query is "+Tuq);
			statement = connObj.prepareCall(Tuq);
			statement.setLong("iCustomerID", biCustomerId);
			boolean TUQueryResult = statement.execute();
			System.out.println("TU execution result : "+TUQueryResult);
			if(TUQueryResult == true)
			{
				System.out.println("Stored procedure executed successfully with "+biCustomerId);
				//logger.info("--------Stored procedure executed successfully with "+biCustomerId+"--------");
			}
			else
			{
				System.out.println("Stored procedure unsuccessfull with "+biCustomerId);
				//logger.info("--------Stored procedure unsuccessfull with "+biCustomerId+"--------");
			}
			OnlineActions.PrintValueToReport("New Decile TU query executed successfully for CustID: "+biCustomerId, "IL TU query status: ");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE EXECUTING TU STORED PROCEDURE "+e.getMessage());
			//logger.info("--------EXCEPTION WHILE EXECUTING TU STORED PROCEDURE--------: "+e.getMessage());
		}

		finally 
		{
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					System.out.println("EXCEPTION WHILE Closing Callable Statement"+ex.getMessage());
					//logger.info("--------EXCEPTION WHILE Closing Callable Statement--------: "+ex.getMessage());
				}
			}
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				//logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
	} 
	
	public static void execute_Proviner_Decile_TUQuery_5(String EmailId ) throws SQLException
	{
		try
		{System.out.println("------------>   11111 <--------------");
			int biCustomerId = (int) getCustomerId(EmailId);
			System.out.println("Customer id for tu query is "+biCustomerId);
			getDbConnection(SQLDBNameToRunTuQuery);
			CallableStatement statement = null;
			String Tuq = "{call "+ getPropertyValue("SP_PRO_DECILE_TU_QUERY_5")+ "(?)}";
			System.out.println("TU query is "+Tuq);
			statement = connObj.prepareCall(Tuq);
			statement.setLong("iCustomerID", biCustomerId);
			boolean TUQueryResult = statement.execute();
			System.out.println("TU execution result : "+TUQueryResult);
			if(TUQueryResult == true)
			{
				System.out.println("Stored procedure executed successfully with "+biCustomerId);
				//logger.info("--------Stored procedure executed successfully with "+biCustomerId+"--------");
			}
			else
			{
				System.out.println("Stored procedure unsuccessfull with "+biCustomerId);
				//logger.info("--------Stored procedure unsuccessfull with "+biCustomerId+"--------");
			}
			OnlineActions.PrintValueToReport("New Decile TU query executed successfully for CustID: "+biCustomerId, "IL TU query status: ");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE EXECUTING TU STORED PROCEDURE "+e.getMessage());
			//logger.info("--------EXCEPTION WHILE EXECUTING TU STORED PROCEDURE--------: "+e.getMessage());
		}

		finally 
		{
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					System.out.println("EXCEPTION WHILE Closing Callable Statement"+ex.getMessage());
					//logger.info("--------EXCEPTION WHILE Closing Callable Statement--------: "+ex.getMessage());
				}
			}
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				//logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
	} 
	
	
	public static void execute_Proviner_Decile_TUQuery_2(String EmailId ) throws SQLException
	{
		try
		{System.out.println("------------>   11111 <--------------");
			int biCustomerId = (int) getCustomerId(EmailId);
			System.out.println("Customer id for tu query is "+biCustomerId);
			getDbConnection(SQLDBNameToRunTuQuery);
			CallableStatement statement = null;
			String Tuq = "{call "+ getPropertyValue("SP_PRO_DECILE_TU_QUERY_2")+ "(?)}";
			System.out.println("TU query is "+Tuq);
			statement = connObj.prepareCall(Tuq);
			statement.setLong("iCustomerID", biCustomerId);
			boolean TUQueryResult = statement.execute();
			System.out.println("TU execution result : "+TUQueryResult);
			if(TUQueryResult == true)
			{
				System.out.println("Stored procedure executed successfully with "+biCustomerId);
				//logger.info("--------Stored procedure executed successfully with "+biCustomerId+"--------");
			}
			else
			{
				System.out.println("Stored procedure unsuccessfull with "+biCustomerId);
				//logger.info("--------Stored procedure unsuccessfull with "+biCustomerId+"--------");
			}
			OnlineActions.PrintValueToReport("New Decile TU query executed successfully for CustID: "+biCustomerId, "IL TU query status: ");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE EXECUTING TU STORED PROCEDURE "+e.getMessage());
			//logger.info("--------EXCEPTION WHILE EXECUTING TU STORED PROCEDURE--------: "+e.getMessage());
		}

		finally 
		{
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					System.out.println("EXCEPTION WHILE Closing Callable Statement"+ex.getMessage());
					//logger.info("--------EXCEPTION WHILE Closing Callable Statement--------: "+ex.getMessage());
				}
			}
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				//logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	public static void execute_Proviner_Decile_TUQuery_8_reloan(String EmailId ) throws SQLException
	{
		try
		{System.out.println("------------>   11111 <--------------");
			int biCustomerId = (int) getCustomerId(EmailId);
			System.out.println("Customer id for tu query is "+biCustomerId);
			getDbConnection(SQLDBNameToRunTuQuery);
			CallableStatement statement = null;
			String Tuq = "{call "+ getPropertyValue("SP_PRO_DECILE_TU_QUERY_8_RELOAN")+ "(?)}";
			System.out.println("TU query is "+Tuq);
			statement = connObj.prepareCall(Tuq);
			statement.setLong("iCustomerID", biCustomerId);
			boolean TUQueryResult = statement.execute();
			System.out.println("TU execution result : "+TUQueryResult);
			if(TUQueryResult == true)
			{
				System.out.println("Stored procedure executed successfully with "+biCustomerId);
				//logger.info("--------Stored procedure executed successfully with "+biCustomerId+"--------");
			}
			else
			{
				System.out.println("Stored procedure unsuccessfull with "+biCustomerId);
				//logger.info("--------Stored procedure unsuccessfull with "+biCustomerId+"--------");
			}
			OnlineActions.PrintValueToReport("New Decile TU query executed successfully for CustID: "+biCustomerId, "IL TU query status: ");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE EXECUTING TU STORED PROCEDURE "+e.getMessage());
			//logger.info("--------EXCEPTION WHILE EXECUTING TU STORED PROCEDURE--------: "+e.getMessage());
		}

		finally 
		{
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					System.out.println("EXCEPTION WHILE Closing Callable Statement"+ex.getMessage());
					//logger.info("--------EXCEPTION WHILE Closing Callable Statement--------: "+ex.getMessage());
				}
			}
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				//logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	public static void execute_Proviner_Decile_TUQuery_8_earlyadvance(String EmailId ) throws SQLException
	{
		try
		{System.out.println("------------>   11111 <--------------");
			int biCustomerId = (int) getCustomerId(EmailId);
			System.out.println("Customer id for tu query is "+biCustomerId);
			getDbConnection(SQLDBNameToRunTuQuery);
			CallableStatement statement = null;
			String Tuq = "{call "+ getPropertyValue("SP_PRO_DECILE_TU_QUERY_8_EARLYADVANCE")+ "(?)}";
			System.out.println("TU query is "+Tuq);
			statement = connObj.prepareCall(Tuq);
			statement.setLong("iCustomerID", biCustomerId);
			boolean TUQueryResult = statement.execute();
			System.out.println("TU execution result : "+TUQueryResult);
			if(TUQueryResult == true)
			{
				System.out.println("Stored procedure executed successfully with "+biCustomerId);
				//logger.info("--------Stored procedure executed successfully with "+biCustomerId+"--------");
			}
			else
			{
				System.out.println("Stored procedure unsuccessfull with "+biCustomerId);
				//logger.info("--------Stored procedure unsuccessfull with "+biCustomerId+"--------");
			}
			OnlineActions.PrintValueToReport("New Decile TU query executed successfully for CustID: "+biCustomerId, "IL TU query status: ");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE EXECUTING TU STORED PROCEDURE "+e.getMessage());
			//logger.info("--------EXCEPTION WHILE EXECUTING TU STORED PROCEDURE--------: "+e.getMessage());
		}

		finally 
		{
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					System.out.println("EXCEPTION WHILE Closing Callable Statement"+ex.getMessage());
					//logger.info("--------EXCEPTION WHILE Closing Callable Statement--------: "+ex.getMessage());
				}
			}
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				//logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	public static void execute_Proviner_Decile_TUQuery_1_refi(String EmailId ) throws SQLException
	{
		try
		{System.out.println("------------>   11111 <--------------");
			int biCustomerId = (int) getCustomerId(EmailId);
			System.out.println("Customer id for tu query is "+biCustomerId);
			getDbConnection(SQLDBNameToRunTuQuery);
			CallableStatement statement = null;
			String Tuq = "{call "+ getPropertyValue("SP_PRO_DECILE_TU_QUERY_1_REFI")+ "(?)}";
			System.out.println("TU query is "+Tuq);
			statement = connObj.prepareCall(Tuq);
			statement.setLong("iCustomerID", biCustomerId);
			boolean TUQueryResult = statement.execute();
			System.out.println("TU execution result : "+TUQueryResult);
			if(TUQueryResult == true)
			{
				System.out.println("Stored procedure executed successfully with "+biCustomerId);
				//logger.info("--------Stored procedure executed successfully with "+biCustomerId+"--------");
			}
			else
			{
				System.out.println("Stored procedure unsuccessfull with "+biCustomerId);
				//logger.info("--------Stored procedure unsuccessfull with "+biCustomerId+"--------");
			}
			OnlineActions.PrintValueToReport("New Decile TU query executed successfully for CustID: "+biCustomerId, "IL TU query status: ");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE EXECUTING TU STORED PROCEDURE "+e.getMessage());
			//logger.info("--------EXCEPTION WHILE EXECUTING TU STORED PROCEDURE--------: "+e.getMessage());
		}

		finally 
		{
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					System.out.println("EXCEPTION WHILE Closing Callable Statement"+ex.getMessage());
					//logger.info("--------EXCEPTION WHILE Closing Callable Statement--------: "+ex.getMessage());
				}
			}
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				//logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
	}  
	
	
	public static void execute_Proviner_Decile_TUQuery_refi_generic(String EmailId ) throws SQLException
	{
		try
		{System.out.println("------------>   11111 <--------------");
			int biCustomerId = (int) getCustomerId(EmailId);
			System.out.println("Customer id for tu query is "+biCustomerId);
			getDbConnection(SQLDBNameToRunTuQuery);
			CallableStatement statement = null;
			String Tuq = "{call "+ getPropertyValue("SP_PRO_DECILE_TU_QUERY_generic_refi")+ "(?)}";
			System.out.println("TU query is "+Tuq);
			statement = connObj.prepareCall(Tuq);
			statement.setLong("iCustomerID", biCustomerId);
			boolean TUQueryResult = statement.execute();
			System.out.println("TU execution result : "+TUQueryResult);
			if(TUQueryResult == true)
			{
				System.out.println("Stored procedure executed successfully with "+biCustomerId);
				//logger.info("--------Stored procedure executed successfully with "+biCustomerId+"--------");
			}
			else
			{
				System.out.println("Stored procedure unsuccessfull with "+biCustomerId);
				//logger.info("--------Stored procedure unsuccessfull with "+biCustomerId+"--------");
			}
			OnlineActions.PrintValueToReport("New Decile TU query executed successfully for CustID: "+biCustomerId, "IL TU query status: ");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE EXECUTING TU STORED PROCEDURE "+e.getMessage());
			//logger.info("--------EXCEPTION WHILE EXECUTING TU STORED PROCEDURE--------: "+e.getMessage());
		}

		finally 
		{
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					System.out.println("EXCEPTION WHILE Closing Callable Statement"+ex.getMessage());
					//logger.info("--------EXCEPTION WHILE Closing Callable Statement--------: "+ex.getMessage());
				}
			}
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				//logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
	}  



	public static void RefiTUQuery(String EmailId ) throws SQLException
	{
		try
		{System.out.println("------------>   11111 <--------------");
			int biCustomerId = (int) getCustomerId(EmailId);
			System.out.println("Customer id for tu query is "+biCustomerId);
			getDbConnection(SQLDBNameToRunTuQuery);
			CallableStatement statement = null;
			String Tuq = "{call "+ getPropertyValue("SP_TU_Refi")+ "(?)}";
			System.out.println("TU query is "+Tuq);
			statement = connObj.prepareCall(Tuq);
			statement.setLong("iCustomerID", biCustomerId);
			boolean TUQueryResult = statement.execute();
			System.out.println("TU execution result : "+TUQueryResult);
			if(TUQueryResult == true)
			{
				System.out.println("Stored procedure executed successfully with "+biCustomerId);
				//logger.info("--------Stored procedure executed successfully with "+biCustomerId+"--------");
			}
			else
			{
				System.out.println("Stored procedure unsuccessfull with "+biCustomerId);
				//logger.info("--------Stored procedure unsuccessfull with "+biCustomerId+"--------");
			}
			OnlineActions.PrintValueToReport("New Decile TU query executed successfully for CustID: "+biCustomerId, "IL TU query status: ");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE EXECUTING TU STORED PROCEDURE "+e.getMessage());
			//logger.info("--------EXCEPTION WHILE EXECUTING TU STORED PROCEDURE--------: "+e.getMessage());
		}

		finally 
		{
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					System.out.println("EXCEPTION WHILE Closing Callable Statement"+ex.getMessage());
					//logger.info("--------EXCEPTION WHILE Closing Callable Statement--------: "+ex.getMessage());
				}
			}
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				//logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
	}  
	
	public static void executeTUdenied(String EmailId ) throws SQLException
	{
		try
		{System.out.println("------------>   11111 <--------------");
			int biCustomerId = (int) getCustomerId(EmailId);
			System.out.println("Customer id for tu query is "+biCustomerId);
			getDbConnection(SQLDBNameToRunTuQuery);
			CallableStatement statement = null;
			String Tuq = "{call "+ getPropertyValue("SP_TU_15000_denied")+ "(?)}";
			System.out.println("TU query is "+Tuq);
			statement = connObj.prepareCall(Tuq);
			statement.setLong("iCustomerID", biCustomerId);
			boolean TUQueryResult = statement.execute();
			System.out.println("TU execution result : "+TUQueryResult);
			if(TUQueryResult == true)
			{
				System.out.println("Stored procedure executed successfully with "+biCustomerId);
				//logger.info("--------Stored procedure executed successfully with "+biCustomerId+"--------");
			}
			else
			{
				System.out.println("Stored procedure unsuccessfull with "+biCustomerId);
				//logger.info("--------Stored procedure unsuccessfull with "+biCustomerId+"--------");
			}
			OnlineActions.PrintValueToReport("New Decile TU query executed successfully for CustID: "+biCustomerId, "IL TU query status: ");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE EXECUTING TU STORED PROCEDURE "+e.getMessage());
			//logger.info("--------EXCEPTION WHILE EXECUTING TU STORED PROCEDURE--------: "+e.getMessage());
		}

		finally 
		{
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					System.out.println("EXCEPTION WHILE Closing Callable Statement"+ex.getMessage());
					//logger.info("--------EXCEPTION WHILE Closing Callable Statement--------: "+ex.getMessage());
				}
			}
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				//logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
	}  

	public static void execute_SPL_TUQuery(String EmailId) throws SQLException
	{
		try
		{
			int biCustomerId = (int) getCustomerId(EmailId);
			System.out.println("Customer id for SPL tu query is "+biCustomerId);
			getDbConnection(SQLDBNameToRunTuQuery);
			CallableStatement statement = null;
			statement = connObj.prepareCall("{call "+ getPropertyValue("SP_SPL")+ "(?)}");
			statement.setLong("iCustomerId", biCustomerId);
			boolean TUQueryResult = statement.execute();
			System.out.println("TU execution result : "+TUQueryResult);
			if(TUQueryResult == true)
			{
				System.out.println("Stored procedure executed successfully with "+biCustomerId);
				//logger.info("--------Stored procedure executed successfully with "+biCustomerId+"--------");
			}
			else
			{
				System.out.println("Stored procedure unsuccessfull with "+biCustomerId);
				//logger.info("--------Stored procedure unsuccessfull with "+biCustomerId+"--------");
			}
			OnlineActions.PrintValueToReport("SPL TU query is executed successfully for custId: "+biCustomerId, "SPL TU query status: ");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE EXECUTING TU STORED PROCEDURE "+e.getMessage());
			//logger.info("--------EXCEPTION WHILE EXECUTING TU STORED PROCEDURE--------: "+e.getMessage());
		}

		finally 
		{
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					System.out.println("EXCEPTION WHILE Closing Callable Statement"+ex.getMessage());
					//logger.info("--------EXCEPTION WHILE Closing Callable Statement--------: "+ex.getMessage());
				}
			}
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				//logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
	} 

	public static void executeBackDateLoan(String EmailId, int noOfDays ) throws SQLException
	{
		try
		{
			int biLoanID = (int) getLoanId(EmailId);
			getDbConnection(SQLDBNameToRunTuQuery);
			CallableStatement statement = null;
			String callObject = "{call "+ getPropertyValue("SP_BackDate")+ "(?,?)}";
			System.out.println("-----> "+callObject);
			statement = connObj.prepareCall(callObject);
			//[dbo].[TU_Script_SPL] 
			//statement = connObj.prepareCall("{call dbo.TU_Script_SPL(?)}");
			//statement.setString(biLoanID, callObject);
			statement.setLong("iLoanID", biLoanID);
			statement.setLong("iNumOfDays", noOfDays);
			boolean BackDateQueryResult = statement.execute();
			System.out.println("TU execution Backdate result : "+BackDateQueryResult);
			if(BackDateQueryResult == true)
			{
				System.out.println("Back date Stored procedure executed successfully with "+BackDateQueryResult);
				//logger.info("--------Stored procedure executed successfully with "+biCustomerId+"--------");
			}
			else
			{
				System.out.println("Back date Stored procedure unsuccessfull with "+BackDateQueryResult);
				//logger.info("--------Stored procedure unsuccessfull with "+biCustomerId+"--------");
			}
			
			OnlineActions.PrintValueToReport("Loan with loan-id "+biLoanID+" is back dated to "+noOfDays+" days", "Executed Back date Query: ");
			
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE EXECUTING BACK DATE STORED PROCEDURE "+e.getMessage());
			//logger.info("--------EXCEPTION WHILE EXECUTING TU STORED PROCEDURE--------: "+e.getMessage());
		}

		finally 
		{
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					System.out.println("EXCEPTION WHILE Closing Callable Statement"+ex.getMessage());
					//logger.info("--------EXCEPTION WHILE Closing Callable Statement--------: "+ex.getMessage());
				}
			}
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				//logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
	} 
	public static void executeBackDateLoan(long Loanid, int noOfDays ) throws SQLException
	{
		try
		{
			
			int biLoanID = (int) Loanid;
			getDbConnection(SQLDBNameToRunTuQuery);
			CallableStatement statement = null;
			String callObject = "{call "+ getPropertyValue("SP_BackDate")+ "(?,?)}";
			System.out.println("-----> "+callObject);
			statement = connObj.prepareCall(callObject);
			//[dbo].[TU_Script_SPL] 
			//statement = connObj.prepareCall("{call dbo.TU_Script_SPL(?)}");
			//statement.setString(biLoanID, callObject);
			statement.setLong("iLoanID", biLoanID);
			statement.setLong("iNumOfDays", noOfDays);
			boolean BackDateQueryResult = statement.execute();
			OnlineActions.PrintValueToReport("Loan with loan-id "+biLoanID+" is back dated to "+noOfDays+" days", "Executed Back date Query: ");
			System.out.println("TU execution result : "+BackDateQueryResult);
			if(BackDateQueryResult == true)
			{
				System.out.println("Back date Stored procedure executed successfully with "+BackDateQueryResult);
				//logger.info("--------Stored procedure executed successfully with "+biCustomerId+"--------");
			}
			else
			{
				System.out.println("Back date Stored procedure unsuccessfull with "+BackDateQueryResult);
				//logger.info("--------Stored procedure unsuccessfull with "+biCustomerId+"--------");
			}
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE EXECUTING BACK DATE STORED PROCEDURE "+e.getMessage());
			//logger.info("--------EXCEPTION WHILE EXECUTING TU STORED PROCEDURE--------: "+e.getMessage());
		}

		finally 
		{
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					System.out.println("EXCEPTION WHILE Closing Callable Statement"+ex.getMessage());
					//logger.info("--------EXCEPTION WHILE Closing Callable Statement--------: "+ex.getMessage());
				}
			}
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				//logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
	}  

	public static void retrieveDatafromTable(String tableName) throws SQLException
	{
		try
		{
			statement = connObj.createStatement();
			String queryString = "select * from "+tableName+"";
			ResultSet rs = statement.executeQuery(queryString);
			while (rs.next()) {
				System.out.println(rs.getString("LoanId"));
				System.out.println(rs.getString("FirstName"));
				System.out.println(rs.getString("LastName"));
			}
			logger.info("--------Table data retrieving successfully--------");
			System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
	}

	public static void retrieveDatafromTableWithSpecificColumns(String ColumnsWithcomma, String tableName) throws SQLException
	{
		try
		{
			statement = connObj.createStatement();
			String queryString = "select "+ColumnsWithcomma+" from "+tableName+"";
			ResultSet rs = statement.executeQuery(queryString);

			while (rs.next()) {
				//System.out.println(rs.getString("LoanId"));
				System.out.println(rs.getString("FirstName"));
				System.out.println(rs.getString("LastName"));
			}
			logger.info("--------Table data retrieving successfully--------");
			System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
	}

	public static void updateColumnDataIntoTable(String CustId) throws SQLException
	{
		try
		{
			statement = connObj.createStatement();
			String sql = "UPDATE MMLoan " +
					"SET FirstName = 'Peter' WHERE LoanId in ("+CustId+")";
			statement.executeUpdate(sql);

			logger.info("--------Table data updated successfully--------");
			System.out.println("Table data updated successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE UPDATING DATA TO TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while Updating data to MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
	}

	public static void updateColumnDataIntoTableWithSpecificColumns(String FirstName, String FirstNameValue, String LastName, String LastNameValue, String Tablename, String whereCond) throws SQLException
	{
		try
		{
			statement = connObj.createStatement();
			String sql = "UPDATE "+Tablename+" " +
					"SET "+FirstName+" = '"+FirstNameValue+"', "+LastName+" = '"+LastNameValue+"' WHERE LoanId in ("+whereCond+")";
			System.out.println("============");
			System.out.println(sql);
			System.out.println("============");
			statement.executeUpdate(sql);

			logger.info("--------Table data updated successfully--------");
			System.out.println("Table data updated successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE UPDATING DATA TO TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while Updating data to MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
	}

	/*
    select * from vitacrm39..customer 
    where  firstname ='javi' and lastname='khadi' 
    Order by createddate desc
	 */

	public static void main(String[] args) throws SQLException, InvalidFormatException, IOException {

		//getDbConnection();
		//long s = getCustomerId("javi","khadi","customer");
		System.out.println("Main method invoked");


		/* retrieveDatafromTable("MMLoan"); // retrieve All data from input table
    retrieveDatafromTableWithSpecificColumns("FirstName,LastName", "MMLoan"); // retrieve specific data from input table
    updateColumnDataIntoTable("101"); // update data based on columns defined in the method and input Customer ID
    updateColumnDataIntoTableWithSpecificColumns("FirstName","UpdNameHere","LastName","UpdNameHere","MMLoanTableHere","101CustomerIdHere"); 
    //update based on input columns and respective values, TableName and Where ConditionValue table will be updated
		 */

	}
	
	
	///added 14 july 2022 start

public static List<String> getLoanDetails(String EmailAddress)
	{
		//long CustomId = getCustomerId(EmailAddress);
		long LoanId = getLoanId(EmailAddress);
		getDbConnection2();
		
		String  sCustomerId = "";
		String  sLoanId = "";
		String  sParentLoanId = "";
		String  schanneltypeid = "";
		String  sEffectiveDate = "";
		String  sAPR = "";
		String  sStateCode = "";
		String  sLoanContractNumber = "";
		String  sLoanStatusId = "";
		String  sLoanTypeId = "";
		
		String  sTotalAmount = "";
		String  sPrincipal = "";
		String  sPaymentTypeId = "";
		String  sRepaymentTypeId = "";
		
		List<String> LoanDetails = new ArrayList<>(); 
		//long sCustomerId = 0;
		try
		{	 statement = connObj.createStatement();
		String queryString = "select CAST(CustomerId as VARCHAR(15)) AS CustomerId, CAST(LoanId as VARCHAR(15)) AS LoanId, "
				+ "CAST(ParentLoanId AS VARCHAR(15)) AS ParentLoanId, CAST(channeltypeid as VARCHAR(15)) as channeltypeid, "
				+ "CAST(EffectiveDate as VARCHAR(25)) as EffectiveDate,"
				+ "CAST(APR AS VARCHAR(10)) AS APR, CAST(StateCode as VARCHAR(5)) as StateCode, "
				+ "CAST(LoanContractNumber AS VARCHAR(25)) AS LoanContractNumber, CAST(LoanStatusId as VARCHAR(5)) as LoanStatusId, "
				+ "CAST(LoanTypeId as VARCHAR(5)) as LoanTypeId,"
				+ "CAST(TotalAmount as VARCHAR(10)) as TotalAmount,"
				+ "CAST(Principal as VARCHAR(10)) as Principal,"
				+ "CAST(PaymentTypeId as VARCHAR(5)) as PaymentTypeId,"
				+ "CAST(RepaymentTypeId as VARCHAR(5)) as RepaymentTypeId"
				+ " from "+ SQLDBNameToGetLoan+ ".."+"Loan"
				+ " where LoanId = '"+LoanId+"'";
		
		logger.info("###################################################");
		logger.info(queryString);
		logger.info("###################################################");

		//Added on 07-July-2022 Start
		logLoanDetails.add("###################################################");
		logLoanDetails.add(queryString);
		logLoanDetails.add("###################################################");
		//Added on 07-July-2022 End

		//Added on 07-July-2022 Start
		UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
		logLoanDetails.clear();
		//Added on 07-July-2022 End

		
		ResultSet rs = statement.executeQuery(queryString);

		LoanDetails.add("CustomerId, LoanId, ParentLoanId, channeltypeid, EffectiveDate, APR, StateCode, LoanContractNumber, LoanStatusId, LoanTypeId, TotalAmount, Principal, PaymentTypeId, RepaymentTypeId");
		
		//Added on 17-Sept-2022 Start
		sb = new StringBuilder();
		
		sb.append("<html>");
		sb.append("<head>");
		sb.append("</head>");
		sb.append("<table border=\"3\">");
		
		sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> CustomerId");
		sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> LoanId");
		sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> ParentLoanId");
		sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> channeltypeid");
		sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> EffectiveDate");
		sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> APR");
		sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> StateCode");
		sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> LoanContractNumber");
		sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> LoanStatusId");
		sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> LoanTypeId");
		sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> TotalAmount");
		sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> Principal");
		sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> PaymentTypeId");
		sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> RepaymentTypeId");
		
		//Added on 17-Sept-2022 End
		
		while (rs.next()) {

			
			sCustomerId = rs.getString("CustomerId");
			sLoanId = rs.getString("LoanId");
			sParentLoanId = rs.getString("ParentLoanId");
			schanneltypeid = rs.getString("channeltypeid");
			sEffectiveDate = rs.getString("EffectiveDate");
			sAPR = rs.getString("APR");
			sStateCode = rs.getString("StateCode");
			sLoanContractNumber = rs.getString("LoanContractNumber");
			sLoanStatusId = rs.getString("LoanStatusId");
			sLoanTypeId = rs.getString("LoanTypeId");
			sTotalAmount = rs.getString("TotalAmount");
			sPrincipal = rs.getString("Principal");
			sPaymentTypeId = rs.getString("PaymentTypeId");
			sRepaymentTypeId = rs.getString("RepaymentTypeId");

					
			LoanDetails.add(sCustomerId +" "+sLoanId+" "+sParentLoanId+" "+schanneltypeid+" "+sEffectiveDate+" "+sAPR+" "+sStateCode+" "+sLoanContractNumber+" "+sLoanStatusId+" "+sLoanTypeId+" "+sTotalAmount+" "+sPrincipal+" "+sPaymentTypeId+" "+sRepaymentTypeId);
			
			//Added on 17-Sept-2022 Start
			 	sb.append("<tr>");
			 	sb.append("<td> "+sCustomerId+" </td>");
			 	sb.append("<td> "+sLoanId+" </td>");
			 	sb.append("<td> "+sParentLoanId+" </td>");
			 	sb.append("<td> "+schanneltypeid+" </td>");
			 	sb.append("<td> "+sEffectiveDate+" </td>");
			 	sb.append("<td> "+sAPR+" </td>");
			 	sb.append("<td> "+sStateCode+" </td>");
			 	sb.append("<td> "+sLoanContractNumber+" </td>");
			 	sb.append("<td> "+sLoanStatusId+" </td>");
			 	sb.append("<td> "+sLoanTypeId+" </td>");
			 	sb.append("<td> "+sTotalAmount+" </td>");
			 	sb.append("<td> "+sPrincipal+" </td>");
			 	sb.append("<td> "+sPaymentTypeId+" </td>");
			 	sb.append("<td> "+sRepaymentTypeId+" </td>");
			    sb.append("</tr>");
			//Added on 17-Sept-2022 End
			
		}
		
		//Added on 17-Sept-2022 Start
		sb.append("</table>");
		sb.append("</body>");
		sb.append("</html>");

		//System.out.println(sb.toString());
		//hooks.scenario.write(sb.toString());
		//Added on 17-Sept-2022 End
		
		Thread.sleep(1000);
		int LoanPDetailsSize = LoanDetails.size();
		logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^ Loan Details ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		for(int i=0;i<LoanPDetailsSize;i++)
		{
			String LoanDetailsIndividualRS = LoanDetails.get(i);
			logLoanDetails.add("Loan Details table row :"+i+": "+LoanDetailsIndividualRS);
			UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
			logLoanDetails.clear();
			//Added on 28-May-2022 End
		}
		logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
		logLoanDetails.clear();
		
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		return LoanDetails;
	}


//Added on 15-Sept-2022 Start
public static List<String> getLoanDetail_Table(String EmailAddress)
{
	//long CustomId = getCustomerId(EmailAddress);
	long LoanId = getLoanId(EmailAddress);
	getDbConnection2();
	

	String  sLoanId = "";
	String  sRefinanceCount = "";
	String  sLoanTerm = "";
	
	List<String> LoanDetailTable = new ArrayList<>(); 
	//long sCustomerId = 0;
	try
	{	 statement = connObj.createStatement();
	String queryString = "select CAST(LoanId as VARCHAR(15)) AS LoanId, "
			+ "CAST(RefinanceCount AS VARCHAR(15)) AS RefinanceCount, CAST(LoanTerm as VARCHAR(15)) as LoanTerm "
			+ " from "+ SQLDBNameToGetLoan+ ".."+"LoanDetail"
			+ " where LoanId = '"+LoanId+"'";
	
	logger.info("###################################################");
	logger.info(queryString);
	logger.info("###################################################");

	//Added on 07-July-2022 Start
	logLoanDetails.add("###################################################");
	logLoanDetails.add(queryString);
	logLoanDetails.add("###################################################");
	//Added on 07-July-2022 End

	//Added on 07-July-2022 Start
	UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
	logLoanDetails.clear();
	//Added on 07-July-2022 End

	
	ResultSet rs = statement.executeQuery(queryString);

	LoanDetailTable.add("LoanId, RefinanceCount, LoanTerm");
	
	//Added on 17-Sept-2022 Start
	sb = new StringBuilder();
	
	sb.append("<html>");
	sb.append("<head>");
	sb.append("</head>");
	sb.append("<table border=\"3\">");
	
	sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> LoanId");
	sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> RefinanceCount");
	sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> LoanTerm");
	//Added on 17-Sept-2022 End
	
	
	
	while (rs.next()) {

		
		sLoanId = rs.getString("LoanId");
		sRefinanceCount = rs.getString("RefinanceCount");
		sLoanTerm = rs.getString("LoanTerm");

				
		LoanDetailTable.add(sLoanId+" "+sRefinanceCount+" "+sLoanTerm);
		
		//Added on 17-Sept-2022 Start
	 	sb.append("<tr>");
	 	sb.append("<td> "+sLoanId+" </td>");
	 	sb.append("<td> "+sRefinanceCount+" </td>");
	 	sb.append("<td> "+sLoanTerm+" </td>");
	    sb.append("</tr>");
	    //Added on 17-Sept-2022 End
		
	}
	
	//Added on 17-Sept-2022 Start
	sb.append("</table>");
	sb.append("</body>");
	sb.append("</html>");
	
	Thread.sleep(1000);
	int LoanPDetailsSize = LoanDetailTable.size();
	logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^ LoanDetail Table Info ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	for(int i=0;i<LoanPDetailsSize;i++)
	{
		String LoanDetailsIndividualRS = LoanDetailTable.get(i);
		logLoanDetails.add("Loan Details table row :"+i+": "+LoanDetailsIndividualRS);
		UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
		logLoanDetails.clear();
		//Added on 28-May-2022 End
	}
	logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
	logLoanDetails.clear();
	
	logger.info("--------Table data retrieving successfully--------");
	System.out.println("Table data retrieving successfully");
	}
	catch(Exception e)
	{
		System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
		logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
		e.printStackTrace();
	}
	finally 
	{
		try {
			connObj.close();
		} catch (SQLException e) {
			System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
			logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
			e.printStackTrace();
		}
	}
	return LoanDetailTable;
}


public static List<String> getLoanPaymentHeader_Table(String EmailAddress)
{
	//long CustomId = getCustomerId(EmailAddress);
	long LoanId = getLoanId(EmailAddress);
	getDbConnection2();
	

	String  sLoanId = "";
	String  sPaymentAmount = "";
	String  sMonthlyPaymentAmount = "";
	
	List<String> LoanLoanPaymentHeaderTable = new ArrayList<>(); 
	//long sCustomerId = 0;
	try
	{	 statement = connObj.createStatement();
	String queryString = "select CAST(LoanId as VARCHAR(15)) AS LoanId, "
			+ "CAST(PaymentAmount AS VARCHAR(15)) AS PaymentAmount, CAST(MonthlyPaymentAmount as VARCHAR(15)) as MonthlyPaymentAmount "
			+ " from "+ SQLDBNameToGetLoan+ ".."+"LoanPaymentHeader"
			+ " where LoanId = '"+LoanId+"'";
	
	logger.info("###################################################");
	logger.info(queryString);
	logger.info("###################################################");

	//Added on 07-July-2022 Start
	logLoanDetails.add("###################################################");
	logLoanDetails.add(queryString);
	logLoanDetails.add("###################################################");
	//Added on 07-July-2022 End

	//Added on 07-July-2022 Start
	UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
	logLoanDetails.clear();
	//Added on 07-July-2022 End

	
	ResultSet rs = statement.executeQuery(queryString);

	LoanLoanPaymentHeaderTable.add("LoanId, PaymentAmount, MonthlyPaymentAmount");
	
	
	//Added on 17-Sept-2022 Start
	sb = new StringBuilder();
	sb.append("<html>");
	sb.append("<head>");
	sb.append("</head>");
	sb.append("<table border=\"3\">");
	
	sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> LoanId");
	sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> PaymentAmount");
	sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> MonthlyPaymentAmount");
	//Added on 17-Sept-2022 End
	
	
	while (rs.next()) {

		
		sLoanId = rs.getString("LoanId");
		sPaymentAmount = rs.getString("PaymentAmount");
		sMonthlyPaymentAmount = rs.getString("MonthlyPaymentAmount");

				
		LoanLoanPaymentHeaderTable.add(sLoanId+" "+sPaymentAmount+" "+sMonthlyPaymentAmount);
		
		//Added on 17-Sept-2022 Start
	 	sb.append("<tr>");
	 	sb.append("<td> "+sLoanId+" </td>");
	 	sb.append("<td> "+sPaymentAmount+" </td>");
	 	sb.append("<td> "+sMonthlyPaymentAmount+" </td>");
	    sb.append("</tr>");
	    //Added on 17-Sept-2022 End
	}
	
	//Added on 17-Sept-2022 Start
	sb.append("</table>");
	sb.append("</body>");
	sb.append("</html>");
	
	Thread.sleep(1000);
	int LoanPDetailsSize = LoanLoanPaymentHeaderTable.size();
	logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	logLoanDetails.add("^^^^^^^^^^^^^^^^^^^ LoanPaymentHeader Details ^^^^^^^^^^^^^^^^^^^^^^^^^^");
	logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	for(int i=0;i<LoanPDetailsSize;i++)
	{
		String LoanDetailsIndividualRS = LoanLoanPaymentHeaderTable.get(i);
		logLoanDetails.add("Loan Details table row :"+i+": "+LoanDetailsIndividualRS);
		UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
		logLoanDetails.clear();
		//Added on 28-May-2022 End
	}
	logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
	logLoanDetails.clear();
	
	logger.info("--------Table data retrieving successfully--------");
	System.out.println("Table data retrieving successfully");
	}
	catch(Exception e)
	{
		System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
		logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
		e.printStackTrace();
	}
	finally 
	{
		try {
			connObj.close();
		} catch (SQLException e) {
			System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
			logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
			e.printStackTrace();
		}
	}
	return LoanLoanPaymentHeaderTable;
}

public static List<String> getLoanFee_Table(String EmailAddress)
{
	//long CustomId = getCustomerId(EmailAddress);
	long LoanId = getLoanId(EmailAddress);
	getDbConnection2();
	

	String  sLoanId = "";
	String  sCalculatedValue = "";
	
	
	List<String> LoanLoanFeeTable = new ArrayList<>(); 
	//long sCustomerId = 0;
	try
	{	 statement = connObj.createStatement();
	String queryString = "select CAST(LoanId as VARCHAR(15)) AS LoanId, "
			+ "CAST(CalculatedValue AS VARCHAR(15)) AS FeeCalculatedValue "
			+ " from "+ SQLDBNameToGetLoan+ ".."+"LoanFee"
			+ " where LoanId = '"+LoanId+"'";
	
	logger.info("###################################################");
	logger.info(queryString);
	logger.info("###################################################");

	//Added on 07-July-2022 Start
	logLoanDetails.add("###################################################");
	logLoanDetails.add(queryString);
	logLoanDetails.add("###################################################");
	//Added on 07-July-2022 End

	//Added on 07-July-2022 Start
	UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
	logLoanDetails.clear();
	//Added on 07-July-2022 End

	
	ResultSet rs = statement.executeQuery(queryString);

	LoanLoanFeeTable.add("LoanId, FeeCalculatedValue");
	
	//Added on 17-Sept-2022 Start
	sb = new StringBuilder();
	
	sb.append("<html>");
	sb.append("<head>");
	sb.append("</head>");
	sb.append("<table border=\"3\">");
	
	sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> LoanId");
	sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> FeeCalculatedValue");
	//Added on 17-Sept-2022 End
	
	while (rs.next()) {

		
		sLoanId = rs.getString("LoanId");
		sCalculatedValue = rs.getString("FeeCalculatedValue");
						
		LoanLoanFeeTable.add(sLoanId+" "+sCalculatedValue);
		
		
		//Added on 17-Sept-2022 Start
	 	sb.append("<tr>");
	 	sb.append("<td> "+sLoanId+" </td>");
	 	sb.append("<td> "+sCalculatedValue+" </td>");
	    sb.append("</tr>");
	    //Added on 17-Sept-2022 End
	}
	
	//Added on 17-Sept-2022 Start
	sb.append("</table>");
	sb.append("</body>");
	sb.append("</html>");
	
	Thread.sleep(1000);
	int LoanPDetailsSize = LoanLoanFeeTable.size();
	logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^ LoanFee Details ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	for(int i=0;i<LoanPDetailsSize;i++)
	{
		String LoanDetailsIndividualRS = LoanLoanFeeTable.get(i);
		logLoanDetails.add("Loan Details table row :"+i+": "+LoanDetailsIndividualRS);
		UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
		logLoanDetails.clear();
		//Added on 28-May-2022 End
	}
	logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
	logLoanDetails.clear();
	
	logger.info("--------Table data retrieving successfully--------");
	System.out.println("Table data retrieving successfully");
	}
	catch(Exception e)
	{
		System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
		logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
		e.printStackTrace();
	}
	finally 
	{
		try {
			connObj.close();
		} catch (SQLException e) {
			System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
			logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
			e.printStackTrace();
		}
	}
	return LoanLoanFeeTable;
}


public static List<String> getCustomerCredit_Table(String EmailAddress)
{
	//long CustomId = getCustomerId(EmailAddress);
	long LoanId = getLoanId(EmailAddress);
	getDbConnection2();
	

	String  sLoanId = "";
	String  sCustomerid = "";
	String  sCreditLimit = "";
	String  sCreditScore = "";
	
	
	List<String> CustomerCreditTable = new ArrayList<>(); 
	//long sCustomerId = 0;
	try
	{	 statement = connObj.createStatement();
	String queryString = "select CAST(LoanId as VARCHAR(15)) AS LoanId, "
			+ "CAST(Customerid AS VARCHAR(15)) AS Customerid, "
			+ "CAST(CreditLimit AS VARCHAR(15)) AS CreditLimit, "
			+ "CAST(CreditScore AS VARCHAR(15)) AS CreditScore "
			+ " from "+ SQLDBNameToGetLoan+ ".."+"CustomerCredit"
			+ " where LoanId = '"+LoanId+"'";
	
	logger.info("###################################################");
	logger.info(queryString);
	logger.info("###################################################");

	//Added on 07-July-2022 Start
	logLoanDetails.add("###################################################");
	logLoanDetails.add(queryString);
	logLoanDetails.add("###################################################");
	//Added on 07-July-2022 End

	//Added on 07-July-2022 Start
	UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
	logLoanDetails.clear();
	//Added on 07-July-2022 End

	
	ResultSet rs = statement.executeQuery(queryString);

	CustomerCreditTable.add("LoanId, Customerid, CreditLimit, CreditScore");
	
	//Added on 17-Sept-2022 Start
		sb = new StringBuilder();
		
		sb.append("<html>");
		sb.append("<head>");
		sb.append("</head>");
		sb.append("<table border=\"3\">");
		
		sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> LoanId");
		sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> Customerid");
		sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> CreditLimit");
		sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> CreditScore");
		//Added on 17-Sept-2022 End
	
	
	while (rs.next()) {

		
		sLoanId = rs.getString("LoanId");
		sCustomerid = rs.getString("Customerid");
		sCreditLimit = rs.getString("CreditLimit");
		sCreditScore = rs.getString("CreditScore");
		CustomerCreditTable.add(sLoanId+" "+sCustomerid+" "+sCreditLimit+" "+sCreditScore);
		
		//Added on 17-Sept-2022 Start
	 	sb.append("<tr>");
	 	sb.append("<td> "+sLoanId+" </td>");
	 	sb.append("<td> "+sCustomerid+" </td>");
	 	sb.append("<td> "+sCreditLimit+" </td>");
	 	sb.append("<td> "+sCreditScore+" </td>");
	 	sb.append("</tr>");
	 	//Added on 17-Sept-2022 End
		
	}
	
	//Added on 17-Sept-2022 Start
	sb.append("</table>");
	sb.append("</body>");
	sb.append("</html>");
	
	Thread.sleep(1000);
	int LoanPDetailsSize = CustomerCreditTable.size();
	logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^ CustomerCredit Details ^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	for(int i=0;i<LoanPDetailsSize;i++)
	{
		String LoanDetailsIndividualRS = CustomerCreditTable.get(i);
		logLoanDetails.add("Loan Details table row :"+i+": "+LoanDetailsIndividualRS);
		UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
		logLoanDetails.clear();
		//Added on 28-May-2022 End
	}
	logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
	logLoanDetails.clear();
	
	logger.info("--------Table data retrieving successfully--------");
	System.out.println("Table data retrieving successfully");
	}
	catch(Exception e)
	{
		System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
		logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
		e.printStackTrace();
	}
	finally 
	{
		try {
			connObj.close();
		} catch (SQLException e) {
			System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
			logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
			e.printStackTrace();
		}
	}
	return CustomerCreditTable;
}
//Added on 15-Sept-2022 Start


public static List<String> getLOANNOTETable(String EmailAddress)
	{
		//long CustomId = getCustomerId(EmailAddress);
		long LoanId = getLoanId(EmailAddress);
		getDbConnection2();

		String Note;
		int LoanNoteTypeId = 0;
		String sOther="";
		String sLoanNoteTypeId;
		List<String> Notes = new ArrayList<>(); 
		//long sCustomerId = 0;
		try
		{	 statement = connObj.createStatement();
		//String queryString = "select Note, LoanNoteTypeId from "+ SQLDBNameToGetLoan+ ".."+"LoanNote"
		String queryString = "select Note, Other from "+ SQLDBNameToGetLoan+ ".."+"LoanNote"
				+ " where LoanId = '"+LoanId+"'";
		
		logger.info("###################################################");
		logger.info(queryString);
		logger.info("###################################################");

		//Added on 07-July-2022 Start
		logLoanDetails.add("###################################################");
		logLoanDetails.add(queryString);
		logLoanDetails.add("###################################################");
		//Added on 07-July-2022 End

		//Added on 07-July-2022 Start
		UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
		logLoanDetails.clear();
		//Added on 07-July-2022 End
		
		ResultSet rs = statement.executeQuery(queryString);
		
		Notes.add("Note, Other");
		
		//Added on 17-Sept-2022 Start
		sb = new StringBuilder();
		
		sb.append("<html>");
		sb.append("<head>");
		sb.append("</head>");
		sb.append("<table border=\"3\">");
		
		sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> Note");
		sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> Other");
		//Added on 17-Sept-2022 End
		

		while (rs.next()) {

			Note = rs.getString("Note");
			//LoanNoteTypeId = rs.getInt("LoanNoteTypeId");
			sOther = rs.getString("Other");
			//sLoanNoteTypeId = Integer.toString(LoanNoteTypeId);
			Notes.add(Note +"  :  "+sOther);
			
			
			//Added on 17-Sept-2022 Start
		 	sb.append("<tr>");
		 	sb.append("<td> "+Note+" </td>");
		 	sb.append("<td> "+sOther+" </td>");
		    sb.append("</tr>");
		//Added on 17-Sept-2022 End

		}
		
		//Added on 17-Sept-2022 Start
		sb.append("</table>");
		sb.append("</body>");
		sb.append("</html>");
		
		Thread.sleep(1000);
		int NotesSize = Notes.size();
		logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^ LoanNote ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		for(int i=0;i<NotesSize;i++)
		{
			String NotesDetails = Notes.get(i);
			logLoanDetails.add("Loan Note table row :"+i+": "+NotesDetails);
			UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
			logLoanDetails.clear();
			//Added on 28-May-2022 End
		}
		logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
		logLoanDetails.clear();
		
		System.out.println("loan note:::"+"/"+Notes);
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		return Notes;
	}


public static List<String> getLoanPayment(String EmailAddress)
	{
		//long CustomId = getCustomerId(EmailAddress);
		long LoanId = getLoanId(EmailAddress);
		getDbConnection2();
		
		String  sLoanId = ""; 
		String  sAmount = ""; 
		String sPrincipal = "";
		String sReturned= ""; 
		String sPaymentTypeId= "";
		String sLoanPaymentStatusId= "";
		
		List<String> LoanPayments = new ArrayList<>(); 
		//long sCustomerId = 0;
		try
		{	 statement = connObj.createStatement();
		String queryString = "select CAST(LoanId as VARCHAR(15)) AS LoanId, CAST(Amount as VARCHAR(15)) AS Amount, CAST(Principal as VARCHAR(15)) AS Principal, "
				+ "CAST(Returned AS VARCHAR(5)) AS Returned, CAST(PaymentTypeId as VARCHAR(5)) as PaymentTypeId, "
				+ "CAST(LoanPaymentStatusId as VARCHAR(5)) as LoanPaymentStatusId from "+ SQLDBNameToGetLoan+ ".."+"LoanPayment"
				+ " where LoanId = '"+LoanId+"'";
		
		logger.info("###################################################");
		logger.info(queryString);
		logger.info("###################################################");

		//Added on 07-July-2022 Start
		logLoanDetails.add("###################################################");
		logLoanDetails.add(queryString);
		logLoanDetails.add("###################################################");
		//Added on 07-July-2022 End

		//Added on 07-July-2022 Start
		UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
		logLoanDetails.clear();
		//Added on 07-July-2022 End
		
		ResultSet rs = statement.executeQuery(queryString);

		LoanPayments.add("LoanId, Amount, Principal, Returned, PaymentTypeId, LoanPaymentStatusId");
		
		//Added on 17-Sept-2022 Start
				sb = new StringBuilder();
				
				sb.append("<html>");
				sb.append("<head>");
				sb.append("</head>");
				sb.append("<table border=\"3\">");
				sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> LoanId");
				sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> Amount");
				sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> Principal");
				sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> Returned");
				sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> PaymentTypeId");
				sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> LoanPaymentStatusId");
				//Added on 17-Sept-2022 End
		
		
		while (rs.next()) {
			sLoanId = rs.getString("LoanId");
			sAmount = rs.getString("Amount");
			sPrincipal = rs.getString("Principal");
			sReturned = rs.getString("Returned");
			sPaymentTypeId = rs.getString("PaymentTypeId");
			sLoanPaymentStatusId = rs.getString("LoanPaymentStatusId");
			
			LoanPayments.add(sLoanId+" "+sAmount +" "+sPrincipal+" "+sReturned+" "+sPaymentTypeId+" "+sLoanPaymentStatusId);
			
			//Added on 17-Sept-2022 Start
		 	sb.append("<tr>");
		 	sb.append("<td> "+sLoanId+" </td>");
		 	sb.append("<td> "+sAmount+" </td>");
		 	sb.append("<td> "+sPrincipal+" </td>");
		 	sb.append("<td> "+sReturned+" </td>");
		 	sb.append("<td> "+sPaymentTypeId+" </td>");
		 	sb.append("<td> "+sLoanPaymentStatusId+" </td>");
		    sb.append("</tr>");
		    //Added on 17-Sept-2022 End
		}
		
		//Added on 17-Sept-2022 Start
		sb.append("</table>");
		sb.append("</body>");
		sb.append("</html>");
		
		Thread.sleep(1000);
		int LoanPaymentsSize = LoanPayments.size();
		logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^ LoanPayment ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		for(int i=0;i<LoanPaymentsSize;i++)
		{
			String PaymentDetails = LoanPayments.get(i);
			logLoanDetails.add("Loan Payments table row :"+i+": "+PaymentDetails);
			UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
			logLoanDetails.clear();
			//Added on 28-May-2022 End
		}
		logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
		logLoanDetails.clear();
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		return LoanPayments;
	}


public static List<String> getLoanTransactionDetails(String EmailAddress)
	{
		//long CustomId = getCustomerId(EmailAddress);
		long LoanId = getLoanId(EmailAddress);
		getDbConnection2();
		
		String  sLoanId = ""; 
		String  sTransactionTypeId = ""; 
		String sAmount = "";
		String sPrincipal= ""; 
		String sCreatedByUserName= "";
		
		List<String> LoanTransactions = new ArrayList<>(); 
		//long sCustomerId = 0;
		try
		{	 statement = connObj.createStatement();
		String queryString = "select CAST(LoanId as VARCHAR(15)) AS LoanId, CAST(TransactionTypeId as VARCHAR(15)) as TransactionTypeId, "
				+ "CAST(Amount as VARCHAR(15)) as Amount, CAST(Principal as VARCHAR(15)) as Principal, "
				+ "CAST(CreatedByUserName as VARCHAR(15)) as CreatedByUserName from "+ SQLDBNameToGetLoan+ ".."+"LoanTransaction"
				+ " where LoanId = '"+LoanId+"'";
		
		logger.info("###################################################");
		logger.info(queryString);
		logger.info("###################################################");

		//Added on 07-July-2022 Start
		logLoanDetails.add("###################################################");
		logLoanDetails.add(queryString);
		logLoanDetails.add("###################################################");
		//Added on 07-July-2022 End

		//Added on 07-July-2022 Start
		UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
		logLoanDetails.clear();
		//Added on 07-July-2022 End

		
		ResultSet rs = statement.executeQuery(queryString);

		LoanTransactions.add("LoanId, TransactionTypeId, Amount, Principal, CreatedByUserName");
		
		//Added on 17-Sept-2022 Start
		sb = new StringBuilder();
		
		sb.append("<html>");
		sb.append("<head>");
		sb.append("</head>");
		sb.append("<table border=\"3\">");
		
		sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> LoanId");
		sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> TransactionTypeId");
		sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> Amount");
		sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> Principal");
		sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> CreatedByUserName");
		//Added on 17-Sept-2022 End
		
		
		while (rs.next()) {
			sLoanId = rs.getString("LoanId");
			sTransactionTypeId = rs.getString("TransactionTypeId");
			sAmount = rs.getString("Amount");
			sPrincipal = rs.getString("Principal");
			sCreatedByUserName = rs.getString("CreatedByUserName");
			
			LoanTransactions.add(sLoanId+" "+sTransactionTypeId +" "+sAmount+" "+sPrincipal+" "+sCreatedByUserName);
			
			//Added on 17-Sept-2022 Start
		 	sb.append("<tr>");
		 	sb.append("<td> "+sLoanId+" </td>");
		 	sb.append("<td> "+sTransactionTypeId+" </td>");
		 	sb.append("<td> "+sAmount+" </td>");
		 	sb.append("<td> "+sPrincipal+" </td>");
		 	sb.append("<td> "+sCreatedByUserName+" </td>");
		 	sb.append("</tr>");
		//Added on 17-Sept-2022 End
			
		}
		
		//Added on 17-Sept-2022 Start
		sb.append("</table>");
		sb.append("</body>");
		sb.append("</html>");
		
		Thread.sleep(1000);
		int LoanTransactionSize = LoanTransactions.size();
		logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^ LoanTransaction ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		for(int i=0;i<LoanTransactionSize;i++)
		{
			String TransactionDetails = LoanTransactions.get(i);
			logLoanDetails.add("Loan Transaction table row :"+i+": "+TransactionDetails);
			UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
			logLoanDetails.clear();
			//Added on 28-May-2022 End
		}
		logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
		logLoanDetails.clear();
		
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		return LoanTransactions;
	}


public static List<String> getLoanEFTLog(String EmailAddress)
	{
		//long CustomId = getCustomerId(EmailAddress);
		long lLoanId = getLoanId(EmailAddress);
		getDbConnection2();
		
		String  sLoanId = ""; 
		String sCustomerId = "";
		String sEFTRequest= ""; 
	
		
		List<String> LoanEFTLog = new ArrayList<>(); 
		//long sCustomerId = 0;
		try
		{	 statement = connObj.createStatement();
		String queryString = "select CAST(LoanId as VARCHAR(15)) AS LoanId, CAST(CustomerId as VARCHAR(15)) AS CustomerId , "
				+ "CAST(EFTRequest as VARCHAR(2000)) AS EFTRequest from "+ SQLDBNameToGetLoan+ ".."+"EFTLog"
				+ " where LoanId = '"+lLoanId+"'";
		
		logger.info("###################################################");
		logger.info(queryString);
		logger.info("###################################################");

		//Added on 07-July-2022 Start
		logLoanDetails.add("###################################################");
		logLoanDetails.add(queryString);
		logLoanDetails.add("###################################################");
		//Added on 07-July-2022 End

		//Added on 07-July-2022 Start
		UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
		logLoanDetails.clear();
		//Added on 07-July-2022 End

		
		ResultSet rs = statement.executeQuery(queryString);

		LoanEFTLog.add("LoanId, CustomerId, EFTRequest");
		while (rs.next()) {

			sLoanId = rs.getString("LoanId");
			sCustomerId = rs.getString("CustomerId");
			sEFTRequest = rs.getString("EFTRequest");
			
			LoanEFTLog.add(sLoanId +" "+sCustomerId+" "+sEFTRequest);
		}
		
		Thread.sleep(1000);
		int LoanLoanEFTLogSize = LoanEFTLog.size();
		logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^ EFTLog ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		for(int i=0;i<LoanLoanEFTLogSize;i++)
		{
			String LoanEFTLogDetails = LoanEFTLog.get(i);
			logLoanDetails.add("Loan EFTLog table row :"+i+": "+LoanEFTLogDetails);
			UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
			logLoanDetails.clear();
			//Added on 28-May-2022 End
		}
		logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
		logLoanDetails.clear();
		
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		return LoanEFTLog;
	}


public static List<String> getLoanETransferLog(String EmailAddress)
	{
		//long CustomId = getCustomerId(EmailAddress);
		long lLoanId = getLoanId(EmailAddress);
		getDbConnection2();
		
		String sETransferLogId = "";
		String sLoanId = ""; 
		String sLoanPaymentId= "";
		String sCustomerId= "";
		String sETransferRequest= "";
		String sETransferResponse= "";
		
		
		List<String> LoanETransferLog = new ArrayList<>(); 
		//long sCustomerId = 0;
		try
		{	 statement = connObj.createStatement();
		String queryString = "select CAST(ETransferLogId as VARCHAR(15)) AS ETransferLogId, CAST(LoanId as VARCHAR(15)) AS LoanId, "
				+ "CAST(LoanPaymentId as VARCHAR(15)) AS LoanPaymentId , "
				+ "CAST(CustomerId as VARCHAR(15)) AS CustomerId , "
				+ "CAST(ETransferRequest as VARCHAR(2000)) AS ETransferRequest,"
				+ "CAST(ETransferResponse as VARCHAR(2000)) AS ETransferResponse from "+ SQLDBNameToGetLoan+ ".."+"ETransferLog"
				+ " where LoanId = '"+lLoanId+"'";
		
		logger.info("###################################################");
		logger.info(queryString);
		logger.info("###################################################");

		//Added on 07-July-2022 Start
		logLoanDetails.add("###################################################");
		logLoanDetails.add(queryString);
		logLoanDetails.add("###################################################");
		//Added on 07-July-2022 End

		//Added on 07-July-2022 Start
		UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
		logLoanDetails.clear();
		//Added on 07-July-2022 End

		
		ResultSet rs = statement.executeQuery(queryString);

		LoanETransferLog.add("ETransferLogId, LoanId, LoanPaymentId, CustomerId, ETransferRequest, ETransferResponse");
		while (rs.next()) {

		
			 sETransferLogId = rs.getString("ETransferLogId");
			 sLoanId = rs.getString("LoanId");
			 sLoanPaymentId= rs.getString("LoanPaymentId");
			 sCustomerId= rs.getString("CustomerId");
			 sETransferRequest= rs.getString("ETransferRequest");
			 sETransferResponse= rs.getString("ETransferResponse");
			
			 LoanETransferLog.add(sETransferLogId +" "+sLoanId+" "+sLoanPaymentId+" "+sCustomerId+" "+sETransferRequest+" "+sETransferResponse);
		}
		
		Thread.sleep(1000);
		int LoanLoanETransferLogSize = LoanETransferLog.size();
		logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^ ETransferLog ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		for(int i=0;i<LoanLoanETransferLogSize;i++)
		{
			String LoanETransferLogDetails = LoanETransferLog.get(i);
			logLoanDetails.add("Loan ETransferLog table row :"+i+": "+LoanETransferLogDetails);
			UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
			logLoanDetails.clear();
			//Added on 28-May-2022 End
		}
		logLoanDetails.add("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
		logLoanDetails.clear();
		
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		return LoanETransferLog;
	}
//added 14 july 2022 end

//add code on new OTP logic revised start 05 17

	public static void UpdateQuery_device_Velocity()
	{
		getDbConnection2();
		
		//System.out.println("Coma separated list is "+commaseparatedlist);
		try
		{
			statement = connObj.createStatement();
			String sql =  "Update "+ "VitaPDLCAN"+ ".."+"ClientDevice"
					+ " set createddate = '01-01-2023'"+" where deviceid in ('616735061693919735')";
			statement.executeUpdate(sql);

			logger.info("--------Table data updated successfully--------");
			System.out.println("Table data updated successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE UPDATING DATA TO TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while Updating data to MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
	}

	
	public static void UpdateQuery_bank_Velocity()
	{
		getDbConnection2();
		
		//System.out.println("Coma separated list is "+commaseparatedlist);
		try
		{
			statement = connObj.createStatement();
			String sql =  "Update "+ "VitaCrmCAN"+ ".."+"CustomerBank"
					+ " set createddate = '01-01-2023'"+" where BankAccountNumber='0000010' and BranchTransitNumber='00010'and FinancialInstitutionNumber=777 ";
			statement.executeUpdate(sql);

			logger.info("--------Table data updated successfully--------");
			System.out.println("Table data updated successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE UPDATING DATA TO TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while Updating data to MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	public static String getOnlineOTP(String EmailAddress)
	{
		long CustomerId = getCustomerId(EmailAddress);
		getDbConnection(SQLDBName);

		String AppData = null;
		String OTP = null;

		try
		{	 statement = connObj.createStatement();
		String queryString = "select top 1 AppData from "+ SQLDBNameToGetLoan+ ".."+"Application"
				+ " where CustomerID = '"+CustomerId+"' order by Id desc"; //Added "order by Id desc" & Added "top 1" on 20-July-2023 Revised 



		ResultSet rs = statement.executeQuery(queryString);

		while (rs.next()) {

			AppData =	rs.getString("AppData");

		}

		String[] AppData1 = AppData.split("\"Otp\":\"");
		AppData = AppData1[1];
		System.out.println("AppData::"+AppData);
		AppData1 = AppData.split("\"}]}");
		OTP = AppData1[0];
		System.out.println("OTP:: "+OTP);
		/*while (rs.next()) {
			sCustomerId =	rs.getLong("CustomerId");
		}*/
		logger.info("--------Table data retrieving successfully--------");
		System.out.println("Table data retrieving successfully");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION WHILE READING DATA FROM TABLE "+e.getMessage());
			logger.info("--------EXCEPTION while retrieving data from MS SQL Server Table--------: "+e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try {
				connObj.close();
			} catch (SQLException e) {
				System.out.println("EXCEPTION WHILE Closing Database Connection"+e.getMessage());
				logger.info("--------EXCEPTION WHILE Closing Database Connection--------: "+e.getMessage());
				e.printStackTrace();
			}
		}
		return OTP;
	}
	
	//add code on new otp logic revised end 05 17
}
