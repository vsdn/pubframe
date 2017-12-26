package webframe.VO;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class responseJsonHeaderVO {
	private String COUNT;
	private String ERROR_FLAG;
	private String MSG_CODE;
	private String MSG;
	private String LAST_PAGE;
	private String PAGES_CNT;
	private String TOT_COUNT;
	private String REQ_TIME;
	private String RES_TIME;
	private String MAX_FLAG;
	private String COL_NAMES;

	private String CONTROL_TYPE;
	private String CONTROL_ID;
	
	public responseJsonHeaderVO() {
		COUNT = "";
		ERROR_FLAG = "";
		MSG_CODE = "";
		MSG = "";
		LAST_PAGE = "";
		PAGES_CNT = "";
		TOT_COUNT = "";
		REQ_TIME = "";
		RES_TIME = "";
		MAX_FLAG = "";
		COL_NAMES = "";
		CONTROL_TYPE = "";
		CONTROL_ID = "";
		
	}

	public String getCONTROL_TYPE() {
		return CONTROL_TYPE;
	}


	public void setCONTROL_TYPE(String cONTROL_TYPE) {
		CONTROL_TYPE = cONTROL_TYPE;
	}


	public String getCONTROL_ID() {
		return CONTROL_ID;
	}


	public void setCONTROL_ID(String cONTROL_ID) {
		CONTROL_ID = cONTROL_ID;
	}
	public String getCOL_NAMES() {
		return COL_NAMES;
	}


	public void setCOL_NAMES(String cOL_NAMES) {
		COL_NAMES = cOL_NAMES;
	}
	public String getCOUNT() {
		return COUNT;
	}
	public void setCOUNT(String cOUNT) {
		COUNT = cOUNT;
	}
	public String getERROR_FLAG() {
		return ERROR_FLAG;
	}
	public void setERROR_FLAG(String eRROR_FLAG) {
		ERROR_FLAG = eRROR_FLAG;
	}
	public String getMSG_CODE() {
		return MSG_CODE;
	}
	public void setMSG_CODE(String mSG_CODE) {
		MSG_CODE = mSG_CODE;
	}
	public String getMSG() {
		return MSG;
	}
	public void setMSG(String mSG) {
		MSG = mSG;
	}
	public String getLAST_PAGE() {
		return LAST_PAGE;
	}
	public void setLAST_PAGE(String lAST_PAGE) {
		LAST_PAGE = lAST_PAGE;
	}
	public String getPAGES_CNT() {
		return PAGES_CNT;
	}
	public void setPAGES_CNT(String pAGES_CNT) {
		PAGES_CNT = pAGES_CNT;
	}
	public String getTOT_COUNT() {
		return TOT_COUNT;
	}
	public void setTOT_COUNT(String tOT_COUNT) {
		TOT_COUNT = tOT_COUNT;
	}
	public String getREQ_TIME() {
		return REQ_TIME;
	}
	public void setREQ_TIME(String rEQ_TIME) {
		REQ_TIME = rEQ_TIME;
	}
	public String getRES_TIME() {
		return RES_TIME;
	}
	public void setRES_TIME(String rES_TIME) {
		RES_TIME = rES_TIME;
	}
	public String getMAX_FLAG() {
		return MAX_FLAG;
	}
	public void setMAX_FLAG(String mAX_FLAG) {
		MAX_FLAG = mAX_FLAG;
	}

}
