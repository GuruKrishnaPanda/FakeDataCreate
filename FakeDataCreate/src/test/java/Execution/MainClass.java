package Execution;



import java.io.IOException;
import java.lang.reflect.Field;

import pojoClases.Contract;
import ReUsable.ReusableFactory;

import Utilities.Constants;
import Utilities.Utils;


public class MainClass {

	public static void main(String[] args)  {
		
		Utils.archiveAvailableFiles();
		ReusableFactory ref =  new ReusableFactory(); 

		ref.createData(Constants.totalData);	

		ref.createData(Constants.totalData);
		//new update


	}

}
