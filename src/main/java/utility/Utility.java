package utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import base.TestBase;

public class Utility extends TestBase {
	
	public static boolean flag = false;
	public static Logger getLogger(Class clas) {
		if(flag) {
			return Logger.getLogger(clas);
		}
		PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/main/java/config/log4j.properties");
		flag=true;
		return Logger.getLogger(clas);
	}

}
