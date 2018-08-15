package myArrayList.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
* FileProcessor program helps in reading input file and returning stream of data
*
* @author  Gaurang Dhake
* @version 1.8
* @since   06/14/18 
*/
public class FileProcessor {
	
	private String intputFile;
	
	public FileProcessor(String intputFile) {
		this.intputFile = intputFile;
	}
	
	/**
	   * This method helps stream of data from input file
	   * @param None
	   * @return String returns stream of data
	   */
	public String readLine() {
		try {
			return new String(Files.readAllBytes(Paths.get(intputFile)));
		}
		catch(IOException e){
			System.out.println("Error: Reading Input File !!");
			System.out.println("Exiting...");
			System.exit(0);
		}
		return null;
	}
	
// Getter and Setter for input file path
	public String getFileName() {
		return intputFile;
	}


	public void setFileName(String intputFile) {
		this.intputFile = intputFile;
	}
	
}