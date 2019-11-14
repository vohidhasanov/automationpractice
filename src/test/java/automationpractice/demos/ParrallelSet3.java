package automationpractice.demos;

import Driver_Factory.NonStaticDriver;
import org.testng.annotations.Test;

public class ParrallelSet3 extends NonStaticDriver {

@Test
    public void testOne () {
        driverHelper.operUrl("http:\\www.cnn.com");

    }

    @Test
    public void testTwo () {
        driverHelper.operUrl("http:\\www.cnn.com");
    }

    @Test
    public void testThree () {
        driverHelper.operUrl("http:\\www.cnn.com");

     }
}
