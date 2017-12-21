
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
			  $(objFormID).each(function() {  
		            this.reset();  
		         });  
		},
}
