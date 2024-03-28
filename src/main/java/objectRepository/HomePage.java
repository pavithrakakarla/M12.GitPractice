package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class HomePage extends SeleniumUtility {
	//1. Create separate POM class for every web page
	
	//2. Identify all the web elements using @FindBy and make them private
	
	//Declaration-Web elements
	
	@FindBy(linkText = "Contacts") 
	private WebElement contactsLnk;
	
	@FindBy(xpath="//a[text()=\"Products\"]")
	private WebElement productsLnk;
	
	@FindBy(xpath = "(//a[text()=\"Leads\"])[1]") 
	private WebElement leadsLnk;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]") 
	private WebElement administratorImg;
	
	@FindBy(linkText ="Sign Out")
	private WebElement signOutLnk;
	
	//3.Create a constructor for initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule 4: Provide Getters
		public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getLeadsLnk() {
		return leadsLnk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
	
	//Rule 5 :Business Library - generic method
	/**
	 * This method will click on Contacts Link in Home page
	 */
	public void clickOnContactsLink()
	{
		contactsLnk.click();		
	}
	
	/**
	 * This method will logout of the Application
	 * @param driver
	 * @throws InterruptedException 
	 */
	public void logoutOfApp(WebDriver driver) throws InterruptedException
	{
		mouseHoverAction(driver, administratorImg);
		Thread.sleep(1000);
		signOutLnk.click();
	}
}
