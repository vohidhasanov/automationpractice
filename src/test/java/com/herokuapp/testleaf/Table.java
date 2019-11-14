package com.herokuapp.testleaf;

import Driver_Factory.NonStaticDriver;
import Utils.AppProperties;
import Utils.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Table extends NonStaticDriver {
private int timeOutInSeceonds =15;
    @BeforeClass
void beforeClass () {
    driverHelper.operUrl(AppProperties.TEST_LEAF_BASE_URL+"/pages/table.html");
}
    @Test
    public void tableTest1 () {
        //finding numbers of coloms
        int index=0;
        int numberOfColomuns= driverHelper.getElements(By.xpath("//table/tbody/tr/th"),timeOutInSeceonds).size();
        assertEquals(numberOfColomuns, 3);
        WebElement tableElement = driverHelper.getElement(By.tagName("table"), numberOfColomuns);
        int numberOfColomun1 = tableElement.findElements(By.tagName("th")).size();
        System.out.println(numberOfColomun1);

   // driver.close();

    }

    @Test
    public void tableTest2 () {
        int numberOfRows = driverHelper.getElements(By.xpath("//table/tbody/tr/"),timeOutInSeceonds).size();
        assertEquals(numberOfRows, 4);
    }

    @Test
    public void tableTest3() {
        String progress = getCellValue("Learn to interact with Elements", "Progress");
        assertEquals(progress, "80%");
      }

      @Test
      public void tableTest4() {
        WebElement webElement = getCellValue2("Learn to interact with Elements", "Vital Task");
        webElement.click();
         assertTrue(webElement.findElement(By.tagName("input")).isSelected());
          Common.sleep(3);
      }

      @Test
      public void tableTest5() {
          String colomnName = "Vital Task";
          int colomnIndex = 0;
          int rowIndex = 0;
          List<WebElement> colomnElements = driverHelper.getElements(By.xpath("//table/tbody/tr/th"), timeOutInSeceonds);
          List<WebElement> rowElements = driverHelper.getElements(By.xpath("//table/tbody/tr"), timeOutInSeceonds);
          for (int index = 0; index < colomnElements.size(); index++) {
              String actualColomnName = colomnElements.get(index).getText();
              if (actualColomnName.equals(colomnName)) {
                  colomnIndex = index + 1;
                  break;
              }
          }

          String mini = driverHelper.getElements(By.xpath("//table/tbody/tr/td[2]"),timeOutInSeceonds).get(0).getText();
          System.out.println("The minimal is "+mini);
          mini = mini.replaceAll("%","");
          int minimal1 = Integer.parseInt(mini);
          for (int index = 1; index < rowElements.size(); index++) {
             //String actualStringData = driverHelper.getElements(By.xpath("//table/tbody/tr/td[2]"),timeOutInSeceonds).get(index).getText();
             String actualStringData = rowElements.get(index).findElement(By.xpath(".//td[2]")).getText();
             actualStringData = actualStringData.replaceAll("%", "");
             int minimal2 = Integer.parseInt(actualStringData);
                if (minimal2 < minimal1) {
                    minimal1 = minimal2;
                    rowIndex=index+1;
                }
              }
          System.out.println("The minimla is ="+minimal1+ " minimal rowindex is= "+rowIndex);

          WebElement inputElement = driverHelper.getElement(By.xpath("//table/tbody/tr["+(rowIndex)+"]/td["+colomnIndex+"]"),timeOutInSeceonds);
          inputElement.click();
    Common.sleep(3);
      //  driver.close();
      }


      private WebElement getCellValue2(String rowName, String colomnNmae) {
          WebElement webElement =null;
          int colomnIndex =0;

          List<WebElement> colomnElements = driverHelper.getElements(By.xpath("//table/tbody/tr/th"), timeOutInSeceonds);
          for (int index =0; index<colomnElements.size(); index++) {
              String actualColomnName = colomnElements.get(index).getText();
              if (actualColomnName.contains(colomnNmae)) {
                  colomnIndex=index+1; //xpath starts with index 1 so we adding 1
                  break;
              }
          }
          List<WebElement> rowElements = driverHelper.getElements(By.xpath("//table/tbody/tr"), timeOutInSeceonds);
          for (int index=1; index<rowElements.size(); index++) {
              String actualRowName =  rowElements.get(index).findElement(By.tagName("td")).getText();
              if (actualRowName.equals(rowName)) {
                  webElement = rowElements.get(index).findElement(By.xpath(".//td["+colomnIndex+"]"));
                  //  cellValue = driverHelper.getText(By.xpath("//table/tbody/tr/td["+colomnIndex+"]"), timeOutInSeceonds);
                  break;
              }
          }


          return webElement;
      }


      private String getCellValue (String rowName, String colomnNmae) {
        String cellValue ="";
        int colomnIndex =0;

          List<WebElement> colomnElements = driverHelper.getElements(By.xpath("//table/tbody/tr/th"), timeOutInSeceonds);
          for (int index =0; index<colomnElements.size(); index++) {
              String actualColomnName = colomnElements.get(index).getText();
              if (actualColomnName.contains(colomnNmae)) {
                  colomnIndex=index+1; //xpath starts with index 1 so we adding 1
                  break;
              }
          }
              List<WebElement> rowElements = driverHelper.getElements(By.xpath("//table/tbody/tr"), timeOutInSeceonds);
              for (int index=1; index<rowElements.size(); index++) {
                String actualRowName =  rowElements.get(index).findElement(By.tagName("td")).getText();
                if (actualRowName.equals(rowName)) {
                    cellValue = rowElements.get(index).findElement(By.xpath(".//td[2]")).getText();
           //  cellValue = driverHelper.getText(By.xpath("//table/tbody/tr/td["+colomnIndex+"]"), timeOutInSeceonds);
                    break;
                }
              }

        
     return cellValue; }
}
