function reqJson(obj)
{

	this.jsonData = null;

	if (typeof(obj) !== "undefined"){
		if(typeof(blnType) !== "undefined"){
			this.jsonData = obj;
		}else
			this.jsonData = obj.jsonData;
	};
	
	this.createBaseGroup = function(){
		this.jsonData = {};
		this.jsonData.HEADER = {};
		this.jsonData.DATA = [{}];
		this.setURL(document.location.href);
		this.setASYNC("TRUE");
		this.setPROGRESS_BAR("TRUE");
		this.setCLIENT_TYPE(cmnFrame.getClientType());
		this.setCLIENT_META(clientInformation.userAgent);
		this.setPAGES_CNT("1");
		this.setROW_CNT("100");
		this.setMAX_LIMIT("3000");
		this.setCONTROL_TYPE("NONE");
	},
	
	this.setHeader = function(header){
		if(this.jsonData == null )
			this.jsonData = {};
		this.jsonData.HEADER = {};
		this.jsonData.HEADER = header;
	};
	
	this.setHeaderKey = function(key, value)
	{
		if(this.jsonData == null )
			this.jsonData = {};
		if(this.jsonData.HEADER == null)
			this.jsonData.HEADER = {};
		
		this.jsonData.HEADER[key] = value;
	};
	
	this.getHeaderKey = function(key)
	{
		return this.jsonData.HEADER[key];
	};

	

	this.getSERVICE = function(value) {
		this.getHeaderKey("SERVICE");
	};
	this.getMETHOD = function(value) {
		this.getHeaderKey("METHOD");
	};
	this.getMENU_ID = function(value) {
		this.getHeaderKey("MENU_ID");
	};
	this.getASYNC = function(value) {
		this.getHeaderKey("ASYNC");
	};
	this.getPROGRESS_BAR = function(value) {
		this.getHeaderKey("PROGRESS_BAR");
	};
	this.getTYPE = function(value) {
		this.getHeaderKey("TYPE");
	};
	this.getURL = function(value) {
		this.getHeaderKey("URL");
	};
	this.getCLIENT_TYPE = function(value) {
		this.getHeaderKey("CLIENT_TYPE");
	};
	this.getCLIENT_META = function(value) {
		this.getHeaderKey("CLIENT_META");
	};
	this.getCONTROL_TYPE = function(value) {
		this.getHeaderKey("CONTROL_TYPE");
	};
	this.getCONTROL_ID = function(value) {
		this.getHeaderKey("CONTROL_ID");
	};
	this.getPAGES_CNT = function(value) {
		this.getHeaderKey("PAGES_CNT");
	};
	this.getROW_CNT = function(value) {
		this.getHeaderKey("ROW_CNT");
	};
	this.getMAX_LIMIT = function(value) {
		this.getHeaderKey("MAX_LIMIT");
	};

	this.setSERVICE = function(value) {
		this.setHeaderKey("SERVICE", value);
	};
	this.setMETHOD = function(value) {
		this.setHeaderKey("METHOD", value);
	};
	this.setMENU_ID = function(value) {
		this.setHeaderKey("MENU_ID", value);
	};
	this.setASYNC = function(value) {
		this.setHeaderKey("ASYNC", value);
	};
	this.setPROGRESS_BAR = function(value) {
		this.setHeaderKey("PROGRESS_BAR", value);
	};
	this.setTYPE = function(value) {
		this.setHeaderKey("TYPE", value);
	};
	this.setURL = function(value) {
		this.setHeaderKey("URL", value);
	};
	this.setCLIENT_TYPE = function(value) {
		this.setHeaderKey("CLIENT_TYPE", value);
	};
	this.setCLIENT_META = function(value) {
		this.setHeaderKey("CLIENT_META", value);
	};
	this.setCONTROL_TYPE = function(value) {
		this.setHeaderKey("CONTROL_TYPE", value);
	};
	this.setCONTROL_ID = function(value) {
		this.setHeaderKey("CONTROL_ID", value);
	};
	this.setPAGES_CNT = function(value) {
		this.setHeaderKey("PAGES_CNT", value);
	};
	this.setROW_CNT = function(value) {
		this.setHeaderKey("ROW_CNT", value);
	};
	this.setMAX_LIMIT = function(value) {
		this.setHeaderKey("MAX_LIMIT", value);
	};
	
	this.initData = function(index,group)
	{
		var strGrp = "DATA";
		if( typeof(group)!=="undefined" ){strGrp = group;}
		
		var strObj = 'this.jsonData[\"' + strGrp + '\"]';
		var strObj2 = 'this.jsonData[\"'+strGrp+ '\"] = [{}]';
		var strObj3 = 'this.jsonData[\"'+strGrp+ '\"][' + index + ']';
		var strObj4 = 'this.jsonData[\"'+strGrp+ '\"][' + index + '] = {}';
		
		if(this.jsonData == null ){this.jsonData = {};}
		if( typeof(eval(strObj))==="undefined" ){eval(strObj2);}
		if( typeof(eval(strObj3))==="undefined" ){eval(strObj4);}
	};

	this.setData = function(key, value, index)
	{
		if( index == undefined || index == null )
			index = 0;
		
		index = Number(index);
		this.initData(index);
		this.jsonData.DATA[index][key] = value;
	};

	this.getData = function(key, index)
	{
		if(index == undefined) index = 0;
		return this.jsonData.DATA[index][key];
	};
}