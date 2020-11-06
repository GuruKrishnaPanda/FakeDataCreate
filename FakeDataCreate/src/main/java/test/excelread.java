package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import Utilities.GenericXLSXReader;

public class excelread {

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
		/*for(int i=0;i<totalrowCount;i++) {
			for(int j = 0;j<totalcolCount;j++) {
				System.out.println(xls.getCellData("Master data sheet", j, i));
			}
			System.out.println("---------------------------------------------------------------");
		}*/
		Hashtable<String,String> configTable=new Hashtable<String,String>();
		{
		for(int r=1;r<totalrowCount;r++) {
			for(int c=0;c<1;c++) {
				String key = xls.getCellData("Master data sheet", "Field", 1);
				String value = xls.getCellData("Master data sheet", "Field", r);
				configTable.put(key, value);
				Set<Entry<String, String> > entrySet =configTable.entrySet(); 
		        ArrayList<Entry<String, String> > listOfEntry = new ArrayList<Entry<String, String> >(entrySet); 
		        System.out.println(listOfEntry); 
			}		
	}
		System.out.println("---------------------------------------");
		
		}
		Hashtable<String,String> configTable1=new Hashtable<String,String>();
		{
        for(int r=2;r<totalrowCount;r++) {
	          for(int c=0;c<1;c++) {
		        String key = xls.getCellData("Master data sheet", "Length", 1);
                String value = xls.getCellData("Master data sheet","Length", r);
                double v = Double.parseDouble(value);
                int le=(int)v;
                String so = Integer.toString(le);
                configTable1.put(key, so);
            	Set<Entry<String, String> > entrySet =configTable1.entrySet(); 
		        ArrayList<Entry<String, String> > listOfEntry = new ArrayList<Entry<String, String> >(entrySet);  
		        System.out.println(listOfEntry); 
                
        }}
		System.out.println("---------------------------------------");
		}
		
		Hashtable<String,String> configTable2=new Hashtable<String,String>();
		{
		for(int r=1;r<totalrowCount;r++) {
			for(int c=0;c<1;c++) {
				String key = xls.getCellData("Master data sheet", "Data Type", 1);
				String value = xls.getCellData("Master data sheet", "Data Type", r);
				configTable2.put(key, value);
				Set<Entry<String, String> > entrySet =configTable2.entrySet(); 
		        ArrayList<Entry<String, String> > listOfEntry = new ArrayList<Entry<String, String> >(entrySet);  
		        System.out.println(listOfEntry); 
		
			}
	}	
		System.out.println("---------------------------------------");
		}
		Hashtable<String,String> configTable3=new Hashtable<String,String>();
		{
		for(int r=1;r<totalrowCount;r++) {
		for(int c=0;c<1;c++) {
		String key = xls.getCellData("Master data sheet", "Value1", 1);
		String value = xls.getCellData("Master data sheet", "Value1", r);
		configTable3.put(key, value);
		Set<Entry<String, String> > entrySet =configTable3.entrySet(); 
        ArrayList<Entry<String, String> > listOfEntry = new ArrayList<Entry<String, String> >(entrySet);  
        System.out.println(listOfEntry); 
}}
		System.out.println("---------------------------------------");
		}
		Hashtable<String,String> configTable4=new Hashtable<String,String>();
		{
		for(int r=1;r<totalrowCount;r++) {
		for(int c=0;c<1;c++) {
		String key = xls.getCellData("Master data sheet", "Value", 1);
		String value = xls.getCellData("Master data sheet", "Value", r);
		configTable4.put(key, value);
		Set<Entry<String, String> > entrySet =configTable4.entrySet(); 
        ArrayList<Entry<String, String> > listOfEntry = new ArrayList<Entry<String, String> >(entrySet);  
        System.out.println(listOfEntry); 
}}
		System.out.println("---------------------------------------");
		}
		Hashtable<String,String> configTable5=new Hashtable<String,String>();
		{
		for(int r=1;r<totalrowCount;r++) {
		for(int c=0;c<1;c++) {
		String key = xls.getCellData("Master data sheet", "Validation Rule", 1);
		String value = xls.getCellData("Master data sheet", "Validation Rule", r);
		configTable5.put(key, value);
		Set<Entry<String, String> > entrySet =configTable5.entrySet(); 
        ArrayList<Entry<String, String> > listOfEntry = new ArrayList<Entry<String, String> >(entrySet);  
        System.out.println(listOfEntry); 
}}
		System.out.println("-----------------------------------------");
		}
		Hashtable<String,String> configTable6=new Hashtable<String,String>();
		{
		for(int r=1;r<totalrowCount;r++) {
		   for(int c=0;c<1;c++) {
		       String key = xls.getCellData("Master data sheet", "Error Types", 1);
		       String value = xls.getCellData("Master data sheet", "Error Types", r);
		       configTable6.put(key, value);
		       Set<Entry<String, String> > entrySet =configTable6.entrySet(); 
		        ArrayList<Entry<String, String> > listOfEntry = new ArrayList<Entry<String, String> >(entrySet);  
		        System.out.println(listOfEntry); 
	
	}}
		System.out.println("---------------------------------------");
		}
		Hashtable<String,String> configTable7=new Hashtable<String,String>();
		{
        for(int r=1;r<totalrowCount;r++) {
	          for(int c=0;c<1;c++) {
		          String key = xls.getCellData("Master data sheet", "Regular Regex Pattern", 1);
		          String value = xls.getCellData("Master data sheet", "Regular Regex Pattern", r);
		          configTable7.put(key, value);
		          Set<Entry<String, String> > entrySet =configTable7.entrySet(); 
			        ArrayList<Entry<String, String> > listOfEntry = new ArrayList<Entry<String, String> >(entrySet);  
			        System.out.println(listOfEntry); 
		          }}
    	System.out.println("---------------------------------------");
		}
		             
	}}
