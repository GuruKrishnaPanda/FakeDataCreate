package ReUsable;


import java.io.IOException;
import java.util.ArrayList;

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
			generateEntityFiles.generateContractfile(contractData,folderName);
			generateEntityFiles.generateCounterpartyfile(counterPartyData,folderName);
			generateEntityFiles.generateProtectionInstrumentfile(protectionInstrumentData, folderName);
			generateEntityFiles.generateRelatedPartyfile(relatedPartyData, folderName);
			generateEntityFiles.generateProtectionfile(ProtectionData, folderName);
			generateEntityFiles.generateCounterpartyRiskfile(counterpartyRiskData,folderName);
			generateEntityFiles.generateCounterpartyRatingfile(counterpartyRatingData, folderName);
			generateEntityFiles.generateInstrumentfile(InstrumentData, folderName);
			
			Utils.compressFolder(folderName);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//ArrayList<Counterparty> counterPartyData = eds.createCounterPartyData(contractData);
		
		
	}
	
	
	



}
