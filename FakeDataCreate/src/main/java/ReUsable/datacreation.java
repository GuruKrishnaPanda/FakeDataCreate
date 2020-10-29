package ReUsable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.javafaker.Faker;

import Utilities.Constants;

public class datacreation {
	//Faker faker = new Faker(new Locale("pt_US"));
	Faker faker =  new Faker();
	public String createReportingEntityId() 
	{
		String parten = "3|5|4|9";
		
		if(Constants.typeOfData.equalsIgnoreCase("Y")) 
		{
			faker.regexify("3|5|4|9");
			String d = faker.regexify("3|5|4|9");
			int i=Integer.parseInt(d); 
			System.out.println(i);
					if(Constants.haveSpecialChar.equalsIgnoreCase("Y")&&Constants.haveDigit.equalsIgnoreCase("N")&&Constants.havechar.equalsIgnoreCase("N"))
						return createdata(i, false, true, false);
					if (Constants.haveSpecialChar.equalsIgnoreCase("Y")&&Constants.haveDigit.equalsIgnoreCase("Y")&&Constants.havechar.equalsIgnoreCase("N"))
						return createdata(i, false, true, true);
					if (Constants.haveSpecialChar.equalsIgnoreCase("N")&&Constants.haveDigit.equalsIgnoreCase("Y")&&Constants.havechar.equalsIgnoreCase("Y"))
						return createdata(i, true, false, true);
					if (Constants.haveSpecialChar.equalsIgnoreCase("N")&&Constants.haveDigit.equalsIgnoreCase("N")&&Constants.havechar.equalsIgnoreCase("Y"))
						return createdata(i, true, false, false);
					if (Constants.haveSpecialChar.equalsIgnoreCase("N")&&Constants.haveDigit.equalsIgnoreCase("Y")&&Constants.havechar.equalsIgnoreCase("N"))
						return faker.number().digits(i);
					if (Constants.haveSpecialChar.equalsIgnoreCase("Y")&&Constants.haveDigit.equalsIgnoreCase("Y")&&Constants.havechar.equalsIgnoreCase("Y"))
						return createdata(i, true, true, true);	
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
            char[] special = new char[]{'!', '@', '#', '$', '%', '^', '&', '*', '}', '/','+','=','~','`','(',')','-','_','<','>',',','.','|'};
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
	String  strDate=null;
	if(Constants.typeOfData.equalsIgnoreCase("Y"))
	{
	Date from = StringToDate("01011950");
	Date to = StringToDate("01012000");
	Date newData =  faker.date().between(from,to);
	DateFormat dateFormat = new SimpleDateFormat("YYYYMMdd");  
     strDate = dateFormat.format(newData); 
    System.out.println(strDate);

	return strDate;
	}
	else {
		
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
                 
		}
		
	}
	return  strDate;
	
	
	
	
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
public String createGstin() {
	String d = faker.regexify("[0-9]{2}[a-zA-Z]{5}[0-9]{4}[a-zA-Z]{1}[1-9A-Za-z]{1}[Z]{1}[0-9a-zA-Z]{1}");
	String d1 =faker.regexify("([0]{1}[1-9]{1}|[1-2]{1}[0-9]{1}|[3]{1}[0-7]{1})([a-zA-Z]{5}[0-9]{4}[a-zA-Z]{1}[1-9a-zA-Z]{1}[zZ]{1}[0-9a-zA-Z]{1})");
	System.out.println(d);
	System.out.println(faker.regexify(d));
	return d;
	
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
		String value = conditionCheck3(j);
		System.out.println(value);
			return value;
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
		 String value = 	conditionCheck3(j);
		System.out.println(value);
		return value;
	}
	else 
	{
		String d= negAlpha(j);
	 return d;	
	}
}

public String countryCode()
{
	String value =  faker.country().countryCode3();
	System.out.println(value);
	return value;
}

