package ReUsable;

import java.util.ArrayList;

import pojoClases.Contract;
import pojoClases.Counterparty;
import pojoClases.datacreation;

public class settingEntityDataSet {
	datacreation create ;
	
public ArrayList<Contract> createContractData(int numberData) {
		
		ArrayList<Contract> con =  new ArrayList<>();
		
			for (int i=0; i<numberData; i++) {
			 	create = new datacreation();
				Contract c  =  new Contract();
				c.setContractId("");
				c.setCounterypartyId("");
				c.setInstrumentId("");
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
		 	cp.setCin("");
		 	cp.setCounterypartyId(contract.getCounterypartyId());
		 	cp.setCountryCode("");
		 	cp.setDistrictCode("");
		 	cp.setEmailAddress("");
		 	cp.setGstin("");
		 	cp.setLei("");
		 	cp.setName("");
		 	cp.setNicCode("");
		 	cp.setNicCode("");
		 	cp.setOccupationCode("");
		 	cp.setPan("");
		 	cp.setPinCode("");
		 	cp.setReportingEntityId(contract.getReportingEntityId());
		 	cp.setStateCode("");
		 	cp.setTan("");
		 	cp.setUdyogAadhaar("");
		 				
		con.add(cp);
		cp=null;
	}	
	return con;
}
}

















