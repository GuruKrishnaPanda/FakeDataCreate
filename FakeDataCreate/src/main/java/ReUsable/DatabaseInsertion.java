package ReUsable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;

import Utilities.DataUtil;
import Utilities.DuplicateDataCheck;
import Utilities.GenericXLSXReader;
import pojoClases.Counterparty;

public class DatabaseInsertion {
	GenericXLSXReader xls = new GenericXLSXReader(System.getProperty("user.dir")+"\\resources\\Configuration.xlsx");
	Hashtable<String, String> configurationData = DataUtil.getData("Configuration", xls);
	Hashtable<String, String> bankingInfo = DataUtil.getData("BankMapping", xls);
	String bankSymbol = bankingInfo.get(configurationData.get("Bank_Type"));	

public Statement myStmt=null;
public String createUniquePan(Connection myconn, datacreation create) {
String PanNoNew= create.pangenerate2();
try {

myStmt=myconn.createStatement();
String sql = "select count(*) from counterparty where pan='"+PanNoNew+"'";

ResultSet rs = myStmt.executeQuery(sql);
rs.next();
int pan=rs.getInt("count(*)");

if(pan>=1)

{

   createUniquePan(myconn,create);
}
//myconn.close();
} catch (SQLException e) {

 e.printStackTrace();
}
return PanNoNew;

}


public void counterpartyDatainsertion(Connection myconn, Counterparty cp) {

try {

myStmt=myconn.createStatement();
String sql = "insert into counterparty(reportingEntityId,counterpartyId,name,dateOfBirthOrIncorporation,caste ,community,pan,aadhaar,din,cin,lei,tan,gstin,udyogAadhaar,typeOfOrganisation,borrowerCategory,sicOrNicCode,occupationCode,addressLine1,addressLine2,addressLine3,pinCode,stateCode,districtCode,countryCode,telephoneNumber,mobileNumber,emailAddress)values ('"+cp.getReportingEntityId()+"','"+cp.getCounterypartyId()+"','"+cp.getName()+"','"+cp.getDate()+"','"+cp.getCasteGen()+"','"+cp.getCommGen()+"','"+cp.getPan()+"','"+cp.getAdharNo()+"','"+cp.getDin()+"','"+cp.getCin()+"','"+cp.getLei()+"','"+cp.getTan()+"','"+cp.getGstin()+"','"+cp.getUdyogAadhaar()+"','"+cp.getTypeOrg()+"','"+cp.getBurrrower()+"','"+cp.getNicCode()+"','"+cp.getOccupationCode()+"','"+cp.getAddressLine1()+"','"+cp.getAddressLine2()+"','"+cp.getAddressLine3()+"','"+cp.getPinCode()+"','"+cp.getStateCode()+"','"+cp.getDistrictCode()+"','"+cp.getCountryCode()+"','"+cp.getTelePhoneNumber()+"','"+cp.getMobNo()+"','"+cp.getEmailAddress()+"')";
myStmt.executeUpdate(sql);
} catch (SQLException e) {
e.printStackTrace();
}

}
public String createUniqueCid(Connection myconn, datacreation create) {
	
	String New_counterid= create.createCouterpartyIdentifier(bankSymbol+"C");
	
	try {

        myStmt=myconn.createStatement();
        String sql = "select count(*) from counterparty where counterpartyId='"+New_counterid+"'";

         ResultSet rs = myStmt.executeQuery(sql);
         rs.next();
         int cpId=rs.getInt("count(*)");

         if(cpId>=1)

       {

           createUniqueCid(myconn,create);
       }
         } catch (SQLException e) {

         e.printStackTrace();
             }
         return New_counterid;

}

             }
