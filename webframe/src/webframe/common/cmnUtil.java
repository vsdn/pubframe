package webframe.common;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

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
	public static String getConfig(String key) {
		String ret = "";
		
		try {
			Properties properties = loadPropByName("");
			ret = properties.getProperty(key);
			if(ret == null) {
				ret = "";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			cmnLog.Error(e);
			ret = "";
		}
		
		return ret;
	}
	public static String getConfig(String propName, String key) {
		String ret = "";
		
		try {
			Properties properties = loadPropByName(propName);
			ret = properties.getProperty(key);
			if(ret == null) {
				ret = "";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			cmnLog.Error(e);
			ret = "";
		}
		
		return ret;
	}
	private static Properties loadPropByName(String propName) throws IOException {
		String path = "";
		if(propName == null) {
			propName = "";
		}
		propName = propName.toUpperCase();
		if("".equals(propName)) {
			path = "/webframe/config/config.properties";
		}
		else if("DEFAULT".equals(propName)) {
			path = "/webframe/config/config.properties";
		}
		else if("MSG".equals(propName)) {
			path = "/webframe/config/msg.properties";
		}
		else if("MESSAGE".equals(propName)) {
			path = "/webframe/config/msg.properties";
		}
		else {
			path = propName;
		}
		
		Properties properties = loadPropForStatic(path);
		return properties;
	}
    private static Properties loadPropForStatic(String path) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = cmnUtil.class.getClassLoader().getResourceAsStream(path);
        properties.load(inputStream);
        inputStream.close();
        return properties;
    }
}
