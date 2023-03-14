package org.stepdefnition;

import org.bas.BaseClass;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Fblogin extends BaseClass {

	
	Fblogin f;
	
@Given("To launch the browser and maximize the window")
public void to_launch_the_browser_and_maximize_the_window() {
    // Write code here that turns the phrase above into concrete actions
	launchbrowser();
	windowMaximize();
}

@When("to launch the URL of icici bank login")
public void to_launch_the_URL_of_icici_bank_login() {
    // Write code here that turns the phrase above into concrete actions
	
	 launchUrl("https://www.myntra.com/");
}

@When("To pass the user id in user address")
public void to_pass_the_user_id_in_user_address() {
    // Write code here that turns the phrase above into concrete actions
	f= new Fblogin();
	passText("raysdfhasdvs", f.getEmail());
}
private WebElement getEmail() {
	// TODO Auto-generated method stub
	return null;
}

@Then("to close the chrome browser")
public void to_close_the_chrome_browser() {
    // Write code here that turns the phrase above into concrete actions
}

}