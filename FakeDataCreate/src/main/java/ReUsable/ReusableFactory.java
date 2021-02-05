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

import EntityDataSet.ContractFile;
import EntityDataSet.CounterPartyFile;
import EntityDataSet.InstrumentFile;
import EntityDataSet.ProtectionFile;
import EntityDataSet.counterpartyRatingFile;
import EntityDataSet.counterpartyRiskFile;
import EntityDataSet.protectionInstrumentFile;
import EntityDataSet.relatedPartyFile;
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
	String scenarioName;
	GenericXLSXReader xlsx;
	
	/*public ReusableFactory(Hashtable<String, String> configurationData) {
		data = configurationData;
	}*/
	public ReusableFactory(){
		System.out.println("-----------");
	}
	
	Hashtable<String, String> data ;//= DataUtil.getData("Configuration", xlsx,"validDataCreation");
	//settingEntityDataSet eds =  new settingEntityDataSet();
	CounterPartyFile cpf ;
	ContractFile cf ;
	counterpartyRatingFile crf ;
	counterpartyRiskFile csf ;
	InstrumentFile iF ;
	protectionInstrumentFile pif ;
	ProtectionFile pf ;
	relatedPartyFile rpf ;
	GenerateEntityFiles generateEntityFiles ;
	
	Faker faker ;
	datacreation dc;
	String folderName;
	String fileName;
	public ReusableFactory(String scenarioName, GenericXLSXReader xlsx) {
		this.scenarioName = scenarioName;
		this.xlsx = xlsx;
		System.out.println("inside this");
		data = DataUtil.getData("Configuration", xlsx,scenarioName);
		 cpf = new CounterPartyFile(data);
		 cf = new ContractFile(data);
		 crf = new counterpartyRatingFile(data);
		 csf = new counterpartyRiskFile(data);
		 iF = new InstrumentFile(data);
		 pif = new protectionInstrumentFile(data);
		 pf = new ProtectionFile(data);
		 rpf = new relatedPartyFile(data);
		 generateEntityFiles = new GenerateEntityFiles(data);	
		 faker =  new Faker();
		 dc = new datacreation();
	}
	
	public void createData(int numberData) {
		
		//ArrayList<Contract> contractData = eds.createContractData(null);
		ArrayList<Counterparty> counterPartyData = cpf.createCounterPartyData(numberData);
		ArrayList<Contract> contractData = cf.createContractData(counterPartyData);
		ArrayList<Instrument> InstrumentData= iF.createInstrumentData(contractData);
		ArrayList<protectionInstrument> protectionInstrumentData =  pif.createProtectionInstrumentData(InstrumentData );
		ArrayList<relatedParty> relatedPartyData = rpf.createRelatedPartyData(counterPartyData);
		ArrayList<Protection> ProtectionData = pf.createProtectionData(protectionInstrumentData);
		ArrayList<counterpartyRisk> counterpartyRiskData = csf.createCounterpartyRiskData(counterPartyData);
		ArrayList<counterpartyRating> counterpartyRatingData= crf.createcounterpartyRatingData(counterPartyData);
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
	//public void createData(Hashtable<String, String> configurationData) {
	public void createData() {
		
		int numberData = Utils.completeinteger(data.get("NoOfData"));
		
		//ArrayList<Contract> contractData = eds.createContractData(null);
		ArrayList<Counterparty> counterPartyData = cpf.createCounterPartyData(numberData);
		ArrayList<Contract> contractData = cf.createContractData(counterPartyData);
		ArrayList<Instrument> InstrumentData= iF.createInstrumentData(contractData);
		ArrayList<protectionInstrument> protectionInstrumentData =  pif.createProtectionInstrumentData(InstrumentData );
		ArrayList<relatedParty> relatedPartyData = rpf.createRelatedPartyData(counterPartyData);
		ArrayList<Protection> ProtectionData = pf.createProtectionData(protectionInstrumentData);
		ArrayList<counterpartyRisk> counterpartyRiskData = csf.createCounterpartyRiskData(counterPartyData);
		ArrayList<counterpartyRating> counterpartyRatingData= crf.createcounterpartyRatingData(counterPartyData);
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