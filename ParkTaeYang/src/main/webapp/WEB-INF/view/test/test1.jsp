<%@page import="thy.coding.springboot.board.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view/test1</title>
</head>
<body>
test1
<%
List<String> list = (List<String>)request.getAttribute("subjects");
out.print("<ol>");

for(String v : list){
	out.print("<li>"+ list);
}



%>
</body>
</html>