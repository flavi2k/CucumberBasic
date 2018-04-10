package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSteps {
	
	public WebDriver driver = Hooks.driver;
	
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() {
		driver.get("https://demo.totaralms.com/");
	}

	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() {
		driver.findElement(By.cssSelector(".usermenu .link-as-button.btn.btn-primary.btn-xs.btn-small")).click();
	}

	@When("^User enters UserName and Password$")
	public void user_enters_UserName_and_Password() {
		driver.findElement(By.id("username")).sendKeys("trainer"); 	 
	    driver.findElement(By.id("password")).sendKeys("trainer");
	    driver.findElement(By.id("loginbtn")).click();
	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() {
		System.out.println("Login Successfully");
		
		Assert.assertTrue(driver.findElement(By.cssSelector("#action-menu-toggle-0 .usertext")).getText().contains("William Johnson"));
	}

	@When("^User LogOut from the Application$")
	public void user_LogOut_from_the_Application() {
		user_is_on_Home_Page();
		user_Navigate_to_LogIn_Page();
		user_enters_UserName_and_Password();
		driver.findElement (By.cssSelector(".link-as-button")).click();
	}

	@Then("^Message displayed LogOut Successfully$")
	public void message_displayed_LogOut_Successfully() {
		System.out.println("LogOut Successfully");
		Assert.assertTrue(driver.findElement(By.cssSelector(".login")).getText().contains("You are not logged in."));
	}
}
