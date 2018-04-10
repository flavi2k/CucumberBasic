package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinition.Hooks;

public class HomePage {

	WebDriver driver = Hooks.driver;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	private String url = "https://demo.totaralms.com/";

	@FindBy(css = ".usermenu .link-as-button.btn.btn-primary.btn-xs.btn-small")
	private WebElement loginBtn;

	@FindBy(css = ".login")
	private WebElement notLoggedInText;

	public void goToLoginPage() {
		loginBtn.click();
	}

	public void goToHome() {
		driver.get(url);
	}

	public void verifyLogOut() {
		Assert.assertTrue(notLoggedInText.getText().contains("You are not logged in."));
	}
}
