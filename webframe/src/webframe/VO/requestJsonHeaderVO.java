package webframe.VO;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class requestJsonHeaderVO {
	private String SERVICE;
	private String METHOD;
	private String MENU_ID;
	private String ASYNC;
	private String PROGRESS_BAR;
	private String TYPE;
	private String URL;
	private String CLIENT_TYPE;
	private String CLIENT_META;
	private String CONTROL_TYPE;
	private String CONTROL_ID;
	private String PAGES_CNT;
	private String ROW_CNT;
	private String MAX_LIMIT;

	
	public requestJsonHeaderVO() {
		SERVICE = "";
		METHOD = "";
		MENU_ID = "";
		ASYNC = "";
		PROGRESS_BAR = "";
		TYPE = "";
		URL = "";
		CLIENT_TYPE = "";
		CLIENT_META = "";
		CONTROL_TYPE = "";
		CONTROL_ID = "";
		PAGES_CNT = "";
		ROW_CNT = "";
		MAX_LIMIT = "";
	
	}
	
	@JsonProperty("SERVICE")
	public String getSERVICE() {
		return SERVICE;
	}
	public void setSERVICE(String sERVICE) {
		SERVICE = sERVICE;
	}
	@JsonProperty("METHOD")
	public String getMETHOD() {
		return METHOD;
	}
	public void setMETHOD(String mETHOD) {
		METHOD = mETHOD;
	}
	public String getMENU_ID() {
		return MENU_ID;
	}
	public void setMENU_ID(String mENU_ID) {
		MENU_ID = mENU_ID;
	}
	public String getASYNC() {
		return ASYNC;
	}
	public void setASYNC(String aSYNC) {
		ASYNC = aSYNC;
	}
	public String getPROGRESS_BAR() {
		return PROGRESS_BAR;
	}
	public void setPROGRESS_BAR(String pROGRESS_BAR) {
		PROGRESS_BAR = pROGRESS_BAR;
	}
	public String getTYPE() {
		return TYPE;
	}
	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getCLIENT_TYPE() {
		return CLIENT_TYPE;
	}
	public void setCLIENT_TYPE(String cLIENT_TYPE) {
		CLIENT_TYPE = cLIENT_TYPE;
	}
	public String getCLIENT_META() {
		return CLIENT_META;
	}
	public void setCLIENT_META(String cLIENT_META) {
		CLIENT_META = cLIENT_META;
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
	public String getPAGES_CNT() {
		return PAGES_CNT;
	}
	public void setPAGES_CNT(String pAGES_CNT) {
		PAGES_CNT = pAGES_CNT;
	}
	public String getROW_CNT() {
		return ROW_CNT;
	}
	public void setROW_CNT(String rOW_CNT) {
		ROW_CNT = rOW_CNT;
	}
	public String getMAX_LIMIT() {
		return MAX_LIMIT;
	}
	public void setMAX_LIMIT(String mAX_LIMIT) {
		MAX_LIMIT = mAX_LIMIT;
	}
	
}
