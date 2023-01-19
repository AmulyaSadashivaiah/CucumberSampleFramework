package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.core.backend.ScenarioScoped;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	
	TestContextSetup testContextSetup;
    WebDriver driver;
	
	public Hooks(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
	}
	
	
	@After
	public void tearDown() throws IOException
	{
		testContextSetup.baseTest.webDriverMgr().quit();
	}
	
	
	
	@AfterStep
	public void getScreenShot(Scenario scenario) throws IOException
	{
		driver=testContextSetup.baseTest.webDriverMgr();
		if(scenario.isFailed())
		{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		byte[] content = FileUtils.readFileToByteArray(src);
		scenario.attach(content, "image/png", "image");
		}
		
	}
	
	
	
	
	
	
}
