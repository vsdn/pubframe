package webframe.SVC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonParser;

import webframe.DAO.USR.USR0101M01DAO;
import webframe.VO.requestJsonVO;
import webframe.VO.responseJsonVO;
import webframe.VO.testVO;
import webframe.VO.USR.USR0101M01VO;
import webframe.common.cmnLog;
import webframe.common.cmnSvcUtil;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletContext;

public class svcHost {

	public String serviceHandler(HttpServletRequest req, HttpServletResponse res, HttpSession sess) {
		String ret = "";
		ServletContext context = req.getServletContext();
		cmnSvcUtil objUtil = new cmnSvcUtil();
		//REQUEST VO SET
		requestJsonVO reqVO = objUtil.getReqVO(req);
		responseJsonVO resVO = null;

		//cmnLog.Debug(reqVO.HEADER.getTYPE());
		try {
			cmnSvcUtil objSvcUtil = new cmnSvcUtil();
			resVO = objSvcUtil.callSvc(reqVO);
		} catch(Exception e) {
			
		}
		
		ret = objUtil.getResJson(resVO); 

		
		return ret;
	}

}
