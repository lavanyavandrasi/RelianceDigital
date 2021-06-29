package com.qa.testscript;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.ReliancePages;
import com.qa.utility.ExcelUtility;


public class TC_Reliance_01 extends TestBase {
	
		@Test(dataProvider="getData")
		public void Search(String ItemName) throws InterruptedException, IOException
		{
     		ReliancePages Reliance =new ReliancePages(driver);
			Reliance.getSearchBar().sendKeys(ItemName);
	        Reliance.getSearchBtn().click();
			Thread.sleep(4000);
			Reliance.getSearchBtn().click();
			Thread.sleep(2000);
            List<WebElement> ItemNames =Reliance.getCategoryName();
			
			System.out.println("total no of items loaded are:" +ItemNames.size());


			for (WebElement Item:ItemNames)
			{
			 Reporter.log(Item.getText(),true);
			}
			
			Reliance.getSearchBar().sendKeys(Keys.ENTER);
			
			String title=driver.getTitle();
		     if(title.contains(ItemName))
		     {
				 Reporter.log("Item is Searched",true);
		      Assert.assertTrue(true);
			}
			else
			{
				captureScreenShot(driver,"Search");
				Reporter.log("Item is not searched",true);
				Assert.assertTrue(false);

			}
			
		}
			@DataProvider
			public String[][] getData() throws IOException
			{
				String xFile ="C:\\Users\\Lavanya\\eclipse-workspace\\RelianceDigital\\src\\test\\java\\com\\qa\\testdata\\Data.xlsx";
				String xSheet ="Sheet1";
				
				int rowCount =ExcelUtility.getRowCount(xFile, xSheet);
				int cellCount =ExcelUtility.getCellCount(xFile, xSheet, rowCount);
				
				String[][] data =new String[rowCount][cellCount];
				
				for(int i=1;i<=rowCount;i++) {
					for(int j=0;j<cellCount;j++)
					{
						data[i-1][j]=ExcelUtility.getCellData(xFile, xSheet, i, j);
				}
				}
				return data;
			}
		
		}
		
			

	
