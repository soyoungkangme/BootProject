// new file (프론트가 만듦), html과 연결(<script>)



/*
// 로그인 
let loginObject = {
	
	init : function() {    // html(JSP)에서 무조건 호출됨 
		$("#btn-login").on("click", () => {    // HTML 
			this.login();
		});
	},
	
	login : function() {
		alert("로그인 요청됨");    // 브라우저 출력 
		
		let data = {    // 사용자 입력값 객체에 세팅 
			username : $("#username").val(),
			password : $("#password").val()
		}

		$.ajax({    // 서버에 요청, 응답 받음 
			type: "POST",
			url: "/auth/login",
			data: JSON.stringify(data),    // JSON으로 변환 
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			alert(response); 
			location = "/";    // 화면이동 
		});
	},
}

loginObject.init();
*/