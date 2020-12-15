<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>회원관리</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<%-- view 폴더 아래에 있는 jsp 페이지가 포함해서 보여줘야 하는 페이지이기 때문에 경로설정은 아래와 같이  --%>
<link href="../css/starter-template.css" rel="stylesheet">
<link href="../css/floating-labels.css" rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<%-- validate 코드  --%>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.js"></script>
<script>
$(function(){
	$('.nav-item a').filter(function(){
		return this.href==location.href;
		}).parent().addClass('active').siblings().removeClass('active');		
});
</script>

</head>
<body style="background-color:#F5F5F5;">
    <!-- Fixed navbar -->
      <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
        <a class="navbar-brand" href="../index.jsp">
        	<img src="../img/icons8-launch-box-48.png">
        </a>        
        <div class="collapse navbar-collapse" id="navbarCollapse">
          <ul class="navbar-nav mr-auto" id="menu">
            <li class="nav-item" id="1">
              <a class="nav-link" href="../index.jsp">Home<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item" id="2">
              <a class="nav-link" href="../view/joinForm.jsp">Register</a>
            </li>
            <li class="nav-item"  id="3">
              <a class="nav-link" href="../view/loginForm.jsp">Login</a>
            </li>
          </ul>          
        </div> <!-- navbarCollapse 뒤 영역에 menu.js 작성내용 appen -->
      </nav>
      <main role="main" class="container">






