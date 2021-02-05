package ReUsable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.javafaker.Faker;

import Utilities.Constants;
import Utilities.DataUtil;
import Utilities.GenericXLSXReader;
import pojoClases.Contract;
import pojoClases.Counterparty;
import pojoClases.Instrument;

public class datacreation {
	GenericXLSXReader xls = new GenericXLSXReader(System.getProperty("user.dir")+"\\resources\\Configuration.xlsx");
	Hashtable<String, String> configurationData = DataUtil.getData("Configuration", xls);
	//Faker faker = new Faker(new Locale("pt_US"));
	Faker faker =  new Faker();
	public String createReportingEntityId(String bankSymbol) 
	{
		
		if(Constants.typeOfData.equalsIgnoreCase("Y")) 
		{

			String d = faker.regexify("0|1|2|6");
			int i=Integer.parseInt(d); 
			if(i==0) {
				return bankSymbol; 
			}
			else {
				if(Constants.haveSpecialChar.equalsIgnoreCase("Y")&&Constants.haveDigit.equalsIgnoreCase("N")&&Constants.havechar.equalsIgnoreCase("N"))
					return bankSymbol+createdata(i, false, true, false);
				if (Constants.haveSpecialChar.equalsIgnoreCase("Y")&&Constants.haveDigit.equalsIgnoreCase("Y")&&Constants.havechar.equalsIgnoreCase("N"))
					return bankSymbol+createdata(i, false, true, true);
				if (Constants.haveSpecialChar.equalsIgnoreCase("N")&&Constants.haveDigit.equalsIgnoreCase("Y")&&Constants.havechar.equalsIgnoreCase("Y"))
					return bankSymbol+createdata(i, true, false, true);
				if (Constants.haveSpecialChar.equalsIgnoreCase("N")&&Constants.haveDigit.equalsIgnoreCase("N")&&Constants.havechar.equalsIgnoreCase("Y"))
					return bankSymbol+createdata(i, true, false, false);
				if (Constants.haveSpecialChar.equalsIgnoreCase("N")&&Constants.haveDigit.equalsIgnoreCase("Y")&&Constants.havechar.equalsIgnoreCase("N"))
					return faker.number().digits(i);
				if (Constants.haveSpecialChar.equalsIgnoreCase("Y")&&Constants.haveDigit.equalsIgnoreCase("Y")&&Constants.havechar.equalsIgnoreCase("Y"))
					return bankSymbol+createdata(i, true, true, true);	
				}
			
		}
		else {
			String invalidNumber = invalidNumberlength(faker);
			int i=Integer.parseInt(invalidNumber); 
			System.out.println(createdata(i, false, true, true));
			return createdata(i, false, true, true);
		     }
		return null;
	}
	public String password(int minimumLength, int maximumLength, boolean includeUppercase, boolean includeSpecial, boolean includeDigit) {
        if (includeSpecial) {
            char[] password = faker.lorem().characters(minimumLength, maximumLength, includeUppercase, includeDigit).toCharArray();
            char[] special = new char[]{'!', '@', '#', '$', '%', '^', '&', '*', '}', '/','+','=','~','`','(',')','-','_','<','>',',','.','|'};
            for (int i = 0; i < faker.random().nextInt(minimumLength); i++) {
                password[faker.random().nextInt(password.length)] = special[faker.random().nextInt(special.length)];
            }
            return new String(password);
        } else {
            return faker.lorem().characters(minimumLength, maximumLength, includeUppercase, includeDigit);
          
            
        }
    }
	public String createdata(int maximumLength, boolean includeUppercase, boolean includeSpecial, boolean includeDigit) {
        if (includeSpecial) {
            char[] data = faker.lorem().characters(maximumLength, includeUppercase, includeDigit).toCharArray();
            char[] special = new char[]{'!', '@', '#', '$', '%', '^', '&', '*', '}', '/','+','=','~','`','(',')','-','_','<','>','.','|'};
            for (int i = 0; i < maximumLength; i++) {
                data[faker.random().nextInt(data.length)] = special[faker.random().nextInt(special.length)];
            }
            return new String(data);
        } else {
        		
            return faker.lorem().characters(maximumLength, includeUppercase, includeDigit);
            
        }
    }
	
	public String invalidNumberlength(Faker faker) {
        String ssn =""+faker.number().numberBetween(0, 15);

        boolean isInValid = false;
        
            if (ssn.matches("3|5|4|9")) {
            	isInValid = true;
            }
        
        if (isInValid) {
            ssn = invalidNumberlength(faker);
        }
        return ssn;
    }
	
public String addressLine1() {
	String add = faker.address().buildingNumber();
	System.out.println(add);
	return add;
}
public String addressLine2() {
	
	String add2 =faker.address().streetAddress();	
	System.out.println(add2);
	return add2;
}
public String addressLine3() {
	String add3 = faker.address().cityName();
	System.out.println(add3);
	return add3;
}


public Date dateofBirth() {
	  Date d = faker.date().birthday(18, 98);
	  System.out.println(d);
	return d;
	}
   public String date() {
	//return faker.date().birthday(26, 87);

	if(Constants.typeOfData.equalsIgnoreCase("Y"))
	{
		return dateAuth1();
	}
	else {
		
		String d = genDate();
		 return d;
                 
		}
}

public String emailAddress() {
	Faker faker = new Faker(new Locale("en_IND"));
	
	if (Constants.typeOfData.equalsIgnoreCase("Y"))
	{
		String value= faker.internet().emailAddress();
		System.out.print( value);
		return value;
	}
	else {
	int num=faker.number().numberBetween(0, 18);
	String invalidEmail =  Constants.array[num];
	
	System.out.println(faker.internet().domainSuffix());
	return invalidEmail;
	}
}
public void testingmethod() {

	int length =  Constants.local.length;
	int random =  faker.number().numberBetween(0, length);
	Faker   f =  new Faker(new Locale(Constants.local[random]));
	System.out.println(Constants.local[random]);
	System.out.println(f.internet().emailAddress());
		
}


public Date StringToDate(String s){

    Date result = null;
    try{
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddmmyyyy");
        result  = dateFormat.parse(s);
    }

    catch(Exception e){
        e.printStackTrace();

    }
    return result ;
}

public String negAlpha(int j) {
	
    String v= null;
	int k = faker.number().numberBetween(1, 4);
		switch(k)
		
		{
		case 1:  v =  conditionCheck2(j);
		        System.out.println(v);
		        break;
		case 2:  v=  conditionCheck4(j);
		        System.out.println(v);
		        break;      
		case 3:  v= conditionCheck5(j);
		         System.out.println(v);
		        break;
		case 4:   v= conditionCheck6(j);
			         System.out.println(v);
			        break;
}
		return v;
	
}

public String negdigit(int j) {
	
         String v= null;
	int k = faker.number().numberBetween(1, 4);
		switch(k)
		
		
		{
		case 1: v =  conditionCheck2(j);
		        System.out.println(v);
		        break;
		case 2:  v=  conditionCheck4(j);
		        System.out.println(v);
		        break;      
		case 3:  v= conditionCheck3(j);
		         System.out.println(v);
		        break;
		case 4:   v= conditionCheck6(j);
			      System.out.println(v);
			        break;

}
		return v;
	
}

public String createContractIdentifier() 
{
	int j= faker.number().numberBetween(5, 36);
	
	if(Constants.typeOfData.equalsIgnoreCase("Y")) 
	{
		 return Alpha(j);
	}
	else 
	{
	String d= negAlpha(j);
	 return d;
	
}}

public String conditionCheck2(int i)
{
	
		return createdata(i, false, true, true);
	
}
public String conditionCheck3(int i)
{
	
		return createdata(i, true, false, true);
	
}
public String conditionCheck4(int i)
{
	
		return createdata(i, true, false, false);
	
}
public String conditionCheck5(int i)
{
		return faker.number().digits(i);
	
}
public String conditionCheck6(int i)
{
	
		return createdata(i, false, true, true);
	
}

public String createInstrumentId()
{
    int j= faker.number().numberBetween(4, 21);
	if(Constants.typeOfData.equalsIgnoreCase("Y")) 
	{
		return Alpha(j);
	}
	else 
	{
		String d= negAlpha(j);
	 return d;	
	}
}

public String countryCode()
{
	//Faker faker = new Faker(new Locale("en_IND"));
	String value =  faker.country().countryCode3();
	System.out.println(value);
	return value;
}

