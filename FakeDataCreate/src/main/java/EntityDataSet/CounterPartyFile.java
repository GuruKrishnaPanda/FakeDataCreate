package EntityDataSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import ReUsable.datacreation;
import Utilities.Constants;
import Utilities.DataUtil;
import pojoClases.Counterparty;

public class CounterPartyFile extends BaseClass {
	public ArrayList<Counterparty> createCounterPartyData(int numberData) {
		create = new datacreation();
		create = null;
		Connection myconn = null;
		
		ArrayList<Counterparty> con =  new ArrayList<>(); 
		ArrayList<String> pan =  new ArrayList<>();
		ArrayList<String> Adhar =  new ArrayList<>();
		ArrayList<String> cpid =  new ArrayList<>();
		Constants cons = new Constants();
		 try {
				//myconn = DriverManager.getConnection(cons.conn);
			 myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/framework","root","password");
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
			    		//String PanNo = duplicatecheck.createUniquePanNew(pan,create);
			    		String PanNo = dis.createUniquePan(myconn,create);
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
			  
			dis.counterpartyDatainsertion(myconn,cp);	  
			 
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
					//String counterid = duplicatecheck.createUniquecpid(cpid, create);
			    	//cp.setCounterypartyId(counterid);
					String counterid=dis.createUniqueCid(myconn,create);
			    	cp.setCounterypartyId(counterid);
			    	cpid.add(counterid);
				 	cp.setName(create.createName());
				    cp.setDate(create.date());
				 	cp.setCasteGen(create.createCaste());
				    cp.setCommGen(create.createCommunity());
				    //cp.setPan(create.pangenerate2());
				    String PanNo = dis.createUniquePan(myconn, create);
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
			dis.counterpartyDatainsertion(myconn,cp);	
			 
			}
			myconn.close();
			    
			}
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return con;
		}

}




