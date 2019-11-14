package Driver_Factory;

import Utils.AppProperties;
import Utils.Common;
import Utils.DriverHelper;
import Utils.Reporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class NonStaticDriver {

    protected WebDriver driver;
    protected static DriverHelper driverHelper;

    @BeforeSuite
    public void initializeReporter()
    {
        Reporter.initReporter();
    }

    @AfterMethod
    public void saveReport()
    {
        Reporter.saveReport();
    }

    @BeforeTest
    public void init() {
        if (driver == null) driver = getDriver(AppProperties.BROWSER_TYPE);
        Common.deleteFiles("/target/screenshots");
        // if (driverHelper == null) driverHelper = new DriverHelper(driver);
    }

    protected NonStaticDriver() {
    }

    protected WebDriver getDriver(String browserType) {
       WebDriver driver = null;
        switch (browserType)
        {
            case "chrome":
                driver = getChromeDriver();
                driver.manage().window().maximize();
                break;
            case "firefox":
                driver = getFirefoxDriver();
                driver.manage().window().maximize();
                break;
            case "opera":
                driver = getOperaDriver();
                break;
            default:
                System.out.println("Browser type" + browserType + " invalid.");
                break;
        }


        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driverHelper = new DriverHelper(driver);
        return driver;
    }

    private static ChromeDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static FirefoxDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static OperaDriver getOperaDriver() {
        WebDriverManager.operadriver().setup();
        return new OperaDriver();
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }




}
