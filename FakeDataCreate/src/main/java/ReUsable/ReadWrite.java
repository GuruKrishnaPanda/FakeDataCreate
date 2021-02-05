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
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.github.javafaker.Faker;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import Utilities.Constants;
import Utilities.DataUtil;
import Utilities.GenericXLSXReader;
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
	datacreation create ;
	GenericXLSXReader xls = new GenericXLSXReader(System.getProperty("user.dir")+"\\resources\\Configuration.xlsx");
	Hashtable<String, String> configurationData = DataUtil.getData("Configuration", xls);
	Hashtable<String, String> fieldValues;
	Faker faker = new Faker();
	
	 File file;
	 FileWriter outputfile;
	 List hearderData;
	
	 public ReadWrite(Hashtable<String, String> data) {
		 configurationData = data;
	}
	 public void writeCotractData(ArrayList<Contract> contractData, String fileName) {
		 try {
		 outputfile = createFileObject(fileName);
		 CSVWriter writer =createCSVWriter(outputfile);
		  System.out.println("No of rows = "+contractData.size()); 
		 if(configurationData.get("Shuffled_Header").equalsIgnoreCase("Yes")) {
		 String[] s = headerFiles.contractHeader();
		 List<String> strList = Arrays.asList(s);
		 Collections.shuffle(strList);
		 s = strList.toArray(new String[strList.size()]);
		 writer.writeNext(s);
		 for(Contract con : contractData) {
		 ArrayList<String> rowdata =new ArrayList();
		 
		 for(String header :strList){
		 if(header.equalsIgnoreCase("reportingEntityId")) {
		 rowdata.add(con.getReportingEntityId());
		 }
		 if(header.equalsIgnoreCase("contractId")) {
		 rowdata.add(con.getContractId());
		 }
		 if(header.equalsIgnoreCase("instrumentId")) {
		 rowdata.add(con.getInstrumentId());
		 }
		 if(header.equalsIgnoreCase("counterypartyId")) {
		 rowdata.add(con.getCounterypartyId());
		 }
		 }
		 String[] writingRowData = rowdata.toArray(new String[rowdata.size()]);
		 writer.writeNext(writingRowData);
		 }
		 
		 writer.close();

		 } 
		 if(configurationData.get("Shuffled_Header").equalsIgnoreCase("No"))
	     {
		 if(configurationData.get("DuplicateFile_generation" ).equalsIgnoreCase("Yes"))
	     {  
			 int count = 0;
			 String  totalRecords = xls.getCellData("Configuration",1, 2);
	         String totalDuplicateRecords = xls.getCellData("Configuration",1, 15);
			 ArrayList<Integer> allIndexes =uniqunumber(totalDuplicateRecords ,totalRecords);
		     writer.writeNext(headerFiles.contractHeader()); 
	     	 for(Contract con : contractData) {
				count++;
	     		 
	     	String[] rowData =  { 
	     				con.getReportingEntityId(), 
	     				con.getContractId(),
	     				con.getInstrumentId(),
	     				con.getCounterypartyId()};
	     	boolean flag= false;
	     	if(allIndexes.contains(count)) {
	     		flag = true;
	     		if(flag) {
		     		for(int z =0;z<=1;z++) {
		     			writer.writeNext(rowData);
		     		}}}
	     		else {
		     		writer.writeNext(rowData);	
		     	}}}
		 else {
			  writer.writeNext(headerFiles.contractHeader()); 
		     	 for(Contract con : contractData) {
			
		     		 
		     	String[] rowData =  { 
		     				con.getReportingEntityId(), 
		     				con.getContractId(),
		     				con.getInstrumentId(),
		     				con.getCounterypartyId()
		     			
		     				};
		     	
		     	writer.writeNext(rowData);	
		 }
	     	writer.close();
	     	}}}
		 
		 catch (IOException e) {

		 e.printStackTrace();

		 } }
	
public ArrayList<Integer> uniqunumber(String totalDuplicateRecords, String totalRecords) {
		
		double f=Double.parseDouble(totalDuplicateRecords);
		int DuplicateRecords=(int)f;
		double f1=Double.parseDouble(totalRecords);
		int Records=(int)f1;
		ArrayList<Integer> duplicatedataIndex = new ArrayList<>();
		if(duplicatedataIndex.size()== 0) {
			duplicatedataIndex = new ArrayList<>();
		}
		for(int i = 0;i<DuplicateRecords;i++) {
			int dr = faker.number().numberBetween(1, Records);
			int data = isUniqueNo(dr,duplicatedataIndex,Records);
			duplicatedataIndex.add(data);
		
	}
		return duplicatedataIndex;
}

private int isUniqueNo(int dr, ArrayList<Integer> duplicatedataIndex,int Records) {
	if(duplicatedataIndex.contains(dr)) {
		 dr = faker.number().numberBetween(1, Records);
		 isUniqueNo(dr,duplicatedataIndex,Records);
	}
	
	else {
		return  dr;
		}

	return dr;
	}
public ArrayList<Integer> uniqunumberfrSkippedData(String totalSkippedRecords, String totalRecords, ArrayList<Integer> allIndexes) {
	
	double f=Double.parseDouble(totalSkippedRecords);
	int SkippedRecords=(int)f;
	double f1=Double.parseDouble(totalRecords);
	int Records=(int)f1;
	ArrayList<Integer> skipdataIndex = new ArrayList<>();
	if(skipdataIndex.size()== 0) {
		skipdataIndex = new ArrayList<>();
	}
	for(int i = 0;i<SkippedRecords;i++) {
		int dr = faker.number().numberBetween(1, Records);
		int data = UniqueNo(dr,skipdataIndex,Records,allIndexes);	
		skipdataIndex.add(data);
	
}
	return skipdataIndex;
}
private int UniqueNo(int dr, ArrayList<Integer> skipdataIndex,int Records,ArrayList<Integer> allIndexes) {
if(allIndexes==null) {
	if(skipdataIndex.contains(dr)) {
		 dr = faker.number().numberBetween(1, Records);
		 UniqueNo(dr,skipdataIndex,Records, allIndexes);
	}
}
else {
if(skipdataIndex.contains(dr)) {
	 dr = faker.number().numberBetween(1, Records);
	 UniqueNo(dr,skipdataIndex,Records, allIndexes);
}
else if (allIndexes.contains(dr)) {
	 dr = faker.number().numberBetween(1, Records);
	 UniqueNo(dr,skipdataIndex,Records, allIndexes);
}}
	return  dr;
	}







