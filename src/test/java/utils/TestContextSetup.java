package utils;


import java.io.IOException;

import org.openqa.selenium.WebDriver;

import abstractComponents.AbstractComponents;
import pageObjects.PageObjectManager;

public class TestContextSetup {

	public WebDriver driver;
	public String productName;
	public PageObjectManager pageObjectManager;
	public AbstractComponents abstractComponents;
	public GenericsUtils genericsUtils;
	public BaseTest baseTest;
	
	public TestContextSetup() throws IOException
	{
		baseTest = new BaseTest();
		pageObjectManager = new PageObjectManager(baseTest.webDriverMgr());
		abstractComponents=new AbstractComponents(baseTest.webDriverMgr());
		genericsUtils=new GenericsUtils(baseTest.webDriverMgr());
	}
	
	
	
	
}
