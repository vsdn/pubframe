package webframe.SVC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonParser;

import webframe.VO.requestJsonVO;
import webframe.VO.responseJsonVO;
import webframe.common.cmnSvcUtil;

import java.util.Enumeration;

import javax.servlet.ServletContext;

public class svcHost {

	public String serviceHandler(HttpServletRequest req, HttpServletResponse res, HttpSession sess) {
		String ret = "";
		ServletContext context = req.getServletContext();

		cmnSvcUtil objUtil = new cmnSvcUtil();
		//REQUEST VO SET
		requestJsonVO reqVO = objUtil.getReqVO(req);
		
		System.out.println(reqVO.HEADER.getSERVICE());
		/*
		requestJsonVO reqVO = new requestJsonVO();
		Enumeration enu = req.getParameterNames();
		 String strName;

		 while (enu.hasMoreElements()) {
		  strName= (String) enu.nextElement();
		  System.out.println(strName + ":" + req.getParameter(strName));
		 }*/

		
		
		//SESSION VO SET

		
		//IAM CHECK
		
		
		//SVC PROCESS CALL
		
		
		//RESPONSE VO SET
		responseJsonVO resVO = new responseJsonVO();
		
		resVO.HEADER.setCOUNT("11");
		resVO.HEADER.setERROR_FLAG("NORMAL");
		resVO.HEADER.setMSG_CODE("MSG_CODE");
		resVO.HEADER.setMSG("MSG");
		resVO.HEADER.setLAST_PAGE("100");
		resVO.HEADER.setPAGES_CNT("100");
		resVO.HEADER.setTOT_COUNT("TOT_COUNT");
		resVO.HEADER.setREQ_TIME("2017-12-12 17:05:42");
		resVO.HEADER.setRES_TIME("2017-12-12 17:05:59");
		resVO.HEADER.setMAX_FLAG("MAX_F");
		
		
		//RESPONSE VO => JSON
		ret = objUtil.getResJson(resVO); 

		
		return ret;
	}
}
