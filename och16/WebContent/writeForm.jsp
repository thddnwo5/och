<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
   <form action="writePro.do?pageNum=${pageNum}" method="post">
       <!-- 댓글 파라미터 작업때문에 hidden으로 보냄 -->
      <input type="hidden" name="num" value="${num}">
      <input type="hidden" name="ref" value="${ref}">
      <input type="hidden" name="re_level" value="${re_level}">
      <input type="hidden" name="re_step" value="${re_step}">
     <table>
         <caption><h2>게시판 글쓰기</h2></caption>
        
        <tr><td>제목</td><td>
        <c:if test="${num > 0}">
                <input type="text" name="subject" value="[답변]" required="required">
        </c:if>
        <c:if test="${num == 0 }">
         <input type="text" name="subject" id="subject"required="required">
        </c:if>
        </td></tr>
        <tr><td>작성자</td><td><input type="text" name="writer" id="writer" required="required"></td></tr>
        <tr><td>이메일</td><td><input type="text" name="email" id="email" required="required"></td></tr>
        <tr><td>내용</td><td><textarea rows="10" cols="35" name="content" required="required"></textarea></td></tr>
        <tr><td>암호</td><td><input type="password" name="passwd" id="passwd" required="required"></td></tr>
        <tr><td colspan="2"><input type="submit" value="확인">&nbsp;&nbsp;<input type="reset" value="다시작성"></td></tr>
     </table>
     </form>
</body>
</html>