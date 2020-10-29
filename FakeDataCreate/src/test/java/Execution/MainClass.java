package Execution;

import java.util.Hashtable;



import ReUsable.ReusableFactory;
import ReUsable.datacreation;
import Utilities.Constants;
import Utilities.DataUtil;
import Utilities.GenericXLSXReader;
import Utilities.Utils;


public class MainClass {

	public static void main(String[] args)  
	{

	    GenericXLSXReader xlsx =  new GenericXLSXReader(System.getProperty("user.dir")+"\\resources\\configuration.xlsx");



        
		DataUtil datautils =  new DataUtil();
		Hashtable<String, String> data = datautils.getData("", xlsx);
		System.out.println(data.size());
		ReusableFactory ref = new ReusableFactory();
		System.out.println(data.get("NoOfData"));

		

	
	}
	}
	