 public String createName()
{
	// Faker faker("en-IND") =  Faker("en-IND");
	 Faker faker = new Faker(new Locale("en_IND"));
	String name = faker.name().name();
	System.out.println(name);
	return name;
	
}
public static void main(String[] args) {
	datacreation dt =  new datacreation();

	//String email = dt.emailAddress();
	//System.out.println(email);
	//dt.pangenerate();
	

}
public String relatedPartyId(String bankSymbol)
{
		int j= faker.number().numberBetween(5, 15);
	
		if(Constants.typeOfData.equalsIgnoreCase("Y"))
	{
		return bankSymbol+Alpha(j);
	}
	else {
	
		String d= negAlpha(j);
	return d;
	}
}

public String legalEntityIdentifier()
{
	String lei;
	lei =faker.regexify("[0-9]{4}[0]{2}[A-Z0-9]{12}[0-9]{2}");
	if (Constants.typeOfData.equalsIgnoreCase("Y"))
	{
	//lei =faker.regexify("[0-9]{4}[0]{2}[A-Z0-9]{12}[0-9]{2}");
	System.out.println(lei);
	return lei;
	}
	else {
	String number = faker.regexify(faker.number().numberBetween(5, 19)+"|20|"+faker.number().numberBetween(21, 25));
	int intNumber = Integer.parseInt(number);
	String data1 = faker.lorem().characters(intNumber,true,true).toUpperCase();
	char[] data = data1. toCharArray();
	System.out.println(data);
	if (intNumber<=20)
	{
	lei = withSpecialCharData(data, 5);
	return lei;
	}
	else if (intNumber>=20)
	{
	lei = withSpecialCharData(data, 21);
	return lei;
	}
	else
	{
	lei = withSpecialCharData(data, 20);
	return lei;

	}

	}
}
public String companyIdentificationNumber()
{
	String CIN;
	CIN =faker.regexify("[UL]{1}[0-9]{5}[A-Z]{2}[2]{1}[0]{1}[0-2]{1}[0-9]{1}[P]{1}[TL]{1}[C]{1}[0-9]{6}");
	if (Constants.typeOfData.equalsIgnoreCase("Y"))
	{

	System.out.println(CIN);
	return CIN;

	}

	else {
	String number = faker.regexify(faker.number().numberBetween(5, 20)+"|21|"+faker.number().numberBetween(22, 25));
	int intNumber = Integer.parseInt(number);
	String data1 = faker.lorem().characters(intNumber,true,true).toUpperCase();
	char[] data = data1. toCharArray();
	System.out.println(data);
	if (intNumber<=21)
	{
	CIN = withSpecialCharData(data, 5);
	return CIN;
	}
	else if (intNumber>=21)
	{
	CIN = withSpecialCharData(data, 22);
	return CIN;
	}
	else
	{
	CIN = withSpecialCharData(data, 21);
	return CIN;

	}
	}
}
public String udyogAdharNumber()
{
    int j= faker.number().numberBetween(3, 12);
	if(Constants.typeOfData.equalsIgnoreCase("Y")) 
	{
		return Alpha(j);
	}
	else {
		String d = negAlpha(j);
		return d;	
	     }
}
public String taxCollectionAccountNumber()
{
	String tan;
	tan =faker.regexify("[A-Z]{3}[A-Z]{1}[0-9]{5}[A-Z]{1}");
	if (Constants.typeOfData.equalsIgnoreCase("Y"))
	{

	System.out.println(tan);

	}
	else {
	String number = faker.regexify(faker.number().numberBetween(3, 9)+"|10|"+faker.number().numberBetween(11, 15));
	int intNumber = Integer.parseInt(number);
	String data1 = faker.lorem().characters(intNumber,true,true).toUpperCase();
	char[] data = data1. toCharArray();
	System.out.println(data);
	if (intNumber<=10)
	{
	tan = withSpecialCharData(data, 3);
	return tan;
	}
	else if (intNumber>=10)
	{
	tan = withSpecialCharData(data, 11);
	return tan;
	}
	else
	{
	tan = withSpecialCharData(data, 10);
	return tan;

	}
	}
	return tan;
}
 public String nicCode()
 {
	 int j= faker.number().numberBetween(4, 5);
		
		if(Constants.typeOfData.equalsIgnoreCase("Y")) 
		{
			return Alpha(j);			
		}
		else {
			String d = negAlpha(j);
			return d;
		     }

 } 
 public String districtCode()
 {
	 int j= faker.number().numberBetween(3, 3);
		
		if(Constants.typeOfData.equalsIgnoreCase("Y")) 
		{
			return Alpha(j);
		}
		else {
			String d = negAlpha(j);
			return d;
		}
 }
 public String createDIN()
 {
	 int j= faker.number().numberBetween(3, 8);
	 if (Constants.typeOfData.equalsIgnoreCase("Y"))
	 {

		
			return createNumeric(j);
	 }
	 else {
		 String d = negdigit(j);
		 return d;

	 }
 }

