package webframe.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import webframe.VO.requestJsonVO;
import webframe.VO.responseJsonVO;
import webframe.VO.usrVO;

public class cmnDbCon {
	public  responseJsonVO insertUserResult(requestJsonVO reqVO, String szQuery){
		
		responseJsonVO rsVO = new responseJsonVO();
		cmnLog.Debug(szQuery);
		cmnDb objDB = new cmnDb();
		
		Connection con = objDB.getConnection();
		ArrayList arrParams = new ArrayList();
		int cnt = 0;
		
		for(int i = 0; i < reqVO.DATA.size();i++)  {
			 HashMap map = (HashMap)reqVO.DATA.get(i);
			 arrParams.add((String) map.get("USID"));
			 arrParams.add((String) map.get("PASSWORD"));
			 arrParams.add((String) map.get("USNAME"));
			 arrParams.add((String) map.get("LIFYEA") +  " 00:00:00");
			 arrParams.add((String) map.get("USE_F"));
			 arrParams.add((String) map.get("DEPT_CODE"));
			 arrParams.add((String) map.get("GRADE"));
			 
			 cnt = objDB.executeCmd(con, szQuery, arrParams);
		     
			 if(cnt == 0) {
			     rsVO.HEADER.setCOUNT(String.valueOf(cnt));
			     rsVO.HEADER.setMSG("����� �����Ͱ� �����ϴ�.");
			     rsVO.HEADER.setMSG_CODE("9999");
			 } else {
			     rsVO.HEADER.setCOUNT(String.valueOf(cnt));
			     rsVO.HEADER.setMSG("���������� �Է�ó�� �Ǿ����ϴ�.");
			     rsVO.HEADER.setMSG_CODE("1000");
			 }
		}
		objDB.closeCon(con);
		
		return rsVO;
	}
	
public  responseJsonVO SelectUserResult(requestJsonVO reqVO, String szQuery){
		responseJsonVO rsVO = new responseJsonVO();
		cmnLog.Debug(szQuery);
		cmnDb objDB = new cmnDb();
		
		Connection con = objDB.getConnection();
		ArrayList arrParams = new ArrayList();
		
		for(int i = 0; i < reqVO.DATA.size();i++)  {
			 HashMap map = (HashMap)reqVO.DATA.get(i);
	
			 arrParams.add((String) map.get("SWORD"));
	
			 rsVO.DATA = objDB.executeSelect(con, szQuery, arrParams, new usrVO());
		     
			 if(rsVO.DATA.size() == 0) {
			     rsVO.HEADER.setCOUNT(String.valueOf(rsVO.DATA.size()));
			     rsVO.HEADER.setMSG("��ȸ�� �����Ͱ� �����ϴ�.");
			     rsVO.HEADER.setMSG_CODE("9999");
			 } else {
			     rsVO.HEADER.setCOUNT(String.valueOf(rsVO.DATA.size()));
			     rsVO.HEADER.setMSG("���������� ��ȸ �Ǿ����ϴ�.");
			     rsVO.HEADER.setMSG_CODE("1000");
			 }
		}
		objDB.closeCon(con);
		
		return rsVO;

	}
}
