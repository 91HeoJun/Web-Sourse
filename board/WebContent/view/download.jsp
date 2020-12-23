<%@page import="domain.BoardVO"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String fileName = request.getParameter("fileName");

	// 다운로드가 일어날 폴더 지정
	
	String downPath = "c:\\upload";
	String filePath = downPath+ "\\" + fileName;
	
	FileInputStream in = new FileInputStream(filePath);
	
	out.clear();
	out = pageContext.pushBody();
	
	// response 헤더 설정
	response.setContentType("application/octet-stream");
	fileName = new String(fileName.getBytes("utf-8"), "iso-8859-1");
	
	// fileName : uuid 값_실제 파일명
	// _ 기준으로 잘라서 파일명 붙여주기
	String showFileName = fileName.substring(fileName.lastIndexOf("_")+1);
	
	response.setHeader("Content-Disposition", "attachment;filename = " + showFileName);

	BufferedOutputStream buf = new BufferedOutputStream(response.getOutputStream());
		
	int numRead = 0;
	byte[] b = new byte[8192];
	
	while((numRead = in.read(b, 0, b.length)) != -1){
		buf.write(b, 0, numRead);
	}

	// 버퍼 비우기
	buf.flush();
	// 자원 비우기
	buf.close();
	in.close();
		
%>