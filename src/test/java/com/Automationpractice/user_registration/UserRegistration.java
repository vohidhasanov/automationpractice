package com.Automationpractice.user_registration;

import Driver_Factory.EDriver;
import Utils.AppProperties;
import Utils.Common;
import Utils.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UserRegistration extends EDriver {
 //   private Logger logger = Logger.getLogger(UserRegistration.class);
    private final int timeOutInSeconds = 15;


   @Test
    public void useerRegistration() {
//       Reporter.createClass("UserRegistration");
//       Reporter.createTest("Account filling");

       WebDriverWait webDriverWait = new WebDriverWait(driver,15);
       DriverHelper driverHelper = new DriverHelper(driver);

       String phoneNumberRandom = Common.getRandomPhoneNumber();
       String mobileNuberRandom = Common.getRandomPhoneNumber();
       int stateNumber = Common.getRandomInt(1,42);
       String firstName = Common.getRandomFirstName();
       String lastName = Common.getRandomLastName();
       String email = Common.getRandomEmail(firstName,lastName);
       String postCode = Common.getRandomCityZipCode();
       String adress1 = Common.getRandomFirstAdress();
       String adress2 = Common.getRandomSecondAdress();

       driver.get(AppProperties.AUTOMATION_PRACTICE_BASE_URL);
       driverHelper.click(By.linkText("Sign in"), timeOutInSeconds);


      String buttonText =driverHelper.getText(By.id("SubmitCreate"), timeOutInSeconds);
      Assert.assertEquals("Create an account", buttonText);
       driverHelper.sendKeys(By.id("email_create"),email, timeOutInSeconds);
       driverHelper.click(By.id("SubmitCreate"),timeOutInSeconds);

       driverHelper.webElementVisibility(By.xpath("//h1[text()='Create an account']"),timeOutInSeconds);

        Common.sleep(3);
        String registrationHeader = driverHelper.getElement(By.tagName("h1"), timeOutInSeconds).getText();
        Assert.assertEquals(registrationHeader, "CREATE AN ACCOUNT");

        driverHelper.click(By.id("uniform-id_gender1"),timeOutInSeconds);
        //WebElement MrButton = driverHelper.getElement(By.id("uniform-id_gender1"),timeOutInSeconds);
        //WebElement MrButton = driverHelper.getElement(By.id("id_gender1"),timeOutInSeconds);//didn't work
      //  MrButton.click();
//        boolean isSelected =MrButton.isSelected();
      //  Assert.assertTrue(isSelected, "The gender Button is not selected");

        driverHelper.sendKeys(By.id("customer_firstname"),firstName,timeOutInSeconds);
        driverHelper.sendKeys(By.id("customer_lastname"), lastName, timeOutInSeconds);


        String actualEmail = driverHelper.getElement(By.id("email"),timeOutInSeconds).getAttribute("value");
        if (!actualEmail.equals(email)) {
        //    logger.error("Actual email -"+actualEmail +", Expected email-"+email);
               }

        driverHelper.sendKeys(By.id("passwd"),"abc123",timeOutInSeconds);
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('class', '')", driverHelper.getElement(By.id("uniform-days"),timeOutInSeconds));
        Select select=  new Select (driverHelper.getElement(By.id("days"),timeOutInSeconds)); //new Select(driver.findElement(By.id("days")));

        select.selectByValue("22");
//
//        int dayOfBirth = Common.getRandomInt(2,31);
//            String dayOfBirthSt = String.valueOf(dayOfBirth);
//        int monthOfBirth = Common.getRandomInt(1,12);
//            String monthOfBirthSt = String.valueOf(monthOfBirth);
//        int yearOfBirth = Common.getRandomInt(2,119);
//            String yearOfBirthSt = String.valueOf(yearOfBirth);
//
//
//       WebElement DayBirthSelect = driver.findElement(By.id("days"));
//       Select select = new Select(DayBirthSelect);
//       select.selectByValue(dayOfBirthSt);
//       //new Select(DayBirthSelect2).selectByValue(dayOfBirthSt);
//
//       WebElement MonthBirthSelect = driver.findElement((By.id("months")));
//       new Select(MonthBirthSelect).selectByValue(monthOfBirthSt);
//
//       WebElement YearBirthSelect = driver.findElement((By.id("years")));
//       new Select (YearBirthSelect).selectByIndex(yearOfBirth);
//
////       WebElement checkboxNewLetter = driver.findElement(By.id("newsletter"));
////       checkboxNewLetter.click();
////       boolean isSelectedCheckboxNewsLetter = checkboxNewLetter.isSelected();
////       Assert.assertTrue(isSelectedCheckboxNewsLetter, "CheckBox Newsletter is not selected");
//
//       WebElement checkboxNewLetter = driver.findElement(By.id("newsletter"));
//       checkboxNewLetter.click();
//       boolean isSelectedCheckboxNewsLetter = checkboxNewLetter.isSelected();
//       Assert.assertTrue(isSelectedCheckboxNewsLetter, "CheckBox Newsletter is not selected");
//
//       WebElement checkboxOptin = driver.findElement(By.id("optin"));
//       checkboxOptin.click();
//       boolean isSelectedCheckboxOptin = checkboxOptin.isSelected();
//       Assert.assertTrue(isSelectedCheckboxOptin, "The checkbox -Recieve special offers is not selected");






        Common.sleep(5);

       //Assert.assertEquals(driverHelper.getText(By.xpath("//h1[text()='Create an account']"),timeOutInSeconds),"CREATE AN ACCOUNT" );

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


//      String headerText = driver.findElement(By.xpath("//h1[text()='Create an account']")).getText();
//     System.out.println(headerText);
//
//       Assert.assertEquals(headerText, "CREATE AN ACCOUNT", "1st Hearder name isn't valid");
//
//       String secondHeaderText = driver.findElement(By.xpath("//h3[text()='Your personal information']")).getText();
//       Assert.assertEquals(secondHeaderText, "YOUR PERSONAL INFORMATION");
//
//       WebElement MrButton = driver.findElement(By.id("id_gender1"));
//       WebElement MrsButton = driver.findElement(By.id("id_gender2"));
//       MrButton.click();
//       boolean isSelected =MrButton.isSelected();
//        Assert.assertTrue(isSelected, "Mr. button is selected");
//
//       driver.findElement(By.id("customer_firstname")).sendKeys(firstName);
//       driver.findElement(By.id("customer_lastname")).sendKeys(lastName);
//
//       driver.findElement(By.id("passwd")).sendKeys(firstName+lastName);
//       int dayOfBirth=Common.getRandomInt(1,31);
//       int monthOfBirth=Common.getRandomInt(2,12);
//       int yearOfBirth=Common.getRandomInt(2,119);
//       driver.findElement(By.xpath("(//select[@id='days']//following-sibling::option[@value])["+dayOfBirth+"]")).click();
//       driver.findElement(By.xpath("(//select[@id='months']//following-sibling::option[@value])["+monthOfBirth+"]")).click();
//       driver.findElement(By.xpath("(//select[@id='years']//following-sibling::option[@value])["+yearOfBirth+"]")).click();
//
//      WebElement newLetterSignUp = driver.findElement(By.id("newsletter"));
//      newLetterSignUp.click();
//      boolean isSelected2 =newLetterSignUp.isSelected();
//      Assert.assertTrue(isSelected2, "Newletter button is not selected");
//
//      WebElement recieveSpecialOffer = driver.findElement(By.xpath("//input[@id='optin']"));
//      recieveSpecialOffer.click();
//      boolean isSelected3 = recieveSpecialOffer.isSelected();
//      Assert.assertTrue(isSelected3, "Recieve special Offers button is not selected");
//
//      driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstName);
//      driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
//      driver.findElement(By.xpath("//input[@id='company']")).sendKeys("TechCenture");
//
//
//
//
//      driver.findElement(By.xpath("//input[@id ='company' ]")).sendKeys("Virgina state");
//      String StreetAdress = driver.findElement(By.xpath("//span[text()='Street address, P.O. Box, Company name, etc.']")).getText();
//      Assert.assertEquals(StreetAdress, "Street address, P.O. Box, Company name, etc.");
//
//       driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(adress1);
//      driver.findElement(By.xpath("//input[@id='address2']")).sendKeys(adress2);
//      String Address2 = driver.findElement(By.xpath("//span[text()='Apartment, suite, unit, building, floor, etc...']")).getText();
//      Assert.assertEquals(Address2, "Apartment, suite, unit, building, floor, etc...");
//
//      driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Virginia");
//
//
//
//      driver.findElement(By.xpath("//select[@id= 'id_state']//following-sibling::option[@value]["+stateNumber+"]")).click();
//
//      driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys(postCode);
//      driver.findElement(By.xpath("//select[@id='id_country']//following-sibling::option[@value][2]")).click();
//
//      driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys("Hello world");
//
//
//      driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phoneNumberRandom);
//
//      driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys(mobileNuberRandom);
//
//
//      String aliasRandomAdress = Common.getRandomFirstAdress();
//      driver.findElement(By.xpath(("//input[@id='alias']"))).sendKeys(aliasRandomAdress);
//










    }





    }

