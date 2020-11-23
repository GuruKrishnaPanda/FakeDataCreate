package test;

import com.github.javafaker.Faker;

public class TestDataCreate {

	public static void main(String[] args) {
		Faker f = new Faker();
		
		for (int i = 0; i<10;i++) {
				String d = f.regexify("([A-Z]){4}([A-Z]){2}([0-9A-Z]){2}([0-9A-Z]{3}?)-\\d{4}");
				String ssn = f.regexify("[0-8]\\d{2}-\\d{2}-\\d{4}");
				System.out.println(d);
				System.out.println(ssn);
				System.out.println(f.name().fullName());
				System.out.println(f.regexify("(HDFC|ICICI)"));
				System.out.println("------------------------------------------------");
	}
	}
		
	
		public class EnIdNumber {
		    private  final String[] invalidSSNPatterns = {
		            "0{3}-\\\\d{2}-\\\\d{4}",
		            "\\d{3}-0{2}-\\d{4}",
		            "\\d{3}-\\d{2}-0{4}",
		            "666-\\d{2}-\\d{4}",
		            "9\\d{2}-\\d{2}-\\d{4}"};

		    public String getValidSsn(Faker f) {
		        String ssn = f.regexify("[0-8]\\d{2}-\\d{2}-\\d{4}");

		        boolean isValid = true;
		        for (String invalidSSNPattern : invalidSSNPatterns) {
		            if (ssn.matches(invalidSSNPattern)) {
		                isValid = false;
		                break;
		            }
		        }
		        if (!isValid) {
		            ssn = getValidSsn(f);
		        }
		        return ssn;
		    }
		}
}
