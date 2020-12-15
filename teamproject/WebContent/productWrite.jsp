
<%@page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
      <%!private PrintWriter pw;%>
     <% String storeImg     = request.getParameter("storeImg"); %> 
<body>    
     <%
      String fileName = "C:/storeImg/"+storeImg;         
	  try{    
	  pw = new PrintWriter (new FileWriter(fileName,true));
	     }catch(IOException e){
	    	 e.printStackTrace();
	     }  
    %> 
    <jsp:forward page="storeWriteAction.jsp"/>
</body>
</html>