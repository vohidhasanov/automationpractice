package automationpractice.demos;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class WebDriver_SwitchDemo extends Driver_Factory.driver {

    @Test
    public void demoIframe () {
        driver.get("http://testleaf.herokuapp.com/pages/frame.html");
        driver.switchTo().frame(0);
    driver.findElement(By.id("Click")).click();
    }

    @Test
    public void demoAlert() {
        driver.get("http://testleaf.herokuapp.com/pages/Alert.html");
        driver.findElement(By.xpath("//button[preceding-sibling::label[text()='Click the button to display a alert box.']]")).click();
        driver.switchTo().alert().accept();
        //driver.switchTo().alert().dismiss();
    }


    @Test
    public void demoWindows() {
        String handle1;
        driver.get("http://testleaf.herokuapp.com/pages/Window.html");
         handle1 = driver.getWindowHandle();
        driver.findElement(By.id("home")).click();






        driver.findElement(By.xpath("//a[child::img[@alt='Images']]")).click();
    }
}
