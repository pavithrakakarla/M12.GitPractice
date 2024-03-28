package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import genericUtilities.SeleniumUtility;

public class CreateNewContactPage extends SeleniumUtility {
	//1. Create separate POM class for every web page
	
	//2. Identify all the web elements using @FindBy and make them private
	@FindBy(name="lastname") private WebElement lastNameEdt;
	@FindBy(name="leadsource") private WebElement leadSourceDropDown;
	@FindBy(xpath="(//input[@title=\"Save [Alt+S]\"])[1]") private WebElement saveBtn;
	
	
	//3.Create a constructor for initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4: Provide Getters
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}


	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}

	
	//Rule 5 :Business Library - generic method
	
	/**
	 * This method will create contact
	 * @param lastname
	 * @param text
	 */
	public void createNewContact(String lastname) {
		lastNameEdt.sendKeys(lastname);
		saveBtn.click();
	}
	
	/**
	 * This method will create contact with Lead source drop down
	 * @param lastname
	 * @param leadSourceValue
	 */
	public void createNewContact(String lastname, String leadSourceValue) {
		lastNameEdt.sendKeys(lastname);
		handleDropDown(leadSourceDropDown, leadSourceValue);
		saveBtn.click();
	}
}
