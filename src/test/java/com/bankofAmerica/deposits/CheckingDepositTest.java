package com.bankofAmerica.deposits;

//import org.testng.annotations.Test;

import Driver_Factory.driver;
import org.testng.annotations.Test;
//import org.junit.Test;

public class CheckingDepositTest extends driver {
	

	//deposit with max amount
	@Test(priority = 3)
	public void depositWithMaxAmount ()
	{
		System.out.println("hello");
	}
	
	//deposit with min amount
	@Test(priority = 1)
	public void depositWithMinAmount () 
	{
		System.out.println("world");
	}
	@Test(priority = 2)
	//deposit with multiple amount
	public void depositWithMultipleAmount ( ) 
	{
		System.out.println("say");
			}
	
	
	

}
