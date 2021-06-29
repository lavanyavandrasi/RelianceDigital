package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReliancePages {
	WebDriver driver;
	
	@FindBy(id="RIL_HeaderLoginAndMyAccount")
	WebElement LogIn;
	public WebElement getLogIn() {
		return LogIn;
	}
	@FindBy(id="email")
	WebElement Email;
	public WebElement getEmail() {
	   return Email;
	}
	@FindBy(id="pass")
	WebElement PassWord;
	public WebElement getPassWord() {
		return PassWord;
	}
	@FindBy(xpath="//*[@id=\"root\"]/main/div/div/div/div/div/div/div/div[2]/div/div[1]/form/div/div/div[3]/button")
	WebElement ContinueBtn;
	public WebElement getContinueBtn() {
		return ContinueBtn;
	}
	@FindBy(id="suggestionBoxEle")
	WebElement SearchBar;
	public WebElement getSearchBar() {
		return SearchBar;
	}
	
	
	@FindBy(id="RIL_HomeSearchButton")
	WebElement SearchBtn;
	public WebElement getSearchBtn() {
		return SearchBtn;
	}
	@FindAll(@FindBy(className="sp__name"))
    List<WebElement> CategoryName;
	public List<WebElement> getCategoryName()
	{
		return CategoryName;
	}
	
	@FindAll(@FindBy(className="blk"))
	List<WebElement> FooterLinks;
	public List<WebElement> getFooterLinks(){
		return FooterLinks;
	
	}
	
    //@FindBy(xpath="//*[@id=\"pl\"]/div[4]/ul/li[1]/div/a/div[1]/div[2]/p")
	@FindAll(@FindBy(xpath="//div[@class='pdp_title"))
     List<WebElement> VerifyItem;
     public List<WebElement> getVerifyItem() {
	return VerifyItem;
      }

	public ReliancePages(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
		
	}

