package automationpractice.demos;

import Driver_Factory.EDriver;
import Utils.AppProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Utils.Common.*;

public class JavascriptDemo extends EDriver {
int timeOutInSeconds = 15;
    @Test
    public void calculator() {
        driverHelper.operUrl("http://www.anaesthetist.com/mnm/javascript/calc.htm");
        driverHelper.click(By.name("two"),timeOutInSeconds);
        driverHelper.click(By.name("add"),timeOutInSeconds);
        driverHelper.click(By.name("two"),timeOutInSeconds);
      //  driverHelper.click(By.name("result"),timeOutInSeconds);

        JavascriptExecutor js = (JavascriptExecutor) driver; //js = it a casted driver of type JavascriptExecuter
        js.executeScript("Calculate();");
        String acturalResult = driverHelper.getElement(By.name("Display"),timeOutInSeconds).getAttribute("value");
        //js.executeScript("arguments[0].style.border = '3px dotted red'",driverHelper.getElement(By.xpath("//*[@name='Display']"),timeOutInSeconds));
        //System.out.println(acturalResult);
        driverHelper.highlightElement(By.name("Display"));
        driverHelper.validateEquals(acturalResult, "4");
        sleep(3);

    }

    @Test
    public void jsAlert() {
    String  alertText = "My name is "+getRandomFirstName()+" "+getRandomLastName();
    driverHelper.operUrl(AppProperties.AUTOMATION_PRACTICE_BASE_URL);

    driver.navigate().refresh(); // In that way we can refresh pages
    driver.navigate().to(""); //Opening pages
    driver.navigate().back(); //
    driver.navigate().forward();

    JavascriptExecutor js  = (JavascriptExecutor) driver;
    js.executeScript("alert('"+ alertText+"');" );

    String actualAlert = driver.switchTo().alert().getText();

        System.out.println(actualAlert);
    driver.switchTo().alert().accept();
    Assert.assertEquals(actualAlert, alertText);

    sleep(3);

    }

    @Test
    public void scrollTOElement () {
        driverHelper.operUrl(AppProperties.AUTOMATION_PRACTICE_BASE_URL);
        driverHelper.click(By.linkText("Sign in"), timeOutInSeconds);
        driverHelper.scrollToElement(By.linkText("Ecommerce software by PrestaShop™"));
        driverHelper.highlightElement(By.linkText("Ecommerce software by PrestaShop™"));
    }

}
