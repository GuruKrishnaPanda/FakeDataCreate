package ReUsable;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import Utilities.Constants;
import pojoClases.Contract;
import pojoClases.Counterparty;

public class GenerateEntityFiles {
	
	File file;
	 ReadWrite rw=  new ReadWrite();
	 
	 
	public void generateContractfile(ArrayList<Contract> contractData,String folderName) throws IOException {
			
			 String fileName = Constants.NewfileLocation+"\\"+folderName+"\\"+folderName+"-"+Constants.contract+Constants.fileType;	 
			 rw.writeCotractData(contractData,fileName);	
	}


	public void generateCounterpartyfile(ArrayList<Counterparty> contractData,String folderName) throws IOException {
		
			 
			 String fileName = Constants.NewfileLocation+"\\"+folderName+"\\"+folderName+"-"+Constants.counterParty+Constants.fileType;	 
			 rw.writeCounterPartyData(contractData,fileName);	

	}
	public void generateCounterpartyRatingfile(ArrayList<Contract> contractData,String folderName) throws IOException {
		
		  String fileName = Constants.NewfileLocation+"\\"+folderName+"\\"+folderName+"-"+Constants.counterParty+Constants.fileType;	 
		 

	}
	public void generateCounterpartyRiskfile(ArrayList<Contract> contractData, String fileFor) throws IOException {
		
			

	}
	public void generateInstrumentfile(ArrayList<Contract> contractData, String fileFor) throws IOException {
		
			
		

	}
	public void generateProtectionfile(ArrayList<Contract> contractData, String fileFor) throws IOException {
		
			
		

	}
	public void generateProtectionInstrumentfile(ArrayList<Contract> contractData, String fileFor) throws IOException {
		
			
		

	}
	public void generateRelatedPartyfile(ArrayList<Contract> contractData, String fileFor) throws IOException {



	}
}
