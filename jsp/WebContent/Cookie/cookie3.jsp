<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

	//쿠키값을 가져온 후 language 값에 따라 페이지 보여주기
	String language = "kor";
	String cookie = request.getHeader("Cookie");
	if (cookie != null){
		Cookie c[] = request.getCookies();
		for(int i = 0; i<c.length; i++){
			if(c[i].getName().equals("language")){
				language = c[i].getValue();
			}
		}
	}
		
if(language.equals("kor")){
	out.print("<h3>안녕하세요. 이것은 쿠키 예제입니다.</h3>");
} else {
	out.print("<h3>Hi, This is Cookie example.</h3>");
}
	
	
%>
<form action="setCookie1.jsp" method="post">
	<input type="radio" name="language" value="kor" />한국어 페이지 보기
	<input type="radio" name="language" value="eng" />영어 페이지 보기
	<input type="submit" value="설정" />

</form>

</body>
</html>