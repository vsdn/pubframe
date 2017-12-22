jQuery(document).ready(function(){
	USR0101M01.initPage();
	USR0101M01.defineEvent();
});

var prcsMode = 0;
var USR0101M01={  
		initPage:function(){	
			 $("#btnNew").show();
			 $("#btnCancel").hide();
			 $("#btnDelete").show();
			 $("#btnSave").show();
			 $("#btnNew").prop("disabled", false);
			 $("#btnDelete").prop("disabled", true);
			 $("#btnSave").prop("disabled", true);
			 prcsMode = 0;
			 $(".readonly").attr("readonly",true); 
			 $(".datepicker").datepicker({
				 	showOn: "both",
				 	buttonImage:"../../img/btn/iconcalendar.gif",
				 	buttonImageOnly : "true",
				 	dateFormat:"yy-mm-dd",
				 	dayNames : ['월요일','화요일','수요일','목요일','금요일','토요일','일요일'],
				 	dayNamesMin : ['월','화','수','목','금','토','일'],
				 	monthNamesShort:['1','2','3','4','5','6','7','8','9','10','11','12'],
				 	monthNames:['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
				 	changeMonth:"true",
				 	changeYear:"true"
			 });
			
		    },
		
		defineEvent:function(){
		   $("#srchUsr").click(function(e){
			   	USR0101M01.srchUsr();
			   	USR0101M01.initBasicModeControl();})
		   $("#btnNew").click(function(e){
			   cmnFrame.setFormDataClear("detForm");
			   $("#btnNew").hide();
			   $("#btnCancel").show();
			   $("#btnDelete").show();
			   $("#btnSave").show();
			   $("#btnCancel").prop("disabled", false);
			   $("#btnDelete").prop("disabled", true);
			   $("#btnSave").prop("disabled", false);
			   prcsMode = 1;
		   })
		   $("#btnCancel").click(function(e){
			   USR0101M01.initBasicModeControl();
		   })
		   $("#btnDelete").click(function(e){
			    USR0101M01.deleteExistUsr();
			    USR0101M01.srchUsr();
			    USR0101M01.initBasicModeControl();
		   })
		   $("#btnSave").click(function(e){
			   
		    	if(prcsMode == 1)
		    		{
		    			USR0101M01.insertNewUsr();
		    			USR0101M01.initBasicModeControl();		    			
		    	}else
		    		{
		    			USR0101M01.updateExistUsr();
		    			USR0101M01.srchUsr();
		    			USR0101M01.initBasicModeControl();	
		    		}
		    	
		   })
		},
		initGrid:function(){
			$("#divUsrList").jsGrid({
		        height: "100%",
		        width: "100%",
		        filtering: true,
		        editing: false,
		        inserting: false,
		        sorting: true,
		        paging: false,
		        autoload: true,
		        pageSize: 15,
		        pageButtonCount: 10,
		        deleteConfirm: "삭제?",
		        controller: dataObj,
		        fields: [
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
		                ]
		        , rowClick: function(e) {
		    		//window.hItem = e.item;
					   cmnFrame.setFormDataClear("detForm");
		        	USR0101M01.setFormData(e.item);
		        	$("#btnNew").hide();
		        	$("#btnCancel").show();
					$("#btnDelete").show();
					$("#btnSave").show();
					$("#btnCancel").prop("disabled", false);
					$("#btnDelete").prop("disabled", false);
					$("#btnSave").prop("disabled", false);
					 prcsMode = 0;
		    	}
		    });
		}

		, getData:function(items) {
			var dataObj = {
			        loadData: function(filter) {
			        	return $.grep(this.data, function(Item) {
			                return (!filter.USID || Item.USNO.indexOf(filter.USID) > -1)
		                    && (!filter.USNO || Item.USNO.indexOf(filter.USNO) > -1)
		                    && (!filter.USNAME || Item.USNAME.indexOf(filter.USNAME) > -1)
		                    && (!filter.LIFYEA || Item.LIFYEA.indexOf(filter.LIFYEA) > -1)
		                    && (!filter.DEPT_CODE || Item.DEPT_CODE.indexOf(filter.DEPT_CODE) > -1)
		                    && (!filter.GRADE || Item.GRADE.indexOf(filter.GRADE) > -1)
		                    && (!filter.LOGIN_F || Item.LOGIN_F.indexOf(filter.LOGIN_F) > -1)
		                    && (!filter.LAST_LOGIN_DATE || Item.LAST_LOGIN_DATE.indexOf(filter.LAST_LOGIN_DATE) > -1)
		                    && (!filter.SYS_FRST_USNO || Item.SYS_FRST_USNO.indexOf(filter.SYS_FRST_USNO) > -1)
		                    && (!filter.SYS_FRST_DATE || Item.SYS_FRST_DATE.indexOf(filter.SYS_FRST_DATE) > -1)
		                    && (!filter.SYS_UPDT_USNO || Item.SYS_UPDT_USNO.indexOf(filter.SYS_UPDT_USNO) > -1)
		                    && (!filter.SYS_UPDT_DATE || Item.SYS_UPDT_DATE.indexOf(filter.SYS_UPDT_DATE) > -1)
		                    && (!filter.USE_F || Item.USE_F.indexOf(filter.USE_F) > -1)
			            });
			        }

			    };
			
			
			dataObj.data = items;
		    window.dataObj = dataObj;
		    this.initGrid();
		}
		,
		srchUsr:function(){
			var objReqJson = new reqJson();
			if(!USR0101M01.srchUsrValidationChk()){alert("검색어를 입력하세요."); return;}
		
			objReqJson.createBaseGroup();
			objReqJson.setSERVICE("USR0101M01");
			objReqJson.setMETHOD("SelectUser");
			objReqJson.setMENU_ID("USR0101M01");
			objReqJson.setASYNC("TRUE");
			objReqJson.setPROGRESS_BAR("TRUE");
			 $("#Srch_F").val() == "ID" ? objReqJson.setTYPE("SELECT1"):objReqJson.setTYPE("SELECT2");
			objReqJson.setURL(document.location.href);
			objReqJson.setCLIENT_TYPE(cmnFrame.getClientType());
			objReqJson.setCLIENT_META(clientInformation.userAgent);
			objReqJson.setCONTROL_TYPE("NONE");
			objReqJson.setCONTROL_ID("");
			objReqJson.setPAGES_CNT("1");
			objReqJson.setROW_CNT("100");
			objReqJson.setMAX_LIMIT("3000");

			objReqJson.setData("SWORD",$("#srchUserInfo").val(),0);
			objReqJson.setData("STYPE",$("#Srch_F").val() == "ID"? "ID":"USNAME",0);
			cmnFrame.callService(objReqJson, function(data) {

			USR0101M01.getData(data.DATA);
			}, function(retTxt) {

				alert("실패");
			});
		},

		initBasicModeControl:function(){
			   cmnFrame.setFormDataClear("detForm");
			 $("#btnNew").show();
			 $("#btnCancel").hide();
			 $("#btnDelete").show();
			 $("#btnSave").show();
			 $("#btnNew").prop("disabled", false);
			 $("#btnDelete").prop("disabled", true);
			 $("#btnSave").prop("disabled", true);
			 prcsMode = 0;
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
    		objReqJson.setASYNC("TRUE");
    		objReqJson.setPROGRESS_BAR("TRUE");
    		objReqJson.setTYPE("INSERT");
    		objReqJson.setURL(document.location.href);
    		objReqJson.setCLIENT_TYPE(cmnFrame.getClientType());
    		objReqJson.setCLIENT_META(clientInformation.userAgent);
    		objReqJson.setCONTROL_TYPE("NONE");
    		objReqJson.setCONTROL_ID("");
    		objReqJson.setPAGES_CNT("1");
    		objReqJson.setROW_CNT("100");
    		objReqJson.setMAX_LIMIT("3000");
    		
    		
    		objReqJson = cmnFrame.setJsonData(objReqJson,'detForm',0);

    		/*objReqJson.setData("USID", $("#USID").val(), 0);
    		objReqJson.setData("PASSWORD", "mew12345", 0);
    		objReqJson.setData("USNAME", $("#USNAME").val(), 0);
    		objReqJson.setData("LIFYEA", $("#LIFYEA").val(), 0);
    		objReqJson.setData("USE_F","사용" == $("#USE_F").val()? "1":"0", 0);
    		objReqJson.setData("DEPT_CODE", $("#DEPT_CODE").val(), 0);
    		objReqJson.setData("GRADE", $("#GRADE").val(), 0);
    		objReqJson.setData("RM", $("#RM").val(), 0);
*/
    		cmnFrame.callService(objReqJson, function(data) {
    			alert(data.HEADER["MSG"]);

    		}, function(retTxt) {
    			alert(retTxt);
    		});	
		},
    	updateExistUsr:function(){
    		var objReqJson = new reqJson();
    		
    		objReqJson.createBaseGroup();
    		objReqJson.setSERVICE("USR0101M01");
    		objReqJson.setMETHOD("UpdateUser");
    		objReqJson.setMENU_ID("USR0101M01");
    		objReqJson.setASYNC("TRUE");
    		objReqJson.setPROGRESS_BAR("TRUE");
    		objReqJson.setTYPE("UPDATE");
    		objReqJson.setURL(document.location.href);
    		objReqJson.setCLIENT_TYPE(cmnFrame.getClientType());
    		objReqJson.setCLIENT_META(clientInformation.userAgent);
    		objReqJson.setCONTROL_TYPE("NONE");
    		objReqJson.setCONTROL_ID("");
    		objReqJson.setPAGES_CNT("1");
    		objReqJson.setROW_CNT("100");
    		objReqJson.setMAX_LIMIT("3000");
    		
    		objReqJson = cmnFrame.setJsonData(objReqJson,'detForm',0);
/*
    		objReqJson.setData("USNAME", $("#USNAME").val(), 0);
    		objReqJson.setData("USID", $("#USID").val(), 0);
    		objReqJson.setData("USNO", $("#USNO").val(), 0);
    		objReqJson.setData("LIFYEA", $("#LIFYEA").val(), 0);
    		objReqJson.setData("USE_F","사용" == $("#USE_F").val()? "1":"0", 0);
    		objReqJson.setData("DEPT_CODE", $("#DEPT_CODE").val(), 0);
    		objReqJson.setData("GRADE", $("#GRADE").val(), 0);
    		objReqJson.setData("RM", $("#RM").val(), 0);
  */  		
    		cmnFrame.callService(objReqJson, function(data) {
    			alert(data.HEADER["MSG"]);

    		}, function(retTxt) {
    			alert(retTxt);
    		});			
		},
		deleteExistUsr:function(){
			var objReqJson = new reqJson();
    		
    		objReqJson.createBaseGroup();
    		objReqJson.setSERVICE("USR0101M01");
    		objReqJson.setMETHOD("DeleteUser");
    		objReqJson.setMENU_ID("USR0101M01");
    		objReqJson.setASYNC("TRUE");
    		objReqJson.setPROGRESS_BAR("TRUE");
    		objReqJson.setTYPE("DELETE");
    		objReqJson.setURL(document.location.href);
    		objReqJson.setCLIENT_TYPE(cmnFrame.getClientType());
    		objReqJson.setCLIENT_META(clientInformation.userAgent);
    		objReqJson.setCONTROL_TYPE("NONE");
    		objReqJson.setCONTROL_ID("");
    		objReqJson.setPAGES_CNT("1");
    		objReqJson.setROW_CNT("100");
    		objReqJson.setMAX_LIMIT("3000");
    		
    		objReqJson = cmnFrame.setJsonData(objReqJson,'detForm',0);
    		/*
    		objReqJson.setData("USNO", $("#USNO").val(), 0);
    	*/
    		cmnFrame.callService(objReqJson, function(data) {
    			alert(data.HEADER["MSG"]);

    		}, function(retTxt) {
    			alert(retTxt);
    		});		
		}
};