public void writeCounterPartyData(ArrayList<Counterparty> counterpartyData, String fileName) {
    try {
    	
    	outputfile = createFileObject(fileName);
        CSVWriter writer =createCSVWriter(outputfile);
        System.out.println("No of rows = "+counterpartyData.size()); 
        if(configurationData.get("Shuffled_Header").equalsIgnoreCase("Yes")) {
			 String[] s = headerFiles.counterPartyHeader();
			 List<String> strList = Arrays.asList(s);
			 Collections.shuffle(strList);
			 s = strList.toArray(new String[strList.size()]);
			 writer.writeNext(s);
			 for(Counterparty con : counterpartyData) {
			 ArrayList<String> rowdata =new ArrayList();
			 
			 for(String header :strList){
			 if(header.equalsIgnoreCase("reportingEntityId")) {
			 rowdata.add(con.getReportingEntityId());
			 }
			 if(header.equalsIgnoreCase("counterPartyId")) {
			 rowdata.add(con.getCounterypartyId());
			 }
			 if(header.equalsIgnoreCase("name")) {
			 rowdata.add(con.getName());
			 }
			 if(header.equalsIgnoreCase("dateOfBirthOrIncorporation")) {
			 rowdata.add(con.getDate());
			 }
			 if(header.equalsIgnoreCase("caste")) {
				 rowdata.add(con.getCasteGen());
			 }
			 if(header.equalsIgnoreCase("community")) {
				 rowdata.add(con.getCommGen());
			 }
			 if(header.equalsIgnoreCase("pan")) {
				 rowdata.add(con.getPan());
			 }
			 if(header.equalsIgnoreCase("aadhaar")) {
				 rowdata.add(con.getAdharNo());
			 }
			 if(header.equalsIgnoreCase("din")) {
				 rowdata.add(con.getDin());
			 }
			 if(header.equalsIgnoreCase("cin")) {
				 rowdata.add(con.getCin());
			}
			 if(header.equalsIgnoreCase("lei")) {
				 rowdata.add(con.getLei());
			}
			 if(header.equalsIgnoreCase("tan")) {
				 rowdata.add(con.getTan());
			}
			 if(header.equalsIgnoreCase("gstin")) {
				 rowdata.add(con.getGstin());
			}
			 if(header.equalsIgnoreCase("udyogAadhaar")) {
				 rowdata.add(con.getUdyogAadhaar());
			}
			 if(header.equalsIgnoreCase("typeOfOrganisation")) {
				 rowdata.add(con.getTypeOrg());
			}
			 if(header.equalsIgnoreCase("borrowerCategory")) {
				 rowdata.add(con.getBurrrower());
			}
			 if(header.equalsIgnoreCase("sicOrNicCode")) {
				 rowdata.add(con.getNicCode());
			}
			 if(header.equalsIgnoreCase("occupationCode")) {
				 rowdata.add(con.getOccupationCode());
			}
			 if(header.equalsIgnoreCase("addressLine1")) {
				 rowdata.add(con.getAddressLine1());
			}
			 if(header.equalsIgnoreCase("addressLine2")) {
				 rowdata.add(con.getAddressLine2());
			}
			 if(header.equalsIgnoreCase("addressLine3")) {
				 rowdata.add(con.getAddressLine3());
			}
			 if(header.equalsIgnoreCase("pinCode")) {
				 rowdata.add(con.getPinCode());
			}
			 if(header.equalsIgnoreCase("stateCode")) {
				 rowdata.add(con.getStateCode());
			}
			 if(header.equalsIgnoreCase("districtCode")) {
				 rowdata.add(con.getDistrictCode());
			}
			 if(header.equalsIgnoreCase("countryCode")) {
				 rowdata.add(con.getCountryCode());
			}
			 if(header.equalsIgnoreCase("telephoneNumber")) {
				 rowdata.add(con.getTelePhoneNumber());
			}
			 if(header.equalsIgnoreCase("mobileNumber")) {
				 rowdata.add(con.getMobNo());
			}
			 if(header.equalsIgnoreCase("emailAddress")) {
				 rowdata.add(con.getEmailAddress());
			}
			 }
			 String[] writingRowData = rowdata.toArray(new String[rowdata.size()]);
			 writer.writeNext(writingRowData);
			 }
			 
			 writer.close();}
        if(configurationData.get("Shuffled_Header").equalsIgnoreCase("No"))
	     {
			 if(configurationData.get("DuplicateFile_generation" ).equalsIgnoreCase("Yes"))
	     
	     {  
			 int count = 0;
			 String  totalRecords = xls.getCellData("Configuration",1, 2);
	         String totalDuplicateRecords = xls.getCellData("Configuration",1, 15);
			 ArrayList<Integer> allIndexes =uniqunumber(totalDuplicateRecords ,totalRecords);
		     writer.writeNext(headerFiles.counterPartyHeader()); 
	     	 for(Counterparty con : counterpartyData) {
	     		 count++;
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
	     	boolean flag= false;
	     	if(allIndexes.contains(count)) {
	     		flag = true;
	     		if(flag) {
		     		for(int z =0;z<=1;z++) {
		     			writer.writeNext(rowData);
		     		}}}
	     		else {
		     		writer.writeNext(rowData);
		     		
		     	}}}
			 
			 else {
				    writer.writeNext(headerFiles.counterPartyHeader()); 
			     	 for(Counterparty con : counterpartyData) {
				
			     		 
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
		     	writer.close();}}}
			 
			 catch (IOException e) {

			 e.printStackTrace();

			 } }
public  void writeProtectionInstrumentData(ArrayList<protectionInstrument> protectionInstrumentData, String fileName) {
    try { 
    	outputfile = createFileObject(fileName);
        
    	 CSVWriter writer =createCSVWriter(outputfile);
    	 System.out.println("No of rows = "+protectionInstrumentData.size()); 
		 if(configurationData.get("Shuffled_Header").equalsIgnoreCase("Yes")) {
		 String[] s = headerFiles.ProtectionInstrument();
		 List<String> strList = Arrays.asList(s);
		 Collections.shuffle(strList);
		 s = strList.toArray(new String[strList.size()]);
		 writer.writeNext(s);
		 for(protectionInstrument con : protectionInstrumentData) {
		 ArrayList<String> rowdata =new ArrayList();
		 
		 for(String header :strList){
		 if(header.equalsIgnoreCase("reportingEntityId")) {
		 rowdata.add(con.getReportingEntityId());
		 }
		 if(header.equalsIgnoreCase("InstrumentId")) {
		 rowdata.add(con.getInstrumentId());
		 }
		 if(header.equalsIgnoreCase("contractId")) {
		 rowdata.add(con.getContractId());
		 }
		 if(header.equalsIgnoreCase("protectionAllocatedValue")) {
		 rowdata.add(con.getProtectionAllocatedValue());
		 }
		 if(header.equalsIgnoreCase("protectionId")) {
			 rowdata.add(con.getProtectionId());
		 }
		 if(header.equalsIgnoreCase("chargeType")) {
			 rowdata.add(con.getChargeType());
		 }
		 }
		 String[] writingRowData = rowdata.toArray(new String[rowdata.size()]);
		 writer.writeNext(writingRowData);
		 }
		 
		 writer.close();

		 } 
		 if(configurationData.get("Shuffled_Header").equalsIgnoreCase("No"))
	     {
			 if(configurationData.get("DuplicateFile_generation" ).equalsIgnoreCase("Yes"))
		     {  
				 int count = 0;
				 String  totalRecords = xls.getCellData("Configuration",1, 2);
		         String totalDuplicateRecords = xls.getCellData("Configuration",1, 15);
				 ArrayList<Integer> allIndexes =uniqunumber(totalDuplicateRecords ,totalRecords);
			     writer.writeNext(headerFiles.ProtectionInstrument()); 
		     	 for(protectionInstrument con : protectionInstrumentData) {
					count++;
		    
       
        	String[] rowData =  { 
        				con.getReportingEntityId(), 
        				con.getContractId(),
        				con.getInstrumentId(),
        				con.getProtectionId(),
        				con.getProtectionAllocatedValue(),
        				con.getChargeType()
        				}; 
        	boolean flag= false;
	     	if(allIndexes.contains(count)) {
	     		flag = true;
	     		if(flag) {
		     		for(int z =0;z<=1;z++) {
		     			writer.writeNext(rowData);
		     		}}}
	     		else {
		     		writer.writeNext(rowData);
		     		
		     	}}}
			 writer.writeNext(headerFiles.ProtectionInstrument());  
	     	 for(protectionInstrument con : protectionInstrumentData) {
		
	     		 
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
     	writer.close();}}
	 
	 catch (IOException e) {

	 e.printStackTrace();}

	 } 
public  void writeRelatedPartyData(ArrayList<relatedParty> relatedPartyData, String fileName) {
    try { 
    	     outputfile = createFileObject(fileName);
			 CSVWriter writer =createCSVWriter(outputfile);
			   System.out.println("No of rows = "+relatedPartyData.size()); 
			 if(configurationData.get("Shuffled_Header").equalsIgnoreCase("Yes")) {
			 String[] s = headerFiles.RelatedParty();
			 List<String> strList = Arrays.asList(s);
			 Collections.shuffle(strList);
			 s = strList.toArray(new String[strList.size()]);
			 writer.writeNext(s);
			 for(relatedParty con : relatedPartyData) {
			 ArrayList<String> rowdata =new ArrayList();
			 
			 for(String header :strList){
			 if(header.equalsIgnoreCase("reportingEntityId")) {
			 rowdata.add(con.getReportingEntityId());
			 }
			 if(header.equalsIgnoreCase("counterpartyId")) {
			 rowdata.add(con.getCounterpartyId());
			 }
			 if(header.equalsIgnoreCase("relatedCounterpartyId")) {
			 rowdata.add(con.getRelatedCounterpartyID());
			 }
			 if(header.equalsIgnoreCase("relation")) {
				 rowdata.add(con.getRelation());
			 } if(header.equalsIgnoreCase("relatedPartyId")) {
				 rowdata.add(con.getRelatedPartyId());
			 }
			 }
			 String[] writingRowData = rowdata.toArray(new String[rowdata.size()]);
			 writer.writeNext(writingRowData);
			 }
			
			 writer.close();  
			 } 
			 if(configurationData.get("Shuffled_Header").equalsIgnoreCase("No"))
		     {
					 if(configurationData.get("DuplicateFile_generation" ).equalsIgnoreCase("Yes"))
				     {  
						 int count = 0;
						 String  totalRecords = xls.getCellData("Configuration",1, 2);
				         String totalDuplicateRecords = xls.getCellData("Configuration",1, 15);
						 ArrayList<Integer> allIndexes =uniqunumber(totalDuplicateRecords ,totalRecords);
					     writer.writeNext(headerFiles.RelatedParty()); 
				     	 for(relatedParty con :relatedPartyData) {
							count++;
				    
        	String[] rowData =  { 
        				con.getReportingEntityId(), 
        				con.getCounterpartyId(),
        				con.getRelatedCounterpartyID(),
        				con.getRelation(),
        				con.getRelatedPartyId()
        				};
        	boolean flag= false;
	     	if(allIndexes.contains(count)) {
	     		flag = true;
	     		if(flag) {
		     		for(int z =0;z<=1;z++) {
		     			writer.writeNext(rowData);
		     		}}}
	     		else {
		     		writer.writeNext(rowData);
		     		
		     	}}}
					 else {
						    writer.writeNext(headerFiles.RelatedParty()); 
					     	 for(relatedParty con :relatedPartyData) {
						
					     		 
					     	String[] rowData =  { 
					     			con.getReportingEntityId(), 
			        				con.getCounterpartyId(),
			        				con.getRelatedCounterpartyID(),
			        				con.getRelation(),
			        				con.getRelatedPartyId()
			        				};
					     	writer.writeNext(rowData);	
					 }
				     	writer.close();}}}
					 
					 catch (IOException e) {

					 e.printStackTrace();

					 } }

public  void writeProtectionData(ArrayList<Protection> ProtectionData, String fileName) {
 	 try {
outputfile = createFileObject(fileName);
CSVWriter writer =createCSVWriter(outputfile);
if(configurationData.get("Shuffled_Header").equalsIgnoreCase("Yes")) {
String[] s = headerFiles.Protection();
List<String> strList = Arrays.asList(s);
Collections.shuffle(strList);
s = strList.toArray(new String[strList.size()]);
writer.writeNext(s);
for(Protection con : ProtectionData) {
ArrayList<String> rowdata =new ArrayList();

for(String header :strList){
if(header.equalsIgnoreCase("reportingEntityId")) {
rowdata.add(con.getReportingEntityId());
}
if(header.equalsIgnoreCase("protectionId")) {
rowdata.add(con.getProtectionId());
}
if(header.equalsIgnoreCase("protectionProviderId")) {
rowdata.add(con.getProtectionProviderId());
}
if(header.equalsIgnoreCase("typeOfProtection")) {
rowdata.add(con.getTypeOfProtection());
}
if(header.equalsIgnoreCase("currencyType")) {
rowdata.add(con.getCurrencyType());
}
if(header.equalsIgnoreCase("protectionValue")) {
	 rowdata.add(con.getProtectionValue());
}
if(header.equalsIgnoreCase("typeOfProtectionValue")) {
rowdata.add(con.getTypeOfProtectionValue());
}

if(header.equalsIgnoreCase("protectionValuationApproach")) {
rowdata.add(con.getProtectionValuationApproach());
}
if(header.equalsIgnoreCase("dateOfProtectionValue")) {
rowdata.add(con.getDateOfProtectionValue());
}
if(header.equalsIgnoreCase("originalProtectionValue")) {
rowdata.add(con.getOriginalProtectionValue());	
}
if(header.equalsIgnoreCase("dateOfOriginalProtectionValue")) {
rowdata.add(con.getDateOfOriginalProtectionValue());	
}
if(header.equalsIgnoreCase("protectionRegistryId")) {
rowdata.add(con.getProtectionRegistryId());	
}
if(header.equalsIgnoreCase("protectionExternalId")) {
rowdata.add(con.getProtectionExternalId());	
}

}
String[] writingRowData = rowdata.toArray(new String[rowdata.size()]);
writer.writeNext(writingRowData);
}

writer.close();

} 
if(configurationData.get("Shuffled_Header").equalsIgnoreCase("No"))
{
		 if(configurationData.get("DuplicateFile_generation" ).equalsIgnoreCase("Yes"))
	     {  
			 int count = 0;
			 String  totalRecords = xls.getCellData("Configuration",1, 2);
	         String totalDuplicateRecords = xls.getCellData("Configuration",1, 15);
			 ArrayList<Integer> allIndexes =uniqunumber(totalDuplicateRecords ,totalRecords);
		     writer.writeNext(headerFiles.Protection()); 
             for(Protection con : ProtectionData) {
	         count++;
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
	con.getProtectionExternalId()};
boolean flag= false;
	if(allIndexes.contains(count)) {
		flag = true;
		if(flag) {
 		for(int z =0;z<=1;z++) {
 			writer.writeNext(rowData);
 		}}}
		else {
 		writer.writeNext(rowData);
 		
 	}}}
		 else {
			 writer.writeNext(headerFiles.Protection()); 
		     	 for(Protection con : ProtectionData) {
			
		     		 
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
		     			con.getProtectionExternalId()};
		     	writer.writeNext(rowData);	
		 }
	     	writer.close();}}}
		 
		 catch (IOException e) {

		 e.printStackTrace();

		 } }


