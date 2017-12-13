package webframe.common;

import javax.servlet.http.HttpServletRequest;

public class cmnUtil {

	public static String getParam(HttpServletRequest req, String paramName){
		String ret = "";
		
		try {
			ret = req.getParameter(paramName);
		}
		catch(Exception e) {
			ret = "";
		}
		return ret;
	}
}
