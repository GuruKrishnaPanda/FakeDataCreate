	package ReUsable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

import com.github.javafaker.Faker;

import Utilities.DataUtil;
import Utilities.DuplicateDataCheck;
import Utilities.GenericXLSXReader;
import Utilities.Utils;
import pojoClases.Contract;
import pojoClases.Counterparty;
import pojoClases.Instrument;
import pojoClases.counterpartyRating;
import pojoClases.protectionInstrument;
import pojoClases.relatedParty;
import pojoClases.Protection;
import pojoClases.counterpartyRisk;

/**
 * @author GuruKrishna,Swapnil,Sushree,Subhashree,Kalpana
 *
 */
public class settingEntityDataSet {
	datacreation create ;
	GenericXLSXReader xls = new GenericXLSXReader(System.getProperty("user.dir")+"\\resources\\Configuration.xlsx");
	Hashtable<String, String> configurationData = DataUtil.getData("Configuration", xls);
	Hashtable<String, String> bankingInfo = DataUtil.getData("BankMapping", xls);
	//ArrayList<Hashtable<String, String>> masterData = DataUtil.getMasterdata();
	Hashtable<String, String> fieldValues;
	Faker faker = new Faker();
	Utils ut = new Utils();
	DuplicateDataCheck duplicatecheck = new DuplicateDataCheck();
	
	String bankSymbol = bankingInfo.get(configurationData.get("Bank_Type"));

	

 public ArrayList<Contract> createContractData(ArrayList<Counterparty> counterpartyData) 
			  {	
				 ReadWrite rw =  new ReadWrite();
				
					ArrayList<Contract> con =  new ArrayList<>();
					ArrayList<String> conid =  new ArrayList<>();
					ArrayList<String> instrumentid =  new ArrayList<>();
					//create = new datacreation();
					
					String counterPartyId ;
					create = null;
					Contract c;
					ArrayList<Integer> allIndexes = null;
					int count = 0;
					if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory")||configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional"))
					{
						
						if(configurationData.get("MultipleDataGenerationForContract").equalsIgnoreCase("Yes")) {
						fieldValues = DataUtil.getFieldValue("MasterData", xls);
						 for(Counterparty counterparty: counterpartyData) {
						 		create = new datacreation();
						 	    c  =  new Contract();
						 	   counterPartyId = create.createCouterpartyIdentifier(bankSymbol);
						 		count++;		
							 
							if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory"))
							{
								allIndexes =rw.uniqunumber(configurationData.get("TotalNo_counterpartyId_repeated_incontractFile") ,configurationData.get("NoOfData"));
								if(allIndexes.contains(count)) {
									
									int z = ut.completeinteger(configurationData.get("No_individual_counterpartyId_repeated_incontractFile"));
									int m =  faker.number().numberBetween(1,z );
									for(int k = 1;k<=m;k++) {
										c  =  new Contract();
								if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Mandatory")) {
									c.setReportingEntityId(counterparty.getReportingEntityId());	
						    	}else
						    		c.setReportingEntityId("");
						    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Mandatory")) {
						    		c.setCounterypartyId(counterPartyId);
						    	}else
						    		c.setCounterypartyId("");
						    	if(fieldValues.get("ContractId").equalsIgnoreCase("Mandatory")) {
						    		c.setContractId(create.createContractIdentifier());
						    	}else
						    		c.setContractId("");
						    	if(fieldValues.get("InstrumentId").equalsIgnoreCase("Mandatory")) {
						    		
						    		c.setInstrumentId(create.createInstrumentId());
						    	}else
						    		c.setInstrumentId("");
						    	con.add(c);
						    	
							}}
								else {
									c  =  new Contract();
									if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Mandatory")) {
										c.setReportingEntityId(counterparty.getReportingEntityId());	
							    	}else
							    		c.setReportingEntityId("");
							    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Mandatory")) {
							    		c.setCounterypartyId(counterPartyId);
							    	}else
							    		c.setCounterypartyId("");
							    	if(fieldValues.get("ContractId").equalsIgnoreCase("Mandatory")) {
							    		c.setContractId(create.createContractIdentifier());
							    	}else
							    		c.setContractId("");
							    	if(fieldValues.get("InstrumentId").equalsIgnoreCase("Mandatory")) {
							    		c.setInstrumentId(create.createInstrumentId());
							    	}else
							    		c.setInstrumentId("");
									
									con.add(c);
								}}
									
									
							 if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional")) {
								 allIndexes =rw.uniqunumber(configurationData.get("TotalNo_counterpartyId_repeated_incontractFile") ,configurationData.get("NoOfData"));
								 if(allIndexes.contains(count)) {
										
										int z = ut.completeinteger(configurationData.get("No_individual_counterpartyId_repeated_incontractFile"));
										int m =  faker.number().numberBetween(1,z );
										for(int k = 1;k<=m;k++) {
											c  =  new Contract();
								 
									if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Optional")) {
										c.setReportingEntityId(counterparty.getReportingEntityId());	
							    	}else
							    		c.setReportingEntityId("");
							    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Optional")) {
							    		c.setCounterypartyId(counterPartyId);
							    	}else
							    		c.setCounterypartyId("");
							    	if(fieldValues.get("ContractId").equalsIgnoreCase("Optional")) {
							    		c.setContractId(create.createContractIdentifier());
							    	}else
							    		c.setContractId("");
							    	if(fieldValues.get("InstrumentId").equalsIgnoreCase("Optional")) {
							    		c.setInstrumentId(create.createInstrumentId());
							    	}else
							    		c.setInstrumentId("");
							 
						con.add(c);
						}}
								 else {
										c  =  new Contract();
										if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Optional")) {
											c.setReportingEntityId(counterparty.getReportingEntityId());	
								    	}else
								    		c.setReportingEntityId("");
								    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Optional")) {
								    		c.setCounterypartyId(counterPartyId);
								    	}else
								    		c.setCounterypartyId("");
								    	if(fieldValues.get("ContractId").equalsIgnoreCase("Optional")) {
								    		c.setContractId(create.createContractIdentifier());
								    	}else
								    		c.setContractId("");
								    	if(fieldValues.get("InstrumentId").equalsIgnoreCase("Optional")) {
								    		c.setInstrumentId(create.createInstrumentId());
								    	}else
								    		c.setInstrumentId("");
								    	con.add(c);}}
						
						
						}}
						else {
							for(Counterparty counterparty: counterpartyData) {
									
									
								create = new datacreation();
								 c  =  new Contract();
								 if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory"))
									{
										if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Mandatory")) {
											c.setReportingEntityId(counterparty.getReportingEntityId());	
								    	}else
								    		c.setReportingEntityId("");
								    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Mandatory")) {
								    		c.setCounterypartyId(create.createCouterpartyIdentifier(bankSymbol));
								    	}else
								    		c.setCounterypartyId("");
								    	if(fieldValues.get("ContractId").equalsIgnoreCase("Mandatory")) {
								    		c.setContractId(create.createContractIdentifier());
								    	}else
								    		c.setContractId("");
								    	if(fieldValues.get("InstrumentId").equalsIgnoreCase("Mandatory")) {
								    		c.setInstrumentId(create.createInstrumentId());
								    	}else
								    		c.setInstrumentId("");
								    	
									}
									 if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional")) {
											if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Optional")) {
												c.setReportingEntityId(counterparty.getReportingEntityId());	
									    	}else
									    		c.setReportingEntityId("");
									    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Optional")) {
									    		c.setCounterypartyId(create.createCouterpartyIdentifier(bankSymbol));
									    	}else
									    		c.setCounterypartyId("");
									    	if(fieldValues.get("ContractId").equalsIgnoreCase("Optional")) {
									    		c.setContractId(create.createContractIdentifier());
									    	}else
									    		c.setContractId("");
									    	if(fieldValues.get("InstrumentId").equalsIgnoreCase("Optional")) {
									    		c.setInstrumentId(create.createInstrumentId());
									    	}else
									    		c.setInstrumentId("");
									 }
								con.add(c);
								
								}} }

			else if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Both")) {
				 if(configurationData.get("MultipleDataGenerationForContract").equalsIgnoreCase("Yes")) {
							 
					 allIndexes =rw.uniqunumber(configurationData.get("TotalNo_counterpartyId_repeated_incontractFile") ,configurationData.get("NoOfData")); 
					 for(Counterparty counterparty: counterpartyData) {
								 count++;
								 create = new datacreation();
								  c  =  new Contract();
								 counterPartyId = counterparty.getCounterypartyId();
								if(allIndexes.contains(count)) {
									
									int z = ut.completeinteger(configurationData.get("No_individual_counterpartyId_repeated_incontractFile"));
									//using faker create randomenumber from 1to z
									int m =  faker.number().numberBetween(1,z );
									for(int k = 1;k<=m;k++) {
										c  =  new Contract();
										c.setReportingEntityId(counterparty.getReportingEntityId());
										//c.setContractId(create.createContractIdentifier());
										 String contract = duplicatecheck.createUniqueContractNew(conid,create);
								    		c.setContractId(contract);
								    		conid.add(contract);
										//c.setInstrumentId(create.createInstrumentId());
										String instrument = duplicatecheck.createUniqueInstrumentNew(instrumentid,create);
							    		c.setInstrumentId(instrument);
							    		instrumentid.add(instrument);
										
										c.setCounterypartyId(counterPartyId);
									 con.add(c);
										
									}  
									
								}else {
									c  =  new Contract();
									c.setReportingEntityId(counterparty.getReportingEntityId());	
									//c.setContractId(create.createContractIdentifier());
									 String contract = duplicatecheck.createUniqueContractNew(conid,create);
							    		c.setContractId(contract);
							    		conid.add(contract);
									//c.setInstrumentId(create.createInstrumentId());
									String instrument = duplicatecheck.createUniqueInstrumentNew(instrumentid,create);
						    		c.setInstrumentId(instrument);
						    		instrumentid.add(instrument);
									c.setCounterypartyId(counterPartyId);
									con.add(c);
								}
						 }
						 }else {
							 for(Counterparty counterparty: counterpartyData) {
									
									
								create = new datacreation();
								 c  =  new Contract();
								c.setReportingEntityId(counterparty.getReportingEntityId());
								//c.setContractId(create.createContractIdentifier());
								String contract = duplicatecheck.createUniqueContractNew(conid,create);
					    		c.setContractId(contract);
					    		conid.add(contract);
								//c.setInstrumentId(create.createInstrumentId());
								String instrument = duplicatecheck.createUniqueInstrumentNew(instrumentid,create);
					    		c.setInstrumentId(instrument);
					    		instrumentid.add(instrument);
								c.setCounterypartyId(create.createCouterpartyIdentifier(bankSymbol));
								
								con.add(c);
								c=null;
								create=null;
							 }}
						  
						}
					return con;
						 }
