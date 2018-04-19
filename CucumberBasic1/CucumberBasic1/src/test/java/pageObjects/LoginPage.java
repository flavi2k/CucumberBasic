package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinition.Hooks;
import waiter.Waiter;

public class LoginPage {

	@FindBy(id="username")
	private  WebElement usernameInput;
	
	@FindBy(id="password")
	private  WebElement passwordInput;
	
	@FindBy(id="loginbtn")
	private  WebElement loginBtn;
	
	@FindBy(css=".error")
	private  WebElement errorMessage;
	
	WebDriver driver = Hooks.driver;
	private Waiter waiter = new Waiter();
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	public  void loginPositive(){
		waiter.waitForPageLoadComplete(driver);
		usernameInput.sendKeys("trainer");
		passwordInput.sendKeys("trainer");
		loginBtn.click();
	}
	
	public  void loginNegative(){
		usernameInput.sendKeys("trainer");
		passwordInput.sendKeys("traine");
		loginBtn.click();
	}
	
	public  void verifyErrorMessage(){
		Assert.assertTrue(errorMessage.getText().contains("Invalid login, please try again"));
	}
}
