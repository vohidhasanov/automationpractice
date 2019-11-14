package automationpractice.demos;

import Driver_Factory.EDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParametrDemo extends EDriver {

    @Parameters({"userid", "password"})
    @Test
    public void Login_with_invalid_userid(@Optional("Mike")String u, @Optional("xyz123")String p)
    { // go to automationproctice.com

//        Reporter.createClass("TestNGParametrDemo");
//        Reporter.createTest("ParametersPass");

        driverHelper.operUrl("http://automationpractice.com/");
        //click signin button
        //driver.findElement(By.className("login")).click();
        driverHelper.click(By.className("login"),2);
        //driver.findElement(By.id("email")).sendKeys("mynknownxadd@mailiminator.com");
        driverHelper.sendKeys(By.id("email"),u,2 );
        driverHelper.sendKeys(By.id("passwd"), p,2);

        driverHelper.click(By.xpath("//button[@id='SubmitLogin']"), 2);



    }
}