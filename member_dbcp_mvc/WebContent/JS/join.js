/**
 *  joinForm.jsp의 유효성 검증
 */

$(function(){
	$("#joinform").validate({
		rules:{
			userid:{ // 5-12자리, 영어 대소문자, 숫자, 특수문자 허용
                required : true,
                validID : true,
				remote:{
					url:"../checkID.do",
					type:"post",
					data:{
						userid:function(){
							return $("#userid").val();
						}
					}
				}
			},
			
			password:{ // 8-15자리, 영어 대소문자, 숫자, 특수문자 허용
                required : true,
                validPW : true				
			},
			confirm_password:{ // 8-15자리, 영어 대소문자, 숫자, 특수문자 허용, password와 동일
                required : true,
                validPW : true,
				equalTo : "#password"
			},
			name:{ // 2-4자리
                required : true,
                validNAME : true
			},
			gender:{ // 무조건 선택
				required : true
				
			},
			email:{ // 이메일 검증
                required : true,
                validEMAIL : true
			}
		}, // rules 종료
		
		messages:{
			userid:{
				required : "아이디는 필수 속성입니다.",
				remote : "아이디 사용 불가"
			},
			password:{
				required : "비밀번호는 필수 속성입니다."
			},
			confirm_password:{
				required : "비밀번호 확인은 필수 속성입니다.",
				equalTo : "이전 비밀번호와 일치하지 않습니다"
			},
			name:{
				required : "이름은 필수 속성입니다."
			},
			gender:{
				required : "성별선택은 필수 속성입니다."
			},
			email:{
				required : "이메일은 필수 속성입니다."
			}
		}, // messages 종료
		errorPlacement:function(error, element) {
			$(element).closest("form").find("small[id='"+element.attr('id')+"']").append(error);
		},
		success: function(label) {
			var name = label.attr('for');
			label.text(name+ ' is ok!');
		}
	});
});

$.validator.addMethod("validID", function (value) {
    let regID = /(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{6,12}$/;
    return regID.test(value); // true or false return
}, "아이디를 확인해 주세요");

$.validator.addMethod("validPW", function (value) {
    let regPw = /(?=.*[A-Za-z])(?=.*[\d])(?=.*[!@#$%])[A-Za-z\d!@#$%]{8,15}$/;
    return regPw.test(value); // true or false return
}, "비밀번호를 확인해 주세요");

$.validator.addMethod("validEMAIL", function (value) {
    let regMail = /(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return regMail.test(value);
}, "이메일 형식을 확인해주세요");