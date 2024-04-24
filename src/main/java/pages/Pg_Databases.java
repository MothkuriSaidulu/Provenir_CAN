package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;
import sqlUtils.MsSqlUtility;
import utils.UtilityMethods;

public class Pg_Databases extends OnlineActions {

	public Pg_Databases(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public static String CandLoanId;
    public static String CandCustomerId;
    public static String CanLoanTypeID;
    public static String CanLoanStatusID;
	
	public static String LoanContractID;
	
	@FindBy(how=How.XPATH, using = "//strong[contains(normalize-space(),'Installment Loan | #')]")
	public static WebElement Loan_ContractID;
	
	public void TUquery() throws Exception
	{
		Thread.sleep(8000);
		MsSqlUtility.execute15000TUQuery(getMapData.get("eMail"));
	}
	
	
	public void Proviner_Decile_TUquery_1() throws Exception
	{
		Thread.sleep(8000);
		MsSqlUtility.execute_Proviner_Decile_TUQuery_1(getMapData.get("eMail"));
		Thread.sleep(8000);
	}
	
	public void Proviner_Decile_TUquery_1_Bankruptcies() throws Exception
	{
		Thread.sleep(8000);
		MsSqlUtility.execute_Proviner_Decile_TUQuery_1_Bankruptcies(getMapData.get("eMail"));
		Thread.sleep(8000);
	}
	
	public void Proviner_Decile_TUquery_generic() throws Exception
	{
		Thread.sleep(8000);
		MsSqlUtility.execute_Proviner_Decile_TUQuery_generic(getMapData.get("eMail"));
	}
	
	
	public void Proviner_Decile_TUquery_GeneralD() throws Exception
	{
		Thread.sleep(8000);
		
		/*
		MsSqlUtility.execute_Proviner_Decile_TUQuery_GeneralD(getMapData.get("eMail"), "719","0000000021","0000000999","0000000001","0000000099","0000000001","0000000004","0000006393","0000000999",
				"83.92","0000000118","000000003","0000000032","0000000008","000000011","0000001001","0000000149","0000000000","0000000003",
				"0000000999","0000000999","0000000001","000000165","0000000001","0000000963","0000000004","0000000148","0000000309","0000000001",
				"New","0000000001","0000000999","0000000264","-000000001","-000000095");
		*/
		
		MsSqlUtility.execute_Proviner_Decile_TUQuery_GeneralD(getMapData.get("eMail"), "550","0000000021","0000000999","0000000000","0000000100","0000000001","0000000030","0000002816","0000000030",
				"0000000102","0000000111","000000000","0000000077","0000000001","000000012","0000000176","0000000025","000000000","0000000002",
				"0000000999","0000000999","0000000002","-000000001","0000000000","0000000000","0000000003","0000000203","0000000502","0000000001",
				"New","0000000001","0000000999","-0000000001","-000000001","000000053");
		
		/*
		MsSqlUtility.execute_Proviner_Decile_TUQuery_GeneralD(getMapData.get("eMail"), "719","","","","","","","","",
				"","","","","","","","","","",
				"","","","","","","","","","",
				"New","","","","","");
		*/
	}
	
	
	public void Proviner_Decile_TUquery_GeneralD(String decileNumber) throws Exception
	{
		Thread.sleep(8000);
		
		if(decileNumber.equalsIgnoreCase("1"))
		{
			System.out.println("DECILE 1");
			logger.info("DECILE 1");
			MsSqlUtility.execute_Proviner_Decile_TUQuery_GeneralD(getMapData.get("eMail"), "719","0000000021","0000000999","0000000001","0000000099","0000000001","0000000004","0000006393","0000000999",
					"83.92","0000000118","000000003","0000000032","0000000008","000000011","0000001001","0000000149","0000000000","0000000003",
					"0000000999","0000000999","0000000001","000000165","0000000001","0000000963","0000000004","0000000148","0000000309","0000000001",
					"New","0000000001","0000000999","0000000264","-000000001","-000000095");
		}
		if(decileNumber.equalsIgnoreCase("2"))
		{
			System.out.println("DECILE 2");
			logger.info("DECILE 2");
			MsSqlUtility.execute_Proviner_Decile_TUQuery_GeneralD(getMapData.get("eMail"), "550","0000000021","0000000999","0000000000","0000000100","0000000001","0000000030","0000002816","0000000030",
					"0000000102","0000000111","000000000","0000000077","0000000001","000000012","0000000176","0000000025","000000000","0000000002",
					"0000000999","0000000999","0000000002","-000000001","0000000000","0000000000","0000000003","0000000203","0000000502","0000000001",
					"New","0000000001","0000000999","-0000000001","-000000001","000000053");
		}
		if(decileNumber.equalsIgnoreCase("3"))
		{
			System.out.println("DECILE 3");
			logger.info("DECILE 3");
		}
		if(decileNumber.equalsIgnoreCase("4"))
		{
			System.out.println("DECILE 4");
			logger.info("DECILE 4");
		}
		if(decileNumber.equalsIgnoreCase("5"))
		{
			System.out.println("DECILE 5");
			logger.info("DECILE 5");
		}
		if(decileNumber.equalsIgnoreCase("6"))
		{
			System.out.println("DECILE 6");
			logger.info("DECILE 6");
			MsSqlUtility.execute_Proviner_Decile_TUQuery_GeneralD(getMapData.get("eMail"), "719","0000000002","0000000999","0000000000","0000000078","0000000000","0000000094","0000007000","0000000999",
					"-1","0000009992","-000000001","-0000000002","-0000000001","-000000002","-0000000001","0000000126","-0000000004","-0000000004",
					"0000000999","-0000000001","-0000000004","-000000001","0000000000","-0000000001","0000000999","0000000100","0000000126","-0000000006",
					"New","0000000000","0000000999","-0000000001","-000000001","000000050");
		}
		if(decileNumber.equalsIgnoreCase("7"))
		{
			System.out.println("DECILE 7");
			logger.info("DECILE 7");
		}
		if(decileNumber.equalsIgnoreCase("8"))
		{
			System.out.println("DECILE 8");
			logger.info("DECILE 8");
		}
		if(decileNumber.equalsIgnoreCase("9"))
		{
			System.out.println("DECILE 9");
			logger.info("DECILE 9");
		}
		if(decileNumber.equalsIgnoreCase("10"))
		{
			System.out.println("DECILE 10");
			logger.info("DECILE 10");
		}
		/* TAMPLATE
		MsSqlUtility.execute_Proviner_Decile_TUQuery_GeneralD(getMapData.get("eMail"), "719","","","","","","","","",
				"","","","","","","","","","",
				"","","","","","","","","","",
				"New","","","","","");
		*/
	}
	
	
	public void Proviner_Decile_TUquery_DeniedRule(String decileNumber, String FICOScore) throws Exception
	{
		Thread.sleep(8000);
		if(decileNumber.equalsIgnoreCase("1"))
		{
			System.out.println("DECILE 1 Denied Rule");
			logger.info("DECILE 1 Denied Rule");
			MsSqlUtility.execute_Proviner_Decile_TUQuery_denied_Rule(getMapData.get("eMail"), ""+FICOScore+"","0000000002","0000000501","0000000011");
		}
	}
	
	public void Proviner_Decile_TUquery_DeniedRule_Approved(String decileNumber, String FICOScore) throws Exception
	{
		Thread.sleep(8000);
		if(decileNumber.equalsIgnoreCase("1"))
		{
			System.out.println("DECILE 1 Denied Rule");
			logger.info("DECILE 1 Denied Rule");
			MsSqlUtility.execute_Proviner_Decile_TUQuery_denied_Rule(getMapData.get("eMail"), ""+FICOScore+"","0000000002","0000000501","0000000013");
		}
	}
	
	
	public void Proviner_Decile_TUquery_To_Get_Less_Than_1k_Approved_Amount(String decileNumber, String FICOScore) throws Exception
	{
		Thread.sleep(8000);
		if(decileNumber.equalsIgnoreCase("1"))
		{
			System.out.println("DECILE 1 To Get Less than 1K Approved Amount");
			logger.info("DECILE 1 Denied Rule To Get Less than 1K Approved Amount");
			MsSqlUtility.execute_Proviner_Decile_TUQuery_To_Get_Less_Thank_1k_Approved_Amount(getMapData.get("eMail"), ""+FICOScore+"");
		}
	}
	
	public void Proviner_Decile_TUquery_To_Get_Less_Than_1k_Approved_Amount_ReREfiEA(String decileNumber, String FICOScore) throws Exception
	{
		Thread.sleep(8000);
		if(decileNumber.equalsIgnoreCase("1"))
		{
			System.out.println("DECILE 1 To Get Less than 1K Approved Amount");
			logger.info("DECILE 1 Denied Rule To Get Less than 1K Approved Amount");
			MsSqlUtility.execute_Proviner_Decile_TUQuery_To_Get_Less_Thank_1k_Approved_Amount_ReRefiEA(getMapData.get("eMail"), ""+FICOScore+"");
		}
	}
	
	public void Proviner_Decile_TUquery_GeneralD(String decileNumber, String FICOScore) throws Exception
	{
		Thread.sleep(8000);
		
		if(decileNumber.equalsIgnoreCase("1"))
		{
			System.out.println("DECILE 1");
			logger.info("DECILE 1");
			MsSqlUtility.execute_Proviner_Decile_TUQuery_GeneralD(getMapData.get("eMail"), ""+FICOScore+"","0000000021","0000000999","0000000001","0000000099","0000000001","0000000004","0000006393","0000000999",
					"83.92","0000000118","000000003","0000000032","0000000008","000000011","0000001001","0000000149","0000000000","0000000003",
					"0000000999","0000000999","0000000001","000000165","0000000001","0000000963","0000000004","0000000148","0000000309","0000000001",
					"New","0000000001","0000000999","0000000264","-000000001","-000000095");
		}
		if(decileNumber.equalsIgnoreCase("2"))
		{
			System.out.println("DECILE 2");
			logger.info("DECILE 2");
			MsSqlUtility.execute_Proviner_Decile_TUQuery_GeneralD(getMapData.get("eMail"), ""+FICOScore+"","0000000021","0000000999","0000000000","0000000100","0000000001","0000000030","0000002816","0000000030",
					"0000000102","0000000111","000000000","0000000077","0000000001","000000012","0000000176","0000000025","000000000","0000000002",
					"0000000999","0000000999","0000000002","-000000001","0000000000","0000000000","0000000003","0000000203","0000000502","0000000001",
					"New","0000000001","0000000999","-0000000001","-000000001","000000053");
		}
		if(decileNumber.equalsIgnoreCase("3"))
		{
			System.out.println("DECILE 3");
			logger.info("DECILE 3");
			
			MsSqlUtility.execute_Proviner_Decile_TUQuery_GeneralD(getMapData.get("eMail"), ""+FICOScore+"","0000000009","0000000999","0000000000","0000000011","0000000000","0000000040","0000000043","0000000999",
					"-000000002","0000009992","-000000002","-000000002","0000000999","-000000002","-000000002","0000000064","0000000000","0000000000",
					"0000000064","0000000999","0000000000","-000000001","0000000000","0000000000","0000000156","0000000159","0000000050","0000000000",
					"New","0000000000","0000000999","0000000176","-000000001","-000000001");
			
		}
		if(decileNumber.equalsIgnoreCase("4"))
		{
			System.out.println("DECILE 4");
			logger.info("DECILE 4");
		}
		if(decileNumber.equalsIgnoreCase("5"))
		{
			System.out.println("DECILE 5");
			logger.info("DECILE 5");
			MsSqlUtility.execute_Proviner_Decile_TUQuery_GeneralD(getMapData.get("eMail"), ""+FICOScore+"","0000000001","0000000999","0000000000","0000000040","0000000000","0000000080","0000001200","0000000999",
					"-2","0000009992","-000000001","-0000000002","-0000000002","-000000002","0000001800","0000000003","-0000000004","-0000000004",
					"0000000999","-0000000001","-0000000004","-000000001","0000000000","-0000000001","0000000999","0000000080","0000000070","-0000000006",
					"New","0000000000","0000000999","-0000000001","-000000001","000000040");
			
		}
		if(decileNumber.equalsIgnoreCase("6"))
		{
			System.out.println("DECILE 6");
			logger.info("DECILE 6");
			MsSqlUtility.execute_Proviner_Decile_TUQuery_GeneralD(getMapData.get("eMail"), ""+FICOScore+"","0000000002","0000000999","0000000000","0000000078","0000000000","0000000094","0000007000","0000000999",
					"-1","0000009992","-000000001","-0000000002","-0000000001","-000000002","-0000000001","0000000126","-0000000004","-0000000004",
					"0000000999","-0000000001","-0000000004","-000000001","0000000000","-0000000001","0000000999","0000000100","0000000126","-0000000006",
					"New","0000000000","0000000999","-0000000001","-000000001","000000050");
		}
		if(decileNumber.equalsIgnoreCase("7"))
		{
			System.out.println("DECILE 7");
			logger.info("DECILE 7");
			
			MsSqlUtility.execute_Proviner_Decile_TUQuery_GeneralD(getMapData.get("eMail"), ""+FICOScore+"","0000000002","0000000999","0000000000","0000000108","0000000000","0000000049","0000002255","0000000999",
					"-000000001","0000009992","-000000001","-000000002","-000000001","-000000002","-000000001","0000000067","-000000004","-000000004",
					"0000000999","-000000001","-000000004","-000000001","0000000000","-000000001","0000000999","0000000050","0000000067","-000000006",
					"New","0000000000","0000000999","-000000001","-000000001","0000000102");
		}
		if(decileNumber.equalsIgnoreCase("8"))
		{
			System.out.println("DECILE 8");
			logger.info("DECILE 8");
			
			MsSqlUtility.execute_Proviner_Decile_TUQuery_GeneralD(getMapData.get("eMail"), ""+FICOScore+"","0000000002","0000000033","0000000000","0000000100","0000000002","0000000026","0000002000","0000000008",
					"-1","0000009992","-000000001","-0000000002","-0000000001","-000000002","-0000000001","0000000105","-0000000004","-0000000004",
					"0000000999","-0000000001","-0000000004","-000000001","0000000000","-0000000001","0000000999","0000000038","0000000105","-0000000006",
					"New","0000000000","0000000999","-0000000001","-000000001","000000100");
			
		}
		if(decileNumber.equalsIgnoreCase("9"))
		{
			System.out.println("DECILE 9");
			logger.info("DECILE 9");
			MsSqlUtility.execute_Proviner_Decile_TUQuery_GeneralD(getMapData.get("eMail"), ""+FICOScore+"","0000000022","0000000002","0000000008","0000000119","0000000003","0000000014","0000003135","0000000003",
					"0000000000","0000009992","-000000002","-0000000002","0000000999","-000000002","0000014003","0000000152","-0000000004","-0000000004",
					"0000000001","0000000003","-0000000004","-000000001","0000000000","-0000000001","0000000999","0000000135","0000000316","-0000000006",
					"New","0000000003","0000000999","-0000000001","-000000001","000000050");
		}
		if(decileNumber.equalsIgnoreCase("10"))
		{
			System.out.println("DECILE 10");
			logger.info("DECILE 10");
			
			MsSqlUtility.execute_Proviner_Decile_TUQuery_GeneralD(getMapData.get("eMail"), ""+FICOScore+"","0000000000","0000000004","0000000000","0000000099","0000000001","0000000003","0000098687","0000000004",
					"-000000002","0000009992","-000000001","-000000002","-000000002","-000000002","000010893","0000000147","000000008","000000008",
					"0000000007","000000999","000000008","-000000001","0000000000","-000000001","0000000999","0000000025","0000000132","000000002",
					"New","0000000000","0000000008","-000000001","-000000001","0000000027");
			
		}
		/* TAMPLATE
		MsSqlUtility.execute_Proviner_Decile_TUQuery_GeneralD(getMapData.get("eMail"), "719","","","","","","","","",
				"","","","","","","","","","",
				"","","","","","","","","","",
				"New","","","","","");
		*/
	}
	
	
	public void Proviner_Decile_TUquery_GeneralD_ReRefiEa(String decileNumber, String FICOScoreR) throws Exception
	{
		Thread.sleep(8000);
		
		if(decileNumber.equalsIgnoreCase("1"))
		{
			System.out.println("DECILE 1");
			logger.info("DECILE 1");
			MsSqlUtility.execute_Proviner_Decile_TUQuery_GeneralD_ReRefiEa(getMapData.get("eMail"), ""+FICOScoreR+"","0000000021","0000000999","0000000001","0000000099","0000000001","0000000004","0000006393","0000000999",
					"83.92","0000000118","000000003","0000000032","0000000008","000000011","0000001001","0000000149","0000000000","0000000003",
					"0000000999","0000000999","0000000001","000000165","0000000001","0000000963","0000000004","0000000148","0000000309","0000000001",
					"New","0000000001","0000000999","0000000264","-000000001","-000000095");
		}
		if(decileNumber.equalsIgnoreCase("2"))
		{
			System.out.println("DECILE 2");
			logger.info("DECILE 2");
			MsSqlUtility.execute_Proviner_Decile_TUQuery_GeneralD_ReRefiEa(getMapData.get("eMail"), ""+FICOScoreR+"","0000000021","0000000999","0000000000","0000000100","0000000001","0000000030","0000002816","0000000030",
					"0000000102","0000000111","000000000","0000000077","0000000001","000000012","0000000176","0000000025","000000000","0000000002",
					"0000000999","0000000999","0000000002","-000000001","0000000000","0000000000","0000000003","0000000203","0000000502","0000000001",
					"New","0000000001","0000000999","-0000000001","-000000001","000000053");
		}
		if(decileNumber.equalsIgnoreCase("3"))
		{
			System.out.println("DECILE 3");
			logger.info("DECILE 3");
			
			MsSqlUtility.execute_Proviner_Decile_TUQuery_GeneralD_ReRefiEa(getMapData.get("eMail"), ""+FICOScoreR+"","0000000009","0000000999","0000000000","0000000011","0000000000","0000000040","0000000043","0000000999",
					"-000000002","0000009992","-000000002","-000000002","0000000999","-000000002","-000000002","0000000064","0000000000","0000000000",
					"0000000064","0000000999","0000000000","-000000001","0000000000","0000000000","0000000156","0000000159","0000000050","0000000000",
					"New","0000000000","0000000999","0000000176","-000000001","-000000001");
		
			
		}
		if(decileNumber.equalsIgnoreCase("4"))
		{
			System.out.println("DECILE 4");
			logger.info("DECILE 4");
		}
		if(decileNumber.equalsIgnoreCase("5"))
		{
			System.out.println("DECILE 5");
			logger.info("DECILE 5");
			MsSqlUtility.execute_Proviner_Decile_TUQuery_GeneralD_ReRefiEa(getMapData.get("eMail"), ""+FICOScoreR+"","0000000001","0000000999","0000000000","0000000040","0000000000","0000000080","0000001200","0000000999",
					"-2","0000009992","-000000001","-0000000002","-0000000002","-000000002","0000001800","0000000003","-0000000004","-0000000004",
					"0000000999","-0000000001","-0000000004","-000000001","0000000000","-0000000001","0000000999","0000000080","0000000070","-0000000006",
					"New","0000000000","0000000999","-0000000001","-000000001","000000040");
			
		}
		if(decileNumber.equalsIgnoreCase("6"))
		{
			System.out.println("DECILE 6");
			logger.info("DECILE 6");
			MsSqlUtility.execute_Proviner_Decile_TUQuery_GeneralD_ReRefiEa(getMapData.get("eMail"), ""+FICOScoreR+"","0000000002","0000000999","0000000000","0000000078","0000000000","0000000094","0000007000","0000000999",
					"-1","0000009992","-000000001","-0000000002","-0000000001","-000000002","-0000000001","0000000126","-0000000004","-0000000004",
					"0000000999","-0000000001","-0000000004","-000000001","0000000000","-0000000001","0000000999","0000000100","0000000126","-0000000006",
					"New","0000000000","0000000999","-0000000001","-000000001","000000050");
		}
		if(decileNumber.equalsIgnoreCase("7"))
		{
			System.out.println("DECILE 7");
			logger.info("DECILE 7");
		}
		if(decileNumber.equalsIgnoreCase("8"))
		{
			System.out.println("DECILE 8");
			logger.info("DECILE 8");
			
			MsSqlUtility.execute_Proviner_Decile_TUQuery_GeneralD_ReRefiEa(getMapData.get("eMail"), ""+FICOScoreR+"","0000000002","0000000033","0000000000","0000000100","0000000002","0000000026","0000002000","0000000008",
					"-1","0000009992","-000000001","-0000000002","-0000000001","-000000002","-0000000001","0000000105","-0000000004","-0000000004",
					"0000000999","-0000000001","-0000000004","-000000001","0000000000","-0000000001","0000000999","0000000038","0000000105","-0000000006",
					"New","0000000000","0000000999","-0000000001","-000000001","000000100");
			
		}
		if(decileNumber.equalsIgnoreCase("9"))
		{
			System.out.println("DECILE 9");
			logger.info("DECILE 9");
			MsSqlUtility.execute_Proviner_Decile_TUQuery_GeneralD_ReRefiEa(getMapData.get("eMail"), ""+FICOScoreR+"","0000000022","0000000002","0000000008","0000000119","0000000003","0000000014","0000003135","0000000003",
					"0000000000","0000009992","-000000002","-0000000002","0000000999","-000000002","0000014003","0000000152","-0000000004","-0000000004",
					"0000000001","0000000003","-0000000004","-000000001","0000000000","-0000000001","0000000999","0000000135","0000000316","-0000000006",
					"New","0000000003","0000000999","-0000000001","-000000001","000000050");
		}
		if(decileNumber.equalsIgnoreCase("10"))
		{
			System.out.println("DECILE 10");
			logger.info("DECILE 10");
			
			MsSqlUtility.execute_Proviner_Decile_TUQuery_GeneralD_ReRefiEa(getMapData.get("eMail"), ""+FICOScoreR+"","0000000000","0000000004","0000000000","0000000099","0000000001","0000000003","0000098687","0000000004",
					"-000000002","0000009992","-000000001","-000000002","-000000002","-000000002","000010893","0000000147","000000008","000000008",
					"0000000007","000000999","000000008","-000000001","0000000000","-000000001","0000000999","0000000025","0000000132","000000002",
					"New","0000000000","0000000008","-000000001","-000000001","0000000027");
			
		}
		/* TAMPLATE
		MsSqlUtility.execute_Proviner_Decile_TUQuery_GeneralD_ReRefiEa(getMapData.get("eMail"), "719","","","","","","","","",
				"","","","","","","","","","",
				"","","","","","","","","","",
				"New","","","","","");
		*/
	}
	
	public void Proviner_Decile_TUquery_5() throws Exception
	{
		Thread.sleep(8000);
		MsSqlUtility.execute_Proviner_Decile_TUQuery_5(getMapData.get("eMail"));
	}
	
	public void Proviner_Decile_TUquery_2() throws Exception
	{
		Thread.sleep(8000);
		MsSqlUtility.execute_Proviner_Decile_TUQuery_2(getMapData.get("eMail"));
	}
	
	public void Proviner_Decile_TUquery_8_reloan() throws Exception
	{
		Thread.sleep(8000);
		MsSqlUtility.execute_Proviner_Decile_TUQuery_8_reloan(getMapData.get("eMail"));
	}
	
	public void Proviner_Decile_TUquery_8_earlyadvance() throws Exception
	{
		Thread.sleep(8000);
		MsSqlUtility.execute_Proviner_Decile_TUQuery_8_earlyadvance(getMapData.get("eMail"));
	}
	
	public void Proviner_Decile_TUquery_1_refi() throws Exception
	{
		Thread.sleep(8000);
		MsSqlUtility.execute_Proviner_Decile_TUQuery_1_refi(getMapData.get("eMail"));
	}
	
	public void Proviner_Decile_TUquery_refi_generic() throws Exception
	{
		Thread.sleep(8000);
		MsSqlUtility.execute_Proviner_Decile_TUQuery_refi_generic(getMapData.get("eMail"));
	}
	
	public void TUquery_refi() throws Exception
	{
		Thread.sleep(8000);
		MsSqlUtility.RefiTUQuery(getMapData.get("eMail"));
	}
	
	public void backdateloan(int days) throws Exception
	{
		Thread.sleep(8000);
		MsSqlUtility.executeBackDateLoan(getMapData.get("eMail"), days);
	}
	public void backdateloanformakepayment(int days) throws Exception
	{
		Thread.sleep(8000);
		MsSqlUtility.executeBackDateLoan(getMapData.get("eMail"), days);
	}
	public void backdateloanforreloan(int reloandays) throws Exception
	{
		Thread.sleep(8000);
		MsSqlUtility.executeBackDateLoan(getMapData.get("eMail"), reloandays);
	}
	public void update_phonenumber() throws Exception
	{
		Thread.sleep(8000);
		
		MsSqlUtility.Check_Update_Phone_Threshold(getMapData.get("Phone"), getMapData.get("eMail"));
		
	}
	public void Update_Address_threshold() throws Exception
	{
		Thread.sleep(8000);
		MsSqlUtility.Check_Update_Address_Threshold(getMapData.get("home_Address_DB"), getMapData.get("eMail"));
	}
	public void Update_emailid_threshold() throws Exception
	{
		Thread.sleep(4000);
		MsSqlUtility.Check_email_Threshold(getMapData.get("eMail"));  
	}
	public void Update_Address() throws Exception
	{
		Thread.sleep(4000);
		MsSqlUtility.update_address(getMapData.get("home_Address_DB"));
	}
	
	public void dbvalidation() throws Exception
	{
		Thread.sleep(4000);
		//MsSqlUtility obj_DB=new MsSqlUtility();
		
		String LoanID = MsSqlUtility.getLoanId(getMapData.get("eMail"))+"";
		String LoanTypeID = MsSqlUtility.getLoanTypeId(getMapData.get("eMail"))+"";
		String CustomerId = MsSqlUtility.getCustomerId(getMapData.get("eMail"))+"";
		long LoanStatus=MsSqlUtility.getLoanStatusId(getMapData.get("eMail"));
		String LoanStatusID = Long.toString(LoanStatus);
		//HashMap<String, String> trans=MsSqlUtility.getLOANTRANSACTIONTable("history.twocard@yopmail.com");
	
		
		datatable.setCellDataForTestData_online(testCaseName, "LoanID_out", 1, LoanID);
		datatable.setCellDataForTestData_online(testCaseName, "LoanTypeID_out", 1, LoanTypeID);
		datatable.setCellDataForTestData_online(testCaseName, "CustomerId_out", 1, CustomerId);
		datatable.setCellDataForTestData_online(testCaseName, "LoanStatus_out", 1, LoanStatusID);
		datatable.setCellDataForTestData_online(testCaseName, "LoanStatusID_out", 1, LoanStatusID);
		
		//datatable.setCellDataForTestData_online_DB(testCaseName, "LoanNote", 1, loannote);
		//datatable.setCellDataForTestData_online_DB1(testCaseName, "LoanTransaction", 1, trans);
		
		if(LoanStatusID.equalsIgnoreCase(getMapData.get("DB_LoanStatus_Denied")))
		{
			String results="loan deneid and Test case passed";
			datatable.setCellDataForTestData_online(testCaseName, "Result_out", 1, results);
		}   
		else if(LoanStatusID.equalsIgnoreCase(getMapData.get("DB_LoanStatus_funded")))
		{
			String results="loan funded and Test case passed";
			datatable.setCellDataForTestData_online(testCaseName, "Result_out", 1, results);
		}
		else if(LoanStatusID.equalsIgnoreCase(getMapData.get("DB_LoanStatus_etransfer")))
		{
			String results="loan etransfer funding and Test case passed";
			datatable.setCellDataForTestData_online(testCaseName, "Result_out", 1, results);
		}
		
		
		
		/*comment 24 july 2022 start
		 * int loanNoteSize =
		 * MsSqlUtility.getLOANNOTETable(getMapData.get("eMail")).size(); for(int
		 * i=0;i<loanNoteSize;i++) {
		 * 
		 * //loannote=MsSqlUtility.getLOANNOTETable(getMapData.get("eMail")).get(i)
		 * +"Loan note table row "+i;
		 * PrintValueToReport(MsSqlUtility.getLOANNOTETable(getMapData.get("eMail")).get
		 * (i),"Loan note table row "+i);
		 * 
		 * 
		 * 
		 * }comment 24 july 2022 end
		 */
		
	
	}
	
	public void dbvalidation_initilize_LoanDetails_Save_Excel() throws Exception
	{
		Thread.sleep(1000);
		CandLoanId = MsSqlUtility.getLoanId(getMapData.get("eMail"))+"";

		logLoanDetails.add("*********************** LOAN DETAILS *****************************");
		logLoanDetails.add("Loan Id : " + CandLoanId);
		
		CandCustomerId = MsSqlUtility.getCustomerId(getMapData.get("eMail"))+"";
		logLoanDetails.add("Customer Id : " + CandCustomerId);
		
		CanLoanTypeID = MsSqlUtility.getLoanTypeId(getMapData.get("eMail"))+"";
		logLoanDetails.add("Loan Type Id : " + CanLoanTypeID);
		
		
		long LoanStatus=MsSqlUtility.getLoanStatusId(getMapData.get("eMail"));
		CanLoanStatusID = Long.toString(LoanStatus);
		logLoanDetails.add("Loan Status Id : " + CanLoanStatusID);
		logLoanDetails.add("*********************** LOAN DETAILS *****************************");
		
		UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
		logLoanDetails.clear();
		
		datatable.setCellDataForTestData_online(testCaseName, "LoanID_out", 1, CandLoanId);
		datatable.setCellDataForTestData_online(testCaseName, "LoanTypeID_out", 1, CanLoanTypeID);
		datatable.setCellDataForTestData_online(testCaseName, "CustomerId_out", 1, CandCustomerId);
		datatable.setCellDataForTestData_online(testCaseName, "LoanStatus_out", 1, CanLoanStatusID);
		datatable.setCellDataForTestData_online(testCaseName, "LoanStatusID_out", 1, CanLoanStatusID);
		
		
	}
	
	public void dbvalidation_reloan_Refinance() throws Exception
	{
		Thread.sleep(10000);
		//MsSqlUtility obj_DB=new MsSqlUtility();
		
		String LoanID = MsSqlUtility.getLoanId(getMapData.get("eMail"))+"";
		String LoanTypeID = MsSqlUtility.getLoanTypeId(getMapData.get("eMail"))+"";
		String CustomerId = MsSqlUtility.getCustomerId(getMapData.get("eMail"))+"";
		long LoanStatus=MsSqlUtility.getLoanStatusId(getMapData.get("eMail"));
		String LoanStatusID = Long.toString(LoanStatus);

		datatable.setCellDataForTestData_online(testCaseName, "Child_loan_id", 1, LoanID);
		
		datatable.setCellDataForTestData_online(testCaseName, "Child_loan_status", 1, LoanStatusID);
		
		if(LoanStatusID.equalsIgnoreCase(getMapData.get("DB_LoanStatus_Denied")))
		{
			String results="loan deneid and Test case passed";
			datatable.setCellDataForTestData_online(testCaseName, "Child_result_out", 1, results);
		}
		else if(LoanStatusID.equalsIgnoreCase(getMapData.get("DB_LoanStatus_funded")))
		{
			String results="loan funded and Test case passed";
			datatable.setCellDataForTestData_online(testCaseName, "Child_result_out", 1, results);
		}
		else if(LoanStatusID.equalsIgnoreCase(getMapData.get("DB_LoanStatus_etransfer")))
		{
			String results="loan etransfer funding and Test case passed";
			datatable.setCellDataForTestData_online(testCaseName, "Child_result_out", 1, results);
		}
		
		
		
		/* comment 24 july 2022 start
		 * int loanNoteSize =
		 * MsSqlUtility.getLOANNOTETable(getMapData.get("eMail")).size(); for(int
		 * i=0;i<loanNoteSize;i++) {
		 * 
		 * //loannote=MsSqlUtility.getLOANNOTETable(getMapData.get("eMail")).get(i)
		 * +"Loan note table row "+i;
		 * PrintValueToReport(MsSqlUtility.getLOANNOTETable(getMapData.get("eMail")).get
		 * (i),"Loan note table row "+i);
		 * 
		 * }comment 24 july 2022 end
		 */
		
		
	}
	
	public void dbvalidation_recind() throws Exception
	{
		Thread.sleep(10000);
		//MsSqlUtility obj_DB=new MsSqlUtility();
		
		String LoanID = MsSqlUtility.getLoanId(getMapData.get("eMail"))+"";
		String LoanTypeID = MsSqlUtility.getLoanTypeId(getMapData.get("eMail"))+"";
		String CustomerId = MsSqlUtility.getCustomerId(getMapData.get("eMail"))+"";
		long LoanStatus=MsSqlUtility.getLoanStatusId(getMapData.get("eMail"));
		String LoanStatusID = Long.toString(LoanStatus);
		datatable.setCellDataForTestData_online(testCaseName, "LoanStatusID", 1, LoanStatusID);
		if(LoanStatusID.equalsIgnoreCase(getMapData.get("DB_LoanStatus_rescind")))
		{
			String results="loan rescind and Test case passed";
			datatable.setCellDataForTestData_online(testCaseName, "Result", 1, results);
		}
		else if(LoanStatusID.equalsIgnoreCase(getMapData.get("DB_LoanStatus_funded")))
		{
			String results="loan funded and Test case passed";
			datatable.setCellDataForTestData_online(testCaseName, "Result", 1, results);
		}
		else if(LoanStatusID.equalsIgnoreCase(getMapData.get("DB_LoanStatus_etransfer")))
		{
			String results="loan etransfer funding and Test case passed";
			datatable.setCellDataForTestData_online(testCaseName, "Result", 1, results);
		}
		
		
		
		/*
		 * int loanNoteSize =
		 * MsSqlUtility.getLOANNOTETable(getMapData.get("eMail")).size(); for(int
		 * i=0;i<loanNoteSize;i++) {
		 * 
		 * //loannote=MsSqlUtility.getLOANNOTETable(getMapData.get("eMail")).get(i)
		 * +"Loan note table row "+i;
		 * PrintValueToReport(MsSqlUtility.getLOANNOTETable(getMapData.get("eMail")).get
		 * (i),"Loan note table row "+i);
		 * 
		 * }
		 */
		
	}
		public void update_loanstatus(int LoanStatus) throws Exception
		{
			Thread.sleep(4000);
			long LoanStatus_DB=MsSqlUtility.getLoanStatusId(getMapData.get("eMail"));
			String LoanStatusID = Long.toString(LoanStatus_DB);
			
			if (LoanStatusID.equalsIgnoreCase(getMapData.get("DB_LoanStatus_BeforeCRM")))
			{
			
			MsSqlUtility.UpdateLoanStatus(getMapData.get("eMail"), LoanStatus);
			}
			else
			{
				logLoanDetails.add("===Loan status===");
		        logLoanDetails.add(LoanStatusID);
		        logLoanDetails.add("===Loan status===");
			}
		}
		
		
		public void update_loanstatus_3(int LoanStatus) throws Exception
		{
			Thread.sleep(4000);
			long LoanStatus_DB=MsSqlUtility.getLoanStatusId(getMapData.get("eMail"));
			String LoanStatusID = Long.toString(LoanStatus_DB);
			
			//if (LoanStatusID.equalsIgnoreCase(getMapData.get("DB_LoanStatus_BeforeCRM")))
			//{
			
			MsSqlUtility.UpdateLoanStatus_3(getMapData.get("eMail"), LoanStatus);
			//}
			//else
			//{
				//logLoanDetails.add("===Loan status===");
		        //logLoanDetails.add(LoanStatusID);
		        //logLoanDetails.add("===Loan status===");
			//}
		}
		
		
		public void Change_LoanContract_iD(int LoanNo) throws Exception
		{
			String LoanContractID=MsSqlUtility.getLoanContractID(getMapData.get("eMail"));
			//String LoanContractID = Double.toString(loancontract);
			System.out.println(LoanContractID);
			String[] loancont = LoanContractID.split("-");
			String p1 = loancont[0];
			String p2 = loancont[1];
			String p3 = loancont[2];
			String p4 = loancont[3];
			String loanContID;
			int p3_1 = Integer.parseInt(p3)-100;
			int p4_1 = Integer.parseInt(p4)+5+LoanNo;
			
			int length1 = String.valueOf(p3_1).length();
			int length2 = String.valueOf(p4_1).length();
			if(length1==6)
			{
				if(length2==2)
				{
					loanContID = p1+"-"+p2+"-"+p3_1+"-"+p4_1;
				}
				else
				{
					String p41_1 = "0"+p4_1;
					loanContID = p1+"-"+p2+"-"+p3_1+"-"+p41_1;
				}
				
			}
			else
			{
				if(length2==2)
				{
					String p31_1 = "0"+p3_1;
					loanContID = p1+"-"+p2+"-"+p31_1+"-"+p4_1;
				}
				else
				{
					String p31_1 = "0"+p3_1;
					String p41_1 = "0"+p4_1;
					loanContID = p1+"-"+p2+"-"+p31_1+"-"+p41_1;
				}
				
			}
			
			//Update loan-ContractID
			MsSqlUtility.UpdateLoanContractID(getMapData.get("eMail"),loanContID);
			PrintValueToReport("Loan contract id is changed from "+LoanContractID+" to "+loanContID+" for LoanID "+MsSqlUtility.getLoanId(getMapData.get("eMail")), "Loan contract id is changed");

		}
	
	}
