package de.exxcellent.challenge;
/**
*includes all methods for handling the content of the input data
*/
public class DataHandler {
	double difference;
	double max;
	double min;
	String label = "";
	
	//sets the label name (day or football team)
	void setLabel(String l) {
		label = l;
	}
	//returns the label name (day or football team)
	String getLabel() {
		return label;
	}
	//sets the max value
	void setMax(String mx) {
		max = Double.parseDouble(mx);
	}
	//returns the max value
	double getMax() {
		return max;
	}
	//sets the min value
	void setMin(String mn) {
		min = Double.parseDouble(mn);
	}
	//returns the min value
	double getMin() {
		return min;
	}
	//calculates the difference of two values max and min
	void setDifference() {
		difference = max - min;
	}
	//returns the difference between max and min
	double getDifference() {
		return difference;
	}
	//checks whether the difference is negative. If yes, difference is multiplied by -1.
	void checkDifferenceForNegativeValues() {
		if (difference < 0) {
			difference = difference *-1;
		}
	}
}
