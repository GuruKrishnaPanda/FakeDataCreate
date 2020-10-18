package ReUsable;

import java.util.ArrayList;

import pojoClases.Contract;
import pojoClases.Counterparty;
import pojoClases.datacreation;

public class settingEntityDataSet {
	datacreation create ;
	
public ArrayList<Contract> createContractData(int numberData) 
  {	
	
		ArrayList<Contract> con =  new ArrayList<>();
		
			for (int i=0; i<numberData; i++) {
			 	create = new datacreation();
				Contract c  =  new Contract();
				c.setContractId(create.createContractIdentifier());
				c.setCounterypartyId(create.createContractIdentifier());
				c.setInstrumentId(create.createInstrumentId());
				c.setReportingEntityId(create.createReportingEntityId());		
			con.add(c);
			c=null;
			}	
		return con;
	}
public ArrayList<Counterparty> createCounterPartyData(ArrayList<Contract> contractData) {
	
	ArrayList<Counterparty> con =  new ArrayList<>();
	
		for(Contract contract: contractData) {
		 	create = new datacreation();
		 	Counterparty cp  =  new Counterparty();
		 	cp.setAddressLine1(create.addressLine1());
		 	cp.setAddressLine2(create.addressLine2());
		 	cp.setAddressLine3(create.addressLine3());
		 	cp.setCin(create.companyIdentificationNumber());
		 	cp.setCounterypartyId(contract.getCounterypartyId());
		 	cp.setCountryCode(create.countryCode());
		 	cp.setDistrictCode(create.districtCode());
		 	cp.setEmailAddress(create.emailAddress());
		 	cp.setGstin(create.createGstin());
		 	cp.setLei(create.legalEntityIdentifier());
		 	cp.setName(create.createName());
		 	cp.setNicCode(create.nicCode());
		 	cp.setOccupationCode(create.occupationalCode());
		 	cp.setPan(create.validatepan());
		 	cp.setReportingEntityId(contract.getReportingEntityId());
		 	cp.setStateCode(create.stateCode());
		 	cp.setTan(create.taxCollectionAccountNumber());
		    	cp.setDate(create.date());
		 	cp.setAdharNo(create.adharGenerate());
		 	cp.setUdyogAadhaar(create.udyogAdharNumber());
		 	cp.setCasteGen(create.createCaste());
		    	cp.setCommGen(create.createCommunity());
		 	cp.setDin(create.createDIN());
		    	cp.setTypeOrg(create.typeOfOrganisation());
		    	cp.setPinCode(create.pinCode());
		    	cp.setBurrrower(create.createBurrower());
		    	cp.setStateCode(create.stateCode());
		    	cp.setTelePhoneNumber(create.mobileNumber());
		    	cp.setMobNo(create.landmobileNumber());
		    con.add(cp);
		
	
		cp=null;
	}	
	return con;
}
}