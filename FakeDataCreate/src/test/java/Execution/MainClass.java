package Execution;



import ReUsable.ReusableFactory;
import ReUsable.datacreation;
import Utilities.Constants;
import Utilities.Utils;


public class MainClass {

	public static void main(String[] args)  {
		
		Utils.archiveAvailableFiles();
		ReusableFactory ref =  new ReusableFactory(); 
		ref.createData(Constants.totalData);
<<<<<<< HEAD
		datacreation d =  new datacreation();
		d.createprotectionAllocatedValue();
=======
		/*datacreation d =  new datacreation();
<<<<<<< HEAD
		d.createRelatedCounterepartyId();*/
		
		
		//Utils.generateFolderwithName();
		
		
=======
		d.createprotectionAllocatedValue();*/


>>>>>>> branch 'master' of https://github.com/GuruKrishnaPanda/FakeDataCreate.git
>>>>>>> refs/remotes/origin/master
	}

}
