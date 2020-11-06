package test;

import java.util.ArrayList;
import java.util.Hashtable;

import Utilities.GenericXLSXReader;

public class ArrayHash {
	
	public static void main(String[] args) {
		
		
		GenericXLSXReader xls = new GenericXLSXReader(System.getProperty("user.dir")+"\\resources\\MasterTable1.xlsx");
		int rowCount =  xls.getRowCount("Master data sheet");
		int colCount =  xls.getColumnCount("Master data sheet");
		int totalrowCount=1;
		int totalcolCount=0;
		String d =xls.getCellData("Master data sheet", 0, 1);
		String d1 =xls.getCellData("Master data sheet", "Field", 7);
		
		System.out.println(d1);
		
		while(!xls.getCellData("Master data sheet",totalcolCount , 1).equalsIgnoreCase("")) {
			totalcolCount++;
		}
		System.out.println(totalcolCount);
		while(!xls.getCellData("Master data sheet",0 , totalrowCount).equals("")) {
			totalrowCount++;
		}
		System.out.println("Row Coult"+totalrowCount+" --- Col Count "+totalcolCount);
		ArrayList <Hashtable<String,String>> masterData =  new ArrayList<Hashtable<String,String>>();
		Hashtable<String,String> getTable ;
		for(int i=2;i<totalrowCount;i++) {
				getTable =  new Hashtable<>();
						
			for(int j = 0;j<totalcolCount;j++) {
				
				String Key = xls.getCellData("Master data sheet", j, 1);
				
				String value = xls.getCellData("Master data sheet", j, i);
				getTable.put(Key,value);
					System.out.println("key "+Key+" value "+value);
			}
			masterData.add(getTable);
			getTable=null;
	}	
		System.out.println(masterData.size());

		for(int i=0;i<masterData.size();i++) {
			

			Hashtable<String,String> matData  = masterData.get(i);
			matData.get("Data Type");
			if(matData.get("Data Type").equalsIgnoreCase("Alphanumeric"))
			
			System.out.println(matData.get("Field"));
			
			
		}
		
		
	}
	
	
	
	
	
	
	}



