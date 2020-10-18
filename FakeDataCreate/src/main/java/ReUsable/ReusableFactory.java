package ReUsable;


import java.io.IOException;
import java.util.ArrayList;

import pojoClases.Contract;
import pojoClases.Counterparty;


public class ReusableFactory {
	
	settingEntityDataSet eds =  new settingEntityDataSet();
	ReadWrite readwrite = new ReadWrite();
	public void createData(int numberData) {
		
		ArrayList<Contract> contractData = eds.createContractData(numberData);
		ArrayList<Counterparty> counterPartyData = eds.createCounterPartyData(contractData);
		
		try {
			
			String folderName = Utils.generateFolderwithName();
			readwrite.generateContractfile(contractData,folderName);
			readwrite.generateCounterpartyfile(counterPartyData,folderName);
			Utils.compressFolder(folderName);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//ArrayList<Counterparty> counterPartyData = eds.createCounterPartyData(contractData);
		
		
	}
	
	
	



}
