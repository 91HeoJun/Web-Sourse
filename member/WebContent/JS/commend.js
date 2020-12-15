/**
 * 버튼 클릭 시 
 */

$(function(){
	// logout 클릭 시 logoutPro.jsp로 이동
	$("#logout").click(function(){
		location.href='logoutPro.jsp';
	});
});

$(function(){
	$("#modify").click(function(){
		location.href='modifyForm.jsp';
	});
});