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

	    //Utils.archiveAvailableFiles();
	/*ReusableFactory ref = new ReusableFactory();
		ref.createData(Constants.totalData);
		System.out.println(Constants.totalData);*/
	/*or (int i=0;i<=10;i++)
		{
			datacreation d = new datacreation();
		d.dateoftheme11();
		}
	}*/
		
		//Don't remove this
		datacreation d = new datacreation();
		GenericXLSXReader xlsx =  new GenericXLSXReader(System.getProperty("user.dir")+"\\resources\\configuration.xlsx");
		Hashtable<String, String> data = DataUtil.getData("Configuration", xlsx);
		String totalData = xlsx.getCellData("Configuration",1, 2);
		double f=Double.parseDouble(totalData);
		int v=(int)f;
	 
		ReusableFactory ref = new ReusableFactory();
		ref.createData(v);
		//5.25
	}}

	

