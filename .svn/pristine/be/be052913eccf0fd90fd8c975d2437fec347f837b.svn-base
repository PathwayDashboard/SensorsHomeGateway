package it.eng.utility;

import java.util.logging.Logger;

public class CloudLogger {
	
	public static Logger logger=Logger.getLogger("it.eng.sensors.home.gateway");
	
	public static void printMethod(){
		logger.fine("Invoked: "+getMethod());
	}

	private static String getMethod() {
		return getMethod(4);
	}
	
	private static String getMethod(int stackDeep) {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		StackTraceElement element=stackTraceElements[stackDeep];
		String toRet=(element.getClassName()+"."+element.getMethodName());
		return toRet;
	}
	
}
