package ReUsable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.github.javafaker.Faker;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import Utilities.Constants;
import Utilities.headerFiles;
import pojoClases.Contract;
import pojoClases.Counterparty;
import pojoClases.Instrument;
import pojoClases.Protection;
import pojoClases.counterpartyRating;
import pojoClases.counterpartyRisk;

import pojoClases.protectionInstrument;
import pojoClases.relatedParty;

public class ReadWrite {
	 File file;
	 FileWriter outputfile;
	 List hearderData;
	 
	
	
public  void writeCotractData(ArrayList<Contract> contractData, String fileName) {
    try { 
    	outputfile = createFileObject(fileName);
        // create CSVWriter with ';' as separator 
       
        CSVWriter writer =createCSVWriter(outputfile);
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
       
        e.printStackTrace(); 
        
    } 
}



public void writeCounterPartyData(ArrayList<Counterparty> counterPartyData, String fileName) {
    try {
    	
    	outputfile = createFileObject(fileName);
        // create CSVWriter with ';' as separator 
    	 CSVWriter writer =createCSVWriter(outputfile);
        
        writer.writeNext(headerFiles.counterPartyHeader()); 
        System.out.println("No of rows = "+counterPartyData.size()); 
        for(Counterparty con : counterPartyData) {
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
        writer.close(); 
    } 
    catch (IOException e) { 
       
        e.printStackTrace(); 
        
    } 
} 




public  void writeProtectionInstrumentData(ArrayList<protectionInstrument> contractData, String fileName) {
    try { 
    	outputfile = createFileObject(fileName);
        // create CSVWriter with ';' as separator 
    	 CSVWriter writer =createCSVWriter(outputfile);
        
        writer.writeNext(headerFiles.ProtectionInstrument()); 
        System.out.println("No of rows = "+contractData.size()); 
        for(protectionInstrument con : contractData) {
        	String[] rowData =  { 
        				con.getReportingEntityId(), 
        				con.getContractId(),
        				con.getInstrumentId(),
        				con.getProtectionId(),
        				con.getProtectionAllocatedValue(),
        				con.getChargeType()
        				}; 
        	writer.writeNext(rowData); 
        }

        writer.close(); 
    } 
    catch (IOException e) { 
        
        e.printStackTrace(); 
        
    } 
}
public  void writeRelatedPartyData(ArrayList<relatedParty> contractData, String fileName) {
    try { 
    	outputfile = createFileObject(fileName);
        // create CSVWriter with ';' as separator 
    	 CSVWriter writer =createCSVWriter(outputfile);
        
        writer.writeNext(headerFiles.RelatedParty()); 
        System.out.println("No of rows = "+contractData.size()); 
        for(relatedParty con : contractData) {
        	String[] rowData =  { 
        				con.getReportingEntityId(), 
        				con.getCounterpartyId(),
        				con.getRelatedCounterpartyID()
        				}; 
        	writer.writeNext(rowData); 
        }

        writer.close(); 
    } 
    catch (IOException e) { 
      
        e.printStackTrace(); 
        
    } 
}
public  void writeProtectionData(ArrayList<Protection> contractData, String fileName) {
    try { 
    	outputfile = createFileObject(fileName);
        // create CSVWriter with ';' as separator 
    	 CSVWriter writer =createCSVWriter(outputfile);
        
        writer.writeNext(headerFiles.Protection()); 
        System.out.println("No of rows = "+contractData.size()); 
        for(Protection con : contractData) {
        	String[] rowData =  { 
        		con.getReportingEntityId(),
        		con.getProtectionId(),
        		con.getProtectionProviderId(),
        		con.getTypeOfProtection(),
        		con.getCurrencyType(),
        		con.getProtectionValue(),
        		con.getTypeOfProtectionValue(),
        		con.getProtectionValuationApproach(),
        		con.getDateOfProtectionValue(),
        		con.getOriginalProtectionValue(),
        		con.getDateOfOriginalProtectionValue(),
        		con.getProtectionRegistryId(),
        		con.getProtectionExternalId()
        	}; 
        	writer.writeNext(rowData); 
        }

        writer.close(); 
    } 
    catch (IOException e) { 
       
        e.printStackTrace(); 
        
    } 
}
public  void writeInstrumentData(ArrayList<Instrument> contractData, String fileName) {
    try { 
    	outputfile = createFileObject(fileName);
        // create CSVWriter with ';' as separator 
    	 CSVWriter writer =createCSVWriter(outputfile);
        
        writer.writeNext(headerFiles.Instrument()); 
        System.out.println("No of rows = "+contractData.size()); 
        for(Instrument con : contractData) {
        	String[] rowData =  { 
        		con.getReportingEntityId(),
        		con.getInstrumentId(),
        		con.getBranchCode(),
        		con.getContractId(),
        		con.getDistrictOfUtilisation(),
        		con.getInstrumentType(),
        		con.getPrioritySector(),
        		con.getWeakerSection(),
        		con.getClassificationOfActivity(),
        		con.getSanctionDate(),
        		con.getDisbursementDate(),
        		con.getMaturityDate(),
        		con.getCurrencyCode(),
        		con.getOrgsanAmmnt(),
        		con.getSyndcateContactId(),
        		con.getRecourse(),
        		con.getInterestRateType(),
        		con.getAmortisationType(),
        		con.getPaymentFrequency(),
        		con.getInterRate(),
        		con.getWeightedAverageInterestRate(),
        		con.getInstallAmnt(),
        		con.getBalanceOutstanding(),
        		con.getUnvailedAmmount(),
        		con.getOffBalMinAmnt(),
        		con.getCrediteqibaloff(),
        		con.getAccuInterst(),
        		con.getAmntOver(),
        		con.getNumPastDue(),
        		con.getSmaCatogry(),
        		con.getSmaCurrentCatg(),
        		con.getNpaCatgCode(),
        		con.getNpaSinDate(),
        		con.getCummRecovSinNpa(),
        		con.getAccProviosions(),
        		con.getAccWriteOffs(),
        		con.getSettAmmount(),
        		con.getRestStatus(),
        		con.getRestDate(),
        		con.getAccountStatus(),
        		con.getStatusDate(),
        		con.getSuitFielDate()                       
        	}; 
        	writer.writeNext(rowData); 
        }

        writer.close(); 
    } 
    catch (IOException e) { 
        e.printStackTrace(); 
        
    } 
}
public  void writecounterpartyRatingData(ArrayList<counterpartyRating> contractData, String fileName) {
    try { 
    	outputfile = createFileObject(fileName);
        // create CSVWriter with ';' as separator 
    	 CSVWriter writer =createCSVWriter(outputfile);
        
        writer.writeNext(headerFiles.CounterpartyRating()); 
        System.out.println("No of rows = "+contractData.size()); 
        for(counterpartyRating con : contractData) {
        	String[] rowData =  { 
        				con.getReportingEntityId(), 
        				con.getCounterpartyId(),
        				con.getRatingID(),
        				con.getCreditRating(),
        				con.getAssessmentAgencyAuthority(),
        				con.getCreditRatingAsOn(),
        				con.getCreditRatingExpiryDate()
        				}; 
        	writer.writeNext(rowData); 
        }

        writer.close(); 
    } 
    catch (IOException e) { 
        
        e.printStackTrace(); 
        
    } 
}

public  void writecounterpartyRiskData(ArrayList<counterpartyRisk> contractData, String fileName) {
    try { 
    	outputfile = createFileObject(fileName);
        // create CSVWriter with ';' as separator 
    	 CSVWriter writer =createCSVWriter(outputfile);
        
        writer.writeNext(headerFiles.CounterpartyRisk()); 
        System.out.println("No of rows = "+contractData.size()); 
        for(counterpartyRisk con : contractData) {
        	String[] rowData =  { 
        		con.getReportingEntityId(),
        		con.getCounterpartyId(),
        		con.getStatusOfInsolvencyProceedings(),
        		con.getDateOfInitiationOfInsolvencyProceedings(),
        		con.getWilfulDefaulter(),
        		con.getDateOfWilfulDefaulterClassification(),
        		con.getNonCooperativeBorrower(),
        		con.getDateOfNonCooperativeBorrowerClassification(),
        		con.getFradulentActivity(),
        		con.getDateOfFradulentActivityClassification(),
        		con.getInternalRating(),
        		con.getDateOfInternalRating()
        }; 
        	writer.writeNext(rowData); 
        }

        writer.close(); 
    } 
    catch (IOException e) { 
       
        e.printStackTrace(); 
        
    } 
}



private FileWriter createFileObject(String fileName) throws IOException{
	file = new File(fileName); 
	outputfile = new FileWriter(file);
	return outputfile;	
}

private CSVWriter createCSVWriter(FileWriter outputfile) {
	 CSVWriter writer = new CSVWriter(outputfile, ',', 
            CSVWriter.NO_QUOTE_CHARACTER, 
            CSVWriter.DEFAULT_ESCAPE_CHARACTER, 
            CSVWriter.DEFAULT_LINE_END); 
	 return writer;
}

public void writeControlFileData(HashMap<String, Integer> cf, String fileLocation ) {
	
	try { 
		outputfile = createFileObject(fileLocation);
    	CSVWriter writer =createCSVWriter(outputfile);
  
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDateTime now = LocalDateTime.now();
    String dateToString = dtf.format(now);
    String [] rowData1 = {"Date",dateToString};
    writer.writeNext(rowData1);
	
	String s = null ;
	String p = null ;
	 Set<String> keys = cf.keySet();
	 
	 if (keys.contains(".csv")) {
		 p = "(CSV) "+cf.get(".csv");
		 if(cf.get(".csv")>0) {
			 s = "csv";
			}
		}
  
		if (keys.contains(".xlsx")) {
			p=p+"(xlsx)"+cf.get(".xlsx");
			if(cf.get(".xlsx")>0) {
				s =s+"/xlsx";
		}
		}
		if (keys.contains(".txt")) {
			p=p+"(txt)"+cf.get(".txt");
	       if(cf.get(".txt")>0) 
			{
				s = s+"/txt";
			}
		}  
	String rowData[] = {"Type of file",s};
	String rowData2[] = {"Number of file ",p};
	writer.writeNext(rowData);
	writer.writeNext(rowData2);
	
	 for(String key:keys){
		 if(key.contains("Contract File")) {
			String rowContract[]= {"Transaction Records in ContractFile",""+cf.get("Contract File")};
			writer.writeNext(rowContract);
			
	    }
	       if(key.contains("CounterParty File")) {
	    	   String rowContract[]= {"Transaction Records in CounterpartyFile",""+cf.get("CounterParty File")};
	    	   writer.writeNext(rowContract);
	    } 
	       if(key.contains("CounterpartyRating File")) {
	    	   String rowContract[]= {"Transaction Records in CounterpartyFile",""+cf.get("CounterParty File")};
	    	   writer.writeNext(rowContract);
	    }  
	       if(key.contains("CounterpartyRisk File")) {
	    	   String rowContract[]= {"Transaction Records in Counterparty Risk File",""+cf.get("CounterpartyRisk File")};
	    	   writer.writeNext(rowContract);
	    }
	       if(key.contains("Instrument File")) {
	    	   String rowContract[]= {"Transaction Records in Instrument File",""+cf.get("Instrument File")};
	    	   writer.writeNext(rowContract);
	    }
	       if(key.contains("Protection File")) {
	    	   String rowContract[]= {"Transaction Records in Protection File",""+cf.get("Protection File")};
	    	   writer.writeNext(rowContract);
	    }  
	       if(key.contains("ProtectionInstrument File")) {
	    	   String rowContract[]= {"Transaction Records in IProtection nstrument File",""+cf.get("ProtectionInstrument File")};
	    	   writer.writeNext(rowContract);
	    }
	       
	       if(key.contains("RelatedParty File")) {
	    	  String rowContract[]= {"Transaction Records in RelatedParty File",""+cf.get("RelatedParty File")};
	    	  writer.writeNext(rowContract);
	    }
	 }
	 writer.close(); 
 } 
 catch (IOException e) { 
    
     e.printStackTrace(); 
     
 } 
}
private ArrayList<Counterparty> randomize( ArrayList<Counterparty> counterPartyData) 

{ 
	System.out.println(counterPartyData); 
	Collections.shuffle(counterPartyData); 
	System.out.println("-------------------------------------------------------"); 
	System.out.println(counterPartyData); 
	return counterPartyData;
} 
   
}







