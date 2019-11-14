package Driver_Factory;

import Utils.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class demo1 extends EDriver {

    public static void main(String[] args) {

    }
@Test
    private void testOne () {
        driverHelper.operUrl("http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=");
        int numberOfProducts = driverHelper.getElements(By.cssSelector(".ajax_block_product"),15).size();
        WebElement lastElement = driverHelper.getElement(By.cssSelector(".ajax_block_product"),numberOfProducts,15);

//                driverHelper.getElement
//                (By.xpath("//ul[contains(@class, 'product_list')]//li[contains(@class, 'ajax_block_product')]"),15);
        int y = lastElement.getLocation().getY();
        driverHelper.scrollToElement(0,y-200);
        Actions actions = new Actions(driver);
        actions.moveToElement(lastElement).perform();

        lastElement.findElement(By.linkText("Add to Compare")).click();
        Common.sleep(4);
    }
}
