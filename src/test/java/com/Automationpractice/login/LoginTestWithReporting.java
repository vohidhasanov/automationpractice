package com.Automationpractice.login;

import Driver_Factory.NonStaticDriver;
import Utils.Reporter;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTestWithReporting extends NonStaticDriver {

    @Test
    public void loginWithValidUserIdAndPassword () {

        Reporter.createClass("LoginTestWithReporting");
        Reporter.createTest("login test case");
     driverHelper.operUrl("http://www.automationpractice.com");
     driverHelper.click(By.className("login"), 15);
     Reporter.verify("abc", "ab1");
    }
}