 public String createCommunity()
 {
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 int gen = faker.random().nextInt(Constants.comm.length);
		
		 System.out.println(Constants.comm[gen]);
	        return Constants.comm[gen];
		
	 }
	 else
	 {
		 String gencomm = faker.lorem().characters(2, 8, true, true).toUpperCase();
		 System.out.println(gencomm);
		 return gencomm;
	 }
	

	
 }
 public String createCaste()
 {
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 int cas = faker.random().nextInt(Constants.caste.length);
		 System.out.println(Constants.caste[cas]);
		return Constants.caste[cas];
	 }
	 else
	 {
		 String gencas = faker.lorem().characters(2, 4, true, true).toUpperCase();
		 System.out.println(gencas);
		 return gencas;
	 }

 }
 public String occupationalCode()
 { 
	 String value= null;
	 int j= faker.number().numberBetween(5, 5);
 if(Constants.typeOfData.equalsIgnoreCase("Y"))
 {
	 return createNumeric(j);
 }
 else
 {
	 String d = negdigit(j);
	 return d;

 }
 }

 
 public String stateCode()
 {
	 int j= faker.number().numberBetween(1, 2);
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 String value = conditionCheck5(j);
			System.out.println("0"+value); 
			return value;
	 }
	 else
	 {
			String d = negdigit(j);
			return d;
	 }
	
 }
 
 public String landmobileNumber()
 { 
	 String No ;
	
	 if (Constants.typeOfData.equalsIgnoreCase("Y")) {
		 No= faker.regexify("[0-9]\\d{2,4}-\\d{6,8}");
		 System.out.println(faker.regexify(No));

	 }
	 
		  else 
		   {
			   String number = faker.regexify(faker.number().numberBetween(6, 11)+"|12|"+faker.number().numberBetween(13, 16));
			   int intNumber = Integer.parseInt(number);
			   String data1 = faker.lorem().characters(intNumber,true,true).toUpperCase();
			   char[] data = data1. toCharArray();
			   System.out.println(data);
			   if (intNumber<=12)
			   {
				   No = withSpecialCharData(data, 6);
				   return No;
			   }
			   else if (intNumber>=12)
			   {
				   No = withSpecialCharData(data, 16);  
				   return No;
			   }
			   else
			   {
				   No = withSpecialCharData(data, 12);
				   return No;

			   }
			   
	       }
	return No;	
	 }

 
 public String pinCode()
 {
	 String  pcode= faker.regexify("[1-9]{1}[0-9]{2}[0-9]{3}");
	 if (Constants.typeOfData.equalsIgnoreCase("Y"))
		
	
		System.out.print(faker.regexify(pcode));
		return pcode;

	

 }
 public String typeOfOrganisation()
 {

	 int j= faker.number().numberBetween(1, 3);
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 String value = conditionCheck5(j);
		 int number = Integer.parseInt(value);
		 if(number<=9) {
			 return "0"+value;
		 }
		 else 
			return value;
	 }
	 else
	 {
			String d = negdigit(j);
			return d;	
	 }}
	 public String createBurrower()
	 {
		 int j= faker.number().numberBetween(1, 3);
		 if(Constants.typeOfData.equalsIgnoreCase("Y"))
		 {
			 String value = conditionCheck5(j);
			 int number = Integer.parseInt(value);
			 if(number<=9) {
				 
				 return "0"+value;
			 }
			 else 
				return value;
		 }
		 else
		 { 
				String d = negAlpha(j);
				return d;
		 } 
	 }
	 public String createProtectionId()
	 {
		 int j= faker.number().numberBetween(5, 15);
			
			if(Constants.typeOfData.equalsIgnoreCase("Y")) 
			{			
				return Alpha(j);			
			}
			else {
			
				String d= negAlpha(j);
				 return d;
			     }
	 }
	 public String createprotectionAllocatedValue()
	 {
		 int j= faker.number().numberBetween(5, 17);
		 if(Constants.typeOfData.equalsIgnoreCase("Y"))
		 {
			return createNumeric(j);
		 }
		 else
		 {
				String d= negdigit(j);
				 return d;	
		 }
	 }
	 public String createChargeType()
	 {
		 int j= faker.number().numberBetween(5, 25);
			
			if(Constants.typeOfData.equalsIgnoreCase("Y")) 
			{		
				return Alpha(j);			
			}
			else {
				String d= negAlpha(j);
				 return d;
			     }
	 }
	 public String createRelatedCounterepartyId()
	 {
		 int j= faker.number().numberBetween(5, 21);
		 if(Constants.typeOfData.equalsIgnoreCase("Y")) 
		 {
			 return Alpha(j);
		 }
		 else
		 {
				String d = negAlpha(j);
				 return d;
		 }
	 }
	 public String createNumeric(int j)
	 {
	
			
		
				String value = 	conditionCheck5(j);
				System.out.println(value);
				return value;
	 }	

	
	 public String createprotectionProviderId()
	 {

	 int j= faker.number().numberBetween(1, 15);
	 	
	 	if(Constants.typeOfData.equalsIgnoreCase("Y")) 
	 	{
	 		return Alpha(j);
	 	}
	 	else {
	 		String d= negAlpha(j);
	 		 return d;
	 	}
	 }
	 public String createprotectionId()
	 {
		 int j= faker.number().numberBetween(2, 15);
			
			if(Constants.typeOfData.equalsIgnoreCase("Y")) 
			{
				return Alpha(j);	
			}
			else {
			
				String d= negAlpha(j);
				 return d;	
			     }
	 }	
	  public String createtypeOfProtection()
	   {
		  if(Constants.typeOfData.equalsIgnoreCase("Y"))
		  {
			  int type = faker.random().nextInt(Constants.protectiontype.length);
				 System.out.println(Constants.protectiontype[type]);
				return Constants.protectiontype[type];
			 }
			 else
			 {
				 String gentype = faker.lorem().characters(2, 4, true, true).toUpperCase();
				 System.out.println(gentype);
				 return gentype;
			 }
		  }
			 
	 
	 
		 public String createcurrencyType()
		 {
		 if(Constants.typeOfData.equalsIgnoreCase("Y"))
		 {
		 int type = faker.random().nextInt(Constants.currency.length);
		 System.out.println(Constants.currency[type]);
		 return Constants.currency[type];
		 }
		 else
		 {
		 String gencur = faker.lorem().characters(2, 4, true, true).toUpperCase();
		 System.out.println(gencur);
		 return gencur;
		 } }
 
	 public  String createprotectionValue()
	 {
	
		 return double2();				
	 }
 public String createtypeOfProtectionValue()
	 {
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 int protect = faker.random().nextInt(Constants.ProtectionValue.length);
		 System.out.println(Constants.ProtectionValue[protect]);
		return Constants.ProtectionValue[protect];
	 }
	 else
	 {
		 String genprotect = faker.lorem().characters(2, 4, true, true).toUpperCase();
		 System.out.println(genprotect);
		 return genprotect;
	 }
} 
	 public String createprotectionValuationApproach()
	 {
		 if(Constants.typeOfData.equalsIgnoreCase("Y"))
		 {
			 int valuation = faker.random().nextInt(Constants.ValuationApproach.length);
			 System.out.println(Constants.ValuationApproach[valuation]);
			return Constants.ValuationApproach[valuation];
		 }
		 else
		 {
			 String genvaluation = faker.lorem().characters(2, 4, true, true).toUpperCase();
			 System.out.println(genvaluation);
			 return genvaluation;
		 }
	 }
	 public String createdateOfProtectionValue()
	  {
		 
		 if(Constants.typeOfData.equalsIgnoreCase("Y"))
		 {
			 return dateAuth1();
		 }
		 else {
			 String d = genDate();
			 return d;
		                 
				}
		 }
 
	 public String createoriginalProtectionValue()
	  {
		 return double2();
 }
	 public String createdateOfOriginalProtectionValu()
	 {
	
		 if(Constants.typeOfData.equalsIgnoreCase("Y"))
		 {
			 return dateAuth1();
		 }
		 else
		 {
			 String d = genDate();
			 return d;
		 }
	 }
	 public String createprotectionRegistryId()
	 {
		 int j= faker.number().numberBetween(8,15);
			
			if(Constants.typeOfData.equalsIgnoreCase("Y")) 
			{
				return Alpha(j);	
			}
			else {
			
			String d= negAlpha(j);
			return d;
			     }
	 }	 
	 public String createprotectionExternalId()
	 {
		 int j= faker.number().numberBetween(20, 50);
			
			if(Constants.typeOfData.equalsIgnoreCase("Y")) 
			{
				return Alpha(j);
			}
			else {
			
				String d= negAlpha(j);
				return d;
			     }
	 }	
	 public double conditionCheck7(double i)
	 {
	 		return faker.number().randomDouble(4, 10, 4);
	 }	
	 public String createStatusOfInsolvencyProceedings()
	 {
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 int insolvency = faker.random().nextInt(Constants.status.length);
		 System.out.println(Constants.status[insolvency]);
		return Constants.status[insolvency];
	 }
	 else
	 {
		 String sta = faker.lorem().characters(2, 4, true, true).toUpperCase();
		 System.out.println(sta);
		 return sta;
	 }
	 
	 	
	 }
