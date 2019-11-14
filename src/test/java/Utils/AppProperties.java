package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppProperties {
  
 private static Properties properties = getProperties();

  public static final String TEST_LEAF_BASE_URL = properties.getProperty("test_leaf_base_url");
  public static final String AUTOMATION_PRACTICE_BASE_URL = properties.getProperty("automation_practice_base_url");
  public static final String THE_INTERNET_BASE_URL = properties.getProperty("the_internet_base_url");
  public static final String BROWSER_TYPE = properties.getProperty("browser_type");


  private static Properties getProperties () {
		Properties properties = new Properties();
		
		try {
		 String filePath = System.getProperty("user.dir")+"/src/test/resources/properties/config.properties";
		 InputStream inputstream = new FileInputStream(filePath);
		 properties.load(inputstream);
         System.out.println(properties.getProperty("base_url"));
		} catch (IOException e) {
            System.out.println("File not found");
			e.printStackTrace();
		}
		return properties;
	}

}
