package EntityDataSet;

import java.util.ArrayList;
import java.util.Collections;

import ReUsable.datacreation;
import Utilities.DataUtil;
import pojoClases.Contract;
import pojoClases.Instrument;

public class InstrumentFile extends BaseClass{
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
}
