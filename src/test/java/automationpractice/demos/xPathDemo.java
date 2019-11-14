package automationpractice.demos;
import Driver_Factory.driver;
import org.openqa.selenium.By;

public class xPathDemo extends Driver_Factory.driver {

    public static void main(String[] args) {
    driver.get("http://automationpractice.com/index.php");
    driver.findElement(By.xpath("(//a[@title='T-shirts'])[2]")).click();
    driver.findElement(By.xpath("(//a[contains(text(), 'Terms and conditions of use')])[1]")).click();

    }


}
