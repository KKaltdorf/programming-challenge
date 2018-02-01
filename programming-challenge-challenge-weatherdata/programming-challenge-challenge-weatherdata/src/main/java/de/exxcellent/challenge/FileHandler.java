package de.exxcellent.challenge;

import javax.swing.JOptionPane;

/**
*includes all methods for handling of the input file
*/
public class FileHandler {
	//initializing variables
	String csvFileLocation = "";
	String directory = "";
	String csvFileName = "";
	int chosenFile;
	
	
	//set path to directory
	void setDirectory() {
		directory = "C:\\Users\\Kristin\\Desktop\\programming-challenge-challenge-weatherdata\\programming-challenge-challenge-weatherdata\\src\\main\\resources\\de\\exxcellent\\challenge\\";
	}
	//user chooses which kind of data set should be analyzed
	void chooseDataset() {
        String[] options = {"weather.csv", "football.csv"};
        chosenFile = JOptionPane.showOptionDialog(null, "Which kind of dataset would you like to analyze?",
                "Click a button",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if(chosenFile == 0) {			//csvFileName is set depending on user choice
        	csvFileName = options[0];
        }else if(chosenFile == 1) {
        	csvFileName = options[1];
        }
	}
	void setcsvFileLocation() {
		csvFileLocation = directory.concat(csvFileName);
	}
	//csvFileLocation includes the path and the file name
	String getcsvFileLocation() {
		return csvFileLocation;
	}
}
