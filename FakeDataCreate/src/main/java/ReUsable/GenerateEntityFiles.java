package ReUsable;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;

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
	
	 ReadWrite rw;

	
	public GenerateEntityFiles(Hashtable<String, String> data) {
		rw =  new ReadWrite(data);
	}


	public void generateContractfile(ArrayList<Contract> contractData,String folderName,String fileName) throws IOException {
			
			 String fileLocation = Constants.NewfileLocation+"\\"+folderName+"\\"+fileName+"-"+Constants.contract+Constants.fileType;	 
			 rw.writeCotractData(contractData,fileLocation);	
			
	}


	public void generateCounterpartyfile(ArrayList<Counterparty> counterpartyData,String folderName, String fileName) throws IOException {
		
			 
			 String fileLocation = Constants.NewfileLocation+"\\"+folderName+"\\"+fileName+"-"+Constants.counterParty+Constants.fileType;	 
			 rw.writeCounterPartyData(counterpartyData,fileLocation);
			

	}
	public void generateCounterpartyRatingfile(ArrayList<counterpartyRating>counterpartyRatingData,String folderName,String fileName) throws IOException {
		
		  String fileLocation = Constants.NewfileLocation+"\\"+folderName+"\\"+fileName+"-"+Constants.counterpartyRating+Constants.fileType;	 
		 rw.writecounterpartyRatingData(counterpartyRatingData, fileLocation);

	}
	public void generateCounterpartyRiskfile(ArrayList<counterpartyRisk> counterpartyRiskData, String folderName,String fileName) throws IOException {
		
		 String fileLocation = Constants.NewfileLocation+"\\"+folderName+"\\"+fileName+"-"+Constants.counterpartyRisk+Constants.fileType;	 
		 rw.writecounterpartyRiskData(counterpartyRiskData, fileLocation);

			

	}
	
	public void generateProtectionfile(ArrayList<Protection> ProtectionData, String folderName,String fileName) throws IOException {
		
		 String fileLocation = Constants.NewfileLocation+"\\"+folderName+"\\"+fileName+"-"+Constants.protection+Constants.fileType;	 
		 rw.writeProtectionData(ProtectionData, fileLocation);

			
		

	}
	public void generateProtectionInstrumentfile( ArrayList<protectionInstrument>protectionInstrumentData, String folderName,String fileName) throws IOException {
		
		 String fileLocation = Constants.NewfileLocation+"\\"+folderName+"\\"+fileName+"-"+Constants.protectionInstrument+Constants.fileType;	 
		 rw.writeProtectionInstrumentData(protectionInstrumentData, fileLocation);

		

	}
	public void generateRelatedPartyfile(ArrayList<relatedParty> relatedPartyData, String folderName,String fileName) throws IOException {


		 String fileLocation = Constants.NewfileLocation+"\\"+folderName+"\\"+fileName+"-"+Constants.relatedParty+Constants.fileType;	 
		 rw.writeRelatedPartyData(relatedPartyData, fileLocation);
	

	}
	public void generateInstrumentfile(ArrayList<Instrument> InstrumentData, String folderName,String fileName) throws IOException {
		String fileLocation = Constants.NewfileLocation+"\\"+folderName+"\\"+fileName+"-"+Constants.instrument+Constants.fileType;	 
		 rw.writeInstrumentData(InstrumentData,fileLocation);
	
}

	public void generateControlfile(HashMap<String, Integer> cf , String folderName,String fileName) {
		String fileLocation = Constants.NewfileLocation+"\\"+folderName+"\\"+fileName+"-"+Constants.controlFile+Constants.fileType;	
	
		rw.writeControlFileData(cf,fileLocation);	
	
	}

	public void generateAllfile(ArrayList<Contract> contractData,ArrayList<Counterparty> counterpartyData,ArrayList<counterpartyRating> counterpartyRatingData,ArrayList<protectionInstrument>protectionInstrumentData,ArrayList<Protection> ProtectionData,ArrayList<counterpartyRisk> counterpartyRiskData,ArrayList<relatedParty>relatedPartyData,ArrayList<Instrument> InstrumentData,String folderName,String fileName) throws IOException {
		String fileLocation = Constants.NewfileLocation+"\\"+folderName+"\\"+fileName+"-"+Constants.allFile+Constants.fileType;	 
		 rw.writeAllData(contractData,counterpartyData,counterpartyRatingData,counterpartyRiskData, ProtectionData,protectionInstrumentData,relatedPartyData,InstrumentData,fileLocation);
	
}


	
}