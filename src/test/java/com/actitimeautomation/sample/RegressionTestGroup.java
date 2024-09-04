package com.actitimeautomation.sample;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class RegressionTestGroup
{
    @BeforeGroups(groups = {"sanity","regression"})
    public void beforeGroup()
    {
        System.out.println("This is before group method-RegressionTestGroup");
    }
    @AfterGroups(groups = {"sanity","regression"})
    public void afterGroup()
    {
        System.out.println("This is after group method-RegressionTestGroup");
    }
    @Test(groups = {"sanity","regression"})
    public void regressionTest1()
    {
        System.out.println("regressionTest1");
    }
    @Test(groups = {"regression"})
    public void regressionTest2()
    {
        System.out.println("regressionTest2");
    }
}
