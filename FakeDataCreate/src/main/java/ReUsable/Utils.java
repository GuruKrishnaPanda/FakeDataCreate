package ReUsable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import test.Constants;

public class Utils {

	public static String generateFolderwithName() {

		try {
			Calendar c = Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");  
			String strDateFormat = "hhmmss";
			DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		    Date date = new Date();
		    String datePart = formatter.format(date);
		    String timePart =dateFormat.format(date);
		    String folderName = Constants.ReportingMemberID+"-"+datePart+"-"+timePart;
		    System.out.println(folderName);
		    Path path = Paths.get(Constants.fileLocation+folderName); 

			  Files.createDirectories(path);

			  System.out.println("Directory is created!");
			  return folderName;

			} catch (IOException e) {

			  System.err.println("Failed to create directory!" + e.getMessage());

			}
		return null;
		
		
	}

	public static void compressFolder(String folderName) {
		
		
	}

	public static void archiveAvailableFiles() {
		
		
	}

}
