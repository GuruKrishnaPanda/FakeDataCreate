package EntityDataSet;

import java.util.Hashtable;

import com.github.javafaker.Faker;

import ReUsable.DatabaseInsertion;
import ReUsable.datacreation;
import Utilities.DataUtil;
import Utilities.DuplicateDataCheck;
import Utilities.GenericXLSXReader;
import Utilities.Utils;

public class BaseClass {
	datacreation create ;
	GenericXLSXReader xls = new GenericXLSXReader(System.getProperty("user.dir")+"\\resources\\Configuration.xlsx");
	Hashtable<String, String> configurationData = DataUtil.getData("Configuration", xls);
	Hashtable<String, String> bankingInfo = DataUtil.getData("BankMapping", xls);
	//ArrayList<Hashtable<String, String>> masterData = DataUtil.getMasterdata();
	Hashtable<String, String> fieldValues;
	Faker faker = new Faker();
	Utils ut = new Utils();
	DuplicateDataCheck duplicatecheck = new DuplicateDataCheck();
	DatabaseInsertion dis = new DatabaseInsertion();
	
	String bankSymbol = bankingInfo.get(configurationData.get("Bank_Type"));

}