public ArrayList<Counterparty> createCounterPartyData(int numberData) {
	create = new datacreation();
	create = null;
	
	ArrayList<Counterparty> con =  new ArrayList<>(); 
	ArrayList<String> pan =  new ArrayList<>();
	ArrayList<String> Adhar =  new ArrayList<>();
	ArrayList<String> cpid =  new ArrayList<>();
	if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory")||configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional"))
	{
		
		fieldValues = DataUtil.getFieldValue("MasterData", xls);
		create = new datacreation();
		String ReportingEntityId  ;
		ReportingEntityId = create.createReportingEntityId(bankSymbol);
		for (int i=0; i<numberData; i++) {
		 	create = new datacreation();
		 	Counterparty cp  =  new Counterparty();
		    if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory")) {
		    	if(fieldValues.get("pan").equalsIgnoreCase("Mandatory")) {
		    		String PanNo = duplicatecheck.createUniquePanNew(pan,create);
		    		cp.setPan(PanNo);
		    		pan.add(PanNo);
		    	}else
		    		cp.setPan("");
		    	if(fieldValues.get("cin").equalsIgnoreCase("Mandatory")) {
		    		cp.setCin(create.companyIdentificationNumber());
		    	}else
		    		cp.setCin("");
		    	if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Mandatory")) {
		    		cp.setReportingEntityId(ReportingEntityId);
		    	}else
		    		cp.setReportingEntityId("");
		    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Mandatory")) {
		    		/*String CounterpartyId = duplicatecheck.createUniquecpid(cpid,create);
		    		cp.setCounterypartyId(CounterpartyId);
		    		cpid.add(CounterpartyId);*/
		    		cp.setCounterypartyId(create.createCouterpartyIdentifier(bankSymbol+"C"));
		    	}else
		    		cp.setCounterypartyId("");
		    	
		    	if(fieldValues.get("Name").equalsIgnoreCase("Mandatory")) {
		    		cp.setName(create.createName());
		    	}else
		    		cp.setName("");
		    	if(fieldValues.get("dateOfBirth/Incoporation").equalsIgnoreCase("Mandatory")) {
		    		   cp.setDate(create.date());
		    	}else
		    		cp.setDate("");
		    	
		    	if(fieldValues.get("caste").equalsIgnoreCase("Mandatory")) {
		    	 	cp.setCasteGen(create.createCaste());  
		    	}else
		    		cp.setCasteGen("");
		    	if(fieldValues.get("community").equalsIgnoreCase("Mandatory")) {
		    		 cp.setCommGen(create.createCommunity());
		    	}else
		    		cp.setCommGen("");
		    	if(fieldValues.get("din").equalsIgnoreCase("Mandatory")) {
		    		cp.setDin(create.createDIN());
		    	}else
		    		cp.setDin("");
		    	if(fieldValues.get("lei").equalsIgnoreCase("Mandatory")) {
		    	 	cp.setLei(create.legalEntityIdentifier());
		    	}else
		    		cp.setLei("");
		    	if(fieldValues.get("tan").equalsIgnoreCase("Mandatory")) {
		    		cp.setTan(create.taxCollectionAccountNumber());
		    	}else
		    		cp.setTan("");
		    	if(fieldValues.get("gstin").equalsIgnoreCase("Mandatory")) {
		    		cp.setGstin(create.createGstin());
		    	}else
		    		cp.setGstin("");
		    	
		    	if(fieldValues.get("udyogAadhaar").equalsIgnoreCase("Mandatory")) {
		    		cp.setUdyogAadhaar(create.udyogAdharNumber());
		    	}else
		    		cp.setUdyogAadhaar("");
		    	if(fieldValues.get("typeOfOrganisation").equalsIgnoreCase("Mandatory")) {
		    		cp.setTypeOrg(create.typeOfOrganisation());
		    	}else
		    		cp.setTypeOrg("");
		    	if(fieldValues.get("borrowerCategory").equalsIgnoreCase("Mandatory")) {
		    		cp.setBurrrower(create.createBurrower());
		    	}else
		    		cp.setBurrrower("");
		    	if(fieldValues.get("nicCode").equalsIgnoreCase("Mandatory")) {
		    		cp.setNicCode(create.nicCode());
		    	}else
		    		cp.setNicCode("");
		    	
		    	if(fieldValues.get("occupationCode").equalsIgnoreCase("Mandatory")) {
		    		cp.setOccupationCode(create.occupationalCode());
		    	}else
		    		cp.setOccupationCode("");
		    	if(fieldValues.get("addressLine1").equalsIgnoreCase("Mandatory")) {
		    	 	cp.setAddressLine1(create.addressLine1());
		    	}else
		    		cp.setAddressLine1("");
		    	if(fieldValues.get("pinCode").equalsIgnoreCase("Mandatory")) {
		    		cp.setPinCode(create.pinCode());
		    	}else
		    		cp.setPinCode("");
		    	
		    	if(fieldValues.get("stateCode").equalsIgnoreCase("Mandatory")) {
		    		cp.setStateCode(create.stateCode());
		    	}else
		    		cp.setStateCode("");
		    	if(fieldValues.get("districtCode").equalsIgnoreCase("Mandatory")) {
		    		 cp.setDistrictCode(create.districtCode());
		    	}else
		    		cp.setDistrictCode("");
		       	if(fieldValues.get("countryCode").equalsIgnoreCase("Mandatory")) {
		       	   cp.setCountryCode(create.countryCode());
		    	}else
		    		cp.setCountryCode("");
		    	
		    	if(fieldValues.get("telephoneNumber").equalsIgnoreCase("Mandatory")) {
		    		 cp.setTelePhoneNumber(create.mobileNumber());
			    	}else
			    		cp.setTelePhoneNumber("");
		    	if(fieldValues.get("mobileNumber").equalsIgnoreCase("Mandatory")) {
		    		   cp.setMobNo(create.landmobileNumber());
			    	}else
			    		cp.setMobNo("");
		    	if(fieldValues.get("emailAddress").equalsIgnoreCase("Mandatory")) {
		    		  cp.setEmailAddress(create.emailAddress());
			    	}else
			    		cp.setEmailAddress("");
		    }
		    if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional")) {
		    	if(fieldValues.get("pan").equalsIgnoreCase("Optional")) {
		    		cp.setPan(create.pangenerate2());
		    	}else
		    		cp.setPan("");
		    	if(fieldValues.get("cin").equalsIgnoreCase("Optional")) {
		    		cp.setCin(create.companyIdentificationNumber());
		    	}else
		    		cp.setCin("");
		    	if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Optional")) {
		    		cp.setReportingEntityId(ReportingEntityId);
		    	}else
		    		cp.setReportingEntityId("");
		    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Optional")) {
		    		cp.setCounterypartyId(create.createCouterpartyIdentifier(bankSymbol+"C"));
		    	}else
		    		cp.setCounterypartyId("");
		    	if(fieldValues.get("Name").equalsIgnoreCase("Optional")) {
		    		cp.setName(create.createName());
		    	}else
		    		cp.setName("");
		    	if(fieldValues.get("dateOfBirth/Incoporation").equalsIgnoreCase("Optional")) {
		    		   cp.setDate(create.date());
		    	}else
		    		cp.setDate("");
		       	if(fieldValues.get("caste").equalsIgnoreCase("Optional")) {
		    	 	cp.setCasteGen(create.createCaste());  
		    	}else
		    		cp.setCasteGen("");
		       	if(fieldValues.get("community").equalsIgnoreCase("Optional")) {
		    		 cp.setCommGen(create.createCommunity());
		    	}else
		    		cp.setCommGen("");
		       	if(fieldValues.get("din").equalsIgnoreCase("Optional")) {
		    		cp.setDin(create.createDIN());
		    	}else
		    		cp.setDin("");
		       	if(fieldValues.get("lei").equalsIgnoreCase("Optional")) {
		    	 	cp.setLei(create.legalEntityIdentifier());
		    	}else
		    		cp.setLei("");
		    	if(fieldValues.get("tan").equalsIgnoreCase("Optional")) {
		    		cp.setTan(create.taxCollectionAccountNumber());
		    	}else
		    		cp.setTan("");
		    	if(fieldValues.get("gstin").equalsIgnoreCase("Optional")) {
		    		cp.setGstin(create.createGstin());
		    	}else
		    		cp.setGstin("");
		      	if(fieldValues.get("udyogAadhaar").equalsIgnoreCase("Optional")) {
		    		cp.setUdyogAadhaar(create.udyogAdharNumber());
		    	}else
		    		cp.setUdyogAadhaar("");
		      	if(fieldValues.get("typeOfOrganisation").equalsIgnoreCase("Optional")) {
		    		cp.setTypeOrg(create.typeOfOrganisation());
		    	}else
		    		cp.setTypeOrg("");
		    	
		    	if(fieldValues.get("borrowerCategory").equalsIgnoreCase("Optional")) {
		    		cp.setBurrrower(create.createBurrower());
		    	}else
		    		cp.setBurrrower("");
		    	if(fieldValues.get("nicCode").equalsIgnoreCase("Optional")) {
		    		cp.setNicCode(create.nicCode());
		    	}else
		    		cp.setNicCode("");
		     	if(fieldValues.get("occupationCode").equalsIgnoreCase("Optional")) {
		    		cp.setOccupationCode(create.occupationalCode());
		    	}else
		    		cp.setOccupationCode("");
		    	if(fieldValues.get("addressLine1").equalsIgnoreCase("Optional")) {
		    	 	cp.setAddressLine1(create.addressLine1());
		    	}else
		    		cp.setAddressLine1("");
		    	if(fieldValues.get("pinCode").equalsIgnoreCase("Optional")) {
		    		cp.setPinCode(create.pinCode());
		    	}else
		    		cp.setPinCode("");
		    	if(fieldValues.get("stateCode").equalsIgnoreCase("Optional")) {
		    		cp.setStateCode(create.stateCode());
		    	}else
		    		cp.setStateCode("");
		    	if(fieldValues.get("districtCode").equalsIgnoreCase("Optional")) {
		    		 cp.setDistrictCode(create.districtCode());
		    	}else
		    		cp.setDistrictCode("");
		       	if(fieldValues.get("countryCode").equalsIgnoreCase("Optional")) {
			       	   cp.setCountryCode(create.countryCode());
			    	}else
			    		cp.setCountryCode("");
		    	if(fieldValues.get("telephoneNumber").equalsIgnoreCase("Optional")) {
		    		 cp.setTelePhoneNumber(create.mobileNumber());
			    	}else
			    		cp.setTelePhoneNumber("");
		    	if(fieldValues.get("mobileNumber").equalsIgnoreCase("Optional")) {
		    		   cp.setMobNo(create.landmobileNumber());
			    	}else
			    		cp.setMobNo("");
		    	if(fieldValues.get("emailAddress").equalsIgnoreCase("Optional")) {
		    		  cp.setEmailAddress(create.emailAddress());
			    	}else
			    		cp.setEmailAddress("");	
		    }
		    con.add(cp);   
		   
		}	
	}else if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Both")) {
		
		/*HashSet<String> uniquecp = new HashSet<String>();
		String id = null;
		for (int i=0; i<numberData; i++) {
		    //id = (contract.getReportingEntityId());
			uniquecp.add(contract.getCounterypartyId());}
			for(String u:uniquecp) {*/
		create = new datacreation();
		
		String ReportingEntityId  ;
			ReportingEntityId = create.createReportingEntityId(bankSymbol);
		for (int i=0; i<numberData; i++) {
			create = new datacreation();
		 	Counterparty cp  =  new Counterparty();
				cp.setReportingEntityId(ReportingEntityId);
			 	//cp.setCounterypartyId(create.createCouterpartyIdentifier(bankSymbol+"C"));
				String counterid = duplicatecheck.createUniquecpid(cpid, create);
		    	cp.setCounterypartyId(counterid);
		    	cpid.add(counterid);
			 	cp.setName(create.createName());
			    cp.setDate(create.date());
			 	cp.setCasteGen(create.createCaste());
			    cp.setCommGen(create.createCommunity());
			    //cp.setPan(create.pangenerate2());
			    String PanNo = duplicatecheck.createUniquePanNew(pan,create);
	    		cp.setPan(PanNo);
	    		pan.add(PanNo);
			 	//cp.setAdharNo(create.adharValidate());
			 	String adharNo = duplicatecheck.createUniqueAdharNew(Adhar,create);
	    		cp.setAdharNo(adharNo);
	    		Adhar.add(adharNo);
			 	cp.setDin(create.createDIN());
			 	cp.setCin(create.companyIdentificationNumber());
			 	cp.setLei(create.legalEntityIdentifier());
				cp.setTan(create.taxCollectionAccountNumber());
				cp.setGstin(create.createGstin());
				cp.setUdyogAadhaar(create.udyogAdharNumber());
				cp.setTypeOrg(create.typeOfOrganisation());
				cp.setBurrrower(create.createBurrower());
			 	cp.setNicCode(create.nicCode());
			 	cp.setOccupationCode(create.occupationalCode());
			 	cp.setAddressLine1(create.addressLine1());
			 	cp.setAddressLine2(create.addressLine2());
			 	cp.setAddressLine3(create.addressLine3());
			 	cp.setPinCode(create.pinCode());
			    cp.setStateCode(create.stateCode());
			    cp.setDistrictCode(create.districtCode());
			    cp.setCountryCode(create.countryCode());
			    cp.setTelePhoneNumber(create.mobileNumber());
			    cp.setMobNo(create.landmobileNumber());
			    cp.setEmailAddress(create.emailAddress());			
		    
		    con.add(cp);
		    
		    
		}}
	return con;
	}
		//Collections.shuffle(con);
		