public String dateOfInitiationOfInsolvencyProceedings() {
	 String strDate = null;
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 return dateAuth1();
	 }
	 else
	 {
		 String d = genDate();
		 return d;
	 }

	
}
public String createwilfulDefaulter()
{
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 int wil = faker.random().nextInt(Constants.priority.length);
		 System.out.println(Constants.priority[wil]);
		return Constants.priority[wil];
	 }
	 else
	 {
		 String wilfu = faker.lorem().characters(1, 2, true, false).toUpperCase();
		 System.out.println(wilfu);
		 return wilfu;
	 }

}
public String dateOfWilfulDefaulterClassification() {

	 String strDate = null;
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 return dateAuth1();
	 }
	 else
	 {
		 String d = genDate();
		 return d;
	 }

}
public String createnonCooperativeBorrower()
{
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 int nonc = faker.random().nextInt(Constants.priority.length);
		 System.out.println(Constants.priority[nonc]);
		return Constants.priority[nonc];
	 }
	 else
	 {
		 String nonco = faker.lorem().characters(1, 2, true, false).toUpperCase();
		 System.out.println(nonco);
		 return nonco;
	 }

}
public String dateOfNonCooperativeBorrowerClassification() {
	 String strDate = null;
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 return dateAuth1();
	 }
	 else
	 {
		 String d = genDate();
		 return d;
	 }

	
}
public String createFradulentActivity()
{
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 int frad = faker.random().nextInt(Constants.priority.length);
		 System.out.println(Constants.priority[frad]);
		return Constants.priority[frad];
	 }
	 else
	 {
		 String fra = faker.lorem().characters(1, 2, true, false).toUpperCase();
		 System.out.println(fra);
		 return fra;
	 }

}
public String dateOfFradulentActivityClassification() {


	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 return dateAuth1();
	 }
	 else
	 {
		 String d = genDate();
		 return d;
	 }
}
 public String createinternalRating()
 {
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 int inter = faker.random().nextInt(Constants.internal.length);
		 System.out.println(Constants.internal[inter]);
		return Constants.internal[inter];
	 }
	 else
	 {
		 String rating = faker.lorem().characters(2, 4, true, true).toUpperCase();
		 System.out.println(rating);
		 return rating;
	 }

}
	public String creditRatingAsOn(){
	 	
	
		 if(Constants.typeOfData.equalsIgnoreCase("Y"))
		 {
			 return dateAuth1();
		 }
		 else
		 {
			 String d = genDate();
			 return d;
		 }
 	}
 	public String creditRatingExpiryDate()
 	 {
 		
		 if(Constants.typeOfData.equalsIgnoreCase("Y"))
		 {
	return dateAuth1();
		 }
		 else
		 {
			 String d = genDate();
			 return d;
		 }

 	 }
 	public String createCouterpartyIdentifier(String bankSymbol)
	 {
 		
 	     int j=faker.number().numberBetween(4, 15);
		 if(Constants.typeOfData.equalsIgnoreCase("Y"))
		 { 
			 j=faker.number().numberBetween(1, 12);
				return bankSymbol+Alpha(j);
		 }
		 else
		 {
				String d= negAlpha(j);
				 return d;				
		 }
	 }
	 public String createRatingId()
	 {
	 	 int j=faker.number().numberBetween(5, 20);
	 	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 	 {
	 		return Alpha(j);
	 	 }
	 	 else
	 	 {
	 		String d = negAlpha(j);
			 return d;
	 	 }	 	
	 }
	 public String createCountryCode()
	 {
	 	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 	 {
	 		 int code = faker.random().nextInt(Constants.CountryCode.length);
	 		 System.out.println(Constants.CountryCode[code]);
	 		return Constants.CountryCode[code];
	 	 }
	 	 else
	 	 {
	 		 String code1 = faker.lorem().characters(2, 4, true, true).toUpperCase();
	 		 System.out.println(code1);
	 		 return code1;
	 	 }
	 }
	 public String creditRating()
	 {
	 	 int j=faker.number().numberBetween(4, 15);
	 	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 	 {
	 		return Alpha(j);
	 	 }
	 	 else
	 	 {
	 		String d = negAlpha(j);
			 return d;	
	 	 } 	
	 }
	 public String assessmentAgencyAuthority()
	 {

	 	 int j=faker.number().numberBetween(6, 20);
	 	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 	 {
	 		return Alpha(j);
	 	 }
	 	 else
	 	 {
	 		String d = negAlpha(j);
			 return d;
	 	 }
	 }
	 	
