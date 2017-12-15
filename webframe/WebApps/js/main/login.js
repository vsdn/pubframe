
jQuery(document).ready(function(){
    
	var login_id = cmnFrame.getCookie();
    if(login_id != undefined) {

        $("#inputEmail").val(login_id);

        $("#EmailSaveChk").prop("checked",true);
    }
     
    $("#submit_button").click(function(){
            if($("#EmailSaveChk").prop("checked")) {
            	cmnFrame.setCookie();
            } else {
            	cmnFrame.removeCookie();
            }
    })
});