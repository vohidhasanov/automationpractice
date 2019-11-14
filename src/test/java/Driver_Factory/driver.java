package Driver_Factory;

import Utils.AppProperties;
import Utils.DriverHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

public class driver {
    protected static WebDriver driver ;
    protected static DriverHelper driverHelper;
    
    static {
        if (driver==null)
        driver = getDriver(AppProperties.BROWSER_TYPE);
    }

    protected driver() { }

    protected static WebDriver getDriver (String browserType) {
        WebDriver driver = null;
        switch (browserType)
        {
            case  "chrome": driver=getChromeDriver();
                  //  driver.manage().window().maximize();
                break;
            case "firefox": driver=getFirefoxDriver();
                    driver.manage().window().maximize();
                break;
            case "opera": driver=getOperaDriver();
                break;
            default:
                System.out.println("Browser type"+ browserType+" invalid.");
                break;
        }

        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driverHelper = new DriverHelper(driver);
        return driver;
    }

    public static ChromeDriver getChromeDriver()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
//        System.setProperty ("webdriver.chrome.driver", "E:\\JAVA\\AUTOMATION\\Compressed\\chromedriver_win32_2\\chromedriver.exe");
//        ChromeDriver chromeDriver = new ChromeDriver();
        return new ChromeDriver(chromeOptions);
    }

    private static FirefoxDriver getFirefoxDriver ()
    { WebDriverManager.firefoxdriver().setup();
//        System.setProperty("webdriver.gecko.driver", "E:\\JAVA\\AUTOMATION\\Compressed\\geckodriver-v0.25.0-win64_3\\geckodriver.exe");
//        FirefoxDriver firefoxDriver = new FirefoxDriver();
        return new FirefoxDriver();
     }

    private static OperaDriver getOperaDriver() {
        WebDriverManager.operadriver().setup();
//         System.setProperty("webdriver.opera.driver", "E:\\JAVA\\AUTOMATION\\Compressed\\operadriver_win64\\operadriver.exe");
//        OperaDriver operaDriver = new OperaDriver();

        return new OperaDriver();
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }
}
