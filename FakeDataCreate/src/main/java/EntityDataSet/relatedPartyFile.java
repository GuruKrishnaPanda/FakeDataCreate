package EntityDataSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

import ReUsable.ReadWrite;
import ReUsable.datacreation;
import Utilities.DataUtil;
import pojoClases.Contract;
import pojoClases.Counterparty;
import pojoClases.relatedParty;

public class relatedPartyFile extends BaseClass{
	public relatedPartyFile(Hashtable<String, String> data) {
		super(data);
	}

	/*public ArrayList<relatedParty> createRelatedPartyData(ArrayList<Counterparty> counterpartyData) {
		
		ArrayList<relatedParty> con =  new ArrayList<>();
		//ReadWrite rw =  new ReadWrite();
		ArrayList<Integer> allIndexes = null;
		ArrayList<Integer> skippedData = null;
		ArrayList<String> Relno =  new ArrayList<>();
		Connection myconn = null; 
		  int count = 0;
		 relatedParty rel ;
		 try {
			 myconn = DriverManager.getConnection(cons.connection,cons.Uname,cons.pwd);
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
					skippedData =rw.uniqunumberfrSkippedData(configurationData.get("indexes_of_skippedData"),configurationData.get("NoOfData"),allIndexes);
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
			    		 //rel.setRelatedCounterpartyID(create.createRelatedCounterepartyId());
			    		String RelNo = duplicatecheck.createUniqueRelNew(Relno,create);
			    		rel.setRelatedCounterpartyID(RelNo);
			    		Relno.add(RelNo);
			    	}else
			    		 rel.setRelatedCounterpartyID("");
			    	if(fieldValues.get("relation").equalsIgnoreCase("Mandatory")) {
			    		rel.setRelation(create.createRelation());
			    	}else
			    		 rel.setRelation("");
			    	con.add(rel);
			    	dis.relatedPartyDatainsertion(myconn, rel);
			    	
				}}
					else if (skippedData.contains(count)) {
						 continue;
					 }
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
				    		 //rel.setRelatedCounterpartyID(create.createRelatedCounterepartyId());
				    		String RelNo = duplicatecheck.createUniqueRelNew(Relno,create);
				    		rel.setRelatedCounterpartyID(RelNo);
				    		Relno.add(RelNo);
				    	}else
				    		 rel.setRelatedCounterpartyID("");
				    	if(fieldValues.get("relation").equalsIgnoreCase("Mandatory")) {
				    		rel.setRelation(create.createRelation());
				    	}else
				    		 rel.setRelation("");
				    	con.add(rel);
				    	dis.relatedPartyDatainsertion(myconn, rel);
					}}
				 if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional")) {
					 
					 allIndexes =rw.uniqunumber(configurationData.get("TotalNo_counterpartyId_repeated_RelatedPartyFile") ,configurationData.get("NoOfData"));
					 skippedData =rw.uniqunumberfrSkippedData(configurationData.get("indexes_of_skippedData"),configurationData.get("NoOfData"),allIndexes);
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
			    		 //rel.setRelatedCounterpartyID(create.createRelatedCounterepartyId());
			    		String RelNo = duplicatecheck.createUniqueRelNew(Relno,create);
			    		rel.setRelatedCounterpartyID(RelNo);
			    		Relno.add(RelNo);
			    	}else
			    		 rel.setRelatedCounterpartyID("");
			    	if(fieldValues.get("relation").equalsIgnoreCase("Optional")) {
			    		 rel.setRelation(create.createRelation());
			    	}else
			    		 rel.setRelation("");
			    
				 
				 con.add(rel);
				 dis.relatedPartyDatainsertion(myconn, rel);
				 rel = null;
				 create=null;}}
	
						else if (skippedData.contains(count)) {
							 continue;
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
								//rel.setRelatedCounterpartyID(create.createRelatedCounterepartyId());
									String RelNo = duplicatecheck.createUniqueRelNew(Relno,create);
						    		rel.setRelatedCounterpartyID(RelNo);
						    		Relno.add(RelNo);
								}else
								rel.setRelatedCounterpartyID("");
								if(fieldValues.get("relation").equalsIgnoreCase("Optional")) {
						    		 rel.setRelation(create.createRelation());
						    	}else
						    		 rel.setRelation("");
								con.add(rel);
								dis.relatedPartyDatainsertion(myconn, rel);
						}}}}
			else {
				int co = 0;
				 skippedData =rw.uniqunumberfrSkippedData(configurationData.get("indexes_of_skippedData"),configurationData.get("NoOfData"), null);	 
				for(Counterparty counterparty: counterpartyData) {
					co++;
					if(skippedData.contains(co)) {
						 continue;
					 }
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
			    		// rel.setRelatedCounterpartyID(create.createRelatedCounterepartyId());
			    		String RelNo = duplicatecheck.createUniqueRelNew(Relno,create);
			    		rel.setRelatedCounterpartyID(RelNo);
			    		Relno.add(RelNo);
			    	}else
			    		 rel.setRelatedCounterpartyID("");
			    	if(fieldValues.get("relation").equalsIgnoreCase("Mandatory")) {
			    		 rel.setRelation(create.createRelation());
			    	}else
			    		 rel.setRelation("");
			    	
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
			    		String RelNo = duplicatecheck.createUniqueRelNew(Relno,create);
			    		rel.setRelatedCounterpartyID(RelNo);
			    		Relno.add(RelNo);
			    		 //rel.setRelatedCounterpartyID(create.createRelatedCounterepartyId());
			    	}else
			    		 rel.setRelatedCounterpartyID("");
			    	if(fieldValues.get("relation").equalsIgnoreCase("Optional")) {
			    		 rel.setRelation(create.createRelation());
			    	}else
			    		 rel.setRelation("");
				 }
				 con.add(rel);
				 dis.relatedPartyDatainsertion(myconn, rel);
				 rel = null;
				 create=null;
			}}}
			

		else if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Both")) {
			 
			if(configurationData.get("MultipleDataGenerationFor_RelatedParty").equalsIgnoreCase("Yes")) {
				 allIndexes =rw.uniqunumber(configurationData.get("TotalNo_counterpartyId_repeated_RelatedPartyFile") ,configurationData.get("NoOfData"));
				 skippedData =rw.uniqunumberfrSkippedData(configurationData.get("indexes_of_skippedData"),configurationData.get("NoOfData"),allIndexes);
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
							dis.relatedPartyDatainsertion(myconn, rel);
							
								
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
					dis.relatedPartyDatainsertion(myconn, rel);
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
				dis.relatedPartyDatainsertion(myconn, rel);
					
					rel=null;
					create=null;
				 }
			}		    
		}
	 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			finally {
				 try {
					myconn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
	return con;
	}*/
public ArrayList<relatedParty> createRelatedPartyData(ArrayList<Counterparty> counterpartyData) {
		
		ArrayList<relatedParty> con =  new ArrayList<>();
		
		ArrayList<Integer> allIndexes = null;
		ArrayList<Integer> skippedData = null;
		ArrayList<String> Relno =  new ArrayList<>();
		Connection myconn = null; 
		  int count = 0;
		 relatedParty rel ;
		 ArrayList<String> relatedcp  = new ArrayList<>();
		 try {
			 myconn = DriverManager.getConnection(cons.connection,cons.Uname,cons.pwd);
			 //Extracting the temp counterparty ID which will be used in Related party table for Co Borrower
			 relatedcp = dis.extracttempTableinformation(myconn, "temporaryrelatedparty");
		               	
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
					skippedData =rw.uniqunumberfrSkippedData(configurationData.get("indexes_of_skippedData"),configurationData.get("NoOfData"),allIndexes);
					String size=Integer.toString(counterpartyData.size());
					temporaryrelatedpartyIndexes =rw.uniqunumberfrSkippedData(configurationData.get("No_cid_passtoRelatedParty"),size,allIndexes);	
					if(allIndexes.contains(count)) {
						
						int z = ut.completeinteger(configurationData.get("No_individual_counterpartyId_repeated_inRelatedPartyFile"));
						int m =  faker.number().numberBetween(1,z );
						for(int k = 1;k<=m;k++) {
							rel  =  new relatedParty();
					if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Mandatory")) {
						  rel.setReportingEntityId(counterparty.getReportingEntityId());
			    	}else
			    		rel.setReportingEntityId("");
					if(fieldValues.get("relatedPartyId").equalsIgnoreCase("Mandatory")) {
						  rel.setRelatedPartyId(create.relatedPartyId(bankSymbol+"R"));
			    	}else
			    		rel.setRelatedPartyId("");
			    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Mandatory")) {
			    		rel.setCounterpartyId(counterparty.getCounterypartyId());
			    	}else
			    		rel.setCounterpartyId("");
			    	if(fieldValues.get("relatedCounterpartyID").equalsIgnoreCase("Mandatory")) {
			    		// rel.setRelatedCounterpartyID(create.createRelatedCounterepartyId());
			    		 String RelNo=dis.createUniqueRelatedCId(myconn, create);
				    	 rel.setRelatedCounterpartyID(RelNo);
			    	}else
			    		 rel.setRelatedCounterpartyID("");
			    	if(fieldValues.get("relation").equalsIgnoreCase("Mandatory")) {
			    		rel.setRelation(create.createRelation());
			    	}else
			    		 rel.setRelation("");
			    	con.add(rel);
			    	dis.relatedPartyDatainsertion(myconn, rel);
			    	
				}}
					else if (skippedData.contains(count)) {
						 continue;
					 }
					else
					{
						
						rel  =  new relatedParty();
						if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Mandatory")) {
							  rel.setReportingEntityId(counterparty.getReportingEntityId());
				    	}else
				    		rel.setReportingEntityId("");
						if(fieldValues.get("relatedPartyId").equalsIgnoreCase("Mandatory")) {
							  rel.setRelatedPartyId(create.relatedPartyId(bankSymbol+"R"));
				    	}else
				    		rel.setRelatedPartyId("");
				    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Mandatory")) {
				    		rel.setCounterpartyId(counterparty.getCounterypartyId());
				    	}else
				    		rel.setCounterpartyId("");
				    	if(fieldValues.get("relatedCounterpartyID").equalsIgnoreCase("Mandatory")) {
				    		//rel.setRelatedCounterpartyID(create.createRelatedCounterepartyId());
				    		 String RelNo=dis.createUniqueRelatedCId(myconn, create);
					    	 rel.setRelatedCounterpartyID(RelNo);
				    	}else
				    		 rel.setRelatedCounterpartyID("");
				    	if(fieldValues.get("relation").equalsIgnoreCase("Mandatory")) {
				    		rel.setRelation(create.createRelation());
				    	}else
				    		 rel.setRelation("");
				    	con.add(rel);
				    	dis.relatedPartyDatainsertion(myconn, rel);
					}}
				 if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional")) {
					 
					 allIndexes =rw.uniqunumber(configurationData.get("TotalNo_counterpartyId_repeated_RelatedPartyFile") ,configurationData.get("NoOfData"));
					 skippedData =rw.uniqunumberfrSkippedData(configurationData.get("indexes_of_skippedData"),configurationData.get("NoOfData"),allIndexes);
						if(allIndexes.contains(count)) {
							
							int z = ut.completeinteger(configurationData.get("No_individual_counterpartyId_repeated_inRelatedPartyFile"));
							int m =  faker.number().numberBetween(1,z );
							for(int k = 1;k<=m;k++) {
								 create = new datacreation();
								rel  =  new relatedParty();
					 
				 
					 if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Optional")) {
						  rel.setReportingEntityId(counterparty.getReportingEntityId());
			    	}else
			    		rel.setReportingEntityId("");
					 if(fieldValues.get("relatedPartyId").equalsIgnoreCase("Optional")) {
						  rel.setRelatedPartyId(create.relatedPartyId(bankSymbol+"R"));
			    	}else
			    		rel.setRelatedPartyId("");
			    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Optional")) {
			    		rel.setCounterpartyId(counterparty.getCounterypartyId());
			    	}else
			    		rel.setCounterpartyId("");
			    	if(fieldValues.get("relatedCounterpartyID").equalsIgnoreCase("Optional")) {
			    		//rel.setRelatedCounterpartyID(create.createRelatedCounterepartyId());
			    		String RelNo=dis.createUniqueRelatedCId(myconn, create);
				    	 rel.setRelatedCounterpartyID(RelNo);
			    	}else
			    		 rel.setRelatedCounterpartyID("");
			    	if(fieldValues.get("relation").equalsIgnoreCase("Optional")) {
			    		 rel.setRelation(create.createRelation());
			    	}else
			    		 rel.setRelation("");
			    
				 
				 con.add(rel);
				 dis.relatedPartyDatainsertion(myconn, rel);
				// rel = null;
				 create=null;}}
	
						else if (skippedData.contains(count)) {
							 continue;
						 }
						else
						{
							 create = new datacreation();
							rel  =  new relatedParty();
							if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Optional")) {
								rel.setReportingEntityId(counterparty.getReportingEntityId());
								}else
								rel.setReportingEntityId("");
							if(fieldValues.get("relatedPartyId").equalsIgnoreCase("Optional")) {
								  rel.setRelatedPartyId(create.relatedPartyId(bankSymbol+"R"));
					    	}else
					    		rel.setRelatedPartyId("");
								if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Optional")) {
								rel.setCounterpartyId(counterparty.getCounterypartyId());
								}else
								rel.setCounterpartyId("");
								if(fieldValues.get("relatedCounterpartyID").equalsIgnoreCase("Optional")) {
								//rel.setRelatedCounterpartyID(create.createRelatedCounterepartyId());
								String RelNo=dis.createUniqueRelatedCId(myconn, create);
						    	 rel.setRelatedCounterpartyID(RelNo);
								}else
								rel.setRelatedCounterpartyID("");
								if(fieldValues.get("relation").equalsIgnoreCase("Optional")) {
						    		 rel.setRelation(create.createRelation());
						    	}else
						    		 rel.setRelation("");
								con.add(rel);
								dis.relatedPartyDatainsertion(myconn, rel);
						}}}}
			else {
				int co = 0;
				 skippedData =rw.uniqunumberfrSkippedData(configurationData.get("indexes_of_skippedData"),configurationData.get("NoOfData"), null);	 
				for(Counterparty counterparty: counterpartyData) {
					co++;
					if(skippedData.contains(co)) {
						 continue;
					 }
					create = new datacreation();
				rel = new relatedParty();
				if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory"))
				{
					if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Mandatory")) {
						  rel.setReportingEntityId(counterparty.getReportingEntityId());
			    	}else
			    		rel.setReportingEntityId("");
					if(fieldValues.get("relatedPartyId").equalsIgnoreCase("Mandatory")) {
						  rel.setRelatedPartyId(create.relatedPartyId(bankSymbol+"R"));
			    	}else
			    		rel.setRelatedPartyId("");
			    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Mandatory")) {
			    		rel.setCounterpartyId(counterparty.getCounterypartyId());
			    	}else
			    		rel.setCounterpartyId("");
			    	if(fieldValues.get("relatedCounterpartyID").equalsIgnoreCase("Mandatory")) {
			    		//rel.setRelatedCounterpartyID(create.createRelatedCounterepartyId());
			    		String RelNo=dis.createUniqueRelatedCId(myconn, create);
				    	 rel.setRelatedCounterpartyID(RelNo);
			    	}else
			    		 rel.setRelatedCounterpartyID("");
			    	if(fieldValues.get("relation").equalsIgnoreCase("Mandatory")) {
			    		 rel.setRelation(create.createRelation());
			    	}else
			    		 rel.setRelation("");
			    	
				}
				 if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional")) {
					 if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Optional")) {
						  rel.setReportingEntityId(counterparty.getReportingEntityId());
			    	}else
			    		rel.setReportingEntityId("");
					 if(fieldValues.get("relatedPartyId").equalsIgnoreCase("Optional")) {
						  rel.setRelatedPartyId(create.relatedPartyId(bankSymbol+"R"));
			    	}else
			    		rel.setRelatedPartyId("");
			    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Optional")) {
			    		rel.setCounterpartyId(counterparty.getCounterypartyId());
			    	}else
			    		rel.setCounterpartyId("");
			    	if(fieldValues.get("relatedCounterpartyID").equalsIgnoreCase("Optional")) {
			    		String RelNo=dis.createUniqueRelatedCId(myconn, create);
				    	 rel.setRelatedCounterpartyID(RelNo);
			    		 //rel.setRelatedCounterpartyID(create.createRelatedCounterepartyId());
			    	}else
			    		 rel.setRelatedCounterpartyID("");
			    	if(fieldValues.get("relation").equalsIgnoreCase("Optional")) {
			    		 rel.setRelation(create.createRelation());
			    	}else
			    		 rel.setRelation("");
				 }
				 con.add(rel);
				 dis.relatedPartyDatainsertion(myconn, rel);
				 rel = null;
				 create=null;
			}}}
			

		else if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Both")) {
			 
			if(configurationData.get("MultipleDataGenerationFor_RelatedParty").equalsIgnoreCase("Yes")) {
				 allIndexes =rw.uniqunumber(configurationData.get("TotalNo_counterpartyId_repeated_RelatedPartyFile") ,configurationData.get("NoOfData"));
				 skippedData =rw.uniqunumberfrSkippedData(configurationData.get("indexes_of_skippedData"),configurationData.get("NoOfData"),allIndexes);
				 String size=Integer.toString(counterpartyData.size());
				 temporaryrelatedpartyIndexes =rw.uniqunumberfrSkippedData(configurationData.get("No_cid_passtoRelatedParty"),size,allIndexes);
				 String counterPartyId;
				 
				 for(Counterparty counterparty: counterpartyData) {
				
					count++;
					
				  String reportingEntityid = counterparty.getReportingEntityId();
				  counterPartyId =counterparty.getCounterypartyId() ;
				 if(allIndexes.contains(count)) {
					 
						int z = ut.completeinteger(configurationData.get("No_individual_counterpartyId_repeated_inRelatedPartyFile"));
							int m =  faker.number().numberBetween(1,z );
							for(int k = 1;k<=m;k++) {
								create = new datacreation();
								rel = new relatedParty();
								 rel.setReportingEntityId(reportingEntityid);
								 rel.setRelatedPartyId(create.relatedPartyId(bankSymbol+"R"));
								 rel.setCounterpartyId(counterPartyId);
					    			 String RelNo=dis.createUniqueRelatedCId(myconn, create);
							    	 rel.setRelatedCounterpartyID(RelNo);
								 rel.setRelation(create.createRelation());
							con.add(rel);
							dis.relatedPartyDatainsertion(myconn, rel);
							
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
						 rel.setRelatedPartyId(create.relatedPartyId(bankSymbol+"R"));
						 rel.setCounterpartyId(counterPartyId);
				    		 if(temporaryrelatedpartyIndexes.contains(count)) {
						    		String relatedcpid = null; 
				   					for(int i =0;i<=relatedcp.size();i++) {
				   					relatedcpid=relatedcp.get(i);
				   					rel.setRelatedCounterpartyID(relatedcpid);
				   					relatedcp.remove(relatedcpid);
									break;}
				   					}
				    		 else {
				    			 String RelNo=dis.createUniqueRelatedCId(myconn, create);
						    	 rel.setRelatedCounterpartyID(RelNo);
				    		 }
						 rel.setRelation(create.createRelation());
					con.add(rel);
					dis.relatedPartyDatainsertion(myconn, rel);
					}
					rel=null;
					create=null;
			 }}
			
			 else {
				 int co = 0;
				 skippedData =rw.uniqunumberfrSkippedData(configurationData.get("indexes_of_skippedData"),configurationData.get("NoOfData"), null);
				 //temporaryrelatedpartyIndexes =rw.uniqunumber(configurationData.get("No_cid_passtoRelatedParty"),size);
				 String size=Integer.toString(counterpartyData.size());
				 temporaryrelatedpartyIndexes =rw.uniqunumberfrSkippedData(configurationData.get("No_cid_passtoRelatedParty"),size,null);
				 for (Counterparty counterparty:counterpartyData ) {
					 
					 co++;
					 if(skippedData.contains(co)) {
						 continue;
					 }
					create = new datacreation();
					rel = new relatedParty();
					rel.setReportingEntityId(counterparty.getReportingEntityId());
					rel.setRelatedPartyId(create.relatedPartyId(bankSymbol+"R"));
					 rel.setCounterpartyId(counterparty.getCounterypartyId());
					 if(temporaryrelatedpartyIndexes.contains(co)) {
				    		String relatedcpid = null; 
		   					for(int i =0;i<=relatedcp.size();i++) {
		   					relatedcpid=relatedcp.get(i);
		   					rel.setRelatedCounterpartyID(relatedcpid);
		   					relatedcp.remove(relatedcpid);
							break;}
		   					}
		    		 else {
		    			 String RelNo=dis.createUniqueRelatedCId(myconn, create);
				    	 rel.setRelatedCounterpartyID(RelNo);
		    		 }
					 rel.setRelation(create.createRelation());
				con.add(rel);
				dis.relatedPartyDatainsertion(myconn, rel);
					
					rel=null;
					create=null;
				 }}
			 dis.destroytable(myconn, "temporaryrelatedparty");
					    
		
		}} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally {
        	 try {
				myconn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	return con;
	}
}