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

	    Utils.archiveAvailableFiles();
		ReusableFactory ref = new ReusableFactory();
		ref.createData(Constants.totalData);
		System.out.println(Constants.totalData);

		

	
	}
	}
	

