package com.mastering.vraptor.controller;

public class MyCustomLogger implements MyLogger  {

	public void log(String message) {
		System.out.println("::LOG:: - " + message);
	}

}
