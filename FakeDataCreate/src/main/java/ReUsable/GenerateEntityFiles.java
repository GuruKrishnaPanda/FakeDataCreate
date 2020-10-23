package ReUsable;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

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
	
	public void generateContractfile(ArrayList<Contract> contractData,String folderName) throws IOException {
			
			 String fileName = Constants.NewfileLocation+"\\"+folderName+"\\"+folderName+"-"+Constants.contract+Constants.fileType;	 
			 rw.writeCotractData(contractData,fileName);	
	}


	public void generateCounterpartyfile(ArrayList<Counterparty> contractData,String folderName) throws IOException {
		
			 
			 String fileName = Constants.NewfileLocation+"\\"+folderName+"\\"+folderName+"-"+Constants.counterParty+Constants.fileType;	 
			 rw.writeCounterPartyData(contractData,fileName);	

	}
	public void generateCounterpartyRatingfile(ArrayList<counterpartyRating> contractData,String folderName) throws IOException {
		
		  String fileName = Constants.NewfileLocation+"\\"+folderName+"\\"+folderName+"-"+Constants.counterpartyRating+Constants.fileType;	 
		 rw.writecounterpartyRatingData(contractData, fileName);

	}
	public void generateCounterpartyRiskfile(ArrayList<counterpartyRisk> contractData, String folderName) throws IOException {
		
		 String fileName = Constants.NewfileLocation+"\\"+folderName+"\\"+folderName+"-"+Constants.counterpartyRisk+Constants.fileType;	 
		 rw.writecounterpartyRiskData(contractData, fileName);
			

	}
	
		

	
	public void generateProtectionfile(ArrayList<Protection> contractData, String folderName) throws IOException {
		
		 String fileName = Constants.NewfileLocation+"\\"+folderName+"\\"+folderName+"-"+Constants.protection+Constants.fileType;	 
		 rw.writeProtectionData(contractData, fileName);
			
		

	}
	public void generateProtectionInstrumentfile( ArrayList<protectionInstrument>contractData, String folderName) throws IOException {
		
		 String fileName = Constants.NewfileLocation+"\\"+folderName+"\\"+folderName+"-"+Constants.protectionInstrument+Constants.fileType;	 
		 rw.writeProtectionInstrumentData(contractData, fileName);
		

	}
	public void generateRelatedPartyfile(ArrayList<relatedParty> contractData, String folderName) throws IOException {


		 String fileName = Constants.NewfileLocation+"\\"+folderName+"\\"+folderName+"-"+Constants.relatedParty+Constants.fileType;	 
		 rw.writeRelatedPartyData(contractData, fileName);

	}
	public void generateInstrumentfile(ArrayList<Instrument> contractData, String folderName) throws IOException {
		String fileName = Constants.NewfileLocation+"\\"+folderName+"\\"+folderName+"-"+Constants.instrument+Constants.fileType;	 
		 rw.writeInstrumentData(contractData,fileName);
}
	
}