public  void writeInstrumentData(ArrayList<Instrument> instrumentData, String fileName) {
	 try 
		 {
			 outputfile = createFileObject(fileName);
			 CSVWriter writer =createCSVWriter(outputfile);
			 if(configurationData.get("Shuffled_Header").equalsIgnoreCase("Yes")) 
		 {
				 String[] s = headerFiles.Instrument();
				 List<String> strList = Arrays.asList(s);
				 Collections.shuffle(strList);
				 s = strList.toArray(new String[strList.size()]);
				 writer.writeNext(s);
				 for(Instrument con : instrumentData)
				 {
					 ArrayList<String> rowdata =new ArrayList();
		 
					 for(String header :strList)
					 {
						 if(header.equalsIgnoreCase("reportingEntityID")) 
						 {
							 rowdata.add(con.getReportingEntityId());
						 }
						 if(header.equalsIgnoreCase("instrumentId")) {
							 rowdata.add(con.getInstrumentId());
						 }
						 if(header.equalsIgnoreCase("branchCode")) {
							 rowdata.add(con.getBranchCode());
						 }
						 
						 if(header.equalsIgnoreCase("contractId")) 
						 {
							 rowdata.add(con.getContractId());
						 }
						 if(header.equalsIgnoreCase("districtOfUtilisation")) {
							 rowdata.add(con.getDistrictOfUtilisation());
						 }
						 if(header.equalsIgnoreCase("instrumentType")) {
							 rowdata.add(con.getInstrumentType());
						 }
						 if(header.equalsIgnoreCase("prioritySector")) 
						 {
							 rowdata.add(con.getPrioritySector());
						 }
						 if(header.equalsIgnoreCase("weakerSection")) {
							 rowdata.add(con.getWeakerSection());
						 }
						 if(header.equalsIgnoreCase("classificationOfActivity")) {
							 rowdata.add(con.getClassificationOfActivity());
						 }
						 if(header.equalsIgnoreCase("sanctionedDate")) {
							 rowdata.add(con.getSanctionDate());
						 }
						 if(header.equalsIgnoreCase("disbursementDate")) {
							 rowdata.add(con.getDisbursementDate());
						 }
						 if(header.equalsIgnoreCase("maturityDate")) {
							 rowdata.add(con.getMaturityDate());
						 }
						 if(header.equalsIgnoreCase("currencyCode")) {
							 rowdata.add(con.getCurrencyCode());
						 }
						 if(header.equalsIgnoreCase("originalSanctionAmount")) {
							 rowdata.add(con.getOrgsanAmmnt());
						 }
						 if(header.equalsIgnoreCase("syndicatedContractId")) {
							 rowdata.add(con.getSyndcateContactId());
						 }
						 if(header.equalsIgnoreCase("recourse")) {
							 rowdata.add(con.getRecourse());
						 }
						 if(header.equalsIgnoreCase("interestRateType")) {
							 rowdata.add(con.getInterestRateType());
						 }
						 if(header.equalsIgnoreCase("amortisationType")) {
							 rowdata.add(con.getAmortisationType());
						 }
						 if(header.equalsIgnoreCase("paymentFrequency")) {
							 rowdata.add(con.getPaymentFrequency());
						 }
						 if(header.equalsIgnoreCase("interestRate")) {
							 rowdata.add(con.getInterRate());
						 }
						 if(header.equalsIgnoreCase("weightedAverageInterestRate")) {
							 rowdata.add(con.getWeightedAverageInterestRate());
						 }
						 if(header.equalsIgnoreCase("instalmentAmount")) {
							 rowdata.add(con.getInstallAmnt());
						 }
						 if(header.equalsIgnoreCase("balanceOutstanding")) {
							 rowdata.add(con.getBalanceOutstanding());
						 }
						 if(header.equalsIgnoreCase("unavailedAmount")) {
							 rowdata.add(con.getUnvailedAmmount());
						 }
						 if(header.equalsIgnoreCase("offBalanceSheetNominalAmount")) {
							 rowdata.add(con.getOffBalMinAmnt());
						 }
						 if(header.equalsIgnoreCase("creditEquivalentOfOffBalanceSheetNominalAmount")) {
							 rowdata.add(con.getCrediteqibaloff());	 
						 }
						 if(header.equalsIgnoreCase("accruedInterest")) {
							 rowdata.add(con.getAccuInterst());	 
						 }
						 if(header.equalsIgnoreCase("amountOverdue")) {
							 rowdata.add(con.getAmntOver());	 
						 }
						 if(header.equalsIgnoreCase("numberOfDaysPastDue")) {
							 rowdata.add(con.getNumPastDue());	 
						 }
						 if(header.equalsIgnoreCase("smaCategory")) {
							 rowdata.add(con.getSmaCatogry());	 
						 }
						 if(header.equalsIgnoreCase("smaCurrentCategorySinceDate")) {
							 rowdata.add(con.getSmaCurrentCatg());	 
						 }
						 if(header.equalsIgnoreCase("npaCategory")) {
							 rowdata.add(con.getNpaCatgCode());	 
						 }
						 if(header.equalsIgnoreCase("npaSinceDate")) {
							 rowdata.add(con.getNpaSinDate());	 
						 }
						 if(header.equalsIgnoreCase("cumulativeRecoveriesSinceNpa")) {
							 rowdata.add(con.getCummRecovSinNpa());	 
						 }
						 if(header.equalsIgnoreCase("accumulatedProvisions")) {
							 rowdata.add(con.getAccProviosions());	 
						 }
						 if(header.equalsIgnoreCase("accumulatedWriteOffs")) {
							 rowdata.add(con.getAccWriteOffs());	 
						 }
						 if(header.equalsIgnoreCase("settlementAmount")) {
							 rowdata.add(con.getSettAmmount());	 
						 }
						 if(header.equalsIgnoreCase("restructuringStatus")) {
							 rowdata.add(con.getRestStatus());	 
						 }
						 if(header.equalsIgnoreCase("restructuringStatusDate")) {
							 rowdata.add(con.getRestDate());	 
						 }
						 if(header.equalsIgnoreCase("status")) {
							 rowdata.add(con.getAccountStatus());	 
						 }
						 if(header.equalsIgnoreCase("statusDate")) {
							 rowdata.add(con.getStatusDate());	 
						 }
						 if(header.equalsIgnoreCase("suitFiledDate")) {
							 rowdata.add(con.getSuitFielDate());	 
						 }
						 
					 }
					 String[] writingRowData = rowdata.toArray(new String[rowdata.size()]);
					 writer.writeNext(writingRowData);
				 }
		 
				 writer.close();
		 	}

		 
		 
			 if(configurationData.get("Shuffled_Header").equalsIgnoreCase("No"))
			   {
					 if(configurationData.get("DuplicateFile_generation" ).equalsIgnoreCase("Yes"))
				     {  
						 int count = 0;
						 String  totalRecords = xls.getCellData("Configuration",1, 2);
				         String totalDuplicateRecords = xls.getCellData("Configuration",1, 15);
						 ArrayList<Integer> allIndexes =uniqunumber(totalDuplicateRecords ,totalRecords);
					     writer.writeNext(headerFiles.Instrument()); 
				     	 for(Instrument con : instrumentData) {
							count++;
				      
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
			    		con.getSuitFielDate() };
			   	boolean flag= false;
				if(allIndexes.contains(count)) {
					flag = true;
					if(flag) {
			 		for(int z =0;z<=1;z++) {
			 			writer.writeNext(rowData);
			 		}}}
					else {
			 		writer.writeNext(rowData);
			 		
			 	}}}
					 else {
						 writer.writeNext(headerFiles.Instrument()); 
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
						    		con.getSuitFielDate() };
					     	writer.writeNext(rowData);	
					 }
				     	writer.close();}}}
					 
					 catch (IOException e) {

					 e.printStackTrace();

					 } }

