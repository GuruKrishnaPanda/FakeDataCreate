package ReUsable;


import java.io.IOException;
import java.util.ArrayList;

import Utilities.Utils;
import pojoClases.Contract;
import pojoClases.Counterparty;


public class ReusableFactory {
	
	settingEntityDataSet eds =  new settingEntityDataSet();
	GenerateEntityFiles generateEntityFiles = new GenerateEntityFiles();
	public void createData(int numberData) {
		
		ArrayList<Contract> contractData = eds.createContractData(numberData);
		ArrayList<Counterparty> counterPartyData = eds.createCounterPartyData(contractData);
		
		try {
			
			String folderName = Utils.generateFolderwithName();
			generateEntityFiles.generateContractfile(contractData,folderName);
			generateEntityFiles.generateCounterpartyfile(counterPartyData,folderName);
			Utils.compressFolder(folderName);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//ArrayList<Counterparty> counterPartyData = eds.createCounterPartyData(contractData);
		
		
	}
	
	
	



}
