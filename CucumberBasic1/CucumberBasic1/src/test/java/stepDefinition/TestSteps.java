package stepDefinition;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.TrainerPage;

public class TestSteps {
	
	public WebDriver driver = Hooks.driver;
	HomePage hp = new HomePage(driver);
	LoginPage lp= new LoginPage(driver);
	TrainerPage tp= new TrainerPage(driver);
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() {
		
		hp.goToHome();
	}

	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() {
		hp.goToLoginPage();
	}

	@When("^User enters UserName and Password$")
	public void user_enters_UserName_and_Password() {
		lp.loginPositive();
	}
	
	@When("^User enters wrong credentials$")
	public void user_enters_wrong_credentials() {
		
		lp.loginNegative();
	}

	@Then("^Error message is displayed$")
	public void error_message_is_displayed() {
		lp.verifyErrorMessage();
	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() {
		System.out.println("Login Successfully");
		tp.verifyLogIn();
	}

	@When("^User LogOut from the Application$")
	public void user_LogOut_from_the_Application() {
		lp.loginPositive();
		tp.logOut();
	}

	@Then("^Message displayed LogOut Successfully$")
	public void message_displayed_LogOut_Successfully() {
		System.out.println("LogOut Successfully");
		hp.verifyLogOut();
	}
}
