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

import Utilities.Constants;
import Utilities.headerFiles;
import pojoClases.Contract;
import pojoClases.Counterparty;

public class ReadWrite {
	 File file;
	 FileWriter outputfile;
	 List hearderData;
	 
	public void generateContractfile(ArrayList<Contract> contractData,String folderName) throws IOException {
	
			 String fileName = Constants.fileLocation+"\\"+folderName+"\\"+folderName+"-"+Constants.contract+Constants.fileType;
			 outputfile = createFileObject(fileName);
			 writeCotractData(contractData,outputfile);	
	}
	
	
	public void generateCounterpartyfile(ArrayList<Counterparty> contractData,String folderName) throws IOException {
		
			 
			 String fileName = Constants.fileLocation+"\\"+folderName+"\\"+folderName+"-"+Constants.counterParty+Constants.fileType;
			 outputfile = createFileObject(fileName);
			 writeCounterPartyData(contractData,outputfile);	

	}
	public void generateCounterpartyRatingfile(ArrayList<Contract> contractData) throws IOException {
		
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

public void writeCotractData(ArrayList<Contract> contractData, FileWriter outputfile) {
    try { 
    	
        // create CSVWriter with ';' as separator 
        CSVWriter writer = new CSVWriter(outputfile, ',', 
                                         CSVWriter.NO_QUOTE_CHARACTER, 
                                         CSVWriter.DEFAULT_ESCAPE_CHARACTER, 
                                         CSVWriter.DEFAULT_LINE_END); 
        
        writer.writeNext(headerFiles.contractHeader()); 
        System.out.println("No of rows = "+contractData.size()); 
        for(Contract con : contractData) {
        	String[] rowData =  { 
        				con.getReportingEntityId(), 
        				con.getContractId(),
        				con.getInstrumentId(),
        				con.getCounterypartyId()}; 
        	writer.writeNext(rowData); 
        }

        writer.close(); 
    } 
    catch (IOException e) { 
        // TODO Auto-generated catch block 
        e.printStackTrace(); 
        
    } 
}

public void writeCounterPartyData(ArrayList<Counterparty> contractData, FileWriter outputfile) {
    try { 
    	
        // create CSVWriter with ';' as separator 
        CSVWriter writer = new CSVWriter(outputfile, ',', 
                                         CSVWriter.NO_QUOTE_CHARACTER, 
                                         CSVWriter.DEFAULT_ESCAPE_CHARACTER, 
                                         CSVWriter.DEFAULT_LINE_END); 
        
        writer.writeNext(headerFiles.contractHeader()); 
        System.out.println("No of rows = "+contractData.size()); 
        for(Counterparty con : contractData) {
        	String[] rowData =  { 
        			con.getReportingEntityId(),
    				con.getCounterypartyId(),
    				con.getName(),
    				con.getDate(),
    				con.getCasteGen(),
    				con.getCommGen(),
    				con.getPan(),
    				con.getAdharNo(),
    				con.getDin(),
    				con.getCin(),
    				con.getLei(),
    				con.getTan(),
    				con.getGstin(),
    				con.getUdyogAadhaar(),
    				con.getTypeOrg(),
    				con.getBurrrower(),
    				con.getNicCode(),
    				con.getOccupationCode(),
    				con.getAddressLine1(),
    				con.getAddressLine2(),
    				con.getAddressLine3(),
    				con.getPinCode(),
    				con.getStateCode(),
    				con.getDistrictCode(),
    				con.getCountryCode(),
    				con.getTelePhoneNumber(),
    				con.getMobNo(),
    				con.getEmailAddress()};
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
public FileWriter createFileObject(String fileName) throws IOException{
	file = new File(fileName); 
	outputfile = new FileWriter(file);
	return outputfile;	
}




public List createHeader(String fileSample) {
	List allData = null;
	FileReader filereader = null;
	
	if (fileSample.equalsIgnoreCase("contract")) {
		try {
			System.out.println(System.getProperty("user.dir")+"\\SampleFiles\\");
			
			//HeaderCreation.createContractHeader(fileSample);
			filereader = new FileReader(System.getProperty("user.dir")+"\\SampleFiles\\SampleContract.csv");
			System.out.println();
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







