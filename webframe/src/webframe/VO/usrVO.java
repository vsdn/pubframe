package webframe.VO;

public class usrVO {
	
	private String USID;
	private int USNO;
	private String PASSWORD;
	private int LOGIN_F;
	private int FAILR_CNT;
	private String LAST_LOGIN_DATE;
	private String USNAME;
	private String LIFYEA;
	private int USE_F;
	private int DEPT_CODE;
	private int GRADE;
	private int SYS_FRST_USNO;
	private String SYS_FRST_DATE;
	private int SYS_UPDT_USNO;
	private String SYS_UPDT_DATE;
	
	public usrVO() {
		USID = "";
		USNO = 0;
		PASSWORD = "";
		LOGIN_F = 0;
		FAILR_CNT = 0;
		LAST_LOGIN_DATE = "";
		USNAME = "";
		LIFYEA = "";
		USE_F = 0;
		DEPT_CODE = 0;
		GRADE = 0;
		SYS_FRST_USNO = 0;
		SYS_FRST_DATE = "";
		SYS_UPDT_USNO = 0;
		SYS_UPDT_DATE = "";
	}
	
	public String getUSID() {
		return USID;
	}
	public void setUSID(String uSID) {
		USID = uSID;
	}
	public int getUSNO() {
		return USNO;
	}
	public void setUSNO(int uSNO) {
		USNO = uSNO;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public int getLOGIN_F() {
		return LOGIN_F;
	}
	public void setLOGIN_F(int lOGIN_F) {
		LOGIN_F = lOGIN_F;
	}
	public int getFAILR_CNT() {
		return FAILR_CNT;
	}
	public void setFAILR_CNT(int fAILR_CNT) {
		FAILR_CNT = fAILR_CNT;
	}
	public String getLAST_LOGIN_DATE() {
		return LAST_LOGIN_DATE;
	}
	public void setLAST_LOGIN_DATE(String lAST_LOGIN_DATE) {
		LAST_LOGIN_DATE = lAST_LOGIN_DATE;
	}
	public String getUSNAME() {
		return USNAME;
	}
	public void setUSNAME(String uSNAME) {
		USNAME = uSNAME;
	}
	public String getLIFYEA() {
		return LIFYEA;
	}
	public void setLIFYEA(String lIFYEA) {
		LIFYEA = lIFYEA;
	}
	public int getUSE_F() {
		return USE_F;
	}
	public void setUSE_F(int uSE_F) {
		USE_F = uSE_F;
	}
	public int getDEPT_CODE() {
		return DEPT_CODE;
	}
	public void setDEPT_CODE(int dEPT_CODE) {
		DEPT_CODE = dEPT_CODE;
	}
	public int getGRADE() {
		return GRADE;
	}
	public void setGRADE(int gRADE) {
		GRADE = gRADE;
	}
	public int getSYS_FRST_USNO() {
		return SYS_FRST_USNO;
	}
	public void setSYS_FRST_USNO(int sYS_FRST_USNO) {
		SYS_FRST_USNO = sYS_FRST_USNO;
	}
	public String getSYS_FRST_DATE() {
		return SYS_FRST_DATE;
	}
	public void setSYS_FRST_DATE(String sYS_FRST_DATE) {
		SYS_FRST_DATE = sYS_FRST_DATE;
	}
	public int getSYS_UPDT_USNO() {
		return SYS_UPDT_USNO;
	}
	public void setSYS_UPDT_USNO(int sYS_UPDT_USNO) {
		SYS_UPDT_USNO = sYS_UPDT_USNO;
	}
	public String getSYS_UPDT_DATE() {
		return SYS_UPDT_DATE;
	}
	public void setSYS_UPDT_DATE(String sYS_UPDT_DATE) {
		SYS_UPDT_DATE = sYS_UPDT_DATE;
	}

	
}