public  void writecounterpartyRatingData(ArrayList<counterpartyRating> counterpartyRatingData, String fileName) {
    try { 
    	outputfile = createFileObject(fileName);
        
    	 CSVWriter writer =createCSVWriter(outputfile);
    	   System.out.println("No of rows = "+counterpartyRatingData.size()); 
    	 if(configurationData.get("Shuffled_Header").equalsIgnoreCase("Yes")) {
			 String[] s = headerFiles.CounterpartyRating();
			 List<String> strList = Arrays.asList(s);
			 Collections.shuffle(strList);
			 s = strList.toArray(new String[strList.size()]);
			 writer.writeNext(s);
			 for(counterpartyRating con : counterpartyRatingData) {
			 ArrayList<String> rowdata =new ArrayList();
			 
			 for(String header :strList){
			 if(header.equalsIgnoreCase("reportingEntityId")) {
			 rowdata.add(con.getReportingEntityId());
			 }
			 if(header.equalsIgnoreCase("counterpartyRatingId")) {
			 rowdata.add(con.getCounterpartyId());
			 }
			 if(header.equalsIgnoreCase("ratingId")) {
			 rowdata.add(con.getRatingID());
			 }
			 if(header.equalsIgnoreCase("creditRating")) {
				 rowdata.add(con.getCreditRating());
	         }
			 if(header.equalsIgnoreCase("assessmentAgencyOrAuthority")) {
				 rowdata.add(con.getAssessmentAgencyAuthority());
	         }
			 if(header.equalsIgnoreCase("creditRatingAsOn")) {
				 rowdata.add(con.getCreditRatingAsOn());
	         }
			 if(header.equalsIgnoreCase("creditRatingExpiryDate")) {
				 rowdata.add(con.getCreditRatingExpiryDate());
	         }
			 }
			 String[] writingRowData = rowdata.toArray(new String[rowdata.size()]);
			 writer.writeNext(writingRowData);
			 }
			
			 writer.close();  
			 } 
			 if(configurationData.get("Shuffled_Header").equalsIgnoreCase("No"))
		     {
				 if(configurationData.get("DuplicateFile_generation" ).equalsIgnoreCase("Yes"))
			     {  
					 int count = 0;
					 String  totalRecords = xls.getCellData("Configuration",1, 2);
			         String totalDuplicateRecords = xls.getCellData("Configuration",1, 15);
					 ArrayList<Integer> allIndexes =uniqunumber(totalDuplicateRecords ,totalRecords);
				     writer.writeNext(headerFiles.CounterpartyRating()); 
		             for(counterpartyRating con : counterpartyRatingData) {
			         count++;
       
        	String[] rowData =  { 
        				con.getReportingEntityId(), 
        				con.getCounterpartyId(),
        				con.getRatingID(),
        				con.getCreditRating(),
        				con.getAssessmentAgencyAuthority(),
        				con.getCreditRatingAsOn(),
        				con.getCreditRatingExpiryDate()
        				}; 
        	boolean flag= false;
        	if(allIndexes.contains(count)) {
        		flag = true;
        		if(flag) {
         		for(int z =0;z<=1;z++) {
         			writer.writeNext(rowData);
         		}}}
        		else {
         		writer.writeNext(rowData);
         		
         	}}}
				 else {
					  writer.writeNext(headerFiles.CounterpartyRating()); 
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
				     	writer.writeNext(rowData);	
				 }
			     	writer.close();}}}
				 
				 catch (IOException e) {

				 e.printStackTrace();

				 } }

