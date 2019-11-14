package com.herokuapp.testleaf;

import Driver_Factory.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Frame extends driver {

    @Test
    public void frameTest () {
        driver.get("http://testleaf.herokuapp.com/pages/frame.html");
        driver.switchTo().frame(0);
        WebDriverWait webDriverWait =new WebDriverWait(driver, 15);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id ("Click")));
        driver.findElement(By.id("Click")).click();
        driver.switchTo().defaultContent();  // navigates back to main HTML

        //driver.switchTo().frame(1); //index begins with 0
        driver.switchTo().frame(driver.findElement(By.xpath("(//iframe)[2]"))); // same thing as above in locators index begins at 0 by WebElements
        driver.switchTo().frame("frame2");
        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Click1")));
        driver.findElement(By.id("Click1")).click();

    }
}
