<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
      <!-- groupingUsed 사람이 가장 보기편하다는 표시 예)돈자릿수 -->
     <fmt:formatNumber value="10000" groupingUsed="true"/><br>
     <fmt:formatNumber value="3.1415923" pattern="#.###"/><br>
     <fmt:formatNumber value="3.1" pattern="#.##"/><br>
     <fmt:formatNumber value="3.1" pattern="#.00"/><br>
     <fmt:formatNumber value="121434323453." pattern="##,###.00"/><br>
     <fmt:formatNumber value="250000" type="currency" currencySymbol="\$"/><br>
     <fmt:formatNumber value="0.75" type="percent"/><br>
</body>
</html>