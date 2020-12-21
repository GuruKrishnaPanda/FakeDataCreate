package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.*;
import java.util.Hashtable;

import ReUsable.datacreation;
import pojoClases.Counterparty;

public class DuplicateDataCheck {
	GenericXLSXReader xls = new GenericXLSXReader(System.getProperty("user.dir")+"\\resources\\Configuration.xlsx");
	Hashtable<String, String> configurationData = DataUtil.getData("Configuration", xls);
	Hashtable<String, String> bankingInfo = DataUtil.getData("BankMapping", xls);
	String bankSymbol = bankingInfo.get(configurationData.get("Bank_Type"));
	
	
	/*public boolean panduplicateCheck(String panNo, ArrayList<Counterparty> con) {
		// TODO Auto-generated method stub
		
		for(Counterparty cp:con) {
		if(cp.getPan().equalsIgnoreCase(panNo)){
			return true;
		  }
		
		}
		return false;
}

	public String createUniquePan(ArrayList<Counterparty> con, datacreation create) {
		
			String PanNo = create.pangenerate2();
			boolean flag = panduplicateCheck(PanNo,con);
			if(flag) {
				
				createUniquePan(con,create);
			}
			return PanNo;
		
	}*/

	public String createUniquePanNew(ArrayList<String> pan, datacreation create) {
		// TODO Auto-generated method stub
		
		String PanNo = create.pangenerate2();
		 
		if(pan.contains(PanNo)) {
			
			createUniquePanNew(pan,create);
		}
		
		return PanNo;
		
	}

	public String createUniqueAdharNew(ArrayList<String> Adhar, datacreation create) {
		// TODO Auto-generated method stub
		String adharNo=create.adharValidate();
		 
		if(Adhar.contains(adharNo)) {
			
			createUniqueAdharNew(Adhar,create);
		}
		return adharNo;
	}
	
	public String createUniquecpid(ArrayList<String> cpid, datacreation create) {
		// TODO Auto-generated method stub
		String counterid = create.createCouterpartyIdentifier(bankSymbol+"C");
		 
		if(cpid.contains(counterid)) {
			createUniquecpid(cpid, create);
		}
		return counterid ;
	}

	public String createUniqueContractNew(ArrayList<String> conid, datacreation create) {
		// TODO Auto-generated method stub
		String contract = create.createContractIdentifier();
		 
		if(conid.contains(contract)) {
			createUniqueContractNew(conid, create);
		}
		return contract;
		
		
	}

	public String createUniqueInstrumentNew(ArrayList<String> instrumentid, datacreation create) {
		// TODO Auto-generated method stub
		String instrument = create.createInstrumentId();
		 
		if(instrumentid.contains(instrument)) {
			createUniqueInstrumentNew(instrumentid, create);
		}
		return instrument;
		
	}

	public String createUniqueProtectNew(ArrayList<String> protectionid, datacreation create) {
		// TODO Auto-generated method stub
		String protection = create.createProtectionId();
		 
		if(protectionid.contains(protection)) {
			createUniqueProtectNew(protectionid, create);
		}
		return protection;
		
	}

	public String createUniqueRelNew(ArrayList<String> relno, datacreation create) {
		// TODO Auto-generated method stub
		String RelNo = create.createProtectionId();
		 
		if(relno.contains(RelNo)) {
			createUniqueRelNew(relno, create);
		}
		return RelNo;
	}

	public String createUniqueRatingIdNew(ArrayList<String> rateid, datacreation create) {
		// TODO Auto-generated method stub
		String ratingID =create.createRatingId();
		 
		if(rateid.contains(rateid)) {
			createUniqueRatingIdNew(rateid, create);
		}
		return ratingID;
	}
	}
