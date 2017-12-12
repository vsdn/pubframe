
package webframe.VO;

import java.util.ArrayList;
import java.util.List;

public class responseJsonVO {
<<<<<<< HEAD
	public responseJsonHeaderVO HEADER;
	public List<Object> DATA;

	public responseJsonVO() {
		HEADER = new responseJsonHeaderVO();
		DATA = new ArrayList<Object>();
	}
=======
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
	private List<Object> DATA;

	public responseJsonVO() {
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
		
		DATA = new ArrayList<Object>();
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
	
>>>>>>> refs/remotes/origin/master
}