public ArrayList<protectionInstrument> createProtectionInstrumentData(ArrayList<Instrument> InstrumentData)
{   String reportingEntityid = null;
	ArrayList<protectionInstrument> con =  new ArrayList<>();
	ArrayList<String> protectionid =  new ArrayList<>();
	protectionInstrument pi = null ;
	ReadWrite rw =  new ReadWrite();
	ArrayList<Integer> allIndexes = null;
	if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory")||configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional"))
	{
		fieldValues = DataUtil.getFieldValue("MasterData", xls);
		for(Instrument instrument: InstrumentData) 
		{
		 	create = new datacreation();
		 	 pi = new protectionInstrument();
		    
		    if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory"))
			{
				if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Mandatory")) {
					  pi.setReportingEntityId(instrument.getReportingEntityId());
		    	}else
		    		 pi.setReportingEntityId("");
		    	if(fieldValues.get("ContractId").equalsIgnoreCase("Mandatory")) {
		    		  pi.setContractId(instrument.getContractId());
		    	}else
		    		  pi.setContractId("");
		    	if(fieldValues.get("InstrumentId").equalsIgnoreCase("Mandatory")) {
		    		 pi.setInstrumentId(instrument.getInstrumentId());
		    	}else
		    		pi.setInstrumentId("");
		      	if(fieldValues.get("Protection Allocated Value").equalsIgnoreCase("Mandatory")) {
		      	  pi.setProtectionAllocatedValue(create.createprotectionAllocatedValue());
		    	}else
		    		 pi.setProtectionAllocatedValue("");
		    	
		      	if(fieldValues.get("protectionId").equalsIgnoreCase("Mandatory")) {
		    	    pi.setProtectionId(create.createProtectionId());
		    	}else
		    		pi.setProtectionId("");
		      	if(fieldValues.get("chargeType").equalsIgnoreCase("Mandatory")) {
		      		 pi.setChargeType(create.createChargeType());
		    	}else
		    		 pi.setChargeType("");	
			}
			 if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional")) {
				 if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Optional")) {
					  pi.setReportingEntityId(instrument.getReportingEntityId());
		    	}else
		    		 pi.setReportingEntityId("");
		    	if(fieldValues.get("ContractId").equalsIgnoreCase("Optional")) {
		    		  pi.setContractId(instrument.getContractId());
		    	}else
		    		  pi.setContractId("");
		    	if(fieldValues.get("InstrumentId").equalsIgnoreCase("Optional")) {
		    		 pi.setInstrumentId(instrument.getInstrumentId());
		    	}else
		    		pi.setInstrumentId("");
		      	if(fieldValues.get("Protection Allocated Value").equalsIgnoreCase("Optional")) {
		      	  pi.setProtectionAllocatedValue(create.createprotectionAllocatedValue());
		    	}else
		    		 pi.setProtectionAllocatedValue("");
		    	
		      	if(fieldValues.get("Protection External Id").equalsIgnoreCase("Optional")) {
		    	    pi.setProtectionId(create.createProtectionId());
		    	}else
		    		pi.setProtectionId("");
		      	if(fieldValues.get("chargeType").equalsIgnoreCase("Optional")) {
		      		 pi.setChargeType(create.createChargeType());
		    	}else
		    		 pi.setChargeType("");
		    	
			 }
			con.add(pi);
			pi = null;
			create=null;	
	  }
}else if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Both")) {
	 int count=0;
	 String instrumentid = null;
	 String contractid = null;
	 

	 if(configurationData.get("MultipleDataGenerationFor_protectioninstrument").equalsIgnoreCase("Yes")) {
		
		
		 for(Instrument instrument: InstrumentData) {
		 instrumentid = instrument.getInstrumentId();
		 reportingEntityid =instrument.getReportingEntityId();
		 contractid =instrument.getContractId();
		
			count++;
			 create = new datacreation();
			 pi = new protectionInstrument();
			 allIndexes =rw.uniqunumber(configurationData.get("TotalNo_contractid,instrumentid_repeated_inprotectioninstrument") ,configurationData.get("NoOfData"));
			if(allIndexes.contains(count)) {
				
				
				int z = ut.completeinteger(configurationData.get("No_individual_contractid,instrumentid_repeated_inprotectioninstrument"));
				//using faker create randomenumber from 1to z
				int m =  faker.number().numberBetween(1,z );
				for(int k = 1;k<=m;k++) {  
					  pi = new protectionInstrument();
 
						    pi.setReportingEntityId(reportingEntityid);
						    pi.setInstrumentId(instrumentid);
						    pi.setContractId(contractid);
						    pi.setProtectionAllocatedValue(create.createprotectionAllocatedValue());
						    //pi.setProtectionId(create.createProtectionId());
						    String protection = duplicatecheck.createUniqueProtectNew(protectionid,create);
						    pi.setProtectionId(protection);
				    		protectionid.add(protection);
						    pi.setChargeType(create.createChargeType());
					con.add(pi);		
					}}
			else 
			{
				 pi = new protectionInstrument();
				pi.setReportingEntityId(reportingEntityid);
			    pi.setInstrumentId(instrumentid);
			    pi.setContractId(contractid);
			    pi.setProtectionAllocatedValue(create.createprotectionAllocatedValue());
			    //pi.setProtectionId(create.createProtectionId());
			    String protection = duplicatecheck.createUniqueProtectNew(protectionid,create);
			    pi.setProtectionId(protection);
	    		protectionid.add(protection);
			    pi.setChargeType(create.createChargeType());
		con.add(pi);
		} 
			
			pi=null;
			create=null;
	 }}	
else {
	for(Instrument instrument: InstrumentData) {
		
		create = new datacreation();
		pi = new protectionInstrument();
	    pi.setReportingEntityId(reportingEntityid);
	    pi.setInstrumentId(instrument.getInstrumentId());
	    pi.setContractId(instrument.getContractId());
	    pi.setProtectionAllocatedValue(create.createprotectionAllocatedValue());
	   // pi.setProtectionId(create.createProtectionId());
	    String protection = duplicatecheck.createUniqueProtectNew(protectionid,create);
	    pi.setProtectionId(protection);
		protectionid.add(protection);
	    pi.setChargeType(create.createChargeType());
		con.add(pi);
		
		pi=null;
		create=null;
	 }}}
	 
	return con;}
	//Collections.shuffle(con);

