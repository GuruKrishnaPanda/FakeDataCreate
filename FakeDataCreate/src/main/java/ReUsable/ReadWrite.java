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
	
	 File file;
	 FileWriter outputfile;
	 List hearderData;
	
	
/*public  void writeCotractData(ArrayList<Contract> contractData, String fileName) {
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
}*/
	 /*if(the condition in th econfig excel file is yes){
     {
     	
			List<String> strList = Arrays.asList(s);
			Collections.shuffle(strList);
			s = strList.toArray(new String[strList.size()]);
     	 writer.writeNext(s);
     	 for(Contract con : contractData) {
     	 	Arraylist<String> rowdata =new Arraylist();
     	 	for(STring header :strList){}
     	 	
     	 		if(header.eqoigonecare("reportingEntityId")
     	 			rowdata.add(con.getReportingEntityId());
     	 	}
     	 	
			   String writingRowData = rowdata.toArray(new String[rowdata.size()]);
			   writer.writeNext(writingRowData); 
     	 	}
     	
     
     }if(the condition in config file is no)
     {
     	 writer.writeNext(s); 
     	 for(Contract con : contractData) {
     	String[] rowData =  { 
     				con.getReportingEntityId(), 
     				con.getContractId(),
     				con.getInstrumentId(),
     				con.getCounterypartyId()}; 
     	writer.writeNext(rowData); 
     }
     
     */
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
		     writer.writeNext(headerFiles.contractHeader()); 
	     	 for(Contract con : contractData) {
	     	String[] rowData =  { 
	     				con.getReportingEntityId(), 
	     				con.getContractId(),
	     				con.getInstrumentId(),
	     				con.getCounterypartyId()}; 
	     	writer.writeNext(rowData); 
	     }
	     	writer.close();}}
		 
		 catch (IOException e) {

		 e.printStackTrace();

		 } }

public void writeCounterPartyData(ArrayList<Counterparty> contractData, String fileName) {
    try {
    	
    	outputfile = createFileObject(fileName);
        CSVWriter writer =createCSVWriter(outputfile);
        System.out.println("No of rows = "+contractData.size()); 
        if(configurationData.get("Shuffled_Header").equalsIgnoreCase("Yes")) {
			 String[] s = headerFiles.counterPartyHeader();
			 List<String> strList = Arrays.asList(s);
			 Collections.shuffle(strList);
			 s = strList.toArray(new String[strList.size()]);
			 writer.writeNext(s);
			 for(Counterparty con : contractData) {
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
		     writer.writeNext(headerFiles.counterPartyHeader()); 
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
	     	writer.close();}
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
			 CSVWriter writer =createCSVWriter(outputfile);
			   System.out.println("No of rows = "+contractData.size()); 
			 if(configurationData.get("Shuffled_Header").equalsIgnoreCase("Yes")) {
			 String[] s = headerFiles.RelatedParty();
			 List<String> strList = Arrays.asList(s);
			 Collections.shuffle(strList);
			 s = strList.toArray(new String[strList.size()]);
			 writer.writeNext(s);
			 for(relatedParty con : contractData) {
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
			 }
			 String[] writingRowData = rowdata.toArray(new String[rowdata.size()]);
			 writer.writeNext(writingRowData);
			 }
			
			 writer.close();  
			 } 
			 if(configurationData.get("Shuffled_Header").equalsIgnoreCase("No"))
		     {
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
    } }
    catch (IOException e) { 
      
        e.printStackTrace(); 
        
    } 
}

public  void writeProtectionData(ArrayList<Protection> contractData, String fileName) {
 	 try {
outputfile = createFileObject(fileName);
CSVWriter writer =createCSVWriter(outputfile);
if(configurationData.get("Shuffled_Header").equalsIgnoreCase("Yes")) {
String[] s = headerFiles.Protection();
List<String> strList = Arrays.asList(s);
Collections.shuffle(strList);
s = strList.toArray(new String[strList.size()]);
writer.writeNext(s);
for(Protection con : contractData) {
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
writer.writeNext(headerFiles.Protection()); 
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
writer.close();}}

catch (IOException e) {

e.printStackTrace();

} }



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
        
    	 CSVWriter writer =createCSVWriter(outputfile);
    	   System.out.println("No of rows = "+contractData.size()); 
    	 if(configurationData.get("Shuffled_Header").equalsIgnoreCase("Yes")) {
			 String[] s = headerFiles.CounterpartyRating();
			 List<String> strList = Arrays.asList(s);
			 Collections.shuffle(strList);
			 s = strList.toArray(new String[strList.size()]);
			 writer.writeNext(s);
			 for(counterpartyRating con : contractData) {
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
    } }
    catch (IOException e) { 
        
        e.printStackTrace(); 
        
    } 
}

public  void writecounterpartyRiskData(ArrayList<counterpartyRisk> contractData, String fileName) {
    try { 
    	outputfile = createFileObject(fileName);
    	CSVWriter writer =createCSVWriter(outputfile);
    	   System.out.println("No of rows = "+contractData.size()); 
    	if(configurationData.get("Shuffled_Header").equalsIgnoreCase("Yes")) {
   		 String[] s = headerFiles.CounterpartyRisk();
   		 List<String> strList = Arrays.asList(s);
   		 Collections.shuffle(strList);
   		 s = strList.toArray(new String[strList.size()]);
   		 writer.writeNext(s);
   		 for(counterpartyRisk con : contractData) {
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
    	if(configurationData.get("Shuffled_Header").equalsIgnoreCase("No")) {
    		 writer.writeNext(headerFiles.CounterpartyRisk()); 
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
    	}}
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
