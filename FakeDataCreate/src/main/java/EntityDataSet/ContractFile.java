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
import Utilities.DuplicateDataCheck;
import Utilities.Utils;
import pojoClases.Contract;
import pojoClases.Counterparty;

public class ContractFile extends BaseClass{
	
	
	
	
	
public ContractFile(Hashtable<String, String> data) {
		super(data);
		
	}


	public ArrayList<Contract> createContractData(ArrayList<Counterparty> counterpartyData) 
	  {	
		 //ReadWrite rw =  new ReadWrite();
			ArrayList<Contract> con =  new ArrayList<>();
			create = new datacreation();
			Connection myconn = null;
			String counterPartyId ;
			create = null;
			Contract c;
			String instrument;
			ArrayList<Integer> allIndexes = null;
			int count = 0;
			try {
				 myconn = DriverManager.getConnection(Constants.connection,Constants.Uname,Constants.pwd);
				 
			if(configurationData.get("Generate Record for Existing Loan").equalsIgnoreCase("New Loan")||configurationData.get("Generate Record for Existing Loan").equalsIgnoreCase("NA"))
			{
				if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory")||configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional"))
				{
					if(configurationData.get("MultipleDataGenerationForContract").equalsIgnoreCase("Yes")) {
					fieldValues = DataUtil.getFieldValue("MasterData", xls);
					 for(Counterparty counterparty: counterpartyData) {
					 		create = new datacreation();
					 	    c  =  new Contract();
					 	  // counterPartyId = create.createCouterpartyIdentifier(bankSymbol);
					 	   counterPartyId = counterparty.getCounterypartyId();
					 		count++;		
						 
						if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory"))
						{
							allIndexes =rw.uniqunumber(configurationData.get("TotalNo_counterpartyId_repeated_incontractFile") ,configurationData.get("NoOfData"));
							if(allIndexes.contains(count)) {
								
								int z = Utils.completeinteger(configurationData.get("No_individual_counterpartyId_repeated_incontractFile"));
								int m =  faker.number().numberBetween(1,z );
								for(int k = 1;k<=m;k++) {
									c  =  new Contract();
							if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Mandatory")) {
								c.setReportingEntityId(counterparty.getReportingEntityId());	
					    	}else
					    		c.setReportingEntityId("");
					    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Mandatory")) {
					    		c.setCounterypartyId(counterPartyId);
					    	}else
					    		c.setCounterypartyId("");
					    	if(fieldValues.get("ContractId").equalsIgnoreCase("Mandatory")) {
					    		String contract=dis.createUniquecontractId(myconn, create);
			    				c.setContractId(contract);
					    	}else
					    		c.setContractId("");
					    	if(fieldValues.get("InstrumentId").equalsIgnoreCase("Mandatory")) {
					    		
					    		instrument = dis.createUniqueInstrumentId(myconn, create);
                                c.setInstrumentId(instrument);
					    	}else
					    		c.setInstrumentId("");
					    	con.add(c);
					    	dis.contractDatainsertion(myconn, c);
					    	c=null;
						}
					}
							else {
								c  =  new Contract();
								if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Mandatory")) {
									c.setReportingEntityId(counterparty.getReportingEntityId());	
						    	}else
						    		c.setReportingEntityId("");
						    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Mandatory")) {
						    		c.setCounterypartyId(counterPartyId);
						    	}else
						    		c.setCounterypartyId("");
						    	if(fieldValues.get("ContractId").equalsIgnoreCase("Mandatory")) {
						  
						    		String contract=dis.createUniquecontractId(myconn, create);
						    				c.setContractId(contract);

						    	}else
						    		c.setContractId("");
						    	if(fieldValues.get("InstrumentId").equalsIgnoreCase("Mandatory")) {
						    		c.setInstrumentId(create.createInstrumentId());
						    	}else
						    		c.setInstrumentId("");
								
								con.add(c);
								dis.contractDatainsertion(myconn, c);
								c=null;
								}
							}		
						 if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional")) {
							 allIndexes =rw.uniqunumber(configurationData.get("TotalNo_counterpartyId_repeated_incontractFile") ,configurationData.get("NoOfData"));
							 if(allIndexes.contains(count)) {
									
									int z = Utils.completeinteger(configurationData.get("No_individual_counterpartyId_repeated_incontractFile"));
									int m =  faker.number().numberBetween(1,z );
									for(int k = 1;k<=m;k++) {
										c  =  new Contract();
							 
								if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Optional")) {
									c.setReportingEntityId(counterparty.getReportingEntityId());	
						    	}else
						    		c.setReportingEntityId("");
						    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Optional")) {
						    		c.setCounterypartyId(counterPartyId);
						    	}else
						    		c.setCounterypartyId("");
						    	if(fieldValues.get("ContractId").equalsIgnoreCase("Optional")) {
						    		String contract=dis.createUniquecontractId(myconn, create);
				    				c.setContractId(contract);
						    	}else
						    		c.setContractId("");
						    	if(fieldValues.get("InstrumentId").equalsIgnoreCase("Optional")) {
						    		c.setInstrumentId(create.createInstrumentId());
						    	}else
						    		c.setInstrumentId("");
						 
