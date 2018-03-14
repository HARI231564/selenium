package com.icicibank.loans.carloans;

public class ICICI implements RBI
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ICICI i=new ICICI();
		i.withdrawl();
	}

	@Override
	public void withdrawl() {
		System.out.println("Hi iam overriden withdrawl method in ICICI");
		
	}

}
