package ReUsable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
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
        	
       
        	{
        	String[] rowData = { 
        				con.getReportingEntityId(), 
        				con.getContractId(),
        				con.getInstrumentId(),
        				con.getCounterypartyId(),};
        	 
                  writer.writeNext(rowData);  
              
        }
        
        writer.close(); 
    }} 
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
        	for (int i=1;i<=1;i++) {
        	writer.writeNext(rowData); 
        	Collections.shuffle(counterPartyData);
        }}
        writer.close(); 
    } 
    catch (IOException e) { 
       
        e.printStackTrace(); 
        
    } 
} 




public  void writeProtectionInstrumentData(ArrayList<protectionInstrument> protectionInstrument, String fileName) {
    try { 
    	outputfile = createFileObject(fileName);
        // create CSVWriter with ';' as separator 
    	 CSVWriter writer =createCSVWriter(outputfile);
        
        writer.writeNext(headerFiles.ProtectionInstrument()); 
        System.out.println("No of rows = "+protectionInstrument.size()); 
        for(protectionInstrument con : protectionInstrument) {
        	String[] rowData =  { 
        				con.getReportingEntityId(), 
        				con.getContractId(),
        				con.getInstrumentId(),
        				con.getProtectionId(),
        				con.getProtectionAllocatedValue(),
        				con.getChargeType()
        				}; 
        	for (int i=1;i<=1;i++)
        	{
        	writer.writeNext(rowData);
        	Collections.shuffle(protectionInstrument);
        }}

        writer.close(); 
    } 
    catch (IOException e) { 
        
        e.printStackTrace(); 
        
    } 
}
public  void writeRelatedPartyData(ArrayList<relatedParty> relatedData, String fileName) {
    try { 
    	outputfile = createFileObject(fileName);
        // create CSVWriter with ';' as separator 
    	 CSVWriter writer =createCSVWriter(outputfile);
        
        writer.writeNext(headerFiles.RelatedParty()); 
        System.out.println("No of rows = "+relatedData.size()); 
        for(relatedParty con : relatedData) {
        	String[] rowData =  { 
        				con.getReportingEntityId(), 
        				con.getCounterpartyId(),
        				con.getRelatedCounterpartyID()
        				}; 
        	for (int i=1;i<=1;i++)
        	{
        	writer.writeNext(rowData); 
        	Collections.shuffle(relatedData);
        }}

        writer.close(); 
    } 
    catch (IOException e) { 
      
        e.printStackTrace(); 
        
    } 
}
public  void writeProtectionData(ArrayList<Protection> protectionData, String fileName) {
    try { 
    	outputfile = createFileObject(fileName);
        // create CSVWriter with ';' as separator 
    	 CSVWriter writer =createCSVWriter(outputfile);
        
        writer.writeNext(headerFiles.Protection()); 
        System.out.println("No of rows = "+protectionData.size()); 
        for(Protection con : protectionData) {
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
        	for (int i=1;i<=1;i++)
        	{
        	writer.writeNext(rowData);
        	Collections.shuffle(protectionData);;
        }}

        writer.close(); 
    } 
    catch (IOException e) { 
       
        e.printStackTrace(); 
        
    } 
}
public  void writeInstrumentData(ArrayList<Instrument> instrumentData, String fileName) {
    try { 
    	outputfile = createFileObject(fileName);
        // create CSVWriter with ';' as separator 
    	 CSVWriter writer =createCSVWriter(outputfile);
        
        writer.writeNext(headerFiles.Instrument()); 
        System.out.println("No of rows = "+instrumentData.size()); 
        for(Instrument con : instrumentData) {
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
        	for (int i=1;i<=1;i++)
        	{
        	writer.writeNext(rowData);
        	Collections.shuffle(instrumentData);
        }}

        writer.close(); 
    } 
    catch (IOException e) { 
        e.printStackTrace(); 
        
    } 
}
public  void writecounterpartyRatingData(ArrayList<counterpartyRating> counterpartyRatingData, String fileName) {
    try { 
    	outputfile = createFileObject(fileName);
        // create CSVWriter with ';' as separator 
    	 CSVWriter writer =createCSVWriter(outputfile);
        
        writer.writeNext(headerFiles.CounterpartyRating()); 
        System.out.println("No of rows = "+counterpartyRatingData.size()); 
        for(counterpartyRating con : counterpartyRatingData) {
        	String[] rowData =  { 
        				con.getReportingEntityId(), 
        				con.getCounterpartyId(),
        				con.getRatingID(),
        				con.getCreditRating(),
        				con.getAssessmentAgencyAuthority(),
        				con.getCreditRatingAsOn(),
        				con.getCreditRatingExpiryDate()
        				}; 
        	for(int i=1;i<=1;i++)
        	{
        	writer.writeNext(rowData);
        	Collections.shuffle(counterpartyRatingData);
        }}

        writer.close(); 
    } 
    catch (IOException e) { 
        
        e.printStackTrace(); 
        
    } 
}

public  void writecounterpartyRiskData(ArrayList<counterpartyRisk> counterPartyRiskData, String fileName) {
    try { 
    	outputfile = createFileObject(fileName);
        // create CSVWriter with ';' as separator 
    	 CSVWriter writer =createCSVWriter(outputfile);
        
        writer.writeNext(headerFiles.CounterpartyRisk()); 
        System.out.println("No of rows = "+ counterPartyRiskData.size()); 
        for(counterpartyRisk con :  counterPartyRiskData) {
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
        	for (int i=1;i<=1;i++)
        	{
        	writer.writeNext(rowData);
        	Collections.shuffle(counterPartyRiskData);
        }}

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


private ArrayList<Counterparty> randomize( ArrayList<Counterparty> counterPartyData) 

{ 
	System.out.println(counterPartyData); 
	Collections.shuffle(counterPartyData); 
	System.out.println("-------------------------------------------------------"); 
	System.out.println(counterPartyData); 
	return counterPartyData;
} 
   
}







