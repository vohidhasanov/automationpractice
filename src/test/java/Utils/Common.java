package Utils;

import com.github.javafaker.Faker;
import org.apache.log4j.Logger;

import java.io.File;

public class Common {
    private static Logger logger = Logger.getLogger(Common.class);
    private static Faker faker = new Faker();



    public static void sleep (int second) {
        try {
            int secondsSleep = second*1000;
            Thread.sleep(secondsSleep);
            logger.info("sleep for "+secondsSleep+" seconds");
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public static String getRandomFirstName()  {
        String randomFirstName =faker.firstName();
        logger.info("random first name is generated: "+randomFirstName);
        return randomFirstName; }

    public static String getRandomLastName()
    {   String randomLastName = faker.lastName();
        logger.info("random last name is generated: "+randomLastName);
        return randomLastName;
    }

    public static String getRandomPhoneNumber() {return  faker.phoneNumber();}

    public static String getRandomCityZipCode() {return  faker.zipCode();}

    public static String getRandomFirstAdress() {return faker.streetAddress(true);}

    public static String getRandomSecondAdress() {return faker.secondaryAddress();}



    public static int getRandomInt (int startPoint, int endPoint) {
        int randomNumber = (int) (startPoint+Math.random()*endPoint);
        return randomNumber;
    }

    public static String getRandomEmail (String firstName, String lastName) {
        String [] emails = {"@gmail.com", "@yahoo.com", "@hotmail.com", "@aol.com", "@hotmail.co.uk", "@hotmail.fr", "@msn.com", "@yahoo.fr", "@wanadoo.fr", "@orange.fr", "@comcast.net", "@yahoo.co.uk", "@yahoo.com.br", "@yahoo.co.in", "@live.com", "@rediffmail.com", "@free.fr", "@gmx.de", "@web.de", "@yandex.ru", "@ymail.com", "@libero.it", "@outlook.com", "@uol.com.br", "@bol.com.br", "@mail.ru", "@cox.net", "@hotmail.it", "@sbcglobal.net", "@sfr.fr", "@live.fr", "@verizon.net", "@live.co.uk", "@googlemail.com", "@yahoo.es", "@ig.com.br", "@live.nl", "@bigpond.com", "@terra.com.br", "@yahoo.it", "@neuf.fr", "@yahoo.de", "@alice.it", "@rocketmail.com", "@att.net", "@laposte.net", "@facebook.com", "@bellsouth.net", "@yahoo.in", "@hotmail.es", "@charter.net", "@yahoo.ca", "@yahoo.com.au", "@rambler.ru", "@hotmail.de", "@tiscali.it", "@shaw.ca", "@yahoo.co.jp", "@sky.com", "@earthlink.net", "@optonline.net", "@freenet.de", "@t-online.de", "@aliceadsl.fr", "@virgilio.it", "@home.nl", "@qq.com", "@telenet.be", "@me.com", "@yahoo.com.ar", "@tiscali.co.uk", "@yahoo.com.mx", "@voila.fr", "@gmx.net", "@mail.com", "@planet.nl",
                "@tin.it", "@live.it", "@ntlworld.com", "@arcor.de", "@yahoo.co.id", "@frontiernet.net", "@hetnet.nl", "@live.com.au", "@yahoo.com.sg", "@zonnet.nl", "@club-internet.fr", "@juno.com", "@optusnet.com.au", "@blueyonder.co.uk", "@bluewin.ch", "@skynet.be", "@sympatico.ca",
                "@windstream.net", "@mac.com", "@centurytel.net", "@chello.nl", "@live.ca", "@aim.com", "@bigpond.net.au"};


        return (firstName+"."+lastName+emails[getRandomInt(0,emails.length)]).toLowerCase();
    }

    public static void deleteFiles (String directoryPath) {
        File file = new File  (System.getProperty("user_id")+directoryPath);
        for ( File file1: file.listFiles()) {
            boolean isfileDeleted =  file1.delete();
            if (isfileDeleted) System.out.println("File \"" +file1.toPath().getFileName()+"\" deleted");
            System.out.println("File \"" +file1.toPath().getFileName()+"\" not deleted");
              }


    }

//    public static void main(String[] args) {
//        WebDriver driver = Driver.driver.getDriver("chrome");
//        driver.get("https://email-verify.my-addr.com/list-of-most-popular-email-domains.php");
//        List<WebElement> rowElement = driver.findElements(By.xpath("(//h2[text()='Top 100']/..//table//tr)"));
//
//        for (int x=1; x<=rowElement.size(); x++) {
//        String email = driver.findElement(By.xpath("((//h2[text()='Top 100']/..//table//tr)["+ x+"]//td)[3]")).getText();
//        email = "\"@"+email+"\", ";
//        System.out.print(email);
//        }
//
//
//
//    }

}
