package automationpractice.demos;

import Driver_Factory.EDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExtentReportDemo extends EDriver {

    @Test
    public void t1() {
        driverHelper.operUrl("http://www.amazon.com");
        driverHelper.click(By.id("dd"),10);
    }




    @Test
    public void login_with_invalid_userID () {

        driver.get("http://automationpractice.com/");

        driver.findElement(By.className("login")).click();
        //driver.findElement(By.id("email")).sendKeys("mynknownxadd@mailiminator.com");
        driverHelper.sendKeys(By.id("email"),"mynknownxadd@mailiminator.com", 15);
        driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
        String errorMessage = driver.findElement(By.xpath(("//p[text()='There is 1 error']"))).getText();

        Assert.assertEquals(errorMessage, "There is 1 error");

        String errorMessage2= driver.findElement(By.xpath("//li[text()='Password is required.']")).getText();
        Assert.assertEquals(errorMessage2, "Password is required.");


    }
}
