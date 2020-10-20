package ReUsable;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import Utilities.Constants;
import pojoClases.Contract;
import pojoClases.Counterparty;
import pojoClases.protectionInstrument;
import pojoClases.relatedParty;

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
	public void generateProtectionInstrumentfile( ArrayList<protectionInstrument>contractData, String folderName) throws IOException {
		
		 String fileName = Constants.NewfileLocation+"\\"+folderName+"\\"+folderName+"-"+Constants.protectionInstrument+Constants.fileType;	 
		 rw.writeProtectionInstrumentData(contractData, fileName);
		

	}
	public void generateRelatedPartyfile(ArrayList<relatedParty> contractData, String folderName) throws IOException {


		 String fileName = Constants.NewfileLocation+"\\"+folderName+"\\"+folderName+"-"+Constants.relatedParty+Constants.fileType;	 
		 rw.writeRelatedPartyData(contractData, fileName);

	}
}
