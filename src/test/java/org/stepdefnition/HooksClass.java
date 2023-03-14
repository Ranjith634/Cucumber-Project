package org.stepdefnition;

import org.bas.BaseClass;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HooksClass extends BaseClass{

	
	@Before(order=2)
	//pre-condition
	private void precondition3() {
		// TODO Auto-generated method stub
launchbrowser();
System.out.println("Launch the browser");
	}
	
	@Before(order=1)
	private void precondition1(){
		// TODO Auto-generated method stub
 windowMaximize();
System.out.println("Max the window");
	}
	
	@Before(order=3)
	private void precondition2() {
		// TODO Auto-generated method stub
System.out.println("Precondition 3");
	}
	@After
	//postcondition
	private void postcondition2() {
		// TODO Auto-generated method stub
		System.out.println("Take screenshot of scenarios ");
		closeEntireBrowser();
	}
	
	private void postcondition1() {
		// TODO Auto-generated method stub
		closeEntireBrowser();
	}
	
	
}
