package webframe.common;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class cmnLog {
	private static final Logger logger = LogManager.getLogger("webframe");
	public static void Info(String val) {
		System.out.println(val);
	}
	public static void Debug(String val) {
		System.out.println(val);
	}
	public static void Error(String val) {
		System.out.println(val);
	}
	public static void Error(Exception e) {
		//Logger.getLogger("com.n.els").error(val);
		System.out.println(e.toString());
	}
}
