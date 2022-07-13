// new file
// 프론트가 만듦



// userObject 객체 선언 
let userObject = {

	// init() 함수 선언 
	init: function() {
		let _this = this;
		
		// "#btn-save" 버튼에 "click" 이벤트가 발생하면 insertUser() 함수를 호출한다. 
		$("#btn-insert").on("click", () => {
			_this.insertUser();
		});
	},
	
	insertUser: function() {
		alert("회원 가입 요청됨");
		
		// 사용자 입력값 추출하여 객체에 세팅 
		let user = {
			username : $("#username").val(),
			password : $("#password").val(),
			email : $("#email").val()
		}		

		// Ajax를 이용한 비동기 호출 (포스트맨 테스트와 동일)
		$.ajax({
			type: "POST", // 등록 (서버 요청 방)
			url: "/auth/insertUser", // 요청 path
			data: JSON.stringify(user), // user Object를 JSON으로 변환
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
 
// userObject 객체의 init() 함수 호출. 
userObject.init();