package chowdary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Repository 
{
	public static WebDriver driver;
	public static void launch(String browser,String  url)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "E://Selenium//chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			
		}
		else
		{
			System.out.println("invalid browser");
		}
		
		driver.get(url);
		
		//Verify title
		/*Assert.assertTrue(driver.getTitle().contains("Mercury Tours"), "Title was not correct");
		System.out.println("Title was correct");*/
		
		String Actualtitle=driver.getTitle();
		String Expectedtitle="Welcome: Mercury Tours";
		Assert.assertEquals(Actualtitle,Expectedtitle);
		driver.findElement(Locators.reg).click();
	}
	
	public static void register()
	{
		driver.findElement(Locators.Fname).sendKeys(Testdata.Fname);
		driver.findElement(Locators.Lname).sendKeys(Testdata.Lname);
		driver.findElement(Locators.phone).sendKeys(Testdata.phone);
		driver.findElement(Locators.mail).sendKeys(Testdata.mail);
		driver.findElement(Locators.Add).sendKeys(Testdata.Add);
		driver.findElement(Locators.city).sendKeys(Testdata.city);
		driver.findElement(Locators.state).sendKeys(Testdata.state);
		driver.findElement(Locators.postal).sendKeys(Testdata.postal);
		new Select(driver.findElement(Locators.cou)).selectByVisibleText(Testdata.cou);
		driver.findElement(Locators.user).sendKeys(Testdata.user);
		driver.findElement(Locators.pass).sendKeys(Testdata.pass);
		driver.findElement(Locators.Cpass).sendKeys(Testdata.Cpass);
		driver.findElement(Locators.submit).click();
	}
	
	public static void last()
	{
		driver.close();
	}


}
