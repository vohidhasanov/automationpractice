package Driver_Factory;

import Utils.AppProperties;
import Utils.Common;
import Utils.DriverHelper;
import Utils.Reporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

@Listeners(Driver_Factory.TestNGListener.class)
public class EDriver {
    protected EventFiringWebDriver driver;
    protected WebDriver sdriver;
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
        if (sdriver == null) sdriver = getDriver(AppProperties.BROWSER_TYPE);
       // Common.deleteFiles("/target/screenshots");

    }

    protected EDriver() {
    }

    protected WebDriver getDriver(String browserType) {

        switch (browserType)
        {
            case "chrome":
                sdriver = getChromeDriver();
             //  sdriver.manage().window().maximize();
                break;
            case "firefox":
                sdriver = getFirefoxDriver();
               // sdriver.manage().window().maximize();
                break;
            case "chrome-headless":
                    sdriver = getHeadlessChromeDriver();
                break;
            default:
                System.out.println("Browser type" + browserType + " invalid.");
                break;
        }

        this.driver = new EventFiringWebDriver(sdriver);
        this.driver.register(new DriverListener());

        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driverHelper = new DriverHelper(this.driver);
        return driver;
    }

    private static ChromeDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        return new ChromeDriver(chromeOptions);
    }

    private static ChromeDriver getHeadlessChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--headless");
        //chromeOptions
        return new ChromeDriver(chromeOptions);
    }


    private static FirefoxDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }


    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }

}
