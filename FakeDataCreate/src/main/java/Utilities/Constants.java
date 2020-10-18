package Utilities;

public class Constants {
	public static String typeOfData = "N";// Valid Data
	public static String haveSpecialChar = "N";
	public static boolean RequiredSpecialChar = true;
	public static String haveDigit = "Y";
	public static String havechar = "N";
	public static int totalData =  100;
	public static String fileType =  ".csv";
	public static String NewfileLocation =  System.getProperty("user.dir")+"\\ActualFileCreated\\";
	public static String ArchivefileLocation =  System.getProperty("user.dir")+"\\ArchiveFiles\\";
	public static String separator =  ";";
	
	public static String contract =  "Contract";
	public static String counterParty =  "CounterParty";
	public static String counterpartyRating =  "CounterpartyRating";
	public static String counterpartyRisk =  "CounterpartyRisk";
	public static String instrument =  "Instrument";
	public static String protection =  "Protection";
	public static String protectionInstrument =  "ProtectionInstrument";
	public static String relatedParty =  "RelatedParty";
	
	public static String ReportingMemberID = "TCSQA1001";
	
	
	
	public static String[] array = { "plainaddress", 
		    "#@%^%#$@#$@#.com", 
		    "@example.com", 
		    "Joe Smith <email@example.com>", 
		    "email.example.com", 
		    "email@example@example.com", 
		    ".email@example.com", 
		    "email.@example.com", 
		    "email..email@example.com",  
		    "email@example.com (Joe Smith)", 
		    "email@example", 
		    "email@-example.com", 
		    "email@example.web", 
		    "email@111.222.333.44444", 
		    "email@example..com", 
		    "Abc..123@example.com", 
		   "\\\\\"(),:;<>[\\\\]@example.com", 
		    "just\"not\"right@example.com", 
		    "this\\\\ is\\\\\"really\\\\\"not\\\\allowed@example.com" };
	
	public static String [] local = {
			"en-GB",
			"en-IND",
			"en-MS",
			"en-NEP",
			"en-NG",
			"en-NZ",
			"en-PAK",
			"en-SG",
			"en-UG",
			"en-US",
			"en-ZA",
			"es",
			"es-MX",
			"fa",
			"fi-FI",
			"fr",
			"he",
			"hu",
			"in-ID",
			"it",
			"ja",
			"ko",
			"nb-NO",
			"nl",
			"pl",
			"pt",
			"pt-BR",
			"ru",
			"sk",
			"sv",
			"sv-SE",
			"tr",
			"uk",
			"vi",
			"zh-CN",
			"zh-TW"
			};
	
	public static char[] special = new char[]{'!', '@', '#', '$', '%', '^', '&', '*', '}', '/','+','=','~','`','(',')','-','_','<','>',',','.','|'};
	public static String[] caste = {"SC","ST","OBC","MBC","ND","GEN"};
	public static String[] page = 		
		{
     		    "[A-Z]{5}[0-9]{4}[A-Z]{1}",
				"[A-Z]{4}[0-9]{4}[A-Z]{1}",
				"[A-Z]{5}[0-9]{4}[0-9]{1}",
				"[A-Z]{8}[0-9]{0}[A-Z]{2}",
				"[A-Z]{8}[0-9]{0}[A-Z]{2}",
				"[A-Z]{5}[_]{1}[A-Z]{4}",
				"[a-z]{5}[0-9]{4}[A-Z]{1}",
				"[0-9]{5}[0-9]{4}[0-9]{1}",
				"[A-Z]{5}[0-9]{5}[A-Z]{2}"
		};
	public static String[] comm = {"Hindu","Muslim","Christian","Zoroastrian","Buddhist","Sikh","Jain","Neo","Buddhist","ND","OTH "};
	
}