public ArrayList<relatedParty> createRelatedPartyData(ArrayList<Counterparty> counterpartyData) {
	
	ArrayList<relatedParty> con =  new ArrayList<>();
	ReadWrite rw =  new ReadWrite();
	ArrayList<Integer> allIndexes = null;
	ArrayList<String> Relno =  new ArrayList<>();

	 relatedParty rel ;
	if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory")||configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional"))
	{
		fieldValues = DataUtil.getFieldValue("MasterData", xls);
		 for(Counterparty counterparty: counterpartyData) {
		    create = new datacreation();
		     rel = new relatedParty();
			if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory"))
			{
				if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Mandatory")) {
					  rel.setReportingEntityId(counterparty.getReportingEntityId());
		    	}else
		    		rel.setReportingEntityId("");
		    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Mandatory")) {
		    		rel.setCounterpartyId(counterparty.getCounterypartyId());
		    	}else
		    		rel.setCounterpartyId("");
		    	if(fieldValues.get("relatedCounterpartyID").equalsIgnoreCase("Mandatory")) {
		    		 rel.setRelatedCounterpartyID(create.createRelatedCounterepartyId());
		    	}else
		    		 rel.setRelatedCounterpartyID("");
		    	
			}
			 if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional")) {
				 if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Optional")) {
					  rel.setReportingEntityId(counterparty.getReportingEntityId());
		    	}else
		    		rel.setReportingEntityId("");
		    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Optional")) {
		    		rel.setCounterpartyId(counterparty.getCounterypartyId());
		    	}else
		    		rel.setCounterpartyId("");
		    	if(fieldValues.get("relatedCounterpartyID").equalsIgnoreCase("Optional")) {
		    		 rel.setRelatedCounterpartyID(create.createRelatedCounterepartyId());
		    	}else
		    		 rel.setRelatedCounterpartyID("");
			 }
			 con.add(rel);
			 rel = null;
			 create=null;
}
	}

	else if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Both")) {
		 String reportingEntityid = null;
		if(configurationData.get("MultipleDataGenerationFor_RelatedParty").equalsIgnoreCase("Yes")) {
			 allIndexes =rw.uniqunumber(configurationData.get("TotalNo_counterpartyId_repeated_RelatedPartyFile") ,configurationData.get("NoOfData"));
			 int count=0;
			 String counterPartyId;
		
			 for(Counterparty counterparty: counterpartyData) {
			
				count++;
			  reportingEntityid = counterparty.getReportingEntityId();
			  counterPartyId =counterparty.getCounterypartyId() ;
			 if(allIndexes.contains(count)) {
				 
					int z = ut.completeinteger(configurationData.get("No_individual_counterpartyId_repeated_inRelatedPartyFile"));
						//using faker create randomenumber from 1to z
						int m =  faker.number().numberBetween(1,z );
						for(int k = 1;k<=m;k++) {
							create = new datacreation();
							rel = new relatedParty();
							 rel.setReportingEntityId(reportingEntityid);
							 rel.setCounterpartyId(counterPartyId);
							 //rel.setRelatedCounterpartyID(create.createRelatedCounterepartyId());
							 String RelNo = duplicatecheck.createUniqueRelNew(Relno,create);
					    		rel.setRelatedCounterpartyID(RelNo);
					    		Relno.add(RelNo);
						
							 rel.setRelation(create.createRelation());
						con.add(rel);
						
							
						}	
					}
					else 
					{
						create = new datacreation();
						rel = new relatedParty();
						 rel.setReportingEntityId(reportingEntityid);
						 rel.setCounterpartyId(counterPartyId);
						 //rel.setRelatedCounterpartyID(create.createRelatedCounterepartyId());
						 String RelNo = duplicatecheck.createUniqueRelNew(Relno,create);
				    		rel.setRelatedCounterpartyID(RelNo);
				    		Relno.add(RelNo);
						 rel.setRelation(create.createRelation());
					con.add(rel);
					}
					rel=null;
					create=null;
			 }}
			 else {
				 for (Counterparty counterparty:counterpartyData ) {		
					create = new datacreation();
					rel = new relatedParty();
					rel.setReportingEntityId(reportingEntityid);
					 rel.setCounterpartyId(counterparty.getCounterypartyId());
					 //rel.setRelatedCounterpartyID(create.createRelatedCounterepartyId());
					 String RelNo = duplicatecheck.createUniqueRelNew(Relno,create);
			    		rel.setRelatedCounterpartyID(RelNo);
			    		Relno.add(RelNo);
					 rel.setRelation(create.createRelation());
				con.add(rel);
					
					rel=null;
					create=null;
				 }}}
		return con;
			 }
		    

   public ArrayList<Protection> createProtectionData(ArrayList<protectionInstrument> createProtectionInstrumentData)
      {
         ArrayList<Protection> con = new ArrayList<>();
         if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory")||configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional"))
     	{
     		fieldValues = DataUtil.getFieldValue("MasterData", xls);
            for(protectionInstrument protect:createProtectionInstrumentData ){
  		      create = new datacreation();
  		      Protection p = new Protection();
  		      if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory"))
  				{
  					if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Mandatory")) {
  						  p.setReportingEntityId(protect.getReportingEntityId());
  			    	}else
  			    		 p.setReportingEntityId("");
  			    	if(fieldValues.get("protectionId").equalsIgnoreCase("Mandatory")) {
  			    		 p.setProtectionId(protect.getProtectionId());
  			    	}else
  			    		p.setProtectionId("");
  			    	if(fieldValues.get("protectionProviderId").equalsIgnoreCase("Mandatory")) {
  			    		p.setProtectionProviderId(create.createprotectionProviderId());
  			    	}else
  			    		p.setProtectionProviderId("");
  			      	if(fieldValues.get("typeOfProtection").equalsIgnoreCase("Mandatory")) {
  			      		 p.setTypeOfProtection(create.createtypeOfProtection());
  			    	}else
  			    		p.setTypeOfProtection("");
  			    	
  			      	if(fieldValues.get("currencyType").equalsIgnoreCase("Mandatory")) {
  			      	  p.setCurrencyType(create.createcurrencyType());
  			    	}else
  			    		 p.setCurrencyType("");
  			      	if(fieldValues.get("protectionValue").equalsIgnoreCase("Mandatory")) {
  			      		 p.setProtectionValue(create.createprotectionValue());
  			    	}else
  			    		p.setProtectionValue("");
  			      	if(fieldValues.get("Type Of Protection Value").equalsIgnoreCase("Mandatory")) {
  			      		 p.setTypeOfProtectionValue(create.createtypeOfProtectionValue());
  			    	}else
  			    		 p.setTypeOfProtectionValue("");
  			      	if(fieldValues.get("Protection Valuation Approach").equalsIgnoreCase("Mandatory")) {
  			      		p.setProtectionValuationApproach(create.createprotectionValuationApproach());
  			    	}else
  			    		p.setProtectionValuationApproach("");
  			      	if(fieldValues.get("Date of protection value").equalsIgnoreCase("Mandatory")) {
  			      		p.setDateOfProtectionValue(create.createdateOfProtectionValue());
  			    	}else
  			    		p.setDateOfProtectionValue("");
  			      	if(fieldValues.get("originalProtectionValue").equalsIgnoreCase("Mandatory")) {
  			      	  p.setOriginalProtectionValue(create.createoriginalProtectionValue());
  			    	}else
  			    		 p.setOriginalProtectionValue("");
  			      	if(fieldValues.get("Date Of OriginalProtectionValue").equalsIgnoreCase("Mandatory")) {
  			      		p.setDateOfOriginalProtectionValue(create.createdateOfOriginalProtectionValu());
  			    	}else
  			    		p.setDateOfOriginalProtectionValue("");
  			      	if(fieldValues.get("Protection Registry Id").equalsIgnoreCase("Mandatory")) {
  			      	     p.setProtectionRegistryId(create.createprotectionRegistryId());
  			    	}else
  			    		 p.setProtectionRegistryId("");
  			      	if(fieldValues.get("Protection External Id").equalsIgnoreCase("Mandatory")) {
  			      		p.setProtectionExternalId(create.createprotectionExternalId());
  			    	}else
  			    		p.setProtectionExternalId("");

  				}
  				 if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional")) {
  					 if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Optional")) {
  						  p.setReportingEntityId(protect.getReportingEntityId());
  			    	}else
  			    		 p.setReportingEntityId("");
  			    	if(fieldValues.get("protectionId").equalsIgnoreCase("Optional")) {
  			    		 p.setProtectionId(protect.getProtectionId());
  			    	}else
  			    		p.setProtectionId("");
  			    	if(fieldValues.get("protectionProviderId").equalsIgnoreCase("Optional")) {
  			    		p.setProtectionProviderId(create.createprotectionProviderId());
  			    	}else
  			    		p.setProtectionProviderId("");
  			      	if(fieldValues.get("typeOfProtection").equalsIgnoreCase("Optional")) {
  			      		 p.setTypeOfProtection(create.createtypeOfProtection());
  			    	}else
  			    		p.setTypeOfProtection("");
  			    	
  			      	if(fieldValues.get("currencyType").equalsIgnoreCase("Optional")) {
  			      	  p.setCurrencyType(create.createcurrencyType());
  			    	}else
  			    		 p.setCurrencyType("");
  			      	if(fieldValues.get("protectionValue").equalsIgnoreCase("Optional")) {
  			      		 p.setProtectionValue(create.createprotectionValue());
  			    	}else
  			    		p.setProtectionValue("");
  			      	if(fieldValues.get("Type Of Protection Value").equalsIgnoreCase("Optional")) {
  			      		 p.setTypeOfProtectionValue(create.createtypeOfProtectionValue());
  			    	}else
  			    		 p.setTypeOfProtectionValue("");
  			      	if(fieldValues.get("Protection Valuation Approach").equalsIgnoreCase("Optional")) {
  			      		p.setProtectionValuationApproach(create.createprotectionValuationApproach());
  			    	}else
  			    		p.setProtectionValuationApproach("");
  			      	if(fieldValues.get("Date of protection value").equalsIgnoreCase("Optional")) {
  			      		p.setDateOfProtectionValue(create.createdateOfProtectionValue());
  			    	}else
  			    		p.setDateOfProtectionValue("");
  			      	if(fieldValues.get("originalProtectionValue").equalsIgnoreCase("Optional")) {
  			      	  p.setOriginalProtectionValue(create.createoriginalProtectionValue());
  			    	}else
  			    		 p.setOriginalProtectionValue("");
  			      	if(fieldValues.get("Date Of OriginalProtectionValue").equalsIgnoreCase("Optional")) {
  			      		p.setDateOfOriginalProtectionValue(create.createdateOfOriginalProtectionValu());
  			    	}else
  			    		p.setDateOfOriginalProtectionValue("");
  			      	if(fieldValues.get("Protection Registry Id").equalsIgnoreCase("Optional")) {
  			      	     p.setProtectionRegistryId(create.createprotectionRegistryId());
  			    	}else
  			    		 p.setProtectionRegistryId("");
  			      	if(fieldValues.get("Protection External Id").equalsIgnoreCase("Optional")) {
  			      		p.setProtectionExternalId(create.createprotectionExternalId());
  			    	}else
  			    		p.setProtectionExternalId("");
  				 }
  				 con.add(p);
  				 p = null;
  				 create=null;
      }
     	}else  if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Both")) {
     		for(protectionInstrument protect:createProtectionInstrumentData ){
    		      create = new datacreation();
    		      Protection p = new Protection();
    					  p.setReportingEntityId(protect.getReportingEntityId());
    				      p.setProtectionId(protect.getProtectionId());
    				      p.setProtectionProviderId(create.createprotectionProviderId());
    				      p.setTypeOfProtection(create.createtypeOfProtection());
    				      p.setCurrencyType(create.createcurrencyType());
    				      p.setProtectionValue(create.createprotectionValue());
    				      p.setTypeOfProtectionValue(create.createtypeOfProtectionValue());
    				      p.setProtectionValuationApproach(create.createprotectionValuationApproach());
    				      p.setDateOfProtectionValue(create.createdateOfProtectionValue());
    				      p.setOriginalProtectionValue(create.createoriginalProtectionValue());
    				      p.setDateOfOriginalProtectionValue(create.createdateOfOriginalProtectionValu());
    				      p.setProtectionRegistryId(create.createprotectionRegistryId());
    				      p.setProtectionExternalId(create.createprotectionExternalId());		 
    		  con.add(p);  
    		  p = null;
    		  create=null;
     		}
     	}
         Collections.shuffle(con);
         return con;
     }
   public ArrayList<counterpartyRating> createcounterpartyRatingData(ArrayList<Counterparty> counterpartyData) {
		
		ArrayList<counterpartyRating> con =  new ArrayList<>();
		counterpartyRating cpr;
		ReadWrite rw =  new ReadWrite();
		ArrayList<Integer> allIndexes = null;
		ArrayList<String> Rateid =  new ArrayList<>();
		String reportingEntityid = null;
		if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory")||configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional"))
     	{
     		fieldValues = DataUtil.getFieldValue("MasterData", xls);
     		 for(Counterparty counterparty: counterpartyData) {
			 	create = new datacreation();
			 	cpr  =  new counterpartyRating();
			 	
				if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory"))
				{
					if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Mandatory")) {
						cpr.setReportingEntityId(counterparty.getReportingEntityId());
			    	}else
			    		cpr.setReportingEntityId("");
			    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Mandatory")) {
			    	 	cpr.setCounterpartyId(counterparty.getCounterypartyId());
			    	}else
			    		cpr.setCounterpartyId("");
			    	if(fieldValues.get("ratingID").equalsIgnoreCase("Mandatory")) {
			    	 	cpr.setRatingID(create.createRatingId());
			    	}else
			    		cpr.setRatingID("");
			    	if(fieldValues.get("creditRating").equalsIgnoreCase("Mandatory")) {
			    		cpr.setCreditRating(create.creditRating());
			    	}else
			    		cpr.setCreditRating("");
			    	if(fieldValues.get("assessmentAgencyAuthority").equalsIgnoreCase("Mandatory")) {
			    		cpr.setAssessmentAgencyAuthority(create.assessmentAgencyAuthority());
			    	}else
			    		cpr.setAssessmentAgencyAuthority("");
			    	if(fieldValues.get("creditRatingAsOn").equalsIgnoreCase("Mandatory")) {
			    		 cpr.setCreditRatingAsOn(create.creditRatingAsOn());
			    	}else
			    		cpr.setCreditRatingAsOn("");
			    	if(fieldValues.get("creditRatingExpiryDate").equalsIgnoreCase("Mandatory")) {
			    		   cpr.setCreditRatingExpiryDate(create.creditRatingExpiryDate());
			    	}else
			    		cpr.setCreditRatingExpiryDate("");
			    	
				}
				 if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional")) {
					 if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Optional")) {
							cpr.setReportingEntityId(counterparty.getReportingEntityId());
				    	}else
				    		cpr.setReportingEntityId("");
				    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Optional")) {
				    	 	cpr.setCounterpartyId(counterparty.getCounterypartyId());
				    	}else
				    		cpr.setCounterpartyId("");
				    	if(fieldValues.get("ratingId").equalsIgnoreCase("Optional")) {
				    	 	cpr.setRatingID(create.createRatingId());
				    	}else
				    		cpr.setRatingID("");
				    	if(fieldValues.get("creditRating").equalsIgnoreCase("Optional")) {
				    		cpr.setCreditRating(create.creditRating());
				    	}else
				    		cpr.setCreditRating("");
				    	if(fieldValues.get("assessmentAgencyAuthority").equalsIgnoreCase("Optional")) {
				    		cpr.setAssessmentAgencyAuthority(create.assessmentAgencyAuthority());
				    	}else
				    		cpr.setAssessmentAgencyAuthority("");
				    	if(fieldValues.get("creditRatingAsOn").equalsIgnoreCase("Optional")) {
				    		 cpr.setCreditRatingAsOn(create.creditRatingAsOn());
				    	}else
				    		cpr.setCreditRatingAsOn("");
				    	if(fieldValues.get("creditRatingExpiryDate").equalsIgnoreCase("Optional")) {
				    		   cpr.setCreditRatingExpiryDate(create.creditRatingExpiryDate());
				    	}else
				    		cpr.setCreditRatingExpiryDate("");
				 }
			 con.add(cpr);	
			 cpr=null;
			 create=null;
				}
     		
     	}else if (configurationData.get("GenerateDataFor").equalsIgnoreCase("Both")){
     		if(configurationData.get("MultipleDataGenerationFor_counterpartyRating").equalsIgnoreCase("Yes")) {
     		int count = 0;
     		
     		String CounterpartyId;
     	
     		 for(Counterparty counterparty: counterpartyData) {
     			  reportingEntityid = counterparty.getReportingEntityId();
     			 CounterpartyId = counterparty.getCounterypartyId();
     			 //pass counterparty
     			 
     			
					count++;
     				 create = new datacreation();
     				 cpr  =  new counterpartyRating();
     				 allIndexes =rw.uniqunumber(configurationData.get("TotalNo_counterpartyId_repeated_counterpartyRatingFile") ,configurationData.get("NoOfData"));
     				if(allIndexes.contains(count)) {
     					
     			int z = ut.completeinteger(configurationData.get("No_individual_counterpartyId_repeated_incounterpartyRatingFile"));
     					//using faker create randomenumber from 1to z
     					int m =  faker.number().numberBetween(1,z );
     					for(int k = 1;k<=m;k++) {
     							cpr  =  new counterpartyRating();
     							cpr.setReportingEntityId(reportingEntityid);
     						 	cpr.setCounterpartyId( CounterpartyId);
     						 	//cpr.setRatingID(create.createRatingId());
     						 	String ratingID = duplicatecheck.createUniqueRatingIdNew(Rateid,create);
     				    		cpr.setRatingID(ratingID);
     				    		Rateid.add(ratingID);
     						 	cpr.setCreditRating(create.creditRating());
     						 	cpr.setAssessmentAgencyAuthority(create.assessmentAgencyAuthority());
     					        cpr.setCreditRatingAsOn(create.creditRatingAsOn());
     					        cpr.setCreditRatingExpiryDate(create.creditRatingExpiryDate());
     					     con.add(cpr);
     					   
     				 }}
     			else {
     				
     					create = new datacreation();
     					cpr  =  new counterpartyRating();
						 	cpr.setReportingEntityId(reportingEntityid);
 						 	cpr.setCounterpartyId( CounterpartyId);
 						 	//cpr.setRatingID(create.createRatingId());
 						 	String ratingID = duplicatecheck.createUniqueRatingIdNew(Rateid,create);
 				    		cpr.setRatingID(ratingID);
 				    		Rateid.add(ratingID);
						 	cpr.setCreditRating(create.creditRating());
						 	cpr.setAssessmentAgencyAuthority(create.assessmentAgencyAuthority());
					        cpr.setCreditRatingAsOn(create.creditRatingAsOn());
					        cpr.setCreditRatingExpiryDate(create.creditRatingExpiryDate());
					     con.add(cpr);}	
     				  cpr=null;
     					create=null;
     				 }}
     				
     						
     		else {	
     			 for(Counterparty counterparty: counterpartyData)
     			 {
     		     create = new datacreation();
			 	 cpr  =  new counterpartyRating();
			 	cpr.setReportingEntityId(reportingEntityid);
			 	cpr.setCounterpartyId(counterparty.getCounterypartyId());
			 	//cpr.setRatingID(create.createRatingId());
			 	String ratingID = duplicatecheck.createUniqueRatingIdNew(Rateid,create);
		    		cpr.setRatingID(ratingID);
		    		Rateid.add(ratingID);
			 	cpr.setCreditRating(create.creditRating());
			 	cpr.setAssessmentAgencyAuthority(create.assessmentAgencyAuthority());
		        cpr.setCreditRatingAsOn(create.creditRatingAsOn());
		        cpr.setCreditRatingExpiryDate(create.creditRatingExpiryDate());
		     con.add(cpr);	 
		   	 cpr=null;
		   	 create=null;
     		}
     	}}
		//Collections.shuffle(con);	
		return con;
	}

