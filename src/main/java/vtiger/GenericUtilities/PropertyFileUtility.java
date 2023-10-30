package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;
/* The generic class consists of description and author 


/* This class consists of generic/reusable methods related to property file 
 * @ author Bhumika S
 */

public class PropertyFileUtility {

/*	This method will read data from property file and return the value to 
 * caller 
 * @param PropertyFileKey
 * @return
 * @throws Throwable
 */
	
	
//	main PSVM will not work and since this will not work we will not add here
	
//	It is a non static generic method
	public String readDataFromPropertyFile(String PropertyFileKey) throws Throwable{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.Properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(PropertyFileKey);
		return value;
	}

}
