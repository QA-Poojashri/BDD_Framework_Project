package StepDefi;


import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;

import Utilities.ReadConfig;

public class BaseClass {
	
	public static  WebDriver driver;
	public LoginPage lp;
	public SearchCustomerPage sp;
	public AddNewCustomerPage cp;
	
	public static Logger log;
	
	public ReadConfig readConfig;
	
	//generate unique email id
		public String generateEmailId()
		{
			return(RandomStringUtils.randomAlphabetic(5));
		}

}