public String dateOfInternalRating() {

	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
       return dateAuth1();
	 }
	 else
	 {
		 String d = genDate();
		 return d;
	 }
}
public String npaSinceDate()
{
	if(Constants.typeOfData.equalsIgnoreCase("Y"))
	{
    return dateAuth1();
	}
	else {
		
		String d = genDate();
		 return d;
                 
		}
}
public String cummulativeRecoveriesNpa()
{

return double2();
}
public String accumulatedProvisions()
{
	return double2();	
}
public String accumulatedWriteOffs()
{
	return double2();
}
public String createSettlementAmount()
{
	return double2();
}
public String createRestructuringStatus()
{
	if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 int res = faker.random().nextInt(Constants.restruct.length);
		 System.out.println(Constants.restruct[res]);
		return Constants.restruct[res];
	 }
	 else
	 {
		 String genres = faker.lorem().characters(2, 4, true, true).toUpperCase();
		 System.out.println(genres);
		 return genres;
	 }
}
public String restructStatusDate()
{
	if(Constants.typeOfData.equalsIgnoreCase("Y"))
	{
		 return dateAuth1();
	}
	else {
		
		String d = genDate();
		 return d;
                 
		}
}
public String createStatusDate()
{
	if(Constants.typeOfData.equalsIgnoreCase("Y"))
	{
		 return dateAuth1();
	}
	else {
		
		String d = genDate();
		 return d;
                 
		}
}
public String createSuiteFieldDate()
{
	if(Constants.typeOfData.equalsIgnoreCase("Y"))
	{
		 return dateAuth1();
	}
	else {
		
		String d = genDate();
		 return d;
                 
		}
}
public String createAccountStatus()
{
	if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 int res = faker.random().nextInt(Constants.account.length);
		 System.out.println(Constants.account[res]);
		return Constants.account[res];
	 }
	 else
	 {
		 String genres = faker.lorem().characters(2, 4, true, true).toUpperCase();
		 System.out.println(genres);
		 return genres;
	 }
}
public String createBranchCode()
{

int j= faker.number().numberBetween(2, 10);

if(Constants.typeOfData.equalsIgnoreCase("Y"))
{

	return Alpha(j);
}
else {
	String d = negAlpha(j);
	return d;
}

}
public String createDistrictOfUtilisaton()
{

int j= faker.number().numberBetween(2, 3);

if(Constants.typeOfData.equalsIgnoreCase("Y"))
{

	return Alpha(j);
}
else {
	String d = negAlpha(j);
	return d;
}

}
public String createInstrumentType()
{
if(Constants.typeOfData.equalsIgnoreCase("Y"))
{
int ins = faker.random().nextInt(Constants.inst.length);
System.out.println(Constants.inst[ins]);
return Constants.inst[ins];
}
else
{
String instru = faker.lorem().characters(2, 4, true, true).toUpperCase();
System.out.println(instru);
return instru;
}

}
public String createPrioritySector()
{
if(Constants.typeOfData.equalsIgnoreCase("Y"))
{
int sector = faker.random().nextInt(Constants.priority.length);
System.out.println(Constants.priority[sector]);
return Constants.priority[sector];
}
else
{
String sec = faker.lorem().characters(2, 4, true, true).toUpperCase();
System.out.println(sec);
return sec;
}

}
public String createWeakerSection()
{
if(Constants.typeOfData.equalsIgnoreCase("Y"))
{
int weak = faker.random().nextInt(Constants.priority.length);
System.out.println(Constants.priority[weak]);
return Constants.priority[weak];
}
else
{
String wea = faker.lorem().characters(2, 4, true, true).toUpperCase();
System.out.println(wea);
return wea;
}

}
public String createClassificationOfActivity()
{
if(Constants.typeOfData.equalsIgnoreCase("Y"))
{
int act = faker.random().nextInt(Constants.activity.length);
System.out.println(Constants.activity[act]);
return Constants.activity[act];
}
else
{
String acti = faker.lorem().characters(2, 4, true, true).toUpperCase();
System.out.println(acti);
return acti;
}
}
public String createSanctionedDate()

{
	if(Constants.typeOfData.equalsIgnoreCase("Y"))
	{
		 return dateAuth1();
	}
	else {
		
		String d = genDate();
		 return d;
                 
		}
} 

public String createDisbursementDate()

{
	if(Constants.typeOfData.equalsIgnoreCase("Y"))
	{
		 return dateAuth1();
	}
	else {
		
		String d = genDate();
		 return d;
                 
		}
} 

public String createMaturityDate()
{
	if(Constants.typeOfData.equalsIgnoreCase("Y"))
	{
		 return dateAuth1();
	}
	else {
		
		String d = genDate();
		 return d;
                 
		}

}

public String createCurrencyCode()
{

	int j= faker.number().numberBetween(3, 3);
if(Constants.typeOfData.equalsIgnoreCase("Y")) 
{
	return Alpha(j);	
}
else {
	return negAlpha(j);
     }
}
public String createoriginalSanctionAmount()
{
	return double2();
}

public String createsyndicatedContractID()
{

int j= faker.number().numberBetween(4, 15);
	
	if(Constants.typeOfData.equalsIgnoreCase("Y")) 
	{
		return Alpha(j);	
	}
	else {
	
	String d = negAlpha(j);
	return d;
	     }
}

