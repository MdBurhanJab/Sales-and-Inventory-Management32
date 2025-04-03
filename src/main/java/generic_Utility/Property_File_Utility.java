package generic_Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This Class consist of methods related to Propertyfile
 */
public class Property_File_Utility {
	/**
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String ToReadDatafromPropertyfile(String key) throws IOException {
		FileInputStream fid = new FileInputStream(".\\src\\test\\resources\\commonfolder.properties");
		Properties ps = new Properties();
		ps.load(fid);
		String value = ps.getProperty(key);
		return value;
	}
	
	
}
