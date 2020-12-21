package Utilities;

import java.util.ArrayList;
import java.util.Hashtable;




public class DataUtil {
	
	public static Hashtable<String, String> getData( String sheetName,GenericXLSXReader xls){
		//String testName="CreateLeadTest";

		
		//Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx");
		int totalrows =1;
		int totalCols=1;
		while(!xls.getCellData(sheetName, 0, totalrows).equals("")) {
			
			
			totalrows++;
		}
		while(!xls.getCellData(sheetName, totalCols, 1).equals("")) {
			
			totalCols++;
		}
		
		System.out.println(totalrows-1+"=-------------"+totalCols);
		
		
		Hashtable<String,String> configTable=new Hashtable<String,String>();
		
		for(int rNum=1;rNum<totalrows;rNum++) {
			for(int cNum=0;cNum+1<totalCols;cNum++) {
				String key = xls.getCellData(sheetName, 0, rNum);
				String data = xls.getCellData(sheetName, 1, rNum);
				System.out.print(key+"-"+data+" --- ");
				configTable.put(key, data);
			}
			
		}
		return configTable;
		
		
		 /* int testStartRowNum=1; while(!xls.getCellData(sheetName, 0,
		  testStartRowNum).equalsIgnoreCase(testName)) {
		  testStartRowNum++; } 
		  System.out.println("Row num for test "+
		  testStartRowNum); int colRowNum = testStartRowNum+1;
		  
		  // total cols , rows
		  
		  
		  
		  while(!xls.getCellData(sheetName, totalCols, colRowNum).equals("")) {
		  totalCols++; }  System.out.println("Total Cols "+ totalCols);
		  
		  int dataStartRowNum= colRowNum+1; int totalRows=0;
		  while(!xls.getCellData(sheetName, 0, dataStartRowNum+totalRows).equals("")) {
		  totalRows++; } 
		  System.out.println("Total Rows "+ totalRows); Object
		  testData[][] = new Object[totalRows][1]; //extract data for the test
		  Hashtable<String,String> table=null; int i=0; for(int
		  rNum=dataStartRowNum;rNum<dataStartRowNum+totalRows;rNum++) { table = new
		  Hashtable<String,String>(); for(int cNum=0;cNum<totalCols;cNum++) { String
		  data = xls.getCellData(sheetName, cNum, rNum); String key =
		  xls.getCellData(sheetName, cNum, colRowNum);
		  System.out.print(key+"-"+data+" --- "); table.put(key, data); } //table
		  will be ready testData[i][0]=table; i++;
		 
		 } return testData;*/
	}
		public static ArrayList<Hashtable<String, String>> getMasterdata() {
			GenericXLSXReader xls = new GenericXLSXReader(System.getProperty("user.dir")+"\\resources\\Configuration.xlsx");
			int rowCount =  xls.getRowCount("MasterData");
			int colCount =  xls.getColumnCount("MasterData");
			int totalrowCount=1;
			int totalcolCount=0;
			String d =xls.getCellData("MasterData", 0, 1);
			String d1 =xls.getCellData("MasterData", "Field", 7);
			
			System.out.println(d1);
			
			while(!xls.getCellData("MasterData",totalcolCount , 1).equalsIgnoreCase("")) {
				totalcolCount++;
			}
			System.out.println(totalcolCount);
			while(!xls.getCellData("MasterData",0 , totalrowCount).equals("")) {
				totalrowCount++;
			}
			System.out.println("Row Coult"+totalrowCount+" --- Col Count "+totalcolCount);
			ArrayList <Hashtable<String,String>> masterData =  new ArrayList<Hashtable<String,String>>();
			Hashtable<String,String> getTable ;
			for(int i=2;i<totalrowCount;i++) {
					getTable =  new Hashtable<>();
							
				for(int j = 0;j<totalcolCount;j++) {
					
					String Key = xls.getCellData("MasterData", j, 1);
					
					String value = xls.getCellData("MasterData", j, i);
					getTable.put(Key,value);
						System.out.println("key "+Key+" value "+value);
				}
				masterData.add(getTable);
				getTable=null;
		
			System.out.println(masterData.size());

			for(int i1=0;i1<masterData.size();i1++) {
				

				Hashtable<String,String> matData  = masterData.get(i1);
				matData.get("Data Type");
				if(matData.get("Data Type").equalsIgnoreCase("Alphanumeric"))
				
				System.out.println(matData.get("Field"));		
			}
			
		}
		return masterData;
		}
	
	// true - Y
	// false - N
	
	 
	/*
	 * public boolean isRunnable(String testName, GenericXLSXReader xls) {
	 * //Xls_Reader xls = new
	 * Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx"); //String
	 * testName="LoginTest"; String sheetName=Constant.TEST_STATUS_SHEET; int rows =
	 * xls.getRowCount(sheetName); for(int rNum=2;rNum<=rows;rNum++) { String
	 * testCaseName = xls.getCellData(sheetName, Constant.TCID, rNum);
	 * if(testName.equalsIgnoreCase(testCaseName)) { String runmode =
	 * xls.getCellData(sheetName, Constant.RUNMODE, rNum); if(runmode.equals("Y"))
	 * return true; else return false; } } return false;
	 * 
	 * }
	 */

		public static Hashtable<String, String> getFieldValue( String sheetName,GenericXLSXReader xls){
			//String testName="CreateLeadTest";

			
			//Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx");
			int totalrows =1;
			int totalCols=1;
			while(!xls.getCellData(sheetName, 0, totalrows).equals("")) {
				
				totalrows++;
			}
			while(!xls.getCellData(sheetName, totalCols, 1).equals("")) {
				
				totalCols++;
			}
			
			System.out.println(totalrows-1+"=-------------"+totalCols);
			
			
			Hashtable<String,String> fieldValues=new Hashtable<String,String>();
			
			for(int rNum=1;rNum<totalrows;rNum++) {
				
					String key = xls.getCellData(sheetName, 0, rNum);
					String data = xls.getCellData(sheetName, 2, rNum);
					System.out.print(key+"-"+data+" --- ");
					fieldValues.put(key, data);
				
				
			}
			return fieldValues;
		}
		
}