public String createrecourse()
{
if(Constants.typeOfData.equalsIgnoreCase("Y"))
{
	 int recourse = faker.random().nextInt(Constants.priority.length);
	 System.out.println(Constants.priority[recourse]);
	return Constants.priority[recourse];
}
else
{
	 String genrecourse = faker.lorem().characters(2, 4, true, true).toUpperCase();
	 System.out.println(genrecourse);
	 return genrecourse;
}
}

public String createintrestRateType()

{
if(Constants.typeOfData.equalsIgnoreCase("Y"))
{
	 int intrest = faker.random().nextInt(Constants.rateType.length);
	 System.out.println(Constants.rateType[intrest]);
	return Constants.rateType[intrest];
}
else
{
	 String genrate = faker.lorem().characters(2, 4, true, true).toUpperCase();
	 System.out.println(genrate);
	 return genrate;
}
}

public String createamortisationType()
{

if(Constants.typeOfData.equalsIgnoreCase("Y"))
{
int type = faker.random().nextInt(Constants.mortisation.length);
System.out.println(Constants.mortisation[type]);
return Constants.mortisation[type];
}
else
{
String gentype = faker.lorem().characters(2, 4, true, true).toUpperCase();
System.out.println(gentype);
return gentype;

}}

public String createpaymentFrequency()
{
if(Constants.typeOfData.equalsIgnoreCase("Y"))
{
	 int payment = faker.random().nextInt(Constants.paymentFrequency.length);
	 System.out.println(Constants.paymentFrequency[payment]);
	return Constants.paymentFrequency[payment];
}
else
{
	 String gentype = faker.lorem().characters(2, 4, true, true).toUpperCase();
	 System.out.println(gentype);
	 return gentype;
}
}
public String interestRate()
{
	return double1();
}
public String weightedAverageInterestRate()
{
	return double1();
}
public String installmentAmount()
{
	return double2();
}

public String  balanceOutstanding()
{
	return double2();
}
public String unavailedAmount()
{
	return double2();
}

public String  offBalanceSheetNominalAmount()
{
	return double2();
} 

public String  creditEquivalentOffBalanceSheetNominalAmount()
{
	return double2();
} 
public String accruedInterest()
{
	return double2();
} 	 
public String amountOverdue()
{ return double2();
} 	
public String numberOfDaysPastDue()
{
	return double1();
}
public String smaCategory()
{
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 int sc = faker.random().nextInt(Constants.sma.length);
		 System.out.println(Constants.sma[sc]);
		return Constants.sma[sc];
	 }
	 else
	 {
		 String s = faker.lorem().characters(2, 4, true, true).toUpperCase();
		 System.out.println(s);
		 return s;
	 }
	 
}
public String smaCurrentCategorySinceDate(){
	if(Constants.typeOfData.equalsIgnoreCase("Y"))
	{
      return dateAuth1();
	}
	else {
		
		String d = genDate();
		 return d;
                 
		}
	}


public String npaCategroyCode()
{
	if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 int ncc = faker.random().nextInt(Constants.npac.length);
		 System.out.println(Constants.npac[ncc]);
		return Constants.npac[ncc];
	 }
	 else
	 {
		 String npa = faker.lorem().characters(2, 4, true, true).toUpperCase();
		 System.out.println(npa);
		 return npa;
	 }
	 
}

public String negNum1() 

{
	String invalidNumber=invalidNumberlength(faker);
	int i=Integer.parseInt(invalidNumber);
	System.out.println(createdata(i,true,true,false));
	return createdata(i,true,true,false);
}
   public String panGeneration()
   {  String panNo;
	   if (Constants.typeOfData.equalsIgnoreCase("Y"))
	   {
		   panNo =faker.regexify("[A-Z]{3}[CPHFATBLJG]{1}[A-Z]{1}[0-9]{4}[A-Z]{1}");
		   //System.out.println(panNo);
		   return panNo;	   
	   }
	   else 
	   {
		   String number = faker.regexify(faker.number().numberBetween(3, 9)+"|10|"+faker.number().numberBetween(11, 15));
		   int intNumber = Integer.parseInt(number);
		   String data1 = faker.lorem().characters(intNumber,true,true).toUpperCase();
		   char[] data = data1. toCharArray();
		   System.out.println(data);
		   if (intNumber<=9)
		   {
			   panNo = withSpecialCharData(data, 3);
			   return panNo;
		   }
		   else if (intNumber>=11)
		   {
			   panNo = withSpecialCharData(data, 11);  
			   return panNo;

		   }
		   else
		   {
			   panNo = withSpecialCharData(data, 10);
			   return panNo;

		   }
		   
	   }
	  
	   }
private String withSpecialCharData(char[] data, int minLength) {
	if(Constants.RequiredSpecialChar)
	{
		for(int i=0;i<faker.random().nextInt(minLength);i++)
		{
			int x= faker.random().nextInt(data.length);
			int y= faker.random().nextInt(Constants.special.length);
			data[x]= Constants.special[y];
			System.out.println(data[x]);
		}
			System.out.println(new String(data));
			return new String(data);
		}
		else {
			return new String(data);
		}	
	}
public String adharValidate()
{  String adNo;
	   if (Constants.typeOfData.equalsIgnoreCase("Y"))
	   {
		    adNo = faker.regexify("[2-9]{1}[0-9]{3} [0-9]{4} [0-9]{4}");
		   System.out.println(adNo);
		   
	   }
	   else if (Constants.typeOfData.equalsIgnoreCase("N"))
	   {
		   String number = faker.regexify(faker.number().numberBetween(3, 11)+"|12|"+faker.number().numberBetween(13, 16));
		   int intNumber = Integer.parseInt(number);
		   String data1 = faker.lorem().characters(intNumber,true,true).toUpperCase();
		   char[] data = data1. toCharArray();
		   System.out.println(data);
		   if (intNumber<=11)
		   {
			   adNo = withSpecialCharData(data, 3);
		   }
		   else if (intNumber>=13)
		   {
			   adNo = withSpecialCharData(data, 13);  
		   }
		   else
		   {
			   adNo = withSpecialCharData(data, 12);
		   }
		   
	   }
	   else {
		   int firstPart= faker.number().numberBetween(0, 5);
		   int secondPart= faker.number().numberBetween(0, 6);
		   int thirdPart= faker.number().numberBetween(0, 4);
		   adNo = faker.regexify("[2-9]{1}[0-9]{3} [0-9]{4} [0-9]{4}");
		   String alphaNumericString = adNo;
		   Matcher alphaNumericMatcher = Pattern.compile("[2-9]{1}[0-9]{3} [0-9]{4} [0-9]{4}").matcher(alphaNumericString);
		   //System.out.println(alphaNumericMatcher.find());
		   boolean isValid = alphaNumericMatcher.find();
		  
	   }
	return adNo;
}

