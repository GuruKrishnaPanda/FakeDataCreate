package Utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.security.auth.login.Configuration;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

//import ReUsable.settingEntityDataSet;
import pojoClases.Contract;
import pojoClases.Counterparty;
import pojoClases.Instrument;
import pojoClases.Protection;
import pojoClases.counterpartyRating;
import pojoClases.counterpartyRisk;
import pojoClases.protectionInstrument;
import pojoClases.relatedParty;

public class JSONobject {

	
	public static void JsonFileCreation(ArrayList<Contract> contractData, ArrayList<Counterparty> counterpartyData,
			ArrayList<counterpartyRating> counterpartyRatingData, ArrayList<counterpartyRisk> counterpartyRiskData,
			ArrayList<Protection> ProtectionData, ArrayList<protectionInstrument> protectionInstrumentData,
			ArrayList<relatedParty> relatedPartyData, ArrayList<Instrument> instrumentData)
	
 {  
		GenericXLSXReader xls = new GenericXLSXReader(System.getProperty("user.dir")+"\\resources\\Configuration.xlsx");
		Hashtable<String, String> configurationData = DataUtil.getData("Configuration", xls);
		
	JSONObject pcrData;
	JSONObject pcrDataObject;
	JSONArray pcrDataList = new JSONArray();
	 if(configurationData.get("Json_File").equalsIgnoreCase("Yes"))
	 {
	for (int i =0;i<=contractData.size()-1;i++){
	pcrData = new JSONObject();
	pcrData.put("reportingEntityId", contractData.get(i).getReportingEntityId());
	pcrData.put("contractId",contractData.get(i).getContractId());
	pcrData.put("instrumentId",contractData.get(i).getInstrumentId());
	pcrData.put("counterypartyId",contractData.get(i).getCounterypartyId());
	pcrData.put("name",counterpartyData.get(i).getName());
	pcrData.put("dateOfBirthOrIncorporation", counterpartyData.get(i).getDate());
	pcrData.put("caste",counterpartyData.get(i).getCasteGen());
	pcrData.put("community", counterpartyData.get(i).getCommGen());
	pcrData.put("pan",counterpartyData.get(i).getPan());
	pcrData.put("aadhaar",counterpartyData.get(i).getAdharNo());
	pcrData.put("din",counterpartyData.get(i).getDin());
	pcrData.put("cin",counterpartyData.get(i).getCin());
	pcrData.put("lei",counterpartyData.get(i).getLei());
	pcrData.put("tan",counterpartyData.get(i).getTan());
	pcrData.put("gstin",counterpartyData.get(i).getGstin());
	pcrData.put("udyogAadhaar",counterpartyData.get(i).getUdyogAadhaar());
	pcrData.put("typeOfOrganisation",counterpartyData.get(i).getTypeOrg());
	pcrData.put("borrowerCategory",counterpartyData.get(i).getBurrrower());
	pcrData.put("sicOrNicCode",counterpartyData.get(i).getNicCode());
	pcrData.put("occupationCode",counterpartyData.get(i).getOccupationCode());
	pcrData.put("addressLine1",counterpartyData.get(i).getAddressLine1());
	pcrData.put("addressLine2",counterpartyData.get(i).getAddressLine2());
	pcrData.put("addressLine3",counterpartyData.get(i).getAddressLine3());
	pcrData.put("pinCode",counterpartyData.get(i).getPinCode());
	pcrData.put("stateCode",counterpartyData.get(i).getStateCode());
	pcrData.put("districtCode",counterpartyData.get(i).getDistrictCode());
	pcrData.put("countryCode",counterpartyData.get(i).getCountryCode());
	pcrData.put("telephoneNumber",counterpartyData.get(i).getTelePhoneNumber());
	pcrData.put("mobileNumber",counterpartyData.get(i).getMobNo());
	pcrData.put("emailAddress",counterpartyData.get(i).getEmailAddress());
	pcrData.put("ratingId", counterpartyRatingData.get(i).getRatingID());
	pcrData.put("creditRating", counterpartyRatingData.get(i).getCreditRating());
	pcrData.put("assessmentAgencyOrAuthority", counterpartyRatingData.get(i).getAssessmentAgencyAuthority());
	pcrData.put("creditRatingAsOn", counterpartyRatingData.get(i).getCreditRatingAsOn());
	pcrData.put("creditRatingExpiryDate", counterpartyRatingData.get(i).getCreditRatingExpiryDate());
	pcrData.put("counterpartyId",counterpartyRiskData.get(i).getCounterpartyId());
	pcrData.put("statusOfInsolvencyProceedings",counterpartyRiskData.get(i).getStatusOfInsolvencyProceedings());
	pcrData.put("dateOfInitiationOfInsolvencyProceeding", counterpartyRiskData.get(i).getDateOfInitiationOfInsolvencyProceedings());
	pcrData.put("wilfulDefaulter",counterpartyRiskData.get(i).getWilfulDefaulter());
	pcrData.put("dateOfWilfulDefaulterClassificationr",counterpartyRiskData.get(i).getDateOfWilfulDefaulterClassification());
	pcrData.put("NonCooperativeBorrower",counterpartyRiskData.get(i).getNonCooperativeBorrower());
	pcrData.put("DateOfNonCooperativeBorrowerClassification",counterpartyRiskData.get(i).getDateOfNonCooperativeBorrowerClassification());
	pcrData.put("FradulentActivity",counterpartyRiskData.get(i).getFradulentActivity());
	pcrData.put("DateOfFradulentActivityClassification",counterpartyRiskData.get(i).getDateOfFradulentActivityClassification()); 
	pcrData.put("InternalRating",counterpartyRiskData.get(i).getInternalRating());
	pcrData.put("DateOfInternalRating",counterpartyRiskData.get(i).getDateOfInternalRating());
	pcrData.put("branchCode", instrumentData.get(i).getBranchCode());
	pcrData.put("districtOfUtilisation", instrumentData.get(i).getDistrictOfUtilisation());
	pcrData.put("instrumentType", instrumentData.get(i).getInstrumentId());
	pcrData.put("prioritySector", instrumentData.get(i).getPrioritySector());
	pcrData.put("weakerSection", instrumentData.get(i).getWeakerSection());
	pcrData.put("classificationOfActivity", instrumentData.get(i).getClassificationOfActivity());
	pcrData.put("sanctionedDate", instrumentData.get(i).getSanctionDate());
	pcrData.put("disbursementDate", instrumentData.get(i).getDisbursementDate());
	pcrData.put("currencyCode", instrumentData.get(i).getCurrencyCode());
	pcrData.put("originalSanctionAmount", instrumentData.get(i).getOrgsanAmmnt());
	pcrData.put("syndicatedContractId", instrumentData.get(i).getSyndcateContactId());
	pcrData.put("recourse", instrumentData.get(i).getRecourse());
	pcrData.put("interestRateType", instrumentData.get(i).getInterestRateType());
	pcrData.put("amortisationType", instrumentData.get(i).getAmortisationType());
	pcrData.put("paymentFrequency", instrumentData.get(i).getPaymentFrequency());
	pcrData.put("interestRate", instrumentData.get(i).getInterRate());
	pcrData.put("weightedAverageInterestRate", instrumentData.get(i).getWeightedAverageInterestRate());
	pcrData.put("instalmentAmount", instrumentData.get(i).getInstallAmnt());
	pcrData.put("balanceOutstanding", instrumentData.get(i).getBalanceOutstanding());
	pcrData.put("unavailedAmount", instrumentData.get(i).getUnvailedAmmount());
	pcrData.put("offBalanceSheetNominalAmount", instrumentData.get(i).getOffBalMinAmnt());
	pcrData.put("creditEquivalentOfOffBalanceSheetNominalAmount", instrumentData.get(i).getCrediteqibaloff());
	pcrData.put("accruedInterest", instrumentData.get(i).getAccuInterst());
	pcrData.put("amountOverdue", instrumentData.get(i).getAmntOver());
	pcrData.put("numberOfDaysPastDue", instrumentData.get(i).getNumPastDue());
	pcrData.put("SmaCatogry",instrumentData.get(i).getSmaCatogry());
	pcrData.put("smaCurrentCategorySinceDate",instrumentData.get(i).getSmaCurrentCatg());
	pcrData.put("npaCategory",instrumentData.get(i).getNpaCatgCode());
	pcrData.put("npaSinceDate",instrumentData.get(i).getNpaSinDate());
	pcrData.put("cumulativeRecoveriesSinceNpa",instrumentData.get(i).getCummRecovSinNpa());
	pcrData.put("accumulatedProvisions",instrumentData.get(i).getAccProviosions());
	pcrData.put("accumulatedWriteOffs",instrumentData.get(i).getAccWriteOffs());
	pcrData.put("settlementAmount",instrumentData.get(i).getSettAmmount());
	pcrData.put("restructuringStatus",instrumentData.get(i).getRestStatus());
	pcrData.put("restructuringStatusDate",instrumentData.get(i).getRestDate());
	pcrData.put("AccountStatus",instrumentData.get(i).getAccountStatus());
	pcrData.put("statusDate",instrumentData.get(i).getStatusDate());
	pcrData.put("suitFiledDate",instrumentData.get(i).getSuitFielDate());
	pcrData.put("protectionId", ProtectionData.get(i).getProtectionId());
	pcrData.put("protectionProviderId", ProtectionData.get(i).getProtectionProviderId());
	pcrData.put("typeOfProtection", ProtectionData.get(i).getTypeOfProtection());
	pcrData.put("currencyType", ProtectionData.get(i).getCurrencyType());
	pcrData.put("protectionValue", ProtectionData.get(i).getProtectionValue());
	pcrData.put("typeOfProtectionValue", ProtectionData.get(i).getTypeOfProtectionValue());
	pcrData.put("protectionValuationApproach", ProtectionData.get(i).getProtectionValuationApproach());
	pcrData.put("dateOfProtectionValue", ProtectionData.get(i).getDateOfProtectionValue());
	pcrData.put("originalProtectionValue", ProtectionData.get(i).getOriginalProtectionValue());
	pcrData.put("dateOfOriginalProtectionValue", ProtectionData.get(i).getDateOfOriginalProtectionValue());
	pcrData.put("protectionRegistryId", ProtectionData.get(i).getProtectionRegistryId());
	pcrData.put("protectionExternalId", ProtectionData.get(i).getProtectionExternalId());
	pcrData.put("protectionAllocatedValue",  protectionInstrumentData.get(i).getProtectionAllocatedValue());
	pcrData.put("chargeType", protectionInstrumentData.get(i).getChargeType());
	pcrData.put("relatedCounterpartyId", relatedPartyData.get(i).getRelatedCounterpartyID());
	

	    pcrDataObject = new JSONObject();
	    pcrDataObject.put("pcrdata", pcrData);
	    pcrDataList.add(pcrDataObject);
	   
	    }
	    //Write JSON file
	    try (FileWriter file = new FileWriter("pcrData.json")) {

	        file.write(pcrDataList.toString());
	        file.flush();

	    } catch (IOException e) {
	        e.printStackTrace();
	    }}
	   
	}

