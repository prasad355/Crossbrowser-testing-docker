package docker;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DockerGrid_Setup {
	@BeforeTest
	void startDockerGrid() throws IOException, InterruptedException {
		
		Runtime.getRuntime().exec("cmd /c start start_dockergrid.bat");
		Thread.sleep(20000);
	
		
		}
	
	
	@AfterTest
	void stopDockergrid() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("cmd /c start stop_dockergrid.bat");
	 Thread.sleep(10000);
	 
	 Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
	 
	}

}
