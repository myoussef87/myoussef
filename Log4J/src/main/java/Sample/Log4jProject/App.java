package Sample.Log4jProject;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class App {
private static Logger logger =  LogManager.getLogger(App.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
logger.error("Error log");
System.out.println("Test Logs");
	}

}
