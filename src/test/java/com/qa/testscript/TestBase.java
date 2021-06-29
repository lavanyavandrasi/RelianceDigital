package com.qa.testscript;
	import java.io.File;
	import java.io.IOException;
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.edge.EdgeDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Parameters;

	public class TestBase 

		{
			WebDriver driver;
			 
			@Parameters({"Browser","Url"})
			@BeforeClass
			public void setUp(String Browser,String Url) throws InterruptedException
			{
				if(Browser.equalsIgnoreCase("Chrome"))
				{
					System.setProperty("webdriver.chrome.driver","C:\\Users\\Lavanya\\eclipse-workspace\\RelianceDigital\\Drivers\\chromedriver.exe");
					driver =new ChromeDriver();
					
	
					
				}
				else if(Browser.equalsIgnoreCase("edge"))
				{
					System.setProperty("webdriver.edge.driver", "C:\\Users\\Lavanya\\eclipse-workspace\\RelianceDigital\\Drivers\\msedgedriver.exe");
					driver= new EdgeDriver();
				}
				driver.manage().window().maximize();
				 
						  driver.get(Url);
						  
						 
			}
		 @AfterClass
		public void tearDown() throws InterruptedException 
			{
				driver.close();
			}
		 public void captureScreenShot(WebDriver driver,String tname) throws IOException
			{
				TakesScreenshot screenShot=(TakesScreenshot) driver;
				File Sources=screenShot.getScreenshotAs(OutputType.FILE);
				String Dest= System.getProperty("user.dir")+"/Screenshots/"+tname+".png";
				FileUtils.copyFile(Sources,new File(Dest));
				
			}
			
		}

