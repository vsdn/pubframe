package webframe.common;

import javax.servlet.http.HttpServletRequest;

import webframe.VO.requestJsonVO;

public class cmnSvcUtil {

	public requestJsonVO getReqVO(HttpServletRequest req) {
		requestJsonVO objVO = new requestJsonVO();	
		objVO.HEADER.setSERVICE(req.getParameter("HEADER[SERVICE]"));
		
		return objVO;
	}
}
