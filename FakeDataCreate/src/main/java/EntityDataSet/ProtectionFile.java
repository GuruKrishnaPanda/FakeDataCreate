package EntityDataSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

import ReUsable.datacreation;
import Utilities.Constants;
import Utilities.DataUtil;
import pojoClases.Protection;
import pojoClases.protectionInstrument;

public class ProtectionFile extends BaseClass{
	 public ProtectionFile(Hashtable<String, String> data) {
		super(data);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Protection> createProtectionData(ArrayList<protectionInstrument> createProtectionInstrumentData)
     {
		 create = new datacreation();
			create = null;
			Connection myconn = null;
	       
			String size=Integer.toString(createProtectionInstrumentData.size());
			temporaryprotectionIndexes =rw.uniqunumber(configurationData.get("No_cid_passtoProtection"),size); 
        ArrayList<Protection> con = new ArrayList<>();
        try {
		 myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/framework","root","password");
		 
         ArrayList<String> providerid = dis.extracttempTableinformation(myconn,"temporaryprotection");
        if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory")||configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional"))
    	{
    		fieldValues = DataUtil.getFieldValue("MasterData", xls);
    		int co = 0;
           for(protectionInstrument protect:createProtectionInstrumentData ){
        	   co++;
 		      create = new datacreation();
 		      Protection p = new Protection();
 		      if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Mandatory"))
 				{
 					if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Mandatory")) {
 						  p.setReportingEntityId(protect.getReportingEntityId());
 			    	}else
 			    		 p.setReportingEntityId("");
 			    	if(fieldValues.get("protectionId").equalsIgnoreCase("Mandatory")) {
 			    		 p.setProtectionId(protect.getProtectionId());
 			    	}else
 			    		p.setProtectionId("");
 			    	if(fieldValues.get("protectionProviderId").equalsIgnoreCase("Mandatory")) {
 			    		p.setProtectionProviderId(create.createprotectionProviderId());
 			    	}else
 			    		p.setProtectionProviderId("");
 			      	if(fieldValues.get("typeOfProtection").equalsIgnoreCase("Mandatory")) {
 			      		 p.setTypeOfProtection(create.createtypeOfProtection());
 			    	}else
 			    		p.setTypeOfProtection("");
 			    	
 			      	if(fieldValues.get("currencyType").equalsIgnoreCase("Mandatory")) {
 			      	  p.setCurrencyType(create.createcurrencyType());
 			    	}else
 			    		 p.setCurrencyType("");
 			      	if(fieldValues.get("protectionValue").equalsIgnoreCase("Mandatory")) {
 			      		 p.setProtectionValue(create.createprotectionValue());
 			    	}else
 			    		p.setProtectionValue("");
 			      	if(fieldValues.get("Type Of Protection Value").equalsIgnoreCase("Mandatory")) {
 			      		 p.setTypeOfProtectionValue(create.createtypeOfProtectionValue());
 			    	}else
 			    		 p.setTypeOfProtectionValue("");
 			      	if(fieldValues.get("Protection Valuation Approach").equalsIgnoreCase("Mandatory")) {
 			      		p.setProtectionValuationApproach(create.createprotectionValuationApproach());
 			    	}else
 			    		p.setProtectionValuationApproach("");
 			      	if(fieldValues.get("Date of protection value").equalsIgnoreCase("Mandatory")) {
 			      		p.setDateOfProtectionValue(create.createdateOfProtectionValue());
 			    	}else
 			    		p.setDateOfProtectionValue("");
 			      	if(fieldValues.get("originalProtectionValue").equalsIgnoreCase("Mandatory")) {
 			      	  p.setOriginalProtectionValue(create.createoriginalProtectionValue());
 			    	}else
 			    		 p.setOriginalProtectionValue("");
 			      	if(fieldValues.get("Date Of OriginalProtectionValue").equalsIgnoreCase("Mandatory")) {
 			      		p.setDateOfOriginalProtectionValue(create.createdateOfOriginalProtectionValu());
 			    	}else
 			    		p.setDateOfOriginalProtectionValue("");
 			      	if(fieldValues.get("Protection Registry Id").equalsIgnoreCase("Mandatory")) {
 			      	     p.setProtectionRegistryId(create.createprotectionRegistryId());
 			    	}else
 			    		 p.setProtectionRegistryId("");
 			      	if(fieldValues.get("Protection External Id").equalsIgnoreCase("Mandatory")) {
 			      		p.setProtectionExternalId(create.createprotectionExternalId());
 			    	}else
 			    		p.setProtectionExternalId("");

 				}
 				 if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Optional")) {
 					 if(fieldValues.get("ReportingEntityId").equalsIgnoreCase("Optional")) {
 						  p.setReportingEntityId(protect.getReportingEntityId());
 			    	}else
 			    		 p.setReportingEntityId("");
 			    	if(fieldValues.get("protectionId").equalsIgnoreCase("Optional")) {
 			    		 p.setProtectionId(protect.getProtectionId());
 			    	}else
 			    		p.setProtectionId("");
 			    	if(fieldValues.get("protectionProviderId").equalsIgnoreCase("Optional")) {
 			    		p.setProtectionProviderId(create.createprotectionProviderId());
 			    	}else
 			    		p.setProtectionProviderId("");
 			      	if(fieldValues.get("typeOfProtection").equalsIgnoreCase("Optional")) {
 			      		 p.setTypeOfProtection(create.createtypeOfProtection());
 			    	}else
 			    		p.setTypeOfProtection("");
 			    	
 			      	if(fieldValues.get("currencyType").equalsIgnoreCase("Optional")) {
 			      	  p.setCurrencyType(create.createcurrencyType());
 			    	}else
 			    		 p.setCurrencyType("");
 			      	if(fieldValues.get("protectionValue").equalsIgnoreCase("Optional")) {
 			      		 p.setProtectionValue(create.createprotectionValue());
 			    	}else
 			    		p.setProtectionValue("");
 			      	if(fieldValues.get("Type Of Protection Value").equalsIgnoreCase("Optional")) {
 			      		 p.setTypeOfProtectionValue(create.createtypeOfProtectionValue());
 			    	}else
 			    		 p.setTypeOfProtectionValue("");
 			      	if(fieldValues.get("Protection Valuation Approach").equalsIgnoreCase("Optional")) {
 			      		p.setProtectionValuationApproach(create.createprotectionValuationApproach());
 			    	}else
 			    		p.setProtectionValuationApproach("");
 			      	if(fieldValues.get("Date of protection value").equalsIgnoreCase("Optional")) {
 			      		p.setDateOfProtectionValue(create.createdateOfProtectionValue());
 			    	}else
 			    		p.setDateOfProtectionValue("");
 			      	if(fieldValues.get("originalProtectionValue").equalsIgnoreCase("Optional")) {
 			      	  p.setOriginalProtectionValue(create.createoriginalProtectionValue());
 			    	}else
 			    		 p.setOriginalProtectionValue("");
 			      	if(fieldValues.get("Date Of OriginalProtectionValue").equalsIgnoreCase("Optional")) {
 			      		p.setDateOfOriginalProtectionValue(create.createdateOfOriginalProtectionValu());
 			    	}else
 			    		p.setDateOfOriginalProtectionValue("");
 			      	if(fieldValues.get("Protection Registry Id").equalsIgnoreCase("Optional")) {
 			      	     p.setProtectionRegistryId(create.createprotectionRegistryId());
 			    	}else
 			    		 p.setProtectionRegistryId("");
 			      	if(fieldValues.get("Protection External Id").equalsIgnoreCase("Optional")) {
 			      		p.setProtectionExternalId(create.createprotectionExternalId());
 			    	}else
 			    		p.setProtectionExternalId("");
 				 }
 				 con.add(p);
 				  dis.protectionFileDatainsertion(myconn, p);
 				 p = null;
 				 create=null;
     }
    	}else  if(configurationData.get("GenerateDataFor").equalsIgnoreCase("Both")) {
    		int co = 0;
			 
    		for(protectionInstrument protect:createProtectionInstrumentData ){
    			co++;
   		      create = new datacreation();
   		      Protection p = new Protection();
   					  p.setReportingEntityId(protect.getReportingEntityId());
   				      p.setProtectionId(protect.getProtectionId());
   				      p.setProtectionProviderId(create.createprotectionProviderId());
   				      p.setTypeOfProtection(create.createtypeOfProtection());
   				      p.setCurrencyType(create.createcurrencyType());
   				      p.setProtectionValue(create.createprotectionValue());
   				      p.setTypeOfProtectionValue(create.createtypeOfProtectionValue());
   				      p.setProtectionValuationApproach(create.createprotectionValuationApproach());
   				      p.setDateOfProtectionValue(create.createdateOfProtectionValue());
   				      p.setOriginalProtectionValue(create.createoriginalProtectionValue());
   				      p.setDateOfOriginalProtectionValue(create.createdateOfOriginalProtectionValu());
   				      p.setProtectionRegistryId(create.createprotectionRegistryId());
   				      p.setProtectionExternalId(create.createprotectionExternalId());		 
   		  con.add(p);  
   		  dis.protectionFileDatainsertion(myconn, p);
   		if(temporaryprotectionIndexes.contains(co)) {
            
            String protectionprovider = null;
            for(int i =0;i<=providerid.size();i++) {
            	protectionprovider=providerid.get(i);
            	p.setProtectionProviderId( protectionprovider);
            	providerid.remove(protectionprovider);
            	break;
            	}
            }
              else {
              p.setProtectionProviderId(p.getProtectionId());
              }
   		  p = null;
   		  create=null;
    		}
    	}
        dis.destroytable(myconn,"temporaryprotection");
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
        //Collections.shuffle(con);
        return con;
    }

}