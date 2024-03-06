package HRS_Online_booking_portal.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LandingPage 
{
WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		//super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
		

	//PageFactory
	
	@FindBy(xpath = "//div[@id='DestinationSearchOpener']")
	WebElement StayLocation;
	
	@FindBy(xpath = "//input[@id='DestinationSearchInput']")
	WebElement StayLocationInput;
	
	@FindBy(css=".DateRangeInputField_checkIn__izcps")
	WebElement Checkin;
	
	@FindBy(css="DateRangeInputField_dateCheckOut__uJbuC")
	WebElement Checkout;
	
	@FindBy(id="#RoomsPersonsOpener")
	WebElement NoOfPrsn;
	
	@FindBy(id="#SearchHotelsButton")
	WebElement SearchButton;
	
	@FindBy(xpath="//div[@class='Month_week__C_XUi']")
	List<WebElement> CalenderDates;
	
	@FindBy(css=".Month_title__m8iWe")
	List<WebElement> MonthName;
	
	
	@FindBy(xpath="//button[@id='onetrust-accept-btn-handler']")
	WebElement Acceptcookie;
	
	@FindBy(xpath="//li[@data-test='DestinationList_suggestionItem']")
	WebElement locationsuggest;
	
	
	
	//-----------------------Actions----------------------------------------//

	public void searchLocation(String StyLoc) throws InterruptedException
	{
		
		StayLocation.click();
		Thread.sleep(2000);
		StayLocationInput.sendKeys(StyLoc);
		Thread.sleep(2000);
		locationsuggest.click();
		Thread.sleep(1000);
		Checkin.click();
	}
	
	public void SearchHotel(String Checkindate,String CheckOutDates) throws InterruptedException
	{
		
		Thread.sleep(2000);
		Checkin.click();
		Checkout.click();
		Checkout.sendKeys(CheckOutDates);
		SearchButton.click();
		
		
	}
	
	public List<WebElement> getDates()
	{
		
		return CalenderDates;
	}
	
	
	
	
	public void goTo() throws InterruptedException
	{
		driver.get("https://www.hrs.de/");
		Thread.sleep(2000);
		Acceptcookie.click();
	}
	
	
	

}
