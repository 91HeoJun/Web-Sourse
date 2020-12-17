/**
 * 
 */

$(function(){
	$("#modifyform").validate({
		rules:{
			current_password:{ // 8-15자리, 영어 대소문자, 숫자, 특수문자 허용
                required : true,
                validPW : true				
			},
			
			new_password:{ // 8-15자리, 영어 대소문자, 숫자, 특수문자 허용
                required : true,
                validPW : true				
			},
			confirm_password:{ // 8-15자리, 영어 대소문자, 숫자, 특수문자 허용, password와 동일
                required : true,
                validPW : true,
				equalTo : "#new_password"
			}
		}, // rules 종료
		
		messages:{
			current_password:{
				required : "현재 비밀번호를 입력해주세요."
			},
			new_password:{
				required : "새로운 비밀번호를 입력해주세요."
			},
			confirm_password:{
				required : "새로운 비밀번호를 입력해주세요.",
				equalTo : "이전 비밀번호와 일치하지 않습니다"
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

$.validator.addMethod("validPW", function (value) {
    let regPw = /(?=.*[A-Za-z])(?=.*[\d])(?=.*[!@#$%])[A-Za-z\d!@#$%]{8,15}$/;
    return regPw.test(value); // true or false return
}, "비밀번호를 확인해 주세요");