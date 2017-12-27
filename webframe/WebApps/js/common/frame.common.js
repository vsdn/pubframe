var cmnFrame = {
		getClientType : function() {
			return clientInformation.userAgent;
		},
		callService : function(obj, controlField, controlOptions, successFunc, errorFunc) {
			$.ajax({      
		        type:"POST",  
		        dataType : 'json',
		        url:"/webframe/api/svc.jsp",      
		        data:obj.jsonData,      
		        success:function(data){   
		         //   alert(data);
		        	if(data.HEADER.CONTROL_TYPE == "NONE") {
		        	}
		        	else if(data.HEADER.CONTROL_TYPE == "GRID") {
		        		cmnFrame.initGrid(data, controlField, controlOptions);
		        	}
		        	else if(data.HEADER.CONTROL_TYPE == "CHART") {
		        		cmnFrame.initChart(data, controlField, controlOptions);
		        	}
		        	else if(data.HEADER.CONTROL_TYPE == "FORM") {
		        		cmnFrame.initForm(data, controlField, controlOptions);
		        	}
		        	
		            successFunc(data);
		        	
		        },
		        error:function(e){
		            alert(e.responseText);
		            errorFunc(e.responseText);
		        }
			});
		},
		getCookie : function(cookie_id){
			return $.cookie(cookie_id);
		},
		setCookie : function(cookie_id, cookie_val){
			 $.cookie(cookie_id, cookie_val);
		},
		removeCookie : function(cookie_id){
			$.removeCookie(cookie_id);
		},
		setFormDataClear:function(objFormID){
			  $($("#" + objFormID)).each(function() {
		            this.reset();  
		      });  
		},
		setEnter:function(cont, btn){
			$("#" + cont).on("keypress", function(e){
				if (e.keyCode == 13) {
					$("#" + btn).click();
			    }
			});
			
		},
		getJsonData:function(obj,objFormID,idx){
			var i = 0;
			for(i = 0; i < $("#" + objFormID ).find("textarea,input[type=text],input[type=password]").length ; i ++ ){
				obj.setData($("#" + objFormID).find("textarea,input[type=text],input[type=password]")[i].id, $($("#" + $("#"+objFormID).find("textarea,input[type=text],input[type=password]")[i].id)).val(), idx);
			}
			for(i = 0; i <$("#" + objFormID).serializeArray().length ; i ++ ){
				obj.setData($("#" + objFormID).serializeArray()[i].name, $("#" + objFormID).serializeArray()[i].value, idx);
			}
			  return obj;
		},
		initGrid:function(resVO, fieldInfo, optionInfo) {
			var loadFunc = function(filter) {
				var colNames = this.colNames;
				return $.grep(this.data, function(Item) {
	        		var arrCols = colNames.split('|');
	        		for(i = 0;i<arrCols.length;i++) {
	        			if((!filter[arrCols[i]] || Item[arrCols[i]].indexOf(filter[arrCols[i]]) > -1) == false) {
			        		return false;
			        	}
	        		}
	                return true;
				});
	        };
	        	
			var dataObj = {
					colNames:resVO.HEADER.COL_NAMES,
					data:resVO.DATA,
			        loadData: loadFunc
			    };
			
		    
			var gridData = {
					//기본옵션
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
			        deleteConfirm: "삭제 하시겠습니까?",
			        controller: dataObj,
			        fields: fieldInfo
			    };
			var keys = Object.keys(optionInfo);
			for(i = 0; i < keys.length; i++) {
				gridData[keys[i]] = optionInfo[keys[i]];
			}
			$("#"+resVO.HEADER.CONTROL_ID).jsGrid(gridData);
		},
		setDatePicker:function(className){
			  $("." + className).datepicker({
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
		setFormData:function(frm, obj){
			$($("#" + frm).find("input,select,textarea")).each(function() {
				if(this.tagName == "SELECT") {
		            $(this).val(obj[this.id]);  
				} else if(this.tagName == "TEXTAREA") {
					$(this).val(obj[this.id]);  
				} else if(this.type == "text") {
					$(this).val(obj[this.id]);  
				} else if(this.type == "radio") {
					$(this).val(obj[this.id]);  
				} else if(this.type == "checkbox") {
					$(this).val(obj[this.id]);  
				} else {
					$(this).val(obj[this.id]);  
				}
	         });
		},
		initCRUDForm:function(frm, mode) {	
			switch(mode){
				case "edit" :
		        	$(".btnNew").hide();
		        	$(".btnCancel").show();
					$(".btnDelete").show();
					$(".btnSave").show();
					$(".btnCancel").prop("disabled", false);
					$(".btnDelete").prop("disabled", false);
					$(".btnSave").prop("disabled", false);
					prcsMode = 0; 
					break;
				case "new" :
					cmnFrame.setFormDataClear("detForm");
					$(".btnNew").hide();
					$(".btnCancel").show();
					$(".btnDelete").show();
					$(".btnSave").show();
					$(".btnCancel").prop("disabled", false);
					$(".btnDelete").prop("disabled", true);
					$(".btnSave").prop("disabled", false);
					prcsMode = 1;
					break;				
				default :
					cmnFrame.setFormDataClear("detForm");
					$(".btnNew").show();
					$(".btnCancel").hide();
					$(".btnDelete").show();
					$(".btnSave").show();
					$(".btnNew").prop("disabled", false);
					$(".btnDelete").prop("disabled", true);
					$(".btnSave").prop("disabled", true);
					prcsMode = 0;
					break;
			}
	
		},
		setDefaultStyle:function(frm, obj){
			 $(".readonly").attr("readonly",true); 
			 cmnFrame.setDatePicker("datepicker");
		},
		validateForm:function(frm) {
			return true;
		},
		alert:function(msg){
			alert(msg);
		}
}
