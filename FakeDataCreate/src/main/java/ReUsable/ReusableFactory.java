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
			readwrite.generateContractfile(contractData,"contract");
			readwrite.generateCounterpartyfile(counterPartyData,"CountrerParty");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//ArrayList<Counterparty> counterPartyData = eds.createCounterPartyData(contractData);
		
		
	}
	
	
	



}
