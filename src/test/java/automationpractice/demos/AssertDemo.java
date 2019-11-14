package automationpractice.demos;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertDemo {

    @Test
    public void testOne () {
        String a = "abc";
        String b = "abc";

        boolean b1 = true;

        Assert.assertEquals(a, b);
    }

}
