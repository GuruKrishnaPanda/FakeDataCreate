package Execution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Stack;

import ReUsable.datacreation;
import Utilities.DataUtil;
import Utilities.GenericXLSXReader;

public class Mainclasstemp {

	public static void main(String[] args) {
		datacreation dis = new datacreation();
		String dataInsertion  ;
		String[] dataFetching=  new String[20];
		ArrayList<String> dataInsert =  new ArrayList<>();
 
	try {
		Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/framework","root","password");
		
	

			Statement myStmt = myconn.createStatement();
		ResultSet myRs = myStmt.executeQuery("select pan from counterparty ORDER BY RAND() LIMIT 5");
		while (myRs.next()) {
			//System.out.println(myRs.getString("pan"));
			//dataFetching = myRs.getString("pan") + ","+myRs.getString("name");
			dataInsertion =myRs.getString("pan");
			
			dataInsert.add(dataInsertion);
			
		
			//System.out.println(sb);
			if(	dataInsert.contains(dataInsertion))
			{
				
			System.out.println(dis.mobileNumber());
			String emailAddress =dis.emailAddress();
			
			}
			
			
		}
		/*String sb = myRs.getString("pan");
		System.out.println(sb);*/
		
		/*Scanner sc = new Scanner(System.in);
		String pan = sc.next();
		String Sql = "SELECT * FROM user  Where pan='" + pan +"'";
		ResultSet Rs =myStmt.executeQuery(Sql);*/
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	/*if(pan ==dis.pangenerate2())
	{
          System.out.println(dis.createCouterpartyIdentifier(bankSymbol));
	}*/


	}
}
