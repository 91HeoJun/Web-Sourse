<%@page import="java.util.UUID"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="com.sun.source.tree.WhileLoopTree"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	// file upload 요청 파악하기
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if (isMultipart) {
			// 전송된 파일을 디스크에 저장하기 위한 객체 생성
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 파일 업로드 handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			// request 파싱을 위해 
			List<FileItem> fileItems = upload.parseRequest(request);
			// for(MemberVO vo:list), Iterator
			String fieldName = null, fileName = null, value = null;
		
			Iterator<FileItem> iter = fileItems.iterator();
		
		while (iter.hasNext()) {
			FileItem item = iter.next();
		
			if (item.isFormField()) { // type != file
				fieldName = item.getFieldName();
				value = item.getString("utf-8");
		
				out.print("<h3>일반 데이터</h3>");
				out.print(fieldName + " : " + value + "<br>");
		
			} else { // type == file
				fieldName = item.getFieldName();
				fileName = item.getName();
				long size = item.getSize();

				out.print("<h3>파일 데이터</h3>");
				out.print(fieldName + " : " + fileName + "<br>");
				out.print("파일 크기 : " + size);
			
				// 파일 저장하기
				String path = "c:\\upload";
				if(!fileName.isEmpty()) {
					
					UUID uuid = UUID.randomUUID();
					
					File uploadFile = new File(path + "\\" + uuid.toString() + "_" + fileName);
					item.write(uploadFile);
					
					
				// 파일 다운로드를 위한 경로설정
				out.print("<p>");
				out.print("<a href = 'download.jsp?fileName=" +uploadFile.getName()+ "'>" + fileName + "</a>");
				out.print("</p>");				
				
				
				
		
			}
	
		}

	}

}
%>