	public static void main(String[] args)  
	{
		GenericXLSXReader xls = new GenericXLSXReader(System.getProperty("user.dir")+"\\resources\\Configuration.xlsx");
		 String  totalRecords = xls.getCellData("Configuration",1, 2);
		 double f1=Double.parseDouble(totalRecords);
			int numberData=(int)f1;

		//int numberData = 100;
		JSONobject rw=  new JSONobject();
		//settingEntityDataSet eds =  new settingEntityDataSet();
		
		/*ArrayList<Counterparty> counterpartyData = eds.createCounterPartyData(numberData);
		ArrayList<Contract> contractData = eds.createContractData(counterpartyData);
		ArrayList<Instrument> instrumentData= eds.createInstrumentData(contractData);
		ArrayList<protectionInstrument> protectionInstrumentData = eds.createProtectionInstrumentData(instrumentData);
		ArrayList<relatedParty> relatedPartyData = eds.createRelatedPartyData(counterpartyData);
		ArrayList<Protection> ProtectionData = eds.createProtectionData(protectionInstrumentData);
		ArrayList<counterpartyRisk> counterpartyRiskData = eds.createCounterpartyRiskData(counterpartyData);
		ArrayList<counterpartyRating> counterpartyRatingData= eds.createcounterpartyRatingData(counterpartyData);*/
	
		//rw.JsonFileCreation(ArrayList<Contract> ,ArrayList<Counterparty> ,ArrayList<counterpartyRating> ,ArrayList<counterpartyRisk> ,ArrayList<Protection> , ArrayList<protectionInstrument> ,ArrayList<relatedParty> ,ArrayList<Instrument>);
		//JsonFileCreation(contractData, counterpartyData, counterpartyRatingData, counterpartyRiskData, ProtectionData, protectionInstrumentData, relatedPartyData, instrumentData);
	      //JsonFileCreation(contractData, counterpartyData, counterpartyRatingData, counterpartyRiskData, ProtectionData, protectionInstrumentData, relatedPartyData, instrumentData);
	}

}