package ReUsable;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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
	GenericXLSXReader xlsx =  new GenericXLSXReader(System.getProperty("user.dir")+"\\resources\\configuration.xlsx");
	Hashtable<String, String> data = DataUtil.getData("", xlsx);
	Faker faker =  new Faker();
	public void createData(int numberData) {
		
		ArrayList<Contract> contractData = eds.createContractData(numberData);
		ArrayList<Counterparty> counterPartyData = eds.createCounterPartyData(contractData);
		ArrayList<protectionInstrument> protectionInstrumentData = eds.createProtectionInstrumentData(contractData);
		ArrayList<relatedParty> relatedPartyData = eds.createRelatedPartyData(contractData);
		ArrayList<Protection> ProtectionData = eds.createProtectionData(contractData);
		ArrayList<counterpartyRisk> counterpartyRiskData = eds.createCounterpartyRiskData(contractData);
		ArrayList<counterpartyRating> counterpartyRatingData= eds.createcounterpartyRatingData(contractData);
		ArrayList<Instrument> InstrumentData= eds.createInstrumentData(contractData);
	
		
		try {
			String folderName = Utils.generateFolderwithName();
			if(data.get("Name_Of_File").equalsIgnoreCase("Valid")) {
				generateEntityFiles.generateContractfile(contractData,folderName);
				generateEntityFiles.generateCounterpartyfile(counterPartyData,folderName);
				generateEntityFiles.generateCounterpartyRatingfile(counterpartyRatingData, folderName);
				generateEntityFiles.generateProtectionInstrumentfile(protectionInstrumentData, folderName);
				generateEntityFiles.generateRelatedPartyfile(relatedPartyData, folderName);
				generateEntityFiles.generateProtectionfile(ProtectionData, folderName);
				generateEntityFiles.generateCounterpartyRiskfile(counterpartyRiskData,folderName);
				generateEntityFiles.generateInstrumentfile(InstrumentData, folderName);
				generateEntityFiles.generateControlfile("", folderName);
			}
			if(data.get("Name_Of_File").equalsIgnoreCase("Invalid")) {
				if((data.get("InValidNameFilesInclude").equalsIgnoreCase("Mandetory"))){
					String mandetoryFiles = data.get("MandetoryFiles");
					String selectedValue = faker.regexify(mandetoryFiles+"|All");
					inValidFileName();
									}
				if((data.get("InValidNameFilesInclude").equalsIgnoreCase("Optional"))){
					
				}
				if((data.get("InValidNameFilesInclude").equalsIgnoreCase("Both"))){
					
				}
				generateEntityFiles.generateContractfile(contractData,folderName);
				generateEntityFiles.generateCounterpartyfile(counterPartyData,folderName);
				generateEntityFiles.generateCounterpartyRatingfile(counterpartyRatingData, folderName);
				generateEntityFiles.generateProtectionInstrumentfile(protectionInstrumentData, folderName);
				generateEntityFiles.generateRelatedPartyfile(relatedPartyData, folderName);
				generateEntityFiles.generateProtectionfile(ProtectionData, folderName);
				generateEntityFiles.generateCounterpartyRiskfile(counterpartyRiskData,folderName);
				generateEntityFiles.generateInstrumentfile(InstrumentData, folderName);
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
		 String folderName;
		String randomValue = faker.regexify("reportingID|date|time|All");
		if(randomValue.equalsIgnoreCase("reportingID")) {
			reportingID = faker.regexify("[A-Z0-9]{4}");
			SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");  
			String strDateFormat = "hhmmss";
			DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		    Date date = new Date();
		    String datePart = formatter.format(date);
		    String timePart =dateFormat.format(date);
		    folderName = reportingID+"-"+datePart+"-"+timePart;	
		}
		if(randomValue.equalsIgnoreCase("date")) {
			
			
		}

		if(randomValue.equalsIgnoreCase("time")) {
			String data = faker.regexify("[A-Z0-9]{4}");
			System.out.println(data);
		}

		if(randomValue.equalsIgnoreCase("All")) {
			reportingID = faker.regexify("[A-Z0-9]{4}");
			
		}
		return randomValue;

	
	}
	
}
