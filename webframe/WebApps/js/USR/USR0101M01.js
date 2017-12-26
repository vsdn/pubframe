jQuery(document).ready(function(){
	USR0101M01.initPage();
	USR0101M01.defineEvent();
});

var prcsMode = 0;
var USR0101M01={  
		initPage:function(){	
			 USR0101M01.initForm("init");
			 $(".readonly").attr("readonly",true); 
			 cmnFrame.setDatePicker("datepicker");
		    },
		
		defineEvent:function(){
		   $("#srchUsr").click(function(e){
			   	USR0101M01.srchUsr();
		   })
		   $("#btnNew").click(function(e){
			   cmnFrame.setFormDataClear("detForm");
			   USR0101M01.initForm("new");
		   })
		   $("#btnCancel").click(function(e){
			   USR0101M01.initForm("cancel");
		   })
		   $("#btnDelete").click(function(e){
			    USR0101M01.deleteExistUsr();
			    USR0101M01.srchUsr();
			    USR0101M01.initForm("delete");
		   })
		   $("#btnSave").click(function(e){
			   
		    	if(prcsMode == 1)
		    		{
		    			USR0101M01.insertNewUsr();
		    			USR0101M01.initForm("save");    			
		    	}else
		    		{
		    			USR0101M01.updateExistUsr();
		    			USR0101M01.srchUsr();
		    			USR0101M01.initForm("save");	
		    		}
		    	
		   })
		},
		srchUsr:function(){
			var objReqJson = new reqJson();
			
			if(!USR0101M01.srchUsrValidationChk()){alert("검색어를 입력하세요."); return;}
		
			objReqJson.createBaseGroup();
			objReqJson.setSERVICE("USR0101M01");
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
	            { name: "LOGIN_F", type: "text",width: 60, align:"center", itemTemplate:function(value,item){
	            	if(value == "Y") {
	            		return "<span class=\"hIcon icon i-checkmark-circle blue-icon\"></span>"
	            	}
	            	else {
	            		return "<span class=\"hIcon icon i-circle blue-icon\"></span>"
	            	}
	            } },
	            { name: "LAST_LOGIN_DATE", type: "text", width: 110 },
	            { name: "SYS_FRST_USNO", type: "text", width: 110 },  
	            { name: "SYS_FRST_DATE", type: "text", width: 110 },
	            { name: "SYS_UPDT_USNO", type: "text", width: 110 },
	            { name: "SYS_UPDT_DATE", type: "text", width: 110 },		            
	            { name: "USE_F", type: "text",width: 60, align:"center" , itemTemplate:function(value,item){
	            	if(value == "Y") {
	            		return "<span class=\"hIcon icon i-checkmark-circle blue-icon\"></span>"
	            	}
	            	else {
	            		return "<span class=\"hIcon icon i-circle blue-icon\"></span>"
	            	}
	            } },
	            { name: "RM", type: "text", width: 150 }
	                ];
			var gridOptions = {rowClick:function(e) {
				USR0101M01.initForm("click");
				cmnFrame.setFormDataClear("detForm");
				USR0101M01.setFormData(e.item);
			}};
			cmnFrame.callService(objReqJson, gridFields, gridOptions, function(data) {alert(data.HEADER["MSG"]); USR0101M01.initForm("srch");}, function(text) {alert("실패");});	
		},
		initForm:function(mode) {	
			switch(mode){
			case "click" :
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

		setFormData:function(obj){
			
		$("#USID").val(obj.USID);
		$("#USNAME").val(obj.USNAME);
		$("#LAST_LOGIN_DATE").val(obj.LAST_LOGIN_DATE);
		$("#LIFYEA").val(obj.LIFYEA);
		$("#DEPT_CODE").val(obj.DEPT_CODE);
		$("#LAST_LOGIN_DATE").val(obj.LAST_LOGIN_DATE);
		$("#GRADE").val(obj.GRADE);
		$("#SYS_FRST_USNO").val(obj.SYS_FRST_USNO);
		$("#SYS_FRST_DATE").val(obj.SYS_FRST_DATE);
		$("#SYS_UPDT_USNO").val(obj.SYS_UPDT_USNO);
		$("#SYS_UPDT_DATE").val(obj.SYS_UPDT_DATE);
		$("#RM").val(obj.RM);
		$("#USNO").val(obj.USNO);
		"Y" == obj.USE_F  ? $("#USE_F").val("1").prop("selected", true) : $("#USE_F").val("0").prop("selected", true);
		"Y" == obj.LOGIN_F  ? $("#LOGIN_F").val("1").prop("selected", true) : $("#LOGIN_F").val("0").prop("selected", true);
		},
		
		srchUsrValidationChk:function(){
			var blnRetVal = true;
			
			if($("#srchUserInfo").val() == "")
				blnRetVal = false;
			
			return blnRetVal;
		},

    	insertNewUsr:function(){
    		var objReqJson = new reqJson();
    		
    		objReqJson.createBaseGroup();
			objReqJson.setSERVICE("USR0101M01");
			objReqJson.setMETHOD("InsertUser");
			objReqJson.setMENU_ID("USR0101M01");
			objReqJson.setCONTROL_TYPE("NONE");

    		objReqJson = cmnFrame.getJsonData(objReqJson,'detForm',0);
    		
			cmnFrame.callService(objReqJson, "", "", function(data) {alert(data.HEADER["MSG"]);}, function(text) {alert("실패");});	
		},
    	updateExistUsr:function(){
    		var objReqJson = new reqJson();
    		
    		objReqJson.createBaseGroup();
			objReqJson.setSERVICE("USR0101M01");
			objReqJson.setMETHOD("UpdateUser");
			objReqJson.setMENU_ID("USR0101M01");
			objReqJson.setCONTROL_TYPE("NONE");
    		
    		objReqJson = cmnFrame.getJsonData(objReqJson,'detForm',0);
		
    		cmnFrame.callService(objReqJson, "", "", function(data) {alert(data.HEADER["MSG"]);}, function(text) {alert("실패");});		
		},
		deleteExistUsr:function(){
    		var objReqJson = new reqJson();
    		
    		objReqJson.createBaseGroup();
			objReqJson.setSERVICE("USR0101M01");
			objReqJson.setMETHOD("DeleteUser");
			objReqJson.setMENU_ID("USR0101M01");
			objReqJson.setCONTROL_TYPE("NONE");
			
    		objReqJson = cmnFrame.getJsonData(objReqJson,'detForm',0);

    		cmnFrame.callService(objReqJson, "", "", function(data) {alert(data.HEADER["MSG"]);}, function(text) {alert("실패");});		
		}
};
