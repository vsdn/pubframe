package webframe.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import webframe.VO.responseJsonVO;

public class cmnDb {
	public Connection getConnection() {
		Context context;
		Connection con = null;
		try {
			context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/SqlDB");
			con = dataSource.getConnection();
			
		} catch (NamingException | SQLException e) {
			cmnLog.Error(e);
		}
		
		return con;
	}
	public Connection getConnection(String contextName) {
		Context context;
		Connection con = null;
		try {
			context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/" + contextName);
			con = dataSource.getConnection();
			
		} catch (NamingException | SQLException e) {
			cmnLog.Error(e);
		}
		
		return con;
	}
	
	public void closeCon(Connection con) {
		if(con != null) {
			try {
				if(con.isClosed() == false) {
					con.close();
				}
			} catch (SQLException e) {
				cmnLog.Error(e);
			}
		}
	}
	
	public int executeCmd(Connection con, String sql, ArrayList<Object> arrParams ) {
		PreparedStatement stmt = null;
		int affCnt = 0;
		try {
			stmt = con.prepareStatement(sql);
			stmt = setParams(stmt, arrParams);
			affCnt = stmt.executeUpdate();
		} catch (SQLException e) {
			cmnLog.Error(e);
		} finally {
			try {
				if (stmt.isClosed() == false) {
					stmt.close();
				}
			} catch (Exception e) {
				cmnLog.Error(e);
			}
		}

		return affCnt;
	}
	public List<Object> executeSelect(Connection con, String sql, ArrayList<Object> arrParams, Object objVO ) {
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		ArrayList<Object> arrRet = new ArrayList<Object>();
	
		try {
			stmt = con.prepareStatement(sql);
			stmt = setParams(stmt, arrParams);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Object objTgt = cmnUtil.getInstance(objVO.getClass().getName());
				setVO(objTgt, rs);
				arrRet.add(objTgt);
			}
			
		} catch (SQLException e) {
			cmnLog.Error(e);
		} finally {
			try {
				if (stmt.isClosed() == false) {
					stmt.close();
				}
			} catch (Exception e) {
				cmnLog.Error(e);
			}
		}

		return arrRet;
	}
	
	public responseJsonVO executeSelect(Connection con, String sql, ArrayList<Object> arrParams, Object objVO, responseJsonVO resVO ) {
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		ArrayList<Object> arrRet = new ArrayList<Object>();
		StringBuffer sb = new StringBuffer();
	
		int i = 0;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt = setParams(stmt, arrParams);
			rs = stmt.executeQuery();
			
			//MetaData
			ResultSetMetaData rsMeta = rs.getMetaData();
			for(i = 0; i < rsMeta.getColumnCount();i++) {
				if(i > 0) {
					sb.append("|");
				}
				sb.append(rsMeta.getColumnLabel(i + 1));
			}
			
			//Data
			while(rs.next()) {
				Object objTgt = cmnUtil.getInstance(objVO.getClass().getName());
				setVO(objTgt, rs);
				arrRet.add(objTgt);
			}
			
		} catch (SQLException e) {
			cmnLog.Error(e);
		} finally {
			try {
				if (stmt.isClosed() == false) {
					stmt.close();
				}
			} catch (Exception e) {
				cmnLog.Error(e);
			}
		}
		
		resVO.HEADER.setCOUNT(String.valueOf(arrRet.size()));
		resVO.HEADER.setCOL_NAMES(sb.toString());
		resVO.DATA = arrRet;
		return resVO;
	}
	private void setVO(Object objVO, ResultSet rs) {
		int i = 0;
		
		try {
			if( rs.isClosed() == false) {
				ResultSetMetaData rsMeta = rs.getMetaData();
				
				for(i = 0; i < rsMeta.getColumnCount(); i++) {
					String colName = rsMeta.getColumnLabel(i + 1);
					cmnUtil.setVar(objVO, colName, rs.getString(i + 1));
				}
			}
		}
		catch(Exception e) {
			cmnLog.Error(e);
		}
	}
	private PreparedStatement setParams(PreparedStatement stmt, ArrayList<Object> arrParams) {
		for (int i = 0; i < arrParams.size(); i++) {
			Object param = arrParams.get(i);
			String clsName = param.getClass().getName().toUpperCase();
			try {
				if (clsName.indexOf("STRING") > -1) {
					stmt.setString(i + 1, (String) param);

				} else if (clsName.indexOf("INT") > -1) {
					stmt.setString(i + 1, (String) param);

				} else if (clsName.indexOf("LONG") > -1) {
					stmt.setLong(i + 1, (Long) param);

				} else if (clsName.indexOf("FLOAT") > -1) {
					stmt.setFloat(i + 1, (Float) param);

				} else if (clsName.indexOf("DATE") > -1) {
					stmt.setDate(i + 1, (java.sql.Date) param);

				} else if (clsName.indexOf("DOUBLE") > -1) {
					stmt.setDouble(i + 1, (Double) param);

				} else if (clsName.indexOf("OBJECT") > -1) {
					stmt.setObject(i + 1, param);

				} else {
					cmnLog.Info("cmnDb.executeCmd : SET PARAM ERR : UNKNOWN : " + clsName);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return stmt;
	}

}
