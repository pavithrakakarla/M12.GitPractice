package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.HomePage;
import objectRepository.LoginPage;

/**
 * This class consists of basic configuration annotations of TestNG
 * @author ganta
 *
 */
public class BaseClass {
	
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public SeleniumUtility sUtil=new SeleniumUtility();
	public WebDriver driver;
	
	//For Listeners
	public static WebDriver sDriver;
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig()
	{
		System.out.println("========DB connection successful=========");
		
	}
	 //@Parameters("browser") //only for cross browser
	 //@BeforeTest    //Only for distributed parallel execution
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		String URL=pUtil.readDataFromPropertyFile("url");
		
		//driver=new ChromeDriver();
//		if(BROWSER.equals("edge"))
//		{
//			driver=new EdgeDriver();
//		}
//		else if(BROWSER.equals("firefox"))
//		{
//			driver=new FirefoxDriver();
//		}
//		else
//		{
		   driver=new ChromeDriver();
//		}
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		
		driver.get(URL);
		
		//For Listeners
		sDriver = driver;
		
		System.out.println("========Browser launch successful=========");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
	
		System.out.println("========Login to App successful=========");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		hp.logoutOfApp(driver);
		
		System.out.println("========Logout of App successful=========");
	}
	
	//@AfterTest  //Only for distributed parallel eecution
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		
		System.out.println("========Browser closure successful=========");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("==========DB closure successful===========");
	}
	

}
