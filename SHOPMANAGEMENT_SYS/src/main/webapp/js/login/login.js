function login(){
	var form_data = {
		user_id : $("#userIdIp").val(),
		user_password: $("#userPasswordIp").val(),
		admin_yn: $("#adminChk").val()
	};
	$.ajax({
		type: "POST",
        /* java loginCheck 클래스로 로그인 시도 */
		url: "login.do",
		data: form_data,
		beforeSend : function(xhr){
			xhr.setRequestHeader("AJAX", "true"); 
			xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		},
		
		success: function(msg, textStatus, xhr) {
			if(msg == 'true') {
               /* 로그인이 완료된 경우 돌아갈 페이지 */
				window.location.replace("pageDashboard.do");
			} else {
				alert("아이디 또는 비밀번호가 잘못되었습니다!!");
			}
		},
		error:function(request, status, error){
			alert("code:" + request.status + "\n" + "error:" + error);
		}
	});
	return false;
}