package ReUsable;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import pojoClases.Contract;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import Utilities.Constants;
import Utilities.headerFiles;

public class HeaderCreation {

	public static void createContractHeader(String filePath) {
		
		File file = new File(filePath); 
	    try { 
	        // create FileWriter object with file as parameter 
	        FileWriter outputfile = new FileWriter(file); 
	  
	        // create CSVWriter object filewriter object as parameter 
	        CSVWriter writer = new CSVWriter(outputfile); 
	    
	        // adding header to csv 
	        //String[] header = { "Name", "Class", "Marks" }; 
	        writer.writeNext(headerFiles.contractHeader()); 
	 
	        // closing writer connection 
	        writer.close(); 
	    } 
	    catch (IOException e) { 
	        // TODO Auto-generated catch block 
	        e.printStackTrace(); 
	    } 
	
	} 

	
	public static List<Contract> parseCSVWithHeader() throws IOException {
		String fileName = Constants.NewfileLocation+"Contract1"+Constants.fileType;
		CSVReader reader = new CSVReader(new FileReader(fileName), ',');
		
		HeaderColumnNameMappingStrategy<Contract> beanStrategy = new HeaderColumnNameMappingStrategy<Contract>();
		beanStrategy.setType(Contract.class);
		
		CsvToBean<Contract> csvToBean = new CsvToBean<Contract>();
		List<Contract> cons = csvToBean.parse(beanStrategy, reader);
		
		System.out.println(cons);
		reader.close();
		return cons;
	}

}
