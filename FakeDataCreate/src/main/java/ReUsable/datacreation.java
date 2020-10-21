package ReUsable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
			return createdata(i, true, false, true);	
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
	Date from = StringToDate("01011950");
	Date to = StringToDate("01012000");
	Date newData =  faker.date().between(from,to);
	DateFormat dateFormat = new SimpleDateFormat("YYYYMMdd");  
    String strDate = dateFormat.format(newData); 
    System.out.println(strDate);
	return strDate;
	
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
public void pangenerate() {
	Faker faker = new Faker();
	String panNo = faker.regexify("[A-Z]{5}[0-9]{4}[A-Z]{1}");
	System.out.println(panNo);
	System.out.println(faker.regexify(panNo));
	 
}

public void validPan()
{
	{
		String panNo =faker.regexify("([A-Z]{4}[0-9]{4}[A-Z]{1}|[A-Z]{5}[0-9]{4}[0-9]{1}|[A-Z]{8}[0-9]{0}[A-Z]{2}|[A-Z]{5}[@#]{4}[A-Z]{1}|[a-z]{5}[0-9]{4}[A-Z]{1})");
		System.out.println(panNo);
		System.out.println(faker.regexify(panNo));
		
	}
}
public String validatepan()
{


String panNo =faker.regexify("[A-Z]{5}[0-9]{4}[A-Z]{1}");
	if (Constants.typeOfData.equalsIgnoreCase("Y"))
		
System.out.println(faker.regexify(panNo));
	
	
	else {
	int num=faker.number().numberBetween(0, 9);
	String invalidPan= Constants.page[num];
	
	System.out.println(faker.regexify(invalidPan));
	System.out.print(invalidPan); 
	
	}
	return panNo;
}
public String createContractIdentifier() 
{

	
	int j= faker.number().numberBetween(5, 36);
	
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
	else {
		String invalidNumber = invalidNumberlength(faker);
		int i=Integer.parseInt(invalidNumber); 
		return createdata(i, true, false, true);	
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
public String adharGenerate() {
	
	String aNo =faker.regexify("[2-9]{1}[0-9]{3} [0-9]{4} [0-9]{4}");
	if (Constants.typeOfData.equalsIgnoreCase("Y"))
		
System.out.println(faker.regexify(aNo));
	
	
	else {
	
	
	}
	return aNo;
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
			return createdata(i, true, false, true);	
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
 { int j= faker.number().numberBetween(5, 5);
 if(Constants.typeOfData.equalsIgnoreCase("Y"))
 {
	 String value = conditionCheck5(j);
		System.out.println(value); 
		return value;
 }
 else
 {
	 String invalidNumber = invalidNumberlength(faker);
		int i=Integer.parseInt(invalidNumber); 
		return createdata(i, true, false, true);	
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
			
				return createdata(10, true, false, true);	
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
			
				return createdata(10, true, false, true);	
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
			
				return createdata(10, true, false, true);	
			     }
	 }
	 public String createRelatedCounterepartyId()
	 {
		 int j= faker.number().numberBetween(5, 21);
			
		String val = createAlpha();
		return val;
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
	 		return createdata(10, true, false, true);
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
			
				return createdata(10, true, false, true);	
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
			Date from = StringToDate("01011950");
			Date to = StringToDate("01012000");
			Date newData =  faker.date().between(from,to);
			DateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");  
		    String strDate = dateFormat.format(newData); 
		    System.out.println(strDate);
			return strDate;
			
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
		 Date from = StringToDate("01011950");
			Date to = StringToDate("01012000");
			Date newData =  faker.date().between(from,to);
			DateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");  
		    String strDate = dateFormat.format(newData); 
		    System.out.println(strDate);
			return strDate;

	 }
	 public String createprotectionRegistryId()
	 {
		 int j= faker.number().numberBetween(8,15);
			
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
			
				return createdata(10, true, false, true);	
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

	Date from = StringToDate("01012000");
	Date to = StringToDate("01012020");
	Date newData =  faker.date().between(from,to);
	DateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");  
    String strDate = dateFormat.format(newData); 
    System.out.println(strDate);
	return strDate;
	
}
public String createwilfulDefaulter()
{
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 int wil = faker.random().nextInt(Constants.wilful.length);
		 System.out.println(Constants.wilful[wil]);
		return Constants.wilful[wil];
	 }
	 else
	 {
		 String wilfu = faker.lorem().characters(2, 4, true, true).toUpperCase();
		 System.out.println(wilfu);
		 return wilfu;
	 }

}
public String dateOfWilfulDefaulterClassification() {

	Date from = StringToDate("01012000");
	Date to = StringToDate("01012020");
	Date newData =  faker.date().between(from,to);
	DateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");  
    String strDate = dateFormat.format(newData); 
    System.out.println(strDate);
	return strDate;
	
}
public String createnonCooperativeBorrower()
{
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 int nonc = faker.random().nextInt(Constants.non.length);
		 System.out.println(Constants.non[nonc]);
		return Constants.non[nonc];
	 }
	 else
	 {
		 String nonco = faker.lorem().characters(2, 4, true, true).toUpperCase();
		 System.out.println(nonco);
		 return nonco;
	 }

}
public String dateOfNonCooperativeBorrowerClassification() {

	Date from = StringToDate("01012000");
	Date to = StringToDate("01012020");
	Date newData =  faker.date().between(from,to);
	DateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");  
    String strDate = dateFormat.format(newData); 
    System.out.println(strDate);
	return strDate;
	
}
public String createFradulentActivity()
{
	 if(Constants.typeOfData.equalsIgnoreCase("Y"))
	 {
		 int frad = faker.random().nextInt(Constants.fradulent.length);
		 System.out.println(Constants.fradulent[frad]);
		return Constants.fradulent[frad];
	 }
	 else
	 {
		 String fra = faker.lorem().characters(2, 4, true, true).toUpperCase();
		 System.out.println(fra);
		 return fra;
	 }

}
public String dateOfFradulentActivityClassification() {

	Date from = StringToDate("01012000");
	Date to = StringToDate("01012020");
	Date newData =  faker.date().between(from,to);
	DateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");  
    String strDate = dateFormat.format(newData); 
    System.out.println(strDate);
	return strDate;
	
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
	 	
 		Date from = StringToDate("01011990");
 		Date to = StringToDate("01012010");
 		Date newData =  faker.date().between(from,to);
 		DateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");  
 	    String appDate = dateFormat.format(newData); 
 	    System.out.println(appDate);
 		return appDate;
 		
 	}
 	public String creditRatingExpiryDate()
 	 {
 		Date from = StringToDate("01011990");
 		Date to = StringToDate("01012010");
 		Date newData =  faker.date().between(from,to);
 		DateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");  
 	    String expDate = dateFormat.format(newData); 
 	    System.out.println(expDate);
 		return expDate;
 		  
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
			 return createdata(10, true, false, true);	
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
	 		return createdata(10, true, false, true);	
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
	 		return createdata(10, true, false, true);	
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
	 		return createdata(10, true, false, true);	
	 	 }
	 }
	 	
public String dateOfInternalRating() {

	Date from = StringToDate("01012000");
	Date to = StringToDate("01012020");
	Date newData =  faker.date().between(from,to);
	DateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");  
    String strDate = dateFormat.format(newData); 
    System.out.println(strDate);
	return strDate;
	
}}

