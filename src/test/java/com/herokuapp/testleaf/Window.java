package com.herokuapp.testleaf;

import Driver_Factory.NonStaticDriver;
import Utils.AppProperties;
import Utils.Common;
import Utils.Reporter;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class Window extends NonStaticDriver {
private int timeOutInSeconds=15;
    @Test
    public void windowsTest1 () {
        driverHelper.operUrl(AppProperties.TEST_LEAF_BASE_URL+"/pages/Window.html");
        driverHelper.click(By.id("home"), timeOutInSeconds);
        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {
            driver.switchTo().window(window);
            String header = driverHelper.getText(By.tagName("h1"), timeOutInSeconds);
            if (header.equals("Locators and Selenium Interactions")){
                String title = driver.getTitle();
                Assert.assertEquals("TestLeaf - Selenium Playground", title);
                driver.close();
            }
            driver.switchTo().window(windows.iterator().next());
            header = driverHelper.getText(By.tagName("h1"), timeOutInSeconds);
            Assert.assertEquals("Work with Windows", header);
        }

    }

    @Test
    public void windowTest2 (){
        Reporter.createClass("WindowHandleTest_2");
        Reporter.createTest("Number_Of_Windows");
        driverHelper.operUrl(AppProperties.TEST_LEAF_BASE_URL+"/pages/Window.html");
        driverHelper.click(By.xpath("//button[text()='Open Multiple Windows']"),timeOutInSeconds);
        Set<String> windows = driver.getWindowHandles();
        System.out.println(windows.size()+" windows are opened");
    }


    @Test
    public void windowTest3 () {
        driverHelper.operUrl(AppProperties.TEST_LEAF_BASE_URL+"/pages/Window.html");
        driverHelper.click(By.id("color"), 1, timeOutInSeconds);
        Set <String> windows = driver.getWindowHandles();
        for (String window : windows) {
            driver.switchTo().window(window);
            String header = driverHelper.getText(By.tagName("h1"),timeOutInSeconds);

            if (!header.equals("Work with Windows")) {
//                String title = driver.getTitle();
//                Assert.assertEquals("TestLeaf - Selenium Playground", title);
                driver.close();
            }
                driver.switchTo().window(driverHelper.getMainWindowHandle());
            // driver.switchTo().window(windows.iterator().next());

        }
        Common.sleep(3);
    }

    @Test
    public void windowsTest4 () {
        driverHelper.operUrl(AppProperties.TEST_LEAF_BASE_URL+"/pages/Window.html");
        driverHelper.click(By.id("color"), 2, timeOutInSeconds);
        Common.sleep(5);
        Set <String> windows=driver.getWindowHandles();
        for (String window: windows) {
            driver.switchTo().window(window);
            String header = driverHelper.getText(By.tagName("h1"), timeOutInSeconds);
            if (!header.equals("Work with Windows")) {
                driver.close();
            }
            //driver.switchTo().window(windows.iterator().next());
            //driver.switchTo().window(driverHelper.getMainWindowHandle());
            driverHelper.switchToMainWindow();
            Common.sleep(4);
        }

    }

}
