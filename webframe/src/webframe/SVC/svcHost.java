package webframe.SVC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonParser;

import webframe.VO.requestJsonVO;
import webframe.VO.responseJsonVO;
import webframe.VO.testVO;
import webframe.VO.usrVO;
import webframe.common.cmnDbCon;
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
		
		if("InsertUser".equals(reqVO.HEADER.getMETHOD()))
		{
			resVO = InsertUser(reqVO);
		}
		else if("SelectUser".equals(reqVO.HEADER.getMETHOD()))
		{
			resVO = SelectUser(reqVO);
		}	
		else if("DeleteUser".equals(reqVO.HEADER.getMETHOD()))
		{
			resVO = DeleteUser(reqVO);
		}
		else if("UpdateUser".equals(reqVO.HEADER.getMETHOD()))
		{
			resVO = UpdateUser(reqVO);
		}		
		svcTest svcTest = new svcTest();
		
		//SESSION VO SET	
		//IAM CHECK
		//SVC PROCESS CALL
		//RESPONSE VO SET
		
		//resVO = svcTest.getDbcpResult(reqVO);
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
	private responseJsonVO InsertUser(requestJsonVO reqVO) {
	
		responseJsonVO resVO = new responseJsonVO();	
		cmnDbCon objDbCon = new cmnDbCon();
		usrVO	usrVO = new usrVO();
		
		
		String sQuery1 = "",sQuery2 = "";
	

		/* for(int i = 0; i < reqVO.DATA.size();i++)  {
			 HashMap map = (HashMap)reqVO.DATA.get(i);
		     Iterator<String> iterator = map.keySet().iterator();
		     while (iterator.hasNext()) {
		         String key = (String) iterator.next();
		        
		     }
		 }*/
		 
		sQuery1 = "INSERT INTO NAEDU.dbo.TFRWUSR0101M  (	USID, PASSWORD, USNAME, LIFYEA, USE_F,DEPT_CODE, GRADE, RM, SYS_FRST_DATE ) VALUES ";
		sQuery2 = ("(?, ?, ?, ?, ?, ?,?,?, GETDATE())");
		sQuery1 += sQuery2;
		
		cmnLog.Debug(sQuery1);
		resVO = objDbCon.insertUserResult(reqVO, sQuery1);
		
		
		
		
		return resVO;
	}
	private responseJsonVO SelectUser(requestJsonVO reqVO) {
		
		responseJsonVO resVO = new responseJsonVO();	
		cmnDbCon objDbCon = new cmnDbCon();
		
		
		String sQuery = "";
	

		sQuery = 	"SELECT USID, USNO, PASSWORD, ISNULL(LOGIN_F,0)  as LOGIN_F, FAILR_CNT, CONVERT(VARCHAR(10),LAST_LOGIN_DATE,23) as LAST_LOGIN_DATE, USNAME,  CONVERT(VARCHAR(10),LIFYEA,23) as LIFYEA,  ISNULL(USE_F,0) as USE_F, DEPT_CODE, GRADE, SYS_FRST_USNO, CONVERT(VARCHAR(10),SYS_FRST_DATE,23) as SYS_FRST_DATE, SYS_UPDT_USNO, CONVERT(VARCHAR(10),SYS_UPDT_DATE,23) as SYS_UPDT_DATE,RM\r\n" + 
					"FROM   NAEDU.dbo.TFRWUSR0101M (NOLOCK) ";
		
		HashMap map = (HashMap)reqVO.DATA.get(0);
		
		cmnLog.Debug(reqVO.HEADER.getTYPE());
		
		if(("ID").equals((String) map.get("STYPE")))
		{
			sQuery += "WHERE USID like '%' + ? + '%'";
		}
		else
		{
			sQuery += "WHERE USNAME like '%' + ? + '%'";
		}

		resVO = objDbCon.SelectUserResult(reqVO, sQuery);
		
		
		
		
		return resVO;
	}
	private responseJsonVO DeleteUser(requestJsonVO reqVO) {
		
		responseJsonVO resVO = new responseJsonVO();	
		cmnDbCon objDbCon = new cmnDbCon();
		usrVO	usrVO = new usrVO();
		
		
		String sQuery = "";
	

		 
		sQuery = "DELETE NAEDU.dbo.TFRWUSR0101M WHERE USNO = ? ";

		
		cmnLog.Debug(sQuery);
		resVO = objDbCon.deleteUserResult(reqVO, sQuery);
		
		
		
		
		return resVO;
	}
	private responseJsonVO UpdateUser(requestJsonVO reqVO) {
		
		responseJsonVO resVO = new responseJsonVO();	
		cmnDbCon objDbCon = new cmnDbCon();
		usrVO	usrVO = new usrVO();
		
		
		String sQuery = "";
	

		 
		sQuery =  " UPDATE 	NAEDU.dbo.TFRWUSR0101M " +
				  " SET		USNAME = ?, " +
				  " 		USID = ?, " +
				  " 		LIFYEA = ?, " +
				  " 		USE_F = ?, " +
				  " 		DEPT_CODE = ?, " +
				  " 		GRADE = ?, " +
				  " 		RM = ?, " +
				  "			SYS_UPDT_DATE = GETDATE() " +		
				  " WHERE USNO = ? ";

		
		cmnLog.Debug(sQuery);
		resVO = objDbCon.updateUserResult(reqVO, sQuery);
		
		
		
		
		return resVO;
	}
}
