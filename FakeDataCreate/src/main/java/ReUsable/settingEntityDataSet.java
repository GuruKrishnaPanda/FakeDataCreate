	package ReUsable;

import java.util.ArrayList;

import javax.sound.midi.Instrument;

import pojoClases.Contract;
import pojoClases.Counterparty;
import pojoClases.counterpartyRating;
import pojoClases.protectionInstrument;
import pojoClases.relatedParty;

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
public ArrayList<protectionInstrument> createProtectionInstrumentData(ArrayList<Contract> contractData)
{
	
	ArrayList<protectionInstrument> con =  new ArrayList<>();
	
	for(Contract contract: contractData) 
	{
	 	create = new datacreation();
	 	protectionInstrument pi = new protectionInstrument();
	    pi.setReportingEntityId(contract.getReportingEntityId());
	    pi.setInstrumentId(contract.getInstrumentId());
	    pi.setContractId(contract.getContractId());
	    pi.setProtectionAllocatedValue(create.createprotectionAllocatedValue());
	    pi.setProtectionId(create.createProtectionId());
	    pi.setChargeType(create.createChargeType());
	
	con.add(pi);
	

	
    }
	return con;
}
public ArrayList<relatedParty> createRelatedPartyData(ArrayList<Contract> contractData) {
	
	ArrayList<relatedParty> con =  new ArrayList<>();
	
	for(Contract contract: contractData) {
    create = new datacreation();
    relatedParty rel = new relatedParty();
    rel.setReportingEntityId(contract.getReportingEntityId());
    rel.setCounterpartyId(contract.getCounterypartyId());
    rel.setRelatedCounterpartyID(create.createRelatedCounterepartyId());
    con.add(rel);		
}
	return con;
	}
public ArrayList<counterpartyRating> createcounterpartyRatingData(ArrayList<Contract> contractData) {
	

	ArrayList<counterpartyRating> con =  new ArrayList<>();
	
				for(Contract contract: contractData) {
			 	create = new datacreation();
			 	counterpartyRating cpr  =  new counterpartyRating();
			 	cpr.setReportingEntityId(contract.getReportingEntityId());
			 	cpr.setCounterpartyId(create.createCouterpartyIdentifier());
			 	con.add(cpr);
			 	
			 	cpr=null;
				}
		 	return con;
}
}
