package Utilities;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;



public class Utils {
	//GenericXLSXReader xls = new GenericXLSXReader(System.getProperty("user.dir")+"\\resources\\Configuration.xlsx");
	Hashtable<String, String> configurationData ;
	private static final int BUFFER_SIZE = 4096;
	 
	public Utils(Hashtable<String, String> configurationData) {
		this.configurationData = configurationData;
	}

	public static String generateFolderwithName(String reportingMemberID) {
		String folderName = null;
		
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");  
			String strDateFormat = "hhmmss";
			DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		    Date date = new Date();
		    String datePart = formatter.format(date);
		    String timePart =dateFormat.format(date);
		    folderName = reportingMemberID+"-"+datePart+"-"+timePart;
		    System.out.println(folderName);
		    Path path = Paths.get(Constants.NewfileLocation+folderName); 
			  Files.createDirectories(path);
			  System.out.println("Directory is created!");
			  
			} catch (IOException e) {

			  System.err.println("Failed to create directory!" + e.getMessage());

			}
		return folderName;
			
	}

	public static void compressFolder(String folderName) {
		
		
	}
	 private void zipDirectory(File folder, String parentFolder, ZipOutputStream zos) throws FileNotFoundException, IOException {
	        for (File file : folder.listFiles()) {
	            if (file.isDirectory()) {
	                zipDirectory(file, parentFolder + "/" + file.getName(), zos);
	                continue;
	            }
	            zos.putNextEntry(new ZipEntry(parentFolder + "/" + file.getName()));
	            BufferedInputStream bis = new BufferedInputStream(
	                    new FileInputStream(file));
	            long bytesRead = 0;
	            byte[] bytesIn = new byte[BUFFER_SIZE];
	            int read = 0;
	            while ((read = bis.read(bytesIn)) != -1) {
	                zos.write(bytesIn, 0, read);
	                bytesRead += read;
	            }
	            zos.closeEntry();
	        }
	    }

	public static void archiveAvailableFiles() {
		
		 File directoryPath = new File(Constants.NewfileLocation);
	      //List of all files and directories
	      String contents[] = directoryPath.list();
	      System.out.println("List of files and directories in the specified directory is : ");
	      if(contents.length>0) {
	    	  
	    	  for(int i=0; i<contents.length; i++) {
	 	         System.out.println(contents[i]);
	 	        try {
			    	  moveFileOrDirectory(contents[i]);
			 
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	  
	 	      } 	  
	      }      
	}
	 
public static int completeinteger(String string) {
		// TODO Auto-generated method stub
	  double f=Double.parseDouble(string);
		int integer=(int)f;
		return integer;	
	}
	private static void moveFileOrDirectory(String contents) throws IOException {
		 File srcDir = new File(Constants.NewfileLocation+"\\"+contents);
		 File destDir = new File(Constants.ArchivefileLocation);
		 try {
			 FileUtils.moveDirectoryToDirectory(srcDir, destDir, true);
			 System.out.println("The File "+contents+" is Successfully archived");
		 }catch(Exception e) {
			 System.out.println(e.getStackTrace());
		 }
		 
		
		}
	
	public static void pack(String sourceDirPath, String zipFilePath) throws IOException {
	    Path p = Files.createFile(Paths.get(zipFilePath));
	    Path pp = Paths.get(sourceDirPath);
	    try (ZipOutputStream zs = new ZipOutputStream(Files.newOutputStream(p));
	        Stream<Path> paths = Files.walk(pp)) {
	        paths
	          .filter(path -> !Files.isDirectory(path))
	          .forEach(path -> {
	              ZipEntry zipEntry = new ZipEntry(pp.relativize(path).toString());
	              try {
	                  zs.putNextEntry(zipEntry);
	                  Files.copy(path, zs);
	                  zs.closeEntry();
	            } catch (IOException e) {
	                System.err.println(e);
	            }
	          });
	    }
	}

}
