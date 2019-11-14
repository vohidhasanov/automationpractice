package automationpractice.demos;

import org.testng.annotations.*;

public class TestNGAnnotationDemo extends Driver_Factory.driver {
   // private String website;

    @Test
    public void testOne () {
        System.out.println("I am test 1");
    }
    @Test
    public void testTwo () {
        System.out.println("I am test 2");
    }

    @BeforeTest
    public void beforeTest () {System.out.println ("I ran before xml test");}

    @BeforeMethod
    public void before () {
        System.out.println("I run always before any test");
    }

    @AfterMethod
    public void after () {
        System.out.println("I run always after any test");
    }

    @BeforeClass
    public void beforeClass () {
        System.out.println("I am before class");
    }

    @AfterClass
    public void afterClass () {
        System.out.println("I am after class");
    }

    @BeforeSuite
    public void beforSuite () {
        System.out.println("I run once and before entire suites run");
    }

    @AfterSuite
    public void afterSuite () {
        System.out.println("I run once and after entire suites run");
    }


}

