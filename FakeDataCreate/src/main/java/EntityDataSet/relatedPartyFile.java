package EntityDataSet;

import java.util.ArrayList;

import ReUsable.ReadWrite;
import ReUsable.datacreation;
import Utilities.DataUtil;
import pojoClases.Contract;
import pojoClases.Counterparty;
import pojoClases.relatedParty;

public class relatedPartyFile extends BaseClass{
	public ArrayList<relatedParty> createRelatedPartyData(ArrayList<Counterparty> counterpartyData) {
		
		ArrayList<relatedParty> con =  new ArrayList<>();
		ReadWrite rw =  new ReadWrite();
		ArrayList<Integer> allIndexes = null;
		ArrayList<Integer> skippedData = null;
		ArrayList<String> Relno =  new ArrayList<>();
		 
		  int count = 0;
		 relatedParty rel ;
		if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory")||configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional"))
		{
			if(configurationData.get("MultipleDataGenerationFor_RelatedParty").equalsIgnoreCase("Yes")) 
			{
			fieldValues = DataUtil.getFieldValue("MasterData", xls);
			 for(Counterparty counterparty: counterpartyData) {
			    create = new datacreation();
			     rel = new relatedParty();
				count++;
				if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory"))
				{
					
					allIndexes =rw.uniqunumber(configurationData.get("TotalNo_counterpartyId_repeated_RelatedPartyFile") ,configurationData.get("NoOfData"));
					if(allIndexes.contains(count)) {
						
						int z = ut.completeinteger(configurationData.get("No_individual_counterpartyId_repeated_inRelatedPartyFile"));
						int m =  faker.number().numberBetween(1,z );
						for(int k = 1;k<=m;k++) {
							rel  =  new relatedParty();
					if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Mandatory")) {
						  rel.setReportingEntityId(counterparty.getReportingEntityId());
			    	}else
			    		rel.setReportingEntityId("");
			    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Mandatory")) {
			    		rel.setCounterpartyId(counterparty.getCounterypartyId());
			    	}else
			    		rel.setCounterpartyId("");
			    	if(fieldValues.get("relatedCounterpartyID").equalsIgnoreCase("Mandatory")) {
			    		 rel.setRelatedCounterpartyID(create.createRelatedCounterepartyId());
			    	}else
			    		 rel.setRelatedCounterpartyID("");
			    	con.add(rel);
			    	
				}}
					else
					{
						
						rel  =  new relatedParty();
						if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Mandatory")) {
							  rel.setReportingEntityId(counterparty.getReportingEntityId());
				    	}else
				    		rel.setReportingEntityId("");
				    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Mandatory")) {
				    		rel.setCounterpartyId(counterparty.getCounterypartyId());
				    	}else
				    		rel.setCounterpartyId("");
				    	if(fieldValues.get("relatedCounterpartyID").equalsIgnoreCase("Mandatory")) {
				    		 rel.setRelatedCounterpartyID(create.createRelatedCounterepartyId());
				    	}else
				    		 rel.setRelatedCounterpartyID("");
				    	con.add(rel);
					}}
				 if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional")) {
					 
					 allIndexes =rw.uniqunumber(configurationData.get("TotalNo_counterpartyId_repeated_RelatedPartyFile") ,configurationData.get("NoOfData"));
						if(allIndexes.contains(count)) {
							
							int z = ut.completeinteger(configurationData.get("No_individual_counterpartyId_repeated_inRelatedPartyFile"));
							int m =  faker.number().numberBetween(1,z );
							for(int k = 1;k<=m;k++) {
								rel  =  new relatedParty();
					 
				 
					 if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Optional")) {
						  rel.setReportingEntityId(counterparty.getReportingEntityId());
			    	}else
			    		rel.setReportingEntityId("");
			    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Optional")) {
			    		rel.setCounterpartyId(counterparty.getCounterypartyId());
			    	}else
			    		rel.setCounterpartyId("");
			    	if(fieldValues.get("relatedCounterpartyID").equalsIgnoreCase("Optional")) {
			    		 rel.setRelatedCounterpartyID(create.createRelatedCounterepartyId());
			    	}else
			    		 rel.setRelatedCounterpartyID("");
				 
				 con.add(rel);
				 rel = null;
				 create=null;
	}
		}
						else
						{
							rel  =  new relatedParty();
							if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Optional")) {
								rel.setReportingEntityId(counterparty.getReportingEntityId());
								}else
								rel.setReportingEntityId("");
								if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Optional")) {
								rel.setCounterpartyId(counterparty.getCounterypartyId());
								}else
								rel.setCounterpartyId("");
								if(fieldValues.get("relatedCounterpartyID").equalsIgnoreCase("Optional")) {
								rel.setRelatedCounterpartyID(create.createRelatedCounterepartyId());
								}else
								rel.setRelatedCounterpartyID("");
								con.add(rel);
						}}}}
			else {
				
				for(Counterparty counterparty: counterpartyData) {
					create = new datacreation();
				rel = new relatedParty();
				if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory"))
				{
					if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Mandatory")) {
						  rel.setReportingEntityId(counterparty.getReportingEntityId());
			    	}else
			    		rel.setReportingEntityId("");
			    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Mandatory")) {
			    		rel.setCounterpartyId(counterparty.getCounterypartyId());
			    	}else
			    		rel.setCounterpartyId("");
			    	if(fieldValues.get("relatedCounterpartyID").equalsIgnoreCase("Mandatory")) {
			    		 rel.setRelatedCounterpartyID(create.createRelatedCounterepartyId());
			    	}else
			    		 rel.setRelatedCounterpartyID("");
			    	
				}
				 if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional")) {
					 if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Optional")) {
						  rel.setReportingEntityId(counterparty.getReportingEntityId());
			    	}else
			    		rel.setReportingEntityId("");
			    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Optional")) {
			    		rel.setCounterpartyId(counterparty.getCounterypartyId());
			    	}else
			    		rel.setCounterpartyId("");
			    	if(fieldValues.get("relatedCounterpartyID").equalsIgnoreCase("Optional")) {
			    		 rel.setRelatedCounterpartyID(create.createRelatedCounterepartyId());
			    	}else
			    		 rel.setRelatedCounterpartyID("");
				 }
				 con.add(rel);
				 rel = null;
				 create=null;
			}}}
			

		else if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Both")) {
			 
			if(configurationData.get("MultipleDataGenerationFor_RelatedParty").equalsIgnoreCase("Yes")) {
				 allIndexes =rw.uniqunumber(configurationData.get("TotalNo_counterpartyId_repeated_RelatedPartyFile") ,configurationData.get("NoOfData"));
				 skippedData =rw.uniqunumberfrSkippedData(configurationData.get("indexes_of_skippedData"),configurationData.get("NoOfData"),allIndexes);
				 System.out.println(allIndexes);
				 System.out.println(skippedData);
				// int count=0;
				 String counterPartyId;
			
				 for(Counterparty counterparty: counterpartyData) {
				
					count++;
				  String reportingEntityid = counterparty.getReportingEntityId();
				  counterPartyId =counterparty.getCounterypartyId() ;
				 if(allIndexes.contains(count)) {
					 
						int z = ut.completeinteger(configurationData.get("No_individual_counterpartyId_repeated_inRelatedPartyFile"));
							//using faker create randomenumber from 1to z
							int m =  faker.number().numberBetween(1,z );
							for(int k = 1;k<=m;k++) {
								create = new datacreation();
								rel = new relatedParty();
								 rel.setReportingEntityId(reportingEntityid);
								 rel.setCounterpartyId(counterPartyId);
								 //rel.setRelatedCounterpartyID(create.createRelatedCounterepartyId());
								 String RelNo = duplicatecheck.createUniqueRelNew(Relno,create);
						    		rel.setRelatedCounterpartyID(RelNo);
						    		Relno.add(RelNo);
							
								 rel.setRelation(create.createRelation());
							con.add(rel);
							
								
							}	
						}
				 else if (skippedData.contains(count)) {
					 continue;
				 }
				 else 
					{
						create = new datacreation();
						rel = new relatedParty();
						 rel.setReportingEntityId(reportingEntityid);
						 rel.setCounterpartyId(counterPartyId);
						 //rel.setRelatedCounterpartyID(create.createRelatedCounterepartyId());
						 String RelNo = duplicatecheck.createUniqueRelNew(Relno,create);
				    		rel.setRelatedCounterpartyID(RelNo);
				    		Relno.add(RelNo);
						 rel.setRelation(create.createRelation());
					con.add(rel);
					}
					rel=null;
					create=null;
			 }}
			
			 else {
				 int co = 0;
				 skippedData =rw.uniqunumberfrSkippedData(configurationData.get("indexes_of_skippedData"),configurationData.get("NoOfData"), null);
				 for (Counterparty counterparty:counterpartyData ) {
					 
					 co++;
					 if(skippedData.contains(co)) {
						 continue;
					 }
					create = new datacreation();
					rel = new relatedParty();
					rel.setReportingEntityId(counterparty.getReportingEntityId());
					 rel.setCounterpartyId(counterparty.getCounterypartyId());
					 //rel.setRelatedCounterpartyID(create.createRelatedCounterepartyId());
					 String RelNo = duplicatecheck.createUniqueRelNew(Relno,create);
			    	 rel.setRelatedCounterpartyID(RelNo);
			    	 Relno.add(RelNo);
					 rel.setRelation(create.createRelation());
				con.add(rel);
					
					rel=null;
					create=null;
				 }}}
		return con;
			 }

}





