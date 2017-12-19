package webframe.common;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

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
	public static Object getInstance(String clsName) {
        Constructor<?> ctr;
        Class<?> myClass = null;
        Object objRet = null;
		try {
	        myClass = Class.forName(clsName);
			ctr = myClass.getConstructor();
			objRet = ctr.newInstance();
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return objRet;
	}
	public static void setVar(Object objVO, String fieldName, String value) {
		try {
	        Field field = objVO.getClass().getDeclaredField(fieldName);
	        
	        if (field.getType() == Character.TYPE) {field.set(objVO, value.charAt(0)); return;}
	        if (field.getType() == Short.TYPE) {field.set(objVO, Short.parseShort(value)); return;}
	        if (field.getType() == Integer.TYPE) {field.set(objVO, Integer.parseInt(value)); return;}
	        if (field.getType() == Long.TYPE) {field.set(objVO, Long.parseLong(value)); return;}
	        if (field.getType() == Float.TYPE) {field.set(objVO, Float.parseFloat(value)); return;}
	        if (field.getType() == Double.TYPE) {field.set(objVO, Double.parseDouble(value)); return;}
	        if (field.getType() == Byte.TYPE) {field.set(objVO, Byte.parseByte(value)); return;}
	        if (field.getType() == Boolean.TYPE) {field.set(objVO, Boolean.parseBoolean(value)); return;}
	        field.set(objVO, value);
			
		} catch(Exception e) {
			cmnLog.Error(e);
		}
    }
}
