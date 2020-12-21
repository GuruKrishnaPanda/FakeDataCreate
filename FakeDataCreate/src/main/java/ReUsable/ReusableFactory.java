package ReUsable;  


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import com.github.javafaker.Faker;

import Utilities.Constants;
import Utilities.DataUtil;
import Utilities.GenericXLSXReader;
import Utilities.Utils;
import pojoClases.Contract;
import pojoClases.Counterparty;
import pojoClases.Instrument;
import pojoClases.Protection;
import pojoClases.counterpartyRating;
import pojoClases.protectionInstrument;
import pojoClases.relatedParty;
import pojoClases.counterpartyRisk;


public class ReusableFactory {
	
	settingEntityDataSet eds =  new settingEntityDataSet();
	GenerateEntityFiles generateEntityFiles = new GenerateEntityFiles();
	GenericXLSXReader xlsx =  new GenericXLSXReader(System.getProperty("user.dir")+"\\resources\\Configuration.xlsx");
	Hashtable<String, String> data = DataUtil.getData("Configuration", xlsx);
	Faker faker =  new Faker();
	datacreation dc = new datacreation();
	String folderName;
	String fileName;
	public void createData(int numberData) {
		
		//ArrayList<Contract> contractData = eds.createContractData(null);
		ArrayList<Counterparty> counterPartyData = eds.createCounterPartyData(numberData);
		ArrayList<Contract> contractData = eds.createContractData(counterPartyData);
		ArrayList<Instrument> InstrumentData= eds.createInstrumentData(contractData);
		ArrayList<protectionInstrument> protectionInstrumentData = eds.createProtectionInstrumentData(InstrumentData );
		ArrayList<relatedParty> relatedPartyData = eds.createRelatedPartyData(counterPartyData);
		ArrayList<Protection> ProtectionData = eds.createProtectionData(protectionInstrumentData);
		ArrayList<counterpartyRisk> counterpartyRiskData = eds.createCounterpartyRiskData(counterPartyData);
		ArrayList<counterpartyRating> counterpartyRatingData= eds.createcounterpartyRatingData(counterPartyData);
		//ArrayList<Instrument> InstrumentData= eds.createInstrumentData(contractData);
	    	try {
			 folderName= Utils.generateFolderwithName( counterPartyData.get(0).getReportingEntityId());
			 fileName = folderName;
			 if(data.get("All_Files").equalsIgnoreCase("No")) {
			if(data.get("Name_Of_File").equalsIgnoreCase("Valid")) {
				if(data.get("Only_Generate_Mandetory_Files").equalsIgnoreCase("Yes")) {
					generateEntityFiles.generateContractfile(contractData,folderName,fileName);
					generateEntityFiles.generateCounterpartyfile(counterPartyData,folderName,fileName);
					generateEntityFiles.generateInstrumentfile(InstrumentData, folderName,fileName);
					HashMap<String,Integer> cf = dc.controlFile1(folderName);
					generateEntityFiles.generateControlfile(cf, folderName, fileName);
					//generateEntityFiles.generateAllfile(contractData, counterPartyData, counterpartyRatingData,protectionInstrumentData, ProtectionData, counterpartyRiskData, relatedPartyData, InstrumentData, folderName, fileName);
					

				}else {
				generateEntityFiles.generateContractfile(contractData,folderName,fileName);
				generateEntityFiles.generateCounterpartyfile(counterPartyData,folderName,fileName);
				generateEntityFiles.generateCounterpartyRatingfile(counterpartyRatingData, folderName,fileName);
				generateEntityFiles.generateProtectionInstrumentfile(protectionInstrumentData, folderName,fileName);
				generateEntityFiles.generateRelatedPartyfile(relatedPartyData, folderName,fileName);
				generateEntityFiles.generateProtectionfile(ProtectionData, folderName,fileName);
				generateEntityFiles.generateCounterpartyRiskfile(counterpartyRiskData,folderName,fileName);
				generateEntityFiles.generateInstrumentfile(InstrumentData, folderName,fileName);
				HashMap<String,Integer> cf = dc.controlFile1(folderName);
				generateEntityFiles.generateControlfile(cf, folderName, fileName);
				//generateEntityFiles.generateAllfile(contractData, counterPartyData, counterpartyRatingData,protectionInstrumentData, ProtectionData, counterpartyRiskData, relatedPartyData, InstrumentData, folderName, fileName);
				}
			}
			

			if(data.get("Name_Of_File").equalsIgnoreCase("Invalid")) {
				if((data.get("InValidNameFilesInclude").equalsIgnoreCase("Mandetory"))){
					String selectedValue = faker.regexify("Contract|Instrument|CounterParty|ControlFile|All");
					String negfileName = inValidFileName();
					if(selectedValue.equalsIgnoreCase("Contract")) {
						generateEntityFiles.generateContractfile(contractData,folderName,negfileName);
						generateEntityFiles.generateCounterpartyfile(counterPartyData,folderName,fileName);
						generateEntityFiles.generateCounterpartyRatingfile(counterpartyRatingData, folderName,fileName);
						generateEntityFiles.generateProtectionInstrumentfile(protectionInstrumentData, folderName,fileName);
						generateEntityFiles.generateRelatedPartyfile(relatedPartyData, folderName,fileName);
						generateEntityFiles.generateProtectionfile(ProtectionData, folderName,fileName);
						generateEntityFiles.generateCounterpartyRiskfile(counterpartyRiskData,folderName,fileName);
						generateEntityFiles.generateInstrumentfile(InstrumentData, folderName,fileName);
						HashMap<String,Integer> cf = dc.controlFile1(folderName);
						generateEntityFiles.generateControlfile(cf, folderName, fileName);
						//generateEntityFiles.generateAllfile(contractData, counterPartyData, counterpartyRatingData,protectionInstrumentData, ProtectionData, counterpartyRiskData, relatedPartyData, InstrumentData, folderName, fileName);
				
				
					}
					if(selectedValue.equalsIgnoreCase("Instrument")) {
						generateEntityFiles.generateContractfile(contractData,folderName,fileName);
						generateEntityFiles.generateCounterpartyfile(counterPartyData,folderName,fileName);
						generateEntityFiles.generateCounterpartyRatingfile(counterpartyRatingData, folderName,fileName);
						generateEntityFiles.generateProtectionInstrumentfile(protectionInstrumentData, folderName,fileName);
						generateEntityFiles.generateRelatedPartyfile(relatedPartyData, folderName,fileName);
						generateEntityFiles.generateProtectionfile(ProtectionData, folderName,fileName);
						generateEntityFiles.generateCounterpartyRiskfile(counterpartyRiskData,folderName,fileName);
						generateEntityFiles.generateInstrumentfile(InstrumentData,folderName, negfileName);
						HashMap<String,Integer> cf = dc.controlFile1(folderName);
						generateEntityFiles.generateControlfile(cf, folderName, fileName);
						//generateEntityFiles.generateAllfile(contractData, counterPartyData, counterpartyRatingData,protectionInstrumentData, ProtectionData, counterpartyRiskData, relatedPartyData, InstrumentData, folderName, fileName);
						
					}

					if(selectedValue.equalsIgnoreCase("CounterParty")) {
						generateEntityFiles.generateContractfile(contractData,folderName,fileName);
						generateEntityFiles.generateCounterpartyfile(counterPartyData,folderName,negfileName);
						generateEntityFiles.generateCounterpartyRatingfile(counterpartyRatingData, folderName,fileName);
						generateEntityFiles.generateProtectionInstrumentfile(protectionInstrumentData, folderName,fileName);
						generateEntityFiles.generateRelatedPartyfile(relatedPartyData, folderName,fileName);
						generateEntityFiles.generateProtectionfile(ProtectionData, folderName,fileName);
						generateEntityFiles.generateCounterpartyRiskfile(counterpartyRiskData,folderName,fileName);
						generateEntityFiles.generateInstrumentfile(InstrumentData,folderName, fileName);
						HashMap<String,Integer> cf = dc.controlFile1(folderName);
						generateEntityFiles.generateControlfile(cf, folderName, fileName);
						//generateEntityFiles.generateAllfile(contractData, counterPartyData, counterpartyRatingData,protectionInstrumentData, ProtectionData, counterpartyRiskData, relatedPartyData, InstrumentData, folderName, fileName);
						
					}
					if(selectedValue.equalsIgnoreCase("ControlFile")) {
						generateEntityFiles.generateContractfile(contractData,folderName,fileName);
						generateEntityFiles.generateCounterpartyfile(counterPartyData,folderName,fileName);
						generateEntityFiles.generateCounterpartyRatingfile(counterpartyRatingData, folderName,fileName);
						generateEntityFiles.generateProtectionInstrumentfile(protectionInstrumentData, folderName,fileName);
						generateEntityFiles.generateRelatedPartyfile(relatedPartyData, folderName,fileName);
						generateEntityFiles.generateProtectionfile(ProtectionData, folderName,fileName);
						generateEntityFiles.generateCounterpartyRiskfile(counterpartyRiskData,folderName,fileName);
						generateEntityFiles.generateInstrumentfile(InstrumentData, folderName,fileName);
						HashMap<String,Integer> cf = dc.controlFile1(folderName);
						generateEntityFiles.generateControlfile(cf, folderName, fileName);
						//generateEntityFiles.generateAllfile(contractData, counterPartyData, counterpartyRatingData,protectionInstrumentData, ProtectionData, counterpartyRiskData, relatedPartyData, InstrumentData, folderName, fileName);
						
					}
					if(selectedValue.equalsIgnoreCase("All")) {
						generateEntityFiles.generateContractfile(contractData,folderName,inValidFileName());
						generateEntityFiles.generateCounterpartyfile(counterPartyData,folderName,inValidFileName());
						generateEntityFiles.generateCounterpartyRatingfile(counterpartyRatingData, folderName,fileName);
						generateEntityFiles.generateProtectionInstrumentfile(protectionInstrumentData, folderName,inValidFileName());
						generateEntityFiles.generateRelatedPartyfile(relatedPartyData, folderName,fileName);
						generateEntityFiles.generateProtectionfile(ProtectionData, folderName,fileName);
						generateEntityFiles.generateCounterpartyRiskfile(counterpartyRiskData,folderName,fileName);
						generateEntityFiles.generateInstrumentfile(InstrumentData, folderName,inValidFileName());
						HashMap<String,Integer> cf = dc.controlFile1(folderName);
						generateEntityFiles.generateControlfile(cf, folderName, fileName);
						//generateEntityFiles.generateAllfile(contractData, counterPartyData, counterpartyRatingData,protectionInstrumentData, ProtectionData, counterpartyRiskData, relatedPartyData, InstrumentData, folderName, fileName);
						
					}					
				}
				if((data.get("InValidNameFilesInclude").equalsIgnoreCase("Optional"))){
					generateEntityFiles.generateContractfile(contractData,folderName,fileName);
					generateEntityFiles.generateCounterpartyfile(counterPartyData,folderName,fileName);
					generateEntityFiles.generateCounterpartyRatingfile(counterpartyRatingData, folderName,fileName);
					generateEntityFiles.generateProtectionInstrumentfile(protectionInstrumentData, folderName,fileName);
					generateEntityFiles.generateRelatedPartyfile(relatedPartyData, folderName,inValidFileName());
					generateEntityFiles.generateProtectionfile(ProtectionData, folderName,fileName);
					generateEntityFiles.generateCounterpartyRiskfile(counterpartyRiskData,folderName,fileName);
					generateEntityFiles.generateInstrumentfile(InstrumentData, folderName,inValidFileName());
					HashMap<String,Integer> cf = dc.controlFile1(folderName);
					generateEntityFiles.generateControlfile(cf, folderName, fileName);
					//generateEntityFiles.generateAllfile(contractData, counterPartyData, counterpartyRatingData,protectionInstrumentData, ProtectionData, counterpartyRiskData, relatedPartyData, InstrumentData, folderName, fileName);
					
				}
				if((data.get("InValidNameFilesInclude").equalsIgnoreCase("Both"))){
					String negfileName = inValidFileName();
					generateEntityFiles.generateContractfile(contractData,folderName,fileName);
					generateEntityFiles.generateCounterpartyfile(counterPartyData,folderName,negfileName);
					generateEntityFiles.generateCounterpartyRatingfile(counterpartyRatingData, folderName,fileName);
					generateEntityFiles.generateProtectionInstrumentfile(protectionInstrumentData, folderName,fileName);
					generateEntityFiles.generateRelatedPartyfile(relatedPartyData, folderName,inValidFileName());
					generateEntityFiles.generateProtectionfile(ProtectionData, folderName,fileName);
					generateEntityFiles.generateCounterpartyRiskfile(counterpartyRiskData,folderName,fileName);
					generateEntityFiles.generateInstrumentfile(InstrumentData, folderName,inValidFileName());
					HashMap<String,Integer> cf = dc.controlFile1(folderName);
					generateEntityFiles.generateControlfile(cf, folderName, fileName);
					//generateEntityFiles.generateAllfile(contractData, counterPartyData, counterpartyRatingData,protectionInstrumentData, ProtectionData, counterpartyRiskData, relatedPartyData, InstrumentData, folderName, fileName);
					
				}
				
			}
			 }
			 if(data.get("All_Files").equalsIgnoreCase("Yes")) 
			 {
					generateEntityFiles.generateAllfile(contractData, counterPartyData, counterpartyRatingData,protectionInstrumentData, ProtectionData, counterpartyRiskData, relatedPartyData, InstrumentData, folderName, fileName);
			 }
			//Utils.compressFolder(folderName);
		} catch (IOException e) {
			
			e.printStackTrace();
		}	
		
		
	}
	
