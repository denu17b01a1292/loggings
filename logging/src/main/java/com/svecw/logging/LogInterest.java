package com.svecw.logging;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LogInterest {
	private static final Logger LOGGER = LogManager.getLogger(LogInterest.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LogResult res = new LogResult();
		String filename  = "ResultInterest.ser";
		Scanner scan = new Scanner(System.in);
		LOGGER.error("Enter Principle Amount:");
		double principleAmount = scan.nextDouble();
		LOGGER.error("\nEnter the duration in years:");
		int time = scan.nextInt();
		LOGGER.error("\n Enter the rate of Interest:");
		double rate = scan.nextDouble();
		LOGGER.error("\n Enter the no.of times Compounded:");
		int compoundTimes = scan.nextInt();
		try {
			FileOutputStream file = new FileOutputStream(filename); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
            out.writeObject(res); 
            LOGGER.error("\n Compound Interest: "+res.compoundInterest(principleAmount,time,rate,compoundTimes));
            LOGGER.error("\n Simple Interest: "+res.simpleInterest(principleAmount,time,rate));  
            out.close(); 
            file.close();  
            LOGGER.error("\n Object has been serialized."); 
  
        } 
          
        catch(IOException ex) 
        { 
            LOGGER.error("IOException is caught"); 
        } 
		scan.close();

	}

}
