package webframe.common;

import javax.servlet.http.HttpSession;

public class cmnSession {

	public static String getSession(HttpSession sess, String key) {
		String ret = "";

		ret = (String) sess.getAttribute(key);

		if(ret == null) {
			ret = "";
		}
		return ret;
	}
	public static void setSession(HttpSession sess, String key, String val) {
		sess.setAttribute(key, val);
	}
}
