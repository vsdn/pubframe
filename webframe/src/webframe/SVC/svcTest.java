package webframe.SVC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

import webframe.VO.requestJsonVO;
import webframe.VO.responseJsonVO;
import webframe.common.cmnLog;

public class svcTest {
	public  responseJsonVO getDbcpResult(requestJsonVO rqVO) {
		
		responseJsonVO rsVO = new responseJsonVO();
		
		
		Context context2;
		try {
			context2 = new InitialContext();
			DataSource dataSource = (DataSource) context2.lookup("java:comp/env/jdbc/SqlDB");
			Connection con = dataSource.getConnection();
			
			PreparedStatement stmt = con.prepareStatement("SELECT GETDATE()");
			
			ResultSet rs = stmt.executeQuery();
			rs.next();
			cmnLog.Debug(rs.getString(1));
			stmt.close();
			con.close();
			
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			cmnLog.Error(e);
		}

		
		

		
		
		
		return rsVO;
	}
}

