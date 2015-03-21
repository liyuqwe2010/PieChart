package com.yu.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class FormatString {
	
	public static String keep1AfterPoint(BigDecimal money){
		DecimalFormat df = new DecimalFormat("0.0");
		String temp = df.format(money.doubleValue());
		return temp;
	}
	
	public static String keep2AfterPoint(BigDecimal money){
		DecimalFormat df = new DecimalFormat("0.00");
		String temp = df.format(money.doubleValue());
		return temp;
	}
	
	public static String keep3AfterPoint(BigDecimal money){
		DecimalFormat df = new DecimalFormat("0.000");
		String temp = df.format(money.doubleValue());
		return temp;
	}
	
}
