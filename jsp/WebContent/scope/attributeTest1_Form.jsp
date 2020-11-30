<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>attributeTest1_Form.jsp</title>
</head>
<body>
	<form action="attributeTest1.jsp" method="post">
		<div>
			<ul><li>Application 영역에 저장할 내용들</li></ul>
		</div>
		<div>
		
		<label for="">이름</label>
		<input type="text" name="name" />
		</div>
		
		<div>
		<label for="">아이디</label>
		<input type="text" name="id" />
		</div>
		
		<div>
		<input type="submit" value="전송" />
		</div>

	</form>

</body>
</html>