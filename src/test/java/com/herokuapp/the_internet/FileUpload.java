package com.herokuapp.the_internet;

import Driver_Factory.EDriver;
import Utils.AppProperties;
import Utils.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class FileUpload extends EDriver {
    private final int timeOutInSeconds =15;


    @Test
    public void fileUpload() {
        WebDriverWait webDriverWait = new WebDriverWait(driver,15);
      //  driver.get(AppProperties.THE_INTERNET_BASE_URL);
        driverHelper.operUrl(AppProperties.THE_INTERNET_BASE_URL);
      driverHelper.click(By.linkText("File Upload"),timeOutInSeconds);
      //  DriverHelper driverHelper = new DriverHelper(driver);



        String filePath= System.getProperty("user.dir")+"/src/test/resources/files/1.jpg";
        System.out.println(System.getProperty("user.dir"));
        String fileName = Paths.get(filePath).getFileName().toString();


        driverHelper.sendKeys(By.id("file-upload"), filePath, timeOutInSeconds);
        String uploadedFile = driverHelper.getElement(By.id("file-upload"),timeOutInSeconds).getAttribute("value");
        uploadedFile = Paths.get(uploadedFile).getFileName().toString();  // uploadedFile = uploadedFile.substring(uploadedFile.lastIndexOf('\\')+1);
        Assert.assertEquals(fileName, uploadedFile, "Uploaded file error Failed");

        driverHelper.click(By.id("file-submit"),timeOutInSeconds);

        String actualHeader = driverHelper.getText(By.tagName("h3"), timeOutInSeconds);
        String actualuploadedFile =driverHelper.getText(By.id("uploaded-files"),timeOutInSeconds);

        Assert.assertEquals(actualHeader, "File Uploaded!" );
        Assert.assertEquals(fileName, actualuploadedFile, "The file does not uploaded");

        System.out.println(uploadedFile);
        driverHelper.takeScreenShot();

        Common.sleep(3);
        driver.quit();


    }

}