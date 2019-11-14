package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.List;


public final class DriverHelper {
    private WebDriver driver;
    private String mainWindowHandle;
    private EventFiringWebDriver eDriver;

    public DriverHelper(WebDriver driver)
    { this.driver=driver; }

    public DriverHelper(EventFiringWebDriver driver)
    { this.eDriver= driver; }


    public void operUrl(String url) {
        eDriver.get(url);
    //   Reporter.step.info("Navigated to: "+url);
        mainWindowHandle =eDriver.getWindowHandle();
     }

    public String getMainWindowHandle() {
        return mainWindowHandle;
    }


    public void webElementVisibility(By by, int timeOutInSeconds) {
        new WebDriverWait(eDriver, timeOutInSeconds)
                .until(ExpectedConditions.visibilityOfElementLocated(by));

    }



    public WebElement getElement (By by, int timeOutInSeconds)
    {
        webElementVisibility(by, timeOutInSeconds);
        return eDriver.findElement(by);
    }

    public WebElement getElement (By by, int index, int timeOutInSeconds)
    {
        webElementVisibility(by, timeOutInSeconds);
        return eDriver.findElements(by).get(index-1);
    }



    public void click(By by, int timeOutInSeconds) {
        getElement(by, timeOutInSeconds).click();
        //Reporter.step.info("Clicked button "+by.toString().substring(by.toString().indexOf(':')));
    }

    public List<WebElement> getElements (By by, int timeOutInSeconds)
    {
        webElementVisibility(by, timeOutInSeconds);
        return eDriver.findElements(by);
    }
    public void click(By by, int index, int timeOutInSeconds) { getElements(by, timeOutInSeconds).get(index-1).click();}

    public void clickByXpath (String xpath, int timeOutInSeconds) {getElement(By.xpath(xpath), timeOutInSeconds).click();}

    public void sendKeys (By by, String text, int timeOutInSeconds) {
        getElement(by, timeOutInSeconds).sendKeys(text);
        Reporter.step.info("Typed: "+text);
    }


    public String getText (By by, int timeOutInSeconds) {
       return getElement(by, timeOutInSeconds).getText().replaceAll("\\s+", " ").trim();
    }

    public void takeScreenShot()
    {
        TakesScreenshot takesScreenshot = (TakesScreenshot) eDriver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(file, new File ( System.getProperty("user.dir")+"/target/ScreenShots/FileName"+System.currentTimeMillis()+".png "));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String takeScreenShotFroReporting(WebDriver driver)
    {   long ms = System.currentTimeMillis();
        String path =System.getProperty("user.dir")+"/target/ScreenShots/FileName"+ms;
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(file, new File ( path+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path +".png";
    }

    public void switchToMainWindow() {
        eDriver.switchTo().window(mainWindowHandle);
    }

    private void executeJS(String script, WebElement webElement) {
    JavascriptExecutor js = (JavascriptExecutor) eDriver;
    js.executeScript(script, webElement);
    }

    public void jsClick (By by) {
    WebElement webElement = eDriver.findElement(by);
    executeJS("arguments[0].click()", webElement);
    }

    public void click1 (By by) {
        try {
            click(by, 15);
        } catch (WebDriverException e)
        {
            Common.sleep(1);
            scrollToElement(by);
            click(by,15);
        }
    }
// If normal click above doesn't work Jsclick will click, becouse it finds and clicks anyway
    public void click2 (By by) {
        try {
            click(by, 15);
        } catch (WebDriverException e)
        {
            jsClick(by);
        }
    }

    public void scrollToElement (By by ) {
        WebElement webElement = getElement(by, 15);
        executeJS("arguments[0].scrollIntoView(true)", webElement);
//        JavascriptExecutor js = (JavascriptExecutor) eDriver;
//        js.executeScript("arguments[0].scrollIntoView(true)", webElement);
    }

    public void scrollToElement (int x, int y ) {
        JavascriptExecutor js = (JavascriptExecutor)eDriver;
         js.executeScript("scroll("+ x +", "+ y +")");
//        JavascriptExecutor js = (JavascriptExecutor) eDriver;
//        js.executeScript("arguments[0].scrollIntoView(true)", webElement);
    }

    public void highlightElement (By by) {
        WebElement webElement = getElement(by, 15);
        executeJS("arguments[0].style.border='3px dotted red'", webElement);


    }

    public void validateEquals (By by, String expectedText) {

        if (!getText(by, 15).equals(expectedText)) {
            highlightElement(by);
            takeScreenShot();
            Assert.assertEquals(getText(by,15), expectedText);
        }
    }

    public void validateEquals (String actualString, String expectedText) {

        if (!actualString.equals(expectedText)) {
//            JavascriptExecutor js = (JavascriptExecutor) eDriver;
//            js.executeScript ("arguments[0].style.border='3px dotted red'", webelement);
            takeScreenShot();
            Assert.assertEquals(actualString, expectedText);
        }
    }
    //C:\Users\Vohid-PC\gitRepo\automationpractice
}
