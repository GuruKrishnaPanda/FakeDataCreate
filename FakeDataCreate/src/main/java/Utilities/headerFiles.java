package Utilities;

public class headerFiles {
	
	public static String[] contractHeader(){
		
		String[] contractHeader = {"reportingEntityId","contractId","instrumentId","counterypartyId"};
		return contractHeader;
	}
	public static String[] counterPartyHeader(){
		
		String[] counterPartyHeader = {"reportingEntityId",
				"counterpartyId",
				"name",
				"dateOfBirthOrIncorporation",
				"caste",
				"community",
				"pan",
				"aadhaar",
				"din",
				"cin",
				"lei",
				"tan",
				"gstin",
				"udyogAadhaar",
				"typeOfOrganisation",
				"borrowerCategory",
				"sicOrNicCode",
				"occupationCode",
				"addressLine1",
				"addressLine2",
				"addressLine3",
				"pinCode",
				"stateCode",
				"districtCode",
				"countryCode",
				"telephoneNumber",
				"mobileNumber",
				"emailAddress"};
		return counterPartyHeader;
	}
	public static String[] CounterpartyRating(){
		
		String[] counterpartyRatingHeader = {
				"counterpartyRatingId",
				"counterpartyId",
				"ratingId",
				"creditRating",
				"assessmentAgencyOrAuthority",
				"creditRatingAsOn",
				"creditRatingExpiryDate"};
		
		return counterpartyRatingHeader;
	}
	public static String[] CounterpartyRisk(){
		
		String[] counterpartyRiskHeader = {
				"reportingEntityId",
				"counterpartyId",
				"statusOfInsolvencyProceedings",
				"dateOfInitiationOfInsolvencyProceedings",
				"wilfulDefaulter",
				"dateOfWilfulDefaulterClassification",
				"nonCooperativeBorrower",
				"dateOfNonCooperativeBorrowerClassification",
				"fraudulentActivity",
				"dateOfFraudulentActivityClassification",
				"internalRating",
				"dateOfInternalRating"
		};
		
		return counterpartyRiskHeader;
	}
	public static String[] Instrument(){
	
		String[] instrumentHeader = {"reportingEntityID",
				"instrumentId",
				"branchCode",
				"contractId",
				"districtOfUtilisation",
				"instrumentType",
				"prioritySector",
				"weakerSection",
				"classificationOfActivity",
				"sanctionedDate",
				"disbursementDate",
				"maturityDate",
				"currencyCode",
				"originalSanctionAmount",
				"syndicatedContractId",
				"recourse",
				"interestRateType",
				"amortisationType",
				"paymentFrequency",
				"interestRate",
				"weightedAverageInterestRate",
				"instalmentAmount",
				"balanceOutstanding",
				"unavailedAmount",
				"offBalanceSheetNominalAmount",
				"creditEquivalentOfOffBalanceSheetNominalAmount",
				"accruedInterest",
				"amountOverdue",
				"numberOfDaysPastDue",
				"smaCategory",
				"smaCurrentCategorySinceDate",
				"npaCategory",
				"npaSinceDate",
				"cumulativeRecoveriesSinceNpa",
				"accumulatedProvisions",
				"accumulatedWriteOffs",
				"settlementAmount",
				"restructuringStatus",
				"restructuringStatusDate",
				"status",
				"statusDate",
				"suitFiledDate"};
	
	return instrumentHeader;
}
	public static String[] Protection(){

		String[] protectionHeader = {"reportingEntityId",
		"protectionId",
		"protectionProviderId",
		"typeOfProtection",
		"currencyType",
		"protectionValue",
		"typeOfProtectionValue",
		"protectionValuationApproach",
		"dateOfProtectionValue",
		"originalProtectionValue",
		"dateOfOriginalProtectionValue",
		"protectionRegistryId",
		"protectionExternalId"};

		return protectionHeader;
}
	public static String[] ProtectionInstrument(){
	
		String[] protectionInstrumentHeader = {"reportingEntityId",
				"instrumentId",
				"contractId",
				"protectionAllocatedValue",
				"protectionId",
				"chargeType"
				};

		return protectionInstrumentHeader;
	
}
	public static String[] RelatedParty(){
	
		String[] relatedPartyHeader = {"reportingEntityId",
				"counterpartyId",
			
				"relatedCounterpartyId"};

		
		return relatedPartyHeader;
}

}
