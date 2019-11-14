package com.herokuapp.testleaf;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Dropdown extends Driver_Factory.driver {

    public static void main(String[] args) {
       driver.get("chrome");
        String textboxUrl ="http://testleaf.herokuapp.com/pages/Dropdown.html";
        driver.navigate().to(textboxUrl);
        //driver.findElement(By.xpath("//select[@id='dropdown1']/option[@value='1']"));

        WebElement dropdown1 = driver.findElement(By.id("dropdown1"));
        Select select = new Select(dropdown1);
        select.selectByIndex(1);

        WebElement dropdown2 = driver.findElement(By.name("dropdown2"));
        select = new Select(dropdown2);
        select.selectByVisibleText("Selenium");

        WebElement dropdown3 = driver.findElement(By.id("dropdown3"));
        select = new Select(dropdown3);
        select.selectByValue("2");

        WebElement dropdown4 = driver.findElement(By.cssSelector("[class='dropdown']"));
        select = new Select(dropdown4);

        List <WebElement> optionsOfDroepDown4 = select.getOptions();
        int numberOfOptions= optionsOfDroepDown4.size();

        System.out.println(numberOfOptions); // returns number of Options
            for (WebElement webElement : optionsOfDroepDown4)
            { System.out.println(webElement.getText());   }
        select.selectByValue("4");

            WebElement dropdown5=driver.findElement(By.xpath("(//select)[5]"));
            dropdown5.sendKeys("Loadrunner");


            WebElement dropdown6 = driver.findElement(By.xpath("(//select)[6]"));
            select = new Select (dropdown6);
//            boolean isMultiple= select.isMultiple();
//            if (isMultiple) {
//                select.selectByIndex(1);
//                select.selectByIndex(2);
//                select.selectByIndex(3);
//            }
            Actions actions = new Actions(driver);
            actions.keyDown(Keys.CONTROL)
            .click(select.getOptions().get(1))
            .click(select.getOptions().get(2))
            .click(select.getOptions().get(3))
            .keyUp(Keys.CONTROL).build().perform();
            
            






          //  driver.quit();











    }

}
