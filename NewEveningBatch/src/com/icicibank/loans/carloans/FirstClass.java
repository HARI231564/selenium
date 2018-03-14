package com.icicibank.loans.carloans;

public class FirstClass implements RBI
{
    int a=10,b=20,result;
    
    public void addition()
    {
    	result=a+b;
    	System.out.println(result);
    }
	
	public static void main(String[] args) 
	{
		System.out.println("Hi !");
		FirstClass obj=new  FirstClass();
		obj.addition();
		obj.withdrawl();
		
		FirstClass obj1=new FirstClass();
		obj1.addition();
	}

	@Override
	public void withdrawl() 
	{
		System.out.println("Hi iam withdrawl overridden method in class Firstclass...");
	}

}
