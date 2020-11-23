package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Utilities.GenericXLSXReader;

/**
 * Hello world!
 *
 */
public class App 
{
	private static final int MasterData = 0;

	public static Hashtable<String, String>  getMapData() throws IOException
		{
		Hashtable<String,String> configTable=new Hashtable<String,String>();
		try
		{
			FileInputStream file =new FileInputStream("./resources/Configuration.xlsx");
			Workbook work =new XSSFWorkbook(file);
			Sheet sheet =work.getSheetAt(MasterData);
			int lastRownumber=sheet.getLastRowNum();
		
			for(int i=0;i<=lastRownumber;i++)
				
			{
				Row row =sheet.getRow(i);
				Cell cell = row.getCell(0);
				String key = cell.getStringCellValue().trim();
				Cell val =row.getCell(1);
				String value = val.getStringCellValue().trim();
			   configTable.put(key, value);
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
			
		}
		return configTable;	
		}
	
 public static void main( String[] args ) throws IOException
    {
    	try {
    		
    	
    	Hashtable<String,String> configTable= App.getMapData();
    	for(Entry<String,String> map: configTable.entrySet())
    	{
    		System.out.println("key=" +map.getKey()+",value ="+map.getValue());
    	}
    }
    catch(FileNotFoundException e){
		e.printStackTrace();
		
	}
}
 }