public ArrayList<counterpartyRisk> createCounterpartyRiskData(ArrayList<Counterparty> counterpartyData) {
		
		ArrayList<counterpartyRisk> con =  new ArrayList<>();
		if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory")||configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional"))
     	{
     		fieldValues = DataUtil.getFieldValue("MasterData", xls);
     		 for(Counterparty counterparty: counterpartyData)  {
			 	create = new datacreation();
			 	counterpartyRisk cr  =  new counterpartyRisk();
			 	
			 	if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory"))
				{
					if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Mandatory")) {
						cr.setReportingEntityId(counterparty.getReportingEntityId());
			    	}else
			    		cr.setReportingEntityId("");
			    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Mandatory")) {
			    	 	cr.setCounterpartyId(counterparty.getCounterypartyId());
			    	}else
			    		cr.setCounterpartyId("");
			    	if(fieldValues.get("statusOfInsolvencyProceedings").equalsIgnoreCase("Mandatory")) {
			    		cr.setStatusOfInsolvencyProceedings(create.createStatusOfInsolvencyProceedings());
			    	}else
			    		cr.setStatusOfInsolvencyProceedings("");
			    	if(fieldValues.get("dateOfInitiationOfInsolvencyProceedings").equalsIgnoreCase("Mandatory")) {
			    		cr.setDateOfInitiationOfInsolvencyProceedings(create.dateOfInitiationOfInsolvencyProceedings());
			    	}else
			    		cr.setDateOfInitiationOfInsolvencyProceedings("");
			    	if(fieldValues.get("wilfulDefaulter").equalsIgnoreCase("Mandatory")) {
			    		cr.setWilfulDefaulter(create.createwilfulDefaulter());
			    	}else
			    		cr.setWilfulDefaulter("");
			    	if(fieldValues.get("dateOfWilfulDefaulterClassfication").equalsIgnoreCase("Mandatory")) {
			    		cr.setDateOfWilfulDefaulterClassification(create.dateOfWilfulDefaulterClassification());
			    	}else
			    		cr.setDateOfWilfulDefaulterClassification("");
			    	if(fieldValues.get("nonCooperativeBorrower").equalsIgnoreCase("Mandatory")) {
			    		cr.setNonCooperativeBorrower(create.createnonCooperativeBorrower());
			    	}else
			    		cr.setNonCooperativeBorrower("");
			    	if(fieldValues.get("dateOfNonCooperativeBorrowerClassification").equalsIgnoreCase("Mandatory")) {
			    		cr.setDateOfNonCooperativeBorrowerClassification(create.dateOfNonCooperativeBorrowerClassification());
			    	}else
			    		cr.setDateOfNonCooperativeBorrowerClassification("");
			    	if(fieldValues.get("fradulentActivity").equalsIgnoreCase("Mandatory")) {
			    		cr.setFradulentActivity(create.createFradulentActivity());
			    	}else
			    		cr.setFradulentActivity("");
			    	if(fieldValues.get("dateOfFradulentActivityClassification").equalsIgnoreCase("Mandatory")) {
			    		cr.setDateOfFradulentActivityClassification(create.dateOfFradulentActivityClassification());
			    	}else
			    		cr.setDateOfFradulentActivityClassification("");
			    	if(fieldValues.get("internalRating").equalsIgnoreCase("Mandatory")) {
			    		cr.setInternalRating(create.createinternalRating());
			    	}else
			    		cr.setInternalRating("");
			    	if(fieldValues.get("dateOfInternalRating").equalsIgnoreCase("Mandatory")) {
			    		cr.setDateOfInternalRating(create.dateOfInternalRating());
			    	}else
			    		cr.setDateOfInternalRating("");
			    		
				}
				 if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional")) {
					 if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Optional")) {
							cr.setReportingEntityId(counterparty.getReportingEntityId());
				    	}else
				    		cr.setReportingEntityId("");
				    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Optional")) {
				    	 	cr.setCounterpartyId(counterparty.getCounterypartyId());
				    	}else
				    		cr.setCounterpartyId("");
				    	if(fieldValues.get("statusOfInsolvencyProceedings").equalsIgnoreCase("Optional")) {
				    		cr.setStatusOfInsolvencyProceedings(create.createStatusOfInsolvencyProceedings());
				    	}else
				    		cr.setStatusOfInsolvencyProceedings("");
				    	if(fieldValues.get("dateOfInitiationOfInsolvencyProceedings").equalsIgnoreCase("Optional")) {
				    		cr.setDateOfInitiationOfInsolvencyProceedings(create.dateOfInitiationOfInsolvencyProceedings());
				    	}else
				    		cr.setDateOfInitiationOfInsolvencyProceedings("");
				    	if(fieldValues.get("wilfulDefaulter").equalsIgnoreCase("Optional")) {
				    		cr.setWilfulDefaulter(create.createwilfulDefaulter());
				    	}else
				    		cr.setWilfulDefaulter("");
				    	if(fieldValues.get("dateOfWilfulDefaulterClassfication").equalsIgnoreCase("Optional")) {
				    		cr.setDateOfWilfulDefaulterClassification(create.dateOfWilfulDefaulterClassification());
				    	}else
				    		cr.setDateOfWilfulDefaulterClassification("");
				    	if(fieldValues.get("nonCooperativeBorrower").equalsIgnoreCase("Optional")) {
				    		cr.setNonCooperativeBorrower(create.createnonCooperativeBorrower());
				    	}else
				    		cr.setNonCooperativeBorrower("");
				    	if(fieldValues.get("dateOfNonCooperativeBorrowerClassification").equalsIgnoreCase("Optional")) {
				    		cr.setDateOfNonCooperativeBorrowerClassification(create.dateOfNonCooperativeBorrowerClassification());
				    	}else
				    		cr.setDateOfNonCooperativeBorrowerClassification("");
				    	if(fieldValues.get("fradulentActivity").equalsIgnoreCase("Optional")) {
				    		cr.setFradulentActivity(create.createFradulentActivity());
				    	}else
				    		cr.setFradulentActivity("");
				    	if(fieldValues.get("dateOfFradulentActivityClassification").equalsIgnoreCase("Optional")) {
				    		cr.setDateOfFradulentActivityClassification(create.dateOfFradulentActivityClassification());
				    	}else
				    		cr.setDateOfFradulentActivityClassification("");
				    	if(fieldValues.get("internalRating").equalsIgnoreCase("Optional")) {
				    		cr.setInternalRating(create.createinternalRating());
				    	}else
				    		cr.setInternalRating("");
				    	if(fieldValues.get("dateOfInternalRating").equalsIgnoreCase("Optional")) {
				    		cr.setDateOfInternalRating(create.dateOfInternalRating());
				    	}else
				    		cr.setDateOfInternalRating("");
				 }
				 con.add(cr);
				 cr = null;
				 create=null;	
     		}
     	}else  if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Both")) {
     		for(Counterparty counterparty: counterpartyData) {
			 	create = new datacreation();
			 	counterpartyRisk cr  =  new counterpartyRisk();
			 	
			 	cr.setReportingEntityId(counterparty.getReportingEntityId());
			 	cr.setCounterpartyId(counterparty.getCounterypartyId());
			 	cr.setStatusOfInsolvencyProceedings(create.createStatusOfInsolvencyProceedings());
			 	cr.setDateOfInitiationOfInsolvencyProceedings(create.dateOfInitiationOfInsolvencyProceedings());
			 	cr.setWilfulDefaulter(create.createwilfulDefaulter());
			 	cr.setDateOfWilfulDefaulterClassification(create.dateOfWilfulDefaulterClassification());
			 	cr.setNonCooperativeBorrower(create.createnonCooperativeBorrower());
			 	cr.setDateOfNonCooperativeBorrowerClassification(create.dateOfNonCooperativeBorrowerClassification());
			 	cr.setFradulentActivity(create.createFradulentActivity());	
			 	cr.setDateOfFradulentActivityClassification(create.dateOfFradulentActivityClassification());
			 	cr.setInternalRating(create.createinternalRating());
			 	cr.setDateOfInternalRating(create.dateOfInternalRating());
			 con.add(cr);
			 cr = null;
			 create=null;	
     		}
     	}
     	 Collections.shuffle(con);
     	 return con;
	}

   public ArrayList<Instrument> createInstrumentData(ArrayList<Contract> contractData) {
		
		ArrayList<Instrument> con =  new ArrayList<>();
		if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory")||configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional"))
     	{
     		fieldValues = DataUtil.getFieldValue("MasterData", xls);
     		for(Contract contract: contractData) {
    		 	create = new datacreation();
    		 	Instrument in  =  new Instrument();
    		 	if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory"))
    			{
    				if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Mandatory")) {
    					in.setReportingEntityId(contract.getReportingEntityId());
    		    	}else
    		    		in.setReportingEntityId("");
    				if(fieldValues.get("InstrumentId").equalsIgnoreCase("Mandatory")) {
    					in.setInstrumentId(contract.getInstrumentId());
    		    	}else
    		    		in.setInstrumentId("");
    		    	if(fieldValues.get("branchCode").equalsIgnoreCase("Mandatory")) {
    		    		in.setBranchCode(create.createBranchCode());
    		    	}else
    		    		in.setBranchCode("");
    		    	if(fieldValues.get("ContractId").equalsIgnoreCase("Mandatory")) {
    		    		in.setContractId(contract.getContractId());
    		    	}else
    		    		in.setContractId("");
    		    	if(fieldValues.get("districtOfUtilisation").equalsIgnoreCase("Mandatory")) {
    		    		in.setDistrictOfUtilisation(create.createDistrictOfUtilisaton());
    		    	}else
    		    		in.setDistrictOfUtilisation("");
    		    	if(fieldValues.get("instrumentType").equalsIgnoreCase("Mandatory")) {
    		    		in.setInstrumentType(create.createInstrumentType());
    		    	}else
    		    		in.setInstrumentType("");
    		    	if(fieldValues.get("prioritySector").equalsIgnoreCase("Mandatory")) {
    		    		in.setPrioritySector(create.createPrioritySector());
    		    	}else
    		    		in.setPrioritySector("");
    		    	if(fieldValues.get("weakerSection").equalsIgnoreCase("Mandatory")) {
    		    		in.setWeakerSection(create.createWeakerSection());
    		    	}else
    		    		in.setWeakerSection("");
    		    	if(fieldValues.get("classificationOfActivity").equalsIgnoreCase("Mandatory")) {
    		    		in.setClassificationOfActivity(create.createClassificationOfActivity());
    		    	}else
    		    		in.setClassificationOfActivity("");
    		    	if(fieldValues.get("sanctionedDate").equalsIgnoreCase("Mandatory")) {
    		    		in.setSanctionDate(create.createSanctionedDate());
    		    	}else
    		    		in.setSanctionDate("");
    		    	if(fieldValues.get("disbursementDate").equalsIgnoreCase("Mandatory")) {
    		    		in.setDisbursementDate(create.createDisbursementDate());
    		    	}else
    		    		in.setDisbursementDate("");
    		    	if(fieldValues.get("maturityDate").equalsIgnoreCase("Mandatory")) {
    		    		in.setMaturityDate(create.createMaturityDate());
    		    	}else
    		    		in.setMaturityDate("");
    		    	if(fieldValues.get("currencyCode").equalsIgnoreCase("Mandatory")) {
    		    		in.setCurrencyCode(create.createCurrencyCode());
    		    	}else
    		    		in.setCurrencyCode("");
    		    	if(fieldValues.get("originalSanctionAmount").equalsIgnoreCase("Mandatory")) {
    		    		in.setOrgsanAmmnt(create.createoriginalSanctionAmount());
    		    	}else
    		    		in.setOrgsanAmmnt("");
    		    	if(fieldValues.get("syndicatedContractID").equalsIgnoreCase("Mandatory")) {
    		    		in.setSyndcateContactId(create.createsyndicatedContractID());
    		    	}else
    		    		in.setSyndcateContactId("");
    		    	if(fieldValues.get("Recourse").equalsIgnoreCase("Mandatory")) {
    		    		in.setRecourse(create.createrecourse());
    		    	}else
    		    		in.setRecourse("");
    		    	if(fieldValues.get("Interest Rate Type").equalsIgnoreCase("Mandatory")) {
    		    		in.setInterestRateType(create.createintrestRateType());
    		    	}else
    		    		in.setInterestRateType("");
    		    	if(fieldValues.get("interestRate").equalsIgnoreCase("Mandatory")) {
    		    		in.setInterRate(create.interestRate());
    		    	}else
    		    		in.setInterRate("");
    		    	if(fieldValues.get("amortisationType").equalsIgnoreCase("Mandatory")) {
    		    		in.setAmortisationType(create.createamortisationType());
    		    	}else
    		    		in.setAmortisationType("");
    		    	if(fieldValues.get("Payment Frequency").equalsIgnoreCase("Mandatory")) {
    		    		in.setPaymentFrequency(create.createpaymentFrequency());
    		    	}else
    		    		in.setPaymentFrequency("");
    		    	if(fieldValues.get("Weighted Average Interest Rate").equalsIgnoreCase("Mandatory")) {
    		    		in.setWeightedAverageInterestRate(create.weightedAverageInterestRate());
    		    	}else
    		    		in.setWeightedAverageInterestRate("");
    		    	if(fieldValues.get("Installment Amount").equalsIgnoreCase("Mandatory")) {
    		    		in.setInstallAmnt(create.installmentAmount());
    		    	}else
    		    		in.setInstallAmnt("");
    		    	if(fieldValues.get("Balance Outstanding").equalsIgnoreCase("Mandatory")) {
    		    		in.setBalanceOutstanding(create.balanceOutstanding());
    		    	}else
    		    		in.setBalanceOutstanding("");
    		    	if(fieldValues.get("Unavailed Amount").equalsIgnoreCase("Mandatory")) {
    		    		in.setUnvailedAmmount(create.unavailedAmount());
    		    	}else
    		    		in.setUnvailedAmmount("");
    		    	if(fieldValues.get("offBalanceSheetNominalAmount").equalsIgnoreCase("Mandatory")) {
    		    		in.setOffBalMinAmnt(create.offBalanceSheetNominalAmount());
    		    	}else
    		    		in.setOffBalMinAmnt("");
    		    	if(fieldValues.get("creditEquivalentOffBalanceSheetNominalAmount").equalsIgnoreCase("Mandatory")) {
    		    	 	in.setCrediteqibaloff(create.creditEquivalentOffBalanceSheetNominalAmount());
    		    	}else
    		    	 	in.setCrediteqibaloff("");
    		    	if(fieldValues.get("accruedInterest").equalsIgnoreCase("Mandatory")) {
    		    		in.setAccuInterst(create.accruedInterest());
    		    	}else
    		    		in.setAccuInterst("");
    		    	if(fieldValues.get("amountOverdue").equalsIgnoreCase("Mandatory")) {
    		    		in.setAmntOver(create.amountOverdue());
    		    	}else
    		    		in.setAmntOver("");
    		    	if(fieldValues.get("Number of days past due").equalsIgnoreCase("Mandatory")) {
    		    		in.setNumPastDue(create.numberOfDaysPastDue());
    		    	}else
    		    		in.setNumPastDue("");
    		    	if(fieldValues.get("SMA category").equalsIgnoreCase("Mandatory")) {
    		    		in.setSmaCatogry(create.smaCategory());
    		    	}else
    		    		in.setSmaCatogry("");
    		    	if(fieldValues.get("SMA current category since date").equalsIgnoreCase("Mandatory")) {
    		    		in.setSmaCurrentCatg(create.smaCurrentCategorySinceDate());
    		    	}else
    		    		in.setSmaCurrentCatg("");
    		    	if(fieldValues.get("npaCategroyCode").equalsIgnoreCase("Mandatory")) {
    		    		in.setNpaCatgCode(create.npaCategroyCode());
    		    	}else
    		    		in.setNpaCatgCode("");
    		    	if(fieldValues.get("NPA since date").equalsIgnoreCase("Mandatory")) {
    		    	 	in.setNpaSinDate(create.npaSinceDate());
    		    	}else
    		    		in.setNpaSinDate("");
    		    	if(fieldValues.get("Cumulative recoveries since NPA").equalsIgnoreCase("Mandatory")) {
    		    		in.setCummRecovSinNpa(create.cummulativeRecoveriesNpa());
    		    	}else
    		    		in.setCummRecovSinNpa("");
    		    	if(fieldValues.get("Accumulated provisions").equalsIgnoreCase("Mandatory")) {
    		    	 	in.setAccProviosions(create.accumulatedProvisions());
    		    	}else
    		    		in.setAccProviosions("");
    		    	if(fieldValues.get("Accumulated write-offs").equalsIgnoreCase("Mandatory")) {
    		    		in.setAccWriteOffs(create.accumulatedWriteOffs());
    		    	}else
    		    		in.setAccWriteOffs("");
    		    	if(fieldValues.get("settlementAmount").equalsIgnoreCase("Mandatory")) {
    		    		in.setSettAmmount(create.createSettlementAmount());
    		    	}else
    		    		in.setSettAmmount("");
    		    	if(fieldValues.get("accountStatus").equalsIgnoreCase("Mandatory")) {
    		    		in.setAccountStatus(create.createAccountStatus());
    		    	}else
    		    		in.setAccountStatus("");
    		    
    		    	if(fieldValues.get("Restructuring status").equalsIgnoreCase("Mandatory")) {
    		    		in.setRestStatus(create.createRestructuringStatus());
    		    	}else
    		    		in.setRestStatus("");
    		    	if(fieldValues.get("statusDate").equalsIgnoreCase("Mandatory")) {
    		    		in.setStatusDate(create.createStatusDate());
    		    	}else
    		    		in.setStatusDate("");
    		    	if(fieldValues.get("suitFiledDate").equalsIgnoreCase("Mandatory")) {
    		    		in.setSuitFielDate(create.createSuiteFieldDate());
    		    	}else
    		    		in.setSuitFielDate("");	
    			}
    			 if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional")) {
    				 if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Optional")) {
    						in.setReportingEntityId(contract.getReportingEntityId());
    			    	}else
    			    		in.setReportingEntityId("");
    					if(fieldValues.get("InstrumentId").equalsIgnoreCase("Optional")) {
    						in.setInstrumentId(contract.getInstrumentId());
    			    	}else
    			    		in.setInstrumentId("");
    			    	if(fieldValues.get("branchCode").equalsIgnoreCase("Optional")) {
    			    		in.setBranchCode(create.createBranchCode());
    			    	}else
    			    		in.setBranchCode("");
    			    	if(fieldValues.get("ContractId").equalsIgnoreCase("Optional")) {
    			    		in.setContractId(contract.getContractId());
    			    	}else
    			    		in.setContractId("");
    			    	if(fieldValues.get("districtOfUtilisation").equalsIgnoreCase("Optional")) {
    			    		in.setDistrictOfUtilisation(create.createDistrictOfUtilisaton());
    			    	}else
    			    		in.setDistrictOfUtilisation("");
    			    	if(fieldValues.get("instrumentType").equalsIgnoreCase("Optional")) {
    			    		in.setInstrumentType(create.createInstrumentType());
    			    	}else
    			    		in.setInstrumentType("");
    			    	if(fieldValues.get("prioritySector").equalsIgnoreCase("Optional")) {
    			    		in.setPrioritySector(create.createPrioritySector());
    			    	}else
    			    		in.setPrioritySector("");
    			    	if(fieldValues.get("weakerSection").equalsIgnoreCase("Optional")) {
    			    		in.setWeakerSection(create.createWeakerSection());
    			    	}else
    			    		in.setWeakerSection("");
    			    	if(fieldValues.get("classificationOfActivity").equalsIgnoreCase("Optional")) {
    			    		in.setClassificationOfActivity(create.createClassificationOfActivity());
    			    	}else
    			    		in.setClassificationOfActivity("");
    			    	if(fieldValues.get("sanctionedDate").equalsIgnoreCase("Optional")) {
    			    		in.setSanctionDate(create.createSanctionedDate());
    			    	}else
    			    		in.setSanctionDate("");
    			    	if(fieldValues.get("disbursementDate").equalsIgnoreCase("Optional")) {
    			    		in.setDisbursementDate(create.createDisbursementDate());
    			    	}else
    			    		in.setDisbursementDate("");
    			    	if(fieldValues.get("maturityDate").equalsIgnoreCase("Optional")) {
    			    		in.setMaturityDate(create.createMaturityDate());
    			    	}else
    			    		in.setMaturityDate("");
    			    	if(fieldValues.get("currencyCode").equalsIgnoreCase("Optional")) {
    			    		in.setCurrencyCode(create.createCurrencyCode());
    			    	}else
    			    		in.setCurrencyCode("");
    			    	if(fieldValues.get("originalSanctionAmount").equalsIgnoreCase("Optional")) {
    			    		in.setOrgsanAmmnt(create.createoriginalSanctionAmount());
    			    	}else
    			    		in.setOrgsanAmmnt("");
    			    	if(fieldValues.get("syndicatedContractID").equalsIgnoreCase("Optional")) {
    			    		in.setSyndcateContactId(create.createsyndicatedContractID());
    			    	}else
    			    		in.setSyndcateContactId("");
    			    	if(fieldValues.get("Recourse").equalsIgnoreCase("Optional")) {
    			    		in.setRecourse(create.createrecourse());
    			    	}else
    			    		in.setRecourse("");
    			    	if(fieldValues.get("Interest Rate Type").equalsIgnoreCase("Optional")) {
    			    		in.setInterestRateType(create.createintrestRateType());
    			    	}else
    			    		in.setInterestRateType("");
    			    	if(fieldValues.get("interestRate").equalsIgnoreCase("Optional")) {
    			    		in.setInterRate(create.interestRate());
    			    	}else
    			    		in.setInterRate("");
    			    	if(fieldValues.get("amortisationType").equalsIgnoreCase("Optional")) {
    			    		in.setAmortisationType(create.createamortisationType());
    			    	}else
    			    		in.setAmortisationType("");
    			    	if(fieldValues.get("Payment Frequency").equalsIgnoreCase("Optional")) {
    			    		in.setPaymentFrequency(create.createpaymentFrequency());
    			    	}else
    			    		in.setPaymentFrequency("");
    			    	if(fieldValues.get("Weighted Average Interest Rate").equalsIgnoreCase("Optional")) {
    			    		in.setWeightedAverageInterestRate(create.weightedAverageInterestRate());
    			    	}else
    			    		in.setWeightedAverageInterestRate("");
    			    	if(fieldValues.get("Installment Amount").equalsIgnoreCase("Optional")) {
    			    		in.setInstallAmnt(create.installmentAmount());
    			    	}else
    			    		in.setInstallAmnt("");
    			    	
    			    	if(fieldValues.get("Balance Outstanding").equalsIgnoreCase("Optional")) {
    			    		in.setBalanceOutstanding(create.balanceOutstanding());
    			    	}else
    			    		in.setBalanceOutstanding("");
    			    	if(fieldValues.get("Unavailed Amount").equalsIgnoreCase("Optional")) {
    			    		in.setUnvailedAmmount(create.unavailedAmount());
    			    	}else
    			    		in.setUnvailedAmmount("");
    			    	if(fieldValues.get("offBalanceSheetNominalAmount").equalsIgnoreCase("Optional")) {
    			    		in.setOffBalMinAmnt(create.offBalanceSheetNominalAmount());
    			    	}else
    			    		in.setOffBalMinAmnt("");
    			    	if(fieldValues.get("creditEquivalentOffBalanceSheetNominalAmount").equalsIgnoreCase("Optional")) {
    			    	 	in.setCrediteqibaloff(create.creditEquivalentOffBalanceSheetNominalAmount());
    			    	}else
    			    	 	in.setCrediteqibaloff("");
    			    	if(fieldValues.get("accruedInterest").equalsIgnoreCase("Optional")) {
    			    		in.setAccuInterst(create.accruedInterest());
    			    	}else
    			    		in.setAccuInterst("");
    			    	if(fieldValues.get("amountOverdue").equalsIgnoreCase("Optional")) {
    			    		in.setAmntOver(create.amountOverdue());
    			    	}else
    			    		in.setAmntOver("");
    			    	if(fieldValues.get("Number of days past due").equalsIgnoreCase("Optional")) {
    			    		in.setNumPastDue(create.numberOfDaysPastDue());
    			    	}else
    			    		in.setNumPastDue("");
    			    	if(fieldValues.get("SMA category").equalsIgnoreCase("Optional")) {
    			    		in.setSmaCatogry(create.smaCategory());
    			    	}else
    			    		in.setSmaCatogry("");
    			    	if(fieldValues.get("SMA current category since date").equalsIgnoreCase("Optional")) {
    			    		in.setSmaCurrentCatg(create.smaCurrentCategorySinceDate());
    			    	}else
    			    		in.setSmaCurrentCatg("");
    			    	if(fieldValues.get("npaCategroyCode").equalsIgnoreCase("Optional")) {
    			    		in.setNpaCatgCode(create.npaCategroyCode());
    			    	}else
    			    		in.setNpaCatgCode("");
    			    	if(fieldValues.get("NPA since date").equalsIgnoreCase("Optional")) {
    			    	 	in.setNpaSinDate(create.npaSinceDate());
    			    	}else
    			    		in.setNpaSinDate("");
    			    	if(fieldValues.get("Cumulative recoveries since NPA").equalsIgnoreCase("Optional")) {
    			    		in.setCummRecovSinNpa(create.cummulativeRecoveriesNpa());
    			    	}else
    			    		in.setCummRecovSinNpa("");
    			    	if(fieldValues.get("Accumulated provisions").equalsIgnoreCase("Optional")) {
    			    	 	in.setAccProviosions(create.accumulatedProvisions());
    			    	}else
    			    		in.setAccProviosions("");
    			    	if(fieldValues.get("Accumulated write-offs").equalsIgnoreCase("Optional")) {
    			    		in.setAccWriteOffs(create.accumulatedWriteOffs());
    			    	}else
    			    		in.setAccWriteOffs("");
    			    	if(fieldValues.get("settlementAmount").equalsIgnoreCase("Optional")) {
    			    		in.setSettAmmount(create.createSettlementAmount());
    			    	}else
    			    		in.setSettAmmount("");
    			    	if(fieldValues.get("accountStatus").equalsIgnoreCase("Optional")) {
    			    		in.setAccountStatus(create.createAccountStatus());
    			    	}else
    			    		in.setAccountStatus("");
    			    	if(fieldValues.get("restDate").equalsIgnoreCase("Optional")) {
    			    		in.setRestDate(create.restructStatusDate());
    			    	}else
    			    		in.setRestDate("");
    			    	if(fieldValues.get("Restructuring status").equalsIgnoreCase("Optional")) {
    			    		in.setRestStatus(create.createRestructuringStatus());
    			    	}else
    			    		in.setRestStatus("");
    			    	if(fieldValues.get("statusDate").equalsIgnoreCase("Optional")) {
    			    		in.setStatusDate(create.createStatusDate());
    			    	}else
    			    		in.setStatusDate("");
    			    	if(fieldValues.get("suitFiledDate").equalsIgnoreCase("Optional")) {
    			    		in.setSuitFielDate(create.createSuiteFieldDate());
    			    	}else
    			    		in.setSuitFielDate("");
    			 }
    			 con.add(in);
 				 create=null;
 				 in = null;
     		}
     	}else if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Both")) {
     		for(Contract contract: contractData) {
    		 	create = new datacreation();
    		 	Instrument in  =  new Instrument();
    		 	in.setReportingEntityId(contract.getReportingEntityId());
			 	in.setInstrumentId(contract.getInstrumentId());
				in.setBranchCode(create.createBranchCode());
			 	in.setContractId(contract.getContractId());
			 	in.setDistrictOfUtilisation(create.createDistrictOfUtilisaton());
			 	in.setInstrumentType(create.createInstrumentType());
			 	in.setPrioritySector(create.createPrioritySector());
			 	in.setWeakerSection(create.createWeakerSection());
			 	in.setClassificationOfActivity(create.createClassificationOfActivity());
			 	in.setSanctionDate(create.createSanctionedDate());
			 	in.setDisbursementDate(create.createDisbursementDate());
			 	in.setMaturityDate(create.createMaturityDate());
			 	in.setCurrencyCode(create.createCurrencyCode());
			 	in.setOrgsanAmmnt(create.createoriginalSanctionAmount());
			 	in.setSyndcateContactId(create.createsyndicatedContractID());
			 	in.setRecourse(create.createrecourse());
			 	in.setInterestRateType(create.createintrestRateType());
			 	in.setInterRate(create.interestRate());
			 	in.setAmortisationType(create.createamortisationType());
			 	in.setPaymentFrequency(create.createpaymentFrequency());
			 	in.setInterRate(create.interestRate());
			 	in.setWeightedAverageInterestRate(create.weightedAverageInterestRate());
			 	in.setInstallAmnt(create.installmentAmount());
			 	in.setBalanceOutstanding(create.balanceOutstanding());
			 	in.setUnvailedAmmount(create.unavailedAmount());
			 	in.setOffBalMinAmnt(create.offBalanceSheetNominalAmount());
			 	in.setCrediteqibaloff(create.creditEquivalentOffBalanceSheetNominalAmount());
			 	in.setAccuInterst(create.accruedInterest());
			 	in.setAmntOver(create.amountOverdue());
			 	in.setNumPastDue(create.numberOfDaysPastDue());
			 	in.setSmaCatogry(create.smaCategory());
			 	in.setSmaCurrentCatg(create.smaCurrentCategorySinceDate());
			 	in.setNpaCatgCode(create.npaCategroyCode());
			 	in.setNpaSinDate(create.npaSinceDate());
			 	in.setCummRecovSinNpa(create.cummulativeRecoveriesNpa());
			 	in.setAccProviosions(create.accumulatedProvisions());
			 	in.setAccWriteOffs(create.accumulatedWriteOffs());
			 	in.setSettAmmount(create.createSettlementAmount());
			 	in.setAccountStatus(create.createAccountStatus());
			 	in.setRestDate(create.restructStatusDate());
			 	in.setRestStatus(create.createRestructuringStatus());
			 	in.setStatusDate(create.createStatusDate());
			 	in.setSuitFielDate(create.createSuiteFieldDate());
			con.add(in);
			create=null;
			in = null;
     		}
     	}
		Collections.shuffle(con);
		return con;
   }
  /* private int isMultiple(int dr, ArrayList<Integer> multipledataIndex,int Records,String totalMultipleRecords) {
		if(multipledataIndex.contains(dr)) {
			double f=Double.parseDouble(totalMultipleRecords);
			int MultipleRecords=(int)f; 
			dr = faker.number().numberBetween(1,MultipleRecords );
			 isMultiple(dr,multipledataIndex,Records, totalMultipleRecords);
		}
		
		else {
			return  dr;
			}

		return dr;
		}
   private ArrayList<Integer> multiplenumber(String totalMultipleRecords, String totalRecords) {
		
		double f=Double.parseDouble(totalMultipleRecords);
		int MultipleRecords=(int)f;
		double f1=Double.parseDouble(totalRecords);
		int Records=(int)f1;
		ArrayList<Integer> multipledataIndex = new ArrayList<>();
		if(multipledataIndex.size()== 0) {
			multipledataIndex = new ArrayList<>();
		}
		for(int i = 0;i<MultipleRecords;i++) {
			int dr = faker.number().numberBetween(1, MultipleRecords);
			int data = isMultiple(dr,multipledataIndex,Records, totalRecords);
			multipledataIndex.add(data);
		
	}
		return multipledataIndex;
}
   private int isIndex(int dr, ArrayList<Integer> IndexNumber,int Records) {
		if(IndexNumber.contains(dr)) {
			 dr = faker.number().numberBetween(1, Records);
			 isIndex(dr,IndexNumber,Records);
		}
		
		else {
			return  dr;
			}

		return dr;
		}
   private ArrayList<Integer> indexnumber(String totalindexRecords, String totalRecords) {
		
		double f=Double.parseDouble(totalindexRecords);
		int indexRecords=(int)f;
		double f1=Double.parseDouble(totalRecords);
		int Records=(int)f1;
		ArrayList<Integer> dataIndex = new ArrayList<>();
		if(dataIndex.size()== 0) {
			dataIndex = new ArrayList<>();
		}
		for(int i = 0;i<indexRecords;i++) {
			int dr = faker.number().numberBetween(1, Records);
			int data = isIndex(dr,dataIndex,Records);
			dataIndex.add(data);
		
	}
		return dataIndex;
}*/
}
   
