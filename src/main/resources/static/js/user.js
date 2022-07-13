// new file (프론트가 만듦)
// insertUser.jsp 와 연결됨  



let userObject = {    // userObject 객체 선언 

	init: function() {    // init() 함수 선언 
		let _this = this;
		
		$("#btn-insert").on("click", () => {    // btn-insert 버튼 클릭되는 순간 (insertUser.jsp))
			_this.insertUser();    // 객체 안에 insertUser() 호출 
		});
	},
	
	insertUser: function() {
		alert("회원 가입 요청됨");    // alert = 팝업 
		
		let user = {    // 사용자 입력값 추출하여 객체에 세팅 (<input>의 id)
			username : $("#username").val(),
			password : $("#password").val(),
			email : $("#email").val()
		}		

		// Ajax 이용하여 서버에 비동기 요청 (포스트맨 설정과 동일)
		$.ajax({
			type: "POST", // = 등록
			url: "/auth/insertUser",    // Controller
			data: JSON.stringify(user), // user 객체를 JSON으로 변환
			// HTTP 바디에 설정되는 데이터의 마임타입설정 
			contentType: "application/json; charset=utf-8"    // JSON 받아서 insert 처리 (백엔드)
			// done() : 요청 처리에 성공했을 때 실행될 코드를 작성한다.
			// 응답으로 들어온 JSON 데이터를 response로 받는다. 
		}).done(function(response) {    // 컨트롤러 메서드의 문자열이 response에 담김 
			// 메인 페이지로 이동한다.
			alert(response);
			location = "/";
		});
		
	},
}
 
 
userObject.init();    // 무조건 실행되는 메서드 