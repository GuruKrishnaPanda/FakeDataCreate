package EntityDataSet;

import java.util.ArrayList;
import java.util.Hashtable;

import com.github.javafaker.Faker;

import ReUsable.DatabaseFunctions;
import ReUsable.ReadWrite;
import ReUsable.datacreation;
import Utilities.Constants;
import Utilities.DataUtil;
import Utilities.DuplicateDataCheck;
import Utilities.GenericXLSXReader;
import Utilities.Utils;

public class BaseClass {
	public BaseClass(Hashtable<String, String> data) {
		configurationData = data;
		bankSymbol = bankingInfo.get(configurationData.get("Bank_Type"));
		ut =  new Utils(data);
		duplicatecheck = new DuplicateDataCheck(data);
		rw =  new ReadWrite(data);
	}
	datacreation create ;
	GenericXLSXReader xls = new GenericXLSXReader(System.getProperty("user.dir")+"\\resources\\Configuration.xlsx");
	Hashtable<String, String> configurationData;
	Hashtable<String, String> bankingInfo = DataUtil.getData("BankMapping", xls);
	//ArrayList<Hashtable<String, String>> masterData = DataUtil.getMasterdata();
	Hashtable<String, String> fieldValues;
	Faker faker = new Faker();
	Utils ut ;//= new Utils();
	DuplicateDataCheck duplicatecheck; //= new DuplicateDataCheck();
	DatabaseFunctions dis = new DatabaseFunctions();
	String bankSymbol ;
	Constants cons = new Constants();
	ReadWrite rw ;//=  new ReadWrite();
	ArrayList<Integer> allIndexes = null;
	ArrayList<Integer> skippedData = null;
	ArrayList<Integer> temporaryprotectionIndexes =  null;
	ArrayList<Integer>  temporaryrelatedpartyIndexes =  null;
}