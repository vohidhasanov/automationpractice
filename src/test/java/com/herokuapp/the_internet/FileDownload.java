package com.herokuapp.the_internet;

import Driver_Factory.NonStaticDriver;
import Utils.AppProperties;
import Utils.Common;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FileDownload extends NonStaticDriver {
    private int timeOutInSeconds = 15;
    @Test
    public void fileDonwnloadTest1 () {
        driverHelper.operUrl(AppProperties.THE_INTERNET_BASE_URL+"/download");
        String fileName ="webdriverIO.png";
        driverHelper.click(By.linkText(fileName), timeOutInSeconds);
        File file = new File(System.getProperty("user.home")+"/Downloads/"+fileName);
        System.out.println(file);
        boolean isFileExists = file.exists();
        int numberOfAttemps = 0;
        while (!isFileExists && numberOfAttemps<5) {
            Common.sleep(1);
            isFileExists = file.exists();
            numberOfAttemps++;
        }


        Assert.assertTrue(file.exists(), "File \""+fileName+"\" not found in Downloads directory");
        Common.sleep(5);
    }

}
