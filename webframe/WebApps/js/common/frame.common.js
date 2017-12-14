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
		}		
}
