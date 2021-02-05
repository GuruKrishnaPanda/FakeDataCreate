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
import pojoClases.Instrument;
import pojoClases.protectionInstrument;

public class protectionInstrumentFile extends BaseClass {
	public protectionInstrumentFile(Hashtable<String, String> data) {
		super(data);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<protectionInstrument> createProtectionInstrumentData(ArrayList<Instrument> InstrumentData)
	{  
		create = new datacreation();
		create = null;
		Connection myconn = null;
		//Constants cons = new Constants();
		int count=0; 
		
		//String reportingEntityid = null;
		ArrayList<protectionInstrument> con =  new ArrayList<>();
		protectionInstrument pi = null ;
		String instrumentid = null;
		 String contractid = null;
		 String  reportingEntityid = null;
		 String protection;
		//ReadWrite rw =  new ReadWrite();
		ArrayList<Integer> allIndexes = null;
		try {
			//myconn = DriverManager.getConnection(cons.conn);
		 myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/framework","root","password");
		if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory")||configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional"))
		{
			if(configurationData.get("MultipleDataGenerationFor_protectioninstrument").equalsIgnoreCase("Yes")) {
			fieldValues = DataUtil.getFieldValue("MasterData", xls);
			for(Instrument instrument: InstrumentData) 
			{   
				
				instrumentid = instrument.getInstrumentId();
				 reportingEntityid =instrument.getReportingEntityId();
				 contractid =instrument.getContractId();
			 	create = new datacreation();
			 	 pi = new protectionInstrument();
			    
				count++;
			    if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory"))
				{
			    	allIndexes =rw.uniqunumber(configurationData.get("TotalNo_counterpartyId_repeated_RelatedPartyFile") ,configurationData.get("NoOfData"));
			    	skippedData =rw.uniqunumberfrSkippedData(configurationData.get("indexes_of_skippedData"),configurationData.get("NoOfData"),allIndexes);
					if(allIndexes.contains(count)) {
						
						int z = ut.completeinteger(configurationData.get("No_individual_counterpartyId_repeated_inRelatedPartyFile"));
						int m =  faker.number().numberBetween(1,z );
						for(int k = 1;k<=m;k++) {
						 pi = new protectionInstrument();
					if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Mandatory")) {
						  pi.setReportingEntityId(reportingEntityid );
			    	}else
			    		 pi.setReportingEntityId("");
			    	if(fieldValues.get("ContractId").equalsIgnoreCase("Mandatory")) {
			    		  pi.setContractId(contractid);
			    	}else
			    		  pi.setContractId("");
			    	if(fieldValues.get("InstrumentId").equalsIgnoreCase("Mandatory")) {
			    		 pi.setInstrumentId(instrumentid );
			    	}else
			    		pi.setInstrumentId("");
			      	if(fieldValues.get("Protection Allocated Value").equalsIgnoreCase("Mandatory")) {
			      	  pi.setProtectionAllocatedValue(create.createprotectionAllocatedValue());
			    	}else
			    		 pi.setProtectionAllocatedValue("");
			    	
			      	if(fieldValues.get("protectionId").equalsIgnoreCase("Mandatory")) {
			    	   // pi.setProtectionId(create.createProtectionId());
			      		protection=dis.createUniquePid(myconn,create);
		                pi.setProtectionId(protection);
			    	}else
			    		pi.setProtectionId("");
			      	if(fieldValues.get("chargeType").equalsIgnoreCase("Mandatory")) {
			      		 pi.setChargeType(create.createChargeType());
			    	}else
			    		 pi.setChargeType("");
			      	con.add(pi);
			      	dis.protectioninstrumentDatainsertion(myconn, pi);
				}}
					else if (skippedData.contains(count)) {
						 continue;
					 }
					else {
						
						 pi = new protectionInstrument();
						if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Mandatory")) {
							  pi.setReportingEntityId(instrument.getReportingEntityId());
				    	}else
				    		 pi.setReportingEntityId("");
				    	if(fieldValues.get("ContractId").equalsIgnoreCase("Mandatory")) {
				    		  pi.setContractId(contractid);
				    	}else
				    		  pi.setContractId("");
				    	if(fieldValues.get("InstrumentId").equalsIgnoreCase("Mandatory")) {
				    		 pi.setInstrumentId(instrumentid );
				    	}else
				    		pi.setInstrumentId("");
				      	if(fieldValues.get("Protection Allocated Value").equalsIgnoreCase("Mandatory")) {
				      	  pi.setProtectionAllocatedValue(create.createprotectionAllocatedValue());
				    	}else
				    		 pi.setProtectionAllocatedValue("");
				    	
				      	if(fieldValues.get("protectionId").equalsIgnoreCase("Mandatory")) {
				    	   // pi.setProtectionId(create.createProtectionId());
				      		protection=dis.createUniquePid(myconn,create);
			                pi.setProtectionId(protection);
				    	}else
				    		pi.setProtectionId("");
				      	if(fieldValues.get("chargeType").equalsIgnoreCase("Mandatory")) {
				      		 pi.setChargeType(create.createChargeType());
				    	}else
				    		 pi.setChargeType("");
				      	con.add(pi);
				     	dis.protectioninstrumentDatainsertion(myconn, pi);
					}}
				 if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional")) {
					 allIndexes =rw.uniqunumber(configurationData.get("TotalNo_counterpartyId_repeated_RelatedPartyFile") ,configurationData.get("NoOfData"));
					 skippedData =rw.uniqunumberfrSkippedData(configurationData.get("indexes_of_skippedData"),configurationData.get("NoOfData"),allIndexes);
						if(allIndexes.contains(count)) {
							
							int z = ut.completeinteger(configurationData.get("No_individual_counterpartyId_repeated_inRelatedPartyFile"));
							int m =  faker.number().numberBetween(1,z );
							for(int k = 1;k<=m;k++) {
							 pi = new protectionInstrument();
							 
					 if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Optional")) {
						  pi.setReportingEntityId(reportingEntityid);
			    	}else
			    		 pi.setReportingEntityId("");
			    	if(fieldValues.get("ContractId").equalsIgnoreCase("Optional")) {
			    		  pi.setContractId(contractid);
			    	}else
			    		  pi.setContractId("");
			    	if(fieldValues.get("InstrumentId").equalsIgnoreCase("Optional")) {
			    		 pi.setInstrumentId(instrumentid);
			    	}else
			    		pi.setInstrumentId("");
			      	if(fieldValues.get("Protection Allocated Value").equalsIgnoreCase("Optional")) {
			      	  pi.setProtectionAllocatedValue(create.createprotectionAllocatedValue());
			    	}else
			    		 pi.setProtectionAllocatedValue("");
			    	
			      	if(fieldValues.get("Protection External Id").equalsIgnoreCase("Optional")) {
			      		protection=dis.createUniquePid(myconn,create);
		                pi.setProtectionId(protection);
			    	    //pi.setProtectionId(create.createProtectionId());
			    	}else
			    		pi.setProtectionId("");
			      	if(fieldValues.get("chargeType").equalsIgnoreCase("Optional")) {
			      		 pi.setChargeType(create.createChargeType());
			    	}else
			    		 pi.setChargeType("");
			      	con.add(pi);
			     	dis.protectioninstrumentDatainsertion(myconn, pi);
				 }}
				
						else if (skippedData.contains(count)) {
							 continue;
						 }	
		  
				else {
							 pi = new protectionInstrument();
							 
							 if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Optional")) {
								  pi.setReportingEntityId(instrument.getReportingEntityId());
					    	}else
					    		 pi.setReportingEntityId("");
					    	if(fieldValues.get("ContractId").equalsIgnoreCase("Optional")) {
					    		  pi.setContractId(instrument.getContractId());
					    	}else
					    		  pi.setContractId("");
					    	if(fieldValues.get("InstrumentId").equalsIgnoreCase("Optional")) {
					    		 pi.setInstrumentId(instrument.getInstrumentId());
					    	}else
					    		pi.setInstrumentId("");
					      	if(fieldValues.get("Protection Allocated Value").equalsIgnoreCase("Optional")) {
					      	  pi.setProtectionAllocatedValue(create.createprotectionAllocatedValue());
					    	}else
					    		 pi.setProtectionAllocatedValue("");
					    	
					      	if(fieldValues.get("Protection External Id").equalsIgnoreCase("Optional")) {
					    	    //pi.setProtectionId(create.createProtectionId());
					      		protection=dis.createUniquePid(myconn,create);
				                pi.setProtectionId(protection);
					    	}else
					    		pi.setProtectionId("");
					      	if(fieldValues.get("chargeType").equalsIgnoreCase("Optional")) {
					      		 pi.setChargeType(create.createChargeType());
					    	}else
					    		 pi.setChargeType("");
						con.add(pi);}}
			     	dis.protectioninstrumentDatainsertion(myconn, pi);
						}}
		else {
			 int co = 0;
			 skippedData =rw.uniqunumberfrSkippedData(configurationData.get("indexes_of_skippedData"),configurationData.get("NoOfData"), null);
			for(Instrument instrument: InstrumentData) 
			{
				 co++;
				 if(skippedData.contains(co)) {
					 continue;
				 }
				create = new datacreation();
				 pi = new protectionInstrument();
				   if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory"))
					{
						if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Mandatory")) {
							  pi.setReportingEntityId(instrument.getReportingEntityId());
				    	}else
				    		 pi.setReportingEntityId("");
				    	if(fieldValues.get("ContractId").equalsIgnoreCase("Mandatory")) {
				    		  pi.setContractId(instrument.getContractId());
				    	}else
				    		  pi.setContractId("");
				    	if(fieldValues.get("InstrumentId").equalsIgnoreCase("Mandatory")) {
				    		 pi.setInstrumentId(instrument.getInstrumentId());
				    	}else
				    		pi.setInstrumentId("");
				      	if(fieldValues.get("Protection Allocated Value").equalsIgnoreCase("Mandatory")) {
				      	  pi.setProtectionAllocatedValue(create.createprotectionAllocatedValue());
				    	}else
				    		 pi.setProtectionAllocatedValue("");
				    	
				      	if(fieldValues.get("protectionId").equalsIgnoreCase("Mandatory")) {
				    	   // pi.setProtectionId(create.createProtectionId());
				      		protection=dis.createUniquePid(myconn,create);
			                pi.setProtectionId(protection);
				    	}else
				    		pi.setProtectionId("");
				      	if(fieldValues.get("chargeType").equalsIgnoreCase("Mandatory")) {
				      		 pi.setChargeType(create.createChargeType());
				    	}else
				    		 pi.setChargeType("");
				      	con.add(pi);
					}
					 if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional")) {
						 if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Optional")) {
							  pi.setReportingEntityId(instrument.getReportingEntityId());
				    	}else
				    		 pi.setReportingEntityId("");
				    	if(fieldValues.get("ContractId").equalsIgnoreCase("Optional")) {
				    		  pi.setContractId(instrument.getContractId());
				    	}else
				    		  pi.setContractId("");
				    	if(fieldValues.get("InstrumentId").equalsIgnoreCase("Optional")) {
				    		 pi.setInstrumentId(instrument.getInstrumentId());
				    	}else
				    		pi.setInstrumentId("");
				      	if(fieldValues.get("Protection Allocated Value").equalsIgnoreCase("Optional")) {
				      	  pi.setProtectionAllocatedValue(create.createprotectionAllocatedValue());
				    	}else
				    		 pi.setProtectionAllocatedValue("");
				    	
				      	if(fieldValues.get("Protection External Id").equalsIgnoreCase("Optional")) {
				    	   // pi.setProtectionId(create.createProtectionId());
				      		protection=dis.createUniquePid(myconn,create);
			                pi.setProtectionId(protection);
				    	}else
				    		pi.setProtectionId("");
				      	if(fieldValues.get("chargeType").equalsIgnoreCase("Optional")) {
				      		 pi.setChargeType(create.createChargeType());
				    	}else
				    		 pi.setChargeType(""); 
					con.add(pi);
			     	dis.protectioninstrumentDatainsertion(myconn, pi);
					pi = null;
					create=null;	
					 }}}}
		else if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Both")) {
			 if(configurationData.get("MultipleDataGenerationFor_protectioninstrument").equalsIgnoreCase("Yes")) {
			 for(Instrument instrument: InstrumentData) {
				 instrumentid = instrument.getInstrumentId();
				 reportingEntityid =instrument.getReportingEntityId();
				 contractid =instrument.getContractId();
				
					count++;
					 create = new datacreation();
					 pi = new protectionInstrument();
					 allIndexes =rw.uniqunumber(configurationData.get("TotalNo_contractid,instrumentid_repeated_inprotectioninstrument") ,configurationData.get("NoOfData"));
					 skippedData =rw.uniqunumberfrSkippedData(configurationData.get("indexes_of_skippedData"),configurationData.get("NoOfData"),allIndexes);
					if(allIndexes.contains(count)) {
						
						
						int z = ut.completeinteger(configurationData.get("No_individual_contractid,instrumentid_repeated_inprotectioninstrument"));
						//using faker create randomenumber from 1to z
						int m =  faker.number().numberBetween(1,z );
						for(int k = 1;k<=m;k++) {  
							  pi = new protectionInstrument();
		 
								    pi.setReportingEntityId(reportingEntityid);
								    pi.setInstrumentId(instrumentid);
								    pi.setContractId(contractid);
								    pi.setProtectionAllocatedValue(create.createprotectionAllocatedValue());
								    //pi.setProtectionId(create.createProtectionId());
						      		protection=dis.createUniquePid(myconn,create);
					                pi.setProtectionId(protection);
								    pi.setChargeType(create.createChargeType());
							con.add(pi);	
					     	dis.protectioninstrumentDatainsertion(myconn, pi);
							}}
					 else if (skippedData.contains(count)) {
						 continue;
					 }
					else 
					{
						 pi = new protectionInstrument();
						pi.setReportingEntityId(reportingEntityid);
					    pi.setInstrumentId(instrumentid);
					    pi.setContractId(contractid);
					    pi.setProtectionAllocatedValue(create.createprotectionAllocatedValue());
					    //pi.setProtectionId(create.createProtectionId());
			      		protection=dis.createUniquePid(myconn,create);
		                pi.setProtectionId(protection);
					    pi.setChargeType(create.createChargeType());
				con.add(pi);     	
				dis.protectioninstrumentDatainsertion(myconn, pi);
				} 
					
					pi=null;
					create=null;
			 }}	
		else {
			 int co = 0;
			 skippedData =rw.uniqunumberfrSkippedData(configurationData.get("indexes_of_skippedData"),configurationData.get("NoOfData"), null);
			for(Instrument instrument: InstrumentData) {
				co++;
				if(skippedData.contains(co)) {
					 continue;
				 }
				create = new datacreation();
				pi = new protectionInstrument();
			    pi.setReportingEntityId(reportingEntityid);
			    pi.setInstrumentId(instrument.getInstrumentId());
			    pi.setContractId(instrument.getContractId());
			    pi.setProtectionAllocatedValue(create.createprotectionAllocatedValue());
	      		protection=dis.createUniquePid(myconn,create);
                pi.setProtectionId(protection);
			    pi.setChargeType(create.createChargeType());
				con.add(pi);
		     	dis.protectioninstrumentDatainsertion(myconn, pi);
				pi=null;
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
	}

}