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
		this.setHeaderKey("SERVICE", value);
	};
	this.getMETHOD = function(value) {
		this.setHeaderKey("METHOD", value);
	};
	this.getMENU_ID = function(value) {
		this.setHeaderKey("MENU_ID", value);
	};
	this.getASYNC = function(value) {
		this.setHeaderKey("ASYNC", value);
	};
	this.getPROGRESS_BAR = function(value) {
		this.setHeaderKey("PROGRESS_BAR", value);
	};
	this.getTYPE = function(value) {
		this.setHeaderKey("TYPE", value);
	};
	this.getURL = function(value) {
		this.setHeaderKey("URL", value);
	};
	this.getCLIENT_TYPE = function(value) {
		this.setHeaderKey("CLIENT_TYPE", value);
	};
	this.getCLIENT_META = function(value) {
		this.setHeaderKey("CLIENT_META", value);
	};
	this.getCONTROL_TYPE = function(value) {
		this.setHeaderKey("CONTROL_TYPE", value);
	};
	this.getCONTROL_ID = function(value) {
		this.setHeaderKey("CONTROL_ID", value);
	};
	this.getPAGES_CNT = function(value) {
		this.setHeaderKey("PAGES_CNT", value);
	};
	this.getROW_CNT = function(value) {
		this.setHeaderKey("ROW_CNT", value);
	};
	this.getMAX_LIMIT = function(value) {
		this.setHeaderKey("MAX_LIMIT", value);
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