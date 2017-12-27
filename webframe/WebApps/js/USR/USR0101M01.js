jQuery(document).ready(function(){
	USR0101M01.initPage();
	USR0101M01.defineEvent();
});

var prcsMode = 0;
var USR0101M01={  
		srvID : "USR0101M01",
		initPage:function(){	
			 USR0101M01.initForm("init");
			 cmnFrame.setDefaultStyle();
	    },
		defineEvent:function(){
		   $("#srchUsr").on("click", function(e){
			   	USR0101M01.srchUsr();
		   })
		   $("#btnNew").on("click", function(e){
			   cmnFrame.setFormDataClear("detForm");
			   USR0101M01.initForm("new");
		   })
		   $("#btnCancel").on("click", function(e){
			   USR0101M01.initForm("cancel");
		   })
		   $("#btnDelete").on("click", function(e){
			    USR0101M01.deleteExistUsr();
			    USR0101M01.srchUsr();
			    USR0101M01.initForm("delete");
		   })
		   $("#btnSave").on("click", function(e){
			   
		    	if(prcsMode == 1)
		    		{
		    			USR0101M01.insertNewUsr();
		    			USR0101M01.initForm("");    			
		    	}else
		    		{
		    			USR0101M01.updateExistUsr();
		    			USR0101M01.srchUsr();
		    			USR0101M01.initForm("");	
		    		}
		    	
		   })
		},
		initForm:function(mode) {	
			switch(mode){
				case "edit" :
		        	$("#btnNew").hide();
		        	$("#btnCancel").show();
					$("#btnDelete").show();
					$("#btnSave").show();
					$("#btnCancel").prop("disabled", false);
					$("#btnDelete").prop("disabled", false);
					$("#btnSave").prop("disabled", false);
					prcsMode = 0; 
					break;
				case "new" :
					cmnFrame.setFormDataClear("detForm");
					$("#btnNew").hide();
					$("#btnCancel").show();
					$("#btnDelete").show();
					$("#btnSave").show();
					$("#btnCancel").prop("disabled", false);
					$("#btnDelete").prop("disabled", true);
					$("#btnSave").prop("disabled", false);
					prcsMode = 1;
					break;				
				default :
					cmnFrame.setFormDataClear("detForm");
					$("#btnNew").show();
					$("#btnCancel").hide();
					$("#btnDelete").show();
					$("#btnSave").show();
					$("#btnNew").prop("disabled", false);
					$("#btnDelete").prop("disabled", true);
					$("#btnSave").prop("disabled", true);
					prcsMode = 0;
					break;
			}
	
		}, 		
		srchUsr:function(){
			var objReqJson = new reqJson();
			
			if(!USR0101M01.srchUsrValidationChk()){alert("검색어를 입력하세요."); return;}
		
			objReqJson.createBaseGroup();
			objReqJson.setSERVICE(this.srvID);
			objReqJson.setMETHOD("SelectUser");
			objReqJson.setMENU_ID("USR0101M01");
			objReqJson.setCONTROL_TYPE("GRID");
			objReqJson.setCONTROL_ID("divUsrList");

			 $("#Srch_F").val() == "ID" ? objReqJson.setTYPE("SELECT1"):objReqJson.setTYPE("SELECT2");
			objReqJson.setData("SWORD",$("#srchUserInfo").val(),0);
			objReqJson.setData("STYPE",$("#Srch_F").val() == "ID"? "ID":"USNAME",0);
			
			var gridFields = new Array();
			gridFields = [
	        	{ name: "USID", type: "text", width: 80 },
	            { name: "USNO", type: "text", width: 80 },
	            { name: "USNAME", type: "text", width: 80 },
	            { name: "LIFYEA", type: "text", width: 100 },			            
	            { name: "DEPT_CODE", type: "text", width: 80 },
	            { name: "GRADE", type: "text", width: 50 },
	            { name: "LOGIN_F", type: "text",width: 60, align:"center", itemTemplate:gridUtil.tmpFlagStyle },
	            { name: "LAST_LOGIN_DATE", type: "text", width: 110 },
	            { name: "SYS_FRST_USNO", type: "text", width: 110 },  
	            { name: "SYS_FRST_DATE", type: "text", width: 110 },
	            { name: "SYS_UPDT_USNO", type: "text", width: 110 },
	            { name: "SYS_UPDT_DATE", type: "text", width: 110 },		            
	            { name: "USE_F", type: "text",width: 60, align:"center" , itemTemplate:gridUtil.tmpFlagStyle },
	            { name: "RM", type: "text", width: 150 }
	                ];
			var gridOptions = {rowClick:function(e) {
				USR0101M01.initForm("edit");
				cmnFrame.setFormDataClear("detForm");
				USR0101M01.setFormData(e.item);
			}};
			cmnFrame.callService(objReqJson, gridFields, gridOptions, function(data) {alert(data.HEADER["MSG"]); USR0101M01.initForm("srch");}, function(text) {alert("실패");});	
		},
		setFormData:function(obj){
			cmnFrame.setFormData("detForm", obj);
		},
		srchUsrValidationChk:function(){
			var blnRetVal = true;
			
			if($("#srchUserInfo").val() == "")
				blnRetVal = false;
			
			return blnRetVal;
		},
    	insertNewUsr:function(){
    		if(cmnFrame.validateForm('detForm') == false) {
    			return;
    		}
    		var objReqJson = new reqJson();
    		
    		objReqJson.createBaseGroup();
			objReqJson.setSERVICE(this.srvID);
			objReqJson.setMETHOD("InsertUser");
			objReqJson.setMENU_ID("USR0101M01");
			objReqJson.setCONTROL_TYPE("NONE");

    		objReqJson = cmnFrame.getJsonData(objReqJson,'detForm',0);
    		
			cmnFrame.callService(objReqJson, "", "", function(data) {alert(data.HEADER["MSG"]);}, function(text) {alert("실패");});	
		},
    	updateExistUsr:function(){
    		if(cmnFrame.validateForm('detForm') == false) {
    			return;
    		}
    		
    		var objReqJson = new reqJson();
    		
    		objReqJson.createBaseGroup();
			objReqJson.setSERVICE(this.srvID);
			objReqJson.setMETHOD("UpdateUser");
			objReqJson.setMENU_ID("USR0101M01");
			objReqJson.setCONTROL_TYPE("NONE");
    		
    		objReqJson = cmnFrame.getJsonData(objReqJson,'detForm',0);
		
    		cmnFrame.callService(objReqJson, "", "", function(data) {alert(data.HEADER["MSG"]);}, function(text) {alert("실패");});		
		},
		deleteExistUsr:function(){
    		var objReqJson = new reqJson();
    		
    		objReqJson.createBaseGroup();
			objReqJson.setSERVICE(this.srvID);
			objReqJson.setMETHOD("DeleteUser");
			objReqJson.setMENU_ID("USR0101M01");
			objReqJson.setCONTROL_TYPE("NONE");
			
    		objReqJson = cmnFrame.getJsonData(objReqJson,'detForm',0);

    		cmnFrame.callService(objReqJson, "", "", function(data) {alert(data.HEADER["MSG"]);}, function(text) {alert("실패");});		
		}
};
