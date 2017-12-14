package webframe.SVC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonParser;

import webframe.VO.requestJsonVO;
import webframe.VO.responseJsonVO;
import webframe.VO.testVO;
import webframe.common.cmnLog;
import webframe.common.cmnSvcUtil;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletContext;

public class svcHost {

	public String serviceHandler(HttpServletRequest req, HttpServletResponse res, HttpSession sess) {
		
		String ret = "";
		ServletContext context = req.getServletContext();
		
		cmnSvcUtil objUtil = new cmnSvcUtil();
		//REQUEST VO SET
		requestJsonVO reqVO = objUtil.getReqVO(req);
		

		svcTest svcTest = new svcTest();
		
		//SESSION VO SET	
		//IAM CHECK
		//SVC PROCESS CALL
		//RESPONSE VO SET
		responseJsonVO resVO = null;
		
		resVO = svcTest.getDbcpResult(reqVO);
		/*
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
		
		
		testVO tVO = new testVO();
		
		tVO.setNAME("°í´ë¼®");
		tVO.setAGE("21");

		resVO.DATA.add(tVO);
		*/
		//RESPONSE VO => JSON
		ret = objUtil.getResJson(resVO); 

		
		return ret;
	}
}