						    	con.add(c);
						    	dis.contractDatainsertion(myconn, c);
								}
							 }
							 else {
									c  =  new Contract();
									if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Optional")) {
										c.setReportingEntityId(counterparty.getReportingEntityId());	
							    	}else
							    		c.setReportingEntityId("");
							    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Optional")) {
							    		c.setCounterypartyId(counterPartyId);
							    	}else
							    		c.setCounterypartyId("");
							    	if(fieldValues.get("ContractId").equalsIgnoreCase("Optional")) {
							    		String contract=dis.createUniquecontractId(myconn, create);
					    				c.setContractId(contract);
							    	}else
							    		c.setContractId("");
							    	if(fieldValues.get("InstrumentId").equalsIgnoreCase("Optional")) {
							    		c.setInstrumentId(create.createInstrumentId());
							    	}else
							    		c.setInstrumentId("");
							    	con.add(c);
							    	dis.contractDatainsertion(myconn, c);
							    	
							 }}
					
					
					}}
					else {
						for(Counterparty counterparty: counterpartyData) {				
							create = new datacreation();
					        c  =  new Contract();
							 
							 if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory"))
								{
									if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Mandatory")) {
										c.setReportingEntityId(counterparty.getReportingEntityId());	
							    	}else
							    		c.setReportingEntityId("");
							    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Mandatory")) {
							    		c.setCounterypartyId(create.createCouterpartyIdentifier(bankSymbol));
							    	}else
							    		c.setCounterypartyId("");
							    	if(fieldValues.get("ContractId").equalsIgnoreCase("Mandatory")) {
							    		String contract=dis.createUniquecontractId(myconn, create);
					    				c.setContractId(contract);
							    	}else
							    		c.setContractId("");
							    	if(fieldValues.get("InstrumentId").equalsIgnoreCase("Mandatory")) {
							    		c.setInstrumentId(create.createInstrumentId());
							    	}else
							    		c.setInstrumentId("");
							    	
								}
								 if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional")) {
										if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Optional")) {
											c.setReportingEntityId(counterparty.getReportingEntityId());	
								    	}else
								    		c.setReportingEntityId("");
								    	if(fieldValues.get("CounterpartyId").equalsIgnoreCase("Optional")) {
								    		c.setCounterypartyId(create.createCouterpartyIdentifier(bankSymbol));
								    	}else
								    		c.setCounterypartyId("");
								    	if(fieldValues.get("ContractId").equalsIgnoreCase("Optional")) {
								    		String contract=dis.createUniquecontractId(myconn, create);
						    				c.setContractId(contract);
								    	}else
								    		c.setContractId("");
								    	if(fieldValues.get("InstrumentId").equalsIgnoreCase("Optional")) {
								    		c.setInstrumentId(create.createInstrumentId());
								    	}else
								    		c.setInstrumentId("");
								 }
							con.add(c);
							dis.contractDatainsertion(myconn, c);
							}
						} 
					}

		else if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Both")) {
			 if(configurationData.get("MultipleDataGenerationForContract").equalsIgnoreCase("Yes")) {
						 
				 allIndexes =rw.uniqunumber(configurationData.get("TotalNo_counterpartyId_repeated_incontractFile") ,configurationData.get("NoOfData")); 
				 for(Counterparty counterparty: counterpartyData) {
							 count++;
							 create = new datacreation();
							  c  =  new Contract();
							 counterPartyId = counterparty.getCounterypartyId();
							if(allIndexes.contains(count)) {
								
								int z = Utils.completeinteger(configurationData.get("No_individual_counterpartyId_repeated_incontractFile"));
								//using faker create randomenumber from 1to z
								int m =  faker.number().numberBetween(1,z );
								for(int k = 1;k<=m;k++) {
									c  =  new Contract();
									c.setReportingEntityId(counterparty.getReportingEntityId());
									//c.setContractId(create.createContractIdentifier());
									String contract=dis.createUniquecontractId(myconn, create);
				    				c.setContractId(contract);
									//c.setInstrumentId(create.createInstrumentId());
						    		instrument = dis.createUniqueInstrumentId(myconn, create);
	                                c.setInstrumentId(instrument);		
									c.setCounterypartyId(counterPartyId);
								 con.add(c);
								 dis.contractDatainsertion(myconn, c);
									
								}  
								
							}else {
								c  =  new Contract();
								c.setReportingEntityId(counterparty.getReportingEntityId());	
								//c.setContractId(create.createContractIdentifier());
								String contract=dis.createUniquecontractId(myconn, create);
			    				c.setContractId(contract);
								//c.setInstrumentId(create.createInstrumentId());
					    		instrument = dis.createUniqueInstrumentId(myconn, create);
                                c.setInstrumentId(instrument);
								c.setCounterypartyId(counterPartyId);
								con.add(c);
								dis.contractDatainsertion(myconn, c);
							}
					 }
					 }else {
						 for(Counterparty counterparty: counterpartyData) {
							create = new datacreation();
							 	c  =  new Contract();
							c.setReportingEntityId(counterparty.getReportingEntityId());
							String contract=dis.createUniquecontractId(myconn, create);
		    				c.setContractId(contract);
				    		instrument = dis.createUniqueInstrumentId(myconn, create);
                            c.setInstrumentId(instrument);
							c.setCounterypartyId(counterparty.getCounterypartyId());
							con.add(c);
							dis.contractDatainsertion(myconn, c);
						 }
					 	}
			    	}		
						
			}
			else if (configurationData.get("Generate Record for Existing Loan").equalsIgnoreCase("Existing Loan")){
						
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