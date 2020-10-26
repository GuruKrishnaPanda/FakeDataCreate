package Execution;



import ReUsable.ReusableFactory;
import ReUsable.datacreation;
import Utilities.Constants;
import Utilities.Utils;


public class MainClass {

	public static void main(String[] args)  {
		
		 Utils.archiveAvailableFiles();
		 ReusableFactory ref = new ReusableFactory();
		 
		 ref.createData(Constants.totalData);




	}

}
