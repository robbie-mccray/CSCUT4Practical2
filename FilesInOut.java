import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;
import java.text.SimpleDateFormat;

/**
 * 
 * CSCU9T4 Java strings and files exercise.
 *
 */
public class FilesInOut { 

    public static void main(String[] args) {
        // Replace this with statements to set the file name (input) and file name (output).
        // Initially it will be easier to hardcode suitable file names.
    	Scanner in = new Scanner(System.in);
    	
    	PrintWriter outputFile = null;
    	
    	String filename = "formattedmu.txt";
    	
    	System.out.println("supply filename for output: ");
    	try {
    		outputFile = new PrintWriter(filename);;
    	} catch (FileNotFoundException e) {
    		System.err.println("FileNotFoundException: " + e.getMessage()
    		+ " not openable");
    		System.exit(0);
    	}
    	
    	System.out.println("supply filename for input: ");
    	try {
    		String inputFileName = in.nextLine();
    		File inputFile = new File(inputFileName) ;
    		Scanner inFile = new Scanner(inputFile);
    		
    		
    		while (inFile.hasNextLine()) {
    			Date Date = null;
    			String formattedDate = null;
    			
    			String line = inFile.nextLine();
    			String [] part = line.split("(?<=\\D)(?=\\d)");
    			
    			String strName = part[0];
    			String strDate = part[1];
    			
    			//Formatting Name
    			strName = FilesInOut.capitalise(strName);
    			
    			// Formatting Date
    			try {
    				SimpleDateFormat originalformat = new SimpleDateFormat("ddMMyyyy");
        			Date = originalformat.parse(strDate);
        			
        			SimpleDateFormat newformat = new SimpleDateFormat("dd/MM/yyyy");
        			formattedDate = newformat.format(Date);
    			} catch (java.text.ParseException e) {
    				e.printStackTrace();
    			}
    			// Printing for testing
    			System.out.println(strName+ " " + formattedDate);
    			
    			//Write to File
    			outputFile.write(strName + " " + formattedDate + "\n");
    		}
    		inFile.close();
    		outputFile.close();
    	} catch (IOException e) {
    		System.err.println("IOException: " + e.getMessage() 
    		+ "not found");
    	}
    	
        // Set up a new Scanner to read the input file.
        // Processing line by line would be sensible here.
        // Initially, echo the text to System.out to check you are reading correctly.
        // Then add code to modify the text to the output format.
    	
        // Set up a new PrintWriter to write the output file.
        // Add suitable code into the above processing (because you need to do this line by line also.
        // That is, read a line, write a line, loop.

        // Finally, add code to read the filenames as arguments from the command line.
    	in.close();
    } // main

    public static String capitalise(String s) {
    	if ((s == null) || (s.trim().length() == 0)) {
    	       return s;
    	    }
    	    s = s.toLowerCase();
    	    char[] cArr = s.trim().toCharArray();
    	    cArr[0] = Character.toUpperCase(cArr[0]);
    	    for (int i = 0; i < cArr.length; i++) {
    	       if (cArr[i] == ' ' && (i + 1) < cArr.length) {
    	         cArr[i + 1] = Character.toUpperCase(cArr[i + 1]);
    	       }
    	       if (cArr[i] == '-' && (i + 1) < cArr.length) {
    	         cArr[i + 1] = Character.toUpperCase(cArr[i + 1]);
    	       }
    	       if (cArr[i] == '\'' && (i + 1) < cArr.length) {
    	         cArr[i + 1] = Character.toUpperCase(cArr[i + 1]);
    	       }
    	    }
    	    return new String(cArr);
    	  }
} // FilesInOut
