package com.actitimeautomation.sample1;

import com.actitimeautomation.common.BaseClass1;
import com.actitimeautomation.common.UtilityClass;
import com.actitimeautomation.pages1.ActitimeLoginPage;
import com.actitimeautomation.pages1.ActitimeTimeTrackPage;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseClass1
{
    ActitimeLoginPage loginPage;
    ActitimeTimeTrackPage ttPAge;
    @BeforeClass
    public void launchBrowser() throws IOException
    {
        initializeBrowser("Chrome");
        loginPage=new ActitimeLoginPage(driver);
        ttPAge=new ActitimeTimeTrackPage(driver);

        loginPage.actitimeLogin(UtilityClass.getConfigData("username"), UtilityClass.getConfigData("password"));
    }
    @Test
    public void verifyUserLogin() throws EncryptedDocumentException, IOException
    {
        String actUserame = ttPAge.getActitimeUsername();
        String expUserNameString = UtilityClass.getExcelData(0, 0).getStringCellValue();
        Assert.assertEquals(actUserame, expUserNameString, "failed: both actual and expected usernames are different.");
    }
    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
