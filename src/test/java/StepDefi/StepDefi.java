package StepDefi;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;


public class StepDefi extends BaseClass {
	
	@Before
    public void setUp() {
		
         readConfig = new ReadConfig();
		
		//Initialize logger
		log = LogManager.getLogger("StepDef");

		System.out.println("Setup-Sanity method executed..");

		String browser = readConfig.getBrowser();
		
		//launch browser
		switch(browser)
		{
		case "chrome":
			System.setProperty("webdriver.chrome.driver","msedgedriver.exe");
		    driver=new EdgeDriver();;
			break;

		case "msedge":
			System.setProperty("webdriver.edge.driver","msedgedriver.exe");
		    driver=new EdgeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver","msedgedriver.exe");
		    driver=new EdgeDriver();
			break;
		default:
			driver = null;
			break;
		}
//			    System.setProperty("webdriver.edge.driver","msedgedriver.exe");
//			    driver=new EdgeDriver();
			    
			    log.info("Setup is executed");
			    log.fatal("Setup is executed");
		}
  	    
    
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		
		
	    
	    lp=new LoginPage(driver);
	    
	    cp=new AddNewCustomerPage(driver);
	    
	    sp=new SearchCustomerPage(driver);
	    log.info("user launch edge browser");
	    
	}
	

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
	   // to open url we used get method
		
		driver.get(url);
		
		 log.info("User get URL");
	}

	
	
	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String uname, String pwd) {
	    
		lp.enterEmail(uname);
		lp.enterPassword(pwd);
		
		 log.info("user enter username and password");
	}

	
	
	@When("Click on Login")
	public void click_on_login() {

		lp.clickOnLoginButton();
		
		 log.info("user enter login");
	}
	
	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
	  
		String actualTitle=driver.getTitle();

		if(actualTitle.equals(expectedTitle))
		{
	        log.warn("login page title is mathed");
			
			Assert.assertTrue(true);//pass
		}
		else
		{
			log.warn("login page title not mathed");
			
			Assert.assertTrue(false);//fail
			
		}

		
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
	   
		lp.clickOnLogOutButton();
		
		log.info("user click log out");
	}
//
	///      close step defi madhe add ////////
//	@Then("close browser")
//	public void close_browser() {
//
//          driver.close();
//          driver.quit();
//		
//	}
	
	/////////////////////// Add new customer//////////////////////////////
	
	@Then("User can view Dashboad")
	public void user_can_view_dashboad() {
	   
		String actualTitle = driver.getTitle();
		String expectedTitle = "Dashboard / nopCommerce administration";

		if(actualTitle.equals(expectedTitle))
		{
			log.info("User can view Dashboad");
			
			Assert.assertTrue(true);

		}
		else
		{
			Assert.assertTrue(false);
			
		}
		
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() {
		
//		JavascriptExecutor j = (JavascriptExecutor) driver;
//		j.executeScript("arguments[0].click();", cp.clickOnCustomersMenu());
		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		log.info("User click on customers Menu");
 
		cp.clickOnCustomersMenu();
		
	 
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() {
		
		cp.clickOnCustomersMenuItem();
		log.info("customer menu item clicked");
	    
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
		
		cp.clickOnAddnew();
		log.info("clicked on add new button.");

	  
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		
		String actualTitle = cp.getPageTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";

		if(actualTitle.equals(expectedTitle))
		{
			log.info("User can view Add new customer page- passed");

			
			Assert.assertTrue(true);//pass
		}
		else
		{
			log.info("User can view Add new customer page- failed");
			
			Assert.assertTrue(false);//fail
		}
	    
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		
		        //cp.enterEmail("cst2945@gmail.com");
		
				cp.enterEmail(generateEmailId() + "@gmail.com");
				cp.enterPassword("test1");
				cp.enterFirstName("Prachi");
				cp.enterLastName("Gupta");
				cp.enterGender("Female");
				cp.enterDob("6/13/1988");
				cp.enterCompanyName("CodeStudio");
				cp.enterAdminContent("Admin content");
				cp.enterManagerOfVendor("Vendor 1");
	  
				log.info("customer information is entered");
	}

	@When("click on Save button")
	public void click_on_save_button() {
		
		cp.clickOnSave();
		
		log.info("clicked on save button");
	   
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String exptectedConfirmationMsg) {
	    
		String bodyTagText = driver.findElement(By.tagName("Body")).getText();
		if(bodyTagText.contains(exptectedConfirmationMsg))
		{
			Assert.assertTrue(true);//pass
			
			log.info("User can view confirmation message - passed");

			
		}
		else
		{
			log.warn("User can view confirmation message - failed");
			
			Assert.assertTrue(false);//fail

		}
	}
	
	////////////////////////////search customer by email//////////////////////////////
	
	@When("Enter customer EMail")
	public void enter_customer_e_mail() {
		sp.enterEmailAdd("victoria_victoria@nopCommerce.com");
		
		log.info("Email address entered");
		

	}

	@When("Click on search button")
	public void click_on_search_button() {
		sp.clickOnSearchButton();
		
		log.info("Clicked on search button.");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {
		String expectedEmail = "victoria_victoria@nopCommerce.com";

		//   Assert.assertTrue(SearchCustPg.searchCustomerByEmail(expectedEmail));

		if( sp.searchCustomerByEmail(expectedEmail) ==true)
		{
			Assert.assertTrue(true);
			
			log.info("User should found Email in the Search table - passed");
			

		}
		else {
			
			log.info("User should found Email in the Search table - passed");
			
			Assert.assertTrue(false);

		}


	}
	
	//////////////////////search customer by name ////////////////////////
	

	@When("Enter customer FirstName")
	public void enter_customer_first_name() {
	   sp.enterFirstName("Victoria");
		
	}
	
	@When("Enter customer LastName")
	public void enter_customer_last_name() {
	   sp.enterLastName("Teres");
		
	}
	
	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() {
		
		String expectedNAme = "Victoria Teres";

		//   Assert.assertTrue(SearchCustPg.searchCustomerByEmail(expectedEmail));

		if( sp.searchCustomerByName(expectedNAme) ==true)
		{
			Assert.assertTrue(true);
			
		}
		else {
			
			Assert.assertTrue(false);
		}

		
	}



	//@After
	public void tearDown(Scenario sc) {
		System.out.println("Tear Down method executed");
		//driver.close();
//		driver.quit();
		
		if(sc.isFailed()==true)
		{
			//Convert web driver object to TakeScreenshot

			String fileWithPath = "C:\\Users\\Hp\\Two\\BDDDemo_Proj3_Hooks_FailedScreenshot\\Failed_Screenshot.png";
			TakesScreenshot scrShot =((TakesScreenshot)driver);

			//Call getScreenshotAs method to create image file
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

			//Move image file to new destination
			File DestFile=new File(fileWithPath);

			//Copy file at destination

			try {
				FileUtils.copyFile(SrcFile, DestFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//driver.quit();
		}
		
		
	@AfterStep
	public void addScreenshot(Scenario sc) {
		
		
		//if we have to take sc for each scenario then comment the if condition
		//if we have to take only failed screenshot the us if condition
		if(sc.isFailed())
		{
			final byte[] screeshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			
			//attach image file report
			sc.attach(screeshot, "image.png", sc.getName());			
			
		}
	}

}

