package EntityDataSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

import ReUsable.ReadWrite;
import ReUsable.datacreation;
import Utilities.Constants;
import Utilities.DataUtil;
import Utilities.Utils;
import pojoClases.Contract;
import pojoClases.Counterparty;
import pojoClases.counterpartyRating;

public class counterpartyRatingFile extends BaseClass {
	
	

public counterpartyRatingFile(Hashtable<String, String> data) {
		super(data);
	}

public ArrayList<counterpartyRating> createcounterpartyRatingData(ArrayList<Counterparty> counterpartyData) {
		
		ArrayList<counterpartyRating> con =  new ArrayList<>();
		counterpartyRating cpr;
		//ReadWrite rw =  new ReadWrite();
		ArrayList<Integer> allIndexes = null;
		int count =0;
		Connection myconn = null;
		String ratingID;
		 try {
			 myconn = DriverManager.getConnection(cons.connection,cons.Uname,cons.pwd);
		if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory")||configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional"))
     	{
			if(configurationData.get("MultipleDataGenerationFor_counterpartyRating").equalsIgnoreCase("Yes"))
             {
				
     		fieldValues = DataUtil.getFieldValue("MasterData", xls);
     		 for(Counterparty counterparty: counterpartyData) {
			 	create = new datacreation();
			 	cpr  =  new counterpartyRating();
			 	count++;
			 	
				if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory"))
				{
					allIndexes =rw.uniqunumber(configurationData.get("TotalNo_counterpartyId_repeated_counterpartyRatingFile") ,configurationData.get("NoOfData"));
					skippedData =rw.uniqunumberfrSkippedData(configurationData.get("indexes_of_skippedData"),configurationData.get("NoOfData"),allIndexes);
					if(allIndexes.contains(count)) {
						
						int z = Utils.completeinteger(configurationData.get("No_individual_counterpartyId_repeated_incounterpartyRatingFile"));
						int m =  faker.number().numberBetween(1,z );
						for(int k = 1;k<=m;k++) {
							cpr  =  new counterpartyRating();
					if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Mandatory")) {
						cpr.setReportingEntityId(counterparty.getReportingEntityId());
			    	}else
			    		cpr.setReportingEntityId("");
			    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Mandatory")) {
			    	 	cpr.setCounterpartyId(counterparty.getCounterypartyId());
			    	}else
			    		cpr.setCounterpartyId("");
			    	if(fieldValues.get("ratingID").equalsIgnoreCase("Mandatory")) {
			    	 	//cpr.setRatingID(create.createRatingId());
			    		ratingID=dis.createUniqueRatingId(myconn, create);
                        cpr.setRatingID(ratingID);
			    	}else
			    		cpr.setRatingID("");
			    	if(fieldValues.get("creditRating").equalsIgnoreCase("Mandatory")) {
			    		cpr.setCreditRating(create.creditRating());
			    	}else
			    		cpr.setCreditRating("");
			    	if(fieldValues.get("assessmentAgencyAuthority").equalsIgnoreCase("Mandatory")) {
			    		cpr.setAssessmentAgencyAuthority(create.assessmentAgencyAuthority());
			    	}else
			    		cpr.setAssessmentAgencyAuthority("");
			    	if(fieldValues.get("creditRatingAsOn").equalsIgnoreCase("Mandatory")) {
			    		 cpr.setCreditRatingAsOn(create.creditRatingAsOn());
			    	}else
			    		cpr.setCreditRatingAsOn("");
			    	if(fieldValues.get("creditRatingExpiryDate").equalsIgnoreCase("Mandatory")) {
			    		   cpr.setCreditRatingExpiryDate(create.creditRatingExpiryDate());
			    	}else
			    		cpr.setCreditRatingExpiryDate("");
			    	con.add(cpr);
			    	dis.counterpartyRatinginsertion(myconn, cpr);
			    	
				}}
					else if (skippedData.contains(count)) {
						 continue;
					 }
					else
					{
						cpr  =  new counterpartyRating();
						if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Mandatory")) {
							cpr.setReportingEntityId(counterparty.getReportingEntityId());
				    	}else
				    		cpr.setReportingEntityId("");
				    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Mandatory")) {
				    	 	cpr.setCounterpartyId(counterparty.getCounterypartyId());
				    	}else
				    		cpr.setCounterpartyId("");
				    	if(fieldValues.get("ratingID").equalsIgnoreCase("Mandatory")) {
				    		ratingID=dis.createUniqueRatingId(myconn, create);
	                        cpr.setRatingID(ratingID);
				    	}else
				    		cpr.setRatingID("");
				    	if(fieldValues.get("creditRating").equalsIgnoreCase("Mandatory")) {
				    		cpr.setCreditRating(create.creditRating());
				    	}else
				    		cpr.setCreditRating("");
				    	if(fieldValues.get("assessmentAgencyAuthority").equalsIgnoreCase("Mandatory")) {
				    		cpr.setAssessmentAgencyAuthority(create.assessmentAgencyAuthority());
				    	}else
				    		cpr.setAssessmentAgencyAuthority("");
				    	if(fieldValues.get("creditRatingAsOn").equalsIgnoreCase("Mandatory")) {
				    		 cpr.setCreditRatingAsOn(create.creditRatingAsOn());
				    	}else
				    		cpr.setCreditRatingAsOn("");
				    	if(fieldValues.get("creditRatingExpiryDate").equalsIgnoreCase("Mandatory")) {
				    		   cpr.setCreditRatingExpiryDate(create.creditRatingExpiryDate());
				    	}else
				    		cpr.setCreditRatingExpiryDate("");
				    	con.add(cpr);
				    	dis.counterpartyRatinginsertion(myconn, cpr);
						
					}}
				 if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional")) {
					 allIndexes =rw.uniqunumber(configurationData.get("TotalNo_counterpartyId_repeated_counterpartyRatingFile") ,configurationData.get("NoOfData"));
					 skippedData =rw.uniqunumberfrSkippedData(configurationData.get("indexes_of_skippedData"),configurationData.get("NoOfData"),allIndexes);
						if(allIndexes.contains(count)) {
							
							int z = ut.completeinteger(configurationData.get("No_individual_counterpartyId_repeated_incounterpartyRatingFile"));
							int m =  faker.number().numberBetween(1,z );
							for(int k = 1;k<=m;k++) {
								cpr  =  new counterpartyRating();
					 if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Optional")) {
							cpr.setReportingEntityId(counterparty.getReportingEntityId());
				    	}else
				    		cpr.setReportingEntityId("");
				    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Optional")) {
				    	 	cpr.setCounterpartyId(counterparty.getCounterypartyId());
				    	}else
				    		cpr.setCounterpartyId("");
				    	if(fieldValues.get("ratingId").equalsIgnoreCase("Optional")) {
				    	 	//cpr.setRatingID(create.createRatingId());
				    		ratingID=dis.createUniqueRatingId(myconn, create);
	                        cpr.setRatingID(ratingID);
				    	}else
				    		cpr.setRatingID("");
				    	if(fieldValues.get("creditRating").equalsIgnoreCase("Optional")) {
				    		cpr.setCreditRating(create.creditRating());
				    	}else
				    		cpr.setCreditRating("");
				    	if(fieldValues.get("assessmentAgencyAuthority").equalsIgnoreCase("Optional")) {
				    		cpr.setAssessmentAgencyAuthority(create.assessmentAgencyAuthority());
				    	}else
				    		cpr.setAssessmentAgencyAuthority("");
				    	if(fieldValues.get("creditRatingAsOn").equalsIgnoreCase("Optional")) {
				    		 cpr.setCreditRatingAsOn(create.creditRatingAsOn());
				    	}else
				    		cpr.setCreditRatingAsOn("");
				    	if(fieldValues.get("creditRatingExpiryDate").equalsIgnoreCase("Optional")) {
				    		   cpr.setCreditRatingExpiryDate(create.creditRatingExpiryDate());
				    	}else
				    		cpr.setCreditRatingExpiryDate("");
				 
			 con.add(cpr);
			 dis.counterpartyRatinginsertion(myconn, cpr);
			 //cpr=null;
			 //create=null;
				}}
						else if (skippedData.contains(count)) {
							 continue;
						 }
						else
						{ 
							cpr  =  new counterpartyRating();
						
							 if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Optional")) {
									cpr.setReportingEntityId(counterparty.getReportingEntityId());
						    	}else
						    		cpr.setReportingEntityId("");
						    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Optional")) {
						    	 	cpr.setCounterpartyId(counterparty.getCounterypartyId());
						    	}else
						    		cpr.setCounterpartyId("");
						    	if(fieldValues.get("ratingId").equalsIgnoreCase("Optional")) {
						    	 	//cpr.setRatingID(create.createRatingId());
						    		ratingID=dis.createUniqueRatingId(myconn, create);
			                        cpr.setRatingID(ratingID);
						    	}else
						    		cpr.setRatingID("");
						    	if(fieldValues.get("creditRating").equalsIgnoreCase("Optional")) {
						    		cpr.setCreditRating(create.creditRating());
						    	}else
						    		cpr.setCreditRating("");
						    	if(fieldValues.get("assessmentAgencyAuthority").equalsIgnoreCase("Optional")) {
						    		cpr.setAssessmentAgencyAuthority(create.assessmentAgencyAuthority());
						    	}else
						    		cpr.setAssessmentAgencyAuthority("");
						    	if(fieldValues.get("creditRatingAsOn").equalsIgnoreCase("Optional")) {
						    		 cpr.setCreditRatingAsOn(create.creditRatingAsOn());
						    	}else
						    		cpr.setCreditRatingAsOn("");
						    	if(fieldValues.get("creditRatingExpiryDate").equalsIgnoreCase("Optional")) {
						    		   cpr.setCreditRatingExpiryDate(create.creditRatingExpiryDate());
						    	}else
						    		cpr.setCreditRatingExpiryDate("");
						 
					 con.add(cpr);
					 dis.counterpartyRatinginsertion(myconn, cpr);
						}}}}
				 else
				 {
					 int co = 0;
				 skippedData =rw.uniqunumberfrSkippedData(configurationData.get("indexes_of_skippedData"),configurationData.get("NoOfData"), null);	 
					 for(Counterparty counterparty: counterpartyData) {
						 co++;
						 if(skippedData.contains(co)) {
							 continue;
						 }
						 create = new datacreation();
						 create=null;
						 cpr = new counterpartyRating();

						 if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory"))
						 {
						 if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Mandatory")) {
						 cpr.setReportingEntityId(counterparty.getReportingEntityId());
						 }else
						 cpr.setReportingEntityId("");
						 if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Mandatory")) {
						 cpr.setCounterpartyId(counterparty.getCounterypartyId());
						 }else
						 cpr.setCounterpartyId("");
						 if(fieldValues.get("ratingID").equalsIgnoreCase("Mandatory")) {
						 //cpr.setRatingID(create.createRatingId());
							 ratingID=dis.createUniqueRatingId(myconn, create);
		                     cpr.setRatingID(ratingID);
						 }else
						 cpr.setRatingID("");
						 if(fieldValues.get("creditRating").equalsIgnoreCase("Mandatory")) {
						 cpr.setCreditRating(create.creditRating());
						 }else
						 cpr.setCreditRating("");
						 if(fieldValues.get("assessmentAgencyAuthority").equalsIgnoreCase("Mandatory")) {
						 cpr.setAssessmentAgencyAuthority(create.assessmentAgencyAuthority());
						 }else
						 cpr.setAssessmentAgencyAuthority("");
						 if(fieldValues.get("creditRatingAsOn").equalsIgnoreCase("Mandatory")) {
						 cpr.setCreditRatingAsOn(create.creditRatingAsOn());
						 }else
						 cpr.setCreditRatingAsOn("");
						 if(fieldValues.get("creditRatingExpiryDate").equalsIgnoreCase("Mandatory")) {
						 cpr.setCreditRatingExpiryDate(create.creditRatingExpiryDate());
						 }else
						 cpr.setCreditRatingExpiryDate("");

						 }
						 if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional")) {
						 if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Optional")) {
						 cpr.setReportingEntityId(counterparty.getReportingEntityId());
						 }else
						 cpr.setReportingEntityId("");
						 if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Optional")) {
						 cpr.setCounterpartyId(counterparty.getCounterypartyId());
						 }else
						 cpr.setCounterpartyId("");
						 if(fieldValues.get("ratingId").equalsIgnoreCase("Optional")) {
							 ratingID=dis.createUniqueRatingId(myconn, create);
		                     cpr.setRatingID(ratingID);
						 }else
						 cpr.setRatingID("");
						 if(fieldValues.get("creditRating").equalsIgnoreCase("Optional")) {
						 cpr.setCreditRating(create.creditRating());
						 }else
						 cpr.setCreditRating("");
						 if(fieldValues.get("assessmentAgencyAuthority").equalsIgnoreCase("Optional")) {
						 cpr.setAssessmentAgencyAuthority(create.assessmentAgencyAuthority());
						 }else
						 cpr.setAssessmentAgencyAuthority("");
						 if(fieldValues.get("creditRatingAsOn").equalsIgnoreCase("Optional")) {
						 cpr.setCreditRatingAsOn(create.creditRatingAsOn());
						 }else
						 cpr.setCreditRatingAsOn("");
						 if(fieldValues.get("creditRatingExpiryDate").equalsIgnoreCase("Optional")) {
						 cpr.setCreditRatingExpiryDate(create.creditRatingExpiryDate());
						 }else
						 cpr.setCreditRatingExpiryDate("");
						 }
						 con.add(cpr);
						 dis.counterpartyRatinginsertion(myconn, cpr);
						 cpr=null;
						 create=null;
						 }
				 }}
     		 
     		
     	else if (configurationData.get("GenerateDataFor").equalsIgnoreCase("Both")){
     		if(configurationData.get("MultipleDataGenerationFor_counterpartyRating").equalsIgnoreCase("Yes")) {
     		String CounterpartyId;
     		 for(Counterparty counterparty: counterpartyData) {
     			 String reportingEntityid = counterparty.getReportingEntityId();
     			 CounterpartyId = counterparty.getCounterypartyId();
					count++;
     				 create = new datacreation();
     				 cpr  =  new counterpartyRating();
     				 allIndexes =rw.uniqunumber(configurationData.get("TotalNo_counterpartyId_repeated_counterpartyRatingFile") ,configurationData.get("NoOfData"));
     				skippedData =rw.uniqunumberfrSkippedData(configurationData.get("indexes_of_skippedData"),configurationData.get("NoOfData"),allIndexes);
     				if(allIndexes.contains(count)) {
     					
     			int z = ut.completeinteger(configurationData.get("No_individual_counterpartyId_repeated_incounterpartyRatingFile"));
     					//using faker create randomenumber from 1to z
     					int m =  faker.number().numberBetween(1,z );
     					for(int k = 1;k<=m;k++) {
     							cpr  =  new counterpartyRating();
     							cpr.setReportingEntityId(reportingEntityid);
     						 	cpr.setCounterpartyId( CounterpartyId);
     						 	//cpr.setRatingID(create.createRatingId());
     						 	ratingID=dis.createUniqueRatingId(myconn, create);
     	                        cpr.setRatingID(ratingID);
     						 	cpr.setCreditRating(create.creditRating());
     						 	cpr.setAssessmentAgencyAuthority(create.assessmentAgencyAuthority());
     					        cpr.setCreditRatingAsOn(create.creditRatingAsOn());
     					        cpr.setCreditRatingExpiryDate(create.creditRatingExpiryDate());
     					     con.add(cpr);
     						dis.counterpartyRatinginsertion(myconn,cpr);
     					   
     				 }}
     				 else if (skippedData.contains(count)) {
    					 continue;
    				 }
     			else {
     				
     					create = new datacreation();
     					cpr  =  new counterpartyRating();
						 	cpr.setReportingEntityId(reportingEntityid);
 						 	cpr.setCounterpartyId( CounterpartyId);
 						 	//cpr.setRatingID(create.createRatingId());
 						 	ratingID=dis.createUniqueRatingId(myconn, create);
 	                        cpr.setRatingID(ratingID);
						 	cpr.setCreditRating(create.creditRating());
						 	cpr.setAssessmentAgencyAuthority(create.assessmentAgencyAuthority());
					        cpr.setCreditRatingAsOn(create.creditRatingAsOn());
					        cpr.setCreditRatingExpiryDate(create.creditRatingExpiryDate());
					     con.add(cpr);
					 	dis.counterpartyRatinginsertion(myconn,cpr);}	
     				  cpr=null;
     					create=null;
     				 }}
     				
     						
     		else {
     			 int co = 0;
				 skippedData =rw.uniqunumberfrSkippedData(configurationData.get("indexes_of_skippedData"),configurationData.get("NoOfData"), null);
     			 for(Counterparty counterparty: counterpartyData)
     			 {
     				 co++;
     				if(skippedData.contains(co)) {
						 continue;
					 }
     		     create = new datacreation();
			 	 cpr  =  new counterpartyRating();
			 	cpr.setReportingEntityId(counterparty.getReportingEntityId());
			 	cpr.setCounterpartyId(counterparty.getCounterypartyId());
			 	//cpr.setRatingID(create.createRatingId());
			 	ratingID=dis.createUniqueRatingId(myconn, create);
                cpr.setRatingID(ratingID);
			 	cpr.setCreditRating(create.creditRating());
			 	cpr.setAssessmentAgencyAuthority(create.assessmentAgencyAuthority());
		        cpr.setCreditRatingAsOn(create.creditRatingAsOn());
		        cpr.setCreditRatingExpiryDate(create.creditRatingExpiryDate());
		     con.add(cpr);
		 	dis.counterpartyRatinginsertion(myconn,cpr);
		   	 cpr=null;
		   	 create=null;
		   
     		}
     			
     	}}}
		catch (SQLException e) {
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
