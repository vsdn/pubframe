package webframe.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
		
		
		 HashMap<String, String> hDataMap = new HashMap();
		
		Gson gson = new Gson();
		
		Enumeration enu = req.getParameterNames();

		 int i = 0;
		 while (enu.hasMoreElements()) {
		  String strName= (String) enu.nextElement();
		  //cmnLog.Debug(strName + ":" + req.getParameter(strName));
		  
			if(strName.substring(0,4).equals("DATA")){
				int _index = strName.indexOf("]");
				int _indexFirst = strName.indexOf("[");
				
				String idx = "";
				String Key = "";
				String Val = "";
				idx = strName.substring(_indexFirst+1,_index);
				Key = strName.substring(_index+2,strName.length()-1);
				Val = cmnUtil.getParam(req, strName);
				cmnLog.Debug(idx + "|" + Key + "|" + Val);
		         setData(objVO, Integer.parseInt(idx), Key, Val);

				//hDataMap.setString(strName.substring(_index+2,strName.length()-1), Integer.parseInt(strName.substring(_indexFirst+1,_index)), objRequest.getParameterValues(strName)[i], strName.substring(0, _indexFirst));
			}
		 
		 }
		 
		 for(i = 0; i < objVO.DATA.size();i++)  {
			 HashMap map = (HashMap)objVO.DATA.get(i);
		     Iterator<String> iterator = map.keySet().iterator();
		     while (iterator.hasNext()) {
		         String key = (String) iterator.next();
		         cmnLog.Debug("key="+key + ":" + " value="+map.get(key));
		     }
		 }
	     Iterator<String> iterator = hDataMap.keySet().iterator();
	     while (iterator.hasNext()) {
	         String key = (String) iterator.next();
	         cmnLog.Debug("key="+key + ":" + " value="+hDataMap.get(key));
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
			HashMap<String, String> map =  (HashMap)objVO.DATA.get(Idx);
			
			map.put(Key, Val);
			objVO.DATA.set(Idx, map);
			
		}
		
	}
	public String getResJson(responseJsonVO objVO) {
		String ret = "";
		
		Gson gson = new Gson();
		ret = gson.toJson(objVO);

		return ret;
	}
}
