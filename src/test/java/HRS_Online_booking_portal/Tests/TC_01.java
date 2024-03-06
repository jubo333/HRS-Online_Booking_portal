package HRS_Online_booking_portal.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import HRS_Online_booking_portal.TestComponents.BaseTest;
import HRS_Online_booking_portal.Data.*;
public class TC_01 extends BaseTest
{
	@Test(dataProvider = "getData")
	public void searchHotel(HashMap<String,String> input) throws InterruptedException
	{
		 String location=input.get("name");
		 
		 landingPage.searchLocation(location);
		 
		 String dateCheckin = input.get("checkindate");
		 
		 String checkoutdate =input.get("checkout");
		
	  List<WebElement> dates= landingPage.getDates();
	  for(int i=0;i<dates.size();i++)
	  {
		  String date=dates.get(i).getText();
		  if(date.equalsIgnoreCase(dateCheckin))
		  {
			  landingPage.SearchHotel(date,checkoutdate);
		  }
	  }
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{

		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//HRS_Online_booking_portal\\Data\\HotelSearch.json");
		return new Object[][]  {{data.get(0)}, {data.get(1) } };
		
	}

	
	

}
