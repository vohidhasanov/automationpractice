package com.herokuapp.testleaf;

import Utils.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Alerts extends Driver_Factory.driver {

    @Test (priority = 1)
    public void alert2() {
        driver.get("http://testleaf.herokuapp.com/pages/Alert.html");
        WebDriverWait webDriverWait = new WebDriverWait(driver, 15);

        WebElement headerElement=driver.findElement(By.tagName("h1"));
        webDriverWait.until(ExpectedConditions.visibilityOf(headerElement));

        String header = headerElement.getText();
        Assert.assertEquals(header, "Handle Alerts", "Header validation is failed"); //

        //WebElement alertBoxButton = driver.findElement(By.xpath("//button[text()='Alert Box']"));
        //webDriverWait.until(ExpectedConditions.elementToBeClickable(alertBoxButton)); // to be sure that it is loaded and clickable secong by the webelement
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Alert Box']"))); // 2- way to be sure first by the locator
        driver.findElement(By.xpath("//button[text()='Alert Box']")).click();

        Assert.assertEquals(driver.switchTo().alert().getText(), "I am an alert box!");
        Common.sleep(2);
        driver.switchTo().alert().accept();

        Common.sleep(3);

            //driver.quit();

    }
@Test (priority = 2)
    public void alert3 () {
        driver.get("http://testleaf.herokuapp.com/pages/Alert.html");
        WebDriverWait webDriverWait = new WebDriverWait(driver, 15);

        WebElement headerElement=driver.findElement(By.tagName("h1"));
       webDriverWait.until(ExpectedConditions.visibilityOf(headerElement));

        String header = headerElement.getText();
        Assert.assertEquals(header, "Handle Alerts", "Header validation is failed");

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Confirm Box']")));
        driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();

        Assert.assertEquals(driver.switchTo().alert().getText(), "Press a button!");
        driver.switchTo().alert().accept();
        String alertText =driver.findElement(By.id("result")).getText();
        Assert.assertEquals(alertText, "You pressed OK!");

        Common.sleep(3);

  //  driver.quit();
    }

    @Test (priority = 3)
    public void alert1 () {
        driver.get("http://testleaf.herokuapp.com/pages/Alert.html");
        WebDriverWait webDriverWait = new WebDriverWait(driver, 15);

        WebElement header = driver.findElement(By.tagName("h1"));
        webDriverWait.until(ExpectedConditions.visibilityOf(header));

        String headerText = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(headerText, "Handle Alerts", "Header validation failed");

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()= 'Prompt Box']")));
        driver.findElement(By.xpath("//button[text()= 'Prompt Box']")).click();

        Assert.assertEquals(driver.switchTo().alert().getText(), "Please enter your training institute name");
        String sendKeyString ="Techcenture";
        driver.switchTo().alert().sendKeys(sendKeyString);
        driver.switchTo().alert().accept();

        String expectedString = "You should not have enjoyed learning at "+sendKeyString+ " as compared to TestLeaf! Right?";

        Assert.assertEquals(driver.findElement(By.id("result1")).getText(), expectedString);

        Common.sleep(3);
      //  driver.quit();

    }

}
