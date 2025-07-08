package ksp.admin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id = "username")
	private WebElement Username;
	
	@FindBy(id = "password")
	private WebElement Password;
	
	@FindBy(xpath = "//button[@class='btn btn-primary w-100 login-button' and 'Login']")
	private WebElement LoginButton;
	
	@FindBy(xpath = "//a[@class='d-block text-end forgot-password mb-0 mt-2']")
	private WebElement ForgotPassword;
	
	@FindBy(id = "togglePassword")
	private WebElement visibilityButton;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void setLogin(String Username, String Password) throws InterruptedException {
		this.Username.sendKeys(Username);
		Thread.sleep(2000);
		this.Password.sendKeys(Password);
		Thread.sleep(2000);
		LoginButton.click();
		Thread.sleep(2000);
	}
}
