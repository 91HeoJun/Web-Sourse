<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file = "header.jsp" %>

<div class="container">
<form action="insert.do" method="post">
  <div class="form-group">
    <label for="username">이름</label>
    <input type="text" class="form-control" name="username" id="username" placeholder="이름을 입력하세요" autofocus required>
  </div>
  <div class="form-group">
    <label for="birthyear">태어난 연도</label>
    <input type="text" class="form-control" name="birthyear" id="birthyear" placeholder="태어난 연도를 입력하세요" required>
  </div>
   <div class="form-group">
    <label for="addr">주소</label>
    <input type="text" class="form-control" name="addr" id="addr" placeholder="주소를 입력하세요">
  </div>
   <div class="form-group">
    <label for="mobile">휴대폰 번호</label>
    <input type="text" class="form-control" name="mobile" id="mobile" placeholder="휴대폰 번호를 입력하세요">
  </div>
<button type="submit" class="btn btn-dark">입력</button>
<button type="reset" class="btn btn-light">취소</button>

</form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function () {
	$("button[type='submit']").click(function () {
		
		// 이름 : 한글, 2~4자리만 가능
        var username = $("username");
        let regName = /^[가-힣]{2,4}$/;
        if (!regName.test($("#username").val())) {
            alert("이름을 확인해주세요");
            $("#username").focus();
            return false;

		
		// 태어난 해: 4자리만 가능
		var birthyear = $("birthyear");
        var regYear = /\d{4}$/;
        if (!regYear.test(birthyear.val())) {
          alert("태어난 해를 확인해 주세요");
          birthyear.focus();
          return false;
        }
		
		// 주소 : 2자리만 가능
		var addr = $("addr");
        var regAddr = /^[A-Za-z가-힣]{2}$/;
        if (!regAddr.test(addr.val())) {
          alert("주소를 확인해 주세요");
          addr.focus();
          return false;
        }

		// 모바일 ???-????-????
		var mobile = $("mobile");
        var regMobile = /\d{3}-\d{4}-\d{4}$/;
        if (!regMobile.test(mobile.val())) {
          alert("핸드폰 번호를 확인해 주세요");
          mobile.focus();
          return false;
        }
		
	});
	
}); 
</script>
</body>
</html>