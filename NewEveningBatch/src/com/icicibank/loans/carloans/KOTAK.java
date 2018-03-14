package com.icicibank.loans.carloans;

public class KOTAK implements RBI
{

	public static void main(String[] args) {
		KOTAK k=new KOTAK();
		k.withdrawl();

	}

	@Override
	public void withdrawl() 
	{
		System.out.println("Hi iam overriden withdrawl method in KOTAK");
		
	}

}
