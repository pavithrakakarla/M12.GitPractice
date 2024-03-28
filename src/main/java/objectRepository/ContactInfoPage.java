package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	//1. Create separate POM class for every web page
	
	//2. Identify all the web elements using @FindBy and make them private
	@FindBy(xpath ="//span[@class=\"dvHeaderText\"]")
	private WebElement contactHeaderText;
	
	//3.Create a constructor for initialization
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4: Provide Getters
	public WebElement getContactHeaderText() {
		return contactHeaderText;
	}
	
		
	//Rule 5 :Business Library - generic method
	/**
	 * This method will capture the hader text and return it to the caller
	 * @return
	 */
	public String captureHeaderText() {
		return contactHeaderText.getText();
	}
}
