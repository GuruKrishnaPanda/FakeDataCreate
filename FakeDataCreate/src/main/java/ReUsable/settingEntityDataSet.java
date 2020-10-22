	package ReUsable;

import java.util.ArrayList;

import javax.sound.midi.Instrument;

import pojoClases.Contract;
import pojoClases.Counterparty;
import pojoClases.counterpartyRating;
import pojoClases.protectionInstrument;
import pojoClases.relatedParty;
import pojoClases.Protection;
import pojoClases.counterpartyRisk;
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

   public ArrayList<Protection> createProtectionData(ArrayList<Contract> contractData)
      {
         ArrayList<Protection> con = new ArrayList<>();

          for(Contract contract: contractData)
         {
      create = new datacreation();
      Protection p = new Protection();
      p.setReportingEntityId(contract.getReportingEntityId());
      p.setProtectionId(create.createprotectionId());
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
				 	cpr.setRatingID(create.createRatingId());
				 	cpr.setCreditRating(create.creditRating());
				 	cpr.setAssessmentAgencyAuthority(create.assessmentAgencyAuthority());
			        cpr.setCreditRatingAsOn(create.creditRatingAsOn());
			        cpr.setCreditRatingExpiryDate(create.creditRatingExpiryDate());
				 	con.add(cpr);
				 	
				 	cpr=null;
					}
			 	return con;
	}
   public ArrayList<counterpartyRisk> createCounterpartyRiskData(ArrayList<Contract> contractData) {
		
		ArrayList<counterpartyRisk> con =  new ArrayList<>();
		for(Contract contract: contractData) {
		 	create = new datacreation();
		 	counterpartyRisk cr  =  new counterpartyRisk();
		 	cr.setCounterpartyId(contract.getCounterypartyId());
		 	cr.setReportingEntityId(contract.getReportingEntityId());
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
			
			}	
		return con;
	}}
   
