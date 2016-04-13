package com.mastering.vraptor.logger;

public class MyCustomLogger implements MyLogger  {

	public void log(String message) {
		System.out.println("::LOG:: - " + message);
	}

}
