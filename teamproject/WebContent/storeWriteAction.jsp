<%@page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.boardDAO" %>
<% request.setCharacterEncoding("utf-8"); %>
<% response.setContentType("text/html; charset=utf-8"); %>
<jsp:useBean id="bod" class="board.board" scope="request"/>
<jsp:setProperty property="storeKgori" name="bod"/>
<jsp:setProperty property="storeProduct" name="bod"/>
<jsp:setProperty property="storeImg" name="bod"/>
<jsp:setProperty property="productInfo" name="bod"/>
<jsp:setProperty property="productPrice" name="bod"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%
      boardDAO boardDAO = new boardDAO();
     int result = 
     boardDAO.storeWrite(bod.getStoreKgori(), bod.getStoreProduct(), 
                         bod.getStoreImg(), bod.getProductInfo(), 
                         bod.getProductPrice());
     
     if(result == -1){
    	 PrintWriter script = response.getWriter();
    	 
    	 script.println("<script>");
    	 script.println("alert('글쓰기에 실패')");
    	 script.println("location.href='storeWrite.jsp'");    	     	 
    	 script.println("</script>");
     }else {
    	 PrintWriter script = response.getWriter();
    	 script.println("<script>");
    	 script.println("alert('글쓰기에 성공')");
    	 script.println("location.href='storeWrite.jsp'");    	     	 
    	 script.println("</script>");
     }
   %>
</body>
</html>