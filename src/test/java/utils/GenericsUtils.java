package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericsUtils {

	public WebDriver driver;
	
	
	public GenericsUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	public void goToNewWindow()
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it  = set.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
	}
	
	
	
	
	
	
	
	
}
