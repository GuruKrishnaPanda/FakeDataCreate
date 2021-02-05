package ReUsable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import EntityDataSet.BaseClass;
import Utilities.DataUtil;
import Utilities.DuplicateDataCheck;
import Utilities.GenericXLSXReader;
import pojoClases.Contract;
import pojoClases.Counterparty;
import pojoClases.Protection;
import pojoClases.counterpartyRating;
import pojoClases.counterpartyRisk;
import pojoClases.protectionInstrument;
import pojoClases.relatedParty;
import pojoClases.Instrument;

public class DatabaseFunctions {

public Statement myStmt;
public void contractDatainsertion(Connection myconn, Contract c) {

	datacreation create  = new datacreation();
try {
myStmt=myconn.createStatement();
String sql = "insert into contract(reportingEntityId,contractId,instrumentId,counterpartyId)values('"+c.getReportingEntityId()+"','"+c.getContractId()+"','"+c.getInstrumentId()+"','"+c.getCounterypartyId()+"')";
myStmt.executeUpdate(sql);
} catch (SQLException e) {
e.printStackTrace();
}
}
public void counterpartyDatainsertion(Connection myconn, Counterparty cp) {
try {
		myStmt=myconn.createStatement();
		String sql = "insert into counterparty(reportingEntityId,counterpartyId,name,dateOfBirthOrIncorporation,caste ,community,pan,aadhaar,din,cin,lei,tan,gstin,udyogAadhaar,typeOfOrganisation,borrowerCategory,sicOrNicCode,occupationCode,addressLine1,addressLine2,addressLine3,pinCode,stateCode,districtCode,countryCode,telephoneNumber,mobileNumber,emailAddress)values ('"+cp.getReportingEntityId()+"','"+cp.getCounterypartyId()+"','"+cp.getName()+"','"+cp.getDate()+"','"+cp.getCasteGen()+"','"+cp.getCommGen()+"','"+cp.getPan()+"','"+cp.getAdharNo()+"','"+cp.getDin()+"','"+cp.getCin()+"','"+cp.getLei()+"','"+cp.getTan()+"','"+cp.getGstin()+"','"+cp.getUdyogAadhaar()+"','"+cp.getTypeOrg()+"','"+cp.getBurrrower()+"','"+cp.getNicCode()+"','"+cp.getOccupationCode()+"','"+cp.getAddressLine1()+"','"+cp.getAddressLine2()+"','"+cp.getAddressLine3()+"','"+cp.getPinCode()+"','"+cp.getStateCode()+"','"+cp.getDistrictCode()+"','"+cp.getCountryCode()+"','"+cp.getTelePhoneNumber()+"','"+cp.getMobNo()+"','"+cp.getEmailAddress()+"')";
		myStmt.executeUpdate(sql);
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
public void protectionFileDatainsertion(Connection myconn,Protection p )
{
try {
	myStmt=myconn.createStatement();
	String sql="insert into protection(reportingEntityId,protectionId,protectionProviderId,typeOfProtection,currencyType,protectionValue,typeOfProtectionValue,protectionValuationApproach,dateOfProtectionValue,originalProtectionValue,dateOfOriginalProtectionValue,protectionRegistryId,protectionExternalId)values('"+ p.getReportingEntityId()+"','"+p.getProtectionId()+"','"+p.getProtectionProviderId()+"','"+p.getTypeOfProtection()+"','"+p.getCurrencyType()+"','"+p.getProtectionValue()+"','"+p.getTypeOfProtectionValue()+"','"+p.getProtectionValuationApproach()+"','"+p.getDateOfProtectionValue()+"','"+p.getOriginalProtectionValue()+"','"+p.getDateOfOriginalProtectionValue()+"','"+p.getProtectionRegistryId()+"','"+p.getProtectionExternalId()+"')";
	myStmt.executeUpdate(sql);
	} catch (SQLException e) {
	e.printStackTrace();
	}
}
public void protectioninstrumentDatainsertion(Connection myconn,protectionInstrument pi)
{
try {
	myStmt=myconn.createStatement();
	String sql2="insert into protectionInstrument(reportingEntityId,contractId,instrumentId,protectionAllocatedValue,protectionId,chargeType)values('"+pi.getReportingEntityId()+"','"+pi.getContractId()+"','"+pi.getInstrumentId()+"','"+pi.getProtectionAllocatedValue()+"','"+pi.getProtectionId()+"','"+pi.getChargeType()+"')";
	myStmt.executeUpdate(sql2);
} catch (SQLException e) {
	e.printStackTrace();
}
}
public void InstrumentInsertion(Connection myconn, Instrument in) {

try {
	myStmt=myconn.createStatement();
	String sql = "insert into instrument(reportingEntityId,instrumentId,branchCode,contractId,districtOfUtilisation,instrumentType,prioritySector,weakerSection,classificationOfActivity,sanctionedDate,disbursementDate,maturityDate,currencyCode,originalSanctionAmount,syndicatedContractId,recourse,interestRateType,amortisationType,paymentFrequency,interestRate,weightedAverageInterestRate,instalmentAmount,balanceOutstanding,unavailedAmount,offBalanceSheetNominalAmount,creditEquivalentOfOffBalanceSheetNominalAmount,accruedInterest,amountOverdue,numberOfDaysPastDue,smaCategory,smaCurrentCategorySinceDate,npaCategory,npaSinceDate,cumulativeRecoveriesSinceNpa,accumulatedProvisions,accumulatedWriteOffs,settlementAmount,restructuringStatus,restructuringStatusDate,status,statusDate,suitFiledDate)values ('"+in.getReportingEntityId()+"','"+in.getInstrumentId()+"','"+in.getBranchCode()+"','"+in.getContractId()+"','"+in.getDistrictOfUtilisation()+"','"+in.getInstrumentType()+"','"+in.getPrioritySector()+"','"+in.getWeakerSection()+"','"+in.getClassificationOfActivity()+"','"+in.getSanctionDate()+"','"+in.getDisbursementDate()+"','"+in.getMaturityDate()+"','"+in.getCurrencyCode()+"','"+in.getOrgsanAmmnt()+"','"+in.getSyndcateContactId()+"','"+in.getRecourse()+"','"+in.getInterestRateType()+"','"+in.getAmortisationType()+"','"+in.getPaymentFrequency()+"','"+in.getInterRate()+"','"+in.getWeightedAverageInterestRate()+"','"+in.getInstallAmnt()+"','"+in.getBalanceOutstanding()+"','"+in.getUnvailedAmmount()+"','"+in.getOffBalMinAmnt()+"','"+in.getCrediteqibaloff()+"','"+in.getAccuInterst()+"','"+in.getAmntOver()+"','"+in.getNumPastDue()+"','"+in.getSmaCatogry()+"','"+in.getSmaCurrentCatg()+"','"+in.getNpaCatgCode()+"','"+in.getNpaSinDate()+"','"+in.getCummRecovSinNpa()+"','"+in.getAccProviosions()+"','"+in.getAccWriteOffs()+"','"+in.getSettAmmount()+"','"+in.getRestStatus()+"','"+in.getRestDate()+"','"+in.getAccountStatus()+"','"+in.getStatusDate()+"','"+in.getSuitFielDate()+"')";
	myStmt.executeUpdate(sql);
} catch (SQLException e) {
	e.printStackTrace();
}
}
public void relatedPartyDatainsertion(Connection myconn, relatedParty rel) {

try {
	myStmt=myconn.createStatement();
	String sql = "insert into relatedparty(reportingEntityId,counterpartyId,relatedCounterpartyID,relation)values('"+rel.getReportingEntityId()+"','"+rel.getCounterpartyId()+"','"+rel.getRelatedCounterpartyID()+"','"+rel.getRelation()+"')";
	myStmt.executeUpdate(sql);
	} catch (SQLException e) {
	e.printStackTrace();
	}
}
public void counterpartyRatinginsertion(Connection myconn, counterpartyRating cpr) {

try {
	myStmt=myconn.createStatement();
	String sql = "insert into counterpartyrating(reportingEntityId,counterpartyId,ratingId,creditRating,assessmentAgencyOrAuthority ,creditRatingAsOn,creditRatingExpiryDate)values ('"+cpr.getReportingEntityId()+"','"+cpr.getCounterpartyId()+"','"+cpr.getRatingID()+"','"+cpr.getCreditRating()+"','"+cpr.getAssessmentAgencyAuthority()+"','"+cpr.getCreditRatingAsOn()+"','"+cpr.getCreditRatingExpiryDate()+"')";
	myStmt.executeUpdate(sql);
} catch (SQLException e) {
	e.printStackTrace();
	}
}
public void counterpartyRiskinsertion(Connection myconn, counterpartyRisk cr) {
try {
	myStmt=myconn.createStatement();
	String sql = "insert into counterpartyrisk(reportingEntityId,counterpartyId,statusOfInsolvencyProceedings,dateOfInitiationOfInsolvencyProceedings,wilfulDefaulter ,dateOfWilfulDefaulterClassification,nonCooperativeBorrower,dateOfNonCooperativeBorrowerClassification,fraudulentActivity,dateOfFraudulentActivityClassification,internalRating,dateOfInternalRating)values ('"+cr.getReportingEntityId()+"','"+cr.getCounterpartyId()+"','"+cr.getStatusOfInsolvencyProceedings()+"','"+cr.getDateOfInitiationOfInsolvencyProceedings()+"','"+cr.getWilfulDefaulter()+"','"+cr.getDateOfWilfulDefaulterClassification()+"','"+cr.getNonCooperativeBorrower()+"','"+cr.getDateOfNonCooperativeBorrowerClassification()+"','"+cr.getFradulentActivity()+"','"+cr.getDateOfFradulentActivityClassification()+"','"+cr.getInternalRating()+"','"+cr.getDateOfInternalRating()+"')";
	myStmt.executeUpdate(sql);
} catch (SQLException e) {
	e.printStackTrace();
}
}

public String createUniquePan(Connection myconn, datacreation create) {
String PanNoNew= create.panGeneration();
try {
	myStmt=myconn.createStatement();
	String sql = "select count(*) from counterparty where pan='"+PanNoNew+"'";
	ResultSet rs = myStmt.executeQuery(sql);
	rs.next();
	int pan=rs.getInt("count(*)");
	if(pan>=1)
	{
	createUniquePan(myconn,create);
	}
} catch (SQLException e) {
	e.printStackTrace();
}
return PanNoNew;
}
public String createUniqueCid(Connection myconn, datacreation create, String bankSymbol) {
	String counterPartyId= create.createCouterpartyIdentifier(bankSymbol);
	
	try {
	
		myStmt=myconn.createStatement();
		String sql = "select count(*) from counterparty where counterpartyId='"+counterPartyId+"'";
		ResultSet rs = myStmt.executeQuery(sql);
		rs.next();
		int cpId=rs.getInt("count(*)");
	if(cpId>=1)
	{
		createUniqueCid(myconn,create,bankSymbol);
	}
	} catch (SQLException e) {
		e.printStackTrace();
	}
return counterPartyId;

}

public String createUniquePid(Connection myconn, datacreation create) {
String ProtectionId=create.createProtectionId();
// TODO Auto-generated method stub
try {
	myStmt=myconn.createStatement();
	String sql = "select count(*) from protectioninstrument where protectionId='"+ProtectionId+"'";
	ResultSet rs = myStmt.executeQuery(sql);
	rs.next();
	int pId=rs.getInt("count(*)");
	if(pId>=1)
	{
		createUniquePid(myconn,create);
	}
	} catch (SQLException e) {
		e.printStackTrace();
}
return ProtectionId;
}
public String createUniqueAadhar(Connection myconn, datacreation create) {
	String adharNo=create.adharValidate();
	try {
	myStmt=myconn.createStatement();
	String sql = "select count(*) from counterparty where aadhaar='"+adharNo+"'";
	ResultSet rs = myStmt.executeQuery(sql);
	rs.next();
	int aadhar=rs.getInt("count(*)");
	if(aadhar>=1)
	{
	createUniqueAadhar(myconn,create);
	}
	} catch (SQLException e) {
	e.printStackTrace();
	}
return adharNo;
}


public String createUniquecontractId(Connection myconn, datacreation create) {
String contractId = create.createContractIdentifier();

try {
	myStmt=myconn.createStatement();
	String sql = "select count(*) from contract where contractId='"+contractId+"'";
	ResultSet rs = myStmt.executeQuery(sql);
	rs.next();
	int contract=rs.getInt("count(*)");
	if(contract>=1)
	{
	createUniquecontractId(myconn,create);
	}
} catch (SQLException e) {
	e.printStackTrace();
}
return contractId;
}


public String createUniqueInstrumentId(Connection myconn, datacreation create) {
	String instrumentId = create.createInstrumentId();
	try {
		myStmt=myconn.createStatement();
		String sql = "select count(*) from contract where instrumentId='"+instrumentId+"'";
		ResultSet rs = myStmt.executeQuery(sql);
		rs.next();
		int instrument=rs.getInt("count(*)");
	if(instrument>=1)
	{
		createUniqueInstrumentId(myconn,create);
	}
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return instrumentId;
}


public String createUniqueRatingId(Connection myconn, datacreation create) {
	String ID =create.createRatingId();
	try {
		myStmt=myconn.createStatement();
		String sql = "select count(*) from counterpartyrating where ratingId='"+ID+"'";
		ResultSet rs = myStmt.executeQuery(sql);
		rs.next();
		int rating=rs.getInt("count(*)");
	if(rating>=1)
	{
		createUniqueRatingId(myconn,create);
	}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return ID;
}


public String createUniqueRelatedCId(Connection myconn, datacreation create) {
	String relatedCounterPartyId = create.createRelatedCounterepartyId();
	try {
		myStmt=myconn.createStatement();
		String sql = "select count(*) from relatedparty where relation='"+relatedCounterPartyId+"'";
		ResultSet rs = myStmt.executeQuery(sql);
		rs.next();
	int relation=rs.getInt("count(*)");
	if(relation>=1)
		{
			createUniqueRelatedCId(myconn,create);
		}
	} 	catch (SQLException e) {
			e.printStackTrace();
	}
		return relatedCounterPartyId;
	}
public void temporaryprotection(String counterypartyId, Connection myconn) {
	// TODO Auto-generated method stub

	String temporary="insert into temporaryprotection(counterpartyId)values('"+counterypartyId+"')";
    try {
		myStmt.executeUpdate(temporary);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void temporaryrelatedparty(String counterypartyId, Connection myconn) {
	// TODO Auto-generated method stub
	String temporary="insert into temporaryrelatedparty(counterpartyId)values('"+counterypartyId+"')";
    try {
		myStmt.executeUpdate(temporary);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void temporarycontract(String counterypartyId, Connection myconn) {
	// TODO Auto-generated method stub
	String temporary="insert into temporarycontract(counterpartyId)values('"+counterypartyId+"')";
    try {
		myStmt.executeUpdate(temporary);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


}
public ArrayList<Counterparty> getRandomCIFRecord(Connection myconn, int numberData, ArrayList<Counterparty> con) {
	 try {
		myStmt=myconn.createStatement();
		String sql = "SELECT * FROM counterparty where reportingEntityId = '001' ORDER BY RAND() LIMIT "+numberData;
		ResultSet rs = myStmt.executeQuery(sql);
		Counterparty cp;
	    while(rs.next()){
	         //Retrieve by column name
	    	 cp =  new Counterparty();
				cp.setReportingEntityId(rs.getString("reportingEntityId"));
		    	cp.setCounterypartyId(rs.getString("counterpartyId"));
			 	cp.setName(rs.getString("name"));
			    cp.setDate(rs.getString("dateOfBirthOrIncorporation"));
			 	cp.setCasteGen(rs.getString("caste"));
			    cp.setCommGen(rs.getString("community"));
			    cp.setPan(rs.getString("pan"));
			 	cp.setAdharNo(rs.getString("aadhaar"));
			 	cp.setDin(rs.getString("din"));
			 	cp.setCin(rs.getString("cin"));
			 	cp.setLei(rs.getString("lei"));
				cp.setTan(rs.getString("tan"));
				cp.setGstin(rs.getString("gstin"));
				cp.setUdyogAadhaar(rs.getString("udyogAadhaar"));
				cp.setTypeOrg(rs.getString("typeOfOrganisation"));
				cp.setBurrrower(rs.getString("borrowerCategory"));
			 	cp.setNicCode(rs.getString("sicOrNicCode"));
			 	cp.setOccupationCode(rs.getString("occupationCode"));
			 	cp.setAddressLine1(rs.getString("addressLine1"));
			 	cp.setAddressLine2(rs.getString("addressLine2"));
			 	cp.setAddressLine3(rs.getString("addressLine3"));
			 	cp.setPinCode(rs.getString("pinCode"));
			    cp.setStateCode(rs.getString("stateCode"));
			    cp.setDistrictCode(rs.getString("districtCode"));
			    cp.setCountryCode(rs.getString("countryCode"));
			    cp.setTelePhoneNumber(rs.getString("telephoneNumber"));
			    cp.setMobNo(rs.getString("mobileNumber"));
			    cp.setEmailAddress(rs.getString("emailAddress"));	
	         con.add(cp);
	         cp = null;
	      }
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return con;
}
public ArrayList<Counterparty> getPANInformation(Connection myconn,
		ArrayList<Counterparty> con) {
	GenericXLSXReader xlsx =  new GenericXLSXReader(System.getProperty("user.dir")+"\\Data\\Existing PAN.xlsx");
	ArrayList<String> pan = DataUtil.getPanNumbers(xlsx);
	
	for(String panNo : pan){
		 try {
				myStmt=myconn.createStatement();
				String sql = "SELECT * FROM counterparty where pan = '"+panNo+"'";
				ResultSet rs = myStmt.executeQuery(sql);
				Counterparty cp;
			    while(rs.next()){
			         //Retrieve by column name
			    	 cp =  new Counterparty();
						cp.setReportingEntityId("");
				    	cp.setCounterypartyId("");
					 	cp.setName(rs.getString("name"));
					    cp.setDate(rs.getString("dateOfBirthOrIncorporation"));
					 	cp.setCasteGen(rs.getString("caste"));
					    cp.setCommGen(rs.getString("community"));
					    cp.setPan(rs.getString("pan"));
					 	cp.setAdharNo(rs.getString("aadhaar"));
					 	cp.setDin(rs.getString("din"));
					 	cp.setCin(rs.getString("cin"));
					 	cp.setLei(rs.getString("lei"));
						cp.setTan(rs.getString("tan"));
						cp.setGstin(rs.getString("gstin"));
						cp.setUdyogAadhaar(rs.getString("udyogAadhaar"));
						cp.setTypeOrg(rs.getString("typeOfOrganisation"));
						cp.setBurrrower(rs.getString("borrowerCategory"));
					 	cp.setNicCode(rs.getString("sicOrNicCode"));
					 	cp.setOccupationCode(rs.getString("occupationCode"));
					 	cp.setAddressLine1(rs.getString("addressLine1"));
					 	cp.setAddressLine2(rs.getString("addressLine2"));
					 	cp.setAddressLine3(rs.getString("addressLine3"));
					 	cp.setPinCode(rs.getString("pinCode"));
					    cp.setStateCode(rs.getString("stateCode"));
					    cp.setDistrictCode(rs.getString("districtCode"));
					    cp.setCountryCode(rs.getString("countryCode"));
					    cp.setTelePhoneNumber(rs.getString("telephoneNumber"));
					    cp.setMobNo(rs.getString("mobileNumber"));
					    cp.setEmailAddress(rs.getString("emailAddress"));	
			         con.add(cp);
			         cp = null;
			      }
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}	
	}
		return con;
}
public ArrayList<String> extracttempTableinformation(Connection myconn,String tableName) {
	String extract="select * from "+tableName+"";
		ResultSet myRs;
		ArrayList<String> extractData = null;
		try {
			myRs = myStmt.executeQuery(extract);
			
			while(myRs.next()) {
				String tempcid = myRs.getString("counterpartyId");
				extractData.add(tempcid);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return extractData;
}
public void destroytable(Connection myconn,String tableName) {
	String extract="delete from"+ tableName;
		
		
		try {
			 myStmt.executeQuery(extract);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}