package automationpractice.demos;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProviderDemo {


//    @DataProvider(name = "mortgageData")
//    public Object[][] getData() {
//        String [][] data = new String [][] {
//                {"3.1", "330000", "15000", "30 "},
//                {"3.75", "270000", "12000", "15 "},
//                {"3.86", "295000", "35000", "30 "},
//        };
//        return data;
//    }



//    @DataProvider(name = "mortgageData")
//    public Object[] getData() {
//        Double[][] data = new Double[][]{
//                {3.1, 330000.0, 15000.0, 30.0 },
//                {3.75, 270000.0, 12000.0, 15.0 },
//                {3.86, 295000.0, 35000.0, 30.0 },
//        };
//        return data;
//    }

      //MIX variant of DataProvider
        @DataProvider(name = "mortgageData")
    public Object[] getData() {
        Object[][] data = new Object[][]{
                {3.1, "330000.0", 15000.0, true },
                {3.75, "270000.0", 12000.0, 15.0 },
                {3.86, "295000.0", 35000.0, 30.0 },
        };
        return data;
    }





    @Test (dataProvider = "mortgageData")
    public void calculateMortgageMonthPayment (Double ir, String tl, Double dp, Double l) {
        System.out.println("Interest rate: " +ir );
        System.out.println("Total loat: "+tl );
        System.out.println("Downpayment: "+dp );
        System.out.println("Length: "+l );

    }
}
