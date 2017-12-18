jQuery(document).ready(function(){
	USR0101M01.initPage();
	USR0101M01.defineEvent();
});


var USR0101M01={
		  
		initPage:function(){	
		        this.defineGrid();	
		    },
		
		defineEvent:function(){
		   $("#srchUsr").click(function(e){USR0101M01.srchUsr();})
		},
		
		defineGrid:function(){
			var clients = [{"USID" :"","USNO" :"","USNAME" :"","LIFYEA" :"","DEPT_CODE" :"","GRADE" :"","LOGIN_F" :"","LAST_LOGIN_DATE" :"","SYS_FRST_USNO" :"","SYS_FRST_DATE" :"","SYS_UPDT_USNO" :"","SYS_UPDT_DATE" :"","USE_F" :""}];
			 $("#divUsrList").jsGrid({
			        height: "90%",
			        width: "100%",
			 
			        sorting: true,
			        paging: true,
			 
			        data: clients,
			 
			        fields: [
			            { name: "USID", type: "text", width: 100 },
			            { name: "USNO", type: "text", width: 100 },
			            { name: "USNAME", type: "text", width: 100 },
			            { name: "LIFYEA", type: "text", width: 100 },			            
			            { name: "DEPT_CODE", type: "text", width: 80 },
			            { name: "GRADE", type: "text", width: 50 },
			            { name: "LOGIN_F", type: "checkbox",title: "접속여부" },
			            { name: "LAST_LOGIN_DATE", type: "text", width: 100 },
			            { name: "SYS_FRST_USNO", type: "text", width: 100 },  
			            { name: "SYS_FRST_DATE", type: "text", width: 100 },
			            { name: "SYS_UPDT_USNO", type: "text", width: 100 },
			            { name: "SYS_UPDT_DATE", type: "text", width: 100 },		            
			            { name: "USE_F", type: "checkbox",title: "사용여부" }

			        ]
			    });
			},
		srchUsr:function(){
				
			alert($("#usrName").val());
			}
};
