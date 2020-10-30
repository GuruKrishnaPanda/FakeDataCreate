package ReUsable;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.Collections;

import Utilities.Constants;
import pojoClases.Contract;
import pojoClases.Counterparty;
import pojoClases.Instrument;
import pojoClases.Protection;
import pojoClases.counterpartyRating;
import pojoClases.counterpartyRisk;

import pojoClases.protectionInstrument;
import pojoClases.relatedParty;

public class GenerateEntityFiles {
	
	File file;
	
	 ReadWrite rw=  new ReadWrite();
	
	public void generateContractfile(ArrayList<Contract> contractData,String folderName,String fileName) throws IOException {
			
			 String fileLocation = Constants.NewfileLocation+"\\"+folderName+"\\"+fileName+"-"+Constants.contract+Constants.fileType;	 
			 rw.writeCotractData(contractData,fileName);	
	}


	public void generateCounterpartyfile(ArrayList<Counterparty> counterPartyData,String folderName, String fileName) throws IOException {
		
			 
			 String fileLocation = Constants.NewfileLocation+"\\"+folderName+"\\"+fileName+"-"+Constants.counterParty+Constants.fileType;	 
			 rw.writeCounterPartyData(counterPartyData,fileLocation);	

	}
	public void generateCounterpartyRatingfile(ArrayList<counterpartyRating> contractData,String folderName,String fileName) throws IOException {
		
		  String fileLocation = Constants.NewfileLocation+"\\"+folderName+"\\"+fileName+"-"+Constants.counterpartyRating+Constants.fileType;	 
		 rw.writecounterpartyRatingData(contractData, fileLocation);

	}
	public void generateCounterpartyRiskfile(ArrayList<counterpartyRisk> contractData, String folderName,String fileName) throws IOException {
		
		 String fileLocation = Constants.NewfileLocation+"\\"+folderName+"\\"+fileName+"-"+Constants.counterpartyRisk+Constants.fileType;	 
		 rw.writecounterpartyRiskData(contractData, fileLocation);
			

	}
	
	public void generateProtectionfile(ArrayList<Protection> contractData, String folderName,String fileName) throws IOException {
		
		 String fileLocation = Constants.NewfileLocation+"\\"+folderName+"\\"+fileName+"-"+Constants.protection+Constants.fileType;	 
		 rw.writeProtectionData(contractData, fileLocation);
			
		

	}
	public void generateProtectionInstrumentfile( ArrayList<protectionInstrument>contractData, String folderName,String fileName) throws IOException {
		
		 String fileLocation = Constants.NewfileLocation+"\\"+folderName+"\\"+fileName+"-"+Constants.protectionInstrument+Constants.fileType;	 
		 rw.writeProtectionInstrumentData(contractData, fileLocation);
		

	}
	public void generateRelatedPartyfile(ArrayList<relatedParty> contractData, String folderName,String fileName) throws IOException {


		 String fileLocation = Constants.NewfileLocation+"\\"+folderName+"\\"+fileName+"-"+Constants.relatedParty+Constants.fileType;	 
		 rw.writeRelatedPartyData(contractData, fileLocation);

	}
	public void generateInstrumentfile(ArrayList<Instrument> contractData, String folderName,String fileName) throws IOException {
		String fileLocation = Constants.NewfileLocation+"\\"+folderName+"\\"+fileName+"-"+Constants.instrument+Constants.fileType;	 
		 rw.writeInstrumentData(contractData,fileLocation);
}


	public void generateControlfile(String string, String folderName,String fileName) {
		
		
	}
	
}