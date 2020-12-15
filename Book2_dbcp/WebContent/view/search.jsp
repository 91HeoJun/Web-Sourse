<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<h4>검색할 도서 정보를 입력해 주세요</h4>    
<form action="/Book2_dbcp/view/searchPro.jsp" method="post">
	<div class=form-row>
		<div class="form-group col-6">
			<select name="criteria" id="">
				<option value="code">코드</option>
				<option value="writer">작가</option>
			</select>
		</div>
		
	<div class="form-group col-6">
		<input type="text" class="form-control" name="keyword" id="keyword" required />
	</div>

	<div>
		<button type="submit" class="btn btn-primary">검색</button>
		<button type="reset" class="btn btn-secondary">취소</button>
	</div>
</div>
</form>