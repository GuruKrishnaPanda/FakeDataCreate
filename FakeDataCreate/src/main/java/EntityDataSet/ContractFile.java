package EntityDataSet;

import java.util.ArrayList;

import ReUsable.ReadWrite;
import ReUsable.datacreation;
import Utilities.DataUtil;
import pojoClases.Contract;
import pojoClases.Counterparty;

public class ContractFile extends BaseClass{
	public ArrayList<Contract> createContractData(ArrayList<Counterparty> counterpartyData) 
	  {	
		 ReadWrite rw =  new ReadWrite();
		
			ArrayList<Contract> con =  new ArrayList<>();
			ArrayList<String> conid =  new ArrayList<>();
			ArrayList<String> instrumentid =  new ArrayList<>();
			//create = new datacreation();
			
			String counterPartyId ;
			create = null;
			Contract c;
			ArrayList<Integer> allIndexes = null;
			int count = 0;
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
							
							int z = ut.completeinteger(configurationData.get("No_individual_counterpartyId_repeated_incontractFile"));
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
				    		c.setContractId(create.createContractIdentifier());
				    	}else
				    		c.setContractId("");
				    	if(fieldValues.get("InstrumentId").equalsIgnoreCase("Mandatory")) {
				    		
				    		c.setInstrumentId(create.createInstrumentId());
				    	}else
				    		c.setInstrumentId("");
				    	con.add(c);
				    	
					}}
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
					    		c.setContractId(create.createContractIdentifier());
					    	}else
					    		c.setContractId("");
					    	if(fieldValues.get("InstrumentId").equalsIgnoreCase("Mandatory")) {
					    		c.setInstrumentId(create.createInstrumentId());
					    	}else
					    		c.setInstrumentId("");
							
							con.add(c);
						}}
							
							
					 if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional")) {
						 allIndexes =rw.uniqunumber(configurationData.get("TotalNo_counterpartyId_repeated_incontractFile") ,configurationData.get("NoOfData"));
						 if(allIndexes.contains(count)) {
								
								int z = ut.completeinteger(configurationData.get("No_individual_counterpartyId_repeated_incontractFile"));
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
					    		c.setContractId(create.createContractIdentifier());
					    	}else
					    		c.setContractId("");
					    	if(fieldValues.get("InstrumentId").equalsIgnoreCase("Optional")) {
					    		c.setInstrumentId(create.createInstrumentId());
					    	}else
					    		c.setInstrumentId("");
					 
				con.add(c);
				}}
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
						    		c.setContractId(create.createContractIdentifier());
						    	}else
						    		c.setContractId("");
						    	if(fieldValues.get("InstrumentId").equalsIgnoreCase("Optional")) {
						    		c.setInstrumentId(create.createInstrumentId());
						    	}else
						    		c.setInstrumentId("");
						    	con.add(c);}}
				
				
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
						    		c.setContractId(create.createContractIdentifier());
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
							    		c.setContractId(create.createContractIdentifier());
							    	}else
							    		c.setContractId("");
							    	if(fieldValues.get("InstrumentId").equalsIgnoreCase("Optional")) {
							    		c.setInstrumentId(create.createInstrumentId());
							    	}else
							    		c.setInstrumentId("");
							 }
						con.add(c);
						
						}} }

	else if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Both")) {
		 if(configurationData.get("MultipleDataGenerationForContract").equalsIgnoreCase("Yes")) {
					 
			 allIndexes =rw.uniqunumber(configurationData.get("TotalNo_counterpartyId_repeated_incontractFile") ,configurationData.get("NoOfData")); 
			 for(Counterparty counterparty: counterpartyData) {
						 count++;
						 create = new datacreation();
						  c  =  new Contract();
						 counterPartyId = counterparty.getCounterypartyId();
						if(allIndexes.contains(count)) {
							
							int z = ut.completeinteger(configurationData.get("No_individual_counterpartyId_repeated_incontractFile"));
							//using faker create randomenumber from 1to z
							int m =  faker.number().numberBetween(1,z );
							for(int k = 1;k<=m;k++) {
								c  =  new Contract();
								c.setReportingEntityId(counterparty.getReportingEntityId());
								//c.setContractId(create.createContractIdentifier());
								 String contract = duplicatecheck.createUniqueContractNew(conid,create);
						    		c.setContractId(contract);
						    		conid.add(contract);
								//c.setInstrumentId(create.createInstrumentId());
								String instrument = duplicatecheck.createUniqueInstrumentNew(instrumentid,create);
					    		c.setInstrumentId(instrument);
					    		instrumentid.add(instrument);
								
								c.setCounterypartyId(counterPartyId);
							 con.add(c);
								
							}  
							
						}else {
							c  =  new Contract();
							c.setReportingEntityId(counterparty.getReportingEntityId());	
							//c.setContractId(create.createContractIdentifier());
							 String contract = duplicatecheck.createUniqueContractNew(conid,create);
					    		c.setContractId(contract);
					    		conid.add(contract);
							//c.setInstrumentId(create.createInstrumentId());
							String instrument = duplicatecheck.createUniqueInstrumentNew(instrumentid,create);
				    		c.setInstrumentId(instrument);
				    		instrumentid.add(instrument);
							c.setCounterypartyId(counterPartyId);
							con.add(c);
						}
				 }
				 }else {
					 for(Counterparty counterparty: counterpartyData) {
							
							
						create = new datacreation();
						 c  =  new Contract();
						c.setReportingEntityId(counterparty.getReportingEntityId());
						//c.setContractId(create.createContractIdentifier());
						String contract = duplicatecheck.createUniqueContractNew(conid,create);
			    		c.setContractId(contract);
			    		conid.add(contract);
						//c.setInstrumentId(create.createInstrumentId());
						String instrument = duplicatecheck.createUniqueInstrumentNew(instrumentid,create);
			    		c.setInstrumentId(instrument);
			    		instrumentid.add(instrument);
						c.setCounterypartyId(counterparty.getCounterypartyId());
						
						con.add(c);
						c=null;
						create=null;
					 }}
				  
				}
			return con;
				 }


}
