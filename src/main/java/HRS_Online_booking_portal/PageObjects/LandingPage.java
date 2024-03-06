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

	@FindBy(css=".Calendar_container__yInee")
	List<WebElement> CalenderDates;
	
	@FindBy(css=".Month_title__m8iWe")
	List<WebElement> MonthName;
	
	public List<WebElement> getDates()
	{
		return CalenderDates;
	}
	
	@FindBy(xpath="//button[@id='onetrust-accept-btn-handler']")
	WebElement Acceptcookie;
	
	@FindBy(xpath="//li[@data-test='DestinationList_suggestionItem']")
	WebElement locationsuggest;

	public void searchLocation(String StyLoc) throws InterruptedException
	{
		
		StayLocation.click();
		Thread.sleep(2000);
		StayLocationInput.sendKeys(StyLoc);
		Thread.sleep(2000);
		locationsuggest.click();
	}
	
	public void SearchHotel(String Checkindate,String CheckOutDates)
	{
		
		Checkin.click();
		Checkin.sendKeys(Checkindate);
		Checkout.click();
		Checkout.sendKeys(CheckOutDates);
		SearchButton.click();
		
		
	}
	
	
	
	public void goTo() throws InterruptedException
	{
		driver.get("https://www.hrs.de/");
		Thread.sleep(2000);
		Acceptcookie.click();
	}
	
	
	

}