 public String createName()
{
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

public String legalEntityIdentifier()
{
int j= faker.number().numberBetween(6, 20);
	
	if(Constants.typeOfData.equalsIgnoreCase("Y")) 
	{
		
		System.out.println(j);
		String value = 	conditionCheck3(j);
		System.out.println(value);
		return value;
		
	}
	else {
		String invalidNumber = invalidNumberlength(faker);
		int i=Integer.parseInt(invalidNumber); 
		return createdata(i, true, false, true);	
	     }

}
public String companyIdentificationNumber()
{

int j= faker.number().numberBetween(4, 21);
	
	if(Constants.typeOfData.equalsIgnoreCase("Y")) 
	{
		
		String value = 	conditionCheck3(j);
		System.out.println(value);
		return value;
	}
	else {
		String invalidNumber = invalidNumberlength(faker);
		int i=Integer.parseInt(invalidNumber); 
		return createdata(i, true, false, true);	
	     }
	
}
public String udyogAdharNumber()
{
int j= faker.number().numberBetween(3, 12);
	
	if(Constants.typeOfData.equalsIgnoreCase("Y")) 
	{
		
		String value = 	conditionCheck5(j);
		System.out.println(value);
		return value;
	}
	else {
		String invalidNumber = invalidNumberlength(faker);
		int i=Integer.parseInt(invalidNumber); 
		return createdata(i, true, false, true);
		
	     }

}
public String taxCollectionAccountNumber()
{
int j= faker.number().numberBetween(4, 10);
	
	if(Constants.typeOfData.equalsIgnoreCase("Y")) 
	{
		
		
		String value = 	conditionCheck3(j);
		System.out.println(value);
		return value;
		
	}
	else {
		String invalidNumber = invalidNumberlength(faker);
		int i=Integer.parseInt(invalidNumber); 
		return createdata(i, true, false, true);	
	     }
	
}
 public String nicCode()
 {
	 int j= faker.number().numberBetween(4, 5);
		
		if(Constants.typeOfData.equalsIgnoreCase("Y")) 
		{
			
			System.out.println(j);
			String value = 	conditionCheck3(j);
			System.out.println(value);
			return value;
			
		}
		else {
			String invalidNumber = invalidNumberlength(faker);
			int i=Integer.parseInt(invalidNumber); 
			System.out.println(createdata(i, false, true, true));
			return createdata(i, false, true, true);	
		     }

 } 
 public String districtCode()
 {
	 int j= faker.number().numberBetween(3, 3);
		
		if(Constants.typeOfData.equalsIgnoreCase("Y")) 
		{
			
			
			String value = 	conditionCheck3(j);
			System.out.println(value);
			return value;
			
		}
		else {
			String invalidNumber = invalidNumberlength(faker);
			int i=Integer.parseInt(invalidNumber); 
			return createdata(i, true, false, true);	
		     }
	
 }


 
 public String createDIN()
 {
	 int j= faker.number().numberBetween(3, 8);
		
			String val = createNumeric();
			
			return val;
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
	  value = conditionCheck5(j);
		System.out.println(value); 
		return value;
 }
 else
 {
	 
	 for(int k =0;k<=4;k++)
	 switch(k)
	 {
	  
	 case 1: String v =  conditionCheck2(j);
	         System.out.println(v);
	         break;
	 case 2: String v1=  conditionCheck4(j);
	         System.out.println(v1);
	         break;      
	 case 3: String v2= conditionCheck3(j);
	          System.out.println(v2);
	         break;
	 case 4:  String v3= conditionCheck6(j);
	 	         System.out.println(v3);
	 	        break;
 }
 }
 return value;
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
		 String invalidNumber = invalidNumberlength(faker);
			int i=Integer.parseInt(invalidNumber); 
			return createdata(i, true, false, true);	
	 }
	
 }
 public String mobileNumber()
 {
	 
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
			return "InsideElse";
		}
		
 }
 public String landmobileNumber()
 { 
	 String No =null;
	
	 if (Constants.typeOfData.equalsIgnoreCase("Y")) {
		 No= faker.regexify("[0-9]\\d{2,4}-\\d{6,8}");
		 System.out.print(faker.regexify(No));

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
		 String invalidNumber = invalidNumberlength(faker);
			int i=Integer.parseInt(invalidNumber); 
			return createdata(i, true, false, true);	
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
				return createdata(10, true, false, true);	
		 } 
	 }
	 public String createProtectionId()
	 {
		 int j= faker.number().numberBetween(5, 15);
			
			if(Constants.typeOfData.equalsIgnoreCase("Y")) 
			{
				
				
				String value = 	conditionCheck3(j);
				System.out.println(value);
				return value;
				
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
			 String value = conditionCheck5(j);
				System.out.println(value); 
				return value;
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
				
				
				String value = 	conditionCheck3(j);
				System.out.println(value);
				return value;
				
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
		String val = createAlpha();
		return val;
		 }
		 else
		 {
				String d = negAlpha(j);
				 return d;
		 }
	 }
	 public String createNumeric()
	 {
		 int j= faker.number().numberBetween(3, 8);
			
			if(Constants.typeOfData.equalsIgnoreCase("Y")) 
			{
				
				String value = 	conditionCheck5(j);
				System.out.println(value);
				return value;
			}
			else {
			
				return createdata(10, true, false, true);	
			     }
	 }
	 		
