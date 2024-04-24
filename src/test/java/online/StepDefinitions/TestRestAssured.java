package online.StepDefinitions;

import static io.restassured.RestAssured.baseURI;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.interactions.Actions;

import driver.TestBase;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import sqlUtils.MsSqlUtility;
import utils.UtilityMethods;


public class TestRestAssured {
	public static String BASE_URL = TestBase.getPropertyValue("BASE_URL");
	public static String BASE_URL_LoanBook = TestBase.getPropertyValue("BASE_URL_LoanBook");
	public static String BASE_URL_ReFi = TestBase.getPropertyValue("BASE_URL_ReFi");
	public static String BASE_URL_ExpiredLoan = TestBase.getPropertyValue("BASE_URL_ExpiredLoan");
	
	//Proviner
	public static String BASE_URL_Proviner = TestBase.getPropertyValue("BASE_URL_Proviner");
	
	public static final Logger logger = Logger.getLogger(TestRestAssured.class.getName());
	
	public static String token;
	public static String CustomerSegmentation;
	public static String ApplicationType;
	public static String Decision;
	public static float MaxAmount;
	public static Response response;
	public static String jsonString;
	
	public static void toGetPostRequestResponseToken() throws IOException {
		RestAssured.baseURI = BASE_URL;
		logger.info("RestAssured.baseURI");
		
     	//Added on 28-May-2022 Start
		TestBase.logLoanDetails.add("###################################################");
		TestBase.logLoanDetails.add(RestAssured.baseURI);
		TestBase.logLoanDetails.add("###################################################");
		//Added on 28-May-2022 End

		//Added on 28-May-2022 Start
		UtilityMethods.PBufferWriter(TestBase.logLoanDetailsPath, TestBase.logLoanDetails);;
		TestBase.logLoanDetails.clear();
		//Added on 28-May-2022 End

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		response = request.body("{\r\n"
				+ "    \"user_id\" : \"AspenBatch\" ,\r\n"
				+ "    \"user_pass\" : \"Y@cE[(Cu\"\r\n"
				+ "}")
				.post("/Authenticate");
		String jsonString = response.asString();
		System.out.println("DONE");
		System.out.println(jsonString);
		System.out.println("DONE");
		token = JsonPath.from(jsonString).get("JwtToken");
		System.out.println("TOKEN");
		System.out.println(token);
		System.out.println("TOKEN");
		
	}
	public static void toExecuteCronJobForLanBook() throws IOException 
	{
		RestAssured.baseURI = BASE_URL_LoanBook;
		
		System.out.println(RestAssured.baseURI);
		
	     	//Added on 28-May-2022 Start
			TestBase.logLoanDetails.add("###################################################");
			TestBase.logLoanDetails.add(RestAssured.baseURI);
			TestBase.logLoanDetails.add("###################################################");
			//Added on 28-May-2022 End

			//Added on 28-May-2022 Start
			UtilityMethods.PBufferWriter(TestBase.logLoanDetailsPath, TestBase.logLoanDetails);;
			TestBase.logLoanDetails.clear();
			//Added on 28-May-2022 End
		
			logger.info("RestAssured.baseURI");		
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Authorization",token);
		response = request.post(baseURI);
		String jsonString = response.asString();
		System.out.println("DONE LoanBook");
		System.out.println(jsonString);
		
		//Added on 28-May-2022 Start
		TestBase.logLoanDetails.add("###################################################");
		TestBase.logLoanDetails.add(jsonString);
		TestBase.logLoanDetails.add("###################################################");
		//Added on 28-May-2022 End

		//Added on 28-May-2022 Start
		UtilityMethods.PBufferWriter(TestBase.logLoanDetailsPath, TestBase.logLoanDetails);;
		TestBase.logLoanDetails.clear();
		//Added on 28-May-2022 End
		
		System.out.println("DONE LoanBook");
	}
	
	
	
