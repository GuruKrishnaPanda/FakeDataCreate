package Utilities;

public class Constants {
	public static String typeOfData = "Y";// Valid Data
	public static String haveSpecialChar = "N";
	public static boolean RequiredSpecialChar = true;
	public static String haveDigit = "Y";
	public static String havechar = "Y";
	public static int totalData =  10;
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
	
	public static char[] special = new char[]{'!', '@', '#', '$', '%', '^', '&', '*', '}', '/','+','=','~','-','_','<','>','.','|'};
	public static String[] caste = {"SC","ST","OBC","MBC","ND","GEN"};
	public static String[] comm = {"Hindu","Muslim","Christian","Zoroastrian","Buddhist","Sikh","Jain","Neo","Buddhist","ND","OTH "};
	public static String[] ProtectionValue = {"Notional amount", "Fair value","Market value","Long-term sustainable value", "Other"};
	public static String[] ValuationApproach = {"Mark-to-market", "Counterparty estimation","Creditor valuation","Third party valuation", "Other type of valuation"};
	public static String[] protectiontype = {"Gold","Depsoits","Securities","Trade receivables","Life insurance policies","Land","building"};
    public static String[] status = {"Pending","Resolved","No action"};
    public static String[] internal = {"AAA++","BBB++","CCC++","AAA","BBB","CCC"};
    public static String[] restruct = {"Restructured due to Non-Performance", "Restructured due to Natural Calamity"," Others"};
	public static String[] account= {"Open","Closed","Settled & Closed","Written Off","Settled Post Write Off","Invoked/Devolved"};
	public static String[] inst = {"0100","0630","1100","9999"};
    public static String[] priority = {"Y","N"};
    public static String[] activity = {"35102","51000","99000"};
    public static String[] rateType = {"Fixed","Floating", "Mixed"};
	public static String[] mortisation = {"French","German","Fixed","Bullet", "Other"};
	public static String[] paymentFrequency = {"Daily","Weekly","Monthly","Quarterly"," Half Yearly", "Annually","On Demand Bullet", "Zero coupon","Rolling","Other"};
	public static String[] sma ={"0","1","2"};
	public static String[] npac = {"Sub-standard", "Doubtful", "Loss"};
	public static String[] currency = {"INR", "USD", "EUR"};
}
