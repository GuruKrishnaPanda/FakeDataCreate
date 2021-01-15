package EntityDataSet;

import java.util.ArrayList;
import java.util.Collections;

import ReUsable.datacreation;
import Utilities.DataUtil;
import pojoClases.Counterparty;
import pojoClases.counterpartyRisk;

public class counterpartyRiskFile extends BaseClass {
public ArrayList<counterpartyRisk> createCounterpartyRiskData(ArrayList<Counterparty> counterpartyData) {
		
		ArrayList<counterpartyRisk> con =  new ArrayList<>();
		if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory")||configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional"))
     	{
     		fieldValues = DataUtil.getFieldValue("MasterData", xls);
     		 for(Counterparty counterparty: counterpartyData)  {
			 	create = new datacreation();
			 	counterpartyRisk cr  =  new counterpartyRisk();
			 	
			 	if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory"))
				{
					if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Mandatory")) {
						cr.setReportingEntityId(counterparty.getReportingEntityId());
			    	}else
			    		cr.setReportingEntityId("");
			    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Mandatory")) {
			    	 	cr.setCounterpartyId(counterparty.getCounterypartyId());
			    	}else
			    		cr.setCounterpartyId("");
			    	if(fieldValues.get("statusOfInsolvencyProceedings").equalsIgnoreCase("Mandatory")) {
			    		cr.setStatusOfInsolvencyProceedings(create.createStatusOfInsolvencyProceedings());
			    	}else
			    		cr.setStatusOfInsolvencyProceedings("");
			    	if(fieldValues.get("dateOfInitiationOfInsolvencyProceedings").equalsIgnoreCase("Mandatory")) {
			    		cr.setDateOfInitiationOfInsolvencyProceedings(create.dateOfInitiationOfInsolvencyProceedings());
			    	}else
			    		cr.setDateOfInitiationOfInsolvencyProceedings("");
			    	if(fieldValues.get("wilfulDefaulter").equalsIgnoreCase("Mandatory")) {
			    		cr.setWilfulDefaulter(create.createwilfulDefaulter());
			    	}else
			    		cr.setWilfulDefaulter("");
			    	if(fieldValues.get("dateOfWilfulDefaulterClassfication").equalsIgnoreCase("Mandatory")) {
			    		cr.setDateOfWilfulDefaulterClassification(create.dateOfWilfulDefaulterClassification());
			    	}else
			    		cr.setDateOfWilfulDefaulterClassification("");
			    	if(fieldValues.get("nonCooperativeBorrower").equalsIgnoreCase("Mandatory")) {
			    		cr.setNonCooperativeBorrower(create.createnonCooperativeBorrower());
			    	}else
			    		cr.setNonCooperativeBorrower("");
			    	if(fieldValues.get("dateOfNonCooperativeBorrowerClassification").equalsIgnoreCase("Mandatory")) {
			    		cr.setDateOfNonCooperativeBorrowerClassification(create.dateOfNonCooperativeBorrowerClassification());
			    	}else
			    		cr.setDateOfNonCooperativeBorrowerClassification("");
			    	if(fieldValues.get("fradulentActivity").equalsIgnoreCase("Mandatory")) {
			    		cr.setFradulentActivity(create.createFradulentActivity());
			    	}else
			    		cr.setFradulentActivity("");
			    	if(fieldValues.get("dateOfFradulentActivityClassification").equalsIgnoreCase("Mandatory")) {
			    		cr.setDateOfFradulentActivityClassification(create.dateOfFradulentActivityClassification());
			    	}else
			    		cr.setDateOfFradulentActivityClassification("");
			    	if(fieldValues.get("internalRating").equalsIgnoreCase("Mandatory")) {
			    		cr.setInternalRating(create.createinternalRating());
			    	}else
			    		cr.setInternalRating("");
			    	if(fieldValues.get("dateOfInternalRating").equalsIgnoreCase("Mandatory")) {
			    		cr.setDateOfInternalRating(create.dateOfInternalRating());
			    	}else
			    		cr.setDateOfInternalRating("");
			    		
				}
				 if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional")) {
					 if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Optional")) {
							cr.setReportingEntityId(counterparty.getReportingEntityId());
				    	}else
				    		cr.setReportingEntityId("");
				    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Optional")) {
				    	 	cr.setCounterpartyId(counterparty.getCounterypartyId());
				    	}else
				    		cr.setCounterpartyId("");
				    	if(fieldValues.get("statusOfInsolvencyProceedings").equalsIgnoreCase("Optional")) {
				    		cr.setStatusOfInsolvencyProceedings(create.createStatusOfInsolvencyProceedings());
				    	}else
				    		cr.setStatusOfInsolvencyProceedings("");
				    	if(fieldValues.get("dateOfInitiationOfInsolvencyProceedings").equalsIgnoreCase("Optional")) {
				    		cr.setDateOfInitiationOfInsolvencyProceedings(create.dateOfInitiationOfInsolvencyProceedings());
				    	}else
				    		cr.setDateOfInitiationOfInsolvencyProceedings("");
				    	if(fieldValues.get("wilfulDefaulter").equalsIgnoreCase("Optional")) {
				    		cr.setWilfulDefaulter(create.createwilfulDefaulter());
				    	}else
				    		cr.setWilfulDefaulter("");
				    	if(fieldValues.get("dateOfWilfulDefaulterClassfication").equalsIgnoreCase("Optional")) {
				    		cr.setDateOfWilfulDefaulterClassification(create.dateOfWilfulDefaulterClassification());
				    	}else
				    		cr.setDateOfWilfulDefaulterClassification("");
				    	if(fieldValues.get("nonCooperativeBorrower").equalsIgnoreCase("Optional")) {
				    		cr.setNonCooperativeBorrower(create.createnonCooperativeBorrower());
				    	}else
				    		cr.setNonCooperativeBorrower("");
				    	if(fieldValues.get("dateOfNonCooperativeBorrowerClassification").equalsIgnoreCase("Optional")) {
				    		cr.setDateOfNonCooperativeBorrowerClassification(create.dateOfNonCooperativeBorrowerClassification());
				    	}else
				    		cr.setDateOfNonCooperativeBorrowerClassification("");
				    	if(fieldValues.get("fradulentActivity").equalsIgnoreCase("Optional")) {
				    		cr.setFradulentActivity(create.createFradulentActivity());
				    	}else
				    		cr.setFradulentActivity("");
				    	if(fieldValues.get("dateOfFradulentActivityClassification").equalsIgnoreCase("Optional")) {
				    		cr.setDateOfFradulentActivityClassification(create.dateOfFradulentActivityClassification());
				    	}else
				    		cr.setDateOfFradulentActivityClassification("");
				    	if(fieldValues.get("internalRating").equalsIgnoreCase("Optional")) {
				    		cr.setInternalRating(create.createinternalRating());
				    	}else
				    		cr.setInternalRating("");
				    	if(fieldValues.get("dateOfInternalRating").equalsIgnoreCase("Optional")) {
				    		cr.setDateOfInternalRating(create.dateOfInternalRating());
				    	}else
				    		cr.setDateOfInternalRating("");
				 }
				 con.add(cr);
				 cr = null;
				 create=null;	
     		}
     	}else  if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Both")) {
     		for(Counterparty counterparty: counterpartyData) {
			 	create = new datacreation();
			 	counterpartyRisk cr  =  new counterpartyRisk();
			 	
			 	cr.setReportingEntityId(counterparty.getReportingEntityId());
			 	cr.setCounterpartyId(counterparty.getCounterypartyId());
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
			 cr = null;
			 create=null;	
     		}
     	}
     	 Collections.shuffle(con);
     	 return con;
	}
}
