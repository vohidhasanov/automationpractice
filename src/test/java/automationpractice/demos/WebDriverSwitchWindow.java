package automationpractice.demos;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Set;

public class WebDriverSwitchWindow extends Driver_Factory.driver {

@Test
    public void switchWindowAndPerformActionInNewWindows () {
        driverHelper.operUrl("http://testleaf.herokuapp.com/pages/Window.html");

        driverHelper.click(By.id("home"), 15);
        Set<String> handles = driver.getWindowHandles();

        driverHelper.switchToMainWindow();

        driverHelper.clickByXpath("//h5[text()='Table']", 2);

    }
}
