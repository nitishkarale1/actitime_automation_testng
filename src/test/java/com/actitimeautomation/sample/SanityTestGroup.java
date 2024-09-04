package com.actitimeautomation.sample;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class SanityTestGroup
{
    @BeforeGroups(groups = {"sanity","regression"})
    public void beforeGroup()
    {
        System.out.println("This is before group method-SanityTestGroup");
    }
    @AfterGroups(groups = {"sanity","regression"})
    public void afterGroup()
    {
        System.out.println("This is after group method-SanityTestGroup");
    }
    @Test(groups = "sanity")
    public void test1()
    {
        System.out.println("sanityTest1");
    }
    @Test(groups = {"sanity","regression"})
    public void test2()
    {
        System.out.println("sanityTest2");
    }
}
