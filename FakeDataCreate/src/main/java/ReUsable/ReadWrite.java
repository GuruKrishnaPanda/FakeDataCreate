package ReUsable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import pojoClases.Contract;
import pojoClases.Counterparty;
import test.Constants;

public class ReadWrite {
	 File file;
	 FileWriter outputfile;
	 List hearderData;
	 
	public void generateContractfile(ArrayList<Contract> contractData, String fileFor) throws IOException {
	
		
			 String fileName = Constants.fileLocation+"Contract"+Constants.fileType;
			 file = new File(fileName); 
			 outputfile = new FileWriter(file);
			 hearderData =  createHeader("contract");
			 writeCotractData(contractData,outputfile,hearderData);	 
		
		
	}
	public void generateCounterpartyfile(ArrayList<Counterparty> contractData, String fileFor) throws IOException {
		
			 String fileName = Constants.fileLocation+"Counterparty"+Constants.fileType;
			 file = new File(fileName); 
			 outputfile = new FileWriter(file);
			 hearderData =  createHeader("Counterparty");
			 writeCounterPartyData(contractData,outputfile,hearderData);	
	
	}
	public void generateCounterpartyRatingfile(ArrayList<Contract> contractData, String fileFor) throws IOException {
		
			String fileName = Constants.fileLocation+"Counterparty Rating"+Constants.fileType;
			 file = new File(fileName); 
			 outputfile = new FileWriter(file);
			 hearderData =  createHeader("Counterparty Rating");
		
	
	}
	public void generateCounterpartyRiskfile(ArrayList<Contract> contractData, String fileFor) throws IOException {
		
			String fileName = Constants.fileLocation+"Counterparty Risk"+Constants.fileType;
			 file = new File(fileName);
			 outputfile = new FileWriter(file);
			 hearderData =  createHeader("Counterparty Risk");
		
	
	}
	public void generateInstrumentfile(ArrayList<Contract> contractData, String fileFor) throws IOException {
		
			String fileName = Constants.fileLocation+"Instrument"+Constants.fileType;
			 file = new File(fileName); 
			 outputfile = new FileWriter(file);
			 hearderData =  createHeader("Instrument");
		
	
	}
	public void generateProtectionfile(ArrayList<Contract> contractData, String fileFor) throws IOException {
		
			String fileName = Constants.fileLocation+"Protection"+Constants.fileType;
			 file = new File(fileName); 
			 outputfile = new FileWriter(file);
			 hearderData =  createHeader("Protection");
		
	
	}
	public void generateProtectionInstrumentfile(ArrayList<Contract> contractData, String fileFor) throws IOException {
		
			String fileName = Constants.fileLocation+"Protection Instrument"+Constants.fileType;
			 file = new File(fileName); 
			 outputfile = new FileWriter(file);
			 hearderData =  createHeader("Protection Instrument");
		
	
	}
	public void generateRelatedPartyfile(ArrayList<Contract> contractData, String fileFor) throws IOException {

		
			String fileName = Constants.fileLocation+"Related Party"+Constants.fileType;
			 file = new File(fileName); 
			 outputfile = new FileWriter(file);
			 hearderData =  createHeader("Related Party");
		
	
	}

public void writeCotractData(ArrayList<Contract> contractData, FileWriter outputfile, List hearderData) {
        try { 
        	
            // create CSVWriter with ';' as separator 
            CSVWriter writer = new CSVWriter(outputfile, ',', 
                                             CSVWriter.NO_QUOTE_CHARACTER, 
                                             CSVWriter.DEFAULT_ESCAPE_CHARACTER, 
                                             CSVWriter.DEFAULT_LINE_END); 
            writer.writeAll(hearderData); 
            // create a List which contains Data 
            //List<String[]> data = new ArrayList<String[]>(); 
  
            System.out.println("No of rows = "+contractData.size()); 
            for(Contract con : contractData) {
            	String[] rowData =  { 
            				con.getReportingEntityId(), 
            				con.getContractId(),
            				con.getInstrumentId(),
            				con.getCounterypartyId()}; 
            	writer.writeNext(rowData); 
            }
  
           // writer.writeAll(data); 
  
            // closing writer connection 
            writer.close(); 
        } 
        catch (IOException e) { 
            // TODO Auto-generated catch block 
            e.printStackTrace(); 
            
        } 
    } 
public void writeCounterPartyData(ArrayList<Counterparty> contractData, FileWriter outputfile, List hearderData) {
    try { 
    	
        // create CSVWriter with ';' as separator 
        CSVWriter writer = new CSVWriter(outputfile, ',', 
                                         CSVWriter.NO_QUOTE_CHARACTER, 
                                         CSVWriter.DEFAULT_ESCAPE_CHARACTER, 
                                         CSVWriter.DEFAULT_LINE_END); 
        writer.writeAll(hearderData); 
        // create a List which contains Data 
        //List<String[]> data = new ArrayList<String[]>(); 

        System.out.println("No of rows = "+contractData.size()); 
        for(Counterparty con : contractData) {
        	String[] rowData =  { 
        				con.getReportingEntityId(), 
        				con.getAddressLine1(),
        				con.getAddressLine2(),
        				con.getCounterypartyId()}; 
        	writer.writeNext(rowData); 
        }

       // writer.writeAll(data); 

        // closing writer connection 
        writer.close(); 
    } 
    catch (IOException e) { 
        // TODO Auto-generated catch block 
        e.printStackTrace(); 
        
    } 
} 
	



public void generateContractFile(ArrayList<Contract> contractData,String entityType) {
	
	
}

public List createHeader(String fileSample) {
	List allData = null;
	FileReader filereader = null;
	
	if (fileSample.equalsIgnoreCase("contract")) {
		try {
			System.out.println(System.getProperty("user.dir")+"\\SampleFiles\\");
			filereader = new FileReader(System.getProperty("user.dir")+"\\SampleFiles\\SampleContract.csv");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} 
	}	if (fileSample.equalsIgnoreCase("Counterparty")) {
		try {
			System.out.println(System.getProperty("user.dir")+"\\SampleFiles\\");
			filereader = new FileReader(System.getProperty("user.dir")+"\\SampleFiles\\SampleCounterparty.csv");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} 
	}
	
	  
    // create csvReader object passing 
    // file reader as a parameter 
    CSVReader csvReader = new CSVReader(filereader); 
    try {
    	allData = csvReader.readAll();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
    return allData;
}


}







