package com.icicibank.loans.carloans;

public class ChildClass extends FirstAbstract
{

	public static void main(String[] args) 
	{
		System.out.println("hii");
		ChildClass c=new ChildClass();
		c.m1();
		c.m2();
		System.out.println("Hi");
		System.out.println("Hi");
		System.out.println("hello");
	}

	@Override
	public void m2() 
	{
		System.out.println("Hi iam m2 overridden method in ChildClass");	
	}

}
