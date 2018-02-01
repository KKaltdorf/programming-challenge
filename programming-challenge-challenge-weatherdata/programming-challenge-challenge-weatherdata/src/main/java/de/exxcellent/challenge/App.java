package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This program is calculating differences of values in csv-tables and outputs the minimal spread.
 * Two kind of datasets can be used: 1) "weather.csv" for calculation of temperature spreads
 *									 2) "football.csv" for comparison of achieved and allowed goals
 * @author Kristin Kaltdorf <kristin.kaltdorf@gmx.de>
 */
public final class App {

    public static void main(String... args) {
    	//initialize variables
	    double difference;
    	double mindifference = Double.MAX_VALUE;
    	int column1 = 1;
    	int column2 = 2;
    	String cvsSplitBy = ",";
	    String label = "";
	    String line = "";

        //load classes
    	FileHandler f = new FileHandler();
    	DataHandler d = new DataHandler();
    	f.setDirectory();									//setting directory of file
    	f.chooseDataset();
    	f.setcsvFileLocation();	    						//sets file location (file path + file name)
  	
    	if(f.csvFileName.equals("weather.csv")) {			//if data set weather is used, column 1 and 2 are compared
    		column1 = 1;
    		column2 = 2;
    	}else if(f.csvFileName == "football.csv"){			//if data set football is used, column 5 and 6 are compared
    		column1 = 5;
    		column2 = 6;
    	}
	    try (BufferedReader br = new BufferedReader(new FileReader(f.getcsvFileLocation()))) {		//read the file line by line
	 	    	
	 	      while ((line = br.readLine()) != null) {

	 	          String[] data = line.split(cvsSplitBy);			// use comma as separator
	 	          try {												//use try to skip header
	 	        	  d.setMax(data[column1]);
	 	        	  d.setMin(data[column2]);
	 	        	  d.setDifference();
	 	        	  d.checkDifferenceForNegativeValues();
	 	        	  difference = d.getDifference();
	 	        	  if(difference < mindifference) {
	 	        		  mindifference = difference;
	 	        		  label = data[0];
	 	        	  }
	 	           
	 	          }catch (Exception e) {
	 	        	  //System.out.println("Header");
	 	          }
	 	      }
	
	 	 	} catch (IOException e) {
	 	 		e.printStackTrace();
	 	 	}
	    	if(f.csvFileName.equals("weather.csv")) {				//if data set weather is used, column 1 and 2 are compared
	    		System.out.printf("Day with smallest temperature spread : %s%n", label + " with a difference of " + mindifference + "°");//dayWithSmallestTempSpread);
	    	}else if(f.csvFileName.equals("football.csv")){			//if data set football is used, column 5 and 6 are compared
	    		System.out.printf("Team with smallest goal spread       : %s%n", label + " with a difference of "+ mindifference);// teamWithSmallesGoalSpread);
	    	}
     }
}

