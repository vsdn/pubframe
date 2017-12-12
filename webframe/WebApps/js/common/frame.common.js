var cmnFrame = {
		getClientType : function() {
			return clientInformation.userAgent;
		},
		callService : function(obj) {
		 $.ajax({      
		        type:"POST",  
		        dataType : 'json',
		        url:"/webframe/api/svc.jsp",      
		        data:obj.jsonData,      
		        success:function(data){   
		            alert(data);
		        	
		        },   
		        error:function(e){  
		            alert(e.responseText);  
		        }  
		    });  
		}		
}
