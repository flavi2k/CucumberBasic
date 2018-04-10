package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id="username")
	private  WebElement usernameInput;
	
	@FindBy(id="password")
	private  WebElement passwordInput;
	
	@FindBy(id="loginbtn")
	private  WebElement loginBtn;
	
	@FindBy(css=".error")
	private  WebElement errorMessage;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public  void loginPositive(){
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
