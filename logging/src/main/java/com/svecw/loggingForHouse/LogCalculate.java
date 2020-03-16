package com.svecw.loggingForHouse;

import java.io.Serializable;


public class LogCalculate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public double calculate(double cost,int val) {
		return cost*val;
	}

}
