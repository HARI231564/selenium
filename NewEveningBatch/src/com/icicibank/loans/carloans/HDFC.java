package com.icicibank.loans.carloans;

public class HDFC implements RBI
{

	public static void main(String[] args) {
		HDFC h=new HDFC();
		h.withdrawl();

	}

	@Override
	public void withdrawl() 
	{
		System.out.println("Hi iam overriden withdrawl method in HDFC");
		
	}

}
