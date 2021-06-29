package com.qa.testscript;


	import java.util.List;

	import org.openqa.selenium.WebElement;
	import org.testng.Reporter;
	import org.testng.annotations.Test;

   import com.qa.pages.ReliancePages;

	public class TC_Reliance_02  extends TestBase {
		@Test
		
		public void FooterLinks() {
			ReliancePages Reliance= new ReliancePages(driver);
			List<WebElement> FooterLinks= Reliance.getFooterLinks();
			System.out.println("The number of FooterLinks loaded are:" +FooterLinks.size());
			if(FooterLinks.size()<=50) {
				for(WebElement link:FooterLinks) {
					Reporter.log(link.getText());
				}
			  }else {
					Reporter.log("Incorrect number of footer Links",true);
				}
			}
			
		}
		
		




