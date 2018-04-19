package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainerPage {

	
	@FindBy(css="#action-menu-toggle-0 .usertext")
	private WebElement userText;
	
	@FindBy(css=".link-as-button")
	private  WebElement logoutBtn;
	
	public TrainerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void verifyLogIn(){
	Assert.assertTrue(userText.getText().contains("William Johnson"));
	}
	
	public void logOut() {
		logoutBtn.click();
	}
}