	public static void toExecute_Proviner_Job() throws IOException, InterruptedException 
	{
		RestAssured.baseURI = BASE_URL_Proviner;
		
		System.out.println(RestAssured.baseURI);
		
			//Added on 28-May-2022 Start
			TestBase.logLoanDetails.add("###################################################");
			TestBase.logLoanDetails.add(RestAssured.baseURI);
			TestBase.logLoanDetails.add("###################################################");
			//Added on 28-May-2022 End

			//Added on 28-May-2022 Start
			UtilityMethods.PBufferWriter(TestBase.logLoanDetailsPath, TestBase.logLoanDetails);;
			TestBase.logLoanDetails.clear();
			//Added on 28-May-2022 End
			
		logger.info("RestAssured.baseURI");		
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		//response = request.post(baseURI);
		
		
		Thread.sleep(5000);
		TestBase.sRequest = MsSqlUtility.getRequest(TestBase.getMapData.get("eMail"));
		System.out.println(TestBase.sRequest);
		
		
		//Added on 28-May-2022 Start
		TestBase.logLoanDetails.add("######################REQUEST FROM DB START#############################");
		TestBase.logLoanDetails.add(TestBase.sRequest);
		TestBase.logLoanDetails.add("######################REQUEST FROM DB END#############################");
		//Added on 28-May-2022 End

		//Added on 28-May-2022 Start
		UtilityMethods.PBufferWriter(TestBase.logLoanDetailsPath, TestBase.logLoanDetails);;
		TestBase.logLoanDetails.clear();
		//Added on 28-May-2022 End
		
		
		response = request.body(TestBase.sRequest)
		.post("/CanadaWorkflow");
		
		/*
		response = request.body("{\r\n"
				+ "    \"Customer\": {\r\n"
				+ "        \"CustomerId\": \"4319341\",\r\n"
				+ "        \"FirstName\": \"DAVEULPKL\",\r\n"
				+ "        \"MiddleName\": \"\",\r\n"
				+ "        \"LastName\": \"SIMPSONULPKL\",\r\n"
				+ "        \"GovernmentNumber\": \"715258455\",\r\n"
				+ "        \"DateOfBirth\": \"1971-03-24T00:00:00\",\r\n"
				+ "        \"Email\": \"dave_ulpkl@yopmail.com\",\r\n"
				+ "        \"IsUnemployed\": null,\r\n"
				+ "        \"NMMEmployee\": false,\r\n"
				+ "        \"OccupationName\": \"\",\r\n"
				+ "        \"NoOfDependents\": 0,\r\n"
				+ "        \"MaritalStatus\": \"\",\r\n"
				+ "        \"SpouseEmployed\": null,\r\n"
				+ "        \"PriorMonthNetPay\": 0.0,\r\n"
				+ "        \"EmployerList\": [\r\n"
				+ "            {\r\n"
				+ "                \"CustomerEmployerId\": 10739710,\r\n"
				+ "                \"EmployerName\": \"BMW\",\r\n"
				+ "                \"CountryCode\": \"CAN\",\r\n"
				+ "                \"Phone\": \"9090919191\",\r\n"
				+ "                \"HireDate\": null,\r\n"
				+ "                \"PayPeriod\": \"MONTHLY\",\r\n"
				+ "                \"LastPayDate\": \"2022-07-20T00:00:00\",\r\n"
				+ "                \"NetPay\": 7200.0000,\r\n"
				+ "                \"GrossPay\": null,\r\n"
				+ "                \"DirectDeposit\": true,\r\n"
				+ "                \"PrimaryIncome\": true,\r\n"
				+ "                \"NextPayDate\": \"2022-08-20T00:00:00\",\r\n"
				+ "                \"SecondPayDate\": null,\r\n"
				+ "                \"EmploymentType\": \"WAGES\",\r\n"
				+ "                \"EmploymentStatus\": \"Full Time Employment\",\r\n"
				+ "                \"WeekNumber\": 0,\r\n"
				+ "                \"DayOfWeek\": 0,\r\n"
				+ "                \"DayOfMonth\": 20,\r\n"
				+ "                \"PayPeriodTypeName\": null,\r\n"
				+ "                \"LastDayOfMonth\": null\r\n"
				+ "            }\r\n"
				+ "        ],\r\n"
				+ "        \"PhoneList\": [],\r\n"
				+ "        \"Address\": {\r\n"
				+ "            \"Address1\": \"\",\r\n"
				+ "            \"Address2\": \"C-1330\",\r\n"
				+ "            \"Address3\": \"PRINCESS AVE\",\r\n"
				+ "            \"City\": \"BRANDON\",\r\n"
				+ "            \"State\": \"MB\",\r\n"
				+ "            \"PostalCode\": \"R7A0R5\",\r\n"
				+ "            \"CountryCode\": \"CAN\"\r\n"
				+ "        },\r\n"
				+ "        \"Expenditure\": {\r\n"
				+ "            \"MonthlyChildSupportExpense\": 0.0,\r\n"
				+ "            \"MonthlyAlimonyExpense\": 0.0,\r\n"
				+ "            \"MonthlyPayJudgementExpense\": 0.0,\r\n"
				+ "            \"OtherMonthlyAmount\": 0.0\r\n"
				+ "        }\r\n"
				+ "    },\r\n"
				+ "    \"LoanHistory\": [\r\n"
				+ "        {\r\n"
				+ "            \"LoanId\": 21495323,\r\n"
				+ "            \"LoanType\": \"MPL\",\r\n"
				+ "            \"LoanStatus\": \"Open\",\r\n"
				+ "            \"OriginationDate\": \"2022-03-04T01:59:09.51\",\r\n"
				+ "            \"PaidDate\": null,\r\n"
				+ "            \"Duedate\": \"2026-03-12T00:00:00\",\r\n"
				+ "            \"Principal\": 9000.0000,\r\n"
				+ "            \"Fee\": 0.0000\r\n"
				+ "        }\r\n"
				+ "    ],\r\n"
				+ "    \"CurrentInstallmentLoan\": {\r\n"
				+ "        \"LoanId\": 21495323,\r\n"
				+ "        \"OriginationDate\": \"2022-03-04T01:59:09.51\",\r\n"
				+ "        \"LoanStatus\": \"Open\",\r\n"
				+ "        \"Decile\": 1.0,\r\n"
				+ "        \"ModelScore\": 700.0,\r\n"
				+ "        \"CustomerSegmentation\": \"New\",\r\n"
				+ "        \"MaxPastDueDaysIn180Days\": 0,\r\n"
				+ "        \"IsEarlyAdvance\": false,\r\n"
				+ "        \"IsTopUp\": null,\r\n"
				+ "        \"IsRefinance\": false,\r\n"
				+ "        \"RefinanceCount\": 0,\r\n"
				+ "        \"EarlyAdvanceCount\": 0,\r\n"
				+ "        \"PastDueAmount\": 0.0,\r\n"
				+ "        \"LastPaymentDate\": \"2022-08-12T02:03:39.527\",\r\n"
				+ "        \"LastTwoPaymentMadeOnTime\": true,\r\n"
				+ "        \"OfferedLineAmount\": 15000.0000,\r\n"
				+ "        \"SPLOutstandingPastDueAmountIn12Months\": null,\r\n"
				+ "        \"PayOffAmount\": 8693.5000,\r\n"
				+ "        \"TopParentOriginationDate\": \"2022-03-08T00:00:00\",\r\n"
				+ "        \"FirstScheduledPaidDate\": \"2022-04-12T02:00:52.257\",\r\n"
				+ "        \"LoanAmount\": 9000.0000\r\n"
				+ "    },\r\n"
				+ "    \"TUCredit\": {\r\n"
				+ "        \"CreditData\": \"<REL4Report><UserReference>UAT Example</UserReference><MemberCode>975ZZ42052</MemberCode><Date>20220520</Date><Time>080956</Time><Product>07000</Product><TU_FFR_Report><Hit>Y</Hit><OnFileDate>20180308</OnFileDate><Names><Name NameType=\\\"Primary \\\"><LastName>MSAPOSTROPHY</LastName><FirstName>STREET</FirstName><MiddleName>TOB</MiddleName></Name></Names><PersonalInformation><SIN>000000000</SIN><DOB>19780805</DOB></PersonalInformation><Addresses><Address AddrType=\\\"Personal \\\"><Street>276 O?CONNOR</Street><City>OTTAWA</City><Prov>ON</Prov><Postal>K2P1V3</Postal><DateReported>20170106</DateReported></Address><Address AddrType=\\\"Personal \\\"><Street>1669 OAKLAND AVE</Street><City>BRANDON</City><Prov>MB</Prov><Postal>R3A1S8</Postal><DateReported>19890801</DateReported></Address></Addresses><Telephones><Telephone PhoneType=\\\"Personal \\\"><Number>6137821112</Number></Telephone></Telephones><Collections><Collection><MemberName>FAMILY RES. OFF.</MemberName><Account>07080708615</Account><Creditor>TU TEST</Creditor><DateReported>20170120</DateReported><DateVerified>20220501</DateVerified><DatePaidOut>20170721</DatePaidOut><Narrative>FA</Narrative><CurrentBalance>0</CurrentBalance><OriginalAmount>1800</OriginalAmount><Remarks>PD</Remarks></Collection></Collections><Trades><Trade><MemberCode>QC</MemberCode><MemberName>NANAIMO CREDIT UNION</MemberName><Type>R</Type><Account>000001772</Account><Joint>I</Joint><DateOpened>20190112</DateOpened><DateRevised>20220107</DateRevised><DateLastActivity>20220117</DateLastActivity><MOP>01</MOP><Balance>394</Balance><HighCredit>3500</HighCredit><CreditLimit>0</CreditLimit><Frequency>M</Frequency><Payment>10</Payment><Narrative1>HC</Narrative1><PastDue>0</PastDue><PaymentPatternStartDate>20220103</PaymentPatternStartDate><PaymentPattern>1111111111111111111111111111111111111</PaymentPattern><MonthsReviewed>37</MonthsReviewed><Plus30>0</Plus30><Plus60>0</Plus60><Plus90>0</Plus90></Trade><Trade><MemberCode>BC</MemberCode><MemberName>NATIONAL BANK MASTERCARD</MemberName><Type>R</Type><Account>000002315</Account><Joint>I</Joint><DateOpened>20090513</DateOpened><DateRevised>20220104</DateRevised><DateLastActivity>20181028</DateLastActivity><MOP>01</MOP><Balance>0</Balance><HighCredit>12100</HighCredit><CreditLimit>0</CreditLimit><Frequency>M</Frequency><Payment>0</Payment><Narrative1>HC</Narrative1><PastDue>0</PastDue><PaymentPatternStartDate>20220114</PaymentPatternStartDate><PaymentPattern>111111111111111XXXXXXXXXXXXXXXXXXXXXXX11X1111111</PaymentPattern><MonthsReviewed>63</MonthsReviewed><Plus30>0</Plus30><Plus60>0</Plus60><Plus90>0</Plus90></Trade><Trade><MemberCode>AZ</MemberCode><MemberName>DRIVE CREDIT CANADA</MemberName><Type>I</Type><Account>000000000023</Account><Joint>I</Joint><DateOpened>20161213</DateOpened><DateRevised>20201113</DateRevised><DateLastActivity>20201024</DateLastActivity><MOP>01</MOP><Balance>10394</Balance><HighCredit>25961</HighCredit><CreditLimit>0</CreditLimit><Frequency>M</Frequency><Payment>635</Payment><PastDue>0</PastDue><PaymentPatternStartDate>20201028</PaymentPatternStartDate><PaymentPattern>11111111111111111111111111111111111111111111111</PaymentPattern><MonthsReviewed>47</MonthsReviewed><Plus30>0</Plus30><Plus60>0</Plus60><Plus90>0</Plus90></Trade><Trade><MemberCode>BB</MemberCode><MemberName>NS BANK EXETER 26007</MemberName><Type>I</Type><Account>OP-099000000000023</Account><Joint>I</Joint><DateOpened>20160516</DateOpened><DateRevised>20200205</DateRevised><DateLastActivity>20200120</DateLastActivity><MOP>01</MOP><Balance>0</Balance><HighCredit>17000</HighCredit><CreditLimit>0</CreditLimit><Frequency>M</Frequency><Payment>0</Payment><Narrative1>PD</Narrative1><PastDue>0</PastDue><PaymentPatternStartDate>20200128</PaymentPatternStartDate><PaymentPattern>11111111111111111111111111111111111111111111</PaymentPattern><MonthsReviewed>44</MonthsReviewed><Plus30>0</Plus30><Plus60>0</Plus60><Plus90>0</Plus90></Trade><Trade><MemberCode>BC</MemberCode><MemberName>CAPITAL ONE BANK</MemberName><Type>R</Type><Account>000002912</Account><Joint>I</Joint><DateOpened>20090513</DateOpened><DateRevised>20171111</DateRevised><DateLastActivity>20171101</DateLastActivity><MOP>01</MOP><Balance>0</Balance><HighCredit>12100</HighCredit><CreditLimit>0</CreditLimit><Frequency>M</Frequency><Payment>10</Payment><Narrative1>CL</Narrative1><Narrative2>HC</Narrative2><PastDue>0</PastDue><PaymentPatternStartDate>20171110</PaymentPatternStartDate><PaymentPattern>111X1111111111XX1111111111XXX1111111XXXXXXX11111</PaymentPattern><MonthsReviewed>99</MonthsReviewed><Plus30>0</Plus30><Plus60>0</Plus60><Plus90>0</Plus90></Trade><Trade><MemberCode>QC</MemberCode><MemberName>METRO CREDIT UNION</MemberName><Type>R</Type><Account>000004300</Account><Joint>C</Joint><DateOpened>20110301</DateOpened><DateRevised>20140428</DateRevised><DateLastActivity>20120401</DateLastActivity><MOP>01</MOP><Balance>0</Balance><HighCredit>0</HighCredit><CreditLimit>5000</CreditLimit><Frequency>M</Frequency><Payment>0</Payment><Narrative1>CZ</Narrative1><PastDue>0</PastDue><PaymentPatternStartDate>20140428</PaymentPatternStartDate><PaymentPattern>11111111111111111111111111111111111111</PaymentPattern><MonthsReviewed>38</MonthsReviewed><Plus30>0</Plus30><Plus60>0</Plus60><Plus90>0</Plus90></Trade><Trade><MemberCode>QA</MemberCode><MemberName>CAN-AUTO</MemberName><Type>I</Type><Account>000006602</Account><Joint>I</Joint><DateOpened>20070901</DateOpened><DateRevised>20111002</DateRevised><DateLastActivity>20111001</DateLastActivity><MOP>01</MOP><Balance>0</Balance><HighCredit>18208</HighCredit><CreditLimit>0</CreditLimit><Frequency>M</Frequency><Payment>0</Payment><Narrative1>PD</Narrative1><PastDue>0</PastDue><PaymentPatternStartDate>20111002</PaymentPatternStartDate><PaymentPattern>111111111111111111111111111111111111111111111111</PaymentPattern><MonthsReviewed>51</MonthsReviewed><Plus30>0</Plus30><Plus60>0</Plus60><Plus90>0</Plus90></Trade><Trade><MemberCode>BC</MemberCode><MemberName>LATITUDE BNC</MemberName><Type>R</Type><Account>000006592</Account><Joint>I</Joint><DateOpened>19850701</DateOpened><DateRevised>20101126</DateRevised><DateLastActivity>20101001</DateLastActivity><MOP>01</MOP><Balance>0</Balance><HighCredit>11000</HighCredit><CreditLimit>0</CreditLimit><Frequency>M</Frequency><Payment>0</Payment><Narrative1>CZ</Narrative1><Narrative2>HC</Narrative2><PastDue>0</PastDue><PaymentPatternStartDate>20101126</PaymentPatternStartDate><PaymentPattern>1111111111111111111111111111111111X1111111111111</PaymentPattern><MonthsReviewed>99</MonthsReviewed><Plus30>0</Plus30><Plus60>0</Plus60><Plus90>0</Plus90></Trade><Trade><MemberCode>BB</MemberCode><MemberName>TD BK KING ST KITCHENER</MemberName><Type>R</Type><Account>000000000023</Account><Joint>I</Joint><DateOpened>20060201</DateOpened><DateRevised>20100201</DateRevised><DateLastActivity>20100201</DateLastActivity><MOP>01</MOP><Balance>0</Balance><HighCredit>10000</HighCredit><CreditLimit>0</CreditLimit><Frequency>M</Frequency><Payment>178</Payment><Narrative1>AC</Narrative1><Narrative2>HC</Narrative2><PastDue>0</PastDue><PaymentPatternStartDate>20100201</PaymentPatternStartDate><PaymentPattern>1111111111111111111111111111111111111111111111</PaymentPattern><MonthsReviewed>46</MonthsReviewed><Plus30>0</Plus30><Plus60>0</Plus60><Plus90>0</Plus90></Trade></Trades><Inquiries><Inquiry><MemberCode>BB00078746</MemberCode><MemberName>BK MONTREAL NIAGARA ST W</MemberName><Date>20090511</Date></Inquiry></Inquiries><ScoreProducts><ScoreProduct><Product>A1948</Product></ScoreProduct><ScoreProduct><Product>C1805</Product></ScoreProduct><ScoreProduct><Product>C1950</Product></ScoreProduct><ScoreProduct><Product>00002</Product><Score>700</Score><ScoreDerogatoryAlert>A</ScoreDerogatoryAlert><Factor1>40</Factor1><Factor2>27</Factor2><Factor3>0</Factor3><Factor4>0</Factor4><ScoreCard>00</ScoreCard></ScoreProduct></ScoreProducts><AccountNetCharacteristics><AccountNetCharacteristic><ID>GO146</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO145</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO143</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO149</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO148</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO147</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT93</ID><Value>0000000156</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT92</ID><Value>0000000131</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT95</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT94</ID><Value>0000030773</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT179</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO141</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT91</ID><Value>0000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT186</ID><Value>0000000394</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AI60</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT96</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT185</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT98</ID><Value>0000030773</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT99</ID><Value>0000010788</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MS154</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT180</ID><Value>0000000010</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO155</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE260</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO154</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BR155</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO157</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO156</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO158</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO151</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO150</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO153</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO152</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT199</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT198</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT197</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT196</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT195</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MC34</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT193</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT192</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BR147</ID><Value>0000000011</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR88</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AM62</ID><Value>0000003500</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AM61</ID><Value>0000000394</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI85</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT161</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MC01</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT160</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT163</ID><Value>0000003500</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT162</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT165</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT164</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT167</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT166</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR91</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR92</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR95</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MC04</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MC03</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MC02</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO81</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AM155</ID><Value>-000000095</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO80</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO83</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT168</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT169</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO89</ID><Value>K2P1V3</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT174</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PF01</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT178</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT177</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT176</ID><Value>0000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT175</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PF08</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT170</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PF03</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO13</ID><Value>0000000004</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO14</ID><Value>0000000309</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT139</ID><Value>0000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO11</ID><Value>0000000100</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO12</ID><Value>0000000148</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO17</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO18</ID><Value>Y</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO16</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR68</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR73</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN155</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN153</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT57</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT142</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO19</ID><Value>Y</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT145</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>OF34</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT140</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT141</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT61</ID><Value>0000000394</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BR24</ID><Value>0000000006</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO22</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT62</ID><Value>0000003500</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BR25</ID><Value>0000000006</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO23</ID><Value>0019850701</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO24</ID><Value>0020220117</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT60</ID><Value>0000000010</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO25</ID><Value>0020090511</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT149</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT148</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT147</ID><Value>0000000099</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO28</ID><Value>0000000004</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO29</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR75</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO116</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO20</ID><Value>Y</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR78</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO21</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MC154</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>OF20</ID><Value>0000000264</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PF29</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR80</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT155</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BI36</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT153</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT154</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT151</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT152</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PF21</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PF20</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT150</ID><Value>0000000394</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN04</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO33</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AM25</ID><Value>0000000021</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO31</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR42</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN02</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO30</ID><Value>0000000525</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR43</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR51</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO129</ID><Value>0020220520</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT77</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PF34</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT76</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT79</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT127</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT80</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FR21</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT83</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FR20</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT84</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT82</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO136</ID><Value>0000000009</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO137</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO132</ID><Value>0000000064</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO134</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AM18</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT88</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT87</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT86</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT85</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT133</ID><Value>0000000009</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT89</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT132</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT20</ID><Value>0000000442</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT100</ID><Value>0000000004</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT21</ID><Value>0000000004</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT22</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT23</ID><Value>0000000009</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT24</ID><Value>0000000009</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT25</ID><Value>0000000009</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT26</ID><Value>0000000009</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT27</ID><Value>0000000009</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT28</ID><Value>0000015600</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT29</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI27</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI20</ID><Value>0000000176</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI21</ID><Value>0000000176</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI23</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI24</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI25</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI26</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT10</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT11</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT14</ID><Value>0000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT15</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT12</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR119</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT13</ID><Value>0000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT18</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT19</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT106</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI33</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI36</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN28</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT103</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT104</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI34</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT105</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI35</ID><Value>0000000963</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BR98</ID><Value>0000015206</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT42</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT43</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FR01</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FR03</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN35</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI01</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI02</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT40</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI03</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE03</ID><Value>0000000006</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT36</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BR84</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT37</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BR85</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT34</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE94</ID><Value>0000015206</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT35</ID><Value>0000006393</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT33</ID><Value>0000000394</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT30</ID><Value>0000000007</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT38</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT39</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO07</ID><Value>0000000004</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO06</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO04</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO03</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO01</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR12</ID><Value>0000000064</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT335</ID><Value>0000000087</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BC155</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR11</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI153</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR10</ID><Value>0000001800</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE21</ID><Value>0000000040</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE23</ID><Value>0000000006</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE24</ID><Value>0000000006</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN59</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE25</ID><Value>0000000006</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE26</ID><Value>0000000006</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE27</ID><Value>0000000006</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT200</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PF153</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT201</ID><Value>0000000176</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR09</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR02</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI145</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO96</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN68</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN62</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BI85</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BI84</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT06</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT05</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT07</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT02</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT01</ID><Value>0000000009</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT03</ID><Value>0000000009</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR38</ID><Value>0020170120</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AM79</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR41</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AM75</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN77</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RR35</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AM86</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN85</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AGG302</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AGG801</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AGG910</ID><Value>83.92</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PAYMNT11</ID><Value>0000000032</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TPR201</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AGG901</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AGG911</ID><Value>2.53</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BALMAG01</ID><Value>0000000118</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BALMAG02</ID><Value>0000009992</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PAYMNT02</ID><Value>000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PAYMNT04</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PAYMNT05</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PAYMNT06</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PAYMNT08</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PAYMNT09</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PAYMNT10</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RVLR03</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TPR101</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TRV01</ID><Value>0000000008</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TRV04</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TRV10</ID><Value>000000011</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TRV14</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT01S</ID><Value>0000000009</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT12Z</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT31S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT35B</ID><Value>0000000197</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT103S</ID><Value>0000000100</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AU21S</ID><Value>0000000065</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BC33Z</ID><Value>0000000394</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BC97A</ID><Value>0000001001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BC98A</ID><Value>0000015206</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BC102S</ID><Value>0000007800</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BC104S</ID><Value>0000000006</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BR21S</ID><Value>0000000156</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BR34S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BR36S</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>CO01S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>DM211</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>DM212</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>DM213</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>DM214</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>DM219</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>DM218</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>DM217</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>DM215</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>DM216</ID><Value>0000000149</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FC04Z</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI20S</ID><Value>0000000176</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI21S</ID><Value>0000000176</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FR21S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI35S</ID><Value>-000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G001S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G002S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G003S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G043R</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G061S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G066S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G093S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G094S</ID><Value>-000000004</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G100S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G215A</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G217S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G250C</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G256Z</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G257Z</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G258S</ID><Value>-000000004</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G259Z</ID><Value>-000000004</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G310S</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G960S</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G990S</ID><Value>0000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>ICO21</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IG096B</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN01S</ID><Value>0000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN24S</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN33Z</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN34S</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN36S</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>INAP01</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MT03S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MT33Z</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MT36Z</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MT37Z</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MT38Z</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MTAP01</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PB01S</ID><Value>0000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PB31S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE28S</ID><Value>0000015600</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE31S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE33Z</ID><Value>0000000394</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE34S</ID><Value>0000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE40S</ID><Value>0000000394</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RP04S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RT21S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RT101Z</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>S068A</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>S114S</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>S204S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>S207S</ID><Value>-000000004</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>SET1S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>ST36S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL01S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL02S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL03S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL06S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL09S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL12S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL20S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL21S</ID><Value>000000165</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL24S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL25S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL27S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL29S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL33S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL35S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL36S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL101S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>US06Z</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>US33Z</ID><Value>-000000003</Value></AccountNetCharacteristic></AccountNetCharacteristics></TU_FFR_Report><HTTPHeaders Status-Code=\\\"200 \\\" Keep-Alive=\\\"timeout=60 \\\" Status-Message=\\\"HTTP/1.1 200 \\\" Connection=\\\"keep-alive \\\" Pragma=\\\"no-cache \\\" Content-Length=\\\"42733 \\\" Date=\\\"Fri, 20 May 2022 12:09:56 GMT \\\" strict-transport-security=\\\"max-age=31536000; incl udeSubDomains \\\" Content-Type=\\\"text/xml \\\" Cache-control=\\\"no-cache, no-store \\\" /></REL4Report>\",\r\n"
				+ "        \"CreditPullDate\": \"2022-08-12T02:04:05.81\"\r\n"
				+ "    },\r\n"
				+ "    \"LoanApplication\": {\r\n"
				+ "        \"LoanType\": \"MPL\",\r\n"
				+ "        \"LoanPurpose\": null,\r\n"
				+ "        \"IsRental\": true,\r\n"
				+ "        \"RentalAmount\": 0.0,\r\n"
				+ "        \"NMMPastDueAccounts\": [],\r\n"
				+ "        \"LPPApplicable\": true,\r\n"
				+ "        \"IsFlinks\": false,\r\n"
				+ "        \"ApplicationType\": \"Refinance\",\r\n"
				+ "        \"CoolOffTillDate\": \"0001-01-01T00:00:00\",\r\n"
				+ "        \"ModelInput\": [],\r\n"
				+ "        \"SessionId\": \"2c734709-326f-4d30-ad3c-ec01d60388e4\",\r\n"
				+ "        \"SecuringType\": \"EFT\",\r\n"
				+ "        \"IsDownSellApplicable\": false,\r\n"
				+ "        \"DownSellLoanType\": \"SPL\",\r\n"
				+ "        \"ExceedsDQThreshold\": false\r\n"
				+ "    },\r\n"
				+ "    \"Fraud\": null,\r\n"
				+ "    \"ScheduleDates\": [\r\n"
				+ "        \"2022-09-20T00:00:00\"\r\n"
				+ "    ],\r\n"
				+ "    \"ApplicationSource\": {\r\n"
				+ "        \"ExternalLending\": {\r\n"
				+ "            \"IsExternalLending\": false,\r\n"
				+ "            \"ExternalLender\": null\r\n"
				+ "        },\r\n"
				+ "        \"ChannelType\": \"ONLINE\",\r\n"
				+ "        \"StoreNumber\": \"303\",\r\n"
				+ "        \"User\": \"123\",\r\n"
				+ "        \"UserName\": null,\r\n"
				+ "        \"FinancialPeriod\": \"2020-04-01T00:00:00\",\r\n"
				+ "        \"CallerDateTime\": \"2022-08-12T02:34:11.9121853-04:00\",\r\n"
				+ "        \"WorkStationId\": 0,\r\n"
				+ "        \"LocationId\": \"946\",\r\n"
				+ "        \"StateCode\": \"MB\",\r\n"
				+ "        \"CountryCode\": \"CAN\"\r\n"
				+ "    }\r\n"
				+ "}")
				
				.post("/CanadaWorkflow");
		 		*/
		String jsonString = response.asString();
		
		
		CustomerSegmentation = JsonPath.from(jsonString).get("OverallDecision[0].CustomerSegmentation");
		ApplicationType = JsonPath.from(jsonString).get("OverallDecision[0].ApplicationType");
		Decision = JsonPath.from(jsonString).get("OverallDecision[0].Decision");
		
		/* Commented on 16-Sept-2022 Start
		if(!Decision.equalsIgnoreCase("Denied"))
		{
		MaxAmount = JsonPath.from(jsonString).get("OverallDecision[0].TermInfoList[0].MaxLoanAmount");
		}
		Commented on 16-Sept-2022 End
		*/
		//String abc = JsonPath.from(jsonString).get("Model.Input.ILCustSegment"); Commented on 16-Sept-2022
				
		//Added on 28-May-2022 Start
		TestBase.logLoanDetails.add("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@RESPONSE VALIDATION FROM API@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		TestBase.logLoanDetails.add(CustomerSegmentation);
		TestBase.logLoanDetails.add(ApplicationType);
		TestBase.logLoanDetails.add(Decision);
		//TestBase.logLoanDetails.add(abc); Commented on 16-Sept-2022
		TestBase.logLoanDetails.add("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@RESPONSE VALIDATION FROM API@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		//Added on 28-May-2022 End

		//Added on 28-May-2022 Start
		UtilityMethods.PBufferWriter(TestBase.logLoanDetailsPath, TestBase.logLoanDetails);;
		TestBase.logLoanDetails.clear();
		//Added on 28-May-2022 End
				
		
		//Added on 28-May-2022 Start
		TestBase.logLoanDetails.add("######################RESPONSE FROM API START#############################");
		TestBase.logLoanDetails.add(jsonString);
		TestBase.logLoanDetails.add("######################RESPONSE FROM API END#############################");
		//Added on 28-May-2022 End

		//Added on 28-May-2022 Start
		UtilityMethods.PBufferWriter(TestBase.logLoanDetailsPath, TestBase.logLoanDetails);;
		TestBase.logLoanDetails.clear();
		//Added on 28-May-2022 End	
		
		System.out.println(CustomerSegmentation);
		System.out.println(ApplicationType);
		System.out.println(MaxAmount);
		System.out.println("DONE Proviner");
		System.out.println(jsonString);
		
		/*
		//Added on 28-May-2022 Start
		TestBase.logLoanDetails.add("###################################################");
		TestBase.logLoanDetails.add(jsonString);
		TestBase.logLoanDetails.add("###################################################");
		//Added on 28-May-2022 End

		//Added on 28-May-2022 Start
		UtilityMethods.PBufferWriter(TestBase.logLoanDetailsPath, TestBase.logLoanDetails);;
		TestBase.logLoanDetails.clear();
		//Added on 28-May-2022 End
		*/
		System.out.println("DONE Proviner");
	}
	
	
	
	//Added on 17-Sept-2022 Start
	public static void show_Request_For_Investigation() throws IOException, InterruptedException 
	{
		hooks.scenario.write("<span style='color:navy'>"+TestBase.sRequest+" : </span>");
		hooks.bindreport_API(TestBase.currentGlobalScenarioName, "<span style='color:navy'>"+TestBase.sRequest+"</span>");

	}
	
	public static void show_Response_For_Investigation() throws IOException, InterruptedException 
	{
		hooks.scenario.write("<span style='color:navy'>"+response.asPrettyString()+" : </span>");
		hooks.bindreport_API(TestBase.currentGlobalScenarioName, "<span style='color:navy'>"+response.asPrettyString()+"</span>");

	}
	//Added on 17-Sept-2022 End
	
	
	public static void toExecute_Proviner_Job_TOTEST_RESTASSURED() throws IOException, InterruptedException, JSONException 
	{
		RestAssured.baseURI = BASE_URL_Proviner;
		
		System.out.println(RestAssured.baseURI);
		
			
			/*
			//Added on 28-May-2022 Start
			TestBase.logLoanDetails.add("###################################################");
			TestBase.logLoanDetails.add(RestAssured.baseURI);
			TestBase.logLoanDetails.add("###################################################");
			//Added on 28-May-2022 End

			//Added on 28-May-2022 Start
			UtilityMethods.PBufferWriter(TestBase.logLoanDetailsPath, TestBase.logLoanDetails);;
			TestBase.logLoanDetails.clear();
			//Added on 28-May-2022 End
			*/
		logger.info("RestAssured.baseURI");		
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		//response = request.post(baseURI);
		
		/*
		Thread.sleep(5000);
		String sRequest = MsSqlUtility.getRequest(TestBase.getMapData.get("eMail"));
		System.out.println(sRequest);
		
		
		//Added on 28-May-2022 Start
		TestBase.logLoanDetails.add("######################REQUEST FROM DB START#############################");
		TestBase.logLoanDetails.add(sRequest);
		TestBase.logLoanDetails.add("######################REQUEST FROM DB END#############################");
		//Added on 28-May-2022 End

		//Added on 28-May-2022 Start
		UtilityMethods.PBufferWriter(TestBase.logLoanDetailsPath, TestBase.logLoanDetails);;
		TestBase.logLoanDetails.clear();
		//Added on 28-May-2022 End
		*/
		
		//response = request.body(sRequest)
		//.post("/CanadaWorkflow");
		
		
		response = request.body("{\r\n"
				+ "    \"Customer\": {\r\n"
				+ "        \"CustomerId\": \"4319341\",\r\n"
				+ "        \"FirstName\": \"DAVEULPKL\",\r\n"
				+ "        \"MiddleName\": \"\",\r\n"
				+ "        \"LastName\": \"SIMPSONULPKL\",\r\n"
				+ "        \"GovernmentNumber\": \"715258455\",\r\n"
				+ "        \"DateOfBirth\": \"1971-03-24T00:00:00\",\r\n"
				+ "        \"Email\": \"dave_ulpkl@yopmail.com\",\r\n"
				+ "        \"IsUnemployed\": null,\r\n"
				+ "        \"NMMEmployee\": false,\r\n"
				+ "        \"OccupationName\": \"\",\r\n"
				+ "        \"NoOfDependents\": 0,\r\n"
				+ "        \"MaritalStatus\": \"\",\r\n"
				+ "        \"SpouseEmployed\": null,\r\n"
				+ "        \"PriorMonthNetPay\": 0.0,\r\n"
				+ "        \"EmployerList\": [\r\n"
				+ "            {\r\n"
				+ "                \"CustomerEmployerId\": 10739710,\r\n"
				+ "                \"EmployerName\": \"BMW\",\r\n"
				+ "                \"CountryCode\": \"CAN\",\r\n"
				+ "                \"Phone\": \"9090919191\",\r\n"
				+ "                \"HireDate\": null,\r\n"
				+ "                \"PayPeriod\": \"MONTHLY\",\r\n"
				+ "                \"LastPayDate\": \"2022-07-20T00:00:00\",\r\n"
				+ "                \"NetPay\": 7200.0000,\r\n"
				+ "                \"GrossPay\": null,\r\n"
				+ "                \"DirectDeposit\": true,\r\n"
				+ "                \"PrimaryIncome\": true,\r\n"
				+ "                \"NextPayDate\": \"2022-08-20T00:00:00\",\r\n"
				+ "                \"SecondPayDate\": null,\r\n"
				+ "                \"EmploymentType\": \"WAGES\",\r\n"
				+ "                \"EmploymentStatus\": \"Full Time Employment\",\r\n"
				+ "                \"WeekNumber\": 0,\r\n"
				+ "                \"DayOfWeek\": 0,\r\n"
				+ "                \"DayOfMonth\": 20,\r\n"
				+ "                \"PayPeriodTypeName\": null,\r\n"
				+ "                \"LastDayOfMonth\": null\r\n"
				+ "            }\r\n"
				+ "        ],\r\n"
				+ "        \"PhoneList\": [],\r\n"
				+ "        \"Address\": {\r\n"
				+ "            \"Address1\": \"\",\r\n"
				+ "            \"Address2\": \"C-1330\",\r\n"
				+ "            \"Address3\": \"PRINCESS AVE\",\r\n"
				+ "            \"City\": \"BRANDON\",\r\n"
				+ "            \"State\": \"MB\",\r\n"
				+ "            \"PostalCode\": \"R7A0R5\",\r\n"
				+ "            \"CountryCode\": \"CAN\"\r\n"
				+ "        },\r\n"
				+ "        \"Expenditure\": {\r\n"
				+ "            \"MonthlyChildSupportExpense\": 0.0,\r\n"
				+ "            \"MonthlyAlimonyExpense\": 0.0,\r\n"
				+ "            \"MonthlyPayJudgementExpense\": 0.0,\r\n"
				+ "            \"OtherMonthlyAmount\": 0.0\r\n"
				+ "        }\r\n"
				+ "    },\r\n"
				+ "    \"LoanHistory\": [\r\n"
				+ "        {\r\n"
				+ "            \"LoanId\": 21495323,\r\n"
				+ "            \"LoanType\": \"MPL\",\r\n"
				+ "            \"LoanStatus\": \"Open\",\r\n"
				+ "            \"OriginationDate\": \"2022-03-04T01:59:09.51\",\r\n"
				+ "            \"PaidDate\": null,\r\n"
				+ "            \"Duedate\": \"2026-03-12T00:00:00\",\r\n"
				+ "            \"Principal\": 9000.0000,\r\n"
				+ "            \"Fee\": 0.0000\r\n"
				+ "        }\r\n"
				+ "    ],\r\n"
				+ "    \"CurrentInstallmentLoan\": {\r\n"
				+ "        \"LoanId\": 21495323,\r\n"
				+ "        \"OriginationDate\": \"2022-03-04T01:59:09.51\",\r\n"
				+ "        \"LoanStatus\": \"Open\",\r\n"
				+ "        \"Decile\": 1.0,\r\n"
				+ "        \"ModelScore\": 700.0,\r\n"
				+ "        \"CustomerSegmentation\": \"New\",\r\n"
				+ "        \"MaxPastDueDaysIn180Days\": 0,\r\n"
				+ "        \"IsEarlyAdvance\": false,\r\n"
				+ "        \"IsTopUp\": null,\r\n"
				+ "        \"IsRefinance\": false,\r\n"
				+ "        \"RefinanceCount\": 0,\r\n"
				+ "        \"EarlyAdvanceCount\": 0,\r\n"
				+ "        \"PastDueAmount\": 0.0,\r\n"
				+ "        \"LastPaymentDate\": \"2022-08-12T02:03:39.527\",\r\n"
				+ "        \"LastTwoPaymentMadeOnTime\": true,\r\n"
				+ "        \"OfferedLineAmount\": 15000.0000,\r\n"
				+ "        \"SPLOutstandingPastDueAmountIn12Months\": null,\r\n"
				+ "        \"PayOffAmount\": 8693.5000,\r\n"
				+ "        \"TopParentOriginationDate\": \"2022-03-08T00:00:00\",\r\n"
				+ "        \"FirstScheduledPaidDate\": \"2022-04-12T02:00:52.257\",\r\n"
				+ "        \"LoanAmount\": 9000.0000\r\n"
				+ "    },\r\n"
				+ "    \"TUCredit\": {\r\n"
				+ "        \"CreditData\": \"<REL4Report><UserReference>UAT Example</UserReference><MemberCode>975ZZ42052</MemberCode><Date>20220520</Date><Time>080956</Time><Product>07000</Product><TU_FFR_Report><Hit>Y</Hit><OnFileDate>20180308</OnFileDate><Names><Name NameType=\\\"Primary \\\"><LastName>MSAPOSTROPHY</LastName><FirstName>STREET</FirstName><MiddleName>TOB</MiddleName></Name></Names><PersonalInformation><SIN>000000000</SIN><DOB>19780805</DOB></PersonalInformation><Addresses><Address AddrType=\\\"Personal \\\"><Street>276 O?CONNOR</Street><City>OTTAWA</City><Prov>ON</Prov><Postal>K2P1V3</Postal><DateReported>20170106</DateReported></Address><Address AddrType=\\\"Personal \\\"><Street>1669 OAKLAND AVE</Street><City>BRANDON</City><Prov>MB</Prov><Postal>R3A1S8</Postal><DateReported>19890801</DateReported></Address></Addresses><Telephones><Telephone PhoneType=\\\"Personal \\\"><Number>6137821112</Number></Telephone></Telephones><Collections><Collection><MemberName>FAMILY RES. OFF.</MemberName><Account>07080708615</Account><Creditor>TU TEST</Creditor><DateReported>20170120</DateReported><DateVerified>20220501</DateVerified><DatePaidOut>20170721</DatePaidOut><Narrative>FA</Narrative><CurrentBalance>0</CurrentBalance><OriginalAmount>1800</OriginalAmount><Remarks>PD</Remarks></Collection></Collections><Trades><Trade><MemberCode>QC</MemberCode><MemberName>NANAIMO CREDIT UNION</MemberName><Type>R</Type><Account>000001772</Account><Joint>I</Joint><DateOpened>20190112</DateOpened><DateRevised>20220107</DateRevised><DateLastActivity>20220117</DateLastActivity><MOP>01</MOP><Balance>394</Balance><HighCredit>3500</HighCredit><CreditLimit>0</CreditLimit><Frequency>M</Frequency><Payment>10</Payment><Narrative1>HC</Narrative1><PastDue>0</PastDue><PaymentPatternStartDate>20220103</PaymentPatternStartDate><PaymentPattern>1111111111111111111111111111111111111</PaymentPattern><MonthsReviewed>37</MonthsReviewed><Plus30>0</Plus30><Plus60>0</Plus60><Plus90>0</Plus90></Trade><Trade><MemberCode>BC</MemberCode><MemberName>NATIONAL BANK MASTERCARD</MemberName><Type>R</Type><Account>000002315</Account><Joint>I</Joint><DateOpened>20090513</DateOpened><DateRevised>20220104</DateRevised><DateLastActivity>20181028</DateLastActivity><MOP>01</MOP><Balance>0</Balance><HighCredit>12100</HighCredit><CreditLimit>0</CreditLimit><Frequency>M</Frequency><Payment>0</Payment><Narrative1>HC</Narrative1><PastDue>0</PastDue><PaymentPatternStartDate>20220114</PaymentPatternStartDate><PaymentPattern>111111111111111XXXXXXXXXXXXXXXXXXXXXXX11X1111111</PaymentPattern><MonthsReviewed>63</MonthsReviewed><Plus30>0</Plus30><Plus60>0</Plus60><Plus90>0</Plus90></Trade><Trade><MemberCode>AZ</MemberCode><MemberName>DRIVE CREDIT CANADA</MemberName><Type>I</Type><Account>000000000023</Account><Joint>I</Joint><DateOpened>20161213</DateOpened><DateRevised>20201113</DateRevised><DateLastActivity>20201024</DateLastActivity><MOP>01</MOP><Balance>10394</Balance><HighCredit>25961</HighCredit><CreditLimit>0</CreditLimit><Frequency>M</Frequency><Payment>635</Payment><PastDue>0</PastDue><PaymentPatternStartDate>20201028</PaymentPatternStartDate><PaymentPattern>11111111111111111111111111111111111111111111111</PaymentPattern><MonthsReviewed>47</MonthsReviewed><Plus30>0</Plus30><Plus60>0</Plus60><Plus90>0</Plus90></Trade><Trade><MemberCode>BB</MemberCode><MemberName>NS BANK EXETER 26007</MemberName><Type>I</Type><Account>OP-099000000000023</Account><Joint>I</Joint><DateOpened>20160516</DateOpened><DateRevised>20200205</DateRevised><DateLastActivity>20200120</DateLastActivity><MOP>01</MOP><Balance>0</Balance><HighCredit>17000</HighCredit><CreditLimit>0</CreditLimit><Frequency>M</Frequency><Payment>0</Payment><Narrative1>PD</Narrative1><PastDue>0</PastDue><PaymentPatternStartDate>20200128</PaymentPatternStartDate><PaymentPattern>11111111111111111111111111111111111111111111</PaymentPattern><MonthsReviewed>44</MonthsReviewed><Plus30>0</Plus30><Plus60>0</Plus60><Plus90>0</Plus90></Trade><Trade><MemberCode>BC</MemberCode><MemberName>CAPITAL ONE BANK</MemberName><Type>R</Type><Account>000002912</Account><Joint>I</Joint><DateOpened>20090513</DateOpened><DateRevised>20171111</DateRevised><DateLastActivity>20171101</DateLastActivity><MOP>01</MOP><Balance>0</Balance><HighCredit>12100</HighCredit><CreditLimit>0</CreditLimit><Frequency>M</Frequency><Payment>10</Payment><Narrative1>CL</Narrative1><Narrative2>HC</Narrative2><PastDue>0</PastDue><PaymentPatternStartDate>20171110</PaymentPatternStartDate><PaymentPattern>111X1111111111XX1111111111XXX1111111XXXXXXX11111</PaymentPattern><MonthsReviewed>99</MonthsReviewed><Plus30>0</Plus30><Plus60>0</Plus60><Plus90>0</Plus90></Trade><Trade><MemberCode>QC</MemberCode><MemberName>METRO CREDIT UNION</MemberName><Type>R</Type><Account>000004300</Account><Joint>C</Joint><DateOpened>20110301</DateOpened><DateRevised>20140428</DateRevised><DateLastActivity>20120401</DateLastActivity><MOP>01</MOP><Balance>0</Balance><HighCredit>0</HighCredit><CreditLimit>5000</CreditLimit><Frequency>M</Frequency><Payment>0</Payment><Narrative1>CZ</Narrative1><PastDue>0</PastDue><PaymentPatternStartDate>20140428</PaymentPatternStartDate><PaymentPattern>11111111111111111111111111111111111111</PaymentPattern><MonthsReviewed>38</MonthsReviewed><Plus30>0</Plus30><Plus60>0</Plus60><Plus90>0</Plus90></Trade><Trade><MemberCode>QA</MemberCode><MemberName>CAN-AUTO</MemberName><Type>I</Type><Account>000006602</Account><Joint>I</Joint><DateOpened>20070901</DateOpened><DateRevised>20111002</DateRevised><DateLastActivity>20111001</DateLastActivity><MOP>01</MOP><Balance>0</Balance><HighCredit>18208</HighCredit><CreditLimit>0</CreditLimit><Frequency>M</Frequency><Payment>0</Payment><Narrative1>PD</Narrative1><PastDue>0</PastDue><PaymentPatternStartDate>20111002</PaymentPatternStartDate><PaymentPattern>111111111111111111111111111111111111111111111111</PaymentPattern><MonthsReviewed>51</MonthsReviewed><Plus30>0</Plus30><Plus60>0</Plus60><Plus90>0</Plus90></Trade><Trade><MemberCode>BC</MemberCode><MemberName>LATITUDE BNC</MemberName><Type>R</Type><Account>000006592</Account><Joint>I</Joint><DateOpened>19850701</DateOpened><DateRevised>20101126</DateRevised><DateLastActivity>20101001</DateLastActivity><MOP>01</MOP><Balance>0</Balance><HighCredit>11000</HighCredit><CreditLimit>0</CreditLimit><Frequency>M</Frequency><Payment>0</Payment><Narrative1>CZ</Narrative1><Narrative2>HC</Narrative2><PastDue>0</PastDue><PaymentPatternStartDate>20101126</PaymentPatternStartDate><PaymentPattern>1111111111111111111111111111111111X1111111111111</PaymentPattern><MonthsReviewed>99</MonthsReviewed><Plus30>0</Plus30><Plus60>0</Plus60><Plus90>0</Plus90></Trade><Trade><MemberCode>BB</MemberCode><MemberName>TD BK KING ST KITCHENER</MemberName><Type>R</Type><Account>000000000023</Account><Joint>I</Joint><DateOpened>20060201</DateOpened><DateRevised>20100201</DateRevised><DateLastActivity>20100201</DateLastActivity><MOP>01</MOP><Balance>0</Balance><HighCredit>10000</HighCredit><CreditLimit>0</CreditLimit><Frequency>M</Frequency><Payment>178</Payment><Narrative1>AC</Narrative1><Narrative2>HC</Narrative2><PastDue>0</PastDue><PaymentPatternStartDate>20100201</PaymentPatternStartDate><PaymentPattern>1111111111111111111111111111111111111111111111</PaymentPattern><MonthsReviewed>46</MonthsReviewed><Plus30>0</Plus30><Plus60>0</Plus60><Plus90>0</Plus90></Trade></Trades><Inquiries><Inquiry><MemberCode>BB00078746</MemberCode><MemberName>BK MONTREAL NIAGARA ST W</MemberName><Date>20090511</Date></Inquiry></Inquiries><ScoreProducts><ScoreProduct><Product>A1948</Product></ScoreProduct><ScoreProduct><Product>C1805</Product></ScoreProduct><ScoreProduct><Product>C1950</Product></ScoreProduct><ScoreProduct><Product>00002</Product><Score>700</Score><ScoreDerogatoryAlert>A</ScoreDerogatoryAlert><Factor1>40</Factor1><Factor2>27</Factor2><Factor3>0</Factor3><Factor4>0</Factor4><ScoreCard>00</ScoreCard></ScoreProduct></ScoreProducts><AccountNetCharacteristics><AccountNetCharacteristic><ID>GO146</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO145</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO143</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO149</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO148</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO147</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT93</ID><Value>0000000156</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT92</ID><Value>0000000131</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT95</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT94</ID><Value>0000030773</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT179</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO141</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT91</ID><Value>0000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT186</ID><Value>0000000394</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AI60</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT96</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT185</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT98</ID><Value>0000030773</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT99</ID><Value>0000010788</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MS154</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT180</ID><Value>0000000010</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO155</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE260</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO154</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BR155</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO157</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO156</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO158</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO151</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO150</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO153</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO152</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT199</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT198</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT197</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT196</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT195</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MC34</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT193</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT192</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BR147</ID><Value>0000000011</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR88</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AM62</ID><Value>0000003500</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AM61</ID><Value>0000000394</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI85</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT161</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MC01</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT160</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT163</ID><Value>0000003500</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT162</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT165</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT164</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT167</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT166</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR91</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR92</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR95</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MC04</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MC03</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MC02</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO81</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AM155</ID><Value>-000000095</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO80</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO83</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT168</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT169</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO89</ID><Value>K2P1V3</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT174</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PF01</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT178</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT177</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT176</ID><Value>0000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT175</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PF08</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT170</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PF03</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO13</ID><Value>0000000004</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO14</ID><Value>0000000309</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT139</ID><Value>0000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO11</ID><Value>0000000100</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO12</ID><Value>0000000148</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO17</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO18</ID><Value>Y</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO16</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR68</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR73</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN155</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN153</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT57</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT142</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO19</ID><Value>Y</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT145</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>OF34</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT140</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT141</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT61</ID><Value>0000000394</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BR24</ID><Value>0000000006</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO22</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT62</ID><Value>0000003500</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BR25</ID><Value>0000000006</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO23</ID><Value>0019850701</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO24</ID><Value>0020220117</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT60</ID><Value>0000000010</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO25</ID><Value>0020090511</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT149</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT148</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT147</ID><Value>0000000099</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO28</ID><Value>0000000004</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO29</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR75</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO116</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO20</ID><Value>Y</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR78</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO21</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MC154</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>OF20</ID><Value>0000000264</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PF29</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR80</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT155</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BI36</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT153</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT154</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT151</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT152</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PF21</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PF20</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT150</ID><Value>0000000394</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN04</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO33</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AM25</ID><Value>0000000021</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO31</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR42</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN02</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO30</ID><Value>0000000525</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR43</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR51</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO129</ID><Value>0020220520</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT77</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PF34</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT76</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT79</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT127</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT80</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FR21</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT83</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FR20</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT84</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT82</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO136</ID><Value>0000000009</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO137</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO132</ID><Value>0000000064</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO134</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AM18</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT88</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT87</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT86</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT85</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT133</ID><Value>0000000009</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT89</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT132</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT20</ID><Value>0000000442</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT100</ID><Value>0000000004</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT21</ID><Value>0000000004</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT22</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT23</ID><Value>0000000009</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT24</ID><Value>0000000009</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT25</ID><Value>0000000009</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT26</ID><Value>0000000009</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT27</ID><Value>0000000009</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT28</ID><Value>0000015600</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT29</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI27</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI20</ID><Value>0000000176</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI21</ID><Value>0000000176</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI23</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI24</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI25</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI26</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT10</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT11</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT14</ID><Value>0000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT15</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT12</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR119</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT13</ID><Value>0000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT18</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT19</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT106</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI33</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI36</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN28</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT103</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT104</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI34</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT105</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI35</ID><Value>0000000963</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BR98</ID><Value>0000015206</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT42</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT43</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FR01</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FR03</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN35</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI01</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI02</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT40</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI03</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE03</ID><Value>0000000006</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT36</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BR84</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT37</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BR85</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT34</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE94</ID><Value>0000015206</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT35</ID><Value>0000006393</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT33</ID><Value>0000000394</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT30</ID><Value>0000000007</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT38</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT39</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO07</ID><Value>0000000004</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO06</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO04</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO03</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO01</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR12</ID><Value>0000000064</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT335</ID><Value>0000000087</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BC155</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR11</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI153</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR10</ID><Value>0000001800</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE21</ID><Value>0000000040</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE23</ID><Value>0000000006</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE24</ID><Value>0000000006</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN59</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE25</ID><Value>0000000006</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE26</ID><Value>0000000006</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE27</ID><Value>0000000006</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT200</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PF153</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT201</ID><Value>0000000176</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR09</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR02</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI145</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO96</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN68</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN62</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BI85</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BI84</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT06</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT05</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT07</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT02</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT01</ID><Value>0000000009</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT03</ID><Value>0000000009</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR38</ID><Value>0020170120</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AM79</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR41</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AM75</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN77</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RR35</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AM86</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN85</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AGG302</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AGG801</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AGG910</ID><Value>83.92</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PAYMNT11</ID><Value>0000000032</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TPR201</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AGG901</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AGG911</ID><Value>2.53</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BALMAG01</ID><Value>0000000118</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BALMAG02</ID><Value>0000009992</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PAYMNT02</ID><Value>000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PAYMNT04</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PAYMNT05</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PAYMNT06</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PAYMNT08</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PAYMNT09</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PAYMNT10</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RVLR03</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TPR101</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TRV01</ID><Value>0000000008</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TRV04</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TRV10</ID><Value>000000011</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TRV14</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT01S</ID><Value>0000000009</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT12Z</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT31S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT35B</ID><Value>0000000197</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT103S</ID><Value>0000000100</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AU21S</ID><Value>0000000065</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BC33Z</ID><Value>0000000394</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BC97A</ID><Value>0000001001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BC98A</ID><Value>0000015206</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BC102S</ID><Value>0000007800</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BC104S</ID><Value>0000000006</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BR21S</ID><Value>0000000156</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BR34S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BR36S</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>CO01S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>DM211</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>DM212</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>DM213</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>DM214</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>DM219</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>DM218</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>DM217</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>DM215</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>DM216</ID><Value>0000000149</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FC04Z</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI20S</ID><Value>0000000176</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI21S</ID><Value>0000000176</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FR21S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI35S</ID><Value>-000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G001S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G002S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G003S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G043R</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G061S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G066S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G093S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G094S</ID><Value>-000000004</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G100S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G215A</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G217S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G250C</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G256Z</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G257Z</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G258S</ID><Value>-000000004</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G259Z</ID><Value>-000000004</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G310S</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G960S</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G990S</ID><Value>0000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>ICO21</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IG096B</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN01S</ID><Value>0000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN24S</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN33Z</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN34S</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN36S</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>INAP01</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MT03S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MT33Z</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MT36Z</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MT37Z</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MT38Z</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MTAP01</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PB01S</ID><Value>0000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PB31S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE28S</ID><Value>0000015600</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE31S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE33Z</ID><Value>0000000394</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE34S</ID><Value>0000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE40S</ID><Value>0000000394</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RP04S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RT21S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RT101Z</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>S068A</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>S114S</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>S204S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>S207S</ID><Value>-000000004</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>SET1S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>ST36S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL01S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL02S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL03S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL06S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL09S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL12S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL20S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL21S</ID><Value>000000165</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL24S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL25S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL27S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL29S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL33S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL35S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL36S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL101S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>US06Z</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>US33Z</ID><Value>-000000003</Value></AccountNetCharacteristic></AccountNetCharacteristics></TU_FFR_Report><HTTPHeaders Status-Code=\\\"200 \\\" Keep-Alive=\\\"timeout=60 \\\" Status-Message=\\\"HTTP/1.1 200 \\\" Connection=\\\"keep-alive \\\" Pragma=\\\"no-cache \\\" Content-Length=\\\"42733 \\\" Date=\\\"Fri, 20 May 2022 12:09:56 GMT \\\" strict-transport-security=\\\"max-age=31536000; incl udeSubDomains \\\" Content-Type=\\\"text/xml \\\" Cache-control=\\\"no-cache, no-store \\\" /></REL4Report>\",\r\n"
				+ "        \"CreditPullDate\": \"2022-08-12T02:04:05.81\"\r\n"
				+ "    },\r\n"
				+ "    \"LoanApplication\": {\r\n"
				+ "        \"LoanType\": \"MPL\",\r\n"
				+ "        \"LoanPurpose\": null,\r\n"
				+ "        \"IsRental\": true,\r\n"
				+ "        \"RentalAmount\": 0.0,\r\n"
				+ "        \"NMMPastDueAccounts\": [],\r\n"
				+ "        \"LPPApplicable\": true,\r\n"
				+ "        \"IsFlinks\": false,\r\n"
				+ "        \"ApplicationType\": \"Refinance\",\r\n"
				+ "        \"CoolOffTillDate\": \"0001-01-01T00:00:00\",\r\n"
				+ "        \"ModelInput\": [],\r\n"
				+ "        \"SessionId\": \"2c734709-326f-4d30-ad3c-ec01d60388e4\",\r\n"
				+ "        \"SecuringType\": \"EFT\",\r\n"
				+ "        \"IsDownSellApplicable\": false,\r\n"
				+ "        \"DownSellLoanType\": \"SPL\",\r\n"
				+ "        \"ExceedsDQThreshold\": false\r\n"
				+ "    },\r\n"
				+ "    \"Fraud\": null,\r\n"
				+ "    \"ScheduleDates\": [\r\n"
				+ "        \"2022-09-20T00:00:00\"\r\n"
				+ "    ],\r\n"
				+ "    \"ApplicationSource\": {\r\n"
				+ "        \"ExternalLending\": {\r\n"
				+ "            \"IsExternalLending\": false,\r\n"
				+ "            \"ExternalLender\": null\r\n"
				+ "        },\r\n"
				+ "        \"ChannelType\": \"ONLINE\",\r\n"
				+ "        \"StoreNumber\": \"303\",\r\n"
				+ "        \"User\": \"123\",\r\n"
				+ "        \"UserName\": null,\r\n"
				+ "        \"FinancialPeriod\": \"2020-04-01T00:00:00\",\r\n"
				+ "        \"CallerDateTime\": \"2022-08-12T02:34:11.9121853-04:00\",\r\n"
				+ "        \"WorkStationId\": 0,\r\n"
				+ "        \"LocationId\": \"946\",\r\n"
				+ "        \"StateCode\": \"MB\",\r\n"
				+ "        \"CountryCode\": \"CAN\"\r\n"
				+ "    }\r\n"
				+ "}")
				
				.post("/CanadaWorkflow");
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$  PROVINER $$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println(response.asString());
		
		JSONObject responseObj = new JSONObject(response.asString());
		
		JSONArray OverallDecisionArray =  responseObj.getJSONArray("OverallDecision");
		
		System.out.println(OverallDecisionArray);
		
		
		//CreditDecision
		for(int i=0;i < OverallDecisionArray.length();i++)
		{
			JSONObject OverallDecisionObject = OverallDecisionArray.getJSONObject(i);
			
			String CreditDecision = OverallDecisionObject.getString("CreditDecision");
			System.out.println(CreditDecision);
		}
		
		
		/*
		String jsonString = response.asString();
		
		
		CustomerSegmentation = JsonPath.from(jsonString).get("OverallDecision[0].CustomerSegmentation");
		ApplicationType = JsonPath.from(jsonString).get("OverallDecision[0].ApplicationType");
		MaxAmount = JsonPath.from(jsonString).get("OverallDecision[0].TermInfoList[0].MaxLoanAmount");
		
		
		String abc = JsonPath.from(jsonString).get("Model.Input.ILCustSegment");
		List<String> b = JsonPath.from(jsonString).get("OverallDecision[0].TermInfoList");
		LinkedHashMap<String, Integer> a = JsonPath.from(jsonString).get("OverallDecision[0].TermInfoList[0]");
		*/
		
		/*
		//Added on 28-May-2022 Start
		TestBase.logLoanDetails.add("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@RESPONSE VALIDATION FROM API@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		TestBase.logLoanDetails.add(CustomerSegmentation);
		TestBase.logLoanDetails.add(ApplicationType);
		TestBase.logLoanDetails.add(abc);
		TestBase.logLoanDetails.add("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@RESPONSE VALIDATION FROM API@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		//Added on 28-May-2022 End

		//Added on 28-May-2022 Start
		UtilityMethods.PBufferWriter(TestBase.logLoanDetailsPath, TestBase.logLoanDetails);;
		TestBase.logLoanDetails.clear();
		//Added on 28-May-2022 End
				
		
		//Added on 28-May-2022 Start
		TestBase.logLoanDetails.add("######################RESPONSE FROM API START#############################");
		TestBase.logLoanDetails.add(jsonString);
		TestBase.logLoanDetails.add("######################RESPONSE FROM API END#############################");
		//Added on 28-May-2022 End

		//Added on 28-May-2022 Start
		UtilityMethods.PBufferWriter(TestBase.logLoanDetailsPath, TestBase.logLoanDetails);;
		TestBase.logLoanDetails.clear();
		//Added on 28-May-2022 End	
		
		System.out.println(CustomerSegmentation);
		System.out.println(ApplicationType);
		System.out.println(MaxAmount);
		System.out.println(abc);
		System.out.println(b);
		System.out.println(b.size());
		
		System.out.println(a.size());
		System.out.println("LinkedHashMap1: " + a);
		System.out.println("LinkedHashMap1: " + a.get("MaxLoanAmount"));
		System.out.println("DONE Proviner");
		System.out.println(jsonString);
		*/
		/*
		//Added on 28-May-2022 Start
		TestBase.logLoanDetails.add("###################################################");
		TestBase.logLoanDetails.add(jsonString);
		TestBase.logLoanDetails.add("###################################################");
		//Added on 28-May-2022 End

		//Added on 28-May-2022 Start
		UtilityMethods.PBufferWriter(TestBase.logLoanDetailsPath, TestBase.logLoanDetails);;
		TestBase.logLoanDetails.clear();
		//Added on 28-May-2022 End
		*/
		System.out.println("DONE Proviner");
	}
	
	
	public static String toExecute_Proviner_Job_toGet_OverallDecision(String fetchNodeDetail) throws IOException, InterruptedException, JSONException 
	{
		RestAssured.baseURI = BASE_URL_Proviner;
		System.out.println(RestAssured.baseURI);
		logger.info("RestAssured.baseURI");		
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		response = request.body("{\r\n"
				+ "    \"Customer\": {\r\n"
				+ "        \"CustomerId\": \"4319341\",\r\n"
				+ "        \"FirstName\": \"DAVEULPKL\",\r\n"
				+ "        \"MiddleName\": \"\",\r\n"
				+ "        \"LastName\": \"SIMPSONULPKL\",\r\n"
				+ "        \"GovernmentNumber\": \"715258455\",\r\n"
				+ "        \"DateOfBirth\": \"1971-03-24T00:00:00\",\r\n"
				+ "        \"Email\": \"dave_ulpkl@yopmail.com\",\r\n"
				+ "        \"IsUnemployed\": null,\r\n"
				+ "        \"NMMEmployee\": false,\r\n"
				+ "        \"OccupationName\": \"\",\r\n"
				+ "        \"NoOfDependents\": 0,\r\n"
				+ "        \"MaritalStatus\": \"\",\r\n"
				+ "        \"SpouseEmployed\": null,\r\n"
				+ "        \"PriorMonthNetPay\": 0.0,\r\n"
				+ "        \"EmployerList\": [\r\n"
				+ "            {\r\n"
				+ "                \"CustomerEmployerId\": 10739710,\r\n"
				+ "                \"EmployerName\": \"BMW\",\r\n"
				+ "                \"CountryCode\": \"CAN\",\r\n"
				+ "                \"Phone\": \"9090919191\",\r\n"
				+ "                \"HireDate\": null,\r\n"
				+ "                \"PayPeriod\": \"MONTHLY\",\r\n"
				+ "                \"LastPayDate\": \"2022-07-20T00:00:00\",\r\n"
				+ "                \"NetPay\": 7200.0000,\r\n"
				+ "                \"GrossPay\": null,\r\n"
				+ "                \"DirectDeposit\": true,\r\n"
				+ "                \"PrimaryIncome\": true,\r\n"
				+ "                \"NextPayDate\": \"2022-08-20T00:00:00\",\r\n"
				+ "                \"SecondPayDate\": null,\r\n"
				+ "                \"EmploymentType\": \"WAGES\",\r\n"
				+ "                \"EmploymentStatus\": \"Full Time Employment\",\r\n"
				+ "                \"WeekNumber\": 0,\r\n"
				+ "                \"DayOfWeek\": 0,\r\n"
				+ "                \"DayOfMonth\": 20,\r\n"
				+ "                \"PayPeriodTypeName\": null,\r\n"
				+ "                \"LastDayOfMonth\": null\r\n"
				+ "            }\r\n"
				+ "        ],\r\n"
				+ "        \"PhoneList\": [],\r\n"
				+ "        \"Address\": {\r\n"
				+ "            \"Address1\": \"\",\r\n"
				+ "            \"Address2\": \"C-1330\",\r\n"
				+ "            \"Address3\": \"PRINCESS AVE\",\r\n"
				+ "            \"City\": \"BRANDON\",\r\n"
				+ "            \"State\": \"MB\",\r\n"
				+ "            \"PostalCode\": \"R7A0R5\",\r\n"
				+ "            \"CountryCode\": \"CAN\"\r\n"
				+ "        },\r\n"
				+ "        \"Expenditure\": {\r\n"
				+ "            \"MonthlyChildSupportExpense\": 0.0,\r\n"
				+ "            \"MonthlyAlimonyExpense\": 0.0,\r\n"
				+ "            \"MonthlyPayJudgementExpense\": 0.0,\r\n"
				+ "            \"OtherMonthlyAmount\": 0.0\r\n"
				+ "        }\r\n"
				+ "    },\r\n"
				+ "    \"LoanHistory\": [\r\n"
				+ "        {\r\n"
				+ "            \"LoanId\": 21495323,\r\n"
				+ "            \"LoanType\": \"MPL\",\r\n"
				+ "            \"LoanStatus\": \"Open\",\r\n"
				+ "            \"OriginationDate\": \"2022-03-04T01:59:09.51\",\r\n"
				+ "            \"PaidDate\": null,\r\n"
				+ "            \"Duedate\": \"2026-03-12T00:00:00\",\r\n"
				+ "            \"Principal\": 9000.0000,\r\n"
				+ "            \"Fee\": 0.0000\r\n"
				+ "        }\r\n"
				+ "    ],\r\n"
				+ "    \"CurrentInstallmentLoan\": {\r\n"
				+ "        \"LoanId\": 21495323,\r\n"
				+ "        \"OriginationDate\": \"2022-03-04T01:59:09.51\",\r\n"
				+ "        \"LoanStatus\": \"Open\",\r\n"
				+ "        \"Decile\": 1.0,\r\n"
				+ "        \"ModelScore\": 700.0,\r\n"
				+ "        \"CustomerSegmentation\": \"New\",\r\n"
				+ "        \"MaxPastDueDaysIn180Days\": 0,\r\n"
				+ "        \"IsEarlyAdvance\": false,\r\n"
				+ "        \"IsTopUp\": null,\r\n"
				+ "        \"IsRefinance\": false,\r\n"
				+ "        \"RefinanceCount\": 0,\r\n"
				+ "        \"EarlyAdvanceCount\": 0,\r\n"
				+ "        \"PastDueAmount\": 0.0,\r\n"
				+ "        \"LastPaymentDate\": \"2022-08-12T02:03:39.527\",\r\n"
				+ "        \"LastTwoPaymentMadeOnTime\": true,\r\n"
				+ "        \"OfferedLineAmount\": 15000.0000,\r\n"
				+ "        \"SPLOutstandingPastDueAmountIn12Months\": null,\r\n"
				+ "        \"PayOffAmount\": 8693.5000,\r\n"
				+ "        \"TopParentOriginationDate\": \"2022-03-08T00:00:00\",\r\n"
				+ "        \"FirstScheduledPaidDate\": \"2022-04-12T02:00:52.257\",\r\n"
				+ "        \"LoanAmount\": 9000.0000\r\n"
				+ "    },\r\n"
				+ "    \"TUCredit\": {\r\n"
				+ "        \"CreditData\": \"<REL4Report><UserReference>UAT Example</UserReference><MemberCode>975ZZ42052</MemberCode><Date>20220520</Date><Time>080956</Time><Product>07000</Product><TU_FFR_Report><Hit>Y</Hit><OnFileDate>20180308</OnFileDate><Names><Name NameType=\\\"Primary \\\"><LastName>MSAPOSTROPHY</LastName><FirstName>STREET</FirstName><MiddleName>TOB</MiddleName></Name></Names><PersonalInformation><SIN>000000000</SIN><DOB>19780805</DOB></PersonalInformation><Addresses><Address AddrType=\\\"Personal \\\"><Street>276 O?CONNOR</Street><City>OTTAWA</City><Prov>ON</Prov><Postal>K2P1V3</Postal><DateReported>20170106</DateReported></Address><Address AddrType=\\\"Personal \\\"><Street>1669 OAKLAND AVE</Street><City>BRANDON</City><Prov>MB</Prov><Postal>R3A1S8</Postal><DateReported>19890801</DateReported></Address></Addresses><Telephones><Telephone PhoneType=\\\"Personal \\\"><Number>6137821112</Number></Telephone></Telephones><Collections><Collection><MemberName>FAMILY RES. OFF.</MemberName><Account>07080708615</Account><Creditor>TU TEST</Creditor><DateReported>20170120</DateReported><DateVerified>20220501</DateVerified><DatePaidOut>20170721</DatePaidOut><Narrative>FA</Narrative><CurrentBalance>0</CurrentBalance><OriginalAmount>1800</OriginalAmount><Remarks>PD</Remarks></Collection></Collections><Trades><Trade><MemberCode>QC</MemberCode><MemberName>NANAIMO CREDIT UNION</MemberName><Type>R</Type><Account>000001772</Account><Joint>I</Joint><DateOpened>20190112</DateOpened><DateRevised>20220107</DateRevised><DateLastActivity>20220117</DateLastActivity><MOP>01</MOP><Balance>394</Balance><HighCredit>3500</HighCredit><CreditLimit>0</CreditLimit><Frequency>M</Frequency><Payment>10</Payment><Narrative1>HC</Narrative1><PastDue>0</PastDue><PaymentPatternStartDate>20220103</PaymentPatternStartDate><PaymentPattern>1111111111111111111111111111111111111</PaymentPattern><MonthsReviewed>37</MonthsReviewed><Plus30>0</Plus30><Plus60>0</Plus60><Plus90>0</Plus90></Trade><Trade><MemberCode>BC</MemberCode><MemberName>NATIONAL BANK MASTERCARD</MemberName><Type>R</Type><Account>000002315</Account><Joint>I</Joint><DateOpened>20090513</DateOpened><DateRevised>20220104</DateRevised><DateLastActivity>20181028</DateLastActivity><MOP>01</MOP><Balance>0</Balance><HighCredit>12100</HighCredit><CreditLimit>0</CreditLimit><Frequency>M</Frequency><Payment>0</Payment><Narrative1>HC</Narrative1><PastDue>0</PastDue><PaymentPatternStartDate>20220114</PaymentPatternStartDate><PaymentPattern>111111111111111XXXXXXXXXXXXXXXXXXXXXXX11X1111111</PaymentPattern><MonthsReviewed>63</MonthsReviewed><Plus30>0</Plus30><Plus60>0</Plus60><Plus90>0</Plus90></Trade><Trade><MemberCode>AZ</MemberCode><MemberName>DRIVE CREDIT CANADA</MemberName><Type>I</Type><Account>000000000023</Account><Joint>I</Joint><DateOpened>20161213</DateOpened><DateRevised>20201113</DateRevised><DateLastActivity>20201024</DateLastActivity><MOP>01</MOP><Balance>10394</Balance><HighCredit>25961</HighCredit><CreditLimit>0</CreditLimit><Frequency>M</Frequency><Payment>635</Payment><PastDue>0</PastDue><PaymentPatternStartDate>20201028</PaymentPatternStartDate><PaymentPattern>11111111111111111111111111111111111111111111111</PaymentPattern><MonthsReviewed>47</MonthsReviewed><Plus30>0</Plus30><Plus60>0</Plus60><Plus90>0</Plus90></Trade><Trade><MemberCode>BB</MemberCode><MemberName>NS BANK EXETER 26007</MemberName><Type>I</Type><Account>OP-099000000000023</Account><Joint>I</Joint><DateOpened>20160516</DateOpened><DateRevised>20200205</DateRevised><DateLastActivity>20200120</DateLastActivity><MOP>01</MOP><Balance>0</Balance><HighCredit>17000</HighCredit><CreditLimit>0</CreditLimit><Frequency>M</Frequency><Payment>0</Payment><Narrative1>PD</Narrative1><PastDue>0</PastDue><PaymentPatternStartDate>20200128</PaymentPatternStartDate><PaymentPattern>11111111111111111111111111111111111111111111</PaymentPattern><MonthsReviewed>44</MonthsReviewed><Plus30>0</Plus30><Plus60>0</Plus60><Plus90>0</Plus90></Trade><Trade><MemberCode>BC</MemberCode><MemberName>CAPITAL ONE BANK</MemberName><Type>R</Type><Account>000002912</Account><Joint>I</Joint><DateOpened>20090513</DateOpened><DateRevised>20171111</DateRevised><DateLastActivity>20171101</DateLastActivity><MOP>01</MOP><Balance>0</Balance><HighCredit>12100</HighCredit><CreditLimit>0</CreditLimit><Frequency>M</Frequency><Payment>10</Payment><Narrative1>CL</Narrative1><Narrative2>HC</Narrative2><PastDue>0</PastDue><PaymentPatternStartDate>20171110</PaymentPatternStartDate><PaymentPattern>111X1111111111XX1111111111XXX1111111XXXXXXX11111</PaymentPattern><MonthsReviewed>99</MonthsReviewed><Plus30>0</Plus30><Plus60>0</Plus60><Plus90>0</Plus90></Trade><Trade><MemberCode>QC</MemberCode><MemberName>METRO CREDIT UNION</MemberName><Type>R</Type><Account>000004300</Account><Joint>C</Joint><DateOpened>20110301</DateOpened><DateRevised>20140428</DateRevised><DateLastActivity>20120401</DateLastActivity><MOP>01</MOP><Balance>0</Balance><HighCredit>0</HighCredit><CreditLimit>5000</CreditLimit><Frequency>M</Frequency><Payment>0</Payment><Narrative1>CZ</Narrative1><PastDue>0</PastDue><PaymentPatternStartDate>20140428</PaymentPatternStartDate><PaymentPattern>11111111111111111111111111111111111111</PaymentPattern><MonthsReviewed>38</MonthsReviewed><Plus30>0</Plus30><Plus60>0</Plus60><Plus90>0</Plus90></Trade><Trade><MemberCode>QA</MemberCode><MemberName>CAN-AUTO</MemberName><Type>I</Type><Account>000006602</Account><Joint>I</Joint><DateOpened>20070901</DateOpened><DateRevised>20111002</DateRevised><DateLastActivity>20111001</DateLastActivity><MOP>01</MOP><Balance>0</Balance><HighCredit>18208</HighCredit><CreditLimit>0</CreditLimit><Frequency>M</Frequency><Payment>0</Payment><Narrative1>PD</Narrative1><PastDue>0</PastDue><PaymentPatternStartDate>20111002</PaymentPatternStartDate><PaymentPattern>111111111111111111111111111111111111111111111111</PaymentPattern><MonthsReviewed>51</MonthsReviewed><Plus30>0</Plus30><Plus60>0</Plus60><Plus90>0</Plus90></Trade><Trade><MemberCode>BC</MemberCode><MemberName>LATITUDE BNC</MemberName><Type>R</Type><Account>000006592</Account><Joint>I</Joint><DateOpened>19850701</DateOpened><DateRevised>20101126</DateRevised><DateLastActivity>20101001</DateLastActivity><MOP>01</MOP><Balance>0</Balance><HighCredit>11000</HighCredit><CreditLimit>0</CreditLimit><Frequency>M</Frequency><Payment>0</Payment><Narrative1>CZ</Narrative1><Narrative2>HC</Narrative2><PastDue>0</PastDue><PaymentPatternStartDate>20101126</PaymentPatternStartDate><PaymentPattern>1111111111111111111111111111111111X1111111111111</PaymentPattern><MonthsReviewed>99</MonthsReviewed><Plus30>0</Plus30><Plus60>0</Plus60><Plus90>0</Plus90></Trade><Trade><MemberCode>BB</MemberCode><MemberName>TD BK KING ST KITCHENER</MemberName><Type>R</Type><Account>000000000023</Account><Joint>I</Joint><DateOpened>20060201</DateOpened><DateRevised>20100201</DateRevised><DateLastActivity>20100201</DateLastActivity><MOP>01</MOP><Balance>0</Balance><HighCredit>10000</HighCredit><CreditLimit>0</CreditLimit><Frequency>M</Frequency><Payment>178</Payment><Narrative1>AC</Narrative1><Narrative2>HC</Narrative2><PastDue>0</PastDue><PaymentPatternStartDate>20100201</PaymentPatternStartDate><PaymentPattern>1111111111111111111111111111111111111111111111</PaymentPattern><MonthsReviewed>46</MonthsReviewed><Plus30>0</Plus30><Plus60>0</Plus60><Plus90>0</Plus90></Trade></Trades><Inquiries><Inquiry><MemberCode>BB00078746</MemberCode><MemberName>BK MONTREAL NIAGARA ST W</MemberName><Date>20090511</Date></Inquiry></Inquiries><ScoreProducts><ScoreProduct><Product>A1948</Product></ScoreProduct><ScoreProduct><Product>C1805</Product></ScoreProduct><ScoreProduct><Product>C1950</Product></ScoreProduct><ScoreProduct><Product>00002</Product><Score>700</Score><ScoreDerogatoryAlert>A</ScoreDerogatoryAlert><Factor1>40</Factor1><Factor2>27</Factor2><Factor3>0</Factor3><Factor4>0</Factor4><ScoreCard>00</ScoreCard></ScoreProduct></ScoreProducts><AccountNetCharacteristics><AccountNetCharacteristic><ID>GO146</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO145</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO143</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO149</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO148</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO147</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT93</ID><Value>0000000156</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT92</ID><Value>0000000131</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT95</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT94</ID><Value>0000030773</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT179</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO141</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT91</ID><Value>0000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT186</ID><Value>0000000394</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AI60</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT96</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT185</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT98</ID><Value>0000030773</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT99</ID><Value>0000010788</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MS154</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT180</ID><Value>0000000010</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO155</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE260</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO154</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BR155</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO157</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO156</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO158</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO151</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO150</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO153</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO152</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT199</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT198</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT197</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT196</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT195</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MC34</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT193</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT192</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BR147</ID><Value>0000000011</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR88</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AM62</ID><Value>0000003500</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AM61</ID><Value>0000000394</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI85</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT161</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MC01</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT160</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT163</ID><Value>0000003500</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT162</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT165</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT164</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT167</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT166</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR91</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR92</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR95</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MC04</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MC03</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MC02</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO81</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AM155</ID><Value>-000000095</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO80</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO83</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT168</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT169</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO89</ID><Value>K2P1V3</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT174</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PF01</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT178</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT177</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT176</ID><Value>0000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT175</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PF08</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT170</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PF03</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO13</ID><Value>0000000004</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO14</ID><Value>0000000309</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT139</ID><Value>0000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO11</ID><Value>0000000100</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO12</ID><Value>0000000148</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO17</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO18</ID><Value>Y</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO16</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR68</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR73</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN155</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN153</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT57</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT142</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO19</ID><Value>Y</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT145</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>OF34</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT140</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT141</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT61</ID><Value>0000000394</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BR24</ID><Value>0000000006</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO22</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT62</ID><Value>0000003500</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BR25</ID><Value>0000000006</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO23</ID><Value>0019850701</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO24</ID><Value>0020220117</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT60</ID><Value>0000000010</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO25</ID><Value>0020090511</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT149</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT148</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT147</ID><Value>0000000099</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO28</ID><Value>0000000004</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO29</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR75</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO116</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO20</ID><Value>Y</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR78</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO21</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MC154</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>OF20</ID><Value>0000000264</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PF29</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR80</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT155</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BI36</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT153</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT154</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT151</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT152</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PF21</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PF20</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT150</ID><Value>0000000394</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN04</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO33</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AM25</ID><Value>0000000021</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO31</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR42</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN02</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO30</ID><Value>0000000525</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR43</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR51</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO129</ID><Value>0020220520</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT77</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PF34</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT76</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT79</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT127</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT80</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FR21</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT83</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FR20</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT84</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT82</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO136</ID><Value>0000000009</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO137</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO132</ID><Value>0000000064</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO134</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AM18</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT88</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT87</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT86</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT85</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT133</ID><Value>0000000009</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT89</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT132</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT20</ID><Value>0000000442</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT100</ID><Value>0000000004</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT21</ID><Value>0000000004</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT22</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT23</ID><Value>0000000009</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT24</ID><Value>0000000009</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT25</ID><Value>0000000009</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT26</ID><Value>0000000009</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT27</ID><Value>0000000009</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT28</ID><Value>0000015600</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT29</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI27</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI20</ID><Value>0000000176</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI21</ID><Value>0000000176</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI23</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI24</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI25</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI26</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT10</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT11</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT14</ID><Value>0000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT15</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT12</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR119</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT13</ID><Value>0000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT18</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT19</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT106</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI33</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI36</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN28</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT103</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT104</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI34</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT105</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI35</ID><Value>0000000963</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BR98</ID><Value>0000015206</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT42</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT43</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FR01</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FR03</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN35</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI01</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI02</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT40</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI03</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE03</ID><Value>0000000006</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT36</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BR84</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT37</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BR85</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT34</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE94</ID><Value>0000015206</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT35</ID><Value>0000006393</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT33</ID><Value>0000000394</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT30</ID><Value>0000000007</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT38</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT39</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO07</ID><Value>0000000004</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO06</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO04</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO03</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO01</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR12</ID><Value>0000000064</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT335</ID><Value>0000000087</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BC155</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR11</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI153</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR10</ID><Value>0000001800</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE21</ID><Value>0000000040</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE23</ID><Value>0000000006</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE24</ID><Value>0000000006</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN59</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE25</ID><Value>0000000006</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE26</ID><Value>0000000006</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE27</ID><Value>0000000006</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT200</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PF153</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT201</ID><Value>0000000176</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR09</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR02</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI145</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>GO96</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN68</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN62</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BI85</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BI84</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT06</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT05</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT07</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT02</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT01</ID><Value>0000000009</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT03</ID><Value>0000000009</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR38</ID><Value>0020170120</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AM79</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PR41</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AM75</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN77</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RR35</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AM86</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN85</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AGG302</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AGG801</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AGG910</ID><Value>83.92</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PAYMNT11</ID><Value>0000000032</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TPR201</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AGG901</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AGG911</ID><Value>2.53</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BALMAG01</ID><Value>0000000118</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BALMAG02</ID><Value>0000009992</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PAYMNT02</ID><Value>000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PAYMNT04</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PAYMNT05</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PAYMNT06</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PAYMNT08</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PAYMNT09</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PAYMNT10</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RVLR03</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TPR101</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TRV01</ID><Value>0000000008</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TRV04</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TRV10</ID><Value>000000011</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TRV14</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT01S</ID><Value>0000000009</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT12Z</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT31S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT35B</ID><Value>0000000197</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AT103S</ID><Value>0000000100</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>AU21S</ID><Value>0000000065</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BC33Z</ID><Value>0000000394</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BC97A</ID><Value>0000001001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BC98A</ID><Value>0000015206</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BC102S</ID><Value>0000007800</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BC104S</ID><Value>0000000006</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BR21S</ID><Value>0000000156</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BR34S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>BR36S</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>CO01S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>DM211</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>DM212</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>DM213</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>DM214</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>DM219</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>DM218</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>DM217</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>DM215</ID><Value>0000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>DM216</ID><Value>0000000149</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FC04Z</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI20S</ID><Value>0000000176</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI21S</ID><Value>0000000176</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FR21S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>FI35S</ID><Value>-000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G001S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G002S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G003S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G043R</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G061S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G066S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G093S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G094S</ID><Value>-000000004</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G100S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G215A</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G217S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G250C</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G256Z</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G257Z</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G258S</ID><Value>-000000004</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G259Z</ID><Value>-000000004</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G310S</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G960S</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>G990S</ID><Value>0000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>ICO21</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IG096B</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN01S</ID><Value>0000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN24S</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN33Z</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN34S</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>IN36S</ID><Value>0000000999</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>INAP01</ID><Value>-000000002</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MT03S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MT33Z</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MT36Z</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MT37Z</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MT38Z</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>MTAP01</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PB01S</ID><Value>0000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>PB31S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE28S</ID><Value>0000015600</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE31S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE33Z</ID><Value>0000000394</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE34S</ID><Value>0000000003</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RE40S</ID><Value>0000000394</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RP04S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RT21S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>RT101Z</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>S068A</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>S114S</ID><Value>0000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>S204S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>S207S</ID><Value>-000000004</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>SET1S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>ST36S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL01S</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL02S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL03S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL06S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL09S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL12S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL20S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL21S</ID><Value>000000165</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL24S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL25S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL27S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL29S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL33S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL35S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL36S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>TEL101S</ID><Value>-000000001</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>US06Z</ID><Value>0000000000</Value></AccountNetCharacteristic><AccountNetCharacteristic><ID>US33Z</ID><Value>-000000003</Value></AccountNetCharacteristic></AccountNetCharacteristics></TU_FFR_Report><HTTPHeaders Status-Code=\\\"200 \\\" Keep-Alive=\\\"timeout=60 \\\" Status-Message=\\\"HTTP/1.1 200 \\\" Connection=\\\"keep-alive \\\" Pragma=\\\"no-cache \\\" Content-Length=\\\"42733 \\\" Date=\\\"Fri, 20 May 2022 12:09:56 GMT \\\" strict-transport-security=\\\"max-age=31536000; incl udeSubDomains \\\" Content-Type=\\\"text/xml \\\" Cache-control=\\\"no-cache, no-store \\\" /></REL4Report>\",\r\n"
				+ "        \"CreditPullDate\": \"2022-08-12T02:04:05.81\"\r\n"
				+ "    },\r\n"
				+ "    \"LoanApplication\": {\r\n"
				+ "        \"LoanType\": \"MPL\",\r\n"
				+ "        \"LoanPurpose\": null,\r\n"
				+ "        \"IsRental\": true,\r\n"
				+ "        \"RentalAmount\": 0.0,\r\n"
				+ "        \"NMMPastDueAccounts\": [],\r\n"
				+ "        \"LPPApplicable\": true,\r\n"
				+ "        \"IsFlinks\": false,\r\n"
				+ "        \"ApplicationType\": \"Refinance\",\r\n"
				+ "        \"CoolOffTillDate\": \"0001-01-01T00:00:00\",\r\n"
				+ "        \"ModelInput\": [],\r\n"
				+ "        \"SessionId\": \"2c734709-326f-4d30-ad3c-ec01d60388e4\",\r\n"
				+ "        \"SecuringType\": \"EFT\",\r\n"
				+ "        \"IsDownSellApplicable\": false,\r\n"
				+ "        \"DownSellLoanType\": \"SPL\",\r\n"
				+ "        \"ExceedsDQThreshold\": false\r\n"
				+ "    },\r\n"
				+ "    \"Fraud\": null,\r\n"
				+ "    \"ScheduleDates\": [\r\n"
				+ "        \"2022-09-20T00:00:00\"\r\n"
				+ "    ],\r\n"
				+ "    \"ApplicationSource\": {\r\n"
				+ "        \"ExternalLending\": {\r\n"
				+ "            \"IsExternalLending\": false,\r\n"
				+ "            \"ExternalLender\": null\r\n"
				+ "        },\r\n"
				+ "        \"ChannelType\": \"ONLINE\",\r\n"
				+ "        \"StoreNumber\": \"303\",\r\n"
				+ "        \"User\": \"123\",\r\n"
				+ "        \"UserName\": null,\r\n"
				+ "        \"FinancialPeriod\": \"2020-04-01T00:00:00\",\r\n"
				+ "        \"CallerDateTime\": \"2022-08-12T02:34:11.9121853-04:00\",\r\n"
				+ "        \"WorkStationId\": 0,\r\n"
				+ "        \"LocationId\": \"946\",\r\n"
				+ "        \"StateCode\": \"MB\",\r\n"
				+ "        \"CountryCode\": \"CAN\"\r\n"
				+ "    }\r\n"
				+ "}")
				.post("/CanadaWorkflow");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$  PROVINER $$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println(response.asString());
		//CreditDecision
		JSONObject responseObj = new JSONObject(response.asString());
		JSONArray OverallDecisionArray =  responseObj.getJSONArray("OverallDecision");
		System.out.println(OverallDecisionArray);
		for(int i=0;i < OverallDecisionArray.length();i++)
		{
			JSONObject OverallDecisionObject = OverallDecisionArray.getJSONObject(i);
			String CreditDecision = OverallDecisionObject.getString(fetchNodeDetail);
			System.out.println(CreditDecision);
			
			JSONArray TermInfoListArray =  OverallDecisionObject.getJSONArray("TermInfoList");
			for(int j=0;j < TermInfoListArray.length();j++)
			{
				JSONObject TermInfoListObject = TermInfoListArray.getJSONObject(j);
				
						
				String TermInfoList = TermInfoListObject.getString("MaxLoanAmountWithLPP");
				System.out.println(TermInfoList);
				
				String TermInfoList1 = TermInfoListObject.getString("MaxLoanAmount");
				System.out.println(TermInfoList1);
				
				String TermInfoList2 = TermInfoListObject.getString("MinLoanAmount");
				System.out.println(TermInfoList2);
				
				String TermInfoList3 = TermInfoListObject.getString("Term");
				System.out.println(TermInfoList3);
			}
			
		}
				System.out.println("DONE Proviner");
		return fetchNodeDetail;
	}
	
	
	
	
	
	public static void toExecuteCronJobForReFi() throws IOException 
	{
		RestAssured.baseURI = BASE_URL_ReFi;
		System.out.println(RestAssured.baseURI);
		
     	//Added on 28-May-2022 Start
		TestBase.logLoanDetails.add("###################################################");
		TestBase.logLoanDetails.add(RestAssured.baseURI);
		TestBase.logLoanDetails.add("###################################################");
		//Added on 28-May-2022 End

		//Added on 28-May-2022 Start
		UtilityMethods.PBufferWriter(TestBase.logLoanDetailsPath, TestBase.logLoanDetails);;
		TestBase.logLoanDetails.clear();
		//Added on 28-May-2022 End

		logger.info("RestAssured.baseURI");
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Authorization",token);
		response = request.post(baseURI);
		String jsonString = response.asString();
		System.out.println("DONE Refi");
		System.out.println(jsonString);
		
		//Added on 28-May-2022 Start
		TestBase.logLoanDetails.add("###################################################");
		TestBase.logLoanDetails.add(jsonString);
		TestBase.logLoanDetails.add("###################################################");
		//Added on 28-May-2022 End

		//Added on 28-May-2022 Start
		UtilityMethods.PBufferWriter(TestBase.logLoanDetailsPath, TestBase.logLoanDetails);;
		TestBase.logLoanDetails.clear();
		//Added on 28-May-2022 End
		System.out.println("DONE Refi");
	}

	
	public static void toExecuteCronJobForExpiredLoan() throws IOException 
	{
		RestAssured.baseURI = BASE_URL_ExpiredLoan;
		System.out.println(RestAssured.baseURI);
    	
		//Added on 28-May-2022 Start
		TestBase.logLoanDetails.add("###################################################");
		TestBase.logLoanDetails.add(RestAssured.baseURI);
		TestBase.logLoanDetails.add("###################################################");
		//Added on 28-May-2022 End

		//Added on 28-May-2022 Start
		UtilityMethods.PBufferWriter(TestBase.logLoanDetailsPath, TestBase.logLoanDetails);;
		TestBase.logLoanDetails.clear();
		//Added on 28-May-2022 End
		
		logger.info("RestAssured.baseURI");
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Authorization",token);
		response = request.post(baseURI);
		String jsonString = response.asString();
		System.out.println("DONE Expired");
		System.out.println(jsonString);
		//Added on 28-May-2022 Start
		TestBase.logLoanDetails.add("###################################################");
		TestBase.logLoanDetails.add(jsonString);
		TestBase.logLoanDetails.add("###################################################");
		//Added on 28-May-2022 End

		//Added on 28-May-2022 Start
		UtilityMethods.PBufferWriter(TestBase.logLoanDetailsPath, TestBase.logLoanDetails);;
		TestBase.logLoanDetails.clear();
		//Added on 28-May-2022 End
		System.out.println("DONE Expired");
	}
	
	public static void get_Request_BodyOnly(String Email) throws IOException, InterruptedException 
	{
		RestAssured.baseURI = BASE_URL_Proviner;
		
		System.out.println(RestAssured.baseURI);
		logger.info("RestAssured.baseURI");		
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		//response = request.post(baseURI);

		Thread.sleep(5000);
		String sRequest = MsSqlUtility.getRequest(Email);
		System.out.println(sRequest);
		
	}
	
	public static void main(String[] args) throws IOException, InterruptedException, JSONException {
		
		
		//toGetPostRequestResponseToken();
		//toExecuteCronJobForLanBook();
		//toExecuteCronJobForReFi();
		//toExecute_Proviner_Job();
		
		//toExecute_Proviner_Job_TOTEST_RESTASSURED();
		
		/*
		toExecute_Proviner_Job_toGet_OverallDecision("CreditDecision");
		toExecute_Proviner_Job_toGet_OverallDecision("ApplicationType");
		toExecute_Proviner_Job_toGet_OverallDecision("APR");
		toExecute_Proviner_Job_toGet_OverallDecision("LoanType");
		toExecute_Proviner_Job_toGet_OverallDecision("ApprovedDate");
		toExecute_Proviner_Job_toGet_OverallDecision("CustomerSegmentation");
		*/
		//toExecute_Proviner_Job_toGet_OverallDecision("TermInfoList");
		
		//get_Request_BodyOnly("dave_mydaa@yopmail.com");//NMM
		
		get_Request_BodyOnly("creditil@yopmail.com");
		
		
		
		
		
		/*
		String sRequest = MsSqlUtility.getRequest("dave_fabyi@yopmail.com");
		System.out.println(sRequest);
		*/
	}
	}
