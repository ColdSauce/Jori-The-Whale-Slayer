package com.jori.dwai.util;

public class Logger {
	private static final boolean DEBUG_MODE = true;
	
	//Put tags you want to be shown here
	//Such as "Menu".
	
	private static final String[] TAGS = {"jori image"};
	public static void log(String whatToLog, String tag){
		if(!DEBUG_MODE){
			return;
		}
		
		for(String tempTag: TAGS){
			if(tempTag.equalsIgnoreCase(tag)){
				System.out.println(tag.toUpperCase() + ": " + whatToLog);
			}
		}
	}
	
	public static void logErr(String errorMessage, Class c){
		if(!DEBUG_MODE){
			return;
		}
		
		System.err.println("Error: " + errorMessage + "\nAt line: " + Thread.currentThread().getStackTrace()[2].getLineNumber() + " at class " + c.getCanonicalName());
	}
}
