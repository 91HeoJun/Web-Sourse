<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<h4>수정할 도서 정보를 입력해 주세요</h4>    
<form action="/Book1/view/modifyPro.jsp" method="post">
	<div class="form-group">
		<label for="code">Code</label>
		<input type="text" class="form-control" name="code" id="code" required />
	</div>
	<div class="form-group">
		<label for="code">Price</label>
		<input type="text" class="form-control" name="price" id="price" required />
	</div>

	<div>
		<button type="submit" class="btn btn-primary">입력</button>
		<button type="reset" class="btn secondary">취소</button>
	</div>
	
</form>