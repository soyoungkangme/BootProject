// new file (프론트가 만듦)


let postObject = {

	init: function() {
		let _this = this;
		
		$("#btn-insert").on("click", () => {    // btn-insert 버튼 클릭되는 순간 (html)
			_this.insertPost();    // 함수 호출  
		});
	},
	
	insertPost: function() {
		alert("1:1 문의 등록 요청됨");    // 브라우저 출력 
		
		let post = {    // 사용자 정보 추출, 객체에 세팅 (html)
			title : $("#title").val(),
			content : $("#content").val()
		}		

		// Ajax를 이용한 비동기 호출 (포스트맨 테스트와 동일)
		$.ajax({
			type: "POST", 
			url: "/post/insertPost", 
			data: JSON.stringify(post), 
			contentType: "application/json; charset=utf-8"    
		}).done(function(response) { 
			alert(response);
			location = "/";
		});
		
	},
}
 
postObject.init();