public String createAlpha()
	 {
		 int j= faker.number().numberBetween(5, 21);
			
			if(Constants.typeOfData.equalsIgnoreCase("Y")) 
			{
				
				
				String value = 	conditionCheck3(j);
				System.out.println(value);
				return value;
				
			}
			else {
			
				return createdata(10, true, false, true);	
			     } 
	 }
	
	 public String createprotectionProviderId()
	 {

	 int j= faker.number().numberBetween(1, 15);
	 	
	 	if(Constants.typeOfData.equalsIgnoreCase("Y")) 
	 	{
	 		
	 		String value = 	conditionCheck3(j);
	 		System.out.println(value);
	 		return value;
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
				String value = 	conditionCheck3(j);
				System.out.println(value);
				return value;		
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
	
		 double j= faker.number().numberBetween(10, 17);
		 String d= Double.toString(j);
		 if(Constants.typeOfData.equalsIgnoreCase("Y"))
		 {
			 double value =conditionCheck7(j);
				System.out.println(value); 
			
		 }
		 else
		 {
		

			
		}
		return d;
				
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
			Date from = StringToDate("01011950");
			Date to = StringToDate("01012000");
			Date newData =  faker.date().between(from,to);
			DateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");  
		    String strDate = dateFormat.format(newData); 
		    System.out.println(strDate);
			return strDate;
		 }
		 else {
			 String d = genDate();
			 return d;
		                 
				}
		 }
	
	
	  
	 
	 public String createoriginalProtectionValue()
	  {
		 double j= faker.number().numberBetween(10, 17);
		 String d= Double.toString(j);
		 if(Constants.typeOfData.equalsIgnoreCase("Y"))
		 {
			 double value =conditionCheck7(j);
				System.out.println(value); 
		
		 }
		 else
		 {
			
		 }
		return d;
	 
 }
	 public String createdateOfOriginalProtectionValu()
	 {
	
		 if(Constants.typeOfData.equalsIgnoreCase("Y"))
		 {
		 Date from = StringToDate("01011950");
			Date to = StringToDate("01012000");
			Date newData =  faker.date().between(from,to);
			DateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");  
		    String strDate = dateFormat.format(newData); 
		    System.out.println(strDate);
			return strDate;
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
				String value = 	conditionCheck3(j);
				System.out.println(value);
				return value;		
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
				String value = 	conditionCheck3(j);
				System.out.println(value);
				return value;		
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
	 Date from = StringToDate("01011950");
		Date to = StringToDate("01012000");
		Date newData =  faker.date().between(from,to);
		DateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");  
	     strDate = dateFormat.format(newData); 
	    System.out.println(strDate);
		return strDate;
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
	 Date from = StringToDate("01011950");
		Date to = StringToDate("01012000");
		Date newData =  faker.date().between(from,to);
		DateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");  
	     strDate = dateFormat.format(newData); 
	    System.out.println(strDate);
		return strDate;
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
	 Date from = StringToDate("01011950");
		Date to = StringToDate("01012000");
		Date newData =  faker.date().between(from,to);
		DateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");  
	     strDate = dateFormat.format(newData); 
	    System.out.println(strDate);
		return strDate;
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
	 Date from = StringToDate("01011950");
		Date to = StringToDate("01012000");
		Date newData =  faker.date().between(from,to);
		DateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");  
	    String strDate = dateFormat.format(newData); 
	    System.out.println(strDate);
		return strDate;
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
		 Date from = StringToDate("01011950");
			Date to = StringToDate("01012000");
			Date newData =  faker.date().between(from,to);
			DateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");  
		   String  strDate = dateFormat.format(newData); 
		    System.out.println(strDate);
			return strDate;
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
		 Date from = StringToDate("01011950");
			Date to = StringToDate("01012000");
			Date newData =  faker.date().between(from,to);
			DateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");  
		    String strDate = dateFormat.format(newData); 
		    System.out.println(strDate);
			return strDate;
		 }
		 else
		 {
			 String d = genDate();
			 return d;
		 }

 	 }
 	public String createCouterpartyIdentifier()
	 {
 	
		 int j=faker.number().numberBetween(3, 15);
		 if(Constants.typeOfData.equalsIgnoreCase("Y"))
		 {
			String value = conditionCheck3(j).toUpperCase();
				System.out.println(value);
				return value;
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
	 		 String value = conditionCheck3(j).toUpperCase();
	 			System.out.println(value);
	 			return value;
	 	 }
	 	 else
	 	 {
	 		String d = negAlpha(j);
			 return d;
	 	 }
	 	
	 	
	 }
	 public String creditRating()
	 {

	 	 int j=faker.number().numberBetween(4, 15);
	 	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 	 {
	 		 String value = conditionCheck3(j).toUpperCase();
	 			System.out.println(value);
	 			return value;
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
	 		 String value = conditionCheck3(j).toUpperCase();
	 			System.out.println(value);
	 			return value;
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
	 Date from = StringToDate("01011950");
		Date to = StringToDate("01012000");
		Date newData =  faker.date().between(from,to);
		DateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");  
	    String strDate = dateFormat.format(newData); 
	    System.out.println(strDate);
		return strDate;
	 }
	 else
	 {
		 String d = genDate();
		 return d;
	 }
}
public String npaSinceDate()
{
	Date from = StringToDate("01011970");
	Date to = StringToDate("01012020");
	Date newData =  faker.date().between(from,to);
	DateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");  
    String strDate = dateFormat.format(newData); 
    System.out.println(strDate);
	return strDate;
}
public String cummulativeRecoveriesNpa()
{

	 double j= faker.number().numberBetween(10, 17);
	 String d= Double.toString(j);
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 double value =conditionCheck7(j);
			System.out.println(value); 
	 }

	return d;	
}
public String accumulatedProvisions()
{
	double j= faker.number().numberBetween(12, 17);
	 String d= Double.toString(j);
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 double value =conditionCheck7(j);
			System.out.println(value); 
	 }

	return d;	
}
public String accumulatedWriteOffs()
{
	double j= faker.number().numberBetween(12, 17);
	 String d= Double.toString(j);
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 double value =conditionCheck7(j);
			System.out.println(value); 
	 }

	return d;	
}
public String createSettlementAmount()
{
	double j= faker.number().numberBetween(10, 17);
	 String d= Double.toString(j);
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 double value =conditionCheck7(j);
			System.out.println(value); 
	 }

	return d;	
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
	Date from = StringToDate("01012000");
	Date to = StringToDate("01012020");
	Date newData =  faker.date().between(from,to);
	DateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");  
    String strDate = dateFormat.format(newData); 
    System.out.println(strDate);
	return strDate;
}
public String createStatusDate()
{
	Date from = StringToDate("01012000");
	Date to = StringToDate("01012020");
	Date newData =  faker.date().between(from,to);
	DateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");  
    String strDate = dateFormat.format(newData); 
    System.out.println(strDate);
	return strDate;
}
public String createSuiteFieldDate()
{
	Date from = StringToDate("01012000");
	Date to = StringToDate("01012020");
	Date newData =  faker.date().between(from,to);
	DateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");  
    String strDate = dateFormat.format(newData); 
    System.out.println(strDate);
	return strDate;
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

String value = conditionCheck3(j);
System.out.println(value);
return value;
}
else {
String invalidNumber = invalidNumberlength(faker);
int i=Integer.parseInt(invalidNumber);
return createdata(i, true, false, true);
}

}
public String createDistrictOfUtilisaton()
{

int j= faker.number().numberBetween(2, 3);

if(Constants.typeOfData.equalsIgnoreCase("Y"))
{

String value = conditionCheck3(j);
System.out.println(value);
return value;
}
else {
String invalidNumber = invalidNumberlength(faker);
int i=Integer.parseInt(invalidNumber);
return createdata(i, true, false, true);
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
	 Date from = StringToDate("01011950");
		Date to = StringToDate("01012000");
		Date newData =  faker.date().between(from,to);
		DateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");  
	    String strDate = dateFormat.format(newData); 
	    System.out.println(strDate);
		return strDate;

} 

public String createDisbursementDate()

{
Date from = StringToDate("01011950");
	Date to = StringToDate("01012000");
	Date newData =  faker.date().between(from,to);
	DateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");  
   String strDate = dateFormat.format(newData); 
   System.out.println(strDate);
	return strDate;

} 

public String createMaturityDate()
{
Date from = StringToDate("01011950");
	Date to = StringToDate("01012000");
	Date newData =  faker.date().between(from,to);
	DateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");  
   String strDate = dateFormat.format(newData); 
   System.out.println(strDate);
	return strDate;

}

public String createCurrencyCode()
{

int j= faker.number().numberBetween(3, 3);

if(Constants.typeOfData.equalsIgnoreCase("Y")) 
{
	String value = 	conditionCheck4(j);
	System.out.println(value);
	return value;		
}
else {

	return createdata(10, true, false, true);
     }
}
public String createoriginalSanctionAmount()

{
	 double j= faker.number().numberBetween(10, 17);
	 String d= Double.toString(j);
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 double value =conditionCheck7(j);
			System.out.println(value); 
	
	 }
	 else
	 {
		
		}
	return d;
}

