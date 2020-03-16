package com.svecw.loggingForHouse;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class LogHouse{
	private static final Logger LOGGER = LogManager.getLogger(LogHouse.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LogCalculate cal = new LogCalculate();
		String filename = "ResultArea.ser";
		Scanner scan = new Scanner(System.in);
		LOGGER.info("Enter Your Type Of Material:");
		LOGGER.info("1.StandardMaterial");
		LOGGER.info("2.Above StandardMaterial");
		LOGGER.info("3.High StandardMaterial");
		LOGGER.info("4.High StandardMaterial and AutomatedHome");
		LOGGER.info("Enter your choice:");
		int choice = scan.nextInt(); 
		LOGGER.error("Enter no.of Squarefeets:");
		double cost = scan.nextDouble();
		try {
			FileOutputStream file = new FileOutputStream(filename); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
            out.writeObject(cal); 
    		switch(choice) {
    		case 1:LOGGER.info("\n Construction cost per StandardMaterial: "+cal.calculate(cost,1200));
    		break;
    		case 2:LOGGER.info("\n Construction cost per Above StandardMaterial:"+cal.calculate(cost,1500));
    		break;
    		case 3:LOGGER.info("\n Construction cost per High StandardMaterial:"+cal.calculate(cost,1800));
    		break;
    		case 4:LOGGER.info("\n Construction cost per StandardMaterial and AutomatedHome:"+cal.calculate(cost,2500));
    		break;
    		default:LOGGER.info("\n Invalid Input...");
    		}
            out.close(); 
            file.close();  
            LOGGER.info("\n Object has been serialized."); 
  
        } 
          
        catch(IOException ex) 
        { 
            LOGGER.info("IOException is caught"); 
        } 

		scan.close();
	}

}