public  void writecounterpartyRiskData(ArrayList<counterpartyRisk> counterpartyRiskData, String fileName) {
    try { 
    	outputfile = createFileObject(fileName);
    	CSVWriter writer =createCSVWriter(outputfile);
    	   System.out.println("No of rows = "+counterpartyRiskData.size()); 
    	if(configurationData.get("Shuffled_Header").equalsIgnoreCase("Yes")) {
   		 String[] s = headerFiles.CounterpartyRisk();
   		 List<String> strList = Arrays.asList(s);
   		 Collections.shuffle(strList);
   		 s = strList.toArray(new String[strList.size()]);
   		 writer.writeNext(s);
   		 for(counterpartyRisk con : counterpartyRiskData) {
   		 ArrayList<String> rowdata =new ArrayList();
   		 
   		 for(String header :strList){
   			if(header.equalsIgnoreCase("reportingEntityId")) {
   			 rowdata.add(con.getReportingEntityId());
   			 }
   			if(header.equalsIgnoreCase("counterpartyId")) {
      			 rowdata.add(con.getCounterpartyId());
      			 }
   			if(header.equalsIgnoreCase("statusOfInsolvencyProceedings")) {
     			 rowdata.add(con.getStatusOfInsolvencyProceedings());
     			 }
   			if(header.equalsIgnoreCase("dateOfInitiationOfInsolvencyProceedings")) {
    			 rowdata.add(con.getDateOfInitiationOfInsolvencyProceedings());
    			 }
   			if(header.equalsIgnoreCase("wilfulDefaulter")) {
   			 rowdata.add(con.getWilfulDefaulter());
   			 }
   			if(header.equalsIgnoreCase("dateOfWilfulDefaulterClassification")) {
      			 rowdata.add(con.getDateOfWilfulDefaulterClassification());
      			 }
   			if(header.equalsIgnoreCase("nonCooperativeBorrower")) {
     			 rowdata.add(con.getNonCooperativeBorrower());
     			 }
   			if(header.equalsIgnoreCase("dateOfNonCooperativeBorrowerClassification")) {
    			 rowdata.add(con.getDateOfNonCooperativeBorrowerClassification());
    			 }
   			if(header.equalsIgnoreCase("fraudulentActivity")) {
   			 rowdata.add(con.getFradulentActivity());
   			 }
   			if(header.equalsIgnoreCase("dateOfFraudulentActivityClassification")) {
      			 rowdata.add(con.getDateOfFradulentActivityClassification());
      			 }
   			if(header.equalsIgnoreCase("internalRating")) {
     			 rowdata.add(con.getInternalRating());
     			 }
   			if(header.equalsIgnoreCase("dateOfInternalRating")) {
    			 rowdata.add(con.getDateOfInternalRating());
    			 }}
   		String[] writingRowData = rowdata.toArray(new String[rowdata.size()]);
		 writer.writeNext(writingRowData);
		 }
		 writer.close(); 
    
   } 
    	if(configurationData.get("Shuffled_Header").equalsIgnoreCase("No"))
    	{
    		 if(configurationData.get("DuplicateFile_generation" ).equalsIgnoreCase("Yes"))
    	     {  
    			 int count = 0;
    			 String  totalRecords = xls.getCellData("Configuration",1, 2);
    	         String totalDuplicateRecords = xls.getCellData("Configuration",1, 15);
    			 ArrayList<Integer> allIndexes =uniqunumber(totalDuplicateRecords ,totalRecords);
    		     writer.writeNext(headerFiles.CounterpartyRisk()); 
                 for(counterpartyRisk con : counterpartyRiskData) {
    	         count++;
   
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
    	        		con.getDateOfInternalRating()  }; 
    	        	
    	        	boolean flag= false;
    	        	if(allIndexes.contains(count)) {
    	        		flag = true;
    	        		if(flag) {
    	         		for(int z =0;z<=1;z++) {
    	         			writer.writeNext(rowData);
    	         		}}}
    	        		else {
    	         		writer.writeNext(rowData);
    	         		
    	         	}}}
    		 else {
    			 writer.writeNext(headerFiles.CounterpartyRisk()); 
			     	 for(counterpartyRisk con : counterpartyRiskData) {
				
			     		 
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
	    	        		con.getDateOfInternalRating()  }; 
			     	writer.writeNext(rowData);	
			 }
		     	writer.close();}}}
			 
			 catch (IOException e) {

			 e.printStackTrace();

			 } }
    		 
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
	    	   String rowContract[]= {"Transaction Records in CounterpartyRatingFile",""+cf.get("CounterpartyRating File")};
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
	       if(key.contains("ProtectionFile")) {
	    	   String rowContract[]= {"Transaction Records in Protection File",""+cf.get("ProtectionFile")};
	    	   writer.writeNext(rowContract);
	    }  
	       if(key.contains("Protectioninstrument File")) {
	    	   String rowContract[]= {"Transaction Records in Protection Instrument File",""+cf.get("Protectioninstrument File")};
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

public void writeCotractData1(ArrayList<Contract> contractData, ArrayList<Counterparty> contractData1,
		ArrayList<counterpartyRating> contractData2, ArrayList<counterpartyRisk> contractData3,
		ArrayList<Protection> contractData4, ArrayList<protectionInstrument> contractData5,
		ArrayList<relatedParty> contractData6, ArrayList<Instrument> contractData7, String fileLocation) {
	// TODO Auto-generated method stub
	
}

 void abc(ArrayList<Contract> contractData, ArrayList<Counterparty> contractData1) {
	for(int i =0;i<=contractData1.size();i++) {
		//contractData1.get(i).get

		
	}
	
}

public void writeAllData(ArrayList<Contract> contractData, ArrayList<Counterparty> counterpartyData,
		ArrayList<counterpartyRating> counterpartyRatingData, ArrayList<counterpartyRisk> counterpartyRiskData,
		ArrayList<Protection> ProtectionData, ArrayList<protectionInstrument> protectionInstrumentData,
		ArrayList<relatedParty> relatedPartyData, ArrayList<Instrument> instrumentData, String fileName) throws IOException {

	 outputfile = createFileObject(fileName);
	 CSVWriter writer =createCSVWriter(outputfile);
	 if(configurationData.get("DuplicateFile_generation" ).equalsIgnoreCase("Yes"))
     {  
		 int count = 0;
		 String  totalRecords = xls.getCellData("Configuration",1, 2);
         String totalDuplicateRecords = xls.getCellData("Configuration",1, 15);
		 ArrayList<Integer> allIndexes =uniqunumber(totalDuplicateRecords ,totalRecords);
	 writer.writeNext(headerFiles.AllDataHeader());
	 
	 for(int i =0;i<=contractData.size()-1;i++) 
		 
	 {
		count++; 
	 
		 
		 String[] rowData= { 
		 contractData.get(i).getReportingEntityId(),
		 contractData.get(i).getContractId(),
		 contractData.get(i).getInstrumentId(),
		 contractData.get(i).getCounterypartyId(),
		 counterpartyData.get(i).getName(),
		 counterpartyData.get(i).getDate(),
		 counterpartyData.get(i).getCasteGen(),
		 counterpartyData.get(i).getCommGen(),
		 counterpartyData.get(i).getPan(),
		 counterpartyData.get(i).getAdharNo(),
		 counterpartyData.get(i).getDin(),
		 counterpartyData.get(i).getCin(),
		 counterpartyData.get(i).getLei(),
		 counterpartyData.get(i).getTan(),
		 counterpartyData.get(i).getGstin(),
		 counterpartyData.get(i).getUdyogAadhaar(),
		 counterpartyData.get(i).getTypeOrg(),
		 counterpartyData.get(i).getBurrrower(),
		 counterpartyData.get(i).getNicCode(),
		 counterpartyData.get(i).getOccupationCode(),
		 counterpartyData.get(i).getAddressLine1(),
		 counterpartyData.get(i).getAddressLine2(),
		 counterpartyData.get(i).getAddressLine3(),
		 counterpartyData.get(i).getPinCode(),
		 counterpartyData.get(i).getStateCode(),
		 counterpartyData.get(i).getDistrictCode(),
		 counterpartyData.get(i).getCountryCode(),
		 counterpartyData.get(i).getTelePhoneNumber(),
		 counterpartyData.get(i).getMobNo(),
		 counterpartyData.get(i).getEmailAddress(),
		 counterpartyRatingData.get(i).getRatingID(),
		 counterpartyRatingData.get(i).getCreditRating(),
		 counterpartyRatingData.get(i).getAssessmentAgencyAuthority(),
		 counterpartyRatingData.get(i).getCreditRatingAsOn(),
		 counterpartyRatingData.get(i).getCreditRatingExpiryDate(),
		 counterpartyRiskData.get(i).getStatusOfInsolvencyProceedings(),
		 counterpartyRiskData.get(i).getDateOfInitiationOfInsolvencyProceedings(),
		 counterpartyRiskData.get(i).getWilfulDefaulter(),
		 counterpartyRiskData.get(i).getDateOfWilfulDefaulterClassification(),
		 counterpartyRiskData.get(i).getNonCooperativeBorrower(),
		 counterpartyRiskData.get(i).getDateOfNonCooperativeBorrowerClassification(),
		 counterpartyRiskData.get(i).getFradulentActivity(),
		 counterpartyRiskData.get(i).getDateOfFradulentActivityClassification(),
		 counterpartyRiskData.get(i).getInternalRating(),
		 counterpartyRiskData.get(i).getDateOfInternalRating(),
		 instrumentData.get(i).getBranchCode(),
		 instrumentData.get(i).getDistrictOfUtilisation(),
		 instrumentData.get(i).getInstrumentType(),
		 instrumentData.get(i).getPrioritySector(),
		 instrumentData.get(i).getWeakerSection(),
		 instrumentData.get(i).getClassificationOfActivity(),
		 instrumentData.get(i).getSanctionDate(),
		 instrumentData.get(i).getDisbursementDate(),
		 instrumentData.get(i).getMaturityDate(),
		 instrumentData.get(i).getCurrencyCode(),
		 instrumentData.get(i).getOrgsanAmmnt(),
		 instrumentData.get(i).getSyndcateContactId(),
		 instrumentData.get(i).getRecourse(),
		 instrumentData.get(i).getInterestRateType(),
		 instrumentData.get(i).getAmortisationType(),
		 instrumentData.get(i).getPaymentFrequency(),
		 instrumentData.get(i).getInterRate(),
		 instrumentData.get(i).getWeightedAverageInterestRate(),
		 instrumentData.get(i).getInstallAmnt(),
		 instrumentData.get(i).getBalanceOutstanding(),
		 instrumentData.get(i).getUnvailedAmmount(),
		 instrumentData.get(i).getOffBalMinAmnt(),
		 instrumentData.get(i).getCrediteqibaloff(),
		 instrumentData.get(i).getAccuInterst(),
		 instrumentData.get(i).getAmntOver(),
		 instrumentData.get(i).getNumPastDue(),
		 instrumentData.get(i).getSmaCatogry(),
		 instrumentData.get(i).getSmaCurrentCatg(),
		 instrumentData.get(i).getNpaCatgCode(),
		 instrumentData.get(i).getNpaSinDate(),
		 instrumentData.get(i).getCummRecovSinNpa(),
		 instrumentData.get(i).getAccProviosions(),
		 instrumentData.get(i).getAccWriteOffs(),
		 instrumentData.get(i).getSettAmmount(),
		 instrumentData.get(i).getRestStatus(),
		 instrumentData.get(i).getRestDate(),
		 instrumentData.get(i).getAccountStatus(),
		 instrumentData.get(i).getStatusDate(),
		 instrumentData.get(i).getSuitFielDate(),
		 ProtectionData.get(i).getProtectionId(),
		 ProtectionData.get(i).getProtectionProviderId(),
		 ProtectionData.get(i).getTypeOfProtection(),
		 ProtectionData.get(i).getCurrencyType(),
		 ProtectionData.get(i).getProtectionValue(),
		 ProtectionData.get(i).getTypeOfProtectionValue(),
		 ProtectionData.get(i).getProtectionValuationApproach(),
		 ProtectionData.get(i).getDateOfProtectionValue(),
		 ProtectionData.get(i).getOriginalProtectionValue(),
		 ProtectionData.get(i).getDateOfOriginalProtectionValue(),
		 ProtectionData.get(i).getProtectionRegistryId(),
		 ProtectionData.get(i).getProtectionExternalId(),
		 protectionInstrumentData.get(i).getProtectionAllocatedValue(),
		 protectionInstrumentData.get(i).getChargeType(),
		 relatedPartyData.get(i).getRelatedCounterpartyID()
		
		 };
		boolean flag= false;
		if(allIndexes.contains(count)) {
			flag = true;
			if(flag) {
	 		for(int z =0;z<=1;z++) {
	 			writer.writeNext(rowData);
	 		}}}
			else {
	 		writer.writeNext(rowData);
	 		
	 	}}}
		writer.close();
		
	}
} 

