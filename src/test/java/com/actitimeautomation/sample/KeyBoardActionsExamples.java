package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.pages.LoginPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

public class KeyBoardActionsExamples extends BaseClass
{
    static WebDriver driver;
    public KeyBoardActionsExamples()
    {
        launchBrowser("chrome");
        driver=super.driver;
    }

    public static void main(String[] args) throws AWTException {
        new KeyBoardActionsExamples();
        driver.manage().window().maximize();

        driver.get("https://online.actitime.com/nitishkarale/login.do");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("nitish18", "vk@410");

        Actions actions= new Actions(driver);
        actions.keyDown(Keys.ENTER).build().perform();
        actions.keyUp(Keys.ENTER).build().perform();

       /* Robot robot= new Robot();
        robot.mouseMove(500,500);
        //mouse left button press robot.mousePress(KeyEvent.VK_LEFT);
        robot.mouseRelease(KeyEvent.VK_LEFT);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        */



      /*//press control+Plus button at a time robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_PLUS);
        robot.keyPress(KeyEvent.VK_PLUS);
        robot.keyRelease(KeyEvent.VK_PLUS);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.mouseWheel(600);
        robot.mouseWheel(-600);
       */
    }
}
