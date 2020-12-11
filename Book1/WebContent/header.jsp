<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1 class="display-4">JDBC / Book</h1>
    <p class="lead">JDBC 기반의 Book(Model1)</p>
  </div>
</div>

<div class="row">
  <div class="col-3">
    <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
      <a class="nav-link active" id="" data-toggle="pill" href="#insert" role="tab" aria-controls="v-pills-home" aria-selected="true">도서 정보 입력</a>
      <a class="nav-link" id="" data-toggle="pill" href="#all" role="tab" aria-controls="v-pills-profile" aria-selected="false">도서 목록 보기</a>
      <a class="nav-link" id="" data-toggle="pill" href="#delete" role="tab" aria-controls="v-pills-messages" aria-selected="false">도서 정보 삭제</a>
      <a class="nav-link" id="v" data-toggle="pill" href="#search" role="tab" aria-controls="v-pills-settings" aria-selected="false">도서 정보 검색</a>
      <a class="nav-link" id="v" data-toggle="pill" href="#modify" role="tab" aria-controls="v-pills-settings" aria-selected="false">도서 정보 수정</a>
    </div>
  </div>
  <div class="col-9">
    <div class="tab-content" id="v-pills-tabContent">
      <div class="tab-pane fade show active" id="insert" role="tabpanel" aria-labelledby="v-pills-home-tab"><jsp:include page="view/insert.jsp"></jsp:include></div>
      <div class="tab-pane fade" id="delete" role="tabpanel" aria-labelledby="v-pills-messages-tab"><jsp:include page="view/delete.jsp"></jsp:include></div>
      <div class="tab-pane fade" id="search" role="tabpanel" aria-labelledby="v-pills-settings-tab">...</div>
      <div class="tab-pane fade" id="modify" role="tabpanel" aria-labelledby="v-pills-settings-tab"><jsp:include page="view/modify.jsp"></jsp:include></div>
    </div>
  </div>
</div>