package ReUsable;


import java.io.IOException;
import java.util.ArrayList;

import Utilities.Utils;
import pojoClases.Contract;
import pojoClases.Counterparty;
import pojoClases.protectionInstrument;
import pojoClases.relatedParty;


public class ReusableFactory {
	
	settingEntityDataSet eds =  new settingEntityDataSet();
	GenerateEntityFiles generateEntityFiles = new GenerateEntityFiles();
	public void createData(int numberData) {
		
		ArrayList<Contract> contractData = eds.createContractData(numberData);
		ArrayList<Counterparty> counterPartyData = eds.createCounterPartyData(contractData);
		ArrayList<protectionInstrument> protectionInstrumentData = eds.createProtectionInstrumentData(contractData);
		ArrayList<relatedParty> relatedPartyData = eds.createRelatedPartyData(contractData);
		
		try {
			
			String folderName = Utils.generateFolderwithName();
			generateEntityFiles.generateContractfile(contractData,folderName);
			generateEntityFiles.generateCounterpartyfile(counterPartyData,folderName);
			generateEntityFiles.generateProtectionInstrumentfile(protectionInstrumentData, folderName);
			generateEntityFiles.generateRelatedPartyfile(relatedPartyData, folderName);
			Utils.compressFolder(folderName);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//ArrayList<Counterparty> counterPartyData = eds.createCounterPartyData(contractData);
		
		
	}
	
	
	



}
