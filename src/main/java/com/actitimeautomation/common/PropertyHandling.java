package com.actitimeautomation.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyHandling
{
    Properties properties;
    public PropertyHandling() throws IOException
    {
        FileInputStream fis = new FileInputStream("C:\\Users\\Lenovo\\IdeaProjects\\actitime_automation_TestNG\\config.properties");
        properties = new Properties();
        properties.load(fis);
    }

   public String getProperty(String key) throws IOException
   {
       return properties.getProperty(key);
   }
}