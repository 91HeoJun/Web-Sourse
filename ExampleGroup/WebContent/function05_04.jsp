<%@page import="java.util.function.Function"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="OCFTest05_04Result.jsp" method="post">
      <div>
        <label for="">이름</label>
        <input type="text" name="name" />
      </div>
      <div>
        <label for="">몸무게</label>
        <input type="text" name="weight" />
      </div>
      <div>
        <label for="">신장</label>
        <input type="text" name="height" />
      </div>

      <input type="submit" value="전송" />
    </form>
</body>
</html>