public String dateoftheme1()
{
	Date from = StringToDate("01011950");
	Date to = StringToDate("01012000");
	Date newData =  faker.date().between(from,to);
	DateFormat dateFormat = new SimpleDateFormat("YYYY/MM/dd");  
   String strDate = dateFormat.format(newData); 
   System.out.println(strDate);
   return strDate;

}

public String dateoftheme2()
{
	Date from = StringToDate("01011950");
	Date to = StringToDate("01012000");
	Date newData =  faker.date().between(from,to);
	DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");  
   String strDate = dateFormat.format(newData); 
   System.out.println(strDate);
return strDate;

}
public String dateoftheme3()
{
	Date from = StringToDate("01011950");
	Date to = StringToDate("01012000");
	Date newData =  faker.date().between(from,to);
	DateFormat dateFormat = new SimpleDateFormat("YYYYdd");  
   String strDate = dateFormat.format(newData); 
   System.out.println(strDate);
   return strDate;

}
public String dateoftheme4()
{
	Date from = StringToDate("01011950");
	Date to = StringToDate("01012000");
	Date newData =  faker.date().between(from,to);
	DateFormat dateFormat = new SimpleDateFormat("YYYYMM");  
   String strDate = dateFormat.format(newData); 
   System.out.println(strDate);
    return strDate;

}
public String dateoftheme5()
{
	Date from = StringToDate("01011950");
	Date to = StringToDate("01012000");
	Date newData =  faker.date().between(from,to);
	DateFormat dateFormat = new SimpleDateFormat("MMdd");  
   String strDate = dateFormat.format(newData); 
   System.out.println(strDate);
   return strDate;

}
public String dateoftheme6()
{
	Date from = StringToDate("01011950");
	Date to = StringToDate("01012000");
	Date newData =  faker.date().between(from,to);
	DateFormat dateFormat = new SimpleDateFormat("YYYY*MM*dd");  
   String strDate = dateFormat.format(newData); 
   System.out.println(strDate);
    return strDate;

}
public String dateoftheme7()
{
	Date from = StringToDate("01011950");
	Date to = StringToDate("01012000");
	Date newData =  faker.date().between(from,to);
	DateFormat dateFormat = new SimpleDateFormat("YYYY.MM.dd");  
    String strDate = dateFormat.format(newData); 
    System.out.println(strDate);
    return strDate;
}
public String dateoftheme8()
{
	Date from = StringToDate("01011950");
	Date to = StringToDate("01012000");
	Date newData =  faker.date().between(from,to);
	DateFormat dateFormat = new SimpleDateFormat("0000-00-00");  
   String strDate = dateFormat.format(newData); 
   System.out.println(strDate);
   return strDate;
}

public String dateoftheme9() {
	  Date date = new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat();
       String sdate = formatter.format(date);
	return sdate;	
	}
public String dateoftheme10()
{
	
	Date from = StringToDate("01011950");
	Date to = StringToDate("01012000");
	Date newData =  faker.date().between(from,to);
	DateFormat dateFormat = new SimpleDateFormat("YYYYMMdd");  
   String strDate = dateFormat.format(newData); 
   System.out.println(strDate);
    return strDate;
}
public String dateoftheme11()
{
	int k = faker.number().numberBetween(13, 40);
	int l = faker.number().numberBetween(32, 59);
	String xx = Integer.toString(k);
	String ll = Integer.toString(l);
	Date from = StringToDate("01011950");
	Date to = StringToDate("01012020");
	Date newData =  faker.date().between(from,to);
	DateFormat dateFormat = new SimpleDateFormat("YYYY");  
    String strDate = dateFormat.format(newData); 
    System.out.println(ll+xx+strDate);
    return strDate;
}


public void negdigit1(int j) {
	
    String v= null;
    int k = faker.number().numberBetween(1, 4);
	switch(k)
	
	{
	case 1: v =  conditionCheck2(j);
	        System.out.println(v);
	        break;
	case 2:  v=  conditionCheck4(j);
	        System.out.println(v);
	        break;      
	case 3:  v= conditionCheck3(j);
	         System.out.println(v);
	        break;
	case 4:   v= conditionCheck6(j);
		      System.out.println(v);
		        break;

}


}
public String genDate() {
	 String strDate = null;
	
		 int number = faker.number().numberBetween(1, 7);
			
			switch(number)
			{
		     
			case 1: strDate = dateoftheme1();
			        System.out.println(strDate);
			        
			        break;
			case 2: strDate= dateoftheme2();
			        System.out.println( strDate);
			        break;      
			case 3:  strDate= dateoftheme3();
	                 System.out.println( strDate);
	                break;
			case 4:   strDate= dateoftheme4();
	 		         System.out.println( strDate);
	 		        break;
			case 5:  strDate= dateoftheme5();
	                 System.out.println( strDate);
	                break;
			case 6:   strDate= dateoftheme6();
	                 System.out.println( strDate);
	                break;
			case 7:   strDate= dateoftheme7();
	                 System.out.println(strDate);
	                break;
			case 8:   strDate= dateoftheme8();
            System.out.println(strDate);
           break;
			case 9:   strDate= dateoftheme9();
            System.out.println(strDate);
           break;
           
			case 10:   strDate= dateoftheme10();
            System.out.println(strDate);
           break;
			case 11:   strDate= dateoftheme11();
            System.out.println(strDate);
           break;
           
	                 
	 }

	return strDate;

}
public String createGstin(String PanNo)
{  String gNo;

	   if (Constants.typeOfData.equalsIgnoreCase("Y"))
	   {
		   gNo =faker.regexify("[0-9]{2}[A-Z]{3}");
		  // System.out.println(gNo);
		   return gNo + PanNo;
		   
	   }
	   else 
	   {
		   String number = faker.regexify(faker.number().numberBetween(6, 14)+"|15|"+faker.number().numberBetween(16, 19));
		   int intNumber = Integer.parseInt(number);
		   String data1 = faker.lorem().characters(intNumber,true,true).toUpperCase();
		   char[] data = data1. toCharArray();
		   System.out.println(data);
		   if (intNumber<=15)
		   {
			   gNo = withSpecialCharData(data, 6);
			   return gNo;
		   }
		   else if (intNumber>=15)
		   {
			   gNo = withSpecialCharData(data, 16);  
			   return gNo;
		   }
		   else
		   {
			   gNo = withSpecialCharData(data, 15);
			   return gNo;

		   }
		   
       }	
}
public String mobileNumber()
{  String gNo;
	   if (Constants.typeOfData.equalsIgnoreCase("Y"))
	   {
		   String No =faker.regexify("((\\+){1}91){1}[1-9]{1}[0-9]{9}");
			System.out.println(faker.regexify(No));
			Matcher alphaNumericMatcher = Pattern.compile("((\\+){1}91){1}[1-9]{1}[0-9]{9}}").matcher(No);

			 boolean isValid = alphaNumericMatcher.find();
			 System.out.println(isValid);
			 if(isValid){
				 mobileNumber();
			 }
			 return No;
	   }
	   else 
	   {
		   String number = faker.regexify(faker.number().numberBetween(6, 11)+"|12|"+faker.number().numberBetween(13, 16));
		   int intNumber = Integer.parseInt(number);
		   String data1 = faker.lorem().characters(intNumber,true,true).toUpperCase();
		   char[] data = data1. toCharArray();
		   System.out.println(data);
		   if (intNumber<=12)
		   {
			   gNo = withSpecialCharData(data, 6);
			   return gNo;
		   }
		   else if (intNumber>=12)
		   {
			   gNo = withSpecialCharData(data, 16);  
			   return gNo;
		   }
		   else
		   {
			   gNo = withSpecialCharData(data, 12);
			   return gNo;

		   }
		   
       }	
}
public String Alpha(int j)
{
		String value = 	conditionCheck3(j);
		System.out.println(value);
		return value;
}

