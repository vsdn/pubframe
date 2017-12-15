package webframe.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import webframe.VO.requestJsonVO;
import webframe.VO.responseJsonVO;

public class cmnDbCon {
	public  responseJsonVO getDbcpResult(requestJsonVO reqVO, String szQuery){
		
		responseJsonVO rsVO = new responseJsonVO();
		cmnLog.Debug(szQuery);
		Context context2;
		try {
			context2 = new InitialContext();
			DataSource dataSource = (DataSource) context2.lookup("java:comp/env/jdbc/SqlDB");
			Connection con = dataSource.getConnection();
			int cnt = 0;
			PreparedStatement stmt = con.prepareStatement(szQuery);
			for(int i = 0; i < reqVO.DATA.size();i++)  {
				 HashMap map = (HashMap)reqVO.DATA.get(i);
				 
					stmt.setString(1,  (String) map.get("USID"));
					stmt.setString(2,  (String) map.get("PASSWORD"));
					stmt.setString(3,  (String) map.get("USNAME"));
					//SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
					//Date to = (Date) transFormat.parse((String) map.get("LIFYEA"));

					stmt.setString(4,  (String) map.get("LIFYEA") +  " 00:00:00");
					stmt.setString(5,  (String) map.get("USE_F"));
					//stmt.setDate(5, (java.sql.Date) to);
					stmt.setString(6,  (String) map.get("DEPT_CODE"));
					stmt.setString(7,  (String) map.get("GRADE"));

					
			     cnt = stmt.executeUpdate();
			     
			     rsVO.HEADER.setCOUNT(String.valueOf(cnt));
			     rsVO.HEADER.setMSG("정상적으로 입력처리 되었습니다.");
			     rsVO.HEADER.setMSG_CODE("10000");
			 }
			stmt.close();
			con.close();
			
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			cmnLog.Error(e);
			 rsVO.HEADER.setCOUNT("0");
		     rsVO.HEADER.setMSG("사용자 입력이 실패하였습니다.");
		     rsVO.HEADER.setMSG_CODE("9999");
		}


		
		return rsVO;
	}
}
