package automationpractice.demos;

import Driver_Factory.EDriver;
import Utils.AppProperties;
import Utils.Common;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HoveOverDemo extends EDriver {
    private Logger logger = Logger.getLogger(HoveOverDemo.class);

    @Test
    public void hoverOverTest1 () {
        driverHelper.operUrl(AppProperties.THE_INTERNET_BASE_URL+"/hovers");
        Actions actions = new Actions(driver);

        WebElement image1 = driverHelper.getElement(By.cssSelector(".figure>img"),15);
       // BasicConfigurator.configure();
        logger.info("Found an element: "+image1);
        actions.moveToElement(image1).perform();
        logger.info("Hover over image1");
        Common.sleep(4);
        driverHelper.click(By.cssSelector(".figure a"),15);

   //     driverHelper.jsClick(By.cssSelector(".figure a"));
        Common.sleep(4);
    }
}
