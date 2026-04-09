package sampleTestNG;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	@DataProvider
	public Object[][] dataProvider_BookingTicket()
	{
		Object[][] arr=new Object[5][2];
		arr[0][0]="Tamil Nadu";
		arr[0][1]="Karnataka";
		
		arr[1][0]="Uttar Pradesh";
		arr[1][1]="Andhra Pradesh";
		
		arr[2][0]="Madya Pradesh";
		arr[2][1]="Himachal Pradesh";
		
		arr[3][0]="Maharashtra";
		arr[3][1]="Kerala";
		
		arr[4][0]="Kashmir";
		arr[4][1]="Gujarat";
		
		return arr;
		
	}
}
