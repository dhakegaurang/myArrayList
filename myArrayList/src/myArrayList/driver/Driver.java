package myArrayList.driver;

import java.io.File;
import java.io.FileNotFoundException;
import myArrayList.MyArrayList;
import myArrayList.test.MyArrayListTest;
import myArrayList.util.FileProcessor;
import myArrayList.util.Results;
/**
* The Driver program implements an application that 
* takes input file, calls myArrayList Object
* adds up all the values and displays into output file.
*
* @author  Gaurang Dhake
* @version 1.8
* @since   06/14/18 
*/
public class Driver {
	/**
	   * This is the main method which accepts input file 
	   * Fills the values into myArrayList Object
	   * Using Result Object, it also prints to output file
	   * @param args Accepts command line arguments as array of strings
	   * @return void. Since it is main method
	   */
	public static void main(String[] args) {
		try {
			// Check if there are exactly two arguments i.e input and output file paths
			if(args.length != 2) {
				throw new IllegalArgumentException("Exception: Two arguments are needed !!");
			}
			// Checking if file actually exists
			else if(!new File(args[0]).exists()) {
				throw new FileNotFoundException("Exception: input file not found!!");
			}
			else {
				String inputFilePath = args[0];
				String outputFilePath = args[1];
				// Creating fileProcessor instance which takes input file are parameter
				FileProcessor fp = new FileProcessor(inputFilePath);
				
				// Creating myArrayList Object and passing values from input file to be inserted in it
				MyArrayList myArrayListObj = new MyArrayList(fp.readLine());
				
				//Creating myArrayListTest Object
				MyArrayListTest testObj = new MyArrayListTest();
	
				// Creating result instance and setting with output path
				Results resultObj = new Results(outputFilePath);	
				
				//Passing myArrayList object and result object to testMe method of myArrayListTest object to complete all the test cases
				testObj.testMe(myArrayListObj, resultObj);
				
				// Writing output to file
				resultObj.writeToFile(String.valueOf(myArrayListObj.sum()));
				
				// Writing output to std output
				resultObj.writeToStdout(String.valueOf(myArrayListObj.sum()));
			}
		}
		catch(IllegalArgumentException e) { // catching in case of incorrect number of arguments
			System.err.println(e.getMessage());
			System.out.println("Exiting...");
			System.exit(0);
		}
		catch(FileNotFoundException e) { // if incorrect input file path
			System.err.println(e.getMessage());
			System.out.println("Exiting...");
			System.exit(0);
		}
		catch(Exception e) { // Any other exceptions
			System.err.println("Exception: "+e.getMessage());
			System.exit(0);
		}
	}

}
