package webframe.common;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class cmnLog {
	private static final Logger logger = LogManager.getLogger("webframe");
	public static void Info(String val) {
		logger.info(val);
	}
	public static void Debug(String val) {
		logger.debug(val);
	}
	public static void Error(String val) {
		logger.error(val);
	}
	public static void Error(Exception e) {
		//Logger.getLogger("com.n.els").error(val);
		logger.error(e.toString());
	}
}
