package test;

import java.util.ArrayList;

import Utilities.GenericXLSXReader;

public class masterPojoMain {

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
		ArrayList<MasterTable> masterData =  new ArrayList<MasterTable>();
		for(int i=0;i<totalrowCount;i++) {
			MasterTable ms =  new MasterTable();
			for(int j = 0;j<totalcolCount;j++) {
				System.out.println(xls.getCellData("Master data sheet", j, i));
				if(j==0)
					ms.setField(xls.getCellData("Master data sheet", j, i));
				if(j==0)
					ms.setField(xls.getCellData("Master data sheet", j, i));
				if(j==0)
					ms.setField(xls.getCellData("Master data sheet", j, i));
				if(j==0)
					ms.setField(xls.getCellData("Master data sheet", j, i));
					
			}
			masterData.add(ms);
			ms=null;
			System.out.println("---------------------------------------------------------------");
		}
		
		
		
		
		

	}

}
