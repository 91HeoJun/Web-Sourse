<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!
    private String str="선언문";
    private String getStr(){
    	return str+"테스트";
    }
    %>
    <%
    
    out.print(getStr());
    
    %>
    