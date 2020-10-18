package test;



import java.lang.reflect.Field;

import pojoClases.Contract;
import pojoClases.datacreation;
import ReUsable.ReusableFactory;
import ReUsable.Utils;


public class MainClass {

	public static void main(String[] args) {
		
		Utils.archiveAvailableFiles();
		ReusableFactory ref =  new ReusableFactory(); 
		ref.createData(Constants.totalData);
		//datacreation d =  new datacreation();
		//d.casteGeneration();
		
		
		//Utils.generateFolderwithName();
		
		
	}

}
