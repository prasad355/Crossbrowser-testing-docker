package docker;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
	 protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
   
	 
	 @BeforeTest
        void startDockerGrid() throws IOException, InterruptedException {
		
		Runtime.getRuntime().exec("cmd /c start start_dockergrid.bat");
		Thread.sleep(20000);
	}
	
	@BeforeMethod
	@Parameters(value = { "browser" })
	public void setup(String browser) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("browserName",browser);
		 driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap));


	}
	public WebDriver getDriver() {
        //Get driver from ThreadLocalMap
        return driver.get();
	}
	

    @AfterMethod
    public void tearDown() throws Exception {
    	   getDriver().quit();
    }

    @AfterClass
    void terminate () {
        //Remove the ThreadLocalMap element
        driver.remove();
    }
    @AfterTest
    void stopDockergrid() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("cmd /c start stop_dockergrid.bat");
	 Thread.sleep(10000);
	 
	 Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
	 
	}

    	
        
}
