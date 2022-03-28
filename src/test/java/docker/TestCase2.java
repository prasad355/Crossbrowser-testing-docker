package docker;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestCase2 extends BaseTest{
		
		@Test
		public void test() throws MalformedURLException {
			
			getDriver().get("http://www.facebook.com");
			System.out.println(getDriver().getTitle());
			
		}
		
	}
	



