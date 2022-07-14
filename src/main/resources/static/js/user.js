// new file (프론트가 만듦)
// insertUser.jsp 와 연결됨  



// 회원가입 
let userObject = {    // userObject 객체 선언 

	init: function() {    // init() 함수 선언 
		let _this = this;

		$("#btn-insert").on("click", () => {    // btn-insert 버튼 클릭되는 순간 (insertUser.jsp)
			_this.insertUser();    // 객체 안에 insertUser() 호출 
		});
	},

	insertUser: function() {
		alert("회원 가입 요청됨");    // alert = 브라우저 출력 (팝업)

		let user = {    // 사용자 입력값 추출하여 객체에 세팅 (<input>의 id)
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		}

		// Ajax 이용하여 서버에 비동기 요청 (포스트맨 설정과 동일)
		$.ajax({
			type: "POST",    // = 등록
			url: "/auth/insertUser",    // Controller 매핑
			data: JSON.stringify(user),    // user 객체를 JSON으로 변환
			contentType: "application/json; charset=utf-8"    // HTTP 바디에 설정되는 데이터의 마임타입설정
		}).done(function(response) {    // 컨트롤러 메서드의 리턴값 문자열을 response로 받음   // done() : 요청 처리에 성공했을 때 실행될 코드 작성
			alert(response);
			location = "/";    // 메인페이지로 이동 (welcome.jsp)
		});

	},
}


userObject.init();    // 무조건 실행되는 메서드 

