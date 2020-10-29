package Utilities;

import java.util.Hashtable;




public class DataUtil {
	
	public static Hashtable<String, String> getData(String testName, GenericXLSXReader xls){
		//String testName="CreateLeadTest";

		String sheetName="Configuration";
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
		
		/*
		 * int testStartRowNum=1; while(!xls.getCellData(sheetName, 0,
		 * testStartRowNum).equalsIgnoreCase(testName)) {
		 * 
		 * testStartRowNum++; } // System.out.println("Row num for test "+
		 * testStartRowNum); int colRowNum = testStartRowNum+1;
		 * 
		 * // total cols , rows
		 * 
		 * 
		 * while(!xls.getCellData(sheetName, totalCols, colRowNum).equals("")) {
		 * totalCols++; } // System.out.println("Total Cols "+ totalCols);
		 * 
		 * int dataStartRowNum= colRowNum+1; int totalRows=0;
		 * while(!xls.getCellData(sheetName, 0, dataStartRowNum+totalRows).equals("")) {
		 * totalRows++; } //System.out.println("Total Rows "+ totalRows); Object
		 * testData[][] = new Object[totalRows][1]; // extract data for the test
		 * Hashtable<String,String> table=null; int i=0; for(int
		 * rNum=dataStartRowNum;rNum<dataStartRowNum+totalRows;rNum++) { table = new
		 * Hashtable<String,String>(); for(int cNum=0;cNum<totalCols;cNum++) { String
		 * data = xls.getCellData(sheetName, cNum, rNum); String key =
		 * xls.getCellData(sheetName, cNum, colRowNum);
		 * //System.out.print(key+"-"+data+" --- "); table.put(key, data); } // table
		 * will be ready testData[i][0]=table; i++;
		 * 
		 * }
		 * 
		 * return testData;
		 */
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

}
