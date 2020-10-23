	package ReUsable;

import java.util.ArrayList;



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
			create=null;//Newly Added By Guru
			}	
		return con;
	}
public ArrayList<Counterparty> createCounterPartyData(ArrayList<Contract> contractData) {
	
	ArrayList<Counterparty> con =  new ArrayList<>();
	
		for(Contract contract: contractData) {
		 	create = new datacreation();
		 	Counterparty cp  =  new Counterparty();
		 	cp.setReportingEntityId(contract.getReportingEntityId());
		 	cp.setCounterypartyId(contract.getCounterypartyId());
		 	cp.setName(create.createName());
		    cp.setDate(create.date());
		 	cp.setCasteGen(create.createCaste());
		    cp.setCommGen(create.createCommunity());
		    cp.setPan(create.validatepan());
		 	cp.setAdharNo(create.adharGenerate());
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
		
	
		cp=null;
		create=null;//Newly Added By Guru
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
	pi = null;// Missing in the code
	create=null;//Newly Added By Guru
	
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
	    rel = null;// Missing in the code
		create=null;//Newly Added By Guru
}
	return con;
	}

   public ArrayList<Protection> createProtectionData(ArrayList<Contract> contractData)
      {
         ArrayList<Protection> con = new ArrayList<>();

          for(Contract contract: contractData){
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
		  p = null;// Missing in the code
		  create=null;//Newly Added By Guru
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
				 create=null;//Newly Added By Guru
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
			 cr = null;// Missing in the code
			 create=null;//Newly Added By Guru
			}	
		return con;
	}

   public ArrayList<Instrument> createInstrumentData(ArrayList<Contract> contractData) {
		
		ArrayList<Instrument> con =  new ArrayList<>();
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
		    
		}
		return con;
	
   }
}
   
