package de.exxcellent.challenge;

import javax.swing.JOptionPane;

import org.junit.Test;

/**
 * 
 * @author Kristin Kaltdorf <kristin.kaltdorf@gmx.de>
 */
public class AppTest {

    @Test //to check output of "chooseDataset"
    public void chooseDataset() {
    		String[] options = {"weather.csv", "football.csv"};
            int fileName = JOptionPane.showOptionDialog(null, "Which kind of dataset would you like to analyze?",
                    "Click a button",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            System.out.println(fileName);
    }

    @Test
    public void aPointlessTest() {
        //Assert.assertEquals("Expectations met", "successful", successLabel);
    }

}