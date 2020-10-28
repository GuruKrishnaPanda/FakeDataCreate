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

		
		// Utils.archiveAvailableFiles();
		 //ReusableFactory ref = new ReusableFactory();
		 
		// ref.createData(Constants.totalData);



		//ReusableFactory ref = new ReusableFactory();
		//ref.createData(Constants.totalData);
		//datacreation d=new datacreation();
		//d.creditRating();
	
		
		//Utils.archiveAvailableFiles();
	    GenericXLSXReader xlsx =  new GenericXLSXReader(System.getProperty("user.dir")+"\\resources\\configuration.xlsx");
        
		DataUtil datautils =  new DataUtil();
		Hashtable<String, String> data = datautils.getData("", xlsx);
		System.out.println(data.size());
		ReusableFactory ref = new ReusableFactory();
		System.out.println(data.get("NoOfData"));
		
		 ref.createData(Constants.totalData);
	
	}
		
	}