public String createsyndicatedContractID()
{

int j= faker.number().numberBetween(4, 15);
	
	if(Constants.typeOfData.equalsIgnoreCase("Y")) 
	{
		String value = 	conditionCheck3(j);
		System.out.println(value);
		return value;		
	}
	else {
	
		return createdata(10, true, false, true);	
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
	 double j= faker.number().numberBetween(2, 5);
	 String d= Double.toString(j);
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
		
	 {
		 double value =conditionCheck7(j);
			System.out.println(d); 
		
	 }
	
	else {
			
	
		   }
	return d;
}
public String weightedAverageInterestRate()
{
	 double j= faker.number().numberBetween(2, 5);
	 String d= Double.toString(j);
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 double value =conditionCheck7(j);
			System.out.println(d); 
	
	 }
	
	else {
			
		
		   }
	return d;
}
public String installmentAmount()
{
	 double j= faker.number().numberBetween(6, 17);
	 String d= Double.toString(j);
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 double value =conditionCheck7(j);
			System.out.println(d); 
			
	 }
	
	else {
			
			
		   }
	return d;
}

public String  balanceOutstanding()
{
	 double j= faker.number().numberBetween(6, 17);
	 String d= Double.toString(j);
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 double value =conditionCheck7(j);
			System.out.println(d); 
		
	 }
	
	else {
			
			
		   }
	return d;
}


