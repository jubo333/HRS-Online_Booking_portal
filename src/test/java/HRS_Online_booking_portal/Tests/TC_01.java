package HRS_Online_booking_portal.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		 String match = null;
		 String location=input.get("name");
		 
		 landingPage.searchLocation(location);
		 
		 String dateCheckin = input.get("checkindate").trim();
		// System.out.println("CheckinDate"+dateCheckin);
		 
		 String checkoutdate =input.get("checkout");
		
	  List<WebElement> dates= landingPage.getDates();
	  //System.out.println("Dates"+dates.size());
	  for(int i=0;i<dates.size();i++)
	  {
		  String date=dates.get(i).getText();
		//  String[] dateParts = date.split(" ");
		  //  for (int j = 0; j < dateParts.length; j++) 
		    //{
		      //  System.out.println("Date part: " + dateParts[j]);
		        
		        // System.out.print("dates inside for"+date);
		  
		  
		  Pattern pattern = Pattern.compile("\\b\\d{1,2}\\b");
	        Matcher matcher = pattern.matcher(date);
	        
	        // Iterate over matches and extract numeric values
	        while (matcher.find()) 
	        {
	            match = matcher.group();
	            System.out.println("Numeric value: " + match);
	            
	        }
	        
		        if(dateCheckin.equals(match))
		        {
		          dates.get(i).click();
			      //System.out.println("date in if"+date);
			      landingPage.SelectDate();
		        }
	        
		    //}
	  }
	  landingPage.clickonSearch();
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{

		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//HRS_Online_booking_portal\\Data\\HotelSearch.json");
		return new Object[][]  {{data.get(0)} };
		
	}

	
	

}
