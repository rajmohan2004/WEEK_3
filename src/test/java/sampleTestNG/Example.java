package sampleTestNG;

import org.testng.annotations.*;

public class Example {
	@Test
	public void add()
	{
		System.out.println(5);
	}

	@BeforeSuite
	public void bs()
	{
		System.out.println("Before Suite");
	}
	
	@BeforeClass
	public void bc()
	{
		System.out.println("Before Class");
	}
	
	@AfterClass
	public void ac()
	{
		System.out.println("After Class");
	}
	
	@BeforeTest
	public void bt()
	{
		System.out.println("Before Test");
	}
	
	@AfterTest
	public void at()
	{
		System.out.println("After Test");
	}
	
	@BeforeMethod
	public void bm()
	{
		System.out.println("Before Method");
	}
	
	@AfterMethod
	public void am()
	{
		System.out.println("After Method");
	}
	
	@Test
	public void t()
	{
		System.out.println("Test");
	}
	
	@AfterSuite
	public void as()
	{
		System.out.println("After Suite");
	}
}
