package com.Automationpractice.login;

import Driver_Factory.NonStaticDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends NonStaticDriver {//extends Driver_Factory.driver {

    @Test(groups = {"functional", "integration"})
    public void testOne()
    { driver.get("integration");}

@Test (groups = "functional")
    public void Login_with_invalid_userid()
    { // go to automationproctice.com
        driver.get("http://automationpractice.com/");
      //click signin button
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("mynknownxadd@mailiminator.com");
        driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
        String errorMessage = driver.findElement(By.xpath(("//p[text()='There is 1 error']"))).getText();
       // System.out.println(errorMessage);
        Assert.assertEquals(errorMessage, "There is 1 error");

        String errorMessage2= driver.findElement(By.xpath("//li[text()='Password is required.']")).getText();
        Assert.assertEquals(errorMessage2, "Password is required.");



    }
}