	public  String inValidFileName() {
		
		String reportingID;
		String dateField;
		String timeField;
		String folderName = null;
		String randomValue = faker.regexify("reportingID|date|time|All");
		if(randomValue.equalsIgnoreCase("reportingID")) {
			String value =  faker.regexify("1|2|4");
			int j = Integer.parseInt(value);
			reportingID = faker.regexify("[A-Z0-9]{"+j+"}");
			SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");  
			String strDateFormat = "hhmmss";
			DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		    Date date = new Date();
		    String datePart = formatter.format(date);
		    String timePart =dateFormat.format(date);
		    folderName = reportingID+"-"+datePart+"-"+timePart;	
		}
		if(randomValue.equalsIgnoreCase("date")) {
			
			dateField = dc.genDate();
			String strDateFormat = "hhmmss";
			DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		    Date date = new Date();
		    timeField =dateFormat.format(date);
		    folderName = Constants.ReportingMemberID+"-"+dateField+"-"+timeField;	
		}

		if(randomValue.equalsIgnoreCase("time")) {
			SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
			String strDateFormat = "mmss";
			DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		    Date date = new Date();
		    dateField = formatter.format(date);
		    timeField =dateFormat.format(date);
		    folderName = Constants.ReportingMemberID+"-"+dateField+"-"+timeField;	
		}

		if(randomValue.equalsIgnoreCase("All")) {
			String value =  faker.regexify("1|2|4");
			int j = Integer.parseInt(value);
			reportingID = faker.regexify("[A-Z0-9]{"+j+"}");
			dateField = dc.genDate();
			String strDateFormat = "mmss";
			DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		    Date date = new Date();
		    timeField =dateFormat.format(date);
		    folderName = reportingID+"-"+dateField+"-"+timeField;
		}
		return folderName;

	
	}
	
}