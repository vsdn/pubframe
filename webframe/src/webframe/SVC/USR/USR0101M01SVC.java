package webframe.SVC.USR;

import java.util.HashMap;

import webframe.DAO.USR.USR0101M01DAO;
import webframe.VO.requestJsonVO;
import webframe.VO.responseJsonVO;
import webframe.common.cmnLog;

public class USR0101M01SVC {
	private responseJsonVO InsertUser(requestJsonVO reqVO) {
		responseJsonVO resVO = new responseJsonVO();	
		USR0101M01DAO objDAO = new USR0101M01DAO();
		
		String sQuery1 = "",sQuery2 = "";
		 
		sQuery1 = "INSERT INTO NAEDU.dbo.TFRWUSR0101M  (	USID, PASSWORD, USNAME, LIFYEA, USE_F,DEPT_CODE, GRADE, RM, SYS_FRST_DATE ) VALUES ";
		sQuery2 = ("(?, ?, ?, ?, ?, ?,?,?, GETDATE())");
		sQuery1 += sQuery2;
		
		cmnLog.Debug(sQuery1);
		resVO = objDAO.insertUserResult(reqVO, sQuery1);
		
		return resVO;
	}
	private responseJsonVO SelectUser(requestJsonVO reqVO) {
		
		responseJsonVO resVO = new responseJsonVO();	
		USR0101M01DAO objDAO = new USR0101M01DAO();
		
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

		resVO = objDAO.SelectUserResult(reqVO, sQuery);
		
		return resVO;
	}
	private responseJsonVO DeleteUser(requestJsonVO reqVO) {
		
		responseJsonVO resVO = new responseJsonVO();	
		USR0101M01DAO objDAO = new USR0101M01DAO();
		
		String sQuery = "";

		sQuery = "DELETE NAEDU.dbo.TFRWUSR0101M WHERE USNO = ? ";
		
		cmnLog.Debug(sQuery);
		resVO = objDAO.deleteUserResult(reqVO, sQuery);
		
		return resVO;
	}
	private responseJsonVO UpdateUser(requestJsonVO reqVO) {
		responseJsonVO resVO = new responseJsonVO();	
		USR0101M01DAO objDAO = new USR0101M01DAO();
		
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
		resVO = objDAO.updateUserResult(reqVO, sQuery);
		
		return resVO;
	}
}