public String dateAuth1()
{
	
	Date from = StringToDate("01011950");
	Date to = StringToDate("01012000");
	Date newData =  faker.date().between(from,to);
	DateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");  
    String strDate = dateFormat.format(newData); 
    System.out.println(strDate);
	return strDate;
}
public String double1()
{
	 double j= faker.number().numberBetween(2, 5);
	 String d= Double.toString(j);
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 double value =conditionCheck7(j);
			System.out.println(d); 
	
	 }
	
	else {
	    int jk= faker.number().numberBetween(2, 5);
	       String x  = negdigit(jk);
	       return x;
		   }
	return d;
}
public String double2()
{
	 double j= faker.number().numberBetween(6, 17);
	 String d= Double.toString(j);
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 double value =conditionCheck7(j);
			System.out.println(d); 
	
	 }
	
	else {
	    int jk= faker.number().numberBetween(6, 17);
	       String x  = negdigit(jk);
	       return x;
		   }
	return d;
}
public HashMap<String,Integer> controlFile(String filePath) throws IOException  {
	int csv =0;
	int xlsx =0;
	int txt =0;
	
	String fileName;
	String extension = null;
	File directory = new File(filePath);
	HashSet<String> setOfExtension= new HashSet<String>();
	HashMap<String, Integer> hm = new HashMap<String, Integer>();
	
	File[] fileList = directory.listFiles();{
	for(File file : fileList)
	{
		fileName = file.toString();
		int index = fileName.lastIndexOf('.');
		if(index>0) 
		{
			extension = fileName.substring(index +1);
			int recordCount  = totalRecords(fileName);
			 if(fileName.contains("Contract")) {
		    	 hm.put("Contract File",recordCount-1);
		    }
		       if(fileName.contains("CounterParty")) {
		    	 hm.put("CounterParty File",recordCount-1);
		    } 
		       if(fileName.contains("CounterpartyRating")) {
		    	 hm.put("CounterpartyRating File",recordCount-1);
		    }  
		       if(fileName.contains("CounterpartyRisk")) {
		    	 hm.put("CounterpartyRisk File",recordCount-1);
		    }
		       if(fileName.contains("Instrument")) {
		    	 hm.put("Instrument File",recordCount-1);
		    }
		       if(fileName.contains("Protection.")) {
		    	 hm.put( "ProtectionFile",recordCount-1);
		    }  
		       if(fileName.contains("Protectioninstrument")) {
		    	 hm.put("Protectioninstrument File",recordCount-1);
		    }
		       
		       if(fileName.contains("RelatedParty")) {
		    	hm.put( "RelatedParty File",recordCount-1);
		    }
		       if(fileName.contains("Control")) {
		    	 hm.put("Control File",recordCount-1);
		    	 	 
		       } 
			
			if (extension.contains("csv")) {
				csv++;
				setOfExtension.add(extension);
			}
	  
			if (extension.contains("xlsx")) {
		
				xlsx++;
				setOfExtension.add(extension);
			}
			if (extension.contains("txt")) {
		
				txt++;
				setOfExtension.add(extension);
			}  
		}
	}
	
	for(String  extensions: setOfExtension) {
			if(extensions.equalsIgnoreCase("csv"))
				hm.put(".csv",csv );
			if(extensions.equalsIgnoreCase("xlsx"))
				hm.put( ".xlsx",xlsx);
			if(extensions.equalsIgnoreCase("txt"))
				hm.put(".txt",txt);
			   
			   
			
	
	}
	return hm;
}
}
private int totalRecords(String fileName) {
	int count = 0;
	 BufferedReader bufferedReader = null;
	try {
		bufferedReader = new BufferedReader(new FileReader(fileName));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    try {
		while((bufferedReader.readLine()) != null)
		{
		    count++;
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
	return count;
}

		
	
public  HashMap<String,Integer> controlFile1(String folderName) throws IOException {
	
	String filePath = System.getProperty("user.dir")+"\\ActualFileCreated\\"+folderName+"\\";
    HashMap<String,Integer> s = controlFile(filePath);
	
	return s;
	
}
public void ecp()
{
	int k = faker.number().numberBetween(13, 40);
	int l = faker.number().numberBetween(32, 59);
	String xx = Integer.toString(k);
	String ll = Integer.toString(l);
    System.out.println(xx);
    System.out.println(ll); 

}

public void num()
{
	 int totaldup;
     Faker f= new Faker();
     totaldup=f.number().numberBetween(1, 10);
     HashSet<Integer> ind = new HashSet<Integer>();
     for(int i=0;i<=totaldup;i++)
     {
     	ind.add(f.number().numberBetween(1, 10));
     }
   
	System.out.println(ind);
}
public String createRelation()
{
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 int rel = faker.random().nextInt(Constants.relation.length);
		 System.out.println(Constants.relation[rel]);
		return Constants.relation[rel];
	 }
	 else
	 {
		 String genrel = faker.lorem().characters(2, 4, true, true).toUpperCase();
		 System.out.println(genrel);
		 return genrel;
	 }
}
}

