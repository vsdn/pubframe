var jsonGridArray = [{}];  

var cmnFrame = {
		getClientType : function() {
			return clientInformation.userAgent;
		},
		callService : function(obj, successFunc, errorFunc) {
			$.ajax({      
		        type:"POST",  
		        dataType : 'json',
		        url:"/webframe/api/svc.jsp",      
		        data:obj.jsonData,      
		        success:function(data){   
		         //   alert(data);
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
		setJsonData:function(obj,objFormID,idx){
			var i = 0;
			for(i = 0; i < $("#" + objFormID ).find("textarea,input[type=text],input[type=password]").length ; i ++ ){
				obj.setData($("#" + objFormID).find("textarea,input[type=text],input[type=password]")[i].id, $($("#" + $("#"+objFormID).find("textarea,input[type=text],input[type=password]")[i].id)).val(), idx);
			}
			for(i = 0; i <$("#" + objFormID).serializeArray().length ; i ++ ){
				obj.setData($("#" + objFormID).serializeArray()[i].name, $("#" + objFormID).serializeArray()[i].value, idx);
			}
			  return obj;
		},
		initGrid:function(objGridID,aJsonArray){
			$("#"+objGridID).jsGrid({
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
		        fields: aJsonArray
		        , rowClick: function(e) {
		    		//window.hItem = e.item;
					/*   cmnFrame.setFormDataClear("detForm");
		        	USR0101M01.setFormData(e.item);
		        	$("#btnNew").hide();
		        	$("#btnCancel").show();
					$("#btnDelete").show();
					$("#btnSave").show();
					$("#btnCancel").prop("disabled", false);
					$("#btnDelete").prop("disabled", false);
					$("#btnSave").prop("disabled", false);
					 prcsMode = 0;*/
		    	}
		    });
		}

		, getData:function(items,cols,objGridID) {
			var arrCols = cols.split('|');
			var aJsonArray = new Array();
			

			for(var i = 0 ; i < arrCols.length ; i++)
				{
				var aJson = new Object();
					aJson.name = arrCols[i];
					aJson.type = "text";
					aJson.width = 80;
					aJsonArray.push(aJson);
				}
			  
			
			var dataObj = {
			        loadData: function(filter) {
			        	return $.grep(this.data, function(Item, arrCols) {
			        		for(i = 0;i<arrCols.length;i++){
			        			if((!filter[arrCols[i]] || Item[arrCols[i]].indexOf(filter[arrCols[i]]) > -1) == false){
					        		return false;
					        	}
			        		}
			                return true;
			            });
			        }

			    };
			
			
			dataObj.data = items;
		    window.dataObj = dataObj;
		    this.initGrid(objGridID,aJsonArray);
		}
	
		
}
