package com.herokuapp.the_internet;

import Driver_Factory.EDriver;
import Utils.AppProperties;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortableDataTables extends EDriver {
    Logger logger = Logger.getLogger(SortableDataTables.class);

    @Test
    public void tableTest1 () {
        driverHelper.operUrl(AppProperties.THE_INTERNET_BASE_URL);
        String tableXpath ="//table[@id='table1']";
        driverHelper.click(By.linkText("Sortable Data Tables"),15);
        logger.info("Clicked by linkText: ");
        int numberOfColomns = driverHelper.getElements(By.xpath(tableXpath+"/thead//th"),15).size();
        int numberOfRows = driverHelper.getElements(By.xpath(tableXpath+"/tbody/tr"),15).size();
//        System.out.println("Table 1: Number of colomus "+numberOfColomns);
//        System.out.println("Table 1: Number of rows "+numberOfRows);

        for (int row =1; row<=numberOfRows; row++) {
            String actualLastName = driverHelper.getText(By.xpath("("+tableXpath+"/tbody/tr)["+row+"]//td[1]"),15);
            if (actualLastName.equals("Bach")) {
                WebElement actionColomnElement = driverHelper.getElement(By.xpath("("+tableXpath+
                        "/tbody/tr)["+row+"]//td["+numberOfColomns+"]"),15); //because edit button is in last colomns
                logger.info("Found element: "+actionColomnElement);
                WebElement editLinkElement = actionColomnElement.findElement(By.linkText("edit"));
                editLinkElement.click();
            }
         }
        driverHelper.takeScreenShot();

        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.endsWith("#edit"));


        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        String lastNameNeeded = "Bach";
//        int rowIndex = 0;
//        List<WebElement> rows = driverHelper.getElements(By.xpath(tableXpath+"/tbody/tr"),15);
//        for (int index = 0; index<rows.size(); index++) {
//        String actualLastName = rows.get(index).findElement(By.tagName("td")).getText();
//            if (lastNameNeeded.equals(actualLastName)) {
//            rowIndex = index+1;
//            break;
//            }
//        }
//
//        driverHelper.getElement(By.xpath(tableXpath+"/tbody/tr["+rowIndex+"]/td"),15);
//
//
//            String editReference="edit";
//            int colomnIndex = 0;
//            int colomnSize = driverHelper.getElements(By.xpath(tableXpath+"/tbody/tr["+rowIndex+"]/td"),15).size();
//            List <WebElement> colomns = driverHelper.getElements(By.xpath(tableXpath+"/tbody/tr["+rowIndex+"]/td"),15);
//
//            for (int index =1; index <= colomnSize;  index++ ) {
//      String actualClickelement = colomns.get(index-1).findElement(By.xpath(tableXpath+"/tbody/tr["+rowIndex+"]//td["+colomnSize+"]//a[1]")).getText();
//                if (editReference.equals(actualClickelement)) {
//                    driverHelper.highlightElement(By.xpath(tableXpath+"/tbody/tr["+rowIndex+"]/td["+colomnSize+"]//a[1]"));
//                    driverHelper.getElement(By.xpath(tableXpath+"/tbody/tr["+rowIndex+"]/td["+index+"]"),15);
//                    driverHelper.click(By.linkText("edit"),15);
//                    Common.sleep(5);
//                    break;
//                }
////            }
//        String currentURL = driver.getCurrentUrl();
//        Assert.assertTrue(currentURL.endsWith("#edit"));

    }

        @Test
    public void example2Table () {
            driverHelper.operUrl(AppProperties.THE_INTERNET_BASE_URL);
            driverHelper.click(By.linkText("Sortable Data Tables"),15);
            WebElement tableElement = driverHelper.getElement(By.id("table2"),15);
            int numberOfRows = tableElement.findElements(By.tagName("tr")).size();
            int numberOfColumns = tableElement.findElements(By.tagName("th")).size();

            for (int row =1; row<=numberOfRows; row++) {
                for (int colomn=1; colomn<=numberOfColumns; colomn++) {
                    String cellValue = row==1 ?
                            tableElement.findElement(By.xpath(".//tr["+row+"]/th["+colomn+"]")).getText(): row>1 && row<5 ?
                            tableElement.findElement(By.xpath(".//tr["+row+"]/td["+colomn+"]")).getText(): row==5 ?
                            tableElement.findElement(By.xpath(".//tr["+(row-1)+"]/td["+colomn+"]")).getText():
                            tableElement.findElement(By.xpath(".//tr["+(row-1)+"]/td["+colomn+"]")).getText();

                    System.out.print(cellValue+"|     ");
                }
                System.out.println();
            }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//            String xpath = "//table[@id='table2']";
//
//            List<WebElement> Header = driverHelper.getElements(By.xpath("//table[@id = 'table2']/thead/tr/th"),15);
//            List<WebElement> rows = driverHelper.getElements(By.xpath("//table[@id='table2']/tbody/tr"),15);
//            List<WebElement> colomns = driverHelper.getElements(By.xpath("//table[@id='table2']/tbody/tr/td"),15);
//
//            for (int index =1; index<=Header.size(); index++) {
//                System.out.print(driverHelper.getElement(By.xpath(xpath+"/thead/tr/th["+index+"]"),15).getText()+"|     ");
//            }
//
//            System.out.println();
//
//            for (int rw =1; rw<=rows.size(); rw++) {
//                for (int cl=1; cl<=Header.size(); cl++) {
//                    System.out.print(driverHelper.getElement(By.xpath(xpath+"/tbody/tr["+rw+"]/td["+cl+"]"),15).getText()+"|    ");
//                }
//                System.out.println();
//            }



        }


}
