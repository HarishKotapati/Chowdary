package chowdary;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testexecution extends Repository
{
public static WebDriver driver;
	@Parameters({"browser","url"})//using @parameter annotation.
	@Test(alwaysRun=true)//using @test annotations.
	public void Verifylaunch(String browser,String  url)
	{
		launch(browser,url);
	}
	
	@Test(dependsOnMethods={"Verifylaunch"},alwaysRun=false)//using dependencies(skip remaining methods if fails). can use priorities also.
	public static void verifyregistration()
	{
		register();
	}
	
	@Test(dependsOnMethods={"verifyregistration"})
	public void Verifylast()
	{
		last();
	}

}
