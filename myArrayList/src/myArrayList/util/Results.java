package myArrayList.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Results implements FileDisplayInterface,StdoutDisplayInterface {
	
	private String outputFilePath;
	private String resultStr;
	
	public Results(String outputFilePath) {
		this.outputFilePath = outputFilePath;
		this.resultStr = "";
	}
	/**
	   * This is method writes output on standard output
	   * @param s string to be written on standard output
	   * @return void since it doesn't return any thing
	   */	
	@Override
	public void writeToStdout(String s) {
			String content = "The sum of all the values in the array list is: "+s;
			content += resultStr;
			System.out.println(content);
	}
	/**
	   * This is method writes output in text file
	   * @param s string to be written on standard output
	   * @return void since it doesn't return any thing
	   */
	@Override
	public void writeToFile(String s) {
		try {
			Path path = Paths.get(outputFilePath);
			String content = "The sum of all the values in the array list is: "+s;
			content += resultStr;
			Files.write(path, content.getBytes());

		} catch (IOException e) {
			System.err.println("Error: failed while writing to output to file");
			System.out.println("Exiting...");
			System.exit(0);
		}
		
	}
	/**
	   * This is method stores new Test Strings in resultStr
	   * @param newTest string to be stores in resultStr
	   * @return void since it doesn't return any thing
	   */
	public void storeNewResult(String newTest) {
		resultStr += newTest;
		resultStr += "\n\n";
	}
	
	@Override
	public String toString() {
		return resultStr;
	}
	
	
}
