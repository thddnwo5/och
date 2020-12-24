<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <c:if test="${result > 0}">
         <script type="text/javascript">
                 alert('게시물이 정상적으로 올라갔습니다.');
                 location.href='list.do?pageNum=${pageNum}';
         </script>
   </c:if>
   <c:if test="${result == 0}">
         <script type="text/javascript">
                 alert('게시물이 올라가지않았습니다.');
                 location.href='writeForm.do?Num=${Num}&pageNum=${pageNum}';
         </script>
   </c:if>
</body>
</html>