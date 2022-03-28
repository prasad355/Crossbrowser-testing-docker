package docker;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestCase3 extends BaseTest{
	
	@Test
	public void test() throws MalformedURLException {
		
		getDriver().get("http://www.flipkart.com");
		System.out.println(getDriver().getTitle());
		
	}
	


}
