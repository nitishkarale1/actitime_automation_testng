package com.actitimeautomation.sample;

import org.testng.annotations.*;

public class TestNGAnnotations {
    {
        System.out.println("This is non static block");
    }

    public TestNGAnnotations() {
        System.out.println("This is a constructor of TestNGAnnotations class");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("This is before class");
    }
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("This is before method");
    }
    @BeforeTest
    public void beforeTest() {
        System.out.println("This is before Test method");
    }
    @AfterTest
    public void AfterTest() {
        System.out.println("This is After Test method");
    }
    @AfterMethod
    public void afterMethod()
    {
        System.out.println("This is after method");
    }
    @Test
    public  void test1()
    {
        System.out.println("This is test1");
    }
    @Test
    public  void test2()
    {
        System.out.println("This is test2");
    }
    @Test
    public  void test3()
    {
        System.out.println("This is test3");
    }
    @AfterClass
    public void afterClass()
    {
        System.out.println("This is after class");
    }
}
