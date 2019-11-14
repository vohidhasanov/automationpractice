package com.herokuapp.testleaf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButton extends Driver_Factory.driver {

    @Test
    public void test1 () {
        driver.get("http://testleaf.herokuapp.com/pages/radio.html");
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);  // Explicit wait
        //driver.findElement(By.id("(//input[@id='yes'])")).click();
        WebElement yesElement = driver.findElement(By.id("yes"));
        WebElement noElement = driver.findElement(By.id("no"));

        webDriverWait.until(ExpectedConditions.visibilityOf(yesElement));
        yesElement.click();
        boolean isYesSelected = yesElement.isSelected();
        Assert.assertTrue(isYesSelected, "Yes radio is not selected");

        driver.quit();
    }



}
