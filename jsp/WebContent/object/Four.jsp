<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int selNum1 = Integer.parseInt(request.getParameter("num1"));
	int selNum2 = Integer.parseInt(request.getParameter("num2"));
	String selop = request.getParameter("op");

%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3> ## 결과 ##</h3>
	<%
	
	int result = 0;

		switch(selop) {
		
		case"+":
			result = selNum1 + selNum2;
			break;
		
		case"-":
			result = selNum1 - selNum2;
			break;
		
		case"*":
			result = selNum1 * selNum2;
			break;
		
		case"/":
			result = selNum1 / selNum2;
			break;
		
		default:
			break;
			
		}
	
		out.print("<p>" + selNum1 + selop + selNum2 + "=" +result+  "</p>");
		
	%>
			<h3><%=selNum1%> <%=selop%> <%=selNum2%> = <%=result %> </h3>
	

</body>
</html>