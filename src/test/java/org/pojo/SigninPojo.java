package org.pojo;

import org.bas.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPojo extends BaseClass {

	
	public SigninPojo(){
		PageFactory.initElements(driver, this);

		
		
	}
}
