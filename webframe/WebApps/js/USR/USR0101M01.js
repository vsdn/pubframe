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

		initGrid:function(){
			$("#divUsrList").jsGrid({
		        height: "100%",
		        width: "100%",
		        filtering: false,
		        editing: false,
		        inserting: false,
		        sorting: true,
		        paging: false,
		        autoload: true,
		        pageSize: 15,
		        pageButtonCount: 10,
		        deleteConfirm: get_msg("4000"),
		        controller: dataObj,
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
		        , rowClick: function(e) {
		    		//window.hItem = e.item;
		    	}
		    });
		}

		, getData :function(items) {
			var dataObj = {
			        loadData: function(filter) {
			        	return $.grep(this.data, function(Item) {
			                return (!filter.USID || Item.USID.indexOf(filter.USID) > -1)
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
		    initGrid();
		}
		,
		srchUsr:function(){
				
			alert($("#usrName").val());
			}
};