public String unavailedAmount()
{
	 double j= faker.number().numberBetween(6, 17);
	 String d= Double.toString(j);
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 double value =conditionCheck7(j);
			System.out.println(d); 
			
	 }
	
	else {
			
		
		   }
	return d;
}

public String  offBalanceSheetNominalAmount()
{
	 double j= faker.number().numberBetween(6, 17);
	 String d= Double.toString(j);
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 double value =conditionCheck7(j);
			System.out.println(d); 
			
	 }
	
	else {
			
			
		   }
	return d;
} 

public String  creditEquivalentOffBalanceSheetNominalAmount()
{
	 double j= faker.number().numberBetween(6, 17);
	 String d= Double.toString(j);
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 double value =conditionCheck7(j);
			System.out.println(d); 
			
	 }
	
	else {
			
			
		   }
	return d;
} 


public String accruedInterest()
{
	 double j= faker.number().numberBetween(6, 17);
	 String d= Double.toString(j);
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 double value =conditionCheck7(j);
			System.out.println(d); 
			
	 }
	
	else {
			
			
		   }
	return d;
} 	 
public String amountOverdue()
{ double j= faker.number().numberBetween(6, 17);
String d= Double.toString(j);
if(Constants.typeOfData.equalsIgnoreCase("Y"))
{
	 double value =conditionCheck7(j);
		System.out.println(d); 
		
}

else {
		
		
	   }
return d;
} 	
public String numberOfDaysPastDue()
{
int j= faker.number().numberBetween(2, 5);
	
	if(Constants.typeOfData.equalsIgnoreCase("Y")) 
	{
		
		String value = 	conditionCheck5(j);
		System.out.println(value);
		return value;
	}
	else {
		String invalidNumber = invalidNumberlength(faker);
		int i=Integer.parseInt(invalidNumber); 
		return createdata(i, true, false, true);
		
	     }
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
 	
		Date from = StringToDate("01011990");
		Date to = StringToDate("01012010");
		Date newData =  faker.date().between(from,to);
		DateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");  
	    String strDate = dateFormat.format(newData); 
	    System.out.println(strDate);
		return strDate;
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
   public String pangenerate2()
   {  String panNo;
	   if (Constants.typeOfData.equalsIgnoreCase("Y"))
	   {
		    panNo =faker.regexify("[A-Z]{5}[0-9]{4}[A-Z]{1}");
		   System.out.println(panNo);
		   return panNo;
		   
	   }
	   else 
	   {
		   String number = faker.regexify(faker.number().numberBetween(3, 9)+"|10|"+faker.number().numberBetween(11, 15));
		   int intNumber = Integer.parseInt(number);
		   //char[] data = faker.regexify("[A-Z0-9]{​​​​​"+intNumber+"}​​​​​").toCharArray();
		   //char[] data = faker.lorem().characters(intNumber,true,true).toCharArray();
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
		    adNo = faker.regexify("​​​​​[2-9]{1}[0-9]{3} [0-9]{4} [0-9]{4}");
		   System.out.println(adNo);
		   
	   }
	   else if (Constants.typeOfData.equalsIgnoreCase("N"))
	   {
		   String number = faker.regexify(faker.number().numberBetween(3, 11)+"|12|"+faker.number().numberBetween(13, 16));
		   int intNumber = Integer.parseInt(number);
		   //char[] data = faker.regexify("[A-Z0-9]{​​​​​"+intNumber+"}​​​​​").toCharArray();
		   //char[] data = faker.lorem().characters(intNumber,true,true).toCharArray();
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
		   //panNo = faker.regexify("[A-Z]{​​​​​"+firstPart+"}​​​​​[0-9]{​​​​​"+secondPart+"}​​​​​[A-Z]{​​​​​"+thirdPart+"}​​​​​");
		   adNo = faker.regexify("[2-9]{1}[0-9]{3} [0-9]{4} [0-9]{4}​​​​​");
		   String alphaNumericString = adNo;
		   Matcher alphaNumericMatcher = Pattern.compile("[2-9]{1}[0-9]{3} [0-9]{4} [0-9]{4}​​​​​").matcher(alphaNumericString);
		   //System.out.println(alphaNumericMatcher.find());
		   boolean isValid = alphaNumericMatcher.find();
		   if(isValid)
		   {
			   adharValidate();
		   }
		   else {
			   System.out.println("-----------");
		   }
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
	                 
	 }

	return strDate;

}
}

