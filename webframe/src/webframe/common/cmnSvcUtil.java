package webframe.common;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import webframe.VO.requestJsonVO;
import webframe.VO.responseJsonVO;

public class cmnSvcUtil {

	public requestJsonVO getReqVO(HttpServletRequest req) {
		requestJsonVO objVO = new requestJsonVO();	
		objVO.HEADER.setSERVICE(req.getParameter("HEADER[SERVICE]"));
		
		Gson gson = new Gson();
		
		
		return objVO;
	}
	public String getResJson(responseJsonVO objVO) {
		String ret = "";
		
		Gson gson = new Gson();
		ret = gson.toJson(objVO);

		return ret;
	}
}
