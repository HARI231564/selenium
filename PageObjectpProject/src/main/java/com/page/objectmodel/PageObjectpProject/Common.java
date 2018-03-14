package com.page.objectmodel.PageObjectpProject;

import org.apache.log4j.PropertyConfigurator;

public class Common 
{
	public static void log4jStart()
	{
		String log4jConfPath="log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}
	
}
