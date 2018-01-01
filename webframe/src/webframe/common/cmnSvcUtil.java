package webframe.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import webframe.VO.requestJsonVO;
import webframe.VO.responseJsonVO;

public class cmnSvcUtil {

	public requestJsonVO getReqVO(HttpServletRequest req) {
		requestJsonVO objVO = new requestJsonVO();		
		
		objVO.HEADER.setSERVICE(cmnUtil.getParam(req, "HEADER[SERVICE]"));
		objVO.HEADER.setMETHOD(cmnUtil.getParam(req, "HEADER[METHOD]"));
		objVO.HEADER.setMENU_ID(cmnUtil.getParam(req, "HEADER[MENU_ID]"));
		objVO.HEADER.setASYNC(cmnUtil.getParam(req, "HEADER[ASYNC]"));
		objVO.HEADER.setPROGRESS_BAR(cmnUtil.getParam(req, "HEADER[PROGRESS_BAR]"));
		objVO.HEADER.setTYPE(cmnUtil.getParam(req, "HEADER[TYPE]"));
		objVO.HEADER.setURL(cmnUtil.getParam(req, "HEADER[URL]"));
		objVO.HEADER.setCLIENT_TYPE(cmnUtil.getParam(req, "HEADER[CLIENT_TYPE]"));
		objVO.HEADER.setCLIENT_META(cmnUtil.getParam(req, "HEADER[CLIENT_META]"));
		objVO.HEADER.setCONTROL_TYPE(cmnUtil.getParam(req, "HEADER[CONTROL_TYPE]"));
		objVO.HEADER.setCONTROL_ID(cmnUtil.getParam(req, "HEADER[CONTROL_ID]"));
		objVO.HEADER.setPAGES_CNT(cmnUtil.getParam(req, "HEADER[PAGES_CNT]"));
		objVO.HEADER.setROW_CNT(cmnUtil.getParam(req, "HEADER[ROW_CNT]"));
		objVO.HEADER.setMAX_LIMIT(cmnUtil.getParam(req, "HEADER[MAX_LIMIT]"));
		
		Enumeration<String> enu = req.getParameterNames();
		 while (enu.hasMoreElements()) {
		  String strName= (String) enu.nextElement();
		  
			if(strName.substring(0,4).equals("DATA")){
				int _index = strName.indexOf("]");
				int _indexFirst = strName.indexOf("[");
				
				String idx = "";
				String Key = "";
				String Val = "";
				idx = strName.substring(_indexFirst+1,_index);
				Key = strName.substring(_index+2,strName.length()-1);
				Val = cmnUtil.getParam(req, strName);

		        setData(objVO, Integer.parseInt(idx), Key, Val);
			}
		 
		 }
		return objVO;
	}
	private void setData(requestJsonVO objVO, int Idx, String Key, String Val) {
		int i = 0;
		
		if(objVO.DATA.size() < Idx + 1) {
			for(i = 0; i < Idx - objVO.DATA.size() + 1; i++) {
				objVO.DATA.add(null);
			}
		}
		if(objVO.DATA.get(Idx) == null) {
			HashMap<String, String> map =  new HashMap<String, String>();
			
			map.put(Key, Val);
			objVO.DATA.set(Idx, map);
			
		}
		else {
			HashMap<String, String> map =  (HashMap<String, String>)objVO.DATA.get(Idx);
			map.put(Key, Val);
			objVO.DATA.set(Idx, map);
		}
		
	}
	public String getResJson(responseJsonVO objVO) {
		String ret = "";
		
		Gson gson = new Gson();
		ret = gson.toJson(objVO);

		cmnLog.Debug("SVC Response : " + ret);
		return ret;
	}
	public String getReqJson(requestJsonVO objVO) {
		String ret = "";
		
		Gson gson = new Gson();
		ret = gson.toJson(objVO);

		cmnLog.Debug("SVC Request : " + ret);
		return ret;
	}
	public responseJsonVO callSvc(requestJsonVO objVO) {
		responseJsonVO resVO = null;
		
		String svcName = objVO.HEADER.getSERVICE();
		String methodName = objVO.HEADER.getMETHOD();
		String svcID = svcName.substring(0, 4);
		
		
		try {
			Object objSvc = cmnUtil.getInstance("webframe.SVC." + svcID + "." + svcName + "SVC");
			Method method = ((Class<?>) objSvc.getClass()).getMethod(methodName, requestJsonVO.class);
			resVO = (responseJsonVO) method.invoke(objVO, objVO);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			cmnLog.Error(e);
			cmnLog.Error("callSVC Error : [" + svcID + "][" + svcName + "][" + methodName + "]");
			cmnLog.Error("callSVC Error reqVO : [" + getReqJson(objVO) + "]");
		}
		
		return resVO;
		
	}
}
