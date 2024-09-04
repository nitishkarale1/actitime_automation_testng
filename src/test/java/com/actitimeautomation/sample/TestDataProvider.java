package com.actitimeautomation.sample;

import org.testng.annotations.DataProvider;

public class TestDataProvider
{
    @DataProvider
    public String [][] getSampleData()
    {
        String [][] testData = {
                {"Pune","Mumbai"},
                {"Nashik","Nagpur"},
                {"Delhi","Bangalore"},
                {"Hyderabad","Chennai"}
        };
        return testData;
    }
}
