package pojoClases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


import com.github.javafaker.Faker;

import test.Constants;



public class datacreation {
	//Faker faker = new Faker(new Locale("pt_US"));
	Faker faker =  new Faker();
	public String createReportingEntityId() {
		String parten = "3|5|4|9";
		if(Constants.typeOfData.equalsIgnoreCase("Y")) {
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
	return faker.address().buildingNumber();	
}
public String addressLine2() {
	return faker.address().streetAddress();	
}
public String addressLine3() {
	return faker.address().cityName();	
}
public String zipCode() {
	return faker.address().zipCode();	
}
public Date dateofBirth() {
	return faker.date().birthday(18, 98);
}
public String date() {
	//return faker.date().birthday(26, 87);
	Date from = StringToDate("01011950");
	Date to = StringToDate("01012000");
	Date newData =  faker.date().between(from,to);
	DateFormat dateFormat = new SimpleDateFormat("YYYYMMdd");  
    String strDate = dateFormat.format(newData);  
	return strDate;
	
}

public String emailAddress() {
	Faker faker = new Faker(new Locale("en_IND"));
	
	if (Constants.typeOfData.equalsIgnoreCase("Y"))
		return faker.internet().emailAddress();
	
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
public void createGSTN() {
	String d = faker.regexify("[0-9]{2}[a-zA-Z]{5}[0-9]{4}[a-zA-Z]{1}[1-9A-Za-z]{1}[Z]{1}[0-9a-zA-Z]{1}");
	String d1 =faker.regexify("([0]{1}[1-9]{1}|[1-2]{1}[0-9]{1}|[3]{1}[0-7]{1})([a-zA-Z]{5}[0-9]{4}[a-zA-Z]{1}[1-9a-zA-Z]{1}[zZ]{1}[0-9a-zA-Z]{1})");
	System.out.println(d1);
	
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
	String panNo = faker.regexify("[A-Z]{5}[0-9]{4}[A-Z]{1}");
	System.out.println(panNo);
	
}


public static void main(String[] args) {
	datacreation dt =  new datacreation();
	dt.createGSTN();
	//String email = dt.emailAddress();
	//System.out.println(email);
	//dt.pangenerate();
	

}



}
