package test;

public class Constants {
	public static String typeOfData = "N";// Valid Data
	public static String haveSpecialChar = "N";
	public static String haveDigit = "Y";
	public static String havechar = "N";
	public static int totalData =  100;
	public static String fileType =  ".csv";
	public static String fileLocation =  System.getProperty("user.dir")+"\\ActualFileCreated\\";
	public static String separator =  ";";
	
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
	
	
	
	
	
}
