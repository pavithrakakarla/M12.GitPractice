package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //1. Create separate POM class for every web page
	
	//2. Identify all the web elements using @FindBy and make them private
	
	@FindBy(name = "user_name")
	private WebElement userNameEdt;
	
	@FindBy(name = "user_password") private WebElement passwordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement submitBtn;
	
	//3.Create a constructor for initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Rule 4: Provide Getters

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	//Rule 5 :Business Library - generic method
	public void loginToApp(String username,String password)
	{
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		submitBtn.click();		
	}
		
}
