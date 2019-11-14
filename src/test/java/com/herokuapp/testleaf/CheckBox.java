package com.herokuapp.testleaf;

import Driver_Factory.NonStaticDriver;
import Utils.AppProperties;
import Utils.Common;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBox extends NonStaticDriver {
    private int timeOutSeconds =15;
  //  private DriverHelper ;

    @BeforeTest
public void classSetUp () {
    driver.get(AppProperties.TEST_LEAF_BASE_URL);
   // driverHelper.operUrl("http://testleaf.herokuapp.com/pages/checkbox.html");
    System.out.println("hey");
}

String xpath = "//label[contains(text(),\"{0}\")]/following-sibling::input[@type='checkbox']";
    @Test
    public void checkboxTest1() {
        driverHelper.click(By.linkText("Checkbox"), timeOutSeconds);
        String xpath ="//label[contains(text(),'Select the languages that you know?')]/following-sibling::input[@type='checkbox']";
      //  String text ="Select the languages that you know?";

        //xpath = MessageFormat.format(this.xpath, text);

        //driverHelper.click(By.xpath("(" + xpath+")[1]"), timeOutSeconds );
        driverHelper.click(By.xpath(xpath),1, timeOutSeconds);
        driverHelper.click(By.xpath(xpath),2, timeOutSeconds);
        driverHelper.click(By.xpath(xpath),3, timeOutSeconds);
        driverHelper.click(By.xpath(xpath),4, timeOutSeconds);
        driverHelper.click(By.xpath(xpath),5, timeOutSeconds);
        Common.sleep(3);
        for (int index =0; index< driverHelper.getElements(By.xpath(xpath),timeOutSeconds).size(); index++)
             {
                 driverHelper.click(By.xpath(xpath),index+1, timeOutSeconds);
            }
      //  Common.sleep(3);
    }

    @Test
    public void checkboxTest2 () {
        driverHelper.click(By.linkText("Checkbox"), timeOutSeconds);
       String xpath = "//label[contains(text(),'Confirm Selenium is checked')]/following-sibling::input[@type='checkbox']";
        //xpath = MessageFormat.format(this.xpath, "Confirm Selenium is checked");
        boolean isChecked = driverHelper.getElement(By.xpath(xpath), timeOutSeconds).isSelected();
        Assert.assertTrue(isChecked, "Selenium checkbox was not checked.");

       // Common.sleep(4);
    }
@Test
    public void chekboxTest3 () {
       // String xpath=
        driverHelper.click(By.linkText("Checkbox"), timeOutSeconds);
        String xpath = "//label[contains(text(), 'DeSelect only checked')]/following-sibling::input[@type='checkbox']";
        boolean isUnSelected= driverHelper.getElement(By.xpath(xpath),timeOutSeconds).isSelected();

        for (int index=0; index<driverHelper.getElements(By.xpath(xpath),timeOutSeconds).size(); index++) {
           // String ind = (index-1)+"";
            if (driverHelper.getElement(By.xpath(xpath+"["+(index+1)+"]"),timeOutSeconds).isSelected()) {
                driverHelper.click(By.xpath(xpath+"["+(index+1)+"]"),timeOutSeconds);
                            }
        }
        Common.sleep(3);


    }



}
