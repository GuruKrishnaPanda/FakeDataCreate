package Execution;





import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import ReUsable.ReusableFactory;
import ReUsable.datacreation;
import Utilities.Constants;
import Utilities.Utils;


public class MainClass {

	public static void main(String[] args)  {
		



		//Utils.archiveAvailableFiles();
		ReusableFactory ref =  new ReusableFactory(); 
		ref.createData(Constants.totalData);
		//datacreation d = new datacreation();
		//d.udyogAdharNumber();


		
	}

}
