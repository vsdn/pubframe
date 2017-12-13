package webframe.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import webframe.VO.requestJsonVO;
import webframe.VO.responseJsonVO;

public class cmnSvcUtil {

	public requestJsonVO getReqVO(HttpServletRequest req) {
		requestJsonVO objVO = new requestJsonVO();		
		
		objVO.HEADER.setSERVICE(cmnUtil.getParam(req, "HEADER[SERVICE]"));
		
		Gson gson = new Gson();
		
		Enumeration enu = req.getParameterNames();
		 String strName;

		 while (enu.hasMoreElements()) {
		  strName= (String) enu.nextElement();
		  cmnLog.Debug(strName + ":" + req.getParameter(strName));
		 }

		

		 
		//gson.fromJson(response,VolumeContainer.class);
		
		
		return objVO;
	}
	public String getResJson(responseJsonVO objVO) {
		String ret = "";
		
		Gson gson = new Gson();
		ret = gson.toJson(objVO);

		return ret;
	